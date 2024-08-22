package com.baidu.searchbox.lightbrowser.view;

import com.baidu.browser.sailor.BdSailorWebChromeClientExt;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.searchbox.lightbrowser.listener.IBrowserLongPressListener;
import com.baidu.webkit.sdk.WebView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J,\u0010\t\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J<\u0010\u000f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/lightbrowser/view/DefWebChromeClientExt;", "Lcom/baidu/browser/sailor/BdSailorWebChromeClientExt;", "browserView", "Lcom/baidu/searchbox/lightbrowser/view/LightBrowserView;", "(Lcom/baidu/searchbox/lightbrowser/view/LightBrowserView;)V", "hideSelectionActionDialogExt", "", "view", "Lcom/baidu/browser/sailor/BdSailorWebView;", "performLongClickExt", "result", "Lcom/baidu/webkit/sdk/WebView$HitTestResult;", "x", "", "y", "showSelectionActionDialogExt", "top", "bottom", "left", "right", "text", "", "lib-lightbrowser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefWebChromeClientExt.kt */
public final class DefWebChromeClientExt extends BdSailorWebChromeClientExt {
    private final LightBrowserView browserView;

    public DefWebChromeClientExt(LightBrowserView browserView2) {
        Intrinsics.checkNotNullParameter(browserView2, "browserView");
        this.browserView = browserView2;
    }

    public void performLongClickExt(BdSailorWebView view2, WebView.HitTestResult result, int x, int y) {
        LongPressMenu menu;
        super.performLongClickExt(view2, result, x, y);
        if (result != null && !this.browserView.checkPopMenuStatus() && result.getType() == 10) {
            IBrowserLongPressListener browserLongPressListener = this.browserView.getBrowserLongPressListener();
            boolean z = true;
            if (browserLongPressListener == null || !browserLongPressListener.onLongPress(result)) {
                z = false;
            }
            if (!z && (menu = this.browserView.getMenu()) != null) {
                menu.showTextPopMenuAndNotify();
            }
        }
    }

    public void hideSelectionActionDialogExt(BdSailorWebView view2) {
        super.hideSelectionActionDialogExt(view2);
        this.browserView.hideSelectionDialog();
    }

    public void showSelectionActionDialogExt(BdSailorWebView view2, int top, int bottom, int left, int right, String text) {
        this.browserView.showSelectionDialog(top, bottom, left, right, text);
    }
}
