package com.alipay.sdk.m.j;

import com.alipay.sdk.m.u.i;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f2217a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f2218b;

    public static void a(String str) {
        f2218b = str;
    }

    public static String b() {
        c b2 = c.b(c.DOUBLE_REQUEST.b());
        return a(b2.b(), b2.a(), "");
    }

    public static boolean c() {
        return f2217a;
    }

    public static String d() {
        return f2218b;
    }

    public static String e() {
        c b2 = c.b(c.PARAMS_ERROR.b());
        return a(b2.b(), b2.a(), "");
    }

    public static void a(boolean z) {
        f2217a = z;
    }

    public static String a() {
        c b2 = c.b(c.CANCELED.b());
        return a(b2.b(), b2.a(), "");
    }

    public static String a(int i2, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("resultStatus={").append(i2).append("};memo={").append(str).append("};result={").append(str2).append(i.f2534d);
        return sb.toString();
    }
}
