package com.baidu.searchbox.ruka.ubc;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.aperf.param.CommonUtils;
import com.baidu.searchbox.aperf.param.dye.DyeConfigManager;
import com.baidu.searchbox.aperf.param.dye.IDyeConfig;
import com.baidu.searchbox.aperf.param.launch.ILaunchType;
import com.baidu.searchbox.aperf.param.launch.LaunchTypeManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.devicescore.IDeviceScore;
import com.baidu.searchbox.looper.impl.LooperBlock;
import com.baidu.searchbox.looper.ioc.ILooperRegister;
import com.baidu.searchbox.ruka.Ruka;
import com.baidu.searchbox.ruka.basic.RukaTrackUIUtil;
import com.baidu.searchbox.ruka.ioc.Constant;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.ubc.UBCManager;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UBCLooperRegister extends ILooperRegister {
    public static String KEY_BLOCK_ACTIVE_UPLOAD = "key_block_active_upload";
    private static final String KEY_EXT = "ext";
    private static final String TAG = "UBCLooperRegister";
    private static final String UBC_BLOCK = "1157";
    private static final int UI_TRACE_MAX_SIZE = 20;
    public static boolean sEnable = QuickPersistConfig.getInstance().getBoolean(KEY_BLOCK_ACTIVE_UPLOAD, false);
    private String separator = "\r\n";

    public boolean checkEnable() {
        return sEnable;
    }

    public void onBlock(Context context, LooperBlock looperBlock) {
        if (sEnable) {
            if (AppConfig.isDebug()) {
                Log.d(TAG, "UBCLooperRegister, sEnable = true, write LooperBlock into UBC");
            }
            JSONObject result = new JSONObject();
            try {
                result.put("memory", CommonUtils.getMemoryInfo());
                String appVersion = CommonUtils.getAppVersion();
                if (appVersion != null) {
                    result.put("appversion", appVersion);
                }
                String sdkVersion = CommonUtils.getSDKVersion(Constant.KEY_RUKA_CONFIG);
                if (sdkVersion != null) {
                    result.put("sdkversion", sdkVersion);
                }
                String cpu = CommonUtils.getCPUInfo();
                if (cpu != null) {
                    result.put("cpu", cpu);
                }
                result.put("root", CommonUtils.getRootedInfo());
                result.put("emulator", CommonUtils.getEmulator());
                result.put("inStorage", CommonUtils.getInStorage());
                result.put("exStorage", CommonUtils.getExStorage());
                result.put("heap", CommonUtils.getHeapInfo());
                result.put("sysMem", CommonUtils.getSysMem());
                result.put("isLowMemory", CommonUtils.isLowMemory());
                result.put("VSSRSS", CommonUtils.getVSSRSS());
                result.put("PSS", CommonUtils.getPSS());
                result.put("procBit", CommonUtils.getProcessBit());
                result.put("ROM", CommonUtils.getROM());
                if (Ruka.getLineMappingMode() >= 0) {
                    result.put("linemapping", Ruka.getLineMappingMode());
                }
                IDeviceScore deviceScore = (IDeviceScore) ServiceManager.getService(IDeviceScore.SERVICE_REFERENCE);
                if (deviceScore != null) {
                    try {
                        result.put("devicescore", String.valueOf(deviceScore.getFinalScore(context)));
                    } catch (JSONException e2) {
                        e = e2;
                        e.printStackTrace();
                    }
                } else {
                    Context context2 = context;
                }
                String network = CommonUtils.getNetwork();
                if (network != null) {
                    result.put("network", network);
                }
                String packageName = CommonUtils.getPackageName();
                if (packageName != null) {
                    result.put("packagename", packageName);
                }
                IDyeConfig dyeConfig = DyeConfigManager.getDyeConfig();
                if (dyeConfig != null && !TextUtils.isEmpty(dyeConfig.getDyeConfig())) {
                    result.put("configid", dyeConfig.getDyeConfig());
                }
                ILaunchType launchType = LaunchTypeManager.getLaunchType();
                if (launchType != null) {
                    result.put("launchtype", launchType.getLaunchType());
                }
                result.put("launchTime", String.valueOf(Ruka.getInitTime()));
                result.put("logid", looperBlock.getLogID());
                result.put("page", looperBlock.getCurrentPage());
                result.put("cpuusage", looperBlock.getCpuRateInfo());
                result.put("duration", looperBlock.getDuration());
                result.put("type", looperBlock.getType());
                result.put(Constant.KEY_TIME_COST_START, looperBlock.getStartLagTime());
                result.put(Constant.KEY_TIME_COST_END, looperBlock.getEndLagTime());
                String stack = looperBlock.getStackSb().toString();
                if (AppConfig.isDebug()) {
                    String str = appVersion;
                    Log.d(TAG, "stack format before: " + stack);
                }
                String[] stackSplit = stack.split(this.separator + this.separator);
                if (stackSplit.length > 0) {
                    String stackTime = stackSplit[0];
                    if (stackTime.length() <= 0 || !stackTime.contains("stack = ")) {
                        String str2 = sdkVersion;
                    } else {
                        String[] strArr = stackSplit;
                        String str3 = sdkVersion;
                        stack = "Looper" + looperBlock.getStackSb().toString().replace(stackTime, "");
                    }
                } else {
                    String str4 = sdkVersion;
                }
                result.put("stacktrace", stack);
                if (AppConfig.isDebug()) {
                    Log.d(TAG, "stack format after: " + stack);
                }
                LinkedList<TrackUI> trackUIs = looperBlock.getTrackUIs();
                if (trackUIs == null || trackUIs.size() <= 0) {
                    String str5 = cpu;
                    IDeviceScore iDeviceScore = deviceScore;
                    String str6 = network;
                } else {
                    JSONArray pageArrays = new JSONArray();
                    int index = trackUIs.size() - 1;
                    int index2 = 1;
                    while (true) {
                        TrackUI trackUI = trackUIs.get(index);
                        LinkedList<TrackUI> trackUIs2 = trackUIs;
                        String cpu2 = cpu;
                        IDeviceScore deviceScore2 = deviceScore;
                        String network2 = network;
                        JSONObject track = new JSONObject();
                        track.put("time", trackUI.getTimeStamp());
                        track.put("page", RukaTrackUIUtil.trackUI2StringPage(trackUI));
                        track.put("event", trackUI.getEvent());
                        pageArrays.put(track);
                        int count = index2 + 1;
                        if (index2 >= 20) {
                            break;
                        }
                        int index3 = index - 1;
                        if (index <= 0) {
                            int i2 = index3;
                            break;
                        }
                        index = index3;
                        cpu = cpu2;
                        deviceScore = deviceScore2;
                        network = network2;
                        index2 = count;
                        trackUIs = trackUIs2;
                    }
                    result.put("pageTrace", pageArrays);
                }
                JSONObject content = new JSONObject();
                content.put("ext", result);
                UBCManager ubc = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                if (ubc != null) {
                    ubc.onEvent("1157", content);
                }
            } catch (JSONException e3) {
                e = e3;
                Context context3 = context;
                e.printStackTrace();
            }
        } else if (AppConfig.isDebug()) {
            Log.d(TAG, "UBCLooperRegister, sEnable = false");
        }
    }
}
