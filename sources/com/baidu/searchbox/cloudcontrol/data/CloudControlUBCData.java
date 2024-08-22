package com.baidu.searchbox.cloudcontrol.data;

import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CloudControlUBCData {
    public static final String KEY_COUNT = "count";
    public static final String KEY_ITEMS = "items";
    private static final String TAG = "CloudControlUBCData";
    private JSONObject controlJsonObject = new JSONObject();
    private String logId;
    private String mTraceId;
    private String runType;
    private JSONObject serviceJsonObject = new JSONObject();

    public void setRunType(String runType2) {
        this.runType = runType2;
    }

    public void setLogId(String logId2) {
        this.logId = logId2;
    }

    public String getTraceId() {
        return this.mTraceId;
    }

    public void setTraceId(String traceId) {
        this.mTraceId = traceId;
    }

    public void collectServiceInfo(JSONObject serviceJsonObject2) {
        this.serviceJsonObject = serviceJsonObject2;
    }

    public void collectDegradegInfo(int total, int success, int filter, JSONArray degradeJsonArray) {
        try {
            this.controlJsonObject.put("count", total + "," + success + "," + filter);
            this.controlJsonObject.put("items", degradeJsonArray);
        } catch (JSONException e2) {
            if (AppConfig.isDebug()) {
                Log.d(TAG, "collectDegradegInfo is error" + e2.toString());
            }
        }
    }

    public JSONObject getServiceJsonObject() {
        return this.serviceJsonObject;
    }

    public JSONObject getControlJsonObject() {
        return this.controlJsonObject;
    }

    public String getRunType() {
        return this.runType;
    }

    public String getLogId() {
        return this.logId;
    }
}
