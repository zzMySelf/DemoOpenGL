package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p039if.fe.rg.qw;
import th.de.th;
import th.de.when.fe;

public final class ObservableSampleTimed<T> extends qw<T, T> {

    /* renamed from: i  reason: collision with root package name */
    public final boolean f10204i;

    /* renamed from: th  reason: collision with root package name */
    public final long f10205th;

    /* renamed from: uk  reason: collision with root package name */
    public final th f10206uk;

    /* renamed from: yj  reason: collision with root package name */
    public final TimeUnit f10207yj;

    public static final class SampleTimedEmitLast<T> extends SampleTimedObserver<T> {
        public static final long serialVersionUID = -7139995637533111443L;
        public final AtomicInteger wip = new AtomicInteger(1);

        public SampleTimedEmitLast(Observer<? super T> observer, long j, TimeUnit timeUnit, th thVar) {
            super(observer, j, timeUnit, thVar);
        }

        public void complete() {
            emit();
            if (this.wip.decrementAndGet() == 0) {
                this.downstream.onComplete();
            }
        }

        public void run() {
            if (this.wip.incrementAndGet() == 2) {
                emit();
                if (this.wip.decrementAndGet() == 0) {
                    this.downstream.onComplete();
                }
            }
        }
    }

    public static final class SampleTimedNoLast<T> extends SampleTimedObserver<T> {
        public static final long serialVersionUID = -7139995637533111443L;

        public SampleTimedNoLast(Observer<? super T> observer, long j, TimeUnit timeUnit, th thVar) {
            super(observer, j, timeUnit, thVar);
        }

        public void complete() {
            this.downstream.onComplete();
        }

        public void run() {
            emit();
        }
    }

    public static abstract class SampleTimedObserver<T> extends AtomicReference<T> implements Observer<T>, Disposable, Runnable {
        public static final long serialVersionUID = -3517602651313910099L;
        public final Observer<? super T> downstream;
        public final long period;
        public final th scheduler;
        public final AtomicReference<Disposable> timer = new AtomicReference<>();
        public final TimeUnit unit;
        public Disposable upstream;

        public SampleTimedObserver(Observer<? super T> observer, long j, TimeUnit timeUnit, th thVar) {
            this.downstream = observer;
            this.period = j;
            this.unit = timeUnit;
            this.scheduler = thVar;
        }

        public void cancelTimer() {
            DisposableHelper.dispose(this.timer);
        }

        public abstract void complete();

        public void dispose() {
            cancelTimer();
            this.upstream.dispose();
        }

        public void emit() {
            Object andSet = getAndSet((Object) null);
            if (andSet != null) {
                this.downstream.onNext(andSet);
            }
        }

        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        public void onComplete() {
            cancelTimer();
            complete();
        }

        public void onError(Throwable th2) {
            cancelTimer();
            this.downstream.onError(th2);
        }

        public void onNext(T t) {
            lazySet(t);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
                th thVar = this.scheduler;
                long j = this.period;
                DisposableHelper.replace(this.timer, thVar.rg(this, j, j, this.unit));
            }
        }
    }

    public ObservableSampleTimed(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, th thVar, boolean z) {
        super(observableSource);
        this.f10205th = j;
        this.f10207yj = timeUnit;
        this.f10206uk = thVar;
        this.f10204i = z;
    }

    public void subscribeActual(Observer<? super T> observer) {
        fe feVar = new fe(observer);
        if (this.f10204i) {
            this.f10756ad.subscribe(new SampleTimedEmitLast(feVar, this.f10205th, this.f10207yj, this.f10206uk));
        } else {
            this.f10756ad.subscribe(new SampleTimedNoLast(feVar, this.f10205th, this.f10207yj, this.f10206uk));
        }
    }
}
