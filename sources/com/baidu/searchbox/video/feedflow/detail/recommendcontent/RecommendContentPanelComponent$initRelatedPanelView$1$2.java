package com.baidu.searchbox.video.feedflow.detail.recommendcontent;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.State;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.detail.business.VideoBizUtilsKt;
import com.baidu.searchbox.video.feedflow.detail.recommendcontent.action.RecommendContentPanelRequestAction;
import com.baidu.searchbox.video.feedflow.detail.recommendcontent.action.RecommendContentPanelState;
import com.baidu.searchbox.video.feedflow.detail.recommendcontent.action.RecommendContentPanelStateKt;
import com.baidu.searchbox.video.feedflow.detail.recommendcontent.adapter.RecommendContentListAdapter;
import com.baidu.searchbox.video.feedflow.detail.recommendcontent.model.RecommendContentPanelType;
import com.baidu.searchbox.video.feedflow.detail.recommendcontent.view.RecommendContentPanelView;
import com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"com/baidu/searchbox/video/feedflow/detail/recommendcontent/RecommendContentPanelComponent$initRelatedPanelView$1$2", "Lcom/baidu/searchbox/video/feedflow/detail/recommendcontent/adapter/RecommendContentListAdapter$IOnItemClickListener;", "onItemClicked", "", "position", "", "itemModel", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "onLoadingViewClicked", "isNeedRequest", "", "isHeader", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecommendContentPanelComponent.kt */
public final class RecommendContentPanelComponent$initRelatedPanelView$1$2 implements RecommendContentListAdapter.IOnItemClickListener {
    final /* synthetic */ RecommendContentPanelComponent this$0;

    RecommendContentPanelComponent$initRelatedPanelView$1$2(RecommendContentPanelComponent $receiver) {
        this.this$0 = $receiver;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.baidu.searchbox.video.feedflow.detail.recommendcontent.action.RecommendContentPanelState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.baidu.searchbox.video.feedflow.detail.recommendcontent.action.RecommendContentPanelState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.baidu.searchbox.video.feedflow.detail.recommendcontent.action.RecommendContentPanelState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.baidu.searchbox.video.feedflow.detail.recommendcontent.action.RecommendContentPanelState} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onItemClicked(int r7, com.baidu.searchbox.video.feedflow.flow.list.ItemModel<?> r8) {
        /*
            r6 = this;
            java.lang.String r0 = "itemModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            com.baidu.searchbox.video.feedflow.detail.recommendcontent.RecommendContentPanelComponent r0 = r6.this$0
            com.baidu.searchbox.feed.detail.frame.Store r0 = r0.getStore()
            r1 = 0
            if (r0 == 0) goto L_0x0038
            com.baidu.searchbox.video.feedflow.detail.recommendcontent.action.RecommendContentPanelAction$OnListItemClickAction r2 = new com.baidu.searchbox.video.feedflow.detail.recommendcontent.action.RecommendContentPanelAction$OnListItemClickAction
            com.baidu.searchbox.video.feedflow.detail.recommendcontent.RecommendContentPanelComponent r3 = r6.this$0
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r3 = r3.getManager()
            r4 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.task.IFlowTaskOperationService> r5 = com.baidu.searchbox.video.feedflow.flow.task.IFlowTaskOperationService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r3 = r3.getService(r5)
            com.baidu.searchbox.video.feedflow.flow.task.IFlowTaskOperationService r3 = (com.baidu.searchbox.video.feedflow.flow.task.IFlowTaskOperationService) r3
            if (r3 == 0) goto L_0x002b
            boolean r3 = r3.isSupportTask()
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            goto L_0x002c
        L_0x002b:
            r3 = r1
        L_0x002c:
            boolean r3 = com.baidu.searchbox.player.utils.BdPlayerUtils.orFalse(r3)
            r2.<init>(r7, r8, r3)
            com.baidu.searchbox.feed.detail.frame.Action r2 = (com.baidu.searchbox.feed.detail.frame.Action) r2
            r0.dispatch(r2)
        L_0x0038:
            com.baidu.searchbox.video.feedflow.detail.recommendcontent.RecommendContentPanelComponent r0 = r6.this$0
            boolean r0 = r0.isCollectionRecommendPanel()
            if (r0 == 0) goto L_0x0047
            com.baidu.searchbox.video.feedflow.detail.recommendcontent.RecommendContentPanelComponent r0 = r6.this$0
            r1 = 0
            r0.closePanelView(r1)
            goto L_0x006d
        L_0x0047:
            com.baidu.searchbox.video.feedflow.detail.recommendcontent.RecommendContentPanelComponent r0 = r6.this$0
            com.baidu.searchbox.feed.detail.frame.Store r0 = r0.getStore()
            if (r0 == 0) goto L_0x0066
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r0.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x005b
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x005c
        L_0x005b:
            r3 = r1
        L_0x005c:
            if (r3 == 0) goto L_0x0064
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.recommendcontent.action.RecommendContentPanelState> r1 = com.baidu.searchbox.video.feedflow.detail.recommendcontent.action.RecommendContentPanelState.class
            java.lang.Object r1 = r3.select(r1)
        L_0x0064:
            com.baidu.searchbox.video.feedflow.detail.recommendcontent.action.RecommendContentPanelState r1 = (com.baidu.searchbox.video.feedflow.detail.recommendcontent.action.RecommendContentPanelState) r1
        L_0x0066:
            if (r1 != 0) goto L_0x0069
            goto L_0x006d
        L_0x0069:
            r0 = 1
            r1.setToRecommendPage(r0)
        L_0x006d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.recommendcontent.RecommendContentPanelComponent$initRelatedPanelView$1$2.onItemClicked(int, com.baidu.searchbox.video.feedflow.flow.list.ItemModel):void");
    }

    public void onLoadingViewClicked(boolean isNeedRequest, boolean isHeader) {
        if (isNeedRequest) {
            RecommendContentPanelView panelView = this.this$0.getPanelView();
            Store access$getStore = this.this$0.getStore();
            RecommendContentPanelType recommendContentPanelType = null;
            panelView.setLoadingError(true, VideoBizUtilsKt.isFromChannelFlow(UBCManifestKt.getPage(access$getStore != null ? (AbsState) access$getStore.getState() : null)));
            Store access$getStore2 = this.this$0.getStore();
            if (access$getStore2 != null) {
                Store access$getStore3 = this.this$0.getStore();
                Store $this$select$iv = this.this$0.getStore();
                if ($this$select$iv != null) {
                    State state = $this$select$iv.getState();
                    CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
                    RecommendContentPanelState recommendContentPanelState = (RecommendContentPanelState) (commonState != null ? commonState.select(RecommendContentPanelState.class) : null);
                    if (recommendContentPanelState != null) {
                        recommendContentPanelType = recommendContentPanelState.getCurShowType();
                    }
                }
                StoreExtKt.post(access$getStore2, new RecommendContentPanelRequestAction.RequestListContent("1", RecommendContentPanelStateKt.getRecommendContentPanelRequestType(access$getStore3, recommendContentPanelType), 0, (String) null, 12, (DefaultConstructorMarker) null));
            }
        }
    }
}
