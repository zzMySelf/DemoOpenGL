package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import th.de.th;

public final class CompletableDelay$Delay extends AtomicReference<Disposable> implements CompletableObserver, Runnable, Disposable {
    public static final long serialVersionUID = 465972761105851022L;
    public final long delay;
    public final boolean delayError;
    public final CompletableObserver downstream;
    public Throwable error;
    public final th scheduler;
    public final TimeUnit unit;

    public CompletableDelay$Delay(CompletableObserver completableObserver, long j, TimeUnit timeUnit, th thVar, boolean z) {
        this.downstream = completableObserver;
        this.delay = j;
        this.unit = timeUnit;
        this.scheduler = thVar;
        this.delayError = z;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    public void onComplete() {
        DisposableHelper.replace(this, this.scheduler.fe(this, this.delay, this.unit));
    }

    public void onError(Throwable th2) {
        this.error = th2;
        DisposableHelper.replace(this, this.scheduler.fe(this, this.delayError ? this.delay : 0, this.unit));
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this, disposable)) {
            this.downstream.onSubscribe(this);
        }
    }

    public void run() {
        Throwable th2 = this.error;
        this.error = null;
        if (th2 != null) {
            this.downstream.onError(th2);
        } else {
            this.downstream.onComplete();
        }
    }
}
