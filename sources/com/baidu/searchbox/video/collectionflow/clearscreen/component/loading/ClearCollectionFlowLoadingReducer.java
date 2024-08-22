package com.baidu.searchbox.video.collectionflow.clearscreen.component.loading;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.NetAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import com.baidu.searchbox.flowvideo.collection.repos.CollectionListModel;
import com.baidu.searchbox.video.feedflow.flow.list.FlowState;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.loading.FlowLoadingState;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/collectionflow/clearscreen/component/loading/ClearCollectionFlowLoadingReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "reduce", "state", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "collection-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClearCollectionFlowLoadingReducer.kt */
public final class ClearCollectionFlowLoadingReducer implements Reducer<CommonState> {
    public CommonState reduce(CommonState state, Action action) {
        List<ItemModel<?>> flowList;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        MutableLiveData<Boolean> mutableLiveData = null;
        boolean z = false;
        if (action instanceof NetAction.Loading) {
            FlowState flowState = (FlowState) state.select(FlowState.class);
            if (!(flowState == null || (flowList = flowState.getFlowList()) == null || flowList.isEmpty())) {
                z = true;
            }
            if (!z) {
                FlowLoadingState flowLoadingState = (FlowLoadingState) state.select(FlowLoadingState.class);
                if (flowLoadingState != null) {
                    mutableLiveData = flowLoadingState.getVisible();
                }
                if (mutableLiveData != null) {
                    mutableLiveData.setValue(true);
                }
            }
        } else if (action instanceof NetAction.Success) {
            if (((NetAction.Success) action).getData() instanceof CollectionListModel) {
                FlowLoadingState flowLoadingState2 = (FlowLoadingState) state.select(FlowLoadingState.class);
                if (flowLoadingState2 != null) {
                    mutableLiveData = flowLoadingState2.getVisible();
                }
                if (mutableLiveData != null) {
                    mutableLiveData.setValue(false);
                }
            }
        } else if (action instanceof NetAction.Failure) {
            FlowLoadingState flowLoadingState3 = (FlowLoadingState) state.select(FlowLoadingState.class);
            if (flowLoadingState3 != null) {
                mutableLiveData = flowLoadingState3.getVisible();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(false);
            }
        }
        return state;
    }
}
