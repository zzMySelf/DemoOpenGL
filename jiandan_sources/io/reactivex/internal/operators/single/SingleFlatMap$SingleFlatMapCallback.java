package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleFlatMap$SingleFlatMapCallback<T, R> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
    public static final long serialVersionUID = 3258103020495908596L;
    public final SingleObserver<? super R> downstream;
    public final Function<? super T, ? extends SingleSource<? extends R>> mapper;

    public static final class qw<R> implements SingleObserver<R> {

        /* renamed from: ad  reason: collision with root package name */
        public final AtomicReference<Disposable> f10309ad;

        /* renamed from: th  reason: collision with root package name */
        public final SingleObserver<? super R> f10310th;

        public qw(AtomicReference<Disposable> atomicReference, SingleObserver<? super R> singleObserver) {
            this.f10309ad = atomicReference;
            this.f10310th = singleObserver;
        }

        public void onError(Throwable th2) {
            this.f10310th.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this.f10309ad, disposable);
        }

        public void onSuccess(R r) {
            this.f10310th.onSuccess(r);
        }
    }

    public SingleFlatMap$SingleFlatMapCallback(SingleObserver<? super R> singleObserver, Function<? super T, ? extends SingleSource<? extends R>> function) {
        this.downstream = singleObserver;
        this.mapper = function;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
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
            th.de.p039if.ad.qw.rg(apply, "The single returned by the mapper is null");
            SingleSource singleSource = (SingleSource) apply;
            if (!isDisposed()) {
                singleSource.qw(new qw(this, this.downstream));
            }
        } catch (Throwable th2) {
            th.de.o.qw.ad(th2);
            this.downstream.onError(th2);
        }
    }
}
