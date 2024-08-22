package com.baidu.swan.apps.core.master.isolation;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.core.container.JSContainer;
import com.baidu.swan.apps.core.master.SwanAppMasterContainer;
import com.baidu.swan.apps.core.master.isolation.codecache.PresetCodeCacheManager;
import com.baidu.swan.apps.engine.AiBaseV8Engine;
import com.baidu.swan.apps.prepose.util.SwanAppDebugUtil;
import com.baidu.swan.apps.runtime.SwanApp;

public class MasterIsolationHelper {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String TAG = "MasterIsolationHelper";

    public static boolean intercept(JSContainer container, String apiName) {
        BasePreloadMasterManager manager;
        if (DEBUG) {
            Log.d(TAG, "JS CALL - " + apiName);
        }
        if (SwanAppDebugUtil.isLocalDebug() || container == null || TextUtils.isEmpty(container.getContainerId())) {
            return false;
        }
        if (PresetCodeCacheManager.get().isCodeCacheFillMaster(container.getContainerId())) {
            return true;
        }
        String containerId = container.getContainerId();
        if (MasterIdGenerator.isMasterId(containerId) && SwanApp.getOrNull() != null && isSwanV8Master(container) && (manager = MasterRecorder.getInstance().getCurrent()) != null) {
            SwanAppMasterContainer master = manager.getMaster();
            SwanAppMasterContainer master2 = master;
            if (master != null) {
                boolean needIntercept = !TextUtils.equals(master2.getWebViewId(), container.getContainerId());
                if (needIntercept) {
                    SwanAppLog.w(TAG, "master id - " + containerId + ", can not call API - " + apiName + ", intercept for preload/prefetch");
                }
                return needIntercept;
            }
        }
        return false;
    }

    private static boolean isSwanV8Master(JSContainer container) {
        return (container instanceof AiBaseV8Engine) && ((AiBaseV8Engine) container).getInvokeSourceType() == 0;
    }
}
