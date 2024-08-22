package com.baidu.searchbox.video.search.secondjumpswitch;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/search/secondjumpswitch/SearchFlowSecondJumpSwitchComponent;", "Lcom/baidu/searchbox/video/search/secondjumpswitch/SearchSecondJumpSwitchComponent;", "()V", "judgeOtherCondition", "", "switchConfig", "Lcom/baidu/searchbox/video/feedflow/detail/secondjumpswitch/SecondJumpSwitchConfig;", "search-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchFlowSecondJumpSwitchComponent.kt */
public final class SearchFlowSecondJumpSwitchComponent extends SearchSecondJumpSwitchComponent {
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0035 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x007c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean judgeOtherCondition(com.baidu.searchbox.video.feedflow.detail.secondjumpswitch.SecondJumpSwitchConfig r8) {
        /*
            r7 = this;
            java.lang.String r0 = "switchConfig"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            com.baidu.searchbox.feed.detail.frame.Store r0 = r7.getStore()
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0032
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r0.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r6 == 0) goto L_0x001b
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x001c
        L_0x001b:
            r5 = r2
        L_0x001c:
            if (r5 == 0) goto L_0x0025
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.secondjumpswitch.SecondJumpSwitchState> r6 = com.baidu.searchbox.video.feedflow.detail.secondjumpswitch.SecondJumpSwitchState.class
            java.lang.Object r5 = r5.select(r6)
            goto L_0x0026
        L_0x0025:
            r5 = r2
        L_0x0026:
            com.baidu.searchbox.video.feedflow.detail.secondjumpswitch.SecondJumpSwitchState r5 = (com.baidu.searchbox.video.feedflow.detail.secondjumpswitch.SecondJumpSwitchState) r5
            if (r5 == 0) goto L_0x0032
            boolean r0 = r5.getForbidShow()
            if (r0 != r3) goto L_0x0032
            r0 = r3
            goto L_0x0033
        L_0x0032:
            r0 = r1
        L_0x0033:
            if (r0 == 0) goto L_0x0036
            return r3
        L_0x0036:
            com.baidu.searchbox.feed.detail.frame.Store r0 = r7.getStore()
            if (r0 == 0) goto L_0x0043
            com.baidu.searchbox.feed.detail.frame.State r0 = r0.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r0 = (com.baidu.searchbox.feed.detail.frame.AbsState) r0
            goto L_0x0044
        L_0x0043:
            r0 = r2
        L_0x0044:
            boolean r4 = r0 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x004b
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r0 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r0
            goto L_0x004c
        L_0x004b:
            r0 = r2
        L_0x004c:
            boolean r0 = com.baidu.searchbox.video.feedflow.utils.TabUtilsKt.isInRecommendTab((com.baidu.searchbox.feed.detail.arch.ext.CommonState) r0)
            if (r0 != 0) goto L_0x0053
            return r3
        L_0x0053:
            com.baidu.searchbox.feed.detail.frame.Store r0 = r7.getStore()
            if (r0 == 0) goto L_0x0079
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r0.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r6 == 0) goto L_0x0065
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x0066
        L_0x0065:
            r5 = r2
        L_0x0066:
            if (r5 == 0) goto L_0x006f
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.FlowDetailState> r6 = com.baidu.searchbox.video.feedflow.detail.FlowDetailState.class
            java.lang.Object r5 = r5.select(r6)
            goto L_0x0070
        L_0x006f:
            r5 = r2
        L_0x0070:
            com.baidu.searchbox.video.feedflow.detail.FlowDetailState r5 = (com.baidu.searchbox.video.feedflow.detail.FlowDetailState) r5
            if (r5 == 0) goto L_0x0079
            com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel r0 = r5.getData()
            goto L_0x007a
        L_0x0079:
            r0 = r2
        L_0x007a:
            if (r0 != 0) goto L_0x007d
            return r3
        L_0x007d:
            com.baidu.searchbox.feed.detail.frame.Store r0 = r7.getStore()
            if (r0 == 0) goto L_0x00a8
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r0.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r6 == 0) goto L_0x008f
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x0090
        L_0x008f:
            r5 = r2
        L_0x0090:
            if (r5 == 0) goto L_0x0099
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.ItemModel> r6 = com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class
            java.lang.Object r5 = r5.select(r6)
            goto L_0x009a
        L_0x0099:
            r5 = r2
        L_0x009a:
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r5 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r5
            if (r5 == 0) goto L_0x00a8
            com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus r0 = r5.getRunTimeStatus()
            if (r0 == 0) goto L_0x00a8
            com.baidu.searchbox.searchflow.detail.api.SeamlessNodeModel r2 = r0.getSeamlessNodeModel()
        L_0x00a8:
            if (r2 == 0) goto L_0x00ab
            return r3
        L_0x00ab:
            int r0 = r8.getGuideDay()
            boolean r0 = r7.searchCanShowInDefaultDays(r0)
            if (r0 != 0) goto L_0x00b6
            return r3
        L_0x00b6:
            int r0 = r8.getGuideCount()
            boolean r0 = r7.searchCanShowInDefaultCounts(r0)
            if (r0 != 0) goto L_0x00c1
            return r3
        L_0x00c1:
            android.content.Context r0 = r7.getContext()
            android.app.Activity r0 = com.baidu.searchbox.video.detail.notch.VideoFlowNotchUtilsKt.getActivity(r0)
            if (r0 == 0) goto L_0x00d3
            boolean r0 = r0.hasWindowFocus()
            if (r0 != r3) goto L_0x00d3
            r0 = r3
            goto L_0x00d4
        L_0x00d3:
            r0 = r1
        L_0x00d4:
            if (r0 != 0) goto L_0x00d7
            return r3
        L_0x00d7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.search.secondjumpswitch.SearchFlowSecondJumpSwitchComponent.judgeOtherCondition(com.baidu.searchbox.video.feedflow.detail.secondjumpswitch.SecondJumpSwitchConfig):boolean");
    }
}
