package com.baidu.sapi2.activity;

import android.os.Bundle;
import com.baidu.aiscan.R;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.SapiWebDTO;

public class ForgetPwdActivity extends BaseActivity {
    /* access modifiers changed from: private */
    public void c() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null || !sapiWebView.canGoBack()) {
            finish();
        } else {
            this.sapiWebView.goBack();
        }
    }

    public SapiWebDTO getWebDTO() {
        return CoreViewRouter.getInstance().getWebLoginDTO();
    }

    public void init() {
        super.init();
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
            init();
            setupViews();
        } catch (Throwable th2) {
            reportWebviewError(th2);
            finish();
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
        setBtnVisibility(4, 0, 4);
        setTitleText((int) R.string.sapi_sdk_title_forget_pwd);
        this.sapiWebView.setOnBackCallback(new SapiWebView.OnBackCallback() {
            public void onBack() {
                ForgetPwdActivity.this.c();
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() {
            public void onFinish() {
                ForgetPwdActivity.this.finish();
            }
        });
        this.sapiWebView.setChangePwdCallback(new SapiWebView.ChangePwdCallback() {
            public void onSuccess() {
                ForgetPwdActivity.this.finish();
            }
        });
        this.sapiWebView.loadForgetPwd();
    }
}
