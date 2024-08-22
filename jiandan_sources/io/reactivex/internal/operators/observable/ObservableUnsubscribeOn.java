package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import th.de.p039if.fe.rg.qw;
import th.de.th;

public final class ObservableUnsubscribeOn<T> extends qw<T, T> {

    /* renamed from: th  reason: collision with root package name */
    public final th f10272th;

    public static final class UnsubscribeObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        public static final long serialVersionUID = 1015244841293359600L;
        public final Observer<? super T> downstream;
        public final th scheduler;
        public Disposable upstream;

        public final class qw implements Runnable {
            public qw() {
            }

            public void run() {
                UnsubscribeObserver.this.upstream.dispose();
            }
        }

        public UnsubscribeObserver(Observer<? super T> observer, th thVar) {
            this.downstream = observer;
            this.scheduler = thVar;
        }

        public void dispose() {
            if (compareAndSet(false, true)) {
                this.scheduler.de(new qw());
            }
        }

        public boolean isDisposed() {
            return get();
        }

        public void onComplete() {
            if (!get()) {
                this.downstream.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (get()) {
                th.de.ppp.qw.ddd(th2);
            } else {
                this.downstream.onError(th2);
            }
        }

        public void onNext(T t) {
            if (!get()) {
                this.downstream.onNext(t);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableUnsubscribeOn(ObservableSource<T> observableSource, th thVar) {
        super(observableSource);
        this.f10272th = thVar;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f10756ad.subscribe(new UnsubscribeObserver(observer, this.f10272th));
    }
}
