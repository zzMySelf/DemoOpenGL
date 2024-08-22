package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.swan.apps.adaptation.interfaces.ISwanAppPageInfo;
import com.baidu.swan.apps.page.SwanAppPageInfoHelper;
import com.baidu.swan.apps.runtime.SwanApp;
import org.json.JSONObject;

public class DefaultSwanAppPageInfo implements ISwanAppPageInfo {
    public void postPageInfo(SwanApp swanApp, JSONObject joParams) {
        SwanAppPageInfoHelper.getInstance().postPageInfo(swanApp, joParams);
    }

    public void operateFavoriteInMainProcess(String ukey, String type, String data) {
    }

    public void notifyFavoriteResultToSwanProcess(String ukey, String type, boolean result) {
    }
}
