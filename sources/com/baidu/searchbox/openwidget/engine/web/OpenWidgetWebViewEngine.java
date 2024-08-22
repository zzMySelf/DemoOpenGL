package com.baidu.searchbox.openwidget.engine.web;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.webkit.ValueCallback;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.browser.sailor.BdSailorWebSettings;
import com.baidu.browser.sailor.BdSailorWebViewClient;
import com.baidu.browser.sailor.BdSailorWebViewClientExt;
import com.baidu.browser.sailor.ISailorWebSettingsExt;
import com.baidu.browser.sailor.ISailorWebViewExt;
import com.baidu.search.simplewebview.SimpleNgWebViewFactory;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.datachannel.DataChannelWebSchemeDispatcher;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.ng.browser.NgWebView;
import com.baidu.searchbox.ng.browser.init.BlinkInitHelper;
import com.baidu.searchbox.ng.browser.util.NgWebViewUtils;
import com.baidu.searchbox.openwidget.config.AbtestConfig;
import com.baidu.searchbox.openwidget.config.CommonConfig;
import com.baidu.searchbox.openwidget.config.RenderConfig;
import com.baidu.searchbox.openwidget.engine.CallbackByDataChannel;
import com.baidu.searchbox.openwidget.engine.IOpenWidgetEngine;
import com.baidu.searchbox.openwidget.engine.OpenWidgetEngineCallback;
import com.baidu.searchbox.openwidget.engine.OpenWidgetEngineCallbackKt;
import com.baidu.searchbox.openwidget.engine.OpenWidgetLoadTracer;
import com.baidu.searchbox.openwidget.engine.web.cookie.OpenWidgetCookieUtils;
import com.baidu.searchbox.openwidget.model.OpenWidgetExtsKt;
import com.baidu.searchbox.openwidget.model.OpenWidgetInstance;
import com.baidu.searchbox.openwidget.model.OpenWidgetSize;
import com.baidu.searchbox.openwidget.utils.OpenWidgetProcess;
import com.baidu.searchbox.openwidget.utils.PrimitivesKt;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.webkit.sdk.WebView;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001)B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\nH\u0003J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\nH\u0002J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0017J\u0018\u0010 \u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0003J \u0010!\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\nH\u0002J\b\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u0014H\u0016J\u0010\u0010&\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\nH\u0002J\u0016\u0010'\u001a\u00020\u00142\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00140(H\u0003R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/baidu/searchbox/openwidget/engine/web/OpenWidgetWebViewEngine;", "Lcom/baidu/searchbox/openwidget/engine/IOpenWidgetEngine;", "context", "Landroid/content/Context;", "tracer", "Lcom/baidu/searchbox/openwidget/engine/OpenWidgetLoadTracer;", "(Landroid/content/Context;Lcom/baidu/searchbox/openwidget/engine/OpenWidgetLoadTracer;)V", "callbackByDataChannel", "Lcom/baidu/searchbox/openwidget/engine/CallbackByDataChannel;", "currWebView", "Lcom/baidu/searchbox/ng/browser/NgWebView;", "dataChannelHost", "", "dispatcher", "Lcom/baidu/searchbox/unitedscheme/UnitedSchemeMainDispatcher;", "getDispatcher", "()Lcom/baidu/searchbox/unitedscheme/UnitedSchemeMainDispatcher;", "dispatcher$delegate", "Lkotlin/Lazy;", "close", "", "initSettings", "webView", "initSettingsExt", "initWebViewSize", "size", "Lcom/baidu/searchbox/openwidget/model/OpenWidgetSize;", "load", "widget", "Lcom/baidu/searchbox/openwidget/model/OpenWidgetInstance;", "callback", "Lcom/baidu/searchbox/openwidget/engine/OpenWidgetEngineCallback;", "onCreateWebView", "onCreateWebViewClient", "Lcom/baidu/browser/sailor/BdSailorWebViewClient;", "onCreateWebViewClientExt", "Lcom/baidu/browser/sailor/BdSailorWebViewClientExt;", "prepare", "setKernelOptions", "syncCookieAsync", "Lkotlin/Function0;", "OnWebViewCallbackImpl", "lib-openwidget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@OpenWidgetProcess
/* compiled from: OpenWidgetWebViewEngine.kt */
public final class OpenWidgetWebViewEngine implements IOpenWidgetEngine {
    private CallbackByDataChannel callbackByDataChannel;
    private final Context context;
    /* access modifiers changed from: private */
    public NgWebView currWebView;
    /* access modifiers changed from: private */
    public final String dataChannelHost = ("OpenWidgetWebViewEngine@" + OpenWidgetWebViewEngineKt.HOST_ID_GEN.incrementAndGet());
    private final Lazy dispatcher$delegate = LazyKt.lazy(new OpenWidgetWebViewEngine$dispatcher$2(this));
    /* access modifiers changed from: private */
    public final OpenWidgetLoadTracer tracer;

    public OpenWidgetWebViewEngine(Context context2, OpenWidgetLoadTracer tracer2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(tracer2, "tracer");
        this.context = context2;
        this.tracer = tracer2;
    }

    private final UnitedSchemeMainDispatcher getDispatcher() {
        return (UnitedSchemeMainDispatcher) this.dispatcher$delegate.getValue();
    }

    public void prepare() {
        if (CommonConfig.INSTANCE.getInitAsync() && !BlinkInitHelper.getInstance(this.context).isBWebkitInited()) {
            BlinkInitHelper.getInstance(this.context).initBWebkit();
        }
    }

    public void load(OpenWidgetInstance widget, OpenWidgetEngineCallback callback) {
        Intrinsics.checkNotNullParameter(widget, "widget");
        Intrinsics.checkNotNullParameter(callback, "callback");
        OpenWidgetEngineCallback wrapCallback = OpenWidgetEngineCallbackKt.callExactlyOnce(callback);
        this.tracer.traceEvent(WebViewEngineTraceEventsKt.EV_ON_CREATE_WEB_VIEW);
        NgWebView $this$load_u24lambda_u2d0 = this.currWebView;
        if ($this$load_u24lambda_u2d0 == null) {
            $this$load_u24lambda_u2d0 = onCreateWebView(widget, wrapCallback);
            this.currWebView = $this$load_u24lambda_u2d0;
        }
        NgWebView webView = $this$load_u24lambda_u2d0;
        if (this.callbackByDataChannel == null) {
            this.callbackByDataChannel = new CallbackByDataChannel(widget, this.dataChannelHost, webView, wrapCallback, this.tracer);
        }
        if (CommonConfig.INSTANCE.getSyncCookiesAsync()) {
            syncCookieAsync(new OpenWidgetWebViewEngine$load$1(this, webView, widget));
            return;
        }
        if (OpenWidgetWebViewEngineKt.DEBUG) {
            Log.d("WidgetWebViewEngine", "start sync cookie");
        }
        OpenWidgetCookieUtils openWidgetCookieUtils = OpenWidgetCookieUtils.INSTANCE;
        Context appContext = AppRuntime.getAppContext();
        Intrinsics.checkNotNullExpressionValue(appContext, "getAppContext()");
        openWidgetCookieUtils.syncCookieAnyProcess(appContext);
        if (OpenWidgetWebViewEngineKt.DEBUG) {
            Log.d("WidgetWebViewEngine", "finish sync cookie");
        }
        this.tracer.traceEvent(WebViewEngineTraceEventsKt.EV_LOAD_URL);
        webView.loadUrl(OpenWidgetExtsKt.getRenderPageUrl(widget));
    }

    private final void syncCookieAsync(Function0<Unit> callback) {
        ExecutorUtilsExt.postOnElastic(new OpenWidgetWebViewEngine$$ExternalSyntheticLambda0(callback), "openwidget_sync_cookie", 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: syncCookieAsync$lambda-2  reason: not valid java name */
    public static final void m1807syncCookieAsync$lambda2(Function0 $callback) {
        Intrinsics.checkNotNullParameter($callback, "$callback");
        if (OpenWidgetWebViewEngineKt.DEBUG) {
            Log.d("WidgetWebViewEngine", "start sync cookie async " + Thread.currentThread().getName());
        }
        OpenWidgetCookieUtils openWidgetCookieUtils = OpenWidgetCookieUtils.INSTANCE;
        Context appContext = AppRuntime.getAppContext();
        Intrinsics.checkNotNullExpressionValue(appContext, "getAppContext()");
        openWidgetCookieUtils.syncCookieAnyProcess(appContext);
        if (OpenWidgetWebViewEngineKt.DEBUG) {
            Log.d("WidgetWebViewEngine", "finish sync cookie async " + Thread.currentThread().getName());
        }
        UiThreadUtils.runOnUiThread(new OpenWidgetWebViewEngine$$ExternalSyntheticLambda1($callback));
    }

    /* access modifiers changed from: private */
    /* renamed from: syncCookieAsync$lambda-2$lambda-1  reason: not valid java name */
    public static final void m1808syncCookieAsync$lambda2$lambda1(Function0 $tmp0) {
        Intrinsics.checkNotNullParameter($tmp0, "$tmp0");
        $tmp0.invoke();
    }

    private final NgWebView onCreateWebView(OpenWidgetInstance widget, OpenWidgetEngineCallback callback) {
        if (OpenWidgetWebViewEngineKt.DEBUG) {
            Context context2 = this.context;
            Context baseContext = null;
            ContextWrapper contextWrapper = context2 instanceof ContextWrapper ? (ContextWrapper) context2 : null;
            if (contextWrapper != null) {
                baseContext = contextWrapper.getBaseContext();
            }
            Log.d("WidgetWebViewEngine", "onCreateWebView, context=" + this.context + ", baseContext=" + baseContext);
        }
        if (OpenWidgetWebViewEngineKt.DEBUG) {
            Log.d("WidgetWebViewEngine", "start init kernel before onCreateWebView");
        }
        BlinkInitHelper.getInstance(this.context).initBWebkit();
        if (OpenWidgetWebViewEngineKt.DEBUG) {
            Log.d("WidgetWebViewEngine", "end init kernel before onCreateWebView");
        }
        NgWebView ngWebView = new NgWebView(this.context);
        NgWebView $this$onCreateWebView_u24lambda_u2d4 = ngWebView;
        SimpleNgWebViewFactory.initSimpleWebView($this$onCreateWebView_u24lambda_u2d4.getContext(), $this$onCreateWebView_u24lambda_u2d4, "");
        setKernelOptions($this$onCreateWebView_u24lambda_u2d4);
        WebView $this$onCreateWebView_u24lambda_u2d4_u24lambda_u2d3 = $this$onCreateWebView_u24lambda_u2d4.getCurrentWebView();
        if ($this$onCreateWebView_u24lambda_u2d4_u24lambda_u2d3 != null) {
            Intrinsics.checkNotNullExpressionValue($this$onCreateWebView_u24lambda_u2d4_u24lambda_u2d3, "currentWebView");
            $this$onCreateWebView_u24lambda_u2d4_u24lambda_u2d3.setLongClickable(false);
            $this$onCreateWebView_u24lambda_u2d4_u24lambda_u2d3.setBackgroundColor(0);
            Drawable background = $this$onCreateWebView_u24lambda_u2d4_u24lambda_u2d3.getBackground();
            if (background != null) {
                background.setAlpha(0);
            }
        }
        ISailorWebViewExt webViewExt = $this$onCreateWebView_u24lambda_u2d4.getWebViewExt();
        if (webViewExt != null) {
            webViewExt.setNeedImpactScriptExt(false);
        }
        $this$onCreateWebView_u24lambda_u2d4.setWebChromeClient(new WidgetWebChromeClient(this.tracer));
        $this$onCreateWebView_u24lambda_u2d4.setWebViewClient(onCreateWebViewClient(widget, callback, $this$onCreateWebView_u24lambda_u2d4));
        $this$onCreateWebView_u24lambda_u2d4.setWebViewClientExt(onCreateWebViewClientExt());
        initWebViewSize($this$onCreateWebView_u24lambda_u2d4, OpenWidgetExtsKt.getSize(widget.getInfo()));
        return ngWebView;
    }

    private final void setKernelOptions(NgWebView webView) {
        BdSailorWebSettings.setNavigationInterceptionEnable(true);
        initSettings(webView);
        initSettingsExt(webView);
        webView.setOverScrollMode(2);
    }

    private final void initSettings(NgWebView webView) {
        BdSailorWebSettings $this$initSettings_u24lambda_u2d5 = webView.getSettings();
        $this$initSettings_u24lambda_u2d5.setNeedInitialFocus(false);
        $this$initSettings_u24lambda_u2d5.setMixedContentMode(NgWebViewUtils.getMixedContentMode());
        $this$initSettings_u24lambda_u2d5.setJavaScriptEnabled(true);
        $this$initSettings_u24lambda_u2d5.setLoadsImagesAutomatically(true);
        $this$initSettings_u24lambda_u2d5.setTextZoom(100);
        $this$initSettings_u24lambda_u2d5.setSupportZoom(false);
        $this$initSettings_u24lambda_u2d5.setBuiltInZoomControls(false);
        $this$initSettings_u24lambda_u2d5.setMediaPlaybackRequiresUserGesture(true);
        $this$initSettings_u24lambda_u2d5.setSupportMultipleWindows(false);
        $this$initSettings_u24lambda_u2d5.setPageCacheCapacity(1);
        this.tracer.traceCustom(OpenWidgetLoadTracer.INFO_BLOCK_IMAGE, Integer.valueOf(PrimitivesKt.toInt($this$initSettings_u24lambda_u2d5.getBlockNetworkImage())));
        if (AbtestConfig.INSTANCE.getDisableBlockImage()) {
            $this$initSettings_u24lambda_u2d5.setBlockNetworkImage(false);
        }
    }

    private final void initSettingsExt(NgWebView webView) {
        ISailorWebSettingsExt $this$initSettingsExt_u24lambda_u2d6 = webView.getSettingsExt();
        $this$initSettingsExt_u24lambda_u2d6.setEnableLPLoadingAnimation(false);
        $this$initSettingsExt_u24lambda_u2d6.setEnableLoadingAnimation(false);
        $this$initSettingsExt_u24lambda_u2d6.setAdBlockEnabledExt(false);
        $this$initSettingsExt_u24lambda_u2d6.setPrerenderEnabledExt(false);
    }

    private final void initWebViewSize(NgWebView webView, OpenWidgetSize size) {
        int width = OpenWidgetWebViewEngineKt.getEngineViewWidth(size);
        int height = OpenWidgetWebViewEngineKt.getEngineViewHeight(size);
        NgWebView $this$initWebViewSize_u24lambda_u2d7 = webView;
        $this$initWebViewSize_u24lambda_u2d7.measure(View.MeasureSpec.makeMeasureSpec(width, 1073741824), View.MeasureSpec.makeMeasureSpec(height, 1073741824));
        $this$initWebViewSize_u24lambda_u2d7.layout(0, 0, width, height);
        WebView currentWebView = $this$initWebViewSize_u24lambda_u2d7.getCurrentWebView();
        if (currentWebView != null) {
            currentWebView.setDefaultViewSize(width, height);
        }
    }

    private final BdSailorWebViewClient onCreateWebViewClient(OpenWidgetInstance widget, OpenWidgetEngineCallback callback, NgWebView webView) {
        Map it = CommonConfig.INSTANCE.getRenderConfigs();
        RenderConfig renderConfig = it.get(Long.valueOf(widget.getInfo().getOpenWidgetId()));
        if (renderConfig == null && (renderConfig = it.get(0L)) == null) {
            renderConfig = RenderConfig.Companion.getDEFAULT();
        }
        return new WidgetWebViewClient(renderConfig, callback, webView, getDispatcher(), this.tracer);
    }

    private final BdSailorWebViewClientExt onCreateWebViewClientExt() {
        return new WidgetWebViewClientExt(this.tracer);
    }

    public void close() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            OpenWidgetWebViewEngine $this$close_u24lambda_u2d9 = this;
            CallbackByDataChannel callbackByDataChannel2 = $this$close_u24lambda_u2d9.callbackByDataChannel;
            if (callbackByDataChannel2 != null) {
                callbackByDataChannel2.release();
            }
            NgWebView ngWebView = $this$close_u24lambda_u2d9.currWebView;
            if (ngWebView != null) {
                ngWebView.onPause();
            }
            NgWebView ngWebView2 = $this$close_u24lambda_u2d9.currWebView;
            if (ngWebView2 != null) {
                ngWebView2.destroy();
            }
            $this$close_u24lambda_u2d9.currWebView = null;
            obj = Result.m8971constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m8978isSuccessimpl(obj)) {
            Unit unit = (Unit) obj;
            if (OpenWidgetWebViewEngineKt.DEBUG) {
                Log.d("WidgetWebViewEngine", "release engine success");
            }
        }
        Throwable it = Result.m8974exceptionOrNullimpl(obj);
        if (it != null && OpenWidgetWebViewEngineKt.DEBUG) {
            Log.d("WidgetWebViewEngine", "release engine failed: " + it);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/openwidget/engine/web/OpenWidgetWebViewEngine$OnWebViewCallbackImpl;", "Lcom/baidu/searchbox/datachannel/DataChannelWebSchemeDispatcher$OnWebViewCallBackListener;", "engine", "Lcom/baidu/searchbox/openwidget/engine/web/OpenWidgetWebViewEngine;", "(Lcom/baidu/searchbox/openwidget/engine/web/OpenWidgetWebViewEngine;)V", "engineWeakRef", "Ljava/lang/ref/WeakReference;", "evaluateJavascript", "", "js", "", "lib-openwidget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: OpenWidgetWebViewEngine.kt */
    private static final class OnWebViewCallbackImpl implements DataChannelWebSchemeDispatcher.OnWebViewCallBackListener {
        private final WeakReference<OpenWidgetWebViewEngine> engineWeakRef;

        public OnWebViewCallbackImpl(OpenWidgetWebViewEngine engine) {
            Intrinsics.checkNotNullParameter(engine, "engine");
            this.engineWeakRef = new WeakReference<>(engine);
        }

        public void evaluateJavascript(String js) {
            NgWebView access$getCurrWebView$p;
            Intrinsics.checkNotNullParameter(js, "js");
            OpenWidgetWebViewEngine openWidgetWebViewEngine = (OpenWidgetWebViewEngine) this.engineWeakRef.get();
            if (openWidgetWebViewEngine != null && (access$getCurrWebView$p = openWidgetWebViewEngine.currWebView) != null) {
                access$getCurrWebView$p.evaluateJavascript(js, (ValueCallback<String>) null);
            }
        }
    }
}
