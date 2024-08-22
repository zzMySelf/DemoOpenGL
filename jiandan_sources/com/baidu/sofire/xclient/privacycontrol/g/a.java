package com.baidu.sofire.xclient.privacycontrol.g;

import android.graphics.Bitmap;
import android.os.Build;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.sofire.xclient.privacycontrol.ui.DoubleListActivity;

public class a extends WebViewClient {
    public final /* synthetic */ DoubleListActivity a;

    public a(DoubleListActivity doubleListActivity) {
        this.a = doubleListActivity;
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.a.b.setVisibility(4);
        this.a.a.setVisibility(0);
    }

    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        super.onReceivedError(webView, i2, str, str2);
        if (Build.VERSION.SDK_INT < 23) {
            this.a.b.setVisibility(0);
            this.a.a.setVisibility(4);
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        this.a.a.loadUrl(str);
        return true;
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (Build.VERSION.SDK_INT >= 21 && webResourceRequest.isForMainFrame()) {
            this.a.b.setVisibility(0);
            this.a.a.setVisibility(4);
        }
    }
}
