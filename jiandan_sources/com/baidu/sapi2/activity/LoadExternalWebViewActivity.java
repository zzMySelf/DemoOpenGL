package com.baidu.sapi2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.aiscan.R;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.result.ExtendSysWebViewMethodResult;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.enums.AccountType;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class LoadExternalWebViewActivity extends BaseActivity {
    public static final String C = "LoadExternalWebViewActi";
    public static final int D = 2001;
    public static final String EXTRA_BUSINESS_FROM = "business_from";
    public static final String EXTRA_BUSINESS_FROM_ONE_KEY_LOGIN = "business_from_one_key_login";
    public static final String EXTRA_BUSINESS_TYPE = "business_type";
    public static final String EXTRA_EXTERNAL_TITLE = "extra_external_title";
    public static final String EXTRA_EXTERNAL_URL = "extra_external_url";
    public static final String EXTRA_PAGE_FROM = "page_from";
    public static final String RESULT_BUSINESS_TYPE_ACCOUNT_FREEZE = "business_account_freeze";
    public static final String RESULT_BUSINESS_TYPE_PRE_SET_UNAME = "business_pre_set_username";
    public OneKeyLoginCallback A;
    public AuthorizationListener B = new AuthorizationListener() {
        public void onFailed(int i2, String str) {
            if ("business_from_one_key_login".equals(LoadExternalWebViewActivity.this.y)) {
                new OneKeyLoginSdkCall().loadOneKeyLoginFail(LoadExternalWebViewActivity.this.A, -103, (String) null);
            }
            LoadExternalWebViewActivity.this.webAuthResult.setResultCode(i2);
            LoadExternalWebViewActivity.this.webAuthResult.setResultMsg(str);
            WebAuthListener webAuthListener = CoreViewRouter.getInstance().getWebAuthListener();
            if (webAuthListener != null) {
                webAuthListener.onFailure(LoadExternalWebViewActivity.this.webAuthResult);
                CoreViewRouter.getInstance().release();
            }
            LoadExternalWebViewActivity.this.setResult(0);
            LoadExternalWebViewActivity.this.finish();
        }

        public void onSuccess(AccountType accountType) {
            WebAuthListener webAuthListener;
            if ("business_from_one_key_login".equals(LoadExternalWebViewActivity.this.y)) {
                OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
                oneKeyLoginResult.setResultCode(0);
                if (LoadExternalWebViewActivity.this.A != null) {
                    LoadExternalWebViewActivity.this.A.onSuccess(oneKeyLoginResult);
                }
            }
            if (!LoginActivity.EXTRA_PARAM_PAGE_LOGIN.equals(LoadExternalWebViewActivity.this.z) && (webAuthListener = CoreViewRouter.getInstance().getWebAuthListener()) != null) {
                LoadExternalWebViewActivity loadExternalWebViewActivity = LoadExternalWebViewActivity.this;
                if (loadExternalWebViewActivity.webAuthResult == null) {
                    loadExternalWebViewActivity.webAuthResult = new WebAuthResult();
                }
                WebAuthResult webAuthResult = LoadExternalWebViewActivity.this.webAuthResult;
                webAuthResult.accountType = accountType;
                webAuthResult.setResultCode(0);
                webAuthListener.onSuccess(LoadExternalWebViewActivity.this.webAuthResult);
                CoreViewRouter.getInstance().release();
            }
            Intent intent = new Intent();
            intent.putExtra("account_type", accountType.getType());
            LoadExternalWebViewActivity.this.setResult(-1, intent);
            LoadExternalWebViewActivity.this.finish();
        }
    };
    public String w;
    public WebAuthResult webAuthResult = new WebAuthResult() {
        public void finishActivity() {
            super.finishActivity();
            LoadExternalWebViewActivity.this.finish();
            CoreViewRouter.getInstance().release();
        }

        public void finishActivity(boolean z) {
            super.finishActivity();
            LoadExternalWebViewActivity.this.finish();
            CoreViewRouter.getInstance().release();
        }
    };
    public String x;
    public String y;
    public String z;

    public void finish() {
        super.finish();
        if (CoreViewRouter.getInstance().getExtendSysWebViewMethodCallback() != null) {
            ExtendSysWebViewMethodResult extendSysWebViewMethodResult = new ExtendSysWebViewMethodResult();
            extendSysWebViewMethodResult.params.put("retCode", -301);
            extendSysWebViewMethodResult.params.put("retMsg", SapiResult.ERROR_MSG_PROCESSED_END);
            CoreViewRouter.getInstance().getExtendSysWebViewMethodCallback().onFinish(extendSysWebViewMethodResult);
            CoreViewRouter.getInstance().clearExtendSysWebViewMethodCallback();
        }
    }

    public SapiWebDTO getWebDTO() {
        return CoreViewRouter.getInstance().getWebLoginDTO();
    }

    public void init() {
        super.init();
        this.w = getIntent().getStringExtra("extra_external_title");
        this.x = getIntent().getStringExtra("extra_external_url");
        this.z = getIntent().getStringExtra(EXTRA_PAGE_FROM);
        this.y = getIntent().getStringExtra(EXTRA_BUSINESS_FROM);
        if (TextUtils.isEmpty(this.x)) {
            setResult(0);
            finish();
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 2001 && i3 == -1) {
            this.loginStatusChange = true;
            setResult(-1, new Intent());
            finish();
        }
    }

    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        c();
    }

    public void onClose() {
        super.onClose();
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.layout_sapi_sdk_webview_with_title_bar);
            this.A = CoreViewRouter.getInstance().getOneKeyLoginCallback();
            CoreViewRouter.getInstance().releaseOneKeyLoginCallback();
            init();
            setupViews();
        } catch (Throwable th2) {
            reportWebviewError(th2);
            finish();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.A != null) {
            this.A = null;
        }
        if (this.webAuthResult != null) {
            this.webAuthResult = null;
        }
    }

    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (this.executeSubClassMethod) {
            c();
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    public void setupViews() {
        super.setupViews();
        this.sapiWebView.setAuthorizationListener(this.B);
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() {
            public boolean onBack() {
                LoadExternalWebViewActivity.this.c();
                return false;
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() {
            public void onFinish() {
                LoadExternalWebViewActivity.this.finish();
            }
        });
        this.sapiWebView.setLeftBtnVisibleCallback(new SapiWebView.LeftBtnVisibleCallback() {
            public void onLeftBtnVisible(int i2) {
                if (i2 == 0) {
                    LoadExternalWebViewActivity.this.setBtnVisibility(4, 4, 4);
                } else {
                    LoadExternalWebViewActivity.this.setBtnVisibility(4, 0, 4);
                }
            }
        });
        this.sapiWebView.setCoverWebBdussCallback(new SapiWebView.CoverWebBdussCallback() {
            public void onCoverBduss(String str, SapiWebView.CoverWebBdussResult coverWebBdussResult) {
                SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                if (currentAccount != null && !TextUtils.isEmpty(str) && !str.equals(currentAccount.bduss)) {
                    coverWebBdussResult.setWebBduss(currentAccount.bduss);
                }
            }
        });
        this.sapiWebView.setSwitchAccountCallback(new SapiWebView.SwitchAccountCallback() {
            public void onAccountSwitch(SapiWebView.SwitchAccountCallback.Result result) {
                Intent intent = new Intent(LoadExternalWebViewActivity.this, LoginActivity.class);
                intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, BaseActivity.EXTRA_PARAM_FROM_ACCOUNT_CENTER);
                int i2 = result.switchAccountType;
                if (i2 == 1) {
                    intent.putExtra("username", result.userName);
                } else if (i2 == 2) {
                    if (result.loginType == 0) {
                        intent.putExtra(LoginActivity.EXTRA_LOGIN_TYPE, WebLoginDTO.EXTRA_LOGIN_WITH_USERNAME);
                    } else {
                        intent.putExtra(LoginActivity.EXTRA_LOGIN_TYPE, WebLoginDTO.EXTRA_LOGIN_WITH_SMS);
                    }
                    intent.putExtra(LoginActivity.EXTRA_LOGIN_FINISH_AFTER_SUC, true);
                    if (!TextUtils.isEmpty(result.displayName)) {
                        intent.putExtra("username", result.displayName);
                    }
                    intent.putExtra(LoginActivity.EXTRA_PARAM_ENCRYPTED_UID, result.encryptedUid);
                }
                LoadExternalWebViewActivity.this.startActivityForResult(intent, 2001);
            }
        });
        this.sapiWebView.setAccountFreezeCallback(new SapiWebView.AccountFreezeCallback() {
            public void onAccountFreeze(SapiWebView.AccountFreezeCallback.AccountFreezeResult accountFreezeResult) {
                Intent intent = new Intent();
                intent.putExtra(LoadExternalWebViewActivity.EXTRA_BUSINESS_TYPE, LoadExternalWebViewActivity.RESULT_BUSINESS_TYPE_ACCOUNT_FREEZE);
                LoadExternalWebViewActivity.this.setResult(-1, intent);
                LoadExternalWebViewActivity.this.finish();
            }
        });
        this.sapiWebView.setPreFillUserNameCallback(new SapiWebView.PreFillUserNameCallback() {
            public void onPreFillUserName(SapiWebView.PreFillUserNameCallback.PreFillUserNameResult preFillUserNameResult) {
                Intent intent = new Intent();
                intent.putExtra(LoadExternalWebViewActivity.EXTRA_BUSINESS_TYPE, LoadExternalWebViewActivity.RESULT_BUSINESS_TYPE_PRE_SET_UNAME);
                intent.putExtra("username", preFillUserNameResult.userName);
                LoadExternalWebViewActivity.this.setResult(-1, intent);
            }
        });
        this.sapiWebView.setWebviewPageFinishCallback(new SapiJsCallBacks.WebviewPageFinishCallback() {
            public void onFinish(String str) {
                if (CoreViewRouter.getInstance().getExtendSysWebViewMethodCallback() != null) {
                    ExtendSysWebViewMethodResult extendSysWebViewMethodResult = new ExtendSysWebViewMethodResult();
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            extendSysWebViewMethodResult.params.put(next, jSONObject.get(next));
                        }
                    } catch (JSONException e) {
                        "onFinish: err:" + e.getMessage() + ", jsonStr=" + str;
                    }
                    CoreViewRouter.getInstance().getExtendSysWebViewMethodCallback().onFinish(extendSysWebViewMethodResult);
                    CoreViewRouter.getInstance().clearExtendSysWebViewMethodCallback();
                }
                LoadExternalWebViewActivity.this.finish();
            }
        });
        ArrayList arrayList = new ArrayList();
        WebLoginDTO webLoginDTO = CoreViewRouter.getInstance().getWebLoginDTO();
        if (webLoginDTO != null && WebLoginDTO.statExtraValid(webLoginDTO.statExtra)) {
            arrayList.add(new PassNameValuePair("extrajson", webLoginDTO.statExtra));
        }
        this.sapiWebView.loadExternalUrl(this.x, arrayList);
    }

    /* access modifiers changed from: private */
    public void c() {
        if (this.x.contains(SapiEnv.LOGIN_PROJECT) || this.x.contains(SapiEnv.CANCEL_REALNAME)) {
            this.sapiWebView.loadUrl(SapiWebView.FN_SWITCH_VIEW);
            return;
        }
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null || !sapiWebView.canGoBack()) {
            finish();
        } else {
            this.sapiWebView.goBack();
        }
    }
}
