package th.de.p039if.th;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.RxThreadFactory;
import io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import th.de.th;

/* renamed from: th.de.if.th.qw  reason: invalid package */
public final class qw extends th implements SchedulerMultiWorkerSupport {

    /* renamed from: i  reason: collision with root package name */
    public static final RxThreadFactory f10949i;

    /* renamed from: o  reason: collision with root package name */
    public static final int f10950o = th(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());

    /* renamed from: pf  reason: collision with root package name */
    public static final de f10951pf;

    /* renamed from: uk  reason: collision with root package name */
    public static final ad f10952uk;

    /* renamed from: th  reason: collision with root package name */
    public final ThreadFactory f10953th;

    /* renamed from: yj  reason: collision with root package name */
    public final AtomicReference<ad> f10954yj;

    /* renamed from: th.de.if.th.qw$ad */
    public static final class ad implements SchedulerMultiWorkerSupport {

        /* renamed from: ad  reason: collision with root package name */
        public final int f10955ad;

        /* renamed from: th  reason: collision with root package name */
        public final de[] f10956th;

        /* renamed from: yj  reason: collision with root package name */
        public long f10957yj;

        public ad(int i2, ThreadFactory threadFactory) {
            this.f10955ad = i2;
            this.f10956th = new de[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                this.f10956th[i3] = new de(threadFactory);
            }
        }

        public void ad() {
            for (de dispose : this.f10956th) {
                dispose.dispose();
            }
        }

        public de qw() {
            int i2 = this.f10955ad;
            if (i2 == 0) {
                return qw.f10951pf;
            }
            de[] deVarArr = this.f10956th;
            long j = this.f10957yj;
            this.f10957yj = 1 + j;
            return deVarArr[(int) (j % ((long) i2))];
        }
    }

    /* renamed from: th.de.if.th.qw$de */
    public static final class de extends rg {
        public de(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    /* renamed from: th.de.if.th.qw$qw  reason: collision with other inner class name */
    public static final class C0342qw extends th.de {

        /* renamed from: ad  reason: collision with root package name */
        public final th.de.p039if.qw.qw f10958ad = new th.de.p039if.qw.qw();

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f10959i;

        /* renamed from: th  reason: collision with root package name */
        public final th.de.i.qw f10960th = new th.de.i.qw();

        /* renamed from: uk  reason: collision with root package name */
        public final de f10961uk;

        /* renamed from: yj  reason: collision with root package name */
        public final th.de.p039if.qw.qw f10962yj;

        public C0342qw(de deVar) {
            this.f10961uk = deVar;
            th.de.p039if.qw.qw qwVar = new th.de.p039if.qw.qw();
            this.f10962yj = qwVar;
            qwVar.ad(this.f10958ad);
            this.f10962yj.ad(this.f10960th);
        }

        public Disposable ad(Runnable runnable) {
            if (this.f10959i) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f10961uk.rg(runnable, 0, TimeUnit.MILLISECONDS, this.f10958ad);
        }

        public Disposable de(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.f10959i) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f10961uk.rg(runnable, j, timeUnit, this.f10960th);
        }

        public void dispose() {
            if (!this.f10959i) {
                this.f10959i = true;
                this.f10962yj.dispose();
            }
        }

        public boolean isDisposed() {
            return this.f10959i;
        }
    }

    static {
        de deVar = new de(new RxThreadFactory("RxComputationShutdown"));
        f10951pf = deVar;
        deVar.dispose();
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        f10949i = rxThreadFactory;
        ad adVar = new ad(0, rxThreadFactory);
        f10952uk = adVar;
        adVar.ad();
    }

    public qw() {
        this(f10949i);
    }

    public static int th(int i2, int i3) {
        return (i3 <= 0 || i3 > i2) ? i2 : i3;
    }

    public Disposable fe(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.f10954yj.get().qw().th(runnable, j, timeUnit);
    }

    public th.de qw() {
        return new C0342qw(this.f10954yj.get().qw());
    }

    public Disposable rg(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.f10954yj.get().qw().yj(runnable, j, j2, timeUnit);
    }

    public void yj() {
        ad adVar = new ad(f10950o, this.f10953th);
        if (!this.f10954yj.compareAndSet(f10952uk, adVar)) {
            adVar.ad();
        }
    }

    public qw(ThreadFactory threadFactory) {
        this.f10953th = threadFactory;
        this.f10954yj = new AtomicReference<>(f10952uk);
        yj();
    }
}
