package com.baidu.swan.apps.aps;

import android.text.TextUtils;
import com.baidu.swan.apps.launch.model.SwanAppLaunchInfo;

public class SwanAppApsUtils {
    public static final String DEV = "_dev";
    public static final String DOMAINS = "domains";
    public static final String ERROR_CODE = "error_code";
    public static final String SWAN_CONF = "swan_conf";
    public static final String TRIAL = "_trial";
    public static final String TYPE = "type";
    public static final String UNDERLINE = "_";
    public static final String WEB_VIEW_DOMAINS = "web_view_domains";

    @Deprecated
    public static boolean isOnlinePackage(String appId) {
        return !TextUtils.isEmpty(appId) && !appId.contains("_");
    }

    public static boolean isOnlinePackage(SwanAppLaunchInfo launchInfo) {
        if (launchInfo != null && launchInfo.getType() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isDevPackage(SwanAppLaunchInfo launchInfo) {
        return launchInfo != null && launchInfo.getType() == 1;
    }

    public static boolean isTrialPackage(SwanAppLaunchInfo launchInfo) {
        return launchInfo != null && launchInfo.getType() == 2;
    }

    public static int getAppTypeByAppKey(String appKey) {
        if (TextUtils.isEmpty(appKey)) {
            return 0;
        }
        if (appKey.contains("_dev")) {
            return 1;
        }
        if (appKey.endsWith("_trial")) {
            return 3;
        }
        if (appKey.contains("_trial")) {
            return 2;
        }
        return 0;
    }

    public static String getAppKey(String appId) {
        if (TextUtils.isEmpty(appId)) {
            return appId;
        }
        int devIndex = appId.indexOf("_dev");
        if (devIndex > 0) {
            return appId.substring(0, devIndex);
        }
        int trialIndex = appId.indexOf("_trial");
        if (trialIndex > 0) {
            return appId.substring(0, trialIndex);
        }
        return appId;
    }

    public static String getAppIdForAd(SwanAppLaunchInfo launchInfo) {
        String appId = launchInfo.getAppKey();
        if (TextUtils.isEmpty(appId)) {
            return appId;
        }
        switch (launchInfo.getType()) {
            case 1:
                return appId + "_dev";
            case 2:
            case 3:
                return appId + "_trial";
            default:
                return appId;
        }
    }

    public static String getSwanAppIdVersion(String appId) {
        if (TextUtils.isEmpty(appId)) {
            return "";
        }
        int devIndex = appId.lastIndexOf("_dev");
        if (devIndex >= 0 && devIndex < appId.length()) {
            return appId.substring(devIndex);
        }
        int trialIndex = appId.lastIndexOf("_trial");
        if (trialIndex < 0 || trialIndex >= appId.length()) {
            return "";
        }
        return appId.substring(trialIndex);
    }
}
