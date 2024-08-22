package com.alipay.sdk.m.f0;

import com.alipay.sdk.m.z.a;

public class c extends a {
    public static final int l = 1;
    public static final int m = 2;
    public static final int n = 3;

    /* renamed from: o  reason: collision with root package name */
    public static final String f656o = "APPKEY_ERROR";
    public static final String p = "SUCCESS";
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;

    /* renamed from: i  reason: collision with root package name */
    public String f657i;
    public String j;
    public String k = "";

    public String a() {
        String str = this.f;
        return str == null ? "0" : str;
    }

    public boolean b() {
        return "1".equals(this.e);
    }

    public int c() {
        return this.a ? a.a(this.c) ? 2 : 1 : f656o.equals(this.b) ? 3 : 2;
    }
}
