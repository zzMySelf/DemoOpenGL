package com.baidu.map.poipage.sp;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.map.poipage.utils.MLog;
import com.baidu.searchbox.common.runtime.AppRuntime;

public class PoiPagePreference {
    private static final String KEY_REQUEST_LOC_PERMISSION_TIME_IN_APP = "request_location_permission_time_in_app";
    private static final String KEY_REQUEST_LOC_PERMISSION_TIME_IN_SCENE = "request_location_permission_time_in_scene";
    private static final String TABLE_NAME = "PoiPagePreference";
    private static final String TAG = "PoiPagePreference";

    public static SharedPreferences obtainWidgetSilentSp() {
        Context context = AppRuntime.getAppContext();
        if (context != null) {
            return context.getSharedPreferences("PoiPagePreference", 0);
        }
        MLog.e("PoiPagePreference", "App context is null, unable to obtain SharedPreferences.");
        return null;
    }

    public static void setKeyRequestLocPermissionTimeInApp(long time) {
        SharedPreferences prefs = obtainWidgetSilentSp();
        if (prefs != null) {
            MLog.i("PoiPagePreference", "getRequestLocPermissionTimeInApp: " + time);
            prefs.edit().putLong(KEY_REQUEST_LOC_PERMISSION_TIME_IN_APP, time).apply();
            return;
        }
        MLog.e("PoiPagePreference", "SharedPreferences is null, app cannot save request location time.");
    }

    public static long getRequestLocPermissionTimeInApp() {
        SharedPreferences prefs = obtainWidgetSilentSp();
        if (prefs != null) {
            long time = prefs.getLong(KEY_REQUEST_LOC_PERMISSION_TIME_IN_APP, 0);
            MLog.i("PoiPagePreference", "getRequestLocPermissionTimeInApp: " + time);
            return time;
        }
        MLog.e("PoiPagePreference", "SharedPreferences is null, app cannot retrieve request location time.");
        return 0;
    }

    public static void setRequestLocPermissionTimeInScene(long time) {
        SharedPreferences prefs = obtainWidgetSilentSp();
        if (prefs != null) {
            MLog.i("PoiPagePreference", "setRequestLocPermissionTimeInScene: " + time);
            prefs.edit().putLong(KEY_REQUEST_LOC_PERMISSION_TIME_IN_SCENE, time).apply();
            return;
        }
        MLog.e("PoiPagePreference", "SharedPreferences is null, scene cannot save request location time.");
    }

    public static long getRequestLocPermissionTimeInScene() {
        SharedPreferences prefs = obtainWidgetSilentSp();
        if (prefs != null) {
            long time = prefs.getLong(KEY_REQUEST_LOC_PERMISSION_TIME_IN_SCENE, 0);
            MLog.i("PoiPagePreference", "setRequestLocPermissionTimeInScene: " + time);
            return time;
        }
        MLog.e("PoiPagePreference", "SharedPreferences is null, scene cannot retrieve request location time.");
        return 0;
    }
}
