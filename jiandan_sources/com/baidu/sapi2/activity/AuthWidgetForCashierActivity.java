package com.baidu.sapi2.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.aiscan.R;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.PassNameValuePair;
import java.util.ArrayList;

public class AuthWidgetForCashierActivity extends BaseActivity {
    public static final String A = "RESULT_KEY_MSG";
    public static final int B = 102;
    public static final String x = "passport://passport.baidu.com/cashiersdk_auth_pass";
    public static final String y = "EXTRA_PARAM_AUTH_ID";
    public static final String z = "RESULT_KEY_CODE";
    public String w;

    /* access modifiers changed from: private */
    public void c() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null || !sapiWebView.canGoBack()) {
            Intent intent = new Intent();
            intent.putExtra(z, 1);
            intent.putExtra(A, "用户取消");
            setResult(102, intent);
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
        Intent intent = new Intent();
        intent.putExtra(z, 1);
        intent.putExtra(A, "用户取消");
        setResult(102, intent);
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_sapi_sdk_webview_with_title_bar);
        this.w = getIntent().getStringExtra("EXTRA_PARAM_AUTH_ID");
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
                AuthWidgetForCashierActivity.this.c();
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() {
            public void onFinish() {
                AuthWidgetForCashierActivity.this.onClose();
            }
        });
        this.sapiWebView.setLeftBtnVisibleCallback(new SapiWebView.LeftBtnVisibleCallback() {
            public void onLeftBtnVisible(int i2) {
                if (i2 == 0) {
                    AuthWidgetForCashierActivity.this.setBtnVisibility(4, 4, 4);
                } else {
                    AuthWidgetForCashierActivity.this.setBtnVisibility(4, 0, 4);
                }
            }
        });
        this.sapiWebView.setWebviewClientCallback(new SapiWebView.WebviewClientCallback() {
            public void onPageFinished(WebView webView, String str) {
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            }

            public void shouldOverrideUrlLoading(WebView webView, String str) {
                if (!TextUtils.isEmpty(str) && str.contains(AuthWidgetForCashierActivity.x)) {
                    Intent intent = new Intent();
                    intent.putExtra(AuthWidgetForCashierActivity.z, 0);
                    intent.putExtra(AuthWidgetForCashierActivity.A, "验证通过");
                    AuthWidgetForCashierActivity.this.setResult(102, intent);
                    AuthWidgetForCashierActivity.this.finish();
                }
            }
        });
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("u", x));
        arrayList.add(new PassNameValuePair("scene", BindVerifyActivity.SCENE));
        arrayList.add(new PassNameValuePair("isnew", "true"));
        arrayList.add(new PassNameValuePair("authid", this.w));
        this.sapiWebView.loadAuthWidget(arrayList, true);
    }
}
