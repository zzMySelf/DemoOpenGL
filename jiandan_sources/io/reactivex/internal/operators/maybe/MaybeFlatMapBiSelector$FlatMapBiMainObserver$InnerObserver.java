package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p039if.ad.qw;

public final class MaybeFlatMapBiSelector$FlatMapBiMainObserver$InnerObserver<T, U, R> extends AtomicReference<Disposable> implements MaybeObserver<U> {
    public static final long serialVersionUID = -2897979525538174559L;
    public final MaybeObserver<? super R> downstream;
    public final BiFunction<? super T, ? super U, ? extends R> resultSelector;
    public T value;

    public MaybeFlatMapBiSelector$FlatMapBiMainObserver$InnerObserver(MaybeObserver<? super R> maybeObserver, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        this.downstream = maybeObserver;
        this.resultSelector = biFunction;
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }

    public void onSuccess(U u) {
        T t = this.value;
        this.value = null;
        try {
            Object apply = this.resultSelector.apply(t, u);
            qw.rg(apply, "The resultSelector returned a null value");
            this.downstream.onSuccess(apply);
        } catch (Throwable th2) {
            th.de.o.qw.ad(th2);
            this.downstream.onError(th2);
        }
    }
}
