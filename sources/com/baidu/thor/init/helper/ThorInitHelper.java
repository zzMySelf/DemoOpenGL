package com.baidu.thor.init.helper;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.logsystem.exceptionhandler.api.ExceptionHandler;
import com.baidu.thor.base.ThorConfig;
import com.baidu.thor.base.ThorKV;
import com.baidu.thor.base.ThorSafeMode;
import com.baidu.thor.base.cloud.control.ThorCloudControl;
import com.baidu.thor.common.ThorUtils;
import com.baidu.thor.sdk.manager.Configurations;
import com.baidu.thor.sdk.manager.ThorManager;
import com.baidu.thor.sdk.manager.ioc.IReporterManager;
import com.baidu.thor.sdk.manager.ioc.IThorConfig;
import com.baidu.thor.sdk.manager.ioc.Issue;
import com.baidu.thor.sdk.manager.ioc.PluginFuncInfo;
import com.baidu.thor.sdk.manager.ioc.impl.ThorConfigManager;
import com.baidu.thor.sdk.plugin.PluginManagerService;
import com.baidu.titan.sdk.pm.TitanPaths;
import java.util.HashMap;
import java.util.Map;

public class ThorInitHelper {
    private static final IReporterManager EMPTY = new IReporterManager() {
        public void onReportIssue(Issue issue) {
            Log.e(ThorInitHelper.TAG, "onReportIssue: " + issue);
        }
    };
    private static final String TAG = "ThorInitHelper";

    public static void init(Context context, boolean isDebug, boolean isBuiltIn) {
        HashMap<String, PluginFuncInfo> infos;
        HashMap<String, PluginFuncInfo> infos2;
        if (context != null && !isNotMonitorProcess()) {
            Log.i(TAG, "Thor init start...");
            if (!isDebug) {
                if (!ThorKV.getInstance().getBoolean(ThorKV.Constants.THOR_MAIN_ENABLE, false)) {
                    Log.i(TAG, "Thor isDisabled.");
                    return;
                }
                long crashTimeStamp = ThorKV.getInstance().getLong(ThorKV.Constants.CRASH_OVER_THRESHOLD_TIMESTAMP, -1);
                if (crashTimeStamp != -1 && Math.abs(System.currentTimeMillis() - crashTimeStamp) <= 604800000) {
                    Log.i(TAG, "The crash time does not exceed the threshold. Thor don't init.");
                    return;
                } else if (ThorSafeMode.getInstance().getCrashCount() >= 2) {
                    ThorKV.getInstance().putLong(ThorKV.Constants.CRASH_OVER_THRESHOLD_TIMESTAMP, System.currentTimeMillis());
                    Log.i(TAG, "The crash count exceeds the threshold.Thor don't init.");
                    return;
                }
            }
            ThorManager.getInstance().init(new Configurations.Builder().setContext(context).setDebug(isDebug).setThorConfigManager(ThorConfig.getThorConfigManager()).setReporterManager(getThorReporterManager()).build());
            if (isThorProcess()) {
                if (isDebug) {
                    Log.i(TAG, "Thor sandbox don't need load plugin.");
                }
            } else if (isBuiltIn) {
                if (isDebug) {
                    try {
                        Log.i(TAG, "Start load built-in plugin.");
                    } catch (Throwable e2) {
                        Log.e(TAG, "load built-in plugin error.", e2);
                        return;
                    }
                }
                PluginManagerService.getInstance().loadBuiltInPlugins();
                IThorConfig builtInConfig = ThorConfigManager.getInstance().getBuiltInConfig(ThorConfig.THOR_BUILT_IN_PLUGIN_FUNC_CONFIG_ASSETS_PATH);
                if (builtInConfig != null && builtInConfig.getEnable() && (infos2 = builtInConfig.getPluginFuncInfos()) != null && !infos2.isEmpty()) {
                    PluginManagerService.getInstance().onPluginFuncControl(infos2.values());
                }
            } else {
                try {
                    PluginManagerService.getInstance().loadPlugins();
                    IThorConfig config = ThorConfigManager.getInstance().getConfig(3);
                    if (config != null && config.getEnable() && (infos = config.getPluginFuncInfos()) != null && !infos.isEmpty()) {
                        PluginManagerService.getInstance().onPluginFuncControl(infos.values());
                    }
                } catch (Throwable e3) {
                    Log.e(TAG, "load plugin error.", e3);
                    ExceptionHandler handler = (ExceptionHandler) ServiceManager.getService(ExceptionHandler.SERVICE_REFERENCE);
                    if (handler != null) {
                        handler.onException(new Exception(e3), "perf", "thor_load_plugin", (Map<String, String>) null);
                    }
                }
                if (isMainProcess()) {
                    ThorCloudControl.getInstance().registerDynamicCommandListener();
                }
            }
        }
    }

    private static boolean isNotMonitorProcess() {
        String processName = ThorUtils.getProcessName();
        if (TextUtils.isEmpty(processName)) {
            return false;
        }
        if (processName.contains(":loki") || processName.contains(TitanPaths.TITAN_SANDBOX_PROCESS_NAME_SUFFIX) || processName.contains(":safemode")) {
            return true;
        }
        return false;
    }

    private static boolean isMainProcess() {
        String processName = ThorUtils.getProcessName();
        if (TextUtils.isEmpty(processName)) {
            return false;
        }
        return !processName.contains(":");
    }

    private static boolean isThorProcess() {
        String processName = ThorUtils.getProcessName();
        if (TextUtils.isEmpty(processName)) {
            return false;
        }
        return processName.contains(":thor");
    }

    public static IReporterManager getThorReporterManager() {
        return EMPTY;
    }
}
