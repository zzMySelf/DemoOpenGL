package com.baidu.searchbox.cloudcontrol.utils;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.cloudcontrol.data.CloudControlUBCData;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;

public class CloudControlUBCUtils {
    private static final String KEY_CONTROL = "control";
    public static final String KEY_EXT = "ext";
    public static final String KEY_K = "product";
    private static final String KEY_LOGID = "logid";
    private static final String KEY_SERVICE = "service";
    private static final String KEY_SOURCE = "source";
    private static final String KEY_TRACE_ID = "traceid";
    public static final String KEY_V = "version";
    public static final String KEY_VALID = "valid";
    private static final String TAG = "CloudControlUBCUtils";
    private static final String UBC_CLOUD_CTROL_ID = "944";

    public void doStatistics(CloudControlUBCData cloudControlUBCData) {
        if (cloudControlUBCData != null) {
            JSONObject value = new JSONObject();
            try {
                value.put("source", cloudControlUBCData.getRunType());
                JSONObject extJson = new JSONObject();
                extJson.put("logid", cloudControlUBCData.getLogId());
                JSONObject serviceJsonObject = cloudControlUBCData.getServiceJsonObject();
                if (!(serviceJsonObject == null || serviceJsonObject.length() == 0)) {
                    extJson.put("service", serviceJsonObject);
                }
                JSONObject controlJsonObject = cloudControlUBCData.getControlJsonObject();
                if (!(controlJsonObject == null || controlJsonObject.length() == 0)) {
                    extJson.put("control", controlJsonObject);
                }
                if (!TextUtils.isEmpty(cloudControlUBCData.getTraceId())) {
                    extJson.put("traceid", cloudControlUBCData.getTraceId());
                }
                value.put("ext", extJson);
                UBCManager ubcManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                if (ubcManager != null) {
                    ubcManager.onEvent(UBC_CLOUD_CTROL_ID, value);
                }
                if (AppConfig.isDebug()) {
                    Log.d(TAG, "cloud control ubc is 944:" + value.toString());
                }
            } catch (JSONException e2) {
                if (AppConfig.isDebug()) {
                    Log.d(TAG, "cloud control doStatistics error" + e2.toString());
                    e2.printStackTrace();
                }
            }
        }
    }
}
