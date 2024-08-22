package com.baidu.searchbox.video.channel.flow.flow.list;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerComplete;
import com.baidu.searchbox.video.feedflow.flow.list.ScrollStateChanged;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/video/channel/flow/flow/list/ChannelFlowListExtReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "reduce", "state", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "tryReissueRequest", "", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelFlowListExtReducer.kt */
public final class ChannelFlowListExtReducer implements Reducer<CommonState> {
    public CommonState reduce(CommonState state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof PlayerComplete) {
            tryReissueRequest(state);
        } else if (action instanceof ScrollStateChanged) {
            tryReissueRequest(state);
        }
        return state;
    }

    private final void tryReissueRequest(CommonState state) {
        ChannelFlowListState channelFlowListState = (ChannelFlowListState) state.select(ChannelFlowListState.class);
        MutableLiveData<Unit> tryReissueNotifyData = channelFlowListState != null ? channelFlowListState.getTryReissueNotifyData() : null;
        if (tryReissueNotifyData != null) {
            tryReissueNotifyData.setValue(Unit.INSTANCE);
        }
    }
}
