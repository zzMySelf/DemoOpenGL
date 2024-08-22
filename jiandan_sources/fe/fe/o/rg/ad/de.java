package fe.fe.o.rg.ad;

import android.content.Context;
import android.database.Cursor;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import com.baidu.apollon.restnet.rest.g;
import com.baidu.down.loopj.android.http.n;
import fe.fe.o.de.rg;
import fe.fe.o.fe.qw.de.o;
import fe.fe.o.rg.de.i;
import fe.fe.o.th.Cswitch;
import fe.fe.o.th.fe;
import java.io.File;

public class de extends qw {
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0138  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public de(android.content.Context r8, fe.fe.o.de.ad r9) {
        /*
            r7 = this;
            r0 = 1
            r7.<init>(r0)
            r7.f82switch = r8
            android.content.ContextWrapper r1 = new android.content.ContextWrapper
            r1.<init>(r8)
            r7.C = r1
            java.lang.String r1 = r9.f2476ad
            r7.ggg = r1
            java.lang.String r1 = r9.f2477de
            r7.ddd = r1
            java.lang.String r1 = r9.f2478fe
            r7.vvv = r1
            java.lang.String r1 = r9.f2483th
            r7.mmm = r1
            java.lang.String r1 = r9.f2485yj
            r7.aaa = r1
            boolean r1 = r9.qw
            r7.tt = r1
            java.lang.Boolean r1 = r9.f2479i
            boolean r1 = r1.booleanValue()
            r7.e = r1
            boolean r2 = r9.f2482rg
            r7.xxx = r2
            int r2 = r9.f2480o
            r7.f2600ad = r2
            r3 = 2
            if (r1 == 0) goto L_0x003d
            if (r2 >= r3) goto L_0x003d
            r1 = 0
            r7.e = r1
        L_0x003d:
            java.lang.String r1 = "pref_config_test_speed_ip_num"
            int r8 = fe.fe.o.th.fe.qw(r8, r1, r3)
            int r1 = r7.f2600ad
            int r8 = java.lang.Math.min(r8, r1)
            int r8 = java.lang.Math.max(r8, r0)
            r7.f2604th = r8
            if (r8 >= r0) goto L_0x0053
            r7.f2604th = r0
        L_0x0053:
            long r1 = r9.f71switch
            r7.qqq = r1
            java.lang.String r8 = r9.ggg
            r7.n = r8
            java.lang.String r8 = r9.vvv
            r7.s = r8
            java.lang.String r8 = r9.xxx
            r7.t = r8
            java.lang.String r8 = r9.ddd
            r7.u = r8
            java.lang.String r8 = r9.nn
            r7.v = r8
            java.lang.String r8 = r9.mmm
            r7.y = r8
            long r1 = r7.pf(r8)
            r7.x = r1
            boolean r8 = r7.e
            r1 = 0
            r2 = 0
            if (r8 == 0) goto L_0x00bd
            long r4 = r9.f70if
            int r8 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r8 <= 0) goto L_0x0092
            java.lang.String r8 = r9.when
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 == 0) goto L_0x0092
            fe.fe.o.rg.ad.ad r8 = new fe.fe.o.rg.ad.ad
            r8.<init>()
            r7.eee = r8
            goto L_0x00d4
        L_0x0092:
            fe.fe.o.rg.ad.ad r8 = new fe.fe.o.rg.ad.ad
            java.lang.String r4 = r9.when
            r8.<init>(r4)
            r7.eee = r8
            fe.fe.o.rg.de.i r8 = fe.fe.o.rg.de.i.ad(r1)
            fe.fe.o.rg.de.qw r8 = r8.qw()
            fe.fe.o.fe.qw.de.qw r8 = r8.nn()
            com.baidu.down.loopj.android.http.n r8 = r8.m163if()
            com.baidu.down.loopj.android.http.n r4 = com.baidu.down.loopj.android.http.n.TYPE_2G
            if (r8 == r4) goto L_0x00e0
            boolean r8 = r7 instanceof fe.fe.o.rg.ad.rg
            if (r8 == 0) goto L_0x00e0
            fe.fe.o.rg.ad.ad r8 = r7.eee
            int r4 = r7.f2600ad
            long r5 = fe.fe.o.rg.ad.qw.E
            r8.ad(r4, r5)
            goto L_0x00e0
        L_0x00bd:
            fe.fe.o.rg.ad.ad r8 = new fe.fe.o.rg.ad.ad
            java.lang.String r4 = r9.when
            r8.<init>(r4)
            r7.eee = r8
            long r4 = r9.f70if
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 <= 0) goto L_0x00e0
            int r8 = r8.qw()
            if (r8 != 0) goto L_0x00e0
            fe.fe.o.rg.ad.ad r8 = r7.eee
        L_0x00d4:
            long r4 = r9.f71switch
            r8.fe(r2, r4)
            fe.fe.o.rg.ad.ad r8 = r7.eee
            long r4 = r9.f70if
            r8.yj(r2, r4)
        L_0x00e0:
            fe.fe.o.rg.ad.ad r8 = r7.eee
            long r4 = r8.i()
            int r8 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r8 <= 0) goto L_0x010d
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r4 = r7.ddd
            r8.append(r4)
            java.lang.String r4 = java.io.File.separator
            r8.append(r4)
            java.lang.String r4 = r7.vvv
            r8.append(r4)
            java.lang.String r8 = r8.toString()
            r7.nn = r8
            fe.fe.o.rg.ad.ad r8 = r7.eee
            long r4 = r8.i()
            r7.p = r4
            goto L_0x010f
        L_0x010d:
            r7.p = r2
        L_0x010f:
            boolean r8 = r9.qw
            if (r8 == 0) goto L_0x0130
            long r4 = r9.f2484uk
            int r8 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r8 >= 0) goto L_0x0130
            fe.fe.o.rg.de.i r8 = fe.fe.o.rg.de.i.ad(r1)
            fe.fe.o.rg.de.qw r8 = r8.qw()
            fe.fe.o.rg.de.fe r8 = r8.xxx()
            java.lang.String r1 = r7.ggg
            java.lang.String r2 = r7.vvv
            java.lang.String r3 = r7.ddd
            long r0 = r8.qw(r1, r2, r3, r0)
            goto L_0x0132
        L_0x0130:
            long r0 = r9.f2484uk
        L_0x0132:
            r7.ppp = r0
            boolean r8 = r7.tt
            if (r8 == 0) goto L_0x013b
            r7.ggg()
        L_0x013b:
            fe.fe.o.rg.ad.fe r8 = new fe.fe.o.rg.ad.fe
            r8.<init>(r7)
            r7.f2601i = r8
            r8.rrr(r7)
            fe.fe.o.qw.rg r8 = new fe.fe.o.qw.rg
            android.content.Context r0 = r7.f82switch
            r8.<init>(r0, r7)
            r7.f2603pf = r8
            fe.fe.o.ad.th r8 = new fe.fe.o.ad.th
            r8.<init>()
            r7.f81if = r8
            long r0 = r9.f2484uk
            r8.f2462de = r0
            java.lang.String r0 = ""
            r8.f2461ad = r0
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            r7.A = r8
            java.util.HashMap r9 = r9.f2481pf
            r8.putAll(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.o.rg.ad.de.<init>(android.content.Context, fe.fe.o.de.ad):void");
    }

    private void ggg() {
        Cursor ad2 = i.ad((Context) null).qw().xxx().ad((String[]) null, "_id=?", new String[]{String.valueOf(this.ppp)}, (String) null, (String) null, (String) null);
        if (ad2 != null) {
            ad2.moveToFirst();
            if (TextUtils.isEmpty(ad2.getString(ad2.getColumnIndex("data")))) {
                ad2.close();
                return;
            }
            ad2.getInt(ad2.getColumnIndex("tasktype"));
            this.when = ad2.getInt(ad2.getColumnIndex("status"));
            this.ggg = ad2.getString(ad2.getColumnIndex("uri"));
            this.vvv = ad2.getString(ad2.getColumnIndex("name"));
            this.ddd = ad2.getString(ad2.getColumnIndex("path"));
            this.nn = ad2.getString(ad2.getColumnIndex("data"));
            this.mmm = ad2.getString(ad2.getColumnIndex("mimetype"));
            this.aaa = ad2.getString(ad2.getColumnIndex("etag"));
            long j = ad2.getLong(ad2.getColumnIndex("current_bytes"));
            this.eee = new ad();
            if (new File(this.nn).exists()) {
                this.eee.fe(0, this.qqq);
                this.eee.yj(0, j);
                this.qqq = ad2.getLong(ad2.getColumnIndex("total_bytes"));
            }
            ad2.close();
        }
    }

    public void i() {
        if (this.when != 1006) {
            this.when = 1006;
            i.ad((Context) null).qw().nn().th(this.C, true, this.f2601i);
            i.ad((Context) null).qw().tt(this.ggg, this.ppp);
            rg rgVar = new rg();
            rgVar.f2493de = this.ppp;
            rgVar.f2492ad = ad();
            rgVar.f2499th = this.nn;
            rgVar.f2494fe = this.eee.i();
            rgVar.f2498rg = this.f2601i.k();
            rgVar.qw = 1006;
            i.ad((Context) null).qw().a(rgVar);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0048, code lost:
        if (r19 <= r5) goto L_0x004a;
     */
    /* renamed from: if  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m171if(long r17, long r19, int r21) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r21
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.util.HashMap r5 = r0.A
            r4.putAll(r5)
            java.lang.String r5 = r0.aaa
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x001f
            java.lang.String r5 = r0.aaa
            java.lang.String r6 = "If-Match"
            r4.put(r6, r5)
        L_0x001f:
            r5 = 0
            r7 = 307200(0x4b000, double:1.51777E-318)
            r9 = 1
            java.lang.String r11 = "-"
            java.lang.String r12 = "bytes="
            java.lang.String r13 = "Range"
            r14 = 0
            int r15 = (r19 > r5 ? 1 : (r19 == r5 ? 0 : -1))
            fe.fe.o.rg.de.i r5 = fe.fe.o.rg.de.i.ad(r14)
            fe.fe.o.rg.de.qw r5 = r5.qw()
            fe.fe.o.fe.qw.de.qw r5 = r5.nn()
            boolean r5 = r5.pf()
            if (r15 <= 0) goto L_0x0067
            if (r5 == 0) goto L_0x004a
            long r5 = r1 + r7
            long r5 = r5 - r9
            int r7 = (r19 > r5 ? 1 : (r19 == r5 ? 0 : -1))
            if (r7 > 0) goto L_0x004c
        L_0x004a:
            r5 = r19
        L_0x004c:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r12)
            r7.append(r1)
            r7.append(r11)
            long r8 = r5 - r9
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r4.put(r13, r7)
            goto L_0x0095
        L_0x0067:
            if (r5 == 0) goto L_0x007e
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r12)
            r5.append(r1)
            r5.append(r11)
            long r6 = r1 + r7
            long r6 = r6 - r9
            r5.append(r6)
            goto L_0x008c
        L_0x007e:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r12)
            r5.append(r1)
            r5.append(r11)
        L_0x008c:
            java.lang.String r5 = r5.toString()
            r4.put(r13, r5)
            r5 = r19
        L_0x0095:
            fe.fe.o.fe.qw.de.o r7 = r0.f2601i
            r7.h()
            fe.fe.o.fe.qw.de.o r7 = r0.f2601i
            boolean r8 = r7 instanceof fe.fe.o.fe.qw.de.Cswitch
            if (r8 == 0) goto L_0x00b9
            fe.fe.o.fe.qw.de.switch r7 = (fe.fe.o.fe.qw.de.Cswitch) r7
            boolean r7 = r7.x()
            if (r7 == 0) goto L_0x00b9
            if (r3 == 0) goto L_0x00b9
            java.lang.String r7 = r0.q
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x00b9
            java.lang.String r7 = r0.q
            java.lang.String r8 = "Host"
            r4.put(r8, r7)
        L_0x00b9:
            fe.fe.o.fe.qw.de.when r7 = new fe.fe.o.fe.qw.de.when
            r7.<init>()
            r7.qw = r1
            r7.f2562ad = r5
            r1 = 2
            r8 = 1
            if (r3 != r1) goto L_0x00df
            fe.fe.o.rg.de.i r1 = fe.fe.o.rg.de.i.ad(r14)
            fe.fe.o.rg.de.qw r1 = r1.qw()
            fe.fe.o.fe.qw.de.qw r1 = r1.nn()
            android.content.Context r2 = r0.C
            java.lang.String r3 = r16.when()
        L_0x00d8:
            r5 = 0
            fe.fe.o.fe.qw.de.o r6 = r0.f2601i
            r1.rg(r2, r3, r4, r5, r6, r7)
            goto L_0x0118
        L_0x00df:
            if (r3 != r8) goto L_0x0105
            fe.fe.o.fe.qw.de.o r1 = r0.f2601i
            int r1 = r1.m()
            if (r1 != 0) goto L_0x00ef
            r1 = 0
            java.lang.String r1 = r0.m172switch(r1)
            goto L_0x00f3
        L_0x00ef:
            java.lang.String r1 = r0.m172switch(r8)
        L_0x00f3:
            r3 = r1
            if (r3 == 0) goto L_0x0118
            fe.fe.o.rg.de.i r1 = fe.fe.o.rg.de.i.ad(r14)
            fe.fe.o.rg.de.qw r1 = r1.qw()
            fe.fe.o.fe.qw.de.qw r1 = r1.nn()
            android.content.Context r2 = r0.C
            goto L_0x00d8
        L_0x0105:
            fe.fe.o.rg.de.i r1 = fe.fe.o.rg.de.i.ad(r14)
            fe.fe.o.rg.de.qw r1 = r1.qw()
            fe.fe.o.fe.qw.de.qw r1 = r1.nn()
            android.content.Context r2 = r0.C
            java.lang.String r3 = r16.ppp()
            goto L_0x00d8
        L_0x0118:
            int r1 = r0.f2606yj
            int r1 = r1 + r8
            r0.f2606yj = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.o.rg.ad.de.m171if(long, long, int):void");
    }

    public void o() {
        this.when = PointerIconCompat.TYPE_VERTICAL_TEXT;
        i.ad((Context) null).qw().nn().th(this.C, true, this.f2601i);
        i.ad((Context) null).qw().tt(this.ggg, this.ppp);
        i.ad((Context) null).qw().eee().qw(ad());
        rg rgVar = new rg();
        rgVar.f2493de = this.ppp;
        rgVar.f2492ad = ad();
        rgVar.qw = PointerIconCompat.TYPE_VERTICAL_TEXT;
        i.ad((Context) null).qw().a(rgVar);
    }

    public final long pf(String str) {
        long j = 0;
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            String lowerCase = str.toLowerCase();
            if (!lowerCase.contains("m")) {
                return lowerCase.contains(g.a) ? 1073741824 : 0;
            }
            String[] split = lowerCase.replace("m", "").split("\\.");
            if (split != null && split.length > 0) {
                j = Long.parseLong(split[0]) * 1024 * 1024;
            }
            if (split == null || split.length <= 1 || TextUtils.isEmpty(split[1].substring(0, 1))) {
                return j;
            }
            long parseLong = Long.parseLong(split[1].substring(0, 1));
            Long.signum(parseLong);
            return j + (parseLong * 1024);
        } catch (Exception unused) {
        }
    }

    public String ppp() {
        return this.ggg;
    }

    /* renamed from: switch  reason: not valid java name */
    public String m172switch(boolean z) {
        return ppp();
    }

    public void uk() {
        int i2;
        long j;
        long j2;
        int i3;
        long j3;
        long j4;
        this.f = SystemClock.elapsedRealtime();
        if (this.when != 1001) {
            this.m = false;
            long j5 = this.qqq;
            if (j5 == 0 || j5 != this.eee.i() || TextUtils.isEmpty(this.nn) || !new File(this.nn).exists()) {
                if (this.eee.i() > 0 && !TextUtils.isEmpty(this.nn) && !new File(this.nn).exists()) {
                    this.eee = new ad();
                    this.z = "file deleted and redownload";
                }
                this.g = SystemClock.elapsedRealtime();
                this.j = this.eee.i();
                this.h = 0;
                this.when = 1001;
                this.f2601i.p();
                this.f81if.fe(i.ad((Context) null).qw().ddd().qw() && Cswitch.ad(this.ggg));
                if (this.e) {
                    long ad2 = fe.ad(this.f82switch, "pref_config_test_speed_threshold", 10240) * 1024;
                    this.f2606yj = 0;
                    n nVar = i.ad((Context) null).qw().nn().m163if();
                    if (this.eee.qw() > 0) {
                        if (this.qqq - this.eee.i() < ad2) {
                            o oVar = this.f2601i;
                            if (oVar instanceof fe.fe.o.fe.qw.de.Cswitch) {
                                ((fe.fe.o.fe.qw.de.Cswitch) oVar).s(false);
                                ((fe.fe.o.fe.qw.de.Cswitch) this.f2601i).f80switch.f2447pf = 1;
                            }
                        }
                        o oVar2 = this.f2601i;
                        if (!(oVar2 instanceof fe.fe.o.fe.qw.de.Cswitch) || nVar == n.TYPE_2G || !((fe.fe.o.fe.qw.de.Cswitch) oVar2).x() || !this.eee.uk(this.f2600ad, qw.E)) {
                            for (o oVar3 : this.eee.th()) {
                                long j6 = oVar3.f2599de;
                                long j7 = oVar3.f2598ad;
                                if (j6 < j7) {
                                    m171if(j6, j7, 0);
                                    if (nVar == n.TYPE_2G) {
                                        break;
                                    }
                                }
                            }
                            rg rgVar = new rg();
                            rgVar.f2493de = this.ppp;
                            rgVar.f2492ad = ad();
                            rgVar.f2494fe = this.eee.i();
                            rgVar.f2498rg = this.f2601i.k();
                            rgVar.qw = 1000;
                            i.ad((Context) null).qw().a(rgVar);
                            return;
                        }
                        fe.fe.o.fe.qw.de.Cswitch switchR = (fe.fe.o.fe.qw.de.Cswitch) this.f2601i;
                        if (switchR.A()) {
                            switchR.f(1);
                        }
                        for (o oVar4 : this.eee.th()) {
                            if (oVar4.f2599de < oVar4.f2598ad) {
                                if (switchR.A()) {
                                    j4 = oVar4.f2599de;
                                    j3 = oVar4.f2598ad;
                                    i3 = 1;
                                } else {
                                    j4 = oVar4.f2599de;
                                    j3 = oVar4.f2598ad;
                                    i3 = 2;
                                }
                                m171if(j4, j3, i3);
                            }
                        }
                        rg rgVar2 = new rg();
                        rgVar2.f2493de = this.ppp;
                        rgVar2.f2492ad = ad();
                        rgVar2.f2494fe = this.eee.i();
                        rgVar2.f2498rg = this.f2601i.k();
                        rgVar2.qw = 1000;
                        i.ad((Context) null).qw().a(rgVar2);
                        return;
                    }
                    if (this.x < ad2) {
                        o oVar5 = this.f2601i;
                        if (oVar5 instanceof fe.fe.o.fe.qw.de.Cswitch) {
                            ((fe.fe.o.fe.qw.de.Cswitch) oVar5).s(false);
                            ((fe.fe.o.fe.qw.de.Cswitch) this.f2601i).f80switch.f2447pf = 1;
                        }
                    }
                    o oVar6 = this.f2601i;
                    if (!(oVar6 instanceof fe.fe.o.fe.qw.de.Cswitch) || nVar == n.TYPE_2G || !((fe.fe.o.fe.qw.de.Cswitch) oVar6).x()) {
                        j2 = 0;
                        j = qw.E;
                    } else {
                        boolean A = ((fe.fe.o.fe.qw.de.Cswitch) this.f2601i).A();
                        j2 = 0;
                        j = qw.E;
                        i2 = A ? 1 : 2;
                        m171if(j2, j, i2);
                        rg rgVar22 = new rg();
                        rgVar22.f2493de = this.ppp;
                        rgVar22.f2492ad = ad();
                        rgVar22.f2494fe = this.eee.i();
                        rgVar22.f2498rg = this.f2601i.k();
                        rgVar22.qw = 1000;
                        i.ad((Context) null).qw().a(rgVar22);
                        return;
                    }
                } else {
                    j2 = this.eee.i();
                    j = -1;
                }
                i2 = 0;
                m171if(j2, j, i2);
                rg rgVar222 = new rg();
                rgVar222.f2493de = this.ppp;
                rgVar222.f2492ad = ad();
                rgVar222.f2494fe = this.eee.i();
                rgVar222.f2498rg = this.f2601i.k();
                rgVar222.qw = 1000;
                i.ad((Context) null).qw().a(rgVar222);
                return;
            }
            this.when = PointerIconCompat.TYPE_TEXT;
            rg rgVar3 = new rg();
            rgVar3.f2493de = this.ppp;
            rgVar3.f2492ad = this.ggg + this.ppp;
            rgVar3.qw = PointerIconCompat.TYPE_TEXT;
            i.ad((Context) null).qw().a(rgVar3);
            i.ad((Context) null).qw().tt(this.ggg, this.ppp);
        }
    }

    public String when() {
        return ppp();
    }
}
