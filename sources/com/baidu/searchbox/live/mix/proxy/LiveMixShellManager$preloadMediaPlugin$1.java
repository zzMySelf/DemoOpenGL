package com.baidu.searchbox.live.mix.proxy;

import com.baidu.searchbox.live.chainlog.NpsLoadChainLog;
import com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"com/baidu/searchbox/live/mix/proxy/LiveMixShellManager$preloadMediaPlugin$1", "Lcom/baidu/searchbox/live/interfaces/mix/PluginLoadCallback;", "onResult", "", "isSucc", "", "retCode", "", "retMsg", "", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: LiveMixShellManager.kt */
public final class LiveMixShellManager$preloadMediaPlugin$1 implements PluginLoadCallback {
    LiveMixShellManager$preloadMediaPlugin$1() {
    }

    public void onResult(boolean isSucc, int retCode, String retMsg) {
        NpsLoadChainLog.getInstance().dLog("LiveMixShellManager preloadMediaPlugin result " + isSucc + ", " + retCode + ", " + retMsg);
    }
}
