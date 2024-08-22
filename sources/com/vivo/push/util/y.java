package com.vivo.push.util;

import com.vivo.push.b.c;

/* compiled from: OperateUtil */
public final class y {
    public static int a(c cVar) {
        ad b2 = ad.b();
        int b3 = cVar.b();
        long currentTimeMillis = System.currentTimeMillis();
        int b4 = b2.b("com.vivo.push_preferences.operate." + b3 + "OPERATE_COUNT");
        long b5 = currentTimeMillis - b2.b("com.vivo.push_preferences.operate." + b3 + "START_TIME", 0);
        if (b5 > 86400000 || b5 < 0) {
            b2.a("com.vivo.push_preferences.operate." + b3 + "START_TIME", System.currentTimeMillis());
            b2.a("com.vivo.push_preferences.operate." + b3 + "OPERATE_COUNT", 1);
            return 0;
        } else if (b4 >= cVar.d()) {
            return 1001;
        } else {
            b2.a("com.vivo.push_preferences.operate." + b3 + "OPERATE_COUNT", b4 + 1);
            return 0;
        }
    }
}
