package com.baidu.sapi2.result;

import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.utils.Log;
import com.google.android.gms.common.Scopes;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONException;
import org.json.JSONObject;

public class OAuthResult extends SapiResult {
    public static final String ERROR_MSG_UNKNOWN = "授权失败";
    public static final String RESULT_MSG_SUCCESS = "授权成功";
    public static final String TAG = "OAuthResult";
    public String accessToken;
    public int expiresIn;
    public String extra;
    public String openid;
    public String refreshToken;
    public String scope;
    public String sessionKey;
    public String sessionSecret;

    public OAuthResult() {
        this.msgMap.put(0, RESULT_MSG_SUCCESS);
        this.msgMap.put(-202, ERROR_MSG_UNKNOWN);
    }

    public static JSONObject oauthResult2Json(OAuthResult oAuthResult) {
        if (oAuthResult == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("access_token", oAuthResult.accessToken);
            jSONObject.put("expires_in", oAuthResult.expiresIn);
            jSONObject.put("scope", oAuthResult.scope);
            jSONObject.put("refresh_token", oAuthResult.refreshToken);
            jSONObject.put("session_key", oAuthResult.sessionKey);
            jSONObject.put("session_secret", oAuthResult.sessionSecret);
            jSONObject.put(SapiAccount.SAPI_ACCOUNT_EXTRA, oAuthResult.extra);
            jSONObject.put(Scopes.OPEN_ID, oAuthResult.openid);
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static OAuthResult parseFromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        OAuthResult oAuthResult = new OAuthResult();
        try {
            oAuthResult.setResultCode(Integer.parseInt(jSONObject.optString("errno")));
        } catch (Exception e) {
            Log.e(TAG, "formatOauthResult parseInt: " + e.getMessage());
        }
        oAuthResult.accessToken = jSONObject.optString("access_token");
        oAuthResult.expiresIn = jSONObject.optInt("expires_in");
        oAuthResult.scope = jSONObject.optString("scope");
        oAuthResult.refreshToken = jSONObject.optString("refresh_token");
        oAuthResult.sessionKey = jSONObject.optString("session_key");
        oAuthResult.sessionSecret = jSONObject.optString("session_secret");
        oAuthResult.extra = jSONObject.optString(SapiAccount.SAPI_ACCOUNT_EXTRA);
        oAuthResult.openid = jSONObject.optString(Scopes.OPEN_ID);
        return oAuthResult;
    }

    public String toString() {
        return "OAuthResult{accessToken='" + this.accessToken + ExtendedMessageFormat.QUOTE + ", expiresIn=" + this.expiresIn + ", refreshToken='" + this.refreshToken + ExtendedMessageFormat.QUOTE + ", scope='" + this.scope + ExtendedMessageFormat.QUOTE + ", sessionKey='" + this.sessionKey + ExtendedMessageFormat.QUOTE + ", sessionSecret='" + this.sessionSecret + ExtendedMessageFormat.QUOTE + ", extra='" + this.extra + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }
}
