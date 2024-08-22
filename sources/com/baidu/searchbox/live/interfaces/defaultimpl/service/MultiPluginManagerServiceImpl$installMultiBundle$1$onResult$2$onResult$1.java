package com.baidu.searchbox.live.interfaces.defaultimpl.service;

import com.baidu.searchbox.live.interfaces.defaultimpl.service.MultiPluginManagerServiceImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/baidu/searchbox/live/interfaces/defaultimpl/service/MultiPluginManagerServiceImpl$installMultiBundle$1$onResult$2$onResult$1", "Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/MultiPluginManagerServiceImpl$PluginInstallCallback;", "onResult", "", "pkgName", "", "retCode1", "", "retMsg1", "lib-live-interfaces-impl_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: MultiPluginManagerServiceImpl.kt */
public final class MultiPluginManagerServiceImpl$installMultiBundle$1$onResult$2$onResult$1 implements MultiPluginManagerServiceImpl.PluginInstallCallback {
    final /* synthetic */ MultiPluginManagerServiceImpl$installMultiBundle$1$onResult$2 this$0;

    MultiPluginManagerServiceImpl$installMultiBundle$1$onResult$2$onResult$1(MultiPluginManagerServiceImpl$installMultiBundle$1$onResult$2 $outer) {
        this.this$0 = $outer;
    }

    public void onResult(String pkgName, int retCode1, String retMsg1) {
        Intrinsics.checkParameterIsNotNull(pkgName, "pkgName");
        Intrinsics.checkParameterIsNotNull(retMsg1, "retMsg1");
        this.this$0.this$0.$installCallback.onResult(pkgName, false, retCode1, retMsg1);
    }
}
