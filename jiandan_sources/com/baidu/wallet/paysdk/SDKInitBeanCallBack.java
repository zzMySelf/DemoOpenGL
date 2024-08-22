package com.baidu.wallet.paysdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.heartbeat.a;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.wallet.core.DebugConfig;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.beans.SdkInitBean;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SDKInitBeanCallBack implements IBeanResponseCallback {
    public static int b;
    public Context a;

    public SDKInitBeanCallBack(Context context) {
        this.a = context;
    }

    public static Map<String, Set<String>> a(String str) throws JSONException {
        HashMap hashMap = new HashMap();
        JSONArray jSONArray = new JSONArray(str);
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            JSONArray jSONArray2 = jSONObject.getJSONArray("pin-sha256");
            JSONArray jSONArray3 = jSONObject.getJSONArray("domains");
            hashSet.clear();
            for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                hashSet.add(jSONArray2.getString(i3));
            }
            for (int i4 = 0; i4 < jSONArray3.length(); i4++) {
                hashMap.put(jSONArray3.getString(i4), hashSet);
            }
        }
        return hashMap;
    }

    public static boolean checkIsJson(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            new JSONObject(str);
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void onBeanExecFailure(int i2, int i3, String str) {
    }

    public void onBeanExecSuccess(int i2, Object obj, String str) {
        if (obj instanceof SdkInitResponse) {
            SdkInitResponse sdkInitResponse = (SdkInitResponse) obj;
            SdkInitBean.setContentSignForReq(sdkInitResponse.sign);
            if (DebugConfig.getInstance().isOnline()) {
                if (checkIsJson(sdkInitResponse.rtcConfig)) {
                    DomainConfig.getInstance().setRtcStrategy(DomainConfig.DomainStrategyType.ONLINE, sdkInitResponse.rtcConfig);
                    SharedPreferencesUtils.setParam(DxmApplicationContextImpl.getApplicationContext(this.a), BeanConstants.DOMAIN_CONFIG_NAME_ONLINE, BeanConstants.RTC_DOMAIN_CONFIG_KEY, sdkInitResponse.rtcConfig);
                }
                if (checkIsJson(sdkInitResponse.domainConfig)) {
                    DomainConfig.getInstance().setStrategy(DomainConfig.DomainStrategyType.ONLINE, sdkInitResponse.domainConfig);
                    SharedPreferencesUtils.setParam(DxmApplicationContextImpl.getApplicationContext(this.a), BeanConstants.DOMAIN_CONFIG_NAME_ONLINE, "wallet_sdk_domain_config_key", sdkInitResponse.domainConfig);
                }
                if (checkIsJson(sdkInitResponse.appDomainConfig)) {
                    a.c().a(sdkInitResponse.appDomainConfig);
                    SharedPreferencesUtils.setParam(DxmApplicationContextImpl.getApplicationContext(this.a), BeanConstants.DOMAIN_CONFIG_NAME_ONLINE, BeanConstants.DOMAIN_CONFIG_KEY_FOR_APP, sdkInitResponse.appDomainConfig);
                }
            } else {
                if (checkIsJson(sdkInitResponse.rtcConfig)) {
                    DomainConfig.getInstance().setRtcStrategy(DomainConfig.DomainStrategyType.QA, sdkInitResponse.rtcConfig);
                    SharedPreferencesUtils.setParam(DxmApplicationContextImpl.getApplicationContext(this.a), BeanConstants.DOMAIN_CONFIG_NAME_QA, BeanConstants.RTC_DOMAIN_CONFIG_KEY, sdkInitResponse.rtcConfig);
                }
                if (checkIsJson(sdkInitResponse.domainConfig)) {
                    DomainConfig.getInstance().setStrategy(DomainConfig.DomainStrategyType.QA, sdkInitResponse.domainConfig);
                    SharedPreferencesUtils.setParam(DxmApplicationContextImpl.getApplicationContext(this.a), BeanConstants.DOMAIN_CONFIG_NAME_QA, "wallet_sdk_domain_config_key", sdkInitResponse.domainConfig);
                }
                if (checkIsJson(sdkInitResponse.appDomainConfig)) {
                    a.c().a(sdkInitResponse.appDomainConfig);
                    SharedPreferencesUtils.setParam(DxmApplicationContextImpl.getApplicationContext(this.a), BeanConstants.DOMAIN_CONFIG_NAME_QA, BeanConstants.DOMAIN_CONFIG_KEY_FOR_APP, sdkInitResponse.appDomainConfig);
                }
            }
            if (!TextUtils.isEmpty(sdkInitResponse.publicKeyPins)) {
                try {
                    Map<String, Set<String>> a2 = a(sdkInitResponse.publicKeyPins);
                    com.baidu.apollon.b.a.a().b();
                    for (String next : a2.keySet()) {
                        com.baidu.apollon.b.a.a().a(next, a2.get(next));
                    }
                } catch (JSONException unused) {
                }
            }
        }
    }
}
