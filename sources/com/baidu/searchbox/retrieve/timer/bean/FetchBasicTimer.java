package com.baidu.searchbox.retrieve.timer.bean;

import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.inter.IFetchTask;
import org.json.JSONObject;

public class FetchBasicTimer {
    protected static final boolean DEBUG = AppConfig.isDebug();
    private static final String EXPIRED = "expiredTime";
    protected static final String INFO = "info";
    private static final String JOB_ID = "jobId";
    protected static final String TAG = "FetchTimerData";
    private static final String TYPE = "type";
    private static final String VERSION = "version";

    public static FetchTimerBasicBean parseJsonContent(JSONObject valueJson) {
        if (valueJson == null) {
            return null;
        }
        String type = valueJson.optString("type");
        String jobId = valueJson.optString("jobId");
        String version = valueJson.optString("version");
        try {
            long expireTime = Long.parseLong(valueJson.optString("expiredTime")) * 1000;
            if (expireTime >= System.currentTimeMillis()) {
                return new FetchTimerBasicBean(jobId, type, version, expireTime);
            }
            reportTaskCheckFail(type, jobId, jobId, valueJson);
            return null;
        } catch (Exception e2) {
            reportTaskCheckFail(type, jobId, version, valueJson);
            if (DEBUG) {
                Log.d(TAG, e2.getMessage());
            }
            reportTaskCheckFail(type, jobId, version, valueJson);
            return null;
        }
    }

    protected static void reportTaskCheckFail(String type, String extJobId, String extVersion, JSONObject extOrigin) {
        ((IFetchTask) ServiceManager.getService(IFetchTask.SERVICE_REFERENCE)).reportTaskCheckFail(type, extJobId, extVersion, extOrigin);
    }
}
