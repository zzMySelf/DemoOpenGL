package io.reactivex.internal.operators.observable;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p039if.fe.rg.qw;
import th.de.rg;

public final class ObservableConcatWithMaybe<T> extends qw<T, T> {

    /* renamed from: th  reason: collision with root package name */
    public final MaybeSource<? extends T> f10077th;

    public static final class ConcatWithObserver<T> extends AtomicReference<Disposable> implements Observer<T>, MaybeObserver<T>, Disposable {
        public static final long serialVersionUID = -1953724749712440952L;
        public final Observer<? super T> downstream;
        public boolean inMaybe;
        public MaybeSource<? extends T> other;

        public ConcatWithObserver(Observer<? super T> observer, MaybeSource<? extends T> maybeSource) {
            this.downstream = observer;
            this.other = maybeSource;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            if (this.inMaybe) {
                this.downstream.onComplete();
                return;
            }
            this.inMaybe = true;
            DisposableHelper.replace(this, (Disposable) null);
            MaybeSource<? extends T> maybeSource = this.other;
            this.other = null;
            maybeSource.qw(this);
        }

        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable) && !this.inMaybe) {
                this.downstream.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.downstream.onNext(t);
            this.downstream.onComplete();
        }
    }

    public ObservableConcatWithMaybe(rg<T> rgVar, MaybeSource<? extends T> maybeSource) {
        super(rgVar);
        this.f10077th = maybeSource;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f10756ad.subscribe(new ConcatWithObserver(observer, this.f10077th));
    }
}
