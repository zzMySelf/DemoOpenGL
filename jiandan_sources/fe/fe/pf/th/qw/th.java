package fe.fe.pf.th.qw;

import android.content.Context;
import com.baidu.helios.clouds.cuidstore.ICstore;
import com.baidu.sapi2.SapiAccount;
import org.json.JSONObject;

public class th implements ICstore {

    /* renamed from: ad  reason: collision with root package name */
    public pf f2935ad = new ppp();

    /* renamed from: de  reason: collision with root package name */
    public yj f2936de = new fe();

    /* renamed from: fe  reason: collision with root package name */
    public JSONObject f2937fe;
    public uk qw = new rg();

    /* renamed from: rg  reason: collision with root package name */
    public Context f2938rg;

    public th(Context context) {
        if (this.f2937fe == null) {
            de(context);
        }
    }

    public final JSONObject ad() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            jSONObject.put("aid", this.qw.a(this.f2938rg));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            jSONObject.put("uid", this.f2936de.a(this.f2938rg));
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            jSONObject.put("adrid", this.f2935ad.c(this.f2938rg));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        try {
            jSONObject.put("network", this.f2935ad.d(this.f2938rg));
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        try {
            jSONObject.put(SapiAccount.ExtraProperty.EXTRA_PKG, this.f2935ad.b(this.f2938rg));
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        try {
            jSONObject.put("ctime", this.f2935ad.b());
        } catch (Exception e7) {
            e7.printStackTrace();
        }
        try {
            jSONObject.put("ua", this.f2935ad.a(this.f2938rg));
        } catch (Exception e8) {
            e8.printStackTrace();
        }
        try {
            jSONObject.put("ut", this.f2935ad.a());
        } catch (Exception e9) {
            e9.printStackTrace();
        }
        try {
            jSONObject.put("iid", this.qw.e(this.f2938rg));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        try {
            jSONObject.put("sids", this.qw.b(this.f2938rg));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        try {
            jSONObject.put("oid", this.qw.c(this.f2938rg));
        } catch (Exception e12) {
            e12.printStackTrace();
        }
        try {
            jSONObject.put("gaid", this.qw.d(this.f2938rg));
        } catch (Exception e13) {
            e13.printStackTrace();
        }
        try {
            jSONObject.put("cver", this.qw.a());
        } catch (Exception e14) {
            e14.printStackTrace();
        }
        try {
            jSONObject.put("sappinfos", this.qw.f(this.f2938rg).toString());
        } catch (Exception e15) {
            e15.printStackTrace();
        }
        try {
            jSONObject.put("cstoreext", this.qw.qw(this.f2938rg).toString());
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return jSONObject;
    }

    public final void de(Context context) {
        if (context != null) {
            if (this.f2938rg == null) {
                this.f2938rg = context.getApplicationContext();
            }
            this.f2937fe = ad();
            return;
        }
        throw new NullPointerException("ctx should not be null");
    }

    public JSONObject qw() {
        if (this.f2937fe == null) {
            de(this.f2938rg);
        }
        return this.f2937fe;
    }
}
