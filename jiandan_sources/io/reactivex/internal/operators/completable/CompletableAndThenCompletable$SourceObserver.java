package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p039if.fe.qw.qw;

public final class CompletableAndThenCompletable$SourceObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
    public static final long serialVersionUID = -4101678820158072998L;
    public final CompletableObserver actualObserver;
    public final CompletableSource next;

    public CompletableAndThenCompletable$SourceObserver(CompletableObserver completableObserver, CompletableSource completableSource) {
        this.actualObserver = completableObserver;
        this.next = completableSource;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    public void onComplete() {
        this.next.qw(new qw(this, this.actualObserver));
    }

    public void onError(Throwable th2) {
        this.actualObserver.onError(th2);
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this, disposable)) {
            this.actualObserver.onSubscribe(this);
        }
    }
}
