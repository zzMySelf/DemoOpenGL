package com.sdk.d;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class f implements ThreadFactory {
    public final AtomicInteger a = new AtomicInteger(1);

    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "PriorityExecutor #" + this.a.getAndIncrement());
    }
}
