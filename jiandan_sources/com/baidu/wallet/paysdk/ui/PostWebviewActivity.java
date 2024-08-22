package com.baidu.wallet.paysdk.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.apollon.webmanager.SafeWebView;
import com.dxmpay.wallet.base.widget.BdActionBar;
import com.dxmpay.wallet.core.SDKBaseActivity;
import com.dxmpay.wallet.core.utils.LogUtil;

public class PostWebviewActivity extends DxmPayBaseActivity {
    public SafeWebView a;

    public class a extends SafeWebView.SafeChromeClient {
        public a() {
        }

        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            PostWebviewActivity postWebviewActivity = PostWebviewActivity.this;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            postWebviewActivity.a(str);
        }
    }

    public static void startPostWebview(Context context, String str, byte[] bArr, String str2) {
        if (context != null) {
            Intent intent = new Intent(context, PostWebviewActivity.class);
            intent.putExtra("jump_url", str);
            if (!TextUtils.isEmpty(str2)) {
                intent.putExtra("web_title", str2);
            }
            if (bArr != null && bArr.length > 0) {
                intent.putExtra("url_post_data", bArr);
            }
            context.startActivity(intent);
        }
    }

    public SDKBaseActivity.BottomBarType getBottomBarType() {
        return SDKBaseActivity.BottomBarType.NONE;
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        byte[] bArr;
        String str;
        super.onCreate(bundle);
        setContentView(ResUtils.layout(getActivity(), "dxm_wallet_base_webview_layout"));
        Bundle extras = getIntent().getExtras();
        String str2 = "";
        if (extras != null) {
            str = extras.getString("jump_url");
            bArr = extras.getByteArray("url_post_data");
            str2 = extras.getString("web_title", str2);
        } else {
            bArr = null;
            str = str2;
        }
        this.a = (SafeWebView) findViewById(ResUtils.id(getActivity(), "dxm_cust_webview"));
        if (TextUtils.isEmpty(str2)) {
            this.a.setWebChromeClient(new a());
        }
        this.a.getSettings().setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT <= 18) {
            this.a.getSettings().setSavePassword(false);
        }
        this.a.setScrollBarStyle(0);
        this.a.clearCache(false);
        this.a.resumeTimers();
        if (Build.VERSION.SDK_INT >= 11) {
            this.a.removeJavascriptInterface("searchBoxJavaBridge_");
            this.a.removeJavascriptInterface("accessibility");
            this.a.removeJavascriptInterface("accessibilityTraversal");
        }
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    this.a.postUrl(str.trim(), bArr);
                    a(str2);
                }
            } catch (Exception e) {
                LogUtil.e("PostWebviewActivity", e.getMessage(), e);
            }
        }
        this.a.loadUrl(str.trim());
        a(str2);
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        BdActionBar bdActionBar = (BdActionBar) findViewById(ResUtils.id(getActivity(), "bdactionbar"));
        if (bdActionBar != null) {
            bdActionBar.setTitle(str);
            bdActionBar.setLeftZoneOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    GlobalUtils.hideKeyboard(PostWebviewActivity.this.getActivity());
                    PostWebviewActivity.this.onBackPressed();
                }
            });
        }
    }
}
