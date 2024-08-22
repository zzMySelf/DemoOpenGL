package com.baidu.common.param;

import android.text.TextUtils;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.common.security.DeviceInfoManager;

public class CustomOSParam {
    private String harmonyInfo;
    private boolean isHarmony;
    private boolean isInit;
    private boolean syncMapping;

    public String getOSInfo() {
        if (!this.isInit) {
            StringBuilder sb = new StringBuilder();
            if (DeviceUtils.isHarmonyOS(AppRuntime.getAppContext())) {
                this.isHarmony = true;
                String version = DeviceInfoManager.INSTANCE.getHarmonyVersion(AppRuntime.getAppContext(), CommonParamRuntime.PARAM_SCENE, "").deviceId;
                if (TextUtils.isEmpty(version)) {
                    version = "0.0";
                }
                sb.append("HMS").append("_").append(version);
            }
            this.harmonyInfo = sb.toString();
            this.isInit = true;
        }
        return this.harmonyInfo;
    }

    public boolean hasSync() {
        if (!this.isHarmony) {
            return false;
        }
        if (!this.syncMapping) {
            this.syncMapping = refreshSync();
        }
        return this.syncMapping;
    }

    private boolean refreshSync() {
        return DeviceInfoManager.INSTANCE.getHarmonyVersion(AppRuntime.getAppContext(), CommonParamRuntime.PARAM_SCENE, "").errorCode == 3;
    }
}
