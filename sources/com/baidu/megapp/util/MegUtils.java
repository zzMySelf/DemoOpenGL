package com.baidu.megapp.util;

public final class MegUtils {
    private static boolean CALL_PLUGIN_SPEED = false;
    private static boolean CALL_PLUGIN_SPEED_LOG_UPLOAD = false;
    public static final String CALL_PLUGIN_SPEED_TAG = "CallPluginSpeed";
    private static boolean DEBUG = false;
    private static boolean LOG_DEBUG = false;
    private static boolean MULTI_PROCESS_DEBUG = false;
    public static long sApsLogicTime = 0;
    public static long sApsSystemTime = 0;
    public static long sCallPluginSpeedTime = 0;
    public static long sPluginEnvInitTime = 0;
    public static long sPluginLoadInitTime = 0;

    public static void clearSpeedData() {
        sCallPluginSpeedTime = 0;
        sPluginEnvInitTime = 0;
        sPluginLoadInitTime = 0;
        sApsSystemTime = 0;
        sApsLogicTime = 0;
    }

    public static void setCallPluginSpeedDebug(boolean debug) {
        CALL_PLUGIN_SPEED = debug;
    }

    public static boolean isCallPluginSpeedDebug() {
        return CALL_PLUGIN_SPEED;
    }

    public static void setCallPluginSpeedLogUpload(boolean debug) {
        CALL_PLUGIN_SPEED_LOG_UPLOAD = debug;
    }

    public static boolean isCallPluginSpeedLogUpload() {
        return CALL_PLUGIN_SPEED_LOG_UPLOAD;
    }

    public static void setDebug(boolean debug) {
        DEBUG = debug;
    }

    public static boolean isDebug() {
        return DEBUG;
    }

    public static void setMultiProcessDebug(boolean debug) {
        MULTI_PROCESS_DEBUG = debug;
    }

    public static boolean isMultiprocessDebug() {
        return MULTI_PROCESS_DEBUG;
    }

    public static void setLogDebug(boolean debug) {
        LOG_DEBUG = debug;
    }

    public static boolean isLogDebug() {
        return LOG_DEBUG;
    }
}
