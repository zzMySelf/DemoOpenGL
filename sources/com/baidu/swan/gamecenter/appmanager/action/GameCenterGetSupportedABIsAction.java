package com.baidu.swan.gamecenter.appmanager.action;

import android.os.Build;
import com.baidu.swan.apps.api.result.SwanApiResult;
import com.baidu.swan.apps.gamecenter.IGameCenterCallback;
import com.baidu.swan.gamecenter.main.GameCenterAction;
import org.json.JSONObject;

public class GameCenterGetSupportedABIsAction extends GameCenterAction {
    private static final String ACTION_NAME = "getSupportedABIs";
    private static final String KEY_DATA = "data";

    public GameCenterGetSupportedABIsAction() {
        super(ACTION_NAME);
    }

    public SwanApiResult handle(JSONObject paramsJson, IGameCenterCallback callback) {
        JSONObject jsonObject = new JSONObject();
        StringBuilder builder = new StringBuilder();
        try {
            for (String abi : Build.SUPPORTED_64_BIT_ABIS) {
                builder.append(abi).append(",");
            }
            for (String abi2 : Build.SUPPORTED_32_BIT_ABIS) {
                builder.append(abi2).append(",");
            }
            jsonObject.put("data", builder.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        callback.onSuccess(jsonObject);
        return null;
    }
}
