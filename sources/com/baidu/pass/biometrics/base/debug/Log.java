package com.baidu.pass.biometrics.base.debug;

public final class Log {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15738a = "SAPI";

    /* renamed from: b  reason: collision with root package name */
    private static boolean f15739b = false;

    private Log() {
    }

    private static String a(String str, Object[] objArr) {
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
                    } catch (Exception e2) {
                    }
                }
            }
            return stringBuffer.toString();
        } catch (Throwable th3) {
            android.util.Log.e("SAPI_" + str, "converArrayToString t: " + th3.toString());
            return "converArrayToString null";
        }
    }

    public static void d(String str, Object... objArr) {
        if (f15739b) {
            android.util.Log.d("SAPI_" + str, a(str, objArr));
        }
    }

    public static void e(Throwable th2) {
        e("SAPI", th2);
    }

    public static void enable(boolean z) {
        f15739b = z;
    }

    public static void i(String str, Object... objArr) {
        if (f15739b) {
            android.util.Log.i("SAPI_" + str, a(str, objArr));
        }
    }

    public static void w(String str, Object... objArr) {
        if (f15739b) {
            android.util.Log.w("SAPI_" + str, a(str, objArr));
        }
    }

    public static void e(String str, Throwable th2) {
        e(str, th2);
    }

    public static void e(String str, Object... objArr) {
        if (f15739b) {
            android.util.Log.e("SAPI_" + str, a(str, objArr));
        }
    }

    public static void d(Object... objArr) {
        d("SAPI", objArr);
    }

    public static void i(Object... objArr) {
        i("SAPI", objArr);
    }

    public static void w(Object... objArr) {
        w("SAPI", objArr);
    }
}
