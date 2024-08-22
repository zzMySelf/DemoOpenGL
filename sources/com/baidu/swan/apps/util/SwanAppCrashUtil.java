package com.baidu.swan.apps.util;

import android.text.TextUtils;
import android.util.Pair;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.launch.model.SwanAppLaunchInfo;
import com.baidu.swan.apps.lifecycle.SwanAppController;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import org.json.JSONException;
import org.json.JSONObject;

public class SwanAppCrashUtil {
    private static final String TAG = "SwanAppCrashUtil";

    public static Pair<String, JSONObject> getMnpKeyAndValue() {
        SwanApp swanApp = SwanApp.getOrNull();
        if (swanApp == null) {
            return Pair.create("mnp", new JSONObject());
        }
        JSONObject result = new JSONObject();
        try {
            JSONObject commonInfo = new JSONObject();
            commonInfo.put("appName", swanApp.getName());
            commonInfo.put("appKey", swanApp.getAppKey());
            if (!swanApp.isSwanGame()) {
                String page = SwanAppController.getInstance().getCurSwanAppsPage();
                if (!TextUtils.isEmpty(page)) {
                    commonInfo.put("path", page);
                }
            }
            SwanAppLaunchInfo.Impl info = swanApp.getInfo();
            if (info != null) {
                commonInfo.put("appVersion", info.getVersionCode());
                SwanCoreVersion swanCoreVersion = info.getSwanCoreVersion();
                if (swanCoreVersion != null) {
                    commonInfo.put("jsVersion", swanCoreVersion.swanCoreVersionName);
                }
            }
            result.put("commonInfo", commonInfo);
            return Pair.create("mnp", result);
        } catch (JSONException e2) {
            SwanAppLog.logToFile(TAG, "#getMnpKeyAndValue ", e2);
            return Pair.create("mnp", new JSONObject());
        }
    }
}
