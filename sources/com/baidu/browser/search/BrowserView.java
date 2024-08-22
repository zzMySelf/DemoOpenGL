package com.baidu.browser.search;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.browser.Browser;
import com.baidu.browser.BrowserRuntime;
import com.baidu.browser.explore.network.NaRequestManager;
import com.baidu.browser.framework.AbsBdFrameView;
import com.baidu.browser.framework.BdWindowBundleManager;
import com.baidu.browser.framework.BdWindowWrapper;
import com.baidu.browser.framework.BeeBdWindow;
import com.baidu.browser.searchfps.SearchFPSMonitor;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.search.basic.utils.SearchABTestUtils;
import com.baidu.search.basic.utils.SearchUtils;
import com.baidu.search.core.utils.IncognitoModeUtil;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.appframework.MainContext;
import com.baidu.searchbox.browserenhanceengine.BeeRootWindow;
import com.baidu.searchbox.favor.IFavorManager;
import com.baidu.searchbox.favor.callback.SyncCallback;
import com.baidu.searchbox.favor.data.SyncType;
import com.baidu.searchbox.multiwindowinterface.MultiWindowInterface;
import com.baidu.searchbox.pinchsummary.interfaces.OnPinchSummaryDataSourceCallback;
import com.baidu.searchbox.pinchsummary.model.PinchSummaryEntity;
import com.baidu.searchbox.schemedispatch.united.module.UnitedSchemeBrowserDispatcher;
import com.baidu.searchbox.search.SearchManager;
import com.baidu.searchbox.speech.SpeechHelper;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.statistic.BaseSpeedLogger;
import com.baidu.statistic.SpeedLoggerConstants;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBC;
import com.baidu.voice.pyramid.VoiceWakeUpInterface;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class BrowserView extends LightSearchView {
    private static final boolean DEBUG = BrowserRuntime.GLOBAL_DEBUG;
    private static final String STATE_HAS_BROWSER = "maint_state_has_browser";
    private static final String TAG = "BrowserView";
    private boolean hasOnSaveState = false;
    private Browser mBrowser;
    /* access modifiers changed from: private */
    public AbsBdFrameView mFrameView;
    private MainContext mMainContext;
    private Flow mUBCBrowserDurationFlow;
    private SlideInterceptor slideInterceptor;

    public BrowserView() {
    }

    BrowserView(MainContext context) {
        this.mMainContext = context;
        initBrowser();
    }

    /* access modifiers changed from: protected */
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (DEBUG) {
            Log.d(TAG, "onCreateView");
        }
        initBrowser();
        getBrowser().clearSpeedInfos();
        if (savedInstanceState != null) {
            restoreFromBundle(savedInstanceState);
        }
        this.mFrameView.attachToBrowserFragment();
        return this.mFrameView;
    }

    public void onActive() {
        super.onActive();
    }

    public void onStart() {
        super.onStart();
        AbsBdFrameView absBdFrameView = this.mFrameView;
        if (absBdFrameView != null) {
            absBdFrameView.onStart();
        }
    }

    public void onResume() {
        this.hasOnSaveState = false;
        BdWindowBundleManager.getInstance().resetHasSaveToBundle();
        BeeBdWindow current = this.mFrameView.getCurrentWindow();
        MultiWindowInterface multiWindowInterface = (MultiWindowInterface) ServiceManager.getService(MultiWindowInterface.SERVICE_REFERENCE);
        if (multiWindowInterface != null) {
            if (current != null && !multiWindowInterface.getWindowList().contains(current)) {
                this.mMainContext.finishBrowserState();
            } else if (current != null && current.getIsClosing()) {
                this.mMainContext.finishBrowserState();
            } else if (current == null || this.mFrameView.checkCurrentWindowParentIsValid()) {
                boolean z = DEBUG;
                if (z) {
                    Log.d(TAG, "BrowserView onResume----");
                }
                if (!isResumed()) {
                    VoiceWakeUpInterface voiceWakeUpInterface = (VoiceWakeUpInterface) ServiceManager.getService(VoiceWakeUpInterface.SERVICE_REFERENCE);
                    if (voiceWakeUpInterface != null) {
                        voiceWakeUpInterface.startVoiceWakeUp(getContext(), SpeechHelper.getVoiceWakeUpParams("searchResult"));
                    }
                    this.mFrameView.setFrameViewShowing(true);
                    this.mFrameView.onResume((Intent) null);
                    this.mFrameView.setVisibility(0);
                    if (z) {
                        Log.i(TAG, "BrowserView onResume, perform frame view onResume() ----");
                    }
                    this.mUBCBrowserDurationFlow = UBC.beginFlow("443");
                    super.onResume();
                }
            } else {
                if (DEBUG) {
                    Log.i(TAG, "当前窗口parent不对");
                }
                this.mMainContext.finishBrowserState();
            }
        }
    }

    public void onPause() {
        if (DEBUG) {
            Log.d(TAG, "BrowserView onPause----");
        }
        this.mFrameView.setEnableGlobalLayoutListener(false);
        this.mFrameView.setFrameViewShowing(false);
        this.mFrameView.closeSelectedMenu();
        this.mFrameView.dismissBrowserMenu();
        this.mFrameView.onPause();
        ((IFavorManager) ServiceManager.getService(IFavorManager.SERVICE_REFERENCE)).doFavorSyncRequest(SyncType.SAVE, (SyncCallback) null);
        if (this.mUBCBrowserDurationFlow != null) {
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("from", "search");
                jsonObject.put("type", "frame_duration");
            } catch (Exception e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
            this.mUBCBrowserDurationFlow.setValueWithDuration(jsonObject.toString());
            this.mUBCBrowserDurationFlow.end();
        }
        VoiceWakeUpInterface voiceWakeUpInterface = (VoiceWakeUpInterface) ServiceManager.getService(VoiceWakeUpInterface.SERVICE_REFERENCE);
        if (voiceWakeUpInterface != null) {
            voiceWakeUpInterface.stopVoiceWakeUp(getContext(), SpeechHelper.getVoiceWakeUpParams("searchResult"));
        }
        super.onPause();
    }

    public void onStop() {
        super.onStop();
        AbsBdFrameView absBdFrameView = this.mFrameView;
        if (absBdFrameView != null) {
            absBdFrameView.onStop();
        }
    }

    public void onInActive() {
        super.onInActive();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        AbsBdFrameView absBdFrameView = this.mFrameView;
        if (absBdFrameView != null) {
            return absBdFrameView.onKeyDown(keyCode, event);
        }
        return false;
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        AbsBdFrameView absBdFrameView = this.mFrameView;
        if (absBdFrameView != null) {
            return absBdFrameView.onKeyUp(keyCode, event);
        }
        return false;
    }

    public void onSaveState(Bundle outState) {
        if (DEBUG) {
            Log.d(TAG, "onSaveState mFragmeView = " + this.mFrameView);
        }
        this.hasOnSaveState = true;
        if (this.mFrameView != null) {
            outState.putBoolean(STATE_HAS_BROWSER, true);
            if (SearchABTestUtils.isColdBootRestoreMultiWindow()) {
                BdWindowBundleManager.getInstance().restoreFromBundle(this.mFrameView);
                outState.putBoolean(BdWindowBundleManager.RECORD_NOT_RESTORE_CUR_WINDOW, true);
            }
            this.mFrameView.saveStateToBundle(outState);
            if (SearchABTestUtils.isColdBootRestoreMultiWindow()) {
                BdWindowBundleManager.getInstance().saveStateBundleToFile(outState);
            }
        }
    }

    public void onStateResult(int requestCode, int resultCode, Intent data) {
        super.onStateResult(requestCode, resultCode, data);
        Browser browser = this.mBrowser;
        if (browser != null) {
            browser.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Browser browser = this.mBrowser;
        if (browser != null) {
            browser.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    /* access modifiers changed from: package-private */
    public void handleIntent(Intent intent) {
        AbsBdFrameView absBdFrameView;
        boolean z = DEBUG;
        if (z) {
            Log.d(TAG, "handleIntent");
        }
        setIntent(intent);
        initBrowser();
        Context context = SearchUtils.convertContextToActivity(this.mFrameView.getContext());
        if (this.mFrameView != null && BrowserRuntime.getContext() != null && !BrowserRuntime.getSearch().isMainActivity(context) && !BrowserRuntime.getContext().isLightSearchActivity(context)) {
            this.mFrameView.releaseCurrentWindow();
        }
        boolean isOpenInNewWindow = intent.getBooleanExtra("EXTRA_URL_NEW_WINDOW", false);
        MultiWindowInterface multiWindowInterface = (MultiWindowInterface) ServiceManager.getService(MultiWindowInterface.SERVICE_REFERENCE);
        if (!(multiWindowInterface != null || (absBdFrameView = this.mFrameView) == null || absBdFrameView.getCurrentWindow() == null)) {
            isOpenInNewWindow = false;
            intent.putExtra("EXTRA_URL_NEW_WINDOW", false);
        }
        if (isOpenInNewWindow && multiWindowInterface != null && multiWindowInterface.size(IncognitoModeUtil.isIncognitoSwitchOn()) >= multiWindowInterface.getMaxCount()) {
            if (z) {
                multiWindowInterface.showCreateWindowFailedToast(getContext(), IncognitoModeUtil.isIncognitoSwitchOn());
            }
            this.mMainContext.finishBrowserState();
        }
        initFromIntent(intent);
    }

    public Browser getBrowser() {
        return this.mBrowser;
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Deprecated
    public boolean isFrameViewShowing() {
        AbsBdFrameView absBdFrameView = this.mFrameView;
        return absBdFrameView != null && absBdFrameView.isFrameViewShowing();
    }

    private void restoreFromBundle(Bundle savedInstanceState) {
        if (DEBUG) {
            Log.d(TAG, "restoreFromBundle");
        }
        if (this.mFrameView != null) {
            if (SearchABTestUtils.isColdBootRestoreMultiWindow()) {
                BdWindowWrapper.releaseWindowList();
                BdWindowBundleManager.getInstance().resetCacheSizeData();
                if (savedInstanceState != null) {
                    try {
                        savedInstanceState.remove(BdWindowBundleManager.RECORD_NOT_RESTORE_CUR_WINDOW);
                    } catch (Exception e2) {
                        if (DEBUG) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            this.mFrameView.restoreFromBundle(savedInstanceState, false);
        }
    }

    public void onLowMemory() {
        if (DEBUG) {
            Log.d(TAG, "onLowMemory");
        }
        AbsBdFrameView absBdFrameView = this.mFrameView;
        if (absBdFrameView != null) {
            absBdFrameView.freeMemory();
        }
    }

    public void onConfigurationChanged(Configuration config) {
        if (DEBUG) {
            Log.d(TAG, "onConfigurationChanged");
        }
        super.onConfigurationChanged(config);
        AbsBdFrameView absBdFrameView = this.mFrameView;
        if (absBdFrameView != null) {
            absBdFrameView.onConfigurationChanged(config);
        }
    }

    public void onDestroyView() {
        if (DEBUG) {
            Log.d(TAG, "onDestroyView");
        }
        AbsBdFrameView absBdFrameView = this.mFrameView;
        if (absBdFrameView != null) {
            absBdFrameView.dismissBrowserMenu();
        }
    }

    public void onDestroy() {
        if (DEBUG) {
            Log.d(TAG, "onDestroy");
        }
        super.onDestroy();
        AbsBdFrameView absBdFrameView = this.mFrameView;
        if (absBdFrameView != null) {
            absBdFrameView.resetPrefetchState();
        }
        MultiWindowInterface multiWindowInterface = (MultiWindowInterface) ServiceManager.getService(MultiWindowInterface.SERVICE_REFERENCE);
        if (multiWindowInterface != null) {
            for (BeeRootWindow window : multiWindowInterface.getWindowList()) {
                if (window instanceof BeeBdWindow) {
                    ((BeeBdWindow) window).resetSearchBoxInfo();
                }
            }
            SearchFPSMonitor.stop();
        }
    }

    public void onActivityDestroy() {
        boolean z = DEBUG;
        if (z) {
            Log.d(TAG, "onActivityDestroy");
        }
        super.onActivityDestroy();
        AbsBdFrameView absBdFrameView = this.mFrameView;
        if (absBdFrameView != null) {
            BeeBdWindow current = absBdFrameView.getCurrentWindow();
            if (current != null && this.mFrameView.checkCurrentWindowParentIsValid()) {
                if (z) {
                    Log.i(TAG, "activity关闭触发关闭窗口");
                }
                this.mFrameView.setCurrentWindowUseState(false);
                this.mFrameView.closeWindow(current);
            }
            MultiWindowInterface multiWindowInterface = (MultiWindowInterface) ServiceManager.getService(MultiWindowInterface.SERVICE_REFERENCE);
            boolean isMainActivityLast = false;
            if (BrowserRuntime.getContext() != null) {
                isMainActivityLast = BrowserRuntime.getContext().isInMainContext(BdBoxActivityManager.getPenultimateActivity());
                if (SearchABTestUtils.isColdBootRestoreMultiWindow() && !isMainActivityLast) {
                    isMainActivityLast = BrowserRuntime.getContext().isInMainContext(BdBoxActivityManager.getRealTopActivity());
                }
            }
            if (this.mBrowser != null && (((BdBoxActivityManager.getActivityCount() == 2 && isMainActivityLast) || BdBoxActivityManager.getActivityCount() == 1) && multiWindowInterface != null)) {
                if (multiWindowInterface.size() > 0) {
                    BdWindowBundleManager.getInstance().saveStateToBundle(this.mFrameView);
                    this.mBrowser.releaseFromSimple();
                } else if (SearchABTestUtils.isColdBootRestoreMultiWindow()) {
                    BdWindowBundleManager.getInstance().clearBundleFileDataIfNeed();
                    if (SearchABTestUtils.isBeeDiskCacheOpt()) {
                        int size = multiWindowInterface.size(false);
                        int normalWindowListSize = size;
                        if (size == 0) {
                            int size2 = multiWindowInterface.size(true);
                            int incognitoWindowListSize = size2;
                            if (size2 == 0 && !this.hasOnSaveState) {
                                long deleteStartTime = System.currentTimeMillis();
                                BdWindowBundleManager.getInstance().clearBeeDiskData();
                                if (z) {
                                    Log.i(TAG, "clearAllFileData cost=" + (System.currentTimeMillis() - deleteStartTime) + " normalWindowListSize=" + normalWindowListSize + " incognitoWindowListSize=" + incognitoWindowListSize);
                                }
                                NaRequestManager.INSTANCE.deleteAllFileCache();
                            }
                        }
                    }
                }
            }
            this.mFrameView.onDestroy();
            this.mFrameView.freeMemory();
            this.mFrameView.release();
        }
    }

    private void initBrowser() {
        if (this.mBrowser == null) {
            Browser browser = new Browser(this.mMainContext);
            this.mBrowser = browser;
            this.mFrameView = browser.getBrowserView();
        }
    }

    private void initFromIntent(Intent intent) {
        if (intent != null) {
            handleSpeedInfo(intent, getTestSpeedLogPoint(intent));
        }
        if (this.mBrowser != null) {
            boolean isContainerMode = false;
            if (!(intent == null || intent.getExtras() == null)) {
                isContainerMode = "1".equals(intent.getExtras().getString(Browser.PARAM_KEY_IS_COLLECT)) || "1".equals(intent.getExtras().getString(UnitedSchemeBrowserDispatcher.PARAM_KEY_IS_HISTORY)) || "1".equals(intent.getExtras().getString(Browser.EXTRA_IS_CONTAINER_MODE));
            }
            if (!isContainerMode) {
                this.mBrowser.initFromIntent(intent);
            } else if (this.mFrameView.getCurrentWindow() != null) {
                this.mFrameView.getCurrentWindow().openLoadSF(intent);
            } else {
                this.mBrowser.initFromIntent(intent);
            }
        }
    }

    private BaseSpeedLogger.TimeInfo getTestSpeedLogPoint(Intent intent) {
        if (!BrowserRuntime.GLOBAL_DEBUG) {
            return null;
        }
        boolean addTestSpeed = false;
        if (TextUtils.equals("com.baidu.searchbox.action.SEARCH", intent.getAction())) {
            addTestSpeed = true;
        } else if (TextUtils.equals("com.baidu.searchbox.action.VIEW", intent.getAction())) {
            String url = intent.getDataString();
            if (!TextUtils.isEmpty(url) && url.startsWith("search://")) {
                addTestSpeed = true;
            }
        } else if (TextUtils.equals("com.baidu.searchbox.action.BROWSER", intent.getAction())) {
            String url2 = intent.getStringExtra("key_url");
            if (!TextUtils.isEmpty(url2)) {
                try {
                    URL sURL = new URL(SearchManager.getWebSearchUrl());
                    URL uURL = new URL(url2);
                    if (TextUtils.equals(sURL.getHost(), uURL.getHost()) && TextUtils.equals(sURL.getPath(), uURL.getPath())) {
                        addTestSpeed = true;
                    }
                } catch (MalformedURLException e2) {
                    e2.printStackTrace();
                }
            }
        }
        if (addTestSpeed) {
            return new BaseSpeedLogger.TimeInfo(100000);
        }
        return null;
    }

    private void handleSpeedInfo(Intent intent, BaseSpeedLogger.TimeInfo timeInfo) {
        BaseSpeedLogger logger;
        String[] timeInfoArray = intent.getStringArrayExtra("time_info_from_home");
        if (this.mFrameView != null && timeInfoArray != null && timeInfoArray.length > 0 && BrowserRuntime.getStatistic() != null && (logger = BrowserRuntime.getStatistic().getSpeedLogger(SpeedLoggerConstants.BROWSER_SPEED_LOGGER_ID)) != null) {
            logger.recordPendingTimes(timeInfoArray);
            if (timeInfo != null) {
                logger.recordPendingTimes(timeInfo.getJsonObject().toString());
            }
            JSONArray frameViewSpeeds = getBrowser().getSpeedInfos();
            if (frameViewSpeeds != null) {
                logger.recordPendingTimes(frameViewSpeeds);
                getBrowser().clearSpeedInfos();
            }
            this.mFrameView.setSpeedLogger(logger);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        r0 = r1.mFrameView;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isSupportSlide() {
        /*
            r1 = this;
            boolean r0 = com.baidu.search.abtest.HisBackAbTest.isGestureBackAbTest()
            if (r0 == 0) goto L_0x001c
            android.content.Context r0 = r1.getContext()
            boolean r0 = com.baidu.search.abtest.HisBackAbTest.isProductNote(r0)
            if (r0 != 0) goto L_0x001c
            com.baidu.browser.framework.AbsBdFrameView r0 = r1.mFrameView
            if (r0 == 0) goto L_0x001c
            boolean r0 = r0.isCanBackToHis()
            if (r0 == 0) goto L_0x001c
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.browser.search.BrowserView.isSupportSlide():boolean");
    }

    /* access modifiers changed from: protected */
    public boolean handlePanelOpened() {
        AbsBdFrameView absBdFrameView = this.mFrameView;
        if (absBdFrameView == null || !absBdFrameView.isCanBackToHis()) {
            return super.handlePanelOpened();
        }
        this.mFrameView.gestureGoBackToHissugUBC();
        this.mFrameView.goBackHissug();
        return true;
    }

    /* access modifiers changed from: protected */
    public SlideInterceptor slideInterceptor() {
        if (this.slideInterceptor == null) {
            this.slideInterceptor = new SlideInterceptor() {
                public boolean isSlidable(MotionEvent ev) {
                    if (BrowserView.this.mFrameView != null) {
                        return BrowserView.this.mFrameView.frameViewSlide(ev);
                    }
                    return false;
                }
            };
        }
        return this.slideInterceptor;
    }

    public PinchSummaryEntity canSupportPinchSummary() {
        AbsBdFrameView absBdFrameView = this.mFrameView;
        if (absBdFrameView != null) {
            return absBdFrameView.canSupportPinchSummary();
        }
        return null;
    }

    public String getCurrentPageUrl() {
        AbsBdFrameView absBdFrameView = this.mFrameView;
        if (absBdFrameView != null) {
            return absBdFrameView.getCurrentUrl();
        }
        return null;
    }

    public void getPinchSummaryData(OnPinchSummaryDataSourceCallback onPinchSummaryDataSourceCallback) {
        AbsBdFrameView absBdFrameView = this.mFrameView;
        if (absBdFrameView != null) {
            absBdFrameView.getPinchSummaryData(onPinchSummaryDataSourceCallback);
        }
    }
}
