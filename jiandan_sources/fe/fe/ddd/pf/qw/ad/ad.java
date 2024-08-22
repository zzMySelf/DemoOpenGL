package fe.fe.ddd.pf.qw.ad;

import android.text.TextUtils;
import org.json.JSONObject;

public class ad {

    /* renamed from: ad  reason: collision with root package name */
    public String f1517ad;

    /* renamed from: de  reason: collision with root package name */
    public String f1518de;

    /* renamed from: fe  reason: collision with root package name */
    public String f1519fe;
    public String qw;

    /* renamed from: rg  reason: collision with root package name */
    public String f1520rg;

    /* renamed from: th  reason: collision with root package name */
    public JSONObject f1521th;

    public static class qw {

        /* renamed from: ad  reason: collision with root package name */
        public String f1522ad = "";

        /* renamed from: de  reason: collision with root package name */
        public String f1523de = "";

        /* renamed from: fe  reason: collision with root package name */
        public String f1524fe = "";
        public String qw;

        /* renamed from: rg  reason: collision with root package name */
        public String f1525rg = "";

        /* renamed from: th  reason: collision with root package name */
        public JSONObject f1526th;

        public qw(String str) {
            this.qw = str;
        }

        public qw i(JSONObject jSONObject) {
            this.f1526th = jSONObject;
            return this;
        }

        /* renamed from: if  reason: not valid java name */
        public qw m72if(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.f1522ad = str;
            }
            return this;
        }

        public qw o(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.f1523de = str;
            }
            return this;
        }

        public qw pf(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.f1525rg = str;
            }
            return this;
        }

        public qw uk(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.f1524fe = str;
            }
            return this;
        }

        public ad yj() {
            return new ad(this);
        }
    }

    public ad(qw qwVar) {
        this.qw = qwVar.qw;
        this.f1517ad = qwVar.f1522ad;
        this.f1518de = qwVar.f1523de;
        this.f1519fe = qwVar.f1524fe;
        this.f1520rg = qwVar.f1525rg;
        this.f1521th = qwVar.f1526th;
    }

    public JSONObject ad() {
        return this.f1521th;
    }

    public String de() {
        return this.f1518de;
    }

    public String fe() {
        return this.f1520rg;
    }

    public String qw() {
        return this.f1519fe;
    }

    public String rg() {
        return this.f1517ad;
    }

    public String th() {
        return this.qw;
    }
}
