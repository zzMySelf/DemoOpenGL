package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/* renamed from: th.de.if.fe.rg.s  reason: invalid package */
public final class s<T> extends qw<T, T> {

    /* renamed from: th.de.if.fe.rg.s$qw */
    public static final class qw<T> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<? super T> f10769ad;

        /* renamed from: th  reason: collision with root package name */
        public Disposable f10770th;

        public qw(Observer<? super T> observer) {
            this.f10769ad = observer;
        }

        public void dispose() {
            this.f10770th.dispose();
        }

        public boolean isDisposed() {
            return this.f10770th.isDisposed();
        }

        public void onComplete() {
            this.f10769ad.onComplete();
        }

        public void onError(Throwable th2) {
            this.f10769ad.onError(th2);
        }

        public void onNext(T t) {
        }

        public void onSubscribe(Disposable disposable) {
            this.f10770th = disposable;
            this.f10769ad.onSubscribe(this);
        }
    }

    public s(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f10756ad.subscribe(new qw(observer));
    }
}
