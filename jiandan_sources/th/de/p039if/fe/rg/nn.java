package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import th.de.rg;

/* renamed from: th.de.if.fe.rg.nn  reason: invalid package */
public final class nn<T, U> extends rg<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final ObservableSource<? extends T> f10707ad;

    /* renamed from: th  reason: collision with root package name */
    public final ObservableSource<U> f10708th;

    /* renamed from: th.de.if.fe.rg.nn$qw */
    public final class qw implements Observer<U> {

        /* renamed from: ad  reason: collision with root package name */
        public final SequentialDisposable f10709ad;

        /* renamed from: th  reason: collision with root package name */
        public final Observer<? super T> f10710th;

        /* renamed from: yj  reason: collision with root package name */
        public boolean f10712yj;

        /* renamed from: th.de.if.fe.rg.nn$qw$qw  reason: collision with other inner class name */
        public final class C0338qw implements Observer<T> {
            public C0338qw() {
            }

            public void onComplete() {
                qw.this.f10710th.onComplete();
            }

            public void onError(Throwable th2) {
                qw.this.f10710th.onError(th2);
            }

            public void onNext(T t) {
                qw.this.f10710th.onNext(t);
            }

            public void onSubscribe(Disposable disposable) {
                qw.this.f10709ad.update(disposable);
            }
        }

        public qw(SequentialDisposable sequentialDisposable, Observer<? super T> observer) {
            this.f10709ad = sequentialDisposable;
            this.f10710th = observer;
        }

        public void onComplete() {
            if (!this.f10712yj) {
                this.f10712yj = true;
                nn.this.f10707ad.subscribe(new C0338qw());
            }
        }

        public void onError(Throwable th2) {
            if (this.f10712yj) {
                th.de.ppp.qw.ddd(th2);
                return;
            }
            this.f10712yj = true;
            this.f10710th.onError(th2);
        }

        public void onNext(U u) {
            onComplete();
        }

        public void onSubscribe(Disposable disposable) {
            this.f10709ad.update(disposable);
        }
    }

    public nn(ObservableSource<? extends T> observableSource, ObservableSource<U> observableSource2) {
        this.f10707ad = observableSource;
        this.f10708th = observableSource2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        this.f10708th.subscribe(new qw(sequentialDisposable, observer));
    }
}
