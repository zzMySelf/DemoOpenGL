package com.baidu.searchbox.video.feedflow.detail.cacheguide;

import com.baidu.searchbox.video.feedflow.cache.FlowVideoCacheConfig;
import com.baidu.searchbox.video.feedflow.cache.GuideConfig;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/video/feedflow/cache/GuideConfig;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoCacheGuideSPHelper.kt */
final class VideoCacheGuideSPHelper$guideConfig$2 extends Lambda implements Function0<GuideConfig> {
    public static final VideoCacheGuideSPHelper$guideConfig$2 INSTANCE = new VideoCacheGuideSPHelper$guideConfig$2();

    VideoCacheGuideSPHelper$guideConfig$2() {
        super(0);
    }

    public final GuideConfig invoke() {
        FlowVideoCacheConfig flowVideoOfflineCacheConfig = DIFactory.INSTANCE.getConfig().getFlowVideoOfflineCacheConfig();
        if (flowVideoOfflineCacheConfig != null) {
            return flowVideoOfflineCacheConfig.getGuideConfig();
        }
        return null;
    }
}
