package com.baidu.swan.apps.process.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.lifecycle.process.IProcessLifecycleObserver;
import com.baidu.swan.apps.optimization.quotasaver.QuotaSaver;
import com.baidu.swan.apps.process.messaging.SwanAppMessenger;
import com.baidu.swan.apps.process.messaging.service.SwanAppPreloadHelper;

public abstract class PreloadLifecycleObserver implements IProcessLifecycleObserver {
    private static final boolean DEBUG = SwanAppMessenger.DEBUG;
    private static final String TAG = "PreloadLifecycleObserver";
    private static boolean sIsFirstTimeForeground = true;

    public void onForegroundStateChange(boolean isForeground, Activity activity) {
        if (!isForeground) {
            return;
        }
        if (sIsFirstTimeForeground) {
            sIsFirstTimeForeground = false;
        } else {
            doSwanPreloadOnForeground();
        }
    }

    private void doSwanPreloadOnForeground() {
        if (SwanAppRuntime.getConfigRuntime().isUserAgreementConfirmed() && QuotaSaver.INSTANCE.getRescueRefractoryPeriod() <= 0) {
            if (DEBUG) {
                Log.i(TAG, "doSwanPreloadOnForeground:" + ProcessUtils.getCurProcessName());
            }
            Bundle ext = new Bundle();
            ext.putString("bundle_key_preload_preload_scene", "9");
            SwanAppPreloadHelper.startServiceForPreloadNext(AppRuntime.getAppContext(), ext);
        }
    }
}
