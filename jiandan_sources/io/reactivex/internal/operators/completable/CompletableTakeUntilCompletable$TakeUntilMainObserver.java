package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import th.de.ppp.qw;

public final class CompletableTakeUntilCompletable$TakeUntilMainObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
    public static final long serialVersionUID = 3533011714830024923L;
    public final CompletableObserver downstream;
    public final AtomicBoolean once = new AtomicBoolean();
    public final OtherObserver other = new OtherObserver(this);

    public static final class OtherObserver extends AtomicReference<Disposable> implements CompletableObserver {
        public static final long serialVersionUID = 5176264485428790318L;
        public final CompletableTakeUntilCompletable$TakeUntilMainObserver parent;

        public OtherObserver(CompletableTakeUntilCompletable$TakeUntilMainObserver completableTakeUntilCompletable$TakeUntilMainObserver) {
            this.parent = completableTakeUntilCompletable$TakeUntilMainObserver;
        }

        public void onComplete() {
            this.parent.innerComplete();
        }

        public void onError(Throwable th2) {
            this.parent.innerError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public CompletableTakeUntilCompletable$TakeUntilMainObserver(CompletableObserver completableObserver) {
        this.downstream = completableObserver;
    }

    public void dispose() {
        if (this.once.compareAndSet(false, true)) {
            DisposableHelper.dispose(this);
            DisposableHelper.dispose(this.other);
        }
    }

    public void innerComplete() {
        if (this.once.compareAndSet(false, true)) {
            DisposableHelper.dispose(this);
            this.downstream.onComplete();
        }
    }

    public void innerError(Throwable th2) {
        if (this.once.compareAndSet(false, true)) {
            DisposableHelper.dispose(this);
            this.downstream.onError(th2);
            return;
        }
        qw.ddd(th2);
    }

    public boolean isDisposed() {
        return this.once.get();
    }

    public void onComplete() {
        if (this.once.compareAndSet(false, true)) {
            DisposableHelper.dispose(this.other);
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable th2) {
        if (this.once.compareAndSet(false, true)) {
            DisposableHelper.dispose(this.other);
            this.downstream.onError(th2);
            return;
        }
        qw.ddd(th2);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }
}
