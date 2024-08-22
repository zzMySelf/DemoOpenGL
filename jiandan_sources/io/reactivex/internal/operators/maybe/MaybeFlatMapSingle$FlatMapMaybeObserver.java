package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p039if.ad.qw;
import th.de.p039if.fe.de.ad;

public final class MaybeFlatMapSingle$FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
    public static final long serialVersionUID = 4827726964688405508L;
    public final SingleObserver<? super R> downstream;
    public final Function<? super T, ? extends SingleSource<? extends R>> mapper;

    public MaybeFlatMapSingle$FlatMapMaybeObserver(SingleObserver<? super R> singleObserver, Function<? super T, ? extends SingleSource<? extends R>> function) {
        this.downstream = singleObserver;
        this.mapper = function;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    public void onComplete() {
        this.downstream.onError(new NoSuchElementException());
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this, disposable)) {
            this.downstream.onSubscribe(this);
        }
    }

    public void onSuccess(T t) {
        try {
            Object apply = this.mapper.apply(t);
            qw.rg(apply, "The mapper returned a null SingleSource");
            SingleSource singleSource = (SingleSource) apply;
            if (!isDisposed()) {
                singleSource.qw(new ad(this, this.downstream));
            }
        } catch (Throwable th2) {
            th.de.o.qw.ad(th2);
            onError(th2);
        }
    }
}
