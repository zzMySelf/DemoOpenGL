package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import th.de.rg;
import th.de.yj;

/* renamed from: th.de.if.fe.rg.th  reason: invalid package */
public final class th<T> extends yj<Boolean> implements FuseToObservable<Boolean> {

    /* renamed from: ad  reason: collision with root package name */
    public final ObservableSource<T> f10791ad;

    /* renamed from: th  reason: collision with root package name */
    public final Predicate<? super T> f10792th;

    /* renamed from: th.de.if.fe.rg.th$qw */
    public static final class qw<T> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final SingleObserver<? super Boolean> f10793ad;

        /* renamed from: th  reason: collision with root package name */
        public final Predicate<? super T> f10794th;

        /* renamed from: uk  reason: collision with root package name */
        public boolean f10795uk;

        /* renamed from: yj  reason: collision with root package name */
        public Disposable f10796yj;

        public qw(SingleObserver<? super Boolean> singleObserver, Predicate<? super T> predicate) {
            this.f10793ad = singleObserver;
            this.f10794th = predicate;
        }

        public void dispose() {
            this.f10796yj.dispose();
        }

        public boolean isDisposed() {
            return this.f10796yj.isDisposed();
        }

        public void onComplete() {
            if (!this.f10795uk) {
                this.f10795uk = true;
                this.f10793ad.onSuccess(Boolean.TRUE);
            }
        }

        public void onError(Throwable th2) {
            if (this.f10795uk) {
                th.de.ppp.qw.ddd(th2);
                return;
            }
            this.f10795uk = true;
            this.f10793ad.onError(th2);
        }

        public void onNext(T t) {
            if (!this.f10795uk) {
                try {
                    if (!this.f10794th.test(t)) {
                        this.f10795uk = true;
                        this.f10796yj.dispose();
                        this.f10793ad.onSuccess(Boolean.FALSE);
                    }
                } catch (Throwable th2) {
                    th.de.o.qw.ad(th2);
                    this.f10796yj.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10796yj, disposable)) {
                this.f10796yj = disposable;
                this.f10793ad.onSubscribe(this);
            }
        }
    }

    public th(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        this.f10791ad = observableSource;
        this.f10792th = predicate;
    }

    public rg<Boolean> ad() {
        return th.de.ppp.qw.when(new rg(this.f10791ad, this.f10792th));
    }

    public void rg(SingleObserver<? super Boolean> singleObserver) {
        this.f10791ad.subscribe(new qw(singleObserver, this.f10792th));
    }
}
