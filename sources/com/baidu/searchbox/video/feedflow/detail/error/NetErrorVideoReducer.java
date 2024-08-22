package com.baidu.searchbox.video.feedflow.detail.error;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.NetAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/error/NetErrorVideoReducer;", "Lcom/baidu/searchbox/video/feedflow/detail/error/NetErrorReducer;", "()V", "reduce", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "state", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetErrorVideoReducer.kt */
public final class NetErrorVideoReducer extends NetErrorReducer {
    public CommonState reduce(CommonState state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if ((action instanceof NetAction.Failure) && Intrinsics.areEqual((Object) ((NetAction.Failure) action).getClazz(), (Object) FlowDetailModel.class)) {
            NetErrorState netErrorState = (NetErrorState) state.select(NetErrorState.class);
            MutableLiveData<Boolean> isNetErrorVisible = netErrorState != null ? netErrorState.isNetErrorVisible() : null;
            if (isNetErrorVisible != null) {
                isNetErrorVisible.setValue(true);
            }
        }
        return super.reduce(state, action);
    }
}
