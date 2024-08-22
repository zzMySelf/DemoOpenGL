package com.baidu.swan.games.extcore;

import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.extcore.SwanAppExtensionCoreManager;
import com.baidu.swan.apps.extcore.base.SwanBaseExtensionCoreManager;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.games.extcore.debug.DebugGameExtensionCoreControl;
import com.baidu.swan.games.extcore.preset.SwanGamePresetExtensionCoreControl;
import com.baidu.swan.games.extcore.remote.SwanGameRemoteExtensionCoreControl;

public class SwanGameExtensionCoreManager extends SwanBaseExtensionCoreManager<SwanGamePresetExtensionCoreControl, SwanGameRemoteExtensionCoreControl> {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String TAG = "ExtCore-GamesManager";
    private static volatile SwanGameExtensionCoreManager sInstance;

    public static SwanGameExtensionCoreManager getInstance() {
        if (sInstance == null) {
            synchronized (SwanGameExtensionCoreManager.class) {
                if (sInstance == null) {
                    sInstance = new SwanGameExtensionCoreManager();
                }
            }
        }
        return sInstance;
    }

    private SwanGameExtensionCoreManager() {
        super(new SwanGamePresetExtensionCoreControl(), new SwanGameRemoteExtensionCoreControl());
    }

    public ExtensionCore getExtensionCore() {
        if (ProcessUtils.isMainProcess()) {
            return getExtensionCoreInMainProcess();
        }
        Bundle bundle = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), GetGameExtensionCoreDelegation.class, (Bundle) null).mResult;
        bundle.setClassLoader(ExtensionCore.class.getClassLoader());
        ExtensionCore extensionCore = (ExtensionCore) bundle.getParcelable(SwanAppExtensionCoreManager.GetExtensionCoreDelegation.BUNDLE_KEY_EXTENSION_CORE);
        if (DEBUG) {
            Log.d(TAG, "getExtensionCore:" + ProcessUtils.getCurProcessName() + " extension core: " + extensionCore);
        }
        return extensionCore;
    }

    public String getDebugExtensionCoreDirFile(int frameType) {
        if (frameType == 1) {
            return DebugGameExtensionCoreControl.getDebugDirFile().getPath();
        }
        return null;
    }

    private static class GetGameExtensionCoreDelegation extends SwanAppExtensionCoreManager.GetExtensionCoreDelegation {
        private GetGameExtensionCoreDelegation() {
        }

        /* access modifiers changed from: protected */
        public int getFrameType() {
            return 1;
        }
    }
}
