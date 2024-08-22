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

/* renamed from: th.de.if.fe.rg.uk  reason: invalid package */
public final class uk<T> extends yj<Boolean> implements FuseToObservable<Boolean> {

    /* renamed from: ad  reason: collision with root package name */
    public final ObservableSource<T> f10816ad;

    /* renamed from: th  reason: collision with root package name */
    public final Predicate<? super T> f10817th;

    /* renamed from: th.de.if.fe.rg.uk$qw */
    public static final class qw<T> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final SingleObserver<? super Boolean> f10818ad;

        /* renamed from: th  reason: collision with root package name */
        public final Predicate<? super T> f10819th;

        /* renamed from: uk  reason: collision with root package name */
        public boolean f10820uk;

        /* renamed from: yj  reason: collision with root package name */
        public Disposable f10821yj;

        public qw(SingleObserver<? super Boolean> singleObserver, Predicate<? super T> predicate) {
            this.f10818ad = singleObserver;
            this.f10819th = predicate;
        }

        public void dispose() {
            this.f10821yj.dispose();
        }

        public boolean isDisposed() {
            return this.f10821yj.isDisposed();
        }

        public void onComplete() {
            if (!this.f10820uk) {
                this.f10820uk = true;
                this.f10818ad.onSuccess(Boolean.FALSE);
            }
        }

        public void onError(Throwable th2) {
            if (this.f10820uk) {
                th.de.ppp.qw.ddd(th2);
                return;
            }
            this.f10820uk = true;
            this.f10818ad.onError(th2);
        }

        public void onNext(T t) {
            if (!this.f10820uk) {
                try {
                    if (this.f10819th.test(t)) {
                        this.f10820uk = true;
                        this.f10821yj.dispose();
                        this.f10818ad.onSuccess(Boolean.TRUE);
                    }
                } catch (Throwable th2) {
                    th.de.o.qw.ad(th2);
                    this.f10821yj.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10821yj, disposable)) {
                this.f10821yj = disposable;
                this.f10818ad.onSubscribe(this);
            }
        }
    }

    public uk(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        this.f10816ad = observableSource;
        this.f10817th = predicate;
    }

    public rg<Boolean> ad() {
        return th.de.ppp.qw.when(new yj(this.f10816ad, this.f10817th));
    }

    public void rg(SingleObserver<? super Boolean> singleObserver) {
        this.f10816ad.subscribe(new qw(singleObserver, this.f10817th));
    }
}
