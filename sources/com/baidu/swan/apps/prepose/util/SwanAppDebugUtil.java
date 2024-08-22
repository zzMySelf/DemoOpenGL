package com.baidu.swan.apps.prepose.util;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.console.debugger.UserDebugParams;
import com.baidu.swan.apps.console.debugger.adbdebug.ADBDebugBundleHelper;
import com.baidu.swan.apps.console.debugger.localdebug.LocalDebugBundleHelper;
import com.baidu.swan.apps.console.debugger.remotedebug.RemoteDebugger;
import com.baidu.swan.apps.console.debugger.wirelessdebug.WirelessDebugBundleHelper;
import com.baidu.swan.apps.core.fragment.SwanAppBaseFragment;
import com.baidu.swan.apps.embed.page.ISwanPageManager;
import com.baidu.swan.apps.extcore.debug.DebugDataHelper;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.install.SwanAppBundleHelper;
import com.baidu.swan.apps.launch.model.SwanAppLaunchInfo;
import com.baidu.swan.apps.launch.model.SwanAppLaunchParams;
import com.baidu.swan.apps.lifecycle.SwanAppController;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.storage.sp.IpcReadOnlySP;
import com.baidu.swan.apps.swancore.SwanAppSwanCoreManager;
import com.baidu.swan.apps.util.data.ErrorCodePicker;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.HashSet;
import java.util.Set;

public final class SwanAppDebugUtil {
    private static final String BDTLS_DISABLE_KEY = "bdtls_disable_key";
    public static final String CAN_NAVIGATE_TO_DEV_APP_KEY = "aiapps_can_navigate_to_dev_app";
    public static final String CLOSE_VIEW_DISABLED_DEBUG_KEY = "aiapps_close_view_disable_debug_key";
    public static final String DASHBOARD_ENABLED_DEBUG_KEY = "aiapps_dashboard_enable_debug_key";
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    public static final String EMIT_GAME_CORE_DEBUG_KEY = "aiapps_emit_game_core_debug_key";
    public static final String EMIT_GAME_LAUNCH_MODE_KEY = "aiapps_emit_game_launch_mode_key";
    public static final String EMIT_HTTPS_DEBUG_KEY = "aiapps_emit_https_debug_key";
    public static final String EMIT_LIVE_DEBUG_KEY = "aiapps_emit_live_debug_key";
    public static final String EMIT_WSS_DEBUG_KEY = "aiapps_emit_wss_debug_key";
    private static final String ENV_DATA = "aiapps_env_data";
    public static final String ERR_PAGE_FEEDBACK_DEBUG_KEY = "aiapps_errpage_feedback_debug_key";
    private static final String FORCE_AUTHORIZED_KEY = "aiapps_force_authorized_key";
    private static final String HTTP_CACHE_KEY = "http_cache_key";
    private static final Set<String> IPC_ALLOWED_KEY_SET;
    private static final String JS_NATIVE_SWITCH__KEY = "aiapps_js_native_switch_key";
    private static final String KEY_SWAN_APP_DEBUG_INSPECT = "KEY_SWAN_APP_DEBUG_INSPECT";
    public static final String LOAD_CTS_DEBUG_KEY = "aiapps_load_cts_debug_key";
    private static final String PAYMENT_DISABLE_KEY = "payment_disable_key";
    private static final String PAY_CHANNEL_KEY = "aiapps_pay_channel_key";
    private static final String PMS_HOST_ENV = "aiapps_pms_host_env";
    public static final String PREFS_NAME = "swan_app_debug";
    public static final String SCONSOLE_SCAN_MODE_DEBUG_KEY = "aiapps_sconsole_scan_mode_debug_key";
    public static final String SERVER_DOMAINS_DEBUG_KEY = "aiapps_server_domains_debug_key";
    public static final String STARTUP_REPORTER = "aiapps_startup_reporter";
    public static final String STARTUP_REPORTER_LOCAL_REPORT = "aiapps_startup_reporter_local_report";
    public static final String STARTUP_REPORTER_RESOLUTION = "aiapps_startup_reporter_resolution";
    public static final String SUPER_WEBVIEW_KEY = "aiapps_super_webview_key";
    private static final String SWAN_DEBUG_DELAY_PREPARE_RUNTIME = "swan_debug_delay_prepare_runtime";
    public static final long SWAN_DEBUG_EXTENSION_CORE_CODE = 4294967297L;
    private static final String SWAN_DEBUG_EXTENSION_CORE_NAME = "1.0.1";
    private static final String SWAN_DEBUG_FORBID_SAMPLE = "swan_debug_forbid_sample";
    private static final String SWAN_DEBUG_FORCE_AB = "swan_debug_force_ab";
    public static final String SWAN_DEBUG_FORCE_AGENT_KEY = "swan_debug_force_lingjing_agent";
    private static final String SWAN_DEBUG_FORCE_OUTPUT_670 = "swan_debug_force_output_670";
    public static final String SWAN_DEBUG_SHOW_TTS_BUTTON_KEY = "swan_debug_show_tts_button";
    public static final int SWAN_DEBUG_SO_TYPE_CLOSE = 0;
    public static final int SWAN_DEBUG_SO_TYPE_DEFAULT = -1;
    public static final String SWAN_DEBUG_SO_TYPE_KEY = "swan_debug_open_so_key";
    public static final int SWAN_DEBUG_SO_TYPE_OPEN = 1;
    public static final String SWAN_DEBUG_SO_URL_KEY = "swan_debug_so_url_key";
    public static final String SWAN_GAME_FPS_DEBUG_KEY = "swan_game_fps_debug_key";
    public static final String SWAN_PREFS_NAME = "swan_debug_feature";
    public static final String USE_EXTENSION_DEBUG_KEY = "aiapps_use_extension_debug_key";
    public static final String USE_GAME_EXTENSION_DEBUG_KEY = "aiapps_use_game_extension_debug_key";
    public static final String WEB_MODE_CTS_USE_KEY = "aiapps_web_mode_cts_use_key";
    public static final String WEB_SAFE_DEBUG_KEY = "aiapps_websafe_debug_key";
    public static final String WEB_SAFE_TEST_KEY = "aiapps_websafe_test_key";
    private static IpcReadOnlySP sPrefs;

    static {
        HashSet hashSet = new HashSet();
        IPC_ALLOWED_KEY_SET = hashSet;
        hashSet.add(WEB_SAFE_DEBUG_KEY);
        hashSet.add(SERVER_DOMAINS_DEBUG_KEY);
        hashSet.add(USE_EXTENSION_DEBUG_KEY);
        hashSet.add(EMIT_LIVE_DEBUG_KEY);
        hashSet.add(EMIT_HTTPS_DEBUG_KEY);
        hashSet.add(EMIT_WSS_DEBUG_KEY);
        hashSet.add(LOAD_CTS_DEBUG_KEY);
        hashSet.add(ENV_DATA);
        hashSet.add(JS_NATIVE_SWITCH__KEY);
        hashSet.add(EMIT_GAME_CORE_DEBUG_KEY);
        hashSet.add(EMIT_GAME_LAUNCH_MODE_KEY);
        hashSet.add(HTTP_CACHE_KEY);
    }

    public static IpcReadOnlySP getPrefs() {
        if (sPrefs == null) {
            synchronized (SwanAppDebugUtil.class) {
                if (sPrefs == null) {
                    IpcReadOnlySP ipcReadOnlySP = new IpcReadOnlySP(PREFS_NAME);
                    sPrefs = ipcReadOnlySP;
                    ipcReadOnlySP.mIpcAllowedKeySet.addAll(IPC_ALLOWED_KEY_SET);
                }
            }
        }
        return sPrefs;
    }

    public static void setForceAbForTest(boolean flag) {
        getPrefs().putBoolean(SWAN_DEBUG_FORCE_AB, flag);
    }

    public static boolean shouldForceAbForTest() {
        return getPrefs().getBoolean(SWAN_DEBUG_FORCE_AB, false);
    }

    public static void setForbidSample(boolean flag) {
        getPrefs().putBoolean(SWAN_DEBUG_FORBID_SAMPLE, flag);
    }

    public static boolean shouldForbidSample() {
        return getPrefs().getBoolean(SWAN_DEBUG_FORBID_SAMPLE, true);
    }

    public static void setDelayPrepareRuntimeSwitch(boolean flag) {
        getPrefs().putBoolean(SWAN_DEBUG_DELAY_PREPARE_RUNTIME, flag);
    }

    public static boolean getDelayPrepareRuntimeSwitch() {
        return getPrefs().getBoolean(SWAN_DEBUG_DELAY_PREPARE_RUNTIME, false);
    }

    public static void set670DataSwitch(boolean flag) {
        getPrefs().putBoolean(SWAN_DEBUG_FORCE_OUTPUT_670, flag);
    }

    public static boolean get670DataSwitch() {
        return getPrefs().getBoolean(SWAN_DEBUG_FORCE_OUTPUT_670, false);
    }

    public static boolean getWebSafeDebug() {
        return getBoolean(WEB_SAFE_DEBUG_KEY, true);
    }

    public static boolean getServerDomainsDebug() {
        return getBoolean(SERVER_DOMAINS_DEBUG_KEY, true);
    }

    public static void setWebSafeDebug(boolean useDebug) {
        setBoolean(WEB_SAFE_DEBUG_KEY, useDebug);
    }

    public static void setServerDomainsDebug(boolean useDebug) {
        setBoolean(SERVER_DOMAINS_DEBUG_KEY, useDebug);
    }

    public static boolean getWebSafeTestDebug() {
        return getBoolean(WEB_SAFE_TEST_KEY, false);
    }

    public static void setWebSafeTestDebug(boolean useTest) {
        setBoolean(WEB_SAFE_TEST_KEY, useTest);
    }

    public static boolean getSuperWebview() {
        return getBoolean(SUPER_WEBVIEW_KEY, false);
    }

    public static void setSuperWebview(boolean enable) {
        setBoolean(SUPER_WEBVIEW_KEY, enable);
    }

    public static boolean getCanNavigateToDevApp() {
        return getBoolean(CAN_NAVIGATE_TO_DEV_APP_KEY, false);
    }

    public static void setCanNavigateToDevApp(boolean enable) {
        setBoolean(CAN_NAVIGATE_TO_DEV_APP_KEY, enable);
    }

    public static boolean getErrPageFeedbackDebug() {
        return getBoolean(ERR_PAGE_FEEDBACK_DEBUG_KEY, false);
    }

    public static void setErrPageFeedbackDebug(boolean enabled) {
        setBoolean(ERR_PAGE_FEEDBACK_DEBUG_KEY, enabled);
    }

    public static boolean getCloseViewDisabledDebug() {
        return getBoolean(CLOSE_VIEW_DISABLED_DEBUG_KEY, false);
    }

    public static void setCloseViewDisabledDebug(boolean disabled) {
        setBoolean(CLOSE_VIEW_DISABLED_DEBUG_KEY, disabled);
    }

    public static boolean getDashboardEnabledDebug() {
        return getBoolean(DASHBOARD_ENABLED_DEBUG_KEY, false);
    }

    public static void setDashboardEnabledDebug(boolean enabled) {
        setBoolean(DASHBOARD_ENABLED_DEBUG_KEY, enabled);
    }

    public static boolean getFpsDisabledDebug() {
        return getBoolean(SWAN_GAME_FPS_DEBUG_KEY, false);
    }

    public static void setFpsDisabledDebug(boolean disabled) {
        setBoolean(SWAN_GAME_FPS_DEBUG_KEY, disabled);
    }

    public static boolean getSconsoleScanModeDebug() {
        return getBoolean(SCONSOLE_SCAN_MODE_DEBUG_KEY, false);
    }

    public static void setSconsoleScanModeDebug(boolean enabled) {
        setBoolean(SCONSOLE_SCAN_MODE_DEBUG_KEY, enabled);
    }

    public static boolean getUseDebugExtension() {
        return getBoolean(USE_EXTENSION_DEBUG_KEY, false);
    }

    public static void setUseDebugExtension(boolean use) {
        setBoolean(USE_EXTENSION_DEBUG_KEY, use);
    }

    public static boolean getUseGameDebugExtension() {
        return getBoolean(USE_GAME_EXTENSION_DEBUG_KEY, false);
    }

    public static void setUseGameDebugExtension(boolean use) {
        setBoolean(USE_GAME_EXTENSION_DEBUG_KEY, use);
    }

    public static boolean getLivePlayerPermissionCheck() {
        return getBoolean(EMIT_LIVE_DEBUG_KEY, false);
    }

    public static void setLivePlayerPermissionCheck(boolean disabled) {
        setBoolean(EMIT_LIVE_DEBUG_KEY, disabled);
    }

    public static boolean getHttpsPermissionCheck() {
        return getBoolean(EMIT_HTTPS_DEBUG_KEY, false);
    }

    public static void setHttpsPermissionCheck(boolean disabled) {
        setBoolean(EMIT_HTTPS_DEBUG_KEY, disabled);
    }

    public static boolean getDebugSwanAppSwanCoreModeStatus() {
        return SwanAppSwanCoreManager.isDebugSwanAppSwanCoreMode();
    }

    public static void setDebugSwanAppSwanCoreModeStatus(boolean isDebugSwanCore) {
        SwanAppSwanCoreManager.setDebugSwanAppSwanCoreMode(isDebugSwanCore);
    }

    public static boolean getDebugGameCoreModeStatus() {
        return getBoolean(EMIT_GAME_CORE_DEBUG_KEY, false);
    }

    public static void setDebugGameCoreModeStatus(boolean isDebugGameCore) {
        setBoolean(EMIT_GAME_CORE_DEBUG_KEY, isDebugGameCore);
    }

    public static boolean getSwanGameDebugLaunchMode() {
        return getBoolean(EMIT_GAME_LAUNCH_MODE_KEY, false);
    }

    public static void setSwanGameDebugLaunchMode(boolean isDebugLaunchMode) {
        setBoolean(EMIT_GAME_LAUNCH_MODE_KEY, isDebugLaunchMode);
    }

    public static boolean getJumpWssPermissionCheck() {
        return getBoolean(EMIT_WSS_DEBUG_KEY, false);
    }

    public static void setJumpWssPermissionCheck(boolean disabled) {
        setBoolean(EMIT_WSS_DEBUG_KEY, disabled);
    }

    public static void setLoadCts(boolean enabled) {
        setBoolean(LOAD_CTS_DEBUG_KEY, enabled);
    }

    public static boolean getLoadCts() {
        return getBoolean(LOAD_CTS_DEBUG_KEY, false);
    }

    public static void setDebugEnvData(String envData) {
        getPrefs().putString(ENV_DATA, envData);
    }

    public static String getDebugEnvData() {
        return getPrefs().getString(ENV_DATA, "");
    }

    public static void setPmsHostEnv(int pmsHostEnv) {
        getPrefs().putInt(PMS_HOST_ENV, pmsHostEnv);
    }

    public static int getPmsHostEnv() {
        return getPrefs().getInt(PMS_HOST_ENV, 0);
    }

    public static void setBoolean(String key, boolean value) {
        getPrefs().putBoolean(key, value);
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        return getPrefs().getBoolean(key, defaultValue);
    }

    public static void setDebugSoType(int debugSoType) {
        getPrefs().putInt(SWAN_DEBUG_SO_TYPE_KEY, debugSoType);
    }

    public static int getDebugSoType() {
        return getPrefs().getInt(SWAN_DEBUG_SO_TYPE_KEY, -1);
    }

    public static void setDebugSoDownloadParams(String downloadParams) {
        getPrefs().putString(SWAN_DEBUG_SO_URL_KEY, downloadParams);
    }

    public static String getDebugSoDownloadParams() {
        return getPrefs().getString(SWAN_DEBUG_SO_URL_KEY, "");
    }

    private static boolean isDebug(SwanAppLaunchParams params) {
        return (DEBUG && params.isDebug()) || isRemoteDebug(params.getRemoteDebug()) || UserDebugParams.isADBDebug() || UserDebugParams.isWirelessDebug() || params.isLocalDebug() || (getSwanGameDebugLaunchMode() && params.getIsCtsLaunchMode());
    }

    public static boolean isDebug(SwanAppLaunchInfo info) {
        return (DEBUG && info.isDebug()) || isRemoteDebug(info.getRemoteDebug()) || UserDebugParams.isADBDebug() || UserDebugParams.isWirelessDebug() || info.isLocalDebug() || (getSwanGameDebugLaunchMode() && info.getIsCtsLaunchMode());
    }

    public static boolean isDebug(Bundle info) {
        if ((!DEBUG || !info.getBoolean("mIsDebug", false)) && !isRemoteDebug(info.getString("remoteDebugUrl"))) {
            return false;
        }
        return true;
    }

    public static boolean isUserDebug() {
        return UserDebugParams.isADBDebug() || UserDebugParams.isWirelessDebug();
    }

    public static boolean isRemoteDebug(String remoteDebug) {
        return !TextUtils.isEmpty(remoteDebug) || RemoteDebugger.isRemoteDebug();
    }

    public static boolean isLocalDebug() {
        SwanApp swanApp = SwanApp.getOrNull();
        if (swanApp != null) {
            return swanApp.getInfo().isLocalDebug();
        }
        return false;
    }

    public static boolean getForceAuthorizedDebug() {
        return getBoolean(FORCE_AUTHORIZED_KEY, false);
    }

    public static void setForceAuthorizedDebug(boolean forceAuthorized) {
        setBoolean(FORCE_AUTHORIZED_KEY, forceAuthorized);
    }

    public static boolean getBdtlsDisableDebug() {
        return getBoolean(BDTLS_DISABLE_KEY, false);
    }

    public static void setBdtlsDisableDebug(boolean disableBdtls) {
        setBoolean(BDTLS_DISABLE_KEY, disableBdtls);
    }

    public static boolean getJsNativeDebug() {
        return getBoolean(JS_NATIVE_SWITCH__KEY, true);
    }

    public static void setJsNativeDebug(boolean jsNativeDebug) {
        setBoolean(JS_NATIVE_SWITCH__KEY, jsNativeDebug);
    }

    public static boolean getPaymentDebug() {
        return getBoolean(PAY_CHANNEL_KEY, false);
    }

    public static void setPaymentDebug(boolean forceAuthorized) {
        setBoolean(PAY_CHANNEL_KEY, forceAuthorized);
    }

    public static SwanAppBundleHelper.SwanAppLoadInfo debugForLoadAndRunSwanApp(SwanAppLaunchInfo launchInfo, ErrorCodePicker errPicker) {
        if (DEBUG && launchInfo.isDebug()) {
            return SwanAppBundleHelper.DebugBundleHelper.debugForLoadAndRunSwanApp(launchInfo, errPicker);
        }
        if (isRemoteDebug(launchInfo.getRemoteDebug())) {
            return SwanAppBundleHelper.RemoteDebugBundleHelper.debugForLoadAndRunSwanApp(launchInfo);
        }
        if (UserDebugParams.isADBDebug()) {
            return ADBDebugBundleHelper.debugForLoadAndRunSwanApp(launchInfo);
        }
        if (UserDebugParams.isWirelessDebug()) {
            return WirelessDebugBundleHelper.debugForLoadAndRunSwanApp(launchInfo);
        }
        if (launchInfo.isLocalDebug()) {
            return LocalDebugBundleHelper.debugForLoadAndRunSwanApp(launchInfo);
        }
        return null;
    }

    public static Bundle launchSwanAppIfDebug(SwanAppLaunchParams params) {
        if (!isDebug(params)) {
            return null;
        }
        SwanAppLaunchInfo info = buildMockObject();
        info.setAppId(params.getAppId());
        info.setLaunchFrom(params.getLaunchFrom());
        info.setPage(params.getPage());
        info.setDebug(params.isDebug());
        info.setLocalDebug(params.isLocalDebug());
        info.setClickId(params.getClickId());
        info.setExtraData(params.requireExtraData());
        info.setLaunchScheme(params.getLaunchScheme());
        info.setNotInHistory(params.getNotInHistory());
        info.setSwanCoreVersion(params.getSwanCoreVersion());
        info.setExtensionCore(params.getExtensionCore());
        info.setTargetSwanVersion(params.getTargetSwanVersion());
        info.setRemoteDebug(params.getRemoteDebug());
        info.setVersion("0");
        info.setAppFrameType(params.getAppFrameType());
        info.setOrientation(params.getOrientation());
        if (isRemoteDebug(params.getRemoteDebug()) || isUserDebug() || params.isLocalDebug()) {
            info.setAppKey(params.getAppId());
        }
        return info.toBundle();
    }

    public static String getDebugUnzipOutputFolder(SwanAppLaunchInfo info) {
        if (DEBUG && info.isDebug()) {
            return SwanAppBundleHelper.DebugBundleHelper.getDebugUnzipOutputFolder().getPath();
        }
        if (isRemoteDebug(info.getRemoteDebug())) {
            return SwanAppBundleHelper.RemoteDebugBundleHelper.getDebugUnzipFolder().getPath();
        }
        if (UserDebugParams.isADBDebug()) {
            return ADBDebugBundleHelper.getDebugUnzipFolder().getPath();
        }
        if (UserDebugParams.isWirelessDebug()) {
            return WirelessDebugBundleHelper.getDebugUnzipFolder().getPath();
        }
        if (info.isLocalDebug()) {
            return LocalDebugBundleHelper.getDebugUnzipFolder().getPath();
        }
        return "";
    }

    public static void updateCtsView() {
        SwanAppBaseFragment swanAppFragment;
        ISwanPageManager manager = SwanAppController.getInstance().getSwanPageManager();
        if (manager != null && (swanAppFragment = manager.getTopFragment()) != null) {
            swanAppFragment.updateCtsView();
        }
    }

    public static boolean isOpenCtsModel() {
        return getLoadCts() || getLivePlayerPermissionCheck() || getHttpsPermissionCheck() || getUseDebugExtension() || !getWebSafeDebug() || getDebugSwanAppSwanCoreModeStatus() || getDebugGameCoreModeStatus() || getJumpWssPermissionCheck() || getSwanGameDebugLaunchMode() || DebugDataHelper.intToBoolean(getPmsHostEnv());
    }

    public static SwanAppLaunchInfo.Impl buildMockObject() {
        return (SwanAppLaunchInfo.Impl) ((SwanAppLaunchInfo.Impl) ((SwanAppLaunchInfo.Impl) ((SwanAppLaunchInfo.Impl) ((SwanAppLaunchInfo.Impl) ((SwanAppLaunchInfo.Impl) ((SwanAppLaunchInfo.Impl) ((SwanAppLaunchInfo.Impl) ((SwanAppLaunchInfo.Impl) ((SwanAppLaunchInfo.Impl) ((SwanAppLaunchInfo.Impl) new SwanAppLaunchInfo.Impl().setPmsAppInfo(new PMSAppInfo())).setAppTitle("小程序测试")).setAppId("10985873")).setNavigateBarColor((long) Color.parseColor("#FF308EF0"))).setLaunchFrom("1230000000000000")).setAppDescription("小程序简介")).setServiceCategory("测试服务类目")).setSubjectInfo("测试主体信息")).setAppKey("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N")).setVersion("1.0")).setIconUrl("https://b.bdstatic.com/searchbox/mappconsole/image/20180502/1525250801121271.png");
    }

    public static ExtensionCore buildMockExtensionCore(ExtensionCore extensionCore) {
        if (extensionCore == null) {
            return null;
        }
        extensionCore.extensionCoreVersionCode = SWAN_DEBUG_EXTENSION_CORE_CODE;
        extensionCore.extensionCoreVersionName = SWAN_DEBUG_EXTENSION_CORE_NAME;
        return extensionCore;
    }

    public static void setSwanAppDebugInspect(boolean isDebugInspect) {
        setBoolean(KEY_SWAN_APP_DEBUG_INSPECT, isDebugInspect);
    }

    public static boolean isSwanAppDebugInspect() {
        return getBoolean(KEY_SWAN_APP_DEBUG_INSPECT, false);
    }

    public static void setSwanAppDebugPayment(boolean isDebugPayment) {
        setBoolean(PAYMENT_DISABLE_KEY, isDebugPayment);
    }

    public static Boolean isSwanAppDebugPayment() {
        return Boolean.valueOf(getBoolean(PAYMENT_DISABLE_KEY, false));
    }

    public static void setSwanForceLingjingAgent(boolean isAgent) {
        setBoolean(SWAN_DEBUG_FORCE_AGENT_KEY, isAgent);
    }

    public static Boolean isSwanForceLingjingAgent() {
        return Boolean.valueOf(getBoolean(SWAN_DEBUG_FORCE_AGENT_KEY, false));
    }

    public static void setSwanShowTtsFloatButton(boolean isShow) {
        setBoolean(SWAN_DEBUG_SHOW_TTS_BUTTON_KEY, isShow);
    }

    public static Boolean isSwanShowTtsFloatButton() {
        return Boolean.valueOf(getBoolean(SWAN_DEBUG_SHOW_TTS_BUTTON_KEY, false));
    }
}
