package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.SingleObserver;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import th.de.p039if.ad.qw;
import th.de.p039if.fe.rg.f0;
import th.de.yj;

/* renamed from: th.de.if.fe.rg.g0  reason: invalid package */
public final class g0<T, R> extends yj<R> {

    /* renamed from: ad  reason: collision with root package name */
    public final ObservableSource<T> f10619ad;

    /* renamed from: th  reason: collision with root package name */
    public final Callable<R> f10620th;

    /* renamed from: yj  reason: collision with root package name */
    public final BiFunction<R, ? super T, R> f10621yj;

    public g0(ObservableSource<T> observableSource, Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        this.f10619ad = observableSource;
        this.f10620th = callable;
        this.f10621yj = biFunction;
    }

    public void rg(SingleObserver<? super R> singleObserver) {
        try {
            R call = this.f10620th.call();
            qw.rg(call, "The seedSupplier returned a null value");
            this.f10619ad.subscribe(new f0.qw(singleObserver, this.f10621yj, call));
        } catch (Throwable th2) {
            th.de.o.qw.ad(th2);
            EmptyDisposable.error(th2, (SingleObserver<?>) singleObserver);
        }
    }
}
