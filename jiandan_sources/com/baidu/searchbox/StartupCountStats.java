package com.baidu.searchbox;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBCManager;
import fe.fe.ddd.rg.de;
import org.json.JSONException;
import org.json.JSONObject;

public class StartupCountStats extends de implements NoProGuard {
    public static final boolean DEBUG = AppConfig.rg();
    public static final String TAG = "StartupCountStats";
    public static volatile String sAppStartSource = "";
    public static long sBackgroundTimeStamp = -1;
    public static Flow sFlow;
    public static long sForegroundTimeStamp = -1;
    public static boolean sIsWarmBootApp = false;
    public static PerfSampleManager sPerfSampleManager = new PerfSampleManager();
    public static qw sStartupCountExtCallBack = new qw();
    public static ad sStartupCountStatsRule = new ad();
    public static String sStartupCountStatsType;
    public static String sStartupCountUploadId = "1482";
    public static qw sUseDurationExtCallBack = new qw();
    public static ad sUseDurationStatsRule = new ad();
    public static String sUseDurationStatsType;
    public static String sUseDurationUploadId = "1557";
    public static UBCManager ubc = null;

    public static class ad {
        @Nullable
        public boolean qw(Activity activity) {
            return true;
        }
    }

    public static class qw {
        @Nullable
        public JSONObject qw() {
            return null;
        }
    }

    public static void appStartupUpload(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", "research");
            jSONObject.put("type", str);
            if (!TextUtils.isEmpty(sAppStartSource)) {
                jSONObject.put(UBCManager.CONTENT_KEY_SOURCE, sAppStartSource);
                sAppStartSource = "";
            }
            JSONObject qw2 = sStartupCountExtCallBack.qw();
            if (qw2 == null) {
                qw2 = new JSONObject();
            }
            qw2.put("ftime", sForegroundTimeStamp);
            qw2.put("btime", sBackgroundTimeStamp);
            if (!TextUtils.isEmpty(sStartupCountStatsType)) {
                qw2.put("launch_sample", sStartupCountStatsType);
            }
            String qw3 = sPerfSampleManager.qw();
            if (!TextUtils.isEmpty(qw3)) {
                qw2.put("pf", qw3);
            }
            qw2.put("lsdk", "bls");
            jSONObject.put(UBCManager.CONTENT_KEY_EXT, qw2);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        if (ubc == null) {
            ubc = (UBCManager) fe.fe.vvv.ad.ad.ad.qw(UBCManager.SERVICE_REFERENCE);
        }
        ubc.onEvent(sStartupCountUploadId, jSONObject);
    }

    public static String generateValueJson() {
        try {
            JSONObject qw2 = sUseDurationExtCallBack.qw();
            if (qw2 == null) {
                qw2 = new JSONObject();
            }
            String qw3 = sPerfSampleManager.qw();
            if (!TextUtils.isEmpty(qw3)) {
                qw2.put("pf", qw3);
            }
            qw2.put("lsdk", "bls");
            if (!TextUtils.isEmpty(sUseDurationStatsType)) {
                qw2.put("launch_sample", sUseDurationStatsType);
            }
            return qw2.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @NonNull
    public static String getSampleFlag() {
        return sPerfSampleManager.qw();
    }

    @Nullable
    public static void setStartSource(String str) {
        sAppStartSource = str;
    }

    @Nullable
    public static void setStartupCountExtCallBack(qw qwVar) {
        sStartupCountExtCallBack = qwVar;
    }

    @Nullable
    public static void setStartupCountStatsRule(ad adVar) {
        sStartupCountStatsRule = adVar;
    }

    @Nullable
    public static void setStartupCountStatsType(String str) {
        sStartupCountStatsType = str;
    }

    @Nullable
    public static void setStartupCountUploadId(String str) {
        sStartupCountUploadId = str;
    }

    @Nullable
    public static void setUseDurationExtCallBack(qw qwVar) {
        sUseDurationExtCallBack = qwVar;
    }

    @Nullable
    public static void setUseDurationStatsRule(ad adVar) {
        sUseDurationStatsRule = adVar;
    }

    @Nullable
    public static void setUseDurationStatsType(String str) {
        sUseDurationStatsType = str;
    }

    @Nullable
    public static void setUseDurationUploadId(String str) {
        sUseDurationUploadId = str;
    }

    public static void startTiming() {
        boolean z = DEBUG;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("duration", "0");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (ubc == null) {
            ubc = (UBCManager) fe.fe.vvv.ad.ad.ad.qw(UBCManager.SERVICE_REFERENCE);
        }
        sFlow = ubc.beginFlow(sUseDurationUploadId, jSONObject.toString(), 4);
    }

    public static void stopTiming() {
        if (sFlow != null) {
            if (ubc == null) {
                ubc = (UBCManager) fe.fe.vvv.ad.ad.ad.qw(UBCManager.SERVICE_REFERENCE);
            }
            ubc.flowSetValueWithDuration(sFlow, generateValueJson());
            ubc.flowEnd(sFlow);
            sFlow = null;
            boolean z = DEBUG;
        }
    }

    public static void updateTiming() {
        if (sFlow != null && sUseDurationStatsRule.qw((Activity) null) && System.currentTimeMillis() - sFlow.getStartTime() > 300000) {
            if (ubc == null) {
                ubc = (UBCManager) fe.fe.vvv.ad.ad.ad.qw(UBCManager.SERVICE_REFERENCE);
            }
            ubc.flowSetValueWithDuration(sFlow, generateValueJson());
            boolean z = DEBUG;
        }
    }

    @Nullable
    public void onActivityResumed(Activity activity) {
        updateTiming();
    }

    @Nullable
    public void onBackgroundToForeground(Activity activity) {
        if (sStartupCountStatsRule.qw(activity)) {
            sForegroundTimeStamp = System.currentTimeMillis();
            appStartupUpload(sIsWarmBootApp ? "warm_start" : "cold_start");
        }
        if (sUseDurationStatsRule.qw(activity)) {
            startTiming();
        }
        if (!sIsWarmBootApp) {
            sIsWarmBootApp = true;
        }
    }

    @Nullable
    public void onForegroundToBackground(Activity activity) {
        sBackgroundTimeStamp = System.currentTimeMillis();
        if (sUseDurationStatsRule.qw(activity)) {
            stopTiming();
        }
    }
}
