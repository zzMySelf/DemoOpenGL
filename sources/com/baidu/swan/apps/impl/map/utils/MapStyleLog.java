package com.baidu.swan.apps.impl.map.utils;

import android.text.TextUtils;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.console.SwanAppLog;

public class MapStyleLog {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String MODULE_TAG = "Map-Style";

    public static void print(String msg) {
        if (DEBUG && !TextUtils.isEmpty(msg)) {
            SwanAppLog.i(MODULE_TAG, msg);
        }
    }
}
