package com.baidu.swan.apps.api.module.system;

import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.api.base.SwanBaseApi;
import com.baidu.swan.apps.api.result.SwanApiResult;
import com.baidu.swan.apps.event.message.SwanAppSensorMessage;
import com.baidu.swan.apps.lifecycle.SwanAppController;
import org.json.JSONObject;

public class SwanSensorCallback {
    private static final int ERR_EXECUTE_FAIL = 1001;
    private static final int ERR_OK = 0;
    private static final String PARAM_USE_EVENT = "useEvent";
    private final boolean isUseEvent;
    private final String mCb;
    private final String mEventName;

    public SwanSensorCallback(String eventName, JSONObject paramsJson, String cb) {
        this.mEventName = eventName;
        this.mCb = cb;
        this.isUseEvent = paramsJson.optBoolean(PARAM_USE_EVENT);
    }

    public SwanSensorCallback(String eventName, String cb) {
        this.mEventName = eventName;
        this.mCb = cb;
        this.isUseEvent = true;
    }

    public void invokeCbIfNeeded(SwanBaseApi swanBaseApi) {
        if (this.isUseEvent) {
            swanBaseApi.invokeCallback(this.mCb, new SwanApiResult(0));
        }
    }

    public void invokeCbIfNeeded(UnitedSchemeEntity entity, CallbackHandler handler) {
        if (this.isUseEvent) {
            UnitedSchemeUtility.safeCallback(handler, entity, UnitedSchemeUtility.wrapCallbackParams(0).toString(), this.mCb);
        }
    }

    public void notifySensorDataChanged(SwanBaseApi swanBaseApi, JSONObject data) {
        SwanApiResult result = new SwanApiResult(0, data);
        if (this.isUseEvent) {
            SwanAppController.getInstance().sendJSMessage(new SwanAppSensorMessage(this.mEventName, result));
        } else {
            swanBaseApi.invokeCallback(this.mCb, result);
        }
    }

    public void notifyCompassDataChanged(SwanBaseApi swanBaseApi, String slaveId, JSONObject data) {
        SwanApiResult result = new SwanApiResult(0, data);
        if (!this.isUseEvent) {
            swanBaseApi.invokeCallback(this.mCb, result);
        } else if (TextUtils.equals(slaveId, "master")) {
            SwanAppController.getInstance().sendJSMessage(new SwanAppSensorMessage(this.mEventName, result));
        } else {
            SwanAppController.getInstance().sendJSMessage(slaveId, new SwanAppSensorMessage(this.mEventName, result));
        }
    }

    public void notifyCompassDataError(SwanBaseApi swanBaseApi, String slaveId, String message) {
        SwanApiResult result = new SwanApiResult(1001, message);
        if (!this.isUseEvent) {
            swanBaseApi.invokeCallback(this.mCb, result);
        } else if (TextUtils.equals(slaveId, "master")) {
            SwanAppController.getInstance().sendJSMessage(new SwanAppSensorMessage(this.mEventName, result));
        } else {
            SwanAppController.getInstance().sendJSMessage(slaveId, new SwanAppSensorMessage(this.mEventName, result));
        }
    }

    public void notifySensorDataChanged(UnitedSchemeEntity entity, CallbackHandler handler, JSONObject data) {
        if (this.isUseEvent) {
            SwanAppController.getInstance().sendJSMessage(new SwanAppSensorMessage(this.mEventName, new SwanApiResult(0, data)));
            return;
        }
        UnitedSchemeUtility.safeCallback(handler, entity, UnitedSchemeUtility.wrapCallbackParams(data, 0).toString(), this.mCb);
    }

    public void notifySensorDataError(SwanBaseApi swanBaseApi, String message) {
        SwanApiResult result = new SwanApiResult(1001, message);
        if (this.isUseEvent) {
            SwanAppController.getInstance().sendJSMessage(new SwanAppSensorMessage(this.mEventName, result));
        } else {
            swanBaseApi.invokeCallback(this.mCb, result);
        }
    }

    public void notifySensorDataError(UnitedSchemeEntity entity, CallbackHandler handler, String message) {
        if (this.isUseEvent) {
            SwanAppController.getInstance().sendJSMessage(new SwanAppSensorMessage(this.mEventName, new SwanApiResult(1001, message)));
            return;
        }
        UnitedSchemeUtility.safeCallback(handler, entity, UnitedSchemeUtility.wrapCallbackParams(1001, message).toString(), this.mCb);
    }
}
