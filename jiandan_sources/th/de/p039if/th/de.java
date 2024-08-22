package th.de.p039if.th;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.RxThreadFactory;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import th.de.th;

/* renamed from: th.de.if.th.de  reason: invalid package */
public final class de extends th {

    /* renamed from: i  reason: collision with root package name */
    public static final RxThreadFactory f10930i;

    /* renamed from: if  reason: not valid java name */
    public static final C0341de f518if;

    /* renamed from: o  reason: collision with root package name */
    public static final long f10931o = Long.getLong("rx2.io-keep-alive-time", 60).longValue();

    /* renamed from: pf  reason: collision with root package name */
    public static final TimeUnit f10932pf = TimeUnit.SECONDS;

    /* renamed from: switch  reason: not valid java name */
    public static final qw f519switch;

    /* renamed from: uk  reason: collision with root package name */
    public static final RxThreadFactory f10933uk;

    /* renamed from: th  reason: collision with root package name */
    public final ThreadFactory f10934th;

    /* renamed from: yj  reason: collision with root package name */
    public final AtomicReference<qw> f10935yj;

    /* renamed from: th.de.if.th.de$ad */
    public static final class ad extends th.de {

        /* renamed from: ad  reason: collision with root package name */
        public final th.de.i.qw f10936ad;

        /* renamed from: th  reason: collision with root package name */
        public final qw f10937th;

        /* renamed from: uk  reason: collision with root package name */
        public final AtomicBoolean f10938uk = new AtomicBoolean();

        /* renamed from: yj  reason: collision with root package name */
        public final C0341de f10939yj;

        public ad(qw qwVar) {
            this.f10937th = qwVar;
            this.f10936ad = new th.de.i.qw();
            this.f10939yj = qwVar.ad();
        }

        public Disposable de(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.f10936ad.isDisposed()) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f10939yj.rg(runnable, j, timeUnit, this.f10936ad);
        }

        public void dispose() {
            if (this.f10938uk.compareAndSet(false, true)) {
                this.f10936ad.dispose();
                this.f10937th.fe(this.f10939yj);
            }
        }

        public boolean isDisposed() {
            return this.f10938uk.get();
        }
    }

    /* renamed from: th.de.if.th.de$de  reason: collision with other inner class name */
    public static final class C0341de extends rg {

        /* renamed from: yj  reason: collision with root package name */
        public long f10940yj = 0;

        public C0341de(ThreadFactory threadFactory) {
            super(threadFactory);
        }

        public long i() {
            return this.f10940yj;
        }

        public void o(long j) {
            this.f10940yj = j;
        }
    }

    /* renamed from: th.de.if.th.de$qw */
    public static final class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final long f10941ad;

        /* renamed from: i  reason: collision with root package name */
        public final Future<?> f10942i;

        /* renamed from: o  reason: collision with root package name */
        public final ThreadFactory f10943o;

        /* renamed from: th  reason: collision with root package name */
        public final ConcurrentLinkedQueue<C0341de> f10944th;

        /* renamed from: uk  reason: collision with root package name */
        public final ScheduledExecutorService f10945uk;

        /* renamed from: yj  reason: collision with root package name */
        public final th.de.i.qw f10946yj;

        public qw(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            this.f10941ad = timeUnit != null ? timeUnit.toNanos(j) : 0;
            this.f10944th = new ConcurrentLinkedQueue<>();
            this.f10946yj = new th.de.i.qw();
            this.f10943o = threadFactory;
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, de.f10930i);
                long j2 = this.f10941ad;
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, j2, j2, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f10945uk = scheduledExecutorService;
            this.f10942i = scheduledFuture;
        }

        public C0341de ad() {
            if (this.f10946yj.isDisposed()) {
                return de.f518if;
            }
            while (!this.f10944th.isEmpty()) {
                C0341de poll = this.f10944th.poll();
                if (poll != null) {
                    return poll;
                }
            }
            C0341de deVar = new C0341de(this.f10943o);
            this.f10946yj.ad(deVar);
            return deVar;
        }

        public long de() {
            return System.nanoTime();
        }

        public void fe(C0341de deVar) {
            deVar.o(de() + this.f10941ad);
            this.f10944th.offer(deVar);
        }

        public void qw() {
            if (!this.f10944th.isEmpty()) {
                long de2 = de();
                Iterator<C0341de> it = this.f10944th.iterator();
                while (it.hasNext()) {
                    C0341de next = it.next();
                    if (next.i() > de2) {
                        return;
                    }
                    if (this.f10944th.remove(next)) {
                        this.f10946yj.qw(next);
                    }
                }
            }
        }

        public void rg() {
            this.f10946yj.dispose();
            Future<?> future = this.f10942i;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f10945uk;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        public void run() {
            qw();
        }
    }

    static {
        C0341de deVar = new C0341de(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        f518if = deVar;
        deVar.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        f10933uk = new RxThreadFactory("RxCachedThreadScheduler", max);
        f10930i = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        qw qwVar = new qw(0, (TimeUnit) null, f10933uk);
        f519switch = qwVar;
        qwVar.rg();
    }

    public de() {
        this(f10933uk);
    }

    public th.de qw() {
        return new ad(this.f10935yj.get());
    }

    public void th() {
        qw qwVar = new qw(f10931o, f10932pf, this.f10934th);
        if (!this.f10935yj.compareAndSet(f519switch, qwVar)) {
            qwVar.rg();
        }
    }

    public de(ThreadFactory threadFactory) {
        this.f10934th = threadFactory;
        this.f10935yj = new AtomicReference<>(f519switch);
        th();
    }
}
