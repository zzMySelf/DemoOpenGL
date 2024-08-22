package fe.fe.o.rg.ad;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.down.loopj.android.http.n;
import com.baidu.down.request.taskmanager.OnFetchDataRequestListener;
import com.baidu.down.utils.CryptUtil;
import fe.fe.o.de.ad;
import fe.fe.o.fe.qw.de.Cif;
import fe.fe.o.fe.qw.de.Cswitch;
import fe.fe.o.fe.qw.de.o;
import fe.fe.o.rg.de.i;
import fe.fe.o.rg.de.th;
import fe.fe.o.rg.de.uk;
import fe.fe.o.rg.de.yj;
import fe.fe.o.th.fe;
import fe.fe.o.th.ggg;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONObject;

public class rg extends de {
    public TreeSet F = new TreeSet();
    public boolean G = false;
    public boolean H = true;
    public long I;
    public int J = 0;
    public Timer K;
    public Timer L;
    public long M;
    public long N;
    public List O;
    public boolean P = false;
    public String Q;

    public rg(Context context, ad adVar) {
        super(context, adVar);
        Cswitch switchR = new Cswitch(this);
        this.f2601i = switchR;
        switchR.rrr(this);
        this.M = fe.fe(this.f82switch, "pref_config_test_speed_data_size", 512) * 1024;
        this.N = fe.fe(this.f82switch, "pref_config_test_speed_duration", 15) * 1000;
    }

    public synchronized void a(uk ukVar) {
        if (this.F != null && this.F.size() > 0) {
            Iterator it = this.F.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                yj yjVar = (yj) it.next();
                if (yjVar.f2665th.equals(ukVar.f2658fe)) {
                    long j = ukVar.f2659rg;
                    yjVar.f2666uk = j;
                    long j2 = ukVar.f2660th;
                    yjVar.f2667yj = j2;
                    if ((j >= this.M || j2 >= this.N) && this.f2601i.m() == 1) {
                        this.f2601i.f(2);
                        u();
                    }
                }
            }
        }
    }

    public void aaa(Cif ifVar) {
        ifVar.m162if();
        i.ad((Context) null).qw().nn().fe(this.C, ifVar);
    }

    public synchronized void b(OnFetchDataRequestListener onFetchDataRequestListener) {
        th mmm = i.ad((Context) null).qw().mmm();
        boolean z = false;
        boolean z2 = mmm != null && !mmm.fe(this.f82switch);
        if (z2 && !t()) {
            tt(mmm);
            ((Cswitch) this.f2601i).f80switch.f2444fe = ggg.qw(this.f82switch);
            onFetchDataRequestListener.qw(true, (TreeSet) null);
        } else if (!this.P) {
            this.P = true;
            if (!z2) {
                z = true;
            }
            this.H = z;
            ArrayList arrayList = new ArrayList();
            this.O = arrayList;
            arrayList.add(onFetchDataRequestListener);
            k(new i(this));
        } else {
            this.O.add(onFetchDataRequestListener);
        }
    }

    public void c(String str, int i2) {
        TreeSet treeSet = this.F;
        if (treeSet != null && treeSet.size() > 0) {
            Iterator it = this.F.iterator();
            while (it.hasNext()) {
                yj yjVar = (yj) it.next();
                if (str.equals(yjVar.f2665th)) {
                    if (i2 != 2 || yjVar.f2662i == 1) {
                        yjVar.f2662i = i2;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void d(String str, long j) {
        TreeSet treeSet = this.F;
        if (treeSet != null && treeSet.size() > 0) {
            Iterator it = this.F.iterator();
            while (it.hasNext()) {
                yj yjVar = (yj) it.next();
                if (str.equals(yjVar.f2665th)) {
                    yjVar.f87if.add(Long.valueOf(j));
                }
            }
        }
    }

    public final void e(JSONObject jSONObject, OnFetchDataRequestListener onFetchDataRequestListener, TreeSet treeSet, th thVar) {
        String str;
        if (jSONObject != null && jSONObject != null) {
            try {
                String string = jSONObject.getString("data");
                if (!TextUtils.isEmpty(string)) {
                    String host = new URL(v()).getHost();
                    String qw = CryptUtil.qw(this.f82switch, string);
                    if (!TextUtils.isEmpty(qw)) {
                        JSONObject jSONObject2 = new JSONObject(qw);
                        int optInt = jSONObject.optInt("status");
                        if (optInt == 0) {
                            JSONArray optJSONArray = jSONObject2.optJSONArray("vips");
                            String optString = jSONObject2.optString("xcode");
                            thVar.f2648fe = optString;
                            String optString2 = jSONObject2.optString("host");
                            this.q = optString2;
                            thVar.f2655yj = optString2;
                            thVar.f2652rg = jSONObject2.optInt("live_time");
                            thVar.f2654uk = ggg.qw(this.f82switch);
                            thVar.f2649i = SystemClock.elapsedRealtime();
                            if (optJSONArray != null && !TextUtils.isEmpty(this.q)) {
                                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                    if (ggg.rg(optJSONArray.getString(i2))) {
                                        yj yjVar = new yj();
                                        String replace = v().replace(host, optJSONArray.getString(i2));
                                        yjVar.f2665th = replace;
                                        if (ggg.pf(replace)) {
                                            str = yjVar.f2665th + "&xcode=" + optString;
                                        } else {
                                            str = yjVar.f2665th + "?xcode=" + optString;
                                        }
                                        yjVar.f2665th = str;
                                        yjVar.f2663o = i2;
                                        yjVar.f2661ad = optJSONArray.getString(i2);
                                        treeSet.add(yjVar);
                                        thVar.qw.add(optJSONArray.getString(i2));
                                    }
                                }
                            }
                        } else if (optInt == 1) {
                            thVar.f2652rg = 600;
                            thVar.f2654uk = ggg.qw(this.f82switch);
                            thVar.f2649i = SystemClock.elapsedRealtime();
                        }
                        thVar.f2650o = optInt;
                    }
                }
            } catch (MalformedURLException e) {
                try {
                    e.printStackTrace();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void ggg() {
        if (((Cswitch) this.f2601i).x()) {
            ((Cswitch) this.f2601i).f(0);
            ((Cswitch) this.f2601i).s(false);
            o oVar = this.f2601i;
            ((Cswitch) oVar).f80switch.qw = 3;
            ((Cswitch) oVar).f80switch.f2445i = 4;
            ((Cswitch) oVar).f80switch.f2447pf = 2;
            i.ad((Context) null).qw().nn().th(this.C, true, this.f2601i);
            if (this.eee.qw() > 0) {
                n nVar = i.ad((Context) null).qw().nn().m163if();
                for (o oVar2 : this.eee.th()) {
                    long j = oVar2.f2599de;
                    long j2 = oVar2.f2598ad;
                    if (j < j2) {
                        m171if(j, j2, 0);
                        if (nVar == n.TYPE_2G) {
                            return;
                        }
                    }
                }
                return;
            }
            m171if(0, qw.E, 0);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j(int r4) {
        /*
            r3 = this;
            android.content.Context r0 = r3.f82switch
            java.lang.String r1 = "pref_config_is_upload_log"
            java.lang.String r2 = "1"
            java.lang.String r0 = fe.fe.o.th.fe.de(r0, r1, r2)
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0039
            switch(r4) {
                case 1004: goto L_0x0027;
                case 1005: goto L_0x001c;
                case 1006: goto L_0x0027;
                case 1007: goto L_0x0013;
                case 1008: goto L_0x0014;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x0039
        L_0x0014:
            android.content.Context r4 = r3.f82switch
            fe.fe.o.ad.fe r4 = fe.fe.o.ad.fe.ad(r4)
            r0 = 0
            goto L_0x0023
        L_0x001c:
            android.content.Context r4 = r3.f82switch
            fe.fe.o.ad.fe r4 = fe.fe.o.ad.fe.ad(r4)
            r0 = 2
        L_0x0023:
            r4.rg(r3, r0)
            goto L_0x0039
        L_0x0027:
            fe.fe.o.fe.qw.de.o r4 = r3.f2601i
            fe.fe.o.fe.qw.de.switch r4 = (fe.fe.o.fe.qw.de.Cswitch) r4
            boolean r4 = r4.z()
            if (r4 == 0) goto L_0x0039
            android.content.Context r4 = r3.f82switch
            fe.fe.o.ad.fe r4 = fe.fe.o.ad.fe.ad(r4)
            r0 = 1
            goto L_0x0023
        L_0x0039:
            r3.p()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.o.rg.ad.rg.j(int):void");
    }

    public final void k(OnFetchDataRequestListener onFetchDataRequestListener) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        yj yjVar = new yj(this, onFetchDataRequestListener, elapsedRealtime);
        Timer timer = new Timer();
        this.L = timer;
        timer.schedule(yjVar, fe.fe(this.f82switch, "pref_config_downinfo_url_timeout", 15) * 1000);
        this.Q = ggg.qw(this.f82switch);
        fe.fe.o.rg.de.o.ad(this.f82switch, this.t, this.u, this.v, this.ggg, this.H, this.s, this.y, new uk(this, elapsedRealtime, onFetchDataRequestListener));
    }

    public final TreeSet mmm(th thVar, boolean z) {
        String str;
        TreeSet treeSet = new TreeSet();
        if (z) {
            try {
                String host = new URL(v()).getHost();
                for (int i2 = 0; i2 < thVar.qw.size(); i2++) {
                    if (ggg.rg((String) thVar.qw.get(i2))) {
                        yj yjVar = new yj();
                        String replace = v().replace(host, (CharSequence) thVar.qw.get(i2));
                        yjVar.f2665th = replace;
                        if (ggg.pf(replace)) {
                            str = yjVar.f2665th + "&xcode=" + thVar.f2648fe;
                        } else {
                            str = yjVar.f2665th + "?xcode=" + thVar.f2648fe;
                        }
                        yjVar.f2665th = str;
                        yjVar.f2663o = i2;
                        yjVar.f2661ad = (String) thVar.qw.get(i2);
                        treeSet.add(yjVar);
                    }
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else {
            Iterator it = thVar.f2646ad.iterator();
            while (it.hasNext()) {
                treeSet.add(((yj) it.next()).ad(this.w, thVar.f2648fe));
            }
        }
        this.q = thVar.f2655yj;
        o oVar = this.f2601i;
        ((Cswitch) oVar).f80switch.f2442ad = 0;
        ((Cswitch) oVar).f80switch.qw = 6;
        return treeSet;
    }

    public void p() {
        this.G = false;
        Timer timer = this.K;
        if (timer != null) {
            timer.cancel();
            this.K = null;
        }
        Timer timer2 = this.L;
        if (timer2 != null) {
            timer2.cancel();
            this.L = null;
        }
        this.F.clear();
        ((Cswitch) this.f2601i).B();
    }

    public String ppp() {
        return !TextUtils.isEmpty(this.w) ? this.w : this.ggg;
    }

    public yj q() {
        TreeSet treeSet = new TreeSet(this.F);
        this.F = treeSet;
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            yj yjVar = (yj) it.next();
            if (yjVar.f2662i == 2) {
                return yjVar;
            }
        }
        return null;
    }

    public String r() {
        TreeSet treeSet = this.F;
        if (treeSet == null || treeSet.size() <= 0) {
            return "";
        }
        Iterator it = this.F.iterator();
        String str = "";
        while (it.hasNext()) {
            yj yjVar = (yj) it.next();
            if (yjVar.f88switch == 1) {
                if (str.equals("")) {
                    str = yjVar.f2663o + "";
                } else {
                    str = str + "@" + yjVar.f2663o;
                }
            }
        }
        return str;
    }

    public void rrr(o oVar) {
        m171if(oVar.f2599de, oVar.f2598ad, 2);
    }

    public TreeSet s() {
        return this.F;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003b  */
    /* renamed from: switch  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String m173switch(boolean r7) {
        /*
            r6 = this;
            java.util.TreeSet r0 = r6.F
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L_0x0007:
            boolean r2 = r0.hasNext()
            r3 = 1
            if (r2 == 0) goto L_0x002f
            java.lang.Object r2 = r0.next()
            fe.fe.o.rg.de.yj r2 = (fe.fe.o.rg.de.yj) r2
            int r4 = r2.f2662i
            r5 = 3
            if (r4 == r5) goto L_0x001b
            int r1 = r1 + 1
        L_0x001b:
            int r4 = r6.f2604th
            if (r1 > r4) goto L_0x002f
            int r4 = r2.f2662i
            if (r4 != 0) goto L_0x0007
            if (r7 == 0) goto L_0x002c
            r2.f2662i = r3
            int r7 = r2.f2664pf
            int r7 = r7 + r3
            r2.f2664pf = r7
        L_0x002c:
            java.lang.String r7 = r2.f2665th
            return r7
        L_0x002f:
            java.util.TreeSet r0 = r6.F
            java.util.Iterator r0 = r0.iterator()
        L_0x0035:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0052
            java.lang.Object r1 = r0.next()
            fe.fe.o.rg.de.yj r1 = (fe.fe.o.rg.de.yj) r1
            int r2 = r1.f2662i
            if (r2 == r3) goto L_0x0048
            r4 = 2
            if (r2 != r4) goto L_0x0035
        L_0x0048:
            if (r7 == 0) goto L_0x004f
            int r7 = r1.f2664pf
            int r7 = r7 + r3
            r1.f2664pf = r7
        L_0x004f:
            java.lang.String r7 = r1.f2665th
            return r7
        L_0x0052:
            r6.ggg()
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.o.rg.ad.rg.m173switch(boolean):java.lang.String");
    }

    public boolean t() {
        String qw = ggg.qw(this.f82switch);
        return TextUtils.isEmpty(qw) || !qw.equals(this.Q) || TextUtils.isEmpty(this.w);
    }

    public final void tt(th thVar) {
        ((Cswitch) this.f2601i).f80switch.f2445i = 0;
        if (thVar.f2647de) {
            this.F = mmm(thVar, false);
            ((Cswitch) this.f2601i).u(false);
            return;
        }
        this.F = mmm(thVar, true);
        ((Cswitch) this.f2601i).u(true);
    }

    public final void u() {
        long j;
        List<WeakReference> list = i.ad((Context) null).qw().nn().m164switch(this.C);
        if (list != null) {
            yj q = q();
            if (q != null) {
                for (WeakReference weakReference : list) {
                    Cif ifVar = (Cif) weakReference.get();
                    if (ifVar != null && ifVar.mmm() && ifVar.qqq()) {
                        long rg2 = q.rg();
                        long fe2 = fe.fe(this.f82switch, "pref_config_download_speed_offset_max", 10);
                        long fe3 = fe.fe(this.f82switch, "pref_config_download_speed_offset_min", 20) * 1024;
                        if (!q.f2665th.equals(ifVar.e) && rg2 != 0) {
                            long j2 = ifVar.f;
                            if ((j2 / rg2) * 100 < 100 - fe2 && rg2 - j2 > fe3) {
                                long o2 = this.eee.o(ifVar.h);
                                long j3 = ifVar.f;
                                if (j3 == 0) {
                                    j = 2147483647L;
                                } else {
                                    long j4 = ifVar.tt;
                                    j = ((o2 - j4) / j3) - ((o2 - j4) / rg2);
                                }
                                if (j > 5) {
                                    uk ukVar = new uk();
                                    ukVar.qw = this;
                                    ukVar.f2657de = ifVar;
                                    i.ad((Context) null).qw().b(7, ukVar);
                                    o rg3 = this.eee.rg(ifVar.h);
                                    yj xxx = xxx(ifVar.e);
                                    if (xxx != null) {
                                        xxx.f88switch = 0;
                                    }
                                    if (rg3.f2599de < rg3.f2598ad) {
                                        uk ukVar2 = new uk();
                                        ukVar2.qw = this;
                                        ukVar2.f2656ad = rg3;
                                        i.ad((Context) null).qw().b(6, ukVar2);
                                    }
                                }
                            }
                        }
                    }
                }
                th mmm = i.ad((Context) null).qw().mmm();
                if (mmm != null) {
                    synchronized (this) {
                        mmm.f2646ad = new TreeSet();
                        Iterator it = this.F.iterator();
                        while (it.hasNext()) {
                            mmm.f2646ad.add(((yj) it.next()).qw());
                        }
                    }
                }
                ((Cswitch) this.f2601i).f80switch.f2446o = q.f2667yj;
                return;
            }
            ggg();
        }
    }

    public void uk() {
        if (i.ad((Context) null).qw().nn().m163if() == n.TYPE_2G) {
            ((Cswitch) this.f2601i).s(false);
            o oVar = this.f2601i;
            ((Cswitch) oVar).f80switch.qw = 4;
            ((Cswitch) oVar).f80switch.f2445i = 5;
            ((Cswitch) oVar).f80switch.f2447pf = 4;
        } else {
            if (!this.G) {
                th mmm = i.ad((Context) null).qw().mmm();
                if (mmm != null && mmm.de(this.f82switch)) {
                    this.H = false;
                    if (!t()) {
                        this.G = true;
                        ((Cswitch) this.f2601i).s(false);
                    }
                } else if (mmm == null || mmm.fe(this.f82switch)) {
                    this.H = true;
                } else {
                    this.H = false;
                    if (i.ad((Context) null).qw().aaa().qw == 1) {
                        if (!t()) {
                            this.G = true;
                            tt(mmm);
                        }
                    }
                }
                this.G = false;
            }
            if (this.G) {
                o oVar2 = this.f2601i;
                ((Cswitch) oVar2).f80switch.f2443de = this.f2600ad;
                ((Cswitch) oVar2).f80switch.f2444fe = ggg.qw(this.f82switch);
                ((Cswitch) this.f2601i).f80switch.f2448rg = this.n;
            } else if (i.ad((Context) null).qw().aaa().qw == 1) {
                k(new th(this));
                return;
            } else {
                return;
            }
        }
        super.uk();
    }

    public final String v() {
        return i.ad((Context) null).qw().aaa().qw == 1 ? this.w : this.ggg;
    }

    public String when() {
        TreeSet treeSet = this.F;
        if (treeSet != null && treeSet.size() > 0) {
            Iterator it = this.F.iterator();
            while (it.hasNext()) {
                yj yjVar = (yj) it.next();
                if (yjVar.f2662i == 2) {
                    return yjVar.f2665th;
                }
            }
        }
        return ppp();
    }

    public yj xxx(String str) {
        TreeSet treeSet = this.F;
        if (treeSet == null || treeSet.size() <= 0) {
            return null;
        }
        Iterator it = this.F.iterator();
        while (it.hasNext()) {
            yj yjVar = (yj) it.next();
            if (str == yjVar.f2665th) {
                return yjVar;
            }
        }
        return null;
    }
}
