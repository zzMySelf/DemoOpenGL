package com.baidu.searchbox.video.feedflow.flow.extlog;

import com.baidu.searchbox.feed.detail.arch.ext.AuxiliaryNestedAction;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Next;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.detail.collectioncontinueplay.CollectionContinueDataUpdate;
import com.baidu.searchbox.video.feedflow.flow.list.FlowState;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.RecommendShowModel;
import com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/extlog/ModifyExtMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ModifyExtMiddleware.kt */
public final class ModifyExtMiddleware implements Middleware<CommonState> {
    public Action apply(Store<CommonState> store, Action action, Next<CommonState> next) {
        boolean z;
        FlowState flowState;
        ItemModel<?> currentPlayItemModel;
        RunTimeStatus $this$apply_u24lambda_u2d0;
        String value;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(next, "next");
        if (action instanceof AuxiliaryNestedAction.OnPageSelectedBefore) {
            z = true;
        } else {
            z = action instanceof CollectionContinueDataUpdate;
        }
        if (!(!z || (flowState = (FlowState) store.getState().select(FlowState.class)) == null || (currentPlayItemModel = flowState.getCurrentPlayItemModel()) == null || ($this$apply_u24lambda_u2d0 = currentPlayItemModel.getRunTimeStatus()) == null)) {
            StoreExtKt.post(store, new OnAutoplayModify((String) null, String.valueOf($this$apply_u24lambda_u2d0.getAutoPlayState()), 1, (DefaultConstructorMarker) null));
            RecommendShowModel recommendNextContentState = $this$apply_u24lambda_u2d0.getRecommendNextContentState();
            boolean z2 = false;
            if (recommendNextContentState != null && recommendNextContentState.isClicked()) {
                RecommendShowModel recommendNextContentState2 = $this$apply_u24lambda_u2d0.getRecommendNextContentState();
                if (recommendNextContentState2 != null && recommendNextContentState2.isDefaultText()) {
                    z2 = true;
                }
                if (z2) {
                    value = "0";
                } else {
                    value = "1";
                }
                StoreExtKt.post(store, new OnRecommendModify((String) null, value, 1, (DefaultConstructorMarker) null));
            }
            StoreExtKt.post(store, new OnPlayModeModify($this$apply_u24lambda_u2d0.getAiPlayState()));
            StoreExtKt.post(store, new OnWindowMovingUpModify($this$apply_u24lambda_u2d0.getWindowMovingUpState()));
        }
        return next.next(store, action);
    }
}
