package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import th.de.p039if.fe.rg.qw;
import th.de.th;

public final class ObservableSkipLastTimed<T> extends qw<T, T> {

    /* renamed from: i  reason: collision with root package name */
    public final int f10232i;

    /* renamed from: o  reason: collision with root package name */
    public final boolean f10233o;

    /* renamed from: th  reason: collision with root package name */
    public final long f10234th;

    /* renamed from: uk  reason: collision with root package name */
    public final th f10235uk;

    /* renamed from: yj  reason: collision with root package name */
    public final TimeUnit f10236yj;

    public static final class SkipLastTimedObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        public static final long serialVersionUID = -5677354903406201275L;
        public volatile boolean cancelled;
        public final boolean delayError;
        public volatile boolean done;
        public final Observer<? super T> downstream;
        public Throwable error;
        public final th.de.p039if.rg.qw<Object> queue;
        public final th scheduler;
        public final long time;
        public final TimeUnit unit;
        public Disposable upstream;

        public SkipLastTimedObserver(Observer<? super T> observer, long j, TimeUnit timeUnit, th thVar, int i2, boolean z) {
            this.downstream = observer;
            this.time = j;
            this.unit = timeUnit;
            this.scheduler = thVar;
            this.queue = new th.de.p039if.rg.qw<>(i2);
            this.delayError = z;
        }

        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.dispose();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                Observer<? super T> observer = this.downstream;
                th.de.p039if.rg.qw<Object> qwVar = this.queue;
                boolean z = this.delayError;
                TimeUnit timeUnit = this.unit;
                th thVar = this.scheduler;
                long j = this.time;
                int i2 = 1;
                while (!this.cancelled) {
                    boolean z2 = this.done;
                    Long l = (Long) qwVar.peek();
                    boolean z3 = l == null;
                    long ad2 = thVar.ad(timeUnit);
                    if (!z3 && l.longValue() > ad2 - j) {
                        z3 = true;
                    }
                    if (z2) {
                        if (!z) {
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                this.queue.clear();
                                observer.onError(th2);
                                return;
                            } else if (z3) {
                                observer.onComplete();
                                return;
                            }
                        } else if (z3) {
                            Throwable th3 = this.error;
                            if (th3 != null) {
                                observer.onError(th3);
                                return;
                            } else {
                                observer.onComplete();
                                return;
                            }
                        }
                    }
                    if (z3) {
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        qwVar.poll();
                        observer.onNext(qwVar.poll());
                    }
                }
                this.queue.clear();
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
            this.queue.m2355if(Long.valueOf(this.scheduler.ad(this.unit)), t);
            drain();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableSkipLastTimed(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, th thVar, int i2, boolean z) {
        super(observableSource);
        this.f10234th = j;
        this.f10236yj = timeUnit;
        this.f10235uk = thVar;
        this.f10232i = i2;
        this.f10233o = z;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f10756ad.subscribe(new SkipLastTimedObserver(observer, this.f10234th, this.f10236yj, this.f10235uk, this.f10232i, this.f10233o));
    }
}
