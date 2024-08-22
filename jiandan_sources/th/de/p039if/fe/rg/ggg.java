package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import th.de.rg;
import th.de.yj;

/* renamed from: th.de.if.fe.rg.ggg  reason: invalid package */
public final class ggg<T> extends yj<Long> implements FuseToObservable<Long> {

    /* renamed from: ad  reason: collision with root package name */
    public final ObservableSource<T> f10622ad;

    /* renamed from: th.de.if.fe.rg.ggg$qw */
    public static final class qw implements Observer<Object>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final SingleObserver<? super Long> f10623ad;

        /* renamed from: th  reason: collision with root package name */
        public Disposable f10624th;

        /* renamed from: yj  reason: collision with root package name */
        public long f10625yj;

        public qw(SingleObserver<? super Long> singleObserver) {
            this.f10623ad = singleObserver;
        }

        public void dispose() {
            this.f10624th.dispose();
            this.f10624th = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f10624th.isDisposed();
        }

        public void onComplete() {
            this.f10624th = DisposableHelper.DISPOSED;
            this.f10623ad.onSuccess(Long.valueOf(this.f10625yj));
        }

        public void onError(Throwable th2) {
            this.f10624th = DisposableHelper.DISPOSED;
            this.f10623ad.onError(th2);
        }

        public void onNext(Object obj) {
            this.f10625yj++;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10624th, disposable)) {
                this.f10624th = disposable;
                this.f10623ad.onSubscribe(this);
            }
        }
    }

    public ggg(ObservableSource<T> observableSource) {
        this.f10622ad = observableSource;
    }

    public rg<Long> ad() {
        return th.de.ppp.qw.when(new ppp(this.f10622ad));
    }

    public void rg(SingleObserver<? super Long> singleObserver) {
        this.f10622ad.subscribe(new qw(singleObserver));
    }
}
