package com.baidu.android.pushservice.e0;

import android.content.Intent;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static Map<Long, c> f8351a;

    public static synchronized void a(long j2) {
        synchronized (b.class) {
            if (f8351a.containsKey(Long.valueOf(j2))) {
                Map<Long, c> map = f8351a;
                map.remove(map.get(Long.valueOf(j2)));
            }
        }
    }

    public static void a(Intent intent) {
        Map<Long, c> map;
        if (intent.hasExtra("bd.cross.request.COMMAND_TYPE") && TextUtils.equals(intent.getStringExtra("bd.cross.request.COMMAND_TYPE"), "bd.cross.command.MESSAGE_ACK")) {
            long longExtra = intent.getLongExtra("bd.cross.request.ID", 0);
            if (longExtra != 0 && (map = f8351a) != null && map.containsKey(Long.valueOf(longExtra))) {
                f8351a.get(Long.valueOf(longExtra)).a(intent);
                Map<Long, c> map2 = f8351a;
                map2.remove(map2.get(Long.valueOf(longExtra)));
            }
        }
    }

    public static synchronized void a(c cVar) {
        synchronized (b.class) {
            if (f8351a == null) {
                f8351a = Collections.synchronizedMap(new HashMap());
            }
            if (f8351a.containsKey(Long.valueOf(cVar.c()))) {
                f8351a.remove(cVar).c();
            }
            f8351a.put(Long.valueOf(cVar.c()), cVar);
        }
    }
}
