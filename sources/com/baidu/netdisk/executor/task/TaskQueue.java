package com.baidu.netdisk.executor.task;

import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public class TaskQueue<E> extends PriorityBlockingQueue<E> {
    private TaskQueue<E>.UpgradeTask mUpgradeTask;

    public TaskQueue() {
        init();
    }

    private void init() {
        this.mUpgradeTask = new UpgradeTask();
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(this.mUpgradeTask, 20000, 20000, TimeUnit.MILLISECONDS);
    }

    private class UpgradeTask implements Runnable {
        private UpgradeTask() {
        }

        public void run() {
            long now = System.currentTimeMillis();
            Iterator it = TaskQueue.this.iterator();
            while (it.hasNext()) {
                E task = it.next();
                if (task instanceof BaseTask) {
                    ((BaseTask) task).upgrade(now);
                }
            }
        }
    }
}
