package com.baidu.sapi2.activity;

import android.os.Bundle;
import android.widget.Toast;
import com.baidu.aiscan.R;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.QrLoginCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.result.QrAppLoginResult;
import com.baidu.sapi2.result.QrLoginResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.QrLoginAction;

public class QrLoginActivity extends BaseActivity {
    public static final String EXTRA_BOOLEAN_FINISH_PAGE = "EXTRA_BOOLEAN_FINISH_PAGE";
    public static final String EXTRA_STRING_QR_LOGIN_URL = "EXTRA_STRING_QR_LOGIN_URL";
    public String w;
    public boolean x;
    public QrLoginResult y = new QrLoginResult();

    /* access modifiers changed from: private */
    public void b(boolean z) {
        try {
            this.sapiWebView.destroy();
        } catch (Exception unused) {
        }
        QrLoginCallback qrLoginCallback = CoreViewRouter.getInstance().getQrLoginCallback();
        if (qrLoginCallback != null) {
            qrLoginCallback.onFinish(this.y);
        }
        if (z) {
            finish();
        }
        CoreViewRouter.getInstance().release();
    }

    private void c() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null || !sapiWebView.canGoBack()) {
            onClose();
        } else {
            this.sapiWebView.back();
        }
    }

    private void finishActivity() {
        b(true);
    }

    public void init() {
        super.init();
        this.w = getIntent().getStringExtra(EXTRA_STRING_QR_LOGIN_URL);
        this.x = getIntent().getBooleanExtra(EXTRA_BOOLEAN_FINISH_PAGE, true);
        if (!SapiUtils.isQrLoginSchema(this.w)) {
            Toast.makeText(this, "抱歉，您扫描的二维码有误，请重新扫描", 0).show();
            this.y.setResultCode(-204);
            this.y.setResultMsg(SapiResult.ERROR_MSG_PARAMS_ERROR);
            finishActivity();
        }
    }

    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        c();
    }

    public void onClose() {
        super.onClose();
        SapiAccountManager.getInstance().getAccountService().qrAppLogin(new SapiCallback<QrAppLoginResult>() {
            public void onFailure(QrAppLoginResult qrAppLoginResult) {
            }

            public void onFinish() {
            }

            public void onStart() {
            }

            public void onSuccess(QrAppLoginResult qrAppLoginResult) {
            }
        }, this.w, QrLoginAction.CANCEL.getName());
        this.y.setResultCode(-301);
        this.y.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
        finishActivity();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.layout_sapi_sdk_webview_with_title_bar);
            init();
            setupViews();
        } catch (Throwable th2) {
            reportWebviewError(th2);
            this.y.setResultCode(-202);
            this.y.setResultMsg(SapiResult.ERROR_MSG_UNKNOWN);
            finishActivity();
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
        setTitle(R.string.sapi_sdk_title_qr_login);
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() {
            public boolean onBack() {
                SapiWebView sapiWebView = QrLoginActivity.this.sapiWebView;
                if (sapiWebView == null || !sapiWebView.canGoBack()) {
                    QrLoginActivity.this.onClose();
                    return false;
                }
                QrLoginActivity.this.sapiWebView.goBack();
                return false;
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() {
            public void onFinish() {
                QrLoginActivity.this.onClose();
            }
        });
        this.sapiWebView.loadQrLogin(new SapiWebView.QrLoginCallback() {
            public void loginStatusChange(boolean z) {
                QrLoginResult qrLoginResult = QrLoginActivity.this.y;
                qrLoginResult.loginStatusChange = z;
                qrLoginResult.setResultCode(0);
                QrLoginActivity.this.y.setResultMsg("成功");
                QrLoginActivity qrLoginActivity = QrLoginActivity.this;
                qrLoginActivity.b(qrLoginActivity.x);
            }
        }, this.w, false);
    }
}
