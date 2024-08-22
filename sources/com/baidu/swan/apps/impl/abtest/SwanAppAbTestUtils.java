package com.baidu.swan.apps.impl.abtest;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.launch.LaunchABUtils;
import com.baidu.searchbox.abtest.AbTestManager;
import com.baidu.swan.apps.prepose.util.SwanAppDebugUtil;
import com.baidu.swan.apps.runtime.SwanApp;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class SwanAppAbTestUtils {
    private static final boolean DEBUG = SwanApp.DEBUG;
    public static final int DEFAULT_DOMAINS_CHECK_SWITCH = 25;
    public static final int HTTPS_PROTOCOL_CHECK_SWITCH = 8;
    private static final int INLINE_PLAYER_SAME_PROCESS_VALUE_DEFAULT = -1;
    private static final int INLINE_PLAYER_SAME_PROCESS_VALUE_FALSE = 0;
    private static final int INLINE_PLAYER_SAME_PROCESS_VALUE_TRUE = 1;
    public static final int PORT_CHECK_SWITCH = 4;
    private static final int SERVER_DOMAINS_CHECK_SWITCH = 2;
    public static final String SWAN_APP_NETWORK_DOMAIN_CHECK = "aiapps_network_domain_port_check";
    private static final String TAG = "SwanAppAbTestUtils";
    private static final int UNINITIALIZED = -1234;
    public static final boolean UNITED_LOW_END_V2 = AbTestManager.getInstance().getUnitedSwitch(LaunchABUtils.LOWENDV2_MAIN_KEY, "lowendv2_enable", true);
    private static final int WEBVIEW_DOMAINS_CHECK_SWITCH = 1;
    public static final int WEBVIEW_IFRAME_CHECK_SWITCH = 16;
    private static int sIsInlinePlayerSameProcessValue = -1;
    private static int sNetworkDomainCheck = UNINITIALIZED;
    private static Boolean sSystemInfoCacheSwitch = null;

    public static int getSwanAppNavigateMaxValue() {
        return getSwitch(SwanAppAbTestConstant.SWAN_APP_NAVIGATE_MAX_SWITCH, 10);
    }

    public static boolean isPreloadUbcSwitchOn() {
        return getSwitch(SwanAppAbTestConstant.PRELOAD_UBC_SWITCH, false);
    }

    public static JSONObject getRawSwitch() {
        JSONObject data = AbTestManager.getInstance().getRawSwitch();
        if (DEBUG) {
            JSONObject abTestConfig = SwanAppABTestManager.getInstance().getRawSwitch();
            Iterator<String> iterator = abTestConfig.keys();
            while (iterator.hasNext()) {
                try {
                    String key = iterator.next();
                    data.put(key, abTestConfig.get(key));
                } catch (JSONException e2) {
                    Log.i(TAG, e2.getMessage());
                }
            }
        }
        return data;
    }

    public static boolean getServerDomainsCheckAbTestSwitch() {
        return 2 == (getDomainsCheckAbTestSwitch() & 2);
    }

    public static boolean getHttpsProtocolAbTestSwitch() {
        return 8 == (getDomainsCheckAbTestSwitch() & 8);
    }

    public static boolean getWebDomainsAbTestSwitch() {
        return 1 == (getDomainsCheckAbTestSwitch() & 1);
    }

    public static boolean getPortCheckAbTestSwitch() {
        return 4 == (getDomainsCheckAbTestSwitch() & 4);
    }

    public static boolean getWebViewIFrameCheckSwitch() {
        return 16 == (getDomainsCheckAbTestSwitch() & 16);
    }

    public static int getDomainsCheckAbTestSwitch() {
        if (sNetworkDomainCheck == UNINITIALIZED) {
            sNetworkDomainCheck = getSwitch(SWAN_APP_NETWORK_DOMAIN_CHECK, 25);
        }
        return sNetworkDomainCheck;
    }

    public static boolean isV8MasterSwitchOn() {
        if (SwanAppDebugUtil.shouldForceAbForTest() || getSwitch(SwanAppAbTestConstant.SWAN_APP_V8_MASTER, true)) {
            return true;
        }
        return false;
    }

    public static boolean isProtectWebViewSwitchOn() {
        return getSwitch(SwanAppAbTestConstant.SWAN_PROTECT_WEBVIEW, false);
    }

    public static boolean isUploadJsSwitchOn() {
        return getSwitch(SwanAppAbTestConstant.SWAN_UPLOAD_JS, false);
    }

    public static boolean isV8StabilitySwitchOn() {
        return getSwitch(SwanAppAbTestConstant.SWAN_V8_STABILITY_SWITCH, false);
    }

    public static long getRecordFcpSwitch() {
        return (long) getSwitch(SwanAppAbTestConstant.SWAN_RECORD_FCP_SWITCH, 0);
    }

    public static boolean isSystemInfoCacheSwitchOn() {
        if (sSystemInfoCacheSwitch == null) {
            sSystemInfoCacheSwitch = Boolean.valueOf(getSwitch(SwanAppAbTestConstant.SWAN_SYSTEM_INFO_CACHE_SWITCH, true));
        }
        return sSystemInfoCacheSwitch.booleanValue();
    }

    public static boolean isPreCacheSystemInfoSwitchOn() {
        return getSwitch(SwanAppAbTestConstant.SWAN_PRE_CACHE_SYSTEM_INFO_SWITCH, false);
    }

    public static boolean getSwitch(String key, boolean defaultValue) {
        Boolean booleanValue;
        if (!DEBUG || (booleanValue = SwanAppABTestManager.getInstance().getBooleanSwitch(key)) == null) {
            return AbTestManager.getInstance().getSwitch(key, defaultValue);
        }
        return booleanValue.booleanValue();
    }

    public static double getSwitch(String key, double defaultValue) {
        Double doubleValue;
        if (!DEBUG || (doubleValue = SwanAppABTestManager.getInstance().getDoubleSwitch(key)) == null) {
            return AbTestManager.getInstance().getSwitch(key, defaultValue);
        }
        return doubleValue.doubleValue();
    }

    public static int getSwitch(String key, int defaultValue) {
        Integer integerValue;
        if (!DEBUG || (integerValue = SwanAppABTestManager.getInstance().getIntSwitch(key)) == null) {
            return AbTestManager.getInstance().getSwitch(key, defaultValue);
        }
        return integerValue.intValue();
    }

    public static long getSwitch(String key, long defaultValue) {
        Long longValue;
        if (!DEBUG || (longValue = SwanAppABTestManager.getInstance().getLongSwitch(key)) == null) {
            return AbTestManager.getInstance().getSwitch(key, defaultValue);
        }
        return longValue.longValue();
    }

    public static String getSwitch(String key, String defaultValue) {
        if (DEBUG) {
            String stringValue = SwanAppABTestManager.getInstance().getStringSwitch(key);
            if (!TextUtils.isEmpty(stringValue)) {
                return stringValue;
            }
        }
        return AbTestManager.getInstance().getSwitch(key, defaultValue);
    }

    public static Object getSwitch(String key) {
        Object objectValue;
        if (!DEBUG || (objectValue = SwanAppABTestManager.getInstance().getSwitch(key)) == null) {
            return AbTestManager.getInstance().getSwitch(key);
        }
        return objectValue;
    }

    public static boolean isExtensionJsHotApplyEnable() {
        return getSwitch(SwanAppAbTestConstant.SWAN_EXTENSION_JS_HOT_APPLY_SWITCH, false);
    }

    public static boolean isInlinePlayerSameProcess() {
        int i2;
        if (sIsInlinePlayerSameProcessValue == -1) {
            if (getSwitch(SwanAppAbTestConstant.SWAN_INLINE_PLAYER_SAME_PROCESS_SWITCH, false)) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            sIsInlinePlayerSameProcessValue = i2;
        }
        if (sIsInlinePlayerSameProcessValue == 1) {
            return true;
        }
        return false;
    }

    public static int getUbcReportLogSize() {
        return getSwitch(SwanAppAbTestConstant.SWAN_UBC_REPORT_LOG_SIZE, 150);
    }
}
