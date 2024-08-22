package com.baidu.searchbox.launch.stats;

import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import java.util.Map;
import org.json.JSONObject;

public abstract class AbstractSpeedStats {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static String TAG = "AbstractSpeedStats";

    public void addStatsTimeStamp(int key) {
        if (DEBUG) {
            Log.d(TAG, "addStatsTimeStamp key: " + key);
        }
    }

    public void addStatsTimeStamp(int key, long timeStamp) {
        if (DEBUG) {
            Log.d(TAG, "addStatsTimeStamp key: " + key + " timeStamp " + timeStamp);
        }
    }

    public void addStatsDuration(String key, long duration) {
        if (DEBUG) {
            Log.d(TAG, "addStatsDuration key: " + key + " duration " + duration);
        }
    }

    public void addStatsMap(String key, Map<String, String> map) {
        if (DEBUG) {
            Log.d(TAG, "addStatsTimeStamp key: " + key + " map " + map.toString());
        }
    }

    public void reset() {
    }

    public boolean packData(JSONObject json) {
        if (!DEBUG) {
            return false;
        }
        Log.d(TAG, "addStatsTimeStamp json " + json.toString());
        return false;
    }

    public long getStatsStartTimeStamp() {
        return -1;
    }

    public long getStatsEndTimeStamp() {
        return -1;
    }
}
