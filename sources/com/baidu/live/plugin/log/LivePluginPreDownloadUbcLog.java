package com.baidu.live.plugin.log;

import android.text.TextUtils;
import com.baidu.live.plugin.prepare.PluginPreloadContext;
import com.baidu.live.plugin.prepare.PreLoadRuntime;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.searchbox.scene.inter.listener.SpecialSceneListener;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;

public class LivePluginPreDownloadUbcLog {
    public static final String SECOND_FILTER_CONFIG_HELPER_NULL = "config_helper_null";
    public static final String SECOND_FILTER_DELAY_NPS_PROCESS = "nps_process";
    public static final String SECOND_FILTER_DISABLE = "version_disable";
    public static final String SECOND_FILTER_DOWNLOAD = "download";
    public static final String SECOND_FILTER_HAVE_OLD_DOWNLOAD_INSTALL_FAIL = "old_download_install_fail";
    public static final String SECOND_FILTER_HAVE_OLD_DOWNLOAD_SWITCH_CLOSE = "old_download_switch_close";
    public static final String SECOND_FILTER_INSTALL = "install";
    public static final String SECOND_FILTER_INSTALL_DOWNLOAD = "install_download";
    public static final String SECOND_FILTER_INSTALL_NO_DOWNLOAD = "install";
    public static final String SECOND_FILTER_NOT_MEDIA_BUSINESS = "not_media_business";
    public static final String SECOND_FILTER_NO_FIRST = "no_first";
    public static final String SECOND_FILTER_NO_INSTALL_DOWNLOAD = "download";
    public static final String SECOND_FILTER_NPS_ERROR = "nps_error";
    public static final String SECOND_FILTER_PROHIBIT_BUSINESS = "prohibit_business";
    public static final String SECOND_FILTER_RUNNING = "running_version";
    public static final String SECOND_UPDATED = "second_updated";
    private static final String TYPE_DOWNLOAD_ACTION = "download_action";
    private static final String TYPE_DOWNLOAD_PROCESS = "download_process";
    private static final String TYPE_DOWNLOAD_RESULT = "download_result";
    private static final String UBC_FROM_LIVE_SHOW = "liveshow";
    private static final String UBC_ID_5161 = "5161";
    private static final String UBC_ID_5163 = "5163";
    private static final String UBC_ID_5164 = "5164";
    private static final String UBC_ID_5165 = "5165";
    private static final UBCManager UBC_MANAGER = ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE));

    public static void preDownloadSchemeOnCall(String source, boolean filter, boolean isWifi, boolean requestBusy, boolean timeFilter, long timeDuration, long timeFilterDuration) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("from", "liveshow");
            jsonObj.put("source", getSource(source));
            int i2 = 0;
            jsonObj.put("value", filter ? 0 : 1);
            JSONObject extJson = new JSONObject();
            extJson.put("net_wifi", isWifi ? 1 : 0);
            extJson.put("time_filter", timeFilter ? 1 : 0);
            extJson.put(SpecialSceneListener.SPECIAL_TIME_DURATION, timeDuration);
            if (requestBusy) {
                i2 = 1;
            }
            extJson.put("request_busy", i2);
            extJson.put("time_filter_duration", timeFilterDuration);
            jsonObj.put("ext", extJson.toString());
        } catch (JSONException e2) {
            PluginPreloadContext.INSTANCE.log(e2.getMessage());
        }
        UBC_MANAGER.onEvent(UBC_ID_5161, jsonObj.toString());
    }

    public static void preDownloadRequest(String source, boolean filter, int errno, String errMsg, boolean switchStatus, int retryCount) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("from", "liveshow");
            jsonObj.put("source", getSource(source));
            int i2 = 0;
            jsonObj.put("value", filter ? 0 : 1);
            JSONObject extJson = new JSONObject();
            extJson.put("errno", errno);
            extJson.put("err_msg", errMsg);
            if (switchStatus) {
                i2 = 1;
            }
            extJson.put("pre_download_switch", i2);
            extJson.put("retry_count", retryCount);
            jsonObj.put("ext", extJson.toString());
        } catch (JSONException e2) {
            PluginPreloadContext.INSTANCE.log(e2.getMessage());
        }
        UBC_MANAGER.onEvent(UBC_ID_5165, jsonObj.toString());
    }

    public static void preDownloadSecondPluginMatch(String source, boolean filter, String firstPkg, String secondOkg, long firstInstallVersion, long firstDownloadVersion, String filterType, long secondVersion, long secondDownload, long secondInstall, int delayNum, int secondInstallFailCode) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("from", "liveshow");
            jsonObj.put("source", getSource(source));
            jsonObj.put("value", filter ? "0" : "1");
            JSONObject extJson = new JSONObject();
            extJson.put("first_pkg", firstPkg);
            try {
                extJson.put("second_pkg", secondOkg);
                try {
                    extJson.put("first_install_version", firstInstallVersion);
                } catch (JSONException e2) {
                    e = e2;
                    long j2 = firstDownloadVersion;
                    String str = filterType;
                    long j3 = secondVersion;
                    long j4 = secondDownload;
                    long j5 = secondInstall;
                    PluginPreloadContext.INSTANCE.log(e.getMessage());
                    UBC_MANAGER.onEvent(UBC_ID_5164, jsonObj.toString());
                }
            } catch (JSONException e3) {
                e = e3;
                long j6 = firstInstallVersion;
                long j22 = firstDownloadVersion;
                String str2 = filterType;
                long j32 = secondVersion;
                long j42 = secondDownload;
                long j52 = secondInstall;
                PluginPreloadContext.INSTANCE.log(e.getMessage());
                UBC_MANAGER.onEvent(UBC_ID_5164, jsonObj.toString());
            }
            try {
                extJson.put("first_download_version", firstDownloadVersion);
                try {
                    extJson.put("filter_type", filterType);
                } catch (JSONException e4) {
                    e = e4;
                    long j322 = secondVersion;
                    long j422 = secondDownload;
                    long j522 = secondInstall;
                    PluginPreloadContext.INSTANCE.log(e.getMessage());
                    UBC_MANAGER.onEvent(UBC_ID_5164, jsonObj.toString());
                }
            } catch (JSONException e5) {
                e = e5;
                String str22 = filterType;
                long j3222 = secondVersion;
                long j4222 = secondDownload;
                long j5222 = secondInstall;
                PluginPreloadContext.INSTANCE.log(e.getMessage());
                UBC_MANAGER.onEvent(UBC_ID_5164, jsonObj.toString());
            }
            try {
                extJson.put("second_version", secondVersion);
                try {
                    extJson.put("second_download_version", secondDownload);
                } catch (JSONException e6) {
                    e = e6;
                    long j52222 = secondInstall;
                    PluginPreloadContext.INSTANCE.log(e.getMessage());
                    UBC_MANAGER.onEvent(UBC_ID_5164, jsonObj.toString());
                }
            } catch (JSONException e7) {
                e = e7;
                long j42222 = secondDownload;
                long j522222 = secondInstall;
                PluginPreloadContext.INSTANCE.log(e.getMessage());
                UBC_MANAGER.onEvent(UBC_ID_5164, jsonObj.toString());
            }
            try {
                extJson.put("second_install_version", secondInstall);
                extJson.put("second_install_fail_code", secondInstallFailCode);
                extJson.put("second_delay_num", delayNum);
                if (PreLoadRuntime.Companion.getInstance().getPreLoadHelper() != null && PreLoadRuntime.Companion.getInstance().getPreLoadHelper().isNpsRequestError()) {
                    extJson.put("nps_request_error", true);
                    extJson.put("nps_request_error_code", PreLoadRuntime.Companion.getInstance().getPreLoadHelper().getNpsRequestStateStr());
                }
                jsonObj.put("ext", extJson.toString());
            } catch (JSONException e8) {
                e = e8;
                PluginPreloadContext.INSTANCE.log(e.getMessage());
                UBC_MANAGER.onEvent(UBC_ID_5164, jsonObj.toString());
            }
        } catch (JSONException e9) {
            e = e9;
            String str3 = secondOkg;
            long j62 = firstInstallVersion;
            long j222 = firstDownloadVersion;
            String str222 = filterType;
            long j32222 = secondVersion;
            long j422222 = secondDownload;
            long j5222222 = secondInstall;
            PluginPreloadContext.INSTANCE.log(e.getMessage());
            UBC_MANAGER.onEvent(UBC_ID_5164, jsonObj.toString());
        }
        UBC_MANAGER.onEvent(UBC_ID_5164, jsonObj.toString());
    }

    public static void preDownloadNpsAction(String source, String plugPkg, long pluginVersion) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("from", "liveshow");
            jsonObj.put("source", getSource(source));
            jsonObj.put("type", TYPE_DOWNLOAD_ACTION);
            JSONObject extJson = new JSONObject();
            extJson.put("plugin_pkg", plugPkg);
            extJson.put("plugin_version", pluginVersion);
            jsonObj.put("ext", extJson.toString());
        } catch (JSONException e2) {
            PluginPreloadContext.INSTANCE.log(e2.getMessage());
        }
        UBC_MANAGER.onEvent(UBC_ID_5163, jsonObj.toString());
    }

    public static void preDownloadNpsProcess(String source, String plugPkg, long pluginVersion, long processDuration) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("from", "liveshow");
            jsonObj.put("source", getSource(source));
            jsonObj.put("type", TYPE_DOWNLOAD_PROCESS);
            JSONObject extJson = new JSONObject();
            extJson.put("plugin_pkg", plugPkg);
            extJson.put("plugin_version", pluginVersion);
            extJson.put("process_duration", processDuration);
            jsonObj.put("ext", extJson.toString());
        } catch (JSONException e2) {
            PluginPreloadContext.INSTANCE.log(e2.getMessage());
        }
        UBC_MANAGER.onEvent(UBC_ID_5163, jsonObj.toString());
    }

    public static void preDownloadNpsResult(String source, String plugPkg, long pluginVersion, boolean filter, int retryCount, int resultCode, String resultMsg, boolean isWifi, int retryNum, int preFailCode) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("from", "liveshow");
            jsonObj.put("source", getSource(source));
            jsonObj.put("value", filter ? "0" : "1");
            jsonObj.put("type", TYPE_DOWNLOAD_RESULT);
            JSONObject extJson = new JSONObject();
            extJson.put("plugin_pkg", plugPkg);
            extJson.put("plugin_version", pluginVersion);
            extJson.put("result_retry_count", retryCount);
            extJson.put("result_code", resultCode);
            extJson.put(AbstractThirdPartyService.EXTRA_RESULT_MSG, resultMsg);
            extJson.put("net_wifi", isWifi ? 1 : 0);
            extJson.put("retry_num", retryNum);
            extJson.put("pre_fail_code", preFailCode);
            jsonObj.put("ext", extJson.toString());
        } catch (JSONException e2) {
            PluginPreloadContext.INSTANCE.log(e2.getMessage());
        }
        UBC_MANAGER.onEvent(UBC_ID_5163, jsonObj.toString());
    }

    public static String getSource(String source) {
        if (TextUtils.isEmpty(source)) {
            return "plugin_prepare";
        }
        return source;
    }
}
