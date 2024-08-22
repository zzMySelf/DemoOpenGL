package com.baidu.swan.apps.statistic;

import android.util.Log;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.core.pms.SwanAppPkgSyncDownloadCallback;
import com.baidu.swan.apps.launch.model.SwanAppProperties;
import com.baidu.swan.apps.statistic.event.SwanAppStabilityEvent;
import com.baidu.swan.apps.trace.ErrCode;
import com.baidu.swan.apps.util.SwanAppExecutorUtils;
import com.baidu.swan.pms.callback.IPMSCallback;

public final class SwanAppStabilityUbc {
    public static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    public static final String TAG = "SwanStabilityUbc";

    public static void onStableEvent(final SwanAppStabilityEvent event) {
        if (event != null) {
            SwanAppExecutorUtils.postOnIO(new Runnable() {
                public void run() {
                    StatRouter.onEvent("671", SwanAppStabilityEvent.this.toJSONObject());
                }
            }, "SwanStabilityUBC");
        } else if (DEBUG) {
            Log.d(TAG, "event is null");
        }
    }

    public static void doRetryStatisForAPS(boolean isPredownload, boolean retrySuccess, SwanAppProperties params, int category) {
        onStableEvent(new SwanAppStabilityEvent().from(SwanAppUBCStatistic.getUBCFrom(category)).errCode(new ErrCode().feature(4).error(36).detail("Predownload=" + isPredownload + ", Retry=" + retrySuccess)).launchInfo(params));
        if (DEBUG) {
            Log.d(TAG, "Statis: Predownload=" + isPredownload + ", Retry=" + retrySuccess);
        }
    }

    public static void doRetryStatisForPMSMain(IPMSCallback callback, int category, boolean retrySuccess) {
        if (callback != null) {
            SwanAppStabilityEvent event = new SwanAppStabilityEvent().from(SwanAppUBCStatistic.getUBCFrom(category)).errCode(new ErrCode().feature(11).error(2331).detail("Retry=" + retrySuccess + ", Scene=" + callback.getClass().getName()));
            if (callback instanceof SwanAppPkgSyncDownloadCallback) {
                event.launchInfo(((SwanAppPkgSyncDownloadCallback) callback).getLaunchParams());
            }
            onStableEvent(event);
            if (DEBUG) {
                Log.d(TAG, "Statis: Retry=" + retrySuccess + ", Scene=" + callback.getClass().getSimpleName());
            }
        } else if (DEBUG) {
            Log.d(TAG, "pms callback is null");
        }
    }
}
