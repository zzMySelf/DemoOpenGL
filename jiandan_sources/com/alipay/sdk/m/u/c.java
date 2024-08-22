package com.alipay.sdk.m.u;

import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.alipay.sdk.m.s.a;
import com.alipay.sdk.m.w.b;

public class c {
    public static final String a = "00:00:00:00:00:00";
    public static c b;

    public c(Context context) {
    }

    public static c b(Context context) {
        if (b == null) {
            b = new c(context);
        }
        return b;
    }

    public static String c(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getResources().getConfiguration().locale.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static g d(Context context) {
        try {
            NetworkInfo a2 = b.a((a) null, context);
            if (a2 != null && a2.getType() == 0) {
                return g.a(a2.getSubtype());
            }
            if (a2 == null || a2.getType() != 1) {
                return g.NONE;
            }
            return g.WIFI;
        } catch (Exception unused) {
            return g.NONE;
        }
    }

    public String a() {
        String str = b() + "|";
        String c = c();
        if (TextUtils.isEmpty(c)) {
            return str + "000000000000000";
        }
        return str + c;
    }

    public String b() {
        return "000000000000000";
    }

    public String c() {
        return "000000000000000";
    }

    public String d() {
        return a;
    }

    public static String a(Context context) {
        return b(context).a().substring(0, 8);
    }
}
