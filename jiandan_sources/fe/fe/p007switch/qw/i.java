package fe.fe.p007switch.qw;

import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.ubc.UBCManager;
import com.dlife.ctaccountapi.t;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: fe.fe.switch.qw.i  reason: invalid package */
public class i {

    /* renamed from: ad  reason: collision with root package name */
    public volatile long f3030ad = 0;

    /* renamed from: de  reason: collision with root package name */
    public volatile long f3031de = 0;

    /* renamed from: fe  reason: collision with root package name */
    public volatile long f3032fe = 0;
    public volatile long qw = 0;

    /* renamed from: rg  reason: collision with root package name */
    public volatile long f3033rg = 0;

    /* renamed from: th  reason: collision with root package name */
    public volatile int f3034th = 0;

    /* renamed from: uk  reason: collision with root package name */
    public volatile JSONObject f3035uk = null;

    /* renamed from: yj  reason: collision with root package name */
    public List<qw> f3036yj = new ArrayList();

    /* renamed from: fe.fe.switch.qw.i$qw */
    public static class qw {

        /* renamed from: ad  reason: collision with root package name */
        public String f3037ad;

        /* renamed from: de  reason: collision with root package name */
        public long f3038de;

        /* renamed from: fe  reason: collision with root package name */
        public long f3039fe;
        public String qw;

        /* renamed from: rg  reason: collision with root package name */
        public boolean f3040rg;

        /* renamed from: th  reason: collision with root package name */
        public JSONObject f3041th;

        /* renamed from: yj  reason: collision with root package name */
        public boolean f3042yj;

        public String ad() {
            return this.f3037ad;
        }

        public long de() {
            return this.f3038de;
        }

        public long fe() {
            return this.f3039fe;
        }

        public String qw() {
            return this.qw;
        }

        public JSONObject th() {
            return this.f3041th;
        }

        public boolean yj() {
            return this.f3040rg;
        }
    }

    public static JSONObject ad(qw qwVar, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION, qwVar.qw());
            jSONObject.put("d", qwVar.de());
            long fe2 = qwVar.fe() - j;
            if (fe2 < 0) {
                fe2 = 0;
            }
            jSONObject.put("ps", fe2);
            jSONObject.put(t.a, qwVar.ad());
            int i2 = 1;
            jSONObject.put("at", qwVar.yj() ? 1 : 0);
            JSONObject th2 = qwVar.th();
            if (!(th2 == null || th2.length() == 0)) {
                jSONObject.put(UBCManager.CONTENT_KEY_EXT, th2);
            }
            if (!qwVar.f3042yj) {
                i2 = 0;
            }
            jSONObject.put("h5", i2);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public JSONObject de() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s", this.qw);
            jSONObject.put("e", this.f3030ad);
            jSONObject.put(com.cmic.sso.sdk.e.i.a, this.f3033rg);
            jSONObject.put("c", 1);
            jSONObject.put("s2", this.f3031de == 0 ? this.qw : this.f3031de);
            jSONObject.put("e2", this.f3032fe == 0 ? this.f3030ad : this.f3032fe);
            jSONObject.put(SapiUtils.QR_LOGIN_LP_PC, this.f3034th);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public long fe() {
        return this.qw;
    }

    public void i(long j) {
        if (this.qw <= 0) {
            this.qw = j;
            this.f3033rg = j;
        }
    }

    public void o(long j) {
        this.f3032fe = j;
    }

    public void pf(long j) {
        if (this.f3031de <= 0) {
            this.f3031de = j;
        }
    }

    public JSONObject qw() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s", this.qw);
            jSONObject.put("e", this.f3030ad);
            jSONObject.put(com.cmic.sso.sdk.e.i.a, this.f3033rg);
            jSONObject.put("c", 1);
            jSONObject.put("s2", this.f3031de == 0 ? this.qw : this.f3031de);
            jSONObject.put("e2", this.f3032fe == 0 ? this.f3030ad : this.f3032fe);
            jSONObject.put(SapiUtils.QR_LOGIN_LP_PC, this.f3034th);
            if (!(this.f3035uk == null || this.f3035uk.length() == 0)) {
                jSONObject.put("launch", this.f3035uk);
            }
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < this.f3036yj.size(); i2++) {
                jSONArray.put(ad(this.f3036yj.get(i2), this.qw));
            }
            jSONObject.put("p", jSONArray);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public boolean rg() {
        return this.f3030ad > 0;
    }

    public boolean th() {
        return this.qw > 0;
    }

    public String toString() {
        return qw().toString();
    }

    public void uk(long j) {
        this.f3030ad = j;
    }

    public void yj() {
        this.qw = 0;
        this.f3030ad = 0;
        this.f3031de = 0;
        this.f3032fe = 0;
        this.f3034th = 0;
        this.f3036yj.clear();
    }
}
