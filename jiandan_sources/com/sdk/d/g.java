package com.sdk.d;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class g implements Executor {
    public static final ThreadFactory a = new f();
    public final BlockingQueue<Runnable> b;
    public final ThreadPoolExecutor c;

    public g() {
        i iVar = new i();
        this.b = iVar;
        this.c = new ThreadPoolExecutor(5, 256, 1, TimeUnit.SECONDS, iVar, a);
    }

    public void execute(Runnable runnable) {
        this.c.execute(runnable);
    }
}
