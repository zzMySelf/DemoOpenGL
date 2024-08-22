package com.baidu.searchbox.browserenhanceengine.container;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import org.json.JSONException;
import org.json.JSONObject;

public class ScreenShotLogStatistics {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String KEY_CURNETWORT = "currentNetWork";
    public static final String KEY_CURTIME = "currentTime";
    public static final String KEY_CURURL = "currentUrl";
    public static final String SCREEN_LOG_SOURCE_SEARCH = "search";
    public static final String TAG = "ScreenShotLogStatistics";

    public static JSONObject getFuseScreenShotLog(String... keysAndParams) {
        if (keysAndParams == null) {
            return null;
        }
        JSONObject jsonObject = new JSONObject();
        for (int i2 = 0; i2 < keysAndParams.length / 2; i2++) {
            int index = i2 * 2;
            if (index + 1 < keysAndParams.length && !TextUtils.isEmpty(keysAndParams[index])) {
                try {
                    jsonObject.put(keysAndParams[index], keysAndParams[index + 1]);
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        if (DEBUG != 0) {
            Log.d(TAG, "keysAndParams length:" + keysAndParams.length);
            Log.d(TAG, "keysAndParams" + keysAndParams);
            Log.d(TAG, jsonObject.toString());
        }
        return jsonObject;
    }
}
