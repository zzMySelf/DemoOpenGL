package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableTimer$TimerDisposable extends AtomicReference<Disposable> implements Disposable, Runnable {
    public static final long serialVersionUID = 3167244060586201109L;
    public final CompletableObserver downstream;

    public CompletableTimer$TimerDisposable(CompletableObserver completableObserver) {
        this.downstream = completableObserver;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    public void run() {
        this.downstream.onComplete();
    }

    public void setFuture(Disposable disposable) {
        DisposableHelper.replace(this, disposable);
    }
}
