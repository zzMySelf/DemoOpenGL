package com.baidu.searchbox.video.feedflow.detail.protocol;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.NestedAction;
import com.baidu.searchbox.feed.detail.arch.ext.NetAction;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel;
import com.baidu.searchbox.flowvideo.detail.repos.PublishInfoModel;
import com.baidu.searchbox.searchflow.detail.api.ProtocolModel;
import com.baidu.searchbox.video.feedflow.detail.FlowDetailState;
import com.baidu.searchbox.video.feedflow.detail.hotcomment.HotCommentAction;
import com.baidu.searchbox.video.feedflow.detail.intelligentrecommend.IntelligentRecommendEntranceHiddenAction;
import com.baidu.searchbox.video.feedflow.detail.intelligentrecommend.IntelligentRecommendEntranceShowAction;
import com.baidu.searchbox.video.feedflow.detail.longpressspeed.LongPressSpeedAnim;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerError;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerStart;
import com.baidu.searchbox.video.feedflow.detail.videopk.VideoPkAction;
import com.baidu.searchbox.video.feedflow.detail.videosummary.VideoSummaryListUnFoldAction;
import com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/protocol/FlowProtocolReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "reduce", "state", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowProtocolReducer.kt */
public class FlowProtocolReducer implements Reducer<CommonState> {
    public CommonState reduce(CommonState state, Action action) {
        boolean z;
        FlowProtocolState $this$reduce_u24lambda_u2d9;
        FlowProtocolState $this$reduce_u24lambda_u2d8;
        FlowProtocolState $this$reduce_u24lambda_u2d7;
        FlowProtocolState $this$reduce_u24lambda_u2d4_u24lambda_u2d3;
        FlowDetailModel data;
        String area;
        PublishInfoModel publishInfo;
        String time;
        FlowDetailModel data2;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        boolean z2 = false;
        boolean z3 = true;
        MutableLiveData<Boolean> mutableLiveData = null;
        if (action instanceof NetAction.Success) {
            Object data3 = ((NetAction.Success) action).getData();
            FlowDetailModel $this$reduce_u24lambda_u2d4 = data3 instanceof FlowDetailModel ? (FlowDetailModel) data3 : null;
            if (!($this$reduce_u24lambda_u2d4 == null || ($this$reduce_u24lambda_u2d4_u24lambda_u2d3 = (FlowProtocolState) state.select(FlowProtocolState.class)) == null)) {
                boolean isShowView = false;
                FlowDetailState flowDetailState = (FlowDetailState) state.select(FlowDetailState.class);
                if ((flowDetailState == null || (data2 = flowDetailState.getData()) == null || data2.isOffLineVideo()) ? false : true) {
                    PublishInfoModel publishInfo2 = $this$reduce_u24lambda_u2d4.getPublishInfo();
                    CharSequence time2 = publishInfo2 != null ? publishInfo2.getTime() : null;
                    if (time2 == null || StringsKt.isBlank(time2)) {
                        $this$reduce_u24lambda_u2d4_u24lambda_u2d3.getTime().setValue(null);
                    } else if (!(UBCManifestKt.isPageFromSearchFlow((AbsState) state) || (publishInfo = $this$reduce_u24lambda_u2d4.getPublishInfo()) == null || (time = publishInfo.getTime()) == null)) {
                        $this$reduce_u24lambda_u2d4_u24lambda_u2d3.getTime().setValue(time);
                        isShowView = true;
                    }
                    PublishInfoModel publishInfo3 = $this$reduce_u24lambda_u2d4.getPublishInfo();
                    CharSequence area2 = publishInfo3 != null ? publishInfo3.getArea() : null;
                    if (area2 == null || StringsKt.isBlank(area2)) {
                        $this$reduce_u24lambda_u2d4_u24lambda_u2d3.getArea().setValue(null);
                    } else {
                        PublishInfoModel publishInfo4 = $this$reduce_u24lambda_u2d4.getPublishInfo();
                        if (!(publishInfo4 == null || (area = publishInfo4.getArea()) == null)) {
                            $this$reduce_u24lambda_u2d4_u24lambda_u2d3.getArea().setValue(area);
                            isShowView = true;
                        }
                    }
                } else {
                    $this$reduce_u24lambda_u2d4_u24lambda_u2d3.getTime().setValue(null);
                    $this$reduce_u24lambda_u2d4_u24lambda_u2d3.getArea().setValue(null);
                }
                if ($this$reduce_u24lambda_u2d4.getProtocol() == null) {
                    $this$reduce_u24lambda_u2d4_u24lambda_u2d3.getData().setValue(null);
                } else {
                    ProtocolModel model = $this$reduce_u24lambda_u2d4.getProtocol();
                    if (model != null) {
                        if (model.getSwitch()) {
                            FlowDetailState flowDetailState2 = (FlowDetailState) state.select(FlowDetailState.class);
                            if (!(flowDetailState2 == null || (data = flowDetailState2.getData()) == null || data.isOffLineVideo())) {
                                z2 = true;
                            }
                            if (z2) {
                                $this$reduce_u24lambda_u2d4_u24lambda_u2d3.getData().setValue(model);
                                isShowView = true;
                            }
                        }
                        $this$reduce_u24lambda_u2d4_u24lambda_u2d3.getData().setValue(null);
                    }
                }
                $this$reduce_u24lambda_u2d4_u24lambda_u2d3.isVisible().setValue(Boolean.valueOf(isShowView));
            }
        } else if (action instanceof NestedAction.OnBindData) {
            FlowProtocolState flowProtocolState = (FlowProtocolState) state.select(FlowProtocolState.class);
            if (flowProtocolState != null) {
                flowProtocolState.reset(state, (NestedAction.OnBindData) action);
            }
        } else if (action instanceof VideoSummaryListUnFoldAction) {
            FlowProtocolState flowProtocolState2 = (FlowProtocolState) state.select(FlowProtocolState.class);
            if (flowProtocolState2 != null) {
                flowProtocolState2.setLeftAreaShow(false);
            }
            FlowProtocolState flowProtocolState3 = (FlowProtocolState) state.select(FlowProtocolState.class);
            if (flowProtocolState3 != null) {
                mutableLiveData = flowProtocolState3.isShowOrHideAnim();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(false);
            }
        } else {
            if (action instanceof VideoPkAction.OnVideoPkShownAction) {
                z = true;
            } else {
                z = action instanceof HotCommentAction.HotCommentShownAction;
            }
            if (z) {
                FlowProtocolState $this$reduce_u24lambda_u2d5 = (FlowProtocolState) state.select(FlowProtocolState.class);
                if ($this$reduce_u24lambda_u2d5 != null && Intrinsics.areEqual((Object) $this$reduce_u24lambda_u2d5.isVisible().getValue(), (Object) true)) {
                    $this$reduce_u24lambda_u2d5.getAlphaAndHeightAnim().setValue(false);
                }
            } else {
                if (!(action instanceof VideoPkAction.OnVideoPkHiddenAction)) {
                    z3 = action instanceof HotCommentAction.HotCommentHiddenAction;
                }
                if (z3) {
                    FlowProtocolState $this$reduce_u24lambda_u2d6 = (FlowProtocolState) state.select(FlowProtocolState.class);
                    if ($this$reduce_u24lambda_u2d6 != null && Intrinsics.areEqual((Object) $this$reduce_u24lambda_u2d6.isVisible().getValue(), (Object) true)) {
                        $this$reduce_u24lambda_u2d6.getAlphaAndHeightAnim().setValue(true);
                    }
                } else if (action instanceof IntelligentRecommendEntranceShowAction) {
                    if (!((IntelligentRecommendEntranceShowAction) action).isBottom() && ($this$reduce_u24lambda_u2d7 = (FlowProtocolState) state.select(FlowProtocolState.class)) != null) {
                        $this$reduce_u24lambda_u2d7.getAlphaAndHeightAnim().setValue(false);
                    }
                } else if (action instanceof IntelligentRecommendEntranceHiddenAction) {
                    if (!((IntelligentRecommendEntranceHiddenAction) action).isBottom() && ($this$reduce_u24lambda_u2d8 = (FlowProtocolState) state.select(FlowProtocolState.class)) != null) {
                        $this$reduce_u24lambda_u2d8.getAlphaAndHeightAnim().setValue(true);
                    }
                } else if (action instanceof LongPressSpeedAnim) {
                    FlowProtocolState flowProtocolState4 = (FlowProtocolState) state.select(FlowProtocolState.class);
                    if (flowProtocolState4 != null) {
                        flowProtocolState4.handleLongPressing(((LongPressSpeedAnim) action).isStart());
                    }
                } else if (action instanceof PlayerError) {
                    FlowProtocolState flowProtocolState5 = (FlowProtocolState) state.select(FlowProtocolState.class);
                    if (flowProtocolState5 != null) {
                        mutableLiveData = flowProtocolState5.isVisible();
                    }
                    if (mutableLiveData != null) {
                        mutableLiveData.setValue(false);
                    }
                } else if ((action instanceof PlayerStart) && ($this$reduce_u24lambda_u2d9 = (FlowProtocolState) state.select(FlowProtocolState.class)) != null && ((PlayerStart) action).isFromError() && $this$reduce_u24lambda_u2d9.getData().getValue() != null) {
                    $this$reduce_u24lambda_u2d9.isVisible().setValue(true);
                }
            }
        }
        return state;
    }
}
