package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p039if.th.uk;
import th.de.rg;
import th.de.th;

public final class ObservableIntervalRange extends rg<Long> {

    /* renamed from: ad  reason: collision with root package name */
    public final th f10143ad;

    /* renamed from: i  reason: collision with root package name */
    public final long f10144i;

    /* renamed from: o  reason: collision with root package name */
    public final TimeUnit f10145o;

    /* renamed from: th  reason: collision with root package name */
    public final long f10146th;

    /* renamed from: uk  reason: collision with root package name */
    public final long f10147uk;

    /* renamed from: yj  reason: collision with root package name */
    public final long f10148yj;

    public static final class IntervalRangeObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
        public static final long serialVersionUID = 1891866368734007884L;
        public long count;
        public final Observer<? super Long> downstream;
        public final long end;

        public IntervalRangeObserver(Observer<? super Long> observer, long j, long j2) {
            this.downstream = observer;
            this.count = j;
            this.end = j2;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        public void run() {
            if (!isDisposed()) {
                long j = this.count;
                this.downstream.onNext(Long.valueOf(j));
                if (j == this.end) {
                    DisposableHelper.dispose(this);
                    this.downstream.onComplete();
                    return;
                }
                this.count = j + 1;
            }
        }

        public void setResource(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public ObservableIntervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit, th thVar) {
        this.f10147uk = j3;
        this.f10144i = j4;
        this.f10145o = timeUnit;
        this.f10143ad = thVar;
        this.f10146th = j;
        this.f10148yj = j2;
    }

    public void subscribeActual(Observer<? super Long> observer) {
        IntervalRangeObserver intervalRangeObserver = new IntervalRangeObserver(observer, this.f10146th, this.f10148yj);
        observer.onSubscribe(intervalRangeObserver);
        th thVar = this.f10143ad;
        if (thVar instanceof uk) {
            th.de qw = thVar.qw();
            intervalRangeObserver.setResource(qw);
            qw.fe(intervalRangeObserver, this.f10147uk, this.f10144i, this.f10145o);
            return;
        }
        intervalRangeObserver.setResource(thVar.rg(intervalRangeObserver, this.f10147uk, this.f10144i, this.f10145o));
    }
}
