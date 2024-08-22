package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import th.de.yj;

/* renamed from: th.de.if.fe.rg.f0  reason: invalid package */
public final class f0<T, R> extends yj<R> {

    /* renamed from: ad  reason: collision with root package name */
    public final ObservableSource<T> f10600ad;

    /* renamed from: th  reason: collision with root package name */
    public final R f10601th;

    /* renamed from: yj  reason: collision with root package name */
    public final BiFunction<R, ? super T, R> f10602yj;

    /* renamed from: th.de.if.fe.rg.f0$qw */
    public static final class qw<T, R> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final SingleObserver<? super R> f10603ad;

        /* renamed from: th  reason: collision with root package name */
        public final BiFunction<R, ? super T, R> f10604th;

        /* renamed from: uk  reason: collision with root package name */
        public Disposable f10605uk;

        /* renamed from: yj  reason: collision with root package name */
        public R f10606yj;

        public qw(SingleObserver<? super R> singleObserver, BiFunction<R, ? super T, R> biFunction, R r) {
            this.f10603ad = singleObserver;
            this.f10606yj = r;
            this.f10604th = biFunction;
        }

        public void dispose() {
            this.f10605uk.dispose();
        }

        public boolean isDisposed() {
            return this.f10605uk.isDisposed();
        }

        public void onComplete() {
            R r = this.f10606yj;
            if (r != null) {
                this.f10606yj = null;
                this.f10603ad.onSuccess(r);
            }
        }

        public void onError(Throwable th2) {
            if (this.f10606yj != null) {
                this.f10606yj = null;
                this.f10603ad.onError(th2);
                return;
            }
            th.de.ppp.qw.ddd(th2);
        }

        public void onNext(T t) {
            R r = this.f10606yj;
            if (r != null) {
                try {
                    R apply = this.f10604th.apply(r, t);
                    th.de.p039if.ad.qw.rg(apply, "The reducer returned a null value");
                    this.f10606yj = apply;
                } catch (Throwable th2) {
                    th.de.o.qw.ad(th2);
                    this.f10605uk.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10605uk, disposable)) {
                this.f10605uk = disposable;
                this.f10603ad.onSubscribe(this);
            }
        }
    }

    public f0(ObservableSource<T> observableSource, R r, BiFunction<R, ? super T, R> biFunction) {
        this.f10600ad = observableSource;
        this.f10601th = r;
        this.f10602yj = biFunction;
    }

    public void rg(SingleObserver<? super R> singleObserver) {
        this.f10600ad.subscribe(new qw(singleObserver, this.f10602yj, this.f10601th));
    }
}
