package com.baidu.searchbox.video.feedflow.detail.batch;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.CoreState;
import com.baidu.searchbox.feed.detail.arch.ext.NestedAction;
import com.baidu.searchbox.feed.detail.arch.ext.NetAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import com.baidu.searchbox.flowvideo.detail.repos.FlowBatchModel;
import com.baidu.searchbox.video.feedflow.detail.batch.BatchCardAction;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.ItemTypeManifestKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u001c\u0010\n\u001a\u00020\u000b2\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u001c\u0010\r\u001a\u00020\u000b2\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u001c\u0010\u000f\u001a\u00020\u000b2\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/batch/BatchCardReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "isPageSelected", "", "state", "reduce", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "reduceToFail", "", "Lcom/baidu/searchbox/feed/detail/arch/ext/NetAction$Failure;", "reduceToLoading", "Lcom/baidu/searchbox/feed/detail/arch/ext/NetAction$Loading;", "reduceToSuccess", "Lcom/baidu/searchbox/feed/detail/arch/ext/NetAction$Success;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BatchCardReducer.kt */
public final class BatchCardReducer implements Reducer<CommonState> {
    public CommonState reduce(CommonState state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof NetAction.Success) {
            reduceToSuccess((NetAction.Success) action, state);
        } else if (action instanceof NestedAction.OnBindData) {
            state.put(((NestedAction.OnBindData) action).getData());
        } else if (action instanceof NetAction.Loading) {
            reduceToLoading((NetAction.Loading) action, state);
        } else if (action instanceof NetAction.Failure) {
            reduceToFail((NetAction.Failure) action, state);
        } else if (action instanceof BatchCardAction.OnCardPause) {
            BatchCardState batchCardState = (BatchCardState) state.select(BatchCardState.class);
            if (batchCardState != null) {
                batchCardState.setOperated(true);
            }
        } else if (action instanceof NestedAction.OnPageSelected) {
            BatchCardState batchCardState2 = (BatchCardState) state.select(BatchCardState.class);
            if (batchCardState2 != null) {
                batchCardState2.setOperated(false);
            }
        } else if ((action instanceof BatchCardAction.ShowScrollGuideAction) && isPageSelected(state)) {
            BatchCardState batchCardState3 = (BatchCardState) state.select(BatchCardState.class);
            MutableLiveData<Boolean> changeBottomGuideVisible = batchCardState3 != null ? batchCardState3.getChangeBottomGuideVisible() : null;
            if (changeBottomGuideVisible != null) {
                changeBottomGuideVisible.setValue(true);
            }
        }
        return state;
    }

    private final void reduceToLoading(NetAction.Loading<?> action, CommonState state) {
        if (Intrinsics.areEqual((Object) action.getClazz(), (Object) FlowBatchModel.class)) {
            BatchCardState batchCardState = (BatchCardState) state.select(BatchCardState.class);
            MutableLiveData<String> style = batchCardState != null ? batchCardState.getStyle() : null;
            if (style != null) {
                style.setValue("flow_batch_loading");
            }
        }
    }

    private final void reduceToFail(NetAction.Failure<?> action, CommonState state) {
        if (Intrinsics.areEqual((Object) action.getClazz(), (Object) FlowBatchModel.class)) {
            CoreState coreState = (CoreState) state.select(CoreState.class);
            MutableLiveData<String> mutableLiveData = null;
            MutableLiveData<NetAction> netAction = coreState != null ? coreState.getNetAction() : null;
            if (netAction != null) {
                netAction.setValue(action);
            }
            BatchCardState batchCardState = (BatchCardState) state.select(BatchCardState.class);
            if (batchCardState != null) {
                mutableLiveData = batchCardState.getStyle();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue("flow_batch_empty");
            }
        }
    }

    private final void reduceToSuccess(NetAction.Success<?> action, CommonState state) {
        String str;
        if (action.getData() instanceof FlowBatchModel) {
            ItemModel itemModel = (ItemModel) state.select(ItemModel.class);
            if (itemModel != null) {
                BatchCardState batchCardState = (BatchCardState) state.select(BatchCardState.class);
                MutableLiveData<String> style = batchCardState != null ? batchCardState.getStyle() : null;
                if (style != null) {
                    if (ItemTypeManifestKt.isFollowGuideItem((ItemModel<?>) itemModel)) {
                        str = "flow_follow_guide";
                    } else {
                        str = "flow_follow_batch";
                    }
                    style.setValue(str);
                }
            }
            BatchCardState $this$reduceToSuccess_u24lambda_u2d1 = (BatchCardState) state.select(BatchCardState.class);
            if ($this$reduceToSuccess_u24lambda_u2d1 != null) {
                MutableLiveData<FlowBatchModel> data = $this$reduceToSuccess_u24lambda_u2d1.getData();
                Object data2 = action.getData();
                if (data2 != null) {
                    data.setValue((FlowBatchModel) data2);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.flowvideo.detail.repos.FlowBatchModel");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        r0 = r0.getNestedAction();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean isPageSelected(com.baidu.searchbox.feed.detail.arch.ext.CommonState r4) {
        /*
            r3 = this;
            r0 = r4
            r1 = 0
            java.lang.Class<com.baidu.searchbox.feed.detail.arch.ext.CoreState> r2 = com.baidu.searchbox.feed.detail.arch.ext.CoreState.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.feed.detail.arch.ext.CoreState r0 = (com.baidu.searchbox.feed.detail.arch.ext.CoreState) r0
            if (r0 == 0) goto L_0x0019
            androidx.lifecycle.MutableLiveData r0 = r0.getNestedAction()
            if (r0 == 0) goto L_0x0019
            java.lang.Object r0 = r0.getValue()
            com.baidu.searchbox.feed.detail.arch.ext.NestedAction r0 = (com.baidu.searchbox.feed.detail.arch.ext.NestedAction) r0
            goto L_0x001a
        L_0x0019:
            r0 = 0
        L_0x001a:
            boolean r0 = r0 instanceof com.baidu.searchbox.feed.detail.arch.ext.NestedAction.OnPageSelected
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.batch.BatchCardReducer.isPageSelected(com.baidu.searchbox.feed.detail.arch.ext.CommonState):boolean");
    }
}
