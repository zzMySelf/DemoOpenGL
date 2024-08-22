package com.baidu.searchbox.video.feedflow.update;

import com.baidu.searchbox.video.feedflow.cache.FlowVideoCacheConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/video/feedflow/cache/FlowVideoCacheConfig;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowVideoOfflineCacheConfigSwitcher.kt */
final class FlowVideoOfflineCacheConfigSwitcher$flowVideoOfflineCacheConfig$2 extends Lambda implements Function0<FlowVideoCacheConfig> {
    public static final FlowVideoOfflineCacheConfigSwitcher$flowVideoOfflineCacheConfig$2 INSTANCE = new FlowVideoOfflineCacheConfigSwitcher$flowVideoOfflineCacheConfig$2();

    FlowVideoOfflineCacheConfigSwitcher$flowVideoOfflineCacheConfig$2() {
        super(0);
    }

    public final FlowVideoCacheConfig invoke() {
        return FlowVideoOfflineCacheConfigSwitcher.INSTANCE.parseOfflineCacheConfig();
    }
}
