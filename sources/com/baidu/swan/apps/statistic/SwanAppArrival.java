package com.baidu.swan.apps.statistic;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.adaptation.webview.impl.WebViewPaintTiming;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.launch.model.SwanAppLaunchInfo;
import com.baidu.swan.apps.monitor.SwanAppArrivalMonitor;
import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.util.SwanAppJSONUtils;
import org.json.JSONObject;

public class SwanAppArrival {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String TAG = "SwanAppArrival";
    private static volatile boolean sCancelRecorded = false;
    private static volatile boolean sFailRecorded = false;
    private static volatile boolean sFmpFailRecorded = false;
    private static volatile boolean sFmpSuccessRecorded = false;
    private static volatile boolean sUnSuccessRecorded = false;

    public static void setCancelRecord(boolean record) {
        sCancelRecorded = record;
    }

    public static boolean isCancelRecord() {
        return sCancelRecorded;
    }

    public static void setUnSuccessRecord(boolean record) {
        sUnSuccessRecorded = record;
    }

    public static boolean isUnSuccessRecord() {
        return sUnSuccessRecorded;
    }

    public static void setFailRecord(boolean record) {
        sFailRecorded = record;
    }

    public static boolean isFailRecord() {
        return sFailRecorded;
    }

    public static void setFmpSuccessRecord(boolean record) {
        sFmpSuccessRecorded = record;
    }

    public static boolean isFmpSuccessRecorded() {
        return sFmpSuccessRecorded;
    }

    public static void setFmpFailRecord(boolean record) {
        sFmpFailRecorded = record;
    }

    public static boolean isFmpFailRecord() {
        return sFmpFailRecorded;
    }

    public static void resetArrivalRecorded() {
        setCancelRecord(false);
        setFailRecord(false);
        setFmpFailRecord(false);
        setFmpSuccessRecord(false);
        setUnSuccessRecord(false);
    }

    public static boolean isArrivalReported() {
        return isCancelRecord() || isFailRecord() || isFmpSuccessRecorded() || isUnSuccessRecord();
    }

    public static void doArrivalReport() {
        if (DEBUG) {
            Log.d(TAG, "start handle arrival report");
        }
        if (!isArrivalReported()) {
            Pair<WebViewPaintTiming, Integer> paintTimingPair = SwanAppArrivalMonitor.getPaintTiming();
            WebViewPaintTiming paintTiming = (WebViewPaintTiming) paintTimingPair.first;
            if (paintTiming == null) {
                long now = System.currentTimeMillis();
                SwanAppLaunchUbc.onArrivalFail(Swan.get().getApp().getInfo(), SwanAppLaunchUbc.VALUE_ARRIVE_FAIL, now, ((Integer) paintTimingPair.second).intValue());
                onFmpArrivalFail(((Integer) paintTimingPair.second).intValue(), now);
            } else {
                SwanApp swanApp = SwanApp.getOrNull();
                if (swanApp != null) {
                    SwanAppLaunchInfo.Impl launchInfo = swanApp.getInfo();
                    SwanAppLaunchInfo.Impl impl = launchInfo;
                    handleArrivalReport(impl, paintTiming.fcp, "0", paintTiming.fmp, SwanAppLaunchUbc.getRightType(paintTiming.fmpType), false);
                } else {
                    return;
                }
            }
            SwanAppRuntime.getSwanExternalTransferStats().finish();
        }
    }

    public static void handleArrivalReport(SwanAppLaunchInfo.Impl launchInfo, long fcp, String fcpType, long fmp, String fmpType, boolean isFromNaRelaunch) {
        if (launchInfo != null && !TextUtils.isEmpty(fcpType) && !TextUtils.isEmpty(fmpType) && !isArrivalReported()) {
            if (SwanAppUbcControl.canStatLaunch("arrivesuccess")) {
                if (isFromNaRelaunch || fcp > 0) {
                    SwanAppLaunchUbc.onArrival(launchInfo, "arrivesuccess", fcp, SwanAppJSONUtils.newJSONObject(SwanAppLaunchUbc.EXT_KEY_VALUE_TYPE, fcpType));
                } else {
                    SwanAppLaunchUbc.onArrivalFail(launchInfo, SwanAppLaunchUbc.VALUE_ARRIVE_FAIL, fcp, 2);
                }
            }
            if (isFromNaRelaunch || fmp > 0) {
                onFmpArrivalSuccess(launchInfo, fmp, SwanAppJSONUtils.newJSONObject(SwanAppLaunchUbc.EXT_KEY_VALUE_TYPE, fmpType));
            } else {
                onFmpArrivalFail(3, fmp);
            }
        }
    }

    public static void onFmpArrivalSuccess(SwanAppLaunchInfo.Impl launchInfo, long arriveTime, JSONObject extJson) {
        if (!isArrivalReported()) {
            setFmpSuccessRecord(true);
            if (isFmpFailRecord()) {
                SwanAppJSONUtils.setValue(extJson, "alreadyFail", "1");
            }
            if (SwanAppLaunchUbc.isUserQuickCancelRecorded()) {
                SwanAppJSONUtils.setValue(extJson, "userCanceled", "1");
            }
            SwanAppLaunchUbc.onArrival(launchInfo, SwanAppLaunchUbc.VALUE_ARRIVE_FMP_SUCCESS, arriveTime, extJson);
            SwanAppLaunchUbc.onArrival(launchInfo, SwanAppLaunchUbc.VALUE_ARRIVE_TTI_SUCCESS, arriveTime, extJson);
        }
    }

    public static void onFmpArrivalFail(int reason, long fmpArrFailTs) {
        SwanApp swanApp = SwanApp.getOrNull();
        if (swanApp != null && !isArrivalReported() && !isFmpFailRecord()) {
            setFmpFailRecord(true);
            SwanAppLaunchInfo.Impl launchInfo = swanApp.getInfo();
            SwanAppLaunchUbc.reportJsLog();
            SwanAppLaunchUbc.onArrival(launchInfo, SwanAppLaunchUbc.VALUE_ARRIVE_FMP_FAIL, fmpArrFailTs, SwanAppJSONUtils.newJSONObject("reason", Integer.valueOf(reason)));
        }
    }
}
