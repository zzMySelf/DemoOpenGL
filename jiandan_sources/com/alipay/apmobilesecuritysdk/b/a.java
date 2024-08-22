package com.alipay.apmobilesecuritysdk.b;

import com.alipay.sdk.m.d0.d;

public final class a {
    public static a b = new a();
    public int a = 0;

    public static a a() {
        return b;
    }

    public static String a(String str, String str2) {
        return str + str2;
    }

    public final void a(int i2) {
        this.a = i2;
    }

    public final int b() {
        return this.a;
    }

    public final String c() {
        String str;
        String a2 = d.a();
        if (com.alipay.sdk.m.z.a.b(a2)) {
            return a2;
        }
        int i2 = this.a;
        if (i2 == 1) {
            str = "://mobilegw.stable.alipay.net/mgw.htm";
        } else if (i2 == 2) {
            return "https://mobilegwpre.alipay.com/mgw.htm";
        } else {
            if (i2 == 3) {
                str = "://mobilegw-1-64.test.alipay.net/mgw.htm";
            } else if (i2 != 4) {
                return "https://mobilegw.alipay.com/mgw.htm";
            } else {
                str = "://mobilegw.aaa.alipay.net/mgw.htm";
            }
        }
        return a("http", str);
    }
}
