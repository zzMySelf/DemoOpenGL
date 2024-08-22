package com.cmic.sso.sdk.e;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.cmic.sso.sdk.a;
import com.cmic.sso.sdk.e.k;
import com.cmic.sso.sdk.e.n;
import org.apache.commons.lang3.time.DateUtils;

public class h {
    public static String a = null;
    public static String b = null;
    public static long c = 0;
    public static int d = -1;

    public static boolean c() {
        if (!TextUtils.isEmpty(a)) {
            c.b("PhoneScripUtils", b + " " + c);
            return a(c);
        }
        return !TextUtils.isEmpty(k.b("phonescripcache", "")) && a(k.a("phonescripstarttime", 0));
    }

    public static void a(boolean z, boolean z2) {
        k.a a2 = k.a();
        a2.a("phonescripstarttime");
        a2.a("phonescripcache");
        a2.a("pre_sim_key");
        a2.a("phonescripversion");
        if (z2) {
            a2.a();
        } else {
            a2.b();
        }
        if (z) {
            a = null;
            b = null;
            c = 0;
            d = -1;
        }
    }

    public static void b(Context context, String str, long j, String str2) {
        String a2 = b.a(context, str);
        if (!TextUtils.isEmpty(a2)) {
            k.a a3 = k.a();
            a3.a("phonescripcache", a2);
            a3.a("phonescripstarttime", j);
            a3.a("phonescripversion", 2);
            a3.a("pre_sim_key", str2);
            a3.b();
        }
    }

    public static void a(final Context context, final String str, long j, final String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && j > 0) {
            c.b("PhoneScripUtils", "save phone scrip simKey = " + str2);
            a = str;
            long j2 = j * 1000;
            c = System.currentTimeMillis() + j2;
            c.b("sLifeTime", c + "");
            b = str2;
            d = 2;
            if (!"operator".equals(str3)) {
                n.a(new n.a() {
                    public void a() {
                        c.b("PhoneScripUtils", "start save scrip to sp in sub thread");
                        h.b(context, str, h.c, str2);
                    }
                });
            } else if (j2 > DateUtils.MILLIS_PER_HOUR) {
                c = System.currentTimeMillis() + DateUtils.MILLIS_PER_HOUR;
            } else {
                c = System.currentTimeMillis() + j2;
            }
        }
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        String b2 = k.b("phonescripcache", "");
        if (TextUtils.isEmpty(b2)) {
            c.a("PhoneScripUtils", StringUtil.NULL_STRING);
            return null;
        }
        c = k.a("phonescripstarttime", 0);
        b = k.b("pre_sim_key", "");
        d = k.a("phonescripversion", -1);
        String b3 = b.b(context, b2);
        a = b3;
        return b3;
    }

    public static boolean a(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        c.b("PhoneScripUtils", j + "");
        c.b("PhoneScripUtils", currentTimeMillis + "");
        return j - currentTimeMillis > 10000;
    }

    public static long a() {
        long j;
        long a2;
        long currentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(a)) {
            c.b("PhoneScripUtils", b + " " + c);
            a2 = c;
        } else {
            String b2 = k.b("phonescripcache", "");
            a2 = k.a("phonescripstarttime", 0);
            if (TextUtils.isEmpty(b2)) {
                j = 0;
                return Math.max(j / 1000, 0);
            }
        }
        j = (a2 - currentTimeMillis) - 10000;
        return Math.max(j / 1000, 0);
    }

    public static int a(String str) {
        String str2;
        if (!TextUtils.isEmpty(b)) {
            str2 = b;
        } else {
            str2 = k.b("pre_sim_key", "");
            b = str2;
        }
        if (TextUtils.isEmpty(str2)) {
            return 0;
        }
        return str2.equals(str) ? 1 : 2;
    }

    public static boolean a(a aVar) {
        int a2 = a(aVar.b("scripKey"));
        aVar.a("imsiState", a2 + "");
        c.b("PhoneScripUtils", "simState = " + a2);
        if (a2 == 0) {
            return false;
        }
        if (d == -1) {
            d = k.a("phonescripversion", -1);
        }
        if (d != 2) {
            a(true, false);
            b.a();
            c.b("PhoneScripUtils", "phoneScriptVersion change");
            return false;
        } else if (a2 != 2) {
            return c();
        } else {
            a(true, false);
            return false;
        }
    }
}
