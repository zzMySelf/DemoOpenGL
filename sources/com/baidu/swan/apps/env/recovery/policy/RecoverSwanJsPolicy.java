package com.baidu.swan.apps.env.recovery.policy;

import com.baidu.swan.apps.env.recovery.model.SwanRecoveryModel;
import com.baidu.swan.apps.extcore.SwanExtensionCoreManager;
import com.baidu.swan.apps.extcore.model.base.SwanAppBaseExtensionCoreInfo;
import com.baidu.swan.apps.extcore.utils.ExtensionCoreUtils;
import com.baidu.swan.apps.swancore.SwanAppSwanCoreManager;
import com.baidu.swan.apps.swancore.preset.PresetSwanCoreControl;
import com.baidu.swan.apps.swancore.remote.RemoteSwanCoreControl;
import com.baidu.swan.utils.SwanAppFileUtils;

public class RecoverSwanJsPolicy extends DefaultRecoveryPolicy {
    public RecoverSwanJsPolicy(SwanRecoveryModel model) {
        super(model);
    }

    /* access modifiers changed from: protected */
    public void onRecovery() {
        killAllSwanProgress();
        resetSwanJs();
        resetExtensionJs();
    }

    private void resetSwanJs() {
        RemoteSwanCoreControl.clearCurRemoteVersion(0);
        PresetSwanCoreControl.clearCurPresetVersion(0);
        PresetSwanCoreControl.setNeedUpdateFlag(true, 0);
        SwanAppFileUtils.safeDeleteFile(SwanAppSwanCoreManager.getSwanCoreBaseDir(0));
    }

    private void resetExtensionJs() {
        SwanExtensionCoreManager.getInstance(0).getRemoteExtCoreControl().clearCurExtensionCoreVersion();
        SwanExtensionCoreManager.getInstance(0).getPresetExtCoreControl().clearCurExtensionCoreVersion();
        ExtensionCoreUtils.setIsNeedUpdatePreset(0, true);
        SwanAppFileUtils.safeDeleteFile(SwanAppBaseExtensionCoreInfo.EXTENSION_CORE_ROOT_DIR);
    }
}
