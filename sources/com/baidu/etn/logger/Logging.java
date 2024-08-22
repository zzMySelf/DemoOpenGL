package com.baidu.etn.logger;

import android.util.Log;

public class Logging {
    public static final int DEBUG = 5;
    public static final int ERROR = 1;
    public static final int INFO = 3;
    public static final String TAG = "EtnSdk";
    public static final int VERBOSE = 4;
    public static final int WARNING = 2;
    public static int sLevel = 1;

    public static void d(String str, String str2) {
        if (sLevel == 5) {
            Log.d(TAG, str2);
        }
    }

    public static void e(String str, String str2) {
        if (sLevel >= 1) {
            Log.e(TAG, str2);
        }
    }

    public static int getLevel() {
        return sLevel;
    }

    public static void i(String str, String str2) {
        if (sLevel >= 3) {
            Log.i(TAG, str2);
        }
    }

    public static void setLevel(int i2) {
        int i3 = sLevel;
        if (i3 > 5 || i3 < 1) {
            throw new IllegalArgumentException("Log sLevel is not between ERROR and DEBUG");
        }
        sLevel = i2;
    }

    public static void v(String str, String str2) {
        if (sLevel >= 4) {
            Log.v(TAG, str2);
        }
    }

    public static void w(String str, String str2) {
        if (sLevel >= 2) {
            Log.w(TAG, str2);
        }
    }

    public static void e(String str, String str2, Throwable th2) {
        if (sLevel >= 1) {
            Log.e(TAG, str2, th2);
        }
    }
}
