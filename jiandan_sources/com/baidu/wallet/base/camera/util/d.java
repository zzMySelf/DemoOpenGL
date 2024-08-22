package com.baidu.wallet.base.camera.util;

import java.util.concurrent.LinkedBlockingQueue;

public final class d implements Runnable {
    public final LinkedBlockingQueue<Runnable> a;

    public d(LinkedBlockingQueue<Runnable> linkedBlockingQueue) {
        this.a = linkedBlockingQueue;
    }

    public void run() {
        Thread currentThread = Thread.currentThread();
        while (!currentThread.isInterrupted()) {
            try {
                this.a.take().run();
            } catch (InterruptedException unused) {
                return;
            }
        }
    }
}
