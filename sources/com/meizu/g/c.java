package com.meizu.g;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class c implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final ThreadPoolExecutor f4951a;

    private static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static c f4952a = new c();
    }

    private c() {
        this.f4951a = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new d().a("single-pool-%d").a());
    }

    public static c a() {
        return b.f4952a;
    }

    public void execute(Runnable runnable) {
        this.f4951a.execute(runnable);
    }
}
