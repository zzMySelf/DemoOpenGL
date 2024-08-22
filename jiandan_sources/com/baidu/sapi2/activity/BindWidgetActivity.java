package com.baidu.sapi2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.aiscan.R;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.WebBindWidgetResult;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import java.util.Collections;

public class BindWidgetActivity extends BaseActivity {
    public static final String EXTRA_BDUSS = "EXTRA_BDUSS";
    public static final String EXTRA_BIND_WIDGET_ACTION = "EXTRA_BIND_WIDGET_ACTION";
    public static final int REQUEST_CODE_LOGIN = 200001;
    public BindWidgetAction w;
    public String x;
    public WebBindWidgetResult y = new WebBindWidgetResult() {
        public void loginSuc() {
            super.loginSuc();
            BindWidgetActivity.this.onClose();
        }
    };

    /* access modifiers changed from: private */
    public void c() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null || !sapiWebView.canGoBack()) {
            onClose();
        } else {
            this.sapiWebView.goBack();
        }
    }

    private void finishActivity() {
        if (CoreViewRouter.getInstance().getWebBindWidgetCallback() != null) {
            CoreViewRouter.getInstance().getWebBindWidgetCallback().onFinish(this.y);
        }
        finish();
        CoreViewRouter.getInstance().release();
    }

    public SapiWebDTO getWebDTO() {
        return CoreViewRouter.getInstance().getWebBindWidgetDTO();
    }

    public void init() {
        super.init();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 200001 && i3 == -1) {
            onClose();
        }
    }

    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        c();
    }

    public void onClose() {
        super.onClose();
        this.y.setResultCode(-301);
        this.y.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
        finishActivity();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.layout_sapi_sdk_webview_with_title_bar);
            this.w = (BindWidgetAction) getIntent().getSerializableExtra(EXTRA_BIND_WIDGET_ACTION);
            String stringExtra = getIntent().getStringExtra("EXTRA_BDUSS");
            this.x = stringExtra;
            if (this.w == null || TextUtils.isEmpty(stringExtra)) {
                this.y.setResultCode(-204);
                this.y.setResultMsg(SapiResult.ERROR_MSG_PARAMS_ERROR);
                finishActivity();
                return;
            }
            init();
            setupViews();
        } catch (Throwable th2) {
            reportWebviewError(th2);
            onClose();
        }
    }

    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (this.executeSubClassMethod) {
            c();
        }
    }

    public void onSuccessFinish() {
        this.y.setResultCode(0);
        this.y.setResultMsg("成功");
        finishActivity();
    }

    public void setupViews() {
        super.setupViews();
        setTitleText(this.w.getName());
        this.sapiWebView.setOnBackCallback(new SapiWebView.OnBackCallback() {
            public void onBack() {
                BindWidgetActivity.this.c();
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() {
            public void onFinish() {
                BindWidgetActivity.this.onSuccessFinish();
            }
        });
        this.sapiWebView.setBindWidgetCallback(new SapiWebView.BindWidgetCallback() {
            public void onPhoneNumberExist(String str) {
                SapiAccountManager.getInstance().getSapiConfiguration().presetPhoneNumber = str;
                if (!CoreViewRouter.getInstance().getWebBindWidgetDTO().handleLogin || CoreViewRouter.getInstance().getWebBindWidgetCallback() == null) {
                    Intent intent = new Intent(BindWidgetActivity.this, LoginActivity.class);
                    intent.putExtra(LoginActivity.EXTRA_LOGIN_TYPE, WebLoginDTO.EXTRA_LOGIN_WITH_SMS);
                    intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, BaseActivity.EXTRA_PARAM_FROM_ACCOUNT_CENTER);
                    BindWidgetActivity.this.startActivityForResult(intent, BindWidgetActivity.REQUEST_CODE_LOGIN);
                    return;
                }
                BindWidgetActivity.this.y.setResultCode(-10001);
                BindWidgetActivity.this.y.setResultMsg("请登录");
                CoreViewRouter.getInstance().getWebBindWidgetCallback().onFinish(BindWidgetActivity.this.y);
            }
        });
        this.sapiWebView.loadBindWidget(this.w, this.x, (String) null, true, Collections.singletonList(SapiWebView.EXTRA_BIND_WIDGET_CONFLICT_DETECT));
    }
}
