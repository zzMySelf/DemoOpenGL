package th.de.p039if.th;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
import th.de.ppp.qw;

/* renamed from: th.de.if.th.ad  reason: invalid package */
public final class ad implements Callable<Void>, Disposable {

    /* renamed from: o  reason: collision with root package name */
    public static final FutureTask<Void> f10924o = new FutureTask<>(Functions.f9948ad, (Object) null);

    /* renamed from: ad  reason: collision with root package name */
    public final Runnable f10925ad;

    /* renamed from: i  reason: collision with root package name */
    public Thread f10926i;

    /* renamed from: th  reason: collision with root package name */
    public final AtomicReference<Future<?>> f10927th = new AtomicReference<>();

    /* renamed from: uk  reason: collision with root package name */
    public final ExecutorService f10928uk;

    /* renamed from: yj  reason: collision with root package name */
    public final AtomicReference<Future<?>> f10929yj = new AtomicReference<>();

    public ad(Runnable runnable, ExecutorService executorService) {
        this.f10925ad = runnable;
        this.f10928uk = executorService;
    }

    public void ad(Future<?> future) {
        Future future2;
        do {
            future2 = this.f10929yj.get();
            if (future2 == f10924o) {
                future.cancel(this.f10926i != Thread.currentThread());
                return;
            }
        } while (!this.f10929yj.compareAndSet(future2, future));
    }

    public void dispose() {
        Future andSet = this.f10929yj.getAndSet(f10924o);
        boolean z = true;
        if (!(andSet == null || andSet == f10924o)) {
            andSet.cancel(this.f10926i != Thread.currentThread());
        }
        Future andSet2 = this.f10927th.getAndSet(f10924o);
        if (andSet2 != null && andSet2 != f10924o) {
            if (this.f10926i == Thread.currentThread()) {
                z = false;
            }
            andSet2.cancel(z);
        }
    }

    public void fe(Future<?> future) {
        Future future2;
        do {
            future2 = this.f10927th.get();
            if (future2 == f10924o) {
                future.cancel(this.f10926i != Thread.currentThread());
                return;
            }
        } while (!this.f10927th.compareAndSet(future2, future));
    }

    public boolean isDisposed() {
        return this.f10929yj.get() == f10924o;
    }

    /* renamed from: qw */
    public Void call() throws Exception {
        this.f10926i = Thread.currentThread();
        try {
            this.f10925ad.run();
            fe(this.f10928uk.submit(this));
            this.f10926i = null;
        } catch (Throwable th2) {
            this.f10926i = null;
            qw.ddd(th2);
        }
        return null;
    }
}
