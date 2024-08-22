package com.baidu.sapi2.activity;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.aiscan.R;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiAccountService;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.callback.SsoHashCallback;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.result.QrAppLoginResult;
import com.baidu.sapi2.result.SsoHashResult;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.QrLoginAction;
import com.baidu.sapi2.views.LoadingDialog;
import com.baidu.sapi2.views.ViewUtility;
import com.baidu.wallet.paysdk.datamodel.Bank;
import com.google.android.gms.common.Scopes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class OauthActivity extends BaseActivity {
    public static final String H = "extra_calling_app_id";
    public static final String I = "extra_oauth_result_json";
    public static final String J = "extra_redirect_url";
    public static final String K = "extra_scope";
    public static final String L = "extra_oauth_type";
    public static final String M = "extra_qr_code_url";
    public static final String N = "extra_oauth_sdk_version";
    public static final String O = "extra_pass_sdk_version";
    public static final String P = "extra_oauth_state";
    public static final String Q = "2.0.0";
    public static final int R = -201;
    public static final int S = -202;
    public static final int T = -204;
    public static final int U = -205;
    public static final int V = -208;
    public String A;
    public String B;
    public String C;
    public Dialog D;
    public int E = 0;
    public String F;
    public boolean G;
    public String w;
    public String x;
    public String y;
    public String z;

    public void init() {
        super.init();
        this.w = getCallingPackage();
        Intent intent = getIntent();
        try {
            this.x = intent.getStringExtra(H);
            this.y = intent.getStringExtra(J);
            this.z = intent.getStringExtra(K);
            this.E = intent.getIntExtra(L, 0);
            this.F = intent.getStringExtra(M);
            this.A = intent.getStringExtra(P);
            this.B = intent.getStringExtra(N);
        } catch (Exception unused) {
            setResult(0, a(-202));
            finish();
        }
        if (TextUtils.isEmpty(this.w) || TextUtils.isEmpty(this.x) || TextUtils.isEmpty(this.y) || TextUtils.isEmpty(this.z)) {
            setResult(0, a(-202));
            finish();
            this.G = true;
        }
        if (!TextUtils.isEmpty(this.F) && !a(this.F)) {
            setResult(0, a(-202));
            finish();
            this.G = true;
        }
        String stringExtra = intent.getStringExtra(O);
        this.C = stringExtra;
        if (!TextUtils.isEmpty(stringExtra) && SapiUtils.versionCompareTo(this.C, "9.10.7.3") > 0) {
            setResult(0, a(-208));
            finish();
            this.G = true;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.layout_sapi_sdk_webview_with_title_bar);
            if (d()) {
                this.configuration = SapiAccountManager.getInstance().getConfignation();
                init();
                if (!this.G) {
                    setupViews();
                }
            }
        } catch (Throwable unused) {
            setResult(0, a(-201));
            finish();
        }
    }

    public void onLeftBtnClick() {
        if (this.E == 1) {
            SapiAccountManager.getInstance().getAccountService().qrAppLogin(new SapiCallback<QrAppLoginResult>() {
                public void onFailure(QrAppLoginResult qrAppLoginResult) {
                }

                public void onFinish() {
                }

                public void onStart() {
                }

                public void onSuccess(QrAppLoginResult qrAppLoginResult) {
                }
            }, this.F, QrLoginAction.CANCEL.getName());
        }
        c();
    }

    public void setupViews() {
        super.setupViews();
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() {
            public boolean onBack() {
                OauthActivity.this.c();
                return false;
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() {
            public void onFinish() {
                OauthActivity oauthActivity = OauthActivity.this;
                oauthActivity.setResult(0, oauthActivity.a(-205));
                OauthActivity.this.finish();
            }
        });
        this.sapiWebView.setAuthorizationListener(new AuthorizationListener() {
            public void onFailed(int i2, String str) {
            }

            public void onSuccess() {
                OauthActivity.this.e();
                SapiAccountManager.getGlobalCallback().onLoginStatusChange();
            }
        });
        AnonymousClass5 r0 = new SapiJsCallBacks.BdOauthCallback() {
            public void onCallback(String str) {
                String str2 = str;
                Intent intent = new Intent();
                if (OauthActivity.this.E == 0) {
                    Map<String, String> urlParamsToMap = SapiUtils.urlParamsToMap(str2.substring(str2.indexOf(Bank.HOT_BANK_LETTER) + 1, str.length()));
                    if (urlParamsToMap.containsKey(SapiUtils.KEY_QR_LOGIN_ERROR)) {
                        OauthActivity oauthActivity = OauthActivity.this;
                        oauthActivity.setResult(0, oauthActivity.a(-204, urlParamsToMap.get(SapiUtils.KEY_QR_LOGIN_ERROR)));
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("refreshToken", urlParamsToMap.get("refresh_token"));
                            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_ACCESS_TOKEN, urlParamsToMap.get("access_token"));
                            jSONObject.put("expiresIn", urlParamsToMap.get("expires_in"));
                            jSONObject.put("scope", urlParamsToMap.get("scope"));
                            jSONObject.put(SapiAccount.SAPI_ACCOUNT_EXTRA, urlParamsToMap.get(SapiAccount.SAPI_ACCOUNT_EXTRA));
                            jSONObject.put("code", urlParamsToMap.get("code"));
                            jSONObject.put(WXLoginActivity.w, urlParamsToMap.get(WXLoginActivity.w));
                            intent.putExtra(OauthActivity.I, jSONObject.toString());
                            OauthActivity.this.setResult(-1, intent);
                        } catch (JSONException e) {
                            Log.e(e);
                            OauthActivity oauthActivity2 = OauthActivity.this;
                            oauthActivity2.setResult(0, oauthActivity2.a(-201));
                        }
                    }
                } else {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str2);
                        int optInt = jSONObject2.optInt("errNo");
                        jSONObject2.optInt("msg");
                        if (optInt == -301) {
                            OauthActivity.this.setResult(0, OauthActivity.this.a(-205));
                            OauthActivity.this.finish();
                            return;
                        }
                        if (optInt != 400021) {
                            if (optInt != 400022) {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_ACCESS_TOKEN, jSONObject2.optString("access_token"));
                                jSONObject3.put(Scopes.OPEN_ID, jSONObject2.optString(Scopes.OPEN_ID));
                                jSONObject3.put("expiresIn", jSONObject2.optString("expires_in"));
                                jSONObject3.put("scope", OauthActivity.this.z);
                                jSONObject3.put("code", jSONObject2.optString("authorization_code"));
                                jSONObject2.put(WXLoginActivity.w, jSONObject2.optString(WXLoginActivity.w));
                                intent.putExtra(OauthActivity.I, jSONObject3.toString());
                                OauthActivity.this.setResult(-1, intent);
                            }
                        }
                        OauthActivity.this.f();
                        return;
                    } catch (JSONException e2) {
                        Log.e(e2);
                        OauthActivity oauthActivity3 = OauthActivity.this;
                        oauthActivity3.setResult(0, oauthActivity3.a(-201));
                    }
                }
                OauthActivity.this.finish();
            }
        };
        SapiJsCallBacks.BdOauthLoginParams bdOauthLoginParams = new SapiJsCallBacks.BdOauthLoginParams();
        bdOauthLoginParams.callingPkg = this.w;
        bdOauthLoginParams.callingAppId = this.x;
        bdOauthLoginParams.redirectUrl = this.y;
        bdOauthLoginParams.callback = r0;
        this.sapiWebView.setBdOauthLoginParams(bdOauthLoginParams);
        if (!SapiAccountManager.getInstance().isLogin() || TextUtils.isEmpty(SapiUtils.getCookiePtoken())) {
            f();
        } else {
            e();
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null || !sapiWebView.canGoBack()) {
            setResult(0, a(-205));
            finish();
            return;
        }
        this.sapiWebView.goBack();
    }

    private boolean d() {
        if (SapiAccountManager.getInstance().getConfignation() == null) {
            SapiAccountManager.getGlobalCallback().onNeedInitPassSdk();
        }
        if (SapiAccountManager.getInstance().getConfignation() != null) {
            return true;
        }
        Log.e("pass sdk have not been initialized", new Object[0]);
        setResult(0, a(-201));
        return false;
    }

    /* access modifiers changed from: private */
    public void e() {
        SapiAccountManager.getInstance().getAccountService().generateSsoHash(new SsoHashCallback() {
            public void onFinish() {
                OauthActivity oauthActivity = OauthActivity.this;
                ViewUtility.dismissDialog(oauthActivity, oauthActivity.D);
            }

            public void onStart() {
                OauthActivity oauthActivity = OauthActivity.this;
                Dialog unused = oauthActivity.D = new LoadingDialog.Builder(oauthActivity).setMessage("正在加载中...").setCancelable(false).setCancelOutside(false).createDialog();
                if (!OauthActivity.this.isFinishing() && !OauthActivity.this.D.isShowing()) {
                    OauthActivity.this.D.show();
                }
            }

            public void onSuccess(SsoHashResult ssoHashResult) {
                String str;
                HashMap hashMap = new HashMap();
                hashMap.put("client", SapiDeviceInfo.OS_TYPE);
                hashMap.put("clientfrom", SapiAccountService.DISPLAY_TYPE_NATIVE);
                hashMap.put("suppcheck", "1");
                if (OauthActivity.this.E == 0) {
                    if (SapiUtils.versionCompareTo(OauthActivity.this.B, OauthActivity.Q) >= 0) {
                        hashMap.put(SapiUtils.KEY_QR_LOGIN_RESPONSE_TYPE, "sso_auth_code");
                        hashMap.put(WXLoginActivity.w, OauthActivity.this.A);
                    } else {
                        hashMap.put(SapiUtils.KEY_QR_LOGIN_RESPONSE_TYPE, "sso_token");
                    }
                    hashMap.put("display", "mobile");
                    hashMap.put("scope", OauthActivity.this.z);
                    hashMap.put("sso_hash", ssoHashResult.ssoHash);
                    hashMap.put(SapiUtils.KEY_QR_LOGIN_CLIENT_ID, OauthActivity.this.x);
                    hashMap.put(SapiUtils.KEY_QR_LOGIN_REDIRECT_URI, OauthActivity.this.y);
                    str = (SapiAccountManager.getInstance().getConfignation().environment.getDeviceUrl() + "/oauth/2.0/authorize") + SapiUtils.mapToUrlParams(hashMap, false);
                } else {
                    hashMap.put("oauth_sso_hash", ssoHashResult.ssoHash);
                    hashMap.put("oauth_redirect_uri", OauthActivity.this.y);
                    if (SapiUtils.versionCompareTo(OauthActivity.this.B, OauthActivity.Q) >= 0) {
                        hashMap.put("getauthorizationcode", "1");
                    } else {
                        hashMap.put("getaccesstoken", "1");
                    }
                    str = OauthActivity.this.F + SapiUtils.mapToUrlParams(hashMap, true);
                }
                SapiWebView sapiWebView = OauthActivity.this.sapiWebView;
                if (sapiWebView != null) {
                    sapiWebView.loadUrl(str);
                }
            }
        }, this.w, this.x);
    }

    /* access modifiers changed from: private */
    public void f() {
        final boolean z2 = SapiAccountManager.getInstance().getConfignation().supportFaceLogin;
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_USERNAME;
        SapiAccountManager.getInstance().getConfignation().supportFaceLogin = false;
        LoginActivity.supportShareLogin = false;
        WebLoginDTO.Config config = new WebLoginDTO.Config();
        config.fastLoginFeatureList = new ArrayList();
        webLoginDTO.config = config;
        CoreViewRouter.getInstance().startLogin(this, new WebAuthListener() {
            public void onFailure(WebAuthResult webAuthResult) {
                if (webAuthResult.getResultCode() == -301) {
                    OauthActivity oauthActivity = OauthActivity.this;
                    oauthActivity.setResult(0, oauthActivity.a(-205));
                    OauthActivity.this.finish();
                } else {
                    OauthActivity oauthActivity2 = OauthActivity.this;
                    oauthActivity2.setResult(0, oauthActivity2.a(-201));
                    OauthActivity.this.finish();
                }
                LoginActivity.supportShareLogin = true;
                SapiAccountManager.getInstance().getConfignation().supportFaceLogin = z2;
            }

            public void onSuccess(WebAuthResult webAuthResult) {
                OauthActivity.this.e();
                SapiAccountManager.getGlobalCallback().onLoginStatusChange();
                LoginActivity.supportShareLogin = true;
                SapiAccountManager.getInstance().getConfignation().supportFaceLogin = z2;
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        SapiUtils.hideSoftInput(OauthActivity.this);
                    }
                }, 300);
            }
        }, webLoginDTO);
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Uri parse = Uri.parse(str);
        parse.getHost();
        String[] strArr = {Uri.decode(parse.getQueryParameter("sign")), Uri.decode(parse.getQueryParameter(SapiUtils.KEY_QR_LOGIN_CLIENT_ID)), Uri.decode(parse.getQueryParameter("cmd")), Uri.decode(parse.getQueryParameter("tpl"))};
        for (int i2 = 0; i2 < 4; i2++) {
            if (TextUtils.isEmpty(strArr[i2])) {
                return false;
            }
        }
        String wap = SapiAccountManager.getInstance().getConfignation().getEnvironment().getWap();
        if (!wap.equals(parse.getScheme() + "://" + parse.getHost())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public Intent a(int i2, String str) {
        Intent intent = new Intent();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i2);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("msg", str);
            }
        } catch (JSONException e) {
            Log.e(e);
        }
        intent.putExtra(I, jSONObject.toString());
        return intent;
    }

    /* access modifiers changed from: private */
    public Intent a(int i2) {
        return a(i2, "");
    }
}
