package th.de.p039if.fe.rg;

import io.reactivex.Observer;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import th.de.p039if.ad.qw;
import th.de.rg;

/* renamed from: th.de.if.fe.rg.f  reason: invalid package */
public final class f<T> extends rg<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final Callable<? extends Throwable> f10599ad;

    public f(Callable<? extends Throwable> callable) {
        this.f10599ad = callable;
    }

    public void subscribeActual(Observer<? super T> observer) {
        try {
            Object call = this.f10599ad.call();
            qw.rg(call, "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
            th = (Throwable) call;
        } catch (Throwable th2) {
            th = th2;
            th.de.o.qw.ad(th);
        }
        EmptyDisposable.error(th, (Observer<?>) observer);
    }
}
