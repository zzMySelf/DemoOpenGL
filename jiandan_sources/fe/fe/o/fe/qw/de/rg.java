package fe.fe.o.fe.qw.de;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.down.loopj.android.a.a.b;
import com.baidu.down.loopj.android.http.h;
import fe.fe.o.ad.yj;
import fe.fe.o.fe.qw.qw.qw.ad;
import fe.fe.o.rg.ad.qw;
import fe.fe.o.rg.de.i;
import fe.fe.o.th.Cif;
import java.util.HashSet;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.security.cert.CertificateException;

public class rg implements Runnable {
    public boolean aaa;

    /* renamed from: ad  reason: collision with root package name */
    public o f2552ad;
    public int ddd;
    public boolean eee;
    public int ggg;

    /* renamed from: i  reason: collision with root package name */
    public int f2553i;

    /* renamed from: if  reason: not valid java name */
    public long f77if;
    public fe.fe.o.qw.rg mmm;
    public int nn;

    /* renamed from: o  reason: collision with root package name */
    public long f2554o;

    /* renamed from: pf  reason: collision with root package name */
    public final Object f2555pf;
    public Thread ppp;
    public yj qqq;

    /* renamed from: switch  reason: not valid java name */
    public HashSet f78switch;

    /* renamed from: th  reason: collision with root package name */
    public boolean f2556th;

    /* renamed from: uk  reason: collision with root package name */
    public int f2557uk;
    public b vvv;
    public boolean when;
    public boolean xxx;

    /* renamed from: yj  reason: collision with root package name */
    public boolean f2558yj;

    public rg(b bVar, uk ukVar) {
        this(ukVar);
        HashSet hashSet = new HashSet();
        this.f78switch = hashSet;
        hashSet.add(bVar.d());
        this.vvv = bVar;
        pf();
        if (this.mmm.when()) {
            this.xxx = false;
            this.nn = 2;
            ppp();
        }
    }

    public rg(uk ukVar) {
        this.f2558yj = false;
        this.f2557uk = 0;
        this.f2553i = 0;
        this.f2555pf = new Object();
        this.f77if = 0;
        this.when = false;
        this.ppp = null;
        this.ggg = -1;
        this.xxx = true;
        this.ddd = 0;
        this.nn = 1;
        this.aaa = true;
        this.qqq = null;
        this.eee = false;
        this.f2552ad = (o) ukVar;
        if (ukVar instanceof o) {
            this.f2556th = true;
        }
        this.mmm = this.f2552ad.f2532uk.f2603pf;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:81|82|83) */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01bf, code lost:
        throw new org.apache.http.client.RedirectException("Invalid uri: " + r12.vvv.a(true));
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:81:0x01a3 */
    /* renamed from: if  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m165if() {
        /*
            r12 = this;
            java.lang.String r0 = "response"
            java.lang.String r1 = "Range"
            java.lang.String r2 = "If-Match"
            boolean r3 = r12.f2558yj
            if (r3 != 0) goto L_0x01e5
            long r3 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x01d5 }
            com.baidu.down.loopj.android.a.a.b r5 = r12.vvv     // Catch:{ IOException -> 0x01d5 }
            fe.fe.o.fe.qw.de.o r6 = r12.f2552ad     // Catch:{ IOException -> 0x01d5 }
            fe.fe.o.ad.yj r7 = r12.qqq     // Catch:{ IOException -> 0x01d5 }
            boolean r8 = r12.eee     // Catch:{ IOException -> 0x01d5 }
            r5.ad(r6, r7, r8)     // Catch:{ IOException -> 0x01d5 }
            r5 = 0
            r12.eee = r5     // Catch:{ IOException -> 0x01d5 }
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x01d5 }
            long r6 = r6 - r3
            r12.f2554o = r6     // Catch:{ IOException -> 0x01d5 }
            fe.fe.o.ad.yj r3 = r12.qqq     // Catch:{ IOException -> 0x01d5 }
            if (r3 == 0) goto L_0x002b
            fe.fe.o.ad.yj r3 = r12.qqq     // Catch:{ IOException -> 0x01d5 }
            r3.f2471pf = r6     // Catch:{ IOException -> 0x01d5 }
        L_0x002b:
            boolean r3 = r12.when()     // Catch:{ IOException -> 0x01d5 }
            if (r3 != 0) goto L_0x0051
            com.baidu.down.loopj.android.a.a.b r3 = r12.vvv     // Catch:{ IOException -> 0x01d5 }
            int r3 = r3.a()     // Catch:{ IOException -> 0x01d5 }
            r4 = 403(0x193, float:5.65E-43)
            if (r3 != r4) goto L_0x0051
            com.baidu.down.loopj.android.a.a.b r3 = r12.vvv     // Catch:{ IOException -> 0x01d5 }
            boolean r3 = r3.b((java.lang.String) r1)     // Catch:{ IOException -> 0x01d5 }
            if (r3 != 0) goto L_0x0044
            goto L_0x0051
        L_0x0044:
            com.baidu.down.loopj.android.a.a.b r0 = r12.vvv     // Catch:{ IOException -> 0x01d5 }
            r0.c(r1)     // Catch:{ IOException -> 0x01d5 }
            com.baidu.down.loopj.android.http.exp.HandlerRetryException r0 = new com.baidu.down.loopj.android.http.exp.HandlerRetryException     // Catch:{ IOException -> 0x01d5 }
            java.lang.String r1 = "403 with range"
            r0.<init>(r1)     // Catch:{ IOException -> 0x01d5 }
            throw r0     // Catch:{ IOException -> 0x01d5 }
        L_0x0051:
            com.baidu.down.loopj.android.a.a.b r1 = r12.vvv     // Catch:{ IOException -> 0x01d5 }
            int r1 = r1.a()     // Catch:{ IOException -> 0x01d5 }
            r3 = 412(0x19c, float:5.77E-43)
            if (r1 != r3) goto L_0x0071
            com.baidu.down.loopj.android.a.a.b r1 = r12.vvv     // Catch:{ IOException -> 0x01d5 }
            boolean r1 = r1.b((java.lang.String) r2)     // Catch:{ IOException -> 0x01d5 }
            if (r1 != 0) goto L_0x0064
            goto L_0x0071
        L_0x0064:
            com.baidu.down.loopj.android.a.a.b r0 = r12.vvv     // Catch:{ IOException -> 0x01d5 }
            r0.c(r2)     // Catch:{ IOException -> 0x01d5 }
            com.baidu.down.loopj.android.http.exp.HandlerRetryException r0 = new com.baidu.down.loopj.android.http.exp.HandlerRetryException     // Catch:{ IOException -> 0x01d5 }
            java.lang.String r1 = "412 with If-Match"
            r0.<init>(r1)     // Catch:{ IOException -> 0x01d5 }
            throw r0     // Catch:{ IOException -> 0x01d5 }
        L_0x0071:
            com.baidu.down.loopj.android.a.a.b r1 = r12.vvv     // Catch:{ IOException -> 0x01d5 }
            int r1 = r1.a()     // Catch:{ IOException -> 0x01d5 }
            r2 = 404(0x194, float:5.66E-43)
            r3 = 1
            if (r1 != r2) goto L_0x0095
            java.lang.String r1 = android.os.Build.VERSION.SDK     // Catch:{ IOException -> 0x01d5 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ IOException -> 0x01d5 }
            r2 = 21
            if (r1 >= r2) goto L_0x0095
            int r1 = r12.f2557uk     // Catch:{ IOException -> 0x01d5 }
            if (r1 == 0) goto L_0x008b
            goto L_0x0095
        L_0x008b:
            r12.eee = r3     // Catch:{ IOException -> 0x01d5 }
            com.baidu.down.loopj.android.http.exp.HandlerRetryException r0 = new com.baidu.down.loopj.android.http.exp.HandlerRetryException     // Catch:{ IOException -> 0x01d5 }
            java.lang.String r1 = "404 with path"
            r0.<init>(r1)     // Catch:{ IOException -> 0x01d5 }
            throw r0     // Catch:{ IOException -> 0x01d5 }
        L_0x0095:
            fe.fe.o.fe.qw.de.o r1 = r12.f2552ad     // Catch:{ IOException -> 0x01d5 }
            fe.fe.o.rg.ad.qw r1 = r1.f2532uk     // Catch:{ IOException -> 0x01d5 }
            java.util.Map r1 = r1.f2602o     // Catch:{ IOException -> 0x01d5 }
            boolean r1 = r1.containsKey(r0)     // Catch:{ IOException -> 0x01d5 }
            r2 = 2
            r4 = 4
            if (r1 == 0) goto L_0x0109
            fe.fe.o.fe.qw.de.o r1 = r12.f2552ad     // Catch:{ IOException -> 0x01d5 }
            fe.fe.o.rg.ad.qw r1 = r1.f2532uk     // Catch:{ IOException -> 0x01d5 }
            java.util.Map r1 = r1.f2602o     // Catch:{ IOException -> 0x01d5 }
            java.lang.Object r0 = r1.get(r0)     // Catch:{ IOException -> 0x01d5 }
            com.baidu.down.common.intercepter.IIntercepter r0 = (com.baidu.down.common.intercepter.IIntercepter) r0     // Catch:{ IOException -> 0x01d5 }
            boolean r1 = r0 instanceof fe.fe.o.de.uk.qw     // Catch:{ IOException -> 0x01d5 }
            if (r1 == 0) goto L_0x0109
            com.baidu.down.loopj.android.a.a.b r1 = r12.vvv     // Catch:{ IOException -> 0x01d5 }
            fe.fe.o.de.uk.de r11 = r1.b()     // Catch:{ IOException -> 0x01d5 }
            r6 = r0
            fe.fe.o.de.uk.qw r6 = (fe.fe.o.de.uk.qw) r6     // Catch:{ IOException -> 0x01d5 }
            fe.fe.o.fe.qw.de.o r0 = r12.f2552ad     // Catch:{ IOException -> 0x01d5 }
            fe.fe.o.rg.ad.qw r0 = r0.f2532uk     // Catch:{ IOException -> 0x01d5 }
            android.content.Context r7 = r0.f82switch     // Catch:{ IOException -> 0x01d5 }
            fe.fe.o.fe.qw.de.o r0 = r12.f2552ad     // Catch:{ IOException -> 0x01d5 }
            fe.fe.o.rg.ad.qw r0 = r0.f2532uk     // Catch:{ IOException -> 0x01d5 }
            java.lang.String r8 = r0.ad()     // Catch:{ IOException -> 0x01d5 }
            fe.fe.o.fe.qw.de.o r0 = r12.f2552ad     // Catch:{ IOException -> 0x01d5 }
            fe.fe.o.rg.ad.qw r0 = r0.f2532uk     // Catch:{ IOException -> 0x01d5 }
            long r9 = r0.ppp     // Catch:{ IOException -> 0x01d5 }
            fe.fe.o.de.uk.ad r0 = r6.qw(r7, r8, r9, r11)     // Catch:{ IOException -> 0x01d5 }
            if (r0 == 0) goto L_0x00e5
            int r1 = r0.f2502ad     // Catch:{ IOException -> 0x01d5 }
            if (r1 == r2) goto L_0x00db
            goto L_0x00e5
        L_0x00db:
            r12.ggg = r4     // Catch:{ IOException -> 0x01d5 }
            com.baidu.down.loopj.android.http.exp.IntercepterException r1 = new com.baidu.down.loopj.android.http.exp.IntercepterException     // Catch:{ IOException -> 0x01d5 }
            java.lang.String r0 = r0.qw     // Catch:{ IOException -> 0x01d5 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x01d5 }
            throw r1     // Catch:{ IOException -> 0x01d5 }
        L_0x00e5:
            if (r0 == 0) goto L_0x00f3
            int r1 = r0.f2502ad     // Catch:{ IOException -> 0x01d5 }
            if (r1 != r3) goto L_0x00f3
            fe.fe.o.fe.qw.de.o r0 = r12.f2552ad     // Catch:{ IOException -> 0x01d5 }
            fe.fe.o.rg.ad.qw r0 = r0.f2532uk     // Catch:{ IOException -> 0x01d5 }
            r0.i()     // Catch:{ IOException -> 0x01d5 }
            return
        L_0x00f3:
            if (r0 == 0) goto L_0x0109
            int r0 = r0.f2502ad     // Catch:{ IOException -> 0x01d5 }
            if (r0 != r4) goto L_0x0109
            boolean r0 = r12.xxx     // Catch:{ IOException -> 0x01d5 }
            if (r0 != 0) goto L_0x00fe
            goto L_0x0109
        L_0x00fe:
            r0 = 6
            r12.ggg = r0     // Catch:{ IOException -> 0x01d5 }
            com.baidu.down.loopj.android.http.exp.RetryStrategyException r0 = new com.baidu.down.loopj.android.http.exp.RetryStrategyException     // Catch:{ IOException -> 0x01d5 }
            java.lang.String r1 = "302 hijack"
            r0.<init>(r1)     // Catch:{ IOException -> 0x01d5 }
            throw r0     // Catch:{ IOException -> 0x01d5 }
        L_0x0109:
            com.baidu.down.loopj.android.a.a.b r0 = r12.vvv     // Catch:{ IOException -> 0x01d5 }
            int r0 = r0.a()     // Catch:{ IOException -> 0x01d5 }
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 == r1) goto L_0x011d
            com.baidu.down.loopj.android.a.a.b r0 = r12.vvv     // Catch:{ IOException -> 0x01d5 }
            int r0 = r0.a()     // Catch:{ IOException -> 0x01d5 }
            r1 = 206(0xce, float:2.89E-43)
            if (r0 != r1) goto L_0x014f
        L_0x011d:
            r12.f2557uk = r5     // Catch:{ IOException -> 0x01d5 }
            r12.xxx = r5     // Catch:{ IOException -> 0x01d5 }
            int r0 = r12.nn     // Catch:{ IOException -> 0x01d5 }
            if (r0 != r2) goto L_0x014a
            r12.nn = r4     // Catch:{ IOException -> 0x01d5 }
            fe.fe.o.qw.rg r0 = r12.mmm     // Catch:{ IOException -> 0x01d5 }
            r1 = 3
            r0.m170switch(r1)     // Catch:{ IOException -> 0x01d5 }
            com.baidu.down.loopj.android.a.a.b r0 = r12.vvv     // Catch:{ IOException -> 0x01d5 }
            java.lang.String r0 = r0.d()     // Catch:{ IOException -> 0x01d5 }
            java.lang.String r1 = "s"
            com.baidu.down.loopj.android.a.a.b r2 = r12.vvv     // Catch:{ IOException -> 0x01d5 }
            java.lang.String r4 = "host"
            java.lang.String r2 = r2.a((java.lang.String) r4)     // Catch:{ IOException -> 0x01d5 }
            java.lang.String r0 = fe.fe.o.qw.qw.qw(r0, r1, r2)     // Catch:{ IOException -> 0x01d5 }
            fe.fe.o.qw.rg r1 = r12.mmm     // Catch:{ IOException -> 0x01d5 }
            int r2 = r12.hashCode()     // Catch:{ IOException -> 0x01d5 }
            r1.th(r2, r0)     // Catch:{ IOException -> 0x01d5 }
        L_0x014a:
            java.util.HashSet r0 = r12.f78switch     // Catch:{ IOException -> 0x01d5 }
            r0.clear()     // Catch:{ IOException -> 0x01d5 }
        L_0x014f:
            com.baidu.down.loopj.android.a.a.b r0 = r12.vvv     // Catch:{ IOException -> 0x01d5 }
            int r0 = r0.a()     // Catch:{ IOException -> 0x01d5 }
            r1 = 301(0x12d, float:4.22E-43)
            if (r0 == r1) goto L_0x0177
            com.baidu.down.loopj.android.a.a.b r0 = r12.vvv     // Catch:{ IOException -> 0x01d5 }
            int r0 = r0.a()     // Catch:{ IOException -> 0x01d5 }
            r1 = 302(0x12e, float:4.23E-43)
            if (r0 == r1) goto L_0x0177
            com.baidu.down.loopj.android.a.a.b r0 = r12.vvv     // Catch:{ IOException -> 0x01d5 }
            int r0 = r0.a()     // Catch:{ IOException -> 0x01d5 }
            r1 = 303(0x12f, float:4.25E-43)
            if (r0 == r1) goto L_0x0177
            com.baidu.down.loopj.android.a.a.b r0 = r12.vvv     // Catch:{ IOException -> 0x01d5 }
            int r0 = r0.a()     // Catch:{ IOException -> 0x01d5 }
            r1 = 307(0x133, float:4.3E-43)
            if (r0 != r1) goto L_0x017e
        L_0x0177:
            com.baidu.down.loopj.android.a.a.b r0 = r12.vvv     // Catch:{ IOException -> 0x01d5 }
            java.util.HashSet r1 = r12.f78switch     // Catch:{ IOException -> 0x01d5 }
            r0.th(r1)     // Catch:{ IOException -> 0x01d5 }
        L_0x017e:
            fe.fe.o.fe.qw.de.o r0 = r12.f2552ad     // Catch:{ IOException -> 0x01d5 }
            if (r0 == 0) goto L_0x01e5
            com.baidu.down.loopj.android.a.a.b r0 = r12.vvv     // Catch:{ IOException -> 0x01d5 }
            int r0 = r0.a()     // Catch:{ IOException -> 0x01d5 }
            r1 = 503(0x1f7, float:7.05E-43)
            if (r0 != r1) goto L_0x01c0
            boolean r0 = r12.when()     // Catch:{ IOException -> 0x01d5 }
            if (r0 != 0) goto L_0x0193
            goto L_0x01c0
        L_0x0193:
            fe.fe.o.fe.qw.de.o r0 = r12.f2552ad     // Catch:{ IllegalArgumentException -> 0x01a3 }
            fe.fe.o.fe.qw.de.switch r0 = (fe.fe.o.fe.qw.de.Cswitch) r0     // Catch:{ IllegalArgumentException -> 0x01a3 }
            com.baidu.down.loopj.android.a.a.b r1 = r12.vvv     // Catch:{ IllegalArgumentException -> 0x01a3 }
            r0.t(r1, r12)     // Catch:{ IllegalArgumentException -> 0x01a3 }
            com.baidu.down.loopj.android.http.h r0 = new com.baidu.down.loopj.android.http.h     // Catch:{ IllegalArgumentException -> 0x01a3 }
            r1 = 0
            r0.<init>(r1)     // Catch:{ IllegalArgumentException -> 0x01a3 }
            throw r0     // Catch:{ IllegalArgumentException -> 0x01a3 }
        L_0x01a3:
            org.apache.http.client.RedirectException r0 = new org.apache.http.client.RedirectException     // Catch:{ IOException -> 0x01d5 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01d5 }
            r1.<init>()     // Catch:{ IOException -> 0x01d5 }
            java.lang.String r2 = "Invalid uri: "
            r1.append(r2)     // Catch:{ IOException -> 0x01d5 }
            com.baidu.down.loopj.android.a.a.b r2 = r12.vvv     // Catch:{ IOException -> 0x01d5 }
            java.lang.String r2 = r2.a((boolean) r3)     // Catch:{ IOException -> 0x01d5 }
            r1.append(r2)     // Catch:{ IOException -> 0x01d5 }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x01d5 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x01d5 }
            throw r0     // Catch:{ IOException -> 0x01d5 }
        L_0x01c0:
            boolean r0 = r12.f2558yj     // Catch:{ IOException -> 0x01d5 }
            if (r0 != 0) goto L_0x01e5
            fe.fe.o.fe.qw.de.o r0 = r12.f2552ad     // Catch:{ IOException -> 0x01d5 }
            com.baidu.down.loopj.android.a.a.b r1 = r12.vvv     // Catch:{ IOException -> 0x01d5 }
            long r0 = r0.ddd(r1, r12)     // Catch:{ IOException -> 0x01d5 }
            long r2 = r12.f77if     // Catch:{ IOException -> 0x01d5 }
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x01e5
            r12.f77if = r0     // Catch:{ IOException -> 0x01d5 }
            goto L_0x01e5
        L_0x01d5:
            r0 = move-exception
            boolean r1 = r0 instanceof org.apache.http.conn.ConnectionPoolTimeoutException
            if (r1 == 0) goto L_0x01df
            com.baidu.down.loopj.android.a.a.b r1 = r12.vvv
            r1.h()
        L_0x01df:
            boolean r1 = r12.f2558yj
            if (r1 == 0) goto L_0x01e4
            goto L_0x01e5
        L_0x01e4:
            throw r0
        L_0x01e5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.o.fe.qw.de.rg.m165if():void");
    }

    public void ad() {
        yj yjVar = this.qqq;
        if (yjVar != null && TextUtils.isEmpty(yjVar.f2472rg)) {
            yj yjVar2 = this.qqq;
            yjVar2.f2472rg = "c";
            yjVar2.f68if = SystemClock.elapsedRealtime();
        }
        this.vvv.e();
    }

    public void de(long j) {
        yj yjVar = this.qqq;
        if (yjVar.f2473th == -1) {
            yjVar.f2473th = j;
        }
    }

    public yj i() {
        return this.qqq;
    }

    public void pf() {
        if (this.f2552ad.f2532uk.f81if.qw) {
            yj yjVar = new yj();
            this.qqq = yjVar;
            this.f2552ad.f2532uk.f81if.de(yjVar);
            this.qqq.f2470o = SystemClock.elapsedRealtime();
            yj yjVar2 = this.qqq;
            qw qwVar = this.f2552ad.f2532uk;
            yjVar2.qw = qwVar.f81if.qw(qwVar.f82switch);
        }
    }

    public final void ppp() {
        if (this.ddd == 0) {
            this.vvv.j();
        }
        b bVar = this.vvv;
        List fe2 = this.mmm.fe();
        int i2 = this.ddd;
        this.ddd = i2 + 1;
        bVar.qw((fe.fe.o.qw.yj) fe2.get(i2));
        yj yjVar = this.qqq;
        if (yjVar != null) {
            yjVar.f2469i++;
        }
    }

    public final boolean rg(Exception exc) {
        return ((exc instanceof SSLException) || (exc instanceof CertificateException)) && this.aaa && (this.vvv instanceof ad);
    }

    public void run() {
        yj yjVar;
        String str;
        Process.setThreadPriority(10);
        this.ppp = Thread.currentThread();
        int i2 = i.ad((Context) null).qw().ddd().qw;
        if (i2 != 0) {
            try {
                Cif.ad(i2);
            } catch (h unused) {
                if (when()) {
                    ((Cswitch) this.f2552ad).y();
                }
                if (i2 == 0) {
                    return;
                }
            } catch (Exception e) {
                if (this.qqq != null) {
                    this.qqq.f2472rg = "f";
                    this.qqq.f68if = SystemClock.elapsedRealtime();
                }
                if (this.f2552ad != null) {
                    this.f2552ad.ggg();
                    if (this.f2556th) {
                        this.f2552ad.o(e, (byte[]) null, this.ggg);
                    } else {
                        this.f2552ad.uk(e, (String) null);
                    }
                }
                if (i2 == 0) {
                    return;
                }
            } catch (Throwable th2) {
                if (i2 != 0) {
                    Cif.qw();
                }
                throw th2;
            }
        }
        if (this.f2552ad != null) {
            this.f2552ad.ppp();
        }
        m166switch();
        if (this.f2552ad != null) {
            this.f2552ad.ggg();
        }
        if (this.qqq != null) {
            if (this.f2552ad == null || this.f2552ad.qw || !this.f2558yj) {
                yjVar = this.qqq;
                str = "s";
            } else {
                yjVar = this.qqq;
                str = "c";
            }
            yjVar.f2472rg = str;
            this.qqq.f68if = SystemClock.elapsedRealtime();
        }
        if (i2 == 0) {
            return;
        }
        Cif.qw();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:149:0x000f, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x000f, code lost:
        continue;
     */
    /* renamed from: switch  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m166switch() {
        /*
            r18 = this;
            r1 = r18
            java.io.StringWriter r2 = new java.io.StringWriter
            r2.<init>()
            java.io.PrintWriter r3 = new java.io.PrintWriter
            r3.<init>(r2)
            r4 = 0
            r5 = 1
        L_0x000e:
            r6 = 1
        L_0x000f:
            if (r6 == 0) goto L_0x02b9
            r9 = 2
            r10 = 0
            fe.fe.o.fe.qw.de.o r0 = r1.f2552ad     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            fe.fe.o.rg.ad.qw r0 = r0.f2532uk     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            int r11 = r1.f2557uk     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            if (r11 <= 0) goto L_0x0051
            java.util.Map r11 = r0.f2602o     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            if (r11 == 0) goto L_0x0051
            java.util.Map r11 = r0.f2602o     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            java.lang.String r12 = "network"
            boolean r11 = r11.containsKey(r12)     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            if (r11 == 0) goto L_0x0051
            java.util.Map r11 = r0.f2602o     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            java.lang.String r12 = "network"
            java.lang.Object r11 = r11.get(r12)     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            r12 = r11
            com.baidu.down.common.intercepter.IIntercepter r12 = (com.baidu.down.common.intercepter.IIntercepter) r12     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            fe.fe.o.fe.qw.de.o r11 = r1.f2552ad     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            fe.fe.o.rg.ad.qw r11 = r11.f2532uk     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            android.content.Context r13 = r11.f82switch     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            java.lang.String r14 = r0.ad()     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            long r7 = r0.ppp     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            r17 = 0
            r15 = r7
            fe.fe.o.de.uk.ad r7 = r12.qw(r13, r14, r15, r17)     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            if (r7 == 0) goto L_0x0051
            int r7 = r7.f2502ad     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            if (r7 != r5) goto L_0x0051
            r0.i()     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            return
        L_0x0051:
            r18.m165if()     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            boolean r0 = r1.f2558yj     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            if (r0 != 0) goto L_0x0068
            fe.fe.o.fe.qw.de.o r0 = r1.f2552ad     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            if (r0 == 0) goto L_0x0062
            fe.fe.o.fe.qw.de.o r0 = r1.f2552ad     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            boolean r0 = r0.qw     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            if (r0 == 0) goto L_0x0068
        L_0x0062:
            boolean r0 = r1.th(r4)     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            if (r0 != 0) goto L_0x000f
        L_0x0068:
            fe.fe.o.fe.qw.de.o r0 = r1.f2552ad     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            if (r0 == 0) goto L_0x007c
            fe.fe.o.fe.qw.de.o r0 = r1.f2552ad     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            boolean r0 = r0.qw     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            if (r0 != 0) goto L_0x007c
            boolean r0 = r1.f2558yj     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            if (r0 == 0) goto L_0x007c
            fe.fe.o.fe.qw.de.o r0 = r1.f2552ad     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            r0.vvv()     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            goto L_0x009e
        L_0x007c:
            fe.fe.o.fe.qw.de.o r0 = r1.f2552ad     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            boolean r0 = r0 instanceof fe.fe.o.fe.qw.de.o     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            if (r0 == 0) goto L_0x009e
            fe.fe.o.rg.de.i r0 = fe.fe.o.rg.de.i.ad(r10)     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            fe.fe.o.rg.de.qw r0 = r0.qw()     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            fe.fe.o.rg.de.de r0 = r0.vvv()     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            fe.fe.o.rg.de.ad r0 = r0.qw()     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            long r7 = r1.f77if     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            r0.f2612ad = r7     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            r7 = -1
            r0.qw = r7     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            fe.fe.o.fe.qw.de.o r7 = r1.f2552ad     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
            r7.e(r0)     // Catch:{ HandlerRetryException -> 0x000e, IOException -> 0x0170, NullPointerException -> 0x00b7, RedirectException -> 0x00b0, h -> 0x009f }
        L_0x009e:
            return
        L_0x009f:
            com.baidu.down.loopj.android.a.a.b r0 = r1.vvv
            boolean r0 = r0.c()
            if (r0 != 0) goto L_0x00aa
            goto L_0x000f
        L_0x00aa:
            com.baidu.down.loopj.android.http.h r0 = new com.baidu.down.loopj.android.http.h
            r0.<init>(r10)
            throw r0
        L_0x00b0:
            r0 = move-exception
            r0.printStackTrace(r3)
        L_0x00b4:
            r6 = 0
            goto L_0x000f
        L_0x00b7:
            r0 = move-exception
            r1.ggg = r4
            int r7 = r1.nn
            if (r7 != r9) goto L_0x00e1
            fe.fe.o.qw.rg r7 = r1.mmm
            r8 = 4
            r7.m170switch(r8)
            com.baidu.down.loopj.android.a.a.b r7 = r1.vvv
            java.lang.String r7 = r7.d()
            java.lang.String r8 = "f"
            com.baidu.down.loopj.android.a.a.b r9 = r1.vvv
            java.lang.String r11 = "host"
            java.lang.String r9 = r9.a((java.lang.String) r11)
            java.lang.String r7 = fe.fe.o.qw.qw.qw(r7, r8, r9)
            fe.fe.o.qw.rg r8 = r1.mmm
            int r9 = r18.hashCode()
            r8.th(r9, r7)
        L_0x00e1:
            com.baidu.down.loopj.android.a.a.b r7 = r1.vvv
            r7.i()
            r1.th(r5)
            java.io.IOException r7 = new java.io.IOException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "NPE in HttpClient"
            r8.append(r9)
            java.lang.String r0 = r0.getMessage()
            r8.append(r0)
            java.lang.String r0 = r8.toString()
            r7.<init>(r0)
            r7.printStackTrace(r3)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r8 = "-----"
            r0.append(r8)
            long r8 = android.os.SystemClock.elapsedRealtime()
            r0.append(r8)
            java.lang.String r8 = "-----\n"
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            r3.append(r0)
            fe.fe.o.fe.qw.de.o r0 = r1.f2552ad
            boolean r0 = r0.f2560ad
            if (r0 != 0) goto L_0x012f
        L_0x0129:
            java.lang.String r0 = "\n### cannot support range!"
            r3.append(r0)
            goto L_0x00b4
        L_0x012f:
            boolean r0 = r18.when()
            if (r0 == 0) goto L_0x014e
            fe.fe.o.fe.qw.de.o r0 = r1.f2552ad
            fe.fe.o.fe.qw.de.switch r0 = (fe.fe.o.fe.qw.de.Cswitch) r0
            com.baidu.down.loopj.android.a.a.b r7 = r1.vvv
            r0.t(r7, r1)
            com.baidu.down.loopj.android.a.a.b r0 = r1.vvv
            boolean r0 = r0.c()
            if (r0 != 0) goto L_0x0148
            goto L_0x000f
        L_0x0148:
            com.baidu.down.loopj.android.http.h r0 = new com.baidu.down.loopj.android.http.h
            r0.<init>(r10)
            throw r0
        L_0x014e:
            r1.when = r5
            com.baidu.down.loopj.android.a.a.b r0 = r1.vvv
            int r6 = r1.f2557uk
            int r6 = r6 + r5
            r1.f2557uk = r6
            int r8 = r1.f2553i
            int r8 = r8 + r5
            r1.f2553i = r8
            boolean r6 = r0.rg(r7, r6, r8)
            fe.fe.o.ad.yj r0 = r1.qqq
            if (r0 == 0) goto L_0x0169
            int r7 = r0.f2469i
            int r7 = r7 + r5
            r0.f2469i = r7
        L_0x0169:
            r1.when = r4
            r7 = 3
            r1.nn = r7
            goto L_0x000f
        L_0x0170:
            r0 = move-exception
            r1.ggg = r4
            r1.th(r5)
            r0.printStackTrace(r3)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "-----"
            r7.append(r8)
            long r12 = android.os.SystemClock.elapsedRealtime()
            r7.append(r12)
            java.lang.String r8 = "-----\n"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r3.append(r7)
            fe.fe.o.fe.qw.de.o r7 = r1.f2552ad
            boolean r7 = r7.f2560ad
            if (r7 != 0) goto L_0x019d
            goto L_0x0129
        L_0x019d:
            boolean r7 = r18.when()
            if (r7 == 0) goto L_0x01c1
            com.baidu.down.loopj.android.a.a.b r0 = r1.vvv
            r0.i()
            fe.fe.o.fe.qw.de.o r0 = r1.f2552ad
            fe.fe.o.fe.qw.de.switch r0 = (fe.fe.o.fe.qw.de.Cswitch) r0
            com.baidu.down.loopj.android.a.a.b r7 = r1.vvv
            r0.t(r7, r1)
            com.baidu.down.loopj.android.a.a.b r0 = r1.vvv
            boolean r0 = r0.c()
            if (r0 != 0) goto L_0x01bb
            goto L_0x000f
        L_0x01bb:
            com.baidu.down.loopj.android.http.h r0 = new com.baidu.down.loopj.android.http.h
            r0.<init>(r10)
            throw r0
        L_0x01c1:
            boolean r6 = r1.rg(r0)
            if (r6 == 0) goto L_0x01d0
            r1.aaa = r4
            com.baidu.down.loopj.android.a.a.b r0 = r1.vvv
            r0.b((boolean) r5)
            goto L_0x000e
        L_0x01d0:
            fe.fe.o.qw.rg r6 = r1.mmm
            boolean r7 = r1.xxx
            int r8 = r1.ddd
            boolean r6 = r6.pf(r7, r0, r8)
            if (r6 == 0) goto L_0x021c
            boolean r6 = r1.xxx
            if (r6 == 0) goto L_0x01e6
            fe.fe.o.qw.rg r6 = r1.mmm
            r6.yj(r0)
            goto L_0x0203
        L_0x01e6:
            com.baidu.down.loopj.android.a.a.b r6 = r1.vvv
            java.lang.String r6 = r6.d()
            java.lang.String r7 = "f"
            com.baidu.down.loopj.android.a.a.b r8 = r1.vvv
            java.lang.String r10 = "host"
            java.lang.String r8 = r8.a((java.lang.String) r10)
            java.lang.String r6 = fe.fe.o.qw.qw.qw(r6, r7, r8)
            fe.fe.o.qw.rg r7 = r1.mmm
            int r8 = r18.hashCode()
            r7.th(r8, r6)
        L_0x0203:
            r1.xxx = r4
            r1.nn = r9
            fe.fe.o.fe.qw.de.o r6 = r1.f2552ad
            fe.fe.o.rg.ad.qw r6 = r6.f2532uk
            monitor-enter(r6)
            fe.fe.o.qw.rg r7 = r1.mmm     // Catch:{ all -> 0x0219 }
            fe.fe.o.fe.qw.de.th r8 = new fe.fe.o.fe.qw.de.th     // Catch:{ all -> 0x0219 }
            r8.<init>(r1)     // Catch:{ all -> 0x0219 }
            r7.uk(r0, r8)     // Catch:{ all -> 0x0219 }
            monitor-exit(r6)     // Catch:{ all -> 0x0219 }
            goto L_0x000e
        L_0x0219:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0219 }
            throw r0
        L_0x021c:
            int r6 = r1.nn
            if (r6 != r9) goto L_0x0243
            fe.fe.o.qw.rg r6 = r1.mmm
            r7 = 4
            r6.m170switch(r7)
            com.baidu.down.loopj.android.a.a.b r6 = r1.vvv
            java.lang.String r6 = r6.d()
            java.lang.String r7 = "f"
            com.baidu.down.loopj.android.a.a.b r8 = r1.vvv
            java.lang.String r9 = "host"
            java.lang.String r8 = r8.a((java.lang.String) r9)
            java.lang.String r6 = fe.fe.o.qw.qw.qw(r6, r7, r8)
            fe.fe.o.qw.rg r7 = r1.mmm
            int r8 = r18.hashCode()
            r7.th(r8, r6)
        L_0x0243:
            com.baidu.down.loopj.android.a.a.b r6 = r1.vvv
            r6.i()
            r1.when = r5
            com.baidu.down.loopj.android.a.a.b r6 = r1.vvv
            int r7 = r1.f2557uk
            int r7 = r7 + r5
            r1.f2557uk = r7
            int r8 = r1.f2553i
            int r8 = r8 + r5
            r1.f2553i = r8
            boolean r6 = r6.rg(r0, r7, r8)
            fe.fe.o.ad.yj r0 = r1.qqq
            if (r0 == 0) goto L_0x0263
            int r7 = r0.f2469i
            int r7 = r7 + r5
            r0.f2469i = r7
        L_0x0263:
            r1.when = r4
            r7 = 3
            r1.nn = r7
            if (r6 == 0) goto L_0x000f
            fe.fe.o.fe.qw.de.o r0 = r1.f2552ad
            boolean r7 = r0 instanceof fe.fe.o.fe.qw.de.Cswitch
            if (r7 == 0) goto L_0x000f
            fe.fe.o.fe.qw.de.switch r0 = (fe.fe.o.fe.qw.de.Cswitch) r0
            boolean r0 = r0.x()
            if (r0 == 0) goto L_0x000f
            fe.fe.o.fe.qw.de.o r0 = r1.f2552ad
            fe.fe.o.fe.qw.de.switch r0 = (fe.fe.o.fe.qw.de.Cswitch) r0
            boolean r7 = r0.C()
            if (r7 == 0) goto L_0x000f
            boolean r7 = r1.f2558yj
            if (r7 != 0) goto L_0x000f
            fe.fe.o.fe.qw.de.o r7 = r1.f2552ad
            fe.fe.o.fe.qw.de.switch r7 = (fe.fe.o.fe.qw.de.Cswitch) r7
            fe.fe.o.ad.ad r7 = r7.f80switch
            r8 = 3
            r7.f2447pf = r8
            fe.fe.o.fe.qw.de.yj r7 = new fe.fe.o.fe.qw.de.yj
            r7.<init>(r1)
            r0.q(r7)
            java.lang.Object r7 = r1.f2555pf     // Catch:{ InterruptedException -> 0x02b3 }
            monitor-enter(r7)     // Catch:{ InterruptedException -> 0x02b3 }
            java.lang.Object r0 = r1.f2555pf     // Catch:{ all -> 0x02b0 }
            r0.wait()     // Catch:{ all -> 0x02b0 }
            monitor-exit(r7)     // Catch:{ all -> 0x02b0 }
            com.baidu.down.loopj.android.a.a.b r0 = r1.vvv     // Catch:{ InterruptedException -> 0x02b3 }
            boolean r0 = r0.c()     // Catch:{ InterruptedException -> 0x02b3 }
            if (r0 != 0) goto L_0x02aa
            goto L_0x000f
        L_0x02aa:
            com.baidu.down.loopj.android.http.h r0 = new com.baidu.down.loopj.android.http.h     // Catch:{ InterruptedException -> 0x02b3 }
            r0.<init>(r10)     // Catch:{ InterruptedException -> 0x02b3 }
            throw r0     // Catch:{ InterruptedException -> 0x02b3 }
        L_0x02b0:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x02b0 }
            throw r0     // Catch:{ InterruptedException -> 0x02b3 }
        L_0x02b3:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x000f
        L_0x02b9:
            java.net.ConnectException r0 = new java.net.ConnectException
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.o.fe.qw.de.rg.m166switch():void");
    }

    public final boolean th(boolean z) {
        qw qwVar;
        int i2;
        String a;
        String str;
        String str2;
        long j;
        o oVar = this.f2552ad;
        if (!(oVar instanceof o) || (i2 = qwVar.when) == 1004 || i2 == 1006 || (a = this.vvv.a("Range")) == null) {
            return false;
        }
        String[] split = a.trim().split("[=-]");
        String str3 = "";
        if (split != null && split.length > 2) {
            String trim = split[1].trim();
            str = split[2].trim();
            str2 = trim;
        } else if (split == null || split.length <= 1) {
            str2 = str3;
            str = str2;
        } else {
            str2 = split[1].trim();
            str = str3;
        }
        long j2 = 0;
        try {
            j2 = Long.valueOf(str2).longValue();
            Long.valueOf(str).longValue();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (z) {
            j = qwVar.eee.pf(j2);
        } else {
            j = this.f77if;
            if (j <= j2) {
                j = j2;
            }
        }
        long o2 = (qwVar = oVar.f2532uk).eee.o(j2);
        int i3 = (o2 > Long.MAX_VALUE ? 1 : (o2 == Long.MAX_VALUE ? 0 : -1));
        if (i3 == 0) {
            j = qwVar.eee.pf(j2);
        } else {
            str3 = str;
        }
        if (j < o2) {
            if (i3 != 0 && i.ad((Context) null).qw().nn().pf()) {
                long j3 = 307200 + j;
                str3 = String.valueOf(j3 - 1 < o2 ? j3 - 2 : o2 - 1);
            }
            b bVar = this.vvv;
            bVar.a("Range", "bytes=" + j + "-" + str3);
            return true;
        }
        return false;
    }

    public void uk() {
        Thread thread;
        if (this.when && (thread = this.ppp) != null) {
            thread.interrupt();
        }
    }

    public final boolean when() {
        o oVar = this.f2552ad;
        return (oVar instanceof Cswitch) && ((Cswitch) oVar).x() && ((Cswitch) this.f2552ad).m() != 2;
    }
}
