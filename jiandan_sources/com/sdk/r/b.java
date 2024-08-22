package com.sdk.r;

import android.content.Context;
import com.sdk.k.a;

public class b {
    public static boolean a = false;

    public static boolean a(Context context) {
        if (a) {
            return true;
        }
        Long b = a.b(context, "access_limit_time");
        long currentTimeMillis = System.currentTimeMillis();
        if (b == null) {
            a.a(context, "access_limit_time", Long.valueOf(currentTimeMillis));
            return true;
        } else if (currentTimeMillis - b.longValue() > 600000) {
            a.a(context, "access_limit_time", Long.valueOf(currentTimeMillis));
            a.a(context, "access_limit_count", (Long) 0L);
            return true;
        } else {
            Long b2 = a.b(context, "access_limit_count");
            if (b2 != null) {
                return b2.longValue() <= 30;
            }
            a.a(context, "access_limit_count", (Long) 0L);
            return true;
        }
    }

    public static void b(Context context) {
        Long b = a.b(context, "access_limit_count");
        a.a(context, "access_limit_count", Long.valueOf(b == null ? 0 : b.longValue() + 1));
    }
}
