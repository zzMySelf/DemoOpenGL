package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.atomic.AtomicReference;
import th.de.rg;

public final class ObservablePublishSelector<T, R> extends th.de.p039if.fe.rg.qw<T, R> {

    /* renamed from: th  reason: collision with root package name */
    public final Function<? super rg<T>, ? extends ObservableSource<R>> f10169th;

    public static final class TargetObserver<T, R> extends AtomicReference<Disposable> implements Observer<R>, Disposable {
        public static final long serialVersionUID = 854110278590336484L;
        public final Observer<? super R> downstream;
        public Disposable upstream;

        public TargetObserver(Observer<? super R> observer) {
            this.downstream = observer;
        }

        public void dispose() {
            this.upstream.dispose();
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        public void onComplete() {
            DisposableHelper.dispose(this);
            this.downstream.onComplete();
        }

        public void onError(Throwable th2) {
            DisposableHelper.dispose(this);
            this.downstream.onError(th2);
        }

        public void onNext(R r) {
            this.downstream.onNext(r);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public static final class qw<T, R> implements Observer<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final PublishSubject<T> f10170ad;

        /* renamed from: th  reason: collision with root package name */
        public final AtomicReference<Disposable> f10171th;

        public qw(PublishSubject<T> publishSubject, AtomicReference<Disposable> atomicReference) {
            this.f10170ad = publishSubject;
            this.f10171th = atomicReference;
        }

        public void onComplete() {
            this.f10170ad.onComplete();
        }

        public void onError(Throwable th2) {
            this.f10170ad.onError(th2);
        }

        public void onNext(T t) {
            this.f10170ad.onNext(t);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f10171th, disposable);
        }
    }

    public ObservablePublishSelector(ObservableSource<T> observableSource, Function<? super rg<T>, ? extends ObservableSource<R>> function) {
        super(observableSource);
        this.f10169th = function;
    }

    public void subscribeActual(Observer<? super R> observer) {
        PublishSubject rg2 = PublishSubject.rg();
        try {
            Object apply = this.f10169th.apply(rg2);
            th.de.p039if.ad.qw.rg(apply, "The selector returned a null ObservableSource");
            ObservableSource observableSource = (ObservableSource) apply;
            TargetObserver targetObserver = new TargetObserver(observer);
            observableSource.subscribe(targetObserver);
            this.f10756ad.subscribe(new qw(rg2, targetObserver));
        } catch (Throwable th2) {
            th.de.o.qw.ad(th2);
            EmptyDisposable.error(th2, (Observer<?>) observer);
        }
    }
}
