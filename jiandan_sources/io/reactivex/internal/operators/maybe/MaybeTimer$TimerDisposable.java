package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeTimer$TimerDisposable extends AtomicReference<Disposable> implements Disposable, Runnable {
    public static final long serialVersionUID = 2875964065294031672L;
    public final MaybeObserver<? super Long> downstream;

    public MaybeTimer$TimerDisposable(MaybeObserver<? super Long> maybeObserver) {
        this.downstream = maybeObserver;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    public void run() {
        this.downstream.onSuccess(0L);
    }

    public void setFuture(Disposable disposable) {
        DisposableHelper.replace(this, disposable);
    }
}
