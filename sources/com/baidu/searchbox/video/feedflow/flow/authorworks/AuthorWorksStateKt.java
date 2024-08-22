package com.baidu.searchbox.video.feedflow.flow.authorworks;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0002\b\u0003\u0018\u00010\u0002¨\u0006\u0003"}, d2 = {"inAuthorWork", "", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "lib-flow-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: AuthorWorksState.kt */
public final class AuthorWorksStateKt {
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean inAuthorWork(com.baidu.searchbox.feed.detail.frame.Store<?> r5) {
        /*
            r0 = 0
            if (r5 == 0) goto L_0x0024
            r1 = r5
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r1.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x0010
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x0011
        L_0x0010:
            r3 = r0
        L_0x0011:
            if (r3 == 0) goto L_0x001a
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.authorworks.AuthorWorksState> r4 = com.baidu.searchbox.video.feedflow.flow.authorworks.AuthorWorksState.class
            java.lang.Object r3 = r3.select(r4)
            goto L_0x001b
        L_0x001a:
            r3 = r0
        L_0x001b:
            com.baidu.searchbox.video.feedflow.flow.authorworks.AuthorWorksState r3 = (com.baidu.searchbox.video.feedflow.flow.authorworks.AuthorWorksState) r3
            if (r3 == 0) goto L_0x0024
            com.baidu.searchbox.video.feedflow.flow.authorworks.AuthorWorkStatus r1 = r3.getCurStatus()
            goto L_0x0025
        L_0x0024:
            r1 = r0
        L_0x0025:
            if (r1 == 0) goto L_0x0051
            r1 = r5
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r1.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x0034
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x0035
        L_0x0034:
            r3 = r0
        L_0x0035:
            if (r3 == 0) goto L_0x003e
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.authorworks.AuthorWorksState> r4 = com.baidu.searchbox.video.feedflow.flow.authorworks.AuthorWorksState.class
            java.lang.Object r3 = r3.select(r4)
            goto L_0x003f
        L_0x003e:
            r3 = r0
        L_0x003f:
            com.baidu.searchbox.video.feedflow.flow.authorworks.AuthorWorksState r3 = (com.baidu.searchbox.video.feedflow.flow.authorworks.AuthorWorksState) r3
            if (r3 == 0) goto L_0x0047
            com.baidu.searchbox.video.feedflow.flow.authorworks.AuthorWorkStatus r0 = r3.getCurStatus()
        L_0x0047:
            com.baidu.searchbox.video.feedflow.flow.authorworks.AuthorWorkStatus$Close r1 = com.baidu.searchbox.video.feedflow.flow.authorworks.AuthorWorkStatus.Close.INSTANCE
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 != 0) goto L_0x0051
            r0 = 1
            goto L_0x0052
        L_0x0051:
            r0 = 0
        L_0x0052:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.authorworks.AuthorWorksStateKt.inAuthorWork(com.baidu.searchbox.feed.detail.frame.Store):boolean");
    }
}
