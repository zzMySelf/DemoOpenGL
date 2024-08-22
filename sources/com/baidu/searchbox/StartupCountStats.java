package com.baidu.searchbox;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.appframework.SimpleActivityLifeCycle;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;

public class StartupCountStats extends SimpleActivityLifeCycle implements NoProGuard {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "StartupCountStats";
    private static volatile String sAppStartSource = "";
    private static long sBackgroundTimeStamp = -1;
    private static Flow sFlow;
    private static long sForegroundTimeStamp = -1;
    private static boolean sIsWarmBootApp = false;
    private static PerfSampleManager sPerfSampleManager = new PerfSampleManager();
    private static ExtDataCallBack sStartupCountExtCallBack = new ExtDataCallBack();
    private static StatsRule sStartupCountStatsRule = new StatsRule();
    private static String sStartupCountStatsType;
    private static String sStartupCountUploadId = StartupCountStatsUtils.DEFAULT_STARTUP_UBC_ID;
    private static ExtDataCallBack sUseDurationExtCallBack = new ExtDataCallBack();
    private static StatsRule sUseDurationStatsRule = new StatsRule();
    private static String sUseDurationStatsType;
    private static String sUseDurationUploadId = StartupCountStatsUtils.DEFAULT_USE_DURATION_UBC_ID;
    private static UBCManager ubc = null;

    public void onBackgroundToForeground(Activity activity) {
        String str;
        if (sStartupCountStatsRule.shouldStats(activity)) {
            sForegroundTimeStamp = System.currentTimeMillis();
            if (sIsWarmBootApp) {
                str = "warm_start";
            } else {
                str = "cold_start";
            }
            appStartupUpload(str);
        }
        if (sUseDurationStatsRule.shouldStats(activity)) {
            startTiming();
        }
        if (!sIsWarmBootApp) {
            sIsWarmBootApp = true;
        }
    }

    public void onForegroundToBackground(Activity activity) {
        sBackgroundTimeStamp = System.currentTimeMillis();
        if (sUseDurationStatsRule.shouldStats(activity)) {
            stopTiming();
        }
    }

    public void onActivityResumed(Activity activity) {
        updateTiming();
    }

    private static void appStartupUpload(String type) {
        JSONObject values = new JSONObject();
        try {
            values.put("from", "research");
            values.put("type", type);
            if (!TextUtils.isEmpty(sAppStartSource)) {
                values.put("source", sAppStartSource);
                sAppStartSource = "";
            }
            JSONObject extObject = sStartupCountExtCallBack.addData();
            if (extObject == null) {
                extObject = new JSONObject();
            }
            extObject.put("ftime", sForegroundTimeStamp);
            extObject.put("btime", sBackgroundTimeStamp);
            if (!TextUtils.isEmpty(sStartupCountStatsType)) {
                extObject.put(StartupCountStatsUtils.LAUNCH_SAMPLE, sStartupCountStatsType);
            }
            String flag = sPerfSampleManager.getSampleFlag();
            if (!TextUtils.isEmpty(flag)) {
                extObject.put("pf", flag);
            }
            extObject.put("lsdk", "bls");
            values.put("ext", extObject);
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
        if (ubc == null) {
            ubc = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        }
        ubc.onEvent(sStartupCountUploadId, values);
    }

    private static void startTiming() {
        if (DEBUG) {
            Log.d(TAG, "App使用时长统计开始：startTiming");
        }
        JSONObject object = new JSONObject();
        try {
            object.put("duration", "0");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (ubc == null) {
            ubc = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        }
        sFlow = ubc.beginFlow(sUseDurationUploadId, object.toString(), 4);
    }

    public static void updateTiming() {
        if (sFlow != null && sUseDurationStatsRule.shouldStats((Activity) null) && System.currentTimeMillis() - sFlow.getStartTime() > 300000) {
            if (ubc == null) {
                ubc = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            }
            ubc.flowSetValueWithDuration(sFlow, generateValueJson());
            if (DEBUG) {
                Log.d(TAG, "App使用时长统计更新（最小间隔5分钟）：updateTiming");
            }
        }
    }

    private static void stopTiming() {
        if (sFlow != null) {
            if (ubc == null) {
                ubc = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            }
            ubc.flowSetValueWithDuration(sFlow, generateValueJson());
            ubc.flowEnd(sFlow);
            sFlow = null;
            if (DEBUG) {
                Log.d(TAG, "App使用时长统计结束：stopTiming");
            }
        }
    }

    private static String generateValueJson() {
        try {
            JSONObject jsonObject = sUseDurationExtCallBack.addData();
            if (jsonObject == null) {
                jsonObject = new JSONObject();
            }
            String flag = sPerfSampleManager.getSampleFlag();
            if (!TextUtils.isEmpty(flag)) {
                jsonObject.put("pf", flag);
            }
            jsonObject.put("lsdk", "bls");
            if (!TextUtils.isEmpty(sUseDurationStatsType)) {
                jsonObject.put(StartupCountStatsUtils.LAUNCH_SAMPLE, sUseDurationStatsType);
            }
            return jsonObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void setStartSource(String source) {
        sAppStartSource = source;
    }

    public static void setStartupCountUploadId(String id) {
        sStartupCountUploadId = id;
    }

    public static void setUseDurationUploadId(String id) {
        sUseDurationUploadId = id;
    }

    public static void setStartupCountStatsType(String type) {
        sStartupCountStatsType = type;
    }

    public static void setUseDurationStatsType(String type) {
        sUseDurationStatsType = type;
    }

    public static void setStartupCountStatsRule(StatsRule rule) {
        sStartupCountStatsRule = rule;
    }

    public static void setUseDurationStatsRule(StatsRule rule) {
        sUseDurationStatsRule = rule;
    }

    public static void setStartupCountExtCallBack(ExtDataCallBack callBack) {
        sStartupCountExtCallBack = callBack;
    }

    public static void setUseDurationExtCallBack(ExtDataCallBack callBack) {
        sUseDurationExtCallBack = callBack;
    }

    public static String getSampleFlag() {
        return sPerfSampleManager.getSampleFlag();
    }

    public static class StatsRule {
        public boolean shouldStats(Activity activity) {
            return true;
        }
    }

    public static class ExtDataCallBack {
        public JSONObject addData() {
            return null;
        }
    }
}
