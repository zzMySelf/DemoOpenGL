package com.baidu.searchbox.video.feedflow.detail.detainmentguide;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.NetAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import com.baidu.searchbox.video.feedflow.common.FlowSwitchState;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerOrientationChanged;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.flow.flowstyle.LandscapeFlowSwitchKt;
import com.baidu.searchbox.video.feedflow.flow.list.ScrollStateChanged;
import com.baidu.searchbox.video.feedflow.flow.list.UpdateFlowStyle;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/detainmentguide/FlowSlideGuideReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "reduce", "state", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "updateExitTime", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowSlideGuideReducer.kt */
public final class FlowSlideGuideReducer implements Reducer<CommonState> {
    public CommonState reduce(CommonState state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof NetAction.Success) {
            FlowDetainmentGuideState $this$reduce_u24lambda_u2d0 = (FlowDetainmentGuideState) state.select(FlowDetainmentGuideState.class);
            if ($this$reduce_u24lambda_u2d0 != null) {
                $this$reduce_u24lambda_u2d0.getDataSuccess().setValue(Unit.INSTANCE);
            }
        } else {
            MutableLiveData mutableLiveData = null;
            if (action instanceof UpdateFlowStyle) {
                if (LandscapeFlowSwitchKt.getLandscapeFlowAbSwitch(state)) {
                    FlowDetainmentGuideState flowDetainmentGuideState = (FlowDetainmentGuideState) state.select(FlowDetainmentGuideState.class);
                    if (flowDetainmentGuideState != null) {
                        mutableLiveData = flowDetainmentGuideState.isLandscapeFlow();
                    }
                    if (mutableLiveData != null) {
                        mutableLiveData.setValue(Boolean.valueOf(((UpdateFlowStyle) action).isLandscapeFlow()));
                    }
                }
            } else if (action instanceof ScrollStateChanged) {
                FlowDetainmentGuideState flowDetainmentGuideState2 = (FlowDetainmentGuideState) state.select(FlowDetainmentGuideState.class);
                if (flowDetainmentGuideState2 != null) {
                    mutableLiveData = flowDetainmentGuideState2.getVerticalScrollStatus();
                }
                if (mutableLiveData != null) {
                    mutableLiveData.setValue(Integer.valueOf(((ScrollStateChanged) action).getScrollState()));
                }
            } else if (action instanceof PlayerOrientationChanged) {
                FlowDetainmentGuideState $this$reduce_u24lambda_u2d1 = (FlowDetainmentGuideState) state.select(FlowDetainmentGuideState.class);
                if ($this$reduce_u24lambda_u2d1 != null && ((PlayerOrientationChanged) action).isFullScreen() && LandscapeFlowSwitchKt.getLandscapeFlowAbSwitch(state)) {
                    $this$reduce_u24lambda_u2d1.getCancelGuide().setValue(Unit.INSTANCE);
                }
            } else if (action instanceof DetainmentLeaveUpdateExitTimeAction) {
                updateExitTime(state);
            }
        }
        return state;
    }

    private final void updateExitTime(CommonState state) {
        String operateConf;
        FlowSwitchState flowSwitchState = (FlowSwitchState) state.select(FlowSwitchState.class);
        FlowDetainmentGuideConfig guideConfig = flowSwitchState != null ? flowSwitchState.getFlowDetainGuideConfig() : null;
        Calendar calendar = Calendar.getInstance();
        boolean z = false;
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        if (!(guideConfig == null || (operateConf = guideConfig.getOperateConf()) == null)) {
            if (!(operateConf.length() == 0)) {
                z = true;
            }
        }
        if (!z || guideConfig.getNeedTotalCount()) {
            DIFactory.INSTANCE.getConfig().setDetainGuideExitTime(calendar.getTimeInMillis());
        } else {
            DIFactory.INSTANCE.getConfig().setDetainGuideExitTimeWithScene(FlowDetainmentGuideStateKt.getCurSceneString(state), calendar.getTimeInMillis());
        }
    }
}
