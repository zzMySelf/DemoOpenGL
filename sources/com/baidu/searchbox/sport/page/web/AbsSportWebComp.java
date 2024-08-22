package com.baidu.searchbox.sport.page.web;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.browser.sailor.BdSailorWebChromeClient;
import com.baidu.browser.sailor.BdSailorWebSettings;
import com.baidu.browser.sailor.BdSailorWebViewClient;
import com.baidu.browser.sailor.BdSailorWebViewClientExt;
import com.baidu.browser.sailor.ISailorWebSettingsExt;
import com.baidu.browser.sailor.ISailorWebViewExt;
import com.baidu.search.simplewebview.SimpleNgWebViewFactory;
import com.baidu.searchbox.common.security.JsInterfaceLogger;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.datachannel.DataChannelWebSchemeDispatcher;
import com.baidu.searchbox.datachannel.Registry;
import com.baidu.searchbox.lightbrowser.jsbridge.SearchBoxJsBridge;
import com.baidu.searchbox.lightbrowser.listener.CloseWindowListener;
import com.baidu.searchbox.nacomp.extension.fontsize.FontSizeInfo;
import com.baidu.searchbox.nacomp.extension.fontsize.IFontSize;
import com.baidu.searchbox.nacomp.extension.nightmode.INightMode;
import com.baidu.searchbox.nacomp.mvvm.impl.MasterComponent;
import com.baidu.searchbox.ng.browser.NgWebView;
import com.baidu.searchbox.ng.browser.inject.GoBackJSInterface;
import com.baidu.searchbox.ng.browser.util.NgWebViewUtils;
import com.baidu.searchbox.ng.browser.util.WeakNetworkManager;
import com.baidu.searchbox.ng.errorview.ErrorViewManager;
import com.baidu.searchbox.ng.errorview.ErrorViewUbcHelper;
import com.baidu.searchbox.ng.errorview.view.BdBaseErrorView;
import com.baidu.searchbox.ng.errorview.view.IBdErrorView;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.sport.R;
import com.baidu.searchbox.sport.page.base.ITabComponent;
import com.baidu.searchbox.sport.page.web.AbsSportWebViewModel;
import com.baidu.searchbox.sport.runtime.SportRuntime;
import com.baidu.searchbox.sport.utils.SportUIUtils;
import com.baidu.searchbox.sport.widget.nestedscroll.NestedScrollWebView2;
import com.baidu.searchbox.ui.BdShimmerView;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public abstract class AbsSportWebComp<VM extends AbsSportWebViewModel> extends MasterComponent<VM> implements INightMode, ITabComponent, IFontSize {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final AtomicLong HOST_ID_GEN = new AtomicLong(0);
    private static final String TAG = "SportWebComp";
    private int bottomPadding = getBottomBarHeight();
    private final String dataChannelHost = makeDataChannelHost();
    private IBdErrorView errorView;
    private FrameLayout loadingParent;
    private BdShimmerView loadingView;
    private UnitedSchemeMainDispatcher mainDispatcher;
    private final JsInterfaceLogger.ReusableLogContext reusableLogContext = new JsInterfaceLogger.ReusableLogContext() {
        public String getHost() {
            return AbsSportWebComp.this.getWebCompName();
        }

        public String getUrl() {
            VM vm = (AbsSportWebViewModel) AbsSportWebComp.this.getViewModel();
            return (vm == null || vm.webUrl.getValue() == null) ? "" : vm.webUrl.getValue();
        }
    };
    private NgWebView webView;

    /* access modifiers changed from: protected */
    public abstract boolean handleGoBack();

    /* access modifiers changed from: protected */
    public abstract NgWebView onFindWebView(View view2);

    public AbsSportWebComp(View view2) {
        super(view2, true);
        NgWebView onFindWebView = onFindWebView(view2);
        this.webView = onFindWebView;
        onFindWebView.setPadding(0, 0, 0, this.bottomPadding);
        if (getWebView() != null) {
            onInitWebView(getWebView());
        }
    }

    /* access modifiers changed from: protected */
    public int getBottomBarHeight() {
        return SportUIUtils.getScaledBottomBarH();
    }

    public void onCreateView(View view2) {
    }

    public void onCreate() {
        super.onCreate();
        onNightModeChange(NightModeHelper.getNightModeSwitcherState());
        onFontSizeChange(FontSizeInfo.Companion.getInfo());
    }

    /* access modifiers changed from: protected */
    public String getWebCompName() {
        return "SportContainer";
    }

    public NgWebView getWebView() {
        return this.webView;
    }

    /* access modifiers changed from: protected */
    public BdSailorWebViewClient onCreateWebViewClient() {
        return new SportWebViewClient((AbsSportWebViewModel) getViewModel(), getWebView(), getSchemeMainDispatcher());
    }

    /* access modifiers changed from: protected */
    public BdSailorWebViewClientExt onCreateWebViewClientExt() {
        return new BdSailorWebViewClientExt();
    }

    /* access modifiers changed from: protected */
    public void onInitWebView(NgWebView webView2) {
        SimpleNgWebViewFactory.initSimpleWebView(getContext(), webView2, getWebViewUAExt());
        setKernelOpt(webView2);
        webView2.getCurrentWebView().setLongClickable(false);
        webView2.getWebViewExt().setNeedImpactScriptExt(false);
        webView2.setWebChromeClient(new BdSailorWebChromeClient());
        webView2.setWebViewClient(onCreateWebViewClient());
        webView2.setWebViewClientExt(onCreateWebViewClientExt());
        setupJavaScriptInterface(webView2);
    }

    private String makeDataChannelHost() {
        return "SportWebView@" + HOST_ID_GEN.incrementAndGet();
    }

    /* access modifiers changed from: protected */
    public UnitedSchemeMainDispatcher getSchemeMainDispatcher() {
        if (this.mainDispatcher == null) {
            this.mainDispatcher = new UnitedSchemeMainDispatcher();
            if (DEBUG) {
                Log.d(TAG, "注册DataChannel分发器，host = " + this.dataChannelHost);
            }
            this.mainDispatcher.setDynamicDispatcher("datachannel", new DataChannelWebSchemeDispatcher(new OnWebViewCallbackImpl(this), this.dataChannelHost));
        }
        return this.mainDispatcher;
    }

    /* access modifiers changed from: protected */
    public String getWebViewUAExt() {
        return "";
    }

    private void setKernelOpt(NgWebView webView2) {
        ISailorWebSettingsExt settingsExt = webView2.getSettingsExt();
        settingsExt.setEnableLPLoadingAnimation(false);
        settingsExt.setEnableLoadingAnimation(false);
        BdSailorWebSettings.setNavigationInterceptionEnable(true);
        webView2.getSettings().setMixedContentMode(SportRuntime.getContext().getMixedContentMode());
    }

    /* access modifiers changed from: protected */
    public void setupJavaScriptInterface(NgWebView webView2) {
        SportRuntime.getContext().addJavaScriptInterface(getContext(), webView2, this.reusableLogContext, new CloseWindowListener() {
            public void doCloseWindow() {
                AbsSportWebComp.this.handleGoBack();
            }
        });
        webView2.addJavascriptInterface(new SearchBoxJsBridge(getContext(), getSchemeMainDispatcher(), new CallbackHandlerDelegate(getWebView()), webView2).setReuseLogContext(this.reusableLogContext), "Bdbox_android_jsbridge");
        webView2.addJavascriptInterface(new GoBackJSInterface(new GoBackJSInterface.OnGoBackJsCallback() {
            public void onJsGoBack() {
                UiThreadUtil.getMainHandler().post(new Runnable() {
                    public void run() {
                        AbsSportWebComp.this.handleGoBack();
                    }
                });
            }
        }).setReuseLogContext(this.reusableLogContext), GoBackJSInterface.GO_BACK_JS_INTERFACE_NAME);
    }

    /* access modifiers changed from: protected */
    public void setTextZoom(int textZoom) {
        if (textZoom > 0) {
            getWebView().getSettings().setTextZoom(textZoom);
        }
    }

    /* access modifiers changed from: private */
    public void hideErrorView() {
        ViewGroup parent;
        IBdErrorView iBdErrorView = this.errorView;
        if (iBdErrorView != null) {
            View view2 = iBdErrorView.getView();
            if (!(view2 == null || (parent = (ViewGroup) view2.getParent()) == null)) {
                parent.removeView(view2);
            }
            this.errorView.onDestroy();
            this.errorView = null;
        }
    }

    private IBdErrorView createErrorView(WebViewLoadState loadState) {
        final IBdErrorView errorView2;
        if (loadState.hasError() || !WeakNetworkManager.isWeakNetwork()) {
            errorView2 = ErrorViewManager.createErrorView(loadState.errorCode, loadState.httpErrorCode, getContext());
        } else {
            errorView2 = ErrorViewManager.createWeakNetworkErrorView(getContext());
        }
        errorView2.updateUIForNight(NightModeHelper.getNightModeSwitcherState());
        if (errorView2 instanceof BdBaseErrorView) {
            ((BdBaseErrorView) errorView2).setEventListener(new BdBaseErrorView.BdErrorViewListener() {
                public void onLinkTextClick() {
                    ErrorViewUbcHelper.linkTextClick(errorView2);
                }

                public void onErrorPageRefresh() {
                    ((AbsSportWebViewModel) AbsSportWebComp.this.getViewModel()).tryReload();
                    ErrorViewUbcHelper.reloadClick(errorView2);
                }
            });
        }
        return errorView2;
    }

    /* access modifiers changed from: private */
    public void showErrorView(WebViewLoadState loadState) {
        if (this.errorView == null) {
            this.errorView = createErrorView(loadState);
            this.webView.hideEmbeddedTitleBar(false);
            this.webView.updateEmbeddedTitleBar(true, false, false);
            this.webView.lockEmbeddedTitlebar(true);
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-1, -1);
            params.bottomMargin = this.bottomPadding;
            ((ViewGroup) this.webView.getCurrentWebView().getParent()).addView((View) this.errorView, params);
            this.errorView.onResume();
            ErrorViewUbcHelper.ubcShow(this.errorView);
        }
    }

    /* access modifiers changed from: protected */
    public void showLoading() {
        int i2;
        if (this.loadingParent == null) {
            this.loadingParent = new FrameLayout(getContext());
            BdShimmerView bdShimmerView = new BdShimmerView(getContext());
            this.loadingView = bdShimmerView;
            if (NightModeHelper.getNightModeSwitcherState()) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            bdShimmerView.setType(i2);
            FrameLayout.LayoutParams loadingParams = new FrameLayout.LayoutParams(-2, -2);
            loadingParams.gravity = 17;
            this.loadingParent.addView(this.loadingView, loadingParams);
            ((ViewGroup) getWebView().getCurrentWebView().getParent()).addView(this.loadingParent, new FrameLayout.LayoutParams(-1, -1));
        }
        this.loadingParent.setVisibility(0);
        BdShimmerView bdShimmerView2 = this.loadingView;
        if (bdShimmerView2 != null) {
            bdShimmerView2.startShimmerAnimation();
        }
    }

    /* access modifiers changed from: protected */
    public void hideLoading() {
        FrameLayout frameLayout = this.loadingParent;
        if (frameLayout != null) {
            frameLayout.setVisibility(4);
        }
        BdShimmerView bdShimmerView = this.loadingView;
        if (bdShimmerView != null) {
            bdShimmerView.stopShimmerAnimation();
        }
    }

    public void onNightModeChange(boolean isNightMode) {
        NgWebView webView2 = getWebView();
        Resources res = getContext().getResources();
        if (NgWebViewUtils.isEngineAvailable()) {
            webView2.onNightModeChanged(isNightMode);
            webView2.getSettingsExt().setNightModeEnabledExt(isNightMode);
            webView2.setBackgroundColor(res.getColor(R.color.sport_bg_a));
        } else {
            webView2.updateWebViewNightMode(isNightMode);
        }
        FrameLayout frameLayout = this.loadingParent;
        if (frameLayout != null) {
            frameLayout.setBackgroundColor(res.getColor(R.color.sport_bg_a));
        }
        BdShimmerView bdShimmerView = this.loadingView;
        if (bdShimmerView != null) {
            bdShimmerView.setType(isNightMode ^ true ? 1 : 0);
        }
        IBdErrorView iBdErrorView = this.errorView;
        if (iBdErrorView != null) {
            iBdErrorView.updateUIForNight(isNightMode);
        }
    }

    public void onFontSizeChange(FontSizeInfo info) {
        setTextZoom(getCurrentTextZoom());
        int bottomBarHeight = getBottomBarHeight();
        this.bottomPadding = bottomBarHeight;
        this.webView.setPadding(0, 0, 0, bottomBarHeight);
        updateErrorViewBottomMargin();
    }

    private void updateErrorViewBottomMargin() {
        IBdErrorView iBdErrorView = this.errorView;
        if (iBdErrorView instanceof View) {
            ViewGroup.LayoutParams lp = ((View) iBdErrorView).getLayoutParams();
            if (lp instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) lp).bottomMargin = this.bottomPadding;
                ((View) this.errorView).setLayoutParams(lp);
            }
        }
    }

    /* access modifiers changed from: protected */
    public int getCurrentTextZoom() {
        float scale = FontSizeHelper.getScaledSize(2, 1.0f);
        if (scale > 0.0f) {
            return (int) (((float) 100) * scale);
        }
        return 100;
    }

    public void onBindViewModel(VM viewModel, LifecycleOwner owner) {
        onBindWebUrl(viewModel, owner);
        onBindLoadState(viewModel, owner);
        onBindReload(viewModel, owner);
    }

    private void onBindWebUrl(VM viewModel, LifecycleOwner owner) {
        viewModel.webUrl.observe(owner, new Observer<String>() {
            public void onChanged(String url) {
                AbsSportWebComp.this.loadUrl(url);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void loadUrl(String url) {
        NgWebView webView2 = getWebView();
        if (webView2 == null) {
            return;
        }
        if (!TextUtils.isEmpty(url) && !url.equals(webView2.getCurrentPageUrl())) {
            if (DEBUG) {
                Log.d(TAG, "load url " + url);
            }
            onStartLoadUrl(url);
            ISailorWebViewExt ext = webView2.getWebViewExt();
            if (ext != null) {
                ext.loadUrl(url, (Map<String, String>) null, true);
            } else {
                webView2.loadUrl(url);
            }
        } else if (DEBUG) {
            Log.d(TAG, "url is empty or url is the same, skipped load url " + url);
        }
    }

    /* access modifiers changed from: protected */
    public void onStartLoadUrl(String url) {
    }

    private void onBindLoadState(VM viewModel, LifecycleOwner owner) {
        viewModel.loadState.observe(owner, new Observer<WebViewLoadState>() {
            public void onChanged(WebViewLoadState loadState) {
                if (loadState == null || !loadState.hasError()) {
                    AbsSportWebComp.this.hideErrorView();
                } else {
                    AbsSportWebComp.this.showErrorView(loadState);
                }
            }
        });
    }

    private void onBindReload(VM viewModel, LifecycleOwner owner) {
        viewModel.reload.observe(owner, new Observer<Boolean>() {
            public void onChanged(Boolean reload) {
                if (Boolean.TRUE.equals(reload) && AbsSportWebComp.this.getWebView() != null) {
                    AbsSportWebComp.this.getWebView().reload();
                }
            }
        });
    }

    public void onResume() {
        super.onResume();
        NgWebView ngWebView = this.webView;
        if (ngWebView != null) {
            ngWebView.onResume();
        }
    }

    public void onPause() {
        super.onPause();
        NgWebView ngWebView = this.webView;
        if (ngWebView != null) {
            ngWebView.onPause();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        NgWebView ngWebView = this.webView;
        if (ngWebView != null) {
            ngWebView.destroy();
        }
        BdShimmerView bdShimmerView = this.loadingView;
        if (bdShimmerView != null) {
            bdShimmerView.stopShimmerAnimation();
        }
        if (DEBUG) {
            Log.d(TAG, "开始兜底取消注册DataChannel receiver：" + this.dataChannelHost);
        }
        Registry.unregisterReceiver(this.dataChannelHost);
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        NgWebView ngWebView = this.webView;
        if (ngWebView != null) {
            ngWebView.saveState(outState);
        }
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        NgWebView ngWebView = this.webView;
        if (ngWebView != null) {
            ngWebView.restoreState(savedInstanceState);
        }
    }

    public void onOffsetChanged(int totalAbsRange, int verticalOffset) {
        int translateY = ((-Math.abs(totalAbsRange)) - verticalOffset) / 2;
        IBdErrorView iBdErrorView = this.errorView;
        if (!(iBdErrorView == null || iBdErrorView.getView() == null)) {
            this.errorView.getView().setTranslationY((float) translateY);
        }
        BdShimmerView bdShimmerView = this.loadingView;
        if (bdShimmerView != null) {
            bdShimmerView.setTranslationY((float) translateY);
        }
        NgWebView ngWebView = this.webView;
        if (ngWebView instanceof NestedScrollWebView2) {
            ((NestedScrollWebView2) ngWebView).setNestedScrollDownEnabled(verticalOffset != 0);
        }
    }

    public void stopTabCompNestedFling() {
        NgWebView ngWebView = this.webView;
        if (ngWebView != null) {
            ViewCompat.stopNestedScroll(ngWebView, 1);
        }
    }

    private static class OnWebViewCallbackImpl implements DataChannelWebSchemeDispatcher.OnWebViewCallBackListener {
        private final WeakReference<AbsSportWebComp<?>> webCompWeakRef;

        public OnWebViewCallbackImpl(AbsSportWebComp<?> webComp) {
            this.webCompWeakRef = new WeakReference<>(webComp);
        }

        public void evaluateJavascript(String js) {
            AbsSportWebComp<?> pageView = (AbsSportWebComp) this.webCompWeakRef.get();
            if (pageView != null) {
                pageView.getWebView().evaluateJavascript(js, (ValueCallback<String>) null);
            }
        }
    }
}
