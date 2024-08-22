package com.dxmpay.wallet.core.beans;

import android.content.Context;
import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.apollon.restnet.rest.RestHttpRequestInterceptor;
import com.dxmpay.apollon.restnet.rest.d;
import com.dxmpay.apollon.restnet.rest.httpurlconnection.RestUrlConnectionRequest;
import com.dxmpay.apollon.utils.Base64Utils;
import com.dxmpay.apollon.utils.PhoneUtils;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.paysdk.PayUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class EbpayHttpRequestInterceptor implements RestHttpRequestInterceptor {
    public final String ad(List<RestNameValuePair> list, String str) {
        for (RestNameValuePair next : list) {
            if (str.equals(next.getName())) {
                return next.getValue();
            }
        }
        return null;
    }

    public void qw(Context context, d dVar) {
        "intercept. X_BAIDU_IE = " + dVar.d();
        dVar.a().rg("X_BAIDU_IE", dVar.d());
        dVar.a().rg("Accept-Encoding", "gzip");
        dVar.a().rg("Content-Type", ShareTarget.ENCODING_TYPE_URL_ENCODED);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(com.baidu.wallet.core.beans.EbpayHttpRequestInterceptor.PARAM_IMSI, "");
            jSONObject.put(com.baidu.wallet.core.beans.EbpayHttpRequestInterceptor.PARAM_MOBILE_IP, PayUtils.encrypt("phone_number", PhoneUtils.getIpInfo()));
            jSONObject.put("wloc", PayUtils.encrypt("phone_number", PhoneUtils.getGPSLocation(context)));
            jSONObject.put(com.baidu.wallet.core.beans.EbpayHttpRequestInterceptor.PARAM_SIM_SERIAL_NUM, "");
        } catch (JSONException e) {
            LogUtil.e(com.baidu.wallet.core.beans.EbpayHttpRequestInterceptor.TAG, e.getMessage(), e);
        }
        dVar.a().rg("wcp", new String(Base64Utils.encode(jSONObject.toString().getBytes())));
        List<RestNameValuePair> ad2 = ((RestUrlConnectionRequest) dVar).ad();
        if (ad2 != null && ad2.size() > 0) {
            String ad3 = ad(ad2, "session_id");
            if (!TextUtils.isEmpty(ad3)) {
                dVar.a().rg("session_id", ad3);
            }
            String ad4 = ad(ad2, "request_type");
            if (!TextUtils.isEmpty(ad4)) {
                dVar.a().rg("request_type", ad4);
            }
        }
    }
}
