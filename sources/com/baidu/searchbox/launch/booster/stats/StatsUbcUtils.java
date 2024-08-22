package com.baidu.searchbox.launch.booster.stats;

import com.baidu.cpu.booster.stats.CpuBoosterStats;
import com.baidu.cpu.booster.stats.StatsConstants;
import com.baidu.cpu.booster.utils.CpuUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.devicescore.IDeviceScore;
import com.baidu.ubc.UBCManager;
import org.json.JSONObject;

public class StatsUbcUtils {
    private static final boolean DEBUG = false;
    private static final String TAG = "StatsUbcUtils-Booster";

    public static void upload(CpuBoosterStats cpuStats) {
        UBCManager ubcManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        if (ubcManager != null && cpuStats != null) {
            JSONObject option = new JSONObject();
            try {
                option.put("from", "research");
                option.put("page", cpuStats.getBusiness());
                if (cpuStats.getStartFlag() == 1) {
                    cpuStats.calculateSampleFlag();
                } else {
                    cpuStats.setSampleFlag(0);
                }
                JSONObject extObject = new JSONObject();
                extObject.put(StatsConstants.KEY_START_FLAG, cpuStats.getStartFlag());
                extObject.put(StatsConstants.KEY_SAMPLE_FLAG, cpuStats.getSampleFlag());
                extObject.put(StatsConstants.EXT_KEY_TIMEOUT, cpuStats.getTimeOut());
                extObject.put("device_score", (double) ((IDeviceScore) ServiceManager.getService(IDeviceScore.SERVICE_REFERENCE)).getFinalScore(AppRuntime.getAppContext()));
                calculateCpuInfo(cpuStats);
                extObject.put(StatsConstants.EXT_KEY_CPU_INFO, cpuStats.getCpuInfo());
                extObject.put("data", cpuStats.getCpuFreqData());
                option.put("ext", extObject);
                ubcManager.onEvent(StatsConstants.UBC_CPU_BOOSTER_ID, option);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private static void calculateCpuInfo(CpuBoosterStats stats) {
        if (stats != null) {
            try {
                JSONObject maxMinCpuFreq = new JSONObject();
                CpuFreqUtils.getCpuMaxMinFreqJson(maxMinCpuFreq);
                stats.setCpuInfoJson(CpuUtils.getCpuCoreNum(), CpuUtils.getCpuInfo().toString(), CpuUtils.getCpuType().name(), CpuUtils.getCpuModel(), maxMinCpuFreq);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
