package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ExecutorScheduler$ExecutorWorker$BooleanRunnable extends AtomicBoolean implements Runnable, Disposable {
    public static final long serialVersionUID = -2421395018820541164L;
    public final Runnable actual;

    public ExecutorScheduler$ExecutorWorker$BooleanRunnable(Runnable runnable) {
        this.actual = runnable;
    }

    public void dispose() {
        lazySet(true);
    }

    public boolean isDisposed() {
        return get();
    }

    public void run() {
        if (!get()) {
            try {
                this.actual.run();
            } finally {
                lazySet(true);
            }
        }
    }
}
