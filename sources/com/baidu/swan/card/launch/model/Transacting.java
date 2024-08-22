package com.baidu.swan.card.launch.model;

import java.util.ArrayDeque;
import java.util.Queue;

public class Transacting {
    private Runnable mCurrent = null;
    private boolean mTmpTransacting = false;
    private final Queue<Runnable> mTransactions = new ArrayDeque();

    public synchronized boolean transact(Runnable transaction) {
        boolean z;
        z = true;
        boolean empty = transaction == null;
        if (!empty) {
            this.mTransactions.offer(transaction);
        }
        boolean exec = this.mCurrent == null && !this.mTransactions.isEmpty();
        if (exec) {
            while (!this.mTransactions.isEmpty()) {
                Runnable poll = this.mTransactions.poll();
                this.mCurrent = poll;
                if (poll != null) {
                    poll.run();
                }
                this.mCurrent = null;
            }
        }
        if (empty || !exec) {
            z = false;
        }
        return z;
    }

    public synchronized boolean acquireTmpTransact() {
        boolean acquired;
        acquired = idle();
        this.mTmpTransacting = true;
        return acquired;
    }

    public synchronized void endTmpTransact() {
        this.mTmpTransacting = false;
        exec();
    }

    private boolean idle() {
        return !this.mTmpTransacting && this.mCurrent == null;
    }

    private synchronized boolean exec() {
        boolean exec;
        exec = idle();
        if (exec) {
            while (!this.mTransactions.isEmpty()) {
                Runnable poll = this.mTransactions.poll();
                this.mCurrent = poll;
                if (poll != null) {
                    poll.run();
                }
            }
            this.mCurrent = null;
        }
        return exec;
    }
}
