package com.baidu.searchbox.video.feedflow.detail.relatedpreview;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import com.baidu.searchbox.video.feedflow.common.CommonStateExtKt;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/relatedpreview/RelatedPreviewReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "isFirstVideo", "", "state", "reduce", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RelatedPreviewReducer.kt */
public class RelatedPreviewReducer implements Reducer<CommonState> {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v5, types: [androidx.lifecycle.MutableLiveData] */
    /* JADX WARNING: type inference failed for: r1v8, types: [androidx.lifecycle.MutableLiveData] */
    /* JADX WARNING: type inference failed for: r1v10, types: [androidx.lifecycle.MutableLiveData] */
    /* JADX WARNING: type inference failed for: r1v17 */
    /* JADX WARNING: type inference failed for: r1v18 */
    /* JADX WARNING: type inference failed for: r1v19 */
    /* JADX WARNING: type inference failed for: r1v20 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.searchbox.feed.detail.arch.ext.CommonState reduce(com.baidu.searchbox.feed.detail.arch.ext.CommonState r12, com.baidu.searchbox.feed.detail.frame.Action r13) {
        /*
            r11 = this;
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            boolean r0 = r13 instanceof com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewPanelAction.RelatedPreviewListDataCacheAction
            r1 = 0
            if (r0 == 0) goto L_0x00a7
            r0 = r12
            r2 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.ItemModel> r3 = com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class
            java.lang.Object r0 = r0.select(r3)
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r0 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r0
            if (r0 == 0) goto L_0x0022
            java.lang.String r2 = r0.getId()
            goto L_0x0023
        L_0x0022:
            r2 = r1
        L_0x0023:
            r3 = r13
            com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewPanelAction$RelatedPreviewListDataCacheAction r3 = (com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewPanelAction.RelatedPreviewListDataCacheAction) r3
            java.lang.String r3 = r3.getVid()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x004b
            java.lang.Object r2 = r0.getData()
            boolean r3 = r2 instanceof com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel
            if (r3 == 0) goto L_0x003b
            r1 = r2
            com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel r1 = (com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel) r1
        L_0x003b:
            if (r1 != 0) goto L_0x003f
            goto L_0x020a
        L_0x003f:
            r2 = r13
            com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewPanelAction$RelatedPreviewListDataCacheAction r2 = (com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewPanelAction.RelatedPreviewListDataCacheAction) r2
            java.util.List r2 = r2.getCacheDataList()
            r1.setCacheRelatedPreviewDataList(r2)
            goto L_0x020a
        L_0x004b:
            r2 = r12
            r3 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.FlowState> r4 = com.baidu.searchbox.video.feedflow.flow.list.FlowState.class
            java.lang.Object r2 = r2.select(r4)
            com.baidu.searchbox.video.feedflow.flow.list.FlowState r2 = (com.baidu.searchbox.video.feedflow.flow.list.FlowState) r2
            if (r2 == 0) goto L_0x005c
            java.util.List r2 = r2.getFlowList()
            goto L_0x005d
        L_0x005c:
            r2 = r1
        L_0x005d:
            if (r2 == 0) goto L_0x00a5
            r3 = r2
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            r4 = 0
            java.util.Iterator r5 = r3.iterator()
        L_0x0067:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00a2
            java.lang.Object r6 = r5.next()
            r7 = r6
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r7 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r7
            r8 = 0
            java.lang.String r9 = r7.getId()
            r10 = r13
            com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewPanelAction$RelatedPreviewListDataCacheAction r10 = (com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewPanelAction.RelatedPreviewListDataCacheAction) r10
            java.lang.String r10 = r10.getVid()
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r10)
            if (r9 == 0) goto L_0x00a0
            java.lang.Object r9 = r7.getData()
            boolean r10 = r9 instanceof com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel
            if (r10 == 0) goto L_0x0091
            com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel r9 = (com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel) r9
            goto L_0x0092
        L_0x0091:
            r9 = r1
        L_0x0092:
            if (r9 != 0) goto L_0x0095
            goto L_0x009f
        L_0x0095:
            r10 = r13
            com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewPanelAction$RelatedPreviewListDataCacheAction r10 = (com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewPanelAction.RelatedPreviewListDataCacheAction) r10
            java.util.List r10 = r10.getCacheDataList()
            r9.setCacheRelatedPreviewDataList(r10)
        L_0x009f:
            goto L_0x0067
        L_0x00a0:
            goto L_0x0067
        L_0x00a2:
            goto L_0x020a
        L_0x00a5:
            goto L_0x020a
        L_0x00a7:
            boolean r0 = r13 instanceof com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewPanelAction.RelatedPreviewPanelShowAction
            r2 = 1
            if (r0 == 0) goto L_0x00bf
            r0 = r12
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState> r3 = com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState.class
            java.lang.Object r0 = r0.select(r3)
            com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState r0 = (com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState) r0
            if (r0 != 0) goto L_0x00ba
            goto L_0x020a
        L_0x00ba:
            r0.setPanelShowing(r2)
            goto L_0x020a
        L_0x00bf:
            boolean r0 = r13 instanceof com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewPanelAction.RelatedPreviewPanelHideAction
            r3 = 0
            if (r0 == 0) goto L_0x00d7
            r0 = r12
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState> r2 = com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState r0 = (com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState) r0
            if (r0 != 0) goto L_0x00d2
            goto L_0x020a
        L_0x00d2:
            r0.setPanelShowing(r3)
            goto L_0x020a
        L_0x00d7:
            boolean r0 = r13 instanceof com.baidu.searchbox.video.feedflow.detail.player.PlayerResumeFormUser
            if (r0 == 0) goto L_0x0122
            r0 = r12
            r4 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState> r5 = com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState.class
            java.lang.Object r0 = r0.select(r5)
            com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState r0 = (com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState) r0
            if (r0 == 0) goto L_0x00ee
            boolean r0 = r0.isClearScreenHandleStatus()
            if (r0 != r2) goto L_0x00ee
            goto L_0x00ef
        L_0x00ee:
            r2 = r3
        L_0x00ef:
            if (r2 != 0) goto L_0x020a
            r0 = r12
            r2 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState> r4 = com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState.class
            java.lang.Object r0 = r0.select(r4)
            com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState r0 = (com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState) r0
            if (r0 == 0) goto L_0x0102
            boolean r0 = r0.isPanelShowing()
            goto L_0x0103
        L_0x0102:
            r0 = r3
        L_0x0103:
            if (r0 == 0) goto L_0x020a
            r2 = r12
            r4 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState> r5 = com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState.class
            java.lang.Object r2 = r2.select(r5)
            com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState r2 = (com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState) r2
            if (r2 == 0) goto L_0x0115
            androidx.lifecycle.MutableLiveData r1 = r2.getShowPanel()
        L_0x0115:
            if (r1 != 0) goto L_0x0119
            goto L_0x020a
        L_0x0119:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r3)
            r1.setValue(r2)
            goto L_0x020a
        L_0x0122:
            boolean r0 = r13 instanceof com.baidu.searchbox.video.feedflow.detail.player.PlayerPauseFormUser
            if (r0 == 0) goto L_0x0190
            r0 = r12
            r4 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState> r5 = com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState.class
            java.lang.Object r0 = r0.select(r5)
            com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState r0 = (com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState) r0
            if (r0 == 0) goto L_0x013a
            boolean r0 = r0.isClearScreenHandleStatus()
            if (r0 != r2) goto L_0x013a
            r0 = r2
            goto L_0x013b
        L_0x013a:
            r0 = r3
        L_0x013b:
            if (r0 != 0) goto L_0x020a
            r0 = r12
            r4 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState> r5 = com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState.class
            java.lang.Object r0 = r0.select(r5)
            com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState r0 = (com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState) r0
            if (r0 == 0) goto L_0x014e
            boolean r0 = r0.isPanelShowing()
            goto L_0x014f
        L_0x014e:
            r0 = r3
        L_0x014f:
            r4 = r12
            r5 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState> r6 = com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState.class
            java.lang.Object r4 = r4.select(r6)
            com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState r4 = (com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState) r4
            if (r4 == 0) goto L_0x0166
            com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewConfig r4 = r4.getSwitchConfig()
            if (r4 == 0) goto L_0x0166
            int r4 = r4.getShowTime()
            goto L_0x0167
        L_0x0166:
            r4 = r3
        L_0x0167:
            r5 = r12
            r6 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState> r7 = com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState.class
            java.lang.Object r5 = r5.select(r7)
            com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState r5 = (com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState) r5
            if (r5 == 0) goto L_0x0177
            androidx.lifecycle.MutableLiveData r1 = r5.getShowPanel()
        L_0x0177:
            if (r1 != 0) goto L_0x017b
            goto L_0x020a
        L_0x017b:
            com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewPanelShowType r5 = com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewPanelShowType.PLAY_PAUSE_SHOW
            int r5 = r5.ordinal()
            if (r5 != r4) goto L_0x0186
            if (r0 != 0) goto L_0x0186
            goto L_0x0187
        L_0x0186:
            r2 = r3
        L_0x0187:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r1.setValue(r2)
            goto L_0x020a
        L_0x0190:
            boolean r0 = r13 instanceof com.baidu.searchbox.feed.detail.arch.ext.NestedAction.OnAttachToScreen
            if (r0 == 0) goto L_0x01a4
            r0 = r12
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState> r2 = com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState r0 = (com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState) r0
            if (r0 == 0) goto L_0x020a
            r0.reset()
            goto L_0x020a
        L_0x01a4:
            boolean r0 = r13 instanceof com.baidu.searchbox.video.feedflow.detail.seekbar.UserDragSeekBarStart
            if (r0 == 0) goto L_0x01c3
            r0 = r12
            r3 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState> r4 = com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState.class
            java.lang.Object r0 = r0.select(r4)
            com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState r0 = (com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState) r0
            if (r0 == 0) goto L_0x01b8
            androidx.lifecycle.MutableLiveData r1 = r0.getInvisibleShowPanel()
        L_0x01b8:
            if (r1 != 0) goto L_0x01bb
            goto L_0x020a
        L_0x01bb:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
            r1.setValue(r0)
            goto L_0x020a
        L_0x01c3:
            boolean r0 = r13 instanceof com.baidu.searchbox.video.feedflow.detail.seekbar.UserDragSeekBarEnd
            if (r0 == 0) goto L_0x01e7
            r0 = r12
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState> r2 = com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState r0 = (com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState) r0
            if (r0 == 0) goto L_0x020a
            r1 = 0
            boolean r2 = r0.isPanelShowing()
            if (r2 == 0) goto L_0x01e5
            androidx.lifecycle.MutableLiveData r2 = r0.getInvisibleShowPanel()
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r2.setValue(r3)
        L_0x01e5:
            goto L_0x020a
        L_0x01e7:
            boolean r0 = r13 instanceof com.baidu.searchbox.feed.detail.arch.ext.NestedAction.OnDetachFromScreen
            if (r0 == 0) goto L_0x020a
            r0 = r12
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState> r2 = com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState r0 = (com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewState) r0
            if (r0 == 0) goto L_0x020a
            r1 = 0
            boolean r2 = r0.isPanelShowing()
            if (r2 == 0) goto L_0x0209
            androidx.lifecycle.MutableLiveData r2 = r0.getShowPanel()
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r2.setValue(r3)
        L_0x0209:
        L_0x020a:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewReducer.reduce(com.baidu.searchbox.feed.detail.arch.ext.CommonState, com.baidu.searchbox.feed.detail.frame.Action):com.baidu.searchbox.feed.detail.arch.ext.CommonState");
    }

    /* access modifiers changed from: protected */
    public boolean isFirstVideo(CommonState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return CommonStateExtKt.isFirstJump$default(state, (ItemModel) null, 1, (Object) null);
    }
}
