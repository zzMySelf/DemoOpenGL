package fe.uk.qw.pf.fe;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.dxmbumptech.glide.load.DataSource;
import com.dxmbumptech.glide.load.Key;
import com.dxmbumptech.glide.load.engine.CallbackException;
import com.dxmbumptech.glide.load.engine.DecodeJob;
import com.dxmbumptech.glide.load.engine.GlideException;
import com.dxmbumptech.glide.load.engine.Resource;
import com.dxmbumptech.glide.load.engine.executor.GlideExecutor;
import com.dxmbumptech.glide.request.ResourceCallback;
import com.dxmbumptech.glide.util.pool.FactoryPools;
import fe.uk.qw.pf.fe.Cswitch;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public class i<R> implements DecodeJob.ad<R>, FactoryPools.Poolable {
    public static final de h = new de();
    public DataSource aaa;

    /* renamed from: ad  reason: collision with root package name */
    public final rg f5758ad;
    public boolean ddd;
    public DecodeJob<R> e;
    public GlideException eee;
    public volatile boolean f;
    public boolean g;
    public Key ggg;

    /* renamed from: i  reason: collision with root package name */
    public final de f5759i;

    /* renamed from: if  reason: not valid java name */
    public final GlideExecutor f236if;
    public Resource<?> mmm;
    public boolean nn;

    /* renamed from: o  reason: collision with root package name */
    public final o f5760o;

    /* renamed from: pf  reason: collision with root package name */
    public final GlideExecutor f5761pf;
    public final AtomicInteger ppp;
    public boolean qqq;
    public boolean rrr;

    /* renamed from: switch  reason: not valid java name */
    public final GlideExecutor f237switch;

    /* renamed from: th  reason: collision with root package name */
    public final fe.uk.qw.vvv.pf.ad f5762th;
    public Cswitch<?> tt;

    /* renamed from: uk  reason: collision with root package name */
    public final Pools.Pool<i<?>> f5763uk;
    public boolean vvv;
    public final GlideExecutor when;
    public boolean xxx;

    /* renamed from: yj  reason: collision with root package name */
    public final Cswitch.qw f5764yj;

    public class ad implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final ResourceCallback f5765ad;

        public ad(ResourceCallback resourceCallback) {
            this.f5765ad = resourceCallback;
        }

        public void run() {
            synchronized (this.f5765ad.fe()) {
                synchronized (i.this) {
                    if (i.this.f5758ad.ad(this.f5765ad)) {
                        i.this.tt.de();
                        i.this.de(this.f5765ad);
                        i.this.xxx(this.f5765ad);
                    }
                    i.this.i();
                }
            }
        }
    }

    @VisibleForTesting
    public static class de {
        public <R> Cswitch<R> qw(Resource<R> resource, boolean z, Key key, Cswitch.qw qwVar) {
            return new Cswitch(resource, z, true, key, qwVar);
        }
    }

    public static final class fe {

        /* renamed from: ad  reason: collision with root package name */
        public final Executor f5767ad;
        public final ResourceCallback qw;

        public fe(ResourceCallback resourceCallback, Executor executor) {
            this.qw = resourceCallback;
            this.f5767ad = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof fe) {
                return this.qw.equals(((fe) obj).qw);
            }
            return false;
        }

        public int hashCode() {
            return this.qw.hashCode();
        }
    }

    public class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final ResourceCallback f5768ad;

        public qw(ResourceCallback resourceCallback) {
            this.f5768ad = resourceCallback;
        }

        public void run() {
            synchronized (this.f5768ad.fe()) {
                synchronized (i.this) {
                    if (i.this.f5758ad.ad(this.f5768ad)) {
                        i.this.ad(this.f5768ad);
                    }
                    i.this.i();
                }
            }
        }
    }

    public static final class rg implements Iterable<fe> {

        /* renamed from: ad  reason: collision with root package name */
        public final List<fe> f5770ad;

        public rg() {
            this(new ArrayList(2));
        }

        public static fe fe(ResourceCallback resourceCallback) {
            return new fe(resourceCallback, fe.uk.qw.vvv.fe.qw());
        }

        public boolean ad(ResourceCallback resourceCallback) {
            return this.f5770ad.contains(fe(resourceCallback));
        }

        public void clear() {
            this.f5770ad.clear();
        }

        public rg de() {
            return new rg(new ArrayList(this.f5770ad));
        }

        public boolean isEmpty() {
            return this.f5770ad.isEmpty();
        }

        @NonNull
        public Iterator<fe> iterator() {
            return this.f5770ad.iterator();
        }

        public void qw(ResourceCallback resourceCallback, Executor executor) {
            this.f5770ad.add(new fe(resourceCallback, executor));
        }

        public void rg(ResourceCallback resourceCallback) {
            this.f5770ad.remove(fe(resourceCallback));
        }

        public int size() {
            return this.f5770ad.size();
        }

        public rg(List<fe> list) {
            this.f5770ad = list;
        }
    }

    public i(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, o oVar, Cswitch.qw qwVar, Pools.Pool<i<?>> pool) {
        this(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, oVar, qwVar, pool, h);
    }

    @GuardedBy("this")
    public void ad(ResourceCallback resourceCallback) {
        try {
            resourceCallback.rg(this.eee);
        } catch (Throwable th2) {
            throw new CallbackException(th2);
        }
    }

    public synchronized void ddd(DecodeJob<R> decodeJob) {
        this.e = decodeJob;
        (decodeJob.e() ? this.f5761pf : o()).execute(decodeJob);
    }

    @GuardedBy("this")
    public void de(ResourceCallback resourceCallback) {
        try {
            resourceCallback.th(this.tt, this.aaa, this.g);
        } catch (Throwable th2) {
            throw new CallbackException(th2);
        }
    }

    @NonNull
    public fe.uk.qw.vvv.pf.ad fe() {
        return this.f5762th;
    }

    public boolean ggg() {
        return this.nn;
    }

    public void i() {
        Cswitch<?> switchR;
        synchronized (this) {
            this.f5762th.de();
            fe.uk.qw.vvv.i.qw(m374switch(), "Not yet complete!");
            int decrementAndGet = this.ppp.decrementAndGet();
            fe.uk.qw.vvv.i.qw(decrementAndGet >= 0, "Can't decrement below 0");
            if (decrementAndGet == 0) {
                switchR = this.tt;
                vvv();
            } else {
                switchR = null;
            }
        }
        if (switchR != null) {
            switchR.th();
        }
    }

    @VisibleForTesting
    /* renamed from: if  reason: not valid java name */
    public synchronized i<R> m373if(Key key, boolean z, boolean z2, boolean z3, boolean z4) {
        this.ggg = key;
        this.vvv = z;
        this.xxx = z2;
        this.ddd = z3;
        this.nn = z4;
        return this;
    }

    public final GlideExecutor o() {
        if (this.xxx) {
            return this.f237switch;
        }
        return this.ddd ? this.when : this.f236if;
    }

    public synchronized void pf(int i2) {
        fe.uk.qw.vvv.i.qw(m374switch(), "Not yet complete!");
        if (this.ppp.getAndAdd(i2) == 0 && this.tt != null) {
            this.tt.de();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0046, code lost:
        r5.f5760o.qw(r5, r0, r2);
        r0 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0053, code lost:
        if (r0.hasNext() == false) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0055, code lost:
        r1 = r0.next();
        r1.f5767ad.execute(new fe.uk.qw.pf.fe.i.ad(r5, r1.qw));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0068, code lost:
        i();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void ppp() {
        /*
            r5 = this;
            monitor-enter(r5)
            fe.uk.qw.vvv.pf.ad r0 = r5.f5762th     // Catch:{ all -> 0x007c }
            r0.de()     // Catch:{ all -> 0x007c }
            boolean r0 = r5.f     // Catch:{ all -> 0x007c }
            if (r0 == 0) goto L_0x0014
            com.dxmbumptech.glide.load.engine.Resource<?> r0 = r5.mmm     // Catch:{ all -> 0x007c }
            r0.recycle()     // Catch:{ all -> 0x007c }
            r5.vvv()     // Catch:{ all -> 0x007c }
            monitor-exit(r5)     // Catch:{ all -> 0x007c }
            return
        L_0x0014:
            fe.uk.qw.pf.fe.i$rg r0 = r5.f5758ad     // Catch:{ all -> 0x007c }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x007c }
            if (r0 != 0) goto L_0x0074
            boolean r0 = r5.qqq     // Catch:{ all -> 0x007c }
            if (r0 != 0) goto L_0x006c
            fe.uk.qw.pf.fe.i$de r0 = r5.f5759i     // Catch:{ all -> 0x007c }
            com.dxmbumptech.glide.load.engine.Resource<?> r1 = r5.mmm     // Catch:{ all -> 0x007c }
            boolean r2 = r5.vvv     // Catch:{ all -> 0x007c }
            com.dxmbumptech.glide.load.Key r3 = r5.ggg     // Catch:{ all -> 0x007c }
            fe.uk.qw.pf.fe.switch$qw r4 = r5.f5764yj     // Catch:{ all -> 0x007c }
            fe.uk.qw.pf.fe.switch r0 = r0.qw(r1, r2, r3, r4)     // Catch:{ all -> 0x007c }
            r5.tt = r0     // Catch:{ all -> 0x007c }
            r0 = 1
            r5.qqq = r0     // Catch:{ all -> 0x007c }
            fe.uk.qw.pf.fe.i$rg r1 = r5.f5758ad     // Catch:{ all -> 0x007c }
            fe.uk.qw.pf.fe.i$rg r1 = r1.de()     // Catch:{ all -> 0x007c }
            int r2 = r1.size()     // Catch:{ all -> 0x007c }
            int r2 = r2 + r0
            r5.pf(r2)     // Catch:{ all -> 0x007c }
            com.dxmbumptech.glide.load.Key r0 = r5.ggg     // Catch:{ all -> 0x007c }
            fe.uk.qw.pf.fe.switch<?> r2 = r5.tt     // Catch:{ all -> 0x007c }
            monitor-exit(r5)     // Catch:{ all -> 0x007c }
            fe.uk.qw.pf.fe.o r3 = r5.f5760o
            r3.qw(r5, r0, r2)
            java.util.Iterator r0 = r1.iterator()
        L_0x004f:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0068
            java.lang.Object r1 = r0.next()
            fe.uk.qw.pf.fe.i$fe r1 = (fe.uk.qw.pf.fe.i.fe) r1
            java.util.concurrent.Executor r2 = r1.f5767ad
            fe.uk.qw.pf.fe.i$ad r3 = new fe.uk.qw.pf.fe.i$ad
            com.dxmbumptech.glide.request.ResourceCallback r1 = r1.qw
            r3.<init>(r1)
            r2.execute(r3)
            goto L_0x004f
        L_0x0068:
            r5.i()
            return
        L_0x006c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x007c }
            java.lang.String r1 = "Already have resource"
            r0.<init>(r1)     // Catch:{ all -> 0x007c }
            throw r0     // Catch:{ all -> 0x007c }
        L_0x0074:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x007c }
            java.lang.String r1 = "Received a resource without any callbacks to notify"
            r0.<init>(r1)     // Catch:{ all -> 0x007c }
            throw r0     // Catch:{ all -> 0x007c }
        L_0x007c:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x007c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.uk.qw.pf.fe.i.ppp():void");
    }

    public synchronized void qw(ResourceCallback resourceCallback, Executor executor) {
        this.f5762th.de();
        this.f5758ad.qw(resourceCallback, executor);
        boolean z = true;
        if (this.qqq) {
            pf(1);
            executor.execute(new ad(resourceCallback));
        } else if (this.rrr) {
            pf(1);
            executor.execute(new qw(resourceCallback));
        } else {
            if (this.f) {
                z = false;
            }
            fe.uk.qw.vvv.i.qw(z, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    public void rg(GlideException glideException) {
        synchronized (this) {
            this.eee = glideException;
        }
        when();
    }

    /* renamed from: switch  reason: not valid java name */
    public final boolean m374switch() {
        return this.rrr || this.qqq || this.f;
    }

    public void th(Resource<R> resource, DataSource dataSource, boolean z) {
        synchronized (this) {
            this.mmm = resource;
            this.aaa = dataSource;
            this.g = z;
        }
        ppp();
    }

    public void uk() {
        if (!m374switch()) {
            this.f = true;
            this.e.qw();
            this.f5760o.ad(this, this.ggg);
        }
    }

    public final synchronized void vvv() {
        if (this.ggg != null) {
            this.f5758ad.clear();
            this.ggg = null;
            this.tt = null;
            this.mmm = null;
            this.rrr = false;
            this.f = false;
            this.qqq = false;
            this.g = false;
            this.e.rrr(false);
            this.e = null;
            this.eee = null;
            this.aaa = null;
            this.f5763uk.release(this);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        r4.f5760o.qw(r4, r1, (fe.uk.qw.pf.fe.Cswitch<?>) null);
        r0 = r2.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        if (r0.hasNext() == false) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
        r1 = r0.next();
        r1.f5767ad.execute(new fe.uk.qw.pf.fe.i.qw(r4, r1.qw));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0052, code lost:
        i();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0055, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void when() {
        /*
            r4 = this;
            monitor-enter(r4)
            fe.uk.qw.vvv.pf.ad r0 = r4.f5762th     // Catch:{ all -> 0x0066 }
            r0.de()     // Catch:{ all -> 0x0066 }
            boolean r0 = r4.f     // Catch:{ all -> 0x0066 }
            if (r0 == 0) goto L_0x000f
            r4.vvv()     // Catch:{ all -> 0x0066 }
            monitor-exit(r4)     // Catch:{ all -> 0x0066 }
            return
        L_0x000f:
            fe.uk.qw.pf.fe.i$rg r0 = r4.f5758ad     // Catch:{ all -> 0x0066 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0066 }
            if (r0 != 0) goto L_0x005e
            boolean r0 = r4.rrr     // Catch:{ all -> 0x0066 }
            if (r0 != 0) goto L_0x0056
            r0 = 1
            r4.rrr = r0     // Catch:{ all -> 0x0066 }
            com.dxmbumptech.glide.load.Key r1 = r4.ggg     // Catch:{ all -> 0x0066 }
            fe.uk.qw.pf.fe.i$rg r2 = r4.f5758ad     // Catch:{ all -> 0x0066 }
            fe.uk.qw.pf.fe.i$rg r2 = r2.de()     // Catch:{ all -> 0x0066 }
            int r3 = r2.size()     // Catch:{ all -> 0x0066 }
            int r3 = r3 + r0
            r4.pf(r3)     // Catch:{ all -> 0x0066 }
            monitor-exit(r4)     // Catch:{ all -> 0x0066 }
            fe.uk.qw.pf.fe.o r0 = r4.f5760o
            r3 = 0
            r0.qw(r4, r1, r3)
            java.util.Iterator r0 = r2.iterator()
        L_0x0039:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0052
            java.lang.Object r1 = r0.next()
            fe.uk.qw.pf.fe.i$fe r1 = (fe.uk.qw.pf.fe.i.fe) r1
            java.util.concurrent.Executor r2 = r1.f5767ad
            fe.uk.qw.pf.fe.i$qw r3 = new fe.uk.qw.pf.fe.i$qw
            com.dxmbumptech.glide.request.ResourceCallback r1 = r1.qw
            r3.<init>(r1)
            r2.execute(r3)
            goto L_0x0039
        L_0x0052:
            r4.i()
            return
        L_0x0056:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0066 }
            java.lang.String r1 = "Already failed once"
            r0.<init>(r1)     // Catch:{ all -> 0x0066 }
            throw r0     // Catch:{ all -> 0x0066 }
        L_0x005e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0066 }
            java.lang.String r1 = "Received an exception without any callbacks to notify"
            r0.<init>(r1)     // Catch:{ all -> 0x0066 }
            throw r0     // Catch:{ all -> 0x0066 }
        L_0x0066:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0066 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.uk.qw.pf.fe.i.when():void");
    }

    public synchronized void xxx(ResourceCallback resourceCallback) {
        boolean z;
        this.f5762th.de();
        this.f5758ad.rg(resourceCallback);
        if (this.f5758ad.isEmpty()) {
            uk();
            if (!this.qqq) {
                if (!this.rrr) {
                    z = false;
                    if (z && this.ppp.get() == 0) {
                        vvv();
                    }
                }
            }
            z = true;
            vvv();
        }
    }

    public void yj(DecodeJob<?> decodeJob) {
        o().execute(decodeJob);
    }

    @VisibleForTesting
    public i(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, o oVar, Cswitch.qw qwVar, Pools.Pool<i<?>> pool, de deVar) {
        this.f5758ad = new rg();
        this.f5762th = fe.uk.qw.vvv.pf.ad.qw();
        this.ppp = new AtomicInteger();
        this.f5761pf = glideExecutor;
        this.f236if = glideExecutor2;
        this.f237switch = glideExecutor3;
        this.when = glideExecutor4;
        this.f5760o = oVar;
        this.f5764yj = qwVar;
        this.f5763uk = pool;
        this.f5759i = deVar;
    }
}
