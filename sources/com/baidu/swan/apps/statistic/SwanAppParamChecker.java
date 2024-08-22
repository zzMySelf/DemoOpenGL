package com.baidu.swan.apps.statistic;

import android.text.TextUtils;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.launch.model.SwanAppLaunchInfo;
import com.baidu.swan.apps.lifecycle.SwanAppController;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.statistic.SwanAppBusinessUbc;
import com.baidu.swan.apps.swancore.SwanAppSwanCoreManager;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.util.SwanAppUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class SwanAppParamChecker {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    public static final int DEFAULT_SWAN_UBC_LOG_SIZE = 150;
    private static final String EXT_KEY_PARAMS = "params";
    private static final String EXT_KEY_SCHEME = "scheme";
    private static final String EXT_KEY_SWAN_CORE_VERSION = "swanjs";
    private static final int SWAN_UBC_LOG_MAX_SIZE_BYTES = (SwanAppRuntime.getSwanAppAbTestRuntime().getUbcReportLogSize() * 1024);
    private static final String TAG = "SwanAppParamChecker";
    private static final int UNIT_KB = 1024;

    public static boolean checkParamsOverMaxLimit(String params) {
        if (!hasHitsLimitSizeAbTest()) {
            return false;
        }
        boolean result = checkParamsLengthInvalid(params);
        if (result) {
            reportEvent(params);
        }
        return result;
    }

    private static boolean hasHitsLimitSizeAbTest() {
        return SWAN_UBC_LOG_MAX_SIZE_BYTES > 0;
    }

    private static boolean checkParamsLengthInvalid(String params) {
        if (!TextUtils.isEmpty(params) && params.getBytes().length > SWAN_UBC_LOG_MAX_SIZE_BYTES) {
            return true;
        }
        return false;
    }

    private static void reportEvent(String params) {
        SwanApp swanApp = SwanApp.getOrNull();
        if (swanApp != null) {
            try {
                JSONObject info = new JSONObject();
                SwanAppLaunchInfo.Impl launchInfo = swanApp.getInfo();
                SwanCoreVersion version = SwanAppController.getInstance().getCoreVersion();
                int frameType = swanApp.getFrameType();
                info.putOpt("scheme", launchInfo.getLaunchScheme());
                info.putOpt(EXT_KEY_SWAN_CORE_VERSION, SwanAppSwanCoreManager.getSwanCoreVersionName(version, frameType));
                if (params != null && params.length() > 1024) {
                    info.putOpt("params", params.substring(0, 1024));
                }
                new SwanAppBusinessUbc.Builder(10020).buildPage(SwanAppUtils.getCurSwanAppPageParam().getPage()).buildInfo(info.toString()).buildAppId(swanApp.getAppId()).report();
                SwanAppLog.logToFile(TAG, "10020, params: " + params);
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
