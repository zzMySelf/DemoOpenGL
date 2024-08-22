package com.alipay.sdk.m.u;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.k.b;
import com.alipay.sdk.m.s.a;

public class i {
    public static final String a = "pref_trade_token";
    public static final String b = ";";
    public static final String c = "result={";
    public static final String d = "}";
    public static final String e = "trade_token=\"";
    public static final String f = "\"";
    public static final String g = "trade_token=";

    public static void a(a aVar, Context context, String str) {
        try {
            String a2 = a(str);
            e.b(com.alipay.sdk.m.l.a.A, "trade token: " + a2);
            if (!TextUtils.isEmpty(a2)) {
                j.b(aVar, context, a, a2);
            }
        } catch (Throwable th2) {
            com.alipay.sdk.m.k.a.a(aVar, b.l, b.I, th2);
            e.a(th2);
        }
    }

    public static String a(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(b);
        for (int i2 = 0; i2 < split.length; i2++) {
            if (split[i2].startsWith(c) && split[i2].endsWith("}")) {
                String[] split2 = split[i2].substring(8, split[i2].length() - 1).split(a.n);
                int i3 = 0;
                while (true) {
                    if (i3 < split2.length) {
                        if (split2[i3].startsWith(e) && split2[i3].endsWith("\"")) {
                            str2 = split2[i3].substring(13, split2[i3].length() - 1);
                            break;
                        } else if (split2[i3].startsWith(g)) {
                            str2 = split2[i3].substring(12);
                            break;
                        } else {
                            i3++;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return str2;
    }

    public static String a(a aVar, Context context) {
        String a2 = j.a(aVar, context, a, "");
        e.b(com.alipay.sdk.m.l.a.A, "get trade token: " + a2);
        return a2;
    }
}
