package com.alipay.sdk.m.n0;

import android.content.Context;
import com.alipay.sdk.m.l0.f;

public class a {
    public static String a(Context context) {
        b b = c.b(context);
        return (b == null || f.a(b.c())) ? "ffffffffffffffffffffffff" : b.c();
    }

    public static String b(Context context) {
        String a = d.a(context).a();
        return (a == null || f.a(a)) ? "ffffffffffffffffffffffff" : a;
    }

    @Deprecated
    public static String c(Context context) {
        return a(context);
    }

    @Deprecated
    public static String d(Context context) {
        return b(context);
    }
}
