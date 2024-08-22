package th.de.p039if.fe.rg;

import io.reactivex.MaybeObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import th.de.de;
import th.de.rg;

/* renamed from: th.de.if.fe.rg.c  reason: invalid package */
public final class c<T> extends de<T> implements FuseToObservable<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final ObservableSource<T> f10539ad;

    /* renamed from: th  reason: collision with root package name */
    public final long f10540th;

    /* renamed from: th.de.if.fe.rg.c$qw */
    public static final class qw<T> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final MaybeObserver<? super T> f10541ad;

        /* renamed from: i  reason: collision with root package name */
        public boolean f10542i;

        /* renamed from: th  reason: collision with root package name */
        public final long f10543th;

        /* renamed from: uk  reason: collision with root package name */
        public long f10544uk;

        /* renamed from: yj  reason: collision with root package name */
        public Disposable f10545yj;

        public qw(MaybeObserver<? super T> maybeObserver, long j) {
            this.f10541ad = maybeObserver;
            this.f10543th = j;
        }

        public void dispose() {
            this.f10545yj.dispose();
        }

        public boolean isDisposed() {
            return this.f10545yj.isDisposed();
        }

        public void onComplete() {
            if (!this.f10542i) {
                this.f10542i = true;
                this.f10541ad.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f10542i) {
                th.de.ppp.qw.ddd(th2);
                return;
            }
            this.f10542i = true;
            this.f10541ad.onError(th2);
        }

        public void onNext(T t) {
            if (!this.f10542i) {
                long j = this.f10544uk;
                if (j == this.f10543th) {
                    this.f10542i = true;
                    this.f10545yj.dispose();
                    this.f10541ad.onSuccess(t);
                    return;
                }
                this.f10544uk = j + 1;
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10545yj, disposable)) {
                this.f10545yj = disposable;
                this.f10541ad.onSubscribe(this);
            }
        }
    }

    public c(ObservableSource<T> observableSource, long j) {
        this.f10539ad = observableSource;
        this.f10540th = j;
    }

    public rg<T> ad() {
        return th.de.ppp.qw.when(new b(this.f10539ad, this.f10540th, null, false));
    }

    public void fe(MaybeObserver<? super T> maybeObserver) {
        this.f10539ad.subscribe(new qw(maybeObserver, this.f10540th));
    }
}
