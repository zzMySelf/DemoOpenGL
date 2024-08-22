package fe.fe.pf.i.de;

import android.text.TextUtils;
import com.baidu.helios.ids.BaseIdProvider;
import com.baidu.wallet.base.iddetect.UrlOcrConfig;
import fe.fe.pf.yj.fe.de.ad;
import fe.fe.pf.yj.fe.de.rg;
import fe.fe.pf.yj.rg.qw;
import java.util.UUID;
import org.json.JSONObject;

public class qw extends BaseIdProvider {

    /* renamed from: fe  reason: collision with root package name */
    public qw.C0142qw f2749fe;

    /* renamed from: rg  reason: collision with root package name */
    public C0124qw f2750rg = new C0124qw();

    /* renamed from: fe.fe.pf.i.de.qw$qw  reason: collision with other inner class name */
    public class C0124qw {

        /* renamed from: ad  reason: collision with root package name */
        public boolean f2751ad = true;

        /* renamed from: de  reason: collision with root package name */
        public rg f2752de = new rg();

        /* renamed from: fe  reason: collision with root package name */
        public String f2753fe;
        public long qw;

        /* renamed from: rg  reason: collision with root package name */
        public String f2754rg;

        public C0124qw() {
        }

        public void ad(String str) {
            String str2 = this.f2753fe;
            if (str2 != str) {
                if (str == null || !str.equals(str2)) {
                    this.f2753fe = str;
                    this.f2751ad = true;
                }
            }
        }

        public void de(long j) {
            if (this.qw != j) {
                this.qw = j;
                this.f2751ad = true;
            }
        }

        public void fe(String str) {
            String str2 = this.f2754rg;
            if (str2 != str) {
                if (str == null || !str.equals(str2)) {
                    this.f2754rg = str;
                    this.f2751ad = true;
                }
            }
        }

        public String qw() {
            return this.f2753fe;
        }

        public boolean rg() {
            String yj2 = qw.this.f2749fe.yj("cache.dat", true);
            if (TextUtils.isEmpty(yj2)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(yj2);
                this.f2753fe = jSONObject.optString("form_id");
                this.qw = jSONObject.getLong("lst_fe_ts");
                jSONObject.getInt("c_form_ver");
                this.f2754rg = jSONObject.getString(UrlOcrConfig.IdCardKey.UUID);
                this.f2752de.ad(jSONObject.getLong("flags"));
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public boolean th() {
            if (this.f2751ad) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("form_id", this.f2753fe);
                    jSONObject.put("lst_fe_ts", this.qw);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f2752de.fe());
                    jSONObject.put(UrlOcrConfig.IdCardKey.UUID, this.f2754rg);
                    qw.this.f2749fe.i("cache.dat", jSONObject.toString(), true);
                    this.f2751ad = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    public qw() {
        super("iid");
    }

    public String de() {
        return this.f2750rg.qw();
    }

    public void th(BaseIdProvider.de deVar) {
        this.f2749fe = this.qw.th(rg());
        this.f2750rg.rg();
        if (TextUtils.isEmpty(this.f2750rg.qw())) {
            String uuid = UUID.randomUUID().toString();
            this.f2750rg.fe(uuid);
            try {
                this.f2750rg.ad(BaseIdProvider.ad("A50", new ad("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).ad(uuid.getBytes("UTF-8"))));
            } catch (Exception unused) {
            }
            this.f2750rg.de(System.currentTimeMillis());
        }
        this.f2750rg.th();
    }
}
