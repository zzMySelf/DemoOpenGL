package com.baidu.searchbox.sport.page.generallive.head;

import android.graphics.Bitmap;
import android.util.Log;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.searchbox.ng.browser.NgWebView;
import com.baidu.searchbox.sport.page.web.SportWebViewClient;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.webkit.sdk.WebResourceRequest;
import com.baidu.webkit.sdk.WebResourceResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J.\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\u0010\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016¨\u0006\u0015"}, d2 = {"com/baidu/searchbox/sport/page/generallive/head/WebHeadComp$onCreateWebViewClient$1", "Lcom/baidu/searchbox/sport/page/web/SportWebViewClient;", "onPageStarted", "", "webview", "Lcom/baidu/browser/sailor/BdSailorWebView;", "s", "", "bitmap", "Landroid/graphics/Bitmap;", "onReceivedError", "webView", "errorCode", "", "desc", "failingUrl", "onReceivedHttpError", "request", "Lcom/baidu/webkit/sdk/WebResourceRequest;", "response", "Lcom/baidu/webkit/sdk/WebResourceResponse;", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebHeadComp.kt */
public final class WebHeadComp$onCreateWebViewClient$1 extends SportWebViewClient {
    final /* synthetic */ WebHeadComp this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WebHeadComp$onCreateWebViewClient$1(WebHeadComp $receiver, WebHeadViewModel $super_call_param$1, NgWebView $super_call_param$2, UnitedSchemeMainDispatcher $super_call_param$3) {
        super($super_call_param$1, $super_call_param$2, $super_call_param$3);
        this.this$0 = $receiver;
    }

    public void onPageStarted(BdSailorWebView webview, String s, Bitmap bitmap) {
        super.onPageStarted(webview, s, bitmap);
        Function1<HeadLoadStatus, Unit> onLoadStatusChange = this.this$0.getOnLoadStatusChange();
        if (onLoadStatusChange != null) {
            onLoadStatusChange.invoke(HeadLoadStatus.ON_START);
        }
    }

    public void onReceivedError(BdSailorWebView webView, int errorCode, String desc, String failingUrl) {
        super.onReceivedError(webView, errorCode, desc, failingUrl);
        if (WebHeadCompKt.DEBUG) {
            Log.d("WebHeadComp", "--->>onReceivedError");
        }
        Function1<HeadLoadStatus, Unit> onLoadStatusChange = this.this$0.getOnLoadStatusChange();
        if (onLoadStatusChange != null) {
            onLoadStatusChange.invoke(HeadLoadStatus.ON_FAILED);
        }
    }

    public void onReceivedHttpError(BdSailorWebView webView, WebResourceRequest request, WebResourceResponse response) {
        super.onReceivedHttpError(webView, request, response);
        if (WebHeadCompKt.DEBUG) {
            Log.d("WebHeadComp", "--->>onReceivedHttpError");
        }
        Function1<HeadLoadStatus, Unit> onLoadStatusChange = this.this$0.getOnLoadStatusChange();
        if (onLoadStatusChange != null) {
            onLoadStatusChange.invoke(HeadLoadStatus.ON_FAILED);
        }
    }
}
