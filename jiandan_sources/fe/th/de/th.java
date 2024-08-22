package fe.th.de;

import fe.th.de.rrr.fe;
import fe.th.de.rrr.p019if.yj;
import fe.th.de.rrr.yj.de;
import fe.th.de.rrr.yj.th;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class th {

    /* renamed from: yj  reason: collision with root package name */
    public static final Executor f5530yj = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), fe.g("OkHttp ConnectionPool", true));

    /* renamed from: ad  reason: collision with root package name */
    public final long f5531ad;

    /* renamed from: de  reason: collision with root package name */
    public final Runnable f5532de;

    /* renamed from: fe  reason: collision with root package name */
    public final Deque<de> f5533fe;
    public final int qw;

    /* renamed from: rg  reason: collision with root package name */
    public final fe.th.de.rrr.yj.fe f5534rg;

    /* renamed from: th  reason: collision with root package name */
    public boolean f5535th;

    public class qw implements Runnable {
        public qw() {
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x002b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
            L_0x0000:
                fe.th.de.th r0 = fe.th.de.th.this
                long r1 = java.lang.System.nanoTime()
                long r0 = r0.qw(r1)
                r2 = -1
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 != 0) goto L_0x0011
                return
            L_0x0011:
                r2 = 0
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 <= 0) goto L_0x0000
                r2 = 1000000(0xf4240, double:4.940656E-318)
                long r4 = r0 / r2
                long r2 = r2 * r4
                long r0 = r0 - r2
                fe.th.de.th r2 = fe.th.de.th.this
                monitor-enter(r2)
                fe.th.de.th r3 = fe.th.de.th.this     // Catch:{ InterruptedException -> 0x002b }
                int r1 = (int) r0     // Catch:{ InterruptedException -> 0x002b }
                r3.wait(r4, r1)     // Catch:{ InterruptedException -> 0x002b }
                goto L_0x002b
            L_0x0029:
                r0 = move-exception
                goto L_0x002d
            L_0x002b:
                monitor-exit(r2)     // Catch:{ all -> 0x0029 }
                goto L_0x0000
            L_0x002d:
                monitor-exit(r2)     // Catch:{ all -> 0x0029 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.th.de.th.qw.run():void");
        }
    }

    public th() {
        this(5, 5, TimeUnit.MINUTES);
    }

    public boolean ad(de deVar) {
        if (deVar.f5498pf || this.qw == 0) {
            this.f5533fe.remove(deVar);
            return true;
        }
        notifyAll();
        return false;
    }

    public Socket de(qw qwVar, fe.th.de.rrr.yj.th thVar) {
        for (de next : this.f5533fe) {
            if (next.pf(qwVar, (qqq) null) && next.m361switch() && next != thVar.fe()) {
                return thVar.xxx(next);
            }
        }
        return null;
    }

    public de fe(qw qwVar, fe.th.de.rrr.yj.th thVar, qqq qqq) {
        for (de next : this.f5533fe) {
            if (next.pf(qwVar, qqq)) {
                thVar.qw(next, true);
                return next;
            }
        }
        return null;
    }

    public long qw(long j) {
        synchronized (this) {
            de deVar = null;
            long j2 = Long.MIN_VALUE;
            int i2 = 0;
            int i3 = 0;
            for (de next : this.f5533fe) {
                if (rg(next, j) > 0) {
                    i3++;
                } else {
                    i2++;
                    long j3 = j - next.ppp;
                    if (j3 > j2) {
                        deVar = next;
                        j2 = j3;
                    }
                }
            }
            if (j2 < this.f5531ad) {
                if (i2 <= this.qw) {
                    if (i2 > 0) {
                        long j4 = this.f5531ad - j2;
                        return j4;
                    } else if (i3 > 0) {
                        long j5 = this.f5531ad;
                        return j5;
                    } else {
                        this.f5535th = false;
                        return -1;
                    }
                }
            }
            this.f5533fe.remove(deVar);
            fe.uk(deVar.ppp());
            return 0;
        }
    }

    public final int rg(de deVar, long j) {
        List<Reference<fe.th.de.rrr.yj.th>> list = deVar.when;
        int i2 = 0;
        while (i2 < list.size()) {
            Reference reference = list.get(i2);
            if (reference.get() != null) {
                i2++;
            } else {
                yj.m350switch().aaa("A connection to " + deVar.route().qw().m345if() + " was leaked. Did you forget to close a response body?", ((th.ad) reference).qw);
                list.remove(i2);
                deVar.f5498pf = true;
                if (list.isEmpty()) {
                    deVar.ppp = j - this.f5531ad;
                    return 0;
                }
            }
        }
        return list.size();
    }

    public void th(de deVar) {
        if (!this.f5535th) {
            this.f5535th = true;
            f5530yj.execute(this.f5532de);
        }
        this.f5533fe.add(deVar);
    }

    public th(int i2, long j, TimeUnit timeUnit) {
        this.f5532de = new qw();
        this.f5533fe = new ArrayDeque();
        this.f5534rg = new fe.th.de.rrr.yj.fe();
        this.qw = i2;
        this.f5531ad = timeUnit.toNanos(j);
        if (j <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
        }
    }
}
