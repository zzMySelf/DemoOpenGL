package fe.mmm.qw.c;

import androidx.annotation.NonNull;
import com.tera.scan.startup.OnProjectListener;
import com.tera.scan.startup.StartupTaskListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public AtomicInteger f7658ad;

    /* renamed from: de  reason: collision with root package name */
    public AtomicBoolean f7659de;

    /* renamed from: fe  reason: collision with root package name */
    public rg f7660fe;

    /* renamed from: i  reason: collision with root package name */
    public final List<th> f7661i;
    @NonNull

    /* renamed from: if  reason: not valid java name */
    public final ad f325if;

    /* renamed from: o  reason: collision with root package name */
    public final List<th> f7662o;

    /* renamed from: pf  reason: collision with root package name */
    public final Map<Class<? extends th>, th> f7663pf;
    public int ppp;
    public CountDownLatch qw;

    /* renamed from: rg  reason: collision with root package name */
    public final List<StartupTaskListener> f7664rg;

    /* renamed from: switch  reason: not valid java name */
    public int f326switch;

    /* renamed from: th  reason: collision with root package name */
    public final List<OnProjectListener> f7665th;

    /* renamed from: uk  reason: collision with root package name */
    public final AtomicInteger f7666uk;
    public int when;

    /* renamed from: yj  reason: collision with root package name */
    public final AtomicInteger f7667yj;

    public static class ad {

        /* renamed from: ad  reason: collision with root package name */
        public ThreadPoolExecutor f7668ad;

        /* renamed from: de  reason: collision with root package name */
        public final List<StartupTaskListener> f7669de = new ArrayList();

        /* renamed from: fe  reason: collision with root package name */
        public final Map<Class<? extends th>, th> f7670fe = new HashMap();
        public final List<OnProjectListener> qw = new ArrayList();

        /* renamed from: rg  reason: collision with root package name */
        public ad f7671rg = new ad(true);

        /* renamed from: th  reason: collision with root package name */
        public List<th> f7672th;

        public ad i(StartupTaskListener startupTaskListener) {
            this.f7669de.add(startupTaskListener);
            return this;
        }

        public qw o() {
            return new qw(this);
        }

        public ad pf(ThreadPoolExecutor threadPoolExecutor) {
            this.f7668ad = threadPoolExecutor;
            return this;
        }

        public ad uk(OnProjectListener onProjectListener) {
            this.qw.add(onProjectListener);
            return this;
        }

        public ad yj(th thVar) {
            if (this.f7670fe.get(thVar.getClass()) != null) {
                throw new RuntimeException(thVar.getClass().getSimpleName() + " had task");
            } else if (thVar.o() != null) {
                if (this.f7672th == null) {
                    this.f7672th = new ArrayList();
                }
                this.f7672th.add(thVar);
                this.f7670fe.put(thVar.getClass(), thVar);
                return this;
            } else {
                throw new IllegalStateException("task name null");
            }
        }
    }

    public class de implements StartupTaskListener {
        public de() {
        }

        public void ad(th thVar) {
            for (StartupTaskListener ad2 : qw.this.f7664rg) {
                ad2.ad(thVar);
            }
        }

        public void de(th thVar) {
        }

        public void qw(th thVar, long j, long j2) {
            for (StartupTaskListener qw2 : qw.this.f7664rg) {
                qw2.qw(thVar, j, j2);
            }
            if (thVar.ppp()) {
                qw.this.qw.countDown();
            } else if (thVar.when()) {
                qw qwVar = qw.this;
                qwVar.f326switch = qwVar.f7658ad.decrementAndGet();
            }
            qw qwVar2 = qw.this;
            if (qwVar2.f326switch == 0 && qwVar2.qw.getCount() == 0 && qw.this.f7659de.compareAndSet(false, true)) {
                for (th aaa : qw.this.f7662o) {
                    aaa.aaa();
                }
            }
            if (thVar.m963switch() && qw.this.f7667yj.decrementAndGet() == 0) {
                qw.this.m961switch();
            }
            if (qw.this.f7666uk.decrementAndGet() == 0) {
                qw.this.when();
            }
        }
    }

    public qw ggg() {
        if (!this.f7661i.isEmpty()) {
            ppp();
            for (th aaa : this.f7661i) {
                aaa.aaa();
            }
            return this;
        }
        throw new RuntimeException("not have start task, please check task dependencies");
    }

    /* renamed from: if  reason: not valid java name */
    public final Executor m960if() {
        if (this.f7660fe == null) {
            this.f7660fe = new rg();
        }
        return this.f7660fe;
    }

    public void o() {
        pf(-1);
    }

    public void pf(long j) {
        while (true) {
            AtomicInteger atomicInteger = this.f7658ad;
            if (atomicInteger == null || atomicInteger.get() <= 0) {
                CountDownLatch countDownLatch = this.qw;
            } else {
                try {
                    Runnable qw2 = this.f7660fe.qw();
                    if (qw2 != null) {
                        qw2.run();
                    }
                } catch (Throwable th2) {
                    if (this.f325if.qw()) {
                        throw new RuntimeException(th2);
                    }
                }
            }
        }
        CountDownLatch countDownLatch2 = this.qw;
        if (countDownLatch2 != null && countDownLatch2.getCount() > 0) {
            if (j > 0) {
                try {
                    this.qw.await(j, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    if (this.f325if.qw()) {
                        throw new RuntimeException(e);
                    }
                }
            } else {
                this.qw.await();
            }
        }
    }

    public final void ppp() {
        List<OnProjectListener> list = this.f7665th;
        if (list != null && !list.isEmpty()) {
            for (OnProjectListener de2 : this.f7665th) {
                de2.de();
            }
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m961switch() {
        for (OnProjectListener qw2 : this.f7665th) {
            qw2.qw();
        }
    }

    public final void when() {
        List<OnProjectListener> list = this.f7665th;
        if (list != null && !list.isEmpty()) {
            for (OnProjectListener ad2 : this.f7665th) {
                ad2.ad();
            }
        }
        for (th next : this.f7663pf.values()) {
            if (!next.m962if()) {
                if (!this.f325if.qw()) {
                    fe.mmm.qw.i.qw.th("NetdiskAppStartup", "task " + next.o() + "not execute", (Throwable) null);
                } else {
                    throw new RuntimeException("task " + next.o() + "not execute");
                }
            }
        }
    }

    public qw(ad adVar) {
        this.f7659de = new AtomicBoolean(false);
        this.f326switch = 0;
        this.when = 0;
        this.ppp = 0;
        this.f7664rg = adVar.f7669de;
        this.f7665th = adVar.qw;
        this.f325if = adVar.f7671rg;
        ThreadPoolExecutor fe2 = adVar.f7668ad;
        de deVar = new de();
        this.f7663pf = adVar.f7670fe;
        this.f7661i = new ArrayList();
        this.f7662o = new ArrayList();
        for (th thVar : adVar.f7672th) {
            thVar.nn(this);
            if (!thVar.when() || !thVar.ppp()) {
                if (thVar.when()) {
                    thVar.ddd(m960if());
                    this.f326switch++;
                } else {
                    thVar.ddd(fe2);
                }
                if (thVar.m963switch()) {
                    this.when++;
                }
                if (thVar.ppp()) {
                    this.ppp++;
                }
                thVar.mmm(deVar);
                List<Class<? extends th>> yj2 = thVar.yj();
                if (yj2 != null && !yj2.isEmpty()) {
                    for (Class next : yj2) {
                        th thVar2 = this.f7663pf.get(next);
                        if (thVar2 != null) {
                            thVar.th(thVar2);
                        } else {
                            throw new RuntimeException(next.getSimpleName() + " not added");
                        }
                    }
                    continue;
                } else if (thVar.ppp() || thVar.when()) {
                    this.f7661i.add(thVar);
                } else if (thVar.pf()) {
                    this.f7662o.add(thVar);
                }
            } else {
                throw new RuntimeException("任务在主线程运行和在 Application onCreate() 阶段运行只能 2 选 1,异常任务：" + thVar.o());
            }
        }
        yj.qw(this.f7661i);
        yj.qw(this.f7662o);
        fe.mmm.qw.i.qw.ad("NetdiskAppStartup", "【all thread task】 count:" + adVar.f7672th.size());
        fe.mmm.qw.i.qw.ad("NetdiskAppStartup", "【main thread task】 count:" + this.f326switch);
        fe.mmm.qw.i.qw.ad("NetdiskAppStartup", "【wait main thread task】 count:" + this.ppp);
        fe.mmm.qw.i.qw.ad("NetdiskAppStartup", "【thread task】 count:" + this.f7662o.size());
        this.f7666uk = new AtomicInteger(this.f7663pf.size());
        this.f7667yj = new AtomicInteger(this.when);
        if (this.f326switch > 0) {
            this.f7658ad = new AtomicInteger(this.f326switch);
        }
        if (this.ppp > 0) {
            this.qw = new CountDownLatch(this.ppp);
        }
    }
}
