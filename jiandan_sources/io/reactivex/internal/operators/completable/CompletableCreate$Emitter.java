package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import th.de.ppp.qw;

public final class CompletableCreate$Emitter extends AtomicReference<Disposable> implements CompletableEmitter, Disposable {
    public static final long serialVersionUID = -2467358622224974244L;
    public final CompletableObserver downstream;

    public CompletableCreate$Emitter(CompletableObserver completableObserver) {
        this.downstream = completableObserver;
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

    public void setCancellable(Cancellable cancellable) {
        setDisposable(new CancellableDisposable(cancellable));
    }

    public void setDisposable(Disposable disposable) {
        DisposableHelper.set(this, disposable);
    }

    public String toString() {
        return String.format("%s{%s}", new Object[]{CompletableCreate$Emitter.class.getSimpleName(), super.toString()});
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
