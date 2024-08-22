package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.schedulers.SchedulerRunnableIntrospection;
import java.util.concurrent.atomic.AtomicReference;

public final class ExecutorScheduler$DelayedRunnable extends AtomicReference<Runnable> implements Runnable, Disposable, SchedulerRunnableIntrospection {
    public static final long serialVersionUID = -4101336210206799084L;
    public final SequentialDisposable direct = new SequentialDisposable();
    public final SequentialDisposable timed = new SequentialDisposable();

    public ExecutorScheduler$DelayedRunnable(Runnable runnable) {
        super(runnable);
    }

    public void dispose() {
        if (getAndSet((Object) null) != null) {
            this.timed.dispose();
            this.direct.dispose();
        }
    }

    public Runnable getWrappedRunnable() {
        Runnable runnable = (Runnable) get();
        return runnable != null ? runnable : Functions.f9948ad;
    }

    public boolean isDisposed() {
        return get() == null;
    }

    public void run() {
        Runnable runnable = (Runnable) get();
        if (runnable != null) {
            try {
                runnable.run();
            } finally {
                lazySet((Object) null);
                this.timed.lazySet(DisposableHelper.DISPOSED);
                this.direct.lazySet(DisposableHelper.DISPOSED);
            }
        }
    }
}
