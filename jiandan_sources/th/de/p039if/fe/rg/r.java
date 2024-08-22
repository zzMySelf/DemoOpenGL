package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: th.de.if.fe.rg.r  reason: invalid package */
public final class r<T> extends qw<T, T> {

    /* renamed from: th.de.if.fe.rg.r$qw */
    public static final class qw<T> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<? super T> f10757ad;

        /* renamed from: th  reason: collision with root package name */
        public Disposable f10758th;

        public qw(Observer<? super T> observer) {
            this.f10757ad = observer;
        }

        public void dispose() {
            this.f10758th.dispose();
        }

        public boolean isDisposed() {
            return this.f10758th.isDisposed();
        }

        public void onComplete() {
            this.f10757ad.onComplete();
        }

        public void onError(Throwable th2) {
            this.f10757ad.onError(th2);
        }

        public void onNext(T t) {
            this.f10757ad.onNext(t);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10758th, disposable)) {
                this.f10758th = disposable;
                this.f10757ad.onSubscribe(this);
            }
        }
    }

    public r(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f10756ad.subscribe(new qw(observer));
    }
}
