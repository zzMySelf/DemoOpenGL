package com.baidu.sofire.l;

import com.baidu.sofire.a.a;
import java.util.concurrent.ConcurrentHashMap;

public class l {
    public static boolean a = true;
    public static ConcurrentHashMap<Long, Throwable> b = new ConcurrentHashMap<>(32);
    public static ConcurrentHashMap<Long, Throwable> c = new ConcurrentHashMap<>(32);

    public static void a() {
        try {
            if (a) {
                Throwable th2 = new Throwable();
                if (c.size() >= 20) {
                    long j = Long.MAX_VALUE;
                    for (Long longValue : c.keySet()) {
                        long longValue2 = longValue.longValue();
                        if (longValue2 < j) {
                            j = longValue2;
                        }
                    }
                    c.remove(Long.valueOf(j));
                }
                c.put(Long.valueOf(System.currentTimeMillis()), th2);
            }
        } catch (Throwable unused) {
            int i2 = a.a;
        }
    }

    public static void b() {
        try {
            if (a) {
                Throwable th2 = new Throwable();
                if (b.size() >= 10) {
                    long j = Long.MAX_VALUE;
                    for (Long longValue : b.keySet()) {
                        long longValue2 = longValue.longValue();
                        if (longValue2 < j) {
                            j = longValue2;
                        }
                    }
                    b.remove(Long.valueOf(j));
                }
                b.put(Long.valueOf(System.currentTimeMillis()), th2);
            }
        } catch (Throwable unused) {
            int i2 = a.a;
        }
    }
}
