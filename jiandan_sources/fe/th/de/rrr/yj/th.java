package fe.th.de.rrr.yj;

import com.duxiaoman.okhttp3.Call;
import com.duxiaoman.okhttp3.EventListener;
import com.duxiaoman.okhttp3.Interceptor;
import com.duxiaoman.okhttp3.internal.connection.RouteException;
import com.duxiaoman.okhttp3.internal.http.HttpCodec;
import fe.th.de.ggg;
import fe.th.de.qqq;
import fe.th.de.rrr.fe;
import fe.th.de.rrr.yj.rg;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public final class th {
    public static ScheduledExecutorService ddd;

    /* renamed from: ad  reason: collision with root package name */
    public rg.qw f5512ad;

    /* renamed from: de  reason: collision with root package name */
    public qqq f5513de;

    /* renamed from: fe  reason: collision with root package name */
    public final fe.th.de.th f5514fe;
    public boolean ggg;

    /* renamed from: i  reason: collision with root package name */
    public int f5515i;

    /* renamed from: if  reason: not valid java name */
    public boolean f220if;

    /* renamed from: o  reason: collision with root package name */
    public de f5516o;

    /* renamed from: pf  reason: collision with root package name */
    public boolean f5517pf;
    public int ppp;
    public final fe.th.de.qw qw;

    /* renamed from: rg  reason: collision with root package name */
    public final Call f5518rg;

    /* renamed from: switch  reason: not valid java name */
    public boolean f221switch;

    /* renamed from: th  reason: collision with root package name */
    public final EventListener f5519th;

    /* renamed from: uk  reason: collision with root package name */
    public final rg f5520uk;
    public boolean vvv;
    public HttpCodec when;
    public boolean xxx;

    /* renamed from: yj  reason: collision with root package name */
    public final Object f5521yj;

    public static final class ad extends WeakReference<th> {
        public final Object qw;

        public ad(th thVar, Object obj) {
            super(thVar);
            this.qw = obj;
        }
    }

    public class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final int f5522ad;

        /* renamed from: i  reason: collision with root package name */
        public final boolean f5523i;

        /* renamed from: if  reason: not valid java name */
        public final BlockingQueue<qw> f222if;

        /* renamed from: o  reason: collision with root package name */
        public final de f5524o;

        /* renamed from: pf  reason: collision with root package name */
        public volatile boolean f5525pf;

        /* renamed from: switch  reason: not valid java name */
        public RuntimeException f223switch;

        /* renamed from: th  reason: collision with root package name */
        public final int f5526th;

        /* renamed from: uk  reason: collision with root package name */
        public final int f5527uk;

        /* renamed from: yj  reason: collision with root package name */
        public final int f5528yj;

        public qw(de deVar, BlockingQueue<qw> blockingQueue, int i2, int i3, int i4, int i5, boolean z) {
            this.f5522ad = i2;
            this.f222if = blockingQueue;
            this.f5526th = i3;
            this.f5528yj = i4;
            this.f5527uk = i5;
            this.f5523i = z;
            this.f5524o = deVar;
        }

        public void de() {
            this.f5525pf = true;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
            if (r9.f5525pf != false) goto L_0x002f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
            r9.f5524o.de();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
            r9.f222if.put(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0042, code lost:
            if (r9.f5525pf == false) goto L_0x0035;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r9 = this;
                boolean r0 = r9.f5525pf     // Catch:{ RuntimeException -> 0x003d }
                if (r0 == 0) goto L_0x0014
                boolean r0 = r9.f5525pf     // Catch:{ InterruptedException -> 0x0013 }
                if (r0 == 0) goto L_0x000e
                fe.th.de.rrr.yj.de r0 = r9.f5524o     // Catch:{ InterruptedException -> 0x0013 }
                r0.de()     // Catch:{ InterruptedException -> 0x0013 }
                goto L_0x0013
            L_0x000e:
                java.util.concurrent.BlockingQueue<fe.th.de.rrr.yj.th$qw> r0 = r9.f222if     // Catch:{ InterruptedException -> 0x0013 }
                r0.put(r9)     // Catch:{ InterruptedException -> 0x0013 }
            L_0x0013:
                return
            L_0x0014:
                fe.th.de.rrr.yj.de r1 = r9.f5524o     // Catch:{ RuntimeException -> 0x003d }
                int r2 = r9.f5522ad     // Catch:{ RuntimeException -> 0x003d }
                int r3 = r9.f5526th     // Catch:{ RuntimeException -> 0x003d }
                int r4 = r9.f5528yj     // Catch:{ RuntimeException -> 0x003d }
                int r5 = r9.f5527uk     // Catch:{ RuntimeException -> 0x003d }
                boolean r6 = r9.f5523i     // Catch:{ RuntimeException -> 0x003d }
                fe.th.de.rrr.yj.th r0 = fe.th.de.rrr.yj.th.this     // Catch:{ RuntimeException -> 0x003d }
                com.duxiaoman.okhttp3.Call r7 = r0.f5518rg     // Catch:{ RuntimeException -> 0x003d }
                fe.th.de.rrr.yj.th r0 = fe.th.de.rrr.yj.th.this     // Catch:{ RuntimeException -> 0x003d }
                com.duxiaoman.okhttp3.EventListener r8 = r0.f5519th     // Catch:{ RuntimeException -> 0x003d }
                r1.fe(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ RuntimeException -> 0x003d }
                boolean r0 = r9.f5525pf     // Catch:{ InterruptedException -> 0x0045 }
                if (r0 == 0) goto L_0x0035
            L_0x002f:
                fe.th.de.rrr.yj.de r0 = r9.f5524o     // Catch:{ InterruptedException -> 0x0045 }
                r0.de()     // Catch:{ InterruptedException -> 0x0045 }
                goto L_0x0045
            L_0x0035:
                java.util.concurrent.BlockingQueue<fe.th.de.rrr.yj.th$qw> r0 = r9.f222if     // Catch:{ InterruptedException -> 0x0045 }
                r0.put(r9)     // Catch:{ InterruptedException -> 0x0045 }
                goto L_0x0045
            L_0x003b:
                r0 = move-exception
                goto L_0x0046
            L_0x003d:
                r0 = move-exception
                r9.f223switch = r0     // Catch:{ all -> 0x003b }
                boolean r0 = r9.f5525pf     // Catch:{ InterruptedException -> 0x0045 }
                if (r0 == 0) goto L_0x0035
                goto L_0x002f
            L_0x0045:
                return
            L_0x0046:
                boolean r1 = r9.f5525pf     // Catch:{ InterruptedException -> 0x0055 }
                if (r1 == 0) goto L_0x0050
                fe.th.de.rrr.yj.de r1 = r9.f5524o     // Catch:{ InterruptedException -> 0x0055 }
                r1.de()     // Catch:{ InterruptedException -> 0x0055 }
                goto L_0x0055
            L_0x0050:
                java.util.concurrent.BlockingQueue<fe.th.de.rrr.yj.th$qw> r1 = r9.f222if     // Catch:{ InterruptedException -> 0x0055 }
                r1.put(r9)     // Catch:{ InterruptedException -> 0x0055 }
            L_0x0055:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.th.de.rrr.yj.th.qw.run():void");
        }
    }

    public th(fe.th.de.th thVar, fe.th.de.qw qwVar, Call call, EventListener eventListener, Object obj) {
        this.f5514fe = thVar;
        this.qw = qwVar;
        this.f5518rg = call;
        this.f5519th = eventListener;
        this.f5520uk = new rg(qwVar, mmm(), call, eventListener);
        this.f5521yj = obj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void aaa(java.io.IOException r7) {
        /*
            r6 = this;
            fe.th.de.th r0 = r6.f5514fe
            monitor-enter(r0)
            boolean r1 = r7 instanceof com.duxiaoman.okhttp3.internal.http2.StreamResetException     // Catch:{ all -> 0x0069 }
            r2 = 0
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0023
            com.duxiaoman.okhttp3.internal.http2.StreamResetException r7 = (com.duxiaoman.okhttp3.internal.http2.StreamResetException) r7     // Catch:{ all -> 0x0069 }
            com.duxiaoman.okhttp3.internal.http2.ErrorCode r7 = r7.errorCode     // Catch:{ all -> 0x0069 }
            com.duxiaoman.okhttp3.internal.http2.ErrorCode r1 = com.duxiaoman.okhttp3.internal.http2.ErrorCode.REFUSED_STREAM     // Catch:{ all -> 0x0069 }
            if (r7 != r1) goto L_0x001c
            int r7 = r6.f5515i     // Catch:{ all -> 0x0069 }
            int r7 = r7 + r4
            r6.f5515i = r7     // Catch:{ all -> 0x0069 }
            if (r7 <= r4) goto L_0x004a
            r6.f5513de = r3     // Catch:{ all -> 0x0069 }
            goto L_0x0048
        L_0x001c:
            com.duxiaoman.okhttp3.internal.http2.ErrorCode r1 = com.duxiaoman.okhttp3.internal.http2.ErrorCode.CANCEL     // Catch:{ all -> 0x0069 }
            if (r7 == r1) goto L_0x004a
            r6.f5513de = r3     // Catch:{ all -> 0x0069 }
            goto L_0x0048
        L_0x0023:
            fe.th.de.rrr.yj.de r1 = r6.f5516o     // Catch:{ all -> 0x0069 }
            if (r1 == 0) goto L_0x004a
            fe.th.de.rrr.yj.de r1 = r6.f5516o     // Catch:{ all -> 0x0069 }
            boolean r1 = r1.m361switch()     // Catch:{ all -> 0x0069 }
            if (r1 == 0) goto L_0x0033
            boolean r1 = r7 instanceof com.duxiaoman.okhttp3.internal.http2.ConnectionShutdownException     // Catch:{ all -> 0x0069 }
            if (r1 == 0) goto L_0x004a
        L_0x0033:
            fe.th.de.rrr.yj.de r1 = r6.f5516o     // Catch:{ all -> 0x0069 }
            int r1 = r1.f218if     // Catch:{ all -> 0x0069 }
            if (r1 != 0) goto L_0x0048
            fe.th.de.qqq r1 = r6.f5513de     // Catch:{ all -> 0x0069 }
            if (r1 == 0) goto L_0x0046
            if (r7 == 0) goto L_0x0046
            fe.th.de.rrr.yj.rg r1 = r6.f5520uk     // Catch:{ all -> 0x0069 }
            fe.th.de.qqq r5 = r6.f5513de     // Catch:{ all -> 0x0069 }
            r1.qw(r5, r7)     // Catch:{ all -> 0x0069 }
        L_0x0046:
            r6.f5513de = r3     // Catch:{ all -> 0x0069 }
        L_0x0048:
            r7 = 1
            goto L_0x004b
        L_0x004a:
            r7 = 0
        L_0x004b:
            fe.th.de.rrr.yj.de r1 = r6.f5516o     // Catch:{ all -> 0x0069 }
            java.net.Socket r7 = r6.rg(r7, r2, r4)     // Catch:{ all -> 0x0069 }
            fe.th.de.rrr.yj.de r2 = r6.f5516o     // Catch:{ all -> 0x0069 }
            if (r2 != 0) goto L_0x005b
            boolean r2 = r6.f5517pf     // Catch:{ all -> 0x0069 }
            if (r2 != 0) goto L_0x005a
            goto L_0x005b
        L_0x005a:
            r3 = r1
        L_0x005b:
            monitor-exit(r0)     // Catch:{ all -> 0x0069 }
            fe.th.de.rrr.fe.uk(r7)
            if (r3 == 0) goto L_0x0068
            com.duxiaoman.okhttp3.EventListener r7 = r6.f5519th
            com.duxiaoman.okhttp3.Call r0 = r6.f5518rg
            r7.connectionReleased(r0, r3)
        L_0x0068:
            return
        L_0x0069:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0069 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.th.de.rrr.yj.th.aaa(java.io.IOException):void");
    }

    public void ad() {
        HttpCodec httpCodec;
        de deVar;
        synchronized (this.f5514fe) {
            this.f221switch = true;
            httpCodec = this.when;
            deVar = this.f5516o;
        }
        if (httpCodec != null) {
            httpCodec.cancel();
        } else if (deVar != null) {
            deVar.de();
        }
    }

    public final Socket ddd() {
        de deVar = this.f5516o;
        if (deVar == null || !deVar.f5498pf) {
            return null;
        }
        return rg(false, false, true);
    }

    public HttpCodec de() {
        HttpCodec httpCodec;
        synchronized (this.f5514fe) {
            httpCodec = this.when;
        }
        return httpCodec;
    }

    public synchronized de fe() {
        return this.f5516o;
    }

    public void ggg() {
        de deVar;
        Socket rg2;
        synchronized (this.f5514fe) {
            deVar = this.f5516o;
            rg2 = rg(false, true, false);
            if (this.f5516o != null) {
                deVar = null;
            }
        }
        fe.uk(rg2);
        if (deVar != null) {
            fe.th.de.rrr.qw.qw.m359if(this.f5518rg, (IOException) null);
            this.f5519th.connectionReleased(this.f5518rg, deVar);
            this.f5519th.callEnd(this.f5518rg);
        }
    }

    public final de i(int i2, int i3, int i4, int i5, boolean z, de deVar, qqq qqq) {
        SynchronousQueue synchronousQueue = new SynchronousQueue();
        synchronized (this.f5514fe) {
            if (ddd == null) {
                ddd = Executors.newScheduledThreadPool(2);
            }
        }
        SynchronousQueue synchronousQueue2 = synchronousQueue;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        int i9 = i5;
        boolean z2 = z;
        qw qwVar = new qw(deVar, synchronousQueue2, i6, i7, i8, i9, z2);
        qw qwVar2 = new qw(new de(this.f5514fe, qqq), synchronousQueue2, i6, i7, i8, i9, z2);
        ddd.execute(qwVar);
        ddd.schedule(qwVar2, (long) this.ppp, TimeUnit.MILLISECONDS);
        de deVar2 = null;
        try {
            qw qwVar3 = (qw) synchronousQueue.take();
            de qw2 = qwVar3.f5524o;
            try {
                this.f5513de = qw2.route();
                if (qwVar3 == qwVar) {
                    qwVar2.de();
                } else {
                    qwVar.de();
                    this.ggg = true;
                    this.f5512ad.de();
                }
                if (qwVar3.f223switch == null) {
                    synchronized (this.f5514fe) {
                        vvv(this.f5516o);
                        this.f5516o = null;
                        qw(qw2, false);
                    }
                    return qw2;
                }
                throw qwVar3.f223switch;
            } catch (InterruptedException unused) {
                deVar2 = qw2;
                return deVar2;
            }
        } catch (InterruptedException unused2) {
            return deVar2;
        }
    }

    /* renamed from: if  reason: not valid java name */
    public boolean m362if() {
        return this.ggg;
    }

    public final fe mmm() {
        return fe.th.de.rrr.qw.qw.pf(this.f5514fe);
    }

    public qqq nn() {
        return this.f5513de;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.f5512ad;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean o() {
        /*
            r1 = this;
            fe.th.de.qqq r0 = r1.f5513de
            if (r0 != 0) goto L_0x0019
            fe.th.de.rrr.yj.rg$qw r0 = r1.f5512ad
            if (r0 == 0) goto L_0x000e
            boolean r0 = r0.ad()
            if (r0 != 0) goto L_0x0019
        L_0x000e:
            fe.th.de.rrr.yj.rg r0 = r1.f5520uk
            boolean r0 = r0.de()
            if (r0 == 0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r0 = 0
            goto L_0x001a
        L_0x0019:
            r0 = 1
        L_0x001a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.th.de.rrr.yj.th.o():boolean");
    }

    public final boolean pf(qqq qqq) {
        return qqq != null && (qqq.fe().getAddress() instanceof Inet6Address);
    }

    public void ppp() {
        de deVar;
        Socket rg2;
        synchronized (this.f5514fe) {
            deVar = this.f5516o;
            rg2 = rg(true, false, false);
            if (this.f5516o != null) {
                deVar = null;
            }
        }
        fe.uk(rg2);
        if (deVar != null) {
            this.f5519th.connectionReleased(this.f5518rg, deVar);
        }
    }

    public void qqq(boolean z, HttpCodec httpCodec, long j, IOException iOException) {
        de deVar;
        Socket rg2;
        boolean z2;
        this.f5519th.responseBodyEnd(this.f5518rg, j);
        synchronized (this.f5514fe) {
            if (httpCodec != null) {
                if (httpCodec == this.when) {
                    if (!z) {
                        this.f5516o.f218if++;
                    }
                    deVar = this.f5516o;
                    rg2 = rg(z, false, true);
                    if (this.f5516o != null) {
                        deVar = null;
                    }
                    z2 = this.f220if;
                }
            }
            throw new IllegalStateException("expected " + this.when + " but was " + httpCodec);
        }
        fe.uk(rg2);
        if (deVar != null) {
            this.f5519th.connectionReleased(this.f5518rg, deVar);
        }
        if (iOException != null) {
            this.f5519th.callFailed(this.f5518rg, fe.th.de.rrr.qw.qw.m359if(this.f5518rg, iOException));
        } else if (z2) {
            fe.th.de.rrr.qw.qw.m359if(this.f5518rg, (IOException) null);
            this.f5519th.callEnd(this.f5518rg);
        }
    }

    public void qw(de deVar, boolean z) {
        if (this.f5516o == null) {
            this.f5516o = deVar;
            this.f5517pf = z;
            deVar.when.add(new ad(this, this.f5521yj));
            return;
        }
        throw new IllegalStateException();
    }

    public final Socket rg(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (z3) {
            this.when = null;
        }
        if (z2) {
            this.f220if = true;
        }
        de deVar = this.f5516o;
        if (deVar == null) {
            return null;
        }
        if (z) {
            deVar.f5498pf = true;
        }
        if (this.when != null) {
            return null;
        }
        if (!this.f220if && !this.f5516o.f5498pf) {
            return null;
        }
        vvv(this.f5516o);
        if (this.f5516o.when.isEmpty()) {
            this.f5516o.ppp = System.nanoTime();
            if (fe.th.de.rrr.qw.qw.rg(this.f5514fe, this.f5516o)) {
                socket = this.f5516o.ppp();
                this.f5516o = null;
                return socket;
            }
        }
        socket = null;
        this.f5516o = null;
        return socket;
    }

    /* renamed from: switch  reason: not valid java name */
    public boolean m363switch() {
        return this.xxx;
    }

    public final de th(int i2, int i3, int i4, int i5, boolean z) throws IOException {
        Socket ddd2;
        Socket socket;
        de deVar;
        de deVar2;
        boolean z2;
        boolean z3;
        qqq qqq;
        boolean z4;
        de deVar3;
        rg.qw qwVar;
        synchronized (this.f5514fe) {
            if (this.f220if) {
                throw new IllegalStateException("released");
            } else if (this.when != null) {
                throw new IllegalStateException("codec != null");
            } else if (!this.f221switch) {
                de deVar4 = this.f5516o;
                ddd2 = ddd();
                socket = null;
                if (this.f5516o != null) {
                    deVar2 = this.f5516o;
                    deVar = null;
                } else {
                    deVar = deVar4;
                    deVar2 = null;
                }
                if (!this.f5517pf) {
                    deVar = null;
                }
                z2 = false;
                if (deVar2 == null) {
                    fe.th.de.rrr.qw.qw.uk(this.f5514fe, this.qw, this, (qqq) null);
                    if (this.f5516o != null) {
                        deVar2 = this.f5516o;
                        qqq = null;
                        z3 = true;
                    } else {
                        qqq = this.f5513de;
                    }
                } else {
                    qqq = null;
                }
                z3 = false;
            } else {
                throw new IOException("Canceled");
            }
        }
        fe.uk(ddd2);
        if (deVar != null) {
            this.f5519th.connectionReleased(this.f5518rg, deVar);
        }
        if (z3) {
            this.f5519th.connectionAcquired(this.f5518rg, deVar2);
        }
        if (deVar2 != null) {
            this.f5513de = this.f5516o.route();
            return deVar2;
        }
        if (qqq != null || ((qwVar = this.f5512ad) != null && qwVar.ad())) {
            z4 = false;
        } else {
            this.f5512ad = this.f5520uk.rg();
            z4 = true;
        }
        synchronized (this.f5514fe) {
            if (!this.f221switch) {
                if (z4) {
                    List<qqq> qw2 = this.f5512ad.qw();
                    int size = qw2.size();
                    int i6 = 0;
                    while (true) {
                        if (i6 >= size) {
                            break;
                        }
                        qqq qqq2 = qw2.get(i6);
                        fe.th.de.rrr.qw.qw.uk(this.f5514fe, this.qw, this, qqq2);
                        if (this.f5516o != null) {
                            deVar2 = this.f5516o;
                            this.f5513de = qqq2;
                            z3 = true;
                            break;
                        }
                        i6++;
                    }
                }
                if (!z3) {
                    if (qqq == null) {
                        qqq = this.f5512ad.fe();
                    }
                    this.f5513de = qqq;
                    this.f5515i = 0;
                    deVar2 = new de(this.f5514fe, qqq);
                    qw(deVar2, false);
                }
                deVar3 = deVar2;
            } else {
                throw new IOException("Canceled");
            }
        }
        if (z3) {
            this.f5519th.connectionAcquired(this.f5518rg, deVar3);
            return deVar3;
        }
        if (this.f5512ad == null) {
            this.f5512ad = this.f5520uk.rg();
        }
        qqq uk2 = uk();
        if (this.ppp > 0 && pf(deVar3.route()) && uk2 != null && this.vvv) {
            z2 = true;
        }
        if (z2) {
            this.xxx = true;
            deVar3 = i(i2, i3, i4, i5, z, deVar3, uk2);
        } else {
            deVar3.fe(i2, i3, i4, i5, z, this.f5518rg, this.f5519th);
        }
        mmm().qw(deVar3.route());
        synchronized (this.f5514fe) {
            this.f5517pf = true;
            fe.th.de.rrr.qw.qw.o(this.f5514fe, deVar3);
            if (deVar3.m361switch()) {
                socket = fe.th.de.rrr.qw.qw.th(this.f5514fe, this.qw, this);
                deVar3 = this.f5516o;
            }
        }
        fe.uk(socket);
        this.f5519th.connectionAcquired(this.f5518rg, deVar3);
        return deVar3;
    }

    public String toString() {
        de fe2 = fe();
        return fe2 != null ? fe2.toString() : this.qw.toString();
    }

    public final qqq uk() {
        for (int i2 = 0; i2 < this.f5512ad.qw().size(); i2++) {
            qqq qqq = this.f5512ad.qw().get(i2);
            if (qqq.fe().getAddress() instanceof Inet4Address) {
                return qqq;
            }
        }
        return null;
    }

    public final void vvv(de deVar) {
        int size = deVar.when.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (deVar.when.get(i2).get() == this) {
                deVar.when.remove(i2);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public HttpCodec when(ggg ggg2, Interceptor.Chain chain, boolean z) {
        int connectTimeoutMillis = chain.connectTimeoutMillis();
        int readTimeoutMillis = chain.readTimeoutMillis();
        int writeTimeoutMillis = chain.writeTimeoutMillis();
        int qqq = ggg2.qqq();
        boolean c = ggg2.c();
        this.ppp = ggg2.when();
        this.vvv = ggg2.xxx();
        try {
            HttpCodec when2 = yj(connectTimeoutMillis, readTimeoutMillis, writeTimeoutMillis, qqq, c, z).when(ggg2, chain, this);
            synchronized (this.f5514fe) {
                this.when = when2;
            }
            return when2;
        } catch (IOException e) {
            throw new RouteException(e);
        }
    }

    public Socket xxx(de deVar) {
        if (this.when == null && this.f5516o.when.size() == 1) {
            Socket rg2 = rg(true, false, false);
            this.f5516o = deVar;
            deVar.when.add(this.f5516o.when.get(0));
            return rg2;
        }
        throw new IllegalStateException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        if (r0.m360if(r9) != false) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final fe.th.de.rrr.yj.de yj(int r4, int r5, int r6, int r7, boolean r8, boolean r9) throws java.io.IOException {
        /*
            r3 = this;
        L_0x0000:
            fe.th.de.rrr.yj.de r0 = r3.th(r4, r5, r6, r7, r8)
            fe.th.de.th r1 = r3.f5514fe
            monitor-enter(r1)
            int r2 = r0.f218if     // Catch:{ all -> 0x001f }
            if (r2 != 0) goto L_0x0013
            boolean r2 = r0.m361switch()     // Catch:{ all -> 0x001f }
            if (r2 != 0) goto L_0x0013
            monitor-exit(r1)     // Catch:{ all -> 0x001f }
            return r0
        L_0x0013:
            monitor-exit(r1)     // Catch:{ all -> 0x001f }
            boolean r1 = r0.m360if(r9)
            if (r1 != 0) goto L_0x001e
            r3.ppp()
            goto L_0x0000
        L_0x001e:
            return r0
        L_0x001f:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001f }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.th.de.rrr.yj.th.yj(int, int, int, int, boolean, boolean):fe.th.de.rrr.yj.de");
    }
}
