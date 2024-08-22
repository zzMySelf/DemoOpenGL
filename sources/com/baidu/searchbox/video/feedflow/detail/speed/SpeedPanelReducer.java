package com.baidu.searchbox.video.feedflow.detail.speed;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import com.baidu.searchbox.player.settings.PlayerSettings;
import com.baidu.searchbox.video.feedflow.common.FlowSwitchStateKt;
import com.baidu.searchbox.video.feedflow.detail.longpressmenu.LongPressMenuSpeedClickAction;
import com.baidu.searchbox.video.feedflow.detail.more.SpeedBtnClick;
import com.baidu.searchbox.video.feedflow.flow.list.ConfigurationChangedAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/speed/SpeedPanelReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "getSwitch", "", "state", "isActive", "reduce", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpeedPanelReducer.kt */
public class SpeedPanelReducer implements Reducer<CommonState> {
    public CommonState reduce(CommonState state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        MutableLiveData mutableLiveData = null;
        if (action instanceof SpeedBtnClick) {
            if (isActive(state)) {
                SpeedPanelState speedPanelState = (SpeedPanelState) state.select(SpeedPanelState.class);
                if (speedPanelState != null) {
                    mutableLiveData = speedPanelState.getShow();
                }
                if (mutableLiveData != null) {
                    mutableLiveData.setValue(new SpeedOptionPanelModel(((SpeedBtnClick) action).getCurSpeed(), getSwitch(state), FlowSwitchStateKt.flowSwitchState(state).getAdvanceAgeModeSwitch()));
                }
            }
        } else if (action instanceof LongPressMenuSpeedClickAction) {
            if (isActive(state)) {
                SpeedPanelState speedPanelState2 = (SpeedPanelState) state.select(SpeedPanelState.class);
                if (speedPanelState2 != null) {
                    mutableLiveData = speedPanelState2.getShow();
                }
                if (mutableLiveData != null) {
                    mutableLiveData.setValue(new SpeedOptionPanelModel(((LongPressMenuSpeedClickAction) action).getCurSpeed(), getSwitch(state), FlowSwitchStateKt.flowSwitchState(state).getAdvanceAgeModeSwitch()));
                }
            }
        } else if (action instanceof ConfigurationChangedAction) {
            SpeedPanelState speedPanelState3 = (SpeedPanelState) state.select(SpeedPanelState.class);
            if (speedPanelState3 != null) {
                mutableLiveData = speedPanelState3.getScreenChange();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(Unit.INSTANCE);
            }
        }
        return state;
    }

    public boolean isActive(CommonState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return state.isActive();
    }

    public boolean getSwitch(CommonState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return !PlayerSettings.INSTANCE.getSpeedSyncSwitch();
    }
}
