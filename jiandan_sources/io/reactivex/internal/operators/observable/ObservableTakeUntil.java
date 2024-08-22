package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p039if.fe.rg.qw;
import th.de.p039if.yj.rg;

public final class ObservableTakeUntil<T, U> extends qw<T, T> {

    /* renamed from: th  reason: collision with root package name */
    public final ObservableSource<? extends U> f10250th;

    public static final class TakeUntilMainObserver<T, U> extends AtomicInteger implements Observer<T>, Disposable {
        public static final long serialVersionUID = 1418547743690811973L;
        public final Observer<? super T> downstream;
        public final AtomicThrowable error = new AtomicThrowable();
        public final TakeUntilMainObserver<T, U>.OtherObserver otherObserver = new OtherObserver();
        public final AtomicReference<Disposable> upstream = new AtomicReference<>();

        public final class OtherObserver extends AtomicReference<Disposable> implements Observer<U> {
            public static final long serialVersionUID = -8693423678067375039L;

            public OtherObserver() {
            }

            public void onComplete() {
                TakeUntilMainObserver.this.otherComplete();
            }

            public void onError(Throwable th2) {
                TakeUntilMainObserver.this.otherError(th2);
            }

            public void onNext(U u) {
                DisposableHelper.dispose(this);
                TakeUntilMainObserver.this.otherComplete();
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public TakeUntilMainObserver(Observer<? super T> observer) {
            this.downstream = observer;
        }

        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this.otherObserver);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        public void onComplete() {
            DisposableHelper.dispose(this.otherObserver);
            rg.qw(this.downstream, this, this.error);
        }

        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.otherObserver);
            rg.de(this.downstream, th2, this, this.error);
        }

        public void onNext(T t) {
            rg.rg(this.downstream, t, this, this.error);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.upstream, disposable);
        }

        public void otherComplete() {
            DisposableHelper.dispose(this.upstream);
            rg.qw(this.downstream, this, this.error);
        }

        public void otherError(Throwable th2) {
            DisposableHelper.dispose(this.upstream);
            rg.de(this.downstream, th2, this, this.error);
        }
    }

    public ObservableTakeUntil(ObservableSource<T> observableSource, ObservableSource<? extends U> observableSource2) {
        super(observableSource);
        this.f10250th = observableSource2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        TakeUntilMainObserver takeUntilMainObserver = new TakeUntilMainObserver(observer);
        observer.onSubscribe(takeUntilMainObserver);
        this.f10250th.subscribe(takeUntilMainObserver.otherObserver);
        this.f10756ad.subscribe(takeUntilMainObserver);
    }
}
