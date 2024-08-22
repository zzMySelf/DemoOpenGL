package p041if.rg.de;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p041if.pf.fe;
import p041if.qw;
import p041if.rg.fe.yj;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.schedulers.SchedulerLifecycle;
import rx.internal.util.RxThreadFactory;

/* renamed from: if.rg.de.ad  reason: invalid package */
public final class ad extends p041if.qw implements SchedulerLifecycle {

    /* renamed from: i  reason: collision with root package name */
    public static final C0351ad f11148i = new C0351ad((ThreadFactory) null, 0);

    /* renamed from: uk  reason: collision with root package name */
    public static final de f11149uk;

    /* renamed from: yj  reason: collision with root package name */
    public static final int f11150yj;

    /* renamed from: ad  reason: collision with root package name */
    public final ThreadFactory f11151ad;

    /* renamed from: th  reason: collision with root package name */
    public final AtomicReference<C0351ad> f11152th = new AtomicReference<>(f11148i);

    /* renamed from: if.rg.de.ad$ad  reason: collision with other inner class name */
    public static final class C0351ad {

        /* renamed from: ad  reason: collision with root package name */
        public final de[] f11153ad;

        /* renamed from: de  reason: collision with root package name */
        public long f11154de;
        public final int qw;

        public C0351ad(ThreadFactory threadFactory, int i2) {
            this.qw = i2;
            this.f11153ad = new de[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                this.f11153ad[i3] = new de(threadFactory);
            }
        }

        public void ad() {
            for (de unsubscribe : this.f11153ad) {
                unsubscribe.unsubscribe();
            }
        }

        public de qw() {
            int i2 = this.qw;
            if (i2 == 0) {
                return ad.f11149uk;
            }
            de[] deVarArr = this.f11153ad;
            long j = this.f11154de;
            this.f11154de = 1 + j;
            return deVarArr[(int) (j % ((long) i2))];
        }
    }

    /* renamed from: if.rg.de.ad$de */
    public static final class de extends fe {
        public de(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    /* renamed from: if.rg.de.ad$qw */
    public static final class qw extends qw.C0349qw {

        /* renamed from: ad  reason: collision with root package name */
        public final yj f11155ad = new yj();

        /* renamed from: th  reason: collision with root package name */
        public final p041if.pf.ad f11156th;

        /* renamed from: uk  reason: collision with root package name */
        public final de f11157uk;

        /* renamed from: yj  reason: collision with root package name */
        public final yj f11158yj;

        /* renamed from: if.rg.de.ad$qw$ad  reason: collision with other inner class name */
        public class C0352ad implements Action0 {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ Action0 f11159ad;

            public C0352ad(Action0 action0) {
                this.f11159ad = action0;
            }

            public void call() {
                if (!qw.this.isUnsubscribed()) {
                    this.f11159ad.call();
                }
            }
        }

        /* renamed from: if.rg.de.ad$qw$qw  reason: collision with other inner class name */
        public class C0353qw implements Action0 {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ Action0 f11161ad;

            public C0353qw(Action0 action0) {
                this.f11161ad = action0;
            }

            public void call() {
                if (!qw.this.isUnsubscribed()) {
                    this.f11161ad.call();
                }
            }
        }

        public qw(de deVar) {
            p041if.pf.ad adVar = new p041if.pf.ad();
            this.f11156th = adVar;
            this.f11158yj = new yj(this.f11155ad, adVar);
            this.f11157uk = deVar;
        }

        public Subscription de(Action0 action0) {
            if (isUnsubscribed()) {
                return fe.ad();
            }
            return this.f11157uk.o(new C0353qw(action0), 0, (TimeUnit) null, this.f11155ad);
        }

        public Subscription fe(Action0 action0, long j, TimeUnit timeUnit) {
            if (isUnsubscribed()) {
                return fe.ad();
            }
            return this.f11157uk.pf(new C0352ad(action0), j, timeUnit, this.f11156th);
        }

        public boolean isUnsubscribed() {
            return this.f11158yj.isUnsubscribed();
        }

        public void unsubscribe() {
            this.f11158yj.unsubscribe();
        }
    }

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        f11150yj = intValue;
        de deVar = new de(RxThreadFactory.NONE);
        f11149uk = deVar;
        deVar.unsubscribe();
    }

    public ad(ThreadFactory threadFactory) {
        this.f11151ad = threadFactory;
        fe();
    }

    public Subscription de(Action0 action0) {
        return this.f11152th.get().qw().i(action0, -1, TimeUnit.NANOSECONDS);
    }

    public void fe() {
        C0351ad adVar = new C0351ad(this.f11151ad, f11150yj);
        if (!this.f11152th.compareAndSet(f11148i, adVar)) {
            adVar.ad();
        }
    }

    public qw.C0349qw qw() {
        return new qw(this.f11152th.get().qw());
    }

    public void shutdown() {
        C0351ad adVar;
        C0351ad adVar2;
        do {
            adVar = this.f11152th.get();
            adVar2 = f11148i;
            if (adVar == adVar2) {
                return;
            }
        } while (!this.f11152th.compareAndSet(adVar, adVar2));
        adVar.ad();
    }
}
