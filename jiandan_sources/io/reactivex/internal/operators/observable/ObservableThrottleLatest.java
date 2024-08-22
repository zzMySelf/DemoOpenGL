package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p039if.fe.rg.qw;
import th.de.rg;
import th.de.th;

public final class ObservableThrottleLatest<T> extends qw<T, T> {

    /* renamed from: i  reason: collision with root package name */
    public final boolean f10254i;

    /* renamed from: th  reason: collision with root package name */
    public final long f10255th;

    /* renamed from: uk  reason: collision with root package name */
    public final th f10256uk;

    /* renamed from: yj  reason: collision with root package name */
    public final TimeUnit f10257yj;

    public static final class ThrottleLatestObserver<T> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        public static final long serialVersionUID = -8296689127439125014L;
        public volatile boolean cancelled;
        public volatile boolean done;
        public final Observer<? super T> downstream;
        public final boolean emitLast;
        public Throwable error;
        public final AtomicReference<T> latest = new AtomicReference<>();
        public final long timeout;
        public volatile boolean timerFired;
        public boolean timerRunning;
        public final TimeUnit unit;
        public Disposable upstream;
        public final th.de worker;

        public ThrottleLatestObserver(Observer<? super T> observer, long j, TimeUnit timeUnit, th.de deVar, boolean z) {
            this.downstream = observer;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = deVar;
            this.emitLast = z;
        }

        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.latest.lazySet((Object) null);
            }
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                AtomicReference<T> atomicReference = this.latest;
                Observer<? super T> observer = this.downstream;
                int i2 = 1;
                while (!this.cancelled) {
                    boolean z = this.done;
                    if (!z || this.error == null) {
                        boolean z2 = atomicReference.get() == null;
                        if (z) {
                            T andSet = atomicReference.getAndSet((Object) null);
                            if (!z2 && this.emitLast) {
                                observer.onNext(andSet);
                            }
                            observer.onComplete();
                            this.worker.dispose();
                            return;
                        }
                        if (z2) {
                            if (this.timerFired) {
                                this.timerRunning = false;
                                this.timerFired = false;
                            }
                        } else if (!this.timerRunning || this.timerFired) {
                            observer.onNext(atomicReference.getAndSet((Object) null));
                            this.timerFired = false;
                            this.timerRunning = true;
                            this.worker.de(this, this.timeout, this.unit);
                        }
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        atomicReference.lazySet((Object) null);
                        observer.onError(this.error);
                        this.worker.dispose();
                        return;
                    }
                }
                atomicReference.lazySet((Object) null);
            }
        }

        public boolean isDisposed() {
            return this.cancelled;
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        public void onError(Throwable th2) {
            this.error = th2;
            this.done = true;
            drain();
        }

        public void onNext(T t) {
            this.latest.set(t);
            drain();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public void run() {
            this.timerFired = true;
            drain();
        }
    }

    public ObservableThrottleLatest(rg<T> rgVar, long j, TimeUnit timeUnit, th thVar, boolean z) {
        super(rgVar);
        this.f10255th = j;
        this.f10257yj = timeUnit;
        this.f10256uk = thVar;
        this.f10254i = z;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f10756ad.subscribe(new ThrottleLatestObserver(observer, this.f10255th, this.f10257yj, this.f10256uk.qw(), this.f10254i));
    }
}
