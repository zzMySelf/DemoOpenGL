package com.baidu.swan.games.updatemanager;

import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.swan.apps.binding.model.JSObjectMap;

public class UpdateCallback {
    private static final String FUNC_CHECK_FOR_UPDATE = "onCheckForUpdate";
    private static final String FUNC_ON_UPDATE_FAILED = "onUpdateFailed";
    private static final String FUNC_ON_UPDATE_READY = "onUpdateReady";
    private JsFunction mOnCheckForUpdate;
    private JsFunction mOnUpdateFailed;
    private JsFunction mOnUpdateReady;

    public static UpdateCallback parseFromObjectMap(JSObjectMap objectMap) {
        if (objectMap == null) {
            return null;
        }
        UpdateCallback callback = new UpdateCallback();
        JsFunction optJsFunction = objectMap.optJsFunction(FUNC_CHECK_FOR_UPDATE);
        callback.mOnCheckForUpdate = optJsFunction;
        if (optJsFunction != null) {
            optJsFunction.setReleaseMode(false);
        }
        JsFunction optJsFunction2 = objectMap.optJsFunction(FUNC_ON_UPDATE_READY);
        callback.mOnUpdateReady = optJsFunction2;
        if (optJsFunction2 != null) {
            optJsFunction2.setReleaseMode(false);
        }
        JsFunction optJsFunction3 = objectMap.optJsFunction(FUNC_ON_UPDATE_FAILED);
        callback.mOnUpdateFailed = optJsFunction3;
        if (optJsFunction3 != null) {
            optJsFunction3.setReleaseMode(false);
        }
        return callback;
    }

    public void onCheckForUpdate(UpdateEvent jsEvent) {
        JsFunction jsFunction = this.mOnCheckForUpdate;
        if (jsFunction != null) {
            jsFunction.call((Object) jsEvent);
        }
    }

    public void onUpdateReady() {
        JsFunction jsFunction = this.mOnUpdateReady;
        if (jsFunction != null) {
            jsFunction.call();
        }
    }

    public void onUpdateFailed() {
        JsFunction jsFunction = this.mOnUpdateFailed;
        if (jsFunction != null) {
            jsFunction.call();
        }
    }
}
