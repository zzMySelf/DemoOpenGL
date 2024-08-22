package com.baidu.browser.components.sniffer;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.ValueCallback;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.browser.arch.component.BrowserComponent;
import com.baidu.browser.components.novel.utils.NovelWhiteListUtils;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.ng.browser.NgWebView;
import com.baidu.searchbox.sniffer.service.ISnifferFun;
import com.baidu.webkit.sdk.VideoSniffingInfo;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J<\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u0012\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016J\u001a\u0010\u0018\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001c\u0010\u001e\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016J&\u0010\u001f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\bH\u0016J\b\u0010#\u001a\u00020\bH\u0016J\b\u0010$\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/baidu/browser/components/sniffer/SnifferComponent;", "Lcom/baidu/browser/arch/component/BrowserComponent;", "()V", "snifferFunManager", "Lcom/baidu/searchbox/sniffer/service/ISnifferFun;", "startSnifferMsg", "", "doUpdateVisitedHistory", "", "view", "Lcom/baidu/browser/sailor/BdSailorWebView;", "url", "isReload", "", "isSameDocument", "fromContentCache", "isBackForward", "initSettings", "ngWebView", "Lcom/baidu/searchbox/ng/browser/NgWebView;", "onConfigurationChanged", "config", "Landroid/content/res/Configuration;", "onDestroy", "onGoBackOrForwardAnimationFinish", "i", "", "onNotifyVideoInfo", "videoSniffingInfo", "Lcom/baidu/webkit/sdk/VideoSniffingInfo;", "onPageFinished", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onPause", "onResume", "resetContainer", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SnifferComponent.kt */
public final class SnifferComponent extends BrowserComponent {
    private final ISnifferFun snifferFunManager;
    private final String startSnifferMsg = "javascript:(function() {typeof window.__$bdba4sptp8_$1bdb0lite6__ === 'function' && window.__$bdba4sptp8_$1bdb0lite6__();})();";

    public SnifferComponent() {
        Object service = ServiceManager.getService(ISnifferFun.Companion.getSERVICE_REFERENCE());
        Intrinsics.checkNotNullExpressionValue(service, "getService(ISnifferFun.SERVICE_REFERENCE)");
        this.snifferFunManager = (ISnifferFun) service;
    }

    public void initSettings(NgWebView ngWebView) {
        if (getManager().getPageViewContext().getContainerType() == 16) {
            String cacheJs = this.snifferFunManager.getSnifferJsString();
            CharSequence charSequence = cacheJs;
            if (charSequence == null || charSequence.length() == 0) {
                ExecutorUtilsExt.postOnElastic(new SnifferComponent$$ExternalSyntheticLambda2(this, ngWebView), "addDocumentSnifferJs", 1);
            } else if (ngWebView != null) {
                ngWebView.addDocumentStartJavaScript(cacheJs, new String[]{"*"}, false, false);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initSettings$lambda-1  reason: not valid java name */
    public static final void m12725initSettings$lambda1(SnifferComponent this$0, NgWebView $ngWebView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String js = this$0.snifferFunManager.getSnifferJsFromFile();
        if (js != null) {
            UiThreadUtils.runOnUiThread(new SnifferComponent$$ExternalSyntheticLambda3($ngWebView, js));
            if (AppConfig.isDebug()) {
                Log.d("SnifferComponent", "initSettings: " + js);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initSettings$lambda-1$lambda-0  reason: not valid java name */
    public static final void m12726initSettings$lambda1$lambda0(NgWebView $ngWebView, String $js) {
        Intrinsics.checkNotNullParameter($js, "$js");
        if ($ngWebView != null && !$ngWebView.isDestroyed()) {
            $ngWebView.addDocumentStartJavaScript($js, new String[]{"*"}, false, false);
        }
    }

    public void onPageFinished(BdSailorWebView view2, String url) {
        if (getManager().getPageViewContext().getContainerType() == 16) {
            ExecutorUtilsExt.postOnElastic(new SnifferComponent$$ExternalSyntheticLambda0(url, this, new WeakReference(view2)), "verifySnifferWhiteList", 0);
            if (AppConfig.isDebug()) {
                Log.d("SnifferComponent", "onPageFinished: " + url);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onPageFinished$lambda-3  reason: not valid java name */
    public static final void m12727onPageFinished$lambda3(String $url, SnifferComponent this$0, WeakReference $webViewRef) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($webViewRef, "$webViewRef");
        if (!NovelWhiteListUtils.isContainInWhiteList($url)) {
            if (this$0.snifferFunManager.snifferUrlSwitch($url == null ? "" : $url)) {
                UiThreadUtils.runOnUiThread(new SnifferComponent$$ExternalSyntheticLambda1($webViewRef, this$0));
            }
        } else if (AppConfig.isDebug()) {
            Log.d("SnifferComponent", "onPageFinished:该嗅探页面被小说白名单劫持");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onPageFinished$lambda-3$lambda-2  reason: not valid java name */
    public static final void m12728onPageFinished$lambda3$lambda2(WeakReference $webViewRef, SnifferComponent this$0) {
        Intrinsics.checkNotNullParameter($webViewRef, "$webViewRef");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BdSailorWebView bdSailorWebView = (BdSailorWebView) $webViewRef.get();
        if (bdSailorWebView != null) {
            bdSailorWebView.evaluateJavascript(this$0.startSnifferMsg, (ValueCallback<String>) null);
        }
    }

    public void onPageStarted(BdSailorWebView view2, String url, Bitmap favicon) {
        if (getManager().getPageViewContext().getContainerType() == 16) {
            this.snifferFunManager.onPageStarted(view2, url, favicon);
            if (AppConfig.isDebug()) {
                Log.d("SnifferComponent", "onPageStarted: " + url);
            }
        }
    }

    public void onDestroy() {
        if (getManager().getPageViewContext().getContainerType() == 16) {
            this.snifferFunManager.onDestroy();
            if (AppConfig.isDebug()) {
                Log.d("SnifferComponent", "onDestroy: ");
            }
        }
    }

    public void onPause() {
        if (getManager().getPageViewContext().getContainerType() == 16) {
            ISnifferFun iSnifferFun = this.snifferFunManager;
            String currentPageUrl = getManager().getPageViewContext().getCurrentPageUrl();
            if (currentPageUrl == null) {
                currentPageUrl = "";
            }
            iSnifferFun.onPause(currentPageUrl);
            if (AppConfig.isDebug()) {
                Log.d("SnifferComponent", "onPause: ");
            }
        }
    }

    public void onResume() {
        if (getManager().getPageViewContext().getContainerType() == 16) {
            ISnifferFun iSnifferFun = this.snifferFunManager;
            String currentPageUrl = getManager().getPageViewContext().getCurrentPageUrl();
            if (currentPageUrl == null) {
                currentPageUrl = "";
            }
            iSnifferFun.onResume(currentPageUrl);
            if (AppConfig.isDebug()) {
                Log.d("SnifferComponent", "onResume: ");
            }
        }
    }

    public void doUpdateVisitedHistory(BdSailorWebView view2, String url, boolean isReload, boolean isSameDocument, boolean fromContentCache, boolean isBackForward) {
        if (getManager().getPageViewContext().getContainerType() == 16) {
            this.snifferFunManager.doUpdateVisitedHistory(view2, url, isReload, isSameDocument, fromContentCache, isBackForward);
            if (AppConfig.isDebug()) {
                Log.d("SnifferComponent", "doUpdateVisitedHistory: ");
            }
        }
    }

    public void resetContainer() {
        if (getManager().getPageViewContext().getContainerType() == 16) {
            this.snifferFunManager.resetContainer();
            if (AppConfig.isDebug()) {
                Log.d("SnifferComponent", "resetContainer: ");
            }
        }
    }

    public void onGoBackOrForwardAnimationFinish(BdSailorWebView view2, int i2) {
        if (getManager().getPageViewContext().getContainerType() == 16) {
            this.snifferFunManager.onGoBackOrForwardAnimationFinish(view2, i2);
            if (AppConfig.isDebug()) {
                Log.d("SnifferComponent", "onGoBackOrForwardAnimationFinish: ");
            }
        }
    }

    public void onNotifyVideoInfo(VideoSniffingInfo videoSniffingInfo) {
        if (getManager().getPageViewContext().getContainerType() == 16) {
            this.snifferFunManager.onNotifyVideoInfo();
            if (AppConfig.isDebug()) {
                Log.d("SnifferComponent", "onNotifyVideoInfo ");
            }
        }
    }

    public void onConfigurationChanged(Configuration config) {
        if (getManager().getPageViewContext().getContainerType() == 16) {
            this.snifferFunManager.onConfigurationChanged(config);
            if (AppConfig.isDebug()) {
                Log.d("SnifferComponent", "onConfigurationChanged");
            }
        }
    }
}
