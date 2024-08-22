package com.baidu.searchbox.video.feedflow.flow.live;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import com.baidu.searchbox.video.feedflow.detail.liveend.OnLiveEndCountDownFinish;
import com.baidu.searchbox.video.feedflow.detail.liveend.OnLiveEndViewShowAtUnSelected;
import com.baidu.searchbox.video.feedflow.detail.liveexception.LiveExceptionCountDownDetach;
import com.baidu.searchbox.video.feedflow.detail.liveexception.LiveExceptionCountDownFinish;
import com.baidu.searchbox.video.feedflow.flow.list.FlowState;
import com.baidu.searchbox.video.feedflow.flow.list.ScrollStateChanged;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/live/LiveFlowReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "isNeedRemoveLiveItem", "", "liveItemModelNid", "", "reduce", "state", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "scrollToNextRemoveItem", "", "nid", "position", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveFlowReducer.kt */
public final class LiveFlowReducer implements Reducer<CommonState> {
    private boolean isNeedRemoveLiveItem;
    private String liveItemModelNid = "";

    public CommonState reduce(CommonState state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof LiveExceptionCountDownFinish) {
            scrollToNextRemoveItem(state, ((LiveExceptionCountDownFinish) action).getNid(), ((LiveExceptionCountDownFinish) action).getPosition());
        } else if (action instanceof OnLiveEndCountDownFinish) {
            scrollToNextRemoveItem(state, ((OnLiveEndCountDownFinish) action).getNid(), ((OnLiveEndCountDownFinish) action).getPosition());
        } else {
            boolean z = false;
            MutableLiveData<String> mutableLiveData = null;
            if (action instanceof ScrollStateChanged) {
                if (((ScrollStateChanged) action).getScrollState() == 0 && this.isNeedRemoveLiveItem) {
                    this.isNeedRemoveLiveItem = false;
                    FlowState flowState = (FlowState) state.select(FlowState.class);
                    if (flowState != null) {
                        mutableLiveData = flowState.getRemoveItemModel();
                    }
                    if (mutableLiveData != null) {
                        mutableLiveData.setValue(this.liveItemModelNid);
                    }
                }
            } else if (action instanceof LiveExceptionCountDownDetach) {
                FlowState flowState2 = (FlowState) state.select(FlowState.class);
                if (flowState2 != null) {
                    mutableLiveData = flowState2.getRemoveItemModel();
                }
                if (mutableLiveData != null) {
                    mutableLiveData.setValue(((LiveExceptionCountDownDetach) action).getNid());
                }
            } else if (action instanceof OnLiveEndViewShowAtUnSelected) {
                FlowState flowState3 = (FlowState) state.select(FlowState.class);
                if (flowState3 != null && flowState3.getScrollState() == 0) {
                    z = true;
                }
                if (z) {
                    FlowState flowState4 = (FlowState) state.select(FlowState.class);
                    if (flowState4 != null) {
                        mutableLiveData = flowState4.getRemoveItemModel();
                    }
                    if (mutableLiveData != null) {
                        mutableLiveData.setValue(((OnLiveEndViewShowAtUnSelected) action).getNid());
                    }
                }
            }
        }
        return state;
    }

    private final void scrollToNextRemoveItem(CommonState state, String nid, int position) {
        FlowState $this$scrollToNextRemoveItem_u24lambda_u2d0 = (FlowState) state.select(FlowState.class);
        if ($this$scrollToNextRemoveItem_u24lambda_u2d0 != null && position >= 0) {
            this.liveItemModelNid = nid;
            $this$scrollToNextRemoveItem_u24lambda_u2d0.getSmoothScrollToPosition().setValue(Integer.valueOf(position + 1));
            this.isNeedRemoveLiveItem = true;
        }
    }
}
