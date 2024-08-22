package com.baidu.swan.apps.core.launchtips.scene.handler;

import com.baidu.swan.apps.api.result.SwanApiResult;
import com.baidu.swan.apps.core.launchtips.scene.SceneInitDataTips;
import org.json.JSONObject;

class DataInitErrorHandler extends AbsExceptionHandler<JSONObject, SwanApiResult> {
    DataInitErrorHandler() {
    }

    public SwanApiResult handle(JSONObject params) {
        new SceneInitDataTips().handleInitDataErrorEvent();
        return new SwanApiResult(0);
    }
}
