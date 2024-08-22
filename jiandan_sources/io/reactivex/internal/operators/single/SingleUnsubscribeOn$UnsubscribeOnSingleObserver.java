package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import th.de.th;

public final class SingleUnsubscribeOn$UnsubscribeOnSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, Runnable {
    public static final long serialVersionUID = 3256698449646456986L;
    public final SingleObserver<? super T> downstream;
    public Disposable ds;
    public final th scheduler;

    public SingleUnsubscribeOn$UnsubscribeOnSingleObserver(SingleObserver<? super T> singleObserver, th thVar) {
        this.downstream = singleObserver;
        this.scheduler = thVar;
    }

    public void dispose() {
        Disposable disposable = (Disposable) getAndSet(DisposableHelper.DISPOSED);
        if (disposable != DisposableHelper.DISPOSED) {
            this.ds = disposable;
            this.scheduler.de(this);
        }
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this, disposable)) {
            this.downstream.onSubscribe(this);
        }
    }

    public void onSuccess(T t) {
        this.downstream.onSuccess(t);
    }

    public void run() {
        this.ds.dispose();
    }
}
