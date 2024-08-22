package com.dlife.ctaccountapi;

import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class r {
    public static ThreadPoolExecutor a;
    public static r b;

    public static abstract class a implements Runnable {
        public boolean a = false;

        public void a(boolean z) {
            this.a = z;
        }

        public boolean a() {
            return this.a;
        }
    }

    public r() {
        b();
    }

    public static r a() {
        if (b == null) {
            b = new r();
        }
        return b;
    }

    private void b() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 3, TimeUnit.SECONDS, new LinkedBlockingQueue());
        a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public void a(Runnable runnable) {
        a.execute(runnable);
    }

    public Future b(Runnable runnable) {
        return a.submit(runnable);
    }
}
