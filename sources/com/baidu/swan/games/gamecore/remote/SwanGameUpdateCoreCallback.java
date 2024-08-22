package com.baidu.swan.games.gamecore.remote;

import android.util.Log;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.core.pms.UpdateCoreCallback;
import com.baidu.swan.apps.core.pms.util.PkgDownloadUtil;
import com.baidu.swan.apps.extcore.SwanExtensionCoreManager;
import com.baidu.swan.apps.extcore.model.ExtensionCoreUpdateInfo;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.swancore.remote.RemoteSwanCoreControl;
import com.baidu.swan.apps.trace.ErrCode;
import com.baidu.swan.apps.util.typedbox.TypedCallback;
import com.baidu.swan.pms.PMSDownloadType;
import com.baidu.swan.pms.model.PMSExtension;
import com.baidu.swan.pms.model.PMSFramework;
import com.baidu.swan.utils.SwanAppFileUtils;

public class SwanGameUpdateCoreCallback extends UpdateCoreCallback {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String TAG = "SwanGameUpdateCore";

    public SwanGameUpdateCoreCallback(TypedCallback<Exception> finalCallback) {
        super(finalCallback);
    }

    /* access modifiers changed from: protected */
    public int getCategory() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public PMSDownloadType getDownloadType() {
        return PMSDownloadType.SWAN_GAME_UPDATE_CORE;
    }

    /* access modifiers changed from: protected */
    public String getFrameworkDownloadPath() {
        return PkgDownloadUtil.getGameCoreDownloadPath();
    }

    /* access modifiers changed from: protected */
    public String getExtensionDownloadPath() {
        return PkgDownloadUtil.getGameExtensionDownloadPath();
    }

    /* access modifiers changed from: protected */
    public ErrCode onFrameworkDownloadFinish(PMSFramework framework) {
        boolean z = DEBUG;
        if (z) {
            Log.d(TAG, "onFrameworkDownloadFinish framework = " + framework);
        }
        if (framework == null) {
            return new ErrCode().feature(13).code(2907).desc("小游戏GameCore包 Framework null");
        }
        RemoteSwanCoreControl.RemoteCoreUpdateStatus status = RemoteSwanCoreControl.doRemoteUpdate(framework, 1);
        SwanAppFileUtils.deleteFile(framework.filePath);
        if (!status.isOk()) {
            return new ErrCode().feature(13).code(2907).desc("小游戏GameCore包更新失败");
        }
        if (z) {
            Log.d(TAG, "小游戏GameCore解压成功");
        }
        long swanVersion = RemoteSwanCoreControl.getCurRemoteVersionCode(1);
        if (swanVersion <= 0) {
            return null;
        }
        SwanAppMessengerService.sendMessageWithDataToAllClient(117, swanVersion);
        return null;
    }

    /* access modifiers changed from: protected */
    public ErrCode onExtensionDownloadFinish(PMSExtension extension) {
        if (extension == null) {
            return new ErrCode().feature(14).code(2908).desc("小游戏Extension包 Extension null");
        }
        ExtensionCoreUpdateInfo updateInfo = new ExtensionCoreUpdateInfo();
        updateInfo.versionCode = extension.versionCode;
        updateInfo.versionName = extension.versionName;
        updateInfo.coreFilePath = extension.filePath;
        updateInfo.sign = extension.sign;
        boolean status = true;
        if (SwanExtensionCoreManager.doRemoteUpdate(1, updateInfo) != null) {
            status = false;
        }
        if (!status) {
            return new ErrCode().feature(14).code(2908).desc("小游戏Extension包更新失败");
        }
        if (!DEBUG) {
            return null;
        }
        Log.i(TAG, "小游戏Extension包解压成功");
        return null;
    }
}
