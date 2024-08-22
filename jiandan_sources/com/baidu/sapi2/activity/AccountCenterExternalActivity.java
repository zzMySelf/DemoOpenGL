package com.baidu.sapi2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.AccountCenterCallback;
import com.baidu.sapi2.dto.AccountCenterDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.result.AccountCenterResult;
import com.baidu.sapi2.utils.Log;

public class AccountCenterExternalActivity extends AccountCenterActivity {
    public static final String EXTRA_EXTERNAL_IS_ACCOUNT_CENTER_TITLEBAR = "extra_external_is_account_center_titlebar";
    public static final String EXTRA_EXTERNAL_URL = "extra_external_url";
    public static final String O = AccountCenterExternalActivity.class.getSimpleName();
    public static final int RESULT_CODE_UNSUBSCRIBE = 3001;
    public String N;

    /* access modifiers changed from: private */
    public void d() {
        Log.d(O, "back: FN_SWITCH_VIEW");
        this.sapiWebView.loadUrl(SapiWebView.FN_SWITCH_VIEW);
    }

    /* access modifiers changed from: private */
    public void e() {
        Intent intent = new Intent(this, AccountCenterActivity.class);
        intent.setFlags(67108864);
        intent.putExtra("action", SlideActiviy.SLIDE_ACTION_QUIT);
        startActivity(intent);
    }

    public void finishActivity() {
        super.finish();
    }

    public void loadAccountCenter(String str) {
        String stringExtra = getIntent().getStringExtra("extra_external_url");
        this.N = stringExtra;
        this.sapiWebView.loadUrl(stringExtra);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1004 && i3 == -1) {
            e();
            this.loginStatusChange = true;
        }
    }

    public void onBottomBackBtnClick() {
        d();
    }

    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.mIsAccountCenterTitleBar = intent.getBooleanExtra(EXTRA_EXTERNAL_IS_ACCOUNT_CENTER_TITLEBAR, false);
        }
        super.onCreate(bundle);
        Log.d(O, "AccountCenterExternalActivity onCreate");
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() {
            public boolean onBack() {
                AccountCenterExternalActivity.this.d();
                return false;
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() {
            public void onFinish() {
                Log.d(AccountCenterExternalActivity.O, "onFinish: finishActivity");
                AccountCenterExternalActivity.this.finishActivity();
            }
        });
        this.sapiWebView.setOnSlidePageFinishCallback(new SapiWebView.OnSlidePageFinishCallback() {
            public void onFinish(String str) {
                String c = AccountCenterExternalActivity.O;
                Log.d(c, "onFinish: SlidePageFinish pageName: " + str);
                if (SlideActiviy.ACCOUNT_CENTER_PAGE_NAME.equals(str)) {
                    Intent intent = new Intent(AccountCenterExternalActivity.this, AccountCenterActivity.class);
                    intent.setFlags(67108864);
                    AccountCenterExternalActivity.this.startActivity(intent);
                }
                if (SlideActiviy.SLIDE_ACTION_QUIT.equals(str)) {
                    AccountCenterExternalActivity.this.e();
                }
            }
        });
        this.sapiWebView.setSwitchAccountCallback(new SapiWebView.SwitchAccountCallback() {
            public void onAccountSwitch(SapiWebView.SwitchAccountCallback.Result result) {
                AccountCenterCallback accountCenterCallback = CoreViewRouter.getInstance().getAccountCenterCallback();
                AccountCenterDTO accountCenterDTO = CoreViewRouter.getInstance().getAccountCenterDTO();
                if (accountCenterDTO == null || !accountCenterDTO.handleLogin || accountCenterCallback == null) {
                    Intent intent = new Intent(AccountCenterExternalActivity.this, LoginActivity.class);
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
                    AccountCenterExternalActivity.this.startActivityForResult(intent, 1004);
                    return;
                }
                AnonymousClass1 r1 = new AccountCenterResult() {
                    public void loginSuc() {
                        super.loginSuc();
                        AccountCenterExternalActivity.this.e();
                        AccountCenterExternalActivity.this.loginStatusChange = true;
                    }
                };
                if (result.switchAccountType == 1) {
                    r1.preSetUserName = result.userName;
                }
                if (result.switchAccountType == 2) {
                    r1.preSetUserName = result.displayName;
                    r1.encryptedId = result.encryptedUid;
                }
                r1.setResultCode(-10001);
                r1.setResultMsg("请登录");
                accountCenterCallback.onFinish(r1);
            }
        });
        this.sapiWebView.setAccountDestoryCallback(new SapiWebView.AccountDestoryCallback() {
            public void onAccountDestory(SapiWebView.AccountDestoryCallback.AccountDestoryResult accountDestoryResult) {
                AccountCenterExternalActivity.this.setResult(3001);
                AccountCenterExternalActivity.this.finishActivity();
            }
        });
    }

    public void onLeftBtnClick() {
        d();
    }
}
