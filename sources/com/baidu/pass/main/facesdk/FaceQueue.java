package com.baidu.pass.main.facesdk;

import java.util.LinkedList;

public class FaceQueue {
    private int nThreads;
    /* access modifiers changed from: private */
    public LinkedList queue = null;
    private PoolWorker[] threads;

    private static class HolderClass {
        /* access modifiers changed from: private */
        public static final FaceQueue instance = new FaceQueue(1);

        private HolderClass() {
        }
    }

    private class PoolWorker extends Thread {
        private PoolWorker() {
        }

        public void run() {
            Runnable runnable;
            while (true) {
                synchronized (FaceQueue.this.queue) {
                    while (FaceQueue.this.queue.isEmpty()) {
                        try {
                            FaceQueue.this.queue.wait();
                        } catch (InterruptedException e2) {
                        }
                    }
                    runnable = (Runnable) FaceQueue.this.queue.removeFirst();
                }
                try {
                    runnable.run();
                } catch (RuntimeException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public FaceQueue(int i2) {
        this.nThreads = i2;
        this.queue = new LinkedList();
        this.threads = new PoolWorker[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            this.threads[i3] = new PoolWorker();
            this.threads[i3].start();
        }
    }

    public static FaceQueue getInstance() {
        return HolderClass.instance;
    }

    public void execute(Runnable runnable) {
        synchronized (this.queue) {
            this.queue.addLast(runnable);
            this.queue.notify();
        }
    }
}
