package com.baidu.swan.gamecenter.appmanager.action;

import android.content.IntentFilter;
import com.baidu.searchbox.preload.business.inner.PreloadConstantsKt;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.api.result.SwanApiResult;
import com.baidu.swan.apps.gamecenter.IGameCenterCallback;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import com.baidu.swan.gamecenter.main.GameCenterAction;
import org.json.JSONObject;

public class GameCenterWifiResumeDownloadAction extends GameCenterAction {
    private static final String ACTION_NAME = "resumeAllDownloadWhileWifi";
    public static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String PARAMS_ERROR_MSG = "params may be error";
    private static final String TAG = "GameCenterWifiResumeDownloadAction";
    private AppDownloadNetworkStateReceiver mNetworkStateReceiver;

    public GameCenterWifiResumeDownloadAction() {
        super(ACTION_NAME);
    }

    public SwanApiResult handle(JSONObject paramsJson, IGameCenterCallback callback) {
        if (paramsJson == null) {
            callback.onFail(202, "params may be error");
            return null;
        }
        if (this.mNetworkStateReceiver == null) {
            this.mNetworkStateReceiver = new AppDownloadNetworkStateReceiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PreloadConstantsKt.CONNECTIVITY_ACTION);
        SwanAppRuntime.getAppContext().registerReceiver(this.mNetworkStateReceiver, intentFilter);
        callback.onSuccess((JSONObject) null);
        return null;
    }
}
