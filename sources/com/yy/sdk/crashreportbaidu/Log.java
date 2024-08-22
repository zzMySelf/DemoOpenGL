package com.yy.sdk.crashreportbaidu;

public class Log {
    private static ILog log = new SimpleLog();

    private Log() {
    }

    static void setLog(ILog logger) {
        if (logger != null) {
            log = logger;
        }
    }

    public static void v(String tag, String msg) {
        log.v(tag, msg);
    }

    public static void v(String tag, String msg, Throwable tr) {
        log.v(tag, msg, tr);
    }

    public static void d(String tag, String msg) {
        log.d(tag, msg);
    }

    public static void d(String tag, String msg, Throwable tr) {
        log.d(tag, msg, tr);
    }

    public static void i(String tag, String msg) {
        log.i(tag, msg);
    }

    public static void i(String tag, String msg, Throwable tr) {
        log.i(tag, msg, tr);
    }

    public static void w(String tag, String msg) {
        log.w(tag, msg);
    }

    public static void w(String tag, String msg, Throwable tr) {
        log.w(tag, msg, tr);
    }

    public static void w(String tag, Throwable tr) {
        log.w(tag, tr);
    }

    public static void e(String tag, String msg) {
        log.e(tag, msg);
    }

    public static void e(String tag, String msg, Throwable tr) {
        log.e(tag, msg, tr);
    }
}
