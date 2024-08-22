package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p039if.th.uk;
import th.de.rg;
import th.de.th;

public final class ObservableInterval extends rg<Long> {

    /* renamed from: ad  reason: collision with root package name */
    public final th f10139ad;

    /* renamed from: th  reason: collision with root package name */
    public final long f10140th;

    /* renamed from: uk  reason: collision with root package name */
    public final TimeUnit f10141uk;

    /* renamed from: yj  reason: collision with root package name */
    public final long f10142yj;

    public static final class IntervalObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
        public static final long serialVersionUID = 346773832286157679L;
        public long count;
        public final Observer<? super Long> downstream;

        public IntervalObserver(Observer<? super Long> observer) {
            this.downstream = observer;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        public void run() {
            if (get() != DisposableHelper.DISPOSED) {
                Observer<? super Long> observer = this.downstream;
                long j = this.count;
                this.count = 1 + j;
                observer.onNext(Long.valueOf(j));
            }
        }

        public void setResource(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public ObservableInterval(long j, long j2, TimeUnit timeUnit, th thVar) {
        this.f10140th = j;
        this.f10142yj = j2;
        this.f10141uk = timeUnit;
        this.f10139ad = thVar;
    }

    public void subscribeActual(Observer<? super Long> observer) {
        IntervalObserver intervalObserver = new IntervalObserver(observer);
        observer.onSubscribe(intervalObserver);
        th thVar = this.f10139ad;
        if (thVar instanceof uk) {
            th.de qw = thVar.qw();
            intervalObserver.setResource(qw);
            qw.fe(intervalObserver, this.f10140th, this.f10142yj, this.f10141uk);
            return;
        }
        intervalObserver.setResource(thVar.rg(intervalObserver, this.f10140th, this.f10142yj, this.f10141uk));
    }
}
