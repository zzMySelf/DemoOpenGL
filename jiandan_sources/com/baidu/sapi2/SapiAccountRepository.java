package com.baidu.sapi2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.sdk.m.s.a;
import com.alipay.sdk.m.x.c;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.http.HttpHashMap;
import com.baidu.pass.http.ReqPriority;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.callback.FillUsernameCallback;
import com.baidu.sapi2.callback.GetCertStatusCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.GetUserAttrInfoCallback;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.callback.IqiyiLoginCallback;
import com.baidu.sapi2.callback.IsShowRealNameCallback;
import com.baidu.sapi2.callback.LoginWithUCAuthCallback;
import com.baidu.sapi2.callback.NetCallback;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.callback.SsoHashCallback;
import com.baidu.sapi2.callback.UserLogoutCallback;
import com.baidu.sapi2.callback.ValidateWithHaoKanCallback;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.callback.inner.ExecuteJsCallback;
import com.baidu.sapi2.callback.inner.GetOnlineAppCallback;
import com.baidu.sapi2.callback.inner.GetShareV3AppCallback;
import com.baidu.sapi2.callback.inner.LoadExternalWebViewActivityCallback;
import com.baidu.sapi2.callback.inner.LoginHistoryCallback;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.sapi2.dto.IqiyiLoginDTO;
import com.baidu.sapi2.dto.IsShowRealNameGuideDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.Web2NativeLoginDTO;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.result.CheckUserFaceIdResult;
import com.baidu.sapi2.result.FaceLoginStatusResult;
import com.baidu.sapi2.result.FillUsernameResult;
import com.baidu.sapi2.result.GetCertStatusResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.GetUserAttrInfoResult;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.result.IqiyiLoginResult;
import com.baidu.sapi2.result.IsShowRealNameGuideResult;
import com.baidu.sapi2.result.LocalRefreshTokenResult;
import com.baidu.sapi2.result.LoginWithUCAuthResult;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.SsoHashResult;
import com.baidu.sapi2.result.ValidateWithHaoKanResult;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.sapi2.share.GetOnlineRequestShareModel;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.ShareUtils;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SapiResponse;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.utils.GetTplStokenStat;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.PtokenStat;
import com.baidu.sapi2.utils.SapiCoreUtil;
import com.baidu.sapi2.utils.SapiDataEncryptor;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiDeviceUtils;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.Security;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sso.SSOManager;
import com.baidu.wallet.base.widget.banner.BannerBaseItemInfo;
import fe.fe.ppp.ad.ad;
import java.io.UnsupportedEncodingException;
import java.net.HttpCookie;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.security.cert.CertificateException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class SapiAccountRepository {
    public static final String API_V3 = "3";
    public static final int SSL_AES = 6;
    public static final String TAG = "SapiAccountRepository";
    public SapiConfiguration configuration = SapiAccountManager.getInstance().getSapiConfiguration();

    public interface OneKeyRequestJsCallback {
        void failure(int i2, String str);

        void success();
    }

    public static String calculateSig(Map<String, String> map, String str) {
        map.remove("sig");
        ArrayList arrayList = new ArrayList();
        for (String add : map.keySet()) {
            arrayList.add(add);
        }
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            try {
                String str3 = map.get(str2);
                if (!TextUtils.isEmpty(str3)) {
                    sb.append(str2);
                    sb.append("=");
                    sb.append(URLEncoder.encode(str3, "UTF-8"));
                    sb.append(a.n);
                }
            } catch (UnsupportedEncodingException e) {
                Log.e(e);
            }
        }
        sb.append("sign_key=");
        sb.append(str);
        return ad.rg(sb.toString().getBytes(), false);
    }

    /* access modifiers changed from: private */
    public String getAccessTokenCacheKey(String str, String str2) {
        return new String(Base64.encode((str + str2).getBytes(), 0));
    }

    private String getAppUc2PassLoginUrl() {
        return this.configuration.environment.getWap() + SapiEnv.APP_UC_PASS_LOGIN;
    }

    private OAuthResult getCachedOauthResult(String str, String str2) {
        JSONObject jSONObject;
        String string = SapiContext.getInstance().getString(getAccessTokenCacheKey(str, str2));
        try {
            jSONObject = new JSONObject(string);
        } catch (JSONException e) {
            String str3 = TAG;
            com.baidu.sapi2.utils.Log.e(str3, "formatOauthResult: " + e.getMessage());
            jSONObject = null;
        }
        if (jSONObject != null) {
            OAuthResult parseFromJson = OAuthResult.parseFromJson(jSONObject);
            if (System.currentTimeMillis() / 1000 < jSONObject.optLong("cachedTimeSecond", 0) + ((long) parseFromJson.expiresIn)) {
                String str4 = TAG;
                com.baidu.sapi2.utils.Log.d(str4, "getCachedOauthResult result: " + string);
                return parseFromJson;
            }
        }
        return null;
    }

    private String getCheckAvailableLoginHistoryUrl() {
        return getDomain().getWap() + "/v3/api/login/historylist";
    }

    private Domain getDomain() {
        return this.configuration.environment;
    }

    private String getLastCert() {
        return "/sslcrypt/get_last_cert";
    }

    /* access modifiers changed from: private */
    public void getThroughServer(final IqiyiLoginCallback iqiyiLoginCallback, IqiyiLoginDTO iqiyiLoginDTO, final IqiyiLoginResult iqiyiLoginResult) {
        if (TextUtils.isEmpty(iqiyiLoginDTO.accessToken) || TextUtils.isEmpty(iqiyiLoginDTO.openID)) {
            iqiyiLoginCallback.onLogin(iqiyiLoginResult);
            return;
        }
        HttpHashMapWrap buildSapiParams = buildSapiParams(getDomainSSOStart());
        if (!TextUtils.isEmpty(iqiyiLoginDTO.phoneNum)) {
            buildSapiParams.put("crypt_m", iqiyiLoginDTO.phoneNum);
        }
        buildSapiParams.put("access_token", iqiyiLoginDTO.accessToken);
        buildSapiParams.put("osuid", iqiyiLoginDTO.openID);
        buildSapiParams.put("json", "1");
        buildSapiParams.put("type", SocialType.IQIYI.getType() + "");
        buildSapiParams.put("act", "special");
        buildSapiParams.put("display", SapiAccountService.DISPLAY_TYPE_NATIVE);
        new HttpClientWrap().get(getDomainSSOStart(), ReqPriority.IMMEDIATE, buildSapiParams, (List<HttpCookie>) null, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) {
            public void onFailure(Throwable th2, int i2, String str) {
                iqiyiLoginResult.setResultCode(i2);
                iqiyiLoginCallback.onFailure(iqiyiLoginResult);
            }

            public void onFinish() {
                iqiyiLoginCallback.onFinish();
            }

            public void onStart() {
            }

            public void onSuccess(int i2, String str) {
                if (SapiAccountRepository.this.getErrorCode(str) == 302) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        iqiyiLoginResult.nextUrl = jSONObject.optString("next_url");
                        iqiyiLoginCallback.onBindWebview(iqiyiLoginResult);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    SocialResponse parseOpenApiAuthorizedResult = SapiWebView.parseOpenApiAuthorizedResult(str, SapiAccountRepository.this.configuration.context);
                    if (parseOpenApiAuthorizedResult == null) {
                        iqiyiLoginResult.setResultCode(-100);
                        iqiyiLoginResult.setResultMsg("登录失败");
                        iqiyiLoginCallback.onFailure(iqiyiLoginResult);
                    } else if (parseOpenApiAuthorizedResult.errorCode != -100) {
                        iqiyiLoginResult.setResultCode(-100);
                        iqiyiLoginResult.setResultMsg("登录失败");
                        iqiyiLoginCallback.onFailure(iqiyiLoginResult);
                    } else {
                        SapiAccount responseToAccount = SapiAccountRepository.this.responseToAccount(parseOpenApiAuthorizedResult);
                        responseToAccount.addSocialInfo(parseOpenApiAuthorizedResult.socialType, parseOpenApiAuthorizedResult.socialPortraitUrl, parseOpenApiAuthorizedResult.socialNickname, parseOpenApiAuthorizedResult.openid);
                        responseToAccount.putExtra("account_type", Integer.valueOf(parseOpenApiAuthorizedResult.accountType.getType()));
                        responseToAccount.addDispersionCertification(parseOpenApiAuthorizedResult.tplStokenMap);
                        responseToAccount.addIsGuestAccount(parseOpenApiAuthorizedResult.isGuestAccount);
                        responseToAccount.putExtra("tpl", SapiAccountRepository.this.configuration.tpl);
                        SapiAccountManager.getInstance().validate(responseToAccount);
                        iqiyiLoginCallback.onSuccess(iqiyiLoginResult);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public String getUaInfo() {
        return "tpl:" + this.configuration.tpl + ";android_sapi_v" + "9.10.7.3";
    }

    private String getUserAttrInfoUrl() {
        return SapiEnv.GET_USER_ATTR_INFO;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0053, code lost:
        r0 = r2.optJSONObject("data");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void processOneKeyLoginIsAvailable(int r7, java.lang.String r8, java.lang.String r9, final com.baidu.sapi2.callback.OneKeyLoginCallback r10) {
        /*
            r6 = this;
            java.lang.String r0 = TAG
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "onSuccess, statusCode = "
            r3.append(r4)
            r3.append(r7)
            java.lang.String r4 = ", response = "
            r3.append(r4)
            r3.append(r8)
            java.lang.String r3 = r3.toString()
            r4 = 0
            r2[r4] = r3
            com.baidu.sapi2.utils.Log.d(r0, r2)
            r0 = 0
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x002b }
            r2.<init>(r8)     // Catch:{ Exception -> 0x002b }
            goto L_0x002c
        L_0x002b:
            r2 = r0
        L_0x002c:
            com.baidu.sapi2.result.OneKeyLoginResult r8 = new com.baidu.sapi2.result.OneKeyLoginResult
            r8.<init>()
            if (r2 != 0) goto L_0x004b
            r8 = -113(0xffffffffffffff8f, float:NaN)
            com.baidu.sapi2.outsdk.OneKeyLoginSdkCall r9 = com.baidu.sapi2.outsdk.OneKeyLoginSdkCall.getInstance()
            java.lang.String r9 = r9.getOperatorType()
            com.baidu.sapi2.utils.SapiStatUtil.statOneKeyCheckAbility(r7, r8, r4, r9)
            com.baidu.sapi2.outsdk.OneKeyLoginSdkCall r7 = new com.baidu.sapi2.outsdk.OneKeyLoginSdkCall
            r7.<init>()
            r8 = -100
            r7.preGetPhoneFail(r10, r8, r0)
            return
        L_0x004b:
            java.lang.String r3 = "errno"
            int r3 = r2.optInt(r3)
            if (r3 != 0) goto L_0x0065
            java.lang.String r0 = "data"
            org.json.JSONObject r0 = r2.optJSONObject(r0)
            if (r0 == 0) goto L_0x0065
            java.lang.String r5 = "enable"
            int r5 = r0.optInt(r5)
            if (r1 != r5) goto L_0x0065
            r5 = 1
            goto L_0x0066
        L_0x0065:
            r5 = 0
        L_0x0066:
            if (r5 == 0) goto L_0x00c7
            if (r0 == 0) goto L_0x00c7
            r8.enable = r1
            r8.setResultCode(r4)
            r2 = -1
            java.lang.String r5 = "hasHistory"
            int r2 = r0.optInt(r5, r2)
            if (r2 != r1) goto L_0x0079
            goto L_0x007a
        L_0x0079:
            r1 = 0
        L_0x007a:
            r8.hasHistory = r1
            r8.encryptPhoneNum = r9
            java.lang.String r9 = "sign"
            java.lang.String r9 = r0.optString(r9)
            r8.sign = r9
            com.baidu.sapi2.outsdk.OneKeyLoginSdkCall.signFromAbilityApi = r9
            com.baidu.sapi2.outsdk.OneKeyLoginSdkCall r9 = new com.baidu.sapi2.outsdk.OneKeyLoginSdkCall
            r9.<init>()
            java.lang.String r9 = r9.getOperatorType()
            r8.operator = r9
            java.lang.String r9 = "md5"
            java.lang.String r9 = r0.optString(r9)
            java.lang.String r1 = "url"
            java.lang.String r1 = r0.optString(r1)
            java.lang.String r2 = "js"
            java.lang.String r0 = r0.optString(r2)
            com.baidu.sapi2.SapiContext r2 = com.baidu.sapi2.SapiContext.getInstance()
            java.lang.String r2 = r2.getOnekeyLoginJsMd5()
            if (r9 == 0) goto L_0x00bb
            boolean r2 = r9.equals(r2)
            if (r2 == 0) goto L_0x00bb
            com.baidu.sapi2.result.OneKeyLoginResult.secondJsCode = r0
            r10.available(r8)
            goto L_0x00d5
        L_0x00bb:
            java.lang.System.currentTimeMillis()
            com.baidu.sapi2.SapiAccountRepository$18 r2 = new com.baidu.sapi2.SapiAccountRepository$18
            r2.<init>(r0, r10, r8)
            r6.requestFirstJsCode(r1, r9, r0, r2)
            goto L_0x00d5
        L_0x00c7:
            java.lang.String r9 = "errmsg"
            java.lang.String r9 = r2.optString(r9)
            com.baidu.sapi2.outsdk.OneKeyLoginSdkCall r0 = new com.baidu.sapi2.outsdk.OneKeyLoginSdkCall
            r0.<init>()
            r0.preGetPhoneFail(r10, r3, r9)
        L_0x00d5:
            boolean r9 = r8.enable
            java.lang.String r8 = r8.operator
            com.baidu.sapi2.utils.SapiStatUtil.statOneKeyCheckAbility(r7, r3, r9, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.SapiAccountRepository.processOneKeyLoginIsAvailable(int, java.lang.String, java.lang.String, com.baidu.sapi2.callback.OneKeyLoginCallback):void");
    }

    /* access modifiers changed from: private */
    public void realDynamicPwdLogin(SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2, String str3, String str4, boolean z, SapiDataEncryptor sapiDataEncryptor) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, CertificateException, JSONException {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("crypttype", BannerBaseItemInfo.TYPE_SCHEME);
        String deviceInfo = SapiDeviceInfo.getDeviceInfo(SapiEnv.LOGIN_URI);
        if (!TextUtils.isEmpty(deviceInfo)) {
            httpHashMapWrap.put("di", deviceInfo);
        }
        httpHashMapWrap.put("cert_id", str2);
        httpHashMapWrap.put("isdpass", "1");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("username", str3);
        jSONObject.put("isphone", "1");
        jSONObject.put("password", str4);
        jSONObject.put("login_type", "3");
        jSONObject.put("key", sapiDataEncryptor.getAESKey());
        jSONObject.put("sdk_version", "2");
        jSONObject.put("pinfo", SapiDeviceUtils.getBrandName());
        httpHashMapWrap.put("userinfo", sapiDataEncryptor.encrypt(str, jSONObject.toString()));
        final SapiCallBack<SapiAccountResponse> sapiCallBack2 = sapiCallBack;
        final boolean z2 = z;
        final SapiDataEncryptor sapiDataEncryptor2 = sapiDataEncryptor;
        new HttpClientWrap().post(SapiEnv.LOGIN_URI, httpHashMapWrap, (List<HttpCookie>) null, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) {
            public void onFailure(Throwable th2, int i2, String str) {
                super.onFailure(th2, i2, str);
                if (i2 == -201) {
                    sapiCallBack2.onNetworkFailed();
                } else {
                    sapiCallBack2.onSystemError(i2);
                }
            }

            public void onSuccess(int i2, String str) {
                super.onSuccess(i2, str);
                SapiAccountRepository sapiAccountRepository = SapiAccountRepository.this;
                sapiAccountRepository.handleDynamicPwdLogin(sapiAccountRepository.getErrorCode(str), sapiCallBack2, str, z2, sapiDataEncryptor2);
            }
        });
    }

    private void requestFirstJsCode(String str, final String str2, String str3, final OneKeyRequestJsCallback oneKeyRequestJsCallback) {
        new HttpClientWrap().get(str, ReqPriority.IMMEDIATE, new HttpHandlerWrap(Looper.getMainLooper()) {
            public void onFailure(Throwable th2, int i2, String str) {
                OneKeyRequestJsCallback oneKeyRequestJsCallback = oneKeyRequestJsCallback;
                if (oneKeyRequestJsCallback != null) {
                    oneKeyRequestJsCallback.failure(-105, "");
                }
            }

            public void onSuccess(int i2, String str) {
                String rg2 = ad.rg(str.getBytes(), false);
                String str2 = str2;
                if (str2 == null || !str2.equals(rg2)) {
                    OneKeyRequestJsCallback oneKeyRequestJsCallback = oneKeyRequestJsCallback;
                    if (oneKeyRequestJsCallback != null) {
                        oneKeyRequestJsCallback.failure(-106, "");
                    }
                    com.baidu.sapi2.utils.Log.d(SapiAccountRepository.TAG, "oneKeyLogin check javsScript MD5 failed");
                    return;
                }
                SapiContext.getInstance().setOneKeyLoginJSCode(str);
                SapiContext.getInstance().setOnekeyLoginJsMd5(str2);
                OneKeyRequestJsCallback oneKeyRequestJsCallback2 = oneKeyRequestJsCallback;
                if (oneKeyRequestJsCallback2 != null) {
                    oneKeyRequestJsCallback2.success();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void setOneKeyLoginCookies(HashMap<String, String> hashMap) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair(this.configuration.environment.getWap(), hashMap.get("HISTORY")));
        SapiUtils.syncCookies(this.configuration.context, arrayList);
    }

    public HttpHashMapWrap buildSapiParams(String str) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        String deviceInfo = SapiDeviceInfo.getDeviceInfo(str);
        if (!TextUtils.isEmpty(deviceInfo)) {
            httpHashMapWrap.put("di", deviceInfo);
        }
        httpHashMapWrap.put("clientfrom", "mobilesdk_enhanced");
        httpHashMapWrap.put("sdk_version", "3");
        return httpHashMapWrap;
    }

    public void cancelRequest() {
    }

    public void checkAvailableLoginHistory(String str, final LoginHistoryCallback loginHistoryCallback) {
        com.baidu.sapi2.utils.Log.d("history", "checkAvailableLoginHistory loginHistoryInfo=" + str);
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("historyBdussList", str);
        new HttpClientWrap().post(getCheckAvailableLoginHistoryUrl(), ReqPriority.IMMEDIATE, httpHashMapWrap, new HttpHandlerWrap(Looper.getMainLooper()) {
            public void onFailure(Throwable th2, int i2, String str) {
                com.baidu.sapi2.utils.Log.d("History", "checkAvailableLoginHistory onFailure errorCode=" + i2 + ", responseBody=" + str);
                loginHistoryCallback.onFailure();
            }

            public void onSuccess(int i2, String str, HashMap<String, String> hashMap) {
                JSONObject jSONObject;
                JSONObject optJSONObject;
                com.baidu.sapi2.utils.Log.d("History", "checkAvailableLoginHistory onSuccess statusCode=" + i2 + ", responseBody=" + str);
                JSONArray jSONArray = null;
                try {
                    jSONObject = new JSONObject(str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    jSONObject = null;
                }
                if (jSONObject == null) {
                    loginHistoryCallback.onFailure();
                    return;
                }
                if (jSONObject.optInt("code") == 110000 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                    jSONArray = optJSONObject.optJSONArray("historyList");
                }
                if (jSONArray != null) {
                    loginHistoryCallback.onResult(jSONArray);
                } else {
                    loginHistoryCallback.onFailure();
                }
            }
        });
    }

    public void checkFaceLoginStatus(final SapiCallback<FaceLoginStatusResult> sapiCallback, String str) {
        SapiAccount currentAccount;
        if (SapiContext.getInstance().getSapiOptions().getOpenBdussTpls().contains(SapiAccountManager.getInstance().getConfignation().tpl) && (currentAccount = SapiContext.getInstance().getCurrentAccount()) != null) {
            str = currentAccount.bduss;
        }
        SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        HttpHashMapWrap buildSapiParams = buildSapiParams(SapiEnv.FACE_LOGIN_STATUS_CHECK);
        buildSapiParams.put("clientfrom", SapiAccountService.DISPLAY_TYPE_NATIVE);
        buildSapiParams.put("bduss", str);
        final FaceLoginStatusResult faceLoginStatusResult = new FaceLoginStatusResult();
        new HttpClientWrap().post(SapiEnv.FACE_LOGIN_STATUS_CHECK, buildSapiParams, (List<HttpCookie>) null, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) {
            public void onFailure(Throwable th2, int i2, String str) {
                faceLoginStatusResult.setResultCode(i2);
                sapiCallback.onFailure(faceLoginStatusResult);
            }

            public void onFinish() {
                sapiCallback.onFinish();
            }

            public void onStart() {
                sapiCallback.onStart();
            }

            public void onSuccess(int i2, String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                    faceLoginStatusResult.setResultCode(parseInt);
                    faceLoginStatusResult.setResultMsg(jSONObject.optString("errmsg"));
                    if (parseInt == 0) {
                        faceLoginStatusResult.status = jSONObject.optInt("status");
                        faceLoginStatusResult.livingUname = jSONObject.optString("livinguname");
                        faceLoginStatusResult.authsid = jSONObject.optString("authsid");
                        faceLoginStatusResult.authWidgetURL = jSONObject.optString("authurl");
                        FaceLoginStatusResult faceLoginStatusResult = faceLoginStatusResult;
                        boolean z = true;
                        if (jSONObject.optInt("faceLoginEnabled") != 1) {
                            z = false;
                        }
                        faceLoginStatusResult.faceLoginSwitch = z;
                        sapiCallback.onSuccess(faceLoginStatusResult);
                        return;
                    }
                    sapiCallback.onFailure(faceLoginStatusResult);
                } catch (Throwable unused) {
                    faceLoginStatusResult.setResultCode(-202);
                    sapiCallback.onFailure(faceLoginStatusResult);
                }
            }
        });
    }

    public void checkOneKeyLoginIsAvailable(final OneKeyLoginCallback oneKeyLoginCallback, final String str, int i2) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("ability", "onekeylogin");
        httpHashMapWrap.put("scene", "api");
        httpHashMapWrap.put("clientfrom", SapiAccountService.DISPLAY_TYPE_NATIVE);
        httpHashMapWrap.put("mobile", str);
        httpHashMapWrap.put("oneKeySdkVersion", c.d);
        String oneKeyLoginAbilityUrl = getOneKeyLoginAbilityUrl();
        List<HttpCookie> buildNaCookie = ParamsUtil.buildNaCookie(oneKeyLoginAbilityUrl, this.configuration);
        System.currentTimeMillis();
        SapiUtils.getNetworkClass(this.configuration.context);
        SSOManager.fe().de(this.configuration.context);
        new HttpClientWrap().get(oneKeyLoginAbilityUrl, ReqPriority.IMMEDIATE, httpHashMapWrap, buildNaCookie, getUaInfo(), i2, new HttpHandlerWrap(Looper.getMainLooper()) {
            public void onFailure(Throwable th2, int i2, String str) {
                System.currentTimeMillis();
                String access$200 = SapiAccountRepository.TAG;
                com.baidu.sapi2.utils.Log.d(access$200, "onFailure, error = " + th2 + ", errorCode = " + i2 + ", responseBody = " + str);
                SapiStatUtil.statOneKeyCheckAbility(i2, OneKeyLoginResult.ONE_KEY_LOGIN_CODE_NET_ERROR, false, OneKeyLoginSdkCall.getInstance().getOperatorType());
                new OneKeyLoginSdkCall().preGetPhoneFail(oneKeyLoginCallback, i2, (String) null);
            }

            public void onSuccess(int i2, String str) {
                System.currentTimeMillis();
                SapiAccountRepository.this.processOneKeyLoginIsAvailable(i2, str, str, oneKeyLoginCallback);
            }
        });
    }

    public void checkUserFaceId(final SapiCallback<CheckUserFaceIdResult> sapiCallback, String str, Map<String, String> map) {
        SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        HttpHashMapWrap buildSapiParams = buildSapiParams(SapiEnv.CHECK_USER_FACE_ID);
        buildSapiParams.put("clientfrom", SapiAccountService.DISPLAY_TYPE_NATIVE);
        buildSapiParams.put("bduss", str);
        if (map != null && !map.isEmpty()) {
            buildSapiParams.putAll(map);
        }
        final CheckUserFaceIdResult checkUserFaceIdResult = new CheckUserFaceIdResult();
        new HttpClientWrap().post(SapiEnv.CHECK_USER_FACE_ID, buildSapiParams, (List<HttpCookie>) null, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) {
            public void onFailure(Throwable th2, int i2, String str) {
                checkUserFaceIdResult.setResultCode(i2);
                sapiCallback.onFailure(checkUserFaceIdResult);
            }

            public void onFinish() {
                sapiCallback.onFinish();
            }

            public void onStart() {
                sapiCallback.onStart();
            }

            public void onSuccess(int i2, String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                    checkUserFaceIdResult.setResultCode(parseInt);
                    checkUserFaceIdResult.setResultMsg(jSONObject.optString("errmsg"));
                    if (parseInt == 0) {
                        checkUserFaceIdResult.status = jSONObject.optInt("status");
                        checkUserFaceIdResult.livingUname = jSONObject.optString("livinguname");
                        checkUserFaceIdResult.authsid = jSONObject.optString("authsid");
                        checkUserFaceIdResult.authWidgetURL = jSONObject.optString("authurl");
                        checkUserFaceIdResult.action = jSONObject.optString("action");
                        sapiCallback.onSuccess(checkUserFaceIdResult);
                        return;
                    }
                    sapiCallback.onFailure(checkUserFaceIdResult);
                } catch (Throwable unused) {
                    checkUserFaceIdResult.setResultCode(-202);
                    sapiCallback.onFailure(checkUserFaceIdResult);
                }
            }
        });
    }

    public boolean dynamicPwdLogin(SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2, boolean z) {
        SapiConfiguration sapiConfiguration = this.configuration;
        if (sapiConfiguration == null || sapiConfiguration.context == null) {
            return false;
        }
        final SapiCallBack<SapiAccountResponse> sapiCallBack2 = sapiCallBack;
        SapiUtils.notNull(sapiCallBack2, SapiCallBack.class.getSimpleName() + " can't be null");
        final SapiDataEncryptor sapiDataEncryptor = new SapiDataEncryptor();
        final boolean z2 = z;
        final String str3 = str;
        final String str4 = str2;
        new HttpClientWrap().get(getLastCert(), ReqPriority.IMMEDIATE, (HttpHashMap) null, (List<HttpCookie>) null, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) {
            public void onFailure(Throwable th2, int i2, String str) {
                if (i2 == -201) {
                    sapiCallBack2.onNetworkFailed();
                } else {
                    sapiCallBack2.onSystemError(i2);
                }
            }

            public void onSuccess(int i2, String str) {
                super.onSuccess(i2, str);
                if (!TextUtils.isEmpty(str)) {
                    SapiAccountRepository.this.handleDynamicPwdLogin(-100, sapiCallBack2, str, z2, sapiDataEncryptor);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    SapiAccountRepository.this.realDynamicPwdLogin(sapiCallBack2, jSONObject.optString("cert"), jSONObject.optString("cert_id"), str3, str4, z2, sapiDataEncryptor);
                } catch (Exception e) {
                    SapiAccountRepository.this.handleDynamicPwdLogin(-100, sapiCallBack2, str, z2, sapiDataEncryptor);
                    com.baidu.sapi2.utils.Log.e(e);
                }
            }
        });
        return true;
    }

    public void extendSysWebViewMethodCheck(final SapiCallback<SapiResult> sapiCallback, String str, String str2) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("open_appid", str);
        httpHashMapWrap.put("open_apikey", str2);
        httpHashMapWrap.put("time", System.currentTimeMillis() + "");
        final SapiResult sapiResult = new SapiResult();
        new HttpClientWrap().post(SapiEnv.EXTEND_SYS_WEBVIEW_METHOD_CHECK, httpHashMapWrap, (List<HttpCookie>) null, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) {
            public void onFailure(Throwable th2, int i2, String str) {
                sapiResult.setResultCode(i2);
                sapiResult.setResultMsg(str);
                sapiCallback.onFailure(sapiResult);
            }

            public void onFinish() {
                sapiCallback.onFinish();
            }

            public void onStart() {
                sapiCallback.onStart();
            }

            public void onSuccess(int i2, String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    sapiResult.setResultCode(jSONObject.optInt("errno"));
                    sapiResult.setResultMsg(jSONObject.optString("errmsg"));
                } catch (JSONException e) {
                    com.baidu.sapi2.utils.Log.e(e);
                }
                if (sapiResult.getResultCode() == 0) {
                    sapiCallback.onSuccess(sapiResult);
                } else {
                    sapiCallback.onFailure(sapiResult);
                }
            }
        });
    }

    public void faceLoginSwitch(SapiCallback<SapiResult> sapiCallback, String str, boolean z, String str2) {
        SapiAccount currentAccount;
        if (SapiContext.getInstance().getSapiOptions().getOpenBdussTpls().contains(SapiAccountManager.getInstance().getConfignation().tpl) && (currentAccount = SapiContext.getInstance().getCurrentAccount()) != null) {
            str = currentAccount.bduss;
        }
        SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        HttpHashMapWrap buildSapiParams = buildSapiParams(SapiEnv.FACE_LOGIN_STATUS_CHECK);
        if (z) {
            buildSapiParams.put("action", "enable_face_login");
        } else {
            buildSapiParams.put("action", "disable_face_login");
        }
        if (!TextUtils.isEmpty(str2)) {
            buildSapiParams.put("callbackKey", str2);
        }
        buildSapiParams.put("guidefrom", FaceBaseDTO.BUSINESS_SENCE_FACE_LOGIN_SWITCH);
        buildSapiParams.put("clientfrom", SapiAccountService.DISPLAY_TYPE_NATIVE);
        buildSapiParams.put("bduss", str);
        final CheckUserFaceIdResult checkUserFaceIdResult = new CheckUserFaceIdResult();
        final SapiCallback<SapiResult> sapiCallback2 = sapiCallback;
        final boolean z2 = z;
        new HttpClientWrap().post(SapiEnv.FACE_LOGIN_SWITCH_URI, buildSapiParams, (List<HttpCookie>) null, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) {
            public void onFailure(Throwable th2, int i2, String str) {
                checkUserFaceIdResult.setResultCode(i2);
                sapiCallback2.onFailure(checkUserFaceIdResult);
            }

            public void onFinish() {
                sapiCallback2.onFinish();
            }

            public void onStart() {
                sapiCallback2.onStart();
            }

            public void onSuccess(int i2, String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                    checkUserFaceIdResult.setResultCode(parseInt);
                    checkUserFaceIdResult.setResultMsg(jSONObject.optString("errmsg"));
                    if (parseInt == 0) {
                        if (z2) {
                            String optString = jSONObject.optString("livinguname");
                            if (!TextUtils.isEmpty(optString)) {
                                new FaceLoginService().syncFaceLoginUID(SapiAccountRepository.this.configuration.context, optString);
                            }
                        }
                        sapiCallback2.onSuccess(checkUserFaceIdResult);
                        return;
                    }
                    sapiCallback2.onFailure(checkUserFaceIdResult);
                } catch (Throwable unused) {
                    checkUserFaceIdResult.setResultCode(-202);
                    sapiCallback2.onFailure(checkUserFaceIdResult);
                }
            }
        });
    }

    public void fillUsername(FillUsernameCallback fillUsernameCallback, String str, String str2) {
        SapiUtils.notNull(fillUsernameCallback, FillUsernameCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        SapiUtils.notEmpty(str2, "username can't be empty");
        FillUsernameResult fillUsernameResult = new FillUsernameResult();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("cert_id", String.valueOf(1));
        httpHashMapWrap.put("crypttype", String.valueOf(6));
        JSONObject jSONObject = new JSONObject();
        final SapiDataEncryptor sapiDataEncryptor = new SapiDataEncryptor();
        try {
            jSONObject.put("bduss", str);
            String clientId = SapiUtils.getClientId(this.configuration.context);
            if (!TextUtils.isEmpty(clientId)) {
                jSONObject.put("clientid", clientId);
            }
            if (!TextUtils.isEmpty(this.configuration.clientIp)) {
                jSONObject.put("clientip", this.configuration.clientIp);
            }
            jSONObject.put("username", str2);
            jSONObject.put("key", sapiDataEncryptor.getAESKey());
            httpHashMapWrap.put("userinfo", sapiDataEncryptor.encrypt(SapiDataEncryptor.Cert1.CERT, jSONObject.toString()));
            final FillUsernameCallback fillUsernameCallback2 = fillUsernameCallback;
            final FillUsernameResult fillUsernameResult2 = fillUsernameResult;
            new HttpClientWrap().post(SapiEnv.FILL_UNAME, httpHashMapWrap, (List<HttpCookie>) null, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) {
                public void onFailure(Throwable th2, int i2, String str) {
                    fillUsernameResult2.setResultCode(i2);
                    fillUsernameCallback2.onFailure(fillUsernameResult2);
                }

                public void onFinish() {
                    fillUsernameCallback2.onFinish();
                }

                public void onStart() {
                    fillUsernameCallback2.onStart();
                }

                public void onSuccess(int i2, String str) {
                    int errorCode = SapiAccountRepository.this.getErrorCode(str);
                    fillUsernameResult2.setResultCode(errorCode);
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        fillUsernameResult2.setResultMsg(jSONObject.optString("errmsg"));
                        JSONObject jSONObject2 = new JSONObject(sapiDataEncryptor.decrypt(jSONObject.optString("userinfo")));
                        if (errorCode == 0 || errorCode == 110000) {
                            SapiAccount sapiAccount = new SapiAccount();
                            sapiAccount.bduss = jSONObject2.optString("bduss");
                            sapiAccount.ptoken = jSONObject2.optString("ptoken");
                            sapiAccount.stoken = jSONObject2.optString("stoken");
                            sapiAccount.displayname = jSONObject2.optString("displayname");
                            sapiAccount.username = jSONObject2.optString("uname");
                            sapiAccount.uid = jSONObject2.optString("uid");
                            sapiAccount.app = SapiUtils.getAppName(SapiAccountRepository.this.configuration.context);
                            sapiAccount.addDispersionCertification(SapiAccount.DispersionCertification.fromJSONObject(jSONObject2).tplStokenMap);
                            sapiAccount.putExtra("tpl", SapiAccountRepository.this.configuration.tpl);
                            SapiAccountManager.getInstance().validate(sapiAccount);
                            fillUsernameResult2.session = sapiAccount;
                            fillUsernameCallback2.onSuccess(fillUsernameResult2);
                            new PtokenStat().onEvent(PtokenStat.FILLNAME_WIDGE);
                            return;
                        }
                        switch (errorCode) {
                            case 160103:
                                fillUsernameCallback2.onBdussExpired(fillUsernameResult2);
                                return;
                            case FillUsernameResult.RESULT_CODE_USER_HAVE_USERNAME /*160104*/:
                                fillUsernameCallback2.onUserHaveUsername(fillUsernameResult2);
                                return;
                            default:
                                fillUsernameCallback2.onFailure(fillUsernameResult2);
                                return;
                        }
                    } catch (Throwable th2) {
                        fillUsernameCallback2.onFailure(fillUsernameResult2);
                        com.baidu.sapi2.utils.Log.e(th2);
                    }
                }
            });
        } catch (Throwable th2) {
            fillUsernameResult.setResultCode(-202);
            fillUsernameCallback.onFailure(fillUsernameResult);
            com.baidu.sapi2.utils.Log.e(th2);
        }
    }

    @SuppressLint({"NewApi"})
    public void generateSsoHash(final SsoHashCallback ssoHashCallback, final String str, final String str2) {
        SapiUtils.notNull(ssoHashCallback, "SsoHashCallback can't be null");
        new AsyncTask<String, Void, Long>() {
            public Long doInBackground(String... strArr) {
                try {
                    URLConnection openConnection = new URL(strArr[0]).openConnection();
                    openConnection.setConnectTimeout(3000);
                    openConnection.connect();
                    return Long.valueOf(openConnection.getDate() / 1000);
                } catch (Exception e) {
                    com.baidu.sapi2.utils.Log.e(e);
                    return 0L;
                }
            }

            public void onPostExecute(Long l) {
                SsoHashResult ssoHashResult = new SsoHashResult();
                ssoHashResult.ssoHash = new Security().encryptSsoHash(l, str, str2);
                ssoHashResult.setResultCode(0);
                ssoHashCallback.onSuccess(ssoHashResult);
            }
        }.execute(new String[]{SapiEnv.HASH_TIMESTAMP_URL});
    }

    public String getAcccountCenterUrl() {
        return getDomain().getWap() + "/wp/v3/ucenter/index";
    }

    public String getAccountCenterCheckUrl() {
        return getDomain().getWap() + "/v6/safetyInspection";
    }

    public String getAccountRealNameUrl() {
        return getDomain().getWap() + "/wp/v3/ucenter/realnameverify";
    }

    public String getAuthWidgetUrl() {
        return getDomain().getWap() + "/v6/authwidget";
    }

    public String getBindWidgetUrl(BindWidgetAction bindWidgetAction) {
        return getDomain().getWap() + bindWidgetAction.getUri();
    }

    public String getCancelRealName() {
        return getDomain().getURL() + SapiEnv.CANCEL_REALNAME;
    }

    public String getCertGuardUrl() {
        return getDomain().getWap() + "/static/manage-chunk/guardian-cert.html";
    }

    public void getCertStatus(final GetCertStatusCallback getCertStatusCallback) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        String certStatusUrl = getCertStatusUrl();
        List<HttpCookie> buildNaCookie = ParamsUtil.buildNaCookie(certStatusUrl, this.configuration);
        buildNaCookie.addAll(ParamsUtil.buildLoginStatusCookie(certStatusUrl, this.configuration));
        new HttpClientWrap().post(certStatusUrl, ReqPriority.IMMEDIATE, httpHashMapWrap, buildNaCookie, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) {
            public void onFailure(Throwable th2, int i2, String str) {
                GetCertStatusResult getCertStatusResult = new GetCertStatusResult();
                getCertStatusResult.setResultCode(i2);
                getCertStatusResult.setResultMsg(str);
                getCertStatusCallback.onFailure(getCertStatusResult);
            }

            public void onSuccess(int i2, String str) {
                GetCertStatusResult getCertStatusResult = new GetCertStatusResult();
                if (i2 != 200) {
                    getCertStatusResult.setResultCode(-202);
                    getCertStatusResult.setResultMsg(SapiResult.ERROR_MSG_UNKNOWN);
                    getCertStatusCallback.onFailure(getCertStatusResult);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("code");
                    if (optInt == 50000) {
                        getCertStatusResult.setResultCode(50000);
                        getCertStatusResult.setResultMsg(GetCertStatusResult.MESSAGE_BUSINESS_RESULT_RISK_CONTROL);
                        getCertStatusCallback.onFailure(getCertStatusResult);
                    } else if (optInt == 110000) {
                        GetCertStatusResult parseFromJSONObject = GetCertStatusResult.parseFromJSONObject(jSONObject.optJSONObject("data"));
                        if (parseFromJSONObject.getResultCode() == 110000) {
                            getCertStatusCallback.onSuccess(parseFromJSONObject);
                        } else {
                            getCertStatusCallback.onFailure(parseFromJSONObject);
                        }
                    } else if (optInt != 400021) {
                        getCertStatusResult.setResultCode(SapiResult.ERROR_CODE_SDK_NOT_INIT);
                        getCertStatusResult.setResultMsg("服务异常，请稍后再试");
                        getCertStatusCallback.onFailure(getCertStatusResult);
                    } else {
                        getCertStatusResult.setResultCode(400021);
                        getCertStatusResult.setResultMsg("当前用户不在线");
                        getCertStatusCallback.onFailure(getCertStatusResult);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    getCertStatusResult.setResultCode(-205);
                    getCertStatusResult.setResultMsg(SapiResult.ERROR_MSG_SERVER_DATA_ERROR);
                    getCertStatusCallback.onFailure(getCertStatusResult);
                }
            }
        });
    }

    public String getCertStatusUrl() {
        return getDomain().getWap() + SapiEnv.GET_CERT_STATUS;
    }

    public String getChangeUsername() {
        return getDomain().getWap() + "/static/manage-chunk/change-username.html";
    }

    public String getChildVerifyUrl() {
        return getDomain().getWap() + SapiEnv.CHILD_VERIFY;
    }

    public String getContactAddressUrl() {
        return getDomain().getWap() + "/v6/shippingAddress";
    }

    public String getDomainAfterAuth() {
        return getDomain().getURL() + SapiEnv.SOCIAL_AFTER_AUTH_URI;
    }

    public String getDomainFinishBind() {
        return getDomain().getURL() + SapiEnv.SOCIAL_FINISH_AUTH_URI;
    }

    public String getDomainSSOFinish() {
        return getDomain().getURL() + "/phoenix/account/ssologin";
    }

    public String getDomainSSOSecondcard() {
        return getDomain().getURL() + SapiEnv.SSO_SECONDCARD_URI;
    }

    public String getDomainSSOStart() {
        return getDomain().getURL() + "/phoenix/account/ssologin";
    }

    public String getDoubleListUrl() {
        return getDomain().getWap() + "/static/manage-chunk/account-info.html";
    }

    public boolean getDynamicPwd(final SapiCallBack<SapiResponse> sapiCallBack, String str) {
        Context context;
        SapiConfiguration sapiConfiguration = this.configuration;
        if (sapiConfiguration == null || (context = sapiConfiguration.context) == null) {
            return false;
        }
        if (!SapiUtils.hasActiveNetwork(context)) {
            if (sapiCallBack != null) {
                sapiCallBack.onNetworkFailed();
            }
            return false;
        } else if (TextUtils.isEmpty(str)) {
            if (sapiCallBack != null) {
                sapiCallBack.onSystemError(257);
            }
            return false;
        } else {
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put("username", str);
            new HttpClientWrap().post(SapiEnv.GET_DYNAMIC_PWD_URI, httpHashMapWrap, (List<HttpCookie>) null, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) {
                public void onFailure(Throwable th2, int i2, String str) {
                    if (i2 == -203) {
                        sapiCallBack.onSystemError(i2);
                    } else {
                        SapiAccountRepository.this.handleGetDynamicPwd(sapiCallBack, str);
                    }
                }

                public void onSuccess(int i2, String str) {
                    SapiAccountRepository.this.handleGetDynamicPwd(sapiCallBack, str);
                }
            });
            return true;
        }
    }

    public int getErrorCode(String str) {
        try {
            return new JSONObject(str).getInt("errno");
        } catch (Exception e) {
            com.baidu.sapi2.utils.Log.e(e);
            return -100;
        }
    }

    public String getExplainCameraDeatilUrl() {
        return getDomain().getWap() + SapiEnv.EXPLAIN_CAMERA_DETAIL;
    }

    public String getInvoiceAddressUrl() {
        return getDomain().getWap() + "/v6/invoiceManage";
    }

    public String getIsShowRealNameGuideUrl() {
        return getDomain().getURL() + SapiEnv.IS_SHOW_REAL_NAME_GUIDE;
    }

    public String getLoadOneKeyLoginUrl() {
        return getDomain().getWap() + SapiEnv.LOAD_ONE_KEY_LOGIN;
    }

    public String getNormalizeGuestAccountUrl() {
        return getDomain().getURL() + SapiEnv.NORMALIZE_GUEST_ACCOUNT_URI;
    }

    public String getOneKeyLoginAbilityUrl() {
        return getDomain().getWap() + SapiEnv.ONE_KEY_LOGIN_ABILITY;
    }

    public void getOnlineAppShareModel(List<GetOnlineRequestShareModel> list, String str, final GetOnlineAppCallback getOnlineAppCallback) {
        if (getOnlineAppCallback != null && list != null && list.size() != 0) {
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put("client", SapiDeviceInfo.OS_TYPE);
            httpHashMapWrap.put("clientfrom", SapiAccountService.DISPLAY_TYPE_NATIVE);
            JSONArray jSONArray = new JSONArray();
            for (GetOnlineRequestShareModel parseModel2JsonObject : list) {
                jSONArray.put(GetOnlineRequestShareModel.parseModel2JsonObject(parseModel2JsonObject));
            }
            httpHashMapWrap.put("applist", jSONArray.toString());
            httpHashMapWrap.put("frominterflow", str);
            String onlineAppUrl = getOnlineAppUrl();
            new HttpClientWrap().post(onlineAppUrl, httpHashMapWrap, ParamsUtil.buildNaCookie(onlineAppUrl, this.configuration), getUaInfo(), new HttpHandlerWrap() {
                public void onFailure(Throwable th2, int i2, String str) {
                    com.baidu.sapi2.utils.Log.d(ShareUtils.TAG, "getOnlineAppShareModel fail responseBody=" + str);
                    getOnlineAppCallback.onFailure();
                }

                public void onSuccess(int i2, String str) {
                    com.baidu.sapi2.utils.Log.d(ShareUtils.TAG, "getOnlineAppShareModel success response=" + str);
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        if (jSONObject.optInt("errno") != 0) {
                            getOnlineAppCallback.onFailure();
                            return;
                        }
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        if (optJSONObject == null) {
                            getOnlineAppCallback.onFailure();
                            return;
                        }
                        JSONArray optJSONArray = optJSONObject.optJSONArray("applist");
                        if (optJSONArray == null) {
                            getOnlineAppCallback.onFailure();
                        } else {
                            getOnlineAppCallback.onSuccess(optJSONArray);
                        }
                    } catch (JSONException e) {
                        com.baidu.sapi2.utils.Log.e(SapiAccountRepository.TAG, e.getMessage());
                        getOnlineAppCallback.onFailure();
                    }
                }
            });
        }
    }

    public String getOnlineAppUrl() {
        return getDomain().getURL() + SapiEnv.SHARE_LOGIN_GET_ONLINE_APP;
    }

    public String getPersonalInfoUrl() {
        return getDomain().getWap() + "/static/manage-chunk/info-out.html";
    }

    public void getShareV3App(String str, List<String> list, String str2, final GetShareV3AppCallback getShareV3AppCallback) {
        if (getShareV3AppCallback != null) {
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put("client", SapiDeviceInfo.OS_TYPE);
            httpHashMapWrap.put("clientfrom", SapiAccountService.DISPLAY_TYPE_NATIVE);
            httpHashMapWrap.put("tpl", str);
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (String append : list) {
                sb.append("\"");
                sb.append(append);
                sb.append("\"");
                sb.append(",");
            }
            StringBuilder deleteCharAt = sb.deleteCharAt(sb.length() - 1);
            deleteCharAt.append("]");
            httpHashMapWrap.put("interflowPkgList", deleteCharAt.toString());
            httpHashMapWrap.put("currentAppPkg", str2);
            String shareV3AppUrl = getShareV3AppUrl();
            new HttpClientWrap().post(shareV3AppUrl, httpHashMapWrap, ParamsUtil.buildNaCookie(shareV3AppUrl, this.configuration), getUaInfo(), new HttpHandlerWrap() {
                public void onFailure(Throwable th2, int i2, String str) {
                    com.baidu.sapi2.utils.Log.d(ShareUtils.TAG, "requestShareV3AppFromCloud fail responseBody=" + str);
                    getShareV3AppCallback.onFailure();
                }

                public void onSuccess(int i2, String str) {
                    JSONObject jSONObject;
                    JSONObject optJSONObject;
                    com.baidu.sapi2.utils.Log.d(ShareUtils.TAG, "requestShareV3AppFromCloud success response=" + str);
                    JSONArray jSONArray = null;
                    try {
                        jSONObject = new JSONObject(str);
                    } catch (JSONException e) {
                        com.baidu.sapi2.utils.Log.e(SapiAccountRepository.TAG, e.getMessage());
                        jSONObject = null;
                    }
                    if (!(jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null)) {
                        jSONArray = optJSONObject.optJSONArray("list");
                    }
                    if (jSONArray != null) {
                        ArrayList arrayList = new ArrayList();
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            ShareStorage.StorageModel fromJSON = ShareStorage.StorageModel.fromJSON(jSONArray.optJSONObject(i3));
                            if (fromJSON != null) {
                                arrayList.add(fromJSON);
                            }
                        }
                        SapiContext.getInstance().put(SapiContext.KEY_SHARE_MODELS_FROM_CLOUD_CACHE, jSONArray.toString());
                        getShareV3AppCallback.onSuccess(arrayList);
                        return;
                    }
                    getShareV3AppCallback.onFailure();
                }
            });
        }
    }

    public String getShareV3AppUrl() {
        return getDomain().getURL() + SapiEnv.CLOUD_SHARE_V3_APP;
    }

    public String getSwitchAccountUrl() {
        return getDomain().getWap() + SapiEnv.SWITCH_ACCOUNT;
    }

    public Map<String, String> getTplStoken(GetTplStokenCallback getTplStokenCallback, String str, List<String> list, boolean z) {
        GetTplStokenCallback getTplStokenCallback2 = getTplStokenCallback;
        String str2 = str;
        List<String> list2 = list;
        final long currentTimeMillis = System.currentTimeMillis();
        SapiUtils.notNull(getTplStokenCallback2, GetTplStokenCallback.class.getSimpleName() + " can't be null");
        GetTplStokenResult getTplStokenResult = new GetTplStokenResult();
        if (list2 == null || list.isEmpty()) {
            getTplStokenResult.setResultCode(-302);
            getTplStokenResult.setResultMsg(SapiResult.ERROR_MSG_PARAMS_ERROR);
            getTplStokenCallback2.onFailure(getTplStokenResult);
            GetTplStokenStat.onEventAutoStat(String.valueOf(System.currentTimeMillis() - currentTimeMillis), String.valueOf(-302), SapiResult.ERROR_MSG_PARAMS_ERROR);
            return getTplStokenResult.tplStokenMap;
        }
        final SapiAccount accountFromBduss = SapiContext.getInstance().getAccountFromBduss(str2);
        if (accountFromBduss == null) {
            getTplStokenResult.setResultCode(-301);
            getTplStokenCallback2.onFailure(getTplStokenResult);
            GetTplStokenStat.onEventAutoStat(String.valueOf(System.currentTimeMillis() - currentTimeMillis), String.valueOf(-301), GetTplStokenResult.ERROR_MSG_BDUSS_NOT_EXIST);
            return getTplStokenResult.tplStokenMap;
        }
        final String str3 = accountFromBduss.ptoken;
        if (isStokenExist(str2, list2)) {
            try {
                SapiAccount.DispersionCertification fromJSONObject = SapiAccount.DispersionCertification.fromJSONObject(new JSONObject(accountFromBduss.extra));
                Iterator<String> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String next = it.next();
                    if (!fromJSONObject.tplStokenMap.containsKey(next)) {
                        getTplStokenResult.tplStokenMap.clear();
                        break;
                    }
                    getTplStokenResult.tplStokenMap.put(next, fromJSONObject.tplStokenMap.get(next));
                }
                if (!getTplStokenResult.tplStokenMap.isEmpty()) {
                    getTplStokenResult.setResultCode(0);
                    getTplStokenResult.setResultMsg("成功");
                    getTplStokenCallback2.onSuccess(getTplStokenResult);
                    GetTplStokenStat.onEventAutoStat(String.valueOf(System.currentTimeMillis() - currentTimeMillis), String.valueOf(0), "成功");
                    return getTplStokenResult.tplStokenMap;
                }
            } catch (JSONException e) {
                com.baidu.sapi2.utils.Log.e(e);
                getTplStokenResult.setResultCode(GetTplStokenResult.ERROR_CODE_PARSE_DATA_FAIL);
                getTplStokenCallback2.onFailure(getTplStokenResult);
                GetTplStokenStat.onEventAutoStat(String.valueOf(System.currentTimeMillis() - currentTimeMillis), String.valueOf(GetTplStokenResult.ERROR_CODE_PARSE_DATA_FAIL), SapiResult.ERROR_MSG_SERVER_DATA_ERROR);
                return getTplStokenResult.tplStokenMap;
            }
        }
        String str4 = list2.get(0);
        for (int i2 = 1; i2 < list.size(); i2++) {
            str4 = str4 + "|" + list2.get(i2);
        }
        if (TextUtils.isEmpty(str3)) {
            getTplStokenResult.setResultCode(-305);
            getTplStokenResult.failureType = GetTplStokenResult.FailureType.PTOKEN_EMPTY;
            getTplStokenCallback2.onFailure(getTplStokenResult);
        }
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("bduss", str2);
        httpHashMapWrap.put("sign", ad.rg((this.configuration.appId + this.configuration.tpl + str2 + this.configuration.appSignKey).getBytes(), false));
        httpHashMapWrap.put("return_type", "1");
        if (!TextUtils.isEmpty(str3)) {
            httpHashMapWrap.put("ptoken", str3);
        }
        httpHashMapWrap.put("tpl_list", str4);
        final GetTplStokenCallback getTplStokenCallback3 = getTplStokenCallback;
        final GetTplStokenResult getTplStokenResult2 = getTplStokenResult;
        final List<String> list3 = list;
        final boolean z2 = z;
        new HttpClientWrap().post(SapiEnv.GET_STOKEN_URI, httpHashMapWrap, (List<HttpCookie>) null, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) {
            public void onFailure(Throwable th2, int i2, String str) {
                if (!TextUtils.isEmpty(str3)) {
                    getTplStokenResult2.setResultCode(i2);
                    getTplStokenCallback3.onFailure(getTplStokenResult2);
                    GetTplStokenStat.onEventAutoStat(String.valueOf(System.currentTimeMillis() - currentTimeMillis), String.valueOf(i2), SapiResult.ERROR_MSG_UNKNOWN);
                }
            }

            public void onFinish() {
                getTplStokenCallback3.onFinish();
            }

            public void onStart() {
                getTplStokenCallback3.onStart();
            }

            public void onSuccess(int i2, String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                    getTplStokenResult2.setResultCode(parseInt);
                    if (parseInt == 0) {
                        Map<String, String> tplStokenMap = SapiAccount.DispersionCertification.getTplStokenMap(jSONObject.optJSONObject("stoken_list"));
                        getTplStokenResult2.tplStokenMap = tplStokenMap;
                        SapiAccount.ExtraProperty extraProperty = new SapiAccount.ExtraProperty();
                        if (!TextUtils.isEmpty(accountFromBduss.extra)) {
                            extraProperty = SapiAccount.ExtraProperty.fromJSONObject(new JSONObject(accountFromBduss.extra));
                        }
                        extraProperty.dispersionCertification.tplStokenMap.putAll(tplStokenMap);
                        accountFromBduss.extra = extraProperty.toJSONObject().toString();
                        if (list3.size() == tplStokenMap.size()) {
                            if (z2) {
                                SapiAccountManager.getInstance().validate(accountFromBduss, false, true);
                            } else {
                                SapiContext.getInstance().setCurrentAccount(accountFromBduss);
                                SapiContext.getInstance().addLoginAccount(accountFromBduss);
                                new ShareCallPacking().asyncMarkLoginState(5);
                            }
                            getTplStokenCallback3.onSuccess(getTplStokenResult2);
                            return;
                        }
                        getTplStokenResult2.setResultCode(GetTplStokenResult.ERROR_CODE_STOKENS_NOT_MATCH);
                        getTplStokenResult2.setResultMsg(SapiResult.ERROR_MSG_SERVER_DATA_ERROR);
                        getTplStokenCallback3.onFailure(getTplStokenResult2);
                        GetTplStokenStat.onEventAutoStat(String.valueOf(System.currentTimeMillis() - currentTimeMillis), String.valueOf(GetTplStokenResult.ERROR_CODE_STOKENS_NOT_MATCH), SapiResult.ERROR_MSG_SERVER_DATA_ERROR);
                    } else if (parseInt != 8) {
                        if (!TextUtils.isEmpty(str3)) {
                            String optString = jSONObject.optString("errmsg");
                            getTplStokenResult2.setResultMsg(optString);
                            getTplStokenCallback3.onFailure(getTplStokenResult2);
                            GetTplStokenStat.onEventAutoStat(String.valueOf(System.currentTimeMillis() - currentTimeMillis), String.valueOf(i2), optString);
                        }
                    } else if (!TextUtils.isEmpty(str3)) {
                        String optString2 = jSONObject.optString("ssnerror");
                        if (TextUtils.isEmpty(optString2)) {
                            optString2 = "0";
                        }
                        int parseInt2 = Integer.parseInt(optString2);
                        if (parseInt2 == GetTplStokenResult.FailureType.BDUSS_PTOKEN_NOT_MATCH.ordinal()) {
                            getTplStokenResult2.failureType = GetTplStokenResult.FailureType.BDUSS_PTOKEN_NOT_MATCH;
                        } else if (parseInt2 == GetTplStokenResult.FailureType.BDUSS_EXPIRED.ordinal()) {
                            getTplStokenResult2.failureType = GetTplStokenResult.FailureType.BDUSS_EXPIRED;
                        }
                        String optString3 = jSONObject.optString("errmsg");
                        getTplStokenResult2.setResultMsg(optString3);
                        getTplStokenCallback3.onFailure(getTplStokenResult2);
                        GetTplStokenStat.onEventAutoStat(String.valueOf(System.currentTimeMillis() - currentTimeMillis), String.valueOf(8), optString3);
                    }
                } catch (Exception e) {
                    com.baidu.sapi2.utils.Log.e(e);
                    if (!TextUtils.isEmpty(str3)) {
                        getTplStokenResult2.setResultCode(-205);
                        getTplStokenCallback3.onFailure(getTplStokenResult2);
                        GetTplStokenStat.onEventAutoStat(String.valueOf(System.currentTimeMillis() - currentTimeMillis), String.valueOf(-205), SapiResult.ERROR_MSG_SERVER_DATA_ERROR);
                    }
                }
            }
        });
        return getTplStokenResult.tplStokenMap;
    }

    public String getUniteVerifyUrl() {
        return getDomain().getWap() + "/wp/unitewidget";
    }

    public void getUserAttrInfo(String str, String str2, String str3, final String str4, final GetUserAttrInfoCallback getUserAttrInfoCallback) {
        String userAttrInfoUrl = getUserAttrInfoUrl();
        List<HttpCookie> buildLoginStatusCookie = ParamsUtil.buildLoginStatusCookie(userAttrInfoUrl, this.configuration);
        HttpHashMap httpHashMap = new HttpHashMap();
        httpHashMap.put("appname", str);
        httpHashMap.put(GetUserAttrInfoResult.KEY_DATA_FIELDS, str2);
        httpHashMap.put(GetUserAttrInfoResult.KEY_DATA_EXT_FIELDS, str3);
        new HttpClientWrap().get(userAttrInfoUrl, ReqPriority.IMMEDIATE, httpHashMap, buildLoginStatusCookie, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) {
            public void onFailure(Throwable th2, int i2, String str) {
                GetUserAttrInfoResult getUserAttrInfoResult = new GetUserAttrInfoResult();
                getUserAttrInfoResult.setResultCode(i2);
                getUserAttrInfoResult.setResultMsg(str);
                getUserAttrInfoCallback.onFailure(getUserAttrInfoResult);
            }

            public void onSuccess(int i2, String str) {
                GetUserAttrInfoResult parseFromJSONObject = GetUserAttrInfoResult.parseFromJSONObject(str);
                if (parseFromJSONObject.getResultCode() != 0) {
                    getUserAttrInfoCallback.onFailure(parseFromJSONObject);
                    return;
                }
                getUserAttrInfoCallback.onSuccess(parseFromJSONObject);
                parseFromJSONObject.setCacheTime(System.currentTimeMillis() / 1000);
                parseFromJSONObject.setIsLocalData(true);
                SapiContext.getInstance().setUserAttrInfo(str4, parseFromJSONObject.toJsonStr());
            }
        });
    }

    public void getUserInfo(GetUserInfoCallback getUserInfoCallback, String str) {
        com.baidu.sapi2.utils.Log.d(TAG, "getUserInfo: 1");
        getUserInfo(getUserInfoCallback, str, "", "");
    }

    public String getUserLogoutUrl() {
        return getDomain().getURL() + SapiEnv.USER_LOGOUT;
    }

    public String getWapForgetPwdUrl() {
        return getDomain().getWap() + "/passport/getpass";
    }

    public String getWapLoginBackUrl() {
        return getDomain().getWap() + "/static/manage-chunk/new-na-simple.html";
    }

    public String getWapLoginUrl() {
        return getDomain().getWap() + "/passport/login";
    }

    public String getWapShareLoginUrl() {
        return getDomain().getWap() + "/v3/login/api/login";
    }

    public void handleDynamicPwdLogin(int i2, SapiCallBack<SapiAccountResponse> sapiCallBack, String str, boolean z, SapiDataEncryptor sapiDataEncryptor) {
        if (str != null) {
            SapiAccountResponse sapiAccountResponse = new SapiAccountResponse();
            try {
                String optString = new JSONObject(str).optString("userinfo");
                JSONObject jSONObject = null;
                if (!TextUtils.isEmpty(optString)) {
                    jSONObject = new JSONObject(sapiDataEncryptor.decrypt(optString));
                    sapiAccountResponse.displayname = jSONObject.optString("displayname");
                    sapiAccountResponse.username = jSONObject.optString("uname");
                    sapiAccountResponse.uid = jSONObject.optString("uid");
                    sapiAccountResponse.email = jSONObject.optString("email");
                    sapiAccountResponse.bduss = jSONObject.optString("bduss");
                    sapiAccountResponse.ptoken = jSONObject.optString("ptoken");
                    sapiAccountResponse.stoken = jSONObject.optString("stoken");
                    sapiAccountResponse.authSid = jSONObject.optString("authsid");
                }
                if (sapiCallBack == null) {
                    return;
                }
                if (i2 != 0) {
                    sapiCallBack.onSystemError(i2);
                    return;
                }
                if (z) {
                    SapiAccount responseToAccount = responseToAccount(sapiAccountResponse);
                    responseToAccount.addDispersionCertification(SapiAccount.DispersionCertification.fromJSONObject(jSONObject).tplStokenMap);
                    responseToAccount.putExtra("tpl", this.configuration.tpl);
                    SapiAccountManager.getInstance().validate(responseToAccount);
                }
                sapiCallBack.onSuccess(sapiAccountResponse);
            } catch (Exception e) {
                com.baidu.sapi2.utils.Log.e(e);
                if (sapiCallBack != null) {
                    sapiCallBack.onSystemError(-100);
                }
            }
        } else if (sapiCallBack != null) {
            sapiCallBack.onSystemError(i2);
        }
    }

    public void handleGetDynamicPwd(SapiCallBack<SapiResponse> sapiCallBack, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            EnhancedService.smsCodeLength = jSONObject.optInt(EnhancedService.KEY_SMS_CODE_LENGTH, 6);
            int parseInt = Integer.parseInt(jSONObject.optString("errno"));
            if (parseInt != 0) {
                sapiCallBack.onSystemError(parseInt);
                return;
            }
            SapiResponse sapiResponse = new SapiResponse();
            sapiResponse.errorCode = parseInt;
            sapiResponse.errorMsg = "短信验证码发送成功";
            sapiCallBack.onSuccess(sapiResponse);
        } catch (Exception unused) {
            sapiCallBack.onSystemError(-100);
        }
    }

    public void iqiyiSSOLogin(IqiyiLoginCallback iqiyiLoginCallback, IqiyiLoginDTO iqiyiLoginDTO) {
        if (iqiyiLoginCallback != null) {
            iqiyiLoginCallback.onStart();
            String str = iqiyiLoginDTO.accessToken;
            final String str2 = iqiyiLoginDTO.phoneNum;
            String str3 = iqiyiLoginDTO.openID;
            final IqiyiLoginResult iqiyiLoginResult = new IqiyiLoginResult();
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            boolean z = !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3);
            if (!z && currentAccount == null) {
                iqiyiLoginCallback.onLogin(iqiyiLoginResult);
            } else if (!z || currentAccount != null) {
                final IqiyiLoginCallback iqiyiLoginCallback2 = iqiyiLoginCallback;
                final IqiyiLoginDTO iqiyiLoginDTO2 = iqiyiLoginDTO;
                SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() {
                    public void onFinish() {
                    }

                    public void onStart() {
                    }

                    public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                        SapiAccountRepository.this.getThroughServer(iqiyiLoginCallback2, iqiyiLoginDTO2, iqiyiLoginResult);
                    }

                    public void onFailure(GetUserInfoResult getUserInfoResult) {
                        iqiyiLoginResult.setResultCode(getUserInfoResult.getResultCode());
                        iqiyiLoginResult.setResultMsg(getUserInfoResult.getResultMsg());
                        iqiyiLoginCallback2.onFailure(iqiyiLoginResult);
                    }

                    public void onSuccess(GetUserInfoResult getUserInfoResult) {
                        String str = getUserInfoResult.secureMobile;
                        boolean z = getUserInfoResult.incompleteUser;
                        if (!TextUtils.isEmpty(str)) {
                            iqiyiLoginCallback2.onSuccess(iqiyiLoginResult);
                        } else if (z) {
                            SapiAccountRepository.this.getThroughServer(iqiyiLoginCallback2, iqiyiLoginDTO2, iqiyiLoginResult);
                        } else if (TextUtils.isEmpty(str2)) {
                            iqiyiLoginCallback2.onSuccess(iqiyiLoginResult);
                        } else {
                            SapiAccountRepository.this.getThroughServer(iqiyiLoginCallback2, iqiyiLoginDTO2, iqiyiLoginResult);
                        }
                    }
                }, currentAccount.bduss);
            } else {
                getThroughServer(iqiyiLoginCallback, iqiyiLoginDTO, iqiyiLoginResult);
            }
        }
    }

    public boolean isAccountStokenExist(SapiAccount sapiAccount, List<String> list) {
        if (sapiAccount != null && !TextUtils.isEmpty(sapiAccount.extra)) {
            try {
                SapiAccount.DispersionCertification fromJSONObject = SapiAccount.DispersionCertification.fromJSONObject(new JSONObject(sapiAccount.extra));
                for (String containsKey : list) {
                    if (!fromJSONObject.tplStokenMap.containsKey(containsKey)) {
                        return false;
                    }
                }
                return true;
            } catch (JSONException e) {
                com.baidu.sapi2.utils.Log.e(e);
            }
        }
        return false;
    }

    public void isShowRealNameGuide(IsShowRealNameGuideDTO isShowRealNameGuideDTO, final IsShowRealNameCallback isShowRealNameCallback) {
        if (isShowRealNameGuideDTO != null) {
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put("type", isShowRealNameGuideDTO.type);
            httpHashMapWrap.put("historyTime", isShowRealNameGuideDTO.historyTime);
            String isShowRealNameGuideUrl = getIsShowRealNameGuideUrl();
            List<HttpCookie> buildNaCookie = ParamsUtil.buildNaCookie(isShowRealNameGuideUrl, this.configuration);
            buildNaCookie.addAll(ParamsUtil.buildLoginStatusCookie(isShowRealNameGuideUrl, this.configuration));
            new HttpClientWrap().post(isShowRealNameGuideUrl, ReqPriority.IMMEDIATE, httpHashMapWrap, buildNaCookie, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) {
                public void onFailure(Throwable th2, int i2, String str) {
                    IsShowRealNameGuideResult isShowRealNameGuideResult = new IsShowRealNameGuideResult();
                    isShowRealNameGuideResult.setResultCode(i2);
                    isShowRealNameGuideResult.setResultMsg(str);
                    isShowRealNameCallback.onFailure(isShowRealNameGuideResult);
                }

                public void onSuccess(int i2, String str) {
                    IsShowRealNameGuideResult isShowRealNameGuideResult = new IsShowRealNameGuideResult();
                    if (i2 != 200) {
                        isShowRealNameGuideResult.setResultCode(-202);
                        isShowRealNameGuideResult.setResultMsg(SapiResult.ERROR_MSG_UNKNOWN);
                        isShowRealNameCallback.onFailure(isShowRealNameGuideResult);
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        int optInt = jSONObject.optInt("code");
                        if (optInt == 110000) {
                            IsShowRealNameGuideResult parseFromJSONObject = IsShowRealNameGuideResult.parseFromJSONObject(jSONObject.optJSONObject("data"));
                            if (parseFromJSONObject.getResultCode() == 110000) {
                                isShowRealNameCallback.onSuccess(parseFromJSONObject);
                            } else {
                                isShowRealNameCallback.onFailure(parseFromJSONObject);
                            }
                        } else if (optInt != 400021) {
                            isShowRealNameGuideResult.setResultCode(SapiResult.ERROR_CODE_SDK_NOT_INIT);
                            isShowRealNameGuideResult.setResultMsg("服务异常，请稍后再试");
                            isShowRealNameCallback.onFailure(isShowRealNameGuideResult);
                        } else {
                            isShowRealNameGuideResult.setResultCode(400021);
                            isShowRealNameGuideResult.setResultMsg("当前用户不在线");
                            isShowRealNameCallback.onFailure(isShowRealNameGuideResult);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        isShowRealNameGuideResult.setResultCode(-205);
                        isShowRealNameGuideResult.setResultMsg(SapiResult.ERROR_MSG_SERVER_DATA_ERROR);
                        isShowRealNameCallback.onFailure(isShowRealNameGuideResult);
                    }
                }
            });
        }
    }

    public boolean isStokenExist(String str, List<String> list) {
        SapiUtils.notEmpty(str, "bduss can't be empty");
        if (list != null && !list.isEmpty()) {
            return isAccountStokenExist(SapiContext.getInstance().getAccountFromBduss(str), list);
        }
        throw new IllegalArgumentException("targetTplList can't be null or empty");
    }

    public void loadOneKeyLogin(OneKeyLoginCallback oneKeyLoginCallback, String str, String str2, LoadExternalWebViewActivityCallback loadExternalWebViewActivityCallback) {
        loadOneKeyLogin(oneKeyLoginCallback, str, str2, true, loadExternalWebViewActivityCallback);
    }

    public void loginWithUCAuth(String str, String str2, String str3, final LoginWithUCAuthCallback loginWithUCAuthCallback) {
        String appUc2PassLoginUrl = getAppUc2PassLoginUrl();
        List<HttpCookie> buildLoginStatusCookie = ParamsUtil.buildLoginStatusCookie(appUc2PassLoginUrl, this.configuration);
        HttpHashMap httpHashMap = new HttpHashMap();
        httpHashMap.put("tpl", str);
        httpHashMap.put("appid", str2);
        httpHashMap.put("ucdata", str3);
        httpHashMap.put("client", SapiDeviceInfo.OS_TYPE);
        httpHashMap.put("clientfrom", SapiAccountService.DISPLAY_TYPE_NATIVE);
        httpHashMap.put("sig", calculateSig(httpHashMap.getMap(), SapiAccountManager.getInstance().getConfignation().appSignKey));
        new HttpClientWrap().post(appUc2PassLoginUrl, ReqPriority.IMMEDIATE, httpHashMap, buildLoginStatusCookie, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) {
            public void onFailure(Throwable th2, int i2, String str) {
                LoginWithUCAuthResult loginWithUCAuthResult = new LoginWithUCAuthResult();
                loginWithUCAuthResult.setResultCode(i2);
                loginWithUCAuthResult.setResultMsg(str);
                loginWithUCAuthCallback.onFailure(loginWithUCAuthResult);
            }

            public void onSuccess(int i2, String str) {
                LoginWithUCAuthResult parseFromJSONObject = LoginWithUCAuthResult.parseFromJSONObject(str);
                if (parseFromJSONObject.getResultCode() != 0) {
                    loginWithUCAuthCallback.onFailure(parseFromJSONObject);
                    return;
                }
                SapiAccount sapiAccount = new SapiAccount();
                sapiAccount.uid = parseFromJSONObject.uid;
                sapiAccount.displayname = parseFromJSONObject.displayname;
                sapiAccount.bduss = parseFromJSONObject.bduss;
                sapiAccount.ptoken = parseFromJSONObject.ptoken;
                sapiAccount.stoken = parseFromJSONObject.stoken;
                SapiAccountManager.getInstance().validate(sapiAccount, false, false);
                loginWithUCAuthCallback.onSuccess(parseFromJSONObject);
            }
        });
    }

    public void oauth(SapiCallback<OAuthResult> sapiCallback, String str, String str2, String str3) {
        SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        if (!TextUtils.isEmpty(str2)) {
            httpHashMapWrap.put("openPlatformId", str2);
        }
        httpHashMapWrap.put("bduss", str);
        if (!TextUtils.isEmpty(str3)) {
            httpHashMapWrap.put("scope", str3);
        }
        final SapiCallback<OAuthResult> sapiCallback2 = sapiCallback;
        final String str4 = str;
        final String str5 = str2;
        new HttpClientWrap().post(SapiEnv.OAUTH_URI, httpHashMapWrap, (List<HttpCookie>) null, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) {
            public void onFailure(Throwable th2, int i2, String str) {
                String access$200 = SapiAccountRepository.TAG;
                com.baidu.sapi2.utils.Log.d(access$200, "oauth failure: code=" + i2 + " body=" + str);
                OAuthResult oAuthResult = new OAuthResult();
                oAuthResult.setResultCode(i2);
                sapiCallback2.onFailure(oAuthResult);
            }

            public void onFinish() {
                sapiCallback2.onFinish();
            }

            public void onStart() {
                sapiCallback2.onStart();
            }

            public void onSuccess(int i2, String str) {
                JSONObject jSONObject;
                String access$200 = SapiAccountRepository.TAG;
                com.baidu.sapi2.utils.Log.d(access$200, "oauth success: " + str);
                try {
                    jSONObject = new JSONObject(str);
                } catch (JSONException e) {
                    String access$2002 = SapiAccountRepository.TAG;
                    com.baidu.sapi2.utils.Log.e(access$2002, "formatOauthResult: " + e.getMessage());
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    try {
                        jSONObject.put(SapiAccount.SAPI_ACCOUNT_EXTRA, str);
                        jSONObject.put("cachedTimeSecond", System.currentTimeMillis() / 1000);
                    } catch (JSONException e2) {
                        String access$2003 = SapiAccountRepository.TAG;
                        com.baidu.sapi2.utils.Log.e(access$2003, "" + e2.getMessage());
                    }
                }
                OAuthResult parseFromJson = OAuthResult.parseFromJson(jSONObject);
                if (jSONObject == null || parseFromJson == null) {
                    OAuthResult oAuthResult = new OAuthResult();
                    oAuthResult.setResultCode(-202);
                    sapiCallback2.onFailure(oAuthResult);
                } else if (parseFromJson.getResultCode() == 0) {
                    SapiContext.getInstance().put(SapiAccountRepository.this.getAccessTokenCacheKey(str4, str5), jSONObject.toString());
                    sapiCallback2.onSuccess(parseFromJson);
                } else {
                    sapiCallback2.onFailure(parseFromJson);
                }
            }
        });
    }

    public void oauthAccessToken(SapiCallback<OAuthResult> sapiCallback, String str, String str2) {
        OAuthResult cachedOauthResult = getCachedOauthResult(str, str2);
        if (cachedOauthResult != null) {
            sapiCallback.onSuccess(cachedOauthResult);
        } else {
            oauth(sapiCallback, str, str2, (String) null);
        }
    }

    public boolean refreshLocalAccessToken(String str, String str2, String str3, String str4) {
        OAuthResult cachedOauthResult = getCachedOauthResult(str, str2);
        if (cachedOauthResult == null) {
            return false;
        }
        try {
            cachedOauthResult.accessToken = str3;
            cachedOauthResult.refreshToken = str4;
            JSONObject oauthResult2Json = OAuthResult.oauthResult2Json(cachedOauthResult);
            SapiContext.getInstance().put(getAccessTokenCacheKey(str, str2), oauthResult2Json.toString());
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public SapiAccount responseToAccount(SapiAccountResponse sapiAccountResponse) {
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.displayname = sapiAccountResponse.displayname;
        sapiAccount.bduss = sapiAccountResponse.bduss;
        sapiAccount.ptoken = sapiAccountResponse.ptoken;
        sapiAccount.stoken = sapiAccountResponse.stoken;
        sapiAccount.uid = sapiAccountResponse.uid;
        sapiAccount.username = sapiAccountResponse.username;
        sapiAccount.app = SapiUtils.getAppName(this.configuration.context);
        return sapiAccount;
    }

    public void setCloudShareAccount(final int i2, ShareStorage.StorageModel storageModel) {
        SapiAccount currentAccount;
        if (SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.FUN_NAME_SHARE_V3).meetGray) {
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            if (i2 == 2) {
                httpHashMapWrap.put("cmd", "insert");
            } else if (i2 == 3) {
                httpHashMapWrap.put("cmd", "delete");
            } else if (i2 == 4) {
                httpHashMapWrap.put("cmd", "reset");
            } else {
                return;
            }
            if (i2 == 2 && storageModel.flag == 0 && (currentAccount = SapiContext.getInstance().getCurrentAccount()) != null) {
                httpHashMapWrap.put("bduss", currentAccount.bduss);
                httpHashMapWrap.put("ptoken", currentAccount.ptoken);
                httpHashMapWrap.put("stoken", currentAccount.stoken);
            }
            httpHashMapWrap.put("app", SapiUtils.getAppName(this.configuration.context));
            httpHashMapWrap.put(SapiAccount.ExtraProperty.EXTRA_PKG, this.configuration.context.getPackageName());
            new HttpClientWrap().post(SapiEnv.CLOUND_SHARE_ACCOUNT, ReqPriority.IMMEDIATE, httpHashMapWrap, new HttpHandlerWrap(Looper.getMainLooper()) {
                public void onFailure(Throwable th2, int i2, String str) {
                    SapiStatUtil.statSetCloudShareAccount(i2, 2);
                }

                public void onStart() {
                    com.baidu.sapi2.utils.Log.d(SapiAccountRepository.TAG, "set clound share account start");
                    SapiStatUtil.statSetCloudShareAccount(i2, 0);
                }

                public void onSuccess(int i2, String str) {
                    try {
                        if (new JSONObject(str).optInt("code") == 110000) {
                            SapiStatUtil.statSetCloudShareAccount(i2, 1);
                            return;
                        }
                    } catch (Exception e) {
                        com.baidu.sapi2.utils.Log.e(e);
                    }
                    SapiStatUtil.statSetCloudShareAccount(i2, 2);
                }
            });
        }
    }

    public LocalRefreshTokenResult syncGetLocalRefreshToken(String str, String str2) {
        LocalRefreshTokenResult localRefreshTokenResult = new LocalRefreshTokenResult();
        OAuthResult cachedOauthResult = getCachedOauthResult(str, str2);
        if (cachedOauthResult == null || TextUtils.isEmpty(cachedOauthResult.refreshToken)) {
            localRefreshTokenResult.setResultCode(-401);
            localRefreshTokenResult.setResultMsg(LocalRefreshTokenResult.RESULT_MSG_NO_CACHE);
            return localRefreshTokenResult;
        }
        localRefreshTokenResult.setResultCode(0);
        localRefreshTokenResult.setResultMsg("成功");
        localRefreshTokenResult.refreshToken = cachedOauthResult.refreshToken;
        return localRefreshTokenResult;
    }

    public void userLogout(int i2, final UserLogoutCallback userLogoutCallback) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("logout_type", String.valueOf(i2));
        String userLogoutUrl = getUserLogoutUrl();
        List<HttpCookie> buildNaCookie = ParamsUtil.buildNaCookie(userLogoutUrl, this.configuration);
        buildNaCookie.addAll(ParamsUtil.buildLoginStatusCookie(userLogoutUrl, this.configuration));
        new HttpClientWrap().post(userLogoutUrl, ReqPriority.IMMEDIATE, httpHashMapWrap, buildNaCookie, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) {
            public void onFailure(Throwable th2, int i2, String str) {
                SapiResult sapiResult = new SapiResult();
                sapiResult.setResultCode(i2);
                sapiResult.setResultMsg(str);
                userLogoutCallback.onFailure(sapiResult);
            }

            public void onSuccess(int i2, String str) {
                SapiResult sapiResult = new SapiResult();
                try {
                    int optInt = new JSONObject(str).optInt("code");
                    if (optInt != 110000) {
                        sapiResult.setResultCode(optInt);
                        userLogoutCallback.onFailure(sapiResult);
                        return;
                    }
                    userLogoutCallback.onSuccess(sapiResult);
                } catch (JSONException e) {
                    e.printStackTrace();
                    sapiResult.setResultCode(-205);
                    sapiResult.setResultMsg(SapiResult.ERROR_MSG_SERVER_DATA_ERROR);
                    userLogoutCallback.onFailure(sapiResult);
                }
            }
        });
    }

    public void validateOnlyHaoKan(String str, ValidateWithHaoKanCallback validateWithHaoKanCallback) {
        ValidateWithHaoKanResult validateWithHaoKanResult = new ValidateWithHaoKanResult();
        try {
            if (TextUtils.isEmpty(str)) {
                validateWithHaoKanResult.setResultCode(-101);
                validateWithHaoKanCallback.onFailure(validateWithHaoKanResult);
                return;
            }
            SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
            if (confignation != null) {
                if (confignation.context != null) {
                    if (!SapiContext.getInstance().getValidateBdussAuthorizedPackages().contains(confignation.context.getPackageName())) {
                        validateWithHaoKanResult.setResultCode(-103);
                        validateWithHaoKanCallback.onFailure(validateWithHaoKanResult);
                        return;
                    } else if (SapiAccountManager.getInstance().isLogin()) {
                        validateWithHaoKanResult.setResultCode(-102);
                        validateWithHaoKanCallback.onFailure(validateWithHaoKanResult);
                        return;
                    } else {
                        final String cookiePtoken = SapiUtils.getCookiePtoken();
                        if (TextUtils.isEmpty(cookiePtoken)) {
                            validateWithHaoKanResult.setResultCode(-105);
                            validateWithHaoKanCallback.onFailure(validateWithHaoKanResult);
                            return;
                        }
                        final ValidateWithHaoKanResult validateWithHaoKanResult2 = validateWithHaoKanResult;
                        final ValidateWithHaoKanCallback validateWithHaoKanCallback2 = validateWithHaoKanCallback;
                        final String str2 = str;
                        getUserInfo(new GetUserInfoCallback() {
                            public void onFinish() {
                            }

                            public void onStart() {
                            }

                            public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                                validateWithHaoKanResult2.setResultCode(400021);
                                validateWithHaoKanCallback2.onFailure(validateWithHaoKanResult2);
                            }

                            public void onFailure(GetUserInfoResult getUserInfoResult) {
                                validateWithHaoKanResult2.setResultCode(-202);
                                validateWithHaoKanCallback2.onFailure(validateWithHaoKanResult2);
                            }

                            public void onSuccess(GetUserInfoResult getUserInfoResult) {
                                SapiAccount session = SapiAccountManager.getInstance().getSession();
                                if (session == null) {
                                    session = new SapiAccount();
                                }
                                session.uid = getUserInfoResult.uid;
                                session.username = getUserInfoResult.username;
                                session.displayname = getUserInfoResult.displayname;
                                session.bduss = str2;
                                session.ptoken = cookiePtoken;
                                session.app = SapiUtils.getAppName(SapiAccountRepository.this.configuration.context);
                                SapiAccountManager.getInstance().validate(session, true, true, true);
                                validateWithHaoKanResult2.setResultCode(0);
                                validateWithHaoKanCallback2.onSuccess(validateWithHaoKanResult2);
                                new PtokenStat().onEvent(PtokenStat.WEB_2_NATIVE);
                            }
                        }, str);
                        return;
                    }
                }
            }
            validateWithHaoKanResult.setResultCode(-104);
            validateWithHaoKanCallback.onFailure(validateWithHaoKanResult);
        } catch (Exception unused) {
            validateWithHaoKanResult.setResultCode(-202);
            validateWithHaoKanCallback.onFailure(validateWithHaoKanResult);
        }
    }

    public void web2NativeLogin(Web2NativeLoginCallback web2NativeLoginCallback, Web2NativeLoginDTO web2NativeLoginDTO) {
        final boolean z;
        boolean z2;
        String str;
        if (web2NativeLoginDTO != null) {
            z2 = web2NativeLoginDTO.overWriteNAAccount;
            z = web2NativeLoginDTO.trustOpenBduss;
        } else {
            z2 = true;
            z = false;
        }
        SapiUtils.notNull(web2NativeLoginCallback, Web2NativeLoginCallback.class.getSimpleName() + " can't be null");
        final Web2NativeLoginResult web2NativeLoginResult = new Web2NativeLoginResult();
        String cookieBduss = SapiUtils.getCookieBduss();
        final String cookiePtoken = SapiUtils.getCookiePtoken();
        if (TextUtils.isEmpty(cookieBduss)) {
            web2NativeLoginResult.setResultCode(-101);
            web2NativeLoginCallback.onBdussEmpty(web2NativeLoginResult);
            return;
        }
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        String str2 = "";
        if (currentAccount != null) {
            str2 = currentAccount.bduss;
            str = currentAccount.ptoken;
        } else {
            str = str2;
        }
        if (cookieBduss.equals(str2) && !TextUtils.isEmpty(cookiePtoken) && cookiePtoken.equals(str)) {
            web2NativeLoginResult.setResultCode(0);
            web2NativeLoginCallback.onSuccess(web2NativeLoginResult);
        } else if (!SapiAccountManager.getInstance().isLogin() || z2) {
            final Web2NativeLoginCallback web2NativeLoginCallback2 = web2NativeLoginCallback;
            final String str3 = cookieBduss;
            getUserInfo(new GetUserInfoCallback() {
                public void onFinish() {
                    web2NativeLoginCallback2.onFinish();
                }

                public void onStart() {
                    web2NativeLoginCallback2.onStart();
                }

                public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                    web2NativeLoginResult.setResultCode(400021);
                    web2NativeLoginCallback2.onBdussExpired(web2NativeLoginResult);
                }

                public void onFailure(GetUserInfoResult getUserInfoResult) {
                    web2NativeLoginResult.setResultCode(-202);
                    web2NativeLoginCallback2.onFailure(web2NativeLoginResult);
                }

                public void onSuccess(GetUserInfoResult getUserInfoResult) {
                    SapiAccount sapiAccount = new SapiAccount();
                    sapiAccount.uid = getUserInfoResult.uid;
                    sapiAccount.username = getUserInfoResult.username;
                    sapiAccount.displayname = getUserInfoResult.displayname;
                    sapiAccount.bduss = str3;
                    if (!TextUtils.isEmpty(cookiePtoken)) {
                        sapiAccount.ptoken = cookiePtoken;
                    }
                    sapiAccount.app = SapiUtils.getAppName(SapiAccountRepository.this.configuration.context);
                    SapiAccountManager.getInstance().validate(sapiAccount, true, true, z);
                    web2NativeLoginResult.setResultCode(0);
                    web2NativeLoginCallback2.onSuccess(web2NativeLoginResult);
                    new PtokenStat().onEvent(PtokenStat.WEB_2_NATIVE);
                }
            }, cookieBduss);
        } else {
            SapiAccount currentAccount2 = SapiContext.getInstance().getCurrentAccount();
            if (!cookieBduss.equals(currentAccount2.bduss)) {
                SapiAccountManager.getInstance().getAccountService().webLogin(this.configuration.context, currentAccount2.bduss);
            }
            web2NativeLoginResult.setResultCode(0);
            web2NativeLoginCallback.onSuccess(web2NativeLoginResult);
        }
    }

    public void loadOneKeyLogin(final OneKeyLoginCallback oneKeyLoginCallback, String str, String str2, final boolean z, final LoadExternalWebViewActivityCallback loadExternalWebViewActivityCallback) {
        JSONObject jSONObject = new JSONObject();
        try {
            String operatorType = new OneKeyLoginSdkCall().getOperatorType();
            jSONObject.put("token", str);
            jSONObject.put("tpl", this.configuration.tpl);
            jSONObject.put("client", SapiDeviceInfo.OS_TYPE);
            jSONObject.put("clientfrom", SapiAccountService.DISPLAY_TYPE_NATIVE);
            jSONObject.put("appid", OneKeyLoginSdkCall.sOneKeyLoginAppKey);
            jSONObject.put("operator", operatorType);
            jSONObject.put("scene", "api");
            jSONObject.put("sign", str2);
            if (OneKeyLoginSdkCall.OPERATOR_TYPE_CUCC.equals(operatorType)) {
                jSONObject.put("CUVersion", "2");
            }
        } catch (JSONException e) {
            com.baidu.sapi2.utils.Log.e(e);
        }
        String oneKeyLoginJsCode = SapiContext.getInstance().getOneKeyLoginJsCode();
        String str3 = OneKeyLoginResult.secondJsCode;
        System.currentTimeMillis();
        SapiUtils.getNetworkClass(this.configuration.context);
        SSOManager.fe().de(this.configuration.context);
        SapiCoreUtil.executeJsCode(oneKeyLoginJsCode, str3, jSONObject.toString(), this.configuration.context, new ExecuteJsCallback() {
            public void jsExecuteCompleted(String str) {
                System.currentTimeMillis();
                JSONObject jSONObject = null;
                if (!TextUtils.isEmpty(str)) {
                    try {
                        jSONObject = new JSONObject(str);
                    } catch (JSONException e) {
                        com.baidu.sapi2.utils.Log.e(e);
                    }
                    HttpHashMap httpHashMap = new HttpHashMap();
                    if (jSONObject != null) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            httpHashMap.put(next, jSONObject.optString(next));
                        }
                    }
                    httpHashMap.put("oneKeySdkVersion", c.d);
                    if (z) {
                        httpHashMap.put("yyNormalOneKey", "1");
                    }
                    String loadOneKeyLoginUrl = SapiAccountRepository.this.getLoadOneKeyLoginUrl();
                    List<HttpCookie> buildNaCookie = ParamsUtil.buildNaCookie(loadOneKeyLoginUrl, SapiAccountRepository.this.configuration);
                    System.currentTimeMillis();
                    new HttpClientWrap().post(loadOneKeyLoginUrl, httpHashMap, buildNaCookie, SapiAccountRepository.this.getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) {
                        public void onFailure(Throwable th2, int i2, String str) {
                            String access$200 = SapiAccountRepository.TAG;
                            com.baidu.sapi2.utils.Log.d(access$200, "onFailure, error = " + th2 + ", errorCode = " + i2 + ", responseBody = " + str);
                            new OneKeyLoginSdkCall().loadOneKeyLoginFail(oneKeyLoginCallback, -100, (String) null);
                            SapiStatUtil.statOneKeyLoginPassAction(0, "-114", "net error");
                        }

                        /* JADX WARNING: Removed duplicated region for block: B:43:0x0100 A[Catch:{ Exception -> 0x0126 }] */
                        /* JADX WARNING: Removed duplicated region for block: B:44:0x0119 A[Catch:{ Exception -> 0x0126 }] */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void onSuccess(int r7, java.lang.String r8, java.util.HashMap<java.lang.String, java.lang.String> r9) {
                            /*
                                r6 = this;
                                java.lang.String r0 = com.baidu.sapi2.SapiAccountRepository.TAG
                                r1 = 1
                                java.lang.Object[] r1 = new java.lang.Object[r1]
                                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                                r2.<init>()
                                java.lang.String r3 = "onSuccess, statusCode = "
                                r2.append(r3)
                                r2.append(r7)
                                java.lang.String r7 = ", response = "
                                r2.append(r7)
                                r2.append(r8)
                                java.lang.String r7 = r2.toString()
                                r2 = 0
                                r1[r2] = r7
                                com.baidu.sapi2.utils.Log.d(r0, r1)
                                r7 = -100
                                r0 = 0
                                org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0126 }
                                r1.<init>(r8)     // Catch:{ Exception -> 0x0126 }
                                java.lang.String r8 = "errInfo"
                                org.json.JSONObject r8 = r1.optJSONObject(r8)     // Catch:{ Exception -> 0x0126 }
                                java.lang.String r3 = "no"
                                java.lang.String r3 = r8.optString(r3)     // Catch:{ Exception -> 0x0126 }
                                java.lang.String r4 = "msg"
                                java.lang.String r8 = r8.optString(r4)     // Catch:{ Exception -> 0x0126 }
                                com.baidu.sapi2.utils.SapiStatUtil.statOneKeyLoginPassAction(r2, r3, r8)     // Catch:{ Exception -> 0x0126 }
                                java.lang.String r4 = "0"
                                boolean r4 = r4.equals(r3)     // Catch:{ Exception -> 0x0126 }
                                java.lang.String r5 = "data"
                                if (r4 == 0) goto L_0x007d
                                com.baidu.sapi2.SapiAccountRepository$19 r8 = com.baidu.sapi2.SapiAccountRepository.AnonymousClass19.this     // Catch:{ Exception -> 0x0126 }
                                com.baidu.sapi2.SapiAccountRepository r8 = com.baidu.sapi2.SapiAccountRepository.this     // Catch:{ Exception -> 0x0126 }
                                r8.setOneKeyLoginCookies(r9)     // Catch:{ Exception -> 0x0126 }
                                org.json.JSONObject r8 = r1.optJSONObject(r5)     // Catch:{ Exception -> 0x0126 }
                                if (r8 == 0) goto L_0x0070
                                java.lang.String r9 = "xml"
                                java.lang.String r8 = r8.optString(r9)     // Catch:{ Exception -> 0x0126 }
                                com.baidu.sapi2.SapiAccountManager r9 = com.baidu.sapi2.SapiAccountManager.getInstance()     // Catch:{ Exception -> 0x0126 }
                                com.baidu.sapi2.SapiAccountService r9 = r9.getAccountService()     // Catch:{ Exception -> 0x0126 }
                                com.baidu.sapi2.SapiAccountRepository$19 r1 = com.baidu.sapi2.SapiAccountRepository.AnonymousClass19.this     // Catch:{ Exception -> 0x0126 }
                                com.baidu.sapi2.callback.OneKeyLoginCallback r1 = r4     // Catch:{ Exception -> 0x0126 }
                                r9.handleOneKeyLoginResult(r1, r8)     // Catch:{ Exception -> 0x0126 }
                                goto L_0x007c
                            L_0x0070:
                                com.baidu.sapi2.outsdk.OneKeyLoginSdkCall r8 = new com.baidu.sapi2.outsdk.OneKeyLoginSdkCall     // Catch:{ Exception -> 0x0126 }
                                r8.<init>()     // Catch:{ Exception -> 0x0126 }
                                com.baidu.sapi2.SapiAccountRepository$19 r9 = com.baidu.sapi2.SapiAccountRepository.AnonymousClass19.this     // Catch:{ Exception -> 0x0126 }
                                com.baidu.sapi2.callback.OneKeyLoginCallback r9 = r4     // Catch:{ Exception -> 0x0126 }
                                r8.loadOneKeyLoginFail(r9, r7, r0)     // Catch:{ Exception -> 0x0126 }
                            L_0x007c:
                                return
                            L_0x007d:
                                java.lang.String r9 = "400101"
                                boolean r9 = r9.equals(r3)     // Catch:{ Exception -> 0x0126 }
                                java.lang.String r4 = ""
                                if (r9 != 0) goto L_0x00ee
                                java.lang.String r9 = "400031"
                                boolean r9 = r9.equals(r3)     // Catch:{ Exception -> 0x0126 }
                                if (r9 != 0) goto L_0x00ee
                                java.lang.String r9 = "400023"
                                boolean r9 = r9.equals(r3)     // Catch:{ Exception -> 0x0126 }
                                if (r9 == 0) goto L_0x0098
                                goto L_0x00ee
                            L_0x0098:
                                java.lang.String r9 = "400704"
                                boolean r9 = r9.equals(r3)     // Catch:{ Exception -> 0x0126 }
                                if (r9 != 0) goto L_0x00df
                                java.lang.String r9 = "400706"
                                boolean r9 = r9.equals(r3)     // Catch:{ Exception -> 0x0126 }
                                if (r9 == 0) goto L_0x00a9
                                goto L_0x00df
                            L_0x00a9:
                                java.lang.String r9 = "400801"
                                boolean r9 = r9.equals(r3)     // Catch:{ Exception -> 0x0126 }
                                if (r9 == 0) goto L_0x00ce
                                org.json.JSONObject r8 = r1.optJSONObject(r5)     // Catch:{ Exception -> 0x0126 }
                                if (r8 == 0) goto L_0x00bd
                                java.lang.String r9 = "mobile"
                                java.lang.String r4 = r8.optString(r9)     // Catch:{ Exception -> 0x0126 }
                            L_0x00bd:
                                com.baidu.sapi2.outsdk.OneKeyLoginSdkCall r8 = new com.baidu.sapi2.outsdk.OneKeyLoginSdkCall     // Catch:{ Exception -> 0x0126 }
                                r8.<init>()     // Catch:{ Exception -> 0x0126 }
                                com.baidu.sapi2.SapiAccountRepository$19 r9 = com.baidu.sapi2.SapiAccountRepository.AnonymousClass19.this     // Catch:{ Exception -> 0x0126 }
                                com.baidu.sapi2.callback.OneKeyLoginCallback r9 = r4     // Catch:{ Exception -> 0x0126 }
                                int r1 = java.lang.Integer.parseInt(r3)     // Catch:{ Exception -> 0x0126 }
                                r8.transMobile(r9, r1, r4)     // Catch:{ Exception -> 0x0126 }
                                return
                            L_0x00ce:
                                com.baidu.sapi2.outsdk.OneKeyLoginSdkCall r9 = new com.baidu.sapi2.outsdk.OneKeyLoginSdkCall     // Catch:{ Exception -> 0x0126 }
                                r9.<init>()     // Catch:{ Exception -> 0x0126 }
                                com.baidu.sapi2.SapiAccountRepository$19 r1 = com.baidu.sapi2.SapiAccountRepository.AnonymousClass19.this     // Catch:{ Exception -> 0x0126 }
                                com.baidu.sapi2.callback.OneKeyLoginCallback r1 = r4     // Catch:{ Exception -> 0x0126 }
                                int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ Exception -> 0x0126 }
                                r9.loadOneKeyLoginFail(r1, r3, r8)     // Catch:{ Exception -> 0x0126 }
                                return
                            L_0x00df:
                                org.json.JSONObject r8 = r1.optJSONObject(r5)     // Catch:{ Exception -> 0x0126 }
                                if (r8 == 0) goto L_0x00ec
                                java.lang.String r9 = "ppDatau"
                                java.lang.String r8 = r8.optString(r9)     // Catch:{ Exception -> 0x0126 }
                                goto L_0x00fa
                            L_0x00ec:
                                r8 = r0
                                goto L_0x00fa
                            L_0x00ee:
                                org.json.JSONObject r8 = r1.optJSONObject(r5)     // Catch:{ Exception -> 0x0126 }
                                if (r8 == 0) goto L_0x00ec
                                java.lang.String r9 = "verifyUrl"
                                java.lang.String r8 = r8.optString(r9)     // Catch:{ Exception -> 0x0126 }
                            L_0x00fa:
                                boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x0126 }
                                if (r9 != 0) goto L_0x0119
                                com.baidu.sapi2.result.OneKeyLoginResult r9 = new com.baidu.sapi2.result.OneKeyLoginResult     // Catch:{ Exception -> 0x0126 }
                                r9.<init>()     // Catch:{ Exception -> 0x0126 }
                                r1 = -104(0xffffffffffffff98, float:NaN)
                                r9.setResultCode(r1)     // Catch:{ Exception -> 0x0126 }
                                com.baidu.sapi2.SapiAccountRepository$19 r1 = com.baidu.sapi2.SapiAccountRepository.AnonymousClass19.this     // Catch:{ Exception -> 0x0126 }
                                com.baidu.sapi2.callback.OneKeyLoginCallback r1 = r4     // Catch:{ Exception -> 0x0126 }
                                r1.onGuideProcess(r9)     // Catch:{ Exception -> 0x0126 }
                                com.baidu.sapi2.SapiAccountRepository$19 r9 = com.baidu.sapi2.SapiAccountRepository.AnonymousClass19.this     // Catch:{ Exception -> 0x0126 }
                                com.baidu.sapi2.callback.inner.LoadExternalWebViewActivityCallback r9 = r8     // Catch:{ Exception -> 0x0126 }
                                r9.needLoadExternalWebView(r4, r8)     // Catch:{ Exception -> 0x0126 }
                                goto L_0x013d
                            L_0x0119:
                                com.baidu.sapi2.outsdk.OneKeyLoginSdkCall r8 = new com.baidu.sapi2.outsdk.OneKeyLoginSdkCall     // Catch:{ Exception -> 0x0126 }
                                r8.<init>()     // Catch:{ Exception -> 0x0126 }
                                com.baidu.sapi2.SapiAccountRepository$19 r9 = com.baidu.sapi2.SapiAccountRepository.AnonymousClass19.this     // Catch:{ Exception -> 0x0126 }
                                com.baidu.sapi2.callback.OneKeyLoginCallback r9 = r4     // Catch:{ Exception -> 0x0126 }
                                r8.loadOneKeyLoginFail(r9, r7, r0)     // Catch:{ Exception -> 0x0126 }
                                goto L_0x013d
                            L_0x0126:
                                r8 = move-exception
                                com.baidu.sapi2.utils.Log.e(r8)
                                com.baidu.sapi2.outsdk.OneKeyLoginSdkCall r8 = new com.baidu.sapi2.outsdk.OneKeyLoginSdkCall
                                r8.<init>()
                                com.baidu.sapi2.SapiAccountRepository$19 r9 = com.baidu.sapi2.SapiAccountRepository.AnonymousClass19.this
                                com.baidu.sapi2.callback.OneKeyLoginCallback r9 = r4
                                r8.loadOneKeyLoginFail(r9, r7, r0)
                                java.lang.String r7 = "-113"
                                java.lang.String r8 = "json error"
                                com.baidu.sapi2.utils.SapiStatUtil.statOneKeyLoginPassAction(r2, r7, r8)
                            L_0x013d:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.SapiAccountRepository.AnonymousClass19.AnonymousClass1.onSuccess(int, java.lang.String, java.util.HashMap):void");
                        }
                    });
                    return;
                }
                com.baidu.sapi2.utils.Log.e(SapiAccountRepository.TAG, "oneKeyLogin execute JavaScript failed, it only support after KitKat version");
                new OneKeyLoginSdkCall().loadOneKeyLoginFail(oneKeyLoginCallback, -107, (String) null);
                SapiStatUtil.statOneKeyLoginPassAction(-1, "-100", "js execute fail");
            }
        });
    }

    public void getUserInfo(GetUserInfoCallback getUserInfoCallback, String str, String str2) {
        com.baidu.sapi2.utils.Log.d(TAG, "getUserInfo: 2");
        getUserInfo(getUserInfoCallback, str, str2, "", "");
    }

    public void getUserInfo(GetUserInfoCallback getUserInfoCallback, String str, String str2, String str3) {
        SapiUtils.notNull(getUserInfoCallback, GetUserInfoCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        SapiAccount accountFromBduss = SapiContext.getInstance().getAccountFromBduss(str);
        getUserInfo(getUserInfoCallback, str, accountFromBduss != null ? accountFromBduss.ptoken : null, str2, str3);
    }

    public void getUserInfo(final GetUserInfoCallback getUserInfoCallback, String str, String str2, String str3, String str4) {
        com.baidu.sapi2.utils.Log.d(TAG, "getUserInfo: 3");
        SapiUtils.notNull(getUserInfoCallback, GetUserInfoCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        getUserInfo(str, str2, str3, str4, (NetCallback) new NetCallback() {
            public void onFailure(Throwable th2, int i2, String str) {
                GetUserInfoResult getUserInfoResult = new GetUserInfoResult();
                getUserInfoResult.setResultCode(i2);
                getUserInfoCallback.onFailure(getUserInfoResult);
            }

            public void onSuccess(int i2, String str) {
                GetUserInfoResult getUserInfoResult = new GetUserInfoResult();
                int errorCode = SapiAccountRepository.this.getErrorCode(str);
                getUserInfoResult.setResultCode(errorCode);
                String access$200 = SapiAccountRepository.TAG;
                com.baidu.sapi2.utils.Log.d(access$200, "getUserInfo: onSuccess: resultCode:" + errorCode);
                if (errorCode == 0) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        String optString = jSONObject.optString("portrait_tag");
                        getUserInfoResult.portraitSign = optString;
                        getUserInfoResult.isInitialPortrait = "0".equals(optString);
                        String optString2 = jSONObject.optString(SapiAccount.SAPI_ACCOUNT_PORTRAIT);
                        if (!TextUtils.isEmpty(optString2)) {
                            getUserInfoResult.portrait = String.format("http://himg.bdimg.com/sys/portrait/item/%s.jpg?%s", new Object[]{optString2, getUserInfoResult.portraitSign});
                            getUserInfoResult.portraitHttps = String.format("https://himg.bdimg.com/sys/portrait/item/%s.jpg?%s", new Object[]{optString2, getUserInfoResult.portraitSign});
                        }
                        getUserInfoResult.username = jSONObject.optString("username");
                        getUserInfoResult.uid = jSONObject.optString("userid");
                        getUserInfoResult.displayname = jSONObject.optString("displayname");
                        getUserInfoResult.incompleteUser = "1".equals(jSONObject.optString("incomplete_user"));
                        getUserInfoResult.secureMobile = jSONObject.optString("securemobil");
                        getUserInfoResult.secureEmail = jSONObject.optString("secureemail");
                        getUserInfoResult.havePwd = "1".equals(jSONObject.optString("have_psw"));
                        getUserInfoResult.carSdkFace = jSONObject.optInt("carSdkFace");
                        getUserInfoResult.faceLoginSwitch = jSONObject.optInt("faceLoginSwitch");
                        getUserInfoCallback.onSuccess(getUserInfoResult);
                    } catch (Exception unused) {
                        getUserInfoCallback.onFailure(getUserInfoResult);
                    }
                } else if (errorCode != 400021) {
                    getUserInfoCallback.onFailure(getUserInfoResult);
                } else {
                    getUserInfoCallback.onBdussExpired(getUserInfoResult);
                }
            }
        });
    }

    public void getUserInfo(String str, String str2, String str3, String str4, NetCallback netCallback) {
        String str5 = str;
        final NetCallback netCallback2 = netCallback;
        com.baidu.sapi2.utils.Log.d(TAG, "getUserInfo: check params");
        SapiUtils.notNull(netCallback2, "callback can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("bduss", str);
        if (!TextUtils.isEmpty(str3)) {
            httpHashMapWrap.put("login_type", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            httpHashMapWrap.put("log_extra", str4);
        }
        if (!TextUtils.isEmpty(str2)) {
            String str6 = str2;
            httpHashMapWrap.put("ptoken", str2);
        }
        String deviceInfo = SapiDeviceInfo.getDeviceInfo(SapiEnv.GET_USER_INFO_URI);
        if (!TextUtils.isEmpty(deviceInfo)) {
            httpHashMapWrap.put("di", deviceInfo);
        }
        String str7 = TAG;
        com.baidu.sapi2.utils.Log.d(str7, "getUserInfo: begin request: clientid:" + httpHashMapWrap.get("clientid"));
        new HttpClientWrap().post(SapiEnv.GET_USER_INFO_URI, httpHashMapWrap, (List<HttpCookie>) null, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) {
            public void onFailure(Throwable th2, int i2, String str) {
                String access$200 = SapiAccountRepository.TAG;
                com.baidu.sapi2.utils.Log.d(access$200, "getUserInfo: request onFailure, code:" + i2 + ", responseBody:" + str);
                netCallback2.onFailure(th2, i2, str);
            }

            public void onSuccess(int i2, String str) {
                String access$200 = SapiAccountRepository.TAG;
                com.baidu.sapi2.utils.Log.d(access$200, "getUserInfo: request onSuccess, code:" + i2);
                netCallback2.onSuccess(i2, str);
            }
        });
    }
}
