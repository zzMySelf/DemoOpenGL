package com.thunder.livesdk.log;

import com.thunder.livesdk.helper.ThunderNative;

public class ThunderLog {
    private static volatile ThunderLog instance = null;
    public static final String kLogTagAudio = "yaudio-Java";
    public static final String kLogTagCall = "ycall-Java";
    public static final String kLogTagCallback = "ycallback-Java";
    public static final String kLogTagRtcEngine = "yrtc";
    public static final String kLogTagSdk = "ysdk-Java";
    public static final String kLogTagVideo = "yvideo-Java";
    private static int logLevel = 10;
    private static Object syncLock = new Object();

    public static final class YYLogModule {
        public static final int YYLOG_MODULE_AUDIO = 101;
        public static final int YYLOG_MODULE_PLATFORM = 100;
        public static final int YYLOG_MODULE_TRANS = 103;
        public static final int YYLOG_MODULE_UNKNOWN = 0;
        public static final int YYLOG_MODULE_VIDEO = 102;
    }

    public static ThunderLog instance() {
        if (instance == null) {
            synchronized (syncLock) {
                if (instance == null) {
                    instance = new ThunderLog();
                }
            }
        }
        return instance;
    }

    public static void setLogLevel(int level) {
        logLevel = level;
    }

    public static void trace(String tag, String format, Object... args) {
        logM(0, 100, tag, format, args);
    }

    public static void trace(String tag, String text) {
        logM(0, 100, tag, text);
    }

    public static void debug(String tag, String format, Object... args) {
        logM(1, 100, tag, format, args);
    }

    public static void debug(String tag, String text) {
        logM(1, 100, tag, text);
    }

    public static void info(String tag, String format, Object... args) {
        logM(2, 100, tag, format, args);
    }

    public static void info(String tag, String text) {
        logM(2, 100, tag, text);
    }

    public static void warn(String tag, String format, Object... args) {
        logM(3, 100, tag, format, args);
    }

    public static void warn(String tag, String text) {
        logM(3, 100, tag, text);
    }

    public static void error(String tag, String format, Object... args) {
        logM(4, 100, tag, format, args);
    }

    public static void error(String tag, String text) {
        logM(4, 100, tag, text);
    }

    public static void release(String tag, String format, Object... args) {
        logM(10, 100, tag, format, args);
    }

    public static void release(String tag, String text) {
        logM(10, 100, tag, text);
    }

    public static void logM(int level, int module, String tag, String text) {
        ThunderNative.logText(level, module, tag, text);
    }

    public static void logM(int level, int module, String tag, String format, Object... args) {
        if (level >= logLevel) {
            ThunderNative.logText(level, module, tag, String.format(format, args));
        }
    }

    public static boolean isInfoValid() {
        return logLevel <= 2;
    }

    public static boolean isWarnValid() {
        return logLevel <= 3;
    }

    public static boolean isErrorValid() {
        return logLevel <= 4;
    }

    public void enableConsoleLogger(boolean bEnable) {
    }
}
