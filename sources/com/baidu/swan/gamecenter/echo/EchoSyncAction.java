package com.baidu.swan.gamecenter.echo;

import com.baidu.swan.apps.api.result.SwanApiResult;
import com.baidu.swan.apps.gamecenter.IGameCenterCallback;
import com.baidu.swan.gamecenter.main.GameCenterAction;
import org.json.JSONObject;

public class EchoSyncAction extends GameCenterAction {
    private static final String API_NAME = "echoSync";

    public EchoSyncAction() {
        super(API_NAME);
    }

    public SwanApiResult handle(JSONObject paramsJson, IGameCenterCallback callback) {
        int status = paramsJson.optInt("status", 0);
        String message = paramsJson.optString("message");
        JSONObject data = paramsJson.optJSONObject("data");
        if (status == 0) {
            return new SwanApiResult(status, data);
        }
        return new SwanApiResult(status, message);
    }
}
