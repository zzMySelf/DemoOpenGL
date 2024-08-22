package fe.fe.o.rg.ad;

import android.content.ContentValues;
import android.content.Context;
import com.baidu.down.loopj.android.http.n;
import fe.fe.o.de.rg;
import fe.fe.o.fe.qw.de.Cswitch;
import fe.fe.o.fe.qw.de.o;
import fe.fe.o.rg.de.ad;
import fe.fe.o.rg.de.i;
import fe.fe.o.rg.de.qw;

public class fe extends o {

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ de f2597o;

    public fe(de deVar) {
        this.f2597o = deVar;
    }

    public void a(byte[] bArr, long j) {
        de deVar = this.f2597o;
        if (!deVar.e || deVar.f2606yj <= 1) {
            de deVar2 = this.f2597o;
            if (deVar2.f2606yj != 1 || j <= 0) {
                this.f2597o.when = 1003;
                rg rgVar = new rg();
                de deVar3 = this.f2597o;
                rgVar.f2493de = deVar3.ppp;
                rgVar.f2492ad = deVar3.ad();
                de deVar4 = this.f2597o;
                rgVar.f2499th = deVar4.nn;
                long j2 = deVar4.qqq;
                rgVar.f2498rg = j2;
                rgVar.f2494fe = j2;
                rg rgVar2 = deVar4.l;
                if (rgVar2 != null) {
                    rgVar.f2495i = (rgVar2.f2494fe * 1000) / (System.currentTimeMillis() - this.f2597o.f);
                }
                rgVar.qw = 1003;
                i.ad((Context) null).qw().a(rgVar);
                qw qw = i.ad((Context) null).qw();
                de deVar5 = this.f2597o;
                qw.tt(deVar5.ggg, deVar5.ppp);
                return;
            }
            deVar2.f2606yj = 0;
            for (o oVar : deVar2.eee.th()) {
                long j3 = oVar.f2599de;
                long j4 = oVar.f2598ad;
                if (j3 != j4 && (oVar.qw >= j || j4 < j)) {
                    this.f2597o.m171if(oVar.f2599de, oVar.f2598ad, 0);
                    return;
                }
            }
        }
    }

    public void ad() {
    }

    public void nn(int i2) {
        int i3 = this.f2597o.when;
        if (i3 != 1003 && i3 != 1008) {
            if (i3 == 1006) {
                i.ad((Context) null).qw().eee().qw(this.f2597o.ad());
            }
            if (this.f2597o.tt) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("status", Integer.valueOf(this.f2597o.when));
                contentValues.put("current_bytes", Long.valueOf(this.f2597o.eee.i()));
                i.ad((Context) null).qw().xxx().de(contentValues, "_id=?", new String[]{String.valueOf(this.f2597o.ppp)});
            }
        }
    }

    public void qqq(long j, String str) {
        long j2;
        int i2;
        de deVar;
        de deVar2 = this.f2597o;
        if (!deVar2.m) {
            deVar2.m = true;
            deVar2.f2605uk = true;
            deVar2.qqq = j;
            deVar2.aaa = str;
            deVar2.when = 1001;
            if (!this.f2560ad) {
                deVar2.eee = new ad();
            }
            if (this.f2597o.eee.qw() <= 0) {
                de deVar3 = this.f2597o;
                if (deVar3.e && this.f2560ad) {
                    if (deVar3.qqq > qw.E && !this.f2561de) {
                        de deVar4 = this.f2597o;
                        if (deVar4.qqq < fe.fe.o.th.fe.ad(deVar3.f82switch, "pref_config_test_speed_threshold", 10240) * 1024) {
                            o oVar = deVar4.f2601i;
                            if (oVar instanceof Cswitch) {
                                ((Cswitch) oVar).s(false);
                                ((Cswitch) this.f2597o.f2601i).f80switch.f2447pf = 1;
                            }
                        }
                        o oVar2 = this.f2597o.f2601i;
                        if ((oVar2 instanceof Cswitch) && ((Cswitch) oVar2).x() && ((Cswitch) this.f2597o.f2601i).A()) {
                            this.f2597o.f2601i.f(1);
                        }
                        this.f2597o.eee.fe(0, qw.E);
                        de deVar5 = this.f2597o;
                        long j3 = deVar5.qqq;
                        long j4 = qw.E;
                        long j5 = (j3 - j4) / ((long) deVar5.f2600ad);
                        if (j5 >= j4) {
                            j4 = j5;
                        }
                        int i3 = qw.D;
                        long j6 = (((j4 + ((long) i3)) - 1) / ((long) i3)) * ((long) i3);
                        n nVar = i.ad((Context) null).qw().nn().m163if();
                        long j7 = qw.E;
                        while (true) {
                            long j8 = this.f2597o.qqq;
                            if (j7 >= j8) {
                                break;
                            }
                            long j9 = j7 + j6;
                            if (j9 <= j8) {
                                j8 = j9;
                            }
                            this.f2597o.eee.fe(j7, j8);
                            if (nVar != n.TYPE_2G) {
                                o oVar3 = this.f2597o.f2601i;
                                if (!(oVar3 instanceof Cswitch) || !((Cswitch) oVar3).x()) {
                                    j2 = j8;
                                    deVar = this.f2597o;
                                    i2 = 0;
                                } else if (((Cswitch) this.f2597o.f2601i).A()) {
                                    i2 = 1;
                                    j2 = j8;
                                    deVar = this.f2597o;
                                } else {
                                    j2 = j8;
                                    deVar = this.f2597o;
                                    i2 = 2;
                                }
                                deVar.m171if(j7, j2, i2);
                            } else {
                                j2 = j8;
                            }
                            j7 = j2;
                        }
                    } else {
                        de deVar6 = this.f2597o;
                        deVar6.eee.fe(0, deVar6.qqq);
                        o oVar4 = this.f2597o.f2601i;
                        if ((oVar4 instanceof Cswitch) && ((Cswitch) oVar4).x()) {
                            ((Cswitch) this.f2597o.f2601i).w(5);
                        }
                    }
                } else {
                    de deVar7 = this.f2597o;
                    deVar7.eee.fe(0, deVar7.qqq);
                }
                if (this.f2597o.tt) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("status", Integer.valueOf(this.f2597o.when));
                    if (this.f2597o.qqq <= 0) {
                        contentValues.put("total_bytes", Long.valueOf(j));
                    }
                    i.ad((Context) null).qw().xxx().de(contentValues, "_id=?", new String[]{String.valueOf(this.f2597o.ppp)});
                }
            }
        }
    }

    public void tt(ad adVar) {
        de deVar = this.f2597o;
        int i2 = deVar.when;
        if (i2 == 1006 || i2 == 1004 || i2 == 1009) {
            i.ad((Context) null).qw().vvv().de(adVar);
            return;
        }
        adVar.f2614fe = deVar.ad();
        i.ad((Context) null).qw().eee().ad(adVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0135, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0137, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void yj(java.lang.Throwable r8, int r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            fe.fe.o.rg.ad.de r0 = r7.f2597o     // Catch:{ all -> 0x0138 }
            int r0 = r0.when     // Catch:{ all -> 0x0138 }
            r1 = 1006(0x3ee, float:1.41E-42)
            if (r0 == r1) goto L_0x0136
            fe.fe.o.rg.ad.de r0 = r7.f2597o     // Catch:{ all -> 0x0138 }
            int r0 = r0.when     // Catch:{ all -> 0x0138 }
            r1 = 1004(0x3ec, float:1.407E-42)
            if (r0 == r1) goto L_0x0136
            fe.fe.o.rg.ad.de r0 = r7.f2597o     // Catch:{ all -> 0x0138 }
            int r0 = r0.when     // Catch:{ all -> 0x0138 }
            r1 = 1005(0x3ed, float:1.408E-42)
            if (r0 != r1) goto L_0x001b
            goto L_0x0136
        L_0x001b:
            fe.fe.o.rg.ad.de r0 = r7.f2597o     // Catch:{ all -> 0x0138 }
            r0.when = r1     // Catch:{ all -> 0x0138 }
            fe.fe.o.de.rg r0 = new fe.fe.o.de.rg     // Catch:{ all -> 0x0138 }
            r0.<init>()     // Catch:{ all -> 0x0138 }
            fe.fe.o.rg.ad.de r2 = r7.f2597o     // Catch:{ all -> 0x0138 }
            long r2 = r2.ppp     // Catch:{ all -> 0x0138 }
            r0.f2493de = r2     // Catch:{ all -> 0x0138 }
            fe.fe.o.rg.ad.de r2 = r7.f2597o     // Catch:{ all -> 0x0138 }
            java.lang.String r2 = r2.ad()     // Catch:{ all -> 0x0138 }
            r0.f2492ad = r2     // Catch:{ all -> 0x0138 }
            fe.fe.o.rg.ad.de r2 = r7.f2597o     // Catch:{ all -> 0x0138 }
            java.lang.String r2 = r2.nn     // Catch:{ all -> 0x0138 }
            r0.f2499th = r2     // Catch:{ all -> 0x0138 }
            long r2 = r7.k()     // Catch:{ all -> 0x0138 }
            r0.f2498rg = r2     // Catch:{ all -> 0x0138 }
            fe.fe.o.rg.ad.de r2 = r7.f2597o     // Catch:{ all -> 0x0138 }
            fe.fe.o.rg.ad.ad r2 = r2.eee     // Catch:{ all -> 0x0138 }
            long r2 = r2.i()     // Catch:{ all -> 0x0138 }
            r0.f2494fe = r2     // Catch:{ all -> 0x0138 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0138 }
            r0.f2501yj = r8     // Catch:{ all -> 0x0138 }
            r0.qw = r1     // Catch:{ all -> 0x0138 }
            r0.when = r9     // Catch:{ all -> 0x0138 }
            fe.fe.o.de.qw r8 = new fe.fe.o.de.qw     // Catch:{ all -> 0x0138 }
            r8.<init>()     // Catch:{ all -> 0x0138 }
            fe.fe.o.rg.ad.de r9 = r7.f2597o     // Catch:{ all -> 0x0138 }
            fe.fe.o.fe.qw.de.o r9 = r9.f2601i     // Catch:{ all -> 0x0138 }
            java.util.List r9 = r9.n()     // Catch:{ all -> 0x0138 }
            r8.f2491yj = r9     // Catch:{ all -> 0x0138 }
            fe.fe.o.rg.ad.de r9 = r7.f2597o     // Catch:{ all -> 0x0138 }
            fe.fe.o.qw.rg r9 = r9.f2603pf     // Catch:{ all -> 0x0138 }
            java.util.concurrent.ConcurrentHashMap r1 = r9.ggg()     // Catch:{ all -> 0x0138 }
            fe.fe.o.rg.ad.de r9 = r7.f2597o     // Catch:{ all -> 0x0138 }
            fe.fe.o.qw.rg r9 = r9.f2603pf     // Catch:{ all -> 0x0138 }
            int r2 = r9.xxx()     // Catch:{ all -> 0x0138 }
            fe.fe.o.rg.ad.de r9 = r7.f2597o     // Catch:{ all -> 0x0138 }
            fe.fe.o.qw.rg r9 = r9.f2603pf     // Catch:{ all -> 0x0138 }
            long r3 = r9.vvv()     // Catch:{ all -> 0x0138 }
            fe.fe.o.rg.ad.de r9 = r7.f2597o     // Catch:{ all -> 0x0138 }
            fe.fe.o.qw.rg r9 = r9.f2603pf     // Catch:{ all -> 0x0138 }
            java.lang.String r5 = r9.mmm()     // Catch:{ all -> 0x0138 }
            fe.fe.o.rg.ad.de r9 = r7.f2597o     // Catch:{ all -> 0x0138 }
            fe.fe.o.qw.rg r9 = r9.f2603pf     // Catch:{ all -> 0x0138 }
            java.lang.String r6 = r9.ddd()     // Catch:{ all -> 0x0138 }
            java.lang.String r9 = fe.fe.o.qw.qw.ad(r1, r2, r3, r5, r6)     // Catch:{ all -> 0x0138 }
            r8.f2488fe = r9     // Catch:{ all -> 0x0138 }
            fe.fe.o.rg.ad.de r9 = r7.f2597o     // Catch:{ all -> 0x0138 }
            fe.fe.o.qw.rg r9 = r9.f2603pf     // Catch:{ all -> 0x0138 }
            int r9 = r9.nn()     // Catch:{ all -> 0x0138 }
            r8.f2486ad = r9     // Catch:{ all -> 0x0138 }
            fe.fe.o.rg.ad.de r9 = r7.f2597o     // Catch:{ all -> 0x0138 }
            fe.fe.o.qw.rg r9 = r9.f2603pf     // Catch:{ all -> 0x0138 }
            java.lang.String r9 = r9.mmm()     // Catch:{ all -> 0x0138 }
            r8.f2487de = r9     // Catch:{ all -> 0x0138 }
            r0.ppp = r8     // Catch:{ all -> 0x0138 }
            r8 = 0
            fe.fe.o.rg.de.i r9 = fe.fe.o.rg.de.i.ad(r8)     // Catch:{ all -> 0x0138 }
            fe.fe.o.rg.de.qw r9 = r9.qw()     // Catch:{ all -> 0x0138 }
            fe.fe.o.fe.qw.de.qw r9 = r9.nn()     // Catch:{ all -> 0x0138 }
            fe.fe.o.rg.ad.de r1 = r7.f2597o     // Catch:{ all -> 0x0138 }
            android.content.Context r1 = r1.C     // Catch:{ all -> 0x0138 }
            fe.fe.o.rg.ad.de r2 = r7.f2597o     // Catch:{ all -> 0x0138 }
            fe.fe.o.fe.qw.de.o r2 = r2.f2601i     // Catch:{ all -> 0x0138 }
            r3 = 1
            r9.th(r1, r3, r2)     // Catch:{ all -> 0x0138 }
            fe.fe.o.rg.de.i r9 = fe.fe.o.rg.de.i.ad(r8)     // Catch:{ all -> 0x0138 }
            fe.fe.o.rg.de.qw r9 = r9.qw()     // Catch:{ all -> 0x0138 }
            fe.fe.o.rg.de.if r9 = r9.eee()     // Catch:{ all -> 0x0138 }
            java.lang.String r1 = r0.f2492ad     // Catch:{ all -> 0x0138 }
            r9.qw(r1)     // Catch:{ all -> 0x0138 }
            fe.fe.o.rg.de.i r9 = fe.fe.o.rg.de.i.ad(r8)     // Catch:{ all -> 0x0138 }
            fe.fe.o.rg.de.qw r9 = r9.qw()     // Catch:{ all -> 0x0138 }
            r9.a(r0)     // Catch:{ all -> 0x0138 }
            fe.fe.o.rg.de.i r9 = fe.fe.o.rg.de.i.ad(r8)     // Catch:{ all -> 0x0138 }
            fe.fe.o.rg.de.qw r9 = r9.qw()     // Catch:{ all -> 0x0138 }
            fe.fe.o.rg.ad.de r0 = r7.f2597o     // Catch:{ all -> 0x0138 }
            java.lang.String r0 = r0.ggg     // Catch:{ all -> 0x0138 }
            fe.fe.o.rg.ad.de r1 = r7.f2597o     // Catch:{ all -> 0x0138 }
            long r1 = r1.ppp     // Catch:{ all -> 0x0138 }
            r9.tt(r0, r1)     // Catch:{ all -> 0x0138 }
            fe.fe.o.rg.ad.de r9 = r7.f2597o     // Catch:{ all -> 0x0138 }
            boolean r9 = r9.tt     // Catch:{ all -> 0x0138 }
            if (r9 == 0) goto L_0x0134
            android.content.ContentValues r9 = new android.content.ContentValues     // Catch:{ all -> 0x0138 }
            r9.<init>()     // Catch:{ all -> 0x0138 }
            java.lang.String r0 = "status"
            fe.fe.o.rg.ad.de r1 = r7.f2597o     // Catch:{ all -> 0x0138 }
            int r1 = r1.when     // Catch:{ all -> 0x0138 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0138 }
            r9.put(r0, r1)     // Catch:{ all -> 0x0138 }
            java.lang.String r0 = "current_bytes"
            fe.fe.o.rg.ad.de r1 = r7.f2597o     // Catch:{ all -> 0x0138 }
            fe.fe.o.rg.ad.ad r1 = r1.eee     // Catch:{ all -> 0x0138 }
            long r1 = r1.i()     // Catch:{ all -> 0x0138 }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0138 }
            r9.put(r0, r1)     // Catch:{ all -> 0x0138 }
            fe.fe.o.rg.de.i r8 = fe.fe.o.rg.de.i.ad(r8)     // Catch:{ all -> 0x0138 }
            fe.fe.o.rg.de.qw r8 = r8.qw()     // Catch:{ all -> 0x0138 }
            fe.fe.o.rg.de.fe r8 = r8.xxx()     // Catch:{ all -> 0x0138 }
            java.lang.String r0 = "_id=?"
            java.lang.String[] r1 = new java.lang.String[r3]     // Catch:{ all -> 0x0138 }
            r2 = 0
            fe.fe.o.rg.ad.de r3 = r7.f2597o     // Catch:{ all -> 0x0138 }
            long r3 = r3.ppp     // Catch:{ all -> 0x0138 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0138 }
            r1[r2] = r3     // Catch:{ all -> 0x0138 }
            r8.de(r9, r0, r1)     // Catch:{ all -> 0x0138 }
        L_0x0134:
            monitor-exit(r7)
            return
        L_0x0136:
            monitor-exit(r7)
            return
        L_0x0138:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.o.rg.ad.fe.yj(java.lang.Throwable, int):void");
    }
}
