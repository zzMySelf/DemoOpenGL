package com.dxmpay.wallet.statistics.impl;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.heartbeat.a;
import com.baidu.wallet.api.BaiduWallet;
import com.duxiaoman.dxmpay.statistics.internal.IStatConfig;
import com.dxmpay.apollon.ApollonConstants;
import com.dxmpay.apollon.NoProguard;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.apollon.restnet.RestRuntimeException;
import com.dxmpay.apollon.restnet.RestTemplate;
import com.dxmpay.apollon.restnet.converter.StringHttpMessageConverter;
import com.dxmpay.apollon.restnet.rest.RestHttpRequestInterceptor;
import com.dxmpay.apollon.restnet.rest.d;
import com.dxmpay.apollon.utils.PhoneUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.core.utils.UAFilterUtil;
import com.dxmpay.wallet.paysdk.PayUtils;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class StatConfig implements IStatConfig, NoProguard {

    /* renamed from: ad  reason: collision with root package name */
    public Context f4365ad;

    public static final class ad {
        public static StatConfig qw = new StatConfig((qw) null);
    }

    public class qw implements RestHttpRequestInterceptor {
        public qw(StatConfig statConfig) {
        }

        public void qw(Context context, d dVar) {
            dVar.a().rg("Accept-Encoding", "gzip");
        }
    }

    public /* synthetic */ StatConfig(qw qwVar) {
        this();
    }

    public static StatConfig getInstance(Context context) {
        ad.qw.setContext(context);
        return ad.qw;
    }

    public String getAppVersionCode() {
        return String.valueOf(PhoneUtils.getAppVersionCode(this.f4365ad));
    }

    public String getAppVersionName() {
        return PhoneUtils.getAppVersionName(this.f4365ad);
    }

    public String getBackUploadUrl() {
        return DomainConfig.getInstance().getBackSensorHost() + "/sensors_batch/v2";
    }

    public String getChannelId() {
        return BeanConstants.CHANNEL_ID;
    }

    public String getCommonEvent() {
        return "DXMPaySDK";
    }

    public String getDistinctId() {
        if (isLogin()) {
            String unionId = WalletLoginHelper.getInstance().getUnionId();
            if (!TextUtils.isEmpty(unionId)) {
                return SecurePay.getInstance().encryptProxy(unionId);
            }
            String dxmDid = PayUtils.getDxmDid(this.f4365ad);
            if (!TextUtils.isEmpty(dxmDid)) {
                return SecurePay.getInstance().encryptProxy(dxmDid);
            }
        }
        return SecurePay.getInstance().encryptProxy(fe.i.ad.th.qw.qw.qw().de(this.f4365ad));
    }

    public String getDistinctIdKey() {
        return SecurePay.getInstance().getpwProxy();
    }

    public String getHeader() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f4365ad != null) {
                fe.i.ad.th.qw.qw qw2 = fe.i.ad.th.qw.qw.qw();
                jSONObject.putOpt("ua", qw2.fe(this.f4365ad));
                jSONObject.putOpt("cu", qw2.ad(this.f4365ad));
                jSONObject.putOpt("op", qw2.rg(this.f4365ad));
                jSONObject.put("cu2", qw2.de(this.f4365ad));
            }
        } catch (JSONException e) {
            LogUtil.e("StatConfig", e.getMessage(), e);
        }
        return jSONObject.toString();
    }

    public String getProductName() {
        return BaiduWallet.TAG;
    }

    public String getSDKVersion() {
        return BeanConstants.VERSION_NO;
    }

    public String getUploadUrl() {
        return DomainConfig.getInstance().getSensortHost() + "/sensors_batch/v2";
    }

    public boolean isLogin() {
        return WalletLoginHelper.getInstance().isLogin();
    }

    public String loadDefaultStrategy() {
        return "{\"content\":{\"disable\":\"0\",\"3G\":\"5\",\"wifi\":\"3\",\"now\":[\"std_pay_success\",\"std_pay_failed\",\"percashier_pay_success\",\"percashier_pay_failed\",\"initiative_bind_card_failed\",\"initiative_bind_card_success\",\"lbs_pay_result_error\",\"lbs_pay_result_paying\",\"lbs_pay_result_cancel\",\"lbs_pay_result_success\",\"_endLivenessSDK\",\"endIDCard\"],\"never\":[]}}";
    }

    public String loadStrategy() {
        return qw(this.f4365ad, 0, DomainConfig.getInstance().getAppPayHost() + "/aif/sdk/category");
    }

    public final String qw(Context context, int i2, String str) {
        String str2;
        Class cls = String.class;
        RestTemplate restTemplate = new RestTemplate(context, UAFilterUtil.getInstance().getTrueUA(context), ApollonConstants.HTTP_REQUEST_TYPE_STASTICS_BEAN);
        ArrayList arrayList = new ArrayList();
        String fe2 = fe.i.ad.th.qw.qw.qw().fe(context);
        if (!TextUtils.isEmpty(fe2)) {
            arrayList.add(new RestNameValuePair("ua", fe2));
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new qw(this));
        restTemplate.setRequestInterceptor(arrayList2);
        restTemplate.setMessageConverter(new StringHttpMessageConverter());
        if (i2 == 0) {
            try {
                str2 = (String) restTemplate.getForObject(str, arrayList, a.h, cls);
            } catch (RestRuntimeException e) {
                LogUtil.e("StatConfig", e.getMessage(), e);
                return null;
            }
        } else {
            str2 = (String) restTemplate.postForObject(str, arrayList, a.h, cls);
        }
        return str2;
    }

    public void setContext(Context context) {
        if (this.f4365ad == null && context != null) {
            this.f4365ad = context.getApplicationContext();
        }
    }

    public StatConfig() {
    }
}
