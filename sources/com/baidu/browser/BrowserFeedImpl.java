package com.baidu.browser;

import android.content.Context;
import com.baidu.browser.ioc.IBrowserFeed;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.searchbox.feed.news.jsbridge.FeedDetailJavaScriptInterface;
import com.baidu.searchbox.ng.browser.NgWebView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/baidu/browser/BrowserFeedImpl;", "Lcom/baidu/browser/ioc/IBrowserFeed;", "()V", "addFeedDetailJavaScriptInterface", "", "webView", "Lcom/baidu/searchbox/ng/browser/NgWebView;", "context", "Landroid/content/Context;", "removeFeedDetailJavaScriptInterface", "lib-browser-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BrowserFeedImpl.kt */
public final class BrowserFeedImpl implements IBrowserFeed {
    public void addFeedDetailJavaScriptInterface(NgWebView webView, Context context) {
        FeedDetailJavaScriptInterface feedDetailJavaScriptInterface = new FeedDetailJavaScriptInterface(context, (BdSailorWebView) webView);
        if (webView != null) {
            webView.addJavascriptInterface(feedDetailJavaScriptInterface, "Bdbox_android_feed");
        }
    }

    public void removeFeedDetailJavaScriptInterface(NgWebView webView) {
        if (webView != null) {
            webView.removeJavascriptInterface("Bdbox_android_feed");
        }
    }
}
