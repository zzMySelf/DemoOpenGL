package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import th.de.p039if.ad.qw;

public final class CompletableConcatIterable$ConcatInnerObserver extends AtomicInteger implements CompletableObserver {
    public static final long serialVersionUID = -7965400327305809232L;
    public final CompletableObserver downstream;
    public final SequentialDisposable sd = new SequentialDisposable();
    public final Iterator<? extends CompletableSource> sources;

    public CompletableConcatIterable$ConcatInnerObserver(CompletableObserver completableObserver, Iterator<? extends CompletableSource> it) {
        this.downstream = completableObserver;
        this.sources = it;
    }

    public void next() {
        if (!this.sd.isDisposed() && getAndIncrement() == 0) {
            Iterator<? extends CompletableSource> it = this.sources;
            while (!this.sd.isDisposed()) {
                try {
                    if (!it.hasNext()) {
                        this.downstream.onComplete();
                        return;
                    }
                    try {
                        Object next = it.next();
                        qw.rg(next, "The CompletableSource returned is null");
                        ((CompletableSource) next).qw(this);
                        if (decrementAndGet() == 0) {
                            return;
                        }
                    } catch (Throwable th2) {
                        th.de.o.qw.ad(th2);
                        this.downstream.onError(th2);
                        return;
                    }
                } catch (Throwable th3) {
                    th.de.o.qw.ad(th3);
                    this.downstream.onError(th3);
                    return;
                }
            }
        }
    }

    public void onComplete() {
        next();
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onSubscribe(Disposable disposable) {
        this.sd.replace(disposable);
    }
}
