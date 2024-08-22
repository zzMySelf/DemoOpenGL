package fe.fe.mmm;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.baidu.ubc.IUBCContext;
import com.baidu.wallet.core.beans.CometHttpRequestInterceptor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class i {
    public static volatile i ddd;

    /* renamed from: ad  reason: collision with root package name */
    public int f2034ad;

    /* renamed from: de  reason: collision with root package name */
    public int f2035de;

    /* renamed from: fe  reason: collision with root package name */
    public int f2036fe;
    public JSONObject ggg;

    /* renamed from: i  reason: collision with root package name */
    public int f2037i = 100;

    /* renamed from: if  reason: not valid java name */
    public int f50if = 60;

    /* renamed from: o  reason: collision with root package name */
    public boolean f2038o = false;

    /* renamed from: pf  reason: collision with root package name */
    public int f2039pf = 819200;
    public String ppp;
    public Context qw;

    /* renamed from: rg  reason: collision with root package name */
    public int f2040rg = 614400;

    /* renamed from: switch  reason: not valid java name */
    public long f51switch = 0;

    /* renamed from: th  reason: collision with root package name */
    public int f2041th = 153600;

    /* renamed from: uk  reason: collision with root package name */
    public int f2042uk = 614400;
    public uk vvv = new uk();
    public int when = 512;
    public h xxx = new h();

    /* renamed from: yj  reason: collision with root package name */
    public int f2043yj = 614400;

    public static i vvv() {
        if (ddd == null) {
            synchronized (yj.class) {
                if (ddd == null) {
                    ddd = new i();
                }
            }
        }
        return ddd;
    }

    public void A(List<Cswitch> list) {
        for (Cswitch next : list) {
            String fe2 = next.fe();
            if (!TextUtils.isEmpty(fe2)) {
                if (!next.mmm()) {
                    this.vvv.f2209ad.add(fe2);
                    this.vvv.f2216th.remove(fe2);
                } else {
                    this.vvv.f2209ad.remove(fe2);
                    this.vvv.f2216th.add(fe2);
                }
                if (next.vvv()) {
                    this.vvv.f2210de.add(fe2);
                    this.vvv.f2211fe.remove(fe2);
                } else {
                    this.vvv.f2210de.remove(fe2);
                    this.vvv.f2211fe.add(fe2);
                }
                if (next.m139switch()) {
                    this.vvv.f2215rg.add(fe2);
                } else {
                    this.vvv.f2215rg.remove(fe2);
                }
                if (next.ggg()) {
                    this.vvv.f2218yj.add(fe2);
                } else {
                    this.vvv.f2218yj.remove(fe2);
                }
                int uk2 = next.uk();
                if (uk2 < 1 || uk2 > 100) {
                    this.vvv.f2217uk.remove(fe2);
                } else {
                    this.vvv.f2217uk.put(fe2, Integer.valueOf(uk2));
                }
                String ad2 = next.ad();
                if (!TextUtils.isEmpty(ad2)) {
                    this.vvv.f2212i.put(fe2, ad2);
                } else {
                    this.vvv.f2212i.remove(fe2);
                }
                int rg2 = next.rg();
                int th2 = next.th();
                if (!(rg2 == 0 || th2 == 0)) {
                    this.vvv.f2213o.put(fe2, new ppp(fe2, th2, rg2));
                }
                if (next.ppp()) {
                    this.vvv.f2214pf.add(fe2);
                } else {
                    this.vvv.f2214pf.remove(fe2);
                }
                if (next.xxx()) {
                    this.vvv.f62if.add(fe2);
                } else {
                    this.vvv.f62if.remove(fe2);
                }
                int de2 = next.de();
                if (next.nn()) {
                    this.vvv.f63switch.put(fe2, Integer.valueOf(de2));
                } else {
                    this.vvv.f63switch.remove(fe2);
                }
                if (next.aaa()) {
                    this.vvv.when.remove(fe2);
                } else {
                    this.vvv.when.put(fe2, Integer.valueOf(next.pf()));
                }
                int yj2 = next.yj();
                if (yj2 != 2) {
                    this.vvv.ppp.put(fe2, Integer.valueOf(yj2));
                } else {
                    this.vvv.ppp.remove(fe2);
                }
                JSONArray qw2 = next.qw();
                if (qw2 == null || qw2.length() <= 0) {
                    this.vvv.ggg.remove(fe2);
                } else {
                    this.vvv.ggg.put(fe2, qw2);
                }
            }
        }
    }

    public void B(long j) {
        if (this.f51switch < j) {
            this.f51switch = j;
        }
    }

    public int a(String str) {
        Integer num;
        if (TextUtils.isEmpty(str) || !this.vvv.f2217uk.containsKey(str) || (num = this.vvv.f2217uk.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public int aaa() {
        return this.f2034ad;
    }

    public int ad(String str) {
        Integer num;
        if (!this.vvv.ppp.containsKey(str) || (num = this.vvv.ppp.get(str)) == null) {
            return 2;
        }
        return num.intValue();
    }

    public String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "0";
        }
        if (!this.vvv.f2214pf.contains(str) && !TextUtils.equals(str, "1876") && !TextUtils.equals(str, "2980")) {
            return "0";
        }
        return "1";
    }

    public int c() {
        return this.f2037i;
    }

    public int d(String str) {
        Integer num;
        if (!this.vvv.when.containsKey(str) || (num = this.vvv.when.get(str)) == null) {
            return -1;
        }
        return num.intValue();
    }

    public int ddd() {
        return this.f2042uk;
    }

    public boolean de(String str) {
        return this.vvv.f2218yj.contains(str);
    }

    public void e(rg rgVar, Context context) {
        this.qw = context;
        this.f2034ad = CometHttpRequestInterceptor.a;
        k qw2 = k.qw();
        this.f2035de = qw2.ad("ubc_data_expire_time", 604800000);
        this.f2036fe = qw2.ad("ubc_database_limit", 10000);
        rgVar.ppp().a(this.vvv);
        this.f2040rg = qw2.ad("ubc_launch_upload_max_limit", 614400);
        this.f2041th = qw2.ad("ubc_single_log_max_limit", 153600);
        this.f2043yj = qw2.ad("ubc_real_upload_max_limit", 614400);
        this.f2042uk = qw2.ad("ubc_non_real_upload_max_limit", 614400);
        this.f2037i = qw2.ad("ubc_upload_trigger_num", 100);
        this.f2038o = tt.pf().yj();
        this.f2039pf = tt.pf().th();
        this.f50if = tt.pf().qw();
        this.ppp = j.qw(this.qw);
    }

    public long eee() {
        return this.f51switch;
    }

    public boolean f() {
        IUBCContext iUBCContext = tt.m142if();
        if (iUBCContext != null) {
            return iUBCContext.de();
        }
        return false;
    }

    public boolean fe(String str) {
        if (!e.de().ad() && d(str) == 0) {
            return true;
        }
        return false;
    }

    public boolean g(String str) {
        HashMap<String, ppp> hashMap = this.vvv.f2213o;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return false;
        }
        return this.vvv.f2213o.get(str).qw();
    }

    public int ggg(String str) {
        Integer num;
        if (!this.vvv.f63switch.containsKey(str) || (num = this.vvv.f63switch.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public boolean h() {
        return this.vvv.qw.f2027ad;
    }

    public boolean i(String str) {
        if (this.vvv.f2209ad.contains(str)) {
            return false;
        }
        if (this.vvv.f2216th.contains(str)) {
            return true;
        }
        return this.vvv.qw.f2029fe;
    }

    /* renamed from: if  reason: not valid java name */
    public String m123if() {
        return this.ppp;
    }

    public boolean j() {
        return this.vvv.qw.f2029fe;
    }

    public boolean k() {
        return this.f2038o;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r2 = r1.vvv.f2213o.get(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean l(java.lang.String r2) {
        /*
            r1 = this;
            fe.fe.mmm.uk r0 = r1.vvv
            java.util.HashMap<java.lang.String, fe.fe.mmm.ppp> r0 = r0.f2213o
            if (r0 == 0) goto L_0x0020
            boolean r0 = r0.containsKey(r2)
            if (r0 == 0) goto L_0x0020
            fe.fe.mmm.uk r0 = r1.vvv
            java.util.HashMap<java.lang.String, fe.fe.mmm.ppp> r0 = r0.f2213o
            java.lang.Object r2 = r0.get(r2)
            fe.fe.mmm.ppp r2 = (fe.fe.mmm.ppp) r2
            if (r2 == 0) goto L_0x0020
            boolean r2 = r2.ad()
            if (r2 == 0) goto L_0x0020
            r2 = 1
            return r2
        L_0x0020:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.i.l(java.lang.String):boolean");
    }

    public boolean m(String str) {
        if (this.qw == null || !de(str) || n(this.qw)) {
            return true;
        }
        return false;
    }

    public int mmm() {
        return this.f2041th;
    }

    public boolean n(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public int nn() {
        return this.f2043yj;
    }

    public JSONObject o(String str) {
        Cif ifVar;
        if (TextUtils.isEmpty(str)) {
            return this.ggg;
        }
        JSONArray jSONArray = this.vvv.ggg.get(str);
        if (jSONArray == null) {
            return this.ggg;
        }
        int length = jSONArray.length();
        if (length == 0) {
            return this.ggg;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = this.ggg;
        if (jSONObject2 != null) {
            try {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String valueOf = String.valueOf(keys.next());
                    jSONObject.put(valueOf, this.ggg.get(valueOf));
                }
            } catch (Exception e) {
                if (tt.vvv()) {
                    e.printStackTrace();
                }
            }
        }
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (!(optJSONObject == null || optJSONObject.length() == 0)) {
                String optString = optJSONObject.optString("name");
                if (!TextUtils.isEmpty(optString) && (ifVar = this.vvv.vvv.get(optString)) != null) {
                    String ad2 = ifVar.ad();
                    if (!TextUtils.isEmpty(ad2)) {
                        try {
                            jSONObject.put(optString, ad2);
                        } catch (JSONException e2) {
                            if (tt.vvv()) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
        return jSONObject;
    }

    public boolean p(String str) {
        return this.vvv.f2210de.contains(str);
    }

    public String pf(String str) {
        return this.vvv.f2212i.containsKey(str) ? this.vvv.f2212i.get(str) : "";
    }

    public int ppp() {
        return this.vvv.qw.f2028de;
    }

    public void q(Cif ifVar) {
        int length;
        String qw2 = ifVar.qw();
        String ad2 = ifVar.ad();
        if (!TextUtils.isEmpty(qw2) && !TextUtils.isEmpty(ad2) && (length = ad2.length()) != 0 && length <= this.when) {
            if (ifVar.de()) {
                if (this.ggg == null) {
                    this.ggg = new JSONObject();
                }
                try {
                    this.ggg.put(ifVar.qw(), ifVar.ad());
                } catch (Exception e) {
                    if (tt.vvv()) {
                        e.printStackTrace();
                    }
                }
            } else {
                this.vvv.vvv.put(qw2, ifVar);
            }
        }
    }

    public HashSet<String> qqq() {
        return this.vvv.f2211fe;
    }

    public boolean qw(String str) {
        return this.vvv.f2215rg.contains(str);
    }

    public void r(int i2) {
        if (i2 >= 0 && this.when <= 1024) {
            this.when = i2;
        }
    }

    public boolean rg(String str) {
        if (!this.xxx.isUBCDebug() && !this.vvv.f2210de.contains(str)) {
            return this.vvv.qw.f2027ad;
        }
        return true;
    }

    public int rrr() {
        return this.f50if;
    }

    public void s(int i2) {
        if (i2 >= 604800000) {
            this.f2035de = i2;
            k.qw().rg("ubc_data_expire_time", i2);
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public int m124switch() {
        return this.f2035de;
    }

    public void t(int i2) {
        if (i2 >= 10000) {
            this.f2036fe = i2;
            k.qw().rg("ubc_database_limit", i2);
        }
    }

    public boolean th(String str) {
        return this.vvv.f62if.contains(str);
    }

    public int tt() {
        return this.f2039pf;
    }

    public void u(int i2) {
        if (i2 >= 153600) {
            this.f2040rg = i2;
            k.qw().rg("ubc_launch_upload_max_limit", i2);
        }
    }

    public boolean uk(String str) {
        if (!e.de().qw() && !f() && this.xxx.isUBCSample() && a(str) > 0 && new Random().nextInt(100) >= a(str)) {
            return true;
        }
        return false;
    }

    public void v(int i2) {
        if (i2 >= 153600) {
            this.f2042uk = i2;
            k.qw().rg("ubc_non_real_upload_max_limit", i2);
        }
    }

    public void w(int i2) {
        if (i2 >= 153600) {
            this.f2043yj = i2;
            k.qw().rg("ubc_real_upload_max_limit", i2);
        }
    }

    public int when() {
        return this.f2036fe;
    }

    public void x(int i2) {
        if (i2 >= 30720) {
            this.f2041th = i2;
            k.qw().rg("ubc_single_log_max_limit", i2);
        }
    }

    public int xxx() {
        return this.f2040rg;
    }

    public void y(int i2) {
        if (i2 >= 1) {
            if (this.f2038o) {
                this.f2034ad = this.f50if * 1000;
            } else {
                this.f2034ad = i2 * CometHttpRequestInterceptor.a;
            }
        }
    }

    public boolean yj(String str, int i2) {
        if (this.vvv.f2209ad.contains(str)) {
            return false;
        }
        if ((i2 & 16) != 0 || (i2 & 32) != 0) {
            return this.vvv.f2216th.contains(str);
        }
        if (this.vvv.f2216th.contains(str)) {
            return true;
        }
        return this.vvv.qw.qw;
    }

    public void z(int i2) {
        if (i2 > 0) {
            this.f2037i = i2;
            k.qw().rg("ubc_upload_trigger_num", i2);
        }
    }
}
