package com.baidu.swan.apps.embed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.swan.api.callbacks.SwanLifecycleCallback;
import com.baidu.swan.api.models.SwanAppLifecycleEvent;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.embed.interfaces.ISwanEmbed;
import com.baidu.swan.apps.embed.page.ISwanPageManager;
import com.baidu.swan.apps.embed.page.SwanEmbedPageManager;
import com.baidu.swan.apps.embed.view.SwanAppEmbedView;
import com.baidu.swan.apps.framework.FrameLifeState;
import com.baidu.swan.apps.framework.ISwanAppActivityCallback;
import com.baidu.swan.apps.framework.ISwanFrameContainer;
import com.baidu.swan.apps.framework.SwanActivityFrame;
import com.baidu.swan.apps.framework.SwanFrameConfig;
import com.baidu.swan.apps.framework.SwanFrameProvider;
import com.baidu.swan.apps.permission.SwanAppPermission;
import com.baidu.swan.apps.res.widget.floatlayer.FloatLayer;
import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.apps.runtime.SwanContext;
import com.baidu.swan.apps.runtime.def.SwanResetFlags;
import com.baidu.swan.apps.system.memory.TrimMemoryDispatcher;
import com.baidu.swan.apps.util.SwanAppUtils;
import com.baidu.swan.apps.view.SwanAppLoadingView;
import com.facebook.common.internal.Sets;

public class SwanEmbedContainer implements ISwanEmbed, ISwanFrameContainer {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String TAG = "SwanEmbedContainer";
    private boolean isTopActionBarWhiteStyle;
    private Activity mActivity;
    private SwanFrameConfig mFrameConfig;
    private SwanFrameProvider mFrameProvider;
    private Bundle mLaunchData;
    private String mScreenStatus = "normal";

    public void loadApp(String scheme, Activity activity) {
    }

    public void loadApp(Bundle data, Activity activity) {
        this.mActivity = activity;
        this.mLaunchData = data;
        if (this.mFrameProvider == null) {
            onCreate(data);
        } else {
            onNewIntent(data);
        }
    }

    public void onStart() {
        this.mFrameProvider.onStart();
    }

    public void onStop() {
        this.mFrameProvider.onStop();
    }

    public void onResume() {
        this.mFrameProvider.onResume();
    }

    public void onPause() {
        this.mFrameProvider.onPause();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return this.mFrameProvider.onKeyDown(keyCode, event);
    }

    public boolean onBackPressed() {
        return this.mFrameProvider.onBackPressed(1);
    }

    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        return this.mFrameProvider.onActivityResult(this.mActivity, requestCode, resultCode, data);
    }

    public void onTrimMemory(int level) {
        this.mFrameProvider.onTrimMemory(level);
    }

    public void onDestroy() {
        if (DEBUG) {
            Log.d(TAG, "onDestroy");
        }
        this.mFrameProvider.onDestroy();
    }

    private void onCreate(Bundle data) {
        if (DEBUG) {
            Log.d(TAG, "onCreate data" + data);
        }
        data.putLong("receive_launch_intent_time", System.currentTimeMillis());
        Bundle bundle = new Bundle();
        bundle.putAll(data);
        this.mLaunchData = bundle;
        SwanFrameProvider swanFrameProvider = new SwanFrameProvider(this, this.mActivity);
        this.mFrameProvider = swanFrameProvider;
        swanFrameProvider.init(0);
        this.mFrameProvider.updateLifeStatus(FrameLifeState.JUST_CREATED);
        this.mFrameProvider.bindEvent();
        this.mFrameProvider.loadApp(data, false, SwanContext.UPDATE_TAG_BY_ACTIVITY_ON_CREATE);
        this.mFrameProvider.executeAsyncTask(getContext());
    }

    private void onNewIntent(Bundle data) {
        if (DEBUG) {
            Log.d(TAG, "onNewIntent data" + data);
        }
        data.putLong("receive_launch_intent_time", System.currentTimeMillis());
        Bundle bundle = new Bundle();
        bundle.putAll(data);
        this.mLaunchData = bundle;
        this.mFrameProvider.onNewIntent(data, false);
    }

    public boolean isContainerDestroyed() {
        return this.mActivity.isDestroyed();
    }

    public boolean isContainerFinishing() {
        return this.mActivity.isFinishing();
    }

    public void performFinish(String... flags) {
        if (DEBUG) {
            Log.d(TAG, "performFinish");
        }
        this.mFrameProvider.destroyFrame();
        if ((flags == null ? Sets.newHashSet() : Sets.newHashSet((E[]) flags)).contains(SwanResetFlags.FLAG_FINISH_ACTIVITY)) {
            finishAndRemoveContainerTask();
        }
    }

    public void handleSwanAppExit(int from) {
        this.mFrameProvider.handleSwanAppExit(from);
    }

    public ISwanPageManager createSwanPageManager() {
        return new SwanEmbedPageManager();
    }

    public ISwanPageManager getSwanPageManager() {
        return this.mFrameProvider.getSwanPageManager();
    }

    public boolean isBackground() {
        return this.mFrameProvider.isBackground();
    }

    public boolean isFrameResumed() {
        return this.mFrameProvider.isFrameResumed();
    }

    public void registerCallback(ISwanAppActivityCallback callback) {
        this.mFrameProvider.registerCallback(callback);
    }

    public void unregisterCallback(ISwanAppActivityCallback callback) {
        this.mFrameProvider.unregisterCallback(callback);
    }

    public void addDebugRunningView() {
        this.mFrameProvider.addDebugRunningView();
    }

    public void removeDebugRunningView() {
        this.mFrameProvider.removeDebugRunningView();
    }

    public SwanActivityFrame getFrame() {
        return this.mFrameProvider.getFrame();
    }

    public void showLoadingView() {
        this.mFrameProvider.showLoadingView();
    }

    public void removeLoadingView() {
        this.mFrameProvider.removeLoadingView();
    }

    public void setWindowFeature(int orientation, int frameType) {
    }

    public void setActivityImmersive(boolean isImmersive) {
    }

    public boolean hasActiveFrame() {
        return this.mFrameProvider.hasActiveFrame();
    }

    public Bundle getBundleData() {
        return this.mLaunchData;
    }

    public void preloadNextSwanAppProcess(Bundle ext) {
        this.mFrameProvider.preloadNextSwanAppProcess(ext);
    }

    public String getShowBy() {
        return this.mFrameProvider.getShowBy();
    }

    public SwanFrameContainerType getContainerType() {
        return SwanFrameContainerType.EMBED_VIEW;
    }

    public boolean moveTaskToBack(boolean nonRoot, int flag) {
        return false;
    }

    public void closeSwanApp() {
        SwanAppEmbedView embedView = SwanEmbedFrameManager.getInstance().getEmbedView();
        if (embedView != null) {
            SwanFrameProvider.doUBCCloseEventStatistic();
            SwanLifecycleCallback embedCallback = embedView.getEmbedCallback();
            if (embedCallback != null) {
                embedCallback.onCloseApp(new SwanAppLifecycleEvent(embedView.getLaunchAppId(), SwanLifecycleCallback.EVENT_APP_CLOSE));
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0022, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setFrameConfig(com.baidu.swan.apps.framework.SwanFrameConfig r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            r2.mFrameConfig = r3     // Catch:{ all -> 0x0023 }
            if (r3 != 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            java.lang.String r0 = r3.runtimeMode     // Catch:{ all -> 0x0023 }
            java.lang.String r1 = "1"
            boolean r0 = android.text.TextUtils.equals(r0, r1)     // Catch:{ all -> 0x0023 }
            if (r0 != 0) goto L_0x001d
            com.baidu.swan.apps.framework.SwanFrameConfig r0 = r2.mFrameConfig     // Catch:{ all -> 0x0023 }
            java.lang.String r0 = r0.runtimeMode     // Catch:{ all -> 0x0023 }
            java.lang.String r1 = "2"
            boolean r0 = android.text.TextUtils.equals(r0, r1)     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x0021
        L_0x001d:
            java.lang.String r0 = "halfScreen"
            r2.mScreenStatus = r0     // Catch:{ all -> 0x0023 }
        L_0x0021:
            monitor-exit(r2)
            return
        L_0x0023:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.embed.SwanEmbedContainer.setFrameConfig(com.baidu.swan.apps.framework.SwanFrameConfig):void");
    }

    public synchronized SwanFrameConfig getFrameConfig() {
        return this.mFrameConfig;
    }

    public void setScreenStatus(String screenType) {
        if (!TextUtils.isEmpty(screenType)) {
            this.mScreenStatus = screenType;
            Swan.get().dispatchEvent("event_on_screen_status_changed");
        }
    }

    public String getScreenStatus() {
        return this.mScreenStatus;
    }

    public void onTopPageActionBarColorChanged(boolean isWhite) {
        SwanLifecycleCallback embedCallback;
        if (this.isTopActionBarWhiteStyle != isWhite) {
            this.isTopActionBarWhiteStyle = isWhite;
            SwanAppEmbedView embedView = SwanEmbedFrameManager.getInstance().getEmbedView();
            if (embedView != null && (embedCallback = embedView.getEmbedCallback()) != null) {
                SwanAppLifecycleEvent event = new SwanAppLifecycleEvent(embedView.getLaunchAppId(), SwanLifecycleCallback.EVENT_ACTION_BAR_COLOR_CHANGE);
                event.isWhiteActionBar = isWhite;
                embedCallback.onTopPageActionBarColorChanged(event);
            }
        }
    }

    public void onHandleSwanExit() {
        SwanLifecycleCallback embedCallback;
        SwanAppEmbedView embedView = SwanEmbedFrameManager.getInstance().getEmbedView();
        if (embedView != null && (embedCallback = embedView.getEmbedCallback()) != null) {
            embedCallback.onHandleSwanExit(new SwanAppLifecycleEvent(embedView.getLaunchAppId(), SwanLifecycleCallback.EVENT_ON_HANDLE_EXIT));
        }
    }

    public void finishAndRemoveContainerTask() {
        SwanAppUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (SwanEmbedContainer.DEBUG) {
                    Log.d(SwanEmbedContainer.TAG, "finishAndRemoveContainerTask");
                }
                SwanEmbedFrameManager.getInstance().destroyEmbedView();
            }
        });
    }

    public FloatLayer getFloatLayer() {
        SwanAppEmbedView embedView = SwanEmbedFrameManager.getInstance().getEmbedView();
        if (embedView != null) {
            return this.mFrameProvider.getFloatLayer(embedView);
        }
        return this.mFrameProvider.getFloatLayer((ViewGroup) this.mActivity.findViewById(16908290));
    }

    public boolean isLandScape() {
        return this.mFrameProvider.isLandScape();
    }

    public SwanAppLoadingView getLoadingView() {
        return this.mFrameProvider.getLoadingView();
    }

    public View getRootView() {
        SwanAppEmbedView embedView = SwanEmbedFrameManager.getInstance().getEmbedView();
        if (embedView != null) {
            return embedView;
        }
        Activity activity = this.mActivity;
        if (activity != null) {
            return activity.findViewById(16908290);
        }
        return null;
    }

    public Context getContext() {
        Activity activity = this.mActivity;
        if (activity != null) {
            return activity;
        }
        return AppRuntime.getAppContext();
    }

    public ActivityResultDispatcher getResultDispatcher() {
        return this.mFrameProvider.getResultDispatcher();
    }

    public void notifyFrameUpdate() {
    }

    public void notifyFrameCreate() {
    }

    public void onNightModeCoverChanged(boolean isNightMode, boolean sendMessage) {
        SwanLifecycleCallback embedCallback;
        SwanAppEmbedView embedView = SwanEmbedFrameManager.getInstance().getEmbedView();
        if (embedView != null && (embedCallback = embedView.getEmbedCallback()) != null) {
            SwanAppLifecycleEvent event = new SwanAppLifecycleEvent(embedView.getLaunchAppId(), SwanLifecycleCallback.EVENT_NIGHT_MODE_CHANGE);
            event.isNightMode = isNightMode;
            event.isSendNightModeMsg = sendMessage;
            embedCallback.onNightModeChanged(event);
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        this.mFrameProvider.onConfigurationChanged(newConfig);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        SwanAppPermission.getInstance().onRequestPermissionsResult(this.mActivity, requestCode, permissions, grantResults);
    }

    public TrimMemoryDispatcher getTrimMemoryDispatcher() {
        return this.mFrameProvider.getTrimMemoryDispatcher();
    }
}
