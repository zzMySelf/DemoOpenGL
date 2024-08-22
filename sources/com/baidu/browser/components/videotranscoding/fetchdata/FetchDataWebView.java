package com.baidu.browser.components.videotranscoding.fetchdata;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.browser.BrowserType;
import com.baidu.browser.components.videotranscoding.fetchdata.FetchTransNa;
import com.baidu.browser.components.videotranscoding.net.MainTransRepoKt;
import com.baidu.browser.components.videotranscoding.util.VideoTransUtilKt;
import com.baidu.browser.core.util.BdViewUtils;
import com.baidu.browser.explore.jsbridge.CommonJsMessageCallback;
import com.baidu.browser.explore.jsbridge.JsInjectionCommonJsInterface;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.BdSailorWebChromeClient;
import com.baidu.browser.sailor.BdSailorWebChromeClientExt;
import com.baidu.browser.sailor.BdSailorWebSettings;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.BdSailorWebViewClient;
import com.baidu.browser.sailor.BdSailorWebViewClientExt;
import com.baidu.browser.sailor.ISailorWebSettingsExt;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.search.basic.utils.SearchABTestUtils;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.datachannel.Contract;
import com.baidu.searchbox.datachannel.DataChannelWebSchemeDispatcher;
import com.baidu.searchbox.datachannel.Registry;
import com.baidu.searchbox.jsinjection.JsInjectionDelegate;
import com.baidu.searchbox.ng.browser.NgWebView;
import com.baidu.searchbox.ng.browser.R;
import com.baidu.searchbox.ng.browser.cache.NgWebViewCacheManager;
import com.baidu.searchbox.ng.browser.client.WebNgClient;
import com.baidu.searchbox.ng.browser.explore.BdExplorePopView;
import com.baidu.searchbox.ng.browser.util.NgWebViewUtils;
import com.baidu.searchbox.search.debug.SearchDebugConfig;
import com.baidu.searchbox.search.pyramid.SearchBrowserInterface;
import com.baidu.searchbox.search.webvideo.utils.SearchH5AbManager;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.swan.apps.model.SwanAppErrorPageParam;
import com.baidu.webkit.sdk.VideoSniffingInfo;
import com.baidu.webkit.sdk.WebSettings;
import com.baidu.webkit.sdk.WebView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0004GHIJB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0011H\u0002J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0011H\u0002J\u0006\u0010\u001f\u001a\u00020\u0017J\b\u0010 \u001a\u00020\u0017H\u0002J\u0014\u0010!\u001a\u0004\u0018\u00010\b2\b\u0010\"\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010#\u001a\u0004\u0018\u00010\u0011J\u0010\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0016J\u0010\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020(H\u0016J\b\u0010,\u001a\u00020\u0017H\u0016J\b\u0010-\u001a\u00020\u0017H\u0002J\u0012\u0010.\u001a\u00020\u00172\b\u0010/\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u00100\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0011H\u0003J\u0006\u00101\u001a\u00020\u0017J\b\u00102\u001a\u00020(H\u0002J\b\u00103\u001a\u00020\u0017H\u0002J\u0006\u00104\u001a\u00020\u0017J\u0018\u00105\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u00106\u001a\u00020(H\u0002J\u000e\u00107\u001a\u00020\u00172\u0006\u00108\u001a\u00020\u0013J\u0010\u00109\u001a\u00020\u00172\u0006\u0010:\u001a\u00020;H\u0002J\u0010\u0010<\u001a\u00020\u00172\u0006\u0010:\u001a\u00020=H\u0002J\u0016\u0010>\u001a\u00020\u00172\u0006\u0010?\u001a\u00020\b2\u0006\u0010@\u001a\u00020AJ\u001a\u0010B\u001a\u00020\u00172\b\u0010/\u001a\u0004\u0018\u00010\u00112\u0006\u0010C\u001a\u00020(H\u0003J\u000e\u0010B\u001a\u00020\u00172\u0006\u0010C\u001a\u00020(J$\u0010D\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&2\b\u0010E\u001a\u0004\u0018\u00010\b2\b\u0010?\u001a\u0004\u0018\u00010\bH\u0002J\u0006\u0010F\u001a\u00020\u0017R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0015X\u0004¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/baidu/browser/components/videotranscoding/fetchdata/FetchDataWebView;", "Lcom/baidu/searchbox/ng/browser/NgWebView$OnWebViewHookHandler;", "Lcom/baidu/searchbox/NoProGuard;", "Lcom/baidu/browser/explore/jsbridge/CommonJsMessageCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "KEY_VIDEO_TRANS_BG", "", "containerKey", "getContext", "()Landroid/content/Context;", "fetchTransNa", "Lcom/baidu/browser/components/videotranscoding/fetchdata/FetchTransNa;", "mMainDispatcher", "Lcom/baidu/searchbox/unitedscheme/UnitedSchemeMainDispatcher;", "mNgWebView", "Lcom/baidu/searchbox/ng/browser/NgWebView;", "transNaCacheListener", "Lcom/baidu/browser/components/videotranscoding/fetchdata/FetchDataWebView$NaPageDataListener;", "videoUrlCache", "Ljava/util/concurrent/ConcurrentHashMap;", "checkZeusSettingsMode", "", "settings", "Lcom/baidu/browser/sailor/BdSailorWebSettings;", "settingsExt", "Lcom/baidu/browser/sailor/ISailorWebSettingsExt;", "clear", "ngWebView", "createWebView", "destroy", "destroyWebView", "getUserAgentString", "originalUa", "getWebView", "handleCommonJsMessage", "message", "Lorg/json/JSONObject;", "hookCanGoBack", "", "canGoBack", "hookCanGoForward", "canGoForward", "hookGoBack", "initDispatcher", "initJavaScript", "webView", "initSettings", "initWebView", "isWebViewStatusReset", "resetNgWebView", "resetWebView", "setFontSettings", "zoomSwitch", "setTransNaCacheDataListener", "listener", "setWebViewClient", "client", "Lcom/baidu/browser/sailor/BdSailorWebViewClient;", "setWebViewClientExt", "Lcom/baidu/browser/sailor/BdSailorWebViewClientExt;", "start", "url", "container", "Landroid/widget/FrameLayout;", "updateWebViewNightMode", "isNightMode", "uploadJsData", "originalPageUrl", "uploadTransData", "DataChannelWebSchemeCallback", "FetchDataWebChromeClient", "FetchDataWebViewClientExt", "NaPageDataListener", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FetchDataWebView.kt */
public final class FetchDataWebView implements NgWebView.OnWebViewHookHandler, NoProGuard, CommonJsMessageCallback {
    private final String KEY_VIDEO_TRANS_BG = "videotrans_bg";
    private final String containerKey;
    private final Context context;
    /* access modifiers changed from: private */
    public final FetchTransNa fetchTransNa = new FetchTransNa((String) null, (String) null, (JSONObject) null, (FetchTransNa.LoadingListener) null, (String) null, (String) null, 63, (DefaultConstructorMarker) null);
    private UnitedSchemeMainDispatcher mMainDispatcher;
    /* access modifiers changed from: private */
    public NgWebView mNgWebView;
    /* access modifiers changed from: private */
    public NaPageDataListener transNaCacheListener;
    /* access modifiers changed from: private */
    public final ConcurrentHashMap<String, String> videoUrlCache = new ConcurrentHashMap<>();

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H&¨\u0006\t"}, d2 = {"Lcom/baidu/browser/components/videotranscoding/fetchdata/FetchDataWebView$NaPageDataListener;", "", "getNaPageCacheData", "Lorg/json/JSONObject;", "pageUrl", "", "uploadJsData", "", "url", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FetchDataWebView.kt */
    public interface NaPageDataListener {
        JSONObject getNaPageCacheData(String str);

        void uploadJsData(String str);
    }

    public FetchDataWebView(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        String str = "fetch_data_" + System.currentTimeMillis();
        this.containerKey = str;
        initDispatcher();
        JsInjectionDelegate.INSTANCE.registerConditionListener(str, new FetchDataWebView$jsInjectionConditionListener$1());
    }

    public final Context getContext() {
        return this.context;
    }

    public final void initWebView() {
        if (this.mNgWebView == null) {
            this.mNgWebView = createWebView();
            initJavaScript(getWebView());
            setWebViewClientExt(new FetchDataWebViewClientExt());
            setWebViewClient(new FetchDataWebViewClient(this.containerKey));
            NgWebView ngWebView = this.mNgWebView;
            if (ngWebView != null) {
                ngWebView.setWebChromeClient(new FetchDataWebChromeClient());
            }
        }
    }

    public final void setTransNaCacheDataListener(NaPageDataListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.transNaCacheListener = listener;
    }

    public final void resetWebView() {
        if (FetchDataWebViewKt.DEBUG) {
            Log.d("FetchDataWebView", "resetWebView fetchTransNa=" + this.fetchTransNa);
        }
        if (SearchH5AbManager.isVideoFirstTransOpen()) {
            if (FetchDataWebViewKt.DEBUG) {
                Log.e(MainTransRepoKt.VIDEO_TRANS_TAG, "FetchDataWebView  videoUrlCache清除");
            }
            this.videoUrlCache.clear();
        }
        NgWebView it = this.mNgWebView;
        if (it != null) {
            it.stopLoading();
            WebView currentWebView = it.getCurrentWebView();
            if (currentWebView != null) {
                currentWebView.clearFocus();
            }
            it.setTag(R.id.webview_reuse_tag, true);
            it.loadUrl("about:blank");
            it.getSettings().setBlockNetworkImage(false);
        }
    }

    public final void start(String url, FrameLayout container) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(container, "container");
        if (FetchDataWebViewKt.DEBUG) {
            Log.d("FetchDataWebView", "start url=" + url);
        }
        this.fetchTransNa.reset(url);
        resetWebView();
        this.fetchTransNa.reset(url);
        NgWebView webView = getWebView();
        if (webView != null) {
            BdViewUtils.removeFromParent(webView);
            int height = DeviceUtils.ScreenInfo.getRealScreenHeight(this.context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(DeviceUtils.ScreenInfo.getDisplayWidth(this.context), height);
            layoutParams.topMargin = height * 2;
            container.addView(webView, 0, layoutParams);
            HashMap header = new HashMap();
            header.put(this.KEY_VIDEO_TRANS_BG, "1");
            header.put("clicktime", String.valueOf(System.currentTimeMillis()));
            webView.loadUrl(url, header);
        }
    }

    public final void destroy() {
        JsInjectionDelegate.INSTANCE.unregisterConditionListener(this.containerKey);
        destroyWebView();
    }

    private final void setWebViewClientExt(BdSailorWebViewClientExt client) {
        NgWebView ngWebView = this.mNgWebView;
        if (ngWebView != null) {
            ngWebView.setWebViewClientExt(client);
        }
    }

    private final void setWebViewClient(BdSailorWebViewClient client) {
        NgWebView ngWebView = this.mNgWebView;
        if (ngWebView != null) {
            ngWebView.setWebViewClient(client);
        }
    }

    private final void destroyWebView() {
        Registry.unregisterReceiver(Contract.getDataChannelReceiverHostKey(Contract.HOST_BD_EXPLORE_VIEW, this));
        NgWebView ngWebView = this.mNgWebView;
        if (ngWebView != null && !ngWebView.getWebViewExt().isDestroyedExt()) {
            ngWebView.getCurrentWebView().setOnLongClickListener((View.OnLongClickListener) null);
            ngWebView.setOnCommonEventHandler((NgWebView.OnCommonEventHandler) null);
            ngWebView.setOnWebViewHookHandler((NgWebView.OnWebViewHookHandler) null);
            ngWebView.setPopupWindowListener((BdExplorePopView.BdExplorePopViewListener) null);
            ngWebView.setWebNgClient((WebNgClient) null);
            ngWebView.setWebViewClient((BdSailorWebViewClient) null);
            ngWebView.setWebViewClientExt((BdSailorWebViewClientExt) null);
            ngWebView.setWebChromeClient((BdSailorWebChromeClient) null);
            ngWebView.setWebChromeClientExt((BdSailorWebChromeClientExt) null);
            ngWebView.enableMedia();
            if (FetchDataWebViewKt.DEBUG) {
                Log.d("FetchDataWebView", "destory WebView : " + hashCode());
            }
            try {
                if (!ngWebView.getWebViewExt().isDestroyedExt()) {
                    clear(ngWebView);
                }
            } catch (Exception e2) {
                if (FetchDataWebViewKt.DEBUG) {
                    Log.e("FetchDataWebView", "", e2);
                }
            }
        }
    }

    private final NgWebView createWebView() {
        NgWebView ngWebView = NgWebViewCacheManager.getInstance().obtainNgWebView(this.context, false);
        if (FetchDataWebViewKt.DEBUG) {
            Log.v("FetchDataWebView", "createWebView mNgWebViewId = " + ngWebView.hashCode());
            Log.v("FetchDataWebView", "createWebView isReuse = " + ngWebView.getTag(R.id.webview_reuse_tag));
        }
        if (ngWebView.getTag(R.id.webview_reuse_tag) != null) {
            ngWebView.setLayoutParams(new FrameLayout.LayoutParams(this.context.getResources().getDisplayMetrics().widthPixels, this.context.getResources().getDisplayMetrics().heightPixels));
        }
        ngWebView.setSearchUsed(true);
        ngWebView.getCurrentWebView().setDefaultViewSize(this.context.getResources().getDisplayMetrics().widthPixels, this.context.getResources().getDisplayMetrics().heightPixels);
        ngWebView.getWebViewExt().setNeedImpactScriptExt(false);
        ngWebView.setOnWebViewHookHandler(this);
        if (((SearchBrowserInterface) ServiceManager.getService(SearchBrowserInterface.SERVICE_REFERENCE)).isEnableJsPromptExceptBdWindow()) {
            ngWebView.getSettings().setEnableJsPromptSailor(false);
        }
        Intrinsics.checkNotNullExpressionValue(ngWebView, "ngWebView");
        initSettings(ngWebView);
        ngWebView.disableMedia();
        updateWebViewNightMode(ngWebView, NightModeHelper.getNightModeSwitcherState());
        return ngWebView;
    }

    private final void initSettings(NgWebView ngWebView) {
        BdSailorWebSettings settings = ngWebView.getSettings();
        settings.setWebViewFrameNameSailor("BdWindow");
        settings.setLightTouchEnabled(false);
        settings.setNeedInitialFocus(false);
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setMixedContentMode(((SearchBrowserInterface) ServiceManager.getService(SearchBrowserInterface.SERVICE_REFERENCE)).getMixedContentMode());
        settings.setBuiltInZoomControls(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        NgWebViewUtils.setSailorFeature();
        if (!NgWebViewUtils.isEngineAvailable()) {
            settings.setAllowFileAccess(true);
        }
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAppCacheEnabled(true);
        String databasePath = this.context.getDir("databases", 0).getPath();
        Intrinsics.checkNotNullExpressionValue(databasePath, "context.getDir(BaseWebVi…PP_DATABASE_PATH, 0).path");
        String geolocationDatabasePath = this.context.getDir("geolocation", 0).getPath();
        Intrinsics.checkNotNullExpressionValue(geolocationDatabasePath, "context.getDir(BaseWebView.APP_GEO_PATH, 0).path");
        String appCachePath = this.context.getDir("appcache", 0).getPath();
        Intrinsics.checkNotNullExpressionValue(appCachePath, "context.getDir(BaseWebView.APP_CACHE_PATH, 0).path");
        settings.setGeolocationDatabasePath(geolocationDatabasePath);
        settings.setDatabasePath(databasePath);
        settings.setAppCachePath(appCachePath);
        if (NgWebViewUtils.isEngineAvailable() || SearchABTestUtils.isSearchWebViewSupportMultiWindow()) {
            settings.setSupportMultipleWindows(true);
        } else {
            settings.setSupportMultipleWindows(false);
        }
        ISailorWebSettingsExt settingExt = ngWebView.getSettingsExt();
        settingExt.setPlayVideoInFullScreenModeExt(false);
        settingExt.setPrerenderEnabledExt(true);
        settingExt.setHookH5NavigationEnabled(true);
        BdSailor.getInstance().getSailorSettings().setJavaScriptEnabledOnFileScheme(true);
        checkZeusSettingsMode(settings, ngWebView.getSettingsExt());
        Object systemService = this.context.getSystemService("activity");
        if (systemService != null) {
            if (((ActivityManager) systemService).getMemoryClass() > 16) {
                settings.setPageCacheCapacity(15);
            } else {
                settings.setPageCacheCapacity(1);
            }
            try {
                settings.setPluginState(WebSettings.PluginState.ON_DEMAND);
            } catch (NoClassDefFoundError e2) {
                if (FetchDataWebViewKt.DEBUG) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                if (FetchDataWebViewKt.DEBUG) {
                    e3.printStackTrace();
                }
            }
            if (SearchABTestUtils.isMultiWebViewReuseWebView() && isWebViewStatusReset()) {
                settings.setUserAgentString("");
            }
            String originalUa = settings.getUserAgentString();
            String ua = getUserAgentString(originalUa);
            if (!TextUtils.equals(originalUa, ua)) {
                if (!FetchDataWebViewKt.DEBUG || !SearchDebugConfig.isBaiduUADisabled()) {
                    settings.setUserAgentString(ua);
                }
                if (FetchDataWebViewKt.DEBUG) {
                    Log.i("FetchDataWebView", "set ua:" + ua);
                }
            }
            setFontSettings(ngWebView, false);
            return;
        }
        NgWebView ngWebView2 = ngWebView;
        throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
    }

    public final NgWebView getWebView() {
        return this.mNgWebView;
    }

    private final String getUserAgentString(String originalUa) {
        return BaiduIdentityManager.getInstance(this.context).processUserAgent(originalUa, BrowserType.MAIN);
    }

    private final void checkZeusSettingsMode(BdSailorWebSettings settings, ISailorWebSettingsExt settingsExt) {
        if (settings != null) {
            NgWebViewUtils.applyNoImageMode(this.context, settings);
            NgWebViewUtils.applyFrugalMode(this.context);
            NgWebViewUtils.applyNoAdsMode(this.context, settingsExt);
            NgWebViewUtils.applyCloudProxyMode(this.context);
        }
    }

    private final void setFontSettings(NgWebView ngWebView, boolean zoomSwitch) {
        if (zoomSwitch) {
            ngWebView.getSettings().setTextZoom(100);
            return;
        }
        ngWebView.getSettings().setTextZoom((int) (FontSizeHelper.getScaledSizeH() * ((float) 100)));
    }

    private final void initDispatcher() {
        if (this.mMainDispatcher == null) {
            this.mMainDispatcher = new UnitedSchemeMainDispatcher();
        }
        DataChannelWebSchemeDispatcher dataChannelSchemeDispatcher = new DataChannelWebSchemeDispatcher(new DataChannelWebSchemeCallback(this), Contract.getDataChannelReceiverHostKey(Contract.HOST_BD_EXPLORE_VIEW, this));
        UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = this.mMainDispatcher;
        if (unitedSchemeMainDispatcher != null) {
            unitedSchemeMainDispatcher.setDynamicDispatcher("datachannel", dataChannelSchemeDispatcher);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/baidu/browser/components/videotranscoding/fetchdata/FetchDataWebView$DataChannelWebSchemeCallback;", "Lcom/baidu/searchbox/datachannel/DataChannelWebSchemeDispatcher$OnWebViewCallBackListener;", "fetchDataWebView", "Lcom/baidu/browser/components/videotranscoding/fetchdata/FetchDataWebView;", "(Lcom/baidu/browser/components/videotranscoding/fetchdata/FetchDataWebView;)V", "mSearchWebViewRef", "Ljava/lang/ref/WeakReference;", "evaluateJavascript", "", "js", "", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FetchDataWebView.kt */
    private static final class DataChannelWebSchemeCallback implements DataChannelWebSchemeDispatcher.OnWebViewCallBackListener {
        private final WeakReference<FetchDataWebView> mSearchWebViewRef;

        public DataChannelWebSchemeCallback(FetchDataWebView fetchDataWebView) {
            Intrinsics.checkNotNullParameter(fetchDataWebView, "fetchDataWebView");
            this.mSearchWebViewRef = new WeakReference<>(fetchDataWebView);
        }

        public void evaluateJavascript(String js) {
            FetchDataWebView fetchDataWebView;
            NgWebView webView;
            Intrinsics.checkNotNullParameter(js, "js");
            WeakReference<FetchDataWebView> weakReference = this.mSearchWebViewRef;
            if (weakReference != null && (fetchDataWebView = (FetchDataWebView) weakReference.get()) != null && (webView = fetchDataWebView.getWebView()) != null) {
                webView.evaluateJavascript(js, (ValueCallback<String>) null);
            }
        }
    }

    private final void initJavaScript(NgWebView webView) {
        if (webView != null) {
            webView.addJavascriptInterface(new JsInjectionCommonJsInterface(this.context, this, (CommonJsMessageCallback) null), JsInjectionCommonJsInterface.INTERFACE_NAME);
        }
    }

    private final void clear(NgWebView ngWebView) {
        ngWebView.stopLoading();
        ngWebView.getCurrentWebView().clearFocus();
        ngWebView.clearView();
        ngWebView.clearHistory();
        if (SearchABTestUtils.isMultiWebViewReuseWebView()) {
            resetNgWebView();
            ngWebView.recycleWebView();
            return;
        }
        ngWebView.destroyWithoutCreate();
    }

    private final void resetNgWebView() {
        NgWebView it = this.mNgWebView;
        if (it != null) {
            it.setTag(R.id.webview_reuse_tag, true);
            BdViewUtils.removeFromParent(it);
        }
    }

    private final boolean isWebViewStatusReset() {
        NgWebView ngWebView = this.mNgWebView;
        return (ngWebView != null ? ngWebView.getTag(R.id.webview_reuse_tag) : null) != null;
    }

    public boolean hookCanGoBack(boolean canGoBack) {
        return false;
    }

    public void hookGoBack() {
    }

    public boolean hookCanGoForward(boolean canGoForward) {
        return false;
    }

    public final void updateWebViewNightMode(boolean isNightMode) {
        updateWebViewNightMode(getWebView(), isNightMode);
    }

    private final void updateWebViewNightMode(NgWebView webView, boolean isNightMode) {
        if (webView != null) {
            if (NgWebViewUtils.isEngineAvailable()) {
                ISailorWebSettingsExt settingsExt = webView.getSettingsExt();
                if (settingsExt != null) {
                    settingsExt.setNightModeEnabledExt(isNightMode);
                    return;
                }
                return;
            }
            webView.updateWebViewNightMode(isNightMode);
        }
    }

    public void handleCommonJsMessage(JSONObject message) {
        Intrinsics.checkNotNullParameter(message, "message");
        UiThreadUtils.runOnUiThread(new FetchDataWebView$$ExternalSyntheticLambda0(this, message));
    }

    /* access modifiers changed from: private */
    /* renamed from: handleCommonJsMessage$lambda-2  reason: not valid java name */
    public static final void m12778handleCommonJsMessage$lambda2(FetchDataWebView this$0, JSONObject $message) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($message, "$message");
        NgWebView webView = this$0.getWebView();
        String messageWebUrl = null;
        String url = webView != null ? webView.getCurrentPageUrl() : null;
        if (url != null) {
            if (FetchDataWebViewKt.DEBUG) {
                Log.d(FetchDataWebViewKt.TRANS_TAG, "fetchDataWebView收到js提取数据 url=" + url + " message=" + $message);
            }
            if (!Intrinsics.areEqual((Object) url, (Object) "") && !Intrinsics.areEqual((Object) url, (Object) "about:blank")) {
                if ($message.has(VideoTransUtilKt.JS_LIST_DATA_KEY)) {
                    JSONObject optJSONObject = $message.optJSONObject(VideoTransUtilKt.JS_LIST_DATA_KEY);
                    if (optJSONObject != null) {
                        messageWebUrl = optJSONObject.optString(SwanAppErrorPageParam.KEY_SWAN_WEB_URL);
                    }
                } else if ($message.has(VideoTransUtilKt.JS_PLAY_DATA_KEY)) {
                    JSONObject optJSONObject2 = $message.optJSONObject(VideoTransUtilKt.JS_PLAY_DATA_KEY);
                    if (optJSONObject2 != null) {
                        messageWebUrl = optJSONObject2.optString(SwanAppErrorPageParam.KEY_SWAN_WEB_URL);
                    }
                } else {
                    messageWebUrl = $message.optString(SwanAppErrorPageParam.KEY_SWAN_WEB_URL);
                }
                if (Intrinsics.areEqual((Object) url, (Object) messageWebUrl) || Intrinsics.areEqual((Object) messageWebUrl, (Object) "")) {
                    NaPageDataListener naPageDataListener = this$0.transNaCacheListener;
                    if (naPageDataListener != null) {
                        naPageDataListener.uploadJsData(url);
                    }
                    String originalPageUrl = this$0.fetchTransNa.getPageUrl();
                    if (originalPageUrl != null) {
                        if (Intrinsics.areEqual((Object) originalPageUrl, (Object) url) || VideoTransUtilKt.pathEquals(url, originalPageUrl)) {
                            this$0.fetchTransNa.setSerialAndTitle($message);
                            this$0.uploadJsData($message, originalPageUrl, url);
                        }
                    }
                }
            }
        }
    }

    private final void uploadJsData(JSONObject message, String originalPageUrl, String url) {
        CharSequence charSequence = originalPageUrl;
        boolean z = false;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            CharSequence charSequence2 = url;
            if (!(charSequence2 == null || StringsKt.isBlank(charSequence2))) {
                boolean isDetailData = VideoTransUtilKt.getTransDataType(message) == 0;
                boolean isNewVersionJs = Intrinsics.areEqual((Object) message.optString(VideoTransUtilKt.DETAIL_TRANS_NO_WAIT_JS_VERSION), (Object) "1");
                JSONObject jSONObject = null;
                if (!SearchH5AbManager.INSTANCE.searchTransDetailNoWait() || !isDetailData || !isNewVersionJs) {
                    String playUrl = this.fetchTransNa.getPlayUrl();
                    if (playUrl != null && (!StringsKt.isBlank(playUrl))) {
                        z = true;
                    }
                    if (z) {
                        FetchTransNa fetchTransNa2 = this.fetchTransNa;
                        NaPageDataListener naPageDataListener = this.transNaCacheListener;
                        if (naPageDataListener != null) {
                            jSONObject = naPageDataListener.getNaPageCacheData(url);
                        }
                        if (fetchTransNa2.uploadTransNaData(originalPageUrl, url, jSONObject)) {
                            this.videoUrlCache.put(url + "-upload_data", "1");
                            resetWebView();
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (FetchDataWebViewKt.DEBUG) {
                    Log.d(FetchDataWebViewKt.TRANS_TAG, "FetchDataWebView js提取数据只有列表页数据，触发上传");
                }
                FetchTransNa fetchTransNa3 = this.fetchTransNa;
                NaPageDataListener naPageDataListener2 = this.transNaCacheListener;
                if (naPageDataListener2 != null) {
                    jSONObject = naPageDataListener2.getNaPageCacheData(url);
                }
                if (fetchTransNa3.uploadTransNaData(originalPageUrl, url, jSONObject)) {
                    this.videoUrlCache.put(url + "-upload_data", "1");
                    resetWebView();
                }
            }
        }
    }

    public final void uploadTransData() {
        String originalPageUrl;
        NgWebView webView = getWebView();
        JSONObject jSONObject = null;
        String url = webView != null ? webView.getCurrentPageUrl() : null;
        if (url != null && (originalPageUrl = this.fetchTransNa.getPageUrl()) != null) {
            if (Intrinsics.areEqual((Object) originalPageUrl, (Object) url) || VideoTransUtilKt.pathEquals(url, originalPageUrl)) {
                CharSequence charSequence = this.videoUrlCache.get(url + "-upload_data");
                if (charSequence == null || StringsKt.isBlank(charSequence)) {
                    FetchTransNa fetchTransNa2 = this.fetchTransNa;
                    NaPageDataListener naPageDataListener = this.transNaCacheListener;
                    if (naPageDataListener != null) {
                        jSONObject = naPageDataListener.getNaPageCacheData(url);
                    }
                    fetchTransNa2.uploadTransNaData(originalPageUrl, url, jSONObject);
                    this.videoUrlCache.put(url + "-upload_data", "1");
                    resetWebView();
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/baidu/browser/components/videotranscoding/fetchdata/FetchDataWebView$FetchDataWebChromeClient;", "Lcom/baidu/browser/sailor/BdSailorWebChromeClient;", "(Lcom/baidu/browser/components/videotranscoding/fetchdata/FetchDataWebView;)V", "onReceivedTitle", "", "view", "Lcom/baidu/browser/sailor/BdSailorWebView;", "title", "", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FetchDataWebView.kt */
    public final class FetchDataWebChromeClient extends BdSailorWebChromeClient {
        public FetchDataWebChromeClient() {
        }

        public void onReceivedTitle(BdSailorWebView view2, String title) {
            super.onReceivedTitle(view2, title);
            FetchDataWebView.this.fetchTransNa.setMainDocTitle(title);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/browser/components/videotranscoding/fetchdata/FetchDataWebView$FetchDataWebViewClientExt;", "Lcom/baidu/browser/sailor/BdSailorWebViewClientExt;", "(Lcom/baidu/browser/components/videotranscoding/fetchdata/FetchDataWebView;)V", "onNotifyVideoInfo", "", "videoSniffingInfo", "Lcom/baidu/webkit/sdk/VideoSniffingInfo;", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FetchDataWebView.kt */
    public final class FetchDataWebViewClientExt extends BdSailorWebViewClientExt {
        public FetchDataWebViewClientExt() {
        }

        public void onNotifyVideoInfo(VideoSniffingInfo videoSniffingInfo) {
            String pageUrl;
            String videoUrl;
            String originalPageUrl;
            if (videoSniffingInfo != null && (pageUrl = videoSniffingInfo.getPageUrl()) != null && (videoUrl = videoSniffingInfo.getSourceUrl()) != null) {
                NgWebView it = FetchDataWebView.this.mNgWebView;
                JSONObject jSONObject = null;
                if (it != null) {
                    it.evaluateJavascript("window._appInjectVar = window._appInjectVar || {};window._appInjectVar.isSearchTransPlayPage = " + (!StringsKt.isBlank(videoUrl)) + ';', (ValueCallback<String>) null);
                }
                if (FetchDataWebViewKt.DEBUG) {
                    Log.d(FetchDataWebViewKt.TRANS_TAG, "fetchDataWebView嗅探执行，videoUrl=" + videoUrl);
                }
                if (FetchDataWebViewKt.DEBUG) {
                    Log.d("FetchDataWebView", "onNotifyVideoInfo videoUrl=" + videoUrl + " pageUrl=" + pageUrl + " pageTitle=" + videoSniffingInfo.getPageTitle());
                }
                if (StringsKt.startsWith$default(videoUrl, "http", false, 2, (Object) null)) {
                    NgWebView webView = FetchDataWebView.this.getWebView();
                    String currentUrl = webView != null ? webView.getCurrentPageUrl() : null;
                    if (!Intrinsics.areEqual((Object) currentUrl, (Object) pageUrl) || Intrinsics.areEqual((Object) currentUrl, (Object) "") || Intrinsics.areEqual((Object) currentUrl, (Object) "about:blank") || FetchDataWebView.this.fetchTransNa.getPlayUrl() != null || (originalPageUrl = FetchDataWebView.this.fetchTransNa.getPageUrl()) == null) {
                        return;
                    }
                    if (Intrinsics.areEqual((Object) originalPageUrl, (Object) pageUrl) || VideoTransUtilKt.pathEquals(pageUrl, originalPageUrl)) {
                        FetchDataWebView.this.fetchTransNa.setPlayUrl(videoUrl);
                        FetchDataWebView.this.fetchTransNa.setVideoPoster(videoSniffingInfo.getPosterImageUrl());
                        FetchDataWebView.this.fetchTransNa.setMainDocTitle(videoSniffingInfo.getPageTitle());
                        FetchTransNa access$getFetchTransNa$p = FetchDataWebView.this.fetchTransNa;
                        NaPageDataListener access$getTransNaCacheListener$p = FetchDataWebView.this.transNaCacheListener;
                        if (access$getTransNaCacheListener$p != null) {
                            jSONObject = access$getTransNaCacheListener$p.getNaPageCacheData(pageUrl);
                        }
                        if (access$getFetchTransNa$p.uploadTransNaData(originalPageUrl, pageUrl, jSONObject)) {
                            FetchDataWebView.this.videoUrlCache.put(pageUrl + "-upload_data", "1");
                            FetchDataWebView.this.resetWebView();
                        }
                    }
                }
            }
        }
    }
}
