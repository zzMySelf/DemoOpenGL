package com.tera.scan.scheduler.executor.task;

import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TaskQueue<E> extends PriorityBlockingQueue<E> {
    public TaskQueue<E>.ad mUpgradeTask;

    public class ad implements Runnable {
        public ad() {
        }

        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            Iterator it = TaskQueue.this.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof fe.mmm.qw.a.yj.de.ad) {
                    ((fe.mmm.qw.a.yj.de.ad) next).vvv(currentTimeMillis);
                }
            }
        }
    }

    public TaskQueue() {
        init();
    }

    private void init() {
        this.mUpgradeTask = new ad();
        new ScheduledThreadPoolExecutor(1).scheduleAtFixedRate(this.mUpgradeTask, 20000, 20000, TimeUnit.MILLISECONDS);
    }
}
