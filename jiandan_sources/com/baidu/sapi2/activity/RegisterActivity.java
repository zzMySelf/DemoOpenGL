package com.baidu.sapi2.activity;

import android.os.Bundle;
import com.baidu.aiscan.R;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.dto.WebRegDTO;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.AccountType;

public class RegisterActivity extends BaseActivity {
    public static final String KEY_PARAMS_LOGIN_USERNAME = "loginUserName";
    public WebAuthResult w = new WebAuthResult() {
        public void finishActivity() {
            super.finishActivity();
            RegisterActivity.this.finish();
            CoreViewRouter.getInstance().release();
        }
    };

    public SapiWebDTO getWebDTO() {
        return CoreViewRouter.getInstance().getWebRegDTO();
    }

    public void init() {
        super.init();
        this.w.activity = this;
    }

    public void onBottomBackBtnClick() {
        this.sapiWebView.back();
    }

    public void onClose() {
        super.onClose();
        WebAuthListener webAuthListener = CoreViewRouter.getInstance().getWebAuthListener();
        this.w.setResultCode(-301);
        this.w.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
        if (webAuthListener != null) {
            webAuthListener.onFailure(this.w);
        }
        finish();
        CoreViewRouter.getInstance().release();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.layout_sapi_sdk_webview_with_title_bar);
            init();
            setupViews();
        } catch (Throwable th2) {
            reportWebviewError(th2);
            WebAuthListener webAuthListener = CoreViewRouter.getInstance().getWebAuthListener();
            if (webAuthListener != null) {
                this.w.setResultCode(-202);
                this.w.setResultMsg(SapiResult.ERROR_MSG_UNKNOWN);
                webAuthListener.onFailure(this.w);
            }
            finish();
            CoreViewRouter.getInstance().release();
        }
    }

    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (this.executeSubClassMethod) {
            this.sapiWebView.back();
        }
    }

    public void setupViews() {
        super.setupViews();
        setTitleText((int) R.string.sapi_sdk_title_register);
        final WebAuthListener webAuthListener = CoreViewRouter.getInstance().getWebAuthListener();
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() {
            public void onFinish() {
                RegisterActivity.this.onClose();
            }
        });
        this.sapiWebView.setAuthorizationListener(new AuthorizationListener() {
            public void beforeSuccess(SapiAccount sapiAccount) {
                super.beforeSuccess(sapiAccount);
                WebAuthListener webAuthListener = webAuthListener;
                if (webAuthListener != null) {
                    webAuthListener.beforeSuccess(sapiAccount);
                }
            }

            public void onFailed(int i2, String str) {
                RegisterActivity.this.w.setResultCode(i2);
                RegisterActivity.this.w.setResultMsg(str);
                WebAuthListener webAuthListener = webAuthListener;
                if (webAuthListener != null) {
                    webAuthListener.onFailure(RegisterActivity.this.w);
                }
                RegisterActivity.this.finish();
                CoreViewRouter.getInstance().release();
            }

            public void onSuccess(AccountType accountType) {
                super.onSuccess(accountType);
                RegisterActivity.this.w.accountType = accountType;
                RegisterActivity.this.w.setResultCode(0);
                WebAuthListener webAuthListener = webAuthListener;
                if (webAuthListener != null) {
                    webAuthListener.onSuccess(RegisterActivity.this.w);
                }
                WebRegDTO webRegDTO = CoreViewRouter.getInstance().getWebRegDTO();
                if (webRegDTO != null && webRegDTO.finishActivityAfterSuc) {
                    RegisterActivity.this.finish();
                    CoreViewRouter.getInstance().release();
                }
            }
        });
        setNewLoginTitleAndSetStyleChangeCallBack();
        WebRegDTO webRegDTO = CoreViewRouter.getInstance().getWebRegDTO();
        this.sapiWebView.loadRegist(webRegDTO != null ? webRegDTO.extraParams : null);
    }
}
