package com.tencent.mm.opensdk.utils;

public class Log {
    public static ILog logImpl;

    public static void d(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog != null) {
            iLog.d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog != null) {
            iLog.e(str, str2);
        }
    }

    public static void i(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog != null) {
            iLog.i(str, str2);
        }
    }

    public static void setLogImpl(ILog iLog) {
        logImpl = iLog;
    }

    public static void v(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog != null) {
            iLog.v(str, str2);
        }
    }

    public static void w(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog != null) {
            iLog.w(str, str2);
        }
    }
}
