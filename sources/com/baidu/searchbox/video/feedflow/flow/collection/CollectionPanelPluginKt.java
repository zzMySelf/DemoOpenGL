package com.baidu.searchbox.video.feedflow.flow.collection;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"ARROW_EFFECT_FILE", "", "DELAY_AUTO_SHOW", "", "getItemStyle", "", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "Lcom/baidu/searchbox/feed/detail/frame/AbsState;", "lib-flow-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionPanelPlugin.kt */
public final class CollectionPanelPluginKt {
    private static final String ARROW_EFFECT_FILE = "assets://pag/video_flow_next_content_arrow.pag";
    private static final long DELAY_AUTO_SHOW = 600;

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int getItemStyle(com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r6) {
        /*
            r0 = 0
            if (r6 == 0) goto L_0x000b
            com.baidu.searchbox.feed.detail.frame.State r1 = r6.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r1 = (com.baidu.searchbox.feed.detail.frame.AbsState) r1
            goto L_0x000c
        L_0x000b:
            r1 = r0
        L_0x000c:
            boolean r1 = com.baidu.searchbox.video.feedflow.flow.flowstyle.LandscapeFlowSwitchKt.isLandscapeFlowMode((com.baidu.searchbox.feed.detail.frame.AbsState) r1)
            r2 = 3
            if (r1 == 0) goto L_0x0016
            r2 = 1
            goto L_0x0070
        L_0x0016:
            if (r6 == 0) goto L_0x0039
            r1 = r6
            r3 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r1.getState()
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r5 == 0) goto L_0x0025
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x0026
        L_0x0025:
            r4 = r0
        L_0x0026:
            if (r4 == 0) goto L_0x002f
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r5 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r4 = r4.select(r5)
            goto L_0x0030
        L_0x002f:
            r4 = r0
        L_0x0030:
            com.baidu.searchbox.video.detail.core.model.IntentData r4 = (com.baidu.searchbox.video.detail.core.model.IntentData) r4
            if (r4 == 0) goto L_0x0039
            java.lang.String r1 = r4.getActionType()
            goto L_0x003a
        L_0x0039:
            r1 = r0
        L_0x003a:
            java.lang.String r3 = "payment"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            if (r1 == 0) goto L_0x0043
            goto L_0x0070
        L_0x0043:
            if (r6 == 0) goto L_0x0065
            r1 = r6
            r3 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r1.getState()
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r5 == 0) goto L_0x0052
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x0053
        L_0x0052:
            r4 = r0
        L_0x0053:
            if (r4 == 0) goto L_0x005c
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r5 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r4 = r4.select(r5)
            goto L_0x005d
        L_0x005c:
            r4 = r0
        L_0x005d:
            com.baidu.searchbox.video.detail.core.model.IntentData r4 = (com.baidu.searchbox.video.detail.core.model.IntentData) r4
            if (r4 == 0) goto L_0x0065
            java.lang.String r0 = r4.getActionType()
        L_0x0065:
            java.lang.String r1 = "subscribe"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r2 = 2
        L_0x0070:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelPluginKt.getItemStyle(com.baidu.searchbox.feed.detail.frame.Store):int");
    }
}
