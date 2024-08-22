package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import th.de.rg;

public final class MaybeToObservable<T> extends rg<T> implements HasUpstreamMaybeSource<T> {

    public static final class MaybeToObservableObserver<T> extends DeferredScalarDisposable<T> implements MaybeObserver<T> {
        public static final long serialVersionUID = 7603343402964826922L;
        public Disposable upstream;

        public MaybeToObservableObserver(Observer<? super T> observer) {
            super(observer);
        }

        public void dispose() {
            super.dispose();
            this.upstream.dispose();
        }

        public void onComplete() {
            complete();
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

    public static <T> MaybeObserver<T> ad(Observer<? super T> observer) {
        return new MaybeToObservableObserver(observer);
    }
}
