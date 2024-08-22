package com.baidu.mobstat.dxmpay;

import android.content.Context;
import fe.fe.p007switch.qw.de;
import fe.fe.p007switch.qw.i;
import fe.fe.p007switch.qw.ppp;
import fe.fe.p007switch.qw.qqq;
import fe.fe.p007switch.qw.th;
import fe.fe.p007switch.qw.yj;
import java.util.HashMap;
import org.json.JSONObject;

public class SessionAnalysis {

    /* renamed from: ad  reason: collision with root package name */
    public long f897ad;

    /* renamed from: de  reason: collision with root package name */
    public i f898de;

    /* renamed from: fe  reason: collision with root package name */
    public int f899fe;
    public boolean qw = false;

    /* renamed from: rg  reason: collision with root package name */
    public int f900rg;

    /* renamed from: th  reason: collision with root package name */
    public boolean f901th;

    /* renamed from: uk  reason: collision with root package name */
    public th f902uk;

    /* renamed from: yj  reason: collision with root package name */
    public Callback f903yj;

    public interface Callback {
        void qw(JSONObject jSONObject);
    }

    public SessionAnalysis() {
        new HashMap();
        this.f897ad = 0;
        this.f898de = new i();
        this.f899fe = 0;
        this.f900rg = 0;
        this.f901th = true;
    }

    public final void ad(Context context, long j, boolean z, boolean z2, int i2) {
        long j2;
        if (this.f898de.rg()) {
            de.ppp().nn(this.f898de);
            de.ppp().pf(context);
            d.qw(this.f898de.de());
            this.f898de.uk(0);
        }
        boolean z3 = j > 0;
        if (z3) {
            j2 = j;
        } else {
            j2 = this.f898de.fe();
        }
        if (z3) {
            this.f898de.yj();
            this.f898de.i(j);
        }
        de.ppp().qqq(context, z3, z, j2, z2, (JSONObject) null);
        Callback callback = this.f903yj;
        if (callback != null) {
            callback.qw(de.ppp().m209if());
        }
        if (z3 || this.f901th) {
            yj.mmm().aaa(context);
        }
        rg(context);
    }

    public void de(Context context, long j) {
        if (context != null) {
            this.f898de.o(j);
            qw(context);
        }
    }

    public void fe(Context context, long j) {
        if (context != null) {
            this.f898de.pf(j);
        }
    }

    public void i(Context context, long j, boolean z) {
        if (!this.qw) {
            de.ppp().m210switch(context);
            th thVar = this.f902uk;
            ad(context, j, z, true, thVar != null ? thVar.qw(context) : 0);
            this.qw = true;
        }
    }

    public final void qw(Context context) {
        if (this.f898de.th()) {
            String jSONObject = this.f898de.qw().toString();
            this.f900rg = jSONObject.getBytes().length;
            String c = qqq.c(context);
            ppp.de(context, c + Config.f885rg, jSONObject, false);
        }
    }

    public void rg(Context context) {
        if (context != null) {
            String jSONObject = new JSONObject().toString();
            String c = qqq.c(context);
            ppp.de(context, c + Config.f885rg, jSONObject, false);
        }
    }

    public void th(Context context, long j) {
        long j2 = this.f897ad;
        if (j2 > 0 && j - j2 > ((long) uk())) {
            ad(context, -1, false, false, 0);
        }
    }

    public int uk() {
        if (this.f899fe <= 0) {
            this.f899fe = 30000;
        }
        return this.f899fe;
    }

    public int yj() {
        return this.f900rg;
    }
}
