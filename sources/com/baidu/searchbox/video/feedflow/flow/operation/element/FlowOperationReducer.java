package com.baidu.searchbox.video.feedflow.flow.operation.element;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/operation/element/FlowOperationReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "reduce", "state", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowOperationReducer.kt */
public class FlowOperationReducer implements Reducer<CommonState> {
    /* JADX WARNING: Removed duplicated region for block: B:226:0x04a4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.searchbox.feed.detail.arch.ext.CommonState reduce(com.baidu.searchbox.feed.detail.arch.ext.CommonState r27, com.baidu.searchbox.feed.detail.frame.Action r28) {
        /*
            r26 = this;
            r1 = r27
            r2 = r28
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            boolean r0 = r2 instanceof com.baidu.searchbox.video.feedflow.detail.DetailItemSelected
            r3 = 0
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r3)
            r6 = 1
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r6)
            if (r0 == 0) goto L_0x008a
            r0 = r27
            r4 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState> r7 = com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState.class
            java.lang.Object r0 = r0.select(r7)
            com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState r0 = (com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState) r0
            if (r0 == 0) goto L_0x05f2
            androidx.lifecycle.MutableLiveData r0 = r0.getOperationData()
            if (r0 == 0) goto L_0x05f2
            java.lang.Object r0 = r0.getValue()
            com.baidu.searchbox.flowvideo.detail.repos.TopOperationModel r0 = (com.baidu.searchbox.flowvideo.detail.repos.TopOperationModel) r0
            if (r0 == 0) goto L_0x05f2
            r4 = 0
            boolean r7 = r0.isFloatMode()
            if (r7 == 0) goto L_0x0083
            r7 = r27
            r8 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState> r9 = com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState.class
            java.lang.Object r7 = r7.select(r9)
            com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState r7 = (com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState) r7
            if (r7 == 0) goto L_0x0054
            boolean r7 = r7.isOperationTimer()
            if (r7 != r6) goto L_0x0054
            r3 = r6
        L_0x0054:
            if (r3 != 0) goto L_0x0083
            r3 = r27
            r7 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState> r8 = com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState.class
            java.lang.Object r3 = r3.select(r8)
            com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState r3 = (com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState) r3
            if (r3 == 0) goto L_0x0068
            androidx.lifecycle.MutableLiveData r5 = r3.getTryReCreateOperationView()
            goto L_0x0069
        L_0x0068:
            r5 = 0
        L_0x0069:
            if (r5 != 0) goto L_0x006c
            goto L_0x0071
        L_0x006c:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r5.setValue(r3)
        L_0x0071:
            r3 = r27
            r5 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState> r7 = com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState.class
            java.lang.Object r3 = r3.select(r7)
            com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState r3 = (com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState) r3
            if (r3 == 0) goto L_0x0083
            r3.showOrHideOperation(r6)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
        L_0x0083:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x05f2
        L_0x008a:
            boolean r0 = r2 instanceof com.baidu.searchbox.video.feedflow.detail.offline.OfflineVisibleChanged
            if (r0 == 0) goto L_0x00ab
            r0 = r2
            com.baidu.searchbox.video.feedflow.detail.offline.OfflineVisibleChanged r0 = (com.baidu.searchbox.video.feedflow.detail.offline.OfflineVisibleChanged) r0
            boolean r0 = r0.isVisible()
            if (r0 == 0) goto L_0x05f2
            r0 = r27
            r4 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState> r5 = com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState.class
            java.lang.Object r0 = r0.select(r5)
            com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState r0 = (com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState) r0
            if (r0 == 0) goto L_0x05f2
            r0.showOrHideOperation(r3)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x05f2
        L_0x00ab:
            boolean r0 = r2 instanceof com.baidu.searchbox.video.feedflow.detail.longpressspeed.LongPressSpeedAnim
            if (r0 == 0) goto L_0x00cb
            r0 = r27
            r3 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState> r4 = com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState.class
            java.lang.Object r0 = r0.select(r4)
            com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState r0 = (com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState) r0
            if (r0 == 0) goto L_0x05f2
            r3 = r2
            com.baidu.searchbox.video.feedflow.detail.longpressspeed.LongPressSpeedAnim r3 = (com.baidu.searchbox.video.feedflow.detail.longpressspeed.LongPressSpeedAnim) r3
            boolean r3 = r3.isStart()
            r3 = r3 ^ r6
            r0.showOrHideOperation(r3)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x05f2
        L_0x00cb:
            boolean r0 = r2 instanceof com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperationAction.HideOrShowFloatingOperation
            if (r0 == 0) goto L_0x0119
            r0 = r27
            r3 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState> r4 = com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState.class
            java.lang.Object r0 = r0.select(r4)
            com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState r0 = (com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState) r0
            if (r0 == 0) goto L_0x00fe
            r3 = 0
            r4 = r2
            com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperationAction$HideOrShowFloatingOperation r4 = (com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperationAction.HideOrShowFloatingOperation) r4
            boolean r4 = r4.isShow()
            if (r4 != 0) goto L_0x00f9
            r4 = r1
            com.baidu.searchbox.feed.detail.frame.AbsState r4 = (com.baidu.searchbox.feed.detail.frame.AbsState) r4
            boolean r4 = r0.isAtCnyTabId(r4)
            if (r4 != 0) goto L_0x00f8
            r4 = r1
            com.baidu.searchbox.feed.detail.frame.AbsState r4 = (com.baidu.searchbox.feed.detail.frame.AbsState) r4
            boolean r4 = r0.isAtWealthTabId(r4)
            if (r4 == 0) goto L_0x00f9
        L_0x00f8:
            return r1
        L_0x00f9:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x00fe:
            r0 = r27
            r3 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState> r4 = com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState.class
            java.lang.Object r0 = r0.select(r4)
            com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState r0 = (com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState) r0
            if (r0 == 0) goto L_0x05f2
            r3 = r2
            com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperationAction$HideOrShowFloatingOperation r3 = (com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperationAction.HideOrShowFloatingOperation) r3
            boolean r3 = r3.isShow()
            r0.showOrHideOperation(r3)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x05f2
        L_0x0119:
            boolean r0 = r2 instanceof com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperationAction.InitFlowOperationDataAction
            if (r0 == 0) goto L_0x019f
            r0 = r27
            r4 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState> r7 = com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState.class
            java.lang.Object r0 = r0.select(r7)
            com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState r0 = (com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState) r0
            if (r0 == 0) goto L_0x0138
            androidx.lifecycle.MutableLiveData r0 = r0.getOperationData()
            if (r0 == 0) goto L_0x0138
            java.lang.Object r0 = r0.getValue()
            r5 = r0
            com.baidu.searchbox.flowvideo.detail.repos.TopOperationModel r5 = (com.baidu.searchbox.flowvideo.detail.repos.TopOperationModel) r5
            goto L_0x0139
        L_0x0138:
            r5 = 0
        L_0x0139:
            if (r5 != 0) goto L_0x05f2
            r0 = r27
            r4 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState> r5 = com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState.class
            java.lang.Object r0 = r0.select(r5)
            com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState r0 = (com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState) r0
            if (r0 == 0) goto L_0x014f
            boolean r0 = r0.isOperationTimer()
            if (r0 != r6) goto L_0x014f
            r3 = r6
        L_0x014f:
            if (r3 != 0) goto L_0x05f2
            r0 = r2
            com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperationAction$InitFlowOperationDataAction r0 = (com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperationAction.InitFlowOperationDataAction) r0
            com.baidu.searchbox.flowvideo.detail.repos.TopOperationModel r0 = r0.getData()
            boolean r0 = r0.isFloatMode()
            if (r0 == 0) goto L_0x05f2
            com.baidu.searchbox.video.feedflow.flow.operation.element.RecordCloseOperationActivityIdsUtils r0 = com.baidu.searchbox.video.feedflow.flow.operation.element.RecordCloseOperationActivityIdsUtils.INSTANCE
            r3 = r2
            com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperationAction$InitFlowOperationDataAction r3 = (com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperationAction.InitFlowOperationDataAction) r3
            com.baidu.searchbox.flowvideo.detail.repos.TopOperationModel r3 = r3.getData()
            java.lang.String r3 = r3.getActivityId()
            boolean r0 = r0.isContainsOperationCloseId(r3)
            if (r0 != 0) goto L_0x05f2
            com.baidu.searchbox.video.feedflow.flow.operation.element.RecordCloseOperationActivityIdsUtils r0 = com.baidu.searchbox.video.feedflow.flow.operation.element.RecordCloseOperationActivityIdsUtils.INSTANCE
            r3 = r2
            com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperationAction$InitFlowOperationDataAction r3 = (com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperationAction.InitFlowOperationDataAction) r3
            com.baidu.searchbox.flowvideo.detail.repos.TopOperationModel r3 = r3.getData()
            java.lang.String r3 = r3.getEndTime()
            boolean r0 = r0.isExpire(r3)
            if (r0 != 0) goto L_0x05f2
            r0 = r27
            r3 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState> r4 = com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState.class
            java.lang.Object r0 = r0.select(r4)
            com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState r0 = (com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState) r0
            if (r0 == 0) goto L_0x05f2
            r3 = r2
            com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperationAction$InitFlowOperationDataAction r3 = (com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperationAction.InitFlowOperationDataAction) r3
            com.baidu.searchbox.flowvideo.detail.repos.TopOperationModel r3 = r3.getData()
            r0.bindData(r3)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x05f2
        L_0x019f:
            boolean r0 = r2 instanceof com.baidu.searchbox.video.feedflow.detail.player.PlayerOrientationChanged
            if (r0 == 0) goto L_0x01bf
            r0 = r27
            r3 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState> r4 = com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState.class
            java.lang.Object r0 = r0.select(r4)
            com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState r0 = (com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState) r0
            if (r0 == 0) goto L_0x05f2
            r3 = r2
            com.baidu.searchbox.video.feedflow.detail.player.PlayerOrientationChanged r3 = (com.baidu.searchbox.video.feedflow.detail.player.PlayerOrientationChanged) r3
            boolean r3 = r3.isFullScreen()
            r3 = r3 ^ r6
            r0.showOrHideOperation(r3)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x05f2
        L_0x01bf:
            boolean r0 = r2 instanceof com.baidu.searchbox.video.feedflow.tab.TabComponentAction.OnTabSelectedAction
            if (r0 == 0) goto L_0x0211
            r0 = r2
            com.baidu.searchbox.video.feedflow.tab.TabComponentAction$OnTabSelectedAction r0 = (com.baidu.searchbox.video.feedflow.tab.TabComponentAction.OnTabSelectedAction) r0
            com.baidu.searchbox.video.feedflow.tab.TabInfoModel r0 = r0.getSelectedTabInfo()
            java.lang.String r0 = r0.getPageType()
            java.lang.String r4 = "talos"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r4)
            if (r0 != 0) goto L_0x01fd
            r0 = r2
            com.baidu.searchbox.video.feedflow.tab.TabComponentAction$OnTabSelectedAction r0 = (com.baidu.searchbox.video.feedflow.tab.TabComponentAction.OnTabSelectedAction) r0
            com.baidu.searchbox.video.feedflow.tab.TabInfoModel r0 = r0.getSelectedTabInfo()
            java.lang.String r0 = r0.getPageType()
            java.lang.String r4 = "H5"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r4)
            if (r0 != 0) goto L_0x01fd
            r0 = r2
            com.baidu.searchbox.video.feedflow.tab.TabComponentAction$OnTabSelectedAction r0 = (com.baidu.searchbox.video.feedflow.tab.TabComponentAction.OnTabSelectedAction) r0
            com.baidu.searchbox.video.feedflow.tab.TabInfoModel r0 = r0.getSelectedTabInfo()
            java.lang.String r0 = r0.getId()
            java.lang.String r4 = "4"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r4)
            if (r0 == 0) goto L_0x05f2
        L_0x01fd:
            r0 = r27
            r4 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState> r5 = com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState.class
            java.lang.Object r0 = r0.select(r5)
            com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState r0 = (com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState) r0
            if (r0 == 0) goto L_0x05f2
            r0.showOrHideOperation(r3)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x05f2
        L_0x0211:
            boolean r0 = r2 instanceof com.baidu.searchbox.video.feedflow.detail.CompressionStartAction
            if (r0 == 0) goto L_0x0229
            r0 = r27
            r4 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState> r5 = com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState.class
            java.lang.Object r0 = r0.select(r5)
            com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState r0 = (com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState) r0
            if (r0 == 0) goto L_0x05f2
            r0.showOrHideOperation(r3)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x05f2
        L_0x0229:
            boolean r0 = r2 instanceof com.baidu.searchbox.video.feedflow.detail.CompressionEndAction
            if (r0 == 0) goto L_0x0241
            r0 = r27
            r3 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState> r4 = com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState.class
            java.lang.Object r0 = r0.select(r4)
            com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState r0 = (com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState) r0
            if (r0 == 0) goto L_0x05f2
            r0.showOrHideOperation(r6)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x05f2
        L_0x0241:
            boolean r0 = r2 instanceof com.baidu.searchbox.feed.detail.arch.ext.CrossLayerServiceRegistered
            if (r0 == 0) goto L_0x0274
            r0 = r27
            r3 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState> r4 = com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState.class
            java.lang.Object r0 = r0.select(r4)
            com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState r0 = (com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState) r0
            if (r0 == 0) goto L_0x0257
            androidx.lifecycle.MutableLiveData r5 = r0.getTransmitServiceRegistered()
            goto L_0x0258
        L_0x0257:
            r5 = 0
        L_0x0258:
            if (r5 != 0) goto L_0x025b
            goto L_0x0260
        L_0x025b:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r5.setValue(r0)
        L_0x0260:
            r0 = r27
            r3 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState> r4 = com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState.class
            java.lang.Object r0 = r0.select(r4)
            com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState r0 = (com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState) r0
            if (r0 == 0) goto L_0x05f2
            r0.showOrHideOperation(r6)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x05f2
        L_0x0274:
            boolean r0 = r2 instanceof com.baidu.searchbox.video.feedflow.flow.topexpand.expandable.TopExpandableAction.CollapseEnd
            if (r0 == 0) goto L_0x02ac
            r0 = r27
            r3 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.TabState> r4 = com.baidu.searchbox.video.feedflow.tab.TabState.class
            java.lang.Object r0 = r0.select(r4)
            com.baidu.searchbox.video.feedflow.tab.TabState r0 = (com.baidu.searchbox.video.feedflow.tab.TabState) r0
            if (r0 == 0) goto L_0x028a
            java.lang.String r5 = r0.getCurrentTabId()
            goto L_0x028b
        L_0x028a:
            r5 = 0
        L_0x028b:
            r0 = r5
            boolean r3 = com.baidu.searchbox.video.feedflow.utils.TabUtilsKt.isNaTheaterTab(r0)
            if (r3 != 0) goto L_0x0298
            boolean r3 = com.baidu.searchbox.video.feedflow.utils.TabUtilsKt.isShortplayTab(r0)
            if (r3 == 0) goto L_0x05f2
        L_0x0298:
            r3 = r27
            r4 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState> r5 = com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState.class
            java.lang.Object r3 = r3.select(r5)
            com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState r3 = (com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState) r3
            if (r3 == 0) goto L_0x05f2
            r3.showOrHideOperation(r6)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            goto L_0x05f2
        L_0x02ac:
            boolean r0 = r2 instanceof com.baidu.searchbox.video.feedflow.flow.topexpand.entrance.TopEntranceAction.Click
            if (r0 == 0) goto L_0x02ed
            r0 = r27
            r4 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.TabState> r6 = com.baidu.searchbox.video.feedflow.tab.TabState.class
            java.lang.Object r0 = r0.select(r6)
            com.baidu.searchbox.video.feedflow.tab.TabState r0 = (com.baidu.searchbox.video.feedflow.tab.TabState) r0
            if (r0 == 0) goto L_0x02c2
            java.lang.String r5 = r0.getCurrentTabId()
            goto L_0x02c3
        L_0x02c2:
            r5 = 0
        L_0x02c3:
            r0 = r5
            r4 = r2
            com.baidu.searchbox.video.feedflow.flow.topexpand.entrance.TopEntranceAction$Click r4 = (com.baidu.searchbox.video.feedflow.flow.topexpand.entrance.TopEntranceAction.Click) r4
            boolean r4 = r4.isExpand()
            if (r4 == 0) goto L_0x05f2
            boolean r4 = com.baidu.searchbox.video.feedflow.utils.TabUtilsKt.isNaTheaterTab(r0)
            if (r4 != 0) goto L_0x02d9
            boolean r4 = com.baidu.searchbox.video.feedflow.utils.TabUtilsKt.isShortplayTab(r0)
            if (r4 == 0) goto L_0x05f2
        L_0x02d9:
            r4 = r27
            r5 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState> r6 = com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState.class
            java.lang.Object r4 = r4.select(r6)
            com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState r4 = (com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState) r4
            if (r4 == 0) goto L_0x05f2
            r4.showOrHideOperation(r3)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            goto L_0x05f2
        L_0x02ed:
            boolean r0 = r2 instanceof com.baidu.searchbox.feed.detail.arch.ext.CoreAction.NewIntent
            if (r0 == 0) goto L_0x04ad
            r0 = r2
            com.baidu.searchbox.feed.detail.arch.ext.CoreAction$NewIntent r0 = (com.baidu.searchbox.feed.detail.arch.ext.CoreAction.NewIntent) r0
            java.lang.Object r0 = r0.getData()
            boolean r4 = r0 instanceof com.baidu.searchbox.video.detail.core.model.IntentData
            if (r4 == 0) goto L_0x02ff
            com.baidu.searchbox.video.detail.core.model.IntentData r0 = (com.baidu.searchbox.video.detail.core.model.IntentData) r0
            goto L_0x0300
        L_0x02ff:
            r0 = 0
        L_0x0300:
            if (r0 == 0) goto L_0x05f2
            r4 = r0
            r7 = 0
            r0 = 0
            r8 = 0
            r9 = 0
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ Exception -> 0x0499 }
            java.lang.String r11 = r4.ext     // Catch:{ Exception -> 0x0499 }
            r10.<init>(r11)     // Catch:{ Exception -> 0x0499 }
            r11 = 0
            java.lang.String r12 = "operationActivityID"
            java.lang.String r12 = r10.optString(r12)     // Catch:{ Exception -> 0x0499 }
            java.lang.String r13 = "optString(OPERATION_ACTIVITY_ID_KEY)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r13)     // Catch:{ Exception -> 0x0499 }
            r0 = r12
            java.lang.String r12 = "activityTimer"
            java.lang.String r12 = r10.optString(r12)     // Catch:{ Exception -> 0x0499 }
            java.lang.String r13 = "optString(ACTIVITY_TIMER)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r13)     // Catch:{ Exception -> 0x0499 }
            com.baidu.searchbox.video.feedflow.flow.operation.timer.ActivityTimer r12 = com.baidu.searchbox.video.feedflow.flow.operation.utils.OperationUtilKt.parseActivityTimerModel(r12)     // Catch:{ Exception -> 0x0499 }
            if (r12 == 0) goto L_0x03f5
            r13 = 0
            com.baidu.searchbox.video.feedflow.flow.operation.timer.FuncInfo r14 = r12.getFuncInfo()     // Catch:{ Exception -> 0x0499 }
            if (r14 == 0) goto L_0x03ed
            com.baidu.searchbox.video.feedflow.flow.operation.timer.FunInfoByInt r14 = r14.toIntData()     // Catch:{ Exception -> 0x0499 }
            if (r14 == 0) goto L_0x03ed
            r15 = 0
            r8 = 1
            com.baidu.searchbox.video.feedflow.flow.operation.timer.ActivityTimerWrapper r5 = new com.baidu.searchbox.video.feedflow.flow.operation.timer.ActivityTimerWrapper     // Catch:{ Exception -> 0x0499 }
            r5.<init>(r12, r14)     // Catch:{ Exception -> 0x0499 }
            com.baidu.searchbox.video.feedflow.flow.operation.utils.OperationHelper r16 = com.baidu.searchbox.video.feedflow.flow.operation.utils.OperationHelper.INSTANCE     // Catch:{ Exception -> 0x0499 }
            java.util.Map r6 = r16.getTasks()     // Catch:{ Exception -> 0x0499 }
            java.lang.String r3 = r14.getActivityID()     // Catch:{ Exception -> 0x0499 }
            java.lang.Object r3 = r6.get(r3)     // Catch:{ Exception -> 0x0499 }
            java.lang.ref.WeakReference r3 = (java.lang.ref.WeakReference) r3     // Catch:{ Exception -> 0x0499 }
            if (r3 == 0) goto L_0x035f
            java.lang.Object r3 = r3.get()     // Catch:{ Exception -> 0x035a }
            com.baidu.searchbox.video.feedflow.flow.operation.timer.ActivityTimerWrapper r3 = (com.baidu.searchbox.video.feedflow.flow.operation.timer.ActivityTimerWrapper) r3     // Catch:{ Exception -> 0x035a }
            goto L_0x0360
        L_0x035a:
            r0 = move-exception
            r17 = r4
            goto L_0x049c
        L_0x035f:
            r3 = 0
        L_0x0360:
            if (r3 == 0) goto L_0x0373
            com.baidu.searchbox.video.feedflow.flow.operation.timer.FunInfoByInt r6 = r3.getFunInfoByInt()     // Catch:{ Exception -> 0x0499 }
            r17 = r4
            com.baidu.searchbox.video.feedflow.flow.operation.timer.FunInfoByInt r4 = r5.getFunInfoByInt()     // Catch:{ Exception -> 0x0497 }
            r6.updateData(r4)     // Catch:{ Exception -> 0x0497 }
            r4 = r3
            r18 = r3
            goto L_0x038a
        L_0x0373:
            r17 = r4
            r4 = r5
            com.baidu.searchbox.video.feedflow.flow.operation.utils.OperationHelper r6 = com.baidu.searchbox.video.feedflow.flow.operation.utils.OperationHelper.INSTANCE     // Catch:{ Exception -> 0x0497 }
            java.util.Map r6 = r6.getTasks()     // Catch:{ Exception -> 0x0497 }
            java.lang.String r9 = r14.getActivityID()     // Catch:{ Exception -> 0x0497 }
            r18 = r3
            java.lang.ref.WeakReference r3 = new java.lang.ref.WeakReference     // Catch:{ Exception -> 0x0497 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0497 }
            r6.put(r9, r3)     // Catch:{ Exception -> 0x0497 }
        L_0x038a:
            com.baidu.searchbox.video.feedflow.flow.operation.utils.OperationHelper r3 = com.baidu.searchbox.video.feedflow.flow.operation.utils.OperationHelper.INSTANCE     // Catch:{ Exception -> 0x0497 }
            java.util.Map r3 = r3.getTasks()     // Catch:{ Exception -> 0x0497 }
            r6 = 0
            java.util.Set r9 = r3.entrySet()     // Catch:{ Exception -> 0x0497 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ Exception -> 0x0497 }
        L_0x0399:
            boolean r19 = r9.hasNext()     // Catch:{ Exception -> 0x0497 }
            if (r19 == 0) goto L_0x03e1
            java.lang.Object r19 = r9.next()     // Catch:{ Exception -> 0x0497 }
            java.util.Map$Entry r19 = (java.util.Map.Entry) r19     // Catch:{ Exception -> 0x0497 }
            r20 = r19
            r21 = 0
            java.lang.Object r22 = r20.getValue()     // Catch:{ Exception -> 0x0497 }
            java.lang.ref.WeakReference r22 = (java.lang.ref.WeakReference) r22     // Catch:{ Exception -> 0x0497 }
            java.lang.Object r22 = r22.get()     // Catch:{ Exception -> 0x0497 }
            com.baidu.searchbox.video.feedflow.flow.operation.timer.ActivityTimerWrapper r22 = (com.baidu.searchbox.video.feedflow.flow.operation.timer.ActivityTimerWrapper) r22     // Catch:{ Exception -> 0x0497 }
            if (r22 == 0) goto L_0x03d6
            com.baidu.searchbox.video.feedflow.flow.operation.timer.FunInfoByInt r22 = r22.getFunInfoByInt()     // Catch:{ Exception -> 0x0497 }
            if (r22 == 0) goto L_0x03d6
            r23 = r22
            r22 = 0
            r24 = r3
            int r3 = r23.getCurrentStep()     // Catch:{ Exception -> 0x0497 }
            r25 = r4
            r4 = r23
            r4.setInitStep(r3)     // Catch:{ Exception -> 0x0497 }
            r3 = 0
            r4.setCurrentDuration(r3)     // Catch:{ Exception -> 0x0497 }
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0497 }
            goto L_0x03db
        L_0x03d6:
            r24 = r3
            r25 = r4
            r3 = 0
        L_0x03db:
            r3 = r24
            r4 = r25
            goto L_0x0399
        L_0x03e1:
            r24 = r3
            r25 = r4
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0497 }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0497 }
            r9 = r25
            goto L_0x03ef
        L_0x03ed:
            r17 = r4
        L_0x03ef:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0497 }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0497 }
            goto L_0x03f7
        L_0x03f5:
            r17 = r4
        L_0x03f7:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0497 }
            r3 = r27
            r4 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState> r5 = com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState.class
            java.lang.Object r5 = r3.select(r5)     // Catch:{ Exception -> 0x0497 }
            com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState r5 = (com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState) r5     // Catch:{ Exception -> 0x0497 }
            if (r5 != 0) goto L_0x0409
            goto L_0x040c
        L_0x0409:
            r5.setActivityTimer(r8)     // Catch:{ Exception -> 0x0497 }
        L_0x040c:
            if (r8 == 0) goto L_0x043d
            if (r9 == 0) goto L_0x043d
            r3 = r27
            r4 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState> r5 = com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState.class
            java.lang.Object r5 = r3.select(r5)     // Catch:{ Exception -> 0x0497 }
            com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState r5 = (com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState) r5     // Catch:{ Exception -> 0x0497 }
            if (r5 != 0) goto L_0x041e
            goto L_0x0422
        L_0x041e:
            r3 = 1
            r5.setOperationTimer(r3)     // Catch:{ Exception -> 0x0497 }
        L_0x0422:
            r3 = r27
            r4 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState> r5 = com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState.class
            java.lang.Object r5 = r3.select(r5)     // Catch:{ Exception -> 0x0497 }
            com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState r5 = (com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState) r5     // Catch:{ Exception -> 0x0497 }
            if (r5 == 0) goto L_0x0434
            androidx.lifecycle.MutableLiveData r5 = r5.getBindTimerData()     // Catch:{ Exception -> 0x0497 }
            goto L_0x0435
        L_0x0434:
            r5 = 0
        L_0x0435:
            if (r5 != 0) goto L_0x0439
        L_0x0437:
            goto L_0x04a7
        L_0x0439:
            r5.setValue(r9)     // Catch:{ Exception -> 0x0497 }
            goto L_0x0437
        L_0x043d:
            r3 = r0
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x0497 }
            boolean r3 = kotlin.text.StringsKt.isBlank(r3)     // Catch:{ Exception -> 0x0497 }
            r4 = 1
            r3 = r3 ^ r4
            if (r3 == 0) goto L_0x04a7
            com.baidu.searchbox.video.feedflow.flow.operation.utils.OperationHelper r3 = com.baidu.searchbox.video.feedflow.flow.operation.utils.OperationHelper.INSTANCE     // Catch:{ Exception -> 0x0497 }
            java.util.Map r3 = r3.getTasks()     // Catch:{ Exception -> 0x0497 }
            boolean r3 = r3.containsKey(r0)     // Catch:{ Exception -> 0x0497 }
            if (r3 == 0) goto L_0x04a7
            r3 = r27
            r4 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState> r5 = com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState.class
            java.lang.Object r5 = r3.select(r5)     // Catch:{ Exception -> 0x0497 }
            com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState r5 = (com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState) r5     // Catch:{ Exception -> 0x0497 }
            if (r5 != 0) goto L_0x0462
            goto L_0x0466
        L_0x0462:
            r3 = 1
            r5.setOperationTimer(r3)     // Catch:{ Exception -> 0x0497 }
        L_0x0466:
            r3 = r27
            r4 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState> r5 = com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState.class
            java.lang.Object r5 = r3.select(r5)     // Catch:{ Exception -> 0x0497 }
            com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState r5 = (com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState) r5     // Catch:{ Exception -> 0x0497 }
            if (r5 == 0) goto L_0x0478
            androidx.lifecycle.MutableLiveData r3 = r5.getBindTimerData()     // Catch:{ Exception -> 0x0497 }
            goto L_0x0479
        L_0x0478:
            r3 = 0
        L_0x0479:
            if (r3 != 0) goto L_0x047c
            goto L_0x04a7
        L_0x047c:
            com.baidu.searchbox.video.feedflow.flow.operation.utils.OperationHelper r4 = com.baidu.searchbox.video.feedflow.flow.operation.utils.OperationHelper.INSTANCE     // Catch:{ Exception -> 0x0497 }
            java.util.Map r4 = r4.getTasks()     // Catch:{ Exception -> 0x0497 }
            java.lang.Object r4 = r4.get(r0)     // Catch:{ Exception -> 0x0497 }
            java.lang.ref.WeakReference r4 = (java.lang.ref.WeakReference) r4     // Catch:{ Exception -> 0x0497 }
            if (r4 == 0) goto L_0x0492
            java.lang.Object r4 = r4.get()     // Catch:{ Exception -> 0x0497 }
            r5 = r4
            com.baidu.searchbox.video.feedflow.flow.operation.timer.ActivityTimerWrapper r5 = (com.baidu.searchbox.video.feedflow.flow.operation.timer.ActivityTimerWrapper) r5     // Catch:{ Exception -> 0x0497 }
            goto L_0x0493
        L_0x0492:
            r5 = 0
        L_0x0493:
            r3.setValue(r5)     // Catch:{ Exception -> 0x0497 }
            goto L_0x04a7
        L_0x0497:
            r0 = move-exception
            goto L_0x049c
        L_0x0499:
            r0 = move-exception
            r17 = r4
        L_0x049c:
            com.baidu.searchbox.video.feedflow.di.DIFactory r3 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE
            boolean r3 = r3.isDebug()
            if (r3 == 0) goto L_0x04a7
            r0.printStackTrace()
        L_0x04a7:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x05f2
        L_0x04ad:
            boolean r0 = r2 instanceof com.baidu.searchbox.video.feedflow.detail.player.PlayerFirstFrame
            if (r0 == 0) goto L_0x04cd
            r0 = r27
            r3 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState> r4 = com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState.class
            java.lang.Object r0 = r0.select(r4)
            com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState r0 = (com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState) r0
            if (r0 == 0) goto L_0x04c3
            androidx.lifecycle.MutableLiveData r5 = r0.getTryChangeTimerState()
            goto L_0x04c4
        L_0x04c3:
            r5 = 0
        L_0x04c4:
            if (r5 != 0) goto L_0x04c8
            goto L_0x05f2
        L_0x04c8:
            r5.setValue(r7)
            goto L_0x05f2
        L_0x04cd:
            boolean r0 = r2 instanceof com.baidu.searchbox.video.feedflow.detail.player.PlayerPause
            if (r0 == 0) goto L_0x04ed
            r0 = r27
            r3 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState> r5 = com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState.class
            java.lang.Object r0 = r0.select(r5)
            com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState r0 = (com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState) r0
            if (r0 == 0) goto L_0x04e3
            androidx.lifecycle.MutableLiveData r5 = r0.getTryChangeTimerState()
            goto L_0x04e4
        L_0x04e3:
            r5 = 0
        L_0x04e4:
            if (r5 != 0) goto L_0x04e8
            goto L_0x05f2
        L_0x04e8:
            r5.setValue(r4)
            goto L_0x05f2
        L_0x04ed:
            boolean r0 = r2 instanceof com.baidu.searchbox.video.feedflow.detail.player.PlayerResume
            if (r0 == 0) goto L_0x04f3
            r3 = 1
            goto L_0x04f5
        L_0x04f3:
            boolean r3 = r2 instanceof com.baidu.searchbox.video.feedflow.detail.player.PlayerStart
        L_0x04f5:
            if (r3 == 0) goto L_0x0513
            r0 = r27
            r3 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState> r4 = com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState.class
            java.lang.Object r0 = r0.select(r4)
            com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState r0 = (com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState) r0
            if (r0 == 0) goto L_0x0509
            androidx.lifecycle.MutableLiveData r5 = r0.getTryChangeTimerState()
            goto L_0x050a
        L_0x0509:
            r5 = 0
        L_0x050a:
            if (r5 != 0) goto L_0x050e
            goto L_0x05f2
        L_0x050e:
            r5.setValue(r7)
            goto L_0x05f2
        L_0x0513:
            boolean r0 = r2 instanceof com.baidu.searchbox.video.feedflow.detail.player.PlayerLoop
            if (r0 == 0) goto L_0x0533
            r0 = r27
            r3 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState> r4 = com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState.class
            java.lang.Object r0 = r0.select(r4)
            com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState r0 = (com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState) r0
            if (r0 == 0) goto L_0x0529
            androidx.lifecycle.MutableLiveData r5 = r0.getTryChangeTimerState()
            goto L_0x052a
        L_0x0529:
            r5 = 0
        L_0x052a:
            if (r5 != 0) goto L_0x052e
            goto L_0x05f2
        L_0x052e:
            r5.setValue(r7)
            goto L_0x05f2
        L_0x0533:
            boolean r0 = r2 instanceof com.baidu.searchbox.video.feedflow.detail.player.OnLoadingStart
            if (r0 == 0) goto L_0x0553
            r0 = r27
            r3 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState> r5 = com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState.class
            java.lang.Object r0 = r0.select(r5)
            com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState r0 = (com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState) r0
            if (r0 == 0) goto L_0x0549
            androidx.lifecycle.MutableLiveData r5 = r0.getTryChangeTimerState()
            goto L_0x054a
        L_0x0549:
            r5 = 0
        L_0x054a:
            if (r5 != 0) goto L_0x054e
            goto L_0x05f2
        L_0x054e:
            r5.setValue(r4)
            goto L_0x05f2
        L_0x0553:
            boolean r0 = r2 instanceof com.baidu.searchbox.video.feedflow.detail.player.OnLoadingEnd
            if (r0 == 0) goto L_0x0573
            r0 = r27
            r3 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState> r4 = com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState.class
            java.lang.Object r0 = r0.select(r4)
            com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState r0 = (com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState) r0
            if (r0 == 0) goto L_0x0569
            androidx.lifecycle.MutableLiveData r5 = r0.getTryChangeTimerState()
            goto L_0x056a
        L_0x0569:
            r5 = 0
        L_0x056a:
            if (r5 != 0) goto L_0x056e
            goto L_0x05f2
        L_0x056e:
            r5.setValue(r7)
            goto L_0x05f2
        L_0x0573:
            boolean r0 = r2 instanceof com.baidu.searchbox.video.feedflow.detail.favor.OnFavorStatusChangeByUser
            if (r0 == 0) goto L_0x05f2
            r0 = r2
            com.baidu.searchbox.video.feedflow.detail.favor.OnFavorStatusChangeByUser r0 = (com.baidu.searchbox.video.feedflow.detail.favor.OnFavorStatusChangeByUser) r0
            boolean r0 = r0.isFavor()
            if (r0 == 0) goto L_0x05f2
            r0 = r27
            r3 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState> r4 = com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState.class
            java.lang.Object r0 = r0.select(r4)
            com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState r0 = (com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState) r0
            if (r0 == 0) goto L_0x05f2
            androidx.lifecycle.MutableLiveData r0 = r0.getBindTimerData()
            if (r0 == 0) goto L_0x05f2
            java.lang.Object r0 = r0.getValue()
            com.baidu.searchbox.video.feedflow.flow.operation.timer.ActivityTimerWrapper r0 = (com.baidu.searchbox.video.feedflow.flow.operation.timer.ActivityTimerWrapper) r0
            if (r0 == 0) goto L_0x05f2
            r3 = 0
            com.baidu.searchbox.video.feedflow.flow.operation.timer.ActivityTimer r4 = r0.getActivityTimer()
            com.baidu.searchbox.video.feedflow.flow.operation.timer.UiInfo r4 = r4.getUiInfo()
            if (r4 == 0) goto L_0x05ab
            com.baidu.searchbox.video.feedflow.flow.operation.timer.FavorTask r4 = r4.getFavorTask()
            goto L_0x05ac
        L_0x05ab:
            r4 = 0
        L_0x05ac:
            if (r4 == 0) goto L_0x05ed
            com.baidu.searchbox.video.feedflow.flow.operation.timer.FunInfoByInt r4 = r0.getFunInfoByInt()
            boolean r4 = r4.getHasDoneFavorTask()
            if (r4 != 0) goto L_0x05ed
            com.baidu.searchbox.video.feedflow.flow.operation.timer.FunInfoByInt r4 = r0.getFunInfoByInt()
            r5 = 1
            r4.setHasDoneFavorTask(r5)
            com.baidu.searchbox.video.feedflow.flow.operation.timer.FunInfoByInt r4 = r0.getFunInfoByInt()
            int r4 = r4.getNeedSteps()
            com.baidu.searchbox.video.feedflow.flow.operation.timer.FunInfoByInt r5 = r0.getFunInfoByInt()
            int r5 = r5.getCurrentStep()
            if (r4 != r5) goto L_0x05ed
            r4 = r27
            r5 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState> r6 = com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState.class
            java.lang.Object r4 = r4.select(r6)
            com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState r4 = (com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperatingActivityState) r4
            if (r4 == 0) goto L_0x05e4
            androidx.lifecycle.MutableLiveData r5 = r4.getUpdateBottomRewardText()
            goto L_0x05e5
        L_0x05e4:
            r5 = 0
        L_0x05e5:
            if (r5 != 0) goto L_0x05e8
            goto L_0x05ed
        L_0x05e8:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            r5.setValue(r4)
        L_0x05ed:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x05f2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperationReducer.reduce(com.baidu.searchbox.feed.detail.arch.ext.CommonState, com.baidu.searchbox.feed.detail.frame.Action):com.baidu.searchbox.feed.detail.arch.ext.CommonState");
    }
}
