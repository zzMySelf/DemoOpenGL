package com.baidu.searchbox.video.feedflow.detail.videopk;

import com.baidu.searchbox.comment.definition.CommentPKResult;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.State;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService;
import com.baidu.searchbox.video.feedflow.detail.videopk.VideoPkAction;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/video/feedflow/detail/videopk/VideoPkComponent$createView$1$2", "Lcom/baidu/searchbox/video/feedflow/detail/videopk/OnVideoPkClickListener;", "onCloseClick", "", "onOptionClick", "optionResult", "Lcom/baidu/searchbox/comment/definition/CommentPKResult;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoPkComponent.kt */
public final class VideoPkComponent$createView$1$2 implements OnVideoPkClickListener {
    final /* synthetic */ VideoPkComponent this$0;

    VideoPkComponent$createView$1$2(VideoPkComponent $receiver) {
        this.this$0 = $receiver;
    }

    public void onCloseClick() {
        ItemModel itemModel;
        this.this$0.closeView(false);
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            StoreExtKt.post(access$getStore, new VideoPkAction.VideoPkCloseBtnClickAction(this.this$0.videoPkModel));
        }
        Store $this$select$iv = this.this$0.getStore();
        RunTimeStatus runTimeStatus = null;
        if ($this$select$iv != null) {
            State state = $this$select$iv.getState();
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            itemModel = (ItemModel) (commonState != null ? commonState.select(ItemModel.class) : null);
        } else {
            itemModel = null;
        }
        ItemModel bindItemModel = itemModel;
        if (bindItemModel != null) {
            runTimeStatus = bindItemModel.getRunTimeStatus();
        }
        if (runTimeStatus != null) {
            runTimeStatus.setVideoPkOperated(true);
        }
    }

    public void onOptionClick(CommentPKResult optionResult) {
        ItemModel itemModel;
        Intrinsics.checkNotNullParameter(optionResult, "optionResult");
        this.this$0.onOptionClicked(optionResult);
        this.this$0.isOptionClicked = true;
        Store $this$select$iv = this.this$0.getStore();
        Integer num = null;
        if ($this$select$iv != null) {
            State state = $this$select$iv.getState();
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            itemModel = (ItemModel) (commonState != null ? commonState.select(ItemModel.class) : null);
        } else {
            itemModel = null;
        }
        ItemModel bindItemModel = itemModel;
        RunTimeStatus runTimeStatus = bindItemModel != null ? bindItemModel.getRunTimeStatus() : null;
        if (runTimeStatus != null) {
            runTimeStatus.setVideoPkOperated(true);
        }
        IPlayerComponentService iPlayerComponentService = (IPlayerComponentService) this.this$0.getManager().getService(IPlayerComponentService.class);
        if (iPlayerComponentService != null) {
            num = Integer.valueOf(iPlayerComponentService.getActualPlayDuration(true));
        }
        int actualPlayDuration = BdPlayerUtils.orZero(num);
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            StoreExtKt.post(access$getStore, new VideoPkAction.OnVideoPkOptionCheckedAction(this.this$0.videoPkModel, optionResult, actualPlayDuration));
        }
    }
}
