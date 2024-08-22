package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: th.de.if.fe.rg.ppp  reason: invalid package */
public final class ppp<T> extends qw<T, Long> {

    /* renamed from: th.de.if.fe.rg.ppp$qw */
    public static final class qw implements Observer<Object>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<? super Long> f10734ad;

        /* renamed from: th  reason: collision with root package name */
        public Disposable f10735th;

        /* renamed from: yj  reason: collision with root package name */
        public long f10736yj;

        public qw(Observer<? super Long> observer) {
            this.f10734ad = observer;
        }

        public void dispose() {
            this.f10735th.dispose();
        }

        public boolean isDisposed() {
            return this.f10735th.isDisposed();
        }

        public void onComplete() {
            this.f10734ad.onNext(Long.valueOf(this.f10736yj));
            this.f10734ad.onComplete();
        }

        public void onError(Throwable th2) {
            this.f10734ad.onError(th2);
        }

        public void onNext(Object obj) {
            this.f10736yj++;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10735th, disposable)) {
                this.f10735th = disposable;
                this.f10734ad.onSubscribe(this);
            }
        }
    }

    public ppp(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    public void subscribeActual(Observer<? super Long> observer) {
        this.f10756ad.subscribe(new qw(observer));
    }
}
