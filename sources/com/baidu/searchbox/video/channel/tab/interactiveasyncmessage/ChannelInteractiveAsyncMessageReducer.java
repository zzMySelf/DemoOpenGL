package com.baidu.searchbox.video.channel.tab.interactiveasyncmessage;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.CoreAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.video.feedflow.channel.ChannelPageExtParamStateKt;
import com.baidu.searchbox.video.feedflow.detail.DetailItemSelected;
import com.baidu.searchbox.video.feedflow.detail.interactiveasyncmessage.InteractiveAsyncMessageReducer;
import com.baidu.searchbox.video.feedflow.detail.interactiveasyncmessage.InteractiveAsyncMessageState;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/channel/tab/interactiveasyncmessage/ChannelInteractiveAsyncMessageReducer;", "Lcom/baidu/searchbox/video/feedflow/detail/interactiveasyncmessage/InteractiveAsyncMessageReducer;", "()V", "reduce", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "state", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelInteractiveAsyncMessageReducer.kt */
public final class ChannelInteractiveAsyncMessageReducer extends InteractiveAsyncMessageReducer {
    public CommonState reduce(CommonState state, Action action) {
        InteractiveAsyncMessageState $this$reduce_u24lambda_u2d0;
        RunTimeStatus runTimeStatus;
        InteractiveAsyncMessageState interactiveAsyncMessageState;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof CoreAction.NewIntent) {
            if (ChannelPageExtParamStateKt.isFromAdTopViewPreCreate(state) && (interactiveAsyncMessageState = (InteractiveAsyncMessageState) state.select(InteractiveAsyncMessageState.class)) != null) {
                interactiveAsyncMessageState.setInterceptStart(true);
            }
        } else if (action instanceof DetailItemSelected) {
            InteractiveAsyncMessageState interactiveAsyncMessageState2 = (InteractiveAsyncMessageState) state.select(InteractiveAsyncMessageState.class);
            if (interactiveAsyncMessageState2 != null && interactiveAsyncMessageState2.isInterceptStart()) {
                ItemModel<?> itemModel = ((DetailItemSelected) action).getItemModel();
                if (!((itemModel == null || (runTimeStatus = itemModel.getRunTimeStatus()) == null || !runTimeStatus.isFromAdTopView()) ? false : true) && ($this$reduce_u24lambda_u2d0 = (InteractiveAsyncMessageState) state.select(InteractiveAsyncMessageState.class)) != null) {
                    $this$reduce_u24lambda_u2d0.setInterceptStart(false);
                    $this$reduce_u24lambda_u2d0.getCanShowNoticePopup().setValue(true);
                }
            }
        }
        return super.reduce(state, action);
    }
}
