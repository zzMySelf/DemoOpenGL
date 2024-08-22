package com.baidu.sofire.xclient.privacycontrol.g;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.sofire.xclient.privacycontrol.ui.ThirdLibActivity;

public class b extends WebViewClient {
    public final /* synthetic */ ThirdLibActivity a;

    public b(ThirdLibActivity thirdLibActivity) {
        this.a = thirdLibActivity;
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
        ThirdLibActivity thirdLibActivity;
        if (!str.startsWith("http://")) {
            thirdLibActivity = this.a;
        } else if (Build.VERSION.SDK_INT >= 23 && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
            ThirdLibActivity thirdLibActivity2 = this.a;
            int i2 = ThirdLibActivity.c;
            thirdLibActivity2.getClass();
            try {
                thirdLibActivity2.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            } catch (Throwable unused) {
                return true;
            }
        } else {
            thirdLibActivity = this.a;
        }
        thirdLibActivity.a.loadUrl(str);
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
