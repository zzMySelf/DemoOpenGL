package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleTimer$TimerDisposable extends AtomicReference<Disposable> implements Disposable, Runnable {
    public static final long serialVersionUID = 8465401857522493082L;
    public final SingleObserver<? super Long> downstream;

    public SingleTimer$TimerDisposable(SingleObserver<? super Long> singleObserver) {
        this.downstream = singleObserver;
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
