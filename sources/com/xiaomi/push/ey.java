package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.feedback.receiver.UFOEventType;
import com.xiaomi.channel.commonutils.logger.b;
import java.util.HashMap;

public class ey {
    public static void a(Context context, String str, int i2, String str2) {
        ag.a(context).a((Runnable) new ez(context, str, i2, str2));
    }

    /* access modifiers changed from: private */
    public static void c(Context context, String str, int i2, String str2) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("awake_info", str);
                hashMap.put(UFOEventType.EVENT_TYPE_KEY, String.valueOf(i2));
                hashMap.put("description", str2);
                switch (fc.a(context).a()) {
                    case 1:
                        a(context, hashMap);
                        break;
                    case 2:
                        c(context, hashMap);
                        break;
                    case 3:
                        a(context, hashMap);
                        c(context, hashMap);
                        break;
                }
                b(context, hashMap);
            } catch (Exception e2) {
                b.a((Throwable) e2);
            }
        }
    }

    private static void a(Context context, HashMap<String, String> hashMap) {
        fg a2 = fc.a(context).a();
        if (a2 != null) {
            a2.a(context, hashMap);
        }
    }

    private static void b(Context context, HashMap<String, String> hashMap) {
        fg a2 = fc.a(context).a();
        if (a2 != null) {
            a2.c(context, hashMap);
        }
    }

    private static void c(Context context, HashMap<String, String> hashMap) {
        fg a2 = fc.a(context).a();
        if (a2 != null) {
            a2.b(context, hashMap);
        }
    }
}
