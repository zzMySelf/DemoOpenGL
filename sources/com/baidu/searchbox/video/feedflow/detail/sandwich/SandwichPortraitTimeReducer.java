package com.baidu.searchbox.video.feedflow.detail.sandwich;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.NestedAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import com.baidu.searchbox.video.feedflow.flow.list.FlowState;
import com.baidu.searchbox.video.feedflow.flow.list.UpdateFlowStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/sandwich/SandwichPortraitTimeReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "reduce", "state", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SandwichPortraitTimeReducer.kt */
public final class SandwichPortraitTimeReducer implements Reducer<CommonState> {
    public CommonState reduce(CommonState state, Action action) {
        SandwichPortraitTimeState $this$reduce_u24lambda_u2d1;
        SandwichPortraitTimeState $this$reduce_u24lambda_u2d0;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        boolean z = false;
        if (action instanceof UpdateFlowStyle) {
            if (state.isActive() && ($this$reduce_u24lambda_u2d0 = (SandwichPortraitTimeState) state.select(SandwichPortraitTimeState.class)) != null) {
                MutableLiveData<Boolean> isLandscape = $this$reduce_u24lambda_u2d0.isLandscape();
                if (isLandscape != null) {
                    isLandscape.setValue(Boolean.valueOf(((UpdateFlowStyle) action).isLandscapeFlow()));
                }
                FlowState flowState = (FlowState) state.select(FlowState.class);
                if (flowState != null) {
                    if (((UpdateFlowStyle) action).isLandscapeFlow() && $this$reduce_u24lambda_u2d0.isSandwich()) {
                        z = true;
                    }
                    flowState.setFromSandwich(z);
                }
            }
        } else if ((action instanceof NestedAction.OnPageSelected) && ($this$reduce_u24lambda_u2d1 = (SandwichPortraitTimeState) state.select(SandwichPortraitTimeState.class)) != null) {
            $this$reduce_u24lambda_u2d1.setSumPlayTime(0);
            $this$reduce_u24lambda_u2d1.setLastUpdateTime(System.currentTimeMillis());
        }
        return state;
    }
}
