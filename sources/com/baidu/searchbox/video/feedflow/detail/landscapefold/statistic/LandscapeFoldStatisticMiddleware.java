package com.baidu.searchbox.video.feedflow.detail.landscapefold.statistic;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/landscapefold/statistic/LandscapeFoldStatisticMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LandscapeFoldStatisticMiddleware.kt */
public final class LandscapeFoldStatisticMiddleware implements Middleware<CommonState> {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus} */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r5v5 */
    /* JADX WARNING: type inference failed for: r5v11 */
    /* JADX WARNING: type inference failed for: r5v12 */
    /* JADX WARNING: type inference failed for: r5v13 */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0094, code lost:
        r4 = (r4 = r4.getBindData()).getValue();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.searchbox.feed.detail.frame.Action apply(com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.arch.ext.CommonState> r21, com.baidu.searchbox.feed.detail.frame.Action r22, com.baidu.searchbox.feed.detail.frame.Next<com.baidu.searchbox.feed.detail.arch.ext.CommonState> r23) {
        /*
            r20 = this;
            r0 = r21
            r1 = r22
            r2 = r23
            java.lang.String r3 = "store"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "next"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            boolean r3 = r1 instanceof com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldAction.OnVisibleChange
            java.lang.String r4 = "landscape_related_recommend"
            r5 = 0
            if (r3 == 0) goto L_0x0140
            com.baidu.searchbox.feed.detail.frame.State r3 = r21.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r3 = (com.baidu.searchbox.feed.detail.frame.AbsState) r3
            boolean r3 = com.baidu.searchbox.video.feedflow.flow.flowstyle.LandscapeFlowSwitchKt.isLandscapeFlowMode((com.baidu.searchbox.feed.detail.frame.AbsState) r3)
            if (r3 == 0) goto L_0x01bf
            r3 = r1
            com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldAction$OnVisibleChange r3 = (com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldAction.OnVisibleChange) r3
            boolean r3 = r3.getVisible()
            if (r3 == 0) goto L_0x01bf
            com.baidu.searchbox.feed.detail.frame.State r3 = r21.getState()
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            boolean r3 = r3.isActive()
            if (r3 == 0) goto L_0x01bf
            r3 = r1
            com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldAction$OnVisibleChange r3 = (com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldAction.OnVisibleChange) r3
            java.lang.String r3 = r3.getType()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            r4 = 0
            r6 = 1
            if (r3 != 0) goto L_0x00d6
            com.baidu.searchbox.feed.detail.frame.State r3 = r21.getState()
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.ItemModel> r7 = com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class
            java.lang.Object r3 = r3.select(r7)
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r3 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r3
            if (r3 == 0) goto L_0x006b
            com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus r3 = r3.getRunTimeStatus()
            if (r3 == 0) goto L_0x006b
            boolean r4 = r3.isReportCollectionEntranceShow()
            goto L_0x006c
        L_0x006b:
        L_0x006c:
            r3 = r4
            if (r3 != 0) goto L_0x01bf
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r7 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            com.baidu.searchbox.feed.detail.frame.State r4 = r21.getState()
            r8 = r4
            com.baidu.searchbox.feed.detail.frame.AbsState r8 = (com.baidu.searchbox.feed.detail.frame.AbsState) r8
            r11 = 0
            r12 = 0
            r13 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r21.getState()
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldState> r9 = com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldState.class
            java.lang.Object r4 = r4.select(r9)
            com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldState r4 = (com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldState) r4
            if (r4 == 0) goto L_0x00a1
            androidx.lifecycle.MutableLiveData r4 = r4.getBindData()
            if (r4 == 0) goto L_0x00a1
            java.lang.Object r4 = r4.getValue()
            com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldModel r4 = (com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldModel) r4
            if (r4 == 0) goto L_0x00a1
            java.lang.String r4 = r4.getExt()
            goto L_0x00a2
        L_0x00a1:
            r4 = r5
        L_0x00a2:
            org.json.JSONObject r14 = com.baidu.searchbox.video.feedflow.detail.banner.BannerUtilsKt.generateBannerExt(r4)
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 952(0x3b8, float:1.334E-42)
            r19 = 0
            java.lang.String r9 = "show"
            java.lang.String r10 = "banner"
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.uploadPageElementUbc$default(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            com.baidu.searchbox.feed.detail.frame.State r4 = r21.getState()
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.ItemModel> r7 = com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class
            java.lang.Object r4 = r4.select(r7)
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r4 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r4
            if (r4 == 0) goto L_0x00cc
            com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus r5 = r4.getRunTimeStatus()
        L_0x00cc:
            if (r5 != 0) goto L_0x00d1
            goto L_0x01bf
        L_0x00d1:
            r5.setReportCollectionEntranceShow(r6)
            goto L_0x01bf
        L_0x00d6:
            r3 = r21
            r7 = 0
            com.baidu.searchbox.feed.detail.frame.State r8 = r3.getState()
            boolean r9 = r8 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r9 == 0) goto L_0x00e4
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r8 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r8
            goto L_0x00e5
        L_0x00e4:
            r8 = r5
        L_0x00e5:
            if (r8 == 0) goto L_0x00ee
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldState> r9 = com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldState.class
            java.lang.Object r8 = r8.select(r9)
            goto L_0x00ef
        L_0x00ee:
            r8 = r5
        L_0x00ef:
            com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldState r8 = (com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldState) r8
            if (r8 == 0) goto L_0x00fa
            boolean r3 = r8.isLandscapeRelatedRecommendShown()
            if (r3 != r6) goto L_0x00fa
            r4 = r6
        L_0x00fa:
            if (r4 != 0) goto L_0x01bf
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r7 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            com.baidu.searchbox.feed.detail.frame.State r3 = r21.getState()
            r8 = r3
            com.baidu.searchbox.feed.detail.frame.AbsState r8 = (com.baidu.searchbox.feed.detail.frame.AbsState) r8
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r18 = 504(0x1f8, float:7.06E-43)
            r19 = 0
            java.lang.String r9 = "show"
            java.lang.String r10 = "relate_recommend"
            java.lang.String r17 = "6037"
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.uploadPageElementUbc$default(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r3 = r21
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r7 = r3.getState()
            boolean r8 = r7 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r8 == 0) goto L_0x012c
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r7 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r7
            goto L_0x012d
        L_0x012c:
            r7 = r5
        L_0x012d:
            if (r7 == 0) goto L_0x0135
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldState> r5 = com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldState.class
            java.lang.Object r5 = r7.select(r5)
        L_0x0135:
            com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldState r5 = (com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldState) r5
            if (r5 != 0) goto L_0x013b
            goto L_0x01bf
        L_0x013b:
            r5.setLandscapeRelatedRecommendShown(r6)
            goto L_0x01bf
        L_0x0140:
            boolean r3 = r1 instanceof com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldAction.OnViewClick
            if (r3 == 0) goto L_0x01bf
            r3 = r1
            com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldAction$OnViewClick r3 = (com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldAction.OnViewClick) r3
            java.lang.String r3 = r3.getType()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 != 0) goto L_0x0196
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r6 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            com.baidu.searchbox.feed.detail.frame.State r3 = r21.getState()
            r7 = r3
            com.baidu.searchbox.feed.detail.frame.AbsState r7 = (com.baidu.searchbox.feed.detail.frame.AbsState) r7
            r10 = 0
            r11 = 0
            r12 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r21.getState()
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldState> r4 = com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldState.class
            java.lang.Object r3 = r3.select(r4)
            com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldState r3 = (com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldState) r3
            if (r3 == 0) goto L_0x0182
            androidx.lifecycle.MutableLiveData r3 = r3.getBindData()
            if (r3 == 0) goto L_0x0182
            java.lang.Object r3 = r3.getValue()
            com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldModel r3 = (com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldModel) r3
            if (r3 == 0) goto L_0x0182
            java.lang.String r5 = r3.getExt()
        L_0x0182:
            org.json.JSONObject r13 = com.baidu.searchbox.video.feedflow.detail.banner.BannerUtilsKt.generateBannerExt(r5)
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 952(0x3b8, float:1.334E-42)
            r18 = 0
            java.lang.String r8 = "click"
            java.lang.String r9 = "banner"
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.uploadPageElementUbc$default(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            goto L_0x01bf
        L_0x0196:
            r3 = r1
            com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldAction$OnViewClick r3 = (com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldAction.OnViewClick) r3
            boolean r3 = r3.isAutoShow()
            if (r3 != 0) goto L_0x01bf
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r4 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            com.baidu.searchbox.feed.detail.frame.State r3 = r21.getState()
            r5 = r3
            com.baidu.searchbox.feed.detail.frame.AbsState r5 = (com.baidu.searchbox.feed.detail.frame.AbsState) r5
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r15 = 504(0x1f8, float:7.06E-43)
            r16 = 0
            java.lang.String r6 = "click"
            java.lang.String r7 = "relate_recommend"
            java.lang.String r14 = "6037"
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.uploadPageElementUbc$default(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
        L_0x01bf:
            com.baidu.searchbox.feed.detail.frame.Action r3 = r2.next(r0, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.landscapefold.statistic.LandscapeFoldStatisticMiddleware.apply(com.baidu.searchbox.feed.detail.frame.Store, com.baidu.searchbox.feed.detail.frame.Action, com.baidu.searchbox.feed.detail.frame.Next):com.baidu.searchbox.feed.detail.frame.Action");
    }
}
