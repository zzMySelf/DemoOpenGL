package fe.fe.pf.th.qw;

import android.content.Context;
import com.baidu.sapi2.SapiAccount;
import fe.fe.pf.yj.rg.qw;
import org.json.JSONArray;
import org.json.JSONObject;

public class when implements i {
    public qw qw;

    public class qw {

        /* renamed from: ad  reason: collision with root package name */
        public qw.C0142qw f2939ad;

        /* renamed from: de  reason: collision with root package name */
        public boolean f2940de;

        /* renamed from: fe  reason: collision with root package name */
        public boolean f2941fe;

        /* renamed from: i  reason: collision with root package name */
        public long f2942i;
        public Context qw;

        /* renamed from: rg  reason: collision with root package name */
        public boolean f2943rg;

        /* renamed from: th  reason: collision with root package name */
        public long f2944th;

        /* renamed from: uk  reason: collision with root package name */
        public JSONObject f2945uk;

        /* renamed from: yj  reason: collision with root package name */
        public JSONObject f2946yj;

        public qw(when when, Context context) {
            if (context != null) {
                this.f2939ad = new fe.fe.pf.yj.rg.qw(context.getApplicationContext()).fe().th("cloud").th("cstore");
                return;
            }
            throw new NullPointerException("context should not be null");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002d, code lost:
            return r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x002f, code lost:
            return false;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized boolean ad() {
            /*
                r3 = this;
                monitor-enter(r3)
                r3.when()     // Catch:{ all -> 0x0030 }
                r3.ppp()     // Catch:{ all -> 0x0030 }
                android.content.Context r0 = r3.qw     // Catch:{ all -> 0x0030 }
                fe.fe.pf.ad r0 = fe.fe.pf.ad.th(r0)     // Catch:{ all -> 0x0030 }
                boolean r0 = r0.i()     // Catch:{ all -> 0x0030 }
                boolean r1 = r3.f2940de     // Catch:{ all -> 0x0030 }
                r2 = 0
                if (r1 == 0) goto L_0x002e
                if (r0 == 0) goto L_0x002e
                org.json.JSONObject r0 = r3.f2946yj     // Catch:{ all -> 0x0030 }
                r1 = 1
                if (r0 != 0) goto L_0x001f
                monitor-exit(r3)
                return r1
            L_0x001f:
                boolean r0 = r3.th()     // Catch:{ all -> 0x0030 }
                if (r0 != 0) goto L_0x002b
                boolean r0 = r3.rg()     // Catch:{ all -> 0x0030 }
                if (r0 == 0) goto L_0x002c
            L_0x002b:
                r2 = 1
            L_0x002c:
                monitor-exit(r3)
                return r2
            L_0x002e:
                monitor-exit(r3)
                return r2
            L_0x0030:
                r0 = move-exception
                monitor-exit(r3)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.fe.pf.th.qw.when.qw.ad():boolean");
        }

        public final boolean de(JSONObject jSONObject, JSONObject jSONObject2) {
            JSONArray jSONArray;
            JSONArray jSONArray2 = null;
            try {
                jSONArray = Cif.qw(jSONObject.optJSONArray("sids"), SapiAccount.ExtraProperty.EXTRA_PKG);
                try {
                    jSONArray2 = Cif.qw(jSONObject2.optJSONArray("sids"), SapiAccount.ExtraProperty.EXTRA_PKG);
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                jSONArray = null;
            }
            return when.de(jSONArray, jSONArray2) || Cif.ad(jSONObject, jSONObject2, "oid") || Cif.ad(jSONObject, jSONObject2, "gaid") || Cif.ad(jSONObject, jSONObject2, "iid") || Cif.ad(jSONObject, jSONObject2, "adrid") || Cif.ad(jSONObject, jSONObject2, "aid");
        }

        public void fe(JSONObject jSONObject) {
            this.f2946yj = jSONObject;
            pf();
        }

        public final void i() {
            try {
                JSONObject qw2 = Cswitch.qw(this.f2939ad.yj("ct.dat", true));
                if (qw2 == null) {
                    this.f2944th = 172800;
                } else {
                    this.f2944th = qw2.optLong("TIME_OUT", 172800);
                }
            } catch (Exception unused) {
                this.f2944th = 172800;
            }
        }

        /* renamed from: if  reason: not valid java name */
        public final boolean m203if() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isOn", this.f2940de);
                this.f2939ad.i("ci.dat", jSONObject.toString(), true);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public final void o() {
            try {
                JSONObject qw2 = Cswitch.qw(this.f2939ad.yj("ci.dat", true));
                if (qw2 == null) {
                    this.f2940de = true;
                } else {
                    this.f2940de = qw2.optBoolean("isOn", true);
                }
            } catch (Exception unused) {
                this.f2940de = true;
            }
        }

        public final boolean pf() {
            try {
                this.f2939ad.i("cs.dat", this.f2946yj.toString(), true);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public final void ppp() {
            uk();
            i();
            o();
        }

        public void qw(JSONObject jSONObject) {
            this.f2945uk = jSONObject;
        }

        public final synchronized boolean rg() {
            if (this.f2946yj == null) {
                return true;
            }
            if (this.f2945uk != null) {
                return de(this.f2946yj, this.f2945uk);
            }
            throw new IllegalArgumentException("you forgot invoke methond :IMatchConditions.setComparedCStoreParams before ");
        }

        /* renamed from: switch  reason: not valid java name */
        public final boolean m204switch() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("TIME_OUT", this.f2944th);
                this.f2939ad.i("ct.dat", jSONObject.toString(), true);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public final boolean th() {
            return Math.abs(System.currentTimeMillis() - this.f2942i) / 1000 > this.f2944th;
        }

        public final void uk() {
            try {
                this.f2946yj = Cswitch.qw(this.f2939ad.yj("cs.dat", true));
                this.f2942i = yj();
            } catch (Exception unused) {
                this.f2942i = 0;
            }
        }

        public final synchronized void when() {
            boolean z = true;
            if (this.f2941fe) {
                this.f2941fe = !m203if();
            }
            if (this.f2943rg) {
                if (m204switch()) {
                    z = false;
                }
                this.f2943rg = z;
            }
        }

        public final long yj() {
            JSONObject jSONObject = this.f2946yj;
            if (jSONObject == null) {
                return 0;
            }
            return jSONObject.optLong("ctime", 0);
        }
    }

    public when(Context context) {
        if (context == null) {
            throw new NullPointerException("context should not be null");
        } else if (this.qw == null) {
            this.qw = new qw(this, context.getApplicationContext());
        }
    }

    public static boolean de(JSONArray jSONArray, JSONArray jSONArray2) {
        int length = jSONArray == null ? 0 : jSONArray.length();
        if (length != (jSONArray2 == null ? 0 : jSONArray2.length())) {
            return true;
        }
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            JSONObject optJSONObject2 = jSONArray2.optJSONObject(i2);
            if (Cif.ad(optJSONObject, optJSONObject2, SapiAccount.ExtraProperty.EXTRA_PKG) || Cif.ad(optJSONObject, optJSONObject2, "aid") || Cif.de(optJSONObject, optJSONObject2, "priority")) {
                return true;
            }
        }
        return false;
    }

    public boolean a() {
        return this.qw.ad();
    }

    public i ad(JSONObject jSONObject) {
        this.qw.qw(jSONObject);
        return this;
    }

    public void qw(JSONObject jSONObject) {
        this.qw.fe(jSONObject);
    }
}
