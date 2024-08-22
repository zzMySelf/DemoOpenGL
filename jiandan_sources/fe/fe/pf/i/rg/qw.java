package fe.fe.pf.i.rg;

import android.text.TextUtils;
import com.baidu.helios.ids.BaseIdProvider;
import com.baidu.sofire.xclient.privacycontrol.lib.DeviceIdHelper;
import fe.fe.pf.yj.fe.de.ad;
import fe.fe.pf.yj.fe.de.rg;
import fe.fe.pf.yj.rg.qw;
import org.json.JSONObject;

public class qw extends BaseIdProvider {

    /* renamed from: fe  reason: collision with root package name */
    public qw.C0142qw f2807fe;

    /* renamed from: rg  reason: collision with root package name */
    public C0130qw f2808rg = new C0130qw();

    /* renamed from: fe.fe.pf.i.rg.qw$qw  reason: collision with other inner class name */
    public class C0130qw {

        /* renamed from: ad  reason: collision with root package name */
        public boolean f2809ad = true;

        /* renamed from: de  reason: collision with root package name */
        public rg f2810de = new rg();

        /* renamed from: fe  reason: collision with root package name */
        public String f2811fe;
        public long qw;

        /* renamed from: rg  reason: collision with root package name */
        public String f2812rg;

        public C0130qw() {
        }

        public String ad() {
            return this.f2811fe;
        }

        public boolean de() {
            if (this.f2809ad) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("form_id", this.f2811fe);
                    jSONObject.put("lst_fe_ts", this.qw);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f2810de.fe());
                    jSONObject.put("ssaid", this.f2812rg);
                    qw.this.f2807fe.i("cache.dat", jSONObject.toString(), true);
                    this.f2809ad = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public boolean fe() {
            String yj2 = qw.this.f2807fe.yj("cache.dat", true);
            if (TextUtils.isEmpty(yj2)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(yj2);
                this.f2811fe = jSONObject.optString("form_id");
                this.qw = jSONObject.getLong("lst_fe_ts");
                jSONObject.getInt("c_form_ver");
                this.f2812rg = jSONObject.getString("ssaid");
                this.f2810de.ad(jSONObject.getLong("flags"));
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public String qw() {
            return this.f2812rg;
        }

        public void rg(String str) {
            String str2 = this.f2812rg;
            if (str2 != str) {
                if (str == null || !str.equals(str2)) {
                    this.f2812rg = str;
                    this.f2809ad = true;
                }
            }
        }

        public void th(String str) {
            String str2 = this.f2811fe;
            if (str2 != str) {
                if (str == null || !str.equals(str2)) {
                    this.f2811fe = str;
                    this.f2809ad = true;
                }
            }
        }

        public void yj(long j) {
            if (this.qw != j) {
                this.qw = j;
                this.f2809ad = true;
            }
        }
    }

    static {
        boolean z = ad.qw;
    }

    public qw() {
        super("ssaid");
    }

    public String de() {
        return this.f2808rg.ad();
    }

    public void th(BaseIdProvider.de deVar) {
        String str;
        this.f2807fe = this.qw.th(rg());
        try {
            str = DeviceIdHelper.getStringFromSettingSecure(this.f813ad.qw.getContentResolver(), "android_id");
        } catch (Throwable unused) {
            str = null;
        }
        if (str == null) {
            str = "0";
        }
        this.f2808rg.fe();
        if (TextUtils.isEmpty(this.f2808rg.ad()) || !TextUtils.equals(str, this.f2808rg.qw())) {
            this.f2808rg.rg(str);
            try {
                this.f2808rg.th(BaseIdProvider.ad("A30", new ad("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).ad(str.getBytes("UTF-8"))));
            } catch (Exception unused2) {
            }
            this.f2808rg.yj(System.currentTimeMillis());
        }
        this.f2808rg.de();
    }
}
