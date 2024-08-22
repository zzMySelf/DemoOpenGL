package th.de.p039if.th;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.ScheduledDirectPeriodicTask;
import io.reactivex.internal.schedulers.ScheduledDirectTask;
import io.reactivex.internal.schedulers.ScheduledRunnable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import th.de.ppp.qw;
import th.de.th;

/* renamed from: th.de.if.th.rg  reason: invalid package */
public class rg extends th.de implements Disposable {

    /* renamed from: ad  reason: collision with root package name */
    public final ScheduledExecutorService f10963ad;

    /* renamed from: th  reason: collision with root package name */
    public volatile boolean f10964th;

    public rg(ThreadFactory threadFactory) {
        this.f10963ad = th.qw(threadFactory);
    }

    public Disposable ad(Runnable runnable) {
        return de(runnable, 0, (TimeUnit) null);
    }

    public Disposable de(Runnable runnable, long j, TimeUnit timeUnit) {
        if (this.f10964th) {
            return EmptyDisposable.INSTANCE;
        }
        return rg(runnable, j, timeUnit, (DisposableContainer) null);
    }

    public void dispose() {
        if (!this.f10964th) {
            this.f10964th = true;
            this.f10963ad.shutdownNow();
        }
    }

    public boolean isDisposed() {
        return this.f10964th;
    }

    public ScheduledRunnable rg(Runnable runnable, long j, TimeUnit timeUnit, DisposableContainer disposableContainer) {
        Future future;
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(qw.mmm(runnable), disposableContainer);
        if (disposableContainer != null && !disposableContainer.ad(scheduledRunnable)) {
            return scheduledRunnable;
        }
        if (j <= 0) {
            try {
                future = this.f10963ad.submit(scheduledRunnable);
            } catch (RejectedExecutionException e) {
                if (disposableContainer != null) {
                    disposableContainer.qw(scheduledRunnable);
                }
                qw.ddd(e);
            }
        } else {
            future = this.f10963ad.schedule(scheduledRunnable, j, timeUnit);
        }
        scheduledRunnable.setFuture(future);
        return scheduledRunnable;
    }

    public Disposable th(Runnable runnable, long j, TimeUnit timeUnit) {
        Future future;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(qw.mmm(runnable));
        if (j <= 0) {
            try {
                future = this.f10963ad.submit(scheduledDirectTask);
            } catch (RejectedExecutionException e) {
                qw.ddd(e);
                return EmptyDisposable.INSTANCE;
            }
        } else {
            future = this.f10963ad.schedule(scheduledDirectTask, j, timeUnit);
        }
        scheduledDirectTask.setFuture(future);
        return scheduledDirectTask;
    }

    public void uk() {
        if (!this.f10964th) {
            this.f10964th = true;
            this.f10963ad.shutdown();
        }
    }

    public Disposable yj(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Future future;
        Runnable mmm = qw.mmm(runnable);
        if (j2 <= 0) {
            ad adVar = new ad(mmm, this.f10963ad);
            if (j <= 0) {
                try {
                    future = this.f10963ad.submit(adVar);
                } catch (RejectedExecutionException e) {
                    qw.ddd(e);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                future = this.f10963ad.schedule(adVar, j, timeUnit);
            }
            adVar.ad(future);
            return adVar;
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(mmm);
        try {
            scheduledDirectPeriodicTask.setFuture(this.f10963ad.scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e2) {
            qw.ddd(e2);
            return EmptyDisposable.INSTANCE;
        }
    }
}
