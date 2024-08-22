package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import java.util.concurrent.atomic.AtomicInteger;

public final class ExecutorScheduler$ExecutorWorker$InterruptibleRunnable extends AtomicInteger implements Runnable, Disposable {
    public static final int FINISHED = 2;
    public static final int INTERRUPTED = 4;
    public static final int INTERRUPTING = 3;
    public static final int READY = 0;
    public static final int RUNNING = 1;
    public static final long serialVersionUID = -3603436687413320876L;
    public final Runnable run;
    public final DisposableContainer tasks;
    public volatile Thread thread;

    public ExecutorScheduler$ExecutorWorker$InterruptibleRunnable(Runnable runnable, DisposableContainer disposableContainer) {
        this.run = runnable;
        this.tasks = disposableContainer;
    }

    public void cleanup() {
        DisposableContainer disposableContainer = this.tasks;
        if (disposableContainer != null) {
            disposableContainer.de(this);
        }
    }

    public void dispose() {
        while (true) {
            int i2 = get();
            if (i2 < 2) {
                if (i2 == 0) {
                    if (compareAndSet(0, 4)) {
                        cleanup();
                        return;
                    }
                } else if (compareAndSet(1, 3)) {
                    Thread thread2 = this.thread;
                    if (thread2 != null) {
                        thread2.interrupt();
                        this.thread = null;
                    }
                    set(4);
                    cleanup();
                    return;
                }
            } else {
                return;
            }
        }
    }

    public boolean isDisposed() {
        return get() >= 2;
    }

    public void run() {
        if (get() == 0) {
            this.thread = Thread.currentThread();
            if (compareAndSet(0, 1)) {
                try {
                    this.run.run();
                    this.thread = null;
                    if (compareAndSet(1, 2)) {
                        cleanup();
                        return;
                    }
                    while (get() == 3) {
                        Thread.yield();
                    }
                    Thread.interrupted();
                } catch (Throwable th2) {
                    this.thread = null;
                    if (!compareAndSet(1, 2)) {
                        while (get() == 3) {
                            Thread.yield();
                        }
                        Thread.interrupted();
                    } else {
                        cleanup();
                    }
                    throw th2;
                }
            } else {
                this.thread = null;
            }
        }
    }
}
