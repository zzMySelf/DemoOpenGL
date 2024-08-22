package com.baidu.searchbox.video.feedflow.cache;

import com.baidu.searchbox.player.ab.UpdateConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/cache/OfflineCacheGCPConfig;", "Lcom/baidu/searchbox/player/ab/UpdateConfig;", "Lcom/baidu/searchbox/video/feedflow/cache/OfflineCacheGCPData;", "()V", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowVideoCacheConfig.kt */
final class OfflineCacheGCPConfig extends UpdateConfig<OfflineCacheGCPData> {
    public static final OfflineCacheGCPConfig INSTANCE = new OfflineCacheGCPConfig();

    private OfflineCacheGCPConfig() {
        super("flowvideo_offline_config", AnonymousClass1.INSTANCE, "", (String) null, (String) null, (String) null, (String) null, 120, (DefaultConstructorMarker) null);
    }
}
