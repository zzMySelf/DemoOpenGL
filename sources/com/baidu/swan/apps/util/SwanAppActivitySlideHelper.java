package com.baidu.swan.apps.util;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.searchbox.widget.OnTranslucentListener;
import com.baidu.searchbox.widget.SlideHelper;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.searchbox.widget.SlidingPaneLayout;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.adaptation.webview.ISwanAppSlaveManager;
import com.baidu.swan.apps.adaptation.webview.ISwanAppWebViewWidget;
import com.baidu.swan.apps.core.fragment.SwanAppBaseFragment;
import com.baidu.swan.apps.core.fragment.SwanAppFragment;
import com.baidu.swan.apps.embed.page.ISwanPageManager;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.launch.cache.SwanAppCacheAPIManager;
import com.baidu.swan.apps.launch.model.SwanAppLaunchInfo;
import com.baidu.swan.apps.monitor.SwanAppPageMonitor;
import com.baidu.swan.apps.network.update.node.SwanAppAccreditNode;
import com.baidu.swan.apps.runtime.config.WindowConfig;
import com.baidu.swan.apps.setting.oauth.ScopeInfo;
import com.baidu.swan.apps.skin.SwanAppSkinDecorator;
import java.lang.ref.WeakReference;

public class SwanAppActivitySlideHelper implements SlideInterceptor {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String MASK_VIEW_COLOR = "#40000000";
    private static final int SLIDE_END = 1;
    private static final int SLIDE_START = 0;
    private static final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";
    private static final String SYSTEM_DIALOG_REASON_KEY = "reason";
    private static final String SYSTEM_DIALOG_REASON_RECENT_APPS = "recentapps";
    private static final String TAG = "SwanActivitySlideHelper";
    /* access modifiers changed from: private */
    public boolean isActivityTranslucent = false;
    private WeakReference<SwanAppActivity> mActivitySoftReference;
    private SwanAppSkinDecorator mDecorator;
    private BroadcastReceiver mMenuAndHomeReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction())) {
                String reason = intent.getStringExtra("reason");
                if (!TextUtils.isEmpty(reason)) {
                    if (("homekey".equals(reason) || reason.equals("recentapps")) && SwanAppActivitySlideHelper.this.mSlideHelper != null) {
                        SwanAppActivitySlideHelper.this.mSlideHelper.closePane();
                        SwanAppActivitySlideHelper.this.mSlideHelper.setCanSlide(false);
                    }
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public SlideHelper mSlideHelper;

    public SwanAppActivitySlideHelper(SwanAppActivity activity) {
        this.mActivitySoftReference = new WeakReference<>(activity);
        this.mSlideHelper = new SlideHelper(!SwanAppRuntime.getLandscapeDeviceConfig().adaptLandscapeDeviceEnabled());
    }

    public void onFrameCreate() {
        if (((SwanAppActivity) this.mActivitySoftReference.get()) != null) {
            this.mSlideHelper.setCanSlide(canSlide());
        }
    }

    public void onActivityCreate() {
        SwanAppActivity activity = (SwanAppActivity) this.mActivitySoftReference.get();
        if (activity != null) {
            SwanAppSkinDecorator skinDecorator = activity.getSkinDecorator();
            this.mDecorator = skinDecorator;
            if (skinDecorator != null) {
                if (SwanAppCacheAPIManager.getNightModeState(false).booleanValue()) {
                    this.mDecorator.setVisibility(0);
                }
                enableSliding();
                this.mSlideHelper.setCanSlide(canSlide());
            }
        }
    }

    public void onCreate() {
        Activity activity = (Activity) this.mActivitySoftReference.get();
        if (activity != null) {
            IntentFilter filter = new IntentFilter();
            filter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
            activity.registerReceiver(this.mMenuAndHomeReceiver, filter);
        }
    }

    public void onNewIntent() {
        SwanAppActivity activity = (SwanAppActivity) this.mActivitySoftReference.get();
        if (activity != null) {
            SwanAppLaunchInfo launchInfo = activity.getLaunchInfo();
            if ((launchInfo == null || !"1230000000000000".equals(launchInfo.getLaunchFrom())) && activity.getFrameType() != 1) {
                this.mSlideHelper.setCanSlide(canSlide());
            } else {
                this.mSlideHelper.setCanSlide(false);
            }
        }
    }

    public void onResume() {
        SwanAppSkinDecorator swanAppSkinDecorator;
        if (SwanAppCacheAPIManager.getNightModeState(true).booleanValue() && (swanAppSkinDecorator = this.mDecorator) != null) {
            swanAppSkinDecorator.setVisibility(0);
        }
    }

    public void onDestroy() {
        Activity activity;
        WeakReference<SwanAppActivity> weakReference = this.mActivitySoftReference;
        if (weakReference != null && (activity = (Activity) weakReference.get()) != null) {
            activity.unregisterReceiver(this.mMenuAndHomeReceiver);
        }
    }

    public void enableSliding() {
        final SwanAppActivity activity = (SwanAppActivity) this.mActivitySoftReference.get();
        if (activity != null && !activity.isDestroyed()) {
            this.mSlideHelper.attachSlideView(activity, activity.findViewById(16908290), new SlidingPaneLayout.LayoutParams(-1, -1));
            this.mSlideHelper.attachActivity(activity);
            this.mSlideHelper.setEnableReleaseWhenNoTranslucent(false);
            this.mSlideHelper.setFadeColor(0);
            this.mSlideHelper.setSlideInterceptor(this);
            this.mSlideHelper.setSlideListener(new SlidingPaneLayout.PanelSlideListener() {
                public void onPanelSlide(View panel, float slideOffset) {
                    View maskView = SwanAppActivitySlideHelper.this.mSlideHelper.getMaskView();
                    if (maskView != null) {
                        maskView.setAlpha(1.0f - slideOffset);
                        if (activity.hasActiveFrame()) {
                            activity.getFrame().onPanelSlide();
                        }
                        if (slideOffset == 0.0f) {
                            maskView.setBackgroundColor(Color.parseColor(SwanAppActivitySlideHelper.MASK_VIEW_COLOR));
                        }
                        if (slideOffset == 1.0f) {
                            maskView.setBackgroundColor(0);
                        }
                    }
                }

                public void onPanelOpened(View panel) {
                    activity.onBackPressed(3);
                    SwanAppActivitySlideHelper.this.hideNightModeCoverLayer();
                    activity.overridePendingTransition(0, 0);
                    SwanAppPageMonitor.getInstance().onExit();
                    SwanAppRuntime.getExceptionUploadManager().onExit();
                }

                public void onPanelClosed(View panel) {
                }
            });
            ISwanAppSlaveManager currentWebViewManager = getCurrentWebViewManager();
            if (currentWebViewManager != null) {
                this.mSlideHelper.setRegionFactor(currentWebViewManager.getRegionFactor());
            }
            this.mSlideHelper.setOnTransparentListener(new OnTranslucentListener() {
                public void onTranslucent(boolean translucent) {
                    boolean unused = SwanAppActivitySlideHelper.this.isActivityTranslucent = true;
                }
            });
        }
    }

    public boolean isSlidable(MotionEvent ev) {
        ISwanPageManager manager;
        ISwanAppSlaveManager currentWebViewManager;
        SwanAppActivity activity = (SwanAppActivity) this.mActivitySoftReference.get();
        if (activity == null || !activity.hasActiveFrame() || (manager = activity.getSwanPageManager()) == null || (currentWebViewManager = getCurrentWebViewManager()) == null) {
            return false;
        }
        ISwanAppWebViewWidget webViewWidget = currentWebViewManager.getWebViewWidget();
        boolean isCanGoBack = (webViewWidget == null || webViewWidget.getWebView() == null || !webViewWidget.getWebView().canGoBack()) ? false : true;
        if (manager.getFragmentCount() > 1 || !currentWebViewManager.isSlidable(ev) || isCanGoBack || !isEnableSwipeBack() || SwanAppUIUtils.isScreenLand()) {
            return false;
        }
        return true;
    }

    public void onConfigurationChanged(Configuration newConfig) {
        if (((SwanAppActivity) this.mActivitySoftReference.get()) != null) {
            if ((newConfig != null && newConfig.orientation == 2) && this.isActivityTranslucent) {
                this.mSlideHelper.setActivityTransparent(false);
                this.isActivityTranslucent = false;
            }
        }
    }

    private ISwanAppSlaveManager getCurrentWebViewManager() {
        ISwanPageManager manager;
        SwanAppBaseFragment fragment;
        SwanAppActivity activity = (SwanAppActivity) this.mActivitySoftReference.get();
        if (activity == null || (manager = activity.getSwanPageManager()) == null || (fragment = manager.getTopFragment()) == null || !(fragment instanceof SwanAppFragment)) {
            return null;
        }
        return ((SwanAppFragment) fragment).getCurrentWebViewManager();
    }

    private boolean canSlide() {
        if (((Activity) this.mActivitySoftReference.get()) == null) {
            return false;
        }
        boolean systemEnableSlide = Build.VERSION.SDK_INT != 26;
        boolean hostEnableSlide = !SwanAppRuntime.getLandscapeDeviceConfig().adaptLandscapeDeviceEnabled();
        if (!systemEnableSlide || !hostEnableSlide) {
            return false;
        }
        return true;
    }

    private boolean isEnableSwipeBack() {
        ISwanPageManager manager;
        SwanAppActivity activity = (SwanAppActivity) this.mActivitySoftReference.get();
        if (activity == null || activity.isDestroyed() || !activity.hasActiveFrame() || (manager = activity.getSwanPageManager()) == null) {
            return false;
        }
        SwanAppFragment topFragment = manager.getTopSwanAppFragment();
        if (topFragment != null) {
            WindowConfig windowConfig = topFragment.getCurWindowConfig();
            if (windowConfig == null) {
                return true;
            }
            return isEnableFullscreenSwipeBack(windowConfig);
        }
        if (DEBUG) {
            Log.d(TAG, "topFragment = null; return false");
        }
        return false;
    }

    private boolean isEnableFullscreenSwipeBack(WindowConfig windowConfig) {
        if (!windowConfig.disableFullScreenSwipeBack) {
            return isEnableEdgeSwipeBack(windowConfig);
        }
        ScopeInfo result = SwanAppAccreditNode.getAccreditListData(true).get("scope_disable_all_swipe_back");
        if (result == null || result.forbidden) {
            return isEnableEdgeSwipeBack(windowConfig);
        }
        SlideHelper slideHelper = this.mSlideHelper;
        if (slideHelper == null) {
            return false;
        }
        slideHelper.setRegionFactor(0.0d);
        return false;
    }

    private boolean isEnableEdgeSwipeBack(WindowConfig windowConfig) {
        if (windowConfig.enableEdgeSwipeBack) {
            ScopeInfo result = SwanAppAccreditNode.getAccreditListData(true).get("scope_disable_swipe_back");
            if (result == null || result.forbidden) {
                return false;
            }
            SlideHelper slideHelper = this.mSlideHelper;
            if (slideHelper != null) {
                slideHelper.setRegionFactor(0.1d);
            }
        }
        return true;
    }

    public void closePane() {
        this.mSlideHelper.closePane();
    }

    public void setCanSlide(boolean canSlide) {
        this.mSlideHelper.setCanSlide(canSlide);
    }

    /* access modifiers changed from: private */
    public void hideNightModeCoverLayer() {
        SwanAppSkinDecorator swanAppSkinDecorator;
        if (SwanAppRuntime.getNightModeRuntime().getNightModeSwitcherState() && (swanAppSkinDecorator = this.mDecorator) != null) {
            swanAppSkinDecorator.setVisibility(8);
        }
    }
}
