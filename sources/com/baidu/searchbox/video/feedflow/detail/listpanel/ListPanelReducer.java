package com.baidu.searchbox.video.feedflow.detail.listpanel;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import com.baidu.searchbox.video.feedflow.detail.banner.BannerAction;
import com.baidu.searchbox.video.feedflow.detail.banner.model.FlowDetailBannerModelKt;
import com.baidu.searchbox.video.feedflow.flow.flowstyle.LandscapeFlowSwitchKt;
import com.baidu.searchbox.video.feedflow.flow.list.ConfigurationChangedAction;
import com.baidu.searchbox.video.inf.ListPanelItemModel;
import com.baidu.searchbox.video.inf.ListPanelModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/listpanel/ListPanelReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "handleData", "Lcom/baidu/searchbox/video/inf/ListPanelModel;", "data", "reduce", "state", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ListPanelReducer.kt */
public final class ListPanelReducer implements Reducer<CommonState> {
    public CommonState reduce(CommonState state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        MutableLiveData mutableLiveData = null;
        if (action instanceof BannerAction.ShowListBannerAction) {
            if (!LandscapeFlowSwitchKt.isLandscapeFlowMode((AbsState) state)) {
                ListPanelState listPanelState = (ListPanelState) state.select(ListPanelState.class);
                if (listPanelState != null) {
                    mutableLiveData = listPanelState.getShow();
                }
                if (mutableLiveData != null) {
                    mutableLiveData.setValue(handleData(((BannerAction.ShowListBannerAction) action).getData()));
                }
            }
        } else if (action instanceof ConfigurationChangedAction) {
            ListPanelState listPanelState2 = (ListPanelState) state.select(ListPanelState.class);
            if (listPanelState2 != null) {
                mutableLiveData = listPanelState2.getDismissPanel();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(Unit.INSTANCE);
            }
        }
        return state;
    }

    private final ListPanelModel handleData(ListPanelModel data) {
        List<ListPanelItemModel<?>> $this$forEach$iv;
        List redPacketList = new ArrayList();
        if (!(data == null || ($this$forEach$iv = data.getList()) == null)) {
            for (ListPanelItemModel model : $this$forEach$iv) {
                if (Intrinsics.areEqual((Object) model.getLayout(), (Object) "redPacket") || Intrinsics.areEqual((Object) model.getLayout(), (Object) FlowDetailBannerModelKt.LAYOUT_AUTO_POPUP_BIG_BANNER_GUIDE)) {
                    redPacketList.add(0, model);
                } else {
                    redPacketList.add(model);
                }
            }
        }
        if (data == null) {
            return null;
        }
        ListPanelModel $this$handleData_u24lambda_u2d1 = data;
        $this$handleData_u24lambda_u2d1.setList(redPacketList);
        return $this$handleData_u24lambda_u2d1;
    }
}
