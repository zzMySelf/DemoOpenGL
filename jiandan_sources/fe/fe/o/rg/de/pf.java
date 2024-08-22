package fe.fe.o.rg.de;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import fe.fe.o.de.rg;
import fe.fe.o.rg.ad.qw;
import fe.fe.o.th.ggg;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class pf implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public BlockingQueue f2629ad = new ArrayBlockingQueue(1000);

    /* renamed from: th  reason: collision with root package name */
    public HashMap f2630th = new HashMap();

    /* renamed from: yj  reason: collision with root package name */
    public rg f2631yj = null;

    public final boolean ad(ad adVar, qw qwVar) {
        if (adVar.qw > 0) {
            RandomAccessFile randomAccessFile = (RandomAccessFile) this.f2630th.get(adVar.f2614fe);
            if (randomAccessFile == null) {
                return false;
            }
            randomAccessFile.seek(adVar.f2612ad);
            randomAccessFile.write(adVar.f2613de, 0, adVar.qw);
            qwVar.eee.yj(adVar.f2612ad, (long) adVar.qw);
            if (qwVar.tt && System.currentTimeMillis() - qwVar.k > 1500) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("current_bytes", Long.valueOf(qwVar.eee.i()));
                i.ad((Context) null).qw().xxx().de(contentValues, "_id=?", new String[]{String.valueOf(qwVar.ppp)});
                qwVar.k = System.currentTimeMillis();
            }
            return qwVar.f2601i.f2560ad && qwVar.eee.i() >= qwVar.qqq;
        } else if (qwVar.qqq == Long.MAX_VALUE) {
            qwVar.qqq = adVar.f2612ad;
            return true;
        } else {
            qwVar.eee.de(adVar.f2612ad);
            return !qwVar.f2601i.f2560ad;
        }
    }

    public final RandomAccessFile de(qw qwVar) {
        String str;
        File file = new File(qwVar.ddd);
        if (!file.exists()) {
            file.mkdir();
        }
        if (TextUtils.isEmpty(qwVar.nn)) {
            if (qwVar.xxx) {
                str = qwVar.ddd + File.separator + qwVar.vvv;
            } else {
                str = ggg.ad(qwVar.ddd + File.separator + ggg.i(qwVar.ggg, qwVar.vvv, qwVar.mmm), ggg.de(qwVar.ggg, qwVar.vvv, qwVar.mmm));
            }
            qwVar.nn = str;
            if (qwVar.tt) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("data", qwVar.nn);
                i.ad((Context) null).qw().xxx().de(contentValues, "_id=?", new String[]{String.valueOf(qwVar.ppp)});
            }
        }
        File file2 = new File(qwVar.nn);
        qwVar.rrr = file2;
        qwVar.vvv = file2.getName();
        return new RandomAccessFile(qwVar.nn, "rw");
    }

    public void fe(String str) {
        RandomAccessFile randomAccessFile = (RandomAccessFile) this.f2630th.remove(str);
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
    }

    public final void qw(qw qwVar) {
        if (((RandomAccessFile) this.f2630th.get(qwVar.ad())) == null) {
            this.f2630th.put(qwVar.ad(), de(qwVar));
        }
    }

    public int rg() {
        return this.f2629ad.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0345, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0348, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0349, code lost:
        r2 = r4;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x033c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x033c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x021d A[Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02ff A[Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0345 A[ExcHandler: all (th java.lang.Throwable), PHI: r3 
      PHI: (r3v9 fe.fe.o.rg.de.qw) = (r3v2 fe.fe.o.rg.de.qw), (r3v2 fe.fe.o.rg.de.qw), (r3v11 fe.fe.o.rg.de.qw), (r3v15 fe.fe.o.rg.de.qw), (r3v15 fe.fe.o.rg.de.qw) binds: [B:7:0x0026, B:20:0x0049, B:69:0x0217, B:61:0x0209, B:62:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:7:0x0026] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r17 = this;
            r1 = r17
            fe.fe.o.de.rg r2 = new fe.fe.o.de.rg
            r2.<init>()
            r1.f2631yj = r2
        L_0x0009:
            r2 = 0
            fe.fe.o.rg.de.i r3 = fe.fe.o.rg.de.i.ad(r2)
            if (r3 != 0) goto L_0x0012
            goto L_0x035c
        L_0x0012:
            fe.fe.o.rg.de.i r3 = fe.fe.o.rg.de.i.ad(r2)
            fe.fe.o.rg.de.qw r3 = r3.qw()
            if (r3 != 0) goto L_0x001e
            goto L_0x035c
        L_0x001e:
            java.util.concurrent.BlockingQueue r4 = r1.f2629ad     // Catch:{ InterruptedException -> 0x034f, all -> 0x034b }
            java.lang.Object r4 = r4.take()     // Catch:{ InterruptedException -> 0x034f, all -> 0x034b }
            fe.fe.o.rg.de.ad r4 = (fe.fe.o.rg.de.ad) r4     // Catch:{ InterruptedException -> 0x034f, all -> 0x034b }
            java.lang.String r5 = r4.f2614fe     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            fe.fe.o.rg.ad.qw r5 = r3.qqq(r5)     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            if (r5 == 0) goto L_0x033c
            int r6 = r5.when     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            r7 = 1006(0x3ee, float:1.41E-42)
            if (r6 == r7) goto L_0x033c
            int r6 = r5.when     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            r8 = 1004(0x3ec, float:1.407E-42)
            if (r6 == r8) goto L_0x033c
            int r6 = r5.when     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            r9 = 1008(0x3f0, float:1.413E-42)
            if (r6 == r9) goto L_0x033c
            int r6 = r5.when     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            r10 = 1005(0x3ed, float:1.408E-42)
            if (r6 != r10) goto L_0x0048
            goto L_0x033c
        L_0x0048:
            r6 = 0
            r1.qw(r5)     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            boolean r12 = r5.f2605uk     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r13 = 0
            if (r12 == 0) goto L_0x00b0
            r5.f2605uk = r6     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            fe.fe.o.de.rg r12 = new fe.fe.o.de.rg     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r12.<init>()     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            long r6 = r5.ppp     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r12.f2493de = r6     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r6.<init>()     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            java.lang.String r7 = r5.ggg     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r6.append(r7)     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            long r10 = r5.ppp     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r6.append(r10)     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r12.f2492ad = r6     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            java.lang.String r6 = r5.nn     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r12.f2499th = r6     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            long r10 = r5.qqq     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r12.f2498rg = r10     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r6 = 1001(0x3e9, float:1.403E-42)
            r12.qw = r6     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            java.lang.String r6 = r5.aaa     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r12.f2496o = r6     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            fe.fe.o.fe.qw.de.o r6 = r5.f2601i     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            boolean r6 = r6.f2560ad     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r12.f73switch = r6     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            fe.fe.o.rg.ad.ad r6 = r5.eee     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            long r10 = r6.i()     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            int r6 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r6 <= 0) goto L_0x0096
            java.lang.String r6 = r5.z     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r12.f2497pf = r6     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
        L_0x0096:
            fe.fe.o.de.qw r6 = new fe.fe.o.de.qw     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r6.<init>()     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            fe.fe.o.fe.qw.de.o r10 = r5.f2601i     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            java.util.List r10 = r10.n()     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r6.f2491yj = r10     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r12.ppp = r6     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            fe.fe.o.rg.de.i r6 = fe.fe.o.rg.de.i.ad(r2)     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            fe.fe.o.rg.de.qw r6 = r6.qw()     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r6.a(r12)     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
        L_0x00b0:
            boolean r6 = r1.ad(r4, r5)     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r10 = 1000(0x3e8, double:4.94E-321)
            if (r6 == 0) goto L_0x015e
            fe.fe.o.rg.de.i r6 = fe.fe.o.rg.de.i.ad(r2)     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            fe.fe.o.rg.de.qw r6 = r6.qw()     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            fe.fe.o.rg.de.if r6 = r6.eee()     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            java.lang.String r12 = r4.f2614fe     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r6.qw(r12)     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            fe.fe.o.de.rg r6 = new fe.fe.o.de.rg     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r6.<init>()     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r5.when = r9     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            long r12 = r5.ppp     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r6.f2493de = r12     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r12.<init>()     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            java.lang.String r13 = r5.ggg     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r12.append(r13)     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            long r13 = r5.ppp     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r12.append(r13)     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r6.f2492ad = r12     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r6.qw = r9     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            long r12 = r5.qqq     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r6.f2498rg = r12     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            fe.fe.o.rg.ad.ad r9 = r5.eee     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r6.f72if = r9     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            long r12 = r6.f2498rg     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            long r12 = r12 * r10
            long r9 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            long r7 = r5.f     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            long r9 = r9 - r7
            long r12 = r12 / r9
            r6.f2495i = r12     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            fe.fe.o.de.qw r7 = new fe.fe.o.de.qw     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r7.<init>()     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            fe.fe.o.fe.qw.de.o r8 = r5.f2601i     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            java.util.List r8 = r8.n()     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r7.f2491yj = r8     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            fe.fe.o.qw.rg r8 = r5.f2603pf     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            java.util.concurrent.ConcurrentHashMap r9 = r8.ggg()     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            fe.fe.o.qw.rg r8 = r5.f2603pf     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            int r10 = r8.xxx()     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            fe.fe.o.qw.rg r8 = r5.f2603pf     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            long r11 = r8.vvv()     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            fe.fe.o.qw.rg r8 = r5.f2603pf     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            java.lang.String r13 = r8.mmm()     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            fe.fe.o.qw.rg r8 = r5.f2603pf     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            java.lang.String r14 = r8.ddd()     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            java.lang.String r8 = fe.fe.o.qw.qw.ad(r9, r10, r11, r13, r14)     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r7.f2488fe = r8     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            fe.fe.o.qw.rg r8 = r5.f2603pf     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            int r8 = r8.nn()     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r7.f2486ad = r8     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            fe.fe.o.qw.rg r8 = r5.f2603pf     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            java.lang.String r8 = r8.mmm()     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r7.f2487de = r8     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r6.ppp = r7     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r3.a(r6)     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            java.lang.String r6 = r5.ggg     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            long r7 = r5.ppp     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r3.tt(r6, r7)     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            fe.fe.o.fe.qw.de.qw r6 = r3.nn()     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            android.content.Context r7 = r5.C     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r8 = 1
            r6.th(r7, r8, r2)     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            goto L_0x033c
        L_0x015e:
            int r6 = r5.when     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r7 = 1004(0x3ec, float:1.407E-42)
            if (r6 == r7) goto L_0x033c
            int r6 = r5.when     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r7 = 1006(0x3ee, float:1.41E-42)
            if (r6 != r7) goto L_0x016c
            goto L_0x033c
        L_0x016c:
            fe.fe.o.de.rg r6 = r1.f2631yj     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            long r7 = r5.ppp     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r6.f2493de = r7     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            fe.fe.o.de.rg r6 = r1.f2631yj     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r7.<init>()     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            java.lang.String r8 = r5.ggg     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r7.append(r8)     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            long r8 = r5.ppp     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r7.append(r8)     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r6.f2492ad = r7     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            fe.fe.o.de.rg r6 = r1.f2631yj     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            java.lang.String r7 = r5.nn     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r6.f2499th = r7     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            fe.fe.o.de.rg r6 = r1.f2631yj     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            long r7 = r5.qqq     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r6.f2498rg = r7     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            fe.fe.o.de.rg r6 = r1.f2631yj     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            fe.fe.o.rg.ad.ad r7 = r5.eee     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            long r7 = r7.i()     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r6.f2494fe = r7     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            fe.fe.o.de.rg r6 = r1.f2631yj     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            fe.fe.o.rg.ad.ad r7 = r5.eee     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            r6.f72if = r7     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            long r8 = r5.g     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            long r8 = r6 - r8
            r15 = 500(0x1f4, double:2.47E-321)
            int r12 = (r8 > r15 ? 1 : (r8 == r15 ? 0 : -1))
            if (r12 >= 0) goto L_0x01c8
            r15 = r3
            long r2 = r5.h     // Catch:{ Exception -> 0x01c4, all -> 0x01bf }
            int r16 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r16 > 0) goto L_0x01cd
            goto L_0x01c9
        L_0x01bf:
            r0 = move-exception
            r2 = r4
            r3 = r15
            goto L_0x034d
        L_0x01c4:
            r0 = move-exception
            r2 = r0
            r3 = r15
            goto L_0x0217
        L_0x01c8:
            r15 = r3
        L_0x01c9:
            int r2 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r2 > 0) goto L_0x01d4
        L_0x01cd:
            fe.fe.o.de.rg r2 = r1.f2631yj     // Catch:{ Exception -> 0x01c4, all -> 0x01bf }
            long r6 = r5.h     // Catch:{ Exception -> 0x01c4, all -> 0x01bf }
            r2.f2495i = r6     // Catch:{ Exception -> 0x01c4, all -> 0x01bf }
            goto L_0x0200
        L_0x01d4:
            fe.fe.o.de.rg r2 = r1.f2631yj     // Catch:{ Exception -> 0x0212, all -> 0x020e }
            fe.fe.o.de.rg r3 = r1.f2631yj     // Catch:{ Exception -> 0x0212, all -> 0x020e }
            long r12 = r3.f2494fe     // Catch:{ Exception -> 0x0212, all -> 0x020e }
            long r10 = r5.j     // Catch:{ Exception -> 0x0212, all -> 0x020e }
            long r12 = r12 - r10
            r10 = 1000(0x3e8, double:4.94E-321)
            long r12 = r12 * r10
            long r12 = r12 / r8
            r2.f2495i = r12     // Catch:{ Exception -> 0x0212, all -> 0x020e }
            fe.fe.o.de.rg r2 = r1.f2631yj     // Catch:{ Exception -> 0x0212, all -> 0x020e }
            long r2 = r2.f2495i     // Catch:{ Exception -> 0x0212, all -> 0x020e }
            r8 = 0
            int r10 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r10 >= 0) goto L_0x01f2
            fe.fe.o.de.rg r2 = r1.f2631yj     // Catch:{ Exception -> 0x01c4, all -> 0x01bf }
            r2.f2495i = r8     // Catch:{ Exception -> 0x01c4, all -> 0x01bf }
        L_0x01f2:
            fe.fe.o.de.rg r2 = r1.f2631yj     // Catch:{ Exception -> 0x0212, all -> 0x020e }
            long r2 = r2.f2494fe     // Catch:{ Exception -> 0x0212, all -> 0x020e }
            r5.j = r2     // Catch:{ Exception -> 0x0212, all -> 0x020e }
            r5.g = r6     // Catch:{ Exception -> 0x0212, all -> 0x020e }
            fe.fe.o.de.rg r2 = r1.f2631yj     // Catch:{ Exception -> 0x0212, all -> 0x020e }
            long r2 = r2.f2495i     // Catch:{ Exception -> 0x0212, all -> 0x020e }
            r5.h = r2     // Catch:{ Exception -> 0x0212, all -> 0x020e }
        L_0x0200:
            fe.fe.o.de.rg r2 = r1.f2631yj     // Catch:{ Exception -> 0x0212, all -> 0x020e }
            r3 = 1002(0x3ea, float:1.404E-42)
            r2.qw = r3     // Catch:{ Exception -> 0x0212, all -> 0x020e }
            fe.fe.o.de.rg r2 = r1.f2631yj     // Catch:{ Exception -> 0x0212, all -> 0x020e }
            r3 = r15
            r3.a(r2)     // Catch:{ Exception -> 0x0215, all -> 0x0345 }
            goto L_0x033c
        L_0x020e:
            r0 = move-exception
            r3 = r15
            goto L_0x0346
        L_0x0212:
            r0 = move-exception
            r3 = r15
            goto L_0x0216
        L_0x0215:
            r0 = move-exception
        L_0x0216:
            r2 = r0
        L_0x0217:
            int r6 = r5.when     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            r7 = 1004(0x3ec, float:1.407E-42)
            if (r6 == r7) goto L_0x033c
            int r6 = r5.when     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            r7 = 1006(0x3ee, float:1.41E-42)
            if (r6 != r7) goto L_0x0225
            goto L_0x033c
        L_0x0225:
            r6 = 1005(0x3ed, float:1.408E-42)
            r5.when = r6     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            fe.fe.o.de.rg r6 = new fe.fe.o.de.rg     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            r6.<init>()     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            long r8 = r5.ppp     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            r6.f2493de = r8     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            r8.<init>()     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            java.lang.String r9 = r5.ggg     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            r8.append(r9)     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            long r9 = r5.ppp     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            r8.append(r9)     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            java.lang.String r8 = r8.toString()     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            r6.f2492ad = r8     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            java.lang.String r8 = r5.nn     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            r6.f2499th = r8     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            long r8 = r5.qqq     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            r6.f2498rg = r8     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            fe.fe.o.rg.ad.ad r8 = r5.eee     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            long r8 = r8.i()     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            r6.f2494fe = r8     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            java.lang.String r8 = r2.toString()     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            r6.f2501yj = r8     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            r7 = 1005(0x3ed, float:1.408E-42)
            r6.qw = r7     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            fe.fe.o.de.qw r7 = new fe.fe.o.de.qw     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            r7.<init>()     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            fe.fe.o.fe.qw.de.o r8 = r5.f2601i     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            java.util.List r8 = r8.n()     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            r7.f2491yj = r8     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            fe.fe.o.qw.rg r8 = r5.f2603pf     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            java.util.concurrent.ConcurrentHashMap r9 = r8.ggg()     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            fe.fe.o.qw.rg r8 = r5.f2603pf     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            int r10 = r8.xxx()     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            fe.fe.o.qw.rg r8 = r5.f2603pf     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            long r11 = r8.vvv()     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            fe.fe.o.qw.rg r8 = r5.f2603pf     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            java.lang.String r13 = r8.mmm()     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            fe.fe.o.qw.rg r8 = r5.f2603pf     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            java.lang.String r14 = r8.ddd()     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            java.lang.String r8 = fe.fe.o.qw.qw.ad(r9, r10, r11, r13, r14)     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            r7.f2488fe = r8     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            fe.fe.o.qw.rg r8 = r5.f2603pf     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            int r8 = r8.nn()     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            r7.f2486ad = r8     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            fe.fe.o.qw.rg r8 = r5.f2603pf     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            java.lang.String r8 = r8.mmm()     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            r7.f2487de = r8     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            r6.ppp = r7     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            r5.rg(r6)     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            boolean r7 = r2 instanceof java.io.IOException     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            if (r7 != 0) goto L_0x02b2
            boolean r7 = r2 instanceof java.io.FileNotFoundException     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            if (r7 == 0) goto L_0x02b0
            goto L_0x02b2
        L_0x02b0:
            r2 = 0
            goto L_0x02cc
        L_0x02b2:
            java.lang.String r7 = r2.getMessage()     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            if (r7 == 0) goto L_0x02c8
            java.lang.String r2 = r2.getMessage()     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            java.lang.String r7 = "No space left on device"
            boolean r2 = r2.contains(r7)     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            if (r2 == 0) goto L_0x02c8
            r2 = 2
            r6.when = r2     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            goto L_0x02b0
        L_0x02c8:
            r2 = 3
            r6.when = r2     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            goto L_0x02b0
        L_0x02cc:
            fe.fe.o.rg.de.i r7 = fe.fe.o.rg.de.i.ad(r2)     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            fe.fe.o.rg.de.qw r2 = r7.qw()     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            fe.fe.o.fe.qw.de.qw r2 = r2.nn()     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            android.content.Context r7 = r5.C     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            fe.fe.o.fe.qw.de.o r8 = r5.f2601i     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            r9 = 1
            r2.th(r7, r9, r8)     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            r2 = 0
            fe.fe.o.rg.de.i r7 = fe.fe.o.rg.de.i.ad(r2)     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            fe.fe.o.rg.de.qw r7 = r7.qw()     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            r7.a(r6)     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            fe.fe.o.rg.de.i r6 = fe.fe.o.rg.de.i.ad(r2)     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            fe.fe.o.rg.de.qw r2 = r6.qw()     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            java.lang.String r6 = r5.ggg     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            long r7 = r5.ppp     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            r2.tt(r6, r7)     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            boolean r2 = r5.tt     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            if (r2 == 0) goto L_0x033c
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            r2.<init>()     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            java.lang.String r6 = "status"
            int r7 = r5.when     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            r2.put(r6, r7)     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            java.lang.String r6 = "current_bytes"
            fe.fe.o.rg.ad.ad r7 = r5.eee     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            long r7 = r7.i()     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            r2.put(r6, r7)     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            r6 = 0
            fe.fe.o.rg.de.i r6 = fe.fe.o.rg.de.i.ad(r6)     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            fe.fe.o.rg.de.qw r6 = r6.qw()     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            fe.fe.o.rg.de.fe r6 = r6.xxx()     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            java.lang.String r7 = "_id=?"
            r8 = 1
            java.lang.String[] r8 = new java.lang.String[r8]     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            long r9 = r5.ppp     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            java.lang.String r5 = java.lang.String.valueOf(r9)     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            r9 = 0
            r8[r9] = r5     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
            r6.de(r2, r7, r8)     // Catch:{ InterruptedException -> 0x0348, all -> 0x0345 }
        L_0x033c:
            fe.fe.o.rg.de.de r2 = r3.vvv()
            r2.de(r4)
            goto L_0x0009
        L_0x0345:
            r0 = move-exception
        L_0x0346:
            r2 = r4
            goto L_0x034d
        L_0x0348:
            r0 = move-exception
            r2 = r4
            goto L_0x0351
        L_0x034b:
            r0 = move-exception
            r6 = r2
        L_0x034d:
            r4 = r0
            goto L_0x035f
        L_0x034f:
            r0 = move-exception
            r6 = r2
        L_0x0351:
            r4 = r0
            r4.printStackTrace()     // Catch:{ all -> 0x035d }
            fe.fe.o.rg.de.de r3 = r3.vvv()
            r3.de(r2)
        L_0x035c:
            return
        L_0x035d:
            r0 = move-exception
            goto L_0x034d
        L_0x035f:
            fe.fe.o.rg.de.de r3 = r3.vvv()
            r3.de(r2)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.o.rg.de.pf.run():void");
    }

    public void th(ad adVar) {
        try {
            this.f2629ad.put(adVar);
        } catch (InterruptedException unused) {
        }
    }
}
