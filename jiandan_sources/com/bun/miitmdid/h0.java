package com.bun.miitmdid;

import androidx.annotation.Keep;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Keep
public class h0 {
    @Keep
    public static int a = 2;
    @Keep
    public static int b = 6000;
    @Keep
    public static int c = 5;
    @Keep
    public static BlockingQueue<Runnable> d = new ArrayBlockingQueue(3);
    @Keep
    public static ThreadFactory e = new a();
    @Keep
    public static ThreadPoolExecutor f = new ThreadPoolExecutor(a, c, (long) b, TimeUnit.SECONDS, d, e);

    @Keep
    public class a implements ThreadFactory {
        @Keep
        public final AtomicInteger a = new AtomicInteger();

        @Keep
        public native Thread newThread(Runnable runnable);
    }

    @Keep
    public static native void a(Runnable runnable);
}
