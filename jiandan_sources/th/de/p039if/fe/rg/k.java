package th.de.p039if.fe.rg;

import io.reactivex.Observer;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import java.util.concurrent.Callable;
import th.de.p039if.ad.qw;
import th.de.rg;

/* renamed from: th.de.if.fe.rg.k  reason: invalid package */
public final class k<T> extends rg<T> implements Callable<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final Callable<? extends T> f10662ad;

    public k(Callable<? extends T> callable) {
        this.f10662ad = callable;
    }

    public T call() throws Exception {
        T call = this.f10662ad.call();
        qw.rg(call, "The callable returned a null value");
        return call;
    }

    public void subscribeActual(Observer<? super T> observer) {
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(observer);
        observer.onSubscribe(deferredScalarDisposable);
        if (!deferredScalarDisposable.isDisposed()) {
            try {
                Object call = this.f10662ad.call();
                qw.rg(call, "Callable returned null");
                deferredScalarDisposable.complete(call);
            } catch (Throwable th2) {
                th.de.o.qw.ad(th2);
                if (!deferredScalarDisposable.isDisposed()) {
                    observer.onError(th2);
                } else {
                    th.de.ppp.qw.ddd(th2);
                }
            }
        }
    }
}
