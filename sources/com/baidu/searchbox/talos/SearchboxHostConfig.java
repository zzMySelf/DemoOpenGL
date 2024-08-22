package com.baidu.searchbox.talos;

import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.pyramid.runtime.service.ServiceRegistry;
import com.baidu.searchbox.appframework.pad.AppLayoutVariantMgrKt;
import com.baidu.searchbox.buildconfig.BuildConfigManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.devicescore.IDeviceScore;
import com.baidu.searchbox.player.utils.DumediaUtils;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.talos.TalosAppRuntimeInit;
import com.baidu.talos.adapter.IHostConfigAdapter;
import com.baidu.talos.common.TalosInitParamsUtil;

public class SearchboxHostConfig implements IHostConfigAdapter {
    public boolean isDebug() {
        return AppConfig.isDebug();
    }

    public String getPhoneCUID() {
        return BaiduIdentityManager.getInstance(TalosAppRuntimeInit.getAppContext()).getUid();
    }

    public String getHostTn() {
        return BaiduIdentityManager.getInstance(TalosAppRuntimeInit.getAppContext()).getTn();
    }

    public boolean isSystraceEnable() {
        return BuildConfigManager.getBoolean("BuildConfig", "SYSTRACE_ENABLE");
    }

    public float getDeviceScore() {
        IDeviceScore deviceScoreService = (IDeviceScore) ServiceRegistry.getService(IDeviceScore.SERVICE_REFERENCE);
        if (deviceScoreService != null) {
            return deviceScoreService.getFinalScore(TalosAppRuntimeInit.getAppContext());
        }
        return 0.0f;
    }

    public int getVideoScore() {
        return DumediaUtils.getPlayQualityScore(0, 0);
    }

    public String getUrlCommonParams() {
        return TalosInitParamsUtil.getUrlCommonParams();
    }

    public boolean foldable() {
        return DeviceUtil.isSupportFoldable();
    }

    public boolean leftSideBarStyle() {
        return AppLayoutVariantMgrKt.layoutStyle() == 2;
    }
}
