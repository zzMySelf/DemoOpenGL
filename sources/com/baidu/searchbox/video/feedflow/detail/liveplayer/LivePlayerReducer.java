package com.baidu.searchbox.video.feedflow.detail.liveplayer;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.NestedAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel;
import com.baidu.searchbox.video.feedflow.common.CommonStateExtKt;
import com.baidu.searchbox.video.feedflow.detail.FlowDetailState;
import com.baidu.searchbox.video.feedflow.detail.autoplay.AutoplayConfigKt;
import com.baidu.searchbox.video.feedflow.detail.player.reducer.PlayerReducer;
import com.baidu.searchbox.video.feedflow.detail.player.state.PlayerState;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel;
import com.baidu.searchbox.video.feedflow.flow.slide.PageScaleAction;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeriesEx;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J\u001e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0015H\u0016¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/liveplayer/LivePlayerReducer;", "Lcom/baidu/searchbox/video/feedflow/detail/player/reducer/PlayerReducer;", "()V", "changeLiveUnionId", "", "state", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "reduce", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "saveLiveVideoSize", "width", "", "height", "setupVideoSeries", "videoSeries", "Lcom/baidu/searchbox/video/plugin/videoplayer/model/BdVideoSeries;", "updatePreRenderSwitch", "playerState", "Lcom/baidu/searchbox/video/feedflow/detail/player/state/PlayerState;", "itemModel", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LivePlayerReducer.kt */
public class LivePlayerReducer extends PlayerReducer {
    public CommonState reduce(CommonState state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        super.reduce(state, action);
        if (action instanceof LiveException) {
            PlayerState $this$reduce_u24lambda_u2d0 = (PlayerState) state.select(PlayerState.class);
            if ($this$reduce_u24lambda_u2d0 != null) {
                $this$reduce_u24lambda_u2d0.getStopPlay().setValue(Unit.INSTANCE);
                $this$reduce_u24lambda_u2d0.isKernelVisible().setValue(false);
            }
        } else if (action instanceof NestedAction.OnBindData) {
            saveLiveVideoSize(0, 0, state);
            PlayerState $this$reduce_u24lambda_u2d1 = (PlayerState) state.select(PlayerState.class);
            if ($this$reduce_u24lambda_u2d1 != null) {
                $this$reduce_u24lambda_u2d1.isNeedLoading().setValue(true);
                $this$reduce_u24lambda_u2d1.setInterceptUserResumeOrPause(true);
                $this$reduce_u24lambda_u2d1.isNeedGestureScale().setValue(false);
            }
            LivePlayerState livePlayerState = (LivePlayerState) state.select(LivePlayerState.class);
            if (livePlayerState != null) {
                livePlayerState.setLiveEndFromKernelErrorCode(false);
            }
        } else if (action instanceof NestedAction.OnPageSelected) {
            PlayerState $this$reduce_u24lambda_u2d2 = (PlayerState) state.select(PlayerState.class);
            if ($this$reduce_u24lambda_u2d2 != null) {
                $this$reduce_u24lambda_u2d2.getLoop().setValue(Boolean.valueOf(!AutoplayConfigKt.findAutoplaySwitch(state)));
            }
            changeLiveUnionId(state);
        } else if (action instanceof LiveOnResumedAction) {
            changeLiveUnionId(state);
        } else {
            MutableLiveData mutableLiveData = null;
            if (action instanceof LiveVideoSizeChanged) {
                PlayerState playerState = (PlayerState) state.select(PlayerState.class);
                if (playerState != null) {
                    mutableLiveData = playerState.getVideoSize();
                }
                if (mutableLiveData != null) {
                    mutableLiveData.setValue(new int[]{((LiveVideoSizeChanged) action).getWidth(), ((LiveVideoSizeChanged) action).getHeight()});
                }
                saveLiveVideoSize(((LiveVideoSizeChanged) action).getWidth(), ((LiveVideoSizeChanged) action).getHeight(), state);
            } else if (action instanceof PageScaleAction.OnPageScale) {
                LivePlayerState livePlayerState2 = (LivePlayerState) state.select(LivePlayerState.class);
                if (livePlayerState2 != null) {
                    mutableLiveData = livePlayerState2.getPageScaleInProcess();
                }
                if (mutableLiveData != null) {
                    mutableLiveData.setValue(Boolean.valueOf(((PageScaleAction.OnPageScale) action).isInProgress()));
                }
            }
        }
        return state;
    }

    private final void changeLiveUnionId(CommonState state) {
        LivePlayerState livePlayerState = (LivePlayerState) state.select(LivePlayerState.class);
        MutableLiveData<String> liveUnionId = livePlayerState != null ? livePlayerState.getLiveUnionId() : null;
        if (liveUnionId != null) {
            liveUnionId.setValue(String.valueOf(System.currentTimeMillis()));
        }
    }

    public void updatePreRenderSwitch(PlayerState playerState, ItemModel<?> itemModel) {
        Intrinsics.checkNotNullParameter(playerState, "playerState");
        MutableLiveData<Boolean> isPlayerPreRender = playerState.isPlayerPreRender();
        VideoItemModel videoItemModel = null;
        Object data = itemModel != null ? itemModel.getData() : null;
        if (data instanceof VideoItemModel) {
            videoItemModel = (VideoItemModel) data;
        }
        boolean z = true;
        if (videoItemModel == null || !videoItemModel.isYYLiveVod()) {
            z = false;
        }
        isPlayerPreRender.setValue(Boolean.valueOf(z));
    }

    private final void saveLiveVideoSize(int width, int height, CommonState state) {
        FlowDetailModel $this$saveLiveVideoSize_u24lambda_u2d4;
        ItemModel itemModel = (ItemModel) state.select(ItemModel.class);
        VideoItemModel videoItemModel = null;
        Object data = itemModel != null ? itemModel.getData() : null;
        if (data instanceof VideoItemModel) {
            videoItemModel = (VideoItemModel) data;
        }
        if (videoItemModel != null) {
            VideoItemModel $this$saveLiveVideoSize_u24lambda_u2d3 = videoItemModel;
            $this$saveLiveVideoSize_u24lambda_u2d3.setVideoWidth(String.valueOf(width));
            $this$saveLiveVideoSize_u24lambda_u2d3.setVideoHeight(String.valueOf(height));
        }
        FlowDetailState flowDetailState = (FlowDetailState) state.select(FlowDetailState.class);
        if (flowDetailState != null && ($this$saveLiveVideoSize_u24lambda_u2d4 = flowDetailState.getData()) != null) {
            $this$saveLiveVideoSize_u24lambda_u2d4.setVideoWidth(String.valueOf(width));
            $this$saveLiveVideoSize_u24lambda_u2d4.setVideoHeight(String.valueOf(height));
        }
    }

    /* access modifiers changed from: protected */
    public void setupVideoSeries(CommonState state, BdVideoSeries videoSeries) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(videoSeries, "videoSeries");
        super.setupVideoSeries(state, videoSeries);
        BdVideoSeriesEx.setYYForbidPrepare(videoSeries, CommonStateExtKt.isPreviousAtCurrentIndex(state));
    }
}
