package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import th.de.p039if.ad.qw;
import th.de.rg;

/* renamed from: th.de.if.fe.rg.xxx  reason: invalid package */
public final class xxx<T> extends rg<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final Callable<? extends ObservableSource<? extends T>> f10871ad;

    public xxx(Callable<? extends ObservableSource<? extends T>> callable) {
        this.f10871ad = callable;
    }

    public void subscribeActual(Observer<? super T> observer) {
        try {
            Object call = this.f10871ad.call();
            qw.rg(call, "null ObservableSource supplied");
            ((ObservableSource) call).subscribe(observer);
        } catch (Throwable th2) {
            th.de.o.qw.ad(th2);
            EmptyDisposable.error(th2, (Observer<?>) observer);
        }
    }
}
