package com.baidu.sapi2.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.baidu.aiscan.R;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.AccountCenterCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.LoadDuVipPayCallBack;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.dto.AccountCenterDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.result.AccountCenterResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.social.DingDingInvokeCallback;
import com.baidu.sapi2.social.SocialLoginBase;
import com.baidu.sapi2.social.WXInvokeCallback;
import com.baidu.sapi2.utils.DarkModeUtil;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.views.ViewUtility;
import java.util.ArrayList;
import java.util.List;

public class AccountCenterActivity extends SlideActiviy {
    public static final String EXTRA_LOAD_WEIXIN = "extra_load_weixin";
    public static final String EXTRA_WEIIXIN_BIND_URL = "extra_weixin_bind_url";
    public static final String K = AccountCenterActivity.class.getSimpleName();
    public static final String L = "AccountCenterActivity";
    public static final int M = 2001;
    public List<PassNameValuePair> F;
    public String G;
    public String H;
    public String I;
    public AccountCenterResult J = new AccountCenterResult();
    public boolean mIsAccountCenterTitleBar = true;

    public void finishActivityAfterSlideOver() {
        if (L.equals(getClass().getSimpleName())) {
            this.J.setResultCode(-301);
            this.J.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
            a(this.J);
            return;
        }
        super.finish();
    }

    public SapiWebDTO getWebDTO() {
        return CoreViewRouter.getInstance().getAccountCenterDTO();
    }

    public void init() {
        super.init();
        AccountCenterDTO accountCenterDTO = CoreViewRouter.getInstance().getAccountCenterDTO();
        if (accountCenterDTO == null) {
            this.J.setResultCode(-204);
            this.J.setResultMsg(SapiResult.ERROR_MSG_PARAMS_ERROR);
            a(this.J);
            return;
        }
        this.G = accountCenterDTO.bduss;
        this.H = accountCenterDTO.refer;
        List<PassNameValuePair> list = accountCenterDTO.paramsList;
        this.F = list;
        int i2 = accountCenterDTO.shieldOption;
        if (!(i2 == 0 || list == null)) {
            list.add(new PassNameValuePair("shield", String.valueOf(i2)));
        }
        if (accountCenterDTO.isFromGuideRealName) {
            long currentTimeMillis = System.currentTimeMillis();
            SapiAccountManager instance = SapiAccountManager.getInstance();
            SapiContext.getInstance().setClickRealNameTimes((instance == null || instance.getSession() == null) ? "" : instance.getSession().uid, currentTimeMillis / 1000);
            List<PassNameValuePair> list2 = this.F;
            if (list2 != null) {
                list2.add(new PassNameValuePair("statistic_scene", "bs_andr_pass_red"));
            }
        }
        this.I = accountCenterDTO.accountToolsUrl;
        List<PassNameValuePair> list3 = this.F;
        if (list3 != null) {
            list3.add(new PassNameValuePair(SlideActiviy.EXTRA_PARAMS_SLIDE_PAGE, "1"));
        }
    }

    public void loadAccountCenter(String str) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("pp");
            SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() {
                public void onFinish() {
                }

                public void onStart() {
                }

                public void onFailure(GetTplStokenResult getTplStokenResult) {
                    AccountCenterActivity accountCenterActivity = AccountCenterActivity.this;
                    SapiWebView sapiWebView = accountCenterActivity.sapiWebView;
                    if (sapiWebView != null) {
                        sapiWebView.loadAccountCenter(accountCenterActivity.F, (String) null, AccountCenterActivity.this.H);
                    }
                }

                public void onSuccess(GetTplStokenResult getTplStokenResult) {
                    if (AccountCenterActivity.this.sapiWebView != null) {
                        AccountCenterActivity accountCenterActivity = AccountCenterActivity.this;
                        accountCenterActivity.sapiWebView.loadAccountCenter(accountCenterActivity.F, getTplStokenResult.tplStokenMap.get("pp"), AccountCenterActivity.this.H);
                    }
                }
            }, str, arrayList);
            return;
        }
        this.J.setResultCode(-204);
        this.J.setResultMsg(SapiResult.ERROR_MSG_PARAMS_ERROR);
        a(this.J);
    }

    public void loadSlideWebview(String str, String str2, String str3) {
        if (SlideActiviy.ACCOUNT_CENTER_PAGE_NAME.equals(str) && !TextUtils.isEmpty(str2)) {
            Intent intent = new Intent(this, AccountCenterExternalActivity.class);
            String queryParameter = Uri.parse(str2).getQueryParameter("topNavType");
            if (!TextUtils.isEmpty(queryParameter) && "1".equals(queryParameter)) {
                intent.putExtra(AccountCenterExternalActivity.EXTRA_EXTERNAL_IS_ACCOUNT_CENTER_TITLEBAR, true);
            }
            String str4 = K;
            Log.d(str4, "loadSlideWebview: " + str2);
            intent.putExtra("extra_external_url", str2);
            startActivityForResult(intent, 2001);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1004 && i3 == -1) {
            String stringExtra = intent.getStringExtra("bduss");
            this.G = stringExtra;
            loadAccountCenter(stringExtra);
            this.loginStatusChange = true;
        }
        if (i2 == 2001 && i3 == 3001) {
            c();
        }
    }

    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        if (TextUtils.isEmpty(this.I)) {
            Log.d(K, "onBottomBackBtnClick: back");
            this.sapiWebView.back();
            return;
        }
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null || !sapiWebView.canGoBack()) {
            Log.d(K, "onBottomBackBtnClick: onClose");
            onClose();
            return;
        }
        Log.d(K, "onBottomBackBtnClick: goBack");
        this.sapiWebView.goBack();
    }

    public void onClose() {
        super.onClose();
        this.J.setResultCode(-301);
        this.J.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
        a(this.J);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.layout_sapi_sdk_webview_with_title_bar);
            init();
            setupViews();
        } catch (Throwable th2) {
            reportWebviewError(th2);
            this.J.setResultCode(-202);
            this.J.setResultMsg(SapiResult.ERROR_MSG_UNKNOWN);
            a(this.J);
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (TextUtils.isEmpty(this.I)) {
            Log.d(K, "onKeyDown: back");
            this.sapiWebView.onKeyUp(i2);
            return true;
        }
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null || !sapiWebView.canGoBack()) {
            Log.d(K, "onKeyDown: onClose");
            onClose();
        } else {
            Log.d(K, "onKeyDown: goBack");
            this.sapiWebView.goBack();
        }
        return true;
    }

    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (this.executeSubClassMethod) {
            if (TextUtils.isEmpty(this.I)) {
                this.sapiWebView.back();
                return;
            }
            SapiWebView sapiWebView = this.sapiWebView;
            if (sapiWebView == null || !sapiWebView.canGoBack()) {
                onClose();
            } else {
                this.sapiWebView.goBack();
            }
        }
    }

    public void onNewIntent(Intent intent) {
        String str;
        super.onNewIntent(intent);
        setIntent(intent);
        String str2 = K;
        Log.d(str2, this + " onNewintent");
        if (AccountCenterActivity.class.getSimpleName().equals(getClass().getSimpleName())) {
            if (intent == null) {
                str = "";
            } else {
                str = intent.getStringExtra("action");
            }
            String str3 = K;
            Log.d(str3, this + " slide action is " + str);
            if (SlideActiviy.SLIDE_ACTION_QUIT.equals(str)) {
                finishActivityAfterSlideOver();
            }
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    public void onRightBtnClick() {
        super.onRightBtnClick();
    }

    public void setupViews() {
        super.setupViews();
        AccountCenterDTO accountCenterDTO = CoreViewRouter.getInstance().getAccountCenterDTO();
        if (accountCenterDTO != null) {
            Drawable drawable = accountCenterDTO.backBtnDrawable;
            if (drawable != null) {
                this.mLeftBtnIv.setImageDrawable(drawable);
            }
            setTitleTextBold(accountCenterDTO.isBoldTitle);
        }
        final AccountCenterCallback accountCenterCallback = CoreViewRouter.getInstance().getAccountCenterCallback();
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() {
            public void onFinish() {
                AccountCenterActivity.this.onClose();
            }
        });
        this.sapiWebView.setLeftBtnVisibleCallback(new SapiWebView.LeftBtnVisibleCallback() {
            public void onLeftBtnVisible(int i2) {
                if (i2 == 0) {
                    AccountCenterActivity.this.setBtnVisibility(4, 4, 4);
                } else {
                    AccountCenterActivity.this.setBtnVisibility(4, 0, 4);
                }
            }
        });
        this.sapiWebView.setSwitchAccountCallback(new SapiWebView.SwitchAccountCallback() {
            public void onAccountSwitch(SapiWebView.SwitchAccountCallback.Result result) {
                AccountCenterDTO accountCenterDTO = CoreViewRouter.getInstance().getAccountCenterDTO();
                if (accountCenterDTO == null || !accountCenterDTO.handleLogin || accountCenterCallback == null) {
                    Intent intent = new Intent(AccountCenterActivity.this, LoginActivity.class);
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
                    AccountCenterActivity.this.startActivityForResult(intent, 1004);
                    return;
                }
                AnonymousClass1 r0 = new AccountCenterResult() {
                    public void loginSuc() {
                        super.loginSuc();
                        String unused = AccountCenterActivity.this.G = SapiContext.getInstance().getCurrentAccount().bduss;
                        AccountCenterActivity accountCenterActivity = AccountCenterActivity.this;
                        accountCenterActivity.loadAccountCenter(accountCenterActivity.G);
                        AccountCenterActivity.this.loginStatusChange = true;
                    }
                };
                if (result.switchAccountType == 1) {
                    r0.preSetUserName = result.userName;
                }
                if (result.switchAccountType == 2) {
                    r0.preSetUserName = result.displayName;
                    r0.encryptedId = result.encryptedUid;
                }
                r0.setResultCode(-10001);
                r0.setResultMsg("请登录");
                accountCenterCallback.onFinish(r0);
            }
        });
        this.sapiWebView.setCoverWebBdussCallback(new SapiWebView.CoverWebBdussCallback() {
            public void onCoverBduss(String str, SapiWebView.CoverWebBdussResult coverWebBdussResult) {
                if (!TextUtils.isEmpty(str) && !str.equals(AccountCenterActivity.this.G)) {
                    coverWebBdussResult.setWebBduss(AccountCenterActivity.this.G);
                }
            }
        });
        this.sapiWebView.setAccountDestoryCallback(new SapiWebView.AccountDestoryCallback() {
            public void onAccountDestory(SapiWebView.AccountDestoryCallback.AccountDestoryResult accountDestoryResult) {
                AccountCenterActivity.this.c();
            }
        });
        this.sapiWebView.setAccountChangeCallback(new SapiWebView.AccountChangeCallback() {
            public void onAccountChange() {
                AccountCenterCallback accountCenterCallback = accountCenterCallback;
                if (accountCenterCallback != null) {
                    accountCenterCallback.onBdussChange();
                }
            }
        });
        this.sapiWebView.setAccountFreezeCallback(new SapiWebView.AccountFreezeCallback() {
            public void onAccountFreeze(SapiWebView.AccountFreezeCallback.AccountFreezeResult accountFreezeResult) {
                AccountCenterDTO accountCenterDTO = CoreViewRouter.getInstance().getAccountCenterDTO();
                if (accountCenterDTO != null && accountCenterDTO.logoutAfterBdussInvalid) {
                    SapiAccountManager.getInstance().logout(5);
                    SapiAccountManager.getInstance().getAccountService().preGetPhoneInfo();
                }
                AccountCenterResult accountCenterResult = new AccountCenterResult();
                accountCenterResult.isAccountFreeze = true;
                AccountCenterActivity.this.a(accountCenterResult);
            }
        });
        this.sapiWebView.setBdussChangeCallback(new SapiWebView.BdussChangeCallback() {
            public void onBdussChange() {
                AccountCenterActivity.this.d();
            }
        });
        this.sapiWebView.setAuthorizationListener(new AuthorizationListener() {
            public void onFailed(int i2, String str) {
            }

            public void onSuccess(AccountType accountType) {
                super.onSuccess(accountType);
                AccountCenterActivity.this.J.setResultCode(-10002);
                AccountCenterActivity accountCenterActivity = AccountCenterActivity.this;
                accountCenterActivity.a(accountCenterActivity.J);
                SapiAccountManager.getGlobalCallback().onLoginStatusChange();
            }
        });
        this.sapiWebView.setChangePwdCallback(new SapiWebView.ChangePwdCallback() {
            public void onSuccess() {
                AccountCenterActivity.this.J.setResultCode(-10002);
                AccountCenterActivity accountCenterActivity = AccountCenterActivity.this;
                accountCenterActivity.a(accountCenterActivity.J);
            }
        });
        if (TextUtils.isEmpty(this.I)) {
            setTitleText((int) R.string.sapi_sdk_title_account_center);
            loadAccountCenter(this.G);
        } else {
            this.sapiWebView.loadUrl(this.I);
        }
        if (this.mIsAccountCenterTitleBar) {
            this.dividerLine.setVisibility(8);
            if (DarkModeUtil.isDarkMode(this)) {
                if (this.useTitle) {
                    ViewUtility.enableStatusBarTint(this, getResources().getColor(R.color.sapi_sdk_account_center_titlebar_bg_darkmode));
                    setTitleLayoutBg(getResources().getColor(R.color.sapi_sdk_account_center_titlebar_bg_darkmode));
                    setTitleTextColor(getResources().getColor(R.color.sapi_sdk_account_center_titlebar_text_darkmode));
                    this.sapiWebView.setBackgroundColor(getResources().getColor(R.color.sapi_sdk_account_center_titlebar_bg_darkmode));
                }
            } else if (this.useTitle) {
                ViewUtility.enableStatusBarTint(this, getResources().getColor(R.color.sapi_sdk_account_center_titlebar_bg));
                setTitleLayoutBg(getResources().getColor(R.color.sapi_sdk_account_center_titlebar_bg));
                setTitleTextColor(getResources().getColor(R.color.sapi_sdk_account_center_titlebar_text));
                this.sapiWebView.setBackgroundColor(getResources().getColor(R.color.sapi_sdk_account_center_titlebar_bg));
            }
        }
        this.sapiWebView.setJumpToUriCallBack(new SapiJsCallBacks.JumpToUriCallBack() {
            public void onJumpTo(String str) {
                if (accountCenterCallback != null && !TextUtils.isEmpty(str)) {
                    accountCenterCallback.onJumpTo(str);
                }
            }
        });
        this.sapiWebView.setSyncAccountCallback(new SapiJsCallBacks.SyncAccountCallBack() {
            public void onSyncAccount(SapiAccount sapiAccount) {
                AccountCenterCallback accountCenterCallback = accountCenterCallback;
                if (accountCenterCallback != null && sapiAccount != null) {
                    accountCenterCallback.onSyncAccount(sapiAccount);
                }
            }
        });
        this.sapiWebView.setOpenCustomerServiceCallBack(new SapiJsCallBacks.OpenCustomerServiceCallBack() {
            public boolean onOpenCustomerService() {
                AccountCenterCallback accountCenterCallback = accountCenterCallback;
                if (accountCenterCallback != null) {
                    return accountCenterCallback.shouldOverrideOpenCustomerService(AccountCenterActivity.this);
                }
                return false;
            }
        });
        this.sapiWebView.setWebViewReceviceTitleCallback(new SapiWebView.WebViewReceviceTitleCallback() {
            public void onTitleChange(String str) {
                SapiContext instance = SapiContext.getInstance();
                if (instance != null && instance.isOpTitle()) {
                    AccountCenterActivity.this.setTitleText(str);
                }
            }
        });
        this.sapiWebView.setOpenDuVipPayCallback(new SapiJsCallBacks.OpenDuVipPayCallback() {
            public void onOpenDuVipPay(LoadDuVipPayCallBack loadDuVipPayCallBack) {
                AccountCenterCallback accountCenterCallback = accountCenterCallback;
                if (accountCenterCallback != null) {
                    accountCenterCallback.onOpenDuVipPay(loadDuVipPayCallBack);
                }
            }
        });
        this.sapiWebView.setOnUnbindAccountCallback(new SapiJsCallBacks.OnUnbindThirdAccountCallback() {
            public void onUnbindThirdAccount(String str) {
                AccountCenterCallback accountCenterCallback = accountCenterCallback;
                if (accountCenterCallback != null) {
                    accountCenterCallback.onUnbindThirdAccount(str);
                }
            }
        });
        this.sapiWebView.isAccountTools = accountCenterDTO != null && accountCenterDTO.isFromAccountTools;
    }

    /* access modifiers changed from: private */
    public void c() {
        AccountCenterDTO accountCenterDTO = CoreViewRouter.getInstance().getAccountCenterDTO();
        if (accountCenterDTO != null && accountCenterDTO.logoutAfterBdussInvalid) {
            SapiAccountManager.getInstance().logout(4);
            SapiAccountManager.getInstance().getAccountService().preGetPhoneInfo();
        }
        AccountCenterResult accountCenterResult = new AccountCenterResult();
        accountCenterResult.setResultCode(0);
        accountCenterResult.setResultMsg("成功");
        accountCenterResult.isAccountDestory = true;
        a(accountCenterResult);
    }

    /* access modifiers changed from: private */
    public void d() {
        SapiAccountManager.getInstance().getAccountService().web2NativeLogin((Web2NativeLoginCallback) new Web2NativeLoginCallback() {
            public void onBdussEmpty(Web2NativeLoginResult web2NativeLoginResult) {
            }

            public void onBdussExpired(Web2NativeLoginResult web2NativeLoginResult) {
            }

            public void onFailure(Web2NativeLoginResult web2NativeLoginResult) {
            }

            public void onFinish() {
            }

            public void onStart() {
            }

            public void onSuccess(Web2NativeLoginResult web2NativeLoginResult) {
                AccountCenterCallback accountCenterCallback = CoreViewRouter.getInstance().getAccountCenterCallback();
                if (SapiUtils.isMethodOverWrited(accountCenterCallback, "onBdussChange", AccountCenterCallback.class, new Class[0])) {
                    accountCenterCallback.onBdussChange();
                }
            }
        }, true);
    }

    /* access modifiers changed from: private */
    public void a(AccountCenterResult accountCenterResult) {
        SocialLoginBase.setWXLoginCallback((WXInvokeCallback) null);
        SocialLoginBase.setDingDingInvokeCallback((DingDingInvokeCallback) null);
        if (CoreViewRouter.getInstance().getAccountCenterCallback() != null) {
            if (accountCenterResult == null) {
                accountCenterResult = new AccountCenterResult();
            }
            CoreViewRouter.getInstance().getAccountCenterCallback().onFinish(accountCenterResult);
        }
        finish();
        CoreViewRouter.getInstance().release();
    }
}
