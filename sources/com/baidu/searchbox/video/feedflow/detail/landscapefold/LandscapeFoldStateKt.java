package com.baidu.searchbox.video.feedflow.detail.landscapefold;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003¨\u0006\u0004"}, d2 = {"canLandscapeRelatedRecommendLoopShow", "", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "lib-flow-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: LandscapeFoldState.kt */
public final class LandscapeFoldStateKt {
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00d3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean canLandscapeRelatedRecommendLoopShow(com.baidu.searchbox.feed.detail.frame.Store<?> r7) {
        /*
            com.baidu.searchbox.video.feedflow.common.FlowSwitchState r0 = com.baidu.searchbox.video.feedflow.common.FlowSwitchStateKt.flowSwitchState((com.baidu.searchbox.feed.detail.frame.Store<?>) r7)
            com.baidu.searchbox.video.feedflow.flow.collection.landscaperelatedrecommend.LandscapeRelatedRecommendModel r0 = r0.getLandscapeRelatedRecommendConfig()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0014
            boolean r0 = r0.getLoopShow()
            if (r0 != r1) goto L_0x0014
            r0 = r1
            goto L_0x0015
        L_0x0014:
            r0 = r2
        L_0x0015:
            if (r0 == 0) goto L_0x0132
            r0 = 0
            if (r7 == 0) goto L_0x003b
            r3 = r7
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r3.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r6 == 0) goto L_0x0027
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x0028
        L_0x0027:
            r5 = r0
        L_0x0028:
            if (r5 == 0) goto L_0x0031
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.FlowDetailState> r6 = com.baidu.searchbox.video.feedflow.detail.FlowDetailState.class
            java.lang.Object r5 = r5.select(r6)
            goto L_0x0032
        L_0x0031:
            r5 = r0
        L_0x0032:
            com.baidu.searchbox.video.feedflow.detail.FlowDetailState r5 = (com.baidu.searchbox.video.feedflow.detail.FlowDetailState) r5
            if (r5 == 0) goto L_0x003b
            com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel r3 = r5.getData()
            goto L_0x003c
        L_0x003b:
            r3 = r0
        L_0x003c:
            if (r7 == 0) goto L_0x0043
            com.baidu.searchbox.feed.detail.frame.State r4 = r7.getState()
            goto L_0x0044
        L_0x0043:
            r4 = r0
        L_0x0044:
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r5 == 0) goto L_0x004b
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x004c
        L_0x004b:
            r4 = r0
        L_0x004c:
            boolean r3 = com.baidu.searchbox.video.feedflow.detail.seamlessplay.SeamlessPlayStateKt.needShowSeamless(r3, r4)
            if (r3 != 0) goto L_0x0132
            if (r7 == 0) goto L_0x0078
            r3 = r7
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r3.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r6 == 0) goto L_0x0061
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x0062
        L_0x0061:
            r5 = r0
        L_0x0062:
            if (r5 == 0) goto L_0x006b
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState> r6 = com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState.class
            java.lang.Object r5 = r5.select(r6)
            goto L_0x006c
        L_0x006b:
            r5 = r0
        L_0x006c:
            com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState r5 = (com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState) r5
            if (r5 == 0) goto L_0x0078
            boolean r3 = r5.isInterceptLandscapeRelatedRecommendAutoShow()
            if (r3 != r1) goto L_0x0078
            r3 = r1
            goto L_0x0079
        L_0x0078:
            r3 = r2
        L_0x0079:
            if (r3 != 0) goto L_0x0132
            boolean r3 = com.baidu.searchbox.video.feedflow.flow.flowstyle.LandscapeFlowSwitchKt.isLandscapeFlowMode((com.baidu.searchbox.feed.detail.frame.Store<?>) r7)
            if (r3 == 0) goto L_0x0132
            if (r7 == 0) goto L_0x00a7
            r3 = r7
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r3.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r6 == 0) goto L_0x0090
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x0091
        L_0x0090:
            r5 = r0
        L_0x0091:
            if (r5 == 0) goto L_0x009a
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.player.state.PlayerState> r6 = com.baidu.searchbox.video.feedflow.detail.player.state.PlayerState.class
            java.lang.Object r5 = r5.select(r6)
            goto L_0x009b
        L_0x009a:
            r5 = r0
        L_0x009b:
            com.baidu.searchbox.video.feedflow.detail.player.state.PlayerState r5 = (com.baidu.searchbox.video.feedflow.detail.player.state.PlayerState) r5
            if (r5 == 0) goto L_0x00a7
            boolean r3 = r5.isThreeDivideGuideShowing()
            if (r3 != r1) goto L_0x00a7
            r3 = r1
            goto L_0x00a8
        L_0x00a7:
            r3 = r2
        L_0x00a8:
            if (r3 != 0) goto L_0x0132
            if (r7 == 0) goto L_0x00d0
            r3 = r7
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r3.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r6 == 0) goto L_0x00b9
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x00ba
        L_0x00b9:
            r5 = r0
        L_0x00ba:
            if (r5 == 0) goto L_0x00c3
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldState> r6 = com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldState.class
            java.lang.Object r5 = r5.select(r6)
            goto L_0x00c4
        L_0x00c3:
            r5 = r0
        L_0x00c4:
            com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldState r5 = (com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldState) r5
            if (r5 == 0) goto L_0x00d0
            boolean r3 = r5.getClickable()
            if (r3 != r1) goto L_0x00d0
            r3 = r1
            goto L_0x00d1
        L_0x00d0:
            r3 = r2
        L_0x00d1:
            if (r3 == 0) goto L_0x0132
            r3 = r7
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r3.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r6 == 0) goto L_0x00e0
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x00e1
        L_0x00e0:
            r5 = r0
        L_0x00e1:
            if (r5 == 0) goto L_0x00ea
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldState> r6 = com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldState.class
            java.lang.Object r5 = r5.select(r6)
            goto L_0x00eb
        L_0x00ea:
            r5 = r0
        L_0x00eb:
            com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldState r5 = (com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldState) r5
            if (r5 == 0) goto L_0x00f7
            boolean r3 = r5.isAutoShown()
            if (r3 != r1) goto L_0x00f7
            r3 = r1
            goto L_0x00f8
        L_0x00f7:
            r3 = r2
        L_0x00f8:
            if (r3 != 0) goto L_0x0132
            r3 = r7
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r3.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r6 == 0) goto L_0x0107
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x0108
        L_0x0107:
            r5 = r0
        L_0x0108:
            if (r5 == 0) goto L_0x0111
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldState> r6 = com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldState.class
            java.lang.Object r5 = r5.select(r6)
            goto L_0x0112
        L_0x0111:
            r5 = r0
        L_0x0112:
            com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldState r5 = (com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldState) r5
            if (r5 == 0) goto L_0x0128
            androidx.lifecycle.MutableLiveData r3 = r5.getBindData()
            if (r3 == 0) goto L_0x0128
            java.lang.Object r3 = r3.getValue()
            com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldModel r3 = (com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldModel) r3
            if (r3 == 0) goto L_0x0128
            java.lang.String r0 = r3.getType()
        L_0x0128:
            java.lang.String r3 = "landscape_related_recommend"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            if (r0 == 0) goto L_0x0132
            goto L_0x0133
        L_0x0132:
            r1 = r2
        L_0x0133:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldStateKt.canLandscapeRelatedRecommendLoopShow(com.baidu.searchbox.feed.detail.frame.Store):boolean");
    }
}
