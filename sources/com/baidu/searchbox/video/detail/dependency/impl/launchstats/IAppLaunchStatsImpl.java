package com.baidu.searchbox.video.detail.dependency.impl.launchstats;

import com.baidu.launch.LaunchUtils;
import com.baidu.launch.stats.LaunchStatsUtils;
import com.baidu.searchbox.video.detail.export.IAppLaunchStates;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/detail/dependency/impl/launchstats/IAppLaunchStatsImpl;", "Lcom/baidu/searchbox/video/detail/export/IAppLaunchStates;", "()V", "getAppCreateTime", "", "isAppColdLaunch", "", "video-dependency-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IAppLaunchStatsImpl.kt */
public final class IAppLaunchStatsImpl implements IAppLaunchStates {
    public long getAppCreateTime() {
        return LaunchStatsUtils.getAppCreateTime();
    }

    public boolean isAppColdLaunch() {
        return LaunchUtils.isColdBoot();
    }
}
