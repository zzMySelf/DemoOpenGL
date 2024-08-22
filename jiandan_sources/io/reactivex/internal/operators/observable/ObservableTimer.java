package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import th.de.rg;
import th.de.th;

public final class ObservableTimer extends rg<Long> {

    /* renamed from: ad  reason: collision with root package name */
    public final th f10269ad;

    /* renamed from: th  reason: collision with root package name */
    public final long f10270th;

    /* renamed from: yj  reason: collision with root package name */
    public final TimeUnit f10271yj;

    public static final class TimerObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
        public static final long serialVersionUID = -2809475196591179431L;
        public final Observer<? super Long> downstream;

        public TimerObserver(Observer<? super Long> observer) {
            this.downstream = observer;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        public void run() {
            if (!isDisposed()) {
                this.downstream.onNext(0L);
                lazySet(EmptyDisposable.INSTANCE);
                this.downstream.onComplete();
            }
        }

        public void setResource(Disposable disposable) {
            DisposableHelper.trySet(this, disposable);
        }
    }

    public ObservableTimer(long j, TimeUnit timeUnit, th thVar) {
        this.f10270th = j;
        this.f10271yj = timeUnit;
        this.f10269ad = thVar;
    }

    public void subscribeActual(Observer<? super Long> observer) {
        TimerObserver timerObserver = new TimerObserver(observer);
        observer.onSubscribe(timerObserver);
        timerObserver.setResource(this.f10269ad.fe(timerObserver, this.f10270th, this.f10271yj));
    }
}
