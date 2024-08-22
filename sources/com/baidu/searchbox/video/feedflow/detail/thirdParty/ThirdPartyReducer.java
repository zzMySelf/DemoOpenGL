package com.baidu.searchbox.video.feedflow.detail.thirdParty;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.NetAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailConfigModel;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel;
import com.baidu.searchbox.flowvideo.detail.repos.ThirdLogModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/thirdParty/ThirdPartyReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "reduce", "state", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ThirdPartyReducer.kt */
public final class ThirdPartyReducer implements Reducer<CommonState> {
    public CommonState reduce(CommonState state, Action action) {
        FlowDetailConfigModel conf;
        ThirdLogModel thirdLog;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof NetAction.Success) {
            Object data = ((NetAction.Success) action).getData();
            MutableLiveData<ThirdLogModel> mutableLiveData = null;
            FlowDetailModel detailModel = data instanceof FlowDetailModel ? (FlowDetailModel) data : null;
            if (!(detailModel == null || (conf = detailModel.getConf()) == null || (thirdLog = conf.getThirdLog()) == null)) {
                ThirdPartyState thirdPartyState = (ThirdPartyState) state.select(ThirdPartyState.class);
                if (thirdPartyState != null) {
                    mutableLiveData = thirdPartyState.getThirdLogModel();
                }
                if (mutableLiveData != null) {
                    mutableLiveData.setValue(thirdLog);
                }
            }
        }
        return state;
    }
}
