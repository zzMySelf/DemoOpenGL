package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import th.de.th;

public final class MaybeObserveOn$ObserveOnMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable, Runnable {
    public static final long serialVersionUID = 8571289934935992137L;
    public final MaybeObserver<? super T> downstream;
    public Throwable error;
    public final th scheduler;
    public T value;

    public MaybeObserveOn$ObserveOnMaybeObserver(MaybeObserver<? super T> maybeObserver, th thVar) {
        this.downstream = maybeObserver;
        this.scheduler = thVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    public void onComplete() {
        DisposableHelper.replace(this, this.scheduler.de(this));
    }

    public void onError(Throwable th2) {
        this.error = th2;
        DisposableHelper.replace(this, this.scheduler.de(this));
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this, disposable)) {
            this.downstream.onSubscribe(this);
        }
    }

    public void onSuccess(T t) {
        this.value = t;
        DisposableHelper.replace(this, this.scheduler.de(this));
    }

    public void run() {
        Throwable th2 = this.error;
        if (th2 != null) {
            this.error = null;
            this.downstream.onError(th2);
            return;
        }
        T t = this.value;
        if (t != null) {
            this.value = null;
            this.downstream.onSuccess(t);
            return;
        }
        this.downstream.onComplete();
    }
}
