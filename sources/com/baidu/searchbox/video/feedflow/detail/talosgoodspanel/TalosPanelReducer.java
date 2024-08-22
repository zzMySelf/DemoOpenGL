package com.baidu.searchbox.video.feedflow.detail.talosgoodspanel;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import com.baidu.searchbox.video.feedflow.detail.banner.BannerAction;
import com.baidu.searchbox.video.feedflow.detail.talosgoodspanel.TalosPanelAction;
import com.baidu.searchbox.video.feedflow.flow.flowstyle.LandscapeFlowSwitchKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/talosgoodspanel/TalosPanelReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "reduce", "state", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TalosPanelReducer.kt */
public final class TalosPanelReducer implements Reducer<CommonState> {
    public CommonState reduce(CommonState state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        MutableLiveData mutableLiveData = null;
        if (action instanceof BannerAction.ShowTalosPanelAction) {
            if (!LandscapeFlowSwitchKt.isLandscapeFlowMode((AbsState) state)) {
                TalosPanelState talosPanelState = (TalosPanelState) state.select(TalosPanelState.class);
                if (talosPanelState != null) {
                    mutableLiveData = talosPanelState.getBindAndShowData();
                }
                if (mutableLiveData != null) {
                    mutableLiveData.setValue(((BannerAction.ShowTalosPanelAction) action).getModel());
                }
            }
        } else if (action instanceof TalosPanelAction.TalosPanleCloseAction) {
            TalosPanelState talosPanelState2 = (TalosPanelState) state.select(TalosPanelState.class);
            if (talosPanelState2 != null) {
                mutableLiveData = talosPanelState2.getClose();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(Boolean.valueOf(((TalosPanelAction.TalosPanleCloseAction) action).isItemClick()));
            }
        } else if (action instanceof TalosPanelAction.JsLoadSuccessTalosPanel) {
            TalosPanelState talosPanelState3 = (TalosPanelState) state.select(TalosPanelState.class);
            if (talosPanelState3 != null) {
                mutableLiveData = talosPanelState3.getJsLoadSuccess();
            }
            if (mutableLiveData != null) {
                String pageId = ((TalosPanelAction.JsLoadSuccessTalosPanel) action).getPageId();
                if (pageId == null) {
                    pageId = "";
                }
                mutableLiveData.setValue(pageId);
            }
        } else if (action instanceof TalosPanelAction.TalosPanleJumpHalfSwanAction) {
            TalosPanelState talosPanelState4 = (TalosPanelState) state.select(TalosPanelState.class);
            if (talosPanelState4 != null) {
                mutableLiveData = talosPanelState4.getJumpHalfSwanModel();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(((TalosPanelAction.TalosPanleJumpHalfSwanAction) action).getModel());
            }
        }
        return state;
    }
}
