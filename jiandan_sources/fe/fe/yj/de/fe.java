package fe.fe.yj.de;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.sapi2.activity.BindVerifyActivity;
import com.baidu.searchbox.common.security.DeviceInfoManager;
import com.baidu.util.Base64Encoder;
import fe.fe.ddd.i.qw.qw;

public class fe {

    /* renamed from: ad  reason: collision with root package name */
    public String f3204ad;

    /* renamed from: de  reason: collision with root package name */
    public String f3205de;

    /* renamed from: fe  reason: collision with root package name */
    public String f3206fe;
    public String qw;

    /* renamed from: rg  reason: collision with root package name */
    public String f3207rg;

    /* renamed from: th  reason: collision with root package name */
    public String f3208th;

    /* renamed from: yj  reason: collision with root package name */
    public boolean f3209yj;

    public fe() {
        yj();
    }

    public String ad() {
        if (TextUtils.isEmpty(this.f3207rg)) {
            i();
        }
        return this.f3207rg;
    }

    public String de() {
        return this.f3204ad;
    }

    public String fe() {
        return this.qw;
    }

    public final void i() {
        this.f3207rg = new String(Base64Encoder.qw(this.f3206fe.getBytes()));
    }

    public boolean o() {
        if (this.f3209yj) {
            return false;
        }
        boolean pf2 = pf();
        this.f3209yj = pf2;
        if (!pf2) {
            qw.ad().yj(new yj(1));
        }
        return !this.f3209yj;
    }

    public final boolean pf() {
        return DeviceInfoManager.qw.mmm(qw.qw(), "pub_param", "", BindVerifyActivity.E).isSync(BindVerifyActivity.E);
    }

    public String qw() {
        return this.f3206fe;
    }

    public String rg() {
        return this.f3205de;
    }

    public String th() {
        return this.f3208th;
    }

    public final String uk() {
        String str = this.qw;
        String str2 = this.f3205de;
        String str3 = this.f3204ad;
        return str + "_" + str2 + "_" + this.f3208th + "_" + str3;
    }

    public final void yj() {
        DeviceInfoManager.qw.mmm(qw.qw(), "pub_param", "", BindVerifyActivity.E);
        String str = DeviceInfoManager.qw.b("pub_param", "").deviceId;
        this.qw = str;
        if (TextUtils.isEmpty(str)) {
            this.qw = "NUL";
        } else {
            this.qw = this.qw.replace("_", "-");
        }
        String str2 = DeviceInfoManager.qw.a("param", "pub_param").deviceId;
        this.f3204ad = str2;
        if (TextUtils.isEmpty(str2)) {
            this.f3204ad = "NUL";
        } else {
            this.f3204ad = this.f3204ad.replace("_", "-");
        }
        String str3 = DeviceInfoManager.qw.f("param", "pub_param").deviceId;
        this.f3205de = str3;
        if (TextUtils.isEmpty(str3)) {
            this.f3205de = "0.0";
        } else {
            this.f3205de = this.f3205de.replace("_", "-");
        }
        this.f3208th = String.valueOf(Build.VERSION.SDK_INT);
        this.f3206fe = uk();
    }
}
