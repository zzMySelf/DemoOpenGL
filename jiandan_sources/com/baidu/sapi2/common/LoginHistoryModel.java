package com.baidu.sapi2.common;

import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.utils.SyncAccountUtils;
import com.baidu.wallet.api.IWalletLoginListener;
import org.json.JSONObject;

public class LoginHistoryModel implements NoProguard {
    public String bduss;
    public String displayname;
    public String loginType;
    public String portrait;
    public String portraitSign;
    public boolean recent;
    public String uid;
    public String username;

    public static LoginHistoryModel fromJSONObject(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        LoginHistoryModel loginHistoryModel = new LoginHistoryModel();
        loginHistoryModel.uid = jSONObject.optString("uid");
        loginHistoryModel.displayname = jSONObject.optString("displayname");
        loginHistoryModel.username = jSONObject.optString("username");
        loginHistoryModel.portrait = jSONObject.optString(SapiAccount.SAPI_ACCOUNT_PORTRAIT);
        loginHistoryModel.portraitSign = jSONObject.optString(SyncAccountUtils.KEY_PORTRAIT_SIGN);
        loginHistoryModel.recent = jSONObject.optBoolean("recent");
        loginHistoryModel.loginType = jSONObject.optString(IWalletLoginListener.KEY_LOGIN_TYPE);
        loginHistoryModel.bduss = jSONObject.optString("bduss");
        return loginHistoryModel;
    }
}
