package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p039if.ad.qw;
import th.de.p039if.fe.de.de;

public final class MaybeFlatMapSingleElement$FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
    public static final long serialVersionUID = 4827726964688405508L;
    public final MaybeObserver<? super R> downstream;
    public final Function<? super T, ? extends SingleSource<? extends R>> mapper;

    public MaybeFlatMapSingleElement$FlatMapMaybeObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends SingleSource<? extends R>> function) {
        this.downstream = maybeObserver;
        this.mapper = function;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    public void onComplete() {
        this.downstream.onComplete();
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
            ((SingleSource) apply).qw(new de(this, this.downstream));
        } catch (Throwable th2) {
            th.de.o.qw.ad(th2);
            onError(th2);
        }
    }
}
