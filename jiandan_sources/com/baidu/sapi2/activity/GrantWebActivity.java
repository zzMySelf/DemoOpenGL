package com.baidu.sapi2.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.aiscan.R;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiAccountService;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.AccountType;
import java.util.ArrayList;
import java.util.HashMap;

public class GrantWebActivity extends BaseActivity {
    public static final String B = GrantWebActivity.class.getSimpleName();
    public static final String C = "openapp";
    public static final String D = "/passport/grantweb";
    public String A;
    public String w;
    public String x;
    public String y;
    public String z;

    private boolean e() {
        Uri data;
        Intent intent = getIntent();
        String scheme = intent.getScheme();
        if (!"android.intent.action.VIEW".equals(intent.getAction()) || (data = intent.getData()) == null) {
            return false;
        }
        String host = data.getHost();
        String path = data.getPath();
        String packageName = SapiAccountManager.getInstance().getConfignation().getContext().getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            packageName = "";
        }
        return C.equals(scheme) && packageName.equals(host) && D.equals(path);
    }

    private boolean f() {
        if (SapiAccountManager.getInstance().getConfignation() == null) {
            SapiAccountManager.getGlobalCallback().onNeedInitPassSdk();
        }
        if (SapiAccountManager.getInstance().getConfignation() != null) {
            return true;
        }
        Log.e(Log.TAG, "pass sdk has not been initialized");
        return false;
    }

    /* access modifiers changed from: private */
    public void g() {
        boolean z2;
        if (SapiAccountManager.getCheckUrlIsAvailablelister() != null) {
            if (TextUtils.isEmpty(this.y)) {
                this.y = this.x;
            }
            z2 = SapiAccountManager.getCheckUrlIsAvailablelister().onCheckUrlIsAvailable(this.y);
        } else {
            z2 = false;
        }
        String str = SapiAccountManager.getInstance().getConfignation().environment.getWap() + "/passport/login";
        HashMap hashMap = new HashMap();
        hashMap.put("client", SapiDeviceInfo.OS_TYPE);
        hashMap.put("clientfrom", SapiAccountService.DISPLAY_TYPE_NATIVE);
        hashMap.put("suppcheck", "1");
        hashMap.put("adapter", "3");
        hashMap.put("channel_id", this.w);
        hashMap.put("wap_tpl", this.A);
        hashMap.put("tpl", SapiAccountManager.getInstance().getConfignation().tpl);
        hashMap.put("u", this.x);
        if (!z2 || "true".equals(this.z)) {
            hashMap.put("force", "true");
        } else {
            hashMap.put("force", "false");
        }
        String str2 = str + SapiUtils.mapToUrlParams(hashMap, false) + "#app_auth";
        Log.d(B, "url = " + str2);
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null) {
            sapiWebView.loadUrl(str2);
        }
    }

    public void init() {
        super.init();
        Uri data = getIntent().getData();
        if (data != null) {
            this.w = data.getQueryParameter("channel_id");
            this.x = data.getQueryParameter("u");
            this.y = data.getQueryParameter("nu");
            this.z = data.getQueryParameter("force");
            this.A = data.getQueryParameter("wap_tpl");
        }
        if (TextUtils.isEmpty(this.w)) {
            finish();
        }
    }

    public void onBottomBackBtnClick() {
        d();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.layout_sapi_sdk_webview_with_title_bar);
            if (!f() || !e()) {
                finish();
                return;
            }
            init();
            setupViews();
        } catch (Throwable th2) {
            Log.e(th2);
            finish();
        }
    }

    public void onLeftBtnClick() {
        d();
    }

    public void onNewIntent(Intent intent) {
        String str = B;
        Log.d(str, this + " onNewIntent");
        if (!SapiAccountManager.getInstance().isLogin() || TextUtils.isEmpty(SapiUtils.getCookiePtoken())) {
            b(false);
        } else {
            g();
        }
    }

    public void setupViews() {
        super.setupViews();
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null) {
            sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() {
                public boolean onBack() {
                    GrantWebActivity.this.d();
                    return false;
                }
            });
            this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() {
                public void onFinish() {
                    GrantWebActivity.this.finish();
                }
            });
            this.sapiWebView.setAuthorizationListener(new AuthorizationListener() {
                public void onFailed(int i2, String str) {
                    Log.d(GrantWebActivity.B, "GrantWebPage login failed");
                    GrantWebActivity.this.finish();
                }

                public void onSuccess(AccountType accountType) {
                    GrantWebActivity.this.g();
                    SapiAccountManager.getGlobalCallback().onLoginStatusChange();
                }
            });
            this.sapiWebView.setGrantWebCallback(new SapiJsCallBacks.GrantWebCallback() {
                public void onGrant(int i2) {
                    if (i2 == 0) {
                        Log.d(GrantWebActivity.B, "after grant web, then back to wap");
                        GrantWebActivity.this.finish();
                        return;
                    }
                    Log.d(GrantWebActivity.B, "after grant web, still stay in app");
                    if (SapiAccountManager.getCheckUrlIsAvailablelister() != null) {
                        if (TextUtils.isEmpty(GrantWebActivity.this.y)) {
                            GrantWebActivity grantWebActivity = GrantWebActivity.this;
                            String unused = grantWebActivity.y = grantWebActivity.x;
                        }
                        SapiAccountManager.getCheckUrlIsAvailablelister().handleWebPageUrl(GrantWebActivity.this.y);
                    }
                    GrantWebActivity.this.finish();
                }
            });
            this.sapiWebView.setCurrentAccountBdussExpiredCallback(new SapiJsCallBacks.CurrentAccountBdussExpiredCallback() {
                public void onBdussExpired() {
                    GrantWebActivity.this.b(true);
                }
            });
        }
        if (!SapiAccountManager.getInstance().isLogin() || TextUtils.isEmpty(SapiUtils.getCookiePtoken())) {
            b(false);
        } else {
            g();
        }
    }

    /* access modifiers changed from: private */
    public void b(boolean z2) {
        final boolean z3 = SapiAccountManager.getInstance().getConfignation().supportFaceLogin;
        SapiAccountManager.getInstance().getConfignation().supportFaceLogin = false;
        LoginActivity.supportShareLogin = false;
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_USERNAME;
        WebLoginDTO.Config config = new WebLoginDTO.Config();
        config.fastLoginFeatureList = new ArrayList();
        webLoginDTO.config = config;
        webLoginDTO.businessType = 2005;
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (z2 && currentAccount != null) {
            webLoginDTO.encryptedId = currentAccount.uid;
            webLoginDTO.preSetUname = currentAccount.displayname;
        }
        CoreViewRouter.getInstance().startLogin(this, new WebAuthListener() {
            public void onFailure(WebAuthResult webAuthResult) {
                LoginActivity.supportShareLogin = true;
                SapiAccountManager.getInstance().getConfignation().supportFaceLogin = z3;
                GrantWebActivity.this.finish();
            }

            public void onSuccess(WebAuthResult webAuthResult) {
                GrantWebActivity.this.g();
                SapiAccountManager.getGlobalCallback().onLoginStatusChange();
                LoginActivity.supportShareLogin = true;
                SapiAccountManager.getInstance().getConfignation().supportFaceLogin = z3;
            }
        }, webLoginDTO);
    }

    /* access modifiers changed from: private */
    public void d() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null || !sapiWebView.canGoBack()) {
            StatService.onEvent("grant_web_cancel", new HashMap());
            finish();
            return;
        }
        this.sapiWebView.goBack();
    }
}
