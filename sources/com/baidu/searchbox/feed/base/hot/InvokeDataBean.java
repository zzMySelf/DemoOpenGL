package com.baidu.searchbox.feed.base.hot;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class InvokeDataBean implements DynamicBean<InvokeDataBean> {
    public static final int INVOKE_STATUS_FAIL = 0;
    public static final int INVOKE_STATUS_NEEDLESS = -1;
    public static final int INVOKE_STATUS_SUCC = 1;
    public static final String INVOKE_VBO_SCHEME = "invokeWbSchemaOrigin";
    public static final String INVOKE_VB_SCHEME = "invokeWbSchema";
    public static final String WB_STRATEGY_POS = "119";
    public int interval = -1;
    public int invokeStatus = -1;
    public HashMap<String, String> schemeMap = new HashMap<>();
    public String strategyPos;

    public InvokeDataBean toModel(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        boolean hasInvoke = false;
        if (jsonObject.has(INVOKE_VB_SCHEME)) {
            hasInvoke = true;
            this.strategyPos = "119";
            this.schemeMap.put(INVOKE_VB_SCHEME, jsonObject.optString(INVOKE_VB_SCHEME));
        }
        if (jsonObject.has(INVOKE_VBO_SCHEME)) {
            hasInvoke = true;
            this.schemeMap.put(INVOKE_VBO_SCHEME, jsonObject.optString(INVOKE_VBO_SCHEME));
        }
        this.interval = jsonObject.optInt("shutdownTriggerInterval", -1);
        if (hasInvoke) {
            return this;
        }
        return null;
    }

    public JSONObject toJson() {
        return toJson(new JSONObject());
    }

    public JSONObject toJson(JSONObject jsonObject) {
        try {
            for (Map.Entry<String, String> entry : this.schemeMap.entrySet()) {
                if (entry.getKey() != null) {
                    jsonObject.put(entry.getKey(), entry.getValue());
                }
            }
            int i2 = this.interval;
            if (i2 != -1) {
                jsonObject.put("shutdownTriggerInterval", i2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jsonObject;
    }

    public boolean check() {
        return true;
    }

    public String getInvokeSchemeKey() {
        if (TextUtils.equals(this.strategyPos, "119")) {
            return INVOKE_VB_SCHEME;
        }
        return null;
    }

    public String getScheme(String key) {
        return this.schemeMap.get(key);
    }
}
