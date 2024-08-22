package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p039if.fe.rg.qw;
import th.de.rg;
import th.de.xxx.ad;

public final class ObservableRetryWhen<T> extends qw<T, T> {

    /* renamed from: th  reason: collision with root package name */
    public final Function<? super rg<Throwable>, ? extends ObservableSource<?>> f10203th;

    public static final class RepeatWhenObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        public static final long serialVersionUID = 802743776666017014L;
        public volatile boolean active;
        public final Observer<? super T> downstream;
        public final AtomicThrowable error = new AtomicThrowable();
        public final RepeatWhenObserver<T>.InnerRepeatObserver inner = new InnerRepeatObserver();
        public final ad<Throwable> signaller;
        public final ObservableSource<T> source;
        public final AtomicReference<Disposable> upstream = new AtomicReference<>();
        public final AtomicInteger wip = new AtomicInteger();

        public final class InnerRepeatObserver extends AtomicReference<Disposable> implements Observer<Object> {
            public static final long serialVersionUID = 3254781284376480842L;

            public InnerRepeatObserver() {
            }

            public void onComplete() {
                RepeatWhenObserver.this.innerComplete();
            }

            public void onError(Throwable th2) {
                RepeatWhenObserver.this.innerError(th2);
            }

            public void onNext(Object obj) {
                RepeatWhenObserver.this.innerNext();
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public RepeatWhenObserver(Observer<? super T> observer, ad<Throwable> adVar, ObservableSource<T> observableSource) {
            this.downstream = observer;
            this.signaller = adVar;
            this.source = observableSource;
        }

        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this.inner);
        }

        public void innerComplete() {
            DisposableHelper.dispose(this.upstream);
            th.de.p039if.yj.rg.qw(this.downstream, this, this.error);
        }

        public void innerError(Throwable th2) {
            DisposableHelper.dispose(this.upstream);
            th.de.p039if.yj.rg.de(this.downstream, th2, this, this.error);
        }

        public void innerNext() {
            subscribeNext();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        public void onComplete() {
            DisposableHelper.dispose(this.inner);
            th.de.p039if.yj.rg.qw(this.downstream, this, this.error);
        }

        public void onError(Throwable th2) {
            DisposableHelper.replace(this.upstream, (Disposable) null);
            this.active = false;
            this.signaller.onNext(th2);
        }

        public void onNext(T t) {
            th.de.p039if.yj.rg.rg(this.downstream, t, this, this.error);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this.upstream, disposable);
        }

        public void subscribeNext() {
            if (this.wip.getAndIncrement() == 0) {
                while (!isDisposed()) {
                    if (!this.active) {
                        this.active = true;
                        this.source.subscribe(this);
                    }
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }
    }

    public ObservableRetryWhen(ObservableSource<T> observableSource, Function<? super rg<Throwable>, ? extends ObservableSource<?>> function) {
        super(observableSource);
        this.f10203th = function;
    }

    public void subscribeActual(Observer<? super T> observer) {
        ad ad2 = PublishSubject.rg().ad();
        try {
            Object apply = this.f10203th.apply(ad2);
            th.de.p039if.ad.qw.rg(apply, "The handler returned a null ObservableSource");
            ObservableSource observableSource = (ObservableSource) apply;
            RepeatWhenObserver repeatWhenObserver = new RepeatWhenObserver(observer, ad2, this.f10756ad);
            observer.onSubscribe(repeatWhenObserver);
            observableSource.subscribe(repeatWhenObserver.inner);
            repeatWhenObserver.subscribeNext();
        } catch (Throwable th2) {
            th.de.o.qw.ad(th2);
            EmptyDisposable.error(th2, (Observer<?>) observer);
        }
    }
}
