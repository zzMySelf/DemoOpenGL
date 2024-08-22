package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import th.de.o.qw;

public final class SingleDoOnDispose$DoOnDisposeObserver<T> extends AtomicReference<Action> implements SingleObserver<T>, Disposable {
    public static final long serialVersionUID = -8583764624474935784L;
    public final SingleObserver<? super T> downstream;
    public Disposable upstream;

    public SingleDoOnDispose$DoOnDisposeObserver(SingleObserver<? super T> singleObserver, Action action) {
        this.downstream = singleObserver;
        lazySet(action);
    }

    public void dispose() {
        Action action = (Action) getAndSet((Object) null);
        if (action != null) {
            try {
                action.run();
            } catch (Throwable th2) {
                qw.ad(th2);
                th.de.ppp.qw.ddd(th2);
            }
            this.upstream.dispose();
        }
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.upstream, disposable)) {
            this.upstream = disposable;
            this.downstream.onSubscribe(this);
        }
    }

    public void onSuccess(T t) {
        this.downstream.onSuccess(t);
    }
}
