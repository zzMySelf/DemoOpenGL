package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import th.de.ppp.qw;

public final class MaybeCreate$Emitter<T> extends AtomicReference<Disposable> implements MaybeEmitter<T>, Disposable {
    public static final long serialVersionUID = -2467358622224974244L;
    public final MaybeObserver<? super T> downstream;

    public MaybeCreate$Emitter(MaybeObserver<? super T> maybeObserver) {
        this.downstream = maybeObserver;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    public void onComplete() {
        Disposable disposable;
        Object obj = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (obj != disposableHelper && (disposable = (Disposable) getAndSet(disposableHelper)) != DisposableHelper.DISPOSED) {
            try {
                this.downstream.onComplete();
            } finally {
                if (disposable != null) {
                    disposable.dispose();
                }
            }
        }
    }

    public void onError(Throwable th2) {
        if (!tryOnError(th2)) {
            qw.ddd(th2);
        }
    }

    public void onSuccess(T t) {
        Disposable disposable;
        Object obj = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (obj != disposableHelper && (disposable = (Disposable) getAndSet(disposableHelper)) != DisposableHelper.DISPOSED) {
            if (t == null) {
                try {
                    this.downstream.onError(new NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources."));
                } catch (Throwable th2) {
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    throw th2;
                }
            } else {
                this.downstream.onSuccess(t);
            }
            if (disposable != null) {
                disposable.dispose();
            }
        }
    }

    public void setCancellable(Cancellable cancellable) {
        setDisposable(new CancellableDisposable(cancellable));
    }

    public void setDisposable(Disposable disposable) {
        DisposableHelper.set(this, disposable);
    }

    public String toString() {
        return String.format("%s{%s}", new Object[]{MaybeCreate$Emitter.class.getSimpleName(), super.toString()});
    }

    public boolean tryOnError(Throwable th2) {
        Disposable disposable;
        if (th2 == null) {
            th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        Object obj = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (obj == disposableHelper || (disposable = (Disposable) getAndSet(disposableHelper)) == DisposableHelper.DISPOSED) {
            return false;
        }
        try {
            this.downstream.onError(th2);
        } finally {
            if (disposable != null) {
                disposable.dispose();
            }
        }
    }
}
