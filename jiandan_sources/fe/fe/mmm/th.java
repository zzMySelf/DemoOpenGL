package fe.fe.mmm;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.ubc.Flow;
import com.baidu.ubc.IUBCStatisticCallback;
import com.baidu.ubc.IUBCUploadCallback;
import com.baidu.ubc.IUbcLogStore;
import com.baidu.ubc.UBCApiCollector;
import com.baidu.ubc.UBCUploadTimingManager;
import com.baidu.ubc.bypass.BypassConstants$Funnel;
import com.baidu.ubc.constants.EnumConstants$RunTime;
import com.baidu.ubc.constants.EnumConstants$Trigger;
import fe.fe.mmm.rg;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class th {

    /* renamed from: o  reason: collision with root package name */
    public static final boolean f2152o = tt.vvv();

    /* renamed from: pf  reason: collision with root package name */
    public static volatile th f2153pf;

    /* renamed from: ad  reason: collision with root package name */
    public ScheduledExecutorService f2154ad;

    /* renamed from: de  reason: collision with root package name */
    public ExecutorService f2155de;

    /* renamed from: fe  reason: collision with root package name */
    public i f2156fe;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2157i;
    public Context qw;

    /* renamed from: rg  reason: collision with root package name */
    public rg f2158rg;

    /* renamed from: th  reason: collision with root package name */
    public AtomicInteger f2159th;

    /* renamed from: uk  reason: collision with root package name */
    public IUbcLogStore f2160uk;

    /* renamed from: yj  reason: collision with root package name */
    public boolean f2161yj = false;

    public class ad implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ boolean f2162ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ String f2163th;

        public ad(boolean z, String str) {
            this.f2162ad = z;
            this.f2163th = str;
        }

        public void run() {
            if (th.this.f2158rg == null) {
                boolean de2 = th.f2152o;
                return;
            }
            if (this.f2162ad) {
                th.this.f2158rg.q(this.f2163th);
            } else {
                th.this.f2158rg.p(this.f2163th);
            }
            UBCUploadTimingManager.o().qqq(this.f2162ad);
        }
    }

    public class ddd implements Runnable {
        public ddd() {
        }

        public void run() {
            fe.fe.mmm.n.qw.de(BypassConstants$Funnel.INIT_INNER_START);
            m.m128switch("init inner start", EnumConstants$RunTime.INIT_MESSAGE);
            Process.setThreadPriority(10);
            try {
                i unused = th.this.f2156fe = i.vvv();
                rg unused2 = th.this.f2158rg = new rg(th.this.qw);
                th.this.f2158rg.f();
                if (th.this.f2158rg == null || th.this.f2156fe == null) {
                    fe.fe.mmm.n.qw.de(BypassConstants$Funnel.INIT_FAIL);
                    m.m128switch("init fail", EnumConstants$RunTime.INIT_MESSAGE);
                    return;
                }
                fe.fe.mmm.n.qw.de(BypassConstants$Funnel.INIT_SUCCESS);
                m.m128switch("init success", EnumConstants$RunTime.INIT_MESSAGE);
            } catch (Throwable th2) {
                if (th.this.f2158rg == null || th.this.f2156fe == null) {
                    fe.fe.mmm.n.qw.de(BypassConstants$Funnel.INIT_FAIL);
                    m.m128switch("init fail", EnumConstants$RunTime.INIT_MESSAGE);
                } else {
                    fe.fe.mmm.n.qw.de(BypassConstants$Funnel.INIT_SUCCESS);
                    m.m128switch("init success", EnumConstants$RunTime.INIT_MESSAGE);
                }
                throw th2;
            }
        }

        public /* synthetic */ ddd(th thVar, fe feVar) {
            this();
        }
    }

    public class de implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Cif f2166ad;

        public de(Cif ifVar) {
            this.f2166ad = ifVar;
        }

        public void run() {
            if (th.this.f2156fe != null) {
                th.this.f2156fe.q(this.f2166ad);
            }
        }
    }

    public class fe implements Runnable {
        public fe() {
        }

        public void run() {
            if (th.this.f2158rg != null) {
                th.this.f2158rg.s(false);
            }
        }
    }

    public class i implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ l f2171ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ rg.de f2172th;

        public i(l lVar, rg.de deVar) {
            this.f2171ad = lVar;
            this.f2172th = deVar;
        }

        public void run() {
            if (th.this.f2158rg == null) {
                boolean de2 = th.f2152o;
                return;
            }
            if (th.f2152o) {
                "uploadData isDataInFile:" + this.f2171ad.g();
                if (this.f2171ad.g()) {
                    this.f2171ad.q("UBCDEBUG");
                } else {
                    this.f2171ad.tt().toString();
                }
            }
            th.this.f2158rg.m(this.f2172th);
        }
    }

    /* renamed from: fe.fe.mmm.th$if  reason: invalid class name */
    public class Cif implements Runnable {
        public Cif() {
        }

        public void run() {
            if (th.this.f2158rg == null) {
                boolean de2 = th.f2152o;
            } else {
                th.this.f2158rg.d();
            }
        }
    }

    public class o implements Runnable {
        public o() {
        }

        public void run() {
            if (th.this.f2158rg == null) {
                boolean de2 = th.f2152o;
            } else {
                th.this.f2158rg.aaa();
            }
        }
    }

    public class pf implements Runnable {
        public pf() {
        }

        public void run() {
            if (th.this.f2158rg == null) {
                boolean de2 = th.f2152o;
            } else {
                th.this.f2158rg.mmm();
            }
        }
    }

    public class ppp implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public String f2177ad;

        /* renamed from: th  reason: collision with root package name */
        public int f2178th;

        public ppp(String str, int i2) {
            this.f2177ad = str;
            this.f2178th = i2;
        }

        public void run() {
            if (th.this.f2158rg == null) {
                boolean de2 = th.f2152o;
            } else {
                th.this.f2158rg.uk(this.f2177ad, this.f2178th);
            }
        }
    }

    public class qw implements Runnable {
        public qw() {
        }

        public void run() {
            if (th.this.f2158rg == null) {
                boolean de2 = th.f2152o;
            } else if (!th.this.f2158rg.i()) {
                boolean de3 = th.f2152o;
            } else {
                th.this.f2158rg.c();
            }
        }
    }

    public class rg implements Runnable {
        public rg() {
        }

        public void run() {
            if (th.this.f2158rg == null) {
                boolean de2 = th.f2152o;
                return;
            }
            if (Math.abs(System.currentTimeMillis() - k.qw().de("ubc_last_upload_all_time", 0)) >= DateUtils.MILLIS_PER_HOUR) {
                th.this.f2158rg.s(true);
                long currentTimeMillis = System.currentTimeMillis();
                k.qw().th("ubc_last_upload_all_time", currentTimeMillis);
                k.qw().th("ubc_last_upload_non_real", currentTimeMillis);
            }
        }
    }

    /* renamed from: fe.fe.mmm.th$switch  reason: invalid class name */
    public class Cswitch implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public nn f2182ad;

        /* renamed from: th  reason: collision with root package name */
        public boolean f2183th;

        /* renamed from: yj  reason: collision with root package name */
        public IUBCStatisticCallback f2185yj;

        public Cswitch(nn nnVar, boolean z, IUBCStatisticCallback iUBCStatisticCallback) {
            this.f2182ad = nnVar;
            this.f2183th = z;
            this.f2185yj = iUBCStatisticCallback;
        }

        public void run() {
            if (th.this.f2158rg == null) {
                boolean de2 = th.f2152o;
            } else {
                th.this.f2158rg.j(this.f2182ad, this.f2183th, this.f2185yj);
            }
        }
    }

    /* renamed from: fe.fe.mmm.th$th  reason: collision with other inner class name */
    public class C0109th implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ EnumConstants$Trigger f2186ad;

        public C0109th(EnumConstants$Trigger enumConstants$Trigger) {
            this.f2186ad = enumConstants$Trigger;
        }

        public void run() {
            if (th.this.f2158rg != null) {
                th.this.f2158rg.l(this.f2186ad);
            }
        }
    }

    public class uk implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ rg.de f2188ad;

        public uk(rg.de deVar) {
            this.f2188ad = deVar;
        }

        public void run() {
            if (th.this.f2158rg == null) {
                boolean de2 = th.f2152o;
            } else {
                th.this.f2158rg.m(this.f2188ad);
            }
        }
    }

    public class vvv implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public String f2190ad;

        /* renamed from: i  reason: collision with root package name */
        public JSONArray f2191i;

        /* renamed from: th  reason: collision with root package name */
        public int f2193th;

        /* renamed from: uk  reason: collision with root package name */
        public long f2194uk;

        /* renamed from: yj  reason: collision with root package name */
        public int f2195yj;

        public vvv(String str, int i2, int i3, JSONArray jSONArray, long j) {
            this.f2190ad = str;
            this.f2193th = i2;
            this.f2195yj = i3;
            this.f2194uk = j == 0 ? System.currentTimeMillis() : j;
            this.f2191i = jSONArray;
        }

        public void run() {
            if (th.this.f2158rg == null) {
                fe.fe.mmm.n.qw.fe(BypassConstants$Funnel.INNER_FLOW_ERROR, this.f2194uk);
                m.i(this.f2190ad, this.f2193th, EnumConstants$RunTime.FLOW_ERROR_INIT_UNFINISH);
                boolean de2 = th.f2152o;
                return;
            }
            fe.fe.mmm.n.qw.fe(BypassConstants$Funnel.INNER_FLOW, this.f2194uk);
            fe.fe.mmm.n.qw.fe(BypassConstants$Funnel.SAMPLE_FLOW, this.f2194uk);
            m.i(this.f2190ad, this.f2193th, EnumConstants$RunTime.ON_FLOW_END);
            String str = null;
            if (aaa.o().de()) {
                aaa.o().qw(this.f2190ad, true);
                str = fe.fe.mmm.u.rg.de().fe(this.f2190ad, String.valueOf(this.f2193th), false);
            }
            th.this.f2158rg.m137switch(this.f2190ad, this.f2193th, this.f2195yj, this.f2194uk, this.f2191i, str);
        }
    }

    public class xxx implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public String f2199ad;

        /* renamed from: th  reason: collision with root package name */
        public int f2200th;

        /* renamed from: yj  reason: collision with root package name */
        public String f2202yj;

        public xxx(String str, int i2, String str2) {
            this.f2199ad = str;
            this.f2200th = i2;
            this.f2202yj = str2;
        }

        public void run() {
            if (th.this.f2158rg == null) {
                boolean de2 = th.f2152o;
            } else {
                th.this.f2158rg.k(this.f2199ad, this.f2200th, this.f2202yj);
            }
        }
    }

    public class yj implements Runnable {
        public yj() {
        }

        public void run() {
            if (th.this.f2158rg == null) {
                boolean de2 = th.f2152o;
            } else {
                th.this.f2158rg.when();
            }
        }
    }

    public th() {
        fe.fe.mmm.n.qw.de(BypassConstants$Funnel.INIT_START);
        m.m128switch("clockTime:" + SystemClock.elapsedRealtime(), EnumConstants$RunTime.INIT_START);
        aaa(tt.ad());
    }

    public static th nn() {
        if (f2153pf == null) {
            synchronized (th.class) {
                if (f2153pf == null) {
                    f2153pf = new th();
                }
            }
        }
        return f2153pf;
    }

    public void a() {
        if (fe.fe.vvv.ad.qw.qw.yj()) {
            this.f2154ad.execute(new pf());
        }
    }

    public final void aaa(Context context) {
        if (this.qw == null && context != null) {
            if (context instanceof Application) {
                this.qw = context;
            } else {
                this.qw = context.getApplicationContext();
            }
            this.f2159th = new AtomicInteger(tt.fe() + 10);
            this.f2154ad = Executors.newSingleThreadScheduledExecutor();
            fe.fe.mmm.n.qw.de(BypassConstants$Funnel.INIT_THREAD_SUCC);
            m.m128switch("init thread success", EnumConstants$RunTime.INIT_MESSAGE);
            this.f2154ad.execute(new ddd(this, (fe) null));
            this.f2155de = Executors.newSingleThreadExecutor();
            fe.fe.mmm.n.qw.de(BypassConstants$Funnel.INIT_UPLOAD_THREAD_SUCC);
            m.m128switch("init upload thread success", EnumConstants$RunTime.INIT_MESSAGE);
        }
    }

    public void b(String str, String str2, int i2, String str3, int i3) {
        this.f2154ad.execute(new when(str, str2, i2, str3, i3));
    }

    public void c(String str, String str2, int i2, String str3, long j, int i3) {
        this.f2154ad.execute(new when(this, str, str2, i2, str3, j, i3));
    }

    public void d() {
        this.f2154ad.execute(new o());
    }

    public void ddd() {
        this.f2154ad.execute(new yj());
    }

    public void e(Cif ifVar) {
        this.f2154ad.execute(new de(ifVar));
    }

    public void eee(String str, String str2, int i2, String str3) {
        this.f2154ad.execute(new when(str, str2, i2, str3));
    }

    public void f(Runnable runnable, long j) {
        this.f2154ad.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    public void g() {
        if (fe.fe.vvv.ad.qw.qw.yj()) {
            boolean z = f2152o;
            UBCApiCollector.ad().th();
        }
    }

    public void ggg(String str, int i2) {
        this.f2154ad.execute(new ppp(str, i2));
    }

    public void h() {
        if (fe.fe.vvv.ad.qw.qw.yj()) {
            this.f2154ad.execute(new qw());
        }
    }

    /* renamed from: if  reason: not valid java name */
    public synchronized Flow m140if(String str, String str2, int i2) {
        Flow vvv2;
        vvv2 = vvv(str, i2);
        if (vvv2 != null && vvv2.getValid()) {
            ggg ggg2 = new ggg(vvv2, str2);
            if (this.f2156fe != null && this.f2156fe.l(str)) {
                ggg2.qw(true);
                m.i(str, vvv2.getHandle(), EnumConstants$RunTime.UPLOAD_EXCEED_REALTIME_LIMIT);
            }
            this.f2154ad.execute(ggg2);
        }
        return vvv2;
    }

    public void j() {
        this.f2154ad.execute(new Cif());
    }

    public void k(nn nnVar, boolean z, IUBCStatisticCallback iUBCStatisticCallback) {
        this.f2154ad.execute(new Cswitch(nnVar, z, iUBCStatisticCallback));
    }

    public void l(String str, int i2, String str2) {
        this.f2154ad.execute(new xxx(str, i2, str2));
    }

    public void m() {
        if (!this.f2161yj) {
            this.f2161yj = true;
            this.f2154ad.execute(new rg());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = r0.xxx(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String mmm(java.lang.String r2) {
        /*
            r1 = this;
            fe.fe.mmm.rg r0 = r1.f2158rg
            if (r0 == 0) goto L_0x0010
            int r2 = r0.xxx(r2)
            r0 = -1
            if (r2 == r0) goto L_0x0010
            java.lang.String r2 = java.lang.String.valueOf(r2)
            return r2
        L_0x0010:
            java.lang.String r2 = ""
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.th.mmm(java.lang.String):java.lang.String");
    }

    public void n(EnumConstants$Trigger enumConstants$Trigger) {
        if (fe.fe.vvv.ad.qw.qw.yj()) {
            this.f2154ad.execute(new C0109th(enumConstants$Trigger));
        }
    }

    public void p(l lVar, String str) {
        if (tt.ggg() || lVar.k()) {
            rg.de deVar = new rg.de();
            boolean g = lVar.g();
            deVar.qw = g;
            if (g) {
                deVar.f2104de = lVar.ggg();
                deVar.f2110th = lVar.when();
            } else {
                deVar.f2105fe = lVar.tt();
            }
            deVar.f2111uk = lVar.k();
            deVar.f2109rg = str;
            deVar.f2107o = lVar.eee();
            deVar.f2108pf = lVar.e();
            deVar.f58if = lVar.d();
            UBCUploadTimingManager.o().mmm();
            this.f2155de.execute(new i(lVar, deVar));
        }
    }

    public synchronized Flow ppp(String str, JSONObject jSONObject, int i2, String str2) {
        Flow vvv2;
        vvv2 = vvv(str, i2);
        if (vvv2 != null && vvv2.getValid()) {
            ggg ggg2 = new ggg(vvv2, jSONObject, str2);
            if (this.f2156fe != null && this.f2156fe.l(str)) {
                ggg2.qw(true);
                m.i(str, vvv2.getHandle(), EnumConstants$RunTime.UPLOAD_EXCEED_REALTIME_LIMIT);
            }
            this.f2154ad.execute(ggg2);
        }
        return vvv2;
    }

    public void q(JSONObject jSONObject) {
        r(jSONObject, (String) null, System.currentTimeMillis(), 1);
    }

    public void qqq(String str, String str2, int i2) {
        this.f2154ad.execute(new when(str, str2, i2));
    }

    public void r(JSONObject jSONObject, String str, long j, int i2) {
        s(jSONObject, str, false, (vvv) null, j, i2, (IUBCUploadCallback) null);
    }

    public void rrr(String str, JSONObject jSONObject, int i2) {
        this.f2154ad.execute(new when(str, jSONObject, i2));
    }

    public final void s(JSONObject jSONObject, String str, boolean z, vvv vvv2, long j, int i2, IUBCUploadCallback iUBCUploadCallback) {
        if (f2152o) {
            "uploadData:" + str;
            jSONObject.toString();
        }
        boolean ggg2 = tt.ggg();
        boolean z2 = (vvv2 == null || (vvv2.xxx() & 128) == 0) ? false : true;
        if (ggg2 || z2) {
            rg.de deVar = new rg.de();
            deVar.qw = false;
            deVar.f2105fe = jSONObject;
            deVar.f2109rg = str;
            deVar.f2112yj = z;
            deVar.f2111uk = z2;
            deVar.f2103ad = vvv2;
            deVar.f2106i = iUBCUploadCallback;
            deVar.f2107o = j;
            deVar.f2108pf = System.currentTimeMillis();
            deVar.f58if = i2;
            this.f2155de.execute(new uk(deVar));
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public synchronized Flow m141switch(String str, String str2, int i2, String str3) {
        Flow vvv2;
        vvv2 = vvv(str, i2);
        if (vvv2 != null && vvv2.getValid()) {
            ggg ggg2 = new ggg(vvv2, str2, str3);
            if (this.f2156fe != null && this.f2156fe.l(str)) {
                ggg2.qw(true);
                m.i(str, vvv2.getHandle(), EnumConstants$RunTime.UPLOAD_EXCEED_REALTIME_LIMIT);
            }
            this.f2154ad.execute(ggg2);
        }
        return vvv2;
    }

    public void t(JSONObject jSONObject, boolean z, vvv vvv2, long j, int i2, IUBCUploadCallback iUBCUploadCallback) {
        s(jSONObject, (String) null, z, vvv2, j, i2, iUBCUploadCallback);
    }

    public void tt(String str, JSONObject jSONObject, int i2, String str2) {
        this.f2154ad.execute(new when(str, jSONObject, i2, str2));
    }

    public void u(String str, boolean z) {
        this.f2154ad.execute(new ad(z, str));
    }

    public void v() {
        this.f2154ad.execute(new fe());
    }

    public Flow vvv(String str, int i2) {
        if ((i2 & 4) != 0) {
            i2 ^= 4;
        }
        Flow flow = new Flow(str, this.f2159th, i2);
        i iVar = this.f2156fe;
        if (iVar != null && !iVar.yj(str, i2)) {
            flow.setValid(false);
            return flow;
        } else if ((i2 & 16) == 0 || tt.m142if().ad(str)) {
            i iVar2 = this.f2156fe;
            if (iVar2 == null || !iVar2.uk(str)) {
                i iVar3 = this.f2156fe;
                if (iVar3 == null || !iVar3.g(str)) {
                    i iVar4 = this.f2156fe;
                    if (iVar4 != null && !iVar4.m(str)) {
                        flow.setValid(false);
                    }
                    return flow;
                }
                flow.setValid(false);
                return flow;
            }
            flow.setValid(false);
            return flow;
        } else {
            flow.setValid(false);
            return flow;
        }
    }

    public synchronized Flow when(String str, JSONObject jSONObject, int i2) {
        Flow vvv2;
        vvv2 = vvv(str, i2);
        if (vvv2 != null && vvv2.getValid()) {
            ggg ggg2 = new ggg(vvv2, jSONObject);
            if (this.f2156fe != null && this.f2156fe.l(str)) {
                ggg2.qw(true);
                m.i(str, vvv2.getHandle(), EnumConstants$RunTime.UPLOAD_EXCEED_REALTIME_LIMIT);
            }
            this.f2154ad.execute(ggg2);
        }
        return vvv2;
    }

    public void xxx(String str, int i2, int i3, JSONArray jSONArray, long j) {
        this.f2154ad.execute(new vvv(str, i2, i3, jSONArray, j));
    }

    public class when implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public vvv f2196ad;

        /* renamed from: th  reason: collision with root package name */
        public String f2197th;

        public when(String str, String str2, int i2) {
            this.f2196ad = new vvv(str, str2, i2);
            this.f2197th = str;
        }

        public void ad(boolean z) {
            vvv vvv = this.f2196ad;
            if (vvv != null) {
                vvv.c(z);
            }
        }

        public final boolean qw(String str, int i2) {
            if ((i2 & 16) != 0 && !tt.m142if().ad(str)) {
                return false;
            }
            if (th.this.f2156fe != null && !th.this.f2156fe.yj(str, i2)) {
                return false;
            }
            if (th.this.f2156fe != null && th.this.f2156fe.g(str)) {
                return false;
            }
            if (th.this.f2156fe != null && th.this.f2156fe.uk(str)) {
                return false;
            }
            if (th.this.f2156fe == null || !th.this.f2156fe.fe(str)) {
                return true;
            }
            return false;
        }

        public void run() {
            if (th.this.f2158rg == null) {
                fe.fe.mmm.n.qw.fe(BypassConstants$Funnel.INNER_EVENT_ERROR, this.f2196ad.mmm());
                m.rg(this.f2196ad.ad(), EnumConstants$RunTime.EVENT_ERROR_INIT_UNFINISH);
                boolean de2 = th.f2152o;
                return;
            }
            if (this.f2196ad.m145switch() == -1) {
                fe.fe.mmm.n.qw.fe(BypassConstants$Funnel.INNER_EVENT, this.f2196ad.mmm());
            }
            if (!th.this.f2157i) {
                if (th.this.f2160uk == null) {
                    IUbcLogStore unused = th.this.f2160uk = (IUbcLogStore) fe.fe.vvv.ad.ad.ad.qw(IUbcLogStore.qw);
                }
                boolean unused2 = th.this.f2157i = true;
            }
            if (th.this.f2156fe != null && th.this.f2156fe.ad(this.f2197th) == 1) {
                m.when(this.f2196ad);
            }
            vvv vvv = this.f2196ad;
            if (vvv != null) {
                if (vvv.m145switch() == -1) {
                    if (qw(this.f2196ad.ppp(), this.f2196ad.xxx())) {
                        fe.fe.mmm.n.qw.fe(BypassConstants$Funnel.SAMPLE_EVENT, this.f2196ad.mmm());
                        if (th.this.f2156fe != null && th.this.f2156fe.l(this.f2196ad.ppp())) {
                            ad(true);
                            m.rg(this.f2196ad.ad(), EnumConstants$RunTime.UPLOAD_EXCEED_REALTIME_LIMIT);
                        }
                        this.f2196ad.m(j.ad());
                        if (th.this.f2156fe != null) {
                            this.f2196ad.eee(th.this.f2156fe.m123if());
                        }
                    } else {
                        return;
                    }
                }
                this.f2196ad.d();
                String ppp = this.f2196ad.ppp();
                if (!TextUtils.isEmpty(ppp)) {
                    if (th.this.f2156fe != null) {
                        String pf2 = th.this.f2156fe.pf(ppp);
                        if (!TextUtils.isEmpty(pf2)) {
                            this.f2196ad.a(pf2);
                        }
                        this.f2196ad.tt(th.this.f2156fe.o(ppp));
                    }
                    if (aaa.o().de() && this.f2196ad.m145switch() == -1) {
                        aaa.o().qw(this.f2196ad.ppp(), true);
                        this.f2196ad.g(fe.fe.mmm.u.rg.de().fe(this.f2196ad.ppp(), this.f2196ad.aaa(), true));
                    }
                    m.rg(this.f2196ad.ad(), EnumConstants$RunTime.ON_EVENT);
                    if (th.this.f2156fe != null && th.this.f2156fe.ad(this.f2197th) == 2) {
                        m.when(this.f2196ad);
                    }
                    if (this.f2196ad.m145switch() == -1 && TextUtils.equals(ppp, "1876")) {
                        th.this.f2158rg.a(this.f2196ad);
                    } else if ((this.f2196ad.xxx() & 8) != 0) {
                        th.this.f2158rg.tt(this.f2196ad);
                    } else if ((this.f2196ad.xxx() & 128) != 0) {
                        th.this.f2158rg.rrr(this.f2196ad);
                    } else if (this.f2196ad == null || th.this.f2156fe == null || !th.this.f2156fe.th(ppp)) {
                        th.this.f2158rg.rrr(this.f2196ad);
                    } else {
                        th.this.f2158rg.x(this.f2196ad);
                    }
                }
            }
        }

        public when(String str, String str2, int i2, String str3) {
            vvv vvv = new vvv(str, str2, i2);
            this.f2196ad = vvv;
            this.f2197th = str;
            vvv.rrr(str3);
        }

        public when(String str, JSONObject jSONObject, int i2) {
            this.f2196ad = new vvv(str, jSONObject, i2);
            this.f2197th = str;
        }

        public when(String str, JSONObject jSONObject, int i2, String str2) {
            vvv vvv = new vvv(str, jSONObject, i2);
            this.f2196ad = vvv;
            this.f2197th = str;
            vvv.rrr(str2);
        }

        public when(String str, String str2, int i2, String str3, int i3) {
            this.f2196ad = new vvv(str, str2, i2, str3, i3);
            this.f2197th = str;
        }

        public when(th thVar, String str, String str2, int i2, String str3, long j, int i3) {
            th.this = thVar;
            this.f2196ad = new vvv(str, str2, i2, str3, j, i3);
            this.f2197th = str;
        }
    }

    public class ggg implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public ddd f2169ad;

        public ggg(Flow flow, String str) {
            ddd ddd = new ddd(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.f2169ad = ddd;
            ddd.aaa(flow.getStartTime());
            this.f2169ad.l("1");
        }

        public void qw(boolean z) {
            ddd ddd = this.f2169ad;
            if (ddd != null) {
                ddd.a(z);
            }
        }

        public void run() {
            if (th.this.f2158rg == null) {
                boolean de2 = th.f2152o;
                return;
            }
            this.f2169ad.m(j.ad());
            m.o(this.f2169ad.ppp(), this.f2169ad.when(), this.f2169ad.ddd(), EnumConstants$RunTime.ON_FLOW_START);
            this.f2169ad.d();
            if (th.this.f2156fe != null) {
                this.f2169ad.mmm(th.this.f2156fe.m123if());
                this.f2169ad.eee(th.this.f2156fe.o(this.f2169ad.ppp()));
                if (!TextUtils.isEmpty(th.this.f2156fe.pf(this.f2169ad.ppp()))) {
                    this.f2169ad.rrr(th.this.f2156fe.pf(this.f2169ad.ppp()));
                }
            }
            th.this.f2158rg.g(this.f2169ad);
            tt.mmm(th.this.f2159th.get());
        }

        public ggg(Flow flow, String str, String str2) {
            ddd ddd = new ddd(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.f2169ad = ddd;
            ddd.aaa(flow.getStartTime());
            this.f2169ad.l("1");
            this.f2169ad.qqq(str2);
        }

        public ggg(Flow flow, JSONObject jSONObject) {
            ddd ddd = new ddd(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.f2169ad = ddd;
            ddd.aaa(flow.getStartTime());
            this.f2169ad.l("1");
        }

        public ggg(Flow flow, JSONObject jSONObject, String str) {
            ddd ddd = new ddd(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.f2169ad = ddd;
            ddd.aaa(flow.getStartTime());
            this.f2169ad.l("1");
            this.f2169ad.qqq(str);
        }
    }
}
