package com.baidu.browser.ioc;

import android.content.Context;
import com.baidu.searchbox.ng.browser.NgWebView;

public interface IBrowserFeed {
    public static final IBrowserFeed EMPTY = new IBrowserFeed() {
        public void addFeedDetailJavaScriptInterface(NgWebView webView, Context context) {
        }

        public void removeFeedDetailJavaScriptInterface(NgWebView webView) {
        }
    };

    void addFeedDetailJavaScriptInterface(NgWebView ngWebView, Context context);

    void removeFeedDetailJavaScriptInterface(NgWebView ngWebView);
}
