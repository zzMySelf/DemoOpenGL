package com.baidu.swan.apps.plugin.log;

import android.text.TextUtils;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.console.SwanAppLog;

public class SwanPluginLog {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    public static final String MODULE_TAG = "Module-Plugin";

    public static void print(String msg) {
        if (DEBUG && !TextUtils.isEmpty(msg)) {
            SwanAppLog.i(MODULE_TAG, msg);
        }
    }

    public static void e(String msg) {
        if (DEBUG && !TextUtils.isEmpty(msg)) {
            SwanAppLog.e(MODULE_TAG, msg);
        }
    }

    public static void todo(String msg) {
        e(msg);
    }
}
