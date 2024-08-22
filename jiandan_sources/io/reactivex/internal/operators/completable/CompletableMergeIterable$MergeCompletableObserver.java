package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import th.de.i.qw;

public final class CompletableMergeIterable$MergeCompletableObserver extends AtomicBoolean implements CompletableObserver {
    public static final long serialVersionUID = -7730517613164279224L;
    public final CompletableObserver downstream;
    public final qw set;
    public final AtomicInteger wip;

    public CompletableMergeIterable$MergeCompletableObserver(CompletableObserver completableObserver, qw qwVar, AtomicInteger atomicInteger) {
        this.downstream = completableObserver;
        this.set = qwVar;
        this.wip = atomicInteger;
    }

    public void onComplete() {
        if (this.wip.decrementAndGet() == 0 && compareAndSet(false, true)) {
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable th2) {
        this.set.dispose();
        if (compareAndSet(false, true)) {
            this.downstream.onError(th2);
        } else {
            th.de.ppp.qw.ddd(th2);
        }
    }

    public void onSubscribe(Disposable disposable) {
        this.set.ad(disposable);
    }
}
