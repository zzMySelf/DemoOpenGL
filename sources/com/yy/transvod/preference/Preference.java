package com.yy.transvod.preference;

import android.content.Context;
import com.yy.transvod.net.NetRequestClientFactory;
import com.yy.transvod.player.OnPlayerStatisticsParams;
import com.yy.transvod.player.log.TLog;
import com.yy.transvod.player.statistics.PlayStatistics;
import com.yy.transvod.preference.subprocess.OnSubProcessPlayerStatistics;
import com.yy.transvod.preference.subprocess.PreferenceSubProcess;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Preference {
    private static boolean mEnableDevEnv = false;
    private static boolean mEnableGlobalProcessConfig = false;
    private static boolean mEnableGlobalSubprocess = false;
    private static OnDnsHostResolveCallback mHostResolveCallback = null;
    private static OnLogCallback mLogCallback = null;
    private static OnPlayerStatistics mStatisticsCallback = null;
    private static OnPlayerStatisticsParams mStatisticsParamsCallback = null;
    private static OnSubProcessPlayerStatistics mSubProcessPlayerStatisticsCallback = null;
    private static OnSubprocessStatistics mSubprocessStatisticsCallback = null;
    private static AtomicInteger mTaskID = new AtomicInteger(new Random().nextInt(10000) + 1);

    public static native NetRequestClientFactory findNetClientFactory(int i2);

    public static native void nativeSetDevEnv(boolean z);

    public static native void nativeSetMediaConfig(HashMap<String, String> hashMap);

    public static native void registerNetClientFactory(int i2, NetRequestClientFactory netRequestClientFactory);

    public static int getTaskId() {
        return mTaskID.getAndAdd(1);
    }

    public static void initSubProcess(Context ctx, OnSubprocessReadyListener listener) {
        PreferenceSubProcess.getInstance().initSubProcess(ctx, listener, (HashMap<String, String>) null);
    }

    public static void initSubProcess(Context ctx, OnSubprocessReadyListener listener, HashMap<String, String> param) {
        PreferenceSubProcess.getInstance().initSubProcess(ctx, listener, param);
    }

    public static void addCrashListener(OnSubprocessCrashListener listener) {
        TLog.info("perference", "add crash listener");
        PreferenceSubProcess.getInstance().addCrashListener(listener, false);
    }

    public static void removeCrashListener(OnSubprocessCrashListener listener) {
        PreferenceSubProcess.getInstance().removeCrashListener(listener, false);
    }

    public static void setGlobalProcessConfig(boolean enableGlobalConfig, boolean enableGlobalSubprocess) {
        TLog.info("Preference", "setGlobalProcessConfig, enableGlobalConfig:" + enableGlobalConfig + ",enableGlobalSubprocess:" + enableGlobalSubprocess);
        mEnableGlobalProcessConfig = enableGlobalConfig;
        mEnableGlobalSubprocess = enableGlobalSubprocess;
    }

    public static boolean isSubProcessFailOver2MainProcess() {
        return PreferenceSubProcess.mFailOverToMainProcess.get();
    }

    public static void testSubprocessCrash() {
        PreferenceSubProcess.getInstance().testSubprocessCrash();
    }

    public static boolean isEnableGlobalProcessConfig() {
        return mEnableGlobalProcessConfig;
    }

    public static boolean isEnableGlobalSubprocess() {
        return mEnableGlobalSubprocess;
    }

    public static boolean isSubProcessConnected() {
        return PreferenceSubProcess.getInstance().isSubProcessConnected();
    }

    public static void setStatisticsCallback(OnPlayerStatistics statisticsCallback) {
        mStatisticsCallback = statisticsCallback;
        PlayStatistics.registerStatisticsListener(statisticsCallback);
    }

    public static void setSubProcessPlayerStatistics(OnSubProcessPlayerStatistics statisticsCallback) {
        mSubProcessPlayerStatisticsCallback = statisticsCallback;
        PlayStatistics.registerSubProcessStatisticsListener(statisticsCallback);
    }

    public static void setStatisticsParamsCallback(OnPlayerStatisticsParams statisticsCallback) {
        mStatisticsParamsCallback = statisticsCallback;
        PlayStatistics.registerStatisticsParamsListener(statisticsCallback);
    }

    public static OnPlayerStatistics getStatisticsCallback() {
        return mStatisticsCallback;
    }

    public static OnPlayerStatisticsParams getStatisticsParamsCallback() {
        return mStatisticsParamsCallback;
    }

    public static void setSubprocessStatisticsCallback(OnSubprocessStatistics statisticsCallback) {
        mSubprocessStatisticsCallback = statisticsCallback;
    }

    public static OnSubprocessStatistics getSubProcessStatisticsCallback() {
        return mSubprocessStatisticsCallback;
    }

    public static void setLogLevel(int level) {
        if (level >= 2 && level <= 6) {
            TLog.setLevel(level);
        }
    }

    public static int getLogLevel() {
        return TLog.getLevel();
    }

    public static void setLogCallback(OnLogCallback logCallback) {
        mLogCallback = logCallback;
        TLog.registerLogger(logCallback);
        TLog.info("listener", "set log callback " + logCallback.toString());
    }

    public static OnLogCallback getLogCallback() {
        return mLogCallback;
    }

    public static void setDnsHostResolveCallback(OnDnsHostResolveCallback callback) {
        mHostResolveCallback = callback;
    }

    public static OnDnsHostResolveCallback getDnsHostResolveCallback() {
        return mHostResolveCallback;
    }

    public static void setMediaConfig(HashMap<String, String> configs) {
        if (configs == null) {
            TLog.error("[vod-java]", "setMediaConfig fail, configs is null");
        }
        TLog.info("perference", "set media config");
        PreferenceSubProcess.getInstance().setMediaConfig(configs);
        StringBuilder sb = new StringBuilder("mediaConfig:");
        for (String key : configs.keySet()) {
            sb.append(" ").append(key).append("-").append(configs.get(key));
        }
        TLog.error("[vod-java]", sb.toString());
        nativeSetMediaConfig(configs);
    }

    public static void enableDevEnv(boolean bEnable) {
        mEnableDevEnv = bEnable;
        nativeSetDevEnv(bEnable);
    }

    public static boolean isEnableDevEnv() {
        return mEnableDevEnv;
    }
}
