package com.baidu.sapi2.activity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.baidu.aiscan.R;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.http.ReqPriority;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.dto.WebSocialLoginDTO;
import com.baidu.sapi2.enums.LoginTypes;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.ShareLoginModel;
import com.baidu.sapi2.share.ShareResultCallback;
import com.baidu.sapi2.share.ShareStatKey;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.social.DingDingInvokeCallback;
import com.baidu.sapi2.social.SocialLoginBase;
import com.baidu.sapi2.social.WXInvokeCallback;
import com.baidu.sapi2.utils.CommonUtil;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.PtokenStat;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.a;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.views.SweepLightLoadingView;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends BaseActivity {
    public static final String EXTRA_LOGIN_FINISH_AFTER_SUC = "extra_login_finish_after_suc";
    public static final String EXTRA_LOGIN_TYPE = "extra_login_type";
    public static final String EXTRA_PARAM_ENCRYPTED_UID = "encryptedUid";
    public static final String EXTRA_PARAM_EXTRAS_JSON = "extraJson";
    public static final String EXTRA_PARAM_PAGE_LOGIN = "page_login";
    public static final String EXTRA_PARAM_THIRD_VERIFY_RESPONSE = "response";
    public static final String EXTRA_PARAM_USERNAME = "username";
    public static final int FIX_FLAG_WINDOW_IS_PARTIALLY_OBSCURED = 2;
    public static final String H = "LoginActivity";
    public static final int I = 2005;
    public static final String J = "floating_window_tag";
    public static final String K = "login_page_tag";
    public static final int REQUEST_SHARE_V2_LOGIN = 2020;
    public static final int REQUEST_SOCIAL_LOGIN = 2001;
    public static final int RESULT_CODE_SWITCH_ACCOUNT = 1001;
    public static boolean supportShareLogin = true;
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public List<PassNameValuePair> F;
    public AuthorizationListener G = new AuthorizationListener() {
        public void beforeSuccess(SapiAccount sapiAccount) {
            super.beforeSuccess(sapiAccount);
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder();
            sb.append("beforeSuccess: ");
            sb.append(sapiAccount != null ? sapiAccount.getAccountType() : StringUtil.NULL_STRING);
            objArr[0] = sb.toString();
            Log.d(LoginActivity.H, objArr);
            WebAuthListener webAuthListener = CoreViewRouter.getInstance().getWebAuthListener();
            if (webAuthListener != null) {
                webAuthListener.beforeSuccess(sapiAccount);
            }
        }

        public void onFailed(int i2, String str) {
            Log.d(LoginActivity.H, "onFailed: " + i2 + "  " + str);
            if (LoginActivity.this.z == 2003) {
                LoginActivity.this.setResult(0);
                return;
            }
            LoginActivity.this.webAuthResult.setResultCode(i2);
            LoginActivity.this.webAuthResult.setResultMsg(str);
            LoginActivity loginActivity = LoginActivity.this;
            loginActivity.loginFail(loginActivity.webAuthResult);
        }

        public boolean onForgetPwd() {
            Log.d(LoginActivity.H, "onForgetPwd: ");
            LoginActivity.this.startActivity(new Intent(LoginActivity.this, ForgetPwdActivity.class));
            return true;
        }

        public void onSuccess(AccountType accountType) {
            super.onSuccess(accountType);
            Log.d(LoginActivity.H, "onSuccess: " + accountType);
            LoginActivity.this.a(accountType, false);
        }
    };
    public boolean mNeedSetContentView = true;
    public SapiWebView sapiWebView;
    public boolean w = false;
    public WebAuthResult webAuthResult = new WebAuthResult() {
        public void finishActivity() {
            super.finishActivity();
            Log.d(LoginActivity.H, "finishActivity: ");
            LoginActivity.this.b(true);
        }

        public void finishActivity(boolean z) {
            super.finishActivity();
            Log.d(LoginActivity.H, "finishActivity: " + z);
            LoginActivity.this.b(false);
        }
    };
    public boolean x;
    public boolean y;
    public int z;

    @TargetApi(5)
    public void finish() {
        super.finish();
        if (this.z == 2005) {
            startActivity(new Intent(this, GrantWebActivity.class));
        }
        SocialLoginBase.setWXLoginCallback((WXInvokeCallback) null);
        SocialLoginBase.setDingDingInvokeCallback((DingDingInvokeCallback) null);
    }

    public SapiWebDTO getWebDTO() {
        return CoreViewRouter.getInstance().getWebLoginDTO();
    }

    public void init() {
        super.init();
        this.webAuthResult.activity = this;
        this.y = getIntent().getBooleanExtra(EXTRA_LOGIN_FINISH_AFTER_SUC, true);
    }

    public void loginFail(WebAuthResult webAuthResult2) {
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("loginFail: ");
        sb.append(webAuthResult2 != null ? Integer.valueOf(webAuthResult2.getResultCode()) : "webAuthResult is null");
        objArr[0] = sb.toString();
        Log.d(H, objArr);
        if (this.z == 2003) {
            finish();
            return;
        }
        WebAuthListener webAuthListener = CoreViewRouter.getInstance().getWebAuthListener();
        if (webAuthListener != null) {
            webAuthListener.onFailure(webAuthResult2);
        }
        finish();
        if (f()) {
            CoreViewRouter.getInstance().release();
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        int i4;
        Log.d(H, "onActivityResult: " + i2 + " resultCode: " + i3);
        super.onActivityResult(i2, i3, intent);
        new ShareCallPacking().onLoginActivityActivityResult(new ShareCallPacking.ShareLoginCallBack() {
            public void onSuccess() {
                LoginActivity.this.a(AccountType.NORMAL, false);
            }
        }, i2, i3, intent, this.F, ShareStatKey.PASS_INNER);
        if ((i2 == 2001 && i3 == 1001) || this.w) {
            Log.d(H, "onActivityResult: + REQUEST_SOCIAL_LOGIN ");
            a((AccountType) null, true);
            this.w = false;
        } else if (i2 == 2005) {
            if (i3 == -1) {
                Log.d(H, "onActivityResult: + Activity.RESULT_OK ");
                String str2 = "";
                if (intent != null) {
                    str2 = intent.getStringExtra(LoadExternalWebViewActivity.EXTRA_BUSINESS_TYPE);
                    str = intent.getStringExtra("username");
                } else {
                    str = str2;
                }
                if (LoadExternalWebViewActivity.RESULT_BUSINESS_TYPE_PRE_SET_UNAME.equals(str2)) {
                    this.sapiWebView.preSetUserName(str);
                } else if (LoadExternalWebViewActivity.RESULT_BUSINESS_TYPE_ACCOUNT_FREEZE.equals(str2)) {
                    this.webAuthResult.isAccountFreeze = true;
                } else {
                    if (intent == null) {
                        i4 = AccountType.UNKNOWN.getType();
                    } else {
                        i4 = intent.getIntExtra("account_type", AccountType.UNKNOWN.getType());
                    }
                    a(AccountType.getAccountType(i4), false);
                }
            }
        } else if (i2 == 2020) {
            a(AccountType.NORMAL, false);
        } else if (i2 == 100004) {
            ShareLoginModel.getInstance().processShareResult(this, intent, new ShareResultCallback() {
                public void onResultAccount(SapiAccount sapiAccount) {
                    WebAuthListener webAuthListener = CoreViewRouter.getInstance().getWebAuthListener();
                    if (sapiAccount == null) {
                        Toast.makeText(LoginActivity.this, "授权失败，请选择其他方式登录", 0).show();
                        WebLoginDTO webLoginDTO = new WebLoginDTO();
                        webLoginDTO.excludeTypes = LoginTypes.SHARE;
                        CoreViewRouter.getInstance().startLogin(webAuthListener, webLoginDTO);
                        return;
                    }
                    if (webAuthListener != null) {
                        WebAuthResult webAuthResult = new WebAuthResult();
                        webAuthResult.accountType = AccountType.NORMAL;
                        webAuthResult.setResultCode(0);
                        webAuthListener.onSuccess(webAuthResult);
                    }
                    if (LoginActivity.this.z == 2006) {
                        LoginActivity.this.setResult(1001);
                    }
                    LoginActivity.this.finish();
                    CoreViewRouter.getInstance().release();
                }
            });
        }
        if (i2 == 2001 && i3 == 4001) {
            a(intent);
        }
    }

    public void onBottomBackBtnClick() {
        this.sapiWebView.back();
    }

    public void onClose() {
        super.onClose();
        this.webAuthResult.setResultCode(-301);
        this.webAuthResult.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
        loginFail(this.webAuthResult);
    }

    public void onCreate(Bundle bundle) {
        SapiWebView sapiWebView2;
        super.onCreate(bundle);
        try {
            if (this.mNeedSetContentView) {
                setContentView(R.layout.layout_sapi_sdk_webview_with_title_bar);
                a.a((Activity) this);
            }
            init();
            setupViews();
            e();
            StatService.onEvent(K, new HashMap());
            SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
            if (confignation == null || !confignation.isAgreeDangerousProtocol()) {
                CommonUtil.showErrorNotice("需要同意隐私协议并同步pass");
            }
            if (getWebDTO() != null && (sapiWebView2 = this.sapiWebView) != null) {
                sapiWebView2.mExcludeTypes = getWebDTO().excludeTypes;
                this.sapiWebView.mExcludeTypesList = getWebDTO().excludeTypesList;
            }
        } catch (Throwable th2) {
            reportWebviewError(th2);
            this.webAuthResult.setResultCode(-202);
            this.webAuthResult.setResultMsg(SapiResult.ERROR_MSG_UNKNOWN);
            loginFail(this.webAuthResult);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.sapiWebView != null) {
            this.sapiWebView = null;
        }
    }

    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (this.executeSubClassMethod) {
            this.sapiWebView.back();
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        SapiWebView sapiWebView2 = this.sapiWebView;
        if (sapiWebView2 != null) {
            sapiWebView2.mExcludeTypes = LoginTypes.SHARE;
            setTitleText((int) R.string.sapi_sdk_title_sms_login);
            this.sapiWebView.loadLogin(1, this.F);
        }
    }

    public void onRightBtnClick() {
        super.onRightBtnClick();
    }

    public void setupViews() {
        super.setupViews();
        WebLoginDTO webLoginDTO = CoreViewRouter.getInstance().getWebLoginDTO();
        this.F = webLoginDTO != null ? webLoginDTO.extraParams : new ArrayList<>();
        this.z = getIntent().getIntExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2001);
        this.A = getIntent().getStringExtra("username");
        this.B = webLoginDTO != null ? webLoginDTO.preLoginName : "";
        this.C = getIntent().getStringExtra(EXTRA_LOGIN_TYPE);
        this.D = getIntent().getStringExtra(EXTRA_PARAM_ENCRYPTED_UID);
        this.E = getIntent().getStringExtra("extraJson");
        this.sapiWebView = (SapiWebView) findViewById(R.id.sapi_webview);
        c();
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() {
            public void onFinish() {
                LoginActivity.this.onClose();
            }
        });
        this.sapiWebView.setAuthorizationListener(this.G);
        this.sapiWebView.setSocialLoginHandler(new Handler() {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                Log.d(LoginActivity.H, "setupViews - handleMessage: ");
                AbstractThirdPartyService thirdPartyService = CoreViewRouter.getInstance().getThirdPartyService();
                if (thirdPartyService != null) {
                    LoginActivity loginActivity = LoginActivity.this;
                    thirdPartyService.loadThirdPartyLogin(loginActivity, (SocialType) message.obj, loginActivity.z, LoginActivity.this.E, false, true, (WebSocialLoginDTO) null);
                    SocialLoginBase.setWXLoginCallback(new WXInvokeCallback() {
                        public void onResult(int i2, Intent intent) {
                            int intExtra;
                            Log.d(LoginActivity.H, "login activity handleMessage - onResult: " + i2);
                            if (i2 == 1001) {
                                boolean unused = LoginActivity.this.w = true;
                            } else if (i2 == 1002 && intent != null && (intExtra = intent.getIntExtra("result_code", -1)) != 0 && intExtra != -301) {
                                String stringExtra = intent.getStringExtra(AbstractThirdPartyService.EXTRA_RESULT_TEXT);
                                if (TextUtils.isEmpty(stringExtra)) {
                                    stringExtra = "操作失败，请稍后再试或选择其他方式登录(" + intExtra + ")";
                                }
                                Toast.makeText(LoginActivity.this, stringExtra, 0).show();
                            }
                        }
                    });
                    SocialLoginBase.setDingDingInvokeCallback(new DingDingInvokeCallback() {
                        public void onResult(int i2, Intent intent) {
                            if (i2 == 1001) {
                                LoginActivity.this.a((AccountType) null, true);
                            }
                        }
                    });
                }
            }
        });
        this.sapiWebView.setLoadExternalWebViewCallback(new SapiWebView.LoadExternalWebViewCallback() {
            public void loadExternalWebview(SapiWebView.LoadExternalWebViewResult loadExternalWebViewResult) {
                Log.d(LoginActivity.H, "loadExternalWebview: " + loadExternalWebViewResult.defaultTitle + " - " + loadExternalWebViewResult.externalUrl);
                Intent intent = new Intent(LoginActivity.this, LoadExternalWebViewActivity.class);
                intent.putExtra("extra_external_title", loadExternalWebViewResult.defaultTitle);
                intent.putExtra("extra_external_url", loadExternalWebViewResult.externalUrl);
                intent.putExtra(LoadExternalWebViewActivity.EXTRA_PAGE_FROM, LoginActivity.EXTRA_PARAM_PAGE_LOGIN);
                LoginActivity.this.startActivityForResult(intent, 2005);
            }
        });
        this.sapiWebView.loadHistoryLogin(new SapiWebView.HistoryLoginCallback() {
            public void onSuccess() {
                if (LoginActivity.this.z == 2006) {
                    LoginActivity.this.setResult(1001);
                }
                if (LoginActivity.this.y) {
                    LoginActivity.this.finish();
                }
            }
        });
        if (supportShareLogin) {
            this.sapiWebView.setShareAccountClickCallback(new SapiWebView.ShareAccountClickCallback() {
                public void onClick(String str, String str2, String str3, String str4, String str5) {
                    if (ShareLoginModel.getInstance().isMeetShareV4(LoginActivity.this, str)) {
                        Log.d(LoginActivity.H, "openShareLogin: is meet share_v4");
                        ShareLoginModel.getInstance().openV4ShareLogin(LoginActivity.this, str, ShareStatKey.PASS_INNER);
                        return;
                    }
                    Log.d(LoginActivity.H, "openShareLogin: is not share_v4");
                    ShareCallPacking shareCallPacking = new ShareCallPacking();
                    LoginActivity loginActivity = LoginActivity.this;
                    shareCallPacking.startLoginShareActivityForResult(loginActivity, str, str2, str3, str4, loginActivity.F, str5, ShareStatKey.PASS_INNER);
                }
            });
        }
        this.sapiWebView.setCustomProtocolCallBack(new SapiJsCallBacks.CustomProtocolCallBack() {
            public String getCustomProtocol(String str) {
                return str;
            }
        });
        this.sapiWebView.setWebviewClientCallback(new SapiWebView.WebviewClientCallback() {
            public void onPageFinished(WebView webView, String str) {
                if (str.contains("/passport/login")) {
                    LoginActivity.this.d();
                }
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            }

            public void shouldOverrideUrlLoading(WebView webView, String str) {
            }
        });
        SapiJsCallBacks.JoinLoginParams joinLoginParams = new SapiJsCallBacks.JoinLoginParams();
        if (!TextUtils.isEmpty(this.D) && !TextUtils.isEmpty(this.A)) {
            if (webLoginDTO == null) {
                webLoginDTO = new WebLoginDTO();
            }
            webLoginDTO.encryptedId = this.D;
            webLoginDTO.preSetUname = this.A;
        }
        if (webLoginDTO != null) {
            if (!TextUtils.isEmpty(webLoginDTO.encryptedId) || !TextUtils.isEmpty(webLoginDTO.uid) || !TextUtils.isEmpty(webLoginDTO.preSetUname)) {
                SapiJsCallBacks.DirectedLoginParams directedLoginParams = new SapiJsCallBacks.DirectedLoginParams();
                directedLoginParams.uid = webLoginDTO.uid;
                directedLoginParams.encryptedId = webLoginDTO.encryptedId;
                directedLoginParams.displayname = webLoginDTO.preSetUname;
                this.F.add(SapiWebView.EXTRA_SUPPORT_DIRECT_LOGIN);
                this.sapiWebView.setDirectedLoginParams(directedLoginParams);
            }
            if (WebLoginDTO.statExtraValid(webLoginDTO.statExtra)) {
                this.F.add(new PassNameValuePair("extrajson", WebLoginDTO.getStatExtraDecode(webLoginDTO.statExtra)));
            }
            SapiWebView sapiWebView2 = this.sapiWebView;
            sapiWebView2.shareV2Disable = webLoginDTO.shareV2Disable;
            joinLoginParams.agreement = webLoginDTO.agreement;
            sapiWebView2.setHideSuccessTip(webLoginDTO.hideSuccessTip);
            WebLoginDTO.Config config = webLoginDTO.config;
            if (config != null) {
                this.sapiWebView.supportTouchGuide = config.supportTouchGuide;
            }
            this.F.add(new PassNameValuePair(SapiWebView.PARAMS_SCREEN_TYPE, String.valueOf(webLoginDTO.screenType)));
            this.F.add(new PassNameValuePair(SapiWebView.PARAMS_IS_ACCEPT_BROWSEMODE_AGREEMENT, String.valueOf(webLoginDTO.isAcceptBrowseModeAgreement)));
        }
        if (!TextUtils.isEmpty(this.E)) {
            try {
                JSONObject jSONObject = new JSONObject(this.E);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.F.add(new PassNameValuePair(next, jSONObject.getString(next)));
                }
            } catch (JSONException e) {
                Log.e(e);
            }
        }
        if (WebLoginDTO.EXTRA_JOIN_LOGIN_WITH_THIRD_ACCOUNT.equals(this.C)) {
            joinLoginParams.hasThirdAccount = true;
        } else {
            joinLoginParams.hasThirdAccount = false;
        }
        this.sapiWebView.setJoinLoingParams(joinLoginParams);
        setNewLoginTitleAndSetStyleChangeCallBack();
        if (WebLoginDTO.EXTRA_JOIN_LOGIN_WITH_THIRD_ACCOUNT.equals(this.C) || WebLoginDTO.EXTRA_JOIN_LOGIN_WITHOUT_THIRD_ACCOUNT.equals(this.C)) {
            this.sapiWebView.loadLogin(4, this.F);
        } else if (WebLoginDTO.EXTRA_LOGIN_WITH_SMS.equals(this.C)) {
            setTitleText((int) R.string.sapi_sdk_title_sms_login);
            this.sapiWebView.loadLogin(1, this.F);
        } else if (WebLoginDTO.EXTRA_LOGIN_WITH_NAME_PHONE_EMAIL.equals(this.C)) {
            this.sapiWebView.loadLogin(6, this.F);
        } else if (WebLoginDTO.EXTRA_LOGIN_WITH_PRE_LOGIN_NAME.equals(this.C)) {
            if (!TextUtils.isEmpty(this.B)) {
                this.F.add(new PassNameValuePair(SapiWebView.PARAMS_LOGIN_WITH_PRE_LOGIN_NAME, this.B));
            }
            this.sapiWebView.loadLogin(7, this.F);
        } else {
            if (!TextUtils.isEmpty(this.A)) {
                this.F.add(new PassNameValuePair("loginUserName", this.A));
            }
            setTitleText((int) R.string.sapi_sdk_title_login);
            this.sapiWebView.loadLogin(this.F);
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        HashMap hashMap = new HashMap();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        try {
            new HttpClientWrap().post(SapiAccountManager.getInstance().getSapiConfiguration().environment.getWap() + SapiEnv.SAPI_LOGIN_CONFIG_HTTPS_URI, ReqPriority.IMMEDIATE, httpHashMapWrap, hashMap, (List<HttpCookie>) null, (String) null, new HttpHandlerWrap(Looper.getMainLooper()) {
                public void onFailure(Throwable th2, int i2, String str) {
                    Log.e("requestLoginConfig errorCode:" + i2 + " responseBody:" + str, new Object[0]);
                }

                public void onSuccess(int i2, String str, HashMap<String, String> hashMap) {
                    if (str != null) {
                        Log.d("requestLoginConfig responseBody:" + str, new Object[0]);
                        try {
                            JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
                            if (optJSONObject != null && "true".equals(optJSONObject.optString("login_degrade"))) {
                                LoginActivity.this.sapiWebView.loadLogin(10, LoginActivity.this.F);
                            }
                        } catch (JSONException e) {
                            Log.e(e);
                        }
                    }
                }
            });
        } catch (Throwable th2) {
            Log.e(th2);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void e() {
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        SapiWebView sapiWebView2 = this.sapiWebView;
        if (sapiWebView2 != null && confignation != null && confignation.supportCheckFloatfLayer) {
            sapiWebView2.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (LoginActivity.this.x) {
                        return false;
                    }
                    if (!((motionEvent.getFlags() & 1) == 0 && (motionEvent.getFlags() & 2) == 0) && motionEvent.getAction() == 1) {
                        int height = LoginActivity.this.getWindowManager().getDefaultDisplay().getHeight();
                        Toast makeText = Toast.makeText(LoginActivity.this, "有悬浮窗遮挡，请注意信息安全！", 0);
                        makeText.setGravity(80, 0, (height / 2) - ((int) ((Resources.getSystem().getDisplayMetrics().density * 70.0f) + 0.5f)));
                        makeText.show();
                        boolean unused = LoginActivity.this.x = true;
                        StatService.onEvent(LoginActivity.J, new HashMap());
                    }
                    return false;
                }
            });
        }
    }

    private boolean f() {
        if (this.z != 2003 && CoreViewRouter.getInstance().getWebBindWidgetDTO() == null && CoreViewRouter.getInstance().getAccountCenterDTO() == null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void b(boolean z2) {
        finish();
        if (f() && z2) {
            CoreViewRouter.getInstance().release();
        }
    }

    private void c() {
        WebLoginDTO webLoginDTO = CoreViewRouter.getInstance().getWebLoginDTO();
        if (webLoginDTO != null) {
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.root_view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            final View sweepLightLoadingView = new SweepLightLoadingView(this);
            View view = webLoginDTO.loadingView;
            if (view != null) {
                relativeLayout.addView(view, layoutParams);
                sweepLightLoadingView = view;
            } else {
                relativeLayout.addView(sweepLightLoadingView, layoutParams);
            }
            sweepLightLoadingView.setVisibility(0);
            SapiWebView sapiWebView2 = this.sapiWebView;
            if (sapiWebView2 != null) {
                sapiWebView2.setOnLoginAssertLoadSuccessListener(new SapiWebView.OnLoginAssertLoadSuccessListener() {
                    public void onAssertLoadFinish() {
                        sweepLightLoadingView.setVisibility(8);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(AccountType accountType, boolean z2) {
        Log.d(H, "loginSucces: " + accountType + " socialLoginSuc: " + z2);
        PtokenStat ptokenStat = new PtokenStat();
        StringBuilder sb = new StringBuilder();
        sb.append(PtokenStat.LOGIN);
        sb.append(SapiUtils.getLastLoginType());
        ptokenStat.onEvent(sb.toString());
        int i2 = this.z;
        if (i2 == 2003) {
            Log.d(H, "loginSucces: EXTRA_PARAM_FROM_ACCOUNT_CENTER");
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            Intent intent = new Intent();
            intent.putExtra("bduss", currentAccount.bduss);
            setResult(-1, intent);
            if (this.y) {
                finish();
                return;
            }
            return;
        }
        if (i2 == 2006) {
            Log.d(H, "loginSucces: EXTRA_PARAM_FROM_ACCOUNT_THIRD_VERIFICATION");
            setResult(1001);
        }
        if (z2) {
            Log.d(H, "loginSucces: socialLoginSuc");
            finish();
            if (f()) {
                CoreViewRouter.getInstance().release();
                return;
            }
            return;
        }
        WebAuthListener webAuthListener = CoreViewRouter.getInstance().getWebAuthListener();
        if (webAuthListener != null) {
            Log.d(H, "loginSucces: webAuthListener");
            WebAuthResult webAuthResult2 = this.webAuthResult;
            webAuthResult2.accountType = accountType;
            webAuthResult2.setResultCode(0);
            webAuthListener.onSuccess(this.webAuthResult);
        }
        if (this.y) {
            finish();
            if (f()) {
                Log.d(H, "loginSucces: finishActivityAfterSuc");
                CoreViewRouter.getInstance().release();
            }
        }
    }

    private void a(Intent intent) {
        SapiJsCallBacks.CallBacks jsCallBacks;
        JsPromptResult promptResult;
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("resultThirdPartyVerify: ");
        sb.append(intent != null ? 1 : 0);
        objArr[0] = sb.toString();
        Log.d(H, objArr);
        SapiWebView sapiWebView2 = this.sapiWebView;
        if (sapiWebView2 != null && (jsCallBacks = sapiWebView2.getJsCallBacks()) != null && (promptResult = jsCallBacks.getPromptResult()) != null) {
            if (intent == null) {
                promptResult.cancel();
                return;
            }
            try {
                String stringExtra = intent.getStringExtra(EXTRA_PARAM_THIRD_VERIFY_RESPONSE);
                Log.d(H, "resultThirdPartyVerify: response" + stringExtra);
                promptResult.confirm(stringExtra);
            } catch (Exception unused) {
                promptResult.cancel();
            }
        }
    }
}
