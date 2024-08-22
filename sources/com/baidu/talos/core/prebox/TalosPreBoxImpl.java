package com.baidu.talos.core.prebox;

import android.app.Application;
import android.os.Build;
import com.baidu.talos.ITalosPreBox;
import com.baidu.talos.TalosAdapterManager;
import com.baidu.talos.TalosRuntimeInitParams;
import com.baidu.talos.adapter.ITalosDTConfigAdapter;
import com.baidu.talos.core.RNConfig;
import com.baidu.talos.core.runtime.CommonRuntimeManager;
import com.baidu.talos.jsengine.JsEngineType;
import com.baidu.talos.jsengine.JsEngineTypeManager;
import com.baidu.talos.tracelog.TalosYaLogger;

public class TalosPreBoxImpl implements ITalosPreBox {
    public void preCodeCache(String mainBizName, String subBizName, String subBizV) {
        if (RNConfig.talosDevPreBoxCloseEnable() || Build.VERSION.SDK_INT <= 21 || !checkZeusSo()) {
            return;
        }
        if (!TalosAdapterManager.getDTConfigAdapter().getSwitch(ITalosDTConfigAdapter.PRECOMPILE_BUNDLE_KEY, mainBizName, subBizName, true)) {
            TalosYaLogger.yaLogD(ITalosDTConfigAdapter.TAG, "precompile " + mainBizName + " " + subBizName + " is disabled");
        } else {
            PreCodeCacheManager.preCodeCache(mainBizName, subBizName, subBizV);
        }
    }

    public void removeCodeCache(String mainBizName, String subBizName, String subBizV) {
        if (!RNConfig.talosDevPreBoxCloseEnable() && Build.VERSION.SDK_INT > 21 && checkZeusSo()) {
            PreCodeCacheManager.removeCodeCache(mainBizName, subBizName, subBizV);
        }
    }

    public void preLoadModule(String packageName, String moudleName) {
        preLoadModule(packageName, moudleName, JsEngineType.V8);
    }

    public void preLoadModule(String packageName, String moudleName, JsEngineType jsEngineType) {
        if (!RNConfig.talosDevPreBoxCloseEnable() && jsEngineType != null) {
            JsEngineType jsEngineType2 = JsEngineTypeManager.getAndCheckJSEngineType(jsEngineType);
            if (jsEngineType2 == JsEngineType.V8 && !checkZeusSo()) {
                return;
            }
            if (!TalosAdapterManager.getDTConfigAdapter().getSwitch(ITalosDTConfigAdapter.PRELOAD_BUNDLE_KEY, packageName, moudleName, true)) {
                TalosYaLogger.yaLogD(ITalosDTConfigAdapter.TAG, "preLoadModule " + packageName + " " + moudleName + " is disabled");
            } else {
                PreLoadBundleManager.loadBundle(packageName, moudleName, jsEngineType2);
            }
        }
    }

    public void preHeatRuntime(Application application, TalosRuntimeInitParams initParams, JsEngineType jsEngineType) {
        RNConfig.talosDevPreBoxCloseEnable();
    }

    public void preHeatRuntime(Application application, TalosRuntimeInitParams initParams) {
    }

    public void preHeatRuntimes(JsEngineType jsEngineType) {
        if (!RNConfig.talosDevPreBoxCloseEnable() && jsEngineType != null) {
            JsEngineType jsEngineType2 = JsEngineTypeManager.getAndCheckJSEngineType(jsEngineType);
            if (jsEngineType2 == JsEngineType.V8 && !checkZeusSo()) {
                return;
            }
            if (jsEngineType2 == JsEngineType.QUICKJS) {
                CommonRuntimeManager.getInstance().preHeatQuickjsRuntime();
            } else {
                CommonRuntimeManager.getInstance().preHeatV8Runtime();
            }
        }
    }

    private boolean checkZeusSo() {
        if (TalosAdapterManager.getV8Adapter().isV8Preset()) {
            return true;
        }
        return TalosAdapterManager.getV8Adapter().isLoadV8Success();
    }
}
