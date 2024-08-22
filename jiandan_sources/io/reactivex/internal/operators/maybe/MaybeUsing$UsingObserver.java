package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import th.de.o.qw;

public final class MaybeUsing$UsingObserver<T, D> extends AtomicReference<Object> implements MaybeObserver<T>, Disposable {
    public static final long serialVersionUID = -674404550052917487L;
    public final Consumer<? super D> disposer;
    public final MaybeObserver<? super T> downstream;
    public final boolean eager;
    public Disposable upstream;

    public MaybeUsing$UsingObserver(MaybeObserver<? super T> maybeObserver, D d, Consumer<? super D> consumer, boolean z) {
        super(d);
        this.downstream = maybeObserver;
        this.disposer = consumer;
        this.eager = z;
    }

    public void dispose() {
        this.upstream.dispose();
        this.upstream = DisposableHelper.DISPOSED;
        disposeResourceAfter();
    }

    public void disposeResourceAfter() {
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

    public void onComplete() {
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
        this.downstream.onComplete();
        if (!this.eager) {
            disposeResourceAfter();
        }
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
            disposeResourceAfter();
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
            disposeResourceAfter();
        }
    }
}
