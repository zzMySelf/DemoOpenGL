package com.baidu.swan.apps.so;

import android.util.Log;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.zeus.jsr.abtest.IABTestInterface;

public class JSRABTestInterfaceImpl implements IABTestInterface {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    public static final String TAG = "JSRABTestInterfaceImpl";

    public boolean getSwitch(String key, boolean defaultValue) {
        boolean res = SwanAppRuntime.getSwanAppAbTestRuntime().getSwitch(key, defaultValue);
        if (DEBUG) {
            Log.i(TAG, "get key: " + key + " value: " + res);
        }
        return res;
    }

    public double getSwitch(String key, double defaultValue) {
        double res = SwanAppRuntime.getSwanAppAbTestRuntime().getSwitch(key, defaultValue);
        if (DEBUG) {
            Log.i(TAG, "get key: " + key + " value: " + res);
        }
        return res;
    }

    public int getSwitch(String key, int defaultValue) {
        int res = SwanAppRuntime.getSwanAppAbTestRuntime().getSwitch(key, defaultValue);
        if (DEBUG) {
            Log.i(TAG, "get key: " + key + " value: " + res);
        }
        return res;
    }

    public long getSwitch(String key, long defaultValue) {
        long res = SwanAppRuntime.getSwanAppAbTestRuntime().getSwitch(key, defaultValue);
        if (DEBUG) {
            Log.i(TAG, "get key: " + key + " value: " + res);
        }
        return res;
    }

    public String getSwitch(String key, String defaultValue) {
        String res = SwanAppRuntime.getSwanAppAbTestRuntime().getSwitch(key, defaultValue);
        if (DEBUG) {
            Log.i(TAG, "get key: " + key + " value: " + res);
        }
        return res;
    }
}
