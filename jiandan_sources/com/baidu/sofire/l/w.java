package com.baidu.sofire.l;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.lang3.StringUtils;

public class w {
    public static final int f;
    public static volatile w g;
    public static final int h;

    /* renamed from: i  reason: collision with root package name */
    public static long f1094i = 0;
    public ThreadPoolExecutor a;
    public ThreadPoolExecutor b;
    public BlockingQueue<Runnable> c = new LinkedBlockingQueue(100);
    public BlockingQueue<Runnable> d = new LinkedBlockingQueue(10);
    public Context e;

    public static class a implements ThreadFactory {
        public final AtomicInteger a = new AtomicInteger(1);
        public final String b;
        public final int c;

        public a(String str, int i2) {
            this.b = str;
            this.c = i2;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.b + this.a.getAndIncrement());
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.c);
            return thread;
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f = availableProcessors;
        h = (availableProcessors * 2) + 1;
    }

    public w() {
        int i2 = f;
        int max = Math.max(4, i2);
        int max2 = Math.max(max, (i2 * 2) + 1);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.a = new ThreadPoolExecutor(max, max2, 10, timeUnit, this.c, new a("sofire_pool_thread_", 5), new ThreadPoolExecutor.AbortPolicy());
        this.b = new ThreadPoolExecutor(2, h, 10, timeUnit, this.d, new a("sofire_pool_core_thread_", 6), new ThreadPoolExecutor.DiscardOldestPolicy());
        if (Build.VERSION.SDK_INT >= 9) {
            this.a.allowCoreThreadTimeOut(true);
            this.b.allowCoreThreadTimeOut(true);
        }
    }

    public int a(Runnable runnable) {
        try {
            ThreadPoolExecutor threadPoolExecutor = this.a;
            if (threadPoolExecutor == null) {
                return -2;
            }
            threadPoolExecutor.execute(runnable);
            return 1;
        } catch (RejectedExecutionException e2) {
            if (this.e != null) {
                if (System.currentTimeMillis() - f1094i >= 86400000) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("0", Integer.valueOf(f));
                    hashMap.put("1", Integer.valueOf(this.a.getCorePoolSize()));
                    hashMap.put("2", Integer.valueOf(this.a.getMaximumPoolSize()));
                    hashMap.put("3", Base64.encodeToString(com.baidu.sofire.a.a.a(e2).getBytes(), 0).replace(StringUtils.LF, "").replace("\t", "").replace(StringUtils.CR, ""));
                    c.a(this.e.getApplicationContext(), "1003147", (Map<String, Object>) hashMap, true);
                    f1094i = System.currentTimeMillis();
                }
            }
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
        }
        int i3 = com.baidu.sofire.a.a.a;
        return -1;
    }

    public int b(Runnable runnable) {
        try {
            ThreadPoolExecutor threadPoolExecutor = this.b;
            if (threadPoolExecutor == null) {
                return -2;
            }
            threadPoolExecutor.execute(runnable);
            return 1;
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
            return -3;
        }
    }

    public static w a(Context context) {
        if (g == null) {
            try {
                synchronized (w.class) {
                    if (g == null) {
                        g = new w();
                    }
                }
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.a.a;
            }
        }
        if (!(g == null || g.e != null || context == null)) {
            g.e = context;
        }
        return g;
    }
}
