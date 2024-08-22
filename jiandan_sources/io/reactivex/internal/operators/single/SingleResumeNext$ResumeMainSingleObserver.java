package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p039if.ad.qw;
import th.de.p039if.de.Cswitch;

public final class SingleResumeNext$ResumeMainSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
    public static final long serialVersionUID = -5314538511045349925L;
    public final SingleObserver<? super T> downstream;
    public final Function<? super Throwable, ? extends SingleSource<? extends T>> nextFunction;

    public SingleResumeNext$ResumeMainSingleObserver(SingleObserver<? super T> singleObserver, Function<? super Throwable, ? extends SingleSource<? extends T>> function) {
        this.downstream = singleObserver;
        this.nextFunction = function;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    public void onError(Throwable th2) {
        try {
            Object apply = this.nextFunction.apply(th2);
            qw.rg(apply, "The nextFunction returned a null SingleSource.");
            ((SingleSource) apply).qw(new Cswitch(this, this.downstream));
        } catch (Throwable th3) {
            th.de.o.qw.ad(th3);
            this.downstream.onError(new CompositeException(th2, th3));
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this, disposable)) {
            this.downstream.onSubscribe(this);
        }
    }

    public void onSuccess(T t) {
        this.downstream.onSuccess(t);
    }
}
