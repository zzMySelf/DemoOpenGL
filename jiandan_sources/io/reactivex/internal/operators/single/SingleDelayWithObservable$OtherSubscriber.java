package io.reactivex.internal.operators.single;

import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p039if.de.Cswitch;
import th.de.ppp.qw;

public final class SingleDelayWithObservable$OtherSubscriber<T, U> extends AtomicReference<Disposable> implements Observer<U>, Disposable {
    public static final long serialVersionUID = -8565274649390031272L;
    public boolean done;
    public final SingleObserver<? super T> downstream;
    public final SingleSource<T> source;

    public SingleDelayWithObservable$OtherSubscriber(SingleObserver<? super T> singleObserver, SingleSource<T> singleSource) {
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
        if (!this.done) {
            this.done = true;
            this.source.qw(new Cswitch(this, this.downstream));
        }
    }

    public void onError(Throwable th2) {
        if (this.done) {
            qw.ddd(th2);
            return;
        }
        this.done = true;
        this.downstream.onError(th2);
    }

    public void onNext(U u) {
        ((Disposable) get()).dispose();
        onComplete();
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.set(this, disposable)) {
            this.downstream.onSubscribe(this);
        }
    }
}
