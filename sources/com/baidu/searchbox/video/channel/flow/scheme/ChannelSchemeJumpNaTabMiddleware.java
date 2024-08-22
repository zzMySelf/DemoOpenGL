package com.baidu.searchbox.video.channel.flow.scheme;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.channel.flow.utils.ChannelJumpModel;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.feedflow.flow.list.FlowState;
import com.baidu.searchbox.video.feedflow.flow.list.ForceTryToLoadMore;
import com.baidu.searchbox.video.feedflow.flow.list.InsertData;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.ItemTypeManifestKt;
import com.baidu.searchbox.video.feedflow.flow.pullrefresh.PullRefreshAction;
import com.baidu.searchbox.video.feedflow.flow.pullrefresh.PullRefreshActionManifestKt;
import com.baidu.searchbox.video.feedflow.tab.FlowTabState;
import com.baidu.searchbox.video.feedflow.utils.TabUtilsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016J\u0016\u0010\u000b\u001a\u00020\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0002J \u0010\r\u001a\u00020\u000e2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J \u0010\u0011\u001a\u00020\u000e2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/video/channel/flow/scheme/ChannelSchemeJumpNaTabMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "hasData", "", "tryForceRefreshList", "", "jumpModel", "Lcom/baidu/searchbox/video/channel/flow/utils/ChannelJumpModel;", "tryForceRefreshNaTab", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelSchemeJumpNaTabMiddleware.kt */
public final class ChannelSchemeJumpNaTabMiddleware implements Middleware<CommonState> {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.baidu.searchbox.video.channel.flow.utils.ChannelJumpModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.baidu.searchbox.video.channel.flow.utils.ChannelJumpModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: com.baidu.searchbox.video.channel.flow.utils.ChannelJumpModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.baidu.searchbox.video.channel.flow.utils.ChannelJumpModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.baidu.searchbox.video.channel.flow.utils.ChannelJumpModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: com.baidu.searchbox.video.channel.flow.utils.ChannelJumpModel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.searchbox.feed.detail.frame.Action apply(com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.arch.ext.CommonState> r7, com.baidu.searchbox.feed.detail.frame.Action r8, com.baidu.searchbox.feed.detail.frame.Next<com.baidu.searchbox.feed.detail.arch.ext.CommonState> r9) {
        /*
            r6 = this;
            java.lang.String r0 = "store"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "next"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            boolean r0 = r8 instanceof com.baidu.searchbox.video.channel.flow.pageview.VideoChannelFlowPageAction.ForceRefreshNATab
            r1 = 0
            if (r0 == 0) goto L_0x0038
            r0 = r8
            com.baidu.searchbox.video.channel.flow.pageview.VideoChannelFlowPageAction$ForceRefreshNATab r0 = (com.baidu.searchbox.video.channel.flow.pageview.VideoChannelFlowPageAction.ForceRefreshNATab) r0
            java.lang.String r0 = r0.getType()
            java.lang.String r2 = "force_refresh_na_type_scheme"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 == 0) goto L_0x009b
            r0 = r8
            com.baidu.searchbox.video.channel.flow.pageview.VideoChannelFlowPageAction$ForceRefreshNATab r0 = (com.baidu.searchbox.video.channel.flow.pageview.VideoChannelFlowPageAction.ForceRefreshNATab) r0
            java.lang.Object r0 = r0.getData()
            boolean r2 = r0 instanceof com.baidu.searchbox.video.channel.flow.utils.ChannelJumpModel
            if (r2 == 0) goto L_0x0033
            r1 = r0
            com.baidu.searchbox.video.channel.flow.utils.ChannelJumpModel r1 = (com.baidu.searchbox.video.channel.flow.utils.ChannelJumpModel) r1
        L_0x0033:
            r6.tryForceRefreshNaTab(r7, r1)
            goto L_0x009b
        L_0x0038:
            boolean r0 = r8 instanceof com.baidu.searchbox.video.feedflow.flow.list.OnItemInsertedAction
            if (r0 == 0) goto L_0x009b
            r0 = r8
            com.baidu.searchbox.video.feedflow.flow.list.OnItemInsertedAction r0 = (com.baidu.searchbox.video.feedflow.flow.list.OnItemInsertedAction) r0
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r0 = r0.getData()
            java.lang.String r0 = r0.getNid()
            r2 = r7
            r3 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r2.getState()
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r5 == 0) goto L_0x0054
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x0055
        L_0x0054:
            r4 = r1
        L_0x0055:
            if (r4 == 0) goto L_0x005e
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r5 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r4 = r4.select(r5)
            goto L_0x005f
        L_0x005e:
            r4 = r1
        L_0x005f:
            com.baidu.searchbox.video.detail.core.model.IntentData r4 = (com.baidu.searchbox.video.detail.core.model.IntentData) r4
            if (r4 == 0) goto L_0x0066
            java.lang.String r2 = r4.nid
            goto L_0x0067
        L_0x0066:
            r2 = r1
        L_0x0067:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 == 0) goto L_0x009b
            r0 = r7
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r0.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x007a
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x007b
        L_0x007a:
            r3 = r1
        L_0x007b:
            if (r3 == 0) goto L_0x0083
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.FlowState> r1 = com.baidu.searchbox.video.feedflow.flow.list.FlowState.class
            java.lang.Object r1 = r3.select(r1)
        L_0x0083:
            com.baidu.searchbox.video.feedflow.flow.list.FlowState r1 = (com.baidu.searchbox.video.feedflow.flow.list.FlowState) r1
            if (r1 == 0) goto L_0x009b
            r0 = r1
            r1 = 0
            androidx.lifecycle.MutableLiveData r2 = r0.getScrollToPosition()
            int r3 = r0.getCurItemPosition()
            int r3 = r3 + 1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2.setValue(r3)
        L_0x009b:
            com.baidu.searchbox.feed.detail.frame.Action r0 = r9.next(r7, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.channel.flow.scheme.ChannelSchemeJumpNaTabMiddleware.apply(com.baidu.searchbox.feed.detail.frame.Store, com.baidu.searchbox.feed.detail.frame.Action, com.baidu.searchbox.feed.detail.frame.Next):com.baidu.searchbox.feed.detail.frame.Action");
    }

    private final void tryForceRefreshNaTab(Store<CommonState> store, ChannelJumpModel jumpModel) {
        List list;
        if (jumpModel != null && !jumpModel.isCodeStart()) {
            CommonState state = store.getState();
            Object obj = null;
            CommonState commonState = state instanceof CommonState ? state : null;
            FlowTabState flowTabState = (FlowTabState) (commonState != null ? commonState.select(FlowTabState.class) : null);
            boolean z = true;
            if ((flowTabState != null && flowTabState.isAttentionTab()) && TabUtilsKt.isAttentionTab(jumpModel.getTabId()) && TabUtilsKt.isInAttentionTab((Store<?>) store) && hasData(store)) {
                CommonState state2 = store.getState();
                CommonState commonState2 = state2 instanceof CommonState ? state2 : null;
                FlowState flowState = (FlowState) (commonState2 != null ? commonState2.select(FlowState.class) : null);
                if (flowState == null || (list = flowState.getFlowList()) == null) {
                    list = new ArrayList();
                }
                if (list.size() != 1 || (!ItemTypeManifestKt.isFollowBatchItem(list.get(0)) && !ItemTypeManifestKt.isFollowGuideItem(list.get(0)))) {
                    tryForceRefreshList(store, jumpModel);
                } else {
                    CommonState state3 = store.getState();
                    CommonState commonState3 = state3 instanceof CommonState ? state3 : null;
                    FlowState flowState2 = (FlowState) (commonState3 != null ? commonState3.select(FlowState.class) : null);
                    MutableLiveData<Unit> clearList = flowState2 != null ? flowState2.getClearList() : null;
                    if (clearList != null) {
                        clearList.setValue(Unit.INSTANCE);
                    }
                    StoreExtKt.post(store, new ForceTryToLoadMore(false, (String) null, 2, (DefaultConstructorMarker) null));
                }
            }
            CommonState state4 = store.getState();
            CommonState commonState4 = state4 instanceof CommonState ? state4 : null;
            FlowTabState flowTabState2 = (FlowTabState) (commonState4 != null ? commonState4.select(FlowTabState.class) : null);
            if ((flowTabState2 != null && flowTabState2.isRecommendTab()) && TabUtilsKt.isRecommendTab(jumpModel.getTabId()) && TabUtilsKt.isInRecommendTab((Store<?>) store) && hasData(store)) {
                tryForceRefreshList(store, jumpModel);
            }
            CommonState state5 = store.getState();
            CommonState commonState5 = state5 instanceof CommonState ? state5 : null;
            FlowTabState flowTabState3 = (FlowTabState) (commonState5 != null ? commonState5.select(FlowTabState.class) : null);
            if ((flowTabState3 != null && flowTabState3.isHotTab()) && TabUtilsKt.isHotTab(jumpModel.getTabId()) && TabUtilsKt.isInHotTab((Store<?>) store) && hasData(store)) {
                tryForceRefreshList(store, jumpModel);
            }
            CommonState state6 = store.getState();
            CommonState commonState6 = state6 instanceof CommonState ? state6 : null;
            FlowTabState flowTabState4 = (FlowTabState) (commonState6 != null ? commonState6.select(FlowTabState.class) : null);
            if ((flowTabState4 != null && flowTabState4.isNaTheaterTab()) && TabUtilsKt.isNaTheaterTab(jumpModel.getTabId()) && TabUtilsKt.isInNaTheaterTab((Store<?>) store) && hasData(store)) {
                tryForceRefreshList(store, jumpModel);
            }
            CommonState state7 = store.getState();
            CommonState commonState7 = state7 instanceof CommonState ? state7 : null;
            if (commonState7 != null) {
                obj = commonState7.select(FlowTabState.class);
            }
            FlowTabState flowTabState5 = (FlowTabState) obj;
            if (flowTabState5 == null || !flowTabState5.isShortPlayTab()) {
                z = false;
            }
            if (z && TabUtilsKt.isShortplayTab(jumpModel.getTabId()) && TabUtilsKt.isInShortPlayTab((Store<?>) store) && hasData(store)) {
                tryForceRefreshList(store, jumpModel);
            }
        }
    }

    private final boolean hasData(Store<CommonState> store) {
        CommonState state = store.getState();
        Object obj = null;
        CommonState commonState = state instanceof CommonState ? state : null;
        if (commonState != null) {
            obj = commonState.select(FlowState.class);
        }
        FlowState flowState = (FlowState) obj;
        return flowState != null && !flowState.isEmptyList();
    }

    private final void tryForceRefreshList(Store<CommonState> store, ChannelJumpModel jumpModel) {
        CommonState state = store.getState();
        Object obj = null;
        CommonState commonState = state instanceof CommonState ? state : null;
        IntentData intentData = (IntentData) (commonState != null ? commonState.select(IntentData.class) : null);
        if ((jumpModel != null ? jumpModel.getVideoInfo() : null) == null || intentData == null) {
            StoreExtKt.post(store, new PullRefreshAction.AutoRefresh(MapsKt.mutableMapOf(new Pair(PullRefreshActionManifestKt.AUTO_REFRESH_EXTEND_KEY_REFRESH_STATE, "10"))));
            return;
        }
        CommonState state2 = store.getState();
        CommonState commonState2 = state2 instanceof CommonState ? state2 : null;
        FlowState flowState = (FlowState) (commonState2 != null ? commonState2.select(FlowState.class) : null);
        if (flowState != null) {
            FlowState $this$tryForceRefreshList_u24lambda_u2d3 = flowState;
            if (jumpModel.canRefresh()) {
                CommonState state3 = store.getState();
                CommonState commonState3 = state3 instanceof CommonState ? state3 : null;
                if (commonState3 != null) {
                    obj = commonState3.select(FlowState.class);
                }
                FlowState flowState2 = (FlowState) obj;
                if (flowState2 != null) {
                    flowState2.setScrolledOnce(false);
                }
                $this$tryForceRefreshList_u24lambda_u2d3.getClearList().setValue(Unit.INSTANCE);
                ItemModel $this$tryForceRefreshList_u24lambda_u2d3_u24lambda_u2d1 = (ItemModel) CollectionsKt.getOrNull(ChannelIntentToFlowDataMapper.INSTANCE.map(intentData).getItems(), 0);
                if ($this$tryForceRefreshList_u24lambda_u2d3_u24lambda_u2d1 != null) {
                    $this$tryForceRefreshList_u24lambda_u2d3.getInsertData().setValue(new InsertData(0, $this$tryForceRefreshList_u24lambda_u2d3_u24lambda_u2d1));
                }
                StoreExtKt.post(store, new ForceTryToLoadMore(false, "8"));
                return;
            }
            ItemModel $this$tryForceRefreshList_u24lambda_u2d3_u24lambda_u2d2 = (ItemModel) CollectionsKt.getOrNull(ChannelIntentToFlowDataMapper.INSTANCE.map(intentData).getItems(), 0);
            if ($this$tryForceRefreshList_u24lambda_u2d3_u24lambda_u2d2 != null) {
                $this$tryForceRefreshList_u24lambda_u2d3.getInsertData().setValue(new InsertData($this$tryForceRefreshList_u24lambda_u2d3.getCurItemPosition() + 1, $this$tryForceRefreshList_u24lambda_u2d3_u24lambda_u2d2));
            }
        }
    }
}
