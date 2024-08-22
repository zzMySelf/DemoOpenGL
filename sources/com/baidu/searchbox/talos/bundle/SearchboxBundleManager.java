package com.baidu.searchbox.talos.bundle;

import android.os.Build;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.reactnative.bundles.clean.OEMCleanManager;
import com.baidu.searchbox.talos.TalosBDCustomViewAdapter;
import com.baidu.talos.ITalosBundleManager;
import com.baidu.talos.TalosAdapterManager;
import com.baidu.talos.TalosManager;
import com.baidu.talos.adapter.CustomViewAdapter;
import com.baidu.talos.core.deploy.BundleCleanManager;
import com.baidu.talos.core.deploy.data.BundlePackageVersionInfo;
import com.baidu.talos.core.deploy.model.BundleLocalManager;
import com.baidu.talos.so.V8LoadStatusListener;
import com.baidu.talos.tracelog.LogParams;
import com.baidu.talos.tracelog.TalosYaLogger;
import com.baidu.talos.util.LogUtils;
import org.json.JSONArray;

public class SearchboxBundleManager implements ITalosBundleManager {
    private static final Boolean DEBUG = Boolean.valueOf(LogUtils.isDebug);
    private static final int MAX_DOWNLOAD_ZEUS_SO_RETRY_COUNT = 2;
    private static final String TAG = "SearchboxBundleManager";
    private int zeusSoRetryCount = 0;

    public void onApplicationCreate() {
        registerCustomVieAdapter();
    }

    public void initBundles() {
        this.zeusSoRetryCount = 0;
        if (Build.VERSION.SDK_INT > 21) {
            if (!TalosAdapterManager.getV8Adapter().isV8Preset()) {
                TalosYaLogger.yaLogD(LogParams.TAG_LOADZEUSSO, "V8统一: initBundles start tryToDownloadAndLoadV8So()");
                TalosAdapterManager.getV8Adapter().tryToDownloadAndLoadV8So(getClass().getClassLoader(), AppRuntime.getApplication(), new V8LoadStatusListener() {
                    public void onloadV8Success() {
                        TalosYaLogger.yaLogD(LogParams.TAG_LOADZEUSSO, "V8统一加载成功 在SearchboxBundleManager#initBundles()中");
                        SearchboxBundleManager.this.initBundlesInner();
                    }

                    public void onLoadV8Fail(String msg) {
                        TalosYaLogger.yaLogD(LogParams.TAG_LOADZEUSSO, "V8统一加载失败 在SearchboxBundleManager#initBundles()中： " + msg);
                    }
                });
                return;
            }
            initBundlesInner();
        }
    }

    public String getBundleCurrentVersion(String bundleId) {
        if (DEBUG.booleanValue()) {
            Log.d("talos_init", "getBundleCurrentVersion");
        }
        return TalosManager.getPackageManager().getCurrentHNBundleVersion(bundleId);
    }

    public JSONArray getAllBundleCurrentVersion() {
        if (DEBUG.booleanValue()) {
            Log.d("talos_init", "getAllBundleCurrentVersion");
        }
        return TalosManager.getPackageManager().getAllBundleCurrentVersion();
    }

    public String isDevForCurBundle(String bundleId) {
        BundlePackageVersionInfo packageVersionInfo = BundleLocalManager.getInstance().getBundlePackageVersionInfo(bundleId);
        return packageVersionInfo == null ? "" : packageVersionInfo.isDev;
    }

    public void manualClean() {
        BundleCleanManager.getInstance().cleanNewCodeCacheDir();
    }

    /* access modifiers changed from: private */
    public void initBundlesInner() {
        TalosManager.getPackageManager().installPresetBundles();
        TalosManager.getRuntimePreloader().preHeatRuntimes();
        if (TalosAdapterManager.getV8Adapter().isV8Preset()) {
            OEMCleanManager.getInstance().cleanOEMLibDir();
        }
    }

    private void registerCustomVieAdapter() {
        TalosAdapterManager.registerCustomView(CustomViewAdapter.DEFAULT_SOURCE, new TalosBDCustomViewAdapter());
    }
}
