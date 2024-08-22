package com.baidu.searchbox.main.init.business;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.app.account.utils.LogUtils;
import com.baidu.searchbox.account.manager.LaunchLoginGuideDialogManager;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.launch.init.ILaunchInterceptor;
import com.baidu.searchbox.launch.init.InterceptResult;
import com.baidu.searchbox.launch.init.IntercepterResultListener;
import com.baidu.searchbox.launch.restore.ColdLaunchRestoreManager;
import com.baidu.searchbox.launch.splash.ParallelRenderManager;
import com.baidu.searchbox.security.WarmTipsManager;

public class LaunchLoginGuideInterceptor implements ILaunchInterceptor {
    private String DAFAULT_VERSION = "-1";

    public void onPreMainInit(Intent intent, BaseActivity activity, IntercepterResultListener listener, InterceptResult result, Bundle savedInstanceState) {
        final BaseActivity baseActivity = activity;
        Bundle bundle = savedInstanceState;
        if (bundle != null || intent == null || !"android.intent.action.MAIN".equals(intent.getAction())) {
            IntercepterResultListener intercepterResultListener = listener;
            InterceptResult interceptResult = result;
            if (AppConfig.isDebug()) {
                Log.e("launchLoginGuide", "intent.getAction != main no loginGuide");
            }
            listener.onCallBack();
            return;
        }
        if (result.isRejectInterruptAct()) {
            IntercepterResultListener intercepterResultListener2 = listener;
            InterceptResult interceptResult2 = result;
        } else if (result.isWarmTips()) {
            IntercepterResultListener intercepterResultListener3 = listener;
            InterceptResult interceptResult3 = result;
        } else if (!WarmTipsManager.hasConfirmDialog()) {
            IntercepterResultListener intercepterResultListener4 = listener;
            InterceptResult interceptResult4 = result;
        } else if (ColdLaunchRestoreManager.INSTANCE.needRestorePage(true)) {
            IntercepterResultListener intercepterResultListener5 = listener;
            InterceptResult interceptResult5 = result;
        } else {
            String lastShowGuideVersion = QuickPersistConfig.getInstance().getString(LaunchLoginGuideDialogManager.LAST_SHOW_GUIDE_VERSION, this.DAFAULT_VERSION);
            String versionName = AppConfig.AppInfo.getVersionName();
            if (TextUtils.isEmpty(versionName) || versionName.contains(lastShowGuideVersion)) {
                if (!TextUtils.equals(QuickPersistConfig.getInstance().getString(LaunchLoginGuideDialogManager.FIRST_SHOW_GUIDE_VERSION, this.DAFAULT_VERSION), lastShowGuideVersion)) {
                    listener.onCallBack();
                    return;
                } else if (QuickPersistConfig.getInstance().getInt(LaunchLoginGuideDialogManager.LOGIN_GUIDE_SHOW_COUNT, 0) >= QuickPersistConfig.getInstance().getInt(LaunchLoginGuideDialogManager.LOGIN_GUIDE_SHOW_TOTAL_COUNT, 0)) {
                    listener.onCallBack();
                    return;
                } else {
                    long interval = QuickPersistConfig.getInstance().getLong(LaunchLoginGuideDialogManager.LOGIN_GUIDE_SHOW_INTERVAL, 0);
                    if (interval <= 0) {
                        listener.onCallBack();
                        return;
                    }
                    if (System.currentTimeMillis() < QuickPersistConfig.getInstance().getLong(LaunchLoginGuideDialogManager.LAST_SHOW_GUIDE_TIME, 0) + interval) {
                        listener.onCallBack();
                        return;
                    }
                }
            }
            final IntercepterResultListener intercepterResultListener6 = listener;
            final InterceptResult interceptResult6 = result;
            new LaunchLoginGuideDialogManager().launchLoginGuide(baseActivity, bundle, new LaunchLoginGuideDialogManager.LaunchLoginGuideCallBack() {
                public void loginGuideFinishCallBack(Bundle savedInstanceState) {
                    intercepterResultListener6.onCallBack();
                    LaunchLoginGuideDialogManager.setFullScreenImmersion(baseActivity, false);
                }

                public void onShow() {
                    interceptResult6.setIsShowIntro(true);
                    interceptResult6.putExtData(LaunchStateConstants.KEY_IS_SHOW_LOGIN_GUIDE, true);
                    LaunchLoginGuideDialogManager.setFullScreenImmersion(baseActivity, true);
                    ParallelRenderManager.get().restoreWindowTheme(baseActivity, false);
                }
            });
            return;
        }
        LogUtils.d("launchLoginGuide", "isRejectInterruptAct or confirm dialog, return");
        listener.onCallBack();
    }

    public boolean isUiReadyMonitor() {
        return false;
    }

    public void onInitialUIReady() {
    }
}
