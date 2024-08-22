package com.baidu.sapi2.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.aiscan.R;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.result.SapiResult;
import java.util.ArrayList;

public class AuthWidgetOnlyPhoneActivity extends BaseActivity {
    public static final String EXTRA_PARAM_AUTH_ID = "EXTRA_PARAM_AUTH_ID";
    public static final String EXTRA_PARAM_SCENE = "EXTRA_PARAM_SCENE";
    public static final String z = "ppsdk://authwidget/u";
    public String w;
    public String x;
    public SapiResult y = new SapiResult();

    /* access modifiers changed from: private */
    public void c() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null || !sapiWebView.canGoBack()) {
            if (CoreViewRouter.getInstance().getAuthWidgetCallback() != null) {
                this.y.setResultCode(-301);
                this.y.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
                CoreViewRouter.getInstance().getAuthWidgetCallback().onFailure(this.y);
            }
            finish();
            return;
        }
        this.sapiWebView.goBack();
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
        if (CoreViewRouter.getInstance().getAuthWidgetCallback() != null) {
            this.y.setResultCode(-301);
            this.y.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
            CoreViewRouter.getInstance().getAuthWidgetCallback().onFailure(this.y);
        }
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_sapi_sdk_webview_with_title_bar);
        this.w = getIntent().getStringExtra("EXTRA_PARAM_AUTH_ID");
        this.x = getIntent().getStringExtra(EXTRA_PARAM_SCENE);
        init();
        setupViews();
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
                AuthWidgetOnlyPhoneActivity.this.c();
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() {
            public void onFinish() {
                AuthWidgetOnlyPhoneActivity.this.onClose();
            }
        });
        this.sapiWebView.setLeftBtnVisibleCallback(new SapiWebView.LeftBtnVisibleCallback() {
            public void onLeftBtnVisible(int i2) {
                if (i2 == 0) {
                    AuthWidgetOnlyPhoneActivity.this.setBtnVisibility(4, 4, 4);
                } else {
                    AuthWidgetOnlyPhoneActivity.this.setBtnVisibility(4, 0, 4);
                }
            }
        });
        this.sapiWebView.setWebviewClientCallback(new SapiWebView.WebviewClientCallback() {
            public void onPageFinished(WebView webView, String str) {
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            }

            public void shouldOverrideUrlLoading(WebView webView, String str) {
                if (!TextUtils.isEmpty(str) && str.contains(AuthWidgetOnlyPhoneActivity.z)) {
                    if (CoreViewRouter.getInstance().getAuthWidgetCallback() != null) {
                        CoreViewRouter.getInstance().getAuthWidgetCallback().onSuccess(AuthWidgetOnlyPhoneActivity.this.w);
                    }
                    AuthWidgetOnlyPhoneActivity.this.finish();
                }
            }
        });
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("u", z));
        arrayList.add(new PassNameValuePair("scene", this.x));
        arrayList.add(new PassNameValuePair("authid", this.w));
        this.sapiWebView.loadAuthWidget(arrayList);
    }
}
