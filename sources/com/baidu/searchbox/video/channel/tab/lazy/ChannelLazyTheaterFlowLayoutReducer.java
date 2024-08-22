package com.baidu.searchbox.video.channel.tab.lazy;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.video.feedflow.common.AbsLazyInflateReducer;
import com.baidu.searchbox.video.feedflow.common.downgrade.DowngradeFeatureManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0014¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/channel/tab/lazy/ChannelLazyTheaterFlowLayoutReducer;", "Lcom/baidu/searchbox/video/feedflow/common/AbsLazyInflateReducer;", "()V", "getDowngradeManager", "Lcom/baidu/searchbox/video/feedflow/common/downgrade/DowngradeFeatureManager;", "state", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelLazyTheaterFlowLayoutReducer.kt */
public final class ChannelLazyTheaterFlowLayoutReducer extends AbsLazyInflateReducer {
    /* access modifiers changed from: protected */
    public DowngradeFeatureManager getDowngradeManager(CommonState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return (DowngradeFeatureManager) state.select(ChannelTheaterFeatureManager.class);
    }
}
