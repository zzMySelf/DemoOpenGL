package com.baidu.browser.sailor;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.ConsoleMessage;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.Toast;
import android.widget.ZoomButtonsController;
import com.baidu.browser.sailor.BdSailorWebSettings;
import com.baidu.browser.sailor.BdSailorWebViewClientExt;
import com.baidu.browser.sailor.feature.a;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.browser.sailor.util.c;
import com.baidu.browser.sailor.util.d;
import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.internal.cloudsetting.CloudSettingSDK;
import com.baidu.webkit.internal.monitor.MonitorConstant;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import com.baidu.webkit.sdk.ClientCertRequest;
import com.baidu.webkit.sdk.DownloadListener;
import com.baidu.webkit.sdk.FirstScreenImageInfomation;
import com.baidu.webkit.sdk.GeolocationPermissions;
import com.baidu.webkit.sdk.HttpAuthHandler;
import com.baidu.webkit.sdk.JsCodeCacheResult;
import com.baidu.webkit.sdk.JsPromptResult;
import com.baidu.webkit.sdk.JsResult;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.PageTransformer;
import com.baidu.webkit.sdk.PermissionRequest;
import com.baidu.webkit.sdk.RenderProcessGoneDetail;
import com.baidu.webkit.sdk.SnapshotExtraInfo;
import com.baidu.webkit.sdk.VideoPlayerFactory;
import com.baidu.webkit.sdk.VideoSniffingInfo;
import com.baidu.webkit.sdk.WebAppShortcutDataListener;
import com.baidu.webkit.sdk.WebBackForwardList;
import com.baidu.webkit.sdk.WebBackForwardListClient;
import com.baidu.webkit.sdk.WebChromeClient;
import com.baidu.webkit.sdk.WebHistoryItem;
import com.baidu.webkit.sdk.WebMessageListener;
import com.baidu.webkit.sdk.WebResourceError;
import com.baidu.webkit.sdk.WebResourceRequest;
import com.baidu.webkit.sdk.WebResourceResponse;
import com.baidu.webkit.sdk.WebScriptHandler;
import com.baidu.webkit.sdk.WebStorage;
import com.baidu.webkit.sdk.WebView;
import com.baidu.webkit.sdk.WebViewClient;
import com.baidu.webkit.sdk.WebViewDelegate;
import com.baidu.webkit.sdk.WebViewRenderProcess;
import com.baidu.webkit.sdk.WebViewRenderProcessClient;
import com.baidu.webkit.sdk.abtest.ABTestSDK;
import com.baidu.webkit.sdk.jsapi.IJsAbility;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public class BdSailorWebView extends FrameLayout {
    protected static final FrameLayout.LayoutParams COVER_SCREEN_PARAMS = new FrameLayout.LayoutParams(-1, -1);
    private static final String JAVASCTIPT_URL = "javascript:";
    /* access modifiers changed from: private */
    public static final String LOG_TAG = BdSailorWebView.class.getSimpleName();
    private static final String SHOW_IMAGE_PREFIX = "imagedisplay:";
    public static final int SITE_TYPE_DEFAULT = -1;
    public static final int SITE_TYPE_NOVEL = 1;
    public static final int SITE_TYPE_OTHERS = 0;
    public static final int SITE_TYPE_VIDEO = 2;
    private static boolean sInitFirstWebView = true;
    private boolean mCanHideTitlebar;
    private boolean mCanShowTitlebar;
    private View mCurrentTitleBar;
    /* access modifiers changed from: private */
    public WebView mCurrentWebView;
    /* access modifiers changed from: private */
    public View mCustomView;
    /* access modifiers changed from: private */
    public WebChromeClient.CustomViewCallback mCustomViewCallback;
    /* access modifiers changed from: private */
    public ISailorDownloadListener mDownloadListener;
    /* access modifiers changed from: private */
    public View mEmbeddedTitlebar;
    /* access modifiers changed from: private */
    public int mEmbeddedTitlebarHeightPix;
    /* access modifiers changed from: private */
    public FrameLayout mFullscreenContainer;
    private FrameLayout mFunctionViewLayer;
    /* access modifiers changed from: private */
    public boolean mHitFlingGesture;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, FirstScreenImageInfomation.FirstScreenImageItem> mImageMap;
    /* access modifiers changed from: private */
    public boolean mIsFunctionLayerShowing;
    /* access modifiers changed from: private */
    public boolean mIsPageLoading;
    private View mLandingPageTitleBar;
    private boolean mLockEmbeddedTitlebar;
    private int mMarginBottom;
    private int mMarginLeft;
    private int mMarginRight;
    private int mMarginTop;
    /* access modifiers changed from: private */
    public int mOriginalOrientation;
    private int mOuterTitlebarHeightPix;
    protected WebView.PictureListener mPictureListener;
    private boolean mPointerWithinSlopRegion;
    private View mSearchResultTitleBar;
    private int mSnapBgColor;
    private View mStatusBar;
    private int mStatusBarHeight;
    private float mTouchDownX;
    private float mTouchDownY;
    private float mTouchSlopSquare = 64.8025f;
    private VideoPlayerFactory mVideoFactory;
    private ViewDelegate mViewDelegate;
    /* access modifiers changed from: private */
    public BdSailorWebChromeClient mWebChromeClient;
    private BdSailorWebSettings mWebSettings;
    /* access modifiers changed from: private */
    public BdSailorWebViewClient mWebViewClient;
    /* access modifiers changed from: private */
    public ISailorWebViewExt mWebViewExt;
    private FrameLayout mWebViewLayer;
    private FrameLayout.LayoutParams mWebViewLayerLp;

    public BdSailorWebView(Context context) {
        super(context);
        this.mCurrentWebView = new WebView(context);
        init();
    }

    public BdSailorWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentWebView = new WebView(context, attributeSet);
        init();
    }

    public BdSailorWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mCurrentWebView = new WebView(context, attributeSet, i2);
        init();
    }

    /* access modifiers changed from: protected */
    public void checkInit() {
        if (!BdSailor.getInstance().isInit()) {
            throw new RuntimeException("Must Call BdSailor.init(Context aContext, String aWorkspace) first!");
        } else if (!BdSailorPlatform.getInstance().isWebkitInit()) {
            throw new RuntimeException("Must Call BdSailor.initWebkit(String aAppId, boolean aIsZeusIntegrate) first!");
        }
    }

    private void init() {
        checkInit();
        this.mWebSettings = new BdSailorWebSettings(this.mCurrentWebView.getSettings());
        this.mWebViewExt = new BdSailorWebViewExt();
        this.mWebViewLayer = new FrameLayout(this.mCurrentWebView.getContext());
        this.mWebViewLayerLp = new FrameLayout.LayoutParams(-1, -1);
        if (!c.a() || !BdZeusUtil.isWebkitLoaded()) {
            addView(this.mWebViewLayer, this.mWebViewLayerLp);
        }
        initWebView(this.mCurrentWebView);
        addWebView(this.mCurrentWebView);
        setFocusableInTouchMode(true);
        if (BdSailor.getInstance().getSailorClient() != null) {
            BdSailor.getInstance().getSailorClient().updateSearchUrlProtocol(getContext(), true);
        }
        this.mCurrentWebView.setWebViewPagerContainer(this);
        Log.i(LOG_TAG, "setNetworkAvailable1");
        if (sInitFirstWebView) {
            Log.i(GlobalConstants.LOG_PER_TAG, " timing = \n" + ZeusPerformanceTiming.getWebViewInitTiming());
            sInitFirstWebView = false;
        }
        float f2 = getContext().getResources().getDisplayMetrics().density;
        this.mTouchSlopSquare *= f2 * f2;
        ZeusPerformanceTiming.recordWebkitInitStatistics(1);
    }

    private void initWebView(WebView webView) {
        webView.setWebChromeClient(new BdWebChromeClientProxy(webView));
        webView.setWebViewClient(new BdWebViewClientProxy());
        webView.setPictureListener(new BdBasePictureListenerProxy());
        webView.setDownloadListener(new BdDownloadListenerBridge(webView));
        webView.setWebBackForwardListClient(new BdBackForwardClientBridge(webView));
        webView.setVideoPlayerFactory(this.mVideoFactory);
    }

    public View getEmbeddedTitlebar() {
        return this.mEmbeddedTitlebar;
    }

    public View getCurrentTitleBar() {
        return this.mCurrentTitleBar;
    }

    public void setCurrentTitleBar(boolean z) {
        View view2;
        View view3 = this.mSearchResultTitleBar;
        if (view3 != null && (view2 = this.mLandingPageTitleBar) != null) {
            if (z) {
                view2 = view3;
            }
            this.mCurrentTitleBar = view2;
            int i2 = 0;
            view3.setVisibility(z ? 0 : 8);
            View view4 = this.mLandingPageTitleBar;
            if (z) {
                i2 = 8;
            }
            view4.setVisibility(i2);
            this.mEmbeddedTitlebar = this.mCurrentTitleBar;
        }
    }

    public View getLandingPageTitleBar() {
        return this.mLandingPageTitleBar;
    }

    public View getSearchResultTitleBar() {
        return this.mSearchResultTitleBar;
    }

    public void onReinputErrorUrl() {
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (c.a((View) this)) {
            BdSailor.getInstance().setCurrentSailorWebView(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (BdSailor.getInstance().getCurSailorWebView() == this) {
            BdSailor.getInstance().setCurrentSailorWebView((BdSailorWebView) null);
        }
    }

    public boolean requestFocus(int i2, Rect rect) {
        return this.mCurrentWebView.requestFocus(i2, rect);
    }

    /* access modifiers changed from: protected */
    public void runWithThreadProtect(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.mCurrentWebView.post(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public FrameLayout getWebViewContainer() {
        return this.mWebViewLayer;
    }

    /* access modifiers changed from: protected */
    public ViewGroup getFunctionLayer() {
        if (this.mFunctionViewLayer == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            this.mFunctionViewLayer = frameLayout;
            addView(frameLayout);
        }
        return this.mFunctionViewLayer;
    }

    public void setSailorWebViewSize(int i2, int i3) {
        setViewSize(this.mWebViewLayer, i2, i3);
        setViewSize(this.mCurrentWebView, i2, i3);
        this.mCurrentWebView.setWebViewPagerSize(i2, i3);
    }

    private void setViewSize(View view2, int i2, int i3) {
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(i2, i3);
            } else {
                layoutParams.width = i2;
                layoutParams.height = i3;
            }
            view2.setLayoutParams(layoutParams);
        }
    }

    public void setDualTitleBars(View view2, View view3, int i2, int i3) {
        setDualTitleBars(view2, view3, i2, i3, true, true);
    }

    public void setDualTitleBars(View view2, View view3, int i2, int i3, boolean z, boolean z2) {
        this.mSearchResultTitleBar = view2;
        if (view2 != null) {
            view2.setContentDescription("searchbar");
        }
        this.mLandingPageTitleBar = view3;
        if (view3 != null) {
            view3.setContentDescription("landingbar");
        }
        View view4 = i3 == 0 ? this.mSearchResultTitleBar : this.mLandingPageTitleBar;
        this.mCurrentTitleBar = view4;
        setNewTitlebar(view4, i2, z, z2);
        setSearchBarTopMargin();
        bringStatusBarToFront();
        this.mCurrentWebView.addEmbeddedTitleBarFinished();
    }

    public void switchTitleBar(boolean z) {
        this.mCurrentWebView.switchTitleBar(z);
    }

    public void setNewTitlebar(View view2, int i2, boolean z, boolean z2) {
        Log.d("new-titlebar", "setNewTitlebar :" + view2 + " allow hide: " + z + " show: " + z2 + " height: " + i2);
        if (view2 == null) {
            View view3 = this.mEmbeddedTitlebar;
            if (view3 != null) {
                removeView(view3);
                if (!BdZeusUtil.isWebkitLoaded()) {
                    setWebViewLayerMargin(this.mMarginLeft, this.mMarginTop - this.mEmbeddedTitlebarHeightPix, this.mMarginRight, this.mMarginBottom);
                }
            }
            this.mEmbeddedTitlebar = null;
            this.mEmbeddedTitlebarHeightPix = 0;
            this.mCanHideTitlebar = false;
            this.mCanShowTitlebar = false;
            this.mLockEmbeddedTitlebar = false;
            setTopControlsHeight(0, false);
            return;
        }
        this.mEmbeddedTitlebar = view2;
        this.mCanHideTitlebar = z;
        this.mCanShowTitlebar = z2;
        this.mLockEmbeddedTitlebar = false;
        this.mEmbeddedTitlebarHeightPix = c.a(getContext(), (float) i2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.mEmbeddedTitlebar.setLayoutParams(layoutParams);
        if (BdZeusUtil.isWebkitLoaded()) {
            setTopControlsHeight(this.mEmbeddedTitlebarHeightPix, true);
            updateTopControlsState(this.mCanHideTitlebar, this.mCanShowTitlebar, false);
        } else {
            setWebViewLayerMargin(this.mMarginLeft, this.mMarginTop + this.mEmbeddedTitlebarHeightPix, this.mMarginRight, this.mMarginBottom);
        }
        View view4 = this.mEmbeddedTitlebar;
        if (view4 != null) {
            if (view4.getParent() != null) {
                ((ViewGroup) this.mEmbeddedTitlebar.getParent()).removeView(this.mEmbeddedTitlebar);
            }
            addView(this.mEmbeddedTitlebar);
            if (c.a()) {
                View view5 = this.mEmbeddedTitlebar;
                View view6 = this.mLandingPageTitleBar;
                if (view5 == view6) {
                    setCurrentTitleBar(false);
                } else if (view6 != null) {
                    if (view6.getParent() != null) {
                        ((ViewGroup) this.mLandingPageTitleBar.getParent()).removeView(this.mLandingPageTitleBar);
                    }
                    this.mLandingPageTitleBar.setLayoutParams(layoutParams);
                    this.mLandingPageTitleBar.setVisibility(8);
                    addView(this.mLandingPageTitleBar);
                }
                View view7 = this.mEmbeddedTitlebar;
                View view8 = this.mSearchResultTitleBar;
                if (view7 == view8) {
                    setCurrentTitleBar(true);
                } else if (view8 != null) {
                    if (view8.getParent() != null) {
                        ((ViewGroup) this.mSearchResultTitleBar.getParent()).removeView(this.mSearchResultTitleBar);
                    }
                    this.mSearchResultTitleBar.setLayoutParams(layoutParams);
                    this.mSearchResultTitleBar.setVisibility(8);
                    addView(this.mSearchResultTitleBar);
                }
            }
            this.mCurrentWebView.addEmbeddedTitleBarFinished();
        }
    }

    public void setNewTitlebar(View view2, int i2, boolean z) {
        setNewTitlebar(view2, i2, z, z);
    }

    public void setOuterTitlebarHeight(int i2) {
        if (BdZeusUtil.isWebkitLoaded() && !c.a()) {
            this.mOuterTitlebarHeightPix = i2;
            setWebViewLayerMarginInternal(this.mMarginLeft, this.mMarginTop + i2, this.mMarginRight, this.mMarginBottom);
        }
    }

    public int getOuterTitlebarHeight() {
        return this.mOuterTitlebarHeightPix;
    }

    public int getTitlebarHeight() {
        return this.mEmbeddedTitlebarHeightPix;
    }

    public boolean isTitlebarShowing() {
        View view2 = this.mEmbeddedTitlebar;
        if (view2 == null || view2.getTranslationY() != 0.0f) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isTitlebarCanHide() {
        return this.mCanHideTitlebar;
    }

    public boolean isTitlebarCanShow() {
        return this.mCanShowTitlebar;
    }

    public boolean isTitlebarLock() {
        return this.mLockEmbeddedTitlebar;
    }

    public boolean isAutoShowTitlebar() {
        return this.mCurrentWebView.isAutoShowTitlebar();
    }

    public void updateTopControlOffset(int i2) {
        this.mCurrentWebView.updateTopControlOffset(i2);
    }

    /* access modifiers changed from: private */
    public void setTopControlsHeight(int i2, boolean z) {
        this.mCurrentWebView.setTopControlsHeight(i2, z);
    }

    public void updateTopControlsState(boolean z, boolean z2, boolean z3) {
        if (this.mEmbeddedTitlebar != null) {
            Log.d("new-titlebar", "updateTopControlsState :".concat(String.valueOf(z)));
            this.mCurrentWebView.updateTopControlsState(z, z2, z3);
            if (z3) {
                return;
            }
            if (!c.a()) {
                WebChromeClient webChromeClient = this.mCurrentWebView.getWebChromeClient();
                if (!z) {
                    webChromeClient.onOffsetsForFullscreenChanged(0.0f, (float) this.mEmbeddedTitlebarHeightPix, 0.0f);
                } else if (!z2) {
                    webChromeClient.onOffsetsForFullscreenChanged((float) (-this.mEmbeddedTitlebarHeightPix), 0.0f, 0.0f);
                }
            } else if (!z) {
                setTopControlsHeight(this.mEmbeddedTitlebarHeightPix, true);
            } else if (!z2) {
                setTopControlsHeight(this.mEmbeddedTitlebarHeightPix, false);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setWebViewLayerMargin(int i2, int i3, int i4, int i5) {
        if ((i2 == this.mMarginLeft && i3 == this.mMarginTop && i4 == this.mMarginRight && i5 == this.mMarginBottom) ? false : true) {
            this.mMarginLeft = i2;
            this.mMarginTop = i3;
            this.mMarginRight = i4;
            this.mMarginBottom = i5;
            setWebViewLayerMarginInternal(i2, i3 + this.mOuterTitlebarHeightPix, i4, i5);
        }
    }

    private void setWebViewLayerMarginInternal(int i2, int i3, int i4, int i5) {
        this.mWebViewLayerLp.setMargins(i2, i3, i4, i5);
        this.mWebViewLayer.setLayoutParams(this.mWebViewLayerLp);
        onWebViewLayerMarginChanged(i2, i3, i4, i5);
        this.mWebViewLayer.invalidate();
        this.mCurrentWebView.setWebViewMargin(i2, i3, i4, i5);
    }

    /* access modifiers changed from: protected */
    public void resetWebViewLayerMargin() {
        setWebViewLayerMargin(0, 0, 0, 0);
    }

    /* access modifiers changed from: protected */
    public void onWebViewLayerMarginChanged(int i2, int i3, int i4, int i5) {
    }

    private void addWebView(WebView webView) {
        addWebView(webView, -1);
    }

    private void addWebView(WebView webView, int i2) {
        if (webView.getParent() == null) {
            ViewDelegate viewDelegate = new ViewDelegate(webView);
            this.mViewDelegate = viewDelegate;
            webView.setViewDelegate(viewDelegate);
            if (!c.a() || !BdZeusUtil.isWebkitLoaded()) {
                getWebViewContainer().addView(webView, i2, new FrameLayout.LayoutParams(-1, -1));
            }
        }
    }

    private void removeWebView(WebView webView) {
        try {
            if (!c.a() || !BdZeusUtil.isWebkitLoaded()) {
                getWebViewContainer().removeView(webView);
            } else {
                webView.getWebViewPager().removeView(webView);
            }
        } catch (Exception e2) {
        }
    }

    public int startPrerender(String str) {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            return webView.startPrerender(str);
        }
        return -1;
    }

    public static void cancelPreload(String str) {
    }

    public static int getSiteTypeInfo(String str) {
        return WebView.getSiteTypeInfo(str);
    }

    public void addWebMessageListener(WebMessageListener webMessageListener, String str, String[] strArr) {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            webView.addWebMessageListener(webMessageListener, str, strArr);
        }
    }

    public void addJavascriptInterface(Object obj, String str) {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            webView.addJavascriptInterface(obj, str);
        }
    }

    public void removeJavascriptInterface(String str) {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            webView.removeJavascriptInterface(str);
        }
    }

    public void reinjectJavascriptInterface() {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            webView.reinjectJavascriptInterface();
        }
    }

    public void addJavascriptInterfaceExt(IJsAbility iJsAbility, String str) {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            webView.addJavascriptInterfaceExt(iJsAbility, str);
        }
    }

    public void removeJavascriptInterfaceExt(String str) {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            webView.removeJavascriptInterfaceExt(str);
        }
    }

    public boolean overlayHorizontalScrollbar() {
        return this.mCurrentWebView.overlayHorizontalScrollbar();
    }

    public boolean overlayVerticalScrollbar() {
        return this.mCurrentWebView.overlayVerticalScrollbar();
    }

    public boolean canGoBack() {
        return this.mCurrentWebView.canGoBack();
    }

    public boolean canGoForward() {
        return this.mCurrentWebView.canGoForward();
    }

    public void goBack() {
        if (canGoBack()) {
            Log.d("bfanim", "BdSailorWebView.Back");
            doRealGoBack();
        }
    }

    /* access modifiers changed from: protected */
    public void doRealGoBack() {
        if (canGoBack()) {
            this.mCurrentWebView.goBack();
            if (this.mWebViewExt.getWebViewClientExt() != null) {
                this.mWebViewExt.getWebViewClientExt().onPageBackOrForwardExt(this, -1);
            }
        }
    }

    public void goForward() {
        if (canGoForward()) {
            doRealGoForward();
        }
    }

    /* access modifiers changed from: protected */
    public void doRealGoForward() {
        if (canGoForward()) {
            this.mCurrentWebView.goForward();
            if (this.mWebViewExt.getWebViewClientExt() != null) {
                this.mWebViewExt.getWebViewClientExt().onPageBackOrForwardExt(this, 1);
            }
        }
    }

    public boolean canGoBackOrForward(int i2) {
        return this.mCurrentWebView.canGoBackOrForward(i2);
    }

    public void goBackOrForward(int i2) {
        if (i2 != 0 && canGoBackOrForward(i2)) {
            this.mCurrentWebView.goBackOrForward(i2);
            if (this.mWebViewExt.getWebViewClientExt() != null) {
                this.mWebViewExt.getWebViewClientExt().onPageBackOrForwardExt(this, i2);
            }
        }
    }

    public boolean canZoomIn() {
        return this.mCurrentWebView.canZoomIn();
    }

    public boolean canZoomOut() {
        return this.mCurrentWebView.canZoomOut();
    }

    public Bitmap captureBitmap(int i2, int i3) {
        return this.mCurrentWebView.captureBitmap(i2, i3);
    }

    public void clearCache(boolean z) {
        this.mCurrentWebView.clearCache(z);
    }

    public void clearFormData() {
        this.mCurrentWebView.clearFormData();
    }

    public void clearHistory() {
        this.mCurrentWebView.clearHistory();
    }

    public void clearMatches() {
        this.mCurrentWebView.clearMatches();
    }

    public void clearSslPreferences() {
        this.mCurrentWebView.clearSslPreferences();
    }

    public void clearView() {
        this.mCurrentWebView.clearView();
    }

    public void computeScroll() {
        this.mCurrentWebView.computeScroll();
    }

    public void setPageTransformer(boolean z, PageTransformer pageTransformer) {
        this.mCurrentWebView.setPageTransformer(z, pageTransformer);
    }

    public void destroy() {
        setDownloadListener((ISailorDownloadListener) null);
        setEmbeddedTitleBar((View) null);
        this.mCurrentWebView.destroy();
    }

    public boolean isDestroyed() {
        return this.mCurrentWebView.isDestroyed();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.mCurrentWebView.dispatchKeyEvent(keyEvent);
    }

    public void documentHasImages(Message message) {
        this.mCurrentWebView.documentHasImages(message);
    }

    public int findAll(String str) {
        return this.mCurrentWebView.findAll(str);
    }

    public void findAllAsync(String str) {
        this.mCurrentWebView.findAllAsync(str);
    }

    public void findNext(boolean z) {
        this.mCurrentWebView.findNext(z);
    }

    public void flingScroll(int i2, int i3) {
        this.mCurrentWebView.flingScroll(i2, i3);
    }

    public void freeMemory() {
        this.mCurrentWebView.freeMemory();
    }

    public SslCertificate getCertificate() {
        return this.mCurrentWebView.getCertificate();
    }

    public int getContentHeight() {
        return this.mCurrentWebView.getContentHeight();
    }

    public int getContentWidth() {
        return this.mCurrentWebView.getContentWidth();
    }

    public Bitmap getFavicon() {
        return this.mCurrentWebView.getFavicon();
    }

    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        return this.mCurrentWebView.getHttpAuthUsernamePassword(str, str2);
    }

    public String getOriginalUrl() {
        return this.mCurrentWebView.getOriginalUrl();
    }

    public int getProgress() {
        return this.mCurrentWebView.getProgress();
    }

    public float getScale() {
        return this.mCurrentWebView.getScale();
    }

    public String getTitle() {
        return this.mCurrentWebView.getTitle();
    }

    public String getUrl() {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            return webView.getUrl();
        }
        return null;
    }

    public void invokeZoomPicker() {
        this.mCurrentWebView.invokeZoomPicker();
    }

    public void loadData(String str, String str2, String str3) {
        this.mCurrentWebView.loadData(str, str2, str3);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.mCurrentWebView.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public void loadUrl(String str) {
        if (str == null || !str.startsWith("javascript:")) {
            perfLog(this.mCurrentWebView, "sailor-loadUrl", "url = ".concat(String.valueOf(str)));
            perfLog("load", str);
            this.mCurrentWebView.loadUrl(str);
            return;
        }
        this.mCurrentWebView.loadUrl(str);
    }

    public void loadUrl(String str, Map<String, String> map) {
        if (str.startsWith("javascript:")) {
            this.mCurrentWebView.loadUrl(str);
            return;
        }
        perfLog(this.mCurrentWebView, "sailor-loadUrl", "url = ".concat(String.valueOf(str)));
        perfLog("load", str);
        this.mCurrentWebView.loadUrl(str, map);
    }

    public boolean pageDown(boolean z) {
        return this.mCurrentWebView.pageDown(z);
    }

    public boolean pageUp(boolean z) {
        return this.mCurrentWebView.pageUp(z);
    }

    public void loadImageInPage(String str) {
        this.mCurrentWebView.loadUrl(SHOW_IMAGE_PREFIX.concat(String.valueOf(str)));
    }

    public void pauseTimers() {
        this.mCurrentWebView.pauseTimers();
    }

    public void resumeTimers() {
        this.mCurrentWebView.resumeTimers();
    }

    public boolean performLongClick() {
        return this.mCurrentWebView.performLongClick();
    }

    public void postUrl(String str, byte[] bArr) {
        this.mCurrentWebView.postUrl(str, bArr);
    }

    public void reload() {
        this.mCurrentWebView.stopLoading();
        this.mCurrentWebView.reload();
        this.mIsPageLoading = false;
    }

    public boolean requestChildRectangleOnScreen(View view2, Rect rect, boolean z) {
        return this.mCurrentWebView.requestChildRectangleOnScreen(view2, rect, z);
    }

    public boolean isFocused() {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            return webView.isFocused();
        }
        return super.isFocused();
    }

    public void requestFocusNodeHref(Message message) {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            webView.requestFocusNodeHref(message);
        } else {
            Log.e("current webview is null.");
        }
    }

    public void requestImageRef(Message message) {
        this.mCurrentWebView.requestImageRef(message);
    }

    public void savePassword(String str, String str2, String str3) {
        this.mCurrentWebView.savePassword(str, str2, str3);
    }

    public void setBackgroundColor(int i2) {
        this.mSnapBgColor = i2;
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            webView.setBackgroundColor(i2);
        } else {
            super.setBackgroundColor(i2);
        }
    }

    public void setHorizontalScrollbarOverlay(boolean z) {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            webView.setHorizontalScrollbarOverlay(z);
        }
    }

    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        this.mCurrentWebView.setHttpAuthUsernamePassword(str, str2, str3, str4);
    }

    public void setInitialScale(int i2) {
        this.mCurrentWebView.setInitialScale(i2);
    }

    public void setMapTrackballToArrowKeys(boolean z) {
        this.mCurrentWebView.setMapTrackballToArrowKeys(z);
    }

    public void setNetworkAvailable(boolean z) {
        this.mCurrentWebView.setNetworkAvailable(z);
    }

    public void setOverScrollMode(int i2) {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            webView.setOverScrollMode(i2);
        } else {
            super.setOverScrollMode(i2);
        }
    }

    public void setScrollBarStyle(int i2) {
        this.mCurrentWebView.setScrollBarStyle(i2);
    }

    public void setVerticalScrollbarOverlay(boolean z) {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            webView.setVerticalScrollbarOverlay(z);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return this.mCurrentWebView.shouldDelayChildPressedState();
    }

    public void stopLoading() {
        if (!isDestroyed()) {
            this.mCurrentWebView.stopLoading();
            this.mIsPageLoading = false;
        }
    }

    public void suspendScheduledTasks(String str) {
        if (!isDestroyed()) {
            this.mCurrentWebView.suspendScheduledTasks(str);
        }
    }

    public boolean isPageLoading() {
        return this.mIsPageLoading;
    }

    public boolean zoomIn() {
        return this.mCurrentWebView.zoomIn();
    }

    public boolean zoomOut() {
        return this.mCurrentWebView.zoomOut();
    }

    public boolean showFindDialog(String str, boolean z) {
        return this.mCurrentWebView.showFindDialog(str, z);
    }

    public boolean isPrivateBrowsingEnabled() {
        return this.mCurrentWebView.isPrivateBrowsingEnabled();
    }

    public void setWebChromeClient(BdSailorWebChromeClient bdSailorWebChromeClient) {
        this.mWebChromeClient = bdSailorWebChromeClient;
    }

    public void setWebChromeClientExt(BdSailorWebChromeClientExt bdSailorWebChromeClientExt) {
        ISailorWebViewExt iSailorWebViewExt = this.mWebViewExt;
        if (iSailorWebViewExt != null) {
            iSailorWebViewExt.setWebChromeClientExt(bdSailorWebChromeClientExt);
        }
    }

    public void setWebViewClient(BdSailorWebViewClient bdSailorWebViewClient) {
        this.mWebViewClient = bdSailorWebViewClient;
    }

    public void setWebViewClientExt(BdSailorWebViewClientExt bdSailorWebViewClientExt) {
        ISailorWebViewExt iSailorWebViewExt = this.mWebViewExt;
        if (iSailorWebViewExt != null) {
            iSailorWebViewExt.setWebViewClientExt(bdSailorWebViewClientExt);
        }
    }

    public void setPictureListener(WebView.PictureListener pictureListener) {
        this.mPictureListener = pictureListener;
    }

    public void setDownloadListener(ISailorDownloadListener iSailorDownloadListener) {
        this.mDownloadListener = iSailorDownloadListener;
    }

    public ISailorDownloadListener getDownloadListener() {
        return this.mDownloadListener;
    }

    public void setVideoPlayerFactory(VideoPlayerFactory videoPlayerFactory) {
        this.mVideoFactory = videoPlayerFactory;
        this.mCurrentWebView.setVideoPlayerFactory(videoPlayerFactory);
    }

    public void setCertificate(SslCertificate sslCertificate) {
        this.mCurrentWebView.setCertificate(sslCertificate);
    }

    public void saveWebArchive(String str) {
        this.mCurrentWebView.saveWebArchive(str);
    }

    public void saveWebArchive(String str, boolean z, ValueCallback<String> valueCallback) {
        this.mCurrentWebView.saveWebArchive(str, z, valueCallback);
    }

    public void setFindListener(WebView.FindListener findListener) {
        this.mCurrentWebView.setFindListener(findListener);
    }

    public void emulateShiftHeld() {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            webView.emulateShiftHeld();
        }
    }

    public void setWebBackForwardListClient(WebBackForwardListClient webBackForwardListClient) {
        this.mCurrentWebView.setWebBackForwardListClient(webBackForwardListClient);
    }

    public Bitmap captureBitmap() {
        Bitmap bitmap;
        try {
            WebView currentWebView = getCurrentWebView();
            if (currentWebView != null && currentWebView.getMeasuredWidth() > 0) {
                if (currentWebView.getMeasuredHeight() > 0) {
                    if (!BdZeusUtil.isWebkitLoaded()) {
                        bitmap = Bitmap.createBitmap(currentWebView.getMeasuredWidth(), currentWebView.getMeasuredHeight(), Bitmap.Config.RGB_565);
                        Canvas canvas = new Canvas(bitmap);
                        int save = canvas.save();
                        this.mWebViewLayer.draw(canvas);
                        canvas.restoreToCount(save);
                    } else {
                        bitmap = getCurrentWebView().captureBitmap();
                    }
                    if (bitmap != null && bitmap.getWidth() > 0) {
                        if (bitmap.getHeight() > 0) {
                            if (getTitlebarHeight() != 0 && isTitlebarShowing()) {
                                return Bitmap.createBitmap(bitmap, 0, getTitlebarHeight(), bitmap.getWidth(), bitmap.getHeight() - getTitlebarHeight());
                            }
                            return bitmap;
                        }
                    }
                    return null;
                }
            }
            return null;
        } catch (Throwable th2) {
            return null;
        }
    }

    public Picture capturePicture() {
        return this.mCurrentWebView.capturePicture();
    }

    public void setLayerType(int i2, Paint paint) {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            webView.setLayerType(i2, paint);
        } else {
            super.setLayerType(i2, paint);
        }
    }

    public void setStatusBar(View view2, int i2) {
        if (!c.a()) {
            return;
        }
        if (view2 == null) {
            View view3 = this.mStatusBar;
            if (view3 != null) {
                removeView(view3);
            }
            this.mStatusBar = null;
            this.mStatusBarHeight = 0;
            setSearchBarTopMargin();
            this.mCurrentWebView.setStatusBar((View) null, 0);
            return;
        }
        this.mStatusBar = view2;
        this.mStatusBarHeight = i2;
        Log.i(LOG_TAG, "setStatusBar: mStatusBarHeight=" + this.mStatusBarHeight);
        if (this.mStatusBar.getParent() != null) {
            ((ViewGroup) this.mStatusBar.getParent()).removeView(this.mStatusBar);
        }
        addView(this.mStatusBar);
        setSearchBarTopMargin();
        bringStatusBarToFront();
        this.mCurrentWebView.setStatusBar(this.mStatusBar, this.mStatusBarHeight);
    }

    private void setSearchBarTopMargin() {
        if (c.a()) {
            setViewTopMargin(this.mSearchResultTitleBar, this.mStatusBarHeight);
            setViewTopMargin(this.mLandingPageTitleBar, this.mStatusBarHeight);
        }
    }

    private void bringStatusBarToFront() {
        View view2;
        if (c.a() && (view2 = this.mStatusBar) != null && indexOfChild(view2) >= 0) {
            bringChildToFront(this.mStatusBar);
        }
    }

    private void setViewTopMargin(View view2, int i2) {
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i2;
                view2.setLayoutParams(marginLayoutParams);
                Log.d(LOG_TAG, "setViewTopMargin: view=" + view2 + ", top=" + marginLayoutParams.topMargin);
            }
        }
    }

    public View getStatusBar() {
        return this.mStatusBar;
    }

    public int getStatusBarHeight() {
        return this.mStatusBarHeight;
    }

    public void setEmbeddedTitleBar(View view2, int i2) {
        if (!c.a()) {
            setNewTitlebar(view2, i2, true, true);
        } else if (view2 == null) {
            setNewTitlebar(view2, i2, true, true);
        } else {
            this.mSearchResultTitleBar = view2;
            this.mCurrentTitleBar = view2;
            this.mEmbeddedTitlebar = view2;
            this.mEmbeddedTitlebarHeightPix = c.a(getContext(), (float) i2);
        }
    }

    public void setEmbeddedTitleBar(View view2) {
        setEmbeddedTitleBar(view2, 0);
    }

    public void showEmbeddedTitleBar(boolean z) {
        if (this.mEmbeddedTitlebar != null && !this.mLockEmbeddedTitlebar) {
            this.mCanShowTitlebar = true;
            updateTopControlsState(false, false, z);
            updateTopControlsState(this.mCanHideTitlebar, this.mCanShowTitlebar, z);
        }
    }

    public void hideEmbeddedTitleBar(boolean z) {
        if (this.mEmbeddedTitlebar != null && !this.mLockEmbeddedTitlebar) {
            this.mCanHideTitlebar = true;
            updateTopControlsState(true, false, z);
            updateTopControlsState(this.mCanHideTitlebar, this.mCanShowTitlebar, z);
        }
    }

    public void updateEmbeddedTitleBar(boolean z, boolean z2, boolean z3) {
        if (this.mEmbeddedTitlebar != null) {
            this.mCanHideTitlebar = z;
            this.mCanShowTitlebar = z2;
            updateTopControlsState(z, z2, z3);
        }
    }

    public void lockEmbeddedTitlebar(boolean z) {
        this.mLockEmbeddedTitlebar = z;
    }

    public void setAutoShowTitlebar(boolean z) {
        this.mCurrentWebView.setAutoShowTitlebar(z);
    }

    public int computeVerticalScrollRange() {
        return this.mCurrentWebView.computeVerticalScrollRange();
    }

    public BdSailorWebSettings getSettings() {
        return this.mWebSettings;
    }

    public ISailorWebSettingsExt getSettingsExt() {
        return this.mWebViewExt.getSettingsExt();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (motionEvent.getAction()) {
            case 0:
                this.mTouchDownX = motionEvent.getX();
                this.mTouchDownY = motionEvent.getY();
                this.mIsFunctionLayerShowing = false;
                this.mHitFlingGesture = false;
                this.mPointerWithinSlopRegion = true;
                break;
            case 1:
                if (this.mHitFlingGesture && this.mPointerWithinSlopRegion && getSettingsExt().getTapInterceptFlingEnabled() && CloudSettingSDK.isTapInterceptFlingEnabled()) {
                    motionEvent.setAction(3);
                    this.mHitFlingGesture = false;
                    break;
                }
            case 2:
                float x = motionEvent.getX() - this.mTouchDownX;
                float y = motionEvent.getY() - this.mTouchDownY;
                if (this.mPointerWithinSlopRegion) {
                    this.mPointerWithinSlopRegion = (x * x) + (y * y) < this.mTouchSlopSquare;
                    break;
                }
                break;
            case 3:
                this.mHitFlingGesture = false;
                this.mPointerWithinSlopRegion = false;
                break;
        }
        if (!(!this.mIsFunctionLayerShowing && !this.mWebViewExt.isTextSelectingModeExt()) || !getSettings().isGestrueBackForwardEnabled()) {
            z = false;
        }
        if (z != getSettings().isGestrueBackForwardEnabledInternal()) {
            getSettings().setBackForwardGestureInternal(z);
        }
        return this.mCurrentWebView.onTouchEventSuper(motionEvent);
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (!hasCustomView()) {
            return super.onKeyDown(i2, keyEvent);
        }
        hideCustomView();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        this.mCurrentWebView.onScrollChangedSuper(i2, i3, i4, i5);
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i2, int i3, boolean z, boolean z2) {
        this.mCurrentWebView.onOverScrolledSuper(i2, i3, z, z2);
    }

    public void goNextOrPreTextField(boolean z) {
    }

    public ISailorWebViewExt getWebViewExt() {
        return this.mWebViewExt;
    }

    public int[] getWebScrollXY() {
        try {
            return new int[]{this.mCurrentWebView.getWebView().getScrollX(), this.mCurrentWebView.getWebView().getScrollY()};
        } catch (NullPointerException e2) {
            Log.printStackTrace(e2);
            return new int[]{0, 0};
        }
    }

    public WebView.HitTestResult getHitTestResult() {
        return this.mCurrentWebView.getHitTestResult();
    }

    public BdSailorWebBackForwardList copyBackForwardList() {
        WebBackForwardList copyBackForwardList;
        try {
            WebView webView = this.mCurrentWebView;
            if (webView == null || (copyBackForwardList = webView.copyBackForwardList()) == null) {
                return null;
            }
            return new BdSailorWebBackForwardList(copyBackForwardList);
        } catch (Throwable th2) {
            Log.printStackTrace(th2);
            return null;
        }
    }

    public BdSailorWebBackForwardList saveState(Bundle bundle) {
        WebBackForwardList saveState;
        if (bundle == null || (saveState = this.mCurrentWebView.saveState(bundle)) == null) {
            return null;
        }
        return new BdSailorWebBackForwardList(saveState);
    }

    public BdSailorWebBackForwardList restoreState(Bundle bundle) {
        WebBackForwardList restoreState;
        if (bundle == null || (restoreState = this.mCurrentWebView.restoreState(bundle)) == null) {
            return null;
        }
        return new BdSailorWebBackForwardList(restoreState);
    }

    public void onPause() {
        this.mCurrentWebView.onPause();
    }

    public void onResume() {
        this.mCurrentWebView.onResume();
    }

    public void pauseMedia() {
        this.mCurrentWebView.pauseMedia();
    }

    public void resumeMedia() {
        this.mCurrentWebView.resumeMedia();
    }

    public void disableMedia() {
        this.mCurrentWebView.disableMedia();
    }

    public void enableMedia() {
        this.mCurrentWebView.enableMedia();
    }

    public void getWebAppShortcutData(WebAppShortcutDataListener webAppShortcutDataListener) {
        Log.i("pwa", "bdsailorwebvew.getWebAppShortcutData");
        this.mCurrentWebView.getWebAppShortcutData(webAppShortcutDataListener);
    }

    public void getWebAppShortcutData(WebAppShortcutDataListener webAppShortcutDataListener, boolean z) {
        Log.i("pwa", "bdsailorwebvew.getWebAppShortcutData");
        this.mCurrentWebView.getWebAppShortcutData(webAppShortcutDataListener, z);
    }

    public BdSailorWebViewClient getWebViewClient() {
        return this.mWebViewClient;
    }

    public BdSailorWebChromeClient getWebChromeClient() {
        return this.mWebChromeClient;
    }

    public WebViewRenderProcess getWebViewRenderProcess() {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            return webView.getWebViewRenderProcess();
        }
        return null;
    }

    public void setWebViewRenderProcessClient(Executor executor, WebViewRenderProcessClient webViewRenderProcessClient) {
        if (this.mCurrentWebView != null) {
            if (webViewRenderProcessClient != null) {
                Log.i("multiProcess", "multiProcess setWebViewRenderProcessClient name = " + webViewRenderProcessClient.getClassName());
            }
            this.mCurrentWebView.setWebViewRenderProcessClient(executor, webViewRenderProcessClient);
        }
    }

    public WebViewRenderProcessClient getWebViewRenderProcessClient() {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            return webView.getWebViewRenderProcessClient();
        }
        return null;
    }

    public void enableFeature(String str) {
    }

    public void disableFeature(String str) {
    }

    public WebView getCurrentWebView() {
        return this.mCurrentWebView;
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            webView.evaluateJavascript(str, valueCallback);
        }
    }

    public ConcurrentHashMap<String, FirstScreenImageInfomation.FirstScreenImageItem> getCurrentFirstScreenImageMap() {
        return this.mImageMap;
    }

    public void addDocumentStartJavaScriptOnce(String str, String[] strArr) {
        addDocumentStartJavaScriptOnce(str, strArr, true);
    }

    public void addDocumentStartJavaScriptOnce(String str, String[] strArr, boolean z) {
        addDocumentStartJavaScript(str, strArr, z, true);
    }

    public WebScriptHandler addDocumentStartJavaScript(String str, String[] strArr) {
        return addDocumentStartJavaScript(str, strArr, true, false);
    }

    public WebScriptHandler addDocumentStartJavaScript(String str, String[] strArr, boolean z, boolean z2) {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            return webView.addDocumentStartJavaScript(str, strArr, z, z2);
        }
        return null;
    }

    public void createAOTCache(String str, String str2, String str3, int i2) {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            webView.createAOTCache(str, str2, str3, i2);
        }
    }

    public void evaluateJavascriptMethod(String str, String str2, String str3, ValueCallback<String> valueCallback) {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            webView.evaluateJavascriptMethod(str, str2, str3, valueCallback);
        }
    }

    public boolean isFeatureEnable(String str) {
        return false;
    }

    /* access modifiers changed from: private */
    public void perfLog(WebView webView, String str) {
        perfLog(webView, str, (String) null);
    }

    /* access modifiers changed from: private */
    public void perfLog(WebView webView, String str, String str2) {
    }

    /* access modifiers changed from: private */
    public void perfLog(String str, String str2) {
    }

    public void dumpInfo() {
    }

    public boolean hasCustomView() {
        return this.mCustomView != null;
    }

    public void showCustomView(Context context, View view2, WebChromeClient.CustomViewCallback customViewCallback) {
        Activity activity;
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity == null) {
            return;
        }
        if (this.mCustomView != null) {
            customViewCallback.onCustomViewHidden();
            return;
        }
        this.mOriginalOrientation = activity.getRequestedOrientation();
        if (activity.getWindow() != null) {
            FrameLayout frameLayout = (FrameLayout) activity.getWindow().getDecorView();
            FullscreenHolder fullscreenHolder = new FullscreenHolder(activity);
            this.mFullscreenContainer = fullscreenHolder;
            FrameLayout.LayoutParams layoutParams = COVER_SCREEN_PARAMS;
            fullscreenHolder.addView(view2, layoutParams);
            if (frameLayout != null) {
                frameLayout.addView(this.mFullscreenContainer, layoutParams);
            }
            this.mCustomView = view2;
            setFullscreen(activity, true);
            if (getCurrentWebView() != null) {
                getCurrentWebView().setVisibility(4);
            }
            this.mCustomViewCallback = customViewCallback;
            activity.setRequestedOrientation(2);
        }
    }

    public void hideCustomView() {
        if (this.mCustomView != null) {
            try {
                getCurrentWebView().getHandler().post(new Runnable() {
                    public void run() {
                        Activity activity;
                        FrameLayout frameLayout;
                        try {
                            Context context = BdSailorWebView.this.getContext();
                            if (context instanceof Activity) {
                                activity = (Activity) context;
                            } else {
                                activity = null;
                            }
                            if (activity != null) {
                                if (BdSailorWebView.this.getCurrentWebView() != null) {
                                    BdSailorWebView.this.getCurrentWebView().setVisibility(0);
                                }
                                BdSailorWebView.this.setFullscreen(activity, false);
                                Window window = activity.getWindow();
                                if (window != null && (frameLayout = (FrameLayout) window.getDecorView()) != null) {
                                    if (BdSailorWebView.this.mFullscreenContainer != null) {
                                        frameLayout.removeView(BdSailorWebView.this.mFullscreenContainer);
                                        FrameLayout unused = BdSailorWebView.this.mFullscreenContainer = null;
                                    }
                                    View unused2 = BdSailorWebView.this.mCustomView = null;
                                    if (BdSailorWebView.this.mCustomViewCallback != null) {
                                        BdSailorWebView.this.mCustomViewCallback.onCustomViewHidden();
                                    }
                                    activity.setRequestedOrientation(BdSailorWebView.this.mOriginalOrientation);
                                }
                            }
                        } catch (Exception e2) {
                            Log.e(BdSailorWebView.LOG_TAG, "Exception happened when hide custom view");
                            e2.printStackTrace();
                        }
                    }
                });
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setFullscreen(Activity activity, boolean z) {
        Window window;
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setFlags(!z ? 0 : 1024, 1024);
        }
    }

    public void notifyPageLeave(String str, WebView webView) {
        Log.i("huqin-multiwebview", "BdSailorWebView notifyPageLeave, webView = " + webView + ", url = " + str);
        SessionMonitorEngine.getInstance().notifyPageLeave(str, webView);
        this.mCurrentWebView.onPageSwapFromWebview(webView, str, false);
    }

    public void notifyPageActive(String str, WebView webView) {
        notifyPageActive(str, webView, false);
    }

    public void notifyPageActive(String str, WebView webView, boolean z) {
        Log.i("huqin-multiwebview", "BdSailorWebView notifyPageActive, webView = " + webView + ", url = " + str + ", isOpen = " + z);
        if (!z) {
            webView.setCurrentSourceIdByIdentifier();
        }
        SessionMonitorEngine.getInstance().notifyPageActive(str, webView, z);
        this.mCurrentWebView.onPageSwapFromWebview(webView, str, true);
    }

    public void setRendererPriorityPolicy(int i2, boolean z) {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            webView.setRendererPriorityPolicy(i2, z);
        }
    }

    public int getRendererRequestedPriority() {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            return webView.getRendererRequestedPriority();
        }
        return 0;
    }

    public boolean getRendererPriorityWaivedWhenNotVisible() {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            return webView.getRendererPriorityWaivedWhenNotVisible();
        }
        return false;
    }

    public Looper getWebViewLooper() {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            return webView.getWebViewLooper();
        }
        return Looper.myLooper();
    }

    public Handler getHandler() {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            return webView.getHandler();
        }
        return super.getHandler();
    }

    public View findFocus() {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            return webView.findFocus();
        }
        return super.findFocus();
    }

    public boolean onCheckIsTextEditor() {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            return webView.onCheckIsTextEditor();
        }
        return false;
    }

    static class FullscreenHolder extends FrameLayout {
        public FullscreenHolder(Context context) {
            super(context);
            setBackgroundColor(context.getResources().getColor(context.getResources().getIdentifier("sailor_common_black", "color", context.getPackageName())));
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    class BdWebChromeClientProxy extends WebChromeClient {
        private String[] mJsBeforeUnloadWhiteList = {"mail.163.com", "mail.126.com", "mail.yeah.net", "shouji.163.com"};

        public BdWebChromeClientProxy(WebView webView) {
        }

        public void onOffsetsForFullscreenChanged(float f2, float f3, float f4) {
            BdSailorWebView bdSailorWebView = BdSailorWebView.this;
            bdSailorWebView.setTopControlsHeight(bdSailorWebView.mEmbeddedTitlebarHeightPix, f3 > 0.0f);
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.onOffsetsForFullscreenChanged(BdSailorWebView.this, f2, f3, f4);
            } else {
                super.onOffsetsForFullscreenChanged(f2, f3, f4);
            }
        }

        public void onPrerenderChanged(int i2, WebView.PrerenderStatus prerenderStatus) {
            super.onPrerenderChanged(i2, prerenderStatus);
            if (BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().onPrerenderChanged(i2, prerenderStatus);
            }
        }

        public Bitmap getDefaultVideoPoster() {
            if (BdSailorWebView.this.mWebChromeClient != null) {
                return BdSailorWebView.this.mWebChromeClient.getDefaultVideoPoster(BdSailorWebView.this);
            }
            return super.getDefaultVideoPoster();
        }

        public View getVideoLoadingProgressView() {
            if (BdSailorWebView.this.mWebChromeClient != null) {
                return BdSailorWebView.this.mWebChromeClient.getVideoLoadingProgressView(BdSailorWebView.this);
            }
            return super.getVideoLoadingProgressView();
        }

        public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
            long currentTimeMillis = System.currentTimeMillis();
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.getVisitedHistory(BdSailorWebView.this, valueCallback);
            } else {
                super.getVisitedHistory(valueCallback);
            }
            SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(BdSailorWebView.this.getCurrentWebView(), BdSailorWebView.this.getUrl(), MonitorConstant.KeySectionType.GET_VISITED_HISTORY.ordinal(), System.currentTimeMillis() - currentTimeMillis);
        }

        public void onCloseWindow(WebView webView) {
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.onCloseWindow(BdSailorWebView.this);
            } else {
                super.onCloseWindow(webView);
            }
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            boolean onConsoleMessage = super.onConsoleMessage(consoleMessage);
            if (BdSailorWebView.this.mWebChromeClient == null || onConsoleMessage) {
                return onConsoleMessage;
            }
            return BdSailorWebView.this.mWebChromeClient.onConsoleMessage(BdSailorWebView.this, consoleMessage);
        }

        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            if (BdSailorWebView.this.mWebChromeClient != null) {
                return BdSailorWebView.this.mWebChromeClient.onCreateWindow(BdSailorWebView.this, z, z2, message);
            }
            return super.onCreateWindow(webView, z, z2, message);
        }

        public void onExceededDatabaseQuota(String str, String str2, long j2, long j3, long j4, WebStorage.QuotaUpdater quotaUpdater) {
            super.onExceededDatabaseQuota(str, str2, j2, j3, j4, quotaUpdater);
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.onExceededDatabaseQuota(BdSailorWebView.this, str, str2, j2, j3, j4, quotaUpdater);
            }
        }

        public void onGeolocationPermissionsHidePrompt() {
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.onGeolocationPermissionsHidePrompt(BdSailorWebView.this);
            } else {
                super.onGeolocationPermissionsHidePrompt();
            }
        }

        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.onGeolocationPermissionsShowPrompt(BdSailorWebView.this, str, callback);
            }
        }

        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            boolean z = BdSailorWebView.this.mWebChromeClient != null && BdSailorWebView.this.mWebChromeClient.onJsAlert(BdSailorWebView.this, str, str2, jsResult);
            if (!z) {
                return super.onJsAlert(webView, str, str2, jsResult);
            }
            return z;
        }

        public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
            if (!TextUtils.isEmpty(str)) {
                String host = Uri.parse(str).getHost();
                if (!TextUtils.isEmpty(host)) {
                    for (String contains : this.mJsBeforeUnloadWhiteList) {
                        if (host.contains(contains)) {
                            jsResult.confirm();
                            return true;
                        }
                    }
                }
            }
            if (super.onJsBeforeUnload(webView, str, str2, jsResult)) {
                return true;
            }
            return BdSailorWebView.this.mWebChromeClient != null && BdSailorWebView.this.mWebChromeClient.onJsBeforeUnload(BdSailorWebView.this, str, str2, jsResult);
        }

        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            if (BdSailorWebView.this.mWebChromeClient != null) {
                return BdSailorWebView.this.mWebChromeClient.onJsConfirm(BdSailorWebView.this, str, str2, jsResult);
            }
            return super.onJsConfirm(webView, str, str2, jsResult);
        }

        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if (super.onJsPrompt(webView, str, str2, str3, jsPromptResult)) {
                return true;
            }
            if (BdSailorWebView.this.mWebChromeClient != null) {
                return BdSailorWebView.this.mWebChromeClient.onJsPrompt(BdSailorWebView.this, str, str2, str3, jsPromptResult);
            }
            return false;
        }

        public boolean onJsTimeout() {
            if (super.onJsTimeout()) {
                return true;
            }
            if (BdSailorWebView.this.mWebChromeClient == null || !BdSailorWebView.this.mWebChromeClient.onJsTimeout(BdSailorWebView.this)) {
                return false;
            }
            return true;
        }

        public void onProgressChanged(WebView webView, int i2) {
            long currentTimeMillis = System.currentTimeMillis();
            super.onProgressChanged(webView, i2);
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.onProgressChanged(BdSailorWebView.this, i2);
            }
            if (webView == BdSailorWebView.this.mCurrentWebView && i2 == 100) {
                boolean unused = BdSailorWebView.this.mIsPageLoading = false;
            }
            SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, webView.getUrl(), MonitorConstant.KeySectionType.PROGRESSCHANGED.ordinal(), System.currentTimeMillis() - currentTimeMillis);
        }

        public void onReachedMaxAppCacheSize(long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
            super.onReachedMaxAppCacheSize(j2, j3, quotaUpdater);
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.onReachedMaxAppCacheSize(BdSailorWebView.this, j2, j3, quotaUpdater);
            }
        }

        public void onReceivedIcon(WebView webView, Bitmap bitmap) {
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.onReceivedIcon(BdSailorWebView.this, bitmap);
            } else {
                super.onReceivedIcon(webView, bitmap);
            }
        }

        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.onReceivedTitle(BdSailorWebView.this, str);
            }
        }

        public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.onReceivedTouchIconUrl(BdSailorWebView.this, str, z);
            } else {
                super.onReceivedTouchIconUrl(webView, str, z);
            }
        }

        public void onRequestFocus(WebView webView) {
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.onRequestFocus(BdSailorWebView.this);
            } else {
                super.onRequestFocus(webView);
            }
        }

        public void onShowCustomView(View view2, WebChromeClient.CustomViewCallback customViewCallback) {
            boolean z;
            if (BdSailorWebView.this.mWebChromeClient != null) {
                z = BdSailorWebView.this.mWebChromeClient.onShowCustomView(BdSailorWebView.this, view2, customViewCallback);
            } else {
                z = false;
            }
            if (!z) {
                BdSailorWebView bdSailorWebView = BdSailorWebView.this;
                bdSailorWebView.showCustomView(bdSailorWebView.getContext(), view2, customViewCallback);
            }
        }

        public void onShowCustomView(View view2, int i2, WebChromeClient.CustomViewCallback customViewCallback) {
            boolean z;
            if (BdSailorWebView.this.mWebChromeClient != null) {
                z = BdSailorWebView.this.mWebChromeClient.onShowCustomView(BdSailorWebView.this, view2, i2, customViewCallback);
            } else {
                z = false;
            }
            if (!z) {
                BdSailorWebView bdSailorWebView = BdSailorWebView.this;
                bdSailorWebView.showCustomView(bdSailorWebView.getContext(), view2, customViewCallback);
            }
        }

        public void onHideCustomView() {
            boolean z;
            if (BdSailorWebView.this.mWebChromeClient != null) {
                z = BdSailorWebView.this.mWebChromeClient.onHideCustomView(BdSailorWebView.this);
            } else {
                z = false;
            }
            if (!z) {
                BdSailorWebView.this.hideCustomView();
            }
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback) {
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.openFileChooser(BdSailorWebView.this, valueCallback);
            } else {
                super.openFileChooser(valueCallback);
            }
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.openFileChooser(BdSailorWebView.this, valueCallback, str);
            } else {
                super.openFileChooser(valueCallback, str);
            }
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.openFileChooser(BdSailorWebView.this, valueCallback, str, str2);
            } else {
                super.openFileChooser(valueCallback, str, str2);
            }
        }

        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            if (BdSailorWebView.this.mWebChromeClient != null) {
                return BdSailorWebView.this.mWebChromeClient.onShowFileChooser(BdSailorWebView.this, valueCallback, fileChooserParams);
            }
            return super.onShowFileChooser(webView, valueCallback, fileChooserParams);
        }

        public void onSetLoadURL(WebView webView, String str) {
            super.onSetLoadURL(webView, str);
            if (BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().onSetLoadURLExt(BdSailorWebView.this, str);
            }
        }

        public void performLongClick(WebView webView, int i2, String str, String str2, int i3, int i4) {
            super.performLongClick(webView, i2, str, str2, i3, i4);
            if (BdZeusUtil.isWebkitLoaded() || Build.VERSION.SDK_INT >= 19) {
                if (!(BdSailorWebView.this.mWebViewExt == null || BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() == null)) {
                    boolean unused = BdSailorWebView.this.mIsFunctionLayerShowing = true;
                    BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().performLongClickExt(BdSailorWebView.this, i2, str, str2, i3, i4);
                }
                if (i2 == 5 || i2 == 8) {
                    BdSailorWebView.this.getWebViewExt().updatePictureUrlListExt();
                }
            }
        }

        public void performLongClick(WebView webView, WebView.HitTestResult hitTestResult, int i2, int i3) {
            super.performLongClick(webView, hitTestResult, i2, i3);
            if (BdZeusUtil.isWebkitLoaded() || Build.VERSION.SDK_INT >= 19) {
                if (!(BdSailorWebView.this.mWebViewExt == null || BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() == null)) {
                    boolean unused = BdSailorWebView.this.mIsFunctionLayerShowing = true;
                    BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().performLongClickExt(BdSailorWebView.this, hitTestResult, i2, i3);
                }
                if (hitTestResult.getType() == 5 || hitTestResult.getType() == 8) {
                    BdSailorWebView.this.getWebViewExt().updatePictureUrlListExt();
                }
            }
        }

        public void showMagnifier(WebView webView, int i2, int i3, int i4, int i5) {
            boolean unused = BdSailorWebView.this.mIsFunctionLayerShowing = true;
            if (BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().showMagnifierExt(BdSailorWebView.this, i2, i3, i4, i5);
            } else {
                super.showMagnifier(webView, i2, i3, i4, i5);
            }
        }

        public void moveMagnifier(WebView webView, int i2, int i3, int i4, int i5) {
            if (BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().moveMagnifierExt(BdSailorWebView.this, i2, i3, i4, i5);
            } else {
                super.moveMagnifier(webView, i2, i3, i4, i5);
            }
        }

        public void hideMagnifier(WebView webView, int i2, int i3) {
            if (BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().hideMagnifierExt(BdSailorWebView.this, i2, i3);
            } else {
                super.hideMagnifier(webView, i2, i3);
            }
            boolean unused = BdSailorWebView.this.mIsFunctionLayerShowing = false;
        }

        public void copyText(WebView webView, String str) {
            if (BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().copyTextExt(BdSailorWebView.this, str);
            } else {
                super.copyText(webView, str);
            }
        }

        public void hideSelectionActionDialog(WebView webView) {
            if (BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().hideSelectionActionDialogExt(BdSailorWebView.this);
            } else {
                super.hideSelectionActionDialog(webView);
            }
            boolean unused = BdSailorWebView.this.mIsFunctionLayerShowing = false;
        }

        public void showSelectionActionDialog(WebView webView, int i2, int i3, int i4, int i5, String str) {
            boolean unused = BdSailorWebView.this.mIsFunctionLayerShowing = true;
            if (BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().showSelectionActionDialogExt(BdSailorWebView.this, i2, i3, i4, i5, str);
            } else {
                super.showSelectionActionDialog(webView, i2, i3, i4, i5, str);
            }
        }

        public void hidePastePopup(WebView webView) {
            if (BdSailorWebView.this.mWebViewExt == null || BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() == null) {
                super.hidePastePopup(webView);
            } else {
                BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().hidePastePopupExt(BdSailorWebView.this);
            }
        }

        public boolean showPastePopup(WebView webView, Rect rect, String str, boolean z) {
            if (BdSailorWebView.this.mWebViewExt == null || BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() == null) {
                return super.showPastePopup(webView, rect, str, z);
            }
            return BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().showPastePopupExt(BdSailorWebView.this, rect, str, z);
        }

        public void destroyPastePopup(WebView webView) {
            if (BdSailorWebView.this.mWebViewExt == null || BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() == null) {
                super.destroyPastePopup(webView);
            } else {
                BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().destroyPastePopupExt(BdSailorWebView.this);
            }
        }

        public boolean isPastePopupShowing(WebView webView) {
            if (BdSailorWebView.this.mWebViewExt == null || BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() == null) {
                return super.isPastePopupShowing(webView);
            }
            return BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().isPastePopupShowingExt(BdSailorWebView.this);
        }

        public boolean needNotifyNativeExitFullScreen() {
            if (BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() != null) {
                return BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().needNotifyNativeExitFullScreenExt(BdSailorWebView.this);
            }
            return super.needNotifyNativeExitFullScreen();
        }

        public void notifyClickWhenLoad() {
            if (BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().notifyClickWhenLoadExt(BdSailorWebView.this);
            } else {
                super.notifyClickWhenLoad();
            }
        }

        public void notifyClientStatus(WebView webView, int i2) {
            if (BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().notifyClientStatusExt(BdSailorWebView.this, i2);
            } else {
                super.notifyClientStatus(webView, i2);
            }
        }

        public void onNativeElementEnterFullScreen() {
            if (BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().onNativeElementEnterFullScreenExt(BdSailorWebView.this);
            } else {
                super.onNativeElementEnterFullScreen();
            }
        }

        public void onNativeElementExitFullScreen() {
            if (BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().onNativeElementExitFullScreenExt(BdSailorWebView.this);
            } else {
                super.onNativeElementExitFullScreen();
            }
        }

        public void doTextSearch(WebView webView, String str) {
            super.doTextSearch(webView, str);
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.doTextSearchExt(BdSailorWebView.this, str);
            }
        }

        public void doTextTranslate(WebView webView, String str) {
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.doTextTranslateExt(BdSailorWebView.this, str);
            } else {
                super.doTextTranslate(webView, str);
            }
        }

        public void onPermissionRequest(PermissionRequest permissionRequest) {
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.onPermissionRequest(BdSailorWebView.this, permissionRequest);
            } else {
                super.onPermissionRequest(permissionRequest);
            }
        }

        public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.onPermissionRequestCanceled(BdSailorWebView.this, permissionRequest);
            } else {
                super.onPermissionRequestCanceled(permissionRequest);
            }
        }
    }

    class BdWebViewClientProxy extends WebViewClient {
        private String[] mTelProtocolsList;

        private BdWebViewClientProxy() {
            this.mTelProtocolsList = new String[]{"wtai://", "tel:", "sms:", "mailto", "smsto:"};
        }

        public void onResourceLoaded(WebView webView, String str, long j2, String str2, String str3, int i2) {
        }

        public void onAbortResourceRequest(WebView webView, String str, String str2, long j2) {
            if ((webView instanceof WebView) && !BdSailorWebView.this.isDestroyed() && BdSailorWebView.this.mWebViewExt != null && BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onAbortResourceRequest(BdSailorWebView.this, str, str2, j2);
            }
        }

        public boolean onSubFrameBeforeRequest(WebView webView, String str) {
            if (!(webView instanceof WebView) || BdSailorWebView.this.isDestroyed() || BdSailorWebView.this.mWebViewExt == null || BdSailorWebView.this.mWebViewExt.getWebViewClientExt() == null) {
                return false;
            }
            return BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onSubFrameBeforeRequest(BdSailorWebView.this, str);
        }

        public void onNewHistoryItem(WebView webView, String str, int i2) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!(BdSailorWebView.this.mWebViewExt == null || BdSailorWebView.this.mWebViewExt.getWebViewClientExt() == null)) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onNewPage(BdSailorWebView.this);
            }
            SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, str, MonitorConstant.KeySectionType.NEW_HISTORY_ITEM.ordinal(), System.currentTimeMillis() - currentTimeMillis);
        }

        public void onPageFinished(WebView webView, String str) {
            BdSailorWebView.this.perfLog(webView, "onPageFinished");
            long currentTimeMillis = System.currentTimeMillis();
            super.onPageFinished(webView, str);
            if (BdSailorWebView.this.mWebViewClient != null) {
                BdSailorWebView.this.mWebViewClient.onPageFinished(BdSailorWebView.this, str);
            }
            if (webView == BdSailorWebView.this.mCurrentWebView) {
                boolean unused = BdSailorWebView.this.mIsPageLoading = false;
            }
            SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, str, MonitorConstant.KeySectionType.PAGEFINISH.ordinal(), System.currentTimeMillis() - currentTimeMillis);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            BdSailorWebView.this.perfLog(webView, "onPageStarted");
            long currentTimeMillis = System.currentTimeMillis();
            super.onPageStarted(webView, str, bitmap);
            if (BdSailorWebView.this.mWebViewClient != null) {
                BdSailorWebView.this.mWebViewClient.onPageStarted(BdSailorWebView.this, str, bitmap);
            }
            if (BdSailorWebView.this.mImageMap == null) {
                ConcurrentHashMap unused = BdSailorWebView.this.mImageMap = new ConcurrentHashMap();
            } else {
                BdSailorWebView.this.mImageMap.clear();
            }
            SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, str, MonitorConstant.KeySectionType.PAGESTART.ordinal(), System.currentTimeMillis() - currentTimeMillis);
        }

        public void onSearchLandingPageClicked(WebView webView, String str, String str2, long j2) {
            super.onSearchLandingPageClicked(webView, str, str2, j2);
            if (BdSailorWebView.this.mWebViewExt != null && BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onSearchLandingPageClicked(BdSailorWebView.this, str, str2, j2);
            }
        }

        public String onProcessWebSearchUrl(WebView webView, String str) {
            if (BdSailorWebView.this.mWebViewExt == null || BdSailorWebView.this.mWebViewExt.getWebViewClientExt() == null) {
                return super.onProcessWebSearchUrl(webView, str);
            }
            return BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onProcessWebSearchUrl(BdSailorWebView.this, str);
        }

        public void onPageCommitVisible(WebView webView, String str, boolean z) {
            long currentTimeMillis = System.currentTimeMillis();
            super.onPageCommitVisible(webView, str, z);
            if (BdSailorWebView.this.mWebViewClient != null) {
                BdSailorWebView.this.mWebViewClient.onPageCommitVisible(BdSailorWebView.this, str);
            }
            SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, str, MonitorConstant.KeySectionType.PAGE_COMMIT_VISIBLE.ordinal(), System.currentTimeMillis() - currentTimeMillis);
        }

        public void onMainResourceResponseDid(WebView webView, String str) {
            super.onMainResourceResponseDid(webView, str);
        }

        public void onMainResourceHttpcodeDid(WebView webView, int i2, String str) {
            super.onMainResourceHttpcodeDid(webView, i2, str);
        }

        public void onMagicFilterHideElement(WebView webView, String str, int i2, int i3, int i4, int i5, int i6) {
            super.onMagicFilterHideElement(webView, str, i2, i3, i4, i5, i6);
        }

        public void doUpdateVisitedHistory(WebView webView, String str, boolean z, boolean z2, boolean z3, boolean z4) {
            long currentTimeMillis = System.currentTimeMillis();
            super.doUpdateVisitedHistory(webView, str, z, z2, z3, z4);
            if (BdSailorWebView.this.mWebViewClient != null) {
                String str2 = str;
                BdSailorWebView.this.mWebViewClient.doUpdateVisitedHistory(BdSailorWebView.this, str, z);
            } else {
                String str3 = str;
                boolean z5 = z;
            }
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().doUpdateVisitedHistory(BdSailorWebView.this, str, z, z2, z3, z4);
            }
            SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, str, MonitorConstant.KeySectionType.DO_UPDATE_VISITED_HISTORY.ordinal(), System.currentTimeMillis() - currentTimeMillis);
        }

        public void onFormResubmission(WebView webView, Message message, Message message2) {
            if (BdSailorWebView.this.mWebViewClient != null) {
                BdSailorWebView.this.mWebViewClient.onFormResubmission(BdSailorWebView.this, message, message2);
            } else {
                super.onFormResubmission(webView, message, message2);
            }
        }

        public void onLoadResource(WebView webView, String str) {
            if (BdSailorWebView.this.mWebViewClient != null) {
                BdSailorWebView.this.mWebViewClient.onLoadResource(BdSailorWebView.this, str);
            } else {
                super.onLoadResource(webView, str);
            }
        }

        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            if (BdSailorWebView.this.mWebViewClient != null) {
                BdSailorWebView.this.mWebViewClient.onReceivedError(BdSailorWebView.this, i2, str, str2);
            }
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            long currentTimeMillis = System.currentTimeMillis();
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (BdSailorWebView.this.mWebViewClient != null) {
                if (webResourceRequest.isForMainFrame() && (webResourceRequest.getUrl().toString().startsWith("http://") || webResourceRequest.getUrl().toString().startsWith("https://"))) {
                    BdSailorWebView.this.mWebViewClient.onReceivedError(BdSailorWebView.this, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
                }
                BdSailorWebView.this.mWebViewClient.onReceivedError(BdSailorWebView.this, webResourceRequest, webResourceError);
            }
            SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, webView.getUrl(), MonitorConstant.KeySectionType.RECEIVED_ERROR.ordinal(), System.currentTimeMillis() - currentTimeMillis);
        }

        public String onGetErrorContent(WebView webView, int i2, String str, String str2) {
            String str3;
            if (!(webView instanceof WebView) || BdSailorWebView.this.isDestroyed() || BdSailorWebView.this.mWebViewExt == null || BdSailorWebView.this.mWebViewExt.getWebViewClientExt() == null) {
                str3 = null;
            } else {
                str3 = BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onGetErrorHtmlExt(BdSailorWebView.this, i2, str, str2);
            }
            if (str3 != null) {
                return str3;
            }
            return BdSailorPlatform.getDefaultErrorPageHtml(webView.getContext());
        }

        public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            if (BdSailorWebView.this.mWebViewClient != null) {
                BdSailorWebView.this.mWebViewClient.onReceivedHttpAuthRequest(BdSailorWebView.this, httpAuthHandler, str, str2);
            } else {
                super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            }
        }

        public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
            if (BdSailorWebView.this.mWebViewClient != null) {
                BdSailorWebView.this.mWebViewClient.onReceivedLoginRequest(BdSailorWebView.this, str, str2, str3);
            } else {
                super.onReceivedLoginRequest(webView, str, str2, str3);
            }
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            a featureByName = BdSailorPlatform.getInstance().getFeatureByName(BdSailorConfig.SAILOR_BASE_SSL);
            if (featureByName != null && featureByName.isEnable()) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            } else if (BdSailorWebView.this.mWebViewClient != null) {
                BdSailorWebView.this.mWebViewClient.onReceivedSslError(BdSailorWebView.this, sslErrorHandler, sslError);
            }
        }

        public void onScaleChanged(WebView webView, float f2, float f3) {
            if (BdSailorWebView.this.mWebViewClient != null) {
                BdSailorWebView.this.mWebViewClient.onScaleChanged(BdSailorWebView.this, f2, f3);
            } else {
                super.onScaleChanged(webView, f2, f3);
            }
        }

        public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
            if (BdSailorWebView.this.mWebViewClient != null) {
                BdSailorWebView.this.mWebViewClient.onUnhandledKeyEvent(BdSailorWebView.this, keyEvent);
            } else {
                super.onUnhandledKeyEvent(webView, keyEvent);
            }
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            WebResourceResponse shouldInterceptRequest = super.shouldInterceptRequest(webView, str);
            if (shouldInterceptRequest == null && BdSailorWebView.this.mWebViewClient != null) {
                return BdSailorWebView.this.mWebViewClient.shouldInterceptRequest(BdSailorWebView.this, str);
            }
            return shouldInterceptRequest;
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            WebResourceResponse webResourceResponse;
            long currentTimeMillis = System.currentTimeMillis();
            if (BdSailorWebView.this.mWebViewClient != null) {
                webResourceResponse = BdSailorWebView.this.mWebViewClient.shouldInterceptRequest(BdSailorWebView.this, webResourceRequest);
            } else {
                webResourceResponse = null;
            }
            if (webResourceResponse == null) {
                webResourceResponse = shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
            }
            SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, webResourceRequest.getUrl().toString(), MonitorConstant.KeySectionType.SHOULD_INTERCEPT_REQUEST.ordinal(), System.currentTimeMillis() - currentTimeMillis);
            return webResourceResponse;
        }

        public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
            if (BdSailorWebView.this.mWebViewClient != null) {
                return BdSailorWebView.this.mWebViewClient.shouldOverrideKeyEvent(BdSailorWebView.this, keyEvent);
            }
            return super.shouldOverrideKeyEvent(webView, keyEvent);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            boolean z;
            if (BdSailorWebView.this.mWebViewClient != null) {
                z = BdSailorWebView.this.mWebViewClient.shouldOverrideUrlLoading(BdSailorWebView.this, str);
            } else {
                z = false;
            }
            if (!z) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            return z;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            boolean z;
            BdSailorWebView.this.perfLog(webView, "shouldOverrideUrlLoading");
            long currentTimeMillis = System.currentTimeMillis();
            String uri = webResourceRequest.getUrl().toString();
            webView.getSecureProcessor().a(uri);
            int i2 = 0;
            if (BdSailorWebView.this.mWebViewClient != null) {
                z = BdSailorWebView.this.mWebViewClient.shouldOverrideUrlLoading(BdSailorWebView.this, webResourceRequest);
            } else {
                z = false;
            }
            if (!z) {
                z = super.shouldOverrideUrlLoading(webView, webResourceRequest);
            }
            if (!z) {
                z = shouldOverrideUrlLoading(webView, uri);
            }
            if (z && !TextUtils.isEmpty(uri)) {
                String[] strArr = this.mTelProtocolsList;
                int length = strArr.length;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (uri.startsWith(strArr[i2])) {
                        Log.d("// BdSailorMonitorEngine", "BdWebViewClientProxy.shouldoverridetel handled by external-->onTelRequest ,url=".concat(String.valueOf(uri)));
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, uri, MonitorConstant.KeySectionType.SHOULD_OVERRIDE_URL_LOADING.ordinal(), System.currentTimeMillis() - currentTimeMillis);
            return z;
        }

        public boolean shouldOverrideSpecialUrlLoading(WebView webView, String str) {
            boolean z;
            long currentTimeMillis = System.currentTimeMillis();
            if (BdSailorWebView.this.mWebViewClient != null) {
                z = BdSailorWebView.this.mWebViewClient.shouldOverrideUrlLoading(BdSailorWebView.this, str);
            } else {
                z = false;
            }
            SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, str, MonitorConstant.KeySectionType.SHOULD_SPECIAL_LOADING.ordinal(), System.currentTimeMillis() - currentTimeMillis);
            return z;
        }

        public void shouldPageRollBack(WebView webView, String str) {
        }

        public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
            if (BdSailorWebView.this.mWebViewClient != null) {
                BdSailorWebView.this.mWebViewClient.onReceivedClientCertRequest(BdSailorWebView.this, clientCertRequest);
            } else {
                super.onReceivedClientCertRequest(webView, clientCertRequest);
            }
        }

        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            if (BdSailorWebView.this.mWebViewClient != null) {
                BdSailorWebView.this.mWebViewClient.onReceivedHttpError(BdSailorWebView.this, webResourceRequest, webResourceResponse);
            } else {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }
        }

        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            boolean z;
            if (BdSailorWebView.this.mWebViewClient != null) {
                z = BdSailorWebView.this.mWebViewClient.onRenderProcessGone(BdSailorWebView.this, renderProcessGoneDetail);
            } else {
                z = super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            int renderRecoveryValue = ABTestSDK.getRenderRecoveryValue();
            boolean didCrash = renderProcessGoneDetail.didCrash();
            if (!z && ((4 == renderRecoveryValue && !didCrash) || (5 == renderRecoveryValue && didCrash))) {
                String url = webView.getUrl();
                if (url != null && (url.startsWith("http://") || url.startsWith("https://") || url.startsWith("zeus://"))) {
                    Log.i("multiProcess", "multiProcess SailorWebview onRenderProcessGone reload url = ".concat(String.valueOf(url)));
                    webView.reload();
                } else if (webView.isAttachedToWindow()) {
                    Log.i("multiProcess", "multiProcess SailorWebview onRenderProcessGone file url need user reopen ".concat(String.valueOf(url)));
                    Toast.makeText(webView.getContext(), "页面异常，请退出页面，重新打开", 1).show();
                }
                return true;
            } else if (1 == renderRecoveryValue && didCrash) {
                return false;
            } else {
                if (2 == renderRecoveryValue && !didCrash) {
                    return false;
                }
                if (z || renderRecoveryValue <= 0) {
                    return z;
                }
                try {
                    Log.i("multiProcess", "multiProcess SailorWebview onRenderProcessGone no handle !!! url =  " + webView.getUrl());
                    String url2 = webView.getUrl();
                    String str = "";
                    if (webView.getContext() != null) {
                        str = webView.getContext().toString();
                    }
                    Activity a2 = c.a(BdSailorWebView.this);
                    if (a2 != null) {
                        str = a2.toString();
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("url", url2);
                    jSONObject.put("context", str);
                    SessionMonitorEngine.getInstance().onRenderProcessEvent(6, 0, jSONObject);
                } catch (Exception e2) {
                }
                return true;
            }
        }

        public Map<String, String> shouldInterceptRequestHeaders(WebView webView, WebResourceRequest webResourceRequest) {
            Log.i("intercept-request-headers", "BdSailorWebView shouldInterceptRequestHeaders url= " + webResourceRequest.getUrl());
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                return BdSailorWebView.this.mWebViewExt.getWebViewClientExt().shouldInterceptRequestHeaders(BdSailorWebView.this, webResourceRequest);
            }
            return super.shouldInterceptRequestHeaders(webView, webResourceRequest);
        }

        public void onFullScreenMode(WebView webView, boolean z, int i2, int i3) {
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onFullScreenModeExt(BdSailorWebView.this, z, i2, i3);
            } else {
                super.onFullScreenMode(webView, z, i2, i3);
            }
        }

        public void onPlayPlugin() {
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onPlayPluginExt(BdSailorWebView.this);
            } else {
                super.onPlayPlugin();
            }
        }

        public void onPausePlugin() {
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onPausePluginExt(BdSailorWebView.this);
            } else {
                super.onPausePlugin();
            }
        }

        public void onHasVideo(WebView webView) {
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onHasVideoExt(BdSailorWebView.this);
            } else {
                super.onHasVideo(webView);
            }
        }

        public void onSubjectsCollected(WebView webView, boolean z, int i2) {
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onSubjectsCollectedExt(BdSailorWebView.this, z, i2);
            } else {
                super.onSubjectsCollected(webView, z, i2);
            }
        }

        public void onFirstLayoutDid(WebView webView, String str) {
            long currentTimeMillis = System.currentTimeMillis();
            BdSailorWebView.this.perfLog(webView, "onFirstLayoutDid");
            super.onFirstLayoutDid(webView, str);
            if (!(BdSailorWebView.this.mWebViewExt == null || BdSailorWebView.this.mWebViewExt.getWebViewClientExt() == null)) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onFirstLayoutDidExt(BdSailorWebView.this, str);
            }
            SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, str, MonitorConstant.KeySectionType.DID_FIRST_LAYOUT.ordinal(), System.currentTimeMillis() - currentTimeMillis);
        }

        public void onPreloadUrlFound(WebView webView, String str) {
            super.onPreloadUrlFound(webView, str);
            if (BdSailorWebView.this.mWebViewExt == null || BdSailorWebView.this.mWebViewExt.getWebViewClientExt() == null) {
                super.onPreloadUrlFound(webView, str);
            } else {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onPreloadUrlFoundExt(BdSailorWebView.this, str);
            }
        }

        public void onPageCanBeScaled(WebView webView, boolean z) {
            if (BdSailorWebView.this.mWebViewExt == null || BdSailorWebView.this.mWebViewExt.getWebViewClientExt() == null) {
                super.onPageCanBeScaled(webView, z);
            } else {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onPageCanBeScaledExt(BdSailorWebView.this, z);
            }
        }

        public void onResumePlugin() {
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onResumePluginExt(BdSailorWebView.this);
            } else {
                super.onResumePlugin();
            }
        }

        public void onFirstPaintDid(WebView webView, String str) {
            long currentTimeMillis = System.currentTimeMillis();
            BdSailorWebView.this.perfLog(webView, "onFirstPaintDid", "Started");
            super.onFirstPaintDid(webView, str);
            if (!(BdSailorWebView.this.mWebViewExt == null || BdSailorWebView.this.mWebViewExt.getWebViewClientExt() == null)) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onFirstPaintDidExt(BdSailorWebView.this, str);
            }
            BdSailorWebView.this.perfLog(webView, "onFirstPaintDid", "Finished");
            BdSailorWebView.this.perfLog("first_paint", str);
            SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, str, MonitorConstant.KeySectionType.DID_FIRST_PAINT.ordinal(), System.currentTimeMillis() - currentTimeMillis);
        }

        public void onFirstContentfulPaint(WebView webView, String str) {
            if (BdSailorWebView.this.mWebViewExt != null && BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                Log.i(WebViewClient.LOG_TAG, "FCPCallback onFirstContentfulPaintExt, aUrl : ".concat(String.valueOf(str)));
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onFirstContentfulPaintExt(BdSailorWebView.this, str);
            }
        }

        public void onResultParsed(WebView webView, String str) {
            if (BdSailorWebView.this.mWebViewExt != null && BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                Log.i(WebViewClient.LOG_TAG, "FCPCallback onResultParsed, aUrl : ".concat(String.valueOf(str)));
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onResultParsed(BdSailorWebView.this, str);
            }
        }

        public void onFirstTextPaint(WebView webView, String str) {
            if (BdSailorWebView.this.mWebViewExt != null && BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                Log.i(WebViewClient.LOG_TAG, "FTPCallback onFirstTextPaintExt, aUrl : ".concat(String.valueOf(str)));
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onFirstTextPaintExt(BdSailorWebView.this, str);
            }
        }

        public void onFirstImagePaint(WebView webView, String str) {
            if (BdSailorWebView.this.mWebViewExt != null && BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                Log.i(WebViewClient.LOG_TAG, "FIPCallback onFirstImagePaintExt, aUrl : ".concat(String.valueOf(str)));
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onFirstImagePaintExt(BdSailorWebView.this, str);
            }
        }

        public void onFirstScreenLayout(WebView webView, String str) {
            if (BdSailorWebView.this.mWebViewExt != null && BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                Log.i(WebViewClient.LOG_TAG, "FSLCallback onFirstScreenLayoutExt, aUrl : ".concat(String.valueOf(str)));
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onFirstScreenLayoutExt(BdSailorWebView.this, str);
            }
        }

        public void onFirstScreenPaintFinished(WebView webView, String str, int i2, int i3, int i4, int i5, int i6, int i7) {
            System.currentTimeMillis();
            BdSailorWebView.this.perfLog(webView, "onFirstScreenPaintFinished");
            super.onFirstScreenPaintFinished(webView, str, i2, i3, i4, i5, i6, i7);
            BdSailorWebViewClientExt.FirstScreenInfo firstScreenInfo = new BdSailorWebViewClientExt.FirstScreenInfo();
            firstScreenInfo.setDiffDomcompleteAndFspTime(i7);
            if (BdSailorWebView.this.mWebViewExt != null && BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.perfLog(webView, "onFirstScreenPaintFinished 22");
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onFirstScreenPaintFinishedExt(BdSailorWebView.this, str);
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onFirstScreenPaintFinishedExt(BdSailorWebView.this, str, firstScreenInfo);
            }
        }

        public void onFirstScreenImagePaint(String str, String str2, ArrayList arrayList) {
            if (BdSailorWebView.this.mImageMap != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && arrayList != null) {
                FirstScreenImageInfomation.FirstScreenImageItem firstScreenImageItem = new FirstScreenImageInfomation.FirstScreenImageItem();
                firstScreenImageItem.setPaintTimeStamp(System.currentTimeMillis());
                float f2 = BdSailorWebView.this.getContext().getResources().getDisplayMetrics().density;
                firstScreenImageItem.setPosX((int) ((((float) Integer.parseInt((String) arrayList.get(5))) / f2) + 0.5f));
                firstScreenImageItem.setPosY((int) ((((float) Integer.parseInt((String) arrayList.get(6))) / f2) + 0.5f));
                firstScreenImageItem.setPaintHeight((int) ((((float) Integer.parseInt((String) arrayList.get(3))) / f2) + 0.5f));
                firstScreenImageItem.setPaintWidth((int) ((((float) Integer.parseInt((String) arrayList.get(4))) / f2) + 0.5f));
                firstScreenImageItem.setHttpStatusCode(Integer.parseInt((String) arrayList.get(2)));
                firstScreenImageItem.setImageUrl((String) arrayList.get(7));
                if (arrayList.size() == 9) {
                    firstScreenImageItem.setImageShowUrl((String) arrayList.get(8));
                }
                if (arrayList.get(0).equals("1")) {
                    firstScreenImageItem.setErrorOccurred(true);
                } else {
                    firstScreenImageItem.setErrorOccurred(false);
                }
                BdSailorWebView.this.mImageMap.put(str2, firstScreenImageItem);
            }
        }

        public void onFirstScreenImagePaintFinished(WebView webView, FirstScreenImageInfomation firstScreenImageInfomation) {
            BdSailorWebView.this.perfLog(webView, "BdWebViewClientProxy.onFirstScreenImagePaintFinished");
            if (BdSailorWebView.this.mWebViewExt != null && BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.perfLog(webView, "BdWebViewClientProxy.onFirstScreenImagePaintFinished 22");
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onFirstScreenImagePaintFinished(BdSailorWebView.this, firstScreenImageInfomation);
            }
        }

        public void onDidAsyncWiseSearchStatusChanged(WebView webView, String str, int i2, long j2) {
            super.onDidAsyncWiseSearchStatusChanged(webView, str, i2, j2);
            if (BdSailorWebView.this.mWebViewExt != null && BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                Log.i(WebViewClient.LOG_TAG, "onDidAsyncWiseSearchStatusChangedExt status : " + i2 + ", aUrl : " + str);
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onDidAsyncWiseSearchStatusChangedExt(BdSailorWebView.this, str, i2, j2);
            }
        }

        public void onGoBackOrForward(WebView webView, int i2) {
            if (webView == BdSailorWebView.this.mCurrentWebView) {
                BdSailorWebView.this.goBackOrForward(i2);
            }
        }

        public void onGoBackOrForwardAnimationStart(WebView webView, int i2) {
            BdSailorWebViewClientExt webViewClientExt;
            if (webView == BdSailorWebView.this.mCurrentWebView && (webViewClientExt = BdSailorWebView.this.getWebViewExt().getWebViewClientExt()) != null) {
                webViewClientExt.onGoBackOrForwardAnimationStart(BdSailorWebView.this, i2);
            }
        }

        public void onGoBackOrForwardAnimationFinish(WebView webView, int i2) {
            BdSailorWebViewClientExt webViewClientExt;
            if (webView == BdSailorWebView.this.mCurrentWebView && (webViewClientExt = BdSailorWebView.this.getWebViewExt().getWebViewClientExt()) != null) {
                webViewClientExt.onGoBackOrForwardAnimationFinish(BdSailorWebView.this, i2);
            }
        }

        public SnapshotExtraInfo[] onReceivedSnapshotExtraInfos(WebView webView) {
            BdSailorWebViewClientExt webViewClientExt;
            if (webView != BdSailorWebView.this.mCurrentWebView || (webViewClientExt = BdSailorWebView.this.getWebViewExt().getWebViewClientExt()) == null) {
                return null;
            }
            return webViewClientExt.onReceivedSnapshotExtraInfos(BdSailorWebView.this);
        }

        public void onStartFirstNavigation(WebView webView, String str, boolean z, boolean z2, boolean z3) {
            BdSailorWebViewClientExt webViewClientExt;
            if (webView == BdSailorWebView.this.mCurrentWebView && (webViewClientExt = BdSailorWebView.this.getWebViewExt().getWebViewClientExt()) != null) {
                webViewClientExt.onStartFirstNavigation(BdSailorWebView.this, str, z, z2, z3);
            }
        }

        public void onNavigationAnimationStart(WebView webView, boolean z) {
            BdSailorWebViewClientExt webViewClientExt;
            if (webView == BdSailorWebView.this.mCurrentWebView && (webViewClientExt = BdSailorWebView.this.getWebViewExt().getWebViewClientExt()) != null) {
                webViewClientExt.onNavigationAnimationStart(BdSailorWebView.this, z);
            }
        }

        public void onNavigationAnimationFinish(WebView webView, boolean z, boolean z2) {
            BdSailorWebViewClientExt webViewClientExt;
            if (webView == BdSailorWebView.this.mCurrentWebView && (webViewClientExt = BdSailorWebView.this.getWebViewExt().getWebViewClientExt()) != null) {
                webViewClientExt.onNavigationAnimationFinish(BdSailorWebView.this, z, z2);
            }
        }

        public void onGestureScrollStarted(WebView webView, int i2, int i3) {
            BdSailorWebViewClientExt webViewClientExt;
            if (webView == BdSailorWebView.this.mCurrentWebView && (webViewClientExt = BdSailorWebView.this.getWebViewExt().getWebViewClientExt()) != null) {
                webViewClientExt.onGestureScrollStarted(BdSailorWebView.this, i2, i3);
            }
        }

        public void onGestureScrollEnded(WebView webView, int i2, int i3) {
            BdSailorWebViewClientExt webViewClientExt;
            if (webView == BdSailorWebView.this.mCurrentWebView && (webViewClientExt = BdSailorWebView.this.getWebViewExt().getWebViewClientExt()) != null) {
                webViewClientExt.onGestureScrollEnded(BdSailorWebView.this, i2, i3);
            }
        }

        public void onGestureFlingEnded(WebView webView, int i2, int i3) {
            BdSailorWebViewClientExt webViewClientExt;
            boolean unused = BdSailorWebView.this.mHitFlingGesture = true;
            if (webView == BdSailorWebView.this.mCurrentWebView && (webViewClientExt = BdSailorWebView.this.getWebViewExt().getWebViewClientExt()) != null) {
                webViewClientExt.onGestureFlingEnded(BdSailorWebView.this, i2, i3);
            }
        }

        public void onProceededAfterSslError(WebView webView, SslError sslError) {
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onProceededAfterSslErrorExt(BdSailorWebView.this, sslError);
            } else {
                super.onProceededAfterSslError(webView, sslError);
            }
        }

        public boolean onTextCopied(WebView webView) {
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onTextCopiedExt(BdSailorWebView.this);
            }
            return super.onTextCopied(webView);
        }

        public boolean shouldOpenFlash(WebView webView, String str) {
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().shouldOpenFlashExt(BdSailorWebView.this, str);
            }
            return super.shouldOpenFlash(webView, str);
        }

        public boolean onSupportsForceZoomScale(WebView webView) {
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                return BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onSupportsForceZoomScale(BdSailorWebView.this);
            }
            return super.onSupportsForceZoomScale(webView);
        }

        public boolean canHandleImage(WebView webView, String str, String str2, String str3) {
            boolean z = false;
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebViewClientExt webViewClientExt = BdSailorWebView.this.mWebViewExt.getWebViewClientExt();
                BdSailorWebView bdSailorWebView = BdSailorWebView.this;
                z = webViewClientExt.shouldHandleImageExt(bdSailorWebView, str, str2, str3, bdSailorWebView.mCurrentWebView == webView);
                Log.i(WebViewClient.LOG_TAG, "canHandleImage ret=".concat(String.valueOf(z)));
            }
            if (!z) {
                return super.canHandleImage(webView, str, str2, str3);
            }
            BdSailorWebView.this.stopLoading();
            return true;
        }

        public void onPageSwitching(WebView webView) {
            if (BdSailorWebView.this.isAutoShowTitlebar()) {
                BdSailorWebView.this.showEmbeddedTitleBar(false);
            }
            super.onPageSwitching(webView);
        }

        public void onSecurityCheckResult(WebView webView, String str, WebViewClient.SecurityInfo securityInfo) {
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onSecurityCheckResultExt(BdSailorWebView.this, str, securityInfo);
            }
            super.onSecurityCheckResult(webView, str, securityInfo);
        }

        public void onKeywordExtension(WebView webView, String str, String str2) {
            boolean z;
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                z = BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onKeywordExtensionExt(BdSailorWebView.this, str, str2);
            } else {
                z = false;
            }
            if (!z) {
                super.onKeywordExtension(webView, str, str2);
            }
        }

        public boolean shouldKeywordExtension(WebView webView, String str) {
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                return BdSailorWebView.this.mWebViewExt.getWebViewClientExt().shouldKeywordExtensionExt(BdSailorWebView.this, str);
            }
            return super.shouldKeywordExtension(webView, str);
        }

        public void onDisplaySoftKeyboard(WebView webView) {
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onDisplaySoftKeyboardExt(BdSailorWebView.this);
            } else {
                super.onDisplaySoftKeyboard(webView);
            }
        }

        public void onHideSoftKeyboard(WebView webView) {
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onHideSoftKeyboardExt(BdSailorWebView.this);
            } else {
                super.onHideSoftKeyboard(webView);
            }
        }

        public void onUpdateTextFieldNextPreStatus(WebView webView, boolean z, boolean z2) {
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onUpdateTextFieldNextPreStatus(BdSailorWebView.this, z, z2);
            }
        }

        public void onUrlRedirected(WebView webView, String str, String str2) {
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onUrlRedirectedExt(BdSailorWebView.this, str, str2);
            }
        }

        public void AntiHijackSign(WebView webView, String str) {
        }

        public void onRestoreFromPageCacheDid(WebView webView, String str) {
            long currentTimeMillis = System.currentTimeMillis();
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onRestoreFromPageCacheDid(BdSailorWebView.this, str);
            } else {
                super.onRestoreFromPageCacheDid(webView, str);
            }
            SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, str, MonitorConstant.KeySectionType.RESTORE_FROM_CACHE.ordinal(), System.currentTimeMillis() - currentTimeMillis);
        }

        public void onRestoreFromCache(WebView webView, String str) {
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onRestoreFromPageCacheDid(BdSailorWebView.this, str);
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onRestoreFromCache(BdSailorWebView.this, str);
                return;
            }
            super.onRestoreFromCache(webView, str);
        }

        public void onCheckHasManifestAndServiceWorker(WebView webView, String str, String str2, boolean z) {
            Log.i("pwa", "onCheckHasManifestAndServiceWorker has=" + z + ",url=" + str);
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onCheckHasManifestAndServiceWorker(BdSailorWebView.this, str, str2, z);
            } else {
                super.onCheckHasManifestAndServiceWorker(webView, str, str2, z);
            }
        }

        public int computeHookH5NavigationStep(int i2) {
            Log.i(WebViewClient.LOG_TAG, "BeeFrame computeHookH5NavigationStep: offset=".concat(String.valueOf(i2)));
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                return BdSailorWebView.this.mWebViewExt.getWebViewClientExt().computeHookH5NavigationStep(i2);
            }
            return super.computeHookH5NavigationStep(i2);
        }

        public void onHandleBackForwardBeyondHistory(int i2) {
            Log.i(WebViewClient.LOG_TAG, "BeeFrame onHandleBackForwardBeyondHistory: offset=".concat(String.valueOf(i2)));
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onHandleBackForwardBeyondHistory(i2);
            } else {
                super.onHandleBackForwardBeyondHistory(i2);
            }
        }

        public void onGotNotResponse(WebView webView) {
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onGotNotResponse(BdSailorWebView.this);
            } else {
                super.onGotNotResponse(webView);
            }
        }

        public void onJsCodeCacheFinished(JsCodeCacheResult jsCodeCacheResult) {
            Log.i(WebViewClient.LOG_TAG, "[zhh] CodeCache. businessId = %s, jsPath = %s, isCacheUsed = %b", jsCodeCacheResult.businessId, jsCodeCacheResult.jsPath, Boolean.valueOf(jsCodeCacheResult.isCacheUsed));
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onJsCodeCacheFinished(jsCodeCacheResult);
            } else {
                super.onJsCodeCacheFinished(jsCodeCacheResult);
            }
        }

        public void onNotifyVideoInfo(VideoSniffingInfo videoSniffingInfo) {
            Log.i("parse-video", "BdSailorWebView onNotifyVideoInfo video info:  url= " + videoSniffingInfo.getSourceUrl() + " poster url= " + videoSniffingInfo.getPosterImageUrl() + " page title= " + videoSniffingInfo.getPageTitle() + " page url= " + videoSniffingInfo.getPageUrl());
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onNotifyVideoInfo(videoSniffingInfo);
            } else {
                super.onNotifyVideoInfo(videoSniffingInfo);
            }
        }

        public boolean shouldBlockMediaRequest(WebView webView, String str, String str2) {
            Log.i("block-media-request", "BdSailorWebView shouldBlockMediaRequest info:  pageUrl= " + str + " mediaUrl= " + str2 + " thread name " + Thread.currentThread().getName());
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                return BdSailorWebView.this.mWebViewExt.getWebViewClientExt().shouldBlockMediaRequest(BdSailorWebView.this, str, str2);
            }
            return super.shouldBlockMediaRequest(webView, str, str2);
        }

        public void onNotifyPrefetchVideoResource(WebView webView, VideoSniffingInfo videoSniffingInfo) {
            Log.i("video-prefetch-send", "BdSailorWebView onNotifyPrefetchVideoResource video info:  url= " + videoSniffingInfo.getSourceUrl() + " cookies= " + videoSniffingInfo.getCookie() + " userAgent= " + videoSniffingInfo.getUserAgent() + " referrer= " + videoSniffingInfo.getReferrer() + " page url= " + videoSniffingInfo.getPageUrl());
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onNotifyPrefetchVideoResource(BdSailorWebView.this, videoSniffingInfo);
            } else {
                super.onNotifyPrefetchVideoResource(webView, videoSniffingInfo);
            }
        }

        public void onNotifyCancelPrefetchVideoResource(WebView webView, String str) {
            Log.i("video-prefetch-send", "BdSailorWebView onNotifyCancelPrefetchVideoResource video info:  videoUrl = ".concat(String.valueOf(str)));
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onNotifyCancelPrefetchVideoResource(BdSailorWebView.this, str);
            } else {
                super.onNotifyCancelPrefetchVideoResource(webView, str);
            }
        }

        public void onPageDetectFinish(WebView webView, WebViewClient.DetectType detectType, String str) {
            Log.i("ZeusStatNodeBuilderImpl", " LayoutObject LayoutObjectTracker detectType  = " + detectType + "onPageDetectFinish = " + str);
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onPageDetectFinish(BdSailorWebView.this, detectType, str);
            } else {
                super.onPageDetectFinish(webView, detectType, str);
            }
        }

        public void onNotifyExitApp(WebView webView, boolean z) {
            Log.i("zeus-flags", " onNotifyExitApp restart= ".concat(String.valueOf(z)));
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onNotifyExitApp(BdSailorWebView.this, z);
            } else {
                super.onNotifyExitApp(webView, z);
            }
        }

        public void onReceivedMainResCustomResponseHeaders(WebView webView, Map<String, String> map) {
            Log.i("mainres-headers", "BdSailorWebView onReceivedMainResCustomResponseHeaders responseHeaders info: url " + webView.getUrl());
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onReceivedMainResCustomResponseHeaders(BdSailorWebView.this, map);
            } else {
                super.onReceivedMainResCustomResponseHeaders(webView, map);
            }
        }

        public void onMainResourceLoaded(WebView webView, String str, int i2, int i3, Map<String, String> map) {
            Log.i("mainres-loaded", "BdSailorWebView onMainResourceLoaded responseHeaders info:  httpStatusCode = " + i2 + " url " + str);
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onMainResourceLoaded(BdSailorWebView.this, str, i2, i3, map);
            } else {
                super.onMainResourceLoaded(webView, str, i2, i3, map);
            }
        }

        public void onReceiveMainDocumentResponse(WebView webView, String str, String str2) {
            Log.i("BdSailorWebView", "BdSailorWebView onReceiveMainDocumentResponse url ".concat(String.valueOf(str)));
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onReceiveMainDocumentResponse(BdSailorWebView.this, str, str2);
            } else {
                super.onReceiveMainDocumentResponse(webView, str, str2);
            }
        }
    }

    class BdDownloadListenerBridge implements DownloadListener {
        private WebView mWebView;

        public BdDownloadListenerBridge(WebView webView) {
            this.mWebView = webView;
        }

        public void onDownloadStart(String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, byte[] bArr) {
            if (BdSailorWebView.this.mDownloadListener != null) {
                BdSailorWebView.this.mDownloadListener.onDownloadStart(str, str2, str3, str4, str5, str6, str7, j2, bArr);
            }
        }
    }

    class BdBackForwardClientBridge extends WebBackForwardListClient {
        private WebView mWebView;

        protected BdBackForwardClientBridge(WebView webView) {
            this.mWebView = webView;
        }

        public void onNewHistoryItem(WebHistoryItem webHistoryItem) {
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onNewPage(BdSailorWebView.this);
            }
        }

        public void onIndexChanged(WebHistoryItem webHistoryItem, int i2) {
            super.onIndexChanged(webHistoryItem, i2);
        }
    }

    class BdBasePictureListenerProxy implements WebView.PictureListener {
        private BdBasePictureListenerProxy() {
        }

        public void onNewPicture(WebView webView, Picture picture) {
            if (BdSailorWebView.this.mPictureListener != null) {
                BdSailorWebView.this.mPictureListener.onNewPicture(webView, picture);
            }
        }
    }

    class BdSailorWebViewExt implements ISailorWebViewExt {
        private ISailorWebSettingsExt mSettingsExt;
        private BdSailorWebChromeClientExt mWebChromeClientExt;
        private BdSailorWebViewClientExt mWebViewClientExt;

        private BdSailorWebViewExt() {
        }

        public void onShowCommentPanel(String str, String str2) {
            BdSailorWebChromeClientExt bdSailorWebChromeClientExt = this.mWebChromeClientExt;
            if (bdSailorWebChromeClientExt != null) {
                bdSailorWebChromeClientExt.onShowCommentPanel(BdSailorWebView.this, str, str2);
            }
        }

        public void onShowValidateComponent(String str, String str2) {
            BdSailorWebChromeClientExt bdSailorWebChromeClientExt = this.mWebChromeClientExt;
            if (bdSailorWebChromeClientExt != null) {
                bdSailorWebChromeClientExt.onShowValidateComponent(BdSailorWebView.this, str, str2);
            }
        }

        public void updatePictureUrlListExt() {
        }

        public void startCaptureContentExt() {
        }

        public List<String> getPictureUrlListExt() {
            return null;
        }

        public void pauseMediaExt() {
            BdSailorWebView.this.mCurrentWebView.pauseMedia();
        }

        public void resumeMediaExt() {
            BdSailorWebView.this.mCurrentWebView.resumeMedia();
        }

        public void resumeExt(boolean z) {
            BdSailorWebView.this.mCurrentWebView.resume(z);
        }

        public void pauseExt(boolean z) {
            BdSailorWebView.this.mCurrentWebView.pause(z);
        }

        public void mediaPlayerTimeChangedExt(float f2, float f3) {
            BdSailorWebView.this.mCurrentWebView.mediaPlayerTimeChanged(f2, f3);
        }

        public void mediaPlayerStatusChangedExt(int i2, float f2, float f3) {
            BdSailorWebView.this.mCurrentWebView.mediaPlayerStatusChanged(i2, f2, f3);
        }

        public int getBackgroundNightColorExt() {
            return 0;
        }

        public int getImageNightColorExt() {
            return 0;
        }

        public int getTextNightColorExt() {
            return 0;
        }

        public int getLinkTextNightColorExt() {
            return 0;
        }

        public int getBigPluginTextNightColorExt() {
            return 0;
        }

        public int getBorderNightColorExt() {
            return 0;
        }

        public int getVisitedLinkNightColorExt() {
            return 0;
        }

        public int getDefaultLinkTextNightColorExt() {
            return 0;
        }

        public int getNightModeColorStyleExt() {
            return BdSailorWebView.this.mCurrentWebView.nightModeColorStyle();
        }

        public boolean setBackgroundNightColorExt(int i2) {
            return false;
        }

        public boolean setImageNightColorExt(int i2) {
            return false;
        }

        public boolean setTextNightColorExt(int i2) {
            return false;
        }

        public boolean setLinkTextNightColorExt(int i2) {
            return false;
        }

        public boolean setBigPluginTextNightColorExt(int i2) {
            return false;
        }

        public boolean setBorderNightColorExt(int i2) {
            return false;
        }

        public boolean setVisitedLinkNightColorExt(int i2) {
            return BdSailorWebView.this.mCurrentWebView.setVisitedLinkNightColor(i2);
        }

        public boolean setDefaultLinkTextNightColorExt(int i2) {
            return false;
        }

        public boolean setNightModeColorStyleExt(int i2) {
            return false;
        }

        public void setWebViewStateExt(WebView.WebViewState webViewState) {
            BdSailorWebView.this.mCurrentWebView.setWebViewState(webViewState);
        }

        public void setWebViewTypeExt(WebView.WebViewType webViewType) {
            BdSailorWebView.this.mCurrentWebView.setWebViewType(webViewType);
        }

        public boolean savePageAsLocalFilesExt(String str, String str2, WebView.SaveAsType saveAsType) {
            return BdSailorWebView.this.mCurrentWebView.savePageAsLocalFiles(str, str2, saveAsType);
        }

        public float getCurrentScaleExt() {
            return BdSailorWebView.this.mCurrentWebView.getCurrentScale();
        }

        public void setSubjectScrollToOnloadExt(int i2) {
            BdSailorWebView.this.mCurrentWebView.setSubjectScrollToOnload(i2);
        }

        public void exitFullScreenModeExt() {
            BdSailorWebView.this.mCurrentWebView.exitFullScreenMode();
        }

        public Bitmap getMagnifierBmpExt() {
            return BdSailorWebView.this.mCurrentWebView.getMagnifierBmp();
        }

        public void showMagnifierExt(int i2, int i3, int i4, int i5, boolean z) {
            BdSailorWebView.this.mCurrentWebView.showMagnifier(i2, i3, i4, i5, z);
        }

        public void moveMagnifierExt(int i2, int i3) {
            BdSailorWebView.this.mCurrentWebView.moveMagnifier(i2, i3);
        }

        public void hideMagnifierExt(int i2, int i3) {
            BdSailorWebView.this.mCurrentWebView.hideMagnifier(i2, i3);
        }

        public boolean setPreviewZoomScaleExt(float f2) {
            return BdSailorWebView.this.mCurrentWebView.setPreviewZoomScale(f2);
        }

        public void setBeginScaleExt() {
            BdSailorWebView.this.mCurrentWebView.setBeginScale();
        }

        public void setEndScaleExt() {
            BdSailorWebView.this.mCurrentWebView.setEndScale();
        }

        public float getActualZoomScaleExt() {
            return BdSailorWebView.this.mCurrentWebView.getActualZoomScale();
        }

        public float getMinZoomScaleExt() {
            return BdSailorWebView.this.mCurrentWebView.getMinZoomScale();
        }

        public float getMaxZoomScaleExt() {
            return BdSailorWebView.this.mCurrentWebView.getMaxZoomScale();
        }

        public void emulateShiftHeldOnLinkExt() {
            BdSailorWebView.this.mCurrentWebView.emulateShiftHeldOnLink();
        }

        public void emulateShiftHeldOnNormalTextExt() {
            BdSailorWebView.this.mCurrentWebView.emulateShiftHeldOnNormalText();
        }

        public void selectElementByIdExt(String str) {
            BdSailorWebView.this.mCurrentWebView.selectElementById(str);
        }

        public int getActionNodesCountExt() {
            return BdSailorWebView.this.mCurrentWebView.getActionNodesCount();
        }

        public boolean isMobileSiteExt() {
            return BdSailorWebView.this.mCurrentWebView.isMobileSite();
        }

        public boolean notifyNativeExitFullScreenIfNeededExt(int i2) {
            return BdSailorWebView.this.mCurrentWebView.notifyNativeExitFullScreenIfNeeded(i2);
        }

        public Bitmap getCanvasCacheBmpExt() {
            return BdSailorWebView.this.mCurrentWebView.getCanvasCacheBmp();
        }

        public void destroyCanvasCacheBmpExt() {
            BdSailorWebView.this.mCurrentWebView.destroyCanvasCacheBmp();
        }

        public void setDefaultViewSizeExt(int i2, int i3) {
            BdSailorWebView.this.mCurrentWebView.setDefaultViewSize(i2, i3);
        }

        public void addNoStatePrefetch(String str, String str2) {
            BdSailorWebView.this.mCurrentWebView.addNoStatePrefetch(str, str2);
        }

        public void addNoStatePrefetch(String str, Map<String, String> map) {
            BdSailorWebView.this.mCurrentWebView.addNoStatePrefetch(str, map);
        }

        public void cancelCurrentNoStatePrefetch() {
            BdSailorWebView.this.mCurrentWebView.cancelCurrentNoStatePrefetch();
        }

        public boolean startPreviewZoomScaleExt() {
            return BdSailorWebView.this.mCurrentWebView.startPreviewZoomScale();
        }

        public void changeWapPreloadUrlStyleExt(int i2, String str) {
            BdSailorWebView.this.mCurrentWebView.changeWapPreloadUrlStyle(i2, str);
        }

        public boolean isWapAllowScaleExt() {
            return BdSailorWebView.this.mCurrentWebView.isWapAllowScale();
        }

        public void completeSelectionExt() {
            BdSailorWebView.this.mCurrentWebView.completeSelection();
        }

        public void setFixWebViewSecurityHolesExt(boolean z) {
            BdSailorWebView.this.mCurrentWebView.getSecureProcessor().a(z);
        }

        public boolean isFixWebViewSecurityHolesExt() {
            return BdSailorWebView.this.mCurrentWebView.getSecureProcessor().a();
        }

        public void ensureRemoveSearchBoxImplExt() {
            BdSailorWebView.this.mCurrentWebView.getSecureProcessor().f();
        }

        public void setNeedImpactScriptExt(boolean z) {
            BdSailorWebView.this.mCurrentWebView.getSecureProcessor().b(z);
        }

        public boolean isNeedImpactScriptExt() {
            return BdSailorWebView.this.mCurrentWebView.getSecureProcessor().b();
        }

        public void execJavaScriptExt(String str, String... strArr) {
            if (strArr == null || strArr.length == 0) {
                BdSailorWebView.this.mCurrentWebView.loadUrl("javascript:(" + str + ")()");
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("javascript:" + str + "('");
            for (int i2 = 0; i2 < strArr.length; i2++) {
                stringBuffer.append(strArr[i2]);
                if (i2 != strArr.length - 1) {
                    stringBuffer.append(", ");
                }
            }
            stringBuffer.append("')");
            BdSailorWebView.this.mCurrentWebView.loadUrl(stringBuffer.toString());
        }

        public boolean isDestroyedExt() {
            return BdSailorWebView.this.mCurrentWebView.isDestroyed();
        }

        public boolean isForegroundExt() {
            return c.a((View) BdSailorWebView.this);
        }

        public int getEmbeddedTitleBarHeightExt() {
            if (BdSailorWebView.this.mEmbeddedTitlebar != null) {
                return BdSailorWebView.this.mEmbeddedTitlebar.getHeight();
            }
            return 0;
        }

        public void setTextSelectingModeExt(boolean z) {
            BdSailorWebView.this.mCurrentWebView.setSelectingText(z);
        }

        public void setExtendSelectionExt(boolean z) {
        }

        public boolean isExtendSelectionExt() {
            return false;
        }

        public void setShiftPressedModeExt(boolean z) {
            Class<WebView> cls = WebView.class;
            try {
                d.a(cls, this, "setShiftIsPressed", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)}, Boolean.FALSE);
            } catch (Exception e2) {
            }
        }

        public boolean isShiftPressedModeExt() {
            try {
                return ((Boolean) d.a(WebView.class, this, "getShiftIsPressed", (Class[]) null, (Object[]) null, Boolean.FALSE)).booleanValue();
            } catch (Exception e2) {
                return false;
            }
        }

        public boolean isTextSelectingModeExt() {
            return BdSailorWebView.this.mCurrentWebView.getSelectingText();
        }

        public String getSelectionTextExt() {
            try {
                return (String) d.a(WebView.class, this, "nativeGetSelection", (Class[]) null, (Object[]) null, "");
            } catch (Exception e2) {
                return "";
            }
        }

        public void setDrawSelectionPointerExt(boolean z) {
            Class<WebView> cls = WebView.class;
            try {
                d.a(cls, this, "setDrawSelectionPointer", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)}, Boolean.FALSE);
            } catch (Exception e2) {
            }
        }

        public boolean isDrawSelectionPointerExt() {
            try {
                return ((Boolean) d.a(WebView.class, this, "getDrawSelectionPointer", (Class[]) null, (Object[]) null, Boolean.FALSE)).booleanValue();
            } catch (Exception e2) {
                return false;
            }
        }

        public ZoomButtonsController getZoomButtonsControllerExt() {
            try {
                return (ZoomButtonsController) d.a(WebView.class, this, "getZoomControls", (Class[]) null, (Object[]) null, (Object) null);
            } catch (Exception e2) {
                return null;
            }
        }

        public ISailorWebSettingsExt getSettingsExt() {
            if (this.mSettingsExt == null) {
                BdSailorWebSettings settings = BdSailorWebView.this.getSettings();
                settings.getClass();
                this.mSettingsExt = new BdSailorWebSettings.BdSailorWebSettingsExt();
            }
            return this.mSettingsExt;
        }

        public void setWebViewClientExt(BdSailorWebViewClientExt bdSailorWebViewClientExt) {
            this.mWebViewClientExt = bdSailorWebViewClientExt;
        }

        public void setWebChromeClientExt(BdSailorWebChromeClientExt bdSailorWebChromeClientExt) {
            this.mWebChromeClientExt = bdSailorWebChromeClientExt;
        }

        public BdSailorWebViewClientExt getWebViewClientExt() {
            return this.mWebViewClientExt;
        }

        public BdSailorWebChromeClientExt getWebChromeClientExt() {
            return this.mWebChromeClientExt;
        }

        public boolean canGoToPreloadNextExt() {
            return BdSailorWebView.this.mCurrentWebView.canGoPrerender();
        }

        public void setTextFieldTextExt(String str) {
            BdSailorWebView.this.mCurrentWebView.setTextFieldText(str);
        }

        public void setTextFieldTextExt(String str, boolean z) {
            if (z) {
                BdSailorWebView.this.mCurrentWebView.insertTextFieldText(str);
            } else {
                BdSailorWebView.this.mCurrentWebView.setTextFieldText(str);
            }
        }

        public WebView.WebPageInfoList getPageInfo() {
            return BdSailorWebView.this.mCurrentWebView.getPageInfo();
        }

        public void onSearchKeyword(String str, String str2) {
        }

        public int getAdCount(String str) {
            Log.i(BdSailorWebView.LOG_TAG, " getAdCount : " + BdSailorWebView.this.mCurrentWebView.getAdblockCount(str));
            return BdSailorWebView.this.mCurrentWebView.getAdblockCount(str);
        }

        public int getEvilLocationCount(String str) {
            Log.i(BdSailorWebView.LOG_TAG, " getEvilLocationCount : " + BdSailorWebView.this.mCurrentWebView.getEvilLocationCount(str));
            return BdSailorWebView.this.mCurrentWebView.getEvilLocationCount(str);
        }

        public int getMagicFilterCount() {
            return 0;
        }

        public void startLoadingAnimation() {
            BdSailorWebView.this.mCurrentWebView.startLoadingAnimation((String) null);
        }

        public void startLoadingAnimation(String str) {
            BdSailorWebView.this.mCurrentWebView.startLoadingAnimation(str);
        }

        public void resetLoadingAnimation() {
            BdSailorWebView.this.mCurrentWebView.resetLoadingAnimation();
        }

        public void loadUrl(String str, Map<String, String> map, boolean z) {
            BdSailorWebView.this.mCurrentWebView.loadUrl(str, map, z);
        }

        public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5, boolean z) {
            BdSailorWebView.this.mCurrentWebView.loadDataWithBaseURL(str, str2, str3, str4, str5, z);
        }

        public void onResumeAll() {
            BdSailorWebView.this.mCurrentWebView.onResumeAll();
        }

        public void onPauseAll() {
            BdSailorWebView.this.mCurrentWebView.onPauseAll();
        }

        public void startDeadChainDetect(String str) {
            BdSailorWebView.this.mCurrentWebView.startDeadChainDetect(str);
        }

        public void resetClearView() {
            BdSailorWebView.this.mCurrentWebView.resetClearView();
        }

        public void cut() {
            if (BdSailorWebView.this.mCurrentWebView != null) {
                BdSailorWebView.this.mCurrentWebView.cut();
            }
        }

        public void copy() {
            if (BdSailorWebView.this.mCurrentWebView != null) {
                BdSailorWebView.this.mCurrentWebView.copy();
            }
        }

        public void paste() {
            if (BdSailorWebView.this.mCurrentWebView != null) {
                BdSailorWebView.this.mCurrentWebView.paste();
            }
        }

        public void pasteAsPlainText() {
            if (BdSailorWebView.this.mCurrentWebView != null) {
                BdSailorWebView.this.mCurrentWebView.pasteAsPlainText();
            }
        }

        public void selectAll() {
            if (BdSailorWebView.this.mCurrentWebView != null) {
                BdSailorWebView.this.mCurrentWebView.selectAll();
            }
        }

        public boolean isFocusedNodeEditable() {
            return BdSailorWebView.this.mCurrentWebView != null && BdSailorWebView.this.mCurrentWebView.isFocusedNodeEditable();
        }

        public boolean canPaste() {
            return BdSailorWebView.this.mCurrentWebView != null && BdSailorWebView.this.mCurrentWebView.canPaste();
        }

        public boolean canPasteAsPlainText() {
            return BdSailorWebView.this.mCurrentWebView != null && BdSailorWebView.this.mCurrentWebView.canPasteAsPlainText();
        }

        public boolean hasSelection() {
            return BdSailorWebView.this.mCurrentWebView != null && BdSailorWebView.this.mCurrentWebView.hasSelection();
        }

        public boolean isSelectionPassword() {
            return BdSailorWebView.this.mCurrentWebView != null && BdSailorWebView.this.mCurrentWebView.isSelectionPassword();
        }
    }

    protected class ViewDelegate extends WebViewDelegate {
        public ViewDelegate(WebView webView) {
            super(webView);
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            return BdSailorWebView.this.onTouchEvent(motionEvent);
        }

        public void onScrollChanged(int i2, int i3, int i4, int i5) {
            BdSailorWebView.this.onScrollChanged(i2, i3, i4, i5);
        }

        public void onOverScrolled(int i2, int i3, boolean z, boolean z2) {
            BdSailorWebView.this.onOverScrolled(i2, i3, z, z2);
        }

        public boolean canGoBack() {
            return BdSailorWebView.this.canGoBack();
        }

        public void goBack() {
            BdSailorWebView.this.goBack();
        }

        public boolean canGoForward() {
            return BdSailorWebView.this.canGoForward();
        }

        public void goForward() {
            BdSailorWebView.this.goForward();
        }

        public boolean canGoBackOrForward(int i2) {
            return BdSailorWebView.this.canGoBackOrForward(i2);
        }

        public void goBackOrForward(int i2) {
            BdSailorWebView.this.goBackOrForward(i2);
        }

        public boolean isTitlebarShowing() {
            return BdSailorWebView.this.isTitlebarShowing();
        }

        public int getTitlebarHeight() {
            return BdSailorWebView.this.getTitlebarHeight();
        }

        public boolean isTitlebarCanShow() {
            return BdSailorWebView.this.isTitlebarCanShow();
        }

        public View getEmbeddedTitlebar() {
            return BdSailorWebView.this.getEmbeddedTitlebar();
        }

        public View getLandingPageTitleBar() {
            return BdSailorWebView.this.getLandingPageTitleBar();
        }

        public View getSearchResultTitleBar() {
            return BdSailorWebView.this.getSearchResultTitleBar();
        }

        public View getCurrentTitleBar() {
            return BdSailorWebView.this.getCurrentTitleBar();
        }

        public void setCurrentTitleBar(boolean z) {
            BdSailorWebView.this.setCurrentTitleBar(z);
        }
    }

    public static void addToWebCache(String str, boolean z, boolean z2) {
        WebView.addToWebCache(str, z, z2);
    }

    public static void addToWebCache(String str, boolean z, boolean z2, Map<String, String> map) {
        WebView.addToWebCache(str, z, z2, map);
    }

    public static void addToWebCache(String str, boolean z, Map<String, String> map) {
        WebView.addToWebCache(str, z, map);
    }

    public static void addToWebCache(String str, boolean z) {
        WebView.addToWebCache(str, z);
    }

    public static void addToWebCache(String str, boolean z, Map<String, String> map, boolean z2) {
        WebView.addToWebCache(str, z, map, z2);
    }

    public void addToWebCache(String str, boolean z, String str2, int i2) {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            webView.addToWebCache(str, z, str2, i2);
        }
    }

    public static void removeFromWebCache(String str) {
        WebView.removeFromWebCache(str);
    }

    public static boolean isInWebCache(String str) {
        return WebView.isInWebCache(str);
    }
}
