package com.baidu.sapi2.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.aiscan.R;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.utils.SapiUtils;
import java.net.URLDecoder;

public class AuthWidgetActivity extends BaseActivity {
    public static final String EXTRA_PARAM_AUTH_URL = "auth_url";
    public String w;
    public String x;
    public SapiResult y = new SapiResult();

    /* access modifiers changed from: private */
    public void c() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null || !sapiWebView.canGoBack()) {
            this.y.setResultCode(-301);
            this.y.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
            finishActivity();
            return;
        }
        this.sapiWebView.goBack();
    }

    private void finishActivity() {
        if (CoreViewRouter.getInstance().getAuthWidgetCallback() != null) {
            CoreViewRouter.getInstance().getAuthWidgetCallback().onFailure(this.y);
        }
        finish();
        CoreViewRouter.getInstance().release();
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
        this.y.setResultCode(-301);
        this.y.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
        finishActivity();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.layout_sapi_sdk_webview_with_title_bar);
            String stringExtra = getIntent().getStringExtra(EXTRA_PARAM_AUTH_URL);
            this.w = stringExtra;
            this.x = SapiUtils.urlParamsToMap(stringExtra).get("u");
            if (TextUtils.isEmpty(this.w) || TextUtils.isEmpty(this.x)) {
                this.y.setResultCode(-204);
                this.y.setResultMsg(SapiResult.ERROR_MSG_PARAMS_ERROR);
                finishActivity();
                return;
            }
            init();
            setupViews();
        } catch (Throwable th2) {
            reportWebviewError(th2);
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
        this.sapiWebView.setOnBackCallback(new SapiWebView.OnBackCallback() {
            public void onBack() {
                AuthWidgetActivity.this.c();
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() {
            public void onFinish() {
                AuthWidgetActivity.this.onClose();
            }
        });
        this.sapiWebView.setLeftBtnVisibleCallback(new SapiWebView.LeftBtnVisibleCallback() {
            public void onLeftBtnVisible(int i2) {
                if (i2 == 0) {
                    AuthWidgetActivity.this.setBtnVisibility(4, 4, 4);
                } else {
                    AuthWidgetActivity.this.setBtnVisibility(4, 0, 4);
                }
            }
        });
        this.sapiWebView.setWebviewClientCallback(new SapiWebView.WebviewClientCallback() {
            public void onPageFinished(WebView webView, String str) {
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            }

            public void shouldOverrideUrlLoading(WebView webView, String str) {
                if (!TextUtils.isEmpty(str) && str.contains(URLDecoder.decode(AuthWidgetActivity.this.x))) {
                    CoreViewRouter.getInstance().getAuthWidgetCallback().onSuccess(SapiUtils.urlParamsToMap(str).get("authsid"));
                    AuthWidgetActivity.this.finish();
                }
            }
        });
        this.sapiWebView.loadUrl(this.w);
    }
}
