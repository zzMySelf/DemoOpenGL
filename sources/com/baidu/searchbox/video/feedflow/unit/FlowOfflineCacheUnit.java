package com.baidu.searchbox.video.feedflow.unit;

import com.baidu.searchbox.feed.detail.arch.SlotUnit;
import com.baidu.searchbox.feed.detail.arch.api.IPlugin;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import com.baidu.searchbox.video.feedflow.flow.offlinecache.FlowOfflineCachePlugin;
import com.baidu.searchbox.video.feedflow.flow.offlinecache.FlowOfflineCacheReducer;
import com.baidu.searchbox.video.feedflow.flow.offlinecache.FlowOfflineCacheStatisticMiddleware;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u0005H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/unit/FlowOfflineCacheUnit;", "Lcom/baidu/searchbox/feed/detail/arch/SlotUnit;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "createMiddlewares", "", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "createPlugin", "Lcom/baidu/searchbox/feed/detail/arch/api/IPlugin;", "createReducer", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowOfflineCacheUnit.kt */
public final class FlowOfflineCacheUnit implements SlotUnit<CommonState> {
    public static final FlowOfflineCacheUnit INSTANCE = new FlowOfflineCacheUnit();

    private FlowOfflineCacheUnit() {
    }

    public List<Middleware<CommonState>> createMiddlewares() {
        return CollectionsKt.mutableListOf(new FlowOfflineCacheStatisticMiddleware());
    }

    public IPlugin createPlugin() {
        return new FlowOfflineCachePlugin();
    }

    public Reducer<CommonState> createReducer() {
        return new FlowOfflineCacheReducer();
    }
}
