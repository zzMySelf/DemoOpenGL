package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import th.de.fe;

/* renamed from: th.de.if.fe.rg.a0  reason: invalid package */
public final class a0<T> extends qw<T, fe<T>> {

    /* renamed from: th.de.if.fe.rg.a0$qw */
    public static final class qw<T> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<? super fe<T>> f10520ad;

        /* renamed from: th  reason: collision with root package name */
        public Disposable f10521th;

        public qw(Observer<? super fe<T>> observer) {
            this.f10520ad = observer;
        }

        public void dispose() {
            this.f10521th.dispose();
        }

        public boolean isDisposed() {
            return this.f10521th.isDisposed();
        }

        public void onComplete() {
            this.f10520ad.onNext(fe.qw());
            this.f10520ad.onComplete();
        }

        public void onError(Throwable th2) {
            this.f10520ad.onNext(fe.ad(th2));
            this.f10520ad.onComplete();
        }

        public void onNext(T t) {
            this.f10520ad.onNext(fe.de(t));
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10521th, disposable)) {
                this.f10521th = disposable;
                this.f10520ad.onSubscribe(this);
            }
        }
    }

    public a0(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    public void subscribeActual(Observer<? super fe<T>> observer) {
        this.f10756ad.subscribe(new qw(observer));
    }
}
