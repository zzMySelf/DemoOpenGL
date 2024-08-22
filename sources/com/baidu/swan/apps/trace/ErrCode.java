package com.baidu.swan.apps.trace;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.pms.model.PMSError;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class ErrCode implements ErrDef {
    private static final String KEY_DESC = "desc";
    private static final String KEY_DETAIL = "detail";
    private static final String KEY_ERROR = "error";
    private static final String KEY_FEATURE = "feature";
    private static final String KEY_HAS_RECORDED = "hasRecorded";
    private static final String KEY_PLATFORM = "platform";
    private static final String KEY_TIP = "tip";
    public static final String TAG = "ErrCode";
    private ErrCode mCauseBy = null;
    private String mDesc = "";
    private final StringBuilder mDetails = new StringBuilder();
    private long mError = 0;
    private long mFeature = 0;
    private boolean mHasRecorded = false;
    private long mPlatform = 2;
    private String mTip = "";

    public String toString(int level) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s :: code(%08d) desc(%s) \n", new Object[]{super.toString(), Long.valueOf(code()), Long.valueOf(platform()), Long.valueOf(feature()), Long.valueOf(error()), desc()}));
        if (level >= -200) {
            sb.append(String.format(Locale.getDefault(), "  p(%01d) f(%03d) e(%04d) \n", new Object[]{Long.valueOf(platform()), Long.valueOf(feature()), Long.valueOf(error())}));
        }
        if (level >= -100) {
            sb.append(String.format(Locale.getDefault(), "  details(%s) \n", new Object[]{details()}));
        }
        return sb.toString();
    }

    public String toString() {
        return toString(-100);
    }

    public ErrCode copyFrom(PMSError psmError) {
        if (psmError != null) {
            error((long) psmError.errorNo).desc(psmError.errorMsg).tip(psmError.tipMsg);
            if (!TextUtils.isEmpty(psmError.errorDetail)) {
                detail(psmError.errorDetail);
            }
        }
        return this;
    }

    public ErrCode platform(long platform) {
        this.mPlatform = illegalFallback(platform, 9, "platform");
        return this;
    }

    public long platform() {
        return this.mPlatform;
    }

    public ErrCode feature(long feature) {
        this.mFeature = illegalFallback(feature, 999, "feature");
        return this;
    }

    public long feature() {
        return this.mFeature;
    }

    public ErrCode error(long error) {
        this.mError = illegalFallback(error, 9999, "error");
        return this;
    }

    public long error() {
        return this.mError;
    }

    public ErrCode desc(String desc) {
        this.mDesc = desc == null ? "" : desc;
        return this;
    }

    public String desc() {
        return this.mDesc;
    }

    public ErrCode tip(String tip) {
        this.mTip = tip == null ? "" : tip;
        return this;
    }

    public String tip() {
        return this.mTip;
    }

    public ErrCode detail(String detail) {
        this.mDetails.append(detail).append("\n");
        return this;
    }

    public StringBuilder details() {
        return this.mDetails;
    }

    public ErrCode causeBy(ErrCode causeBy) {
        this.mCauseBy = causeBy;
        return this;
    }

    public ErrCode causeBy() {
        return this.mCauseBy;
    }

    public long code() {
        return (platform() * 10000000) + (feature() * 10000) + (error() * 1);
    }

    public ErrCode code(long code) {
        platform(code / 10000000);
        long code2 = code % 10000000;
        feature(code2 / 10000);
        error((code2 % 10000) / 1);
        return this;
    }

    public boolean hasRecorded() {
        return this.mHasRecorded;
    }

    public void markRecorded() {
        this.mHasRecorded = true;
    }

    private long illegalFallback(long var, long overflow, String tag) {
        boolean illegal = var < 0 || var > overflow;
        if (illegal) {
            detail("illegalFallback " + tag + "::" + var);
        }
        return illegal ? overflow : var;
    }

    public JSONObject toJSONObject() {
        JSONObject errJson = new JSONObject();
        try {
            errJson.put("feature", this.mFeature);
            errJson.put("error", this.mError);
            errJson.put("platform", this.mPlatform);
            errJson.put("desc", this.mDesc);
            errJson.put("tip", this.mTip);
            errJson.put("detail", this.mDetails.toString());
            errJson.put("hasRecorded", this.mHasRecorded);
        } catch (JSONException e2) {
            SwanAppLog.i("ErrCode", Log.getStackTraceString(e2));
        }
        return errJson;
    }

    public static ErrCode fromJSON(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        ErrCode errCode = new ErrCode();
        try {
            errCode.feature(jsonObject.getLong("feature"));
            errCode.error(jsonObject.getLong("error"));
            errCode.platform(jsonObject.getLong("platform"));
            errCode.desc(jsonObject.getString("desc"));
            errCode.tip(jsonObject.getString("tip"));
            errCode.mDetails.append(jsonObject.getString("detail"));
            errCode.mHasRecorded = jsonObject.getBoolean("hasRecorded");
            return errCode;
        } catch (Exception e2) {
            SwanAppLog.i("ErrCode", Log.getStackTraceString(e2));
            return null;
        }
    }
}
