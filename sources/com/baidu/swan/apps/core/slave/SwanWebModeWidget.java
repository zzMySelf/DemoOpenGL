package com.baidu.swan.apps.core.slave;

import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.BdSailorWebViewClientExt;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.adaptation.interfaces.ISwanExternalTransferStats;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.slave.SwanAppWebViewWidget;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.menu.fontsize.FontSizeSettingHelper;
import com.baidu.swan.apps.util.SwanAppUIUtils;
import com.baidu.swan.apps.web.SwanWebModeController;
import com.baidu.swan.apps.web.statistics.WebStatisticManager;

public class SwanWebModeWidget extends SwanAppWebViewWidget implements CallbackHandler {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String TAG = "SwanWebModeWidget";

    public SwanWebModeWidget(Context context) {
        super(context);
        setExternalWebViewClient(new SwanWebModeClient());
        setExternalWebViewClientExt(new SwanWebWidgetClientExt());
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

    private class SwanWebModeClient extends SwanAppWebViewWidget.WebViewWidgetClient {
        private SwanWebModeClient() {
            super();
        }

        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String url) {
            return SwanWebModeWidget.this.mWebViewWidgetListener != null && SwanWebModeWidget.this.mWebViewWidgetListener.shouldOverrideUrlLoading(url);
        }

        public void onPageStarted(BdSailorWebView bdSailorWebView, String s, Bitmap bitmap) {
            SwanWebModeWidget.this.mResizeStatusBarHeight = SwanAppUIUtils.getStatusBarHeight();
            super.onPageStarted(bdSailorWebView, s, bitmap);
        }

        public void onPageFinished(BdSailorWebView bdSailorWebView, String url) {
            if (SwanWebModeWidget.this.mWebViewWidgetListener != null) {
                SwanWebModeWidget.this.mWebViewWidgetListener.onPageFinished(url);
            }
            WebStatisticManager.getStrategy().onLoadUrlEnd(url);
            SwanWebModeController.getInstance().updateCurPageParam(url);
            SwanWebModeWidget.this.resizeTheFont();
            super.onPageFinished(bdSailorWebView, url);
        }

        public void onReceivedError(BdSailorWebView bdSailorWebView, int errCode, String desc, String failingUrl) {
            if (SwanWebModeWidget.this.mWebViewWidgetListener != null) {
                SwanWebModeWidget.this.mWebViewWidgetListener.onReceivedError(errCode, desc, failingUrl);
            }
            super.onReceivedError(bdSailorWebView, errCode, desc, failingUrl);
        }
    }

    public void resizeTheFont() {
        FontSizeSettingHelper.setFontSize(FontSizeSettingHelper.getFontSizeLevel(), FontSizeSettingHelper.getFontSizeScale());
    }

    public String getFrameName() {
        return "swan_app_web_mode_widget";
    }

    /* access modifiers changed from: protected */
    public void onInitConfig(SwanAppWebViewManager.Config config) {
        super.onInitConfig(config);
        config.isSwanWebMode = true;
    }

    private class SwanWebWidgetClientExt extends BdSailorWebViewClientExt {
        public SwanWebWidgetClientExt() {
        }

        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String url) {
            super.onFirstContentfulPaintExt(bdSailorWebView, url);
            WebStatisticManager.getStrategy().onFcpSubmit(url);
            SwanWebModeController.getInstance().setWebModeArrive(System.currentTimeMillis(), false);
        }

        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String url) {
            super.onFirstTextPaintExt(bdSailorWebView, url);
            WebStatisticManager.getStrategy().onFirstTextPaint(url);
            SwanWebModeController.getInstance().setWebModeArrive(System.currentTimeMillis(), false);
        }

        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String url) {
            super.onFirstImagePaintExt(bdSailorWebView, url);
            WebStatisticManager.getStrategy().onFirstImagePaint(url);
            SwanWebModeController.getInstance().setWebModeArrive(System.currentTimeMillis(), false);
        }

        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String url) {
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, url);
            WebStatisticManager.getStrategy().onFmpSubmit(url);
            SwanWebModeController.getInstance().setWebModeArrive(System.currentTimeMillis(), true);
            SwanAppRuntime.getSwanExternalTransferStats().report(ISwanExternalTransferStats.MINI_SHOW_END, String.valueOf(System.currentTimeMillis()), true);
            SwanAppRuntime.getSwanExternalTransferStats().finish();
        }
    }
}
