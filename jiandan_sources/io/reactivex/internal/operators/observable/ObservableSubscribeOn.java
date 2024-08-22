package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import th.de.th;

public final class ObservableSubscribeOn<T> extends th.de.p039if.fe.rg.qw<T, T> {

    /* renamed from: th  reason: collision with root package name */
    public final th f10237th;

    public static final class SubscribeOnObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
        public static final long serialVersionUID = 8094547886072529208L;
        public final Observer<? super T> downstream;
        public final AtomicReference<Disposable> upstream = new AtomicReference<>();

        public SubscribeOnObserver(Observer<? super T> observer) {
            this.downstream = observer;
        }

        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.downstream.onComplete();
        }

        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.upstream, disposable);
        }

        public void setDisposable(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public final class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final SubscribeOnObserver<T> f10238ad;

        public qw(SubscribeOnObserver<T> subscribeOnObserver) {
            this.f10238ad = subscribeOnObserver;
        }

        public void run() {
            ObservableSubscribeOn.this.f10756ad.subscribe(this.f10238ad);
        }
    }

    public ObservableSubscribeOn(ObservableSource<T> observableSource, th thVar) {
        super(observableSource);
        this.f10237th = thVar;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(observer);
        observer.onSubscribe(subscribeOnObserver);
        subscribeOnObserver.setDisposable(this.f10237th.de(new qw(subscribeOnObserver)));
    }
}
