package fe.fe.ddd.pf.qw.ad;

import android.text.TextUtils;
import org.json.JSONObject;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public String f1527ad;

    /* renamed from: de  reason: collision with root package name */
    public JSONObject f1528de;
    public String qw;

    /* renamed from: fe.fe.ddd.pf.qw.ad.qw$qw  reason: collision with other inner class name */
    public static class C0082qw {

        /* renamed from: ad  reason: collision with root package name */
        public String f1529ad;

        /* renamed from: de  reason: collision with root package name */
        public JSONObject f1530de;
        public String qw = "active";

        public C0082qw(String str) {
            this.f1529ad = str;
        }

        public qw fe() {
            return new qw(this);
        }

        public C0082qw rg(JSONObject jSONObject) {
            this.f1530de = jSONObject;
            return this;
        }

        public C0082qw th(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.qw = str;
            }
            return this;
        }
    }

    public qw(C0082qw qwVar) {
        this.qw = qwVar.qw;
        this.f1527ad = qwVar.f1529ad;
        this.f1528de = qwVar.f1530de;
    }

    public JSONObject ad() {
        return this.f1528de;
    }

    public String de() {
        return this.qw;
    }

    public String qw() {
        return this.f1527ad;
    }
}
