package com.baidu.searchbox.video.feedflow.flow.talos;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/talos/TalosNativeState;", "", "()V", "talosCache", "", "", "getCache", "tabId", "saveCache", "", "cache", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TalosNativeState.kt */
public final class TalosNativeState {
    private final Map<String, String> talosCache = new LinkedHashMap();

    public final void saveCache(String tabId, String cache) {
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        Intrinsics.checkNotNullParameter(cache, "cache");
        this.talosCache.put(tabId, cache);
    }

    public final String getCache(String tabId) {
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        String str = this.talosCache.get(tabId);
        return str == null ? "" : str;
    }
}
