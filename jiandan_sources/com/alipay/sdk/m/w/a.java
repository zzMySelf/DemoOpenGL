package com.alipay.sdk.m.w;

import android.content.Context;
import android.os.SystemClock;
import android.util.Pair;
import com.alipay.sdk.m.k.b;
import com.alipay.sdk.m.u.e;
import com.alipay.sdk.m.u.n;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class a {
    public static final String a = "CDT";
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static ConcurrentHashMap<Integer, Pair<Long, ?>> g;
    public static ExecutorService h = Executors.newFixedThreadPool(16);

    /* renamed from: com.alipay.sdk.m.w.a$a  reason: collision with other inner class name */
    public interface C0018a<T, R> {
        R a(T t);
    }

    public static synchronized void a(int i2, Object obj) {
        synchronized (a.class) {
            if (g == null) {
                g = new ConcurrentHashMap<>();
            }
            g.put(Integer.valueOf(i2), new Pair(Long.valueOf(SystemClock.elapsedRealtime()), obj));
        }
    }

    public static Pair<Boolean, ?> a(int i2, TimeUnit timeUnit, long j) {
        ConcurrentHashMap<Integer, Pair<Long, ?>> concurrentHashMap = g;
        if (concurrentHashMap == null) {
            return new Pair<>(Boolean.FALSE, (Object) null);
        }
        Pair pair = concurrentHashMap.get(Integer.valueOf(i2));
        if (pair == null) {
            return new Pair<>(Boolean.FALSE, (Object) null);
        }
        Long l = (Long) pair.first;
        Object obj = pair.second;
        if (l == null || SystemClock.elapsedRealtime() - l.longValue() > TimeUnit.MILLISECONDS.convert(j, timeUnit)) {
            return new Pair<>(Boolean.FALSE, (Object) null);
        }
        return new Pair<>(Boolean.TRUE, obj);
    }

    public static synchronized void a() {
        synchronized (a.class) {
            g = null;
        }
    }

    public static Context a(Context context) {
        if (context == null) {
            return null;
        }
        return context.getApplicationContext();
    }

    public static <T> T a(int i2, long j, TimeUnit timeUnit, C0018a<Object, Boolean> aVar, Callable<T> callable, boolean z, long j2, TimeUnit timeUnit2, com.alipay.sdk.m.s.a aVar2, boolean z2) {
        T t;
        try {
            Pair<Boolean, ?> a2 = a(i2, timeUnit, j);
            if (!((Boolean) a2.first).booleanValue() || !aVar.a(a2.second).booleanValue()) {
                if (!z2 || !n.h()) {
                    if (z) {
                        t = h.submit(callable).get(j2, timeUnit2);
                    } else {
                        t = callable.call();
                    }
                    a(i2, t);
                } else {
                    com.alipay.sdk.m.k.a.b(aVar2, b.l, "ch_get_main", "" + i2);
                    e.d("getC", i2 + " skip");
                    t = null;
                }
                e.d("getC", i2 + " new " + t);
                return t;
            }
            e.d("getC", i2 + " got " + a2.second);
            return a2.second;
        } catch (Throwable th2) {
            e.a(a, "ch_get_e|" + i2, th2);
            com.alipay.sdk.m.k.a.a(aVar2, b.l, "ch_get_e|" + i2, th2);
            e.d("getC", i2 + " err");
            return null;
        }
    }
}
