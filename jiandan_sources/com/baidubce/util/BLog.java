package com.baidubce.util;

public class BLog {
    public static String LOG_TAG = "BOS";
    public static boolean enableLog;

    public static void debug(String str) {
        boolean z = enableLog;
    }

    public static void disableLog() {
        enableLog = false;
    }

    public static void enableLog() {
        enableLog = true;
    }

    public static void error(String str) {
        if (enableLog) {
            String.valueOf(str);
        }
    }

    public static void info(String str) {
        boolean z = enableLog;
    }

    public static boolean isEnableLog() {
        return enableLog;
    }

    public static void warn(String str) {
        if (enableLog) {
            String.valueOf(str);
        }
    }

    public static void debug(String str, Object obj) {
        if (enableLog) {
            str + obj;
        }
    }

    public static void info(String str, Object obj) {
        if (enableLog) {
            str + obj;
        }
    }

    public static void error(String str, Object obj) {
        if (enableLog) {
            str + obj;
        }
    }

    public static void warn(String str, Object obj) {
        if (enableLog) {
            str + obj;
        }
    }

    public static void debug(String str, Object obj, Object obj2) {
        if (enableLog) {
            str + obj + obj2;
        }
    }

    public static void info(String str, Object obj, Object obj2) {
        if (enableLog) {
            str + obj + obj2;
        }
    }

    public static void error(String str, Object obj, Object obj2) {
        if (enableLog) {
            str + obj + obj2;
        }
    }

    public static void warn(String str, Object obj, Object obj2) {
        if (enableLog) {
            str + obj + obj2;
        }
    }

    public static void debug(String str, Throwable th2) {
        boolean z = enableLog;
    }

    public static void info(String str, Throwable th2) {
        boolean z = enableLog;
    }

    public static void debug(String str, String str2, Throwable th2) {
        if (enableLog) {
            str + str2;
        }
    }

    public static void error(String str, Throwable th2) {
        boolean z = enableLog;
    }

    public static void info(String str, String str2, Throwable th2) {
        if (enableLog) {
            str + str2;
        }
    }

    public static void warn(String str, Throwable th2) {
        boolean z = enableLog;
    }

    public static void error(String str, String str2, Throwable th2) {
        if (enableLog) {
            str + str2;
        }
    }

    public static void warn(String str, String str2, Throwable th2) {
        if (enableLog) {
            str + str2;
        }
    }
}
