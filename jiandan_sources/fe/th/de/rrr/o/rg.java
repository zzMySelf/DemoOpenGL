package fe.th.de.rrr.o;

import com.duxiaoman.okhttp3.internal.http2.ErrorCode;
import com.duxiaoman.okhttp3.internal.http2.PushObserver;
import fe.th.de.rrr.o.th;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

public final class rg implements Closeable {
    public static final ExecutorService g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), fe.th.de.rrr.fe.g("OkHttp Http2Connection", true));
    public long aaa;

    /* renamed from: ad  reason: collision with root package name */
    public final boolean f5352ad;
    public long ddd = 0;
    public final Cif e;
    public final o eee = new o();
    public final Set<Integer> f = new LinkedHashSet();
    public long ggg = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f5353i;

    /* renamed from: if  reason: not valid java name */
    public final ScheduledExecutorService f213if;
    public long mmm = 0;
    public long nn = 0;

    /* renamed from: o  reason: collision with root package name */
    public int f5354o;

    /* renamed from: pf  reason: collision with root package name */
    public boolean f5355pf;
    public long ppp = 0;
    public o qqq = new o();
    public final Socket rrr;

    /* renamed from: switch  reason: not valid java name */
    public final ExecutorService f214switch;

    /* renamed from: th  reason: collision with root package name */
    public final o f5356th;
    public final uk tt;

    /* renamed from: uk  reason: collision with root package name */
    public final String f5357uk;
    public long vvv = 0;
    public final PushObserver when;
    public long xxx = 0;

    /* renamed from: yj  reason: collision with root package name */
    public final Map<Integer, yj> f5358yj = new LinkedHashMap();

    public class ad extends fe.th.de.rrr.de {

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ int f5359th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ long f5361yj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ad(String str, Object[] objArr, int i2, long j) {
            super(str, objArr);
            this.f5359th = i2;
            this.f5361yj = j;
        }

        public void fe() {
            try {
                rg.this.tt.xxx(this.f5359th, this.f5361yj);
            } catch (IOException unused) {
                rg.this.vvv();
            }
        }
    }

    public class de extends fe.th.de.rrr.de {
        public de(String str, Object... objArr) {
            super(str, objArr);
        }

        public void fe() {
            rg.this.k(false, 2, 0);
        }
    }

    public class fe extends fe.th.de.rrr.de {

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ int f5363th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ List f5365yj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public fe(String str, Object[] objArr, int i2, List list) {
            super(str, objArr);
            this.f5363th = i2;
            this.f5365yj = list;
        }

        public void fe() {
            if (rg.this.when.onRequest(this.f5363th, this.f5365yj)) {
                try {
                    rg.this.tt.ppp(this.f5363th, ErrorCode.CANCEL);
                    synchronized (rg.this) {
                        rg.this.f.remove(Integer.valueOf(this.f5363th));
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    public final class i extends fe.th.de.rrr.de {
        public i() {
            super("OkHttp %s ping", rg.this.f5357uk);
        }

        public void fe() {
            boolean z;
            synchronized (rg.this) {
                if (rg.this.ggg < rg.this.ppp) {
                    z = true;
                } else {
                    rg.th(rg.this);
                    z = false;
                }
            }
            if (z) {
                rg.this.vvv();
            } else {
                rg.this.k(false, 1, 0);
            }
        }
    }

    /* renamed from: fe.th.de.rrr.o.rg$if  reason: invalid class name */
    public class Cif extends fe.th.de.rrr.de implements th.ad {

        /* renamed from: th  reason: collision with root package name */
        public final th f5367th;

        /* renamed from: fe.th.de.rrr.o.rg$if$ad */
        public class ad extends fe.th.de.rrr.de {

            /* renamed from: th  reason: collision with root package name */
            public final /* synthetic */ boolean f5369th;

            /* renamed from: yj  reason: collision with root package name */
            public final /* synthetic */ o f5371yj;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ad(String str, Object[] objArr, boolean z, o oVar) {
                super(str, objArr);
                this.f5369th = z;
                this.f5371yj = oVar;
            }

            public void fe() {
                Cif.this.rg(this.f5369th, this.f5371yj);
            }
        }

        /* renamed from: fe.th.de.rrr.o.rg$if$de */
        public class de extends fe.th.de.rrr.de {
            public de(String str, Object... objArr) {
                super(str, objArr);
            }

            public void fe() {
                rg rgVar = rg.this;
                rgVar.f5356th.qw(rgVar);
            }
        }

        /* renamed from: fe.th.de.rrr.o.rg$if$qw */
        public class qw extends fe.th.de.rrr.de {

            /* renamed from: th  reason: collision with root package name */
            public final /* synthetic */ yj f5373th;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public qw(String str, Object[] objArr, yj yjVar) {
                super(str, objArr);
                this.f5373th = yjVar;
            }

            public void fe() {
                try {
                    rg.this.f5356th.ad(this.f5373th);
                } catch (IOException e) {
                    fe.th.de.rrr.p019if.yj yjVar = fe.th.de.rrr.p019if.yj.m350switch();
                    yjVar.mmm(4, "Http2Connection.Listener failure for " + rg.this.f5357uk, e);
                    try {
                        this.f5373th.th(ErrorCode.PROTOCOL_ERROR);
                    } catch (IOException unused) {
                    }
                }
            }
        }

        public Cif(th thVar) {
            super("OkHttp %s", rg.this.f5357uk);
            this.f5367th = thVar;
        }

        public void ackSettings() {
        }

        public void ad(int i2, ErrorCode errorCode, ByteString byteString) {
            yj[] yjVarArr;
            byteString.size();
            synchronized (rg.this) {
                yjVarArr = (yj[]) rg.this.f5358yj.values().toArray(new yj[rg.this.f5358yj.size()]);
                boolean unused = rg.this.f5355pf = true;
            }
            for (yj yjVar : yjVarArr) {
                if (yjVar.i() > i2 && yjVar.m356if()) {
                    yjVar.xxx(ErrorCode.REFUSED_STREAM);
                    rg.this.c(yjVar.i());
                }
            }
        }

        public void data(boolean z, int i2, BufferedSource bufferedSource, int i3) throws IOException {
            if (rg.this.b(i2)) {
                rg.this.qqq(i2, bufferedSource, i3, z);
                return;
            }
            yj xxx = rg.this.xxx(i2);
            if (xxx == null) {
                rg.this.m(i2, ErrorCode.PROTOCOL_ERROR);
                long j = (long) i3;
                rg.this.h(j);
                bufferedSource.skip(j);
                return;
            }
            xxx.ppp(bufferedSource, i3);
            if (z) {
                xxx.ggg();
            }
        }

        public void de(boolean z, o oVar) {
            try {
                rg.this.f213if.execute(new ad("OkHttp %s ACK Settings", new Object[]{rg.this.f5357uk}, z, oVar));
            } catch (RejectedExecutionException unused) {
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r1 = com.duxiaoman.okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR;
            r0 = com.duxiaoman.okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            r2 = r4.f5368yj;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x002b, code lost:
            r2 = th;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x001c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void fe() {
            /*
                r4 = this;
                com.duxiaoman.okhttp3.internal.http2.ErrorCode r0 = com.duxiaoman.okhttp3.internal.http2.ErrorCode.INTERNAL_ERROR
                fe.th.de.rrr.o.th r1 = r4.f5367th     // Catch:{ IOException -> 0x001b, all -> 0x0018 }
                r1.fe(r4)     // Catch:{ IOException -> 0x001b, all -> 0x0018 }
            L_0x0007:
                fe.th.de.rrr.o.th r1 = r4.f5367th     // Catch:{ IOException -> 0x001b, all -> 0x0018 }
                r2 = 0
                boolean r1 = r1.de(r2, r4)     // Catch:{ IOException -> 0x001b, all -> 0x0018 }
                if (r1 == 0) goto L_0x0011
                goto L_0x0007
            L_0x0011:
                com.duxiaoman.okhttp3.internal.http2.ErrorCode r1 = com.duxiaoman.okhttp3.internal.http2.ErrorCode.NO_ERROR     // Catch:{ IOException -> 0x001b, all -> 0x0018 }
                com.duxiaoman.okhttp3.internal.http2.ErrorCode r0 = com.duxiaoman.okhttp3.internal.http2.ErrorCode.CANCEL     // Catch:{ IOException -> 0x001c }
                fe.th.de.rrr.o.rg r2 = fe.th.de.rrr.o.rg.this     // Catch:{ IOException -> 0x0025 }
                goto L_0x0022
            L_0x0018:
                r2 = move-exception
                r1 = r0
                goto L_0x002c
            L_0x001b:
                r1 = r0
            L_0x001c:
                com.duxiaoman.okhttp3.internal.http2.ErrorCode r1 = com.duxiaoman.okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR     // Catch:{ all -> 0x002b }
                com.duxiaoman.okhttp3.internal.http2.ErrorCode r0 = com.duxiaoman.okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR     // Catch:{ all -> 0x002b }
                fe.th.de.rrr.o.rg r2 = fe.th.de.rrr.o.rg.this     // Catch:{ IOException -> 0x0025 }
            L_0x0022:
                r2.ggg(r1, r0)     // Catch:{ IOException -> 0x0025 }
            L_0x0025:
                fe.th.de.rrr.o.th r0 = r4.f5367th
                fe.th.de.rrr.fe.yj(r0)
                return
            L_0x002b:
                r2 = move-exception
            L_0x002c:
                fe.th.de.rrr.o.rg r3 = fe.th.de.rrr.o.rg.this     // Catch:{ IOException -> 0x0031 }
                r3.ggg(r1, r0)     // Catch:{ IOException -> 0x0031 }
            L_0x0031:
                fe.th.de.rrr.o.th r0 = r4.f5367th
                fe.th.de.rrr.fe.yj(r0)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.th.de.rrr.o.rg.Cif.fe():void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0076, code lost:
            r0.vvv(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0079, code lost:
            if (r10 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x007b, code lost:
            r0.ggg();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void headers(boolean r10, int r11, int r12, java.util.List<fe.th.de.rrr.o.qw> r13) {
            /*
                r9 = this;
                fe.th.de.rrr.o.rg r12 = fe.th.de.rrr.o.rg.this
                boolean r12 = r12.b(r11)
                if (r12 == 0) goto L_0x000e
                fe.th.de.rrr.o.rg r12 = fe.th.de.rrr.o.rg.this
                r12.rrr(r11, r13, r10)
                return
            L_0x000e:
                fe.th.de.rrr.o.rg r12 = fe.th.de.rrr.o.rg.this
                monitor-enter(r12)
                fe.th.de.rrr.o.rg r0 = fe.th.de.rrr.o.rg.this     // Catch:{ all -> 0x007f }
                fe.th.de.rrr.o.yj r0 = r0.xxx(r11)     // Catch:{ all -> 0x007f }
                if (r0 != 0) goto L_0x0075
                fe.th.de.rrr.o.rg r0 = fe.th.de.rrr.o.rg.this     // Catch:{ all -> 0x007f }
                boolean r0 = r0.f5355pf     // Catch:{ all -> 0x007f }
                if (r0 == 0) goto L_0x0023
                monitor-exit(r12)     // Catch:{ all -> 0x007f }
                return
            L_0x0023:
                fe.th.de.rrr.o.rg r0 = fe.th.de.rrr.o.rg.this     // Catch:{ all -> 0x007f }
                int r0 = r0.f5353i     // Catch:{ all -> 0x007f }
                if (r11 > r0) goto L_0x002b
                monitor-exit(r12)     // Catch:{ all -> 0x007f }
                return
            L_0x002b:
                int r0 = r11 % 2
                fe.th.de.rrr.o.rg r1 = fe.th.de.rrr.o.rg.this     // Catch:{ all -> 0x007f }
                int r1 = r1.f5354o     // Catch:{ all -> 0x007f }
                r2 = 2
                int r1 = r1 % r2
                if (r0 != r1) goto L_0x0037
                monitor-exit(r12)     // Catch:{ all -> 0x007f }
                return
            L_0x0037:
                fe.th.de.pf r8 = fe.th.de.rrr.fe.h(r13)     // Catch:{ all -> 0x007f }
                fe.th.de.rrr.o.yj r13 = new fe.th.de.rrr.o.yj     // Catch:{ all -> 0x007f }
                fe.th.de.rrr.o.rg r5 = fe.th.de.rrr.o.rg.this     // Catch:{ all -> 0x007f }
                r6 = 0
                r3 = r13
                r4 = r11
                r7 = r10
                r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x007f }
                fe.th.de.rrr.o.rg r10 = fe.th.de.rrr.o.rg.this     // Catch:{ all -> 0x007f }
                r10.f5353i = r11     // Catch:{ all -> 0x007f }
                fe.th.de.rrr.o.rg r10 = fe.th.de.rrr.o.rg.this     // Catch:{ all -> 0x007f }
                java.util.Map<java.lang.Integer, fe.th.de.rrr.o.yj> r10 = r10.f5358yj     // Catch:{ all -> 0x007f }
                java.lang.Integer r0 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x007f }
                r10.put(r0, r13)     // Catch:{ all -> 0x007f }
                java.util.concurrent.ExecutorService r10 = fe.th.de.rrr.o.rg.g     // Catch:{ all -> 0x007f }
                fe.th.de.rrr.o.rg$if$qw r0 = new fe.th.de.rrr.o.rg$if$qw     // Catch:{ all -> 0x007f }
                java.lang.String r1 = "OkHttp %s stream %d"
                java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x007f }
                r3 = 0
                fe.th.de.rrr.o.rg r4 = fe.th.de.rrr.o.rg.this     // Catch:{ all -> 0x007f }
                java.lang.String r4 = r4.f5357uk     // Catch:{ all -> 0x007f }
                r2[r3] = r4     // Catch:{ all -> 0x007f }
                r3 = 1
                java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x007f }
                r2[r3] = r11     // Catch:{ all -> 0x007f }
                r0.<init>(r1, r2, r13)     // Catch:{ all -> 0x007f }
                r10.execute(r0)     // Catch:{ all -> 0x007f }
                monitor-exit(r12)     // Catch:{ all -> 0x007f }
                return
            L_0x0075:
                monitor-exit(r12)     // Catch:{ all -> 0x007f }
                r0.vvv(r13)
                if (r10 == 0) goto L_0x007e
                r0.ggg()
            L_0x007e:
                return
            L_0x007f:
                r10 = move-exception
                monitor-exit(r12)     // Catch:{ all -> 0x007f }
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.th.de.rrr.o.rg.Cif.headers(boolean, int, int, java.util.List):void");
        }

        public void ping(boolean z, int i2, int i3) {
            if (z) {
                synchronized (rg.this) {
                    if (i2 == 1) {
                        try {
                            rg.fe(rg.this);
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    } else if (i2 == 2) {
                        rg.when(rg.this);
                    } else if (i2 == 3) {
                        rg.ppp(rg.this);
                        rg.this.notifyAll();
                    }
                }
                return;
            }
            try {
                rg.this.f213if.execute(new pf(true, i2, i3));
            } catch (RejectedExecutionException unused) {
            }
        }

        public void priority(int i2, int i3, int i4, boolean z) {
        }

        public void pushPromise(int i2, int i3, List<qw> list) {
            rg.this.tt(i3, list);
        }

        public void qw(int i2, ErrorCode errorCode) {
            if (rg.this.b(i2)) {
                rg.this.a(i2, errorCode);
                return;
            }
            yj c = rg.this.c(i2);
            if (c != null) {
                c.xxx(errorCode);
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(8:2|3|7|17|18|19|20|21) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0063 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void rg(boolean r6, fe.th.de.rrr.o.o r7) {
            /*
                r5 = this;
                fe.th.de.rrr.o.rg r0 = fe.th.de.rrr.o.rg.this
                fe.th.de.rrr.o.uk r0 = r0.tt
                monitor-enter(r0)
                fe.th.de.rrr.o.rg r1 = fe.th.de.rrr.o.rg.this     // Catch:{ all -> 0x0098 }
                monitor-enter(r1)     // Catch:{ all -> 0x0098 }
                fe.th.de.rrr.o.rg r2 = fe.th.de.rrr.o.rg.this     // Catch:{ all -> 0x0095 }
                fe.th.de.rrr.o.o r2 = r2.eee     // Catch:{ all -> 0x0095 }
                int r2 = r2.fe()     // Catch:{ all -> 0x0095 }
                if (r6 == 0) goto L_0x0019
                fe.th.de.rrr.o.rg r6 = fe.th.de.rrr.o.rg.this     // Catch:{ all -> 0x0095 }
                fe.th.de.rrr.o.o r6 = r6.eee     // Catch:{ all -> 0x0095 }
                r6.qw()     // Catch:{ all -> 0x0095 }
            L_0x0019:
                fe.th.de.rrr.o.rg r6 = fe.th.de.rrr.o.rg.this     // Catch:{ all -> 0x0095 }
                fe.th.de.rrr.o.o r6 = r6.eee     // Catch:{ all -> 0x0095 }
                r6.uk(r7)     // Catch:{ all -> 0x0095 }
                fe.th.de.rrr.o.rg r6 = fe.th.de.rrr.o.rg.this     // Catch:{ all -> 0x0095 }
                fe.th.de.rrr.o.o r6 = r6.eee     // Catch:{ all -> 0x0095 }
                int r6 = r6.fe()     // Catch:{ all -> 0x0095 }
                r7 = -1
                r3 = 0
                if (r6 == r7) goto L_0x0054
                if (r6 == r2) goto L_0x0054
                int r6 = r6 - r2
                long r6 = (long) r6     // Catch:{ all -> 0x0095 }
                fe.th.de.rrr.o.rg r2 = fe.th.de.rrr.o.rg.this     // Catch:{ all -> 0x0095 }
                java.util.Map<java.lang.Integer, fe.th.de.rrr.o.yj> r2 = r2.f5358yj     // Catch:{ all -> 0x0095 }
                boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0095 }
                if (r2 != 0) goto L_0x0056
                fe.th.de.rrr.o.rg r2 = fe.th.de.rrr.o.rg.this     // Catch:{ all -> 0x0095 }
                java.util.Map<java.lang.Integer, fe.th.de.rrr.o.yj> r2 = r2.f5358yj     // Catch:{ all -> 0x0095 }
                java.util.Collection r2 = r2.values()     // Catch:{ all -> 0x0095 }
                fe.th.de.rrr.o.rg r3 = fe.th.de.rrr.o.rg.this     // Catch:{ all -> 0x0095 }
                java.util.Map<java.lang.Integer, fe.th.de.rrr.o.yj> r3 = r3.f5358yj     // Catch:{ all -> 0x0095 }
                int r3 = r3.size()     // Catch:{ all -> 0x0095 }
                fe.th.de.rrr.o.yj[] r3 = new fe.th.de.rrr.o.yj[r3]     // Catch:{ all -> 0x0095 }
                java.lang.Object[] r2 = r2.toArray(r3)     // Catch:{ all -> 0x0095 }
                fe.th.de.rrr.o.yj[] r2 = (fe.th.de.rrr.o.yj[]) r2     // Catch:{ all -> 0x0095 }
                r3 = r2
                goto L_0x0056
            L_0x0054:
                r6 = 0
            L_0x0056:
                monitor-exit(r1)     // Catch:{ all -> 0x0095 }
                fe.th.de.rrr.o.rg r1 = fe.th.de.rrr.o.rg.this     // Catch:{ IOException -> 0x0063 }
                fe.th.de.rrr.o.uk r1 = r1.tt     // Catch:{ IOException -> 0x0063 }
                fe.th.de.rrr.o.rg r2 = fe.th.de.rrr.o.rg.this     // Catch:{ IOException -> 0x0063 }
                fe.th.de.rrr.o.o r2 = r2.eee     // Catch:{ IOException -> 0x0063 }
                r1.qw(r2)     // Catch:{ IOException -> 0x0063 }
                goto L_0x0068
            L_0x0063:
                fe.th.de.rrr.o.rg r1 = fe.th.de.rrr.o.rg.this     // Catch:{ all -> 0x0098 }
                r1.vvv()     // Catch:{ all -> 0x0098 }
            L_0x0068:
                monitor-exit(r0)     // Catch:{ all -> 0x0098 }
                r0 = 0
                if (r3 == 0) goto L_0x007d
                int r1 = r3.length
                r2 = 0
            L_0x006e:
                if (r2 >= r1) goto L_0x007d
                r4 = r3[r2]
                monitor-enter(r4)
                r4.de(r6)     // Catch:{ all -> 0x007a }
                monitor-exit(r4)     // Catch:{ all -> 0x007a }
                int r2 = r2 + 1
                goto L_0x006e
            L_0x007a:
                r6 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x007a }
                throw r6
            L_0x007d:
                java.util.concurrent.ExecutorService r6 = fe.th.de.rrr.o.rg.g
                fe.th.de.rrr.o.rg$if$de r7 = new fe.th.de.rrr.o.rg$if$de
                java.lang.String r1 = "OkHttp %s settings"
                r2 = 1
                java.lang.Object[] r2 = new java.lang.Object[r2]
                fe.th.de.rrr.o.rg r3 = fe.th.de.rrr.o.rg.this
                java.lang.String r3 = r3.f5357uk
                r2[r0] = r3
                r7.<init>(r1, r2)
                r6.execute(r7)
                return
            L_0x0095:
                r6 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0095 }
                throw r6     // Catch:{ all -> 0x0098 }
            L_0x0098:
                r6 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0098 }
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.th.de.rrr.o.rg.Cif.rg(boolean, fe.th.de.rrr.o.o):void");
        }

        public void windowUpdate(int i2, long j) {
            if (i2 == 0) {
                synchronized (rg.this) {
                    rg.this.aaa += j;
                    rg.this.notifyAll();
                }
                return;
            }
            yj xxx = rg.this.xxx(i2);
            if (xxx != null) {
                synchronized (xxx) {
                    xxx.de(j);
                }
            }
        }
    }

    public static abstract class o {
        public static final o qw = new qw();

        public class qw extends o {
            public void ad(yj yjVar) throws IOException {
                yjVar.th(ErrorCode.REFUSED_STREAM);
            }
        }

        public abstract void ad(yj yjVar) throws IOException;

        public void qw(rg rgVar) {
        }
    }

    public final class pf extends fe.th.de.rrr.de {

        /* renamed from: th  reason: collision with root package name */
        public final boolean f5376th;

        /* renamed from: uk  reason: collision with root package name */
        public final int f5377uk;

        /* renamed from: yj  reason: collision with root package name */
        public final int f5378yj;

        public pf(boolean z, int i2, int i3) {
            super("OkHttp %s ping %08x%08x", rg.this.f5357uk, Integer.valueOf(i2), Integer.valueOf(i3));
            this.f5376th = z;
            this.f5378yj = i2;
            this.f5377uk = i3;
        }

        public void fe() {
            rg.this.k(this.f5376th, this.f5378yj, this.f5377uk);
        }
    }

    public class qw extends fe.th.de.rrr.de {

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ int f5379th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ ErrorCode f5381yj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public qw(String str, Object[] objArr, int i2, ErrorCode errorCode) {
            super(str, objArr);
            this.f5379th = i2;
            this.f5381yj = errorCode;
        }

        public void fe() {
            try {
                rg.this.l(this.f5379th, this.f5381yj);
            } catch (IOException unused) {
                rg.this.vvv();
            }
        }
    }

    /* renamed from: fe.th.de.rrr.o.rg$rg  reason: collision with other inner class name */
    public class C0226rg extends fe.th.de.rrr.de {

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ int f5383th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ boolean f5384uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ List f5385yj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0226rg(String str, Object[] objArr, int i2, List list, boolean z) {
            super(str, objArr);
            this.f5383th = i2;
            this.f5385yj = list;
            this.f5384uk = z;
        }

        public void fe() {
            boolean onHeaders = rg.this.when.onHeaders(this.f5383th, this.f5385yj, this.f5384uk);
            if (onHeaders) {
                try {
                    rg.this.tt.ppp(this.f5383th, ErrorCode.CANCEL);
                } catch (IOException unused) {
                    return;
                }
            }
            if (onHeaders || this.f5384uk) {
                synchronized (rg.this) {
                    rg.this.f.remove(Integer.valueOf(this.f5383th));
                }
            }
        }
    }

    public class th extends fe.th.de.rrr.de {

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f5386i;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ int f5388th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ int f5389uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ Buffer f5390yj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public th(String str, Object[] objArr, int i2, Buffer buffer, int i3, boolean z) {
            super(str, objArr);
            this.f5388th = i2;
            this.f5390yj = buffer;
            this.f5389uk = i3;
            this.f5386i = z;
        }

        public void fe() {
            try {
                boolean onData = rg.this.when.onData(this.f5388th, this.f5390yj, this.f5389uk, this.f5386i);
                if (onData) {
                    rg.this.tt.ppp(this.f5388th, ErrorCode.CANCEL);
                }
                if (onData || this.f5386i) {
                    synchronized (rg.this) {
                        rg.this.f.remove(Integer.valueOf(this.f5388th));
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    public static class uk {

        /* renamed from: ad  reason: collision with root package name */
        public String f5391ad;

        /* renamed from: de  reason: collision with root package name */
        public BufferedSource f5392de;

        /* renamed from: fe  reason: collision with root package name */
        public BufferedSink f5393fe;
        public Socket qw;

        /* renamed from: rg  reason: collision with root package name */
        public o f5394rg = o.qw;

        /* renamed from: th  reason: collision with root package name */
        public PushObserver f5395th = PushObserver.qw;

        /* renamed from: uk  reason: collision with root package name */
        public int f5396uk;

        /* renamed from: yj  reason: collision with root package name */
        public boolean f5397yj;

        public uk(boolean z) {
            this.f5397yj = z;
        }

        public uk ad(o oVar) {
            this.f5394rg = oVar;
            return this;
        }

        public uk de(int i2) {
            this.f5396uk = i2;
            return this;
        }

        public uk fe(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.qw = socket;
            this.f5391ad = str;
            this.f5392de = bufferedSource;
            this.f5393fe = bufferedSink;
            return this;
        }

        public rg qw() {
            return new rg(this);
        }
    }

    public class yj extends fe.th.de.rrr.de {

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ int f5398th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ ErrorCode f5400yj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public yj(String str, Object[] objArr, int i2, ErrorCode errorCode) {
            super(str, objArr);
            this.f5398th = i2;
            this.f5400yj = errorCode;
        }

        public void fe() {
            rg.this.when.qw(this.f5398th, this.f5400yj);
            synchronized (rg.this) {
                rg.this.f.remove(Integer.valueOf(this.f5398th));
            }
        }
    }

    static {
        Class<rg> cls = rg.class;
    }

    public rg(uk ukVar) {
        uk ukVar2 = ukVar;
        this.when = ukVar2.f5395th;
        boolean z = ukVar2.f5397yj;
        this.f5352ad = z;
        this.f5356th = ukVar2.f5394rg;
        int i2 = z ? 1 : 2;
        this.f5354o = i2;
        if (ukVar2.f5397yj) {
            this.f5354o = i2 + 2;
        }
        if (ukVar2.f5397yj) {
            this.qqq.i(7, 16777216);
        }
        this.f5357uk = ukVar2.f5391ad;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, fe.th.de.rrr.fe.g(fe.th.de.rrr.fe.xxx("OkHttp %s Writer", this.f5357uk), false));
        this.f213if = scheduledThreadPoolExecutor;
        if (ukVar2.f5396uk != 0) {
            i iVar = new i();
            int i3 = ukVar2.f5396uk;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(iVar, (long) i3, (long) i3, TimeUnit.MILLISECONDS);
        }
        this.f214switch = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), fe.th.de.rrr.fe.g(fe.th.de.rrr.fe.xxx("OkHttp %s Push Observer", this.f5357uk), true));
        this.eee.i(7, 65535);
        this.eee.i(5, 16384);
        this.aaa = (long) this.eee.fe();
        this.rrr = ukVar2.qw;
        this.tt = new uk(ukVar2.f5393fe, this.f5352ad);
        this.e = new Cif(new th(ukVar2.f5392de, this.f5352ad));
    }

    public static /* synthetic */ long fe(rg rgVar) {
        long j = rgVar.ggg;
        rgVar.ggg = 1 + j;
        return j;
    }

    public static /* synthetic */ long ppp(rg rgVar) {
        long j = rgVar.ddd;
        rgVar.ddd = 1 + j;
        return j;
    }

    public static /* synthetic */ long th(rg rgVar) {
        long j = rgVar.ppp;
        rgVar.ppp = 1 + j;
        return j;
    }

    public static /* synthetic */ long when(rg rgVar) {
        long j = rgVar.xxx;
        rgVar.xxx = 1 + j;
        return j;
    }

    public void a(int i2, ErrorCode errorCode) {
        eee(new yj("OkHttp %s Push Reset[%s]", new Object[]{this.f5357uk, Integer.valueOf(i2)}, i2, errorCode));
    }

    public yj aaa(List<qw> list, boolean z) throws IOException {
        return mmm(0, list, z);
    }

    public boolean b(int i2) {
        return i2 != 0 && (i2 & 1) == 0;
    }

    public synchronized yj c(int i2) {
        yj remove;
        remove = this.f5358yj.remove(Integer.valueOf(i2));
        notifyAll();
        return remove;
    }

    public void close() throws IOException {
        ggg(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    public void d() {
        synchronized (this) {
            if (this.xxx >= this.vvv) {
                this.vvv++;
                this.nn = System.nanoTime() + 1000000000;
                try {
                    this.f213if.execute(new de("OkHttp %s ping", this.f5357uk));
                } catch (RejectedExecutionException unused) {
                }
            }
        }
    }

    public synchronized boolean ddd(long j) {
        if (this.f5355pf) {
            return false;
        }
        if (this.xxx >= this.vvv || j < this.nn) {
            return true;
        }
        return false;
    }

    public void e(ErrorCode errorCode) throws IOException {
        synchronized (this.tt) {
            synchronized (this) {
                if (!this.f5355pf) {
                    this.f5355pf = true;
                    int i2 = this.f5353i;
                    this.tt.yj(i2, errorCode, fe.th.de.rrr.fe.qw);
                }
            }
        }
    }

    public final synchronized void eee(fe.th.de.rrr.de deVar) {
        if (!this.f5355pf) {
            this.f214switch.execute(deVar);
        }
    }

    public void f() throws IOException {
        g(true);
    }

    public void flush() throws IOException {
        this.tt.flush();
    }

    public void g(boolean z) throws IOException {
        if (z) {
            this.tt.de();
            this.tt.ggg(this.qqq);
            int fe2 = this.qqq.fe();
            if (fe2 != 65535) {
                this.tt.xxx(0, (long) (fe2 - 65535));
            }
        }
        new Thread(this.e).start();
    }

    public void ggg(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        yj[] yjVarArr = null;
        try {
            e(errorCode);
            e = null;
        } catch (IOException e2) {
            e = e2;
        }
        synchronized (this) {
            if (!this.f5358yj.isEmpty()) {
                yjVarArr = (yj[]) this.f5358yj.values().toArray(new yj[this.f5358yj.size()]);
                this.f5358yj.clear();
            }
        }
        if (yjVarArr != null) {
            for (yj th2 : yjVarArr) {
                try {
                    th2.th(errorCode2);
                } catch (IOException e3) {
                    if (e != null) {
                        e = e3;
                    }
                }
            }
        }
        try {
            this.tt.close();
        } catch (IOException e4) {
            if (e == null) {
                e = e4;
            }
        }
        try {
            this.rrr.close();
        } catch (IOException e5) {
            e = e5;
        }
        this.f213if.shutdown();
        this.f214switch.shutdown();
        if (e != null) {
            throw e;
        }
    }

    public synchronized void h(long j) {
        long j2 = this.mmm + j;
        this.mmm = j2;
        if (j2 >= ((long) (this.qqq.fe() / 2))) {
            n(0, this.mmm);
            this.mmm = 0;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:26|27|28) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r8.aaa), r8.tt.pf());
        r6 = (long) r3;
        r8.aaa -= r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0066, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x005a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j(int r9, boolean r10, okio.Buffer r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x000d
            fe.th.de.rrr.o.uk r12 = r8.tt
            r12.fe(r10, r9, r11, r0)
            return
        L_0x000d:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0069
            monitor-enter(r8)
        L_0x0012:
            long r3 = r8.aaa     // Catch:{ InterruptedException -> 0x005a }
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 > 0) goto L_0x0030
            java.util.Map<java.lang.Integer, fe.th.de.rrr.o.yj> r3 = r8.f5358yj     // Catch:{ InterruptedException -> 0x005a }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch:{ InterruptedException -> 0x005a }
            boolean r3 = r3.containsKey(r4)     // Catch:{ InterruptedException -> 0x005a }
            if (r3 == 0) goto L_0x0028
            r8.wait()     // Catch:{ InterruptedException -> 0x005a }
            goto L_0x0012
        L_0x0028:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ InterruptedException -> 0x005a }
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch:{ InterruptedException -> 0x005a }
            throw r9     // Catch:{ InterruptedException -> 0x005a }
        L_0x0030:
            long r3 = r8.aaa     // Catch:{ all -> 0x0058 }
            long r3 = java.lang.Math.min(r12, r3)     // Catch:{ all -> 0x0058 }
            int r4 = (int) r3     // Catch:{ all -> 0x0058 }
            fe.th.de.rrr.o.uk r3 = r8.tt     // Catch:{ all -> 0x0058 }
            int r3 = r3.pf()     // Catch:{ all -> 0x0058 }
            int r3 = java.lang.Math.min(r4, r3)     // Catch:{ all -> 0x0058 }
            long r4 = r8.aaa     // Catch:{ all -> 0x0058 }
            long r6 = (long) r3     // Catch:{ all -> 0x0058 }
            long r4 = r4 - r6
            r8.aaa = r4     // Catch:{ all -> 0x0058 }
            monitor-exit(r8)     // Catch:{ all -> 0x0058 }
            long r12 = r12 - r6
            fe.th.de.rrr.o.uk r4 = r8.tt
            if (r10 == 0) goto L_0x0053
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x0053
            r5 = 1
            goto L_0x0054
        L_0x0053:
            r5 = 0
        L_0x0054:
            r4.fe(r5, r9, r11, r3)
            goto L_0x000d
        L_0x0058:
            r9 = move-exception
            goto L_0x0067
        L_0x005a:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0058 }
            r9.interrupt()     // Catch:{ all -> 0x0058 }
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0058 }
            r9.<init>()     // Catch:{ all -> 0x0058 }
            throw r9     // Catch:{ all -> 0x0058 }
        L_0x0067:
            monitor-exit(r8)     // Catch:{ all -> 0x0058 }
            throw r9
        L_0x0069:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.th.de.rrr.o.rg.j(int, boolean, okio.Buffer, long):void");
    }

    public void k(boolean z, int i2, int i3) {
        try {
            this.tt.m355switch(z, i2, i3);
        } catch (IOException unused) {
            vvv();
        }
    }

    public void l(int i2, ErrorCode errorCode) throws IOException {
        this.tt.ppp(i2, errorCode);
    }

    public void m(int i2, ErrorCode errorCode) {
        try {
            this.f213if.execute(new qw("OkHttp %s stream %d", new Object[]{this.f5357uk, Integer.valueOf(i2)}, i2, errorCode));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final fe.th.de.rrr.o.yj mmm(int r11, java.util.List<fe.th.de.rrr.o.qw> r12, boolean r13) throws java.io.IOException {
        /*
            r10 = this;
            r6 = r13 ^ 1
            r4 = 0
            fe.th.de.rrr.o.uk r7 = r10.tt
            monitor-enter(r7)
            monitor-enter(r10)     // Catch:{ all -> 0x0078 }
            int r0 = r10.f5354o     // Catch:{ all -> 0x0075 }
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L_0x0013
            com.duxiaoman.okhttp3.internal.http2.ErrorCode r0 = com.duxiaoman.okhttp3.internal.http2.ErrorCode.REFUSED_STREAM     // Catch:{ all -> 0x0075 }
            r10.e(r0)     // Catch:{ all -> 0x0075 }
        L_0x0013:
            boolean r0 = r10.f5355pf     // Catch:{ all -> 0x0075 }
            if (r0 != 0) goto L_0x006f
            int r8 = r10.f5354o     // Catch:{ all -> 0x0075 }
            int r0 = r10.f5354o     // Catch:{ all -> 0x0075 }
            int r0 = r0 + 2
            r10.f5354o = r0     // Catch:{ all -> 0x0075 }
            fe.th.de.rrr.o.yj r9 = new fe.th.de.rrr.o.yj     // Catch:{ all -> 0x0075 }
            r5 = 0
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0075 }
            if (r13 == 0) goto L_0x003c
            long r0 = r10.aaa     // Catch:{ all -> 0x0075 }
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L_0x003c
            long r0 = r9.f5419ad     // Catch:{ all -> 0x0075 }
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r13 = 0
            goto L_0x003d
        L_0x003c:
            r13 = 1
        L_0x003d:
            boolean r0 = r9.m357switch()     // Catch:{ all -> 0x0075 }
            if (r0 == 0) goto L_0x004c
            java.util.Map<java.lang.Integer, fe.th.de.rrr.o.yj> r0 = r10.f5358yj     // Catch:{ all -> 0x0075 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0075 }
            r0.put(r1, r9)     // Catch:{ all -> 0x0075 }
        L_0x004c:
            monitor-exit(r10)     // Catch:{ all -> 0x0075 }
            if (r11 != 0) goto L_0x0055
            fe.th.de.rrr.o.uk r0 = r10.tt     // Catch:{ all -> 0x0078 }
            r0.vvv(r6, r8, r11, r12)     // Catch:{ all -> 0x0078 }
            goto L_0x005e
        L_0x0055:
            boolean r0 = r10.f5352ad     // Catch:{ all -> 0x0078 }
            if (r0 != 0) goto L_0x0067
            fe.th.de.rrr.o.uk r0 = r10.tt     // Catch:{ all -> 0x0078 }
            r0.when(r11, r8, r12)     // Catch:{ all -> 0x0078 }
        L_0x005e:
            monitor-exit(r7)     // Catch:{ all -> 0x0078 }
            if (r13 == 0) goto L_0x0066
            fe.th.de.rrr.o.uk r11 = r10.tt
            r11.flush()
        L_0x0066:
            return r9
        L_0x0067:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0078 }
            java.lang.String r12 = "client streams shouldn't have associated stream IDs"
            r11.<init>(r12)     // Catch:{ all -> 0x0078 }
            throw r11     // Catch:{ all -> 0x0078 }
        L_0x006f:
            com.duxiaoman.okhttp3.internal.http2.ConnectionShutdownException r11 = new com.duxiaoman.okhttp3.internal.http2.ConnectionShutdownException     // Catch:{ all -> 0x0075 }
            r11.<init>()     // Catch:{ all -> 0x0075 }
            throw r11     // Catch:{ all -> 0x0075 }
        L_0x0075:
            r11 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0075 }
            throw r11     // Catch:{ all -> 0x0078 }
        L_0x0078:
            r11 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0078 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.th.de.rrr.o.rg.mmm(int, java.util.List, boolean):fe.th.de.rrr.o.yj");
    }

    public void n(int i2, long j) {
        try {
            this.f213if.execute(new ad("OkHttp Window Update %s stream %d", new Object[]{this.f5357uk, Integer.valueOf(i2)}, i2, j));
        } catch (RejectedExecutionException unused) {
        }
    }

    public synchronized int nn() {
        return this.eee.rg(Integer.MAX_VALUE);
    }

    public void qqq(int i2, BufferedSource bufferedSource, int i3, boolean z) throws IOException {
        Buffer buffer = new Buffer();
        long j = (long) i3;
        bufferedSource.require(j);
        bufferedSource.read(buffer, j);
        if (buffer.size() == j) {
            eee(new th("OkHttp %s Push Data[%s]", new Object[]{this.f5357uk, Integer.valueOf(i2)}, i2, buffer, i3, z));
            return;
        }
        throw new IOException(buffer.size() + " != " + i3);
    }

    public void rrr(int i2, List<qw> list, boolean z) {
        try {
            eee(new C0226rg("OkHttp %s Push Headers[%s]", new Object[]{this.f5357uk, Integer.valueOf(i2)}, i2, list, z));
        } catch (RejectedExecutionException unused) {
        }
    }

    public void tt(int i2, List<qw> list) {
        synchronized (this) {
            if (this.f.contains(Integer.valueOf(i2))) {
                m(i2, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.f.add(Integer.valueOf(i2));
            try {
                eee(new fe("OkHttp %s Push Request[%s]", new Object[]{this.f5357uk, Integer.valueOf(i2)}, i2, list));
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    public final void vvv() {
        try {
            ggg(ErrorCode.PROTOCOL_ERROR, ErrorCode.PROTOCOL_ERROR);
        } catch (IOException unused) {
        }
    }

    public synchronized yj xxx(int i2) {
        return this.f5358yj.get(Integer.valueOf(i2));
    }
}
