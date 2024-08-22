package com.baidu.searchbox.launch.restore.ioc;

import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.launch.restore.WarmStartRecoverMgr_Factory;
import com.baidu.searchbox.launch.restore.interfaces.IWarmStartRecoverMgr;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/launch/restore/ioc/WarmStartRecoverRuntime;", "", "()V", "getWarmStartRecoverMgr", "Lcom/baidu/searchbox/launch/restore/interfaces/IWarmStartRecoverMgr;", "lib-app-launch-restore-interfaces_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WarmStartRecoverRuntime.kt */
public final class WarmStartRecoverRuntime {
    public static final WarmStartRecoverRuntime INSTANCE = new WarmStartRecoverRuntime();

    private WarmStartRecoverRuntime() {
    }

    @StableApi
    public final IWarmStartRecoverMgr getWarmStartRecoverMgr() {
        return WarmStartRecoverMgr_Factory.get();
    }
}
