package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import th.de.th;

public final class MaybeDelay$DelayMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable, Runnable {
    public static final long serialVersionUID = 5566860102500855068L;
    public final long delay;
    public final MaybeObserver<? super T> downstream;
    public Throwable error;
    public final th scheduler;
    public final TimeUnit unit;
    public T value;

    public MaybeDelay$DelayMaybeObserver(MaybeObserver<? super T> maybeObserver, long j, TimeUnit timeUnit, th thVar) {
        this.downstream = maybeObserver;
        this.delay = j;
        this.unit = timeUnit;
        this.scheduler = thVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    public void onComplete() {
        schedule();
    }

    public void onError(Throwable th2) {
        this.error = th2;
        schedule();
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this, disposable)) {
            this.downstream.onSubscribe(this);
        }
    }

    public void onSuccess(T t) {
        this.value = t;
        schedule();
    }

    public void run() {
        Throwable th2 = this.error;
        if (th2 != null) {
            this.downstream.onError(th2);
            return;
        }
        T t = this.value;
        if (t != null) {
            this.downstream.onSuccess(t);
        } else {
            this.downstream.onComplete();
        }
    }

    public void schedule() {
        DisposableHelper.replace(this, this.scheduler.fe(this, this.delay, this.unit));
    }
}
