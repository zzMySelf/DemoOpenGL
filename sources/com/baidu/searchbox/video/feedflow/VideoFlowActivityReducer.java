package com.baidu.searchbox.video.feedflow;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import com.baidu.searchbox.video.feedflow.detail.entertransition.OnEnterAllAnimEnd;
import com.baidu.searchbox.video.feedflow.detail.entertransition.OnTransitionAnimEnd;
import com.baidu.searchbox.video.feedflow.detail.entertransition.OnTransitionAnimStart;
import com.baidu.searchbox.video.feedflow.detail.player.FirstJumpPlayerFirstFrame;
import com.baidu.searchbox.video.utils.VideoCommonWrap;
import com.baidu.searchbox.video.utils.VideoFlowBusEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/VideoFlowActivityReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "reduce", "state", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoFlowActivityReducer.kt */
public final class VideoFlowActivityReducer implements Reducer<CommonState> {
    public CommonState reduce(CommonState state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        MutableLiveData<Boolean> mutableLiveData = null;
        if (action instanceof OnTransitionAnimStart ? true : Intrinsics.areEqual((Object) action, (Object) OnTransitionAnimEnd.INSTANCE)) {
            VideoFlowActivityState videoFlowActivityState = (VideoFlowActivityState) state.select(VideoFlowActivityState.class);
            if (videoFlowActivityState != null) {
                mutableLiveData = videoFlowActivityState.getChangeVideoPlaceHolderVisible();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(false);
            }
        } else if (action instanceof OnEnterAllAnimEnd) {
            BdEventBus.Companion.getDefault().post(new VideoFlowBusEvent(VideoCommonWrap.getKEY_VIDEO_FLOW_END_TRANSITION_EVENT()));
        } else if (action instanceof FirstJumpPlayerFirstFrame) {
            VideoFlowActivityState videoFlowActivityState2 = (VideoFlowActivityState) state.select(VideoFlowActivityState.class);
            if (videoFlowActivityState2 != null) {
                mutableLiveData = videoFlowActivityState2.getSyncBarrierState();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(false);
            }
        }
        return state;
    }
}
