package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import th.de.ppp.qw;

public final class SingleTakeUntil$TakeUntilMainObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
    public static final long serialVersionUID = -622603812305745221L;
    public final SingleObserver<? super T> downstream;
    public final SingleTakeUntil$TakeUntilOtherSubscriber other = new SingleTakeUntil$TakeUntilOtherSubscriber(this);

    public SingleTakeUntil$TakeUntilMainObserver(SingleObserver<? super T> singleObserver) {
        this.downstream = singleObserver;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
        this.other.dispose();
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    public void onError(Throwable th2) {
        this.other.dispose();
        Disposable disposable = (Disposable) get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable == disposableHelper || ((Disposable) getAndSet(disposableHelper)) == DisposableHelper.DISPOSED) {
            qw.ddd(th2);
        } else {
            this.downstream.onError(th2);
        }
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }

    public void onSuccess(T t) {
        this.other.dispose();
        if (((Disposable) getAndSet(DisposableHelper.DISPOSED)) != DisposableHelper.DISPOSED) {
            this.downstream.onSuccess(t);
        }
    }

    public void otherError(Throwable th2) {
        Disposable disposable;
        Disposable disposable2 = (Disposable) get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable2 == disposableHelper || (disposable = (Disposable) getAndSet(disposableHelper)) == DisposableHelper.DISPOSED) {
            qw.ddd(th2);
            return;
        }
        if (disposable != null) {
            disposable.dispose();
        }
        this.downstream.onError(th2);
    }
}
