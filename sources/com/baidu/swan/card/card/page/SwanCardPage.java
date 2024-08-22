package com.baidu.swan.card.card.page;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.gamecore.util.GameCenterUtils;
import com.baidu.swan.apps.pullrefresh.PullToRefreshBaseWebView;
import com.baidu.swan.card.R;
import com.baidu.swan.card.api.component.SwanAppNARootViewManager;
import com.baidu.swan.card.card.SwanCard;
import com.baidu.swan.card.card.SwanCardController;
import com.baidu.swan.card.card.SwanCardManager;
import com.baidu.swan.card.card.core.SwanCardRenderPool;
import com.baidu.swan.card.card.core.SwanCardSlavePool;
import com.baidu.swan.card.card.page.event.FontSizeSettingEvent;
import com.baidu.swan.card.card.page.event.NightModeChangeEvent;
import com.baidu.swan.card.card.page.event.PageReadyEvent;
import com.baidu.swan.card.launch.dispatcher.EventSubscriber;
import com.baidu.swan.card.launch.dispatcher.SwanCardEventDispatcher;
import com.baidu.swan.card.launch.model.SwanCardPageParam;
import com.baidu.swan.card.launch.model.SwanCardParam;
import com.baidu.swan.card.launch.model.SwanEvents;
import com.baidu.swan.card.pkg.config.CardWindowConfig;
import com.baidu.swan.card.pkg.config.SwanCardConfigData;
import com.baidu.swan.card.pkg.config.SwanCardPageAlias;
import com.baidu.swan.card.pkg.model.SwanEvent;
import com.baidu.swan.card.render.engine.event.msg.SwanAppLifecycleMessage;
import com.baidu.swan.card.render.jscontainer.interfaces.IMasterBinder;
import com.baidu.swan.card.render.jscontainer.interfaces.ISwanAppSlaveManager;
import com.baidu.swan.card.render.jscontainer.interfaces.SwanAppMasterContainer;
import com.baidu.swan.card.ubc.SwanCardUBCStatistic;
import com.baidu.swan.card.utils.SwanAppLibConfig;
import com.baidu.swan.card.utils.SwanCardImmersionHelper;
import com.baidu.swan.card.utils.SwanCardLog;
import com.baidu.swan.card.utils.SwanCardUtil;
import com.baidu.swan.card.utils.typedbox.TypedCallback;
import com.baidu.swan.card.utils.typedbox.TypedMapping;
import java.util.HashMap;
import java.util.Map;

public class SwanCardPage extends SwanCardBasePage {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String PARAM_KEY = "ai_apps_param";
    public static final String TAG = "SwanCardPage";
    private static SwanCardPageParam sLastPageParams;
    private static String sRouteType;
    /* access modifiers changed from: private */
    public SwanCardPageParam mCurPageParams = new SwanCardPageParam();
    private ISwanAppSlaveManager mCurWebViewManager;
    private CardWindowConfig mCurWindowConfig;
    private SwanCardPageParam mPrePageParams;
    private View mRootView;
    private final EventSubscriber mSubscriber = new EventSubscriber();
    private FrameLayout mWebViewContainer;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restoreArguments();
        initEventHandler();
        if (DEBUG) {
            Log.d(TAG, "onCreate() obj: " + this);
        }
    }

    private void restoreArguments() {
        Bundle bundle = this.mPageContainer.getPageArguments();
        if (bundle != null) {
            this.mPrePageParams = sLastPageParams;
            if (DEBUG) {
                Log.d(TAG, "restoreArguments sPrePageParams=" + this.mPrePageParams);
            }
            this.mParam = SwanCardParam.createSwanAppParam(bundle.getString(PARAM_KEY));
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
                this.mCurPageParams.cardId = this.mParam.getCardId();
            }
            SwanCardPageParam swanCardPageParam = this.mCurPageParams;
            swanCardPageParam.mRoutePage = SwanCardPageAlias.checkRoutesPath(swanCardPageParam.cardId, this.mCurPageParams.getPage());
            CardWindowConfig pageWindowConfig = SwanCardController.getInstance().getPageWindowConfig(this.mCurPageParams.cardId, this.mCurPageParams.getRoutePage());
            this.mCurWindowConfig = pageWindowConfig;
            if (pageWindowConfig.isModifyByUser) {
                this.mCurWindowConfig = SwanCardController.getInstance().obtainNewWindowConfig(this.mCurPageParams.cardId, this.mCurPageParams.getPage());
            }
            if (this.isTransparent) {
                this.mCurWindowConfig.enablePullRefresh = false;
                this.mCurWindowConfig.enableOpacityNavigationBar = true;
                this.mCurWindowConfig.isModifyByUser = true;
            }
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (DEBUG) {
            Log.d(TAG, "onAttach() obj: " + this);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = LayoutInflater.from(AppRuntime.getAppContext()).inflate(R.layout.card_page, container, false);
        this.mWebViewContainer = (FrameLayout) rootView.findViewById(R.id.ai_apps_card_page_content);
        initActionBar();
        createSlaveWebView(rootView);
        this.mRootView = rootView;
        return rootView;
    }

    private void initActionBar() {
        String text = this.mCurWindowConfig.navigationBarTitle;
        int bgColor = this.mCurWindowConfig.navigationBarBgColor;
        int textColor = SwanCardConfigData.parseColor(this.mCurWindowConfig.navigationBarTextStyle);
        SwanEvent.Impl barUpdate = new SwanEvent.Impl(SwanEvents.ActionBarUpdate.EVENT_NAME);
        barUpdate.putBoolean("enable", !TextUtils.equals(this.mCurWindowConfig.navigationStyle, "custom"));
        barUpdate.putString("title", text);
        barUpdate.putInt("txtColor", textColor);
        barUpdate.putInt("bgColor", bgColor);
        SwanCardEventDispatcher.dispatchEvent(this.mCurPageParams.cardId, barUpdate);
    }

    private void initEventHandler() {
        this.mSubscriber.addEventFilter(new TypedMapping<SwanEvent.Impl, Boolean>() {
            public Boolean map(SwanEvent.Impl k) {
                SwanCard swanCard = SwanCardManager.get().getCardOrNull(SwanCardPage.this.mCurPageParams.cardId);
                return Boolean.valueOf(swanCard != null && !swanCard.isContainerFinishing() && !swanCard.isDestroyed());
            }
        }).subscribe(new TypedCallback<SwanEvent.Impl>() {
            public void onCallback(SwanEvent.Impl msg) {
                if (SwanCardPage.DEBUG) {
                    Log.d(SwanCardPage.TAG, "msg_font_size_change");
                }
                FontSizeSettingEvent.sendFontSizeChangeEvent(SwanCardPage.this.mCurPageParams.cardId, SwanCardPage.this.getSlaveWebViewId());
            }
        }, SwanEvents.MSG_FONT_SIZE_CHANGE).subscribe(new TypedCallback<SwanEvent.Impl>() {
            public void onCallback(SwanEvent.Impl msg) {
                if (SwanCardPage.DEBUG) {
                    Log.d(SwanCardPage.TAG, "msg_night_mode_changed");
                }
                NightModeChangeEvent.sendNightModeChangeEvent(SwanCardPage.this.mCurPageParams.cardId, SwanCardPage.this.getSlaveWebViewId());
            }
        }, SwanEvents.MSG_NIGHT_MODE_CHANGED);
        SwanCardEventDispatcher.addEventCallback(this.mCurPageParams.cardId, this.mSubscriber);
    }

    public PullToRefreshBaseWebView getPullToRefreshWebView() {
        ISwanAppSlaveManager iSwanAppSlaveManager = this.mCurWebViewManager;
        if (iSwanAppSlaveManager != null) {
            return iSwanAppSlaveManager.getPullToRefreshWebView();
        }
        return null;
    }

    public void onStart() {
        super.onStart();
        performStart();
    }

    public void onResume() {
        super.onResume();
        performResume();
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
        }
        if (DEBUG) {
            Log.d(TAG, Log.getStackTraceString(new Exception("performStart() wvID: " + this.mCurWebViewManager.getWebViewId())));
        }
    }

    private void performResume() {
        if (this.mPageContainer.getUserVisibleHint()) {
            resume();
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

    private void createSlaveWebView(View rootView) {
        String baseUrl = this.mParam.getBaseUrl();
        String params = this.mParam.getParams();
        String page = this.mParam.getPage();
        String pageUrl = SwanCardUtil.buildPageUrl(this.mParam.getCardId(), baseUrl, page, params);
        this.mCurWebViewManager = SwanCardSlavePool.getSlaveManager(this.mParam.getCardId(), pageUrl);
        boolean z = DEBUG;
        if (z) {
            Log.d(TAG, "pageUrl: " + pageUrl + " is load: " + (this.mCurWebViewManager != null));
        }
        if (this.mCurWebViewManager == null) {
            if (z) {
                Log.e(TAG, Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
            }
            this.mCurWebViewManager = createSlaveAndLoad(this.mParam.getCardId(), baseUrl, page, params, "");
        }
        this.mCurWebViewManager.setPageParam(this.mCurPageParams);
        CardWindowConfig config = SwanCardController.getInstance().getPageWindowConfig(this.mParam.mCardId, page);
        this.mCurWebViewManager.setBackgroundColor(this.mWebViewContainer, config);
        this.mCurWebViewManager.addToParent(this.mParam.getCardId(), this.mWebViewContainer, config);
        addWebViewManagerListener(this.mCurWebViewManager);
    }

    public void onDetach() {
        super.onDetach();
    }

    public void onDestroyView() {
        super.onDestroyView();
        ISwanAppSlaveManager iSwanAppSlaveManager = this.mCurWebViewManager;
        if (iSwanAppSlaveManager != null) {
            iSwanAppSlaveManager.destroyView();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        destroyWebView();
        SwanCardEventDispatcher.delEventCallback(this.mCurPageParams.cardId, this.mSubscriber);
    }

    private void destroyWebView() {
        ISwanAppSlaveManager iSwanAppSlaveManager = this.mCurWebViewManager;
        if (iSwanAppSlaveManager != null) {
            iSwanAppSlaveManager.destroy();
        }
        this.mCurWebViewManager = null;
        if (DEBUG) {
            Log.d(TAG, "onDestroy() obj: " + this);
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (this.mPageContainer.isPageAdded()) {
            super.setUserVisibleHint(isVisibleToUser);
            if (DEBUG) {
                Log.d(TAG, "setUserVisibleHint isVisibleToUser: " + isVisibleToUser);
            }
            if (isVisibleToUser) {
                resume();
            } else {
                pause();
            }
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
    }

    public void resume() {
        ISwanAppSlaveManager iSwanAppSlaveManager = this.mCurWebViewManager;
        boolean isSlaveWebViewNull = iSwanAppSlaveManager == null;
        String slaveId = isSlaveWebViewNull ? "" : iSwanAppSlaveManager.getWebViewId();
        if (DEBUG) {
            Log.d(TAG, "resume() wvID: " + slaveId);
        }
        if (!isSlaveWebViewNull) {
            this.mCurWebViewManager.onResume();
            sendLifecycleMessage("onPageShow");
        }
        SwanCardUBCStatistic.onShowEvent(this.mCurPageParams.cardId);
        SwanCardLog.i(TAG, "onPageShow");
    }

    public void pause() {
        PullToRefreshBaseWebView webView;
        ISwanAppSlaveManager iSwanAppSlaveManager = this.mCurWebViewManager;
        boolean isSlaveWebViewNull = iSwanAppSlaveManager == null;
        String slaveId = isSlaveWebViewNull ? "" : iSwanAppSlaveManager.getWebViewId();
        if (DEBUG) {
            Log.d(TAG, "pause() wvID: " + slaveId);
        }
        if (!isSlaveWebViewNull) {
            this.mCurWebViewManager.onPause();
            sendLifecycleMessage(SwanAppLifecycleMessage.TYPE_HIDE);
        }
        SwanCardLog.i(TAG, SwanAppLifecycleMessage.TYPE_HIDE);
        if (!isSlaveWebViewNull && (webView = this.mCurWebViewManager.getPullToRefreshWebView()) != null) {
            webView.onPullDownRefreshComplete(false);
        }
    }

    public void stop() {
    }

    private void sendLifecycleMessage(String type) {
        HashMap<String, String> values = new HashMap<>();
        values.put("miniId", this.mCurPageParams.cardId);
        values.put("wvID", this.mCurWebViewManager.getWebViewId());
        SwanAppLifecycleMessage lifecycleMessage = new SwanAppLifecycleMessage(type, (Map<String, String>) values);
        if (DEBUG) {
            Log.d(TAG, "sendLifecycleMessage type: " + type + " wvID: " + this.mCurWebViewManager.getWebViewId());
        }
        SwanCardController.getInstance().sendJSMessage(this.mCurWebViewManager.getWebViewId(), lifecycleMessage);
    }

    private ISwanAppSlaveManager createSlaveAndLoad(String cardId, String baseUrl, String page, String params, String routeId) {
        boolean z = DEBUG;
        if (z) {
            Log.d(TAG, "createSlaveAndLoad start.");
        }
        String str = cardId;
        SwanCardRenderPool.PreloadSlaveManager preloadManager = SwanCardSlavePool.getPreloadSlaveManager(cardId, this.mPageContainer.getAttachedActivity());
        if (z) {
            Log.d(TAG, "createSlaveAndLoad preloadManager: " + preloadManager);
        }
        final String str2 = cardId;
        final SwanCardRenderPool.PreloadSlaveManager preloadSlaveManager = preloadManager;
        final String str3 = baseUrl;
        final String str4 = params;
        final String str5 = page;
        SwanCardUtil.runOnUiThread(new Runnable() {
            public void run() {
                SwanAppMasterContainer master = SwanCardController.getInstance().getCardRuntime(str2).getMasterContainer();
                if (master != null) {
                    ((IMasterBinder) preloadSlaveManager.slaveManager).bindMaster(master, new IMasterBinder.IMasterBindCallback() {
                        public void onBindReady(String url) {
                            SwanCard swanCard = SwanCardManager.get().getCardOrNull(str2);
                            if (swanCard != null && swanCard.getConfig() != null) {
                                PageReadyEvent.sendPageReadyEvent(str2, preloadSlaveManager.slaveManager, swanCard.getInfo(), swanCard.getConfig(), str3, TextUtils.isEmpty(str4) ? str5 : str5 + GameCenterUtils.SCHEME_SWAN_SUFFIX + str4);
                            }
                        }
                    });
                }
            }
        });
        if (z) {
            Log.d(TAG, "createSlaveAndLoad end.");
        }
        return preloadManager.slaveManager;
    }

    public FrameLayout getWebViewContainer() {
        return this.mWebViewContainer;
    }

    public static SwanCardPage newInstance(SwanCardParam param) {
        SwanCardPage swanCardPage = new SwanCardPage();
        if (param != null) {
            Bundle bundle = new Bundle();
            bundle.putString(PARAM_KEY, param.toJSONString());
            swanCardPage.getPageContainer().setPageArguments(bundle);
        }
        return swanCardPage;
    }

    public String getSlaveWebViewId() {
        ISwanAppSlaveManager iSwanAppSlaveManager = this.mCurWebViewManager;
        if (iSwanAppSlaveManager != null) {
            return iSwanAppSlaveManager.getWebViewId();
        }
        return "";
    }

    public SwanCardPageParam getCurSwanAppPageParams() {
        return this.mCurPageParams;
    }

    public SwanCardPageParam getPreSwanAppPageParams() {
        return this.mPrePageParams;
    }

    public SwanAppNARootViewManager getSwanAppNARootViewManager() {
        return this.mCurWebViewManager.getNARootViewManager();
    }

    public ISwanAppSlaveManager getCurrentWebViewManager() {
        return this.mCurWebViewManager;
    }

    public CardWindowConfig getCurWindowConfig() {
        return this.mCurWindowConfig;
    }

    private void addWebViewManagerListener(ISwanAppSlaveManager manager) {
    }

    public static void setLastPageParams(SwanCardPageParam pageParam) {
        try {
            if (DEBUG) {
                Log.d(TAG, "setLastPageParams =" + pageParam);
            }
            if (pageParam == null) {
                sLastPageParams = null;
            } else {
                sLastPageParams = (SwanCardPageParam) pageParam.clone();
            }
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    public void setNavigationBarFrontColor(int color) {
        setNavigationBarFrontColor(color, "", false);
    }

    public void setNavigationBarFrontColor(String color, boolean isModifyByUser) {
        setNavigationBarFrontColor(SwanCardConfigData.parseColor(color), color, isModifyByUser);
    }

    /* access modifiers changed from: protected */
    public void setNavigationBarFrontColor(int color, String colorString, boolean isModifyByUser) {
        if (this.mActivity != null && this.mActivity.getWindow() != null) {
            SwanCardImmersionHelper.setStatusBarLightMode(this.mActivity.getWindow(), (color == -16777216 ? (char) 0 : 65535) == 0);
        }
    }
}
