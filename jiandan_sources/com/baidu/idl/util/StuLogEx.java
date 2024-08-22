package com.baidu.idl.util;

import android.util.Log;

public class StuLogEx {
    public static final boolean DEBUG_ENABLE = Log.isLoggable("stu", 3);
    public static final String TAG = "IDL";

    public static void d(String str, String str2) {
        if (DEBUG_ENABLE) {
            str + str2;
        }
    }

    public static void e(String str, String str2) {
        str + str2;
    }

    public static void i(String str, String str2) {
        if (DEBUG_ENABLE) {
            str + str2;
        }
    }

    public static void v(String str, String str2) {
        if (DEBUG_ENABLE) {
            str + str2;
        }
    }

    public static void w(String str, String str2) {
        if (DEBUG_ENABLE) {
            str + str2;
        }
    }

    public static void e(String str, String str2, Throwable th2) {
        str + str2;
    }
}
