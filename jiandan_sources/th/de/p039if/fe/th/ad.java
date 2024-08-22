package th.de.p039if.fe.th;

import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import th.de.yj;

/* renamed from: th.de.if.fe.th.ad  reason: invalid package */
public final class ad<T, R> extends yj<R> {

    /* renamed from: ad  reason: collision with root package name */
    public final SingleSource<? extends T> f10909ad;

    /* renamed from: th  reason: collision with root package name */
    public final Function<? super T, ? extends R> f10910th;

    /* renamed from: th.de.if.fe.th.ad$qw */
    public static final class qw<T, R> implements SingleObserver<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final SingleObserver<? super R> f10911ad;

        /* renamed from: th  reason: collision with root package name */
        public final Function<? super T, ? extends R> f10912th;

        public qw(SingleObserver<? super R> singleObserver, Function<? super T, ? extends R> function) {
            this.f10911ad = singleObserver;
            this.f10912th = function;
        }

        public void onError(Throwable th2) {
            this.f10911ad.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            this.f10911ad.onSubscribe(disposable);
        }

        public void onSuccess(T t) {
            try {
                Object apply = this.f10912th.apply(t);
                th.de.p039if.ad.qw.rg(apply, "The mapper function returned a null value.");
                this.f10911ad.onSuccess(apply);
            } catch (Throwable th2) {
                th.de.o.qw.ad(th2);
                onError(th2);
            }
        }
    }

    public ad(SingleSource<? extends T> singleSource, Function<? super T, ? extends R> function) {
        this.f10909ad = singleSource;
        this.f10910th = function;
    }

    public void rg(SingleObserver<? super R> singleObserver) {
        this.f10909ad.qw(new qw(singleObserver, this.f10910th));
    }
}
