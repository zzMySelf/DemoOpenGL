package com.baidu.wallet.core.beans;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.baidu.apollon.restnet.rest.RestHttpRequestInterceptor;
import com.baidu.apollon.restnet.rest.d;
import com.baidu.apollon.utils.Base64Utils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.PayUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class EbpayHttpRequestInterceptor implements RestHttpRequestInterceptor {
    public static final String PARAM_CUID = "cuid_1";
    public static final String PARAM_IMSI = "wims";
    public static final String PARAM_LOCATION = "wloc";
    public static final String PARAM_MOBILE_IP = "wmip";
    public static final String PARAM_SIM_SERIAL_NUM = "wssn";
    public static final String TAG = "EbpayClientHttpRequestInterceptor";

    private void setToken(StringBuffer stringBuffer) {
        stringBuffer.append(BeanConstants.COOKIE_OPENBDUSS);
        stringBuffer.append("=");
        stringBuffer.append(WalletLoginHelper.getInstance().getOpenLoginToken());
        LogUtil.d(TAG, "setToken():" + stringBuffer);
    }

    public void intercept(Context context, d dVar) {
        StringBuffer stringBuffer = new StringBuffer();
        setToken(stringBuffer);
        if (!TextUtils.isEmpty(AccountManager.getInstance(context).getBfbToken())) {
            stringBuffer.append(i.b);
            stringBuffer.append("token=");
            stringBuffer.append(AccountManager.getInstance(context).getBfbToken());
        }
        dVar.a().a("Cookie", stringBuffer.toString());
        LogUtil.i(TAG, "intercept. X_BAIDU_IE = " + dVar.e());
        dVar.a().a("X_BAIDU_IE", dVar.e());
        dVar.a().a("Accept-Encoding", "gzip");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PARAM_IMSI, "");
            jSONObject.put(PARAM_MOBILE_IP, PayUtils.encrypt("phone_number", PhoneUtils.getIpInfo()));
            jSONObject.put(PARAM_SIM_SERIAL_NUM, "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        dVar.a().a("wcp", new String(Base64Utils.encode(jSONObject.toString().getBytes())));
    }
}
