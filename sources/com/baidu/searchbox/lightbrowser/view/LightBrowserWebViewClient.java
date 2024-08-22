package com.baidu.searchbox.lightbrowser.view;

import android.graphics.Bitmap;
import android.os.Message;
import android.view.KeyEvent;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.webkit.sdk.ClientCertRequest;
import com.baidu.webkit.sdk.RenderProcessGoneDetail;
import com.baidu.webkit.sdk.WebResourceError;
import com.baidu.webkit.sdk.WebResourceRequest;
import com.baidu.webkit.sdk.WebResourceResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J$\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\"\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J,\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\bH\u0016J \u0010 \u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"H\u0016J.\u0010#\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010\b2\b\u0010%\u001a\u0004\u0018\u00010\b2\b\u0010&\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010'\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010(\u001a\u00020)H\u0016J \u0010*\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0016J\u0018\u0010.\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010/\u001a\u000200H\u0016J\u001a\u00101\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u00102\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010/\u001a\u000200H\u0016J\u0018\u00103\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u00064"}, d2 = {"Lcom/baidu/searchbox/lightbrowser/view/LightBrowserWebViewClient;", "", "()V", "doUpdateVisitedHistory", "", "view", "Lcom/baidu/browser/sailor/BdSailorWebView;", "url", "", "isReload", "", "onFormResubmission", "dontResend", "Landroid/os/Message;", "resend", "onLoadResource", "onPageCommitVisible", "onPageFinished", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onReceivedClientCertRequest", "request", "Lcom/baidu/webkit/sdk/ClientCertRequest;", "onReceivedError", "Lcom/baidu/webkit/sdk/WebResourceRequest;", "error", "Lcom/baidu/webkit/sdk/WebResourceError;", "errorCode", "", "description", "failingUrl", "onReceivedHttpError", "errorResponse", "Lcom/baidu/webkit/sdk/WebResourceResponse;", "onReceivedLoginRequest", "realm", "account", "args", "onRenderProcessGone", "detail", "Lcom/baidu/webkit/sdk/RenderProcessGoneDetail;", "onScaleChanged", "oldScale", "", "newScale", "onUnhandledKeyEvent", "e", "Landroid/view/KeyEvent;", "shouldInterceptRequest", "shouldOverrideKeyEvent", "shouldOverrideUrlLoading", "lib-lightbrowser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LightBrowserWebViewClient.kt */
public class LightBrowserWebViewClient {
    public void onPageFinished(BdSailorWebView view2, String url) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(url, "url");
    }

    public void onPageStarted(BdSailorWebView view2, String url, Bitmap favicon) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(url, "url");
    }

    public void onPageCommitVisible(BdSailorWebView view2, String url) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(url, "url");
    }

    public void doUpdateVisitedHistory(BdSailorWebView view2, String url, boolean isReload) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(url, "url");
    }

    public void onFormResubmission(BdSailorWebView view2, Message dontResend, Message resend) {
        Intrinsics.checkNotNullParameter(view2, "view");
    }

    public void onLoadResource(BdSailorWebView view2, String url) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(url, "url");
    }

    public void onReceivedError(BdSailorWebView view2, int errorCode, String description, String failingUrl) {
        Intrinsics.checkNotNullParameter(view2, "view");
    }

    public void onReceivedError(BdSailorWebView view2, WebResourceRequest request, WebResourceError error) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(error, "error");
    }

    public void onReceivedLoginRequest(BdSailorWebView view2, String realm, String account, String args) {
        Intrinsics.checkNotNullParameter(view2, "view");
    }

    public void onScaleChanged(BdSailorWebView view2, float oldScale, float newScale) {
        Intrinsics.checkNotNullParameter(view2, "view");
    }

    public void onUnhandledKeyEvent(BdSailorWebView view2, KeyEvent e2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(e2, "e");
    }

    public WebResourceResponse shouldInterceptRequest(BdSailorWebView view2, String url) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        return null;
    }

    public boolean shouldOverrideKeyEvent(BdSailorWebView view2, KeyEvent e2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(e2, "e");
        return false;
    }

    public boolean shouldOverrideUrlLoading(BdSailorWebView view2, String url) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        return false;
    }

    public void onReceivedClientCertRequest(BdSailorWebView view2, ClientCertRequest request) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(request, "request");
    }

    public void onReceivedHttpError(BdSailorWebView view2, WebResourceRequest request, WebResourceResponse errorResponse) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(errorResponse, "errorResponse");
    }

    public boolean onRenderProcessGone(BdSailorWebView view2, RenderProcessGoneDetail detail) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(detail, "detail");
        return false;
    }
}
