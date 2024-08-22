package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: th.de.if.fe.rg.r0  reason: invalid package */
public final class r0<T> extends qw<T, T> {

    /* renamed from: th.de.if.fe.rg.r0$qw */
    public static final class qw<T> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<? super T> f10759ad;

        /* renamed from: th  reason: collision with root package name */
        public Disposable f10760th;

        /* renamed from: yj  reason: collision with root package name */
        public T f10761yj;

        public qw(Observer<? super T> observer) {
            this.f10759ad = observer;
        }

        public void dispose() {
            this.f10761yj = null;
            this.f10760th.dispose();
        }

        public boolean isDisposed() {
            return this.f10760th.isDisposed();
        }

        public void onComplete() {
            qw();
        }

        public void onError(Throwable th2) {
            this.f10761yj = null;
            this.f10759ad.onError(th2);
        }

        public void onNext(T t) {
            this.f10761yj = t;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10760th, disposable)) {
                this.f10760th = disposable;
                this.f10759ad.onSubscribe(this);
            }
        }

        public void qw() {
            T t = this.f10761yj;
            if (t != null) {
                this.f10761yj = null;
                this.f10759ad.onNext(t);
            }
            this.f10759ad.onComplete();
        }
    }

    public r0(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f10756ad.subscribe(new qw(observer));
    }
}
