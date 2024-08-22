package com.baidu.nadcore.util;

import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.nadcore.core.AdRuntime;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.AdDownloadInfo;
import com.baidu.nadcore.model.MonitorUrl;
import com.baidu.nadcore.utils.UrlUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdDataReduceUtil {
    private static final String TAG = "AdDataReduceUtil";
    private static final String TAG_AD_AUTO_INVOKE = "__AUTO_INVOKE__";
    private static final String TAG_AD_EXT_0 = "__AD_EXTRA_PARAM_ENCODE_0__";
    private static final String TAG_AD_EXT_1 = "__AD_EXTRA_PARAM_ENCODE_1__";
    private static final String TAG_AD_EXT_2 = "__AD_EXTRA_PARAM_ENCODE_2__";
    private static final String TAG_AD_EXT_3 = "__AD_EXTRA_PARAM_ENCODE_3__";
    private static final HashMap<String, Integer> TAG_MAP;

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        TAG_MAP = hashMap;
        hashMap.put("__AD_EXTRA_PARAM_ENCODE_0__", 0);
        hashMap.put("__AD_EXTRA_PARAM_ENCODE_1__", 1);
        hashMap.put("__AD_EXTRA_PARAM_ENCODE_2__", 2);
        hashMap.put("__AD_EXTRA_PARAM_ENCODE_3__", 3);
    }

    private static String getFeedAdExt(AdBaseModel model) {
        if (model == null || model.common.extraParam == null) {
            return null;
        }
        return model.common.extraParam;
    }

    public static boolean shouldReplaceExt(String source) {
        if (TextUtils.isEmpty(source)) {
            return false;
        }
        for (Map.Entry<String, Integer> entry : TAG_MAP.entrySet()) {
            if (source.contains(entry.getKey())) {
                return true;
            }
        }
        return false;
    }

    private static String encodeExtMulti(String replaceExt, int count) {
        if (count <= 0) {
            return replaceExt;
        }
        for (int i2 = 0; i2 < count; i2++) {
            replaceExt = Uri.encode(replaceExt);
        }
        return replaceExt;
    }

    public static String replaceExt(String source, String replacement) {
        if (source == null || replacement == null) {
            return source;
        }
        for (Map.Entry<String, Integer> entry : TAG_MAP.entrySet()) {
            if (source.contains(entry.getKey())) {
                try {
                    source = source.replaceAll(entry.getKey(), encodeExtMulti(replacement, entry.getValue().intValue()));
                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e2) {
                }
            }
        }
        return source;
    }

    public static void replaceDataCmdExt(AdBaseModel model) {
        if (!TextUtils.isEmpty(model.common.scheme)) {
            String cmd = model.common.scheme;
            model.common.scheme = replaceCmd(model, cmd);
        }
    }

    private static void replaceDeferredCmdExt(AdBaseModel model) {
        if (model.downloadInfo != null && model.downloadInfo.deferredCmd != null) {
            String deferredCmd = model.downloadInfo.deferredCmd;
            model.downloadInfo.deferredCmd = replaceCmd(model, deferredCmd);
        }
    }

    public static void replaceButtonCmdExt(AdBaseModel model) {
        if (model.hasOperator && !TextUtils.isEmpty(model.operator.btnScheme)) {
            String cmd = model.operator.btnScheme;
            model.operator.btnScheme = replaceCmd(model, cmd);
        }
    }

    public static String replaceCmd(AdBaseModel model, String cmd) {
        if (!shouldReplaceExt(cmd)) {
            return cmd;
        }
        String extraParam = getFeedAdExt(model);
        if (!TextUtils.isEmpty(extraParam)) {
            return replaceExt(cmd, extraParam);
        }
        return cmd;
    }

    public static void preProcessCmd(AdBaseModel model) {
        replaceCmdExts(model);
        replaceDeferredCmd(model);
    }

    public static void replaceCmdExts(AdBaseModel model) {
        replaceDataCmdExt(model);
        replaceButtonCmdExt(model);
        replaceDeferredCmdExt(model);
    }

    public static void replaceDeferredCmd(AdBaseModel model) {
        if (model.downloadInfo != null && model.downloadInfo.isValid) {
            String deferredCmd = model.downloadInfo.deferredCmd;
            if (deferredCmd.contains(TAG_AD_AUTO_INVOKE)) {
                model.downloadInfo.deferredCmd = deferredCmd.replace(TAG_AD_AUTO_INVOKE, hasInstalled(model.downloadInfo.apkName) ? "0" : "1");
            }
        }
    }

    public static String getAdCmd(AdBaseModel data, String cmd) {
        if (data.downloadInfo == null || !data.downloadInfo.isValid) {
            return cmd;
        }
        AdDownloadInfo adDownload = data.downloadInfo;
        String openAppOrDeepLinkCmd = "";
        String pkgName = adDownload.apkName;
        if (TextUtils.isEmpty(pkgName)) {
            return cmd;
        }
        boolean hasInstalledApp = hasInstalled(pkgName);
        String deferredCmd = adDownload.deferredCmd;
        if (hasInstalledApp) {
            if (TextUtils.isEmpty(deferredCmd)) {
                return cmd;
            }
            openAppOrDeepLinkCmd = deferredCmd;
        }
        return TextUtils.isEmpty(openAppOrDeepLinkCmd) ? cmd : openAppOrDeepLinkCmd;
    }

    public static boolean hasInstalled(String pkgName) {
        try {
            AdRuntime.applicationContext().getPackageManager().getApplicationInfo(pkgName, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            return false;
        } catch (Exception e3) {
            return false;
        }
    }

    public static String getAutoPopCmd(String cmd, Long chargeDelayTime, List<MonitorUrl> monitorUrls) {
        String cmd2 = UrlUtil.addParam(UrlUtil.addParam(cmd, "auto_pop", "1"), "charge_delay_time", String.valueOf(chargeDelayTime));
        if (monitorUrls != null) {
            for (MonitorUrl m : monitorUrls) {
                if (m != null && !TextUtils.isEmpty(m.clickUrl)) {
                    cmd2 = UrlUtil.addParam(cmd2, "charge_url", m.clickUrl);
                }
            }
        }
        return cmd2;
    }

    public static String getFormAutoPopCmd(String cmd, Long chargeDelayTime, List<MonitorUrl> monitorUrls) {
        String cmd2 = UrlUtil.addParam(UrlUtil.addParam(cmd, "auto_pop", "0"), "charge_delay_time", String.valueOf(chargeDelayTime));
        if (monitorUrls != null) {
            for (MonitorUrl m : monitorUrls) {
                if (m != null && !TextUtils.isEmpty(m.clickUrl)) {
                    cmd2 = UrlUtil.addParam(cmd2, "charge_url", m.clickUrl);
                }
            }
        }
        return cmd2;
    }
}
