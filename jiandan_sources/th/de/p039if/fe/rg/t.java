package th.de.p039if.fe.rg;

import io.reactivex.CompletableObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToObservable;
import th.de.rg;

/* renamed from: th.de.if.fe.rg.t  reason: invalid package */
public final class t<T> extends th.de.qw implements FuseToObservable<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final ObservableSource<T> f10783ad;

    /* renamed from: th.de.if.fe.rg.t$qw */
    public static final class qw<T> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final CompletableObserver f10784ad;

        /* renamed from: th  reason: collision with root package name */
        public Disposable f10785th;

        public qw(CompletableObserver completableObserver) {
            this.f10784ad = completableObserver;
        }

        public void dispose() {
            this.f10785th.dispose();
        }

        public boolean isDisposed() {
            return this.f10785th.isDisposed();
        }

        public void onComplete() {
            this.f10784ad.onComplete();
        }

        public void onError(Throwable th2) {
            this.f10784ad.onError(th2);
        }

        public void onNext(T t) {
        }

        public void onSubscribe(Disposable disposable) {
            this.f10785th = disposable;
            this.f10784ad.onSubscribe(this);
        }
    }

    public t(ObservableSource<T> observableSource) {
        this.f10783ad = observableSource;
    }

    public rg<T> ad() {
        return th.de.ppp.qw.when(new s(this.f10783ad));
    }

    public void de(CompletableObserver completableObserver) {
        this.f10783ad.subscribe(new qw(completableObserver));
    }
}
