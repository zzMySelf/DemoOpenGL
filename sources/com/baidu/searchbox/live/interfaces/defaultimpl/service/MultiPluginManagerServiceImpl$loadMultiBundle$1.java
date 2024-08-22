package com.baidu.searchbox.live.interfaces.defaultimpl.service;

import com.baidu.nps.main.invoke.IInvokeCallback;
import com.baidu.searchbox.live.interfaces.multiplugin.MultiPluginLoadCallback;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"com/baidu/searchbox/live/interfaces/defaultimpl/service/MultiPluginManagerServiceImpl$loadMultiBundle$1", "Lcom/baidu/nps/main/invoke/IInvokeCallback;", "onResult", "", "retCode", "", "retMsg", "", "retObj", "", "lib-live-interfaces-impl_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: MultiPluginManagerServiceImpl.kt */
public final class MultiPluginManagerServiceImpl$loadMultiBundle$1 implements IInvokeCallback {
    final /* synthetic */ MultiPluginLoadCallback $loadCallback;

    MultiPluginManagerServiceImpl$loadMultiBundle$1(MultiPluginLoadCallback $captured_local_variable$0) {
        this.$loadCallback = $captured_local_variable$0;
    }

    public void onResult(int retCode, String retMsg, Object retObj) {
        if (retCode == 14) {
            MultiPluginLoadCallback multiPluginLoadCallback = this.$loadCallback;
            if (multiPluginLoadCallback != null) {
                multiPluginLoadCallback.onResult(true, retCode, retMsg);
                return;
            }
            return;
        }
        MultiPluginLoadCallback multiPluginLoadCallback2 = this.$loadCallback;
        if (multiPluginLoadCallback2 != null) {
            multiPluginLoadCallback2.onResult(false, retCode, retMsg);
        }
    }
}
