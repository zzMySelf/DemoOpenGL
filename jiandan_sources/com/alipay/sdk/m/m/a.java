package com.alipay.sdk.m.m;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.u.e;
import com.alipay.sdk.m.u.j;
import com.alipay.sdk.m.u.n;
import com.dlife.ctaccountapi.v;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static final String A = "DynCon";
    public static final int B = 10000;
    public static final String C = "https://h5.m.taobao.com/mlapp/olist.html";
    public static final int D = 10;
    public static final boolean E = true;
    public static final boolean F = false;
    public static final boolean G = true;
    public static final boolean H = true;
    public static final boolean I = false;
    public static final boolean J = false;
    public static final boolean K = false;
    public static final boolean L = false;
    public static final boolean M = true;
    public static final String N = "";
    public static final boolean O = false;
    public static final boolean P = false;
    public static final int Q = 1000;
    public static final boolean R = true;
    public static final String S = "";
    public static final boolean T = false;
    public static final boolean U = false;
    public static final int V = 1000;
    public static final int W = 20000;
    public static final boolean X = false;
    public static final String Y = "alipay_cashier_dynamic_config";
    public static final String Z = "timeout";
    public static final String a0 = "h5_port_degrade";
    public static final String b0 = "st_sdk_config";
    public static final String c0 = "tbreturl";
    public static final String d0 = "launchAppSwitch";
    public static final String e0 = "configQueryInterval";
    public static final String f0 = "deg_log_mcgw";
    public static final String g0 = "deg_start_srv_first";
    public static final String h0 = "prev_jump_dual";
    public static final String i0 = "bind_use_imp";
    public static final String j0 = "retry_bnd_once";
    public static final String k0 = "skip_trans";
    public static final String l0 = "start_trans";
    public static final String m0 = "up_before_pay";
    public static final String n0 = "lck_k";
    public static final String o0 = "use_sc_lck_a";
    public static final String p0 = "utdid_factor";
    public static final String q0 = "cfg_max_time";
    public static final String r0 = "get_oa_id";
    public static final String s0 = "notifyFailApp";
    public static final String t0 = "startactivity_in_ui_thread";
    public static final String u0 = "intercept_batch";
    public static final String v0 = "bind_with_startActivity";
    public static final String w0 = "enableStartActivityFallback";
    public static final String x0 = "enableBindExFallback";
    public static a y0;
    public int a = 10000;
    public boolean b = false;
    public String c = C;
    public int d = 10;
    public boolean e = true;
    public boolean f = false;
    public boolean g = false;
    public boolean h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f669i = true;
    public boolean j = true;
    public boolean k = false;
    public boolean l = false;
    public boolean m = false;
    public boolean n = false;

    /* renamed from: o  reason: collision with root package name */
    public boolean f670o = true;
    public String p = "";
    public String q = "";
    public boolean r = false;
    public boolean s = false;
    public boolean t = false;
    public int u = 1000;
    public boolean v = false;
    public JSONObject w;
    public boolean x = true;
    public List<b> y = null;
    public int z = -1;

    /* renamed from: com.alipay.sdk.m.m.a$a  reason: collision with other inner class name */
    public class C0011a implements Runnable {
        public final /* synthetic */ com.alipay.sdk.m.s.a a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ int d;

        public C0011a(com.alipay.sdk.m.s.a aVar, Context context, boolean z, int i2) {
            this.a = aVar;
            this.b = context;
            this.c = z;
            this.d = i2;
        }

        public void run() {
            try {
                com.alipay.sdk.m.p.b a2 = new com.alipay.sdk.m.q.b().a(this.a, this.b);
                if (a2 != null) {
                    a.this.a(this.a, a2.a());
                    a.this.a(com.alipay.sdk.m.s.a.h());
                    com.alipay.sdk.m.s.a aVar = this.a;
                    com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "offcfg|" + this.c + "|" + this.d);
                }
            } catch (Throwable th2) {
                e.a(th2);
            }
        }
    }

    private JSONObject A() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Z, i());
        jSONObject.put(a0, v());
        jSONObject.put(c0, o());
        jSONObject.put(e0, d());
        jSONObject.put(d0, b.a(j()));
        jSONObject.put(u0, g());
        jSONObject.put(f0, e());
        jSONObject.put(g0, f());
        jSONObject.put(h0, k());
        jSONObject.put(i0, b());
        jSONObject.put(j0, l());
        jSONObject.put(k0, n());
        jSONObject.put(l0, x());
        jSONObject.put(m0, p());
        jSONObject.put(o0, m());
        jSONObject.put(n0, h());
        jSONObject.put(v0, c());
        jSONObject.put(q0, y());
        jSONObject.put(r0, u());
        jSONObject.put(s0, s());
        jSONObject.put(w0, t());
        jSONObject.put(x0, r());
        jSONObject.put(t0, w());
        jSONObject.put(com.alipay.sdk.m.u.a.b, a());
        return jSONObject;
    }

    private int y() {
        return this.u;
    }

    public static a z() {
        if (y0 == null) {
            a aVar = new a();
            y0 = aVar;
            aVar.q();
        }
        return y0;
    }

    public boolean b() {
        return this.k;
    }

    public String c() {
        return this.q;
    }

    public int d() {
        return this.d;
    }

    public boolean e() {
        return this.h;
    }

    public boolean f() {
        return this.f669i;
    }

    public boolean g() {
        return this.e;
    }

    public String h() {
        return this.p;
    }

    public int i() {
        int i2 = this.a;
        if (i2 < 1000 || i2 > 20000) {
            e.b(A, "time(def) = 10000");
            return 10000;
        }
        e.b(A, "time = " + this.a);
        return this.a;
    }

    public List<b> j() {
        return this.y;
    }

    public boolean k() {
        return this.j;
    }

    public boolean l() {
        return this.l;
    }

    public boolean m() {
        return this.t;
    }

    public boolean n() {
        return this.m;
    }

    public String o() {
        return this.c;
    }

    public boolean p() {
        return this.f670o;
    }

    public void q() {
        Context b2 = com.alipay.sdk.m.s.b.d().b();
        String a2 = j.a(com.alipay.sdk.m.s.a.h(), b2, Y, (String) null);
        try {
            this.z = Integer.parseInt(j.a(com.alipay.sdk.m.s.a.h(), b2, p0, "-1"));
        } catch (Exception unused) {
        }
        a(a2);
    }

    public boolean r() {
        return this.s;
    }

    public boolean s() {
        return this.v;
    }

    public boolean t() {
        return this.r;
    }

    public boolean u() {
        return this.x;
    }

    public boolean v() {
        return this.b;
    }

    public boolean w() {
        return this.f;
    }

    public boolean x() {
        return this.n;
    }

    public static final class b {
        public final String a;
        public final int b;
        public final String c;

        public b(String str, int i2, String str2) {
            this.a = str;
            this.b = i2;
            this.c = str2;
        }

        public static b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new b(jSONObject.optString("pn"), jSONObject.optInt(v.d, 0), jSONObject.optString("pk"));
        }

        public String toString() {
            return String.valueOf(a(this));
        }

        public static List<b> a(JSONArray jSONArray) {
            if (jSONArray == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                b a2 = a(jSONArray.optJSONObject(i2));
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
            return arrayList;
        }

        public static JSONObject a(b bVar) {
            if (bVar == null) {
                return null;
            }
            try {
                return new JSONObject().put("pn", bVar.a).put(v.d, bVar.b).put("pk", bVar.c);
            } catch (JSONException e) {
                e.a((Throwable) e);
                return null;
            }
        }

        public static JSONArray a(List<b> list) {
            if (list == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (b a2 : list) {
                jSONArray.put(a(a2));
            }
            return jSONArray;
        }
    }

    public JSONObject a() {
        return this.w;
    }

    public void a(boolean z2) {
        this.g = z2;
    }

    private void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                a(new JSONObject(str));
            } catch (Throwable th2) {
                e.a(th2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(com.alipay.sdk.m.s.a aVar) {
        try {
            JSONObject A2 = A();
            j.b(aVar, com.alipay.sdk.m.s.b.d().b(), Y, A2.toString());
        } catch (Exception e2) {
            e.a((Throwable) e2);
        }
    }

    /* access modifiers changed from: private */
    public void a(com.alipay.sdk.m.s.a aVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject optJSONObject = jSONObject.optJSONObject(b0);
                com.alipay.sdk.m.u.a.a(aVar, optJSONObject, com.alipay.sdk.m.u.a.a(aVar, jSONObject));
                if (optJSONObject != null) {
                    a(optJSONObject);
                } else {
                    e.e(A, "empty config");
                }
            } catch (Throwable th2) {
                e.a(th2);
            }
        }
    }

    private void a(JSONObject jSONObject) {
        this.a = jSONObject.optInt(Z, 10000);
        this.b = jSONObject.optBoolean(a0, false);
        this.c = jSONObject.optString(c0, C).trim();
        this.d = jSONObject.optInt(e0, 10);
        this.y = b.a(jSONObject.optJSONArray(d0));
        this.e = jSONObject.optBoolean(u0, true);
        this.h = jSONObject.optBoolean(f0, false);
        this.f669i = jSONObject.optBoolean(g0, true);
        this.j = jSONObject.optBoolean(h0, true);
        this.k = jSONObject.optBoolean(i0, false);
        this.l = jSONObject.optBoolean(j0, false);
        this.m = jSONObject.optBoolean(k0, false);
        this.n = jSONObject.optBoolean(l0, false);
        this.f670o = jSONObject.optBoolean(m0, true);
        this.p = jSONObject.optString(n0, "");
        this.t = jSONObject.optBoolean(o0, false);
        this.v = jSONObject.optBoolean(s0, false);
        this.q = jSONObject.optString(v0, "");
        this.u = jSONObject.optInt(q0, 1000);
        this.x = jSONObject.optBoolean(r0, true);
        this.r = jSONObject.optBoolean(w0, false);
        this.s = jSONObject.optBoolean(x0, false);
        this.f = jSONObject.optBoolean(t0, false);
        this.w = jSONObject.optJSONObject(com.alipay.sdk.m.u.a.b);
    }

    public void a(com.alipay.sdk.m.s.a aVar, Context context, boolean z2, int i2) {
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "oncfg|" + z2 + "|" + i2);
        C0011a aVar2 = new C0011a(aVar, context, z2, i2);
        if (!z2 || n.h()) {
            Thread thread = new Thread(aVar2);
            thread.setName("AlipayDCP");
            thread.start();
            return;
        }
        int y2 = y();
        if (!n.a((long) y2, (Runnable) aVar2, "AlipayDCPBlok")) {
            com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.m0, "" + y2);
        }
    }

    public boolean a(Context context, int i2) {
        if (this.z == -1) {
            this.z = n.a();
            j.b(com.alipay.sdk.m.s.a.h(), context, p0, String.valueOf(this.z));
        }
        return this.z < i2;
    }
}
