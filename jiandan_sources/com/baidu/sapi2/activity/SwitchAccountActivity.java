package com.baidu.sapi2.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import com.baidu.aiscan.R;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SwitchAccountDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.AccountType;
import java.util.ArrayList;

public class SwitchAccountActivity extends BaseActivity {
    public static final String A = "https://wappass.baidu.com/v6/changeAccount";
    public static final String z = "SwitchAccountActivity";
    public WebAuthResult w = new WebAuthResult() {
        public void finishActivity() {
            SwitchAccountActivity.this.finish();
            CoreViewRouter.getInstance().release();
        }
    };
    public WebAuthListener x;
    public SwitchAccountDTO y;

    /* access modifiers changed from: private */
    public void c() {
        d();
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null || !sapiWebView.canGoBack()) {
            onClose();
            return;
        }
        String d = d();
        if (d == null || !d.startsWith(A)) {
            this.sapiWebView.goBack();
        } else {
            onClose();
        }
    }

    private String d() {
        WebBackForwardList copyBackForwardList;
        WebHistoryItem currentItem;
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null || (copyBackForwardList = sapiWebView.copyBackForwardList()) == null || copyBackForwardList.getSize() == 0 || (currentItem = copyBackForwardList.getCurrentItem()) == null) {
            return null;
        }
        return currentItem.getUrl();
    }

    public void init() {
        super.init();
        this.x = CoreViewRouter.getInstance().getWebAuthListener();
        SwitchAccountDTO switchAccountDTO = CoreViewRouter.getInstance().getSwitchAccountDTO();
        this.y = switchAccountDTO;
        if (switchAccountDTO == null || this.x == null) {
            "init: witchAccountDTO or webAuthListener is null; accountDTO:" + this.y + ", webAuthListener " + this.x;
            this.w.setResultCode(-204);
            a(this.w);
            return;
        }
        setupViews();
    }

    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        c();
    }

    public void onClose() {
        super.onClose();
        this.w.setResultCode(-301);
        a(this.w);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.layout_sapi_sdk_webview_with_title_bar);
            init();
        } catch (Throwable th2) {
            reportWebviewError(th2);
            this.w.setResultCode(-202);
            a(this.w);
        }
    }

    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (this.executeSubClassMethod) {
            c();
        }
    }

    public void setupViews() {
        super.setupViews();
        setTitleText((int) R.string.sapi_sdk_title_switch);
        SapiWebView sapiWebView = this.sapiWebView;
        sapiWebView.showSwitchAccount = this.configuration.supportMultipleAccounts;
        sapiWebView.showLinkAccount = this.y.supportQueryAssociatedAccount;
        sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() {
            public void onFinish() {
                SwitchAccountActivity.this.onClose();
            }
        });
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() {
            public boolean onBack() {
                SwitchAccountActivity.this.c();
                return false;
            }
        });
        this.sapiWebView.setAuthorizationListener(new AuthorizationListener() {
            public void onFailed(int i2, String str) {
                SwitchAccountActivity.this.a(i2, str);
            }

            public void onSuccess(AccountType accountType) {
                super.onSuccess();
                SwitchAccountActivity.this.a(accountType);
            }
        });
        this.sapiWebView.setSwitchAccountCallback(new SapiWebView.SwitchAccountCallback() {
            public void onAccountSwitch(SapiWebView.SwitchAccountCallback.Result result) {
                WebLoginDTO webLoginDTO = new WebLoginDTO();
                webLoginDTO.finishActivityAfterSuc = false;
                int i2 = result.switchAccountType;
                if (i2 == 1) {
                    webLoginDTO.preSetUname = result.userName;
                } else if (i2 == 2) {
                    if (result.loginType == 0) {
                        webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_USERNAME;
                    } else {
                        webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_SMS;
                    }
                    if (!TextUtils.isEmpty(result.displayName)) {
                        webLoginDTO.preSetUname = result.displayName;
                    }
                    webLoginDTO.encryptedId = result.encryptedUid;
                }
                if (!TextUtils.isEmpty(result.extraJson)) {
                    webLoginDTO.extraJson = result.extraJson;
                }
                CoreViewRouter.getInstance().startLogin(SwitchAccountActivity.this, new WebAuthListener() {
                    public void onFailure(WebAuthResult webAuthResult) {
                        "onFailure: " + webAuthResult.getResultCode() + StringUtil.ARRAY_ELEMENT_SEPARATOR + webAuthResult.getResultMsg();
                        SwitchAccountActivity.this.a(webAuthResult.getResultCode(), webAuthResult.getResultMsg());
                    }

                    public void onSuccess(WebAuthResult webAuthResult) {
                        "onSuccess: result" + webAuthResult.accountType;
                        webAuthResult.finishActivity(false);
                        SwitchAccountActivity.this.a(webAuthResult.accountType);
                        if (SwitchAccountActivity.this.sapiWebView != null) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(new PassNameValuePair("changeAccountSuc", "1"));
                            SwitchAccountActivity.this.sapiWebView.loadSwitchAccount(arrayList);
                        }
                    }
                }, webLoginDTO);
            }
        });
        this.sapiWebView.loadSwitchAccount(new ArrayList());
    }

    /* access modifiers changed from: private */
    public void a(AccountType accountType) {
        "switchAccoutSuccess: " + accountType;
        this.w.setResultCode(0);
        WebAuthResult webAuthResult = this.w;
        webAuthResult.accountType = accountType;
        this.x.onSuccess(webAuthResult);
    }

    /* access modifiers changed from: private */
    public void a(int i2, String str) {
        "switchAccountFailed: " + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + str;
        this.w.setResultCode(i2);
        this.w.setResultMsg(str);
        this.x.onFailure(this.w);
    }

    private void a(WebAuthResult webAuthResult) {
        WebAuthListener webAuthListener = this.x;
        if (webAuthListener != null) {
            webAuthListener.onFailure(webAuthResult);
        }
        finish();
        CoreViewRouter.getInstance().release();
    }
}
