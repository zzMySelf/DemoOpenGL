package com.baidu.searchbox.video.feedflow.tab.theater.topentrance;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.video.feedflow.flow.topexpand.entrance.TopEntranceReducer;
import com.baidu.searchbox.video.feedflow.flow.topexpand.entrance.TopEntranceState;
import com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/tab/theater/topentrance/TheaterTopEntranceReducer;", "Lcom/baidu/searchbox/video/feedflow/flow/topexpand/entrance/TopEntranceReducer;", "()V", "reduce", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "state", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "setToken", "", "updateVisible", "isActionEnable", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TheaterTopEntranceReducer.kt */
public final class TheaterTopEntranceReducer extends TopEntranceReducer {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v1, types: [androidx.lifecycle.MutableLiveData] */
    /* JADX WARNING: type inference failed for: r4v3, types: [androidx.lifecycle.MutableLiveData] */
    /* JADX WARNING: type inference failed for: r4v5, types: [androidx.lifecycle.MutableLiveData] */
    /* JADX WARNING: type inference failed for: r4v16 */
    /* JADX WARNING: type inference failed for: r4v17 */
    /* JADX WARNING: type inference failed for: r4v18 */
    /* JADX WARNING: type inference failed for: r4v19 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.searchbox.feed.detail.arch.ext.CommonState reduce(com.baidu.searchbox.feed.detail.arch.ext.CommonState r9, com.baidu.searchbox.feed.detail.frame.Action r10) {
        /*
            r8 = this;
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            boolean r0 = r10 instanceof com.baidu.searchbox.video.feedflow.flow.list.ListRefreshCompleteAction
            r1 = 1
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r1)
            if (r0 == 0) goto L_0x0017
            r0 = r1
            goto L_0x0019
        L_0x0017:
            boolean r0 = r10 instanceof com.baidu.searchbox.feed.detail.arch.ext.NetAction.Success
        L_0x0019:
            if (r0 == 0) goto L_0x001d
            r0 = r1
            goto L_0x001f
        L_0x001d:
            boolean r0 = r10 instanceof com.baidu.searchbox.feed.detail.arch.ext.NetAction.Failure
        L_0x001f:
            r3 = 0
            if (r0 == 0) goto L_0x006e
            r0 = r9
            r2 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.topexpand.entrance.TopEntranceState> r4 = com.baidu.searchbox.video.feedflow.flow.topexpand.entrance.TopEntranceState.class
            java.lang.Object r0 = r0.select(r4)
            com.baidu.searchbox.video.feedflow.flow.topexpand.entrance.TopEntranceState r0 = (com.baidu.searchbox.video.feedflow.flow.topexpand.entrance.TopEntranceState) r0
            if (r0 == 0) goto L_0x01c3
            r2 = 0
            androidx.lifecycle.MutableLiveData r4 = r0.getSetUsable()
            boolean r5 = r8.getUsable(r9)
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            r4.setValue(r5)
            androidx.lifecycle.MutableLiveData r4 = r0.getSetVisible()
            r5 = r9
            r6 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.theater.top.TheaterTopContainerState> r7 = com.baidu.searchbox.video.feedflow.tab.theater.top.TheaterTopContainerState.class
            java.lang.Object r5 = r5.select(r7)
            com.baidu.searchbox.video.feedflow.tab.theater.top.TheaterTopContainerState r5 = (com.baidu.searchbox.video.feedflow.tab.theater.top.TheaterTopContainerState) r5
            if (r5 == 0) goto L_0x0063
            androidx.lifecycle.MutableLiveData r5 = r5.getData()
            if (r5 == 0) goto L_0x0063
            java.lang.Object r5 = r5.getValue()
            com.baidu.searchbox.flowvideo.theater.repos.TheaterTopModel r5 = (com.baidu.searchbox.flowvideo.theater.repos.TheaterTopModel) r5
            if (r5 == 0) goto L_0x0063
            boolean r5 = r5.isAvailable()
            if (r5 != r1) goto L_0x0063
            goto L_0x0064
        L_0x0063:
            r1 = r3
        L_0x0064:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r4.setValue(r1)
            goto L_0x01c3
        L_0x006e:
            boolean r0 = r10 instanceof com.baidu.searchbox.video.feedflow.tab.theater.top.TheaterTopContainerAction.OnBindData
            r4 = 0
            if (r0 == 0) goto L_0x00d1
            r0 = r9
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.topexpand.entrance.TopEntranceState> r5 = com.baidu.searchbox.video.feedflow.flow.topexpand.entrance.TopEntranceState.class
            java.lang.Object r0 = r0.select(r5)
            com.baidu.searchbox.video.feedflow.flow.topexpand.entrance.TopEntranceState r0 = (com.baidu.searchbox.video.feedflow.flow.topexpand.entrance.TopEntranceState) r0
            if (r0 == 0) goto L_0x00cc
            r1 = 0
            androidx.lifecycle.MutableLiveData r5 = r0.getSetVisible()
            java.lang.Object r5 = r5.getValue()
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x00ca
            r3 = r9
            r5 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.FlowTabState> r6 = com.baidu.searchbox.video.feedflow.tab.FlowTabState.class
            java.lang.Object r3 = r3.select(r6)
            com.baidu.searchbox.video.feedflow.tab.FlowTabState r3 = (com.baidu.searchbox.video.feedflow.tab.FlowTabState) r3
            if (r3 == 0) goto L_0x00a8
            com.baidu.searchbox.video.feedflow.tab.TabInfoModel r3 = r3.getTabInfo()
            if (r3 == 0) goto L_0x00a8
            java.lang.String r4 = r3.getId()
        L_0x00a8:
            boolean r3 = com.baidu.searchbox.video.feedflow.utils.TabUtilsKt.isShortplayTab(r4)
            if (r3 == 0) goto L_0x00ca
            boolean r3 = com.baidu.searchbox.video.feedflow.utils.TabUtilsKt.isInShortPlayTab((com.baidu.searchbox.feed.detail.arch.ext.CommonState) r9)
            if (r3 == 0) goto L_0x00ca
            androidx.lifecycle.MutableLiveData r3 = r0.getSetUsable()
            boolean r4 = r8.getUsable(r9)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            r3.setValue(r4)
            androidx.lifecycle.MutableLiveData r3 = r0.getSetVisible()
            r3.setValue(r2)
        L_0x00ca:
        L_0x00cc:
            r8.setToken(r9)
            goto L_0x01c3
        L_0x00d1:
            boolean r0 = r10 instanceof com.baidu.searchbox.video.feedflow.tab.theater.top.TheaterTopContainerAction.RequestFailure
            if (r0 == 0) goto L_0x00ff
            r0 = r9
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.topexpand.entrance.TopEntranceState> r2 = com.baidu.searchbox.video.feedflow.flow.topexpand.entrance.TopEntranceState.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.video.feedflow.flow.topexpand.entrance.TopEntranceState r0 = (com.baidu.searchbox.video.feedflow.flow.topexpand.entrance.TopEntranceState) r0
            if (r0 == 0) goto L_0x01c3
            r1 = 0
            androidx.lifecycle.MutableLiveData r2 = r0.getSetUsable()
            boolean r4 = r8.getUsable(r9)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            r2.setValue(r4)
            androidx.lifecycle.MutableLiveData r2 = r0.getSetVisible()
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r2.setValue(r3)
            goto L_0x01c3
        L_0x00ff:
            boolean r0 = r10 instanceof com.baidu.searchbox.video.feedflow.detail.DetailItemSelected
            if (r0 == 0) goto L_0x016a
            r0 = r10
            com.baidu.searchbox.video.feedflow.detail.DetailItemSelected r0 = (com.baidu.searchbox.video.feedflow.detail.DetailItemSelected) r0
            java.lang.String r0 = r0.getTag()
            java.lang.String r1 = "item_trigger_source_flow"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x01c3
            r0 = r9
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.FlowTabState> r2 = com.baidu.searchbox.video.feedflow.tab.FlowTabState.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.video.feedflow.tab.FlowTabState r0 = (com.baidu.searchbox.video.feedflow.tab.FlowTabState) r0
            if (r0 == 0) goto L_0x012a
            com.baidu.searchbox.video.feedflow.tab.TabInfoModel r0 = r0.getTabInfo()
            if (r0 == 0) goto L_0x012a
            java.lang.String r0 = r0.getId()
            goto L_0x012b
        L_0x012a:
            r0 = r4
        L_0x012b:
            boolean r0 = com.baidu.searchbox.video.feedflow.utils.TabUtilsKt.isShortplayTab(r0)
            if (r0 == 0) goto L_0x01c3
            boolean r0 = com.baidu.searchbox.video.feedflow.utils.TabUtilsKt.isInShortPlayTab((com.baidu.searchbox.feed.detail.arch.ext.CommonState) r9)
            if (r0 == 0) goto L_0x01c3
            r0 = r9
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.topexpand.entrance.TopEntranceState> r2 = com.baidu.searchbox.video.feedflow.flow.topexpand.entrance.TopEntranceState.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.video.feedflow.flow.topexpand.entrance.TopEntranceState r0 = (com.baidu.searchbox.video.feedflow.flow.topexpand.entrance.TopEntranceState) r0
            if (r0 == 0) goto L_0x0147
            androidx.lifecycle.MutableLiveData r4 = r0.getUpdateVisible()
        L_0x0147:
            if (r4 != 0) goto L_0x014b
            goto L_0x01c3
        L_0x014b:
            kotlin.Pair r0 = new kotlin.Pair
            r1 = r10
            com.baidu.searchbox.video.feedflow.detail.DetailItemSelected r1 = (com.baidu.searchbox.video.feedflow.detail.DetailItemSelected) r1
            int r1 = r1.getPosition()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r2 = r10
            com.baidu.searchbox.video.feedflow.detail.DetailItemSelected r2 = (com.baidu.searchbox.video.feedflow.detail.DetailItemSelected) r2
            boolean r2 = r2.isUp()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r0.<init>(r1, r2)
            r4.setValue(r0)
            goto L_0x01c3
        L_0x016a:
            boolean r0 = r10 instanceof com.baidu.searchbox.video.feedflow.flow.list.UpdateFlowStyle
            if (r0 == 0) goto L_0x017a
            r0 = r10
            com.baidu.searchbox.video.feedflow.flow.list.UpdateFlowStyle r0 = (com.baidu.searchbox.video.feedflow.flow.list.UpdateFlowStyle) r0
            boolean r0 = r0.isLandscapeFlow()
            r0 = r0 ^ r1
            r8.updateVisible(r9, r0)
            goto L_0x01c3
        L_0x017a:
            boolean r0 = r10 instanceof com.baidu.searchbox.video.feedflow.detail.longpressspeed.LongPressSpeedAnim
            if (r0 == 0) goto L_0x018a
            r0 = r10
            com.baidu.searchbox.video.feedflow.detail.longpressspeed.LongPressSpeedAnim r0 = (com.baidu.searchbox.video.feedflow.detail.longpressspeed.LongPressSpeedAnim) r0
            boolean r0 = r0.isStart()
            r0 = r0 ^ r1
            r8.updateVisible(r9, r0)
            goto L_0x01c3
        L_0x018a:
            boolean r0 = r10 instanceof com.baidu.searchbox.video.feedflow.flow.topexpand.expandable.TopExpandableAction.CollapseEnd
            if (r0 == 0) goto L_0x01a9
            r0 = r9
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.topexpand.entrance.TopEntranceState> r2 = com.baidu.searchbox.video.feedflow.flow.topexpand.entrance.TopEntranceState.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.video.feedflow.flow.topexpand.entrance.TopEntranceState r0 = (com.baidu.searchbox.video.feedflow.flow.topexpand.entrance.TopEntranceState) r0
            if (r0 == 0) goto L_0x019e
            androidx.lifecycle.MutableLiveData r4 = r0.getOnExpand()
        L_0x019e:
            if (r4 != 0) goto L_0x01a1
            goto L_0x01c3
        L_0x01a1:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r3)
            r4.setValue(r0)
            goto L_0x01c3
        L_0x01a9:
            boolean r0 = r10 instanceof com.baidu.searchbox.video.feedflow.flow.topexpand.expandable.TopExpandableAction.ExpandEnd
            if (r0 == 0) goto L_0x01c3
            r0 = r9
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.topexpand.entrance.TopEntranceState> r3 = com.baidu.searchbox.video.feedflow.flow.topexpand.entrance.TopEntranceState.class
            java.lang.Object r0 = r0.select(r3)
            com.baidu.searchbox.video.feedflow.flow.topexpand.entrance.TopEntranceState r0 = (com.baidu.searchbox.video.feedflow.flow.topexpand.entrance.TopEntranceState) r0
            if (r0 == 0) goto L_0x01bd
            androidx.lifecycle.MutableLiveData r4 = r0.getOnExpand()
        L_0x01bd:
            if (r4 != 0) goto L_0x01c0
            goto L_0x01c3
        L_0x01c0:
            r4.setValue(r2)
        L_0x01c3:
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r0 = super.reduce((com.baidu.searchbox.feed.detail.arch.ext.CommonState) r9, (com.baidu.searchbox.feed.detail.frame.Action) r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.tab.theater.topentrance.TheaterTopEntranceReducer.reduce(com.baidu.searchbox.feed.detail.arch.ext.CommonState, com.baidu.searchbox.feed.detail.frame.Action):com.baidu.searchbox.feed.detail.arch.ext.CommonState");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0014, code lost:
        r0 = r0.getTabInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateVisible(com.baidu.searchbox.feed.detail.arch.ext.CommonState r4, boolean r5) {
        /*
            r3 = this;
            boolean r0 = r4.isActive()
            if (r0 == 0) goto L_0x0050
            if (r5 == 0) goto L_0x0050
            r0 = r4
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.FlowTabState> r2 = com.baidu.searchbox.video.feedflow.tab.FlowTabState.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.video.feedflow.tab.FlowTabState r0 = (com.baidu.searchbox.video.feedflow.tab.FlowTabState) r0
            if (r0 == 0) goto L_0x001f
            com.baidu.searchbox.video.feedflow.tab.TabInfoModel r0 = r0.getTabInfo()
            if (r0 == 0) goto L_0x001f
            java.lang.String r0 = r0.getId()
            goto L_0x0020
        L_0x001f:
            r0 = 0
        L_0x0020:
            boolean r0 = com.baidu.searchbox.video.feedflow.utils.TabUtilsKt.isShortplayTab(r0)
            if (r0 == 0) goto L_0x0050
            boolean r0 = com.baidu.searchbox.video.feedflow.utils.TabUtilsKt.isInShortPlayTab((com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4)
            if (r0 == 0) goto L_0x0050
            r0 = r4
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.topexpand.entrance.TopEntranceState> r2 = com.baidu.searchbox.video.feedflow.flow.topexpand.entrance.TopEntranceState.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.video.feedflow.flow.topexpand.entrance.TopEntranceState r0 = (com.baidu.searchbox.video.feedflow.flow.topexpand.entrance.TopEntranceState) r0
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0041
            boolean r0 = r0.isHidden()
            if (r0 != r1) goto L_0x0041
            goto L_0x0042
        L_0x0041:
            r1 = r2
        L_0x0042:
            if (r1 != 0) goto L_0x0050
            com.baidu.searchbox.video.feedflow.di.DIFactory r0 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE
            com.baidu.searchbox.video.feedflow.tab.theater.topentrance.TheaterTopEntranceReducer$updateVisible$1 r1 = new com.baidu.searchbox.video.feedflow.tab.theater.topentrance.TheaterTopEntranceReducer$updateVisible$1
            r1.<init>(r4)
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r0.post(r1)
        L_0x0050:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.tab.theater.topentrance.TheaterTopEntranceReducer.updateVisible(com.baidu.searchbox.feed.detail.arch.ext.CommonState, boolean):void");
    }

    private final void setToken(CommonState state) {
        TopEntranceState topEntranceState = (TopEntranceState) state.select(TopEntranceState.class);
        if (topEntranceState != null) {
            topEntranceState.setToken(TheaterTopEntranceComponentKt.TOKEN + UBCManifestKt.getPage(state));
        }
    }
}
