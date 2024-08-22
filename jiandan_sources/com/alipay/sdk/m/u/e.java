package com.alipay.sdk.m.u;

import com.alipay.sdk.interior.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class e {
    public static Log.ISdkLogCallback a = null;
    public static final String b = "alipaysdk";

    public static void a(Log.ISdkLogCallback iSdkLogCallback) {
        a = iSdkLogCallback;
    }

    public static void b(String str, String str2) {
        a(a(str, str2));
    }

    public static void c(String str, String str2) {
        a(a(str, str2));
    }

    public static void d(String str, String str2) {
        a(a(str, str2));
    }

    public static void e(String str, String str2) {
        a(a(str, str2));
    }

    public static void a(String str) {
        try {
            Log.ISdkLogCallback iSdkLogCallback = a;
            if (iSdkLogCallback != null) {
                iSdkLogCallback.onLogLine(String.format("[AlipaySDK] %s %s", new Object[]{new SimpleDateFormat("hh:mm:ss.SSS", Locale.getDefault()).format(new Date()), str}));
            }
        } catch (Throwable unused) {
        }
    }

    public static String b(Throwable th2) {
        StringWriter stringWriter = new StringWriter();
        th2.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static void a(String str, String str2, Throwable th2) {
        String a2 = a(str, str2);
        a(a2 + " " + b(th2));
    }

    public static void a(Throwable th2) {
        if (th2 != null) {
            try {
                a(b(th2));
            } catch (Throwable unused) {
            }
        }
    }

    public static String a(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        return String.format("[%s][%s]", new Object[]{str, str2});
    }
}
