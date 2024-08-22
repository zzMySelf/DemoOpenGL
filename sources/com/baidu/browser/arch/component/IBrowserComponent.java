package com.baidu.browser.arch.component;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.browser.arch.event.IBrowserEvent;
import com.baidu.browser.arch.event.IBrowserLifecycle;
import com.baidu.browser.arch.service.IBrowserServiceManager;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.BdSailorWebViewClientExt;
import com.baidu.searchbox.ng.browser.NgWebView;
import com.baidu.webkit.sdk.VideoSniffingInfo;
import com.baidu.webkit.sdk.WebViewClient;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/baidu/browser/arch/component/IBrowserComponent;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/baidu/browser/arch/event/IBrowserEvent;", "Lcom/baidu/browser/arch/event/IBrowserLifecycle;", "injectLifecycleOwner", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "injectManager", "manager", "Lcom/baidu/browser/arch/component/IBrowserComponentManager;", "registerService", "serviceManager", "Lcom/baidu/browser/arch/service/IBrowserServiceManager;", "lib-browser-arch_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IBrowserComponent.kt */
public interface IBrowserComponent extends LifecycleObserver, IBrowserEvent, IBrowserLifecycle {
    void injectLifecycleOwner(LifecycleOwner lifecycleOwner);

    void injectManager(IBrowserComponentManager iBrowserComponentManager);

    void registerService(IBrowserServiceManager iBrowserServiceManager);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IBrowserComponent.kt */
    public static final class DefaultImpls {
        public static boolean canGoBack(IBrowserComponent iBrowserComponent) {
            return IBrowserEvent.DefaultImpls.canGoBack(iBrowserComponent);
        }

        public static void doUpdateVisitedHistory(IBrowserComponent iBrowserComponent, BdSailorWebView view2, String url, boolean isReload, boolean isSameDocument, boolean fromContentCache, boolean isBackForward) {
            IBrowserEvent.DefaultImpls.doUpdateVisitedHistory(iBrowserComponent, view2, url, isReload, isSameDocument, fromContentCache, isBackForward);
        }

        public static void handleGoBack(IBrowserComponent iBrowserComponent, boolean isAnim) {
            IBrowserEvent.DefaultImpls.handleGoBack(iBrowserComponent, isAnim);
        }

        public static void handleGoForward(IBrowserComponent iBrowserComponent) {
            IBrowserEvent.DefaultImpls.handleGoForward(iBrowserComponent);
        }

        public static void initSettings(IBrowserComponent iBrowserComponent, NgWebView ngWebView) {
            IBrowserEvent.DefaultImpls.initSettings(iBrowserComponent, ngWebView);
        }

        public static void onAbortResourceRequest(IBrowserComponent iBrowserComponent, BdSailorWebView view2, String url, String mime, long contentLength) {
            IBrowserEvent.DefaultImpls.onAbortResourceRequest(iBrowserComponent, view2, url, mime, contentLength);
        }

        public static void onActivityResult(IBrowserComponent iBrowserComponent, int requestCode, int resultCode, Intent data) {
            IBrowserEvent.DefaultImpls.onActivityResult(iBrowserComponent, requestCode, resultCode, data);
        }

        public static void onAttachToFrameView(IBrowserComponent iBrowserComponent) {
            IBrowserEvent.DefaultImpls.onAttachToFrameView(iBrowserComponent);
        }

        public static void onBeforeLoadUrl(IBrowserComponent iBrowserComponent, String url, Map<String, String> additionalHeader, Boolean isPrefetch, Boolean longPressSearch, String source, Map<String, String> extInfo) {
            IBrowserEvent.DefaultImpls.onBeforeLoadUrl(iBrowserComponent, url, additionalHeader, isPrefetch, longPressSearch, source, extInfo);
        }

        public static void onCommonMenuShow(IBrowserComponent iBrowserComponent, boolean isShow) {
            IBrowserEvent.DefaultImpls.onCommonMenuShow(iBrowserComponent, isShow);
        }

        public static void onConfigurationChanged(IBrowserComponent iBrowserComponent, Configuration config) {
            IBrowserEvent.DefaultImpls.onConfigurationChanged(iBrowserComponent, config);
        }

        public static void onContainerAnimationFinish(IBrowserComponent iBrowserComponent, boolean enter, boolean goback, boolean fromGesture) {
            IBrowserEvent.DefaultImpls.onContainerAnimationFinish(iBrowserComponent, enter, goback, fromGesture);
        }

        public static void onContainerAnimationStart(IBrowserComponent iBrowserComponent, boolean enter, boolean goback, boolean fromGesture) {
            IBrowserEvent.DefaultImpls.onContainerAnimationStart(iBrowserComponent, enter, goback, fromGesture);
        }

        public static void onContainerAttachedToWindow(IBrowserComponent iBrowserComponent) {
            IBrowserEvent.DefaultImpls.onContainerAttachedToWindow(iBrowserComponent);
        }

        public static void onContainerDetachedFromWindow(IBrowserComponent iBrowserComponent) {
            IBrowserEvent.DefaultImpls.onContainerDetachedFromWindow(iBrowserComponent);
        }

        public static void onContainerVisibleChanged(IBrowserComponent iBrowserComponent, boolean show) {
            IBrowserEvent.DefaultImpls.onContainerVisibleChanged(iBrowserComponent, show);
        }

        public static void onCopyLink(IBrowserComponent iBrowserComponent) {
            IBrowserEvent.DefaultImpls.onCopyLink(iBrowserComponent);
        }

        public static void onErrorPageShow(IBrowserComponent iBrowserComponent, boolean isBlock) {
            IBrowserEvent.DefaultImpls.onErrorPageShow(iBrowserComponent, isBlock);
        }

        public static void onFavor(IBrowserComponent iBrowserComponent) {
            IBrowserEvent.DefaultImpls.onFavor(iBrowserComponent);
        }

        public static void onFavorFail(IBrowserComponent iBrowserComponent) {
            IBrowserEvent.DefaultImpls.onFavorFail(iBrowserComponent);
        }

        public static void onFirstScreenPaintFinishedExt(IBrowserComponent iBrowserComponent, BdSailorWebView view2, String url, BdSailorWebViewClientExt.FirstScreenInfo firstScreenInfo) {
            IBrowserEvent.DefaultImpls.onFirstScreenPaintFinishedExt(iBrowserComponent, view2, url, firstScreenInfo);
        }

        public static void onFullScreenModeChanged(IBrowserComponent iBrowserComponent, boolean fullScreenMode) {
            IBrowserEvent.DefaultImpls.onFullScreenModeChanged(iBrowserComponent, fullScreenMode);
        }

        public static void onGoBackOrForwardAnimationFinish(IBrowserComponent iBrowserComponent, BdSailorWebView view2, int i2) {
            IBrowserEvent.DefaultImpls.onGoBackOrForwardAnimationFinish(iBrowserComponent, view2, i2);
        }

        public static void onGoBackOrForwardAnimationStart(IBrowserComponent iBrowserComponent, BdSailorWebView view2, int i2) {
            IBrowserEvent.DefaultImpls.onGoBackOrForwardAnimationStart(iBrowserComponent, view2, i2);
        }

        public static void onNotifyVideoInfo(IBrowserComponent iBrowserComponent, VideoSniffingInfo videoSniffingInfo) {
            IBrowserEvent.DefaultImpls.onNotifyVideoInfo(iBrowserComponent, videoSniffingInfo);
        }

        public static void onPageCommitVisible(IBrowserComponent iBrowserComponent, BdSailorWebView view2, String url) {
            IBrowserEvent.DefaultImpls.onPageCommitVisible(iBrowserComponent, view2, url);
        }

        public static void onPageDetectFinish(IBrowserComponent iBrowserComponent, BdSailorWebView view2, WebViewClient.DetectType type, String jsonValue) {
            IBrowserEvent.DefaultImpls.onPageDetectFinish(iBrowserComponent, view2, type, jsonValue);
        }

        public static void onPageFinished(IBrowserComponent iBrowserComponent, BdSailorWebView view2, String url) {
            IBrowserEvent.DefaultImpls.onPageFinished(iBrowserComponent, view2, url);
        }

        public static void onPageStarted(IBrowserComponent iBrowserComponent, BdSailorWebView view2, String url, Bitmap favicon) {
            IBrowserEvent.DefaultImpls.onPageStarted(iBrowserComponent, view2, url, favicon);
        }

        public static void onReceivedTitle(IBrowserComponent iBrowserComponent, BdSailorWebView view2, String title) {
            IBrowserEvent.DefaultImpls.onReceivedTitle(iBrowserComponent, view2, title);
        }

        public static void onRequestPermissionsResult(IBrowserComponent iBrowserComponent, int requestCode, String[] permissions, int[] grantResults) {
            IBrowserEvent.DefaultImpls.onRequestPermissionsResult(iBrowserComponent, requestCode, permissions, grantResults);
        }

        public static void onRestart(IBrowserComponent iBrowserComponent) {
            IBrowserEvent.DefaultImpls.onRestart(iBrowserComponent);
        }

        public static void onRestore(IBrowserComponent iBrowserComponent, String modelJsonStr) {
            IBrowserEvent.DefaultImpls.onRestore(iBrowserComponent, modelJsonStr);
        }

        public static void onSaveState(IBrowserComponent iBrowserComponent, String modelJsonStr) {
            IBrowserEvent.DefaultImpls.onSaveState(iBrowserComponent, modelJsonStr);
        }

        public static void onSecurityCheckResultExt(IBrowserComponent iBrowserComponent, BdSailorWebView view2, String aUrl, WebViewClient.SecurityInfo securityInfo) {
            IBrowserEvent.DefaultImpls.onSecurityCheckResultExt(iBrowserComponent, view2, aUrl, securityInfo);
        }

        public static void onShareClick(IBrowserComponent iBrowserComponent) {
            IBrowserEvent.DefaultImpls.onShareClick(iBrowserComponent);
        }

        public static void onTabSelected(IBrowserComponent iBrowserComponent, String pd) {
            IBrowserEvent.DefaultImpls.onTabSelected(iBrowserComponent, pd);
        }

        public static void onWindowModeChanged(IBrowserComponent iBrowserComponent, boolean isIncognito) {
            IBrowserEvent.DefaultImpls.onWindowModeChanged(iBrowserComponent, isIncognito);
        }

        public static void onWindowSizeChanged(IBrowserComponent iBrowserComponent, int size, boolean isIncognito) {
            IBrowserEvent.DefaultImpls.onWindowSizeChanged(iBrowserComponent, size, isIncognito);
        }

        public static void resetContainer(IBrowserComponent iBrowserComponent) {
            IBrowserEvent.DefaultImpls.resetContainer(iBrowserComponent);
        }

        public static void updateContext(IBrowserComponent iBrowserComponent, Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            IBrowserEvent.DefaultImpls.updateContext(iBrowserComponent, context);
        }

        public static void updateUIForNight(IBrowserComponent iBrowserComponent, boolean nightMode) {
            IBrowserEvent.DefaultImpls.updateUIForNight(iBrowserComponent, nightMode);
        }
    }
}
