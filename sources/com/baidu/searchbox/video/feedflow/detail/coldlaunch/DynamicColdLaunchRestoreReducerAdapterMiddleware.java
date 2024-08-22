package com.baidu.searchbox.video.feedflow.detail.coldlaunch;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0014J\"\u0010\b\u001a\u00020\u00042\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0014¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/coldlaunch/DynamicColdLaunchRestoreReducerAdapterMiddleware;", "Lcom/baidu/searchbox/video/feedflow/detail/coldlaunch/ColdLaunchRestoreReducerAdapterMiddleware;", "()V", "handleData", "", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "onSuccess", "action", "Lcom/baidu/searchbox/feed/detail/arch/ext/NetAction$Success;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicColdLaunchRestoreReducerAdapterMiddleware.kt */
public final class DynamicColdLaunchRestoreReducerAdapterMiddleware extends ColdLaunchRestoreReducerAdapterMiddleware {
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0058, code lost:
        if ((r2.length() > 0) == true) goto L_0x005c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSuccess(com.baidu.searchbox.feed.detail.arch.ext.NetAction.Success<?> r8, com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.arch.ext.CommonState> r9) {
        /*
            r7 = this;
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "store"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.Object r0 = r8.getData()
            boolean r1 = r0 instanceof com.baidu.searchbox.flowvideo.dynamic.repos.DynamicDetailModel
            r2 = 0
            if (r1 == 0) goto L_0x0017
            com.baidu.searchbox.flowvideo.dynamic.repos.DynamicDetailModel r0 = (com.baidu.searchbox.flowvideo.dynamic.repos.DynamicDetailModel) r0
            goto L_0x0018
        L_0x0017:
            r0 = r2
        L_0x0018:
            if (r0 == 0) goto L_0x006a
            r1 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r9.getState()
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            boolean r3 = r3.isActive()
            if (r3 == 0) goto L_0x0068
            boolean r3 = r0.isOffLine()
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L_0x003d
            boolean r3 = r7.isTypeEnable(r9)
            if (r3 == 0) goto L_0x003d
            boolean r3 = r7.isNetError(r9)
            if (r3 != 0) goto L_0x003d
            r3 = r4
            goto L_0x003e
        L_0x003d:
            r3 = r5
        L_0x003e:
            com.baidu.searchbox.flowvideo.detail.repos.FavorModel r6 = r0.getFavouriteInfo()
            if (r6 == 0) goto L_0x0048
            java.lang.String r2 = r6.getCmd()
        L_0x0048:
            if (r3 == 0) goto L_0x0068
            if (r2 == 0) goto L_0x005b
            r6 = r2
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            int r6 = r6.length()
            if (r6 <= 0) goto L_0x0057
            r6 = r4
            goto L_0x0058
        L_0x0057:
            r6 = r5
        L_0x0058:
            if (r6 != r4) goto L_0x005b
            goto L_0x005c
        L_0x005b:
            r4 = r5
        L_0x005c:
            if (r4 == 0) goto L_0x0068
            com.baidu.searchbox.video.feedflow.flow.coldlaunch.UpdateColdLaunchRestoreScheme r4 = new com.baidu.searchbox.video.feedflow.flow.coldlaunch.UpdateColdLaunchRestoreScheme
            r4.<init>(r2)
            com.baidu.searchbox.feed.detail.frame.Action r4 = (com.baidu.searchbox.feed.detail.frame.Action) r4
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r9, r4)
        L_0x0068:
        L_0x006a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.coldlaunch.DynamicColdLaunchRestoreReducerAdapterMiddleware.onSuccess(com.baidu.searchbox.feed.detail.arch.ext.NetAction$Success, com.baidu.searchbox.feed.detail.frame.Store):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0051, code lost:
        if ((r5.length() > 0) == true) goto L_0x0055;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleData(com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.arch.ext.CommonState> r8) {
        /*
            r7 = this;
            java.lang.String r0 = "store"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            com.baidu.searchbox.feed.detail.frame.State r0 = r8.getState()
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r0 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r0
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.dynamic.DynamicDetailState> r2 = com.baidu.searchbox.video.feedflow.detail.dynamic.DynamicDetailState.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.video.feedflow.detail.dynamic.DynamicDetailState r0 = (com.baidu.searchbox.video.feedflow.detail.dynamic.DynamicDetailState) r0
            if (r0 == 0) goto L_0x0062
            com.baidu.searchbox.flowvideo.dynamic.repos.DynamicDetailModel r0 = r0.getData()
            if (r0 == 0) goto L_0x0062
            r1 = 0
            boolean r2 = r7.isTypeEnable(r8)
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0034
            boolean r2 = r0.isOffLine()
            if (r2 != 0) goto L_0x0034
            boolean r2 = r7.isNetError(r8)
            if (r2 != 0) goto L_0x0034
            r2 = r3
            goto L_0x0035
        L_0x0034:
            r2 = r4
        L_0x0035:
            com.baidu.searchbox.flowvideo.detail.repos.FavorModel r5 = r0.getFavouriteInfo()
            if (r5 == 0) goto L_0x0040
            java.lang.String r5 = r5.getCmd()
            goto L_0x0041
        L_0x0040:
            r5 = 0
        L_0x0041:
            if (r2 == 0) goto L_0x0061
            if (r5 == 0) goto L_0x0054
            r6 = r5
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            int r6 = r6.length()
            if (r6 <= 0) goto L_0x0050
            r6 = r3
            goto L_0x0051
        L_0x0050:
            r6 = r4
        L_0x0051:
            if (r6 != r3) goto L_0x0054
            goto L_0x0055
        L_0x0054:
            r3 = r4
        L_0x0055:
            if (r3 == 0) goto L_0x0061
            com.baidu.searchbox.video.feedflow.flow.coldlaunch.UpdateColdLaunchRestoreScheme r3 = new com.baidu.searchbox.video.feedflow.flow.coldlaunch.UpdateColdLaunchRestoreScheme
            r3.<init>(r5)
            com.baidu.searchbox.feed.detail.frame.Action r3 = (com.baidu.searchbox.feed.detail.frame.Action) r3
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r8, r3)
        L_0x0061:
        L_0x0062:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.coldlaunch.DynamicColdLaunchRestoreReducerAdapterMiddleware.handleData(com.baidu.searchbox.feed.detail.frame.Store):void");
    }
}
