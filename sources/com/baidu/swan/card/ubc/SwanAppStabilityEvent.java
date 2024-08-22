package com.baidu.swan.card.ubc;

import android.text.TextUtils;
import com.baidu.swan.card.launch.model.SwanCardProperties;
import com.baidu.swan.card.pkg.model.ErrCode;
import com.baidu.swan.card.utils.SwanAppLibConfig;
import org.json.JSONException;
import org.json.JSONObject;

public class SwanAppStabilityEvent extends SwanAppUBCEvent {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    public static final String EXT_INFO_KEY = "info";
    private static final String EXT_INFO_STACK_TRACE_KEY = "stacktrace";
    private static final int MAX_STACK_TRACE_RECORD_ROW_COUNT = 35;
    private JSONObject mInfoObj;
    private boolean mStackTraceEnabled = false;

    public SwanAppStabilityEvent(String cardId) {
        super(cardId);
        this.mSource = "NA";
    }

    public SwanAppStabilityEvent errCode(int errCode) {
        this.mType = String.valueOf(errCode);
        return this;
    }

    public SwanAppStabilityEvent errCode(ErrCode errCode) {
        this.mType = String.valueOf(errCode.code());
        String detail = errCode.details().toString();
        if (!TextUtils.isEmpty(detail)) {
            addInfo("detail", detail);
        }
        return this;
    }

    public SwanAppStabilityEvent enableStacktrace(boolean enable) {
        this.mStackTraceEnabled = enable;
        return this;
    }

    public SwanAppStabilityEvent from(String from) {
        this.mFrom = from;
        return this;
    }

    public SwanAppStabilityEvent appId(String appId) {
        this.mAppId = appId;
        return this;
    }

    public SwanAppStabilityEvent source(String source) {
        this.mSource = source;
        return this;
    }

    public SwanAppStabilityEvent page(String page) {
        this.mPage = page;
        return this;
    }

    public SwanAppStabilityEvent addInfo(String key, String value) {
        if (key == null || value == null) {
            return this;
        }
        if (this.mInfoObj == null) {
            this.mInfoObj = new JSONObject();
        }
        try {
            this.mInfoObj.put(key, value);
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
        return this;
    }

    public SwanAppStabilityEvent launchInfo(SwanCardProperties info) {
        if (info == null) {
            return this;
        }
        if (!TextUtils.isEmpty(info.getLaunchFrom())) {
            this.mSource = info.getLaunchFrom();
        }
        if (!TextUtils.isEmpty(info.getAppId())) {
            this.mAppId = info.getAppId();
        }
        if (!TextUtils.isEmpty(info.getLaunchScheme())) {
            this.mScheme = info.getLaunchScheme();
        }
        if (!TextUtils.isEmpty(info.getPage())) {
            this.mExtPage = info.getPage();
        }
        return this;
    }

    public JSONObject toJSONObject() {
        if (this.mExt == null) {
            this.mExt = new JSONObject();
        }
        try {
            JSONObject jSONObject = this.mInfoObj;
            if (!(jSONObject == null || jSONObject.length() == 0)) {
                this.mExt.put("info", this.mInfoObj);
            }
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
