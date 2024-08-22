package io.reactivex.internal.operators.single;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p039if.de.Cswitch;

public final class SingleDelayWithCompletable$OtherObserver<T> extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
    public static final long serialVersionUID = -8565274649390031272L;
    public final SingleObserver<? super T> downstream;
    public final SingleSource<T> source;

    public SingleDelayWithCompletable$OtherObserver(SingleObserver<? super T> singleObserver, SingleSource<T> singleSource) {
        this.downstream = singleObserver;
        this.source = singleSource;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    public void onComplete() {
        this.source.qw(new Cswitch(this, this.downstream));
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
