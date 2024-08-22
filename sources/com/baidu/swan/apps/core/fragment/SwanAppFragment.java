package com.baidu.swan.apps.core.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.payment.PaymentManager;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.gamecore.util.GameCenterUtils;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.adaptation.interfaces.ISwanAppPageHistory;
import com.baidu.swan.apps.adaptation.webview.ISwanAppSlaveManager;
import com.baidu.swan.apps.adaptation.webview.ISwanAppWebView;
import com.baidu.swan.apps.adaptation.webview.ISwanAppWebViewWidget;
import com.baidu.swan.apps.adaptation.webview.impl.WebViewPaintTiming;
import com.baidu.swan.apps.api.module.baijiahao.BaijiahaoGuideViewHelper;
import com.baidu.swan.apps.api.module.baijiahao.BaijiahaoInfoData;
import com.baidu.swan.apps.api.module.orientation.PageOrientationConfig;
import com.baidu.swan.apps.api.module.orientation.PageOrientationManager;
import com.baidu.swan.apps.console.ConsoleController;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.console.debugger.UserDebugParams;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.console.ConsoleMessageHelper;
import com.baidu.swan.apps.core.handler.SwanAppPinchSummaryHandler;
import com.baidu.swan.apps.core.listener.DefaultWebViewWidgetListener;
import com.baidu.swan.apps.core.listener.IOnScrollChangedListener;
import com.baidu.swan.apps.core.listener.IWebViewWidgetChangeListener;
import com.baidu.swan.apps.core.slave.SwanAppSlavePool;
import com.baidu.swan.apps.core.turbo.AppReadyEvent;
import com.baidu.swan.apps.core.turbo.PageReadyEvent;
import com.baidu.swan.apps.core.turbo.SlaveReadyEvent;
import com.baidu.swan.apps.database.favorite.SwanAppFavoriteHelper;
import com.baidu.swan.apps.embed.SwanEmbedFrameManager;
import com.baidu.swan.apps.embed.SwanFrameContainerType;
import com.baidu.swan.apps.embed.page.ISwanPageManager;
import com.baidu.swan.apps.embed.page.PageContainerType;
import com.baidu.swan.apps.embed.view.SwanAppEmbedView;
import com.baidu.swan.apps.event.message.SwanAppCommonMessage;
import com.baidu.swan.apps.event.message.SwanAppCustomMessage;
import com.baidu.swan.apps.event.message.SwanAppLifecycleMessage;
import com.baidu.swan.apps.event.message.SwanAppRouteMessage;
import com.baidu.swan.apps.event.message.SwanAppWebMessage;
import com.baidu.swan.apps.framework.ISwanFrameContainer;
import com.baidu.swan.apps.inlinewidget.util.SwanInlineCustomViewHelper;
import com.baidu.swan.apps.inlinewidget.video.pictureinpicture.SwanAppPictureInPictureManager;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.lifecycle.SwanAppController;
import com.baidu.swan.apps.media.SwanAppPlayerManager;
import com.baidu.swan.apps.menu.SwanAppMenuHelper;
import com.baidu.swan.apps.menu.fontsize.FontSizeSettingEvent;
import com.baidu.swan.apps.menu.fontsize.FontSizeSettingHelper;
import com.baidu.swan.apps.message.SwanAppMessageHelper;
import com.baidu.swan.apps.model.SwanAppPageParam;
import com.baidu.swan.apps.model.SwanAppParam;
import com.baidu.swan.apps.monitor.SwanAppArrivalMonitor;
import com.baidu.swan.apps.monitor.SwanAppPageMonitor;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.SwanAppFragmentRecorder;
import com.baidu.swan.apps.performance.SwanAppPerformanceTrace;
import com.baidu.swan.apps.performance.SwanAppPerformanceUBC;
import com.baidu.swan.apps.performance.SwanAppRoutePerformUtils;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.prepose.util.SwanAppDebugUtil;
import com.baidu.swan.apps.pullrefresh.PullToRefreshBaseWebView;
import com.baidu.swan.apps.pullrefresh.SwanAsyncLayoutInflater;
import com.baidu.swan.apps.res.widget.floatlayer.FloatLayer;
import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.runtime.SwanAppGlobalVar;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.runtime.config.WindowConfig;
import com.baidu.swan.apps.scheme.actions.route.SwanAppPageAlias;
import com.baidu.swan.apps.setting.oauth.OAuthUtils;
import com.baidu.swan.apps.setting.oauth.ScopeInfo;
import com.baidu.swan.apps.setting.oauth.TaskResult;
import com.baidu.swan.apps.setting.oauth.request.Authorize;
import com.baidu.swan.apps.stability.deathlink.SwanDeadLinkDetector;
import com.baidu.swan.apps.statistic.IStat;
import com.baidu.swan.apps.statistic.StatFlow;
import com.baidu.swan.apps.statistic.SwanAppLaunchUbc;
import com.baidu.swan.apps.statistic.SwanAppUBCStatistic;
import com.baidu.swan.apps.statistic.SwanAppUbcControl;
import com.baidu.swan.apps.statistic.event.SwanAppUBCEvent;
import com.baidu.swan.apps.statistic.event.SwanAppUrlLoadFlowEvent;
import com.baidu.swan.apps.swancore.SwanAppSwanCoreManager;
import com.baidu.swan.apps.tabbar.controller.SwanAppBottomBarViewController;
import com.baidu.swan.apps.ui.R;
import com.baidu.swan.apps.util.SwanAppExecutorUtils;
import com.baidu.swan.apps.util.SwanAppRefererUtils;
import com.baidu.swan.apps.util.SwanAppRomUtils;
import com.baidu.swan.apps.util.SwanAppUIUtils;
import com.baidu.swan.apps.util.SwanAppUtils;
import com.baidu.swan.apps.util.typedbox.TypedCallback;
import com.baidu.swan.apps.view.Immersion.SwanAppImmersionHelper;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.apps.view.SwanAppHalfScreenView;
import com.baidu.swan.apps.view.container.util.SwanAppEventHelper;
import com.baidu.swan.apps.view.decorate.SwanAppMenuDecorate;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.swan.apps.view.narootview.SwanAppNARootViewManager;
import com.baidu.swan.menu.SwanAppMenu;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SwanAppFragment extends SwanAppBaseFragment implements FloatLayer.Holder {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    public static final String DEFAULT_FROM_WEBVIEW_ID = "-1";
    private static final String KEY_CAN_NAVIGATE_BACK = "canNavigateBack";
    private static final String KEY_PAGE_BACK_MESSAGE = "pageBack";
    private static final String KEY_PAGE_BACK_TIME = "pageBackTime";
    private static final String KEY_SCENE = "scene";
    private static final String KEY_SLAVE_ID = "slaveId";
    private static final String PARAM_KEY = "ai_apps_param";
    private static final String SCROLLVIEW_BACK_TO_TOP_EVENT_NAME = "scrollViewBackToTop";
    private static final long SWAN_CORE_VEISION_V1312 = 3500000;
    public static final boolean SWITCH_TAB_ROUTE_OPT = SwanAppRuntime.getSwanAppAbTestRuntime().getSwitch("swan_app_switch_tab_route_opt", true);
    public static final String TAG = "SwanAppFragment";
    private static final int TRANSPARENT_BAR_CHANGE_CRITICAL = SwanAppUIUtils.dp2px(149.0f);
    private static String mTopWebViewId = "-1";
    private static SwanAppPageParam sLastPageParams;
    private static String sRouteType;
    public boolean disablePreloadSlaveAfterDestroy = false;
    /* access modifiers changed from: private */
    public SwanAppPageParam mCurPageParams = new SwanAppPageParam();
    /* access modifiers changed from: private */
    public ISwanAppSlaveManager mCurWebViewManager;
    private WindowConfig mCurWindowConfig;
    private FloatLayer mFloatLayer;
    private SwanAppFragmentRecorder mFragmentRecorder = new SwanAppFragmentRecorder();
    private boolean mIsActionBarTransparent = false;
    /* access modifiers changed from: private */
    public boolean mIsEnableFloatBackShow = false;
    /* access modifiers changed from: private */
    public IOnScrollChangedListener mOnScrollChangedForTransparentBar;
    private PageOrientationConfig mOrientationConfig;
    /* access modifiers changed from: private */
    public ISwanAppPageHistory mPageHistory;
    private final SwanAppPinchSummaryHandler mPinchSummaryHandler = new SwanAppPinchSummaryHandler();
    private SwanAppPageParam mPrePageParams;
    private View mRootView;
    private SwanAppBottomBarViewController mSwanAppBottomBarViewController;
    private Map<String, ISwanAppSlaveManager> mTabMap = new TreeMap();
    private int mTransparentBarChangeSpacing = 0;
    private StatFlow mUrlLoadFlow;
    private FrameLayout mWebViewContainer;

    public SwanAppFragment(PageContainerType containerType) {
        super(containerType);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restoreArguments();
        if (DEBUG) {
            Log.d(TAG, "onCreate() obj: " + this);
        }
        SwanAppExecutorUtils.postOnComputation(new Runnable() {
            public void run() {
                ISwanAppPageHistory unused = SwanAppFragment.this.mPageHistory = SwanAppRuntime.getPageHistoryRuntime();
                SwanAppFragment.this.mPageHistory.onFragmentOpened(SwanAppFragment.this.fragmentId, SwanAppFragment.this.mCurPageParams, SwanAppFragment.this.mPageContainer.getContext());
                SwanAppUtils.initCustomMenuItem();
                SwanAppRuntime.getPageHistoryReportedRuntime().onFragmentOpened(SwanAppFragment.this.mCurPageParams);
                BaijiahaoGuideViewHelper.checkAndShowBaijiahaoGuide(SwanAppFragment.this);
            }
        }, "SwanAppPageHistory");
        SwanAppPerformanceTrace.log("route", "fragment create.");
    }

    private void restoreArguments() {
        Bundle bundle = this.mPageContainer.getPageArguments();
        if (bundle != null) {
            this.mPrePageParams = sLastPageParams;
            if (DEBUG) {
                Log.d(TAG, "restoreArguments sPrePageParams=" + this.mPrePageParams);
            }
            this.mParam = SwanAppParam.createSwanAppParam(bundle.getString(PARAM_KEY));
            if (this.mParam == null) {
                this.mCurPageParams.mPage = "";
                this.mCurPageParams.mParams = "";
                this.mCurPageParams.mRouteType = "";
                this.mCurPageParams.mRouteId = "";
                this.mCurPageParams.mScene = "";
            } else {
                this.mCurPageParams.mPage = this.mParam.getPage();
                this.mCurPageParams.mParams = this.mParam.getParams();
                this.mCurPageParams.mRouteType = this.mParam.getRouteType();
                this.mCurPageParams.mRouteId = this.mParam.getRouteId();
                this.mCurPageParams.mScene = this.mParam.getScene();
                this.mCurPageParams.mCoreReady = this.mParam.getCoreReady();
            }
            SwanAppPageParam swanAppPageParam = this.mCurPageParams;
            swanAppPageParam.mRoutePage = SwanAppPageAlias.checkRoutesPath(swanAppPageParam.getPage());
            WindowConfig pageWindowConfig = SwanAppController.getInstance().getPageWindowConfig(this.mCurPageParams.getRoutePage());
            this.mCurWindowConfig = pageWindowConfig;
            if (pageWindowConfig.isModifyByUser) {
                this.mCurWindowConfig = SwanAppController.getInstance().obtainNewWindowConfig(this.mCurPageParams.getPage());
            }
            if (this.isTransparent) {
                this.mCurWindowConfig.enablePullRefresh = false;
                this.mCurWindowConfig.enableOpacityNavigationBar = true;
                this.mCurWindowConfig.isModifyByUser = true;
            }
            this.mTransparentBarChangeSpacing = getResourcesSafely().getDimensionPixelSize(R.dimen.aiapps_normal_base_action_bar_height);
            this.mOrientationConfig = PageOrientationConfig.createPageOrientationConfig(this.mCurWindowConfig.pageOrientation);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (DEBUG) {
            Log.d(TAG, "onAttach() obj: " + this);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        SwanAppPerformanceTrace.log("route", "fragment onCreateView.");
        View rootView = SwanAsyncLayoutInflater.get().getView(com.baidu.swan.apps.R.layout.aiapps_fragment, container, false);
        this.mWebViewContainer = (FrameLayout) rootView.findViewById(com.baidu.swan.apps.R.id.ai_apps_fragment_content);
        initActionBar(rootView);
        updateObtainStabilityDataButton(rootView);
        this.mSwanAppBottomBarViewController = new SwanAppBottomBarViewController(this);
        createSlaveWebView(rootView);
        if (!FontSizeSettingHelper.isDisableFontSizeSetting()) {
            FontSizeSettingEvent.sendFontSizeChangeEvent(this.mCurWebViewManager.getWebViewId());
        }
        View view2 = rootView;
        if (immersionEnabled()) {
            view2 = initImmersion(view2);
        }
        this.mRootView = enableSliding(view2, this);
        setRegionFactor(this.mCurWebViewManager.getRegionFactor());
        SwanDeadLinkDetector.startDeadChainDetect();
        SwanAppPageMonitor.getInstance().start();
        return this.mRootView;
    }

    private void updateHalfScreenViewWindowConfig() {
        SwanAppEmbedView swanAppEmbedView;
        ISwanFrameContainer frameContainer = Swan.get().getSwanFrameContainer();
        if (frameContainer != null && frameContainer.getContainerType() == SwanFrameContainerType.EMBED_VIEW && (swanAppEmbedView = SwanEmbedFrameManager.getInstance().getEmbedView()) != null) {
            ViewParent swanAppHalfScreenView = swanAppEmbedView.getParent();
            if (swanAppHalfScreenView instanceof SwanAppHalfScreenView) {
                ((SwanAppHalfScreenView) swanAppHalfScreenView).checkGestureResponseArea(this.mCurWindowConfig);
            }
        }
    }

    public PullToRefreshBaseWebView getPullToRefreshWebView() {
        ISwanAppSlaveManager iSwanAppSlaveManager = this.mCurWebViewManager;
        if (iSwanAppSlaveManager != null) {
            return iSwanAppSlaveManager.getPullToRefreshWebView();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void initActionBar(View view2) {
        super.initActionBar(view2);
        boolean z = true;
        if (isEmbeddedFirstPage()) {
            setBackViewVisible(false);
        } else {
            setBackViewVisible(isLandingFragment() || isCurrentNotHomePage());
        }
        if (isNeedShowHomeButton()) {
            loadHaveHomeActionBar();
        }
        refreshBarTransparentType();
        this.mSwanAppActionBar.setOnDoubleClickListener(new SwanAppActionBar.OnDoubleClickListener() {
            public void onDoubleClick(View v) {
                String webViewId = SwanAppFragment.this.mCurWebViewManager.getWebViewId();
                SwanAppWebMessage webMessage = new SwanAppWebMessage();
                webMessage.mData = SwanAppEventHelper.getEventJson(webViewId, SwanAppFragment.SCROLLVIEW_BACK_TO_TOP_EVENT_NAME);
                SwanAppController.getInstance().sendJSMessage(webViewId, webMessage);
            }
        });
        if (SwanAppUbcControl.canStatLaunch(SwanAppLaunchUbc.VALUE_NA_RENDER_SUCCESS) && !SwanAppLaunchUbc.isNaRenderSuccessRecorded()) {
            SwanAppLaunchUbc.handleNaRenderSuccess(Swan.get().getApp().getInfo());
        }
        if (!isEnableNaviStyleCustom() || !isCurrentNotHomePage() || isEmbeddedFirstPage()) {
            z = false;
        }
        this.mIsEnableFloatBackShow = z;
        if (z) {
            checkHideFloatBackPermission();
        }
        checkAndSetCustomCloseIcon();
        if (SwanAppUtils.isLingJingAgent()) {
            hideFloatBackButtonOnUiThread();
            hideRightMenuButtonOnUiThread();
        }
        if (isEnableShowTtsNavigationButton()) {
            SwanAppUBCStatistic.recordTTSButtonEvent("show");
            this.mSwanAppActionBar.setRightTtsFloatZoneVisibility(0);
            this.mSwanAppActionBar.setRightTtsFloatViewClickListener(new SwanAppFragment$$ExternalSyntheticLambda0());
        }
    }

    static /* synthetic */ void lambda$initActionBar$0(View v) {
        SwanAppUBCStatistic.recordTTSButtonEvent("clk");
        SwanAppRuntime.getSwanTTSEventManager().onNavigationBarTtsButtonClick();
    }

    /* access modifiers changed from: protected */
    public void onActionBarSettingPressed() {
        ISwanAppSlaveManager iSwanAppSlaveManager = this.mCurWebViewManager;
        if (iSwanAppSlaveManager != null) {
            iSwanAppSlaveManager.checkInputMethod();
        }
        initToolMenu();
        getMenuToolRefreshTips(true);
        if (this.mMenuHeader != null) {
            this.mMenuHeader.setAttentionBtnStates(SwanAppFavoriteHelper.isSwanAppInFavorite(Swan.get().getAppId()));
        }
        this.mToolMenu.notifyFontSizeScale(FontSizeSettingHelper.getFontSizeRadio());
        this.mToolMenu.show(SwanAppRuntime.getNightModeRuntime().getNightModeSwitcherState(), getFavoriteState(), this.mMenuHeader, false);
    }

    /* access modifiers changed from: protected */
    public boolean isShowFloatButton() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onActionBarHomePressed() {
        handleBackToHome();
        SwanAppUBCEvent event = new SwanAppUBCEvent();
        event.mValue = "gohome";
        event.mSource = "bar";
        SwanAppFragment swanAppFragment = SwanAppController.getInstance().getTopSwanAppFragment();
        SwanAppParam swanAppParam = swanAppFragment == null ? null : swanAppFragment.getSwanAppParam();
        if (swanAppParam != null && !TextUtils.isEmpty(swanAppParam.getPage())) {
            event.addExt("page", swanAppParam.getPage());
        }
        doUBCEventStatistic(event);
    }

    /* access modifiers changed from: protected */
    public void applyImmersion(int color) {
        boolean occupyStatusBar;
        if (!WindowConfig.isNaviBarTransparent(this.mCurWindowConfig)) {
            super.applyImmersion(color);
            return;
        }
        if (isEnableNaviStyleCustom()) {
            occupyStatusBar = true;
        } else {
            occupyStatusBar = !SwanAppRomUtils.hasNotch(this.mActivity);
        }
        applyImmersion(color, occupyStatusBar);
        refreshBarTransparentType();
    }

    public boolean setActionBarBackgroundColor(int color) {
        boolean result = super.setActionBarBackgroundColor(color);
        refreshBarTransparentType();
        return result;
    }

    public void resetWithCurImmersion() {
        super.resetWithCurImmersion();
        refreshBarTransparentType();
        if (this.mImmersionHelper != null && this.mImmersionHelper.isImmersivePortraitVideo() && SwanAppImmersionHelper.SUPPORT_IMMERSION) {
            this.mImmersionHelper.setPortraitImmersion();
        }
    }

    public void onStart() {
        super.onStart();
        performStart();
    }

    public void onResume() {
        super.onResume();
        performResume();
        getRightMenuRefreshTips(false);
    }

    public void onPause() {
        super.onPause();
        performPause();
    }

    public void onStop() {
        super.onStop();
        performStop();
    }

    private void performStart() {
        if (this.mPageContainer.getPageVisibleHint()) {
            start();
        } else if (this.isNextPageTransparent) {
            this.mCurWebViewManager.onPause();
        }
        if (DEBUG) {
            Log.d(TAG, Log.getStackTraceString(new Exception("performStart() wvID: " + this.mCurWebViewManager.getWebViewId())));
        }
    }

    private void performResume() {
        if (this.mPageContainer.getUserVisibleHint()) {
            resume();
        }
        if (this.mToolMenu != null && this.mToolMenu.isShowing()) {
            this.mToolMenu.updateNightModeMenuView(SwanAppRuntime.getNightModeRuntime().getNightModeSwitcherState());
        }
        if (DEBUG) {
            Log.d(TAG, Log.getStackTraceString(new Exception("performResume() wvID: " + this.mCurWebViewManager.getWebViewId())));
        }
    }

    private void performPause() {
        if (this.mPageContainer.getUserVisibleHint()) {
            pause();
        }
        if (DEBUG) {
            Log.d(TAG, Log.getStackTraceString(new Exception("performPause() wvID: " + this.mCurWebViewManager.getWebViewId())));
        }
    }

    private void performStop() {
        if (this.mPageContainer.getPageVisibleHint()) {
            stop();
        }
        if (DEBUG) {
            Log.d(TAG, Log.getStackTraceString(new Exception("performStop() wvID: " + this.mCurWebViewManager.getWebViewId())));
        }
    }

    public static void setRouteType(String routeType) {
        sRouteType = routeType;
    }

    public static String getRouteType() {
        return sRouteType;
    }

    public static void setTopWebViewId(String webViewId) {
        mTopWebViewId = webViewId;
    }

    public static String getTopWebViewId() {
        return mTopWebViewId;
    }

    private void sendRouteMessage() {
        if (!TextUtils.equals(mTopWebViewId, this.mCurWebViewManager.getWebViewId()) || TextUtils.equals(sRouteType, "switchTab")) {
            int curTabId = this.mSwanAppBottomBarViewController.getTabIndex(getCurSwanAppPageParams().getRoutePage());
            SwanAppRouteMessage routeMessage = new SwanAppRouteMessage();
            routeMessage.mFromId = mTopWebViewId;
            routeMessage.mToId = this.mCurWebViewManager.getWebViewId();
            routeMessage.mRouteType = sRouteType;
            routeMessage.mToPage = this.mCurPageParams.mPage;
            routeMessage.mIsPictureInPictureActive = SwanAppPictureInPictureManager.INSTANCE.updatePictureInPictureActiveStatus(routeMessage);
            routeMessage.mToTabIndex = String.valueOf(curTabId);
            sRouteType = "";
            if (DEBUG) {
                Log.d(TAG, "sendRouteMessage fromId: " + routeMessage.mFromId + " ,toId: " + routeMessage.mToId + " ,RouteType: " + routeMessage.mRouteType + " page:" + routeMessage.mToPage + ",TabIndex: " + routeMessage.mToTabIndex + ",isPictureInPictureActive:" + routeMessage.mIsPictureInPictureActive);
            }
            SwanAppController.getInstance().sendJSMessage(routeMessage);
            mTopWebViewId = this.mCurWebViewManager.getWebViewId();
        }
    }

    private void sendLifecycleMessage(String type) {
        HashMap<String, String> values = new HashMap<>();
        values.put(SwanAppLifecycleMessage.EVENT_TYPE_KEY, type);
        values.put("wvID", this.mCurWebViewManager.getWebViewId());
        SwanAppLifecycleMessage lifecycleMessage = new SwanAppLifecycleMessage((Map<String, String>) values);
        if (DEBUG) {
            Log.d(TAG, "sendLifecycleMessage type: " + type + " wvID: " + this.mCurWebViewManager.getWebViewId());
        }
        SwanAppController.getInstance().sendJSMessage(lifecycleMessage);
        SwanAppController.getInstance().sendJSMessage(this.mCurWebViewManager.getWebViewId(), lifecycleMessage);
    }

    public void share() {
        if (this.mCurWebViewManager != null) {
            Map<String, String> param = new HashMap<>();
            param.put("wvID", this.mCurWebViewManager.getWebViewId());
            ISwanAppWebViewWidget webView = this.mCurWebViewManager.getWebViewWidget();
            if (webView != null) {
                param.put("webViewUrl", webView.getCurrentPageUrl());
            }
            SwanAppController.getInstance().sendJSMessage(new SwanAppCommonMessage("sharebtn", param));
        } else if (DEBUG) {
            Log.e(TAG, Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
        }
    }

    private void createSlaveWebView(View rootView) {
        SwanAppPerformanceTrace.log("route", "createSlaveWebView start.");
        String baseUrl = this.mParam.getBaseUrl();
        String params = this.mParam.getParams();
        String page = this.mParam.getPage();
        String pageUrl = SwanAppUtils.buildPageUrl(baseUrl, page, params);
        this.mCurWebViewManager = SwanAppSlavePool.getSlaveManager(pageUrl);
        boolean z = DEBUG;
        if (z) {
            Log.d(TAG, "pageUrl: " + pageUrl + " is load: " + (this.mCurWebViewManager != null));
        }
        if (this.mCurWebViewManager == null) {
            if (z) {
                Log.e(TAG, Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
            }
            this.mCurWebViewManager = createSlaveAndLoad(baseUrl, page, params, "");
        }
        this.mCurWebViewManager.setPageParam(this.mCurPageParams);
        WindowConfig config = SwanAppController.getInstance().getPageWindowConfig(page);
        this.mCurWebViewManager.setBackgroundColor(this.mWebViewContainer, config);
        this.mCurWebViewManager.addToParent(this.mWebViewContainer, config);
        initScrollChangedEventListener(page);
        addWebViewManagerListener(this.mCurWebViewManager);
        if (isTabFragment()) {
            this.mTabMap.put(getPageOpt(page, this.mCurPageParams.mRoutePage), this.mCurWebViewManager);
            this.mSwanAppBottomBarViewController.addBottomBar(rootView, this.mPageContainer.getContext(), getPageOpt(page, this.mCurPageParams.mRoutePage));
        }
        SwanAppPerformanceTrace.log("route", "createSlaveWebView end.");
        beginFlow();
    }

    public void onDetach() {
        super.onDetach();
    }

    public void onDestroyView() {
        super.onDestroyView();
        Map<String, ISwanAppSlaveManager> map = this.mTabMap;
        if (map == null || map.isEmpty()) {
            ISwanAppSlaveManager iSwanAppSlaveManager = this.mCurWebViewManager;
            if (iSwanAppSlaveManager != null) {
                iSwanAppSlaveManager.destroyView();
            }
        } else {
            for (ISwanAppSlaveManager swanAppSlaveManager : this.mTabMap.values()) {
                if (swanAppSlaveManager != null) {
                    swanAppSlaveManager.destroyView();
                }
            }
        }
        hideCustomView();
    }

    public void onDestroy() {
        super.onDestroy();
        this.mSwanAppFragmentCallbackRegistry.onFragmentDestroyed();
        if (FragmentDestroySwitch.isPostDestroyEnable()) {
            SwanAppUtils.getHandler().postAtFrontOfQueue(new Runnable() {
                public void run() {
                    SwanAppFragment.this.destroyWebView();
                }
            });
        } else {
            destroyWebView();
        }
    }

    /* access modifiers changed from: private */
    public void destroyWebView() {
        Map<String, ISwanAppSlaveManager> map = this.mTabMap;
        if (map == null || map.isEmpty()) {
            ISwanAppSlaveManager iSwanAppSlaveManager = this.mCurWebViewManager;
            if (iSwanAppSlaveManager != null) {
                tryRemoveTransparentBarScrollListener(iSwanAppSlaveManager);
                this.mCurWebViewManager.destroy();
            }
        } else {
            for (ISwanAppSlaveManager swanAppSlaveManager : this.mTabMap.values()) {
                if (swanAppSlaveManager != null) {
                    tryRemoveTransparentBarScrollListener(swanAppSlaveManager);
                    swanAppSlaveManager.destroy();
                }
            }
            this.mTabMap.clear();
        }
        this.mCurWebViewManager = null;
        if (DEBUG) {
            Log.d(TAG, "onDestroy() obj: " + this);
        }
        if (!this.disablePreloadSlaveAfterDestroy && Swan.get().getActivity() != null) {
            SwanAppSlavePool.preloadSlaveManager(Swan.get().getActivity());
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        updateMenuOrientation(newConfig.orientation == 2);
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (this.mPageContainer.isPageAdded()) {
            super.setUserVisibleHint(isVisibleToUser);
            if (DEBUG) {
                Log.d(TAG, "setUserVisibleHint isVisibleToUser: " + isVisibleToUser);
            }
            if (isVisibleToUser) {
                resume();
                getRightMenuRefreshTips(false);
                return;
            }
            pause();
        }
    }

    public void setPageVisibleHint(boolean isPageVisible) {
        if (this.mPageContainer.isPageAdded()) {
            super.setPageVisibleHint(isPageVisible);
            if (DEBUG) {
                Log.d(TAG, "setPageVisibleHint isPageVisible: " + isPageVisible);
            }
            if (isPageVisible) {
                start();
            } else {
                stop();
            }
        }
    }

    public void start() {
        ISwanAppSlaveManager iSwanAppSlaveManager;
        if (this.isNextPageTransparent && (iSwanAppSlaveManager = this.mCurWebViewManager) != null) {
            iSwanAppSlaveManager.onResume();
        }
    }

    public void resume() {
        ISwanAppSlaveManager iSwanAppSlaveManager = this.mCurWebViewManager;
        boolean z = false;
        boolean isSlaveWebViewNull = iSwanAppSlaveManager == null;
        String appKey = "";
        String slaveId = isSlaveWebViewNull ? appKey : iSwanAppSlaveManager.getWebViewId();
        if (DEBUG) {
            Log.d(TAG, "resume() wvID: " + slaveId);
        }
        if (!isSlaveWebViewNull) {
            if (isEmbeddedFirstPage()) {
                setBackViewVisible(false);
            } else {
                if (isLandingFragment() || isCurrentNotHomePage()) {
                    z = true;
                }
                setBackViewVisible(z);
            }
            if (!this.isNextPageTransparent) {
                this.mCurWebViewManager.onResume();
            }
            sendRouteMessage();
            sendLifecycleMessage("onShow");
            SwanAppFragmentRecorder swanAppFragmentRecorder = this.mFragmentRecorder;
            if (swanAppFragmentRecorder != null) {
                swanAppFragmentRecorder.onShow();
            }
            SwanAppPageMonitor.getInstance().onPageForegroundChange(true);
        }
        SwanAppLog.i(SwanApp.MODEL_TAG, "onShow");
        SwanAppPlayerManager.onForegroundStateChanged(slaveId, true);
        PageOrientationManager.onPageShow(this.mActivity, this.mOrientationConfig);
        updateHalfScreenViewWindowConfig();
        if (SwanAppLog.getConsoleSwitch()) {
            ConsoleMessageHelper.requestFullSanData();
        }
        if (SwanApp.getOrNull() != null) {
            appKey = SwanApp.getOrNull().getAppKey();
        }
        SwanAppRuntime.getLifecycle().onPageShow(appKey);
        SwanAppRuntime.getSwanTTSEventManager().onNavigationBarTtsButtonShow(this.mSwanAppActionBar);
        SwanAppPictureInPictureManager.INSTANCE.resumePictureInPicture(this);
    }

    public PageOrientationConfig getPageOrientationConfig() {
        return this.mOrientationConfig;
    }

    public void notifyFontSizeChange(float targetRadio) {
        SwanAppBottomBarViewController swanAppBottomBarViewController = this.mSwanAppBottomBarViewController;
        if (swanAppBottomBarViewController != null) {
            swanAppBottomBarViewController.notifyFontSizeChange(targetRadio);
        }
        updateTopMargin(this.mIsActionBarTransparent, targetRadio);
        super.notifyFontSizeChange(targetRadio);
    }

    public void pause() {
        PullToRefreshBaseWebView webView;
        BaijiahaoGuideViewHelper.removeBaijiahaoGuideView((BaijiahaoInfoData) null);
        ISwanAppSlaveManager iSwanAppSlaveManager = this.mCurWebViewManager;
        boolean isSlaveWebViewNull = iSwanAppSlaveManager == null;
        String appKey = "";
        String slaveId = isSlaveWebViewNull ? appKey : iSwanAppSlaveManager.getWebViewId();
        if (DEBUG) {
            Log.d(TAG, "pause() wvID: " + slaveId);
        }
        if (!isSlaveWebViewNull) {
            if (!this.isNextPageTransparent) {
                this.mCurWebViewManager.onPause();
            }
            sendLifecycleMessage(SwanAppLifecycleMessage.TYPE_HIDE);
            SwanAppFragmentRecorder swanAppFragmentRecorder = this.mFragmentRecorder;
            if (swanAppFragmentRecorder != null) {
                swanAppFragmentRecorder.onHide(this.mCurPageParams);
            }
            SwanAppPageMonitor.getInstance().onPageForegroundChange(false);
            WebViewPaintTiming paintTiming = (WebViewPaintTiming) SwanAppArrivalMonitor.getPaintTiming().first;
            if (paintTiming != null && paintTiming.fmp > 0 && paintTiming.fcp > 0) {
                SwanAppArrivalMonitor.onSwanPageChange(false);
            }
        }
        if (getFloatLayer() != null && !getFloatLayer().getRewardVideoAdLayer() && (!getFloatLayer().isShowingView() || getFloatLayer().resumeDismiss())) {
            getFloatLayer().reset();
        }
        SwanAppLog.i(SwanApp.MODEL_TAG, SwanAppLifecycleMessage.TYPE_HIDE);
        SwanAppPlayerManager.onForegroundStateChanged(slaveId, false);
        if (!isSlaveWebViewNull && (webView = this.mCurWebViewManager.getPullToRefreshWebView()) != null) {
            webView.onPullDownRefreshComplete(false);
        }
        if (SwanApp.getOrNull() != null) {
            appKey = SwanApp.getOrNull().getAppKey();
        }
        SwanAppRuntime.getLifecycle().onPageHide(appKey);
    }

    public void stop() {
        ISwanAppSlaveManager iSwanAppSlaveManager;
        if (this.isNextPageTransparent && (iSwanAppSlaveManager = this.mCurWebViewManager) != null) {
            iSwanAppSlaveManager.onPause();
        }
    }

    public String getTabWebViewId(String page) {
        if (this.mTabMap.containsKey(page)) {
            return this.mTabMap.get(page).getWebViewId();
        }
        return null;
    }

    public void switchTab(SwanAppPageParam pageParam) {
        if (DEBUG) {
            Log.d(TAG, "switchTab pageParam: " + pageParam);
        }
        this.mCurPageParams.mScene = "";
        if (this.mSwanAppBottomBarViewController.getTabIndex(getCurSwanAppPageParams().getRoutePage()) == this.mSwanAppBottomBarViewController.getTabIndex(pageParam.getRoutePage())) {
            this.mCurPageParams.mRouteType = pageParam.mRouteType;
            this.mCurPageParams.mRouteId = pageParam.mRouteId;
            return;
        }
        this.mSwanAppBottomBarViewController.updateTabUI(pageParam.getRoutePage());
        this.mPageContainer.onPause();
        this.mPageContainer.onStop();
        doSwitchTab(pageParam, "");
    }

    private void createTabSlaveWebView(SwanAppPageParam page, String routeId) {
        if (this.mTabMap.get(page.mRoutePage) == null) {
            String pageUrl = SwanAppUtils.buildPageUrl(page.mBaseUrl, page.mPage, page.mParams);
            ISwanAppSlaveManager manager = SwanAppSlavePool.getSlaveManager(pageUrl);
            if (manager != null) {
                if (DEBUG) {
                    Log.d(TAG, "createTabSlaveWebView loaded manager pageUrl: " + pageUrl);
                }
                this.mTabMap.put(getPageOpt(page.mPage, page.mRoutePage), manager);
            } else {
                if (DEBUG) {
                    Log.d(TAG, "createTabSlaveWebView createNew.");
                }
                manager = createSlaveAndLoad(page.mBaseUrl, page.mPage, page.mParams, routeId);
                this.mTabMap.put(getPageOpt(page.mPage, page.mRoutePage), manager);
            }
            initScrollChangedEventListener(page.mPage);
            addWebViewManagerListener(manager);
        }
    }

    private ISwanAppSlaveManager createSlaveAndLoad(String baseUrl, String page, String params, String routeId) {
        String str;
        boolean z = DEBUG;
        if (z) {
            Log.d(TAG, "createSlaveAndLoad start.");
        }
        SwanAppSlavePool.PreloadSlaveManager preloadManager = SwanAppSlavePool.getPreloadSlaveManager(this.mPageContainer.getAttachedActivity());
        if (!TextUtils.isEmpty(routeId)) {
            HybridUbcFlow record = SwanAppPerformanceUBC.requireSession("route", routeId).record(new UbcFlowEvent(SwanAppRoutePerformUtils.ACTION_NA_PRE_LOAD_SLAVE_CHECK));
            if (preloadManager.isReady) {
                str = "1";
            } else {
                str = "0";
            }
            record.putExt("preload", str);
        }
        if (z) {
            Log.d(TAG, "createSlaveAndLoad preloadManager: " + preloadManager);
        }
        final SwanAppSlavePool.PreloadSlaveManager preloadSlaveManager = preloadManager;
        final String str2 = routeId;
        final String str3 = page;
        final String str4 = baseUrl;
        final String str5 = params;
        SwanAppSlavePool.requestPreloadOnReady(preloadManager, new SwanAppSlavePool.PreloadStatusCallback() {
            public void onReady() {
                PageReadyEvent pageReadyEvent = new PageReadyEvent();
                pageReadyEvent.isT7Available = preloadSlaveManager.slaveManager.isT7WebView();
                if (!TextUtils.isEmpty(str2)) {
                    SwanAppRoutePerformUtils.onPreloadCheckOk(preloadSlaveManager, str2);
                }
                String routePath = SwanAppPageAlias.checkRoutesPath(str3);
                pageReadyEvent.appPath = str4;
                pageReadyEvent.pagePath = TextUtils.isEmpty(str5) ? str3 : str3 + GameCenterUtils.SCHEME_SWAN_SUFFIX + str5;
                pageReadyEvent.pageType = Swan.get().getApp().getPageType(routePath);
                pageReadyEvent.initData = Swan.get().getApp().getInitDataByPage(routePath);
                pageReadyEvent.rootPath = AppReadyEvent.getRootPath(SwanApp.get(), pageReadyEvent.pagePath);
                pageReadyEvent.onReachBottomDistance = SwanAppController.getInstance().getPageWindowConfig(routePath).onReachBottomDistance;
                pageReadyEvent.sConsole = String.valueOf(ConsoleController.isConsoleEnabled());
                pageReadyEvent.showPerformancePanel = SwanAppFragment.DEBUG || SwanAppController.getInstance().isSupportDebug();
                if (SwanAppDebugUtil.isUserDebug()) {
                    pageReadyEvent.preloadFile = UserDebugParams.getSlavePreloadFilePath();
                }
                if (!TextUtils.isEmpty(str2)) {
                    pageReadyEvent.routeId = str2;
                    SwanAppPerformanceUBC.requireSession("route", str2).record(new UbcFlowEvent("slave_dispatch_start"));
                }
                SwanAppRefererUtils.setSlaveWebviewReferer();
                preloadSlaveManager.slaveManager.getWebView().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, str3);
                preloadSlaveManager.slaveManager.setPathWithQuery(pageReadyEvent.pagePath);
                SwanAppController.getInstance().sendJSMessage(preloadSlaveManager.slaveManager.getWebViewId(), PageReadyEvent.createPageReadyMessage(pageReadyEvent));
                SlaveReadyEvent slaveReadyEvent = new SlaveReadyEvent();
                slaveReadyEvent.slaveId = preloadSlaveManager.slaveManager.getWebViewId();
                slaveReadyEvent.viewMode = "";
                SwanAppController.getInstance().sendJSMessage(SlaveReadyEvent.createSlaveReadyMessage(slaveReadyEvent));
                SwanAppLaunchUbc.updateArrivalSlavePath(preloadSlaveManager.slaveManager.getWebViewId(), pageReadyEvent.pagePath);
                if (SwanAppFragment.DEBUG) {
                    Log.d(SwanAppFragment.TAG, "createSlaveAndLoad onReady. pageEvent: " + pageReadyEvent.toString());
                }
            }
        });
        if (z) {
            Log.d(TAG, "createSlaveAndLoad end.");
        }
        return preloadManager.slaveManager;
    }

    public void doSwitchTab(SwanAppPageParam pageParam, String routeId) {
        setLastPageParams(this.mCurPageParams);
        this.mPrePageParams = sLastPageParams;
        if (DEBUG) {
            Log.d(TAG, "doSwitchTab mPrePageParams=" + this.mPrePageParams);
        }
        String page = pageParam.mPage;
        String routePage = pageParam.mRoutePage;
        String str = "";
        WindowConfig windowConfig = SwanAppController.getInstance().getPageWindowConfig(TextUtils.isEmpty(routePage) ? str : routePage);
        boolean isTabFirstCreate = !isTabWebViewCreated(routePage);
        if (!TextUtils.isEmpty(routeId)) {
            if (isTabFirstCreate) {
                SwanAppRoutePerformUtils.initRouteType(7, routeId);
            } else {
                SwanAppRoutePerformUtils.initRouteType(6, routeId);
            }
        }
        this.mCurPageParams.mPage = page;
        SwanAppPageParam swanAppPageParam = this.mCurPageParams;
        if (pageParam != null) {
            str = pageParam.getParams();
        }
        swanAppPageParam.mParams = str;
        this.mCurPageParams.mRoutePage = routePage;
        this.mCurWindowConfig = windowConfig;
        this.mOrientationConfig = PageOrientationConfig.createPageOrientationConfig(windowConfig.pageOrientation);
        if (!isTabFirstCreate) {
            switchTabWebView(routePage, pageParam);
        } else {
            createTabSlaveWebView(pageParam, routeId);
            switchTabWebView(getPageOpt(page, routePage), pageParam);
        }
        if (!TextUtils.isEmpty(routeId)) {
            SwanAppPerformanceUBC.requireSession("route", routeId).record(new UbcFlowEvent(SwanAppRoutePerformUtils.ACTION_NA_PUSH_PAGE_END));
            SwanAppRoutePerformUtils.endNARouteSession(routeId, pageParam);
        }
        setActionbarTitle(windowConfig.navigationBarTitle);
        setNavigationBarFrontColor(SwanAppConfigData.parseColor(windowConfig.navigationBarTextStyle));
        setActionBarBackgroundColor(windowConfig.navigationBarBgColor);
        refreshBarTransparentType();
        updateNonFirstPageFlag();
        ExecutorUtilsExt.postOnElastic(new Runnable() {
            public void run() {
                if (SwanAppFragment.this.mPageHistory != null) {
                    SwanAppFragment.this.mPageHistory.updateFragmentPage(SwanAppFragment.this.fragmentId, SwanAppFragment.this.mCurPageParams);
                }
                SwanAppRuntime.getPageHistoryReportedRuntime().onFragmentOpened(SwanAppFragment.this.mCurPageParams);
            }
        }, "SwanAppTabPageHistory", 2);
        SwanAppLog.i(TAG, "switch tab title: " + windowConfig.navigationBarTitle + " page:" + page);
    }

    private void switchTabWebView(String page, SwanAppPageParam pageParam) {
        ISwanAppSlaveManager manager = this.mTabMap.get(page);
        if (this.mCurWebViewManager != manager && manager != null) {
            WindowConfig config = SwanAppController.getInstance().getPageWindowConfig(page);
            manager.setBackgroundColor(this.mWebViewContainer, config);
            if (!manager.hasParent()) {
                manager.addToParent(this.mWebViewContainer, config);
            }
            manager.setSlaveVisibility(0);
            ISwanAppSlaveManager iSwanAppSlaveManager = this.mCurWebViewManager;
            if (iSwanAppSlaveManager != null) {
                iSwanAppSlaveManager.setSlaveVisibility(8);
            }
            this.mCurWebViewManager = manager;
            this.mCurPageParams.mRouteType = pageParam.mRouteType;
            this.mCurPageParams.mRouteId = pageParam.mRouteId;
            this.mCurWebViewManager.setPageParam(this.mCurPageParams);
            onTabSwitched();
        }
    }

    private void onTabSwitched() {
        Activity activity = requireActivity();
        if (activity != null) {
            onConfigurationChanged(activity.getResources().getConfiguration());
        }
    }

    public FrameLayout getWebViewContainer() {
        return this.mWebViewContainer;
    }

    private boolean isTabWebViewCreated(String page) {
        if (!this.mTabMap.isEmpty() && this.mTabMap.get(page) != null) {
            return true;
        }
        return false;
    }

    public static SwanAppFragment newInstance(PageContainerType containerType, SwanAppParam param) {
        SwanAppFragment swanAppFragment = new SwanAppFragment(containerType);
        if (param != null) {
            Bundle bundle = new Bundle();
            bundle.putString(PARAM_KEY, param.toJSONString());
            swanAppFragment.getPageContainer().setPageArguments(bundle);
        }
        return swanAppFragment;
    }

    public boolean isSlidable(MotionEvent ev) {
        return isLandingFragment() && this.mCurWebViewManager.isSlidable(ev);
    }

    public boolean isHandleScrollYEvent(MotionEvent event, boolean scrollUp) {
        ISwanAppSlaveManager iSwanAppSlaveManager = this.mCurWebViewManager;
        if (iSwanAppSlaveManager != null) {
            return iSwanAppSlaveManager.isHandleScrollYEvent(event, scrollUp);
        }
        return true;
    }

    public boolean isTabFragment() {
        SwanAppConfigData config;
        SwanAppController controller = SwanAppController.getInstance();
        if (controller == null || (config = controller.getConfigData()) == null || !config.hasTabItemInfo() || this.mParam == null) {
            return false;
        }
        return config.isInTabUrl(getPageOpt(this.mParam.getPage(), this.mCurPageParams.getRoutePage()));
    }

    public boolean isBottomBarVisible() {
        SwanAppBottomBarViewController swanAppBottomBarViewController = this.mSwanAppBottomBarViewController;
        if (swanAppBottomBarViewController == null) {
            return false;
        }
        return swanAppBottomBarViewController.isBottomBarVisible();
    }

    /* access modifiers changed from: protected */
    public final boolean isNeedShowHomeButton() {
        SwanAppConfigData configData;
        WindowConfig windowConfig = this.mCurWindowConfig;
        if ((windowConfig != null && windowConfig.hideNavigationBarHomeBtn) || (configData = SwanAppController.getInstance().getConfigData()) == null) {
            return false;
        }
        String curPage = SwanAppController.getInstance().getCurSwanAppsPage();
        if (TextUtils.equals(configData.getFirstPageUrl(), curPage) || configData.isInTabUrl(curPage)) {
            return false;
        }
        return true;
    }

    private void checkHideFloatBackPermission() {
        WindowConfig windowConfig = this.mCurWindowConfig;
        if (windowConfig != null && windowConfig.hideCustomNavigationBarBackBtn) {
            Swan.get().getApp().getSetting().checkOrAuthorize(this.mActivity, ScopeInfo.SCOPE_ID_BACK_BUTTON_HIDE, new TypedCallback<TaskResult<Authorize.Result>>() {
                public void onCallback(TaskResult<Authorize.Result> result) {
                    if (OAuthUtils.isAuthorizeOk(result)) {
                        SwanAppFragment.this.hideFloatBackButtonOnUiThread();
                    }
                }
            });
        }
        Swan.get().getApp().getSetting().checkAuthorize("mapp_i_custom_navigation_bar", new TypedCallback<ScopeInfo>() {
            public void onCallback(ScopeInfo msg) {
                if (msg != null && !msg.forbidden && msg.tipStatus == 1) {
                    SwanAppFragment.this.hideFloatBackButtonOnUiThread();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void hideFloatBackButtonOnUiThread() {
        SwanAppUtils.runOnUiThread(new Runnable() {
            public void run() {
                boolean unused = SwanAppFragment.this.mIsEnableFloatBackShow = false;
                SwanAppFragment.this.setNaviStyleCustom(true, false);
            }
        });
    }

    private void hideRightMenuButtonOnUiThread() {
        SwanAppUtils.runOnUiThread(new SwanAppFragment$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$hideRightMenuButtonOnUiThread$1$com-baidu-swan-apps-core-fragment-SwanAppFragment  reason: not valid java name */
    public /* synthetic */ void m7935lambda$hideRightMenuButtonOnUiThread$1$combaiduswanappscorefragmentSwanAppFragment() {
        SwanAppActionBar actionBar = this.mSwanAppActionBar;
        if (actionBar != null) {
            actionBar.setRightZoneVisibility(false);
        }
    }

    private boolean isCurrentNotHomePage() {
        SwanAppConfigData configData = SwanAppController.getInstance().getConfigData();
        if (configData == null) {
            return false;
        }
        if (!(TextUtils.equals(configData.getFirstPageUrl(), this.mCurPageParams.mPage) || configData.isInTabUrl(this.mCurPageParams.mPage))) {
            return true;
        }
        return false;
    }

    private boolean isEmbeddedFirstPage() {
        ISwanFrameContainer frameContainer = Swan.get().getSwanFrameContainer();
        ISwanPageManager manager = getSwanPageManager();
        if (manager != null && frameContainer != null && frameContainer.getContainerType() == SwanFrameContainerType.EMBED_VIEW && manager.getFragmentCount() == 1) {
            return true;
        }
        return false;
    }

    private boolean isShowBackHomePage() {
        SwanAppConfigData configData = SwanAppController.getInstance().getConfigData();
        return configData != null && !TextUtils.equals(configData.getFirstPageUrl(), this.mCurPageParams.getPage());
    }

    public String getSlaveWebViewId() {
        ISwanAppSlaveManager iSwanAppSlaveManager = this.mCurWebViewManager;
        if (iSwanAppSlaveManager != null) {
            return iSwanAppSlaveManager.getWebViewId();
        }
        return "";
    }

    public List<String> getSlaveWebViewIds() {
        List<String> slaveList = new ArrayList<>();
        Map<String, ISwanAppSlaveManager> map = this.mTabMap;
        if (map != null && !map.isEmpty()) {
            for (Map.Entry entry : this.mTabMap.entrySet()) {
                if (entry != null) {
                    slaveList.add(((ISwanAppSlaveManager) entry.getValue()).getWebViewId());
                }
            }
        }
        ISwanAppSlaveManager iSwanAppSlaveManager = this.mCurWebViewManager;
        if (iSwanAppSlaveManager != null) {
            String slaveId = iSwanAppSlaveManager.getWebViewId();
            if (!slaveList.contains(slaveId)) {
                slaveList.add(slaveId);
            }
        }
        return slaveList;
    }

    public boolean handleBackPressed() {
        ISwanPageManager manager;
        if (getFloatLayer() != null && getFloatLayer().hookBack() && getFloatLayer().isShowingView()) {
            return true;
        }
        if (getFloatLayer() != null && getFloatLayer().getRewardVideoAdLayer()) {
            getFloatLayer().handleBackPressed();
            return true;
        } else if (PaymentManager.removeWalletUI()) {
            return true;
        } else {
            ISwanAppSlaveManager iSwanAppSlaveManager = this.mCurWebViewManager;
            if (iSwanAppSlaveManager != null && (SwanAppPlayerManager.handleBackPressed(iSwanAppSlaveManager.getWebViewId()) || this.mCurWebViewManager.handleBackPressed())) {
                return true;
            }
            if (this.mWebViewContainer != null && SwanAppRuntime.getStartVoiceRecognitionRuntime().handleBackPressed(this.mWebViewContainer)) {
                return true;
            }
            boolean z = false;
            if (SwanAppSwanCoreManager.getSwanCoreVersionCode(Swan.get().getApp().getFrameType()) <= SWAN_CORE_VEISION_V1312 || this.type > 2 || !Swan.get().getApp().getSetting().checkAuthorizeFromLocalCache("scope_prevent_page_back") || (manager = getSwanPageManager()) == null) {
                return false;
            }
            int i2 = this.type;
            if (manager.getFragmentCount() > 1) {
                z = true;
            }
            sendPageBackMessage(i2, z);
            return true;
        }
    }

    private void sendPageBackMessage(int type, boolean canNavigateBack) {
        SwanAppCustomMessage message = new SwanAppCustomMessage(KEY_PAGE_BACK_MESSAGE);
        message.put("slaveId", SwanAppController.getInstance().getSlaveWebViewId());
        message.put(KEY_CAN_NAVIGATE_BACK, Boolean.valueOf(canNavigateBack));
        message.putValueToData("scene", Integer.valueOf(type));
        message.putValueToData(KEY_PAGE_BACK_TIME, Long.valueOf(System.currentTimeMillis() / 1000));
        SwanAppController.getInstance().sendJSMessage(message);
        SwanAppLog.i(SwanApp.MODEL_TAG, "prevent and send pageBack message to swanjs, back type: " + type);
    }

    public void showAgentMenu() {
        initToolMenu();
        if (this.mToolMenu != null) {
            this.mToolMenu.notifyFontSizeScale(FontSizeSettingHelper.getFontSizeRadio());
            this.mToolMenu.show(SwanAppRuntime.getNightModeRuntime().getNightModeSwitcherState(), 0, (View) null, false);
            SwanAppMenuHelper.doShowAgentCenterUBCEventStatistic();
        }
    }

    /* access modifiers changed from: protected */
    public void initToolMenu() {
        Activity activity = this.mPageContainer.getAttachedActivity();
        Context context = this.mPageContainer.getContext();
        if (this.mMenuHeader == null && context != null) {
            this.mMenuHeader = new SwanAppMenuHeaderView(context);
        }
        if (activity != null) {
            if (this.mToolMenu == null) {
                this.mToolMenu = new SwanAppMenu(activity, this.mSwanAppActionBar, getMenuStyle(), SwanAppRuntime.getMenuExtensionRuntime(), new SwanAppMenuDecorate());
                new SwanAppMenuHelper(this.mToolMenu, this, this.mMenuHeader).setMenuItemClickListener();
                updateMenuOrientation(SwanAppUIUtils.isScreenLand());
            } else if (this.mToolMenu.isYouthModeChanged()) {
                this.mToolMenu.updateMenuUI();
                this.mToolMenu.updateYouthMode();
            }
        }
    }

    private void updateMenuOrientation(boolean isLandscape) {
        int menuOrientation;
        if (this.mToolMenu != null) {
            if (isLandscape) {
                menuOrientation = 1;
            } else {
                menuOrientation = 0;
            }
            this.mToolMenu.setScreenOrientation(menuOrientation);
        }
    }

    private int getMenuStyle() {
        if (SwanAppUtils.isLingJingAgent()) {
            return 23;
        }
        if (isSmartApp()) {
            if (isShowBackHomePage()) {
                return 18;
            }
            return 17;
        } else if (isShowBackHomePage()) {
            return 12;
        } else {
            return 15;
        }
    }

    public Pair<Integer, Integer> getCurWindowSize() {
        Pair<Integer, Integer> pair;
        ISwanAppSlaveManager iSwanAppSlaveManager = this.mCurWebViewManager;
        if (iSwanAppSlaveManager == null) {
            return new Pair<>(0, 0);
        }
        View webView = iSwanAppSlaveManager.getWebView().getCurrentWebView();
        if (webView != null) {
            pair = new Pair<>(Integer.valueOf(webView.getWidth()), Integer.valueOf(webView.getHeight()));
        }
        return pair;
    }

    public SwanAppBottomBarViewController getSwanAppBottomBarViewController() {
        return this.mSwanAppBottomBarViewController;
    }

    public SwanAppPageParam getCurSwanAppPageParams() {
        return this.mCurPageParams;
    }

    public SwanAppPageParam getPreSwanAppPageParams() {
        return this.mPrePageParams;
    }

    public SwanAppNARootViewManager getSwanAppNARootViewManager() {
        return this.mCurWebViewManager.getNARootViewManager();
    }

    public ISwanAppSlaveManager getCurrentWebViewManager() {
        return this.mCurWebViewManager;
    }

    public FloatLayer getFloatLayer() {
        if (this.mFloatLayer == null) {
            if (this.mRootView == null) {
                return null;
            }
            this.mFloatLayer = new FloatLayer((LinearLayout) this.mRootView.findViewById(com.baidu.swan.apps.R.id.ai_apps_fragment_base_view), getResourcesSafely().getDimensionPixelOffset(R.dimen.aiapps_normal_base_action_bar_height));
        }
        return this.mFloatLayer;
    }

    public WindowConfig getCurWindowConfig() {
        return this.mCurWindowConfig;
    }

    public PageOrientationConfig getOrientationConfig() {
        return this.mOrientationConfig;
    }

    private boolean isEnableBarTransparent() {
        WindowConfig windowConfig = this.mCurWindowConfig;
        return windowConfig != null && windowConfig.enableOpacityNavigationBar;
    }

    private boolean isEnableShowTtsNavigationButton() {
        ISwanFrameContainer frameContainer = Swan.get().getSwanFrameContainer();
        boolean isEmbedView = (frameContainer != null ? frameContainer.getContainerType() : null) == SwanFrameContainerType.EMBED_VIEW;
        if (isEnableNaviStyleCustom() || isEmbedView || !isCurrentNotHomePage() || !SwanAppRuntime.getSwanTTSEventManager().isShowNavigationBarTtsButton()) {
            return false;
        }
        return true;
    }

    public boolean isEnableNaviStyleCustom() {
        WindowConfig windowConfig = this.mCurWindowConfig;
        if (windowConfig != null) {
            return TextUtils.equals(windowConfig.navigationStyle, "custom");
        }
        return false;
    }

    private void initScrollChangedEventListener(String page) {
        if (!isEnableNaviStyleCustom()) {
            if (SwanAppController.getInstance().getPageWindowConfig(TextUtils.isEmpty(page) ? "" : page).enableOpacityNavigationBar && this.mOnScrollChangedForTransparentBar == null) {
                this.mOnScrollChangedForTransparentBar = new IOnScrollChangedListener() {
                    public void onScrollChanged(int l, int t, int oldl, int oldt) {
                        SwanAppFragment.this.updateBarTransparentDegree(t);
                    }
                };
            }
        }
    }

    private void addWebViewManagerListener(ISwanAppSlaveManager manager) {
        if (manager != null) {
            IOnScrollChangedListener iOnScrollChangedListener = this.mOnScrollChangedForTransparentBar;
            if (iOnScrollChangedListener != null) {
                manager.addOnScrollChangedListener(iOnScrollChangedListener);
            }
            manager.setWebViewWidgetChangeListener(getWebviewWidgetChangeListener());
        }
    }

    private IWebViewWidgetChangeListener getWebviewWidgetChangeListener() {
        return new IWebViewWidgetChangeListener() {
            public void onWebViewWidgetInsert(ISwanAppWebViewWidget webViewWidget) {
                if (webViewWidget != null) {
                    webViewWidget.addOnScrollChangedListener(SwanAppFragment.this.mOnScrollChangedForTransparentBar);
                    webViewWidget.setSwanAppWebViewWidgetListener(SwanAppFragment.this.getWebViewWidgetEventListener());
                    SwanAppPageMonitor.getInstance().onWebViewWidgetInsert(webViewWidget);
                }
            }

            public void onWebViewWidgetRemove(ISwanAppWebViewWidget webViewWidget) {
                if (webViewWidget != null) {
                    webViewWidget.removeOnScrollChangedListener(SwanAppFragment.this.mOnScrollChangedForTransparentBar);
                    SwanAppPageMonitor.getInstance().onWebViewWidgetRemove(webViewWidget);
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public DefaultWebViewWidgetListener getWebViewWidgetEventListener() {
        return new DefaultWebViewWidgetListener() {
            public void onReceivedTitle(String title) {
                SwanAppFragment.this.setActionbarTitle(title);
            }
        };
    }

    private void tryRemoveTransparentBarScrollListener(ISwanAppSlaveManager manager) {
        IOnScrollChangedListener iOnScrollChangedListener = this.mOnScrollChangedForTransparentBar;
        if (iOnScrollChangedListener != null && manager != null) {
            manager.removeOnScrollChangedListener(iOnScrollChangedListener);
            if (manager.getWebViewWidget() != null) {
                manager.removeOnScrollChangedListener(this.mOnScrollChangedForTransparentBar);
            }
        }
    }

    private void refreshBarTransparentType() {
        ISwanAppWebView ngWebView;
        if (this.mSwanAppActionBar != null) {
            int scrollY = 0;
            int titleAlpha = 1;
            boolean isBarTransparent = true;
            if (isEnableNaviStyleCustom()) {
                setNaviStyleCustom(true, this.mIsEnableFloatBackShow);
            } else if (isEnableBarTransparent()) {
                setNaviStyleCustom(false, false);
                ISwanAppSlaveManager iSwanAppSlaveManager = this.mCurWebViewManager;
                if (iSwanAppSlaveManager != null) {
                    if (iSwanAppSlaveManager.getWebViewWidget() != null) {
                        ngWebView = this.mCurWebViewManager.getWebViewWidget().getWebView();
                    } else {
                        ngWebView = this.mCurWebViewManager.getWebView();
                    }
                    if (ngWebView != null) {
                        scrollY = ngWebView.getWebViewScrollY();
                    }
                }
                WindowConfig windowConfig = this.mCurWindowConfig;
                if (windowConfig != null && windowConfig.enableOpacityNavigationBarText) {
                    titleAlpha = 0;
                }
            } else {
                setNaviStyleCustom(false, false);
                scrollY = TRANSPARENT_BAR_CHANGE_CRITICAL + this.mTransparentBarChangeSpacing;
                isBarTransparent = false;
            }
            this.mIsActionBarTransparent = isBarTransparent;
            TextView titleView = this.mSwanAppActionBar.getCenterTitleView();
            if (titleView != null) {
                titleView.setAlpha((float) titleAlpha);
            }
            updateBarTransparentDegree(scrollY);
            updateTopMargin(isBarTransparent, FontSizeSettingHelper.getFontSizeRadio());
        }
    }

    private void updateTopMargin(boolean isBarTransparent, float fontScareRatio) {
        FrameLayout.LayoutParams actionBarRootLp;
        FrameLayout.LayoutParams webViewContainerLp;
        int webViewContainerTopMargin = 0;
        int actionBarRootTopMargin = 0;
        int actionBarHeight = SwanAppUIUtils.getActionBarHeight(fontScareRatio);
        if (!isBarTransparent) {
            webViewContainerTopMargin = actionBarHeight;
        } else if (this.mImmersionHelper != null && this.mImmersionHelper.isOccupyStatusBar()) {
            actionBarRootTopMargin = SwanAppUIUtils.getCustomStatusBarHeight();
        }
        FrameLayout frameLayout = this.mWebViewContainer;
        if (!(frameLayout == null || (webViewContainerLp = (FrameLayout.LayoutParams) frameLayout.getLayoutParams()) == null)) {
            webViewContainerLp.topMargin = webViewContainerTopMargin;
            this.mWebViewContainer.setLayoutParams(webViewContainerLp);
        }
        if (this.mSwanAppActionBarRoot != null && (actionBarRootLp = (FrameLayout.LayoutParams) this.mSwanAppActionBarRoot.getLayoutParams()) != null) {
            actionBarRootLp.topMargin = actionBarRootTopMargin;
            actionBarRootLp.height = actionBarHeight;
            this.mSwanAppActionBarRoot.setLayoutParams(actionBarRootLp);
        }
    }

    /* access modifiers changed from: private */
    public void updateBarTransparentDegree(int scrollY) {
        TextView titleView;
        View statusBarView;
        Drawable statusBarViewBackground;
        float f2 = ((float) (scrollY - TRANSPARENT_BAR_CHANGE_CRITICAL)) * 1.0f;
        int i2 = this.mTransparentBarChangeSpacing;
        if (i2 == 0) {
            i2 = 1;
        }
        float percentage = f2 / ((float) i2);
        if (percentage <= 0.0f) {
            percentage = 0.0f;
        } else if (percentage >= 1.0f) {
            percentage = 1.0f;
        }
        int alpha = (int) (255.0f * percentage);
        if (!(!DEBUG || alpha == 0 || alpha == 255)) {
            Log.d(TAG, "update bar transparent degree: " + percentage + " : " + alpha);
        }
        if (!(this.mImmersionHelper == null || !this.mImmersionHelper.isOccupyStatusBar() || (statusBarView = this.mImmersionHelper.getCurStatusBarView()) == null || (statusBarViewBackground = statusBarView.getBackground()) == null)) {
            statusBarViewBackground.setAlpha(alpha);
        }
        Drawable actionBarBackground = this.mSwanAppActionBar.getBackground();
        if (actionBarBackground != null) {
            actionBarBackground.setAlpha(alpha);
        }
        WindowConfig windowConfig = this.mCurWindowConfig;
        if (!(windowConfig == null || !windowConfig.enableOpacityNavigationBarText || (titleView = this.mSwanAppActionBar.getCenterTitleView()) == null)) {
            titleView.setAlpha(percentage);
        }
        Drawable titleShadowBackground = this.mTitleShadowView.getBackground();
        if (titleShadowBackground != null) {
            titleShadowBackground.setAlpha(alpha);
        }
    }

    private void beginFlow() {
        this.mUrlLoadFlow = SwanAppUBCStatistic.createFlow(IStat.UBC_CERES_FLOW_ID_SWAN_APP_URL_LOAD);
    }

    public void loadUrlFinishedFromJS(SwanAppUrlLoadFlowEvent endEvent) {
        StatFlow statFlow = this.mUrlLoadFlow;
        if (statFlow != null) {
            SwanAppUBCStatistic.endFlow(statFlow, endEvent);
            this.mUrlLoadFlow = null;
        }
    }

    public void disableNaviStyleCustom() {
        this.mCurWindowConfig.navigationStyle = "default";
        applyImmersion();
        refreshBarTransparentType();
    }

    public boolean isFirstPage() {
        if (this.mParam != null) {
            return this.mParam.isFirstPage();
        }
        return false;
    }

    public static void setLastPageParams(SwanAppPageParam pageParam) {
        try {
            if (DEBUG) {
                Log.d(TAG, "setLastPageParams =" + pageParam);
            }
            if (pageParam == null) {
                sLastPageParams = null;
            } else {
                sLastPageParams = (SwanAppPageParam) pageParam.clone();
            }
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    public void updateNonFirstPageFlag() {
        if (this.mParam != null) {
            this.mParam.updateNonFirstPageFlag();
        }
    }

    public SwanAppPinchSummaryHandler getPinchSummaryHandler() {
        return this.mPinchSummaryHandler;
    }

    private void getRightMenuRefreshTips(boolean force) {
        if (SwanAppRuntime.getMenuExtensionRuntime().isGetRightMenuRefreshTips(force, 1)) {
            SwanAppMessageHelper.updateMenuRedDotRefresh(this.mPageContainer.getContext(), this.mSwanAppActionBar, Swan.get().getApp().getInfo().getPmsAppInfo().paNumber);
            return;
        }
        SwanAppMessageHelper.updateRightMenuRedDots(this.mSwanAppActionBar, Swan.get().getApp().getGlobalVar().getInteger(SwanAppGlobalVar.INT_VAR_KEY_UNREAD_COUNTS, 0).intValue());
    }

    private void getMenuToolRefreshTips(boolean force) {
        if (SwanAppRuntime.getMenuExtensionRuntime().isGetRightMenuRefreshTips(force, 2)) {
            SwanAppMessageHelper.updateMenuToolsRefreshTips(this.mPageContainer.getContext(), this.mToolMenu, this.mSwanAppActionBar, Swan.get().getApp().getInfo().getPmsAppInfo().paNumber);
        }
    }

    private void hideCustomView() {
        SwanInlineCustomViewHelper customViewHelper;
        ISwanAppSlaveManager slaveManager = getCurrentWebViewManager();
        if ((slaveManager instanceof SwanAppWebViewManager) && (customViewHelper = ((SwanAppWebViewManager) slaveManager).getCustomViewHelper()) != null) {
            customViewHelper.hideCustomView();
        }
    }

    private void checkAndSetCustomCloseIcon() {
        SwanAppConfigData configData;
        SwanApp swanApp;
        ISwanFrameContainer frameContainer = Swan.get().getSwanFrameContainer();
        if (frameContainer != null && frameContainer.getContainerType() == SwanFrameContainerType.EMBED_VIEW && (configData = SwanAppController.getInstance().getConfigData()) != null) {
            final String iconPath = configData.mCustomHalfScreenIconPath;
            final String appPath = this.mParam.getBaseUrl();
            if (!TextUtils.isEmpty(iconPath) && !TextUtils.isEmpty(appPath) && (swanApp = SwanApp.getOrNull()) != null && !TextUtils.isEmpty(swanApp.getAppId())) {
                swanApp.getSetting().checkOrAuthorize(Swan.get().getActivity(), ScopeInfo.SCOPE_ID_HALF_SCREEN_CUSTOM_CLOSE_ICON, new TypedCallback<TaskResult<Authorize.Result>>() {
                    public void onCallback(TaskResult<Authorize.Result> result) {
                        if (OAuthUtils.isAuthorizeOk(result)) {
                            Bitmap iconBitmap = null;
                            try {
                                iconBitmap = BitmapFactory.decodeFile((appPath.endsWith(File.separator) ? appPath : appPath + File.separator) + (iconPath.startsWith(File.separator) ? iconPath.substring(1) : iconPath));
                            } catch (Exception e2) {
                            }
                            if (iconBitmap != null) {
                                SwanAppFragment.this.mSwanAppActionBar.setRightCloseImageSrcCustom(iconBitmap);
                            }
                        }
                    }
                });
            }
        }
    }

    public static String getPageOpt(String page, String routePage) {
        if (SWITCH_TAB_ROUTE_OPT) {
            return routePage;
        }
        return page;
    }

    private static class FragmentDestroySwitch {
        private static final String AB_KEY_FRAGMENT_DESTROY_SWITCH = "swan_app_fragment_destroy_switch";
        private static final int AB_VALUE_ENABLE = 1;
        private static final int AB_VALUE_NORMAL = 0;
        static int sFragmentDestroySwitch = -1;

        private FragmentDestroySwitch() {
        }

        static int getPostDestroySwitch() {
            if (sFragmentDestroySwitch < 0) {
                sFragmentDestroySwitch = SwanAppRuntime.getSwanAppAbTestRuntime().getSwitch(AB_KEY_FRAGMENT_DESTROY_SWITCH, 1);
            }
            if (SwanAppFragment.DEBUG) {
                Log.d(SwanAppFragment.TAG, "getFragmentDestroySwitch:" + sFragmentDestroySwitch);
            }
            return sFragmentDestroySwitch;
        }

        static boolean isPostDestroyEnable() {
            return getPostDestroySwitch() > 0;
        }
    }
}
