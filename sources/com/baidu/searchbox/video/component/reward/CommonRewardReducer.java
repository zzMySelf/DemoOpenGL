package com.baidu.searchbox.video.component.reward;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.NestedAction;
import com.baidu.searchbox.feed.detail.arch.ext.NetAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\tH$J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u000bH\u0017¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/video/component/reward/CommonRewardReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "mapSrcDataToRewardData", "", "action", "Lcom/baidu/searchbox/feed/detail/arch/ext/NetAction$Success;", "state", "Lcom/baidu/searchbox/video/component/reward/CommonRewardState;", "reduce", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "lib-video-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommonRewardReducer.kt */
public abstract class CommonRewardReducer implements Reducer<CommonState> {
    /* access modifiers changed from: protected */
    public abstract void mapSrcDataToRewardData(NetAction.Success<?> success, CommonRewardState commonRewardState);

    public CommonState reduce(CommonState state, Action action) {
        CommonRewardState commonRewardState;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof NetAction.Success) {
            CommonRewardState rewardState = (CommonRewardState) state.select(CommonRewardState.class);
            if (rewardState != null) {
                mapSrcDataToRewardData((NetAction.Success) action, rewardState);
            }
        } else if (action instanceof NestedAction.OnBindData) {
            CommonRewardState commonRewardState2 = (CommonRewardState) state.select(CommonRewardState.class);
            if (commonRewardState2 != null) {
                commonRewardState2.reset();
            }
        } else {
            MutableLiveData mutableLiveData = null;
            if (action instanceof RewardPanelShow) {
                CommonRewardState commonRewardState3 = (CommonRewardState) state.select(CommonRewardState.class);
                if (commonRewardState3 != null) {
                    mutableLiveData = commonRewardState3.getInvokeRewardPanel();
                }
                if (mutableLiveData != null) {
                    mutableLiveData.setValue(new CommonRewardPanelModel(((RewardPanelShow) action).getSource(), ((RewardPanelShow) action).getFrom()));
                }
            } else if (action instanceof RewardPanelHide) {
                CommonRewardState commonRewardState4 = (CommonRewardState) state.select(CommonRewardState.class);
                if (commonRewardState4 != null) {
                    mutableLiveData = commonRewardState4.getHideRewardPanel();
                }
                if (mutableLiveData != null) {
                    mutableLiveData.setValue(Unit.INSTANCE);
                }
            } else if ((action instanceof RewardPanelVisibleChangeAction) && (commonRewardState = (CommonRewardState) state.select(CommonRewardState.class)) != null) {
                commonRewardState.setPanelShow(((RewardPanelVisibleChangeAction) action).isVisible());
            }
        }
        return state;
    }
}
