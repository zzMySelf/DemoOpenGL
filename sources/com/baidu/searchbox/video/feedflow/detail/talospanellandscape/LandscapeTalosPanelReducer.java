package com.baidu.searchbox.video.feedflow.detail.talospanellandscape;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import com.baidu.searchbox.video.feedflow.detail.banner.BannerAction;
import com.baidu.searchbox.video.feedflow.detail.talospanellandscape.LandscapeTalosPanelAction;
import com.baidu.searchbox.video.feedflow.flow.flowstyle.LandscapeFlowSwitchKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/talospanellandscape/LandscapeTalosPanelReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "reduce", "state", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LandscapeTalosPanelReducer.kt */
public final class LandscapeTalosPanelReducer implements Reducer<CommonState> {
    public CommonState reduce(CommonState state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        MutableLiveData mutableLiveData = null;
        if (action instanceof BannerAction.ShowTalosPanelAction) {
            if (LandscapeFlowSwitchKt.isLandscapeFlowMode((AbsState) state)) {
                LandscapeTalosPanelState landscapeTalosPanelState = (LandscapeTalosPanelState) state.select(LandscapeTalosPanelState.class);
                if (landscapeTalosPanelState != null) {
                    mutableLiveData = landscapeTalosPanelState.getBindAndShowData();
                }
                if (mutableLiveData != null) {
                    mutableLiveData.setValue(((BannerAction.ShowTalosPanelAction) action).getModel());
                }
            }
        } else if (action instanceof LandscapeTalosPanelAction.LandscapeTalosPanleCloseAction) {
            LandscapeTalosPanelState landscapeTalosPanelState2 = (LandscapeTalosPanelState) state.select(LandscapeTalosPanelState.class);
            if (landscapeTalosPanelState2 != null) {
                mutableLiveData = landscapeTalosPanelState2.getClose();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(Unit.INSTANCE);
            }
        } else if (action instanceof LandscapeTalosPanelAction.LandscapeTalosPanleJumpHalfSwanAction) {
            LandscapeTalosPanelState landscapeTalosPanelState3 = (LandscapeTalosPanelState) state.select(LandscapeTalosPanelState.class);
            if (landscapeTalosPanelState3 != null) {
                mutableLiveData = landscapeTalosPanelState3.getJumpHalfSwanModel();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(((LandscapeTalosPanelAction.LandscapeTalosPanleJumpHalfSwanAction) action).getModel());
            }
        } else if (action instanceof LandscapeTalosPanelAction.LandscapeTalosPanleJumpCmdAction) {
            LandscapeTalosPanelState landscapeTalosPanelState4 = (LandscapeTalosPanelState) state.select(LandscapeTalosPanelState.class);
            if (landscapeTalosPanelState4 != null) {
                mutableLiveData = landscapeTalosPanelState4.getJumpCmd();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(((LandscapeTalosPanelAction.LandscapeTalosPanleJumpCmdAction) action).getCmd());
            }
        } else if (action instanceof LandscapeTalosPanelAction.LandscapJsLoadSuccessTalosPanel) {
            LandscapeTalosPanelState landscapeTalosPanelState5 = (LandscapeTalosPanelState) state.select(LandscapeTalosPanelState.class);
            if (landscapeTalosPanelState5 != null) {
                mutableLiveData = landscapeTalosPanelState5.getJsLoadSuccess();
            }
            if (mutableLiveData != null) {
                String pageId = ((LandscapeTalosPanelAction.LandscapJsLoadSuccessTalosPanel) action).getPageId();
                if (pageId == null) {
                    pageId = "";
                }
                mutableLiveData.setValue(pageId);
            }
        }
        return state;
    }
}
