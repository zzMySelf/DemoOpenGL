package com.baidu.swan.apps.stability;

import android.util.Pair;
import com.baidu.swan.apps.adaptation.webview.ISwanAppSlaveManager;
import com.baidu.swan.apps.adaptation.webview.ISwanAppWebViewWidget;
import com.baidu.swan.apps.adaptation.webview.impl.WebViewPaintTiming;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.core.fragment.SwanAppFragment;
import com.baidu.swan.apps.core.launchtips.monitor.request.RequestModel;
import com.baidu.swan.apps.core.launchtips.monitor.request.RequestMonitor;
import com.baidu.swan.apps.embed.page.ISwanPageManager;
import com.baidu.swan.apps.lifecycle.SwanAppController;
import com.baidu.swan.apps.performance.StartupReporter;
import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.pms.database.PMSDB;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.talos.core.render.views.viewgroup.TalosPerformEvent;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

class SwanAppStabilityData {
    private static final String TAG = "SwanAppStabilityData";
    public List<Float> mCpuList = new CopyOnWriteArrayList();
    public List<Float> mDeviceMemList = new CopyOnWriteArrayList();
    public List<Integer> mFpsList = new CopyOnWriteArrayList();
    public List<Float> mHostMemList = new CopyOnWriteArrayList();
    public List<Float> mMnpMemList = new CopyOnWriteArrayList();
    int mObtainInterval = 500;
    public Set<String> mPrelinkUrlList = new ConcurrentSkipListSet();
    public List<Long> mTimestampList = new CopyOnWriteArrayList();
    public float mTotalMem = 0.0f;
    public VerificationData mVerificationData = new VerificationData();

    SwanAppStabilityData() {
    }

    public Map<String, String> toMap() {
        Map<String, String> result = new TreeMap<>();
        try {
            result.put("obtainInterval", String.valueOf(this.mObtainInterval));
            result.put("totalMem", String.valueOf(this.mTotalMem));
            result.put("prelinkUrlList", JSONObject.wrap(this.mPrelinkUrlList).toString());
            result.put("timestampList", JSONObject.wrap(this.mTimestampList).toString());
            result.put("fpsList", JSONObject.wrap(this.mFpsList).toString());
            result.put("cpuList", JSONObject.wrap(this.mCpuList).toString());
            result.put("deviceMemList", JSONObject.wrap(this.mDeviceMemList).toString());
            result.put("hostMemList", JSONObject.wrap(this.mHostMemList).toString());
            result.put("mnpMemList", JSONObject.wrap(this.mMnpMemList).toString());
            JSONObject vDataJo = new JSONObject();
            vDataJo.put(TalosPerformEvent.EVENT_TYPE_FMP, String.valueOf(this.mVerificationData.mFmp));
            vDataJo.put("mainPkgSize", String.valueOf(this.mVerificationData.mMainPkgSize));
            vDataJo.put("idleCpuAvg", String.valueOf(this.mVerificationData.mIdleCpuAvg));
            vDataJo.put("fpsAvg", String.valueOf(this.mVerificationData.mFpsAvg));
            vDataJo.put("launchMemDiff", String.valueOf(this.mVerificationData.mLaunchDiffMem));
            vDataJo.put("runningMemDiff", String.valueOf(this.mVerificationData.mRunningDiffMem));
            vDataJo.put("launchRequestCount", String.valueOf(this.mVerificationData.mLaunchRequestCount));
            result.put("verificationData", vDataJo.toString());
        } catch (Exception e2) {
            SwanAppLog.logToFile(TAG, "#toMap 出错", e2);
        }
        return result;
    }

    public String toString() {
        return "SwanAppStabilityData{mObtainInterval=" + this.mObtainInterval + ", mTotalMem=" + this.mTotalMem + ", mPrelinkUrlList=" + this.mPrelinkUrlList + ", mTimestampList=" + this.mTimestampList + ", mFpsList=" + this.mFpsList + ", mCpuList=" + this.mCpuList + ", mDeviceMemList=" + this.mDeviceMemList + ", mHostMemList=" + this.mHostMemList + ", mMnpMemList=" + this.mMnpMemList + ", mVerificationData=" + this.mVerificationData + AbstractJsonLexerKt.END_OBJ;
    }

    public void fillVerificationData(List<Float> idleCpuList) {
        VerificationData vData = this.mVerificationData;
        Pair<Long, Long> fmpTimetampAndFmpTime = getFmpTimetampAndFmpTime(10000);
        long fmpTimestamp = ((Long) fmpTimetampAndFmpTime.first).longValue();
        vData.mFmp = ((Long) fmpTimetampAndFmpTime.second).longValue();
        vData.mIdleCpuAvg = VerificationData.getIdleCpuAvg(idleCpuList);
        vData.mMainPkgSize = VerificationData.getMainPkgSize();
        vData.mLaunchDiffMem = VerificationData.getLaunchDiffMem(this.mMnpMemList, this.mTimestampList, fmpTimestamp);
        vData.mRunningDiffMem = VerificationData.getRunningDiffMem(this.mMnpMemList, this.mTimestampList, fmpTimestamp);
        vData.mLaunchRequestCount = VerificationData.getRequestCountBeforeFmp(fmpTimestamp);
        vData.mFpsAvg = VerificationData.calcFpsAvg(this.mFpsList);
    }

    private Pair<Long, Long> getFmpTimetampAndFmpTime(int timeoutMs) {
        long fmp;
        long fmpTimestamp;
        long timeoutTs = ((long) timeoutMs) + System.currentTimeMillis();
        do {
            fmp = VerificationData.getFmpCostMs();
            fmpTimestamp = VerificationData.getFmpTimestamp();
            if (fmp > 0 && fmpTimestamp > 0) {
                break;
            }
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException ex) {
                SwanAppLog.logToFile(TAG, "sleep 中断", ex);
            }
        } while (timeoutTs > System.currentTimeMillis());
        SwanAppLog.i(TAG, "fmpTimestamp=" + fmpTimestamp + " fmp=" + fmp);
        return Pair.create(Long.valueOf(fmpTimestamp), Long.valueOf(fmp));
    }

    public String toJSONString() {
        return String.valueOf(JSONObject.wrap(toMap()));
    }

    public static class VerificationData {
        public static final long DEFAULT_FMP = 0;
        public static final float DEFAULT_IDLE_CPU = -1.0f;
        public static final float DEFAULT_MAIN_PKG_SIZE = 0.0f;
        public volatile long mFmp;
        public float mFpsAvg;
        public float mIdleCpuAvg;
        public float mLaunchDiffMem;
        public int mLaunchRequestCount;
        public float mMainPkgSize;
        public float mRunningDiffMem;

        public String toString() {
            return "VerificationData{mFmp=" + this.mFmp + ", mMainPkgSize=" + this.mMainPkgSize + ", mIdleCpuAvg=" + this.mIdleCpuAvg + ", mFpsAvg=" + this.mFpsAvg + ", mLaunchDiffMem=" + this.mLaunchDiffMem + ", mRunningDiffMem=" + this.mRunningDiffMem + ", mLaunchRequestCount=" + this.mLaunchRequestCount + AbstractJsonLexerKt.END_OBJ;
        }

        public static long getFmpCostMs() {
            return StartupReporter.Storage.getInstance().fmpCostMs;
        }

        public static float calcFpsAvg(List<Integer> fpsList) {
            int count = 0;
            float sum = 0.0f;
            for (Integer fps : fpsList) {
                if (fps != null && fps.intValue() > 0) {
                    count++;
                    sum += (float) fps.intValue();
                }
            }
            if (count == 0) {
                return 0.0f;
            }
            return sum / ((float) count);
        }

        public static long getFmpTimestamp() {
            SwanAppFragment curFragment;
            ISwanAppSlaveManager slaveManager;
            WebViewPaintTiming paintTiming;
            ISwanPageManager fragmentManager = SwanAppController.getInstance().getSwanPageManager();
            if (fragmentManager == null || (curFragment = fragmentManager.getTopSwanAppFragment()) == null || (slaveManager = curFragment.getCurrentWebViewManager()) == null) {
                return 0;
            }
            ISwanAppWebViewWidget webViewWidget = slaveManager.getWebViewWidget();
            if (webViewWidget == null) {
                paintTiming = slaveManager.getPaintTiming();
            } else {
                paintTiming = webViewWidget.getPaintTiming();
            }
            if (paintTiming == null) {
                return 0;
            }
            return paintTiming.fmp;
        }

        public static float getIdleCpuAvg(List<Float> idleCpuList) {
            if (idleCpuList == null || idleCpuList.isEmpty()) {
                return 0.0f;
            }
            int count = 0;
            float sum = 0.0f;
            for (Float usedCpu : idleCpuList) {
                if (usedCpu != null) {
                    count++;
                    sum += usedCpu.floatValue();
                }
            }
            if (count == 0) {
                return -1.0f;
            }
            return sum / ((float) count);
        }

        public static float getMainPkgSize() {
            PMSAppInfo appInfo = PMSDB.getInstance().querySwanApp(Swan.get().getAppId());
            if (appInfo == null) {
                return 0.0f;
            }
            return ((float) appInfo.pkgSize) / 1024.0f;
        }

        public static float getLaunchDiffMem(List<Float> memList, List<Long> timeList, long fmp) {
            return calcFirstAndMaxMemDiff(memList, timeList, fmp, true);
        }

        public static float getRunningDiffMem(List<Float> memList, List<Long> timeList, long fmp) {
            return calcFirstAndMaxMemDiff(memList, timeList, fmp, false);
        }

        public static float calcFirstAndMaxMemDiff(List<Float> memList, List<Long> timeList, long fmp, boolean isBefore) {
            float firstMem = 0.0f;
            if (fmp == 0 || memList == null || memList.isEmpty() || timeList == null || timeList.isEmpty() || memList.size() != timeList.size()) {
                return 0.0f;
            }
            SwanAppLog.d(SwanAppStabilityData.TAG, "#calcFirstAndMaxMemDiff memList=" + memList + " timeList=" + timeList + " fmp=" + fmp + " isBefore=" + isBefore);
            float maxMem = Float.MIN_VALUE;
            Float firstMemItem = memList.get(0);
            if (firstMemItem != null) {
                firstMem = firstMemItem.floatValue();
            }
            for (int i2 = 0; i2 < memList.size(); i2++) {
                Long time = timeList.get(i2);
                Float mem = memList.get(i2);
                if (!(time == null || mem == null)) {
                    if (isBefore) {
                        if (time.longValue() <= fmp) {
                            maxMem = Math.max(maxMem, mem.floatValue());
                        }
                    } else if (time.longValue() >= fmp) {
                        maxMem = Math.max(maxMem, mem.floatValue());
                    }
                }
            }
            return maxMem - firstMem;
        }

        public static int getRequestCountBeforeFmp(long fmp) {
            int result = 0;
            for (RequestModel model : RequestMonitor.instance().getAllRequests()) {
                if (model != null && model.getStartTime() < fmp) {
                    result++;
                }
            }
            return result;
        }
    }
}
