package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import th.de.when.fe;

public final class ObservableWithLatestFrom<T, U, R> extends th.de.p039if.fe.rg.qw<T, R> {

    /* renamed from: th  reason: collision with root package name */
    public final BiFunction<? super T, ? super U, ? extends R> f10289th;

    /* renamed from: yj  reason: collision with root package name */
    public final ObservableSource<? extends U> f10290yj;

    public static final class WithLatestFromObserver<T, U, R> extends AtomicReference<U> implements Observer<T>, Disposable {
        public static final long serialVersionUID = -312246233408980075L;
        public final BiFunction<? super T, ? super U, ? extends R> combiner;
        public final Observer<? super R> downstream;
        public final AtomicReference<Disposable> other = new AtomicReference<>();
        public final AtomicReference<Disposable> upstream = new AtomicReference<>();

        public WithLatestFromObserver(Observer<? super R> observer, BiFunction<? super T, ? super U, ? extends R> biFunction) {
            this.downstream = observer;
            this.combiner = biFunction;
        }

        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this.other);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        public void onComplete() {
            DisposableHelper.dispose(this.other);
            this.downstream.onComplete();
        }

        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.other);
            this.downstream.onError(th2);
        }

        public void onNext(T t) {
            Object obj = get();
            if (obj != null) {
                try {
                    Object apply = this.combiner.apply(t, obj);
                    th.de.p039if.ad.qw.rg(apply, "The combiner returned a null value");
                    this.downstream.onNext(apply);
                } catch (Throwable th2) {
                    th.de.o.qw.ad(th2);
                    dispose();
                    this.downstream.onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.upstream, disposable);
        }

        public void otherError(Throwable th2) {
            DisposableHelper.dispose(this.upstream);
            this.downstream.onError(th2);
        }

        public boolean setOther(Disposable disposable) {
            return DisposableHelper.setOnce(this.other, disposable);
        }
    }

    public final class qw implements Observer<U> {

        /* renamed from: ad  reason: collision with root package name */
        public final WithLatestFromObserver<T, U, R> f10291ad;

        public qw(ObservableWithLatestFrom observableWithLatestFrom, WithLatestFromObserver<T, U, R> withLatestFromObserver) {
            this.f10291ad = withLatestFromObserver;
        }

        public void onComplete() {
        }

        public void onError(Throwable th2) {
            this.f10291ad.otherError(th2);
        }

        public void onNext(U u) {
            this.f10291ad.lazySet(u);
        }

        public void onSubscribe(Disposable disposable) {
            this.f10291ad.setOther(disposable);
        }
    }

    public ObservableWithLatestFrom(ObservableSource<T> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction, ObservableSource<? extends U> observableSource2) {
        super(observableSource);
        this.f10289th = biFunction;
        this.f10290yj = observableSource2;
    }

    public void subscribeActual(Observer<? super R> observer) {
        fe feVar = new fe(observer);
        WithLatestFromObserver withLatestFromObserver = new WithLatestFromObserver(feVar, this.f10289th);
        feVar.onSubscribe(withLatestFromObserver);
        this.f10290yj.subscribe(new qw(this, withLatestFromObserver));
        this.f10756ad.subscribe(withLatestFromObserver);
    }
}
