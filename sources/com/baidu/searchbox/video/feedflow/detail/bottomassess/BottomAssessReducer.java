package com.baidu.searchbox.video.feedflow.detail.bottomassess;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/bottomassess/BottomAssessReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "bottomAssessInfoValid", "", "state", "detailModel", "Lcom/baidu/searchbox/flowvideo/detail/repos/FlowDetailModel;", "reduce", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomAssessReducer.kt */
public final class BottomAssessReducer implements Reducer<CommonState> {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: androidx.lifecycle.MutableLiveData<java.lang.Boolean>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: androidx.lifecycle.MutableLiveData<java.lang.Boolean>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: androidx.lifecycle.MutableLiveData<java.lang.Boolean>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v37, resolved type: com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: androidx.lifecycle.MutableLiveData<java.lang.Boolean>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: androidx.lifecycle.MutableLiveData<java.lang.Boolean>} */
    /* JADX WARNING: type inference failed for: r2v14, types: [com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.searchbox.feed.detail.arch.ext.CommonState reduce(com.baidu.searchbox.feed.detail.arch.ext.CommonState r9, com.baidu.searchbox.feed.detail.frame.Action r10) {
        /*
            r8 = this;
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            boolean r0 = r10 instanceof com.baidu.searchbox.feed.detail.arch.ext.NetAction.Success
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L_0x007c
            r0 = r10
            com.baidu.searchbox.feed.detail.arch.ext.NetAction$Success r0 = (com.baidu.searchbox.feed.detail.arch.ext.NetAction.Success) r0
            java.lang.Object r0 = r0.getData()
            boolean r3 = r0 instanceof com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel
            if (r3 == 0) goto L_0x0020
            r2 = r0
            com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel r2 = (com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel) r2
        L_0x0020:
            if (r2 == 0) goto L_0x007a
            r0 = r2
            r2 = 0
            r3 = r9
            r4 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessState> r5 = com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessState.class
            java.lang.Object r3 = r3.select(r5)
            com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessState r3 = (com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessState) r3
            if (r3 == 0) goto L_0x007a
            r4 = 0
            r5 = r9
            r6 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.offline.OfflineState> r7 = com.baidu.searchbox.video.feedflow.detail.offline.OfflineState.class
            java.lang.Object r5 = r5.select(r7)
            com.baidu.searchbox.video.feedflow.detail.offline.OfflineState r5 = (com.baidu.searchbox.video.feedflow.detail.offline.OfflineState) r5
            if (r5 == 0) goto L_0x004b
            androidx.lifecycle.MutableLiveData r5 = r5.isShowOffline()
            if (r5 == 0) goto L_0x004b
            java.lang.Object r5 = r5.getValue()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            if (r5 != 0) goto L_0x004f
        L_0x004b:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)
        L_0x004f:
            java.lang.String r1 = "state.select<OfflineStat…owOffline?.value ?: false"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r1)
            boolean r1 = r5.booleanValue()
            if (r1 != 0) goto L_0x0078
            boolean r5 = r8.bottomAssessInfoValid(r9, r0)
            if (r5 == 0) goto L_0x0078
            androidx.lifecycle.MutableLiveData r5 = r3.getBottomAssessModel()
            com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessMapper r6 = com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessMapper.INSTANCE
            com.baidu.searchbox.flowvideo.detail.repos.FlowBottomAssessModel r7 = r0.getBottomAssessEntry()
            if (r7 != 0) goto L_0x0071
            com.baidu.searchbox.flowvideo.detail.repos.FlowBottomAssessModel r7 = r0.getBottomQuickCardEntry()
        L_0x0071:
            com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessModel r6 = r6.map((com.baidu.searchbox.flowvideo.detail.repos.FlowBottomAssessModel) r7)
            r5.setValue(r6)
        L_0x0078:
        L_0x007a:
            goto L_0x0157
        L_0x007c:
            boolean r0 = r10 instanceof com.baidu.searchbox.feed.detail.arch.ext.NestedAction.OnBindData
            if (r0 == 0) goto L_0x00d5
            r0 = r9
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessState> r2 = com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessState.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessState r0 = (com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessState) r0
            if (r0 == 0) goto L_0x008f
            r0.reset()
        L_0x008f:
            r0 = r9
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.ItemModel> r2 = com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r0 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r0
            if (r0 == 0) goto L_0x00d3
            r1 = 0
            com.baidu.searchbox.video.feedflow.flow.list.CommonItemData r2 = r0.getCommonItemData()
            if (r2 == 0) goto L_0x00d2
            com.baidu.searchbox.video.feedflow.flow.list.BottomAssessConditionModel r2 = r2.getBottomAssessCondition()
            if (r2 == 0) goto L_0x00d2
            r3 = 0
            r4 = r9
            r5 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessState> r6 = com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessState.class
            java.lang.Object r4 = r4.select(r6)
            com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessState r4 = (com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessState) r4
            if (r4 != 0) goto L_0x00b6
            goto L_0x00bd
        L_0x00b6:
            boolean r5 = r2.getBottomAssessWasShown()
            r4.setWasShown(r5)
        L_0x00bd:
            r4 = r9
            r5 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessState> r6 = com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessState.class
            java.lang.Object r4 = r4.select(r6)
            com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessState r4 = (com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessState) r4
            if (r4 != 0) goto L_0x00ca
            goto L_0x00d1
        L_0x00ca:
            boolean r5 = r2.getBottomAssessUserOperated()
            r4.setUserOperated(r5)
        L_0x00d1:
        L_0x00d2:
        L_0x00d3:
            goto L_0x0157
        L_0x00d5:
            boolean r0 = r10 instanceof com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessAction.AssessViewShow
            r3 = 1
            if (r0 == 0) goto L_0x00ed
            r0 = r9
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessState> r2 = com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessState.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessState r0 = (com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessState) r0
            if (r0 != 0) goto L_0x00e8
            goto L_0x0157
        L_0x00e8:
            r0.setDisplaying(r3)
            goto L_0x0157
        L_0x00ed:
            boolean r0 = r10 instanceof com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessAction.AssessViewHide
            if (r0 == 0) goto L_0x0102
            r0 = r9
            r2 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessState> r3 = com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessState.class
            java.lang.Object r0 = r0.select(r3)
            com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessState r0 = (com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessState) r0
            if (r0 != 0) goto L_0x00fe
            goto L_0x0157
        L_0x00fe:
            r0.setDisplaying(r1)
            goto L_0x0157
        L_0x0102:
            boolean r0 = r10 instanceof com.baidu.searchbox.video.feedflow.detail.longpressspeed.LongPressSpeedAnim
            if (r0 == 0) goto L_0x011e
            r0 = r9
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessState> r2 = com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessState.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessState r0 = (com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessState) r0
            if (r0 == 0) goto L_0x0157
            r1 = r10
            com.baidu.searchbox.video.feedflow.detail.longpressspeed.LongPressSpeedAnim r1 = (com.baidu.searchbox.video.feedflow.detail.longpressspeed.LongPressSpeedAnim) r1
            boolean r1 = r1.isStart()
            r1 = r1 ^ r3
            r0.changeVisible(r1)
            goto L_0x0157
        L_0x011e:
            boolean r0 = r10 instanceof com.baidu.searchbox.video.feedflow.flow.list.UpdateFlowStyle
            if (r0 == 0) goto L_0x0144
            r0 = r9
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessState> r3 = com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessState.class
            java.lang.Object r0 = r0.select(r3)
            com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessState r0 = (com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessState) r0
            if (r0 == 0) goto L_0x0132
            androidx.lifecycle.MutableLiveData r2 = r0.isLandscape()
        L_0x0132:
            if (r2 != 0) goto L_0x0135
            goto L_0x0157
        L_0x0135:
            r0 = r10
            com.baidu.searchbox.video.feedflow.flow.list.UpdateFlowStyle r0 = (com.baidu.searchbox.video.feedflow.flow.list.UpdateFlowStyle) r0
            boolean r0 = r0.isLandscapeFlow()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r2.setValue(r0)
            goto L_0x0157
        L_0x0144:
            boolean r0 = r10 instanceof com.baidu.searchbox.feed.detail.arch.ext.NestedAction.OnPageSelected
            if (r0 == 0) goto L_0x0157
            r0 = r9
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessState> r2 = com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessState.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessState r0 = (com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessState) r0
            if (r0 == 0) goto L_0x0157
            r0.resetLiveProcess()
        L_0x0157:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessReducer.reduce(com.baidu.searchbox.feed.detail.arch.ext.CommonState, com.baidu.searchbox.feed.detail.frame.Action):com.baidu.searchbox.feed.detail.arch.ext.CommonState");
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean bottomAssessInfoValid(com.baidu.searchbox.feed.detail.arch.ext.CommonState r12, com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel r13) {
        /*
            r11 = this;
            r0 = 0
            if (r13 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.baidu.searchbox.flowvideo.detail.repos.FlowDetailBottomEntryModel r1 = r13.getBottomEntry()
            if (r1 == 0) goto L_0x000b
            return r0
        L_0x000b:
            r1 = 0
            com.baidu.searchbox.flowvideo.detail.repos.FlowBottomAssessModel r1 = r13.getBottomAssessEntry()
            com.baidu.searchbox.flowvideo.detail.repos.FlowBottomAssessModel r2 = r13.getBottomQuickCardEntry()
            r3 = 1
            if (r1 != 0) goto L_0x0025
            boolean r4 = com.baidu.searchbox.video.feedflow.detail.videosummary.VideoSummaryAntionManifestKt.canShowNewVideoSummary(r12, r13)
            if (r4 != 0) goto L_0x0024
            r4 = 0
            boolean r4 = com.baidu.searchbox.video.feedflow.common.CommonStateExtKt.isFirstJump$default((com.baidu.searchbox.feed.detail.arch.ext.CommonState) r12, (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r4, (int) r3, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x0025
        L_0x0024:
            return r0
        L_0x0025:
            if (r1 != 0) goto L_0x0029
            r4 = r2
            goto L_0x002a
        L_0x0029:
            r4 = r1
        L_0x002a:
            r1 = r4
            if (r1 == 0) goto L_0x004b
            java.lang.String r4 = r1.getTitle()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r4 = r4.length()
            if (r4 <= 0) goto L_0x003b
            r4 = r3
            goto L_0x003c
        L_0x003b:
            r4 = r0
        L_0x003c:
            if (r4 == 0) goto L_0x004b
            java.util.List r4 = r1.getButton()
            int r4 = r4.size()
            r5 = 2
            if (r4 < r5) goto L_0x004b
            r4 = r3
            goto L_0x004c
        L_0x004b:
            r4 = r0
        L_0x004c:
            r5 = 0
            r5 = 1
            if (r1 == 0) goto L_0x008d
            r6 = r1
            r7 = 0
            java.util.List r8 = r1.getButton()
            java.util.Iterator r8 = r8.iterator()
        L_0x005b:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x008b
            java.lang.Object r9 = r8.next()
            com.baidu.searchbox.flowvideo.detail.repos.BottomAssessButtonItemModel r9 = (com.baidu.searchbox.flowvideo.detail.repos.BottomAssessButtonItemModel) r9
            java.lang.String r10 = r9.getText()
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            int r10 = r10.length()
            if (r10 != 0) goto L_0x0075
            r10 = r3
            goto L_0x0076
        L_0x0075:
            r10 = r0
        L_0x0076:
            if (r10 != 0) goto L_0x0089
            java.lang.String r10 = r9.getRank()
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            int r10 = r10.length()
            if (r10 != 0) goto L_0x0086
            r10 = r3
            goto L_0x0087
        L_0x0086:
            r10 = r0
        L_0x0087:
            if (r10 == 0) goto L_0x005b
        L_0x0089:
            r5 = 0
            goto L_0x005b
        L_0x008b:
        L_0x008d:
            if (r4 == 0) goto L_0x0092
            if (r5 == 0) goto L_0x0092
            r0 = r3
        L_0x0092:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessReducer.bottomAssessInfoValid(com.baidu.searchbox.feed.detail.arch.ext.CommonState, com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel):boolean");
    }
}
