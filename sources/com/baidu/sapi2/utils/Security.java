package com.baidu.sapi2.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sofire.ac.FH;
import org.json.JSONException;
import org.json.JSONObject;

public class Security {
    public String encryptSsoHash(Long timestamp, String callingPkg, String callingAppId) {
        SapiConfiguration configuration = SapiAccountManager.getInstance().getConfignation();
        String hostPkg = configuration.context.getPackageName();
        String hostSign = SapiUtils.getPackageSign(configuration.context, hostPkg);
        String callingSign = SapiUtils.getPackageSign(configuration.context, callingPkg);
        JSONObject json = new JSONObject();
        try {
            json.put("type", "native");
            json.put("timestamp", timestamp);
            json.put("host_api_key", configuration.bdOauthAppId);
            json.put("host_pkgname", hostPkg);
            json.put("host_key_hash", hostSign);
            SapiAccount sapiAccount = SapiContext.getInstance().getCurrentAccount();
            json.put("bduss_sign", SecurityUtil.md5((sapiAccount == null ? "" : sapiAccount.bduss).getBytes(), false));
            json.put("pkgname", callingPkg);
            json.put("key_hash", callingSign);
            json.put("app_id", callingAppId);
        } catch (JSONException e2) {
            Log.e(e2);
        }
        String keySeed = SecurityUtil.md5(("as#JU*342ns" + callingAppId + "#$FW34sfs").getBytes(), false);
        try {
            return SecurityUtil.base64Encode(SecurityUtil.aesEncrypt(json.toString(), new StringBuffer(keySeed.substring(keySeed.length() - 16, keySeed.length())).reverse().toString(), keySeed.substring(0, 16)));
        } catch (Exception e3) {
            Log.e(e3);
            return "";
        }
    }

    public static String getZid(Context context, int callEnv) {
        String zid = FH.gzfi(context, (String) null, callEnv);
        return TextUtils.isEmpty(zid) ? "NoZidYet" : zid;
    }

    public static boolean isDefaultZid(String zid) {
        return "NoZidYet".equals(zid);
    }
}
