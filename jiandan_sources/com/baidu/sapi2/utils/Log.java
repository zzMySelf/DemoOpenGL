package com.baidu.sapi2.utils;

import com.baidu.sapi2.NoProguard;

public final class Log implements NoProguard {
    public static final String TAG = "SAPI";
    public static boolean enabled = false;

    public static String converArrayToString(String str, Object[] objArr) {
        if (objArr == null) {
            return "";
        }
        try {
            if (objArr.length == 0) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            int length = objArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                Throwable th2 = objArr[i2];
                if (th2 != null) {
                    if (i2 != 0) {
                        stringBuffer.append("|");
                    }
                    try {
                        if (th2 instanceof Throwable) {
                            stringBuffer.append(android.util.Log.getStackTraceString(th2));
                        } else {
                            stringBuffer.append(th2.toString());
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            return stringBuffer.toString();
        } catch (Throwable th3) {
            "converArrayToString t: " + th3.toString();
            return "converArrayToString null";
        }
    }

    public static void d(String str, Object... objArr) {
        if (enabled) {
            "SAPI_" + str;
            converArrayToString(str, objArr);
        }
    }

    public static void e(Throwable th2) {
        e(TAG, th2);
    }

    public static void enable(boolean z) {
        enabled = z;
    }

    public static void i(String str, Object... objArr) {
        if (enabled) {
            "SAPI_" + str;
            converArrayToString(str, objArr);
        }
    }

    public static void w(String str, Object... objArr) {
        if (enabled) {
            "SAPI_" + str;
            converArrayToString(str, objArr);
        }
    }

    public static void e(String str, Throwable th2) {
        e(str, th2);
    }

    public static void d(Object... objArr) {
        d(TAG, objArr);
    }

    public static void e(String str, Object... objArr) {
        if (enabled) {
            "SAPI_" + str;
            converArrayToString(str, objArr);
        }
    }

    public static void i(Object... objArr) {
        i(TAG, objArr);
    }

    public static void w(Object... objArr) {
        w(TAG, objArr);
    }
}
