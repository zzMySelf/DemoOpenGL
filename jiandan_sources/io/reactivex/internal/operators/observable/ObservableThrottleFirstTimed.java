package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p039if.fe.rg.qw;
import th.de.th;
import th.de.when.fe;

public final class ObservableThrottleFirstTimed<T> extends qw<T, T> {

    /* renamed from: th  reason: collision with root package name */
    public final long f10251th;

    /* renamed from: uk  reason: collision with root package name */
    public final th f10252uk;

    /* renamed from: yj  reason: collision with root package name */
    public final TimeUnit f10253yj;

    public static final class DebounceTimedObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, Runnable {
        public static final long serialVersionUID = 786994795061867455L;
        public boolean done;
        public final Observer<? super T> downstream;
        public volatile boolean gate;
        public final long timeout;
        public final TimeUnit unit;
        public Disposable upstream;
        public final th.de worker;

        public DebounceTimedObserver(Observer<? super T> observer, long j, TimeUnit timeUnit, th.de deVar) {
            this.downstream = observer;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = deVar;
        }

        public void dispose() {
            this.upstream.dispose();
            this.worker.dispose();
        }

        public boolean isDisposed() {
            return this.worker.isDisposed();
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.downstream.onComplete();
                this.worker.dispose();
            }
        }

        public void onError(Throwable th2) {
            if (this.done) {
                th.de.ppp.qw.ddd(th2);
                return;
            }
            this.done = true;
            this.downstream.onError(th2);
            this.worker.dispose();
        }

        public void onNext(T t) {
            if (!this.gate && !this.done) {
                this.gate = true;
                this.downstream.onNext(t);
                Disposable disposable = (Disposable) get();
                if (disposable != null) {
                    disposable.dispose();
                }
                DisposableHelper.replace(this, this.worker.de(this, this.timeout, this.unit));
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public void run() {
            this.gate = false;
        }
    }

    public ObservableThrottleFirstTimed(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, th thVar) {
        super(observableSource);
        this.f10251th = j;
        this.f10253yj = timeUnit;
        this.f10252uk = thVar;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f10756ad.subscribe(new DebounceTimedObserver(new fe(observer), this.f10251th, this.f10253yj, this.f10252uk.qw()));
    }
}
