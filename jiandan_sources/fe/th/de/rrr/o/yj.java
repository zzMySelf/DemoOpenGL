package fe.th.de.rrr.o;

import com.alipay.sdk.m.m.a;
import com.duxiaoman.okhttp3.internal.http2.ErrorCode;
import com.duxiaoman.okhttp3.internal.http2.StreamResetException;
import fe.th.de.pf;
import fe.th.de.rrr.fe;
import fe.th.de.rrr.o.qw;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class yj {

    /* renamed from: ad  reason: collision with root package name */
    public long f5419ad;

    /* renamed from: de  reason: collision with root package name */
    public final int f5420de;

    /* renamed from: fe  reason: collision with root package name */
    public final rg f5421fe;

    /* renamed from: i  reason: collision with root package name */
    public final qw f5422i;

    /* renamed from: if  reason: not valid java name */
    public ErrorCode f215if = null;

    /* renamed from: o  reason: collision with root package name */
    public final de f5423o = new de();

    /* renamed from: pf  reason: collision with root package name */
    public final de f5424pf = new de();
    public long qw = 0;

    /* renamed from: rg  reason: collision with root package name */
    public final Deque<pf> f5425rg = new ArrayDeque();

    /* renamed from: th  reason: collision with root package name */
    public qw.C0225qw f5426th;

    /* renamed from: uk  reason: collision with root package name */
    public final ad f5427uk;

    /* renamed from: yj  reason: collision with root package name */
    public boolean f5428yj;

    public final class ad implements Source {

        /* renamed from: ad  reason: collision with root package name */
        public final Buffer f5429ad = new Buffer();

        /* renamed from: i  reason: collision with root package name */
        public boolean f5430i;

        /* renamed from: th  reason: collision with root package name */
        public final Buffer f5432th = new Buffer();

        /* renamed from: uk  reason: collision with root package name */
        public boolean f5433uk;

        /* renamed from: yj  reason: collision with root package name */
        public final long f5434yj;

        public ad(long j) {
            this.f5434yj = j;
        }

        public void close() throws IOException {
            long size;
            qw.C0225qw qwVar;
            ArrayList<pf> arrayList;
            synchronized (yj.this) {
                this.f5433uk = true;
                size = this.f5432th.size();
                this.f5432th.clear();
                qwVar = null;
                if (yj.this.f5425rg.isEmpty() || yj.this.f5426th == null) {
                    arrayList = null;
                } else {
                    ArrayList arrayList2 = new ArrayList(yj.this.f5425rg);
                    yj.this.f5425rg.clear();
                    ArrayList arrayList3 = arrayList2;
                    qwVar = yj.this.f5426th;
                    arrayList = arrayList3;
                }
                yj.this.notifyAll();
            }
            if (size > 0) {
                de(size);
            }
            yj.this.fe();
            if (qwVar != null) {
                for (pf qw : arrayList) {
                    qwVar.qw(qw);
                }
            }
        }

        public final void de(long j) {
            yj.this.f5421fe.h(j);
        }

        public void qw(BufferedSource bufferedSource, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            long j2;
            while (j > 0) {
                synchronized (yj.this) {
                    z = this.f5430i;
                    z2 = true;
                    z3 = this.f5432th.size() + j > this.f5434yj;
                }
                if (z3) {
                    bufferedSource.skip(j);
                    yj.this.uk(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    bufferedSource.skip(j);
                    return;
                } else {
                    long read = bufferedSource.read(this.f5429ad, j);
                    if (read != -1) {
                        j -= read;
                        synchronized (yj.this) {
                            if (this.f5433uk) {
                                j2 = this.f5429ad.size();
                                this.f5429ad.clear();
                            } else {
                                if (this.f5432th.size() != 0) {
                                    z2 = false;
                                }
                                this.f5432th.writeAll(this.f5429ad);
                                if (z2) {
                                    yj.this.notifyAll();
                                }
                                j2 = 0;
                            }
                        }
                        if (j2 > 0) {
                            de(j2);
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
        }

        public long read(Buffer buffer, long j) throws IOException {
            ErrorCode errorCode;
            long j2;
            qw.C0225qw qwVar;
            pf pfVar;
            long j3 = j;
            if (j3 >= 0) {
                while (true) {
                    synchronized (yj.this) {
                        yj.this.f5423o.enter();
                        try {
                            errorCode = yj.this.f215if != null ? yj.this.f215if : null;
                            if (!this.f5433uk) {
                                if (yj.this.f5425rg.isEmpty() || yj.this.f5426th == null) {
                                    if (this.f5432th.size() > 0) {
                                        j2 = this.f5432th.read(buffer, Math.min(j3, this.f5432th.size()));
                                        yj.this.qw += j2;
                                        if (errorCode == null && yj.this.qw >= ((long) (yj.this.f5421fe.qqq.fe() / 2))) {
                                            yj.this.f5421fe.n(yj.this.f5420de, yj.this.qw);
                                            yj.this.qw = 0;
                                        }
                                    } else {
                                        Buffer buffer2 = buffer;
                                        if (this.f5430i || errorCode != null) {
                                            j2 = -1;
                                        } else {
                                            yj.this.nn();
                                        }
                                    }
                                    pfVar = null;
                                    qwVar = null;
                                } else {
                                    pfVar = (pf) yj.this.f5425rg.removeFirst();
                                    qwVar = yj.this.f5426th;
                                    Buffer buffer3 = buffer;
                                    j2 = -1;
                                }
                                yj.this.f5423o.exitAndThrowIfTimedOut();
                                if (pfVar != null && qwVar != null) {
                                    qwVar.qw(pfVar);
                                }
                            } else {
                                throw new IOException("stream closed");
                            }
                        } finally {
                            yj.this.f5423o.exitAndThrowIfTimedOut();
                        }
                    }
                }
                if (j2 != -1) {
                    de(j2);
                    return j2;
                } else if (errorCode == null) {
                    return -1;
                } else {
                    throw new StreamResetException(errorCode);
                }
            } else {
                throw new IllegalArgumentException("byteCount < 0: " + j3);
            }
        }

        public Timeout timeout() {
            return yj.this.f5423o;
        }
    }

    public class de extends AsyncTimeout {
        public de() {
        }

        public void exitAndThrowIfTimedOut() throws IOException {
            if (exit()) {
                throw newTimeoutException((IOException) null);
            }
        }

        public IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException(a.Z);
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        public void timedOut() {
            yj.this.uk(ErrorCode.CANCEL);
            yj.this.f5421fe.d();
        }
    }

    public final class qw implements Sink {

        /* renamed from: ad  reason: collision with root package name */
        public final Buffer f5435ad = new Buffer();

        /* renamed from: th  reason: collision with root package name */
        public boolean f5436th;

        /* renamed from: yj  reason: collision with root package name */
        public boolean f5438yj;

        public qw() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
            if (r8.f5435ad.size() <= 0) goto L_0x002d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
            if (r8.f5435ad.size() <= 0) goto L_0x003a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
            qw(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x002d, code lost:
            r0 = r8.f5437uk;
            r0.f5421fe.j(r0.f5420de, true, (okio.Buffer) null, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x003a, code lost:
            r2 = r8.f5437uk;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            r8.f5436th = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x003f, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0040, code lost:
            r8.f5437uk.f5421fe.flush();
            r8.f5437uk.fe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x004c, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0011, code lost:
            if (r8.f5437uk.f5422i.f5438yj != false) goto L_0x003a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() throws java.io.IOException {
            /*
                r8 = this;
                fe.th.de.rrr.o.yj r0 = fe.th.de.rrr.o.yj.this
                monitor-enter(r0)
                boolean r1 = r8.f5436th     // Catch:{ all -> 0x0050 }
                if (r1 == 0) goto L_0x0009
                monitor-exit(r0)     // Catch:{ all -> 0x0050 }
                return
            L_0x0009:
                monitor-exit(r0)     // Catch:{ all -> 0x0050 }
                fe.th.de.rrr.o.yj r0 = fe.th.de.rrr.o.yj.this
                fe.th.de.rrr.o.yj$qw r0 = r0.f5422i
                boolean r0 = r0.f5438yj
                r1 = 1
                if (r0 != 0) goto L_0x003a
                okio.Buffer r0 = r8.f5435ad
                long r2 = r0.size()
                r4 = 0
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x002d
            L_0x001f:
                okio.Buffer r0 = r8.f5435ad
                long r2 = r0.size()
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x003a
                r8.qw(r1)
                goto L_0x001f
            L_0x002d:
                fe.th.de.rrr.o.yj r0 = fe.th.de.rrr.o.yj.this
                fe.th.de.rrr.o.rg r2 = r0.f5421fe
                int r3 = r0.f5420de
                r4 = 1
                r5 = 0
                r6 = 0
                r2.j(r3, r4, r5, r6)
            L_0x003a:
                fe.th.de.rrr.o.yj r2 = fe.th.de.rrr.o.yj.this
                monitor-enter(r2)
                r8.f5436th = r1     // Catch:{ all -> 0x004d }
                monitor-exit(r2)     // Catch:{ all -> 0x004d }
                fe.th.de.rrr.o.yj r0 = fe.th.de.rrr.o.yj.this
                fe.th.de.rrr.o.rg r0 = r0.f5421fe
                r0.flush()
                fe.th.de.rrr.o.yj r0 = fe.th.de.rrr.o.yj.this
                r0.fe()
                return
            L_0x004d:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x004d }
                throw r0
            L_0x0050:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0050 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.th.de.rrr.o.yj.qw.close():void");
        }

        public void flush() throws IOException {
            synchronized (yj.this) {
                yj.this.rg();
            }
            while (this.f5435ad.size() > 0) {
                qw(false);
                yj.this.f5421fe.flush();
            }
        }

        /* JADX INFO: finally extract failed */
        public final void qw(boolean z) throws IOException {
            long min;
            synchronized (yj.this) {
                yj.this.f5424pf.enter();
                while (yj.this.f5419ad <= 0 && !this.f5438yj && !this.f5436th && yj.this.f215if == null) {
                    try {
                        yj.this.nn();
                    } catch (Throwable th2) {
                        yj.this.f5424pf.exitAndThrowIfTimedOut();
                        throw th2;
                    }
                }
                yj.this.f5424pf.exitAndThrowIfTimedOut();
                yj.this.rg();
                min = Math.min(yj.this.f5419ad, this.f5435ad.size());
                yj.this.f5419ad -= min;
            }
            yj.this.f5424pf.enter();
            try {
                yj.this.f5421fe.j(yj.this.f5420de, z && min == this.f5435ad.size(), this.f5435ad, min);
            } finally {
                yj.this.f5424pf.exitAndThrowIfTimedOut();
            }
        }

        public Timeout timeout() {
            return yj.this.f5424pf;
        }

        public void write(Buffer buffer, long j) throws IOException {
            this.f5435ad.write(buffer, j);
            while (this.f5435ad.size() >= 16384) {
                qw(false);
            }
        }
    }

    public yj(int i2, rg rgVar, boolean z, boolean z2, pf pfVar) {
        if (rgVar != null) {
            this.f5420de = i2;
            this.f5421fe = rgVar;
            this.f5419ad = (long) rgVar.eee.fe();
            this.f5427uk = new ad((long) rgVar.qqq.fe());
            qw qwVar = new qw();
            this.f5422i = qwVar;
            this.f5427uk.f5430i = z2;
            qwVar.f5438yj = z;
            if (pfVar != null) {
                this.f5425rg.add(pfVar);
            }
            if (m356if() && pfVar != null) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            } else if (!m356if() && pfVar == null) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
        } else {
            throw new NullPointerException("connection == null");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0036, code lost:
        r2.f5423o.exitAndThrowIfTimedOut();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003b, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized fe.th.de.pf ddd() throws java.io.IOException {
        /*
            r2 = this;
            monitor-enter(r2)
            fe.th.de.rrr.o.yj$de r0 = r2.f5423o     // Catch:{ all -> 0x003c }
            r0.enter()     // Catch:{ all -> 0x003c }
        L_0x0006:
            java.util.Deque<fe.th.de.pf> r0 = r2.f5425rg     // Catch:{ all -> 0x0035 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x0016
            com.duxiaoman.okhttp3.internal.http2.ErrorCode r0 = r2.f215if     // Catch:{ all -> 0x0035 }
            if (r0 != 0) goto L_0x0016
            r2.nn()     // Catch:{ all -> 0x0035 }
            goto L_0x0006
        L_0x0016:
            fe.th.de.rrr.o.yj$de r0 = r2.f5423o     // Catch:{ all -> 0x003c }
            r0.exitAndThrowIfTimedOut()     // Catch:{ all -> 0x003c }
            java.util.Deque<fe.th.de.pf> r0 = r2.f5425rg     // Catch:{ all -> 0x003c }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x003c }
            if (r0 != 0) goto L_0x002d
            java.util.Deque<fe.th.de.pf> r0 = r2.f5425rg     // Catch:{ all -> 0x003c }
            java.lang.Object r0 = r0.removeFirst()     // Catch:{ all -> 0x003c }
            fe.th.de.pf r0 = (fe.th.de.pf) r0     // Catch:{ all -> 0x003c }
            monitor-exit(r2)
            return r0
        L_0x002d:
            com.duxiaoman.okhttp3.internal.http2.StreamResetException r0 = new com.duxiaoman.okhttp3.internal.http2.StreamResetException     // Catch:{ all -> 0x003c }
            com.duxiaoman.okhttp3.internal.http2.ErrorCode r1 = r2.f215if     // Catch:{ all -> 0x003c }
            r0.<init>(r1)     // Catch:{ all -> 0x003c }
            throw r0     // Catch:{ all -> 0x003c }
        L_0x0035:
            r0 = move-exception
            fe.th.de.rrr.o.yj$de r1 = r2.f5423o     // Catch:{ all -> 0x003c }
            r1.exitAndThrowIfTimedOut()     // Catch:{ all -> 0x003c }
            throw r0     // Catch:{ all -> 0x003c }
        L_0x003c:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.th.de.rrr.o.yj.ddd():fe.th.de.pf");
    }

    public void de(long j) {
        this.f5419ad += j;
        if (j > 0) {
            notifyAll();
        }
    }

    public void fe() throws IOException {
        boolean z;
        boolean z2;
        synchronized (this) {
            z = !this.f5427uk.f5430i && this.f5427uk.f5433uk && (this.f5422i.f5438yj || this.f5422i.f5436th);
            z2 = m357switch();
        }
        if (z) {
            th(ErrorCode.CANCEL);
        } else if (!z2) {
            this.f5421fe.c(this.f5420de);
        }
    }

    public void ggg() {
        boolean z;
        synchronized (this) {
            this.f5427uk.f5430i = true;
            z = m357switch();
            notifyAll();
        }
        if (!z) {
            this.f5421fe.c(this.f5420de);
        }
    }

    public int i() {
        return this.f5420de;
    }

    /* renamed from: if  reason: not valid java name */
    public boolean m356if() {
        if (this.f5421fe.f5352ad == ((this.f5420de & 1) == 1)) {
            return true;
        }
        return false;
    }

    public Timeout mmm() {
        return this.f5424pf;
    }

    public void nn() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public Sink o() {
        synchronized (this) {
            if (!this.f5428yj) {
                if (!m356if()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            }
        }
        return this.f5422i;
    }

    public Source pf() {
        return this.f5427uk;
    }

    public void ppp(BufferedSource bufferedSource, int i2) throws IOException {
        this.f5427uk.qw(bufferedSource, (long) i2);
    }

    public void rg() throws IOException {
        qw qwVar = this.f5422i;
        if (qwVar.f5436th) {
            throw new IOException("stream closed");
        } else if (qwVar.f5438yj) {
            throw new IOException("stream finished");
        } else if (this.f215if != null) {
            throw new StreamResetException(this.f215if);
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public synchronized boolean m357switch() {
        if (this.f215if != null) {
            return false;
        }
        if ((this.f5427uk.f5430i || this.f5427uk.f5433uk) && ((this.f5422i.f5438yj || this.f5422i.f5436th) && this.f5428yj)) {
            return false;
        }
        return true;
    }

    public void th(ErrorCode errorCode) throws IOException {
        if (yj(errorCode)) {
            this.f5421fe.l(this.f5420de, errorCode);
        }
    }

    public void uk(ErrorCode errorCode) {
        if (yj(errorCode)) {
            this.f5421fe.m(this.f5420de, errorCode);
        }
    }

    public void vvv(List<qw> list) {
        boolean z;
        synchronized (this) {
            this.f5428yj = true;
            this.f5425rg.add(fe.h(list));
            z = m357switch();
            notifyAll();
        }
        if (!z) {
            this.f5421fe.c(this.f5420de);
        }
    }

    public Timeout when() {
        return this.f5423o;
    }

    public synchronized void xxx(ErrorCode errorCode) {
        if (this.f215if == null) {
            this.f215if = errorCode;
            notifyAll();
        }
    }

    public final boolean yj(ErrorCode errorCode) {
        synchronized (this) {
            if (this.f215if != null) {
                return false;
            }
            if (this.f5427uk.f5430i && this.f5422i.f5438yj) {
                return false;
            }
            this.f215if = errorCode;
            notifyAll();
            this.f5421fe.c(this.f5420de);
            return true;
        }
    }
}
