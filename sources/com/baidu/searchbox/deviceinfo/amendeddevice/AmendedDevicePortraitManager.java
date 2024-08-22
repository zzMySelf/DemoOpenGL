package com.baidu.searchbox.deviceinfo.amendeddevice;

import android.content.Context;
import com.baidu.searchbox.aideviceperformance.amendeddevicescore.IAmendedDeviceScoreManager;
import com.baidu.searchbox.aideviceperformanceboxproxy.amendedstaticscore.AmendedDeviceScoreManagerSingleton;
import com.baidu.searchbox.config.AppConfig;

public class AmendedDevicePortraitManager implements IAmendedDeviceScoreManager {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "AmendedDevicePortraitManager";
    private static AmendedDevicePortraitManager sInstance = new AmendedDevicePortraitManager();
    private IAmendedDeviceScoreManager baseManager = AmendedDeviceScoreManagerSingleton.getInstance();

    public static AmendedDevicePortraitManager getInstance() {
        return sInstance;
    }

    private AmendedDevicePortraitManager() {
    }

    public float getAmendedDeviceScore(Context cx) {
        return this.baseManager.getAmendedDeviceScore(cx);
    }

    public long getModelVersion() {
        return this.baseManager.getModelVersion();
    }
}
