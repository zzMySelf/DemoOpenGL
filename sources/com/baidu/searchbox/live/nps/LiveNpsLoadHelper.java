package com.baidu.searchbox.live.nps;

import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.BundleInfoGroup;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.searchbox.live.nps.MultiPluginHelper;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/live/nps/LiveNpsLoadHelper;", "", "()V", "getLiveNpsPluginWillLoadVersion", "", "lib-live_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveNpsLoadHelper.kt */
public final class LiveNpsLoadHelper {
    public static final LiveNpsLoadHelper INSTANCE = new LiveNpsLoadHelper();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LiveNpsLoadHelper.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MultiPluginHelper.ConfigType.values().length];
            iArr[MultiPluginHelper.ConfigType.CONFIG_TYPE_DEF.ordinal()] = 1;
            iArr[MultiPluginHelper.ConfigType.CONFIG_TYPE_PRESET.ordinal()] = 2;
            iArr[MultiPluginHelper.ConfigType.CONFIG_TYPE_DOWNLOAD.ordinal()] = 3;
            iArr[MultiPluginHelper.ConfigType.CONFIG_TYPE_INSTALL.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private LiveNpsLoadHelper() {
    }

    public final int getLiveNpsPluginWillLoadVersion() {
        if (LiveMediaPluginManager.getInstance().isLoaded("com.baidu.searchbox.livenps")) {
            return LiveMediaPluginManager.getInstance().getInstallPluginVersion("com.baidu.searchbox.livenps");
        }
        BundleInfoGroup liveNpsGroup = NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.livenps");
        BundleInfo installLiveNps = null;
        BundleInfo updateLiveNps = liveNpsGroup != null ? liveNpsGroup.getBundleByType(1) : null;
        if (updateLiveNps != null && updateLiveNps.needForceUpdate()) {
            return updateLiveNps.getVersionCode();
        }
        BundleInfo liveNpsPresetInfo = NPSPackageManager.getInstance().getPresetBundle("com.baidu.searchbox.livenps");
        BundleInfo downloadLiveNps = liveNpsGroup != null ? liveNpsGroup.getBundleByType(2) : null;
        MultiPluginHelper.ConfigType it = MultiPluginHelper.compatPluginConfigType("getLiveNpsPluginWillLoadVersion");
        int i2 = 0;
        if (it != null) {
            switch (WhenMappings.$EnumSwitchMapping$0[it.ordinal()]) {
                case 1:
                    int versionCode = liveNpsPresetInfo != null ? liveNpsPresetInfo.getVersionCode() : 0;
                    if (downloadLiveNps != null) {
                        i2 = downloadLiveNps.getVersionCode();
                    }
                    return RangesKt.coerceAtLeast(versionCode, i2);
                case 2:
                    if (liveNpsPresetInfo != null) {
                        return liveNpsPresetInfo.getVersionCode();
                    }
                    return 0;
                case 3:
                    if (downloadLiveNps != null) {
                        return downloadLiveNps.getVersionCode();
                    }
                    return 0;
                case 4:
                    if (liveNpsGroup != null) {
                        installLiveNps = liveNpsGroup.getBundleByType(3);
                    }
                    if (installLiveNps != null) {
                        return installLiveNps.getVersionCode();
                    }
                    return 0;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        } else if (liveNpsPresetInfo != null) {
            return liveNpsPresetInfo.getVersionCode();
        } else {
            return 0;
        }
    }
}
