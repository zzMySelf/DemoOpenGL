package com.baidu.searchbox.net.common;

import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ExtraInfoCallback;

public final class ClientIPHelper {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "ClientIPHelper";

    public static void addClientIPCallback(ExtraInfoCallback callback) {
        if (callback != null) {
            if (DEBUG) {
                Log.d(TAG, "addClientIPCallback callback: " + callback);
            }
            HttpManager.getExtraInfoDispatcher().addCallback(callback);
        }
    }

    public static void clearClientIPCallback() {
        if (DEBUG) {
            Log.d(TAG, "clearClientIPCallback : " + HttpManager.getExtraInfoDispatcher().getAllCallbacks());
        }
        HttpManager.getExtraInfoDispatcher().clearCallback();
    }
}
