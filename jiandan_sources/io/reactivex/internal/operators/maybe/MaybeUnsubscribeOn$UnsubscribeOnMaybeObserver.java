package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import th.de.th;

public final class MaybeUnsubscribeOn$UnsubscribeOnMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable, Runnable {
    public static final long serialVersionUID = 3256698449646456986L;
    public final MaybeObserver<? super T> downstream;
    public Disposable ds;
    public final th scheduler;

    public MaybeUnsubscribeOn$UnsubscribeOnMaybeObserver(MaybeObserver<? super T> maybeObserver, th thVar) {
        this.downstream = maybeObserver;
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

    public void onComplete() {
        this.downstream.onComplete();
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
