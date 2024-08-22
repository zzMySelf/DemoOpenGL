package com.baidu.sapi2.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.k.b;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiAccountService;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sofire.ac.FH;
import fe.fe.ppp.ad.ad;
import org.json.JSONException;
import org.json.JSONObject;

public class Security {
    public static String getZid(Context context, int i2) {
        String gzfi = FH.gzfi(context, (String) null, i2);
        return TextUtils.isEmpty(gzfi) ? "NoZidYet" : gzfi;
    }

    public static boolean isDefaultZid(String str) {
        return "NoZidYet".equals(str);
    }

    @TargetApi(8)
    public String encryptSsoHash(Long l, String str, String str2) {
        String str3;
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        String packageName = confignation.context.getPackageName();
        String packageSign = SapiUtils.getPackageSign(confignation.context, packageName);
        String packageSign2 = SapiUtils.getPackageSign(confignation.context, str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", SapiAccountService.DISPLAY_TYPE_NATIVE);
            jSONObject.put("timestamp", l);
            jSONObject.put("host_api_key", confignation.bdOauthAppId);
            jSONObject.put("host_pkgname", packageName);
            jSONObject.put("host_key_hash", packageSign);
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            if (currentAccount == null) {
                str3 = "";
            } else {
                str3 = currentAccount.bduss;
            }
            jSONObject.put("bduss_sign", ad.rg(str3.getBytes(), false));
            jSONObject.put("pkgname", str);
            jSONObject.put("key_hash", packageSign2);
            jSONObject.put(b.D0, str2);
        } catch (JSONException e) {
            Log.e(e);
        }
        String rg2 = ad.rg(("as#JU*342ns" + str2 + "#$FW34sfs").getBytes(), false);
        String substring = rg2.substring(0, 16);
        try {
            return ad.fe(ad.ad(jSONObject.toString(), new StringBuffer(rg2.substring(rg2.length() - 16, rg2.length())).reverse().toString(), substring));
        } catch (Exception e2) {
            Log.e(e2);
            return "";
        }
    }
}
