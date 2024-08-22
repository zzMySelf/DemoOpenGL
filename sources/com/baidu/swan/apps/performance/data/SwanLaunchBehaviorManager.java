package com.baidu.swan.apps.performance.data;

import android.content.ContentResolver;
import android.content.ContentValues;
import com.baidu.swan.apps.database.favorite.SwanUserBehaviorTable;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.statistic.SwanAppStatsUtils;
import com.baidu.swan.apps.util.SwanAppExecutorUtils;

public class SwanLaunchBehaviorManager {
    public static final short BACKSTAGE_SURVIVAL_DEFAULT = 300;
    private static final boolean DEBUG = false;
    private static final String KEY_STEP = "step";
    public static final String SP_NAME_LAUNCH_BEHAVIOR = "sp_launch_behavior";
    private static final String TAG = "SwanLaunchBehavior";

    public static void recordLaunchFinish() {
        SwanAppExecutorUtils.postOnIO(new Runnable() {
            public void run() {
                SwanApp swanApp = SwanApp.getOrNull();
                if (swanApp != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("appKey", swanApp.getAppId());
                    contentValues.put("launch_type", Integer.valueOf(SwanAppStatsUtils.getStartType()));
                    contentValues.put("source", swanApp.getInfo().getLaunchFrom());
                    contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
                    ContentResolver resolver = SwanAppRuntime.getAppContext().getContentResolver();
                    if (resolver != null) {
                        try {
                            resolver.insert(SwanUserBehaviorTable.getTableUri(), contentValues);
                        } catch (Exception e2) {
                        }
                    }
                }
            }
        }, TAG);
    }
}
