package com.huawei.multimedia.audiokit.utils;

import android.util.Log;

public class LogUtils {
    public static final int DEBUG = 4;
    public static final int ERROR = 1;
    private static final String ERROR_MESSAGE = "log message error : ";
    public static final int INFO = 3;
    public static final int LOG_LEVEL = 6;
    public static final int VERBOSE = 5;
    public static final int WARN = 2;

    private LogUtils() {
    }

    public static void error(String tag, String msg) {
        Log.e(tag, msg);
    }

    public static void warn(String tag, String msg) {
        Log.w(tag, msg);
    }

    public static void info(String tag, String msg) {
        Log.i(tag, msg);
    }

    public static void debug(String tag, String msg) {
        Log.d(tag, msg);
    }

    public static void verbose(String tag, String msg) {
        Log.v(tag, msg);
    }
}
