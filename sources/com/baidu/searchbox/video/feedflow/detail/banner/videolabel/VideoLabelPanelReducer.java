package com.baidu.searchbox.video.feedflow.detail.banner.videolabel;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.ext.common.UserVisibleHint;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import com.baidu.searchbox.video.component.datachannel.DataChannelAction;
import com.baidu.searchbox.video.feedflow.detail.banner.videolabel.VideoLabelPanelAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/banner/videolabel/VideoLabelPanelReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "reduce", "state", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoLabelPanelReducer.kt */
public final class VideoLabelPanelReducer implements Reducer<CommonState> {
    public CommonState reduce(CommonState state, Action action) {
        VideoLabelPanelState $this$reduce_u24lambda_u2d3;
        VideoLabelPanelState $this$reduce_u24lambda_u2d2;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof VideoLabelPanelAction.ShowVideoLabelPanel) {
            VideoLabelPanelState $this$reduce_u24lambda_u2d0 = (VideoLabelPanelState) state.select(VideoLabelPanelState.class);
            if ($this$reduce_u24lambda_u2d0 != null) {
                $this$reduce_u24lambda_u2d0.getLabelData().setValue(((VideoLabelPanelAction.ShowVideoLabelPanel) action).getData());
                $this$reduce_u24lambda_u2d0.getPanelStatus().setValue(true);
            }
        } else if (action instanceof VideoLabelPanelAction.HideVideoLabelPanel) {
            VideoLabelPanelState $this$reduce_u24lambda_u2d1 = (VideoLabelPanelState) state.select(VideoLabelPanelState.class);
            if ($this$reduce_u24lambda_u2d1 != null) {
                $this$reduce_u24lambda_u2d1.getPanelStatus().setValue(false);
            }
        } else if (action instanceof DataChannelAction.SyncOuterAction) {
            if (Intrinsics.areEqual((Object) ((DataChannelAction.SyncOuterAction) action).getType(), (Object) VideoLabelPanelRegisterKt.VIDEO_LABEL_PANEL_CHANNEL_ACTION) && ($this$reduce_u24lambda_u2d2 = (VideoLabelPanelState) state.select(VideoLabelPanelState.class)) != null) {
                $this$reduce_u24lambda_u2d2.getPanelStatus().setValue(false);
            }
        } else if ((action instanceof UserVisibleHint) && ($this$reduce_u24lambda_u2d3 = (VideoLabelPanelState) state.select(VideoLabelPanelState.class)) != null) {
            $this$reduce_u24lambda_u2d3.setVisibleToUser(((UserVisibleHint) action).getVisible());
            if (!((UserVisibleHint) action).getVisible()) {
                VideoLabelPanelState videoLabelPanelState = (VideoLabelPanelState) state.select(VideoLabelPanelState.class);
                MutableLiveData<Boolean> panelStatus = videoLabelPanelState != null ? videoLabelPanelState.getPanelStatus() : null;
                if (panelStatus != null) {
                    panelStatus.setValue(false);
                }
            }
        }
        return state;
    }
}
