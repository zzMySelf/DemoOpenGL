package th.de.p039if.fe.rg;

import io.reactivex.Observer;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import th.de.p039if.ad.qw;
import th.de.rg;

/* renamed from: th.de.if.fe.rg.l  reason: invalid package */
public final class l<T> extends rg<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final Future<? extends T> f10668ad;

    /* renamed from: th  reason: collision with root package name */
    public final long f10669th;

    /* renamed from: yj  reason: collision with root package name */
    public final TimeUnit f10670yj;

    public l(Future<? extends T> future, long j, TimeUnit timeUnit) {
        this.f10668ad = future;
        this.f10669th = j;
        this.f10670yj = timeUnit;
    }

    public void subscribeActual(Observer<? super T> observer) {
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(observer);
        observer.onSubscribe(deferredScalarDisposable);
        if (!deferredScalarDisposable.isDisposed()) {
            try {
                Object obj = this.f10670yj != null ? this.f10668ad.get(this.f10669th, this.f10670yj) : this.f10668ad.get();
                qw.rg(obj, "Future returned null");
                deferredScalarDisposable.complete(obj);
            } catch (Throwable th2) {
                th.de.o.qw.ad(th2);
                if (!deferredScalarDisposable.isDisposed()) {
                    observer.onError(th2);
                }
            }
        }
    }
}
