package com.baidu.swan.apps.api.module.network;

import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.model.ext.SwanExtInfo;
import com.baidu.swan.apps.runtime.SwanApp;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

public class CloudCacheSwitch {
    private static final String LOG_MODULE = "CloudCache";
    public static final String PARAMS_KEY_CLOUD_CACHE = "cloudCache";
    public static final String PARAMS_KEY_CLOUD_CACHE_HOST = "X-SP-Developer-Server-Domain";
    public static final String PMS_EXT_KEY_CLOSE_CLOUD_CACHE = "closeCloudCache";
    public static final String STAT_KEY_DEV_CLOUD_CACHE = "devCloudCache";
    private static final String TAG = "CloudCacheSwitch";
    public static final int VALUE_FALSE = 0;
    public static final int VALUE_TRUE = 1;

    /* access modifiers changed from: private */
    public static boolean isPmsCloseCloudCache() {
        SwanApp swanApp = SwanApp.getOrNull();
        return swanApp != null && SwanExtInfo.get().closeCloudCache(swanApp.getInfo().getPmsAppInfo());
    }

    public static boolean parseIsPmsCloseCloudCache(JSONObject pkgInfoExtJo) {
        if (pkgInfoExtJo == null || pkgInfoExtJo.optInt("closeCloudCache", 0) != 1) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static boolean isDevOpenCloudCache(JSONObject headersJo) {
        if (headersJo == null) {
            return false;
        }
        Object value = headersJo.opt("cloudCache");
        if (value instanceof Boolean) {
            return ((Boolean) value).booleanValue();
        }
        if (value != null) {
            return true;
        }
        return false;
    }

    public static class State {
        public boolean closeCloudCache = CloudCacheSwitch.isPmsCloseCloudCache();
        public boolean devCloudCache;

        public State(JSONObject joRequest) {
            this.devCloudCache = CloudCacheSwitch.isDevOpenCloudCache(joRequest);
        }

        public JSONObject toJSONObject() {
            JSONObject result = new JSONObject();
            try {
                String str = "1";
                result.put("devCloudCache", this.devCloudCache ? str : "0");
                if (!this.closeCloudCache) {
                    str = "0";
                }
                result.put("closeCloudCache", str);
            } catch (JSONException e2) {
                SwanAppLog.logToFile(CloudCacheSwitch.TAG, "State#toJSONObject error", e2);
            }
            return result;
        }

        public String toString() {
            return "{closeCloudCache=" + this.closeCloudCache + ", devCloudCache=" + this.devCloudCache + AbstractJsonLexerKt.END_OBJ;
        }
    }

    public static void logInfo(String tag, String msg) {
        SwanAppLog.info(tag, LOG_MODULE, msg, false);
    }
}
