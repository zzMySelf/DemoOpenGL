package com.alipay.sdk.m.l0;

public class g {
    public static String a(String str, String str2) {
        Class<String> cls = String.class;
        try {
            Class<?> cls2 = Class.forName("android.os.SystemProperties");
            return (String) cls2.getMethod("get", new Class[]{cls, cls}).invoke(cls2, new Object[]{str, str2});
        } catch (Exception unused) {
            return str2;
        }
    }
}
