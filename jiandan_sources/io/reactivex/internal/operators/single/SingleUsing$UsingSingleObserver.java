package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import th.de.o.qw;

public final class SingleUsing$UsingSingleObserver<T, U> extends AtomicReference<Object> implements SingleObserver<T>, Disposable {
    public static final long serialVersionUID = -5331524057054083935L;
    public final Consumer<? super U> disposer;
    public final SingleObserver<? super T> downstream;
    public final boolean eager;
    public Disposable upstream;

    public SingleUsing$UsingSingleObserver(SingleObserver<? super T> singleObserver, U u, boolean z, Consumer<? super U> consumer) {
        super(u);
        this.downstream = singleObserver;
        this.eager = z;
        this.disposer = consumer;
    }

    public void dispose() {
        this.upstream.dispose();
        this.upstream = DisposableHelper.DISPOSED;
        disposeAfter();
    }

    public void disposeAfter() {
        Object andSet = getAndSet(this);
        if (andSet != this) {
            try {
                this.disposer.accept(andSet);
            } catch (Throwable th2) {
                qw.ad(th2);
                th.de.ppp.qw.ddd(th2);
            }
        }
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onError(Throwable th2) {
        this.upstream = DisposableHelper.DISPOSED;
        if (this.eager) {
            Object andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.disposer.accept(andSet);
                } catch (Throwable th3) {
                    qw.ad(th3);
                    th2 = new CompositeException(th2, th3);
                }
            } else {
                return;
            }
        }
        this.downstream.onError(th2);
        if (!this.eager) {
            disposeAfter();
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.upstream, disposable)) {
            this.upstream = disposable;
            this.downstream.onSubscribe(this);
        }
    }

    public void onSuccess(T t) {
        this.upstream = DisposableHelper.DISPOSED;
        if (this.eager) {
            Object andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.disposer.accept(andSet);
                } catch (Throwable th2) {
                    qw.ad(th2);
                    this.downstream.onError(th2);
                    return;
                }
            } else {
                return;
            }
        }
        this.downstream.onSuccess(t);
        if (!this.eager) {
            disposeAfter();
        }
    }
}
