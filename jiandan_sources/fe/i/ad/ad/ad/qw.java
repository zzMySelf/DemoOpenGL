package fe.i.ad.ad.ad;

import android.content.Context;
import android.text.TextUtils;
import com.dxmpay.wallet.core.domain.a;
import com.dxmpay.wallet.core.lollipop.json.JSONException;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse;
import java.util.regex.Pattern;

public class qw implements a {

    /* renamed from: de  reason: collision with root package name */
    public static final Pattern f4443de = Pattern.compile("^https://.*\\.com");

    /* renamed from: ad  reason: collision with root package name */
    public Context f4444ad;
    public String qw;

    public String getAppHost() {
        return TextUtils.isEmpty(this.qw) ? "https://app.duxiaoman.com" : this.qw;
    }

    public String getAppPayHost() {
        if (this.f4444ad == null) {
            return "https://www.dxmpay.com";
        }
        String appPayHost = SdkInitResponse.getInstance().getAppPayHost(this.f4444ad);
        if (TextUtils.isEmpty(appPayHost)) {
            return "https://www.dxmpay.com";
        }
        return appPayHost;
    }

    public String getBackSensorHost() {
        if (this.f4444ad == null) {
            return "https://datasink.paydxm.com";
        }
        String backSensorHost = SdkInitResponse.getInstance().getBackSensorHost(this.f4444ad);
        if (TextUtils.isEmpty(backSensorHost)) {
            return "https://datasink.paydxm.com";
        }
        return backSensorHost;
    }

    public String getInitHost() {
        return "https://www.dxmpay.com";
    }

    public String getRecordHost() {
        if (this.f4444ad == null) {
            return "https://ai.dxmpay.com";
        }
        String recordHost = SdkInitResponse.getInstance().getRecordHost(this.f4444ad);
        if (TextUtils.isEmpty(recordHost)) {
            return "https://ai.dxmpay.com";
        }
        return recordHost;
    }

    public String getRtcHost() {
        if (this.f4444ad == null) {
            return "wss://ai.dxmpay.com";
        }
        String rtcHost = SdkInitResponse.getInstance().getRtcHost(this.f4444ad);
        if (TextUtils.isEmpty(rtcHost)) {
            return "wss://ai.dxmpay.com";
        }
        return rtcHost;
    }

    public String getSensortHost() {
        if (this.f4444ad == null) {
            return "https://datasink.dxmpay.com";
        }
        String sensorHost = SdkInitResponse.getInstance().getSensorHost(this.f4444ad);
        if (TextUtils.isEmpty(sensorHost)) {
            return "https://datasink.dxmpay.com";
        }
        return sensorHost;
    }

    public String getSpareInitHost() {
        return "https://www.paydxm.com";
    }

    public String getZhiFuHost() {
        if (this.f4444ad == null) {
            return "https://zhifu.dxmjuhe.com";
        }
        String polymerHost = SdkInitResponse.getInstance().getPolymerHost(this.f4444ad);
        if (TextUtils.isEmpty(polymerHost)) {
            return "https://zhifu.dxmjuhe.com";
        }
        return polymerHost;
    }

    public void setDomainConfig(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String optString = new JSONObject(str).optString("app_host");
                if (TextUtils.isEmpty(optString) || !f4443de.matcher(optString).matches()) {
                    this.qw = "";
                    fe.i.qw.de.qw.i().yj("https://app.duxiaoman.com");
                    return;
                }
                this.qw = optString;
                fe.i.qw.de.qw.i().yj(this.qw);
            } catch (JSONException e) {
                LogUtil.e("OnlineDomainStrategy", e.getMessage(), e);
            }
        }
    }

    public void setDxmPayContext(Context context) {
        this.f4444ad = context;
    }
}
