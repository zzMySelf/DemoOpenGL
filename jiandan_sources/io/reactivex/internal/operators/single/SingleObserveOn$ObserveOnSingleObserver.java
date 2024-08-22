package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import th.de.th;

public final class SingleObserveOn$ObserveOnSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, Runnable {
    public static final long serialVersionUID = 3528003840217436037L;
    public final SingleObserver<? super T> downstream;
    public Throwable error;
    public final th scheduler;
    public T value;

    public SingleObserveOn$ObserveOnSingleObserver(SingleObserver<? super T> singleObserver, th thVar) {
        this.downstream = singleObserver;
        this.scheduler = thVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
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
            this.downstream.onError(th2);
        } else {
            this.downstream.onSuccess(this.value);
        }
    }
}
