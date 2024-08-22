package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import th.de.th;

public final class CompletableObserveOn$ObserveOnCompletableObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable, Runnable {
    public static final long serialVersionUID = 8571289934935992137L;
    public final CompletableObserver downstream;
    public Throwable error;
    public final th scheduler;

    public CompletableObserveOn$ObserveOnCompletableObserver(CompletableObserver completableObserver, th thVar) {
        this.downstream = completableObserver;
        this.scheduler = thVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    public void onComplete() {
        DisposableHelper.replace(this, this.scheduler.de(this));
    }

    public void onError(Throwable th2) {
        this.error = th2;
        DisposableHelper.replace(this, this.scheduler.de(this));
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this, disposable)) {
            this.downstream.onSubscribe(this);
        }
    }

    public void run() {
        Throwable th2 = this.error;
        if (th2 != null) {
            this.error = null;
            this.downstream.onError(th2);
            return;
        }
        this.downstream.onComplete();
    }
}
