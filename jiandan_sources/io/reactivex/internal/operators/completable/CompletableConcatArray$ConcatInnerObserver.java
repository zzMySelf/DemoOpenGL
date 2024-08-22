package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableConcatArray$ConcatInnerObserver extends AtomicInteger implements CompletableObserver {
    public static final long serialVersionUID = -7965400327305809232L;
    public final CompletableObserver downstream;
    public int index;
    public final SequentialDisposable sd = new SequentialDisposable();
    public final CompletableSource[] sources;

    public CompletableConcatArray$ConcatInnerObserver(CompletableObserver completableObserver, CompletableSource[] completableSourceArr) {
        this.downstream = completableObserver;
        this.sources = completableSourceArr;
    }

    public void next() {
        if (!this.sd.isDisposed() && getAndIncrement() == 0) {
            CompletableSource[] completableSourceArr = this.sources;
            while (!this.sd.isDisposed()) {
                int i2 = this.index;
                this.index = i2 + 1;
                if (i2 == completableSourceArr.length) {
                    this.downstream.onComplete();
                    return;
                }
                completableSourceArr[i2].qw(this);
                if (decrementAndGet() == 0) {
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
