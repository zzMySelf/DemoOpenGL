package com.baidu.swan.apps.view;

import android.content.Context;
import com.baidu.browser.sailor.BdSailorWebChromeClient;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.swan.apps.core.slave.SwanAppWebViewWidget;

public class SwanAppSimpleH5Widget extends SwanAppWebViewWidget {
    public SwanAppSimpleH5Widget(Context context) {
        super(context);
        setExternalWebViewClient(new SimpleWebViewClient());
        setExternalWebChromeClient(new SimpleWebChromeClient());
    }

    /* access modifiers changed from: protected */
    public boolean shouldCheckWebDomain() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean shouldCheckWebviewWhiteList() {
        return false;
    }

    public boolean hookGoBack() {
        if (this.mWebViewWidgetListener != null) {
            this.mWebViewWidgetListener.goBack();
        }
        return super.hookGoBack();
    }

    private class SimpleWebViewClient extends SwanAppWebViewWidget.WebViewWidgetClient {
        private SimpleWebViewClient() {
            super();
        }

        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String url) {
            return SwanAppSimpleH5Widget.this.mWebViewWidgetListener != null && SwanAppSimpleH5Widget.this.mWebViewWidgetListener.shouldOverrideUrlLoading(url);
        }

        public void onPageFinished(BdSailorWebView bdSailorWebView, String url) {
            if (SwanAppSimpleH5Widget.this.mWebViewWidgetListener != null) {
                SwanAppSimpleH5Widget.this.mWebViewWidgetListener.onPageFinished(url);
            }
            super.onPageFinished(bdSailorWebView, url);
        }

        public void onReceivedError(BdSailorWebView bdSailorWebView, int errCode, String desc, String failingUrl) {
            if (SwanAppSimpleH5Widget.this.mWebViewWidgetListener != null) {
                SwanAppSimpleH5Widget.this.mWebViewWidgetListener.onReceivedError(errCode, desc, failingUrl);
            }
            super.onReceivedError(bdSailorWebView, errCode, desc, failingUrl);
        }
    }

    class SimpleWebChromeClient extends BdSailorWebChromeClient {
        SimpleWebChromeClient() {
        }

        public void onReceivedTitle(BdSailorWebView view2, String title) {
            super.onReceivedTitle(view2, title);
            if (SwanAppSimpleH5Widget.this.mWebViewWidgetListener != null) {
                SwanAppSimpleH5Widget.this.mWebViewWidgetListener.onReceivedTitle(title);
            }
        }
    }
}
