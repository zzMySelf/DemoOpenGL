package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import th.de.when.fe;

public final class ObservableSampleWithObservable<T> extends th.de.p039if.fe.rg.qw<T, T> {

    /* renamed from: th  reason: collision with root package name */
    public final ObservableSource<?> f10208th;

    /* renamed from: yj  reason: collision with root package name */
    public final boolean f10209yj;

    public static final class SampleMainEmitLast<T> extends SampleMainObserver<T> {
        public static final long serialVersionUID = -3029755663834015785L;
        public volatile boolean done;
        public final AtomicInteger wip = new AtomicInteger();

        public SampleMainEmitLast(Observer<? super T> observer, ObservableSource<?> observableSource) {
            super(observer, observableSource);
        }

        public void completeMain() {
            this.done = true;
            if (this.wip.getAndIncrement() == 0) {
                emit();
                this.downstream.onComplete();
            }
        }

        public void completeOther() {
            this.done = true;
            if (this.wip.getAndIncrement() == 0) {
                emit();
                this.downstream.onComplete();
            }
        }

        public void run() {
            if (this.wip.getAndIncrement() == 0) {
                do {
                    boolean z = this.done;
                    emit();
                    if (z) {
                        this.downstream.onComplete();
                        return;
                    }
                } while (this.wip.decrementAndGet() != 0);
            }
        }
    }

    public static final class SampleMainNoLast<T> extends SampleMainObserver<T> {
        public static final long serialVersionUID = -3029755663834015785L;

        public SampleMainNoLast(Observer<? super T> observer, ObservableSource<?> observableSource) {
            super(observer, observableSource);
        }

        public void completeMain() {
            this.downstream.onComplete();
        }

        public void completeOther() {
            this.downstream.onComplete();
        }

        public void run() {
            emit();
        }
    }

    public static abstract class SampleMainObserver<T> extends AtomicReference<T> implements Observer<T>, Disposable {
        public static final long serialVersionUID = -3517602651313910099L;
        public final Observer<? super T> downstream;
        public final AtomicReference<Disposable> other = new AtomicReference<>();
        public final ObservableSource<?> sampler;
        public Disposable upstream;

        public SampleMainObserver(Observer<? super T> observer, ObservableSource<?> observableSource) {
            this.downstream = observer;
            this.sampler = observableSource;
        }

        public void complete() {
            this.upstream.dispose();
            completeOther();
        }

        public abstract void completeMain();

        public abstract void completeOther();

        public void dispose() {
            DisposableHelper.dispose(this.other);
            this.upstream.dispose();
        }

        public void emit() {
            Object andSet = getAndSet((Object) null);
            if (andSet != null) {
                this.downstream.onNext(andSet);
            }
        }

        public void error(Throwable th2) {
            this.upstream.dispose();
            this.downstream.onError(th2);
        }

        public boolean isDisposed() {
            return this.other.get() == DisposableHelper.DISPOSED;
        }

        public void onComplete() {
            DisposableHelper.dispose(this.other);
            completeMain();
        }

        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.other);
            this.downstream.onError(th2);
        }

        public void onNext(T t) {
            lazySet(t);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
                if (this.other.get() == null) {
                    this.sampler.subscribe(new qw(this));
                }
            }
        }

        public abstract void run();

        public boolean setOther(Disposable disposable) {
            return DisposableHelper.setOnce(this.other, disposable);
        }
    }

    public static final class qw<T> implements Observer<Object> {

        /* renamed from: ad  reason: collision with root package name */
        public final SampleMainObserver<T> f10210ad;

        public qw(SampleMainObserver<T> sampleMainObserver) {
            this.f10210ad = sampleMainObserver;
        }

        public void onComplete() {
            this.f10210ad.complete();
        }

        public void onError(Throwable th2) {
            this.f10210ad.error(th2);
        }

        public void onNext(Object obj) {
            this.f10210ad.run();
        }

        public void onSubscribe(Disposable disposable) {
            this.f10210ad.setOther(disposable);
        }
    }

    public ObservableSampleWithObservable(ObservableSource<T> observableSource, ObservableSource<?> observableSource2, boolean z) {
        super(observableSource);
        this.f10208th = observableSource2;
        this.f10209yj = z;
    }

    public void subscribeActual(Observer<? super T> observer) {
        fe feVar = new fe(observer);
        if (this.f10209yj) {
            this.f10756ad.subscribe(new SampleMainEmitLast(feVar, this.f10208th));
        } else {
            this.f10756ad.subscribe(new SampleMainNoLast(feVar, this.f10208th));
        }
    }
}
