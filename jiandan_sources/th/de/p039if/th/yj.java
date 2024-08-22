package th.de.p039if.th;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.RxThreadFactory;
import io.reactivex.internal.schedulers.ScheduledDirectPeriodicTask;
import io.reactivex.internal.schedulers.ScheduledDirectTask;
import io.reactivex.internal.schedulers.ScheduledRunnable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import th.de.th;

/* renamed from: th.de.if.th.yj  reason: invalid package */
public final class yj extends th {

    /* renamed from: uk  reason: collision with root package name */
    public static final ScheduledExecutorService f10983uk;

    /* renamed from: yj  reason: collision with root package name */
    public static final RxThreadFactory f10984yj = new RxThreadFactory("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);

    /* renamed from: th  reason: collision with root package name */
    public final AtomicReference<ScheduledExecutorService> f10985th;

    /* renamed from: th.de.if.th.yj$qw */
    public static final class qw extends th.de {

        /* renamed from: ad  reason: collision with root package name */
        public final ScheduledExecutorService f10986ad;

        /* renamed from: th  reason: collision with root package name */
        public final th.de.i.qw f10987th = new th.de.i.qw();

        /* renamed from: yj  reason: collision with root package name */
        public volatile boolean f10988yj;

        public qw(ScheduledExecutorService scheduledExecutorService) {
            this.f10986ad = scheduledExecutorService;
        }

        public Disposable de(Runnable runnable, long j, TimeUnit timeUnit) {
            Future future;
            if (this.f10988yj) {
                return EmptyDisposable.INSTANCE;
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(th.de.ppp.qw.mmm(runnable), this.f10987th);
            this.f10987th.ad(scheduledRunnable);
            if (j <= 0) {
                try {
                    future = this.f10986ad.submit(scheduledRunnable);
                } catch (RejectedExecutionException e) {
                    dispose();
                    th.de.ppp.qw.ddd(e);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                future = this.f10986ad.schedule(scheduledRunnable, j, timeUnit);
            }
            scheduledRunnable.setFuture(future);
            return scheduledRunnable;
        }

        public void dispose() {
            if (!this.f10988yj) {
                this.f10988yj = true;
                this.f10987th.dispose();
            }
        }

        public boolean isDisposed() {
            return this.f10988yj;
        }
    }

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f10983uk = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
    }

    public yj() {
        this(f10984yj);
    }

    public static ScheduledExecutorService th(ThreadFactory threadFactory) {
        return th.qw(threadFactory);
    }

    public Disposable fe(Runnable runnable, long j, TimeUnit timeUnit) {
        Future future;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(th.de.ppp.qw.mmm(runnable));
        if (j <= 0) {
            try {
                future = this.f10985th.get().submit(scheduledDirectTask);
            } catch (RejectedExecutionException e) {
                th.de.ppp.qw.ddd(e);
                return EmptyDisposable.INSTANCE;
            }
        } else {
            future = this.f10985th.get().schedule(scheduledDirectTask, j, timeUnit);
        }
        scheduledDirectTask.setFuture(future);
        return scheduledDirectTask;
    }

    public th.de qw() {
        return new qw(this.f10985th.get());
    }

    public Disposable rg(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Future future;
        Runnable mmm = th.de.ppp.qw.mmm(runnable);
        if (j2 <= 0) {
            ScheduledExecutorService scheduledExecutorService = this.f10985th.get();
            ad adVar = new ad(mmm, scheduledExecutorService);
            if (j <= 0) {
                try {
                    future = scheduledExecutorService.submit(adVar);
                } catch (RejectedExecutionException e) {
                    th.de.ppp.qw.ddd(e);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                future = scheduledExecutorService.schedule(adVar, j, timeUnit);
            }
            adVar.ad(future);
            return adVar;
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(mmm);
        try {
            scheduledDirectPeriodicTask.setFuture(this.f10985th.get().scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e2) {
            th.de.ppp.qw.ddd(e2);
            return EmptyDisposable.INSTANCE;
        }
    }

    public yj(ThreadFactory threadFactory) {
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<>();
        this.f10985th = atomicReference;
        atomicReference.lazySet(th(threadFactory));
    }
}
