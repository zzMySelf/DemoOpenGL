package fe.i.ad.ad.ad;

import android.content.Context;
import android.text.TextUtils;
import com.dxmpay.wallet.core.domain.a;
import com.dxmpay.wallet.core.lollipop.json.JSONException;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.core.utils.LogUtil;
import fe.i.qw.de.qw;

public class ad implements a {

    /* renamed from: uk  reason: collision with root package name */
    public static ad f4436uk;

    /* renamed from: ad  reason: collision with root package name */
    public String f4437ad;

    /* renamed from: de  reason: collision with root package name */
    public String f4438de;

    /* renamed from: fe  reason: collision with root package name */
    public String f4439fe;
    public String qw;

    /* renamed from: rg  reason: collision with root package name */
    public String f4440rg;

    /* renamed from: th  reason: collision with root package name */
    public String f4441th;

    /* renamed from: yj  reason: collision with root package name */
    public String f4442yj;

    public static ad qw() {
        if (f4436uk == null) {
            f4436uk = new ad();
        }
        return f4436uk;
    }

    public void ad(String str) {
        this.qw = str;
    }

    public void de(String str) {
        this.f4437ad = str;
    }

    public void fe(String str) {
        this.f4438de = str;
    }

    public String getAppHost() {
        return TextUtils.isEmpty(this.qw) ? "https://app.duxiaoman.com" : this.qw;
    }

    public String getAppPayHost() {
        return TextUtils.isEmpty(this.f4437ad) ? "https://www.dxmpay.com" : this.f4437ad;
    }

    public String getBackSensorHost() {
        return TextUtils.isEmpty(this.f4442yj) ? "https://datasink.paydxm.com" : this.f4442yj;
    }

    public String getInitHost() {
        return getAppPayHost();
    }

    public String getRecordHost() {
        return TextUtils.isEmpty(this.f4440rg) ? "https://ai.dxmpay.com" : this.f4440rg;
    }

    public String getRtcHost() {
        return TextUtils.isEmpty(this.f4439fe) ? "wss://ai.dxmpay.com" : this.f4439fe;
    }

    public String getSensortHost() {
        return TextUtils.isEmpty(this.f4442yj) ? "https://datasink.dxmpay.com" : this.f4442yj;
    }

    public String getSpareInitHost() {
        return TextUtils.isEmpty(this.f4441th) ? "https://www.dxmpay.com" : this.f4441th;
    }

    public String getZhiFuHost() {
        return TextUtils.isEmpty(this.f4438de) ? "https://zhifu.dxmjuhe.com" : this.f4438de;
    }

    public void rg(String str) {
        this.f4439fe = str;
    }

    public void setDomainConfig(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String optString = new JSONObject(str).optString("app_host");
                if (TextUtils.isEmpty(optString) || !qw.f4443de.matcher(optString).matches()) {
                    this.qw = "https://app.duxiaoman.com";
                } else {
                    this.qw = optString;
                }
                qw.i().yj(this.qw);
            } catch (JSONException e) {
                LogUtil.e("QADomainStrategy", e.getMessage(), e);
            }
        }
    }

    public void setDxmPayContext(Context context) {
    }

    public void th(String str) {
        this.f4441th = str;
    }

    public void uk(String str) {
        this.f4442yj = str;
    }

    public void yj(String str) {
        this.f4440rg = str;
    }
}
