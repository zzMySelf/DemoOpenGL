package fe.th.de;

import androidx.core.app.NotificationCompat;
import com.alipay.sdk.m.m.a;
import com.duxiaoman.okhttp3.Call;
import com.duxiaoman.okhttp3.Callback;
import com.duxiaoman.okhttp3.EventListener;
import com.duxiaoman.okhttp3.internal.http.HttpCodec;
import fe.th.de.rrr.de;
import fe.th.de.rrr.fe;
import fe.th.de.rrr.p019if.yj;
import fe.th.de.rrr.uk.i;
import fe.th.de.rrr.uk.th;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import okio.AsyncTimeout;

public final class xxx implements Call {

    /* renamed from: ad  reason: collision with root package name */
    public final ggg f5562ad;

    /* renamed from: i  reason: collision with root package name */
    public final ddd f5563i;

    /* renamed from: o  reason: collision with root package name */
    public final boolean f5564o;

    /* renamed from: pf  reason: collision with root package name */
    public boolean f5565pf;

    /* renamed from: th  reason: collision with root package name */
    public final i f5566th;

    /* renamed from: uk  reason: collision with root package name */
    public EventListener f5567uk;

    /* renamed from: yj  reason: collision with root package name */
    public final AsyncTimeout f5568yj;

    public final class ad extends de {

        /* renamed from: th  reason: collision with root package name */
        public final Callback f5569th;

        static {
            Class<xxx> cls = xxx.class;
        }

        public ad(Callback callback) {
            super("OkHttp %s", xxx.this.yj());
            this.f5569th = callback;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0030 A[Catch:{ IOException -> 0x004e, all -> 0x0026, all -> 0x008d }] */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0059 A[Catch:{ IOException -> 0x004e, all -> 0x0026, all -> 0x008d }] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0079 A[Catch:{ IOException -> 0x004e, all -> 0x0026, all -> 0x008d }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void fe() {
            /*
                r5 = this;
                fe.th.de.xxx r0 = fe.th.de.xxx.this
                okio.AsyncTimeout r0 = r0.f5568yj
                r0.enter()
                r0 = 0
                fe.th.de.xxx r1 = fe.th.de.xxx.this     // Catch:{ IOException -> 0x004e, all -> 0x0026 }
                fe.th.de.mmm r0 = r1.rg()     // Catch:{ IOException -> 0x004e, all -> 0x0026 }
                r1 = 1
                com.duxiaoman.okhttp3.Callback r2 = r5.f5569th     // Catch:{ IOException -> 0x0024, all -> 0x0022 }
                fe.th.de.xxx r3 = fe.th.de.xxx.this     // Catch:{ IOException -> 0x0024, all -> 0x0022 }
                r2.onResponse(r3, r0)     // Catch:{ IOException -> 0x0024, all -> 0x0022 }
            L_0x0016:
                fe.th.de.xxx r0 = fe.th.de.xxx.this
                fe.th.de.ggg r0 = r0.f5562ad
                fe.th.de.i r0 = r0.i()
                r0.fe(r5)
                goto L_0x008c
            L_0x0022:
                r0 = move-exception
                goto L_0x0029
            L_0x0024:
                r0 = move-exception
                goto L_0x0051
            L_0x0026:
                r1 = move-exception
                r0 = r1
                r1 = 0
            L_0x0029:
                fe.th.de.xxx r2 = fe.th.de.xxx.this     // Catch:{ all -> 0x008d }
                r2.cancel()     // Catch:{ all -> 0x008d }
                if (r1 != 0) goto L_0x004d
                java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x008d }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x008d }
                r2.<init>()     // Catch:{ all -> 0x008d }
                java.lang.String r3 = "canceled due to "
                r2.append(r3)     // Catch:{ all -> 0x008d }
                r2.append(r0)     // Catch:{ all -> 0x008d }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x008d }
                r1.<init>(r2)     // Catch:{ all -> 0x008d }
                com.duxiaoman.okhttp3.Callback r2 = r5.f5569th     // Catch:{ all -> 0x008d }
                fe.th.de.xxx r3 = fe.th.de.xxx.this     // Catch:{ all -> 0x008d }
                r2.onFailure(r3, r1)     // Catch:{ all -> 0x008d }
            L_0x004d:
                throw r0     // Catch:{ all -> 0x008d }
            L_0x004e:
                r1 = move-exception
                r0 = r1
                r1 = 0
            L_0x0051:
                fe.th.de.xxx r2 = fe.th.de.xxx.this     // Catch:{ all -> 0x008d }
                java.io.IOException r0 = r2.uk(r0)     // Catch:{ all -> 0x008d }
                if (r1 == 0) goto L_0x0079
                fe.th.de.rrr.if.yj r1 = fe.th.de.rrr.p019if.yj.m350switch()     // Catch:{ all -> 0x008d }
                r2 = 4
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x008d }
                r3.<init>()     // Catch:{ all -> 0x008d }
                java.lang.String r4 = "Callback failure for "
                r3.append(r4)     // Catch:{ all -> 0x008d }
                fe.th.de.xxx r4 = fe.th.de.xxx.this     // Catch:{ all -> 0x008d }
                java.lang.String r4 = r4.i()     // Catch:{ all -> 0x008d }
                r3.append(r4)     // Catch:{ all -> 0x008d }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x008d }
                r1.mmm(r2, r3, r0)     // Catch:{ all -> 0x008d }
                goto L_0x0016
            L_0x0079:
                fe.th.de.xxx r1 = fe.th.de.xxx.this     // Catch:{ all -> 0x008d }
                com.duxiaoman.okhttp3.EventListener r1 = r1.f5567uk     // Catch:{ all -> 0x008d }
                fe.th.de.xxx r2 = fe.th.de.xxx.this     // Catch:{ all -> 0x008d }
                r1.callFailed(r2, r0)     // Catch:{ all -> 0x008d }
                com.duxiaoman.okhttp3.Callback r1 = r5.f5569th     // Catch:{ all -> 0x008d }
                fe.th.de.xxx r2 = fe.th.de.xxx.this     // Catch:{ all -> 0x008d }
                r1.onFailure(r2, r0)     // Catch:{ all -> 0x008d }
                goto L_0x0016
            L_0x008c:
                return
            L_0x008d:
                r0 = move-exception
                fe.th.de.xxx r1 = fe.th.de.xxx.this
                fe.th.de.ggg r1 = r1.f5562ad
                fe.th.de.i r1 = r1.i()
                r1.fe(r5)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.th.de.xxx.ad.fe():void");
        }

        public void rg(ExecutorService executorService) {
            try {
                executorService.execute(this);
            } catch (RejectedExecutionException e) {
                InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                interruptedIOException.initCause(e);
                xxx.this.f5567uk.callFailed(xxx.this, interruptedIOException);
                this.f5569th.onFailure(xxx.this, interruptedIOException);
                xxx.this.f5562ad.i().fe(this);
            } catch (Throwable th2) {
                xxx.this.f5562ad.i().fe(this);
                throw th2;
            }
        }

        public xxx th() {
            return xxx.this;
        }

        public String yj() {
            return xxx.this.f5563i.uk().m338if();
        }
    }

    public class qw extends AsyncTimeout {
        public qw() {
        }

        public void timedOut() {
            xxx.this.cancel();
        }
    }

    public xxx(ggg ggg, ddd ddd, boolean z) {
        this.f5562ad = ggg;
        this.f5563i = ddd;
        this.f5564o = z;
        this.f5566th = new i(ggg, z);
        qw qwVar = new qw();
        this.f5568yj = qwVar;
        qwVar.timeout((long) ggg.de(), TimeUnit.MILLISECONDS);
    }

    public static xxx th(ggg ggg, ddd ddd, boolean z) {
        xxx xxx = new xxx(ggg, ddd, z);
        xxx.f5567uk = ggg.pf().create(xxx);
        return xxx;
    }

    public void cancel() {
        this.f5566th.qw();
    }

    public final void de() {
        this.f5566th.pf(yj.m350switch().vvv("response.body().close()"));
    }

    public mmm execute() throws IOException {
        synchronized (this) {
            if (!this.f5565pf) {
                this.f5565pf = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        de();
        this.f5568yj.enter();
        this.f5567uk.callStart(this);
        try {
            this.f5562ad.i().ad(this);
            mmm rg2 = rg();
            if (rg2 != null) {
                this.f5562ad.i().rg(this);
                return rg2;
            }
            throw new IOException("Canceled");
        } catch (IOException e) {
            IOException uk2 = uk(e);
            this.f5567uk.callFailed(this, uk2);
            throw uk2;
        } catch (Throwable th2) {
            this.f5562ad.i().rg(this);
            throw th2;
        }
    }

    /* renamed from: fe */
    public xxx clone() {
        return th(this.f5562ad, this.f5563i, this.f5564o);
    }

    public String i() {
        StringBuilder sb = new StringBuilder();
        sb.append(isCanceled() ? "canceled " : "");
        sb.append(this.f5564o ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(yj());
        return sb.toString();
    }

    public boolean isCanceled() {
        return this.f5566th.fe();
    }

    public void qw(Callback callback) {
        synchronized (this) {
            if (!this.f5565pf) {
                this.f5565pf = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        de();
        this.f5567uk.callStart(this);
        this.f5562ad.i().qw(new ad(callback));
    }

    public ddd request() {
        return this.f5563i;
    }

    public mmm rg() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f5562ad.ggg());
        arrayList.add(this.f5566th);
        arrayList.add(new fe.th.de.rrr.uk.qw(this.f5562ad.uk()));
        arrayList.add(new fe.th.de.rrr.th.qw(this.f5562ad.vvv()));
        arrayList.add(new fe.th.de.rrr.yj.qw(this.f5562ad));
        if (!this.f5564o) {
            arrayList.addAll(this.f5562ad.ddd());
        }
        arrayList.add(new fe.th.de.rrr.uk.ad(this.f5564o));
        mmm qw2 = new th(arrayList, (fe.th.de.rrr.yj.th) null, (HttpCodec) null, (fe.th.de.rrr.yj.de) null, 0, this.f5563i, this, this.f5567uk, this.f5562ad.rg(), this.f5562ad.b(), this.f5562ad.f()).qw(this.f5563i);
        if (!this.f5566th.fe()) {
            return qw2;
        }
        fe.yj(qw2);
        throw new IOException("Canceled");
    }

    public IOException uk(IOException iOException) {
        if (!this.f5568yj.exit()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException(a.Z);
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public String yj() {
        return this.f5563i.uk().tt();
    }
}
