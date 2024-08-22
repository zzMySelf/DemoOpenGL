package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import th.de.p039if.fe.rg.qw;
import th.de.th;

public final class ObservableTakeLastTimed<T> extends qw<T, T> {

    /* renamed from: i  reason: collision with root package name */
    public final th f10244i;

    /* renamed from: o  reason: collision with root package name */
    public final int f10245o;

    /* renamed from: pf  reason: collision with root package name */
    public final boolean f10246pf;

    /* renamed from: th  reason: collision with root package name */
    public final long f10247th;

    /* renamed from: uk  reason: collision with root package name */
    public final TimeUnit f10248uk;

    /* renamed from: yj  reason: collision with root package name */
    public final long f10249yj;

    public static final class TakeLastTimedObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        public static final long serialVersionUID = -5677354903406201275L;
        public volatile boolean cancelled;
        public final long count;
        public final boolean delayError;
        public final Observer<? super T> downstream;
        public Throwable error;
        public final th.de.p039if.rg.qw<Object> queue;
        public final th scheduler;
        public final long time;
        public final TimeUnit unit;
        public Disposable upstream;

        public TakeLastTimedObserver(Observer<? super T> observer, long j, long j2, TimeUnit timeUnit, th thVar, int i2, boolean z) {
            this.downstream = observer;
            this.count = j;
            this.time = j2;
            this.unit = timeUnit;
            this.scheduler = thVar;
            this.queue = new th.de.p039if.rg.qw<>(i2);
            this.delayError = z;
        }

        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.dispose();
                if (compareAndSet(false, true)) {
                    this.queue.clear();
                }
            }
        }

        public void drain() {
            Throwable th2;
            if (compareAndSet(false, true)) {
                Observer<? super T> observer = this.downstream;
                th.de.p039if.rg.qw<Object> qwVar = this.queue;
                boolean z = this.delayError;
                while (!this.cancelled) {
                    if (z || (th2 = this.error) == null) {
                        Object poll = qwVar.poll();
                        if (poll == null) {
                            Throwable th3 = this.error;
                            if (th3 != null) {
                                observer.onError(th3);
                                return;
                            } else {
                                observer.onComplete();
                                return;
                            }
                        } else {
                            Object poll2 = qwVar.poll();
                            if (((Long) poll).longValue() >= this.scheduler.ad(this.unit) - this.time) {
                                observer.onNext(poll2);
                            }
                        }
                    } else {
                        qwVar.clear();
                        observer.onError(th2);
                        return;
                    }
                }
                qwVar.clear();
            }
        }

        public boolean isDisposed() {
            return this.cancelled;
        }

        public void onComplete() {
            drain();
        }

        public void onError(Throwable th2) {
            this.error = th2;
            drain();
        }

        public void onNext(T t) {
            th.de.p039if.rg.qw<Object> qwVar = this.queue;
            long ad2 = this.scheduler.ad(this.unit);
            long j = this.time;
            long j2 = this.count;
            boolean z = j2 == Long.MAX_VALUE;
            qwVar.m2355if(Long.valueOf(ad2), t);
            while (!qwVar.isEmpty()) {
                if (((Long) qwVar.peek()).longValue() <= ad2 - j || (!z && ((long) (qwVar.when() >> 1)) > j2)) {
                    qwVar.poll();
                    qwVar.poll();
                } else {
                    return;
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableTakeLastTimed(ObservableSource<T> observableSource, long j, long j2, TimeUnit timeUnit, th thVar, int i2, boolean z) {
        super(observableSource);
        this.f10247th = j;
        this.f10249yj = j2;
        this.f10248uk = timeUnit;
        this.f10244i = thVar;
        this.f10245o = i2;
        this.f10246pf = z;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f10756ad.subscribe(new TakeLastTimedObserver(observer, this.f10247th, this.f10249yj, this.f10248uk, this.f10244i, this.f10245o, this.f10246pf));
    }
}
