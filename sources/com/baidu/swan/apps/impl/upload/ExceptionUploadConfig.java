package com.baidu.swan.apps.impl.upload;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.pms.node.common.ExceptionUploadSampleManager;
import java.util.Iterator;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

public class ExceptionUploadConfig {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    public static final String KEY_API_ERROR = "api_error";
    public static final String KEY_JS_ERROR = "js_error";
    public static final String KEY_LAUNCH = "launch";
    public static final String KEY_WHITE_SCREEN = "white_screen";
    private static final String TAG = "UploadConfig";
    static volatile JSONObject sData;
    static volatile String sVersion;

    private static synchronized JSONObject parseConfigData() {
        synchronized (ExceptionUploadConfig.class) {
            String version = ExceptionUploadSampleManager.getInstance().getVersion();
            if (!TextUtils.equals(sVersion, version) || sData == null) {
                String dataJsonStr = ExceptionUploadSampleManager.getInstance().getData();
                if (TextUtils.isEmpty(dataJsonStr)) {
                    return null;
                }
                try {
                    JSONObject dataJo = new JSONObject(dataJsonStr);
                    sVersion = version;
                    sData = dataJo;
                    return dataJo;
                } catch (JSONException ex) {
                    SwanAppLog.logToFile(TAG, "#parseConfigData error", ex);
                    return null;
                }
            } else {
                JSONObject jSONObject = sData;
                return jSONObject;
            }
        }
    }

    public static boolean checkLaunchSample(String sourceKey) {
        JSONObject sourceJo;
        int value;
        boolean z = DEBUG;
        long startTime = z ? System.nanoTime() : 0;
        JSONObject uploadConfigJo = parseConfigData();
        if (z) {
            Log.d(TAG, "#checkLaunchSample parseConfigData耗时(ms):  " + (((float) (System.nanoTime() - startTime)) / 1000000.0f));
        }
        if (uploadConfigJo != null && (sourceJo = uploadConfigJo.optJSONObject("launch")) != null && (value = sourceJo.optInt(sourceKey)) >= 1 && new Random().nextInt(value) == 0) {
            return true;
        }
        return false;
    }

    public static boolean checkJsErrorSample(String message) {
        JSONObject sourceJo;
        Iterator<String> msgKeys;
        int value;
        boolean z = DEBUG;
        long startTime = z ? System.nanoTime() : 0;
        JSONObject uploadConfigJo = parseConfigData();
        if (z) {
            Log.d(TAG, "#checkJsErrorSample parseConfigData耗时(ms): " + (((float) (System.nanoTime() - startTime)) / 1000000.0f));
        }
        if (uploadConfigJo == null || (sourceJo = uploadConfigJo.optJSONObject("js_error")) == null || (msgKeys = sourceJo.keys()) == null) {
            return false;
        }
        while (msgKeys.hasNext()) {
            String msgKey = msgKeys.next();
            if (msgKey != null && msgKey.contains(message) && (value = sourceJo.optInt(msgKey)) >= 1) {
                if (new Random().nextInt(value) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkErrorCodeSample(String errCodeStr) {
        JSONObject sourceJo;
        Iterator<String> msgKeys;
        int value;
        if (TextUtils.isEmpty(errCodeStr)) {
            return false;
        }
        boolean z = DEBUG;
        long startTime = z ? System.nanoTime() : 0;
        JSONObject uploadConfigJo = parseConfigData();
        if (z) {
            Log.d(TAG, "#checkJsErrorSample parseConfigData耗时(ms): " + (((float) (System.nanoTime() - startTime)) / 1000000.0f));
        }
        if (uploadConfigJo == null || (sourceJo = uploadConfigJo.optJSONObject("white_screen")) == null || (msgKeys = sourceJo.keys()) == null) {
            return false;
        }
        while (msgKeys.hasNext()) {
            String msgKey = msgKeys.next();
            if (msgKey != null && errCodeStr.endsWith(msgKey) && (value = sourceJo.optInt(msgKey)) >= 1) {
                if (new Random().nextInt(value) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    protected static boolean isSampleReportingApiError(String apiName) {
        JSONObject apiErrorConfig;
        int sampleRate;
        JSONObject configData = parseConfigData();
        if (configData != null && (apiErrorConfig = configData.optJSONObject(KEY_API_ERROR)) != null && (sampleRate = apiErrorConfig.optInt(apiName, -1)) >= 1 && new Random().nextInt(sampleRate) == 0) {
            return true;
        }
        return false;
    }
}
