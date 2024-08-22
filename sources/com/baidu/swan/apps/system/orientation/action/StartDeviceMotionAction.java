package com.baidu.swan.apps.system.orientation.action;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.api.module.system.SwanSensorCallback;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.scheme.UnitedSchemeSwanAppDispatcher;
import com.baidu.swan.apps.scheme.actions.SwanAppAction;
import com.baidu.swan.apps.system.orientation.SwanAppOrientationManager;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

public class StartDeviceMotionAction extends SwanAppAction {
    private static final String ACTION_TAG = "StartDeviceMotionAction";
    private static final String ACTION_TYPE = "/swanAPI/startDeviceMotion";
    private static final String EVENT_DEVICE_MOTION_CHANGE = "deviceMotionChange";
    private static final String KEY_CALLBACK_ALPHA = "alpha";
    private static final String KEY_CALLBACK_BETA = "beta";
    private static final String KEY_CALLBACK_GAMMA = "gamma";
    private static final String KEY_INTERVAL = "interval";
    private static final String VALUE_INTERVAL_GAME = "game";
    private static final String VALUE_INTERVAL_UI = "ui";

    public StartDeviceMotionAction(UnitedSchemeSwanAppDispatcher dispatcher) {
        super(dispatcher, ACTION_TYPE);
    }

    public boolean handle(Context context, final UnitedSchemeEntity entity, final CallbackHandler handler, SwanApp swanApp) {
        int sensorDelay;
        if (swanApp == null) {
            SwanAppLog.e(ACTION_TAG, "none swanApp");
            entity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal swanApp");
            return false;
        } else if (context == null) {
            SwanAppLog.e(ACTION_TAG, "none context");
            entity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal context");
            return false;
        } else {
            JSONObject paramsJson = UnitedSchemeUtility.optParamsAsJo(entity);
            if (paramsJson == null) {
                SwanAppLog.e(ACTION_TAG, "none params");
                entity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            String cb = paramsJson.optString("cb");
            if (TextUtils.isEmpty(cb)) {
                SwanAppLog.e(ACTION_TAG, "cb is empty");
                entity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String interval = paramsJson.optString("interval");
            if ("ui".equals(interval)) {
                sensorDelay = 2;
            } else if ("game".equals(interval)) {
                sensorDelay = 1;
            } else {
                sensorDelay = 3;
            }
            SwanAppLog.i(ACTION_TAG, "startSensor===");
            final SwanSensorCallback sensorCallback = new SwanSensorCallback(EVENT_DEVICE_MOTION_CHANGE, paramsJson, cb);
            if (!SwanAppOrientationManager.getInstance().startListenOrientation(sensorDelay, new SwanAppOrientationManager.IOrientationChangeListener() {
                public void onOrientationChange(float[] orientationData) {
                    if (orientationData != null && orientationData.length == 3) {
                        StartDeviceMotionAction.this.handleSensorData(entity, handler, sensorCallback, orientationData);
                    }
                }
            })) {
                SwanAppLog.e(ACTION_TAG, "start system sensor fail");
                entity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "start system sensor fail");
                return false;
            }
            UnitedSchemeUtility.callCallback(handler, entity, 0);
            sensorCallback.invokeCbIfNeeded(entity, handler);
            return true;
        }
    }

    /* access modifiers changed from: private */
    public void handleSensorData(UnitedSchemeEntity entity, CallbackHandler handler, SwanSensorCallback callback, float[] data) {
        JSONObject jsonData = new JSONObject();
        double[] actionResult = new double[3];
        double alpha = ((double) data[0]) - 1.5707963267948966d;
        if (alpha < 0.0d) {
            alpha += 6.283185307179586d;
        }
        actionResult[0] = Math.toDegrees(alpha);
        actionResult[1] = Math.toDegrees((double) (-data[2]));
        actionResult[2] = Math.toDegrees((double) (-data[1]));
        if (DEBUG) {
            Log.i("SwanAppAction", "deviceMotionChange: " + Arrays.toString(actionResult));
        }
        try {
            jsonData.put("alpha", (double) ((float) actionResult[0]));
            jsonData.put(KEY_CALLBACK_BETA, (double) ((float) actionResult[1]));
            jsonData.put(KEY_CALLBACK_GAMMA, (double) ((float) actionResult[2]));
            callback.notifySensorDataChanged(entity, handler, jsonData);
        } catch (JSONException e2) {
            SwanAppLog.e(ACTION_TAG, "handle orientation,json error，" + e2.toString());
            callback.notifySensorDataError(entity, handler, "Json error");
        }
    }
}
