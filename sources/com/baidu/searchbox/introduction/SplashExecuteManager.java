package com.baidu.searchbox.introduction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.baidu.searchbox.ad.IntroductionInfoManager;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.feed.ad.AdRuntimeHolder;
import com.baidu.searchbox.introduction.WorkspaceStateChangeListener;
import com.baidu.searchbox.launch.SmartLaunchStats;

public class SplashExecuteManager {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "SplashExecuteManager";
    public static boolean adHasShowInColdStart;
    /* access modifiers changed from: private */
    public int currentSystemUiFlag;
    /* access modifiers changed from: private */
    public Activity mActivity;
    /* access modifiers changed from: private */
    public IntroductionSplashManager mIntroductionSplashManager;
    private SplashStateListener mListener;

    private void buildSplashIntroduction() {
        this.mIntroductionSplashManager = IntroductionSplashManager.createManager(this.mActivity, this.mListener);
    }

    public IntroductionInfo executeSplash(Intent intent, BaseActivity activity, Bundle savedInstanceState, SplashStateListener listener) {
        this.mListener = new SplashStateListenerWrapper(listener);
        this.mActivity = activity;
        IntroductionInfo info = new IntroductionInfo();
        if (savedInstanceState != null || intent == null || !"android.intent.action.MAIN".equals(intent.getAction()) || adHasShowInColdStart) {
            if (DEBUG) {
                Log.d(TAG, "intent.getAction != main 不出开屏广告");
            }
            return info;
        }
        buildSplashIntroduction();
        IntroductionSplashManager introductionSplashManager = this.mIntroductionSplashManager;
        if (introductionSplashManager == null || !introductionSplashManager.showable()) {
            return info;
        }
        SmartLaunchStats.setAdShowTimestamps(System.currentTimeMillis());
        Activity activity2 = this.mActivity;
        if (activity2 instanceof BaseActivity) {
            ((BaseActivity) activity2).setEnableImmersion(false);
        }
        this.mActivity.getWindow().getDecorView().setSystemUiVisibility(1028);
        this.mActivity.getWindow().addFlags(1024);
        IntroductionInfoManager.getInstance().setIsIntroductionAdState(true);
        return this.mIntroductionSplashManager.showIntroductionNew(info);
    }

    public IntroductionInfo executeSplash(Activity activity, SplashStateListener listener) {
        this.mListener = new SplashStateListenerWrapper(listener);
        this.mActivity = activity;
        IntroductionInfo info = new IntroductionInfo();
        buildSplashIntroduction();
        IntroductionSplashManager introductionSplashManager = this.mIntroductionSplashManager;
        if (introductionSplashManager == null || !introductionSplashManager.showable()) {
            return info;
        }
        this.currentSystemUiFlag = this.mActivity.getWindow().getDecorView().getSystemUiVisibility();
        this.mActivity.getWindow().getDecorView().setSystemUiVisibility(1028);
        IntroductionInfoManager.getInstance().setIsIntroductionAdState(true);
        adHasShowInColdStart = true;
        SplashStateManager.getInstance().setHasShowSplash(true);
        return this.mIntroductionSplashManager.showIntroductionNew(info);
    }

    class SplashStateListenerWrapper extends SplashStateListener {
        private SplashStateListener mListener;

        public SplashStateListenerWrapper(SplashStateListener listener) {
            this.mListener = listener;
        }

        public void onClose(View v, WorkspaceStateChangeListener.OnCloseCallBack callBack, int quitType) {
            super.onClose(v, callBack, quitType);
            this.mListener.onClose(v, callBack, quitType);
            if (SplashExecuteManager.this.mIntroductionSplashManager != null) {
                SplashExecuteManager.this.mIntroductionSplashManager.release();
            }
            if (SplashExecuteManager.this.mActivity == null) {
                return;
            }
            if (AdRuntimeHolder.getHomePageController().isMainActivity(SplashExecuteManager.this.mActivity)) {
                ((BaseActivity) SplashExecuteManager.this.mActivity).setEnableImmersion(false);
                SplashExecuteManager.this.mActivity.getWindow().clearFlags(1024);
                return;
            }
            SplashExecuteManager.this.mActivity.getWindow().getDecorView().setSystemUiVisibility(SplashExecuteManager.this.currentSystemUiFlag);
        }
    }
}
