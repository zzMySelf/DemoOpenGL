package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import th.de.rg;
import th.de.th;

public final class ObservableTimeoutTimed<T> extends th.de.p039if.fe.rg.qw<T, T> {

    /* renamed from: i  reason: collision with root package name */
    public final ObservableSource<? extends T> f10261i;

    /* renamed from: th  reason: collision with root package name */
    public final long f10262th;

    /* renamed from: uk  reason: collision with root package name */
    public final th f10263uk;

    /* renamed from: yj  reason: collision with root package name */
    public final TimeUnit f10264yj;

    public static final class TimeoutFallbackObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, ad {
        public static final long serialVersionUID = 3764492702657003550L;
        public final Observer<? super T> downstream;
        public ObservableSource<? extends T> fallback;
        public final AtomicLong index = new AtomicLong();
        public final SequentialDisposable task = new SequentialDisposable();
        public final long timeout;
        public final TimeUnit unit;
        public final AtomicReference<Disposable> upstream = new AtomicReference<>();
        public final th.de worker;

        public TimeoutFallbackObserver(Observer<? super T> observer, long j, TimeUnit timeUnit, th.de deVar, ObservableSource<? extends T> observableSource) {
            this.downstream = observer;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = deVar;
            this.fallback = observableSource;
        }

        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this);
            this.worker.dispose();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onComplete();
                this.worker.dispose();
            }
        }

        public void onError(Throwable th2) {
            if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onError(th2);
                this.worker.dispose();
                return;
            }
            th.de.ppp.qw.ddd(th2);
        }

        public void onNext(T t) {
            long j = this.index.get();
            if (j != Long.MAX_VALUE) {
                long j2 = 1 + j;
                if (this.index.compareAndSet(j, j2)) {
                    ((Disposable) this.task.get()).dispose();
                    this.downstream.onNext(t);
                    startTimeout(j2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.upstream, disposable);
        }

        public void onTimeout(long j) {
            if (this.index.compareAndSet(j, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.upstream);
                ObservableSource<? extends T> observableSource = this.fallback;
                this.fallback = null;
                observableSource.subscribe(new qw(this.downstream, this));
                this.worker.dispose();
            }
        }

        public void startTimeout(long j) {
            this.task.replace(this.worker.de(new de(j, this), this.timeout, this.unit));
        }
    }

    public static final class TimeoutObserver<T> extends AtomicLong implements Observer<T>, Disposable, ad {
        public static final long serialVersionUID = 3764492702657003550L;
        public final Observer<? super T> downstream;
        public final SequentialDisposable task = new SequentialDisposable();
        public final long timeout;
        public final TimeUnit unit;
        public final AtomicReference<Disposable> upstream = new AtomicReference<>();
        public final th.de worker;

        public TimeoutObserver(Observer<? super T> observer, long j, TimeUnit timeUnit, th.de deVar) {
            this.downstream = observer;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = deVar;
        }

        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            this.worker.dispose();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onComplete();
                this.worker.dispose();
            }
        }

        public void onError(Throwable th2) {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onError(th2);
                this.worker.dispose();
                return;
            }
            th.de.ppp.qw.ddd(th2);
        }

        public void onNext(T t) {
            long j = get();
            if (j != Long.MAX_VALUE) {
                long j2 = 1 + j;
                if (compareAndSet(j, j2)) {
                    ((Disposable) this.task.get()).dispose();
                    this.downstream.onNext(t);
                    startTimeout(j2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.upstream, disposable);
        }

        public void onTimeout(long j) {
            if (compareAndSet(j, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.upstream);
                this.downstream.onError(new TimeoutException(ExceptionHelper.de(this.timeout, this.unit)));
                this.worker.dispose();
            }
        }

        public void startTimeout(long j) {
            this.task.replace(this.worker.de(new de(j, this), this.timeout, this.unit));
        }
    }

    public interface ad {
        void onTimeout(long j);
    }

    public static final class de implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final ad f10265ad;

        /* renamed from: th  reason: collision with root package name */
        public final long f10266th;

        public de(long j, ad adVar) {
            this.f10266th = j;
            this.f10265ad = adVar;
        }

        public void run() {
            this.f10265ad.onTimeout(this.f10266th);
        }
    }

    public static final class qw<T> implements Observer<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<? super T> f10267ad;

        /* renamed from: th  reason: collision with root package name */
        public final AtomicReference<Disposable> f10268th;

        public qw(Observer<? super T> observer, AtomicReference<Disposable> atomicReference) {
            this.f10267ad = observer;
            this.f10268th = atomicReference;
        }

        public void onComplete() {
            this.f10267ad.onComplete();
        }

        public void onError(Throwable th2) {
            this.f10267ad.onError(th2);
        }

        public void onNext(T t) {
            this.f10267ad.onNext(t);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this.f10268th, disposable);
        }
    }

    public ObservableTimeoutTimed(rg<T> rgVar, long j, TimeUnit timeUnit, th thVar, ObservableSource<? extends T> observableSource) {
        super(rgVar);
        this.f10262th = j;
        this.f10264yj = timeUnit;
        this.f10263uk = thVar;
        this.f10261i = observableSource;
    }

    public void subscribeActual(Observer<? super T> observer) {
        if (this.f10261i == null) {
            TimeoutObserver timeoutObserver = new TimeoutObserver(observer, this.f10262th, this.f10264yj, this.f10263uk.qw());
            observer.onSubscribe(timeoutObserver);
            timeoutObserver.startTimeout(0);
            this.f10756ad.subscribe(timeoutObserver);
            return;
        }
        TimeoutFallbackObserver timeoutFallbackObserver = new TimeoutFallbackObserver(observer, this.f10262th, this.f10264yj, this.f10263uk.qw(), this.f10261i);
        observer.onSubscribe(timeoutFallbackObserver);
        timeoutFallbackObserver.startTimeout(0);
        this.f10756ad.subscribe(timeoutFallbackObserver);
    }
}
