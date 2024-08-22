package com.baidu.swan.apps.system.compass.action;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.api.module.system.CompassApi;
import com.baidu.swan.apps.api.module.system.SwanSensorCallback;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.scheme.UnitedSchemeSwanAppDispatcher;
import com.baidu.swan.apps.scheme.actions.SwanAppAction;
import com.baidu.swan.apps.system.compass.SwanAppCompassManager;
import org.json.JSONException;
import org.json.JSONObject;

public class StartCompassAction extends SwanAppAction {
    public static final String ACTION_TYPE = "/swanAPI/startCompass";
    private static final String KEY_ACCURACY = "accuracy";
    private static final String KEY_DIRECTION = "direction";
    private static final String MODULE_TAG = "compass";

    public StartCompassAction(UnitedSchemeSwanAppDispatcher dispatcher) {
        super(dispatcher, ACTION_TYPE);
    }

    public boolean handle(Context context, final UnitedSchemeEntity entity, final CallbackHandler handler, SwanApp swanApp) {
        if (swanApp == null) {
            SwanAppLog.e(MODULE_TAG, "none swanApp");
            entity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (DEBUG) {
                Log.d("SwanAppAction", "startCompass --- illegal swanApp");
            }
            return false;
        } else if (context == null) {
            SwanAppLog.e(MODULE_TAG, "none context");
            entity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
            if (DEBUG) {
                Log.d("SwanAppAction", "startCompass --- illegal context");
            }
            return false;
        } else {
            JSONObject paramsJson = UnitedSchemeUtility.optParamsAsJo(entity);
            if (paramsJson == null) {
                if (DEBUG) {
                    Log.d("SwanAppAction", "startCompass --- params is empty");
                }
                SwanAppLog.e(MODULE_TAG, "none params");
                entity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            String cb = paramsJson.optString("cb");
            if (TextUtils.isEmpty(cb)) {
                if (DEBUG) {
                    Log.d("SwanAppAction", "startCompass --- cb is empty");
                }
                SwanAppLog.e(MODULE_TAG, "cb is empty");
                entity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            SwanAppLog.i(MODULE_TAG, "init");
            final SwanSensorCallback sensorCallback = new SwanSensorCallback(CompassApi.EVENT_COMPASS_CHANGE, paramsJson, cb);
            SwanAppCompassManager manager = SwanAppCompassManager.getInstance();
            manager.init(context);
            manager.addOnCompassChangeListener("master", new SwanAppCompassManager.OnCompassChangeListener() {
                public void onCompassChange(String slaveId, float compassAngle, int accuracy) {
                    SwanAppLog.i(StartCompassAction.MODULE_TAG, "handle compass change, angle:" + compassAngle + ",accuracy: " + accuracy);
                    StartCompassAction.this.handleCompassChange(entity, handler, sensorCallback, compassAngle, accuracy);
                }
            });
            SwanAppLog.i(MODULE_TAG, "start listen compass");
            manager.startListenCompass();
            UnitedSchemeUtility.callCallback(handler, entity, 0);
            sensorCallback.invokeCbIfNeeded(entity, handler);
            return true;
        }
    }

    /* access modifiers changed from: private */
    public void handleCompassChange(UnitedSchemeEntity entity, CallbackHandler handler, SwanSensorCallback callback, float compassAngle, int accuracy) {
        JSONObject jsonData = new JSONObject();
        try {
            jsonData.put("direction", (double) compassAngle);
            jsonData.put(KEY_ACCURACY, SwanAppCompassManager.getAccuracyType(accuracy));
            if (DEBUG) {
                Log.d("SwanAppAction", "compassAngle : " + jsonData.toString());
            }
            callback.notifySensorDataChanged(entity, handler, jsonData);
        } catch (JSONException e2) {
            SwanAppLog.e(MODULE_TAG, "handle compass,json error，" + e2.toString());
            callback.notifySensorDataError(entity, handler, "Json error");
        }
    }
}
