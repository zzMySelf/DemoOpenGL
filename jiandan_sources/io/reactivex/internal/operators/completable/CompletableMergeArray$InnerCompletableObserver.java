package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import th.de.i.qw;

public final class CompletableMergeArray$InnerCompletableObserver extends AtomicInteger implements CompletableObserver {
    public static final long serialVersionUID = -8360547806504310570L;
    public final CompletableObserver downstream;
    public final AtomicBoolean once;
    public final qw set;

    public CompletableMergeArray$InnerCompletableObserver(CompletableObserver completableObserver, AtomicBoolean atomicBoolean, qw qwVar, int i2) {
        this.downstream = completableObserver;
        this.once = atomicBoolean;
        this.set = qwVar;
        lazySet(i2);
    }

    public void onComplete() {
        if (decrementAndGet() == 0 && this.once.compareAndSet(false, true)) {
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable th2) {
        this.set.dispose();
        if (this.once.compareAndSet(false, true)) {
            this.downstream.onError(th2);
        } else {
            th.de.ppp.qw.ddd(th2);
        }
    }

    public void onSubscribe(Disposable disposable) {
        this.set.ad(disposable);
    }
}
