package com.baidu.sapi2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.aiscan.R;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.AccountRealNameCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.dto.RealNameDTO;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.SapiResult;
import java.util.ArrayList;

public class AccountRealNameActivity extends BaseActivity {
    public static final String EXTRA_BDUSS = "EXTRA_BDUSS";
    public static final String EXTRA_CUSTOM_LINK = "EXTRA_CUSTOM_LINK";
    public static final String EXTRA_NEED_CB_KEY = "EXTRA_NEED_CB_KEY";
    public static final String EXTRA_REAL_NAME_LEVEL = "EXTRA_REAL_NAME_LEVEL";
    public static final String EXTRA_SCENE = "EXTRA_SCENE";
    public int A;
    public AccountRealNameResult B = new AccountRealNameResult();
    public AccountRealNameCallback C;
    public Bundle D;
    public String w;
    public String x;
    public boolean y;
    public String z;

    private void finishActivity() {
        AccountRealNameCallback accountRealNameCallback = this.C;
        if (accountRealNameCallback != null) {
            accountRealNameCallback.onFinish();
            this.C.onFinish(this.B);
        }
        this.D = null;
        finish();
    }

    public void init() {
        super.init();
        Intent intent = getIntent();
        this.w = intent.getStringExtra("EXTRA_BDUSS");
        this.x = intent.getStringExtra("EXTRA_SCENE");
        this.y = intent.getBooleanExtra(EXTRA_NEED_CB_KEY, false);
        this.z = intent.getStringExtra(EXTRA_CUSTOM_LINK);
        this.A = intent.getIntExtra(EXTRA_REAL_NAME_LEVEL, 0);
    }

    public void loadSlideWebview(String str, String str2, String str3) {
        Intent intent = new Intent(this, LoadExternalWebViewActivity.class);
        intent.putExtra("extra_external_title", str);
        intent.putExtra("extra_external_url", str2);
        startActivity(intent);
    }

    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        c();
    }

    public void onClose() {
        super.onClose();
        AccountRealNameResult accountRealNameResult = this.B;
        if (accountRealNameResult.juniorRealNameSuc || accountRealNameResult.seniorRealNameSuc) {
            this.B.setResultCode(0);
            this.B.setResultMsg("成功");
        } else {
            accountRealNameResult.setResultCode(-301);
            this.B.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
        }
        finishActivity();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.C = CoreViewRouter.getInstance().getAccountRealNameCallback();
            CoreViewRouter.getInstance().releaseAccountRealNameCallback();
            RealNameDTO webDTO = getWebDTO();
            if (webDTO == null) {
                this.B.setResultCode(-208);
                this.B.setResultMsg(SapiResult.ERROR_MSG_DTO_IS_NULL);
                finishActivity();
                return;
            }
            this.D = webDTO.extraParams;
            setContentView(R.layout.layout_sapi_sdk_webview_with_title_bar);
            init();
            setupViews();
        } catch (Throwable th2) {
            reportWebviewError(th2);
            this.B.setResultCode(-202);
            this.B.setResultMsg(SapiResult.ERROR_MSG_UNKNOWN);
            finishActivity();
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (this.executeSubClassMethod) {
            c();
        }
    }

    public void setupViews() {
        super.setupViews();
        setTitleText((int) R.string.sapi_sdk_title_real_name);
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() {
            public boolean onBack() {
                SapiWebView sapiWebView = AccountRealNameActivity.this.sapiWebView;
                if (sapiWebView == null || !sapiWebView.canGoBack()) {
                    AccountRealNameActivity.this.onClose();
                    return false;
                }
                AccountRealNameActivity.this.sapiWebView.goBack();
                return false;
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() {
            public void onFinish() {
                AccountRealNameActivity.this.onClose();
            }
        });
        this.sapiWebView.setRealNameStateCallback(new SapiJsCallBacks.RealNameStatusCallback() {
            public void onFinish(AccountRealNameResult accountRealNameResult) {
                if (!(accountRealNameResult == null || AccountRealNameActivity.this.B == null || accountRealNameResult.seniorRealNameSuc)) {
                    accountRealNameResult.errorStep = AccountRealNameActivity.this.B.errorStep;
                    accountRealNameResult.subResultCode = AccountRealNameActivity.this.B.subResultCode;
                    accountRealNameResult.subResultMsg = AccountRealNameActivity.this.B.subResultMsg;
                }
                AccountRealNameResult unused = AccountRealNameActivity.this.B = accountRealNameResult;
            }
        });
        this.sapiWebView.setRealNameSubErrorCallback(new SapiJsCallBacks.RealNameSubErrorCallback() {
            public void onFinish(AccountRealNameResult accountRealNameResult) {
                if (accountRealNameResult != null) {
                    if (AccountRealNameActivity.this.B == null) {
                        AccountRealNameResult unused = AccountRealNameActivity.this.B = accountRealNameResult;
                        return;
                    }
                    AccountRealNameActivity.this.B.errorStep = accountRealNameResult.errorStep;
                    AccountRealNameActivity.this.B.subResultCode = accountRealNameResult.subResultCode;
                    AccountRealNameActivity.this.B.subResultMsg = accountRealNameResult.subResultMsg;
                }
            }
        });
        this.sapiWebView.setLoadSlideWebViewCallback(new SapiWebView.LoadSlideWebViewCallback() {
            public void loadSlideWebview(SapiWebView.LoadSlideWebViewResult loadSlideWebViewResult) {
                AccountRealNameActivity.this.loadSlideWebview(loadSlideWebViewResult.page, loadSlideWebViewResult.url, loadSlideWebViewResult.adapter);
            }
        });
        d();
    }

    private void c() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null || !sapiWebView.canGoBack()) {
            onClose();
        } else {
            this.sapiWebView.back();
        }
    }

    private void d() {
        if (!TextUtils.isEmpty(this.w)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("pp");
            SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() {
                public void onFinish() {
                }

                public void onStart() {
                }

                public void onFailure(GetTplStokenResult getTplStokenResult) {
                    AccountRealNameActivity accountRealNameActivity = AccountRealNameActivity.this;
                    SapiWebView sapiWebView = accountRealNameActivity.sapiWebView;
                    if (sapiWebView != null) {
                        sapiWebView.loadAccountRealName((String) null, accountRealNameActivity.x, AccountRealNameActivity.this.y, AccountRealNameActivity.this.z, AccountRealNameActivity.this.A, AccountRealNameActivity.this.D);
                    }
                }

                public void onSuccess(GetTplStokenResult getTplStokenResult) {
                    if (AccountRealNameActivity.this.sapiWebView != null) {
                        AccountRealNameActivity accountRealNameActivity = AccountRealNameActivity.this;
                        accountRealNameActivity.sapiWebView.loadAccountRealName(getTplStokenResult.tplStokenMap.get("pp"), accountRealNameActivity.x, AccountRealNameActivity.this.y, AccountRealNameActivity.this.z, AccountRealNameActivity.this.A, AccountRealNameActivity.this.D);
                    }
                }
            }, this.w, arrayList);
            return;
        }
        Toast.makeText(this, getString(R.string.sapi_sdk_account_center_please_relogin), 1).show();
        finishActivity();
    }

    public RealNameDTO getWebDTO() {
        return CoreViewRouter.getInstance().getRealNameDTO();
    }
}
