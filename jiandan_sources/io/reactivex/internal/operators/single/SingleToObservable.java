package io.reactivex.internal.operators.single;

import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import th.de.rg;

public final class SingleToObservable<T> extends rg<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final SingleSource<? extends T> f10312ad;

    public static final class SingleToObservableObserver<T> extends DeferredScalarDisposable<T> implements SingleObserver<T> {
        public static final long serialVersionUID = 3786543492451018833L;
        public Disposable upstream;

        public SingleToObservableObserver(Observer<? super T> observer) {
            super(observer);
        }

        public void dispose() {
            super.dispose();
            this.upstream.dispose();
        }

        public void onError(Throwable th2) {
            error(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            complete(t);
        }
    }

    public SingleToObservable(SingleSource<? extends T> singleSource) {
        this.f10312ad = singleSource;
    }

    public static <T> SingleObserver<T> ad(Observer<? super T> observer) {
        return new SingleToObservableObserver(observer);
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f10312ad.qw(ad(observer));
    }
}
