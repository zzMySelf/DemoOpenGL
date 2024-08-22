package com.baidu.swan.apps.api.module.system;

import android.app.Activity;
import androidx.collection.ArrayMap;
import com.baidu.swan.apps.api.base.ISwanApiContext;
import com.baidu.swan.apps.api.base.SwanBaseApi;
import com.baidu.swan.apps.api.result.SwanApiResult;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.system.accelerometer.SwanAppAccelerometerManager;
import org.json.JSONException;
import org.json.JSONObject;

public class AccelerometerApi extends AbsSystemApi {
    private static final String ACTION_START_ACCELEROMETER = "startAccelerometer";
    private static final String ACTION_STOP_ACCELEROMETER = "stopAccelerometer";
    public static final String EVENT_ACCURACY_CHANGE = "accelerometerChange";
    public static final String KEY_ACCELEROMETER_INTERVAL = "interval";
    public static final String KEY_ACCELEROMETER_X = "x";
    public static final String KEY_ACCELEROMETER_Y = "y";
    public static final String KEY_ACCELEROMETER_Z = "z";
    public static final int NUMBER_ACCELEROMETER = 3;
    private static final String TAG = "AccelerometerApi";
    private static final String WHITELIST_START_ACCELEROMETER = "swanAPI/startAccelerometer";
    private static final String WHITELIST_STOP_ACCELEROMETER = "swanAPI/stopAccelerometer";

    public String getLogTag() {
        return TAG;
    }

    public AccelerometerApi(ISwanApiContext swanApiContext) {
        super(swanApiContext);
    }

    public SwanApiResult startAccelerometer(String params) {
        logInfo("#startAccelerometer", false);
        return handleParseCommonParam(params, true, false, true, new SwanBaseApi.CommonApiHandler() {
            public SwanApiResult handle(SwanApp swanApp, Activity activity, JSONObject joParams, final String callback) {
                final SwanSensorCallback sensorCallback = new SwanSensorCallback(AccelerometerApi.EVENT_ACCURACY_CHANGE, joParams, callback);
                SwanAppAccelerometerManager manager = SwanAppAccelerometerManager.getInstance();
                manager.init(AccelerometerApi.this.getContext(), AccelerometerInterval.getAccelerometerInterval(joParams.optString("interval")));
                manager.setOnAccelerometerChangeListener(new SwanAppAccelerometerManager.OnAccelerometerChangeListener() {
                    public void onAccelerometerChange(double[] accelerometers) {
                        if (accelerometers == null || accelerometers.length != 3) {
                            AccelerometerApi.this.logError("illegal accelerometers", (Throwable) null, true);
                            AccelerometerApi.this.invokeCallback(callback, new SwanApiResult(1001));
                            return;
                        }
                        JSONObject jsonData = new JSONObject();
                        try {
                            jsonData.put("x", accelerometers[0]);
                            jsonData.put("y", accelerometers[1]);
                            jsonData.put("z", accelerometers[2]);
                            sensorCallback.notifySensorDataChanged(AccelerometerApi.this, jsonData);
                        } catch (JSONException e2) {
                            AccelerometerApi.this.logError("json put data fail", e2, true);
                            sensorCallback.notifySensorDataError(AccelerometerApi.this, "json put data fail");
                        }
                    }
                });
                manager.startListenAccelerometer();
                sensorCallback.invokeCbIfNeeded(AccelerometerApi.this);
                return SwanApiResult.ok();
            }
        });
    }

    public SwanApiResult stopAccelerometer() {
        logInfo("#stopAccelerometer", true);
        SwanAppAccelerometerManager.getInstance().stopListenAccelerometer();
        return SwanApiResult.ok();
    }

    public static class AccelerometerInterval {
        private static final String KEY_ACCELEROMETER_GAME = "game";
        private static final String KEY_ACCELEROMETER_NORMAL = "normal";
        private static final String KEY_ACCELEROMETER_UI = "ui";
        private static final int VALUE_ACCELEROMETER_GAME = 20;
        private static final int VALUE_ACCELEROMETER_NORMAL = 200;
        private static final int VALUE_ACCELEROMETER_UI = 60;
        private static ArrayMap<String, Integer> sIntervalMap;

        static {
            ArrayMap<String, Integer> arrayMap = new ArrayMap<>(3);
            sIntervalMap = arrayMap;
            arrayMap.put("ui", 60);
            sIntervalMap.put("game", 20);
            sIntervalMap.put("normal", 200);
        }

        public static int getAccelerometerInterval(String key) {
            Integer value = sIntervalMap.get(key);
            if (value != null) {
                return value.intValue();
            }
            return 200;
        }
    }
}
