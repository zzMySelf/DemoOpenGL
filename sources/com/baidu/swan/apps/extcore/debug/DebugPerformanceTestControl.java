package com.baidu.swan.apps.extcore.debug;

import com.baidu.swan.apps.storage.sp.SwanAppSpHelper;

public class DebugPerformanceTestControl {
    public static final String SP_KEY_DEBUG_PERFORMANCE_TEST = "SP-DebugPerformanceTest";

    public static boolean isOpen() {
        return SwanAppSpHelper.getInstance().getBoolean(SP_KEY_DEBUG_PERFORMANCE_TEST, false);
    }

    public static void setOpenState(boolean isOpen) {
        SwanAppSpHelper.getInstance().putBoolean(SP_KEY_DEBUG_PERFORMANCE_TEST, isOpen);
    }
}
