package io.reactivex.internal.operators.maybe;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p039if.fe.de.qw;

public final class MaybeDelayWithCompletable$OtherObserver<T> extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
    public static final long serialVersionUID = 703409937383992161L;
    public final MaybeObserver<? super T> downstream;
    public final MaybeSource<T> source;

    public MaybeDelayWithCompletable$OtherObserver(MaybeObserver<? super T> maybeObserver, MaybeSource<T> maybeSource) {
        this.downstream = maybeObserver;
        this.source = maybeSource;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    public void onComplete() {
        this.source.qw(new qw(this, this.downstream));
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this, disposable)) {
            this.downstream.onSubscribe(this);
        }
    }
}
