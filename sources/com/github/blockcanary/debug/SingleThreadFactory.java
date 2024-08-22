package com.github.blockcanary.debug;

import java.util.concurrent.ThreadFactory;

final class SingleThreadFactory implements ThreadFactory {
    private final String threadName;

    SingleThreadFactory(String threadName2) {
        this.threadName = "BlockCanary-" + threadName2;
    }

    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.threadName);
    }
}
