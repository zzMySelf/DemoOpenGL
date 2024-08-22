package com.baidu.searchbox.video.channel.flow.flow.duration;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.video.channel.flow.pageview.VideoChannelFlowPageAction;
import com.baidu.searchbox.video.feedflow.detail.DetailItemSelected;
import com.baidu.searchbox.video.feedflow.flow.duration.DurationReducer;
import com.baidu.searchbox.video.feedflow.flow.duration.DurationState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/channel/flow/flow/duration/ChannelFlowDurationReducer;", "Lcom/baidu/searchbox/video/feedflow/flow/duration/DurationReducer;", "()V", "reduce", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "state", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelFlowDurationReducer.kt */
public final class ChannelFlowDurationReducer extends DurationReducer {
    public CommonState reduce(CommonState state, Action action) {
        DurationState durationState;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        super.reduce(state, action);
        if (action instanceof DetailItemSelected) {
            DurationState durationState2 = (DurationState) state.select(DurationState.class);
            if (durationState2 != null) {
                durationState2.setUp(((DetailItemSelected) action).isUp());
            }
        } else if ((action instanceof VideoChannelFlowPageAction.SchemeJumpAction) && (durationState = (DurationState) state.select(DurationState.class)) != null) {
            durationState.setSchemeJump(true);
        }
        return state;
    }
}
