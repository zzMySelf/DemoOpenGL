package com.baidu.swan.apps.core.master.isolation.multi;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.core.master.isolation.BasePreloadMasterManager;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;

public class PreloadMasterManagerMulti extends BasePreloadMasterManager {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String TAG = "PreloadMasterManagerMulti";

    PreloadMasterManagerMulti(boolean isDefault, boolean isV8) {
        super(isDefault, isV8);
        if (DEBUG) {
            Log.d(TAG, "PreloadMasterManagerMulti created");
        }
    }

    public boolean shouldUseNewEnv(PMSAppInfo currentAppInfo, PrefetchEvent.PrefetchMessage currentMsg) {
        if (this.mPrefetchTag == null || this.mPrefetchTag.pmsInfo == null) {
            return false;
        }
        if (currentAppInfo.versionCode != this.mPrefetchTag.pmsInfo.versionCode || !TextUtils.equals(currentAppInfo.appId, this.mPrefetchTag.appId) || isDynamicLibChange(currentMsg, this.mPrefetchTag.msg)) {
            return true;
        }
        return false;
    }
}
