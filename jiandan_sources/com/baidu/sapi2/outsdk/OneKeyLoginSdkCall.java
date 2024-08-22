package com.baidu.sapi2.outsdk;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.alipay.sdk.m.x.c;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.inner.OneKeyLoginOptCallback;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.PassCoreVHelper;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sso.SSOManager;
import org.json.JSONException;
import org.json.JSONObject;

public class OneKeyLoginSdkCall {
    public static final int CONNECT_TIMEOUT = 15000;
    public static final String OKL_SCENE_INIT = "init";
    public static final String OKL_SCENE_LOGIN = "login";
    public static final String OKL_SCENE_PRODUCT = "product";
    public static final String OKL_SCENE_SAPI = "sapi";
    public static final int ONE_KEY_AVAILABLE = 1;
    public static final String OPERATOR_CHINA_MOBILE = "CMCC";
    public static final String OPERATOR_CHINA_TELECOM = "CTCC";
    public static final String OPERATOR_CHINA_UNICOM = "CUCC";
    public static final String OPERATOR_TYPE_CMCC = "CM";
    public static final String OPERATOR_TYPE_CTCC = "CT";
    public static final String OPERATOR_TYPE_CUCC = "CU";
    public static final String TAG = "OneKeyLogin";
    public static OneKeyLoginSdkCall instance;
    public static OneKeyLoginOptResult preLoginOptResult;
    public static String sOneKeyLoginAppKey;
    public static String sOneKeyLoginAppSecret;
    public static String signFromAbilityApi;

    public interface TokenListener extends NoProguard {
        void onGetTokenComplete(JSONObject jSONObject);
    }

    public static OneKeyLoginSdkCall getInstance() {
        if (instance == null) {
            instance = new OneKeyLoginSdkCall();
        }
        return instance;
    }

    public boolean checkSupOauth() {
        return preLoginOptResult != null;
    }

    public JSONObject getEncryptPhone() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (preLoginOptResult != null) {
                jSONObject.put("phone", preLoginOptResult.getSecurityPhone());
                jSONObject.put("operator", getOperatorType());
                jSONObject.put("CUVersion", "2");
            }
        } catch (JSONException e) {
            Log.e(TAG, (Throwable) e);
        }
        Log.d(TAG, "getEncryptPhone result:" + jSONObject.toString());
        return jSONObject;
    }

    public void getMobileOauthToken(SapiConfiguration sapiConfiguration, final TokenListener tokenListener) {
        try {
            SSOManager.fe().o(sapiConfiguration.context, 15000, new SSOManager.ISSOLoginListener() {
                public void onFinish(String str) {
                    Log.d(OneKeyLoginSdkCall.TAG, "getMobileOauthToken onFinish result=" + str);
                    OneKeyLoginOptResult formatOptResult = OneKeyLoginOptResult.formatOptResult(str);
                    String extraStr = formatOptResult.getExtraStr();
                    SapiStatUtil.statOneKeyOauthToken(formatOptResult.getCode(), formatOptResult.getSubCode(), true ^ TextUtils.isEmpty(extraStr) ? 1 : 0);
                    final JSONObject jSONObject = new JSONObject();
                    if (OneKeyLoginOptResult.isValid(formatOptResult)) {
                        try {
                            jSONObject.put("errno", 0);
                            jSONObject.put("operator", OneKeyLoginSdkCall.this.getOperatorType());
                            jSONObject.put("appid", OneKeyLoginSdkCall.sOneKeyLoginAppKey);
                            jSONObject.put("token", extraStr);
                            jSONObject.put("oneKeySdkVersion", c.d);
                        } catch (Exception e) {
                            Log.e(OneKeyLoginSdkCall.TAG, (Throwable) e);
                        }
                    } else {
                        try {
                            jSONObject.put("errno", 0);
                            jSONObject.put("operator", OneKeyLoginSdkCall.this.getOperatorType());
                        } catch (JSONException e2) {
                            Log.e(OneKeyLoginSdkCall.TAG, (Throwable) e2);
                        }
                    }
                    if (tokenListener != null) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                tokenListener.onGetTokenComplete(jSONObject);
                            }
                        });
                    }
                }
            });
        } catch (NoClassDefFoundError unused) {
            if (tokenListener != null) {
                try {
                    tokenListener.onGetTokenComplete(new JSONObject());
                } catch (Exception e) {
                    if (tokenListener != null) {
                        tokenListener.onGetTokenComplete(new JSONObject());
                    }
                    Log.e(TAG, e.getMessage());
                    return;
                }
            }
            Log.e(TAG, "please import the package : onekey_login_ssolibrary-*.aar");
        }
    }

    public String getOperatorType() {
        OneKeyLoginOptResult oneKeyLoginOptResult = preLoginOptResult;
        if (oneKeyLoginOptResult == null) {
            return null;
        }
        if ("1".equals(oneKeyLoginOptResult.getOperateType())) {
            return OPERATOR_TYPE_CMCC;
        }
        if ("2".equals(preLoginOptResult.getOperateType())) {
            return OPERATOR_TYPE_CUCC;
        }
        if ("3".equals(preLoginOptResult.getOperateType())) {
            return OPERATOR_TYPE_CTCC;
        }
        return null;
    }

    public OneKeyLoginOptResult getPreLoginOptResult() {
        return preLoginOptResult;
    }

    public void getToken(SapiConfiguration sapiConfiguration, final TokenListener tokenListener) {
        try {
            SSOManager.fe().yj(sapiConfiguration.context, 15000, new SSOManager.ISSOLoginListener() {
                public void onFinish(String str) {
                    Log.d(OneKeyLoginSdkCall.TAG, "SSOManager login onFinish result=" + str);
                    OneKeyLoginOptResult formatOptResult = OneKeyLoginOptResult.formatOptResult(str);
                    String extraStr = formatOptResult.getExtraStr();
                    SapiStatUtil.statOneKeyLoginSDKAction(formatOptResult.getCode(), formatOptResult.getSubCode(), TextUtils.isEmpty(extraStr) ^ true ? 1 : 0);
                    final JSONObject jSONObject = new JSONObject();
                    try {
                        if (OneKeyLoginOptResult.isValid(formatOptResult)) {
                            jSONObject.put("errno", 0);
                            jSONObject.put("code", 0);
                            jSONObject.put("appid", OneKeyLoginSdkCall.sOneKeyLoginAppKey);
                            jSONObject.put("token", extraStr);
                            jSONObject.put("oneKeySdkVersion", c.d);
                            jSONObject.put("operator", OneKeyLoginSdkCall.this.getOperatorType());
                            if (formatOptResult.getOperateType().equals("2")) {
                                jSONObject.put("CUVersion", "2");
                            }
                        }
                    } catch (JSONException e) {
                        Log.e(OneKeyLoginSdkCall.TAG, e.getMessage());
                    }
                    if (tokenListener != null) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                tokenListener.onGetTokenComplete(jSONObject);
                            }
                        });
                    }
                }
            });
        } catch (NoClassDefFoundError unused) {
            if (tokenListener != null) {
                try {
                    tokenListener.onGetTokenComplete(new JSONObject());
                } catch (Exception e) {
                    if (tokenListener != null) {
                        tokenListener.onGetTokenComplete(new JSONObject());
                    }
                    Log.e(TAG, e.getMessage());
                    return;
                }
            }
            Log.e(TAG, "please import the package : onekey_login_ssolibrary-*.aar");
        }
    }

    public void initOneKeyLoginSdk(SapiConfiguration sapiConfiguration) {
        try {
            sOneKeyLoginAppKey = PassCoreVHelper.getOneKeyLoginAppKey();
            sOneKeyLoginAppSecret = PassCoreVHelper.getOneKeyLoginAppSecret();
            SSOManager.fe().rg(sapiConfiguration.context, sOneKeyLoginAppKey, sOneKeyLoginAppSecret);
            SSOManager.fe().ad(sapiConfiguration.debug);
            SSOManager.fe().i(sapiConfiguration.context, sapiConfiguration.isAgreeDangerousProtocol());
        } catch (Exception e) {
            Log.e(e.getMessage(), new Object[0]);
        } catch (Throwable th2) {
            Log.e(th2.getMessage(), new Object[0]);
        }
    }

    public boolean isMeetOneKeyLoginGray(String str) {
        String str2;
        if (TextUtils.equals(str, OPERATOR_CHINA_MOBILE)) {
            str2 = SapiOptions.Gray.FUN_NAME_CHINA_MOBILE_OAUTH;
        } else if (TextUtils.equals(str, OPERATOR_CHINA_UNICOM)) {
            str2 = SapiOptions.Gray.FUN_NAME_CHINA_UNICOM_OAUTH;
        } else {
            str2 = TextUtils.equals(str, OPERATOR_CHINA_TELECOM) ? SapiOptions.Gray.FUN_NAME_CHINA_TELECOM_OAUTH : null;
        }
        Log.d(TAG, "isMeetOneKeyLoginGray ? operator=" + str);
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        return SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(str2).isMeetGray();
    }

    public void loadOneKeyLoginFail(OneKeyLoginCallback oneKeyLoginCallback, int i2, String str) {
        if (oneKeyLoginCallback != null) {
            OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
            oneKeyLoginResult.setResultCode(i2);
            oneKeyLoginResult.setResultMsg(str);
            oneKeyLoginCallback.onFail(oneKeyLoginResult);
        }
    }

    public void preGetPhoneFail(OneKeyLoginCallback oneKeyLoginCallback, int i2, int i3, String str) {
        if (oneKeyLoginCallback != null) {
            OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
            oneKeyLoginResult.setResultCode(i2);
            oneKeyLoginResult.setResultMsg("subCode=" + i3 + ", msg=" + str);
            oneKeyLoginCallback.unAvailable(oneKeyLoginResult);
        }
    }

    public void preGetPhoneInfo(SapiConfiguration sapiConfiguration, String str) {
        try {
            preGetPhoneInfo(sapiConfiguration.context, str, 15000, false, (OneKeyLoginOptCallback) null);
        } catch (NoClassDefFoundError unused) {
            Log.e(TAG, "please import the package : onekey_login_ssolibrary-*.aar");
        }
    }

    public void transMobile(OneKeyLoginCallback oneKeyLoginCallback, int i2, String str) {
        if (oneKeyLoginCallback != null) {
            OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
            oneKeyLoginResult.setResultCode(i2);
            oneKeyLoginResult.mobile = str;
            oneKeyLoginCallback.onFail(oneKeyLoginResult);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0059 A[Catch:{ NoClassDefFoundError -> 0x00bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0095 A[Catch:{ NoClassDefFoundError -> 0x00bd }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void preGetPhoneInfo(android.content.Context r7, final java.lang.String r8, int r9, boolean r10, final com.baidu.sapi2.callback.inner.OneKeyLoginOptCallback r11) {
        /*
            r6 = this;
            java.lang.System.currentTimeMillis()
            java.lang.String r0 = "OneKeyLogin"
            r1 = 0
            r2 = 1
            if (r10 != 0) goto L_0x002f
            com.baidu.sapi2.SapiAccountManager r10 = com.baidu.sapi2.SapiAccountManager.getInstance()     // Catch:{ NoClassDefFoundError -> 0x00bd }
            boolean r10 = r10.isLogin()     // Catch:{ NoClassDefFoundError -> 0x00bd }
            if (r10 == 0) goto L_0x002f
            java.lang.Object[] r7 = new java.lang.Object[r2]     // Catch:{ NoClassDefFoundError -> 0x00bd }
            java.lang.String r8 = "preGetPhoneInfo account is logined"
            r7[r1] = r8     // Catch:{ NoClassDefFoundError -> 0x00bd }
            com.baidu.sapi2.utils.Log.d(r0, r7)     // Catch:{ NoClassDefFoundError -> 0x00bd }
            if (r11 == 0) goto L_0x002e
            com.baidu.sapi2.result.OneKeyLoginOptResult r7 = new com.baidu.sapi2.result.OneKeyLoginOptResult     // Catch:{ NoClassDefFoundError -> 0x00bd }
            r7.<init>()     // Catch:{ NoClassDefFoundError -> 0x00bd }
            r8 = -110(0xffffffffffffff92, float:NaN)
            r7.setCode(r8)     // Catch:{ NoClassDefFoundError -> 0x00bd }
            r7.setSubCode(r8)     // Catch:{ NoClassDefFoundError -> 0x00bd }
            r11.onFinish(r7)     // Catch:{ NoClassDefFoundError -> 0x00bd }
        L_0x002e:
            return
        L_0x002f:
            java.lang.String r10 = com.baidu.sapi2.utils.SapiUtils.getNetworkClass(r7)     // Catch:{ NoClassDefFoundError -> 0x00bd }
            com.baidu.sso.SSOManager r3 = com.baidu.sso.SSOManager.fe()     // Catch:{ NoClassDefFoundError -> 0x00bd }
            java.lang.String r3 = r3.de(r7)     // Catch:{ NoClassDefFoundError -> 0x00bd }
            java.lang.String r4 = "CMCC"
            boolean r4 = android.text.TextUtils.equals(r3, r4)     // Catch:{ NoClassDefFoundError -> 0x00bd }
            if (r4 != 0) goto L_0x0056
            java.lang.String r4 = "CUCC"
            boolean r4 = android.text.TextUtils.equals(r3, r4)     // Catch:{ NoClassDefFoundError -> 0x00bd }
            if (r4 != 0) goto L_0x0056
            java.lang.String r4 = "CTCC"
            boolean r4 = android.text.TextUtils.equals(r3, r4)     // Catch:{ NoClassDefFoundError -> 0x00bd }
            if (r4 == 0) goto L_0x0054
            goto L_0x0056
        L_0x0054:
            r4 = 0
            goto L_0x0057
        L_0x0056:
            r4 = 1
        L_0x0057:
            if (r4 == 0) goto L_0x0095
            boolean r4 = r6.isMeetOneKeyLoginGray(r3)     // Catch:{ NoClassDefFoundError -> 0x00bd }
            if (r4 != 0) goto L_0x0087
            java.lang.Object[] r7 = new java.lang.Object[r2]     // Catch:{ NoClassDefFoundError -> 0x00bd }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ NoClassDefFoundError -> 0x00bd }
            r8.<init>()     // Catch:{ NoClassDefFoundError -> 0x00bd }
            java.lang.String r9 = "未命中灰度，不请求预取号操作 operator="
            r8.append(r9)     // Catch:{ NoClassDefFoundError -> 0x00bd }
            r8.append(r3)     // Catch:{ NoClassDefFoundError -> 0x00bd }
            java.lang.String r8 = r8.toString()     // Catch:{ NoClassDefFoundError -> 0x00bd }
            r7[r1] = r8     // Catch:{ NoClassDefFoundError -> 0x00bd }
            com.baidu.sapi2.utils.Log.d(r0, r7)     // Catch:{ NoClassDefFoundError -> 0x00bd }
            if (r11 == 0) goto L_0x0086
            com.baidu.sapi2.result.OneKeyLoginOptResult r7 = new com.baidu.sapi2.result.OneKeyLoginOptResult     // Catch:{ NoClassDefFoundError -> 0x00bd }
            r7.<init>()     // Catch:{ NoClassDefFoundError -> 0x00bd }
            r8 = -121(0xffffffffffffff87, float:NaN)
            r7.setCode(r8)     // Catch:{ NoClassDefFoundError -> 0x00bd }
            r11.onFinish(r7)     // Catch:{ NoClassDefFoundError -> 0x00bd }
        L_0x0086:
            return
        L_0x0087:
            com.baidu.sso.SSOManager r3 = com.baidu.sso.SSOManager.fe()     // Catch:{ NoClassDefFoundError -> 0x00bd }
            long r4 = (long) r9     // Catch:{ NoClassDefFoundError -> 0x00bd }
            com.baidu.sapi2.outsdk.OneKeyLoginSdkCall$1 r9 = new com.baidu.sapi2.outsdk.OneKeyLoginSdkCall$1     // Catch:{ NoClassDefFoundError -> 0x00bd }
            r9.<init>(r8, r10, r11)     // Catch:{ NoClassDefFoundError -> 0x00bd }
            r3.uk(r7, r4, r9)     // Catch:{ NoClassDefFoundError -> 0x00bd }
            goto L_0x00d9
        L_0x0095:
            java.lang.Object[] r7 = new java.lang.Object[r2]     // Catch:{ NoClassDefFoundError -> 0x00bd }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ NoClassDefFoundError -> 0x00bd }
            r8.<init>()     // Catch:{ NoClassDefFoundError -> 0x00bd }
            java.lang.String r9 = "不能获取正确的运营商信息，请检查手机是否有sim卡，operator="
            r8.append(r9)     // Catch:{ NoClassDefFoundError -> 0x00bd }
            r8.append(r3)     // Catch:{ NoClassDefFoundError -> 0x00bd }
            java.lang.String r8 = r8.toString()     // Catch:{ NoClassDefFoundError -> 0x00bd }
            r7[r1] = r8     // Catch:{ NoClassDefFoundError -> 0x00bd }
            com.baidu.sapi2.utils.Log.d(r0, r7)     // Catch:{ NoClassDefFoundError -> 0x00bd }
            if (r11 == 0) goto L_0x00bc
            com.baidu.sapi2.result.OneKeyLoginOptResult r7 = new com.baidu.sapi2.result.OneKeyLoginOptResult     // Catch:{ NoClassDefFoundError -> 0x00bd }
            r7.<init>()     // Catch:{ NoClassDefFoundError -> 0x00bd }
            r8 = -115(0xffffffffffffff8d, float:NaN)
            r7.setCode(r8)     // Catch:{ NoClassDefFoundError -> 0x00bd }
            r11.onFinish(r7)     // Catch:{ NoClassDefFoundError -> 0x00bd }
        L_0x00bc:
            return
        L_0x00bd:
            if (r11 == 0) goto L_0x00d0
            com.baidu.sapi2.result.OneKeyLoginOptResult r7 = new com.baidu.sapi2.result.OneKeyLoginOptResult
            r7.<init>()
            r8 = -101(0xffffffffffffff9b, float:NaN)
            r7.setCode(r8)
            r7.setSubCode(r8)
            r11.onFinish(r7)
        L_0x00d0:
            java.lang.Object[] r7 = new java.lang.Object[r2]
            java.lang.String r8 = "please import the package : onekey_login_ssolibrary-*.aar"
            r7[r1] = r8
            com.baidu.sapi2.utils.Log.e((java.lang.String) r0, (java.lang.Object[]) r7)
        L_0x00d9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.outsdk.OneKeyLoginSdkCall.preGetPhoneInfo(android.content.Context, java.lang.String, int, boolean, com.baidu.sapi2.callback.inner.OneKeyLoginOptCallback):void");
    }

    public void preGetPhoneFail(OneKeyLoginCallback oneKeyLoginCallback, int i2, String str) {
        if (oneKeyLoginCallback != null) {
            OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
            oneKeyLoginResult.setResultCode(i2);
            oneKeyLoginResult.setResultMsg(str);
            oneKeyLoginCallback.unAvailable(oneKeyLoginResult);
        }
    }
}
