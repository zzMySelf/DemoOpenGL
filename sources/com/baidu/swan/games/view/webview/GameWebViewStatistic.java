package com.baidu.swan.games.view.webview;

import android.util.Log;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.statistic.SwanAppUBCStatistic;
import com.baidu.swan.apps.statistic.event.SwanAppUBCBaseEvent;
import com.baidu.swan.games.view.webview.GameWebViewApi;

class GameWebViewStatistic {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String TAG = "GameWebViewStatistic";
    private static final String UBC_EXT_H5_FINISH = "h5_finish";
    private static final String UBC_EXT_H5_START = "h5_start";
    private static final String UBC_EXT_NA_START = "na_start";
    private static final String UBC_TYPE_START_UP = "startup";

    GameWebViewStatistic() {
    }

    static void doH5GameLoadingFinishStats(SwanApp swanApp, GameWebViewApi.H5GameInfo h5GameInfo) {
        long launchTime = swanApp.getInfo().getLong("launch_time", 0);
        if (launchTime > 0) {
            SwanAppUBCBaseEvent event = new SwanAppUBCBaseEvent();
            event.mFrom = SwanAppUBCStatistic.getUBCFrom(swanApp.getInfo().getAppFrameType());
            event.mAppId = swanApp.getAppId();
            event.mSource = swanApp.getInfo().getLaunchFrom();
            event.mType = "startup";
            event.mPage = h5GameInfo.mGameId;
            event.mValue = h5GameInfo.mGameName;
            event.addExt("na_start", Long.valueOf(launchTime));
            event.addExt(UBC_EXT_H5_START, Long.valueOf(h5GameInfo.mStartLoadingTimestamp));
            event.addExt(UBC_EXT_H5_FINISH, Long.valueOf(h5GameInfo.mFinishLoadingTimestamp));
            SwanAppUBCStatistic.onEvent("1235", event);
        } else if (DEBUG) {
            Log.d(TAG, "doH5GameLoadingFinishStats: launchTime is invalid.");
        }
    }
}
