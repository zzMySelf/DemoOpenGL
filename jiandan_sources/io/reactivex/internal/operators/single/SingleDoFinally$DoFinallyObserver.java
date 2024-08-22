package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
import th.de.o.qw;

public final class SingleDoFinally$DoFinallyObserver<T> extends AtomicInteger implements SingleObserver<T>, Disposable {
    public static final long serialVersionUID = 4109457741734051389L;
    public final SingleObserver<? super T> downstream;
    public final Action onFinally;
    public Disposable upstream;

    public SingleDoFinally$DoFinallyObserver(SingleObserver<? super T> singleObserver, Action action) {
        this.downstream = singleObserver;
        this.onFinally = action;
    }

    public void dispose() {
        this.upstream.dispose();
        runFinally();
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
        runFinally();
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.upstream, disposable)) {
            this.upstream = disposable;
            this.downstream.onSubscribe(this);
        }
    }

    public void onSuccess(T t) {
        this.downstream.onSuccess(t);
        runFinally();
    }

    public void runFinally() {
        if (compareAndSet(0, 1)) {
            try {
                this.onFinally.run();
            } catch (Throwable th2) {
                qw.ad(th2);
                th.de.ppp.qw.ddd(th2);
            }
        }
    }
}
