package com.baidu.swan.apps.core.preset;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.install.SwanAppBundleHelper;
import com.baidu.swan.apps.install.decrypt.BundleDecrypt;
import com.baidu.swan.apps.ioc.SwanGameRuntime;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.SwanAppPerformanceUBC;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.util.SwanAppExecutorUtils;
import com.baidu.swan.apps.util.SwanAppJSONUtils;
import com.baidu.swan.apps.util.SwanAppSignChecker;
import com.baidu.swan.pms.database.PMSDB;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.utils.PMSJsonParser;
import com.baidu.swan.utils.SwanAppFileUtils;
import com.baidu.swan.utils.SwanAppStreamUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

abstract class PresetController {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String KEY_BUNDLE_NAME = "bundle_name";
    private static final String KEY_PKG_TYPE = "pkg_type";
    private static final String KEY_PRESET_LIST = "list";
    private static final String TAG = "PresetController";

    /* access modifiers changed from: protected */
    public abstract boolean doUnzipBundle(PresetInfo presetInfo);

    /* access modifiers changed from: protected */
    public abstract String getAppInfoJsonStr(String str);

    /* access modifiers changed from: protected */
    public abstract String getPresetListJsonStr();

    PresetController() {
    }

    public HashMap<String, PresetInfo> getPresetInfoMap() {
        JSONArray presetArray;
        String jsonString = getPresetListJsonStr();
        if (TextUtils.isEmpty(jsonString) || (presetArray = SwanAppJSONUtils.parseString(jsonString).optJSONArray("list")) == null) {
            return null;
        }
        HashMap<String, PresetInfo> hashMap = new HashMap<>();
        for (int i2 = 0; i2 < presetArray.length(); i2++) {
            PresetInfo info = parsePresetInfo(presetArray.optJSONObject(i2));
            if (info != null) {
                hashMap.put(info.bundleId, info);
            }
        }
        return hashMap;
    }

    public void loadPresetApp(final PresetInfo presetInfo, final PresetLoadCallback callback) {
        final HybridUbcFlow flow = SwanAppPerformanceUBC.requireSession("startup");
        flow.record(new UbcFlowEvent("loadPresetApp-start").justLocalRecord(true));
        if (callback != null) {
            if (presetInfo == null) {
                callback.onFailed(0);
                return;
            }
            SwanAppExecutorUtils.postOnIO(new Runnable() {
                public void run() {
                    flow.record(new UbcFlowEvent("loadPresetApp#run-start").justLocalRecord(true));
                    String jsonStr = PresetController.this.getAppInfoJsonStr(presetInfo.bundleId);
                    if (TextUtils.isEmpty(jsonStr)) {
                        callback.onFailed(0);
                        return;
                    }
                    JSONObject appInfoJson = SwanAppJSONUtils.parseString(jsonStr);
                    flow.record(new UbcFlowEvent("loadPresetApp#run-appInfoJson").justLocalRecord(true));
                    PMSAppInfo appInfo = PresetController.this.parseAppInfo(presetInfo, appInfoJson);
                    if (appInfo == null) {
                        callback.onFailed(1);
                        return;
                    }
                    flow.record(new UbcFlowEvent("loadPresetApp#run-PMSAppInfo").justLocalRecord(true));
                    callback.onAppInfoUpdate(appInfo);
                    long startTime = System.currentTimeMillis();
                    boolean result = PresetController.this.doUnzipBundle(presetInfo);
                    if (PresetController.DEBUG) {
                        Log.d(PresetController.TAG, "签名+解压 耗时：" + (System.currentTimeMillis() - startTime));
                    }
                    flow.record(new UbcFlowEvent("loadPresetApp#run-doUnzipBundle").justLocalRecord(true));
                    if (result) {
                        appInfo.setOrientation(PresetController.this.getOrientation(presetInfo.category, presetInfo.bundleId, presetInfo.versionCode));
                        appInfo.updateInstallSrc(3);
                        PMSDB.getInstance().bulkInsert(presetInfo, appInfo);
                        flow.record(new UbcFlowEvent("loadPresetApp#run-bulkInsert").justLocalRecord(true));
                        callback.onSuccess(appInfo);
                    } else {
                        callback.onFailed(2);
                    }
                    flow.record(new UbcFlowEvent("loadPresetApp#run-return").justLocalRecord(true));
                }
            }, "加载小程序预置包");
            flow.record(new UbcFlowEvent("loadPresetApp-return").justLocalRecord(true));
        }
    }

    /* access modifiers changed from: private */
    public int getOrientation(int category, String bundleId, long versionCode) {
        if (category == 1) {
            return SwanGameRuntime.getSwanGameCoreManager().getSwanGameConfigOrientation(bundleId, versionCode);
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public PMSAppInfo parseAppInfo(PresetInfo presetInfo, JSONObject appInfoJson) {
        PMSAppInfo appInfo;
        if (appInfoJson == null || presetInfo == null || (appInfo = PMSJsonParser.parseAppInfo(appInfoJson)) == null) {
            return null;
        }
        appInfo.copyMainPkgInfo(presetInfo);
        appInfo.createTime = System.currentTimeMillis();
        return appInfo;
    }

    private PresetInfo parsePresetInfo(JSONObject info) {
        PresetInfo presetInfo;
        if (info == null || (presetInfo = (PresetInfo) PMSJsonParser.parsePackage(info, new PresetInfo())) == null) {
            return null;
        }
        presetInfo.pkgType = info.optInt("pkg_type");
        presetInfo.bundleName = info.optString(KEY_BUNDLE_NAME);
        if (!presetInfo.checkValid()) {
            return null;
        }
        return presetInfo;
    }

    /* access modifiers changed from: protected */
    public File getUnzipDir(int category, String bundleId, long versionCode) {
        if (category == 0) {
            return SwanAppBundleHelper.ReleaseBundleHelper.getUnzipFolder(bundleId, String.valueOf(versionCode));
        }
        if (category == 1) {
            return SwanGameRuntime.getSwanGameBundleManager().getUnzipFolder(bundleId, String.valueOf(versionCode));
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean unzipOrDecryptBundle(BufferedInputStream inputStream, File unzipDir) {
        if (inputStream == null || unzipDir == null) {
            return false;
        }
        try {
            BundleDecrypt.DecryptTypeResult typeResult = BundleDecrypt.getDecryptType(inputStream);
            if ((typeResult == null || typeResult.type == -1) ? false : true) {
                return BundleDecrypt.decrypt(inputStream, unzipDir, typeResult.type).isSuccess;
            }
            boolean streamToUnzipFile = SwanAppStreamUtils.streamToUnzipFile(inputStream, unzipDir.getPath());
            SwanAppFileUtils.closeSafely(inputStream);
            return streamToUnzipFile;
        } catch (IOException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
            return false;
        } finally {
            SwanAppFileUtils.closeSafely(inputStream);
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkSign(ReadableByteChannel source, String sign) {
        if (source == null || TextUtils.isEmpty(sign)) {
            return false;
        }
        try {
            long startTime = System.currentTimeMillis();
            boolean result = SwanAppSignChecker.checkZipSign(source, sign);
            if (DEBUG) {
                Log.d(TAG, "签名校验结果：" + result + " ,耗时：" + (System.currentTimeMillis() - startTime));
            }
            return result;
        } catch (IOException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
            return false;
        } finally {
            SwanAppFileUtils.closeSafely(source);
        }
    }
}
