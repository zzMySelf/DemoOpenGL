package th.de.p039if.th;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import th.de.th;

/* renamed from: th.de.if.th.uk  reason: invalid package */
public final class uk extends th {

    /* renamed from: th  reason: collision with root package name */
    public static final uk f10969th = new uk();

    /* renamed from: th.de.if.th.uk$ad */
    public static final class ad implements Comparable<ad> {

        /* renamed from: ad  reason: collision with root package name */
        public final Runnable f10970ad;

        /* renamed from: th  reason: collision with root package name */
        public final long f10971th;

        /* renamed from: uk  reason: collision with root package name */
        public volatile boolean f10972uk;

        /* renamed from: yj  reason: collision with root package name */
        public final int f10973yj;

        public ad(Runnable runnable, Long l, int i2) {
            this.f10970ad = runnable;
            this.f10971th = l.longValue();
            this.f10973yj = i2;
        }

        /* renamed from: qw */
        public int compareTo(ad adVar) {
            int ad2 = th.de.p039if.ad.qw.ad(this.f10971th, adVar.f10971th);
            return ad2 == 0 ? th.de.p039if.ad.qw.qw(this.f10973yj, adVar.f10973yj) : ad2;
        }
    }

    /* renamed from: th.de.if.th.uk$de */
    public static final class de extends th.de implements Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final PriorityBlockingQueue<ad> f10974ad = new PriorityBlockingQueue<>();

        /* renamed from: th  reason: collision with root package name */
        public final AtomicInteger f10975th = new AtomicInteger();

        /* renamed from: uk  reason: collision with root package name */
        public volatile boolean f10976uk;

        /* renamed from: yj  reason: collision with root package name */
        public final AtomicInteger f10977yj = new AtomicInteger();

        /* renamed from: th.de.if.th.uk$de$qw */
        public final class qw implements Runnable {

            /* renamed from: ad  reason: collision with root package name */
            public final ad f10978ad;

            public qw(ad adVar) {
                this.f10978ad = adVar;
            }

            public void run() {
                this.f10978ad.f10972uk = true;
                de.this.f10974ad.remove(this.f10978ad);
            }
        }

        public Disposable ad(Runnable runnable) {
            return rg(runnable, qw(TimeUnit.MILLISECONDS));
        }

        public Disposable de(Runnable runnable, long j, TimeUnit timeUnit) {
            long qw2 = qw(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j);
            return rg(new qw(runnable, this, qw2), qw2);
        }

        public void dispose() {
            this.f10976uk = true;
        }

        public boolean isDisposed() {
            return this.f10976uk;
        }

        public Disposable rg(Runnable runnable, long j) {
            if (this.f10976uk) {
                return EmptyDisposable.INSTANCE;
            }
            ad adVar = new ad(runnable, Long.valueOf(j), this.f10977yj.incrementAndGet());
            this.f10974ad.add(adVar);
            if (this.f10975th.getAndIncrement() != 0) {
                return th.de.i.ad.ad(new qw(adVar));
            }
            int i2 = 1;
            while (!this.f10976uk) {
                ad poll = this.f10974ad.poll();
                if (poll == null) {
                    i2 = this.f10975th.addAndGet(-i2);
                    if (i2 == 0) {
                        return EmptyDisposable.INSTANCE;
                    }
                } else if (!poll.f10972uk) {
                    poll.f10970ad.run();
                }
            }
            this.f10974ad.clear();
            return EmptyDisposable.INSTANCE;
        }
    }

    /* renamed from: th.de.if.th.uk$qw */
    public static final class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final Runnable f10980ad;

        /* renamed from: th  reason: collision with root package name */
        public final de f10981th;

        /* renamed from: yj  reason: collision with root package name */
        public final long f10982yj;

        public qw(Runnable runnable, de deVar, long j) {
            this.f10980ad = runnable;
            this.f10981th = deVar;
            this.f10982yj = j;
        }

        public void run() {
            if (!this.f10981th.f10976uk) {
                long qw = this.f10981th.qw(TimeUnit.MILLISECONDS);
                long j = this.f10982yj;
                if (j > qw) {
                    try {
                        Thread.sleep(j - qw);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        th.de.ppp.qw.ddd(e);
                        return;
                    }
                }
                if (!this.f10981th.f10976uk) {
                    this.f10980ad.run();
                }
            }
        }
    }

    public static uk th() {
        return f10969th;
    }

    public Disposable de(Runnable runnable) {
        th.de.ppp.qw.mmm(runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    public Disposable fe(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            th.de.ppp.qw.mmm(runnable).run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            th.de.ppp.qw.ddd(e);
        }
        return EmptyDisposable.INSTANCE;
    }

    public th.de qw() {
        return new de();
    }
}
