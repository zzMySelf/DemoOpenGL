package p041if.rg.de;

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
import p041if.pf.fe;
import p041if.qw;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.schedulers.ScheduledAction;
import rx.internal.schedulers.SchedulerLifecycle;
import rx.internal.util.RxThreadFactory;

/* renamed from: if.rg.de.qw  reason: invalid package */
public final class qw extends p041if.qw implements SchedulerLifecycle {

    /* renamed from: i  reason: collision with root package name */
    public static final de f11170i;

    /* renamed from: o  reason: collision with root package name */
    public static final C0355qw f11171o;

    /* renamed from: uk  reason: collision with root package name */
    public static final TimeUnit f11172uk = TimeUnit.SECONDS;

    /* renamed from: yj  reason: collision with root package name */
    public static final long f11173yj = ((long) Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue());

    /* renamed from: ad  reason: collision with root package name */
    public final ThreadFactory f11174ad;

    /* renamed from: th  reason: collision with root package name */
    public final AtomicReference<C0355qw> f11175th = new AtomicReference<>(f11171o);

    /* renamed from: if.rg.de.qw$ad */
    public static final class ad extends qw.C0349qw implements Action0 {

        /* renamed from: ad  reason: collision with root package name */
        public final p041if.pf.ad f11176ad = new p041if.pf.ad();

        /* renamed from: th  reason: collision with root package name */
        public final C0355qw f11177th;

        /* renamed from: uk  reason: collision with root package name */
        public final AtomicBoolean f11178uk;

        /* renamed from: yj  reason: collision with root package name */
        public final de f11179yj;

        /* renamed from: if.rg.de.qw$ad$qw  reason: collision with other inner class name */
        public class C0354qw implements Action0 {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ Action0 f11180ad;

            public C0354qw(Action0 action0) {
                this.f11180ad = action0;
            }

            public void call() {
                if (!ad.this.isUnsubscribed()) {
                    this.f11180ad.call();
                }
            }
        }

        public ad(C0355qw qwVar) {
            this.f11177th = qwVar;
            this.f11178uk = new AtomicBoolean();
            this.f11179yj = qwVar.ad();
        }

        public void call() {
            this.f11177th.fe(this.f11179yj);
        }

        public Subscription de(Action0 action0) {
            return fe(action0, 0, (TimeUnit) null);
        }

        public Subscription fe(Action0 action0, long j, TimeUnit timeUnit) {
            if (this.f11176ad.isUnsubscribed()) {
                return fe.ad();
            }
            ScheduledAction i2 = this.f11179yj.i(new C0354qw(action0), j, timeUnit);
            this.f11176ad.qw(i2);
            i2.addParent(this.f11176ad);
            return i2;
        }

        public boolean isUnsubscribed() {
            return this.f11176ad.isUnsubscribed();
        }

        public void unsubscribe() {
            if (this.f11178uk.compareAndSet(false, true)) {
                this.f11179yj.de(this);
            }
            this.f11176ad.unsubscribe();
        }
    }

    /* renamed from: if.rg.de.qw$de */
    public static final class de extends fe {

        /* renamed from: switch  reason: not valid java name */
        public long f528switch = 0;

        public de(ThreadFactory threadFactory) {
            super(threadFactory);
        }

        /* renamed from: switch  reason: not valid java name */
        public long m2364switch() {
            return this.f528switch;
        }

        public void when(long j) {
            this.f528switch = j;
        }
    }

    /* renamed from: if.rg.de.qw$qw  reason: collision with other inner class name */
    public static final class C0355qw {

        /* renamed from: ad  reason: collision with root package name */
        public final long f11182ad;

        /* renamed from: de  reason: collision with root package name */
        public final ConcurrentLinkedQueue<de> f11183de;

        /* renamed from: fe  reason: collision with root package name */
        public final p041if.pf.ad f11184fe;
        public final ThreadFactory qw;

        /* renamed from: rg  reason: collision with root package name */
        public final ScheduledExecutorService f11185rg;

        /* renamed from: th  reason: collision with root package name */
        public final Future<?> f11186th;

        /* renamed from: if.rg.de.qw$qw$ad */
        public class ad implements Runnable {
            public ad() {
            }

            public void run() {
                C0355qw.this.qw();
            }
        }

        /* renamed from: if.rg.de.qw$qw$qw  reason: collision with other inner class name */
        public class C0356qw implements ThreadFactory {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ ThreadFactory f11188ad;

            public C0356qw(C0355qw qwVar, ThreadFactory threadFactory) {
                this.f11188ad = threadFactory;
            }

            public Thread newThread(Runnable runnable) {
                Thread newThread = this.f11188ad.newThread(runnable);
                newThread.setName(newThread.getName() + " (Evictor)");
                return newThread;
            }
        }

        public C0355qw(ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            this.qw = threadFactory;
            this.f11182ad = timeUnit != null ? timeUnit.toNanos(j) : 0;
            this.f11183de = new ConcurrentLinkedQueue<>();
            this.f11184fe = new p041if.pf.ad();
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, new C0356qw(this, threadFactory));
                fe.m2363if(scheduledExecutorService);
                ad adVar = new ad();
                long j2 = this.f11182ad;
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(adVar, j2, j2, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f11185rg = scheduledExecutorService;
            this.f11186th = scheduledFuture;
        }

        public de ad() {
            if (this.f11184fe.isUnsubscribed()) {
                return qw.f11170i;
            }
            while (!this.f11183de.isEmpty()) {
                de poll = this.f11183de.poll();
                if (poll != null) {
                    return poll;
                }
            }
            de deVar = new de(this.qw);
            this.f11184fe.qw(deVar);
            return deVar;
        }

        public long de() {
            return System.nanoTime();
        }

        public void fe(de deVar) {
            deVar.when(de() + this.f11182ad);
            this.f11183de.offer(deVar);
        }

        public void qw() {
            if (!this.f11183de.isEmpty()) {
                long de2 = de();
                Iterator<de> it = this.f11183de.iterator();
                while (it.hasNext()) {
                    de next = it.next();
                    if (next.m2364switch() > de2) {
                        return;
                    }
                    if (this.f11183de.remove(next)) {
                        this.f11184fe.ad(next);
                    }
                }
            }
        }

        public void rg() {
            try {
                if (this.f11186th != null) {
                    this.f11186th.cancel(true);
                }
                if (this.f11185rg != null) {
                    this.f11185rg.shutdownNow();
                }
            } finally {
                this.f11184fe.unsubscribe();
            }
        }
    }

    static {
        de deVar = new de(RxThreadFactory.NONE);
        f11170i = deVar;
        deVar.unsubscribe();
        C0355qw qwVar = new C0355qw((ThreadFactory) null, 0, (TimeUnit) null);
        f11171o = qwVar;
        qwVar.rg();
    }

    public qw(ThreadFactory threadFactory) {
        this.f11174ad = threadFactory;
        de();
    }

    public void de() {
        C0355qw qwVar = new C0355qw(this.f11174ad, f11173yj, f11172uk);
        if (!this.f11175th.compareAndSet(f11171o, qwVar)) {
            qwVar.rg();
        }
    }

    public qw.C0349qw qw() {
        return new ad(this.f11175th.get());
    }

    public void shutdown() {
        C0355qw qwVar;
        C0355qw qwVar2;
        do {
            qwVar = this.f11175th.get();
            qwVar2 = f11171o;
            if (qwVar == qwVar2) {
                return;
            }
        } while (!this.f11175th.compareAndSet(qwVar, qwVar2));
        qwVar.rg();
    }
}
