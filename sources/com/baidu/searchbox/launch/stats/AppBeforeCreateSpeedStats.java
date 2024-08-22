package com.baidu.searchbox.launch.stats;

import com.baidu.launch.stats.ApplicationStatsHelper;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class AppBeforeCreateSpeedStats extends AbstractSpeedStats {
    private static final String APP_CONFIG_INIT = "appConfigInit";
    private static final String APP_RUNTIME_INIT = "appRuntimeInit";
    private static final String BEFORE_ATTACH_BASE_CONTEXT = "beforeAttachBaseContext";
    private static final String FIX_THREAD_PRIORITY = "fixThreadPriority";
    private static final String INSTALL_CONTENT_PROVIDER = "installContentProvider";
    private static final String LOKI_INIT = "lokiInit";
    private static final String MULTIDEX_INSTALL = "multidexInstall";
    private static final String NPS_HOOK = "npsHook";
    private static final String SPLASH_AFD_QUERY = "splashAfdQuery";
    public static final String TITAN_DETAILS = "titan";
    private static final String TITAN_INIT = "titanInit";
    private static final String TITAN_READ_CONFIG = "titanReadConfig";
    private static final String TITAN_START_SERVICE = "titanStartService";
    private long mAppCreateStartTime = -1;
    private volatile Map mTitanDetailsMap = null;

    public void addStatsTimeStamp(int key) {
        addStatsTimeStamp(key, System.currentTimeMillis());
    }

    public void addStatsTimeStamp(int key, long timeStamp) {
        super.addStatsTimeStamp(key, timeStamp);
        switch (key) {
            case 2000:
                this.mAppCreateStartTime = timeStamp;
                return;
            default:
                return;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addStatsMap(java.lang.String r2, java.util.Map<java.lang.String, java.lang.String> r3) {
        /*
            r1 = this;
            super.addStatsMap(r2, r3)
            int r0 = r2.hashCode()
            switch(r0) {
                case 110371084: goto L_0x000b;
                default: goto L_0x000a;
            }
        L_0x000a:
            goto L_0x0016
        L_0x000b:
            java.lang.String r0 = "titan"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x000a
            r0 = 0
            goto L_0x0017
        L_0x0016:
            r0 = -1
        L_0x0017:
            switch(r0) {
                case 0: goto L_0x001b;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x001d
        L_0x001b:
            r1.mTitanDetailsMap = r3
        L_0x001d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.launch.stats.AppBeforeCreateSpeedStats.addStatsMap(java.lang.String, java.util.Map):void");
    }

    public boolean packData(JSONObject json) {
        JSONObject jSONObject = json;
        super.packData(json);
        if (jSONObject == null) {
            return true;
        }
        long appStartTimeStamp = ApplicationStatsHelper.sStartTime;
        long totalDuration = this.mAppCreateStartTime - appStartTimeStamp;
        long attachBaseContextStartTimeStamp = ApplicationStatsHelper.sAttachBaseContextStartTime;
        long beforeAttachBaseContext = attachBaseContextStartTimeStamp - appStartTimeStamp;
        long multiDexInstallEndTimeStamp = ApplicationStatsHelper.sMultiDexInstallEndTime;
        long multidexInstall = multiDexInstallEndTimeStamp - attachBaseContextStartTimeStamp;
        long appRuntimeInitEndTimeStamp = ApplicationStatsHelper.sAppRuntimeInitEndTime;
        long runtimeInit = appRuntimeInitEndTimeStamp - multiDexInstallEndTimeStamp;
        long fixThreadPriorityEndTimeStamp = ApplicationStatsHelper.sFixThreadPriorityEndTime;
        long fixThreadPriority = fixThreadPriorityEndTimeStamp - appRuntimeInitEndTimeStamp;
        long titanInitEndTimeStamp = ApplicationStatsHelper.sTitanInitEndTime;
        long titanInit = titanInitEndTimeStamp - fixThreadPriorityEndTimeStamp;
        long lokiInitEndTimeStamp = ApplicationStatsHelper.sLokiInitEndTime;
        long lokiInit = lokiInitEndTimeStamp - titanInitEndTimeStamp;
        long npsHookInitEndTimeStamp = ApplicationStatsHelper.sNPSHookManagerInitEndTime;
        long npsHook = npsHookInitEndTimeStamp - lokiInitEndTimeStamp;
        long appConfigEndTimeStamp = ApplicationStatsHelper.sAppConfigEndTime;
        long appConfig = appConfigEndTimeStamp - npsHookInitEndTimeStamp;
        long splashAfdQuery = ApplicationStatsHelper.sSplashAfdQueryEndTime - appConfigEndTimeStamp;
        long j2 = appStartTimeStamp;
        long installContentProvider = this.mAppCreateStartTime - ApplicationStatsHelper.sAttachBaseContextEndTime;
        if (totalDuration < 0 || totalDuration > 60000 || beforeAttachBaseContext < 0 || beforeAttachBaseContext > 60000 || multidexInstall < 0 || multidexInstall > 60000 || runtimeInit < 0 || runtimeInit > 60000 || fixThreadPriority < 0 || fixThreadPriority > 60000 || titanInit < 0 || titanInit > 60000 || lokiInit < 0 || lokiInit > 60000 || npsHook < 0 || npsHook > 60000 || appConfig < 0 || appConfig > 60000 || splashAfdQuery < 0 || splashAfdQuery > 60000 || installContentProvider < 0) {
            return false;
        } else if (installContentProvider > 60000) {
            long j3 = attachBaseContextStartTimeStamp;
            return false;
        } else {
            Map<String, String> map = new HashMap<>();
            long j4 = attachBaseContextStartTimeStamp;
            map.put(BEFORE_ATTACH_BASE_CONTEXT, String.valueOf(beforeAttachBaseContext));
            map.put(MULTIDEX_INSTALL, String.valueOf(multidexInstall));
            map.put(APP_RUNTIME_INIT, String.valueOf(runtimeInit));
            map.put(FIX_THREAD_PRIORITY, String.valueOf(fixThreadPriority));
            map.put(TITAN_INIT, String.valueOf(titanInit));
            map.put(LOKI_INIT, String.valueOf(lokiInit));
            map.put(NPS_HOOK, String.valueOf(npsHook));
            map.put(APP_CONFIG_INIT, String.valueOf(appConfig));
            map.put(SPLASH_AFD_QUERY, String.valueOf(splashAfdQuery));
            map.put(INSTALL_CONTENT_PROVIDER, String.valueOf(installContentProvider));
            if (ApplicationStatsHelper.sTitanStartServiceTime > 0) {
                map.put(TITAN_START_SERVICE, String.valueOf(ApplicationStatsHelper.sTitanStartServiceTime));
            }
            map.put(TITAN_READ_CONFIG, String.valueOf(ApplicationStatsHelper.sTitanReadConfigTime));
            if (this.mTitanDetailsMap != null) {
                synchronized (this) {
                    if (this.mTitanDetailsMap != null) {
                        map.putAll(this.mTitanDetailsMap);
                    }
                }
            }
            JSONObject jsonObject = SpeedStatsUtils.getJsonData(totalDuration, map);
            if (jsonObject == null) {
                return true;
            }
            try {
                jSONObject.put(SpeedStatsMainTable.BEFORE_APP_CREATE_STAGE, jsonObject);
                return true;
            } catch (JSONException e2) {
                if (!AppConfig.isDebug()) {
                    return true;
                }
                e2.printStackTrace();
                return true;
            }
        }
    }

    public void reset() {
        this.mTitanDetailsMap = null;
        ApplicationStatsHelper.reset();
    }

    public long getStatsStartTimeStamp() {
        return SpeedStatsManager.getInstance().getAppLaunchStartTimeStamp();
    }

    public long getStatsEndTimeStamp() {
        return this.mAppCreateStartTime;
    }
}
