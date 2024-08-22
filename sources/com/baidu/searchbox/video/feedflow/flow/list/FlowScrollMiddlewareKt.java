package com.baidu.searchbox.video.feedflow.flow.list;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003¨\u0006\u0004"}, d2 = {"isDisableLandscapeScrollScene", "", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "lib-flow-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowScrollMiddleware.kt */
public final class FlowScrollMiddlewareKt {
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isDisableLandscapeScrollScene(com.baidu.searchbox.feed.detail.frame.Store<?> r12) {
        /*
            r0 = 0
            if (r12 != 0) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = com.baidu.searchbox.video.feedflow.common.CommonStoreExtKt.isSingleVideoPage((com.baidu.searchbox.feed.detail.frame.Store<?>) r12)
            r2 = 1
            if (r1 == 0) goto L_0x000c
            return r2
        L_0x000c:
            r1 = r12
            r3 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r1.getState()
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            r6 = 0
            if (r5 == 0) goto L_0x001a
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x001b
        L_0x001a:
            r4 = r6
        L_0x001b:
            if (r4 == 0) goto L_0x0024
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r5 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r4 = r4.select(r5)
            goto L_0x0025
        L_0x0024:
            r4 = r6
        L_0x0025:
            r1 = r4
            com.baidu.searchbox.video.detail.core.model.IntentData r1 = (com.baidu.searchbox.video.detail.core.model.IntentData) r1
            if (r1 == 0) goto L_0x002d
            java.lang.String r3 = r1.page
            goto L_0x002e
        L_0x002d:
            r3 = r6
        L_0x002e:
            java.lang.String r4 = ""
            if (r3 != 0) goto L_0x0033
            r3 = r4
        L_0x0033:
            r5 = r12
            r7 = 0
            com.baidu.searchbox.feed.detail.frame.State r8 = r5.getState()
            boolean r9 = r8 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r9 == 0) goto L_0x0040
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r8 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r8
            goto L_0x0041
        L_0x0040:
            r8 = r6
        L_0x0041:
            if (r8 == 0) goto L_0x004a
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.ItemModel> r9 = com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class
            java.lang.Object r8 = r8.select(r9)
            goto L_0x004b
        L_0x004a:
            r8 = r6
        L_0x004b:
            r5 = r8
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r5 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r5
            if (r5 == 0) goto L_0x0055
            java.lang.String r7 = r5.getLayout()
            goto L_0x0056
        L_0x0055:
            r7 = r6
        L_0x0056:
            if (r7 != 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            r4 = r7
        L_0x005a:
            boolean r7 = com.baidu.searchbox.video.detail.business.VideoBizUtilsKt.isFromUserHomePage(r3)
            if (r7 != 0) goto L_0x00a2
            boolean r7 = com.baidu.searchbox.video.detail.business.VideoBizUtilsKt.isFromHotFlow(r3)
            if (r7 != 0) goto L_0x00a2
            boolean r7 = com.baidu.searchbox.video.feedflow.flow.list.ItemTypeManifestKt.isRealLiveRoomItem((java.lang.String) r4)
            if (r7 != 0) goto L_0x00a2
            r7 = r12
            r8 = 0
            com.baidu.searchbox.feed.detail.frame.State r9 = r7.getState()
            boolean r10 = r9 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r10 == 0) goto L_0x0079
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r9 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r9
            goto L_0x007a
        L_0x0079:
            r9 = r6
        L_0x007a:
            if (r9 == 0) goto L_0x0083
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r10 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r9 = r9.select(r10)
            goto L_0x0084
        L_0x0083:
            r9 = r6
        L_0x0084:
            com.baidu.searchbox.video.detail.core.model.IntentData r9 = (com.baidu.searchbox.video.detail.core.model.IntentData) r9
            if (r9 == 0) goto L_0x008b
            java.lang.String r7 = r9.pd
            goto L_0x008c
        L_0x008b:
            r7 = r6
        L_0x008c:
            boolean r7 = com.baidu.searchbox.video.feedflow.detail.challenge.challengefromcomment.ChallengeUtilsKt.isPdFromCommentList(r7)
            if (r7 != 0) goto L_0x00a2
            if (r1 == 0) goto L_0x009c
            boolean r7 = r1.isTtv()
            if (r7 != r2) goto L_0x009c
            r7 = r2
            goto L_0x009d
        L_0x009c:
            r7 = r0
        L_0x009d:
            if (r7 == 0) goto L_0x00a0
            goto L_0x00a2
        L_0x00a0:
            r7 = r0
            goto L_0x00a3
        L_0x00a2:
            r7 = r2
        L_0x00a3:
            if (r7 != 0) goto L_0x00fd
            r8 = r12
            r9 = 0
            com.baidu.searchbox.feed.detail.frame.State r10 = r8.getState()
            boolean r11 = r10 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r11 == 0) goto L_0x00b3
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r10 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r10
            goto L_0x00b4
        L_0x00b3:
            r10 = r6
        L_0x00b4:
            if (r10 == 0) goto L_0x00bd
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.FlowTabState> r11 = com.baidu.searchbox.video.feedflow.tab.FlowTabState.class
            java.lang.Object r10 = r10.select(r11)
            goto L_0x00be
        L_0x00bd:
            r10 = r6
        L_0x00be:
            com.baidu.searchbox.video.feedflow.tab.FlowTabState r10 = (com.baidu.searchbox.video.feedflow.tab.FlowTabState) r10
            if (r10 == 0) goto L_0x00ca
            boolean r8 = r10.isAttentionTab()
            if (r8 != r2) goto L_0x00ca
            r8 = r2
            goto L_0x00cb
        L_0x00ca:
            r8 = r0
        L_0x00cb:
            if (r8 != 0) goto L_0x00fc
            boolean r8 = com.baidu.searchbox.video.feedflow.utils.TabUtilsKt.isInAttentionTab((com.baidu.searchbox.feed.detail.frame.Store<?>) r12)
            if (r8 != 0) goto L_0x00fc
            r8 = r12
            r9 = 0
            com.baidu.searchbox.feed.detail.frame.State r10 = r8.getState()
            boolean r11 = r10 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r11 == 0) goto L_0x00e0
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r10 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r10
            goto L_0x00e1
        L_0x00e0:
            r10 = r6
        L_0x00e1:
            if (r10 == 0) goto L_0x00e9
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.FlowTabState> r6 = com.baidu.searchbox.video.feedflow.tab.FlowTabState.class
            java.lang.Object r6 = r10.select(r6)
        L_0x00e9:
            com.baidu.searchbox.video.feedflow.tab.FlowTabState r6 = (com.baidu.searchbox.video.feedflow.tab.FlowTabState) r6
            if (r6 == 0) goto L_0x00f4
            boolean r6 = r6.isHotTab()
            if (r6 != r2) goto L_0x00f4
            r0 = r2
        L_0x00f4:
            if (r0 != 0) goto L_0x00fc
            boolean r0 = com.baidu.searchbox.video.feedflow.utils.TabUtilsKt.isInHotTab((com.baidu.searchbox.feed.detail.frame.Store<?>) r12)
            if (r0 == 0) goto L_0x00fd
        L_0x00fc:
            r7 = 1
        L_0x00fd:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.list.FlowScrollMiddlewareKt.isDisableLandscapeScrollScene(com.baidu.searchbox.feed.detail.frame.Store):boolean");
    }
}
