package com.baidu.searchbox.video.channel.flow.detail.dynamic;

import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.video.feedflow.common.VideoFlowActionInterceptor;
import com.baidu.searchbox.video.feedflow.detail.dynamic.carouselpic.OnCarouselPicFirstJumpFirstPicLoadResult;
import com.baidu.searchbox.video.feedflow.sidebar.SideBarAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/channel/flow/detail/dynamic/ChannelDynamicItemActionInterceptor;", "Lcom/baidu/searchbox/video/feedflow/common/VideoFlowActionInterceptor;", "()V", "accept", "", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "deliver", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelDynamicItemActionInterceptor.kt */
public final class ChannelDynamicItemActionInterceptor extends VideoFlowActionInterceptor {
    public boolean accept(Action action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (!(action instanceof SideBarAction.OnDrawerOpen) && !(action instanceof SideBarAction.OnDrawerClose)) {
            return super.accept(action);
        }
        return true;
    }

    public boolean deliver(Action action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof OnCarouselPicFirstJumpFirstPicLoadResult) {
            return true;
        }
        return super.deliver(action);
    }
}
