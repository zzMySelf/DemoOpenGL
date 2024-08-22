package com.baidu.searchbox.video.feedflow.detail.favor.favorpanel;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"BUBBLE_SHOW_TIME_MILLIS", "", "TOKEN", "", "isFavorPanelCanShow", "", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "Lcom/baidu/searchbox/feed/detail/frame/AbsState;", "lib-flow-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FavorPanelPlugin.kt */
public final class FavorPanelPluginKt {
    private static final int BUBBLE_SHOW_TIME_MILLIS = 5000;
    private static final String TOKEN = "FavorPanelGuide";

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0057 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0081 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0082  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isFavorPanelCanShow(com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r7) {
        /*
            r0 = 0
            if (r7 == 0) goto L_0x0024
            r1 = r7
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
            java.lang.Class<com.baidu.searchbox.video.feedflow.config.GcpConfig> r4 = com.baidu.searchbox.video.feedflow.config.GcpConfig.class
            java.lang.Object r3 = r3.select(r4)
            goto L_0x001b
        L_0x001a:
            r3 = r0
        L_0x001b:
            com.baidu.searchbox.video.feedflow.config.GcpConfig r3 = (com.baidu.searchbox.video.feedflow.config.GcpConfig) r3
            if (r3 == 0) goto L_0x0024
            com.baidu.searchbox.video.feedflow.detail.favorbottomtoast.FavorBottomToastConfig r1 = r3.getFavorBottomToastConfig()
            goto L_0x0025
        L_0x0024:
            r1 = r0
        L_0x0025:
            boolean r1 = com.baidu.searchbox.video.feedflow.detail.favorbottomtoast.FavorBottomToastConfigKt.isEnable(r1)
            r2 = 0
            if (r1 != 0) goto L_0x002d
            return r2
        L_0x002d:
            r1 = 1
            if (r7 == 0) goto L_0x0054
            r3 = r7
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r3.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r6 == 0) goto L_0x003d
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x003e
        L_0x003d:
            r5 = r0
        L_0x003e:
            if (r5 == 0) goto L_0x0047
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.favor.favorpanel.FavorPanelState> r6 = com.baidu.searchbox.video.feedflow.detail.favor.favorpanel.FavorPanelState.class
            java.lang.Object r5 = r5.select(r6)
            goto L_0x0048
        L_0x0047:
            r5 = r0
        L_0x0048:
            com.baidu.searchbox.video.feedflow.detail.favor.favorpanel.FavorPanelState r5 = (com.baidu.searchbox.video.feedflow.detail.favor.favorpanel.FavorPanelState) r5
            if (r5 == 0) goto L_0x0054
            boolean r3 = r5.isPanelShowing()
            if (r3 != r1) goto L_0x0054
            r3 = r1
            goto L_0x0055
        L_0x0054:
            r3 = r2
        L_0x0055:
            if (r3 == 0) goto L_0x0058
            return r2
        L_0x0058:
            if (r7 == 0) goto L_0x007e
            r3 = r7
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r3.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r6 == 0) goto L_0x0067
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x0068
        L_0x0067:
            r5 = r0
        L_0x0068:
            if (r5 == 0) goto L_0x0071
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.ItemModel> r6 = com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class
            java.lang.Object r5 = r5.select(r6)
            goto L_0x0072
        L_0x0071:
            r5 = r0
        L_0x0072:
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r5 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r5
            if (r5 == 0) goto L_0x007e
            boolean r3 = com.baidu.searchbox.video.feedflow.flow.list.ItemTypeManifestKt.isAdsItem((com.baidu.searchbox.video.feedflow.flow.list.ItemModel<?>) r5)
            if (r3 != r1) goto L_0x007e
            r3 = r1
            goto L_0x007f
        L_0x007e:
            r3 = r2
        L_0x007f:
            if (r3 == 0) goto L_0x0082
            return r2
        L_0x0082:
            if (r7 == 0) goto L_0x008a
            com.baidu.searchbox.feed.detail.frame.State r0 = r7.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r0 = (com.baidu.searchbox.feed.detail.frame.AbsState) r0
        L_0x008a:
            boolean r0 = com.baidu.searchbox.video.feedflow.flow.flowstyle.LandscapeFlowSwitchKt.isLandscapeFlowMode((com.baidu.searchbox.feed.detail.frame.AbsState) r0)
            if (r0 == 0) goto L_0x0091
            return r2
        L_0x0091:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.favor.favorpanel.FavorPanelPluginKt.isFavorPanelCanShow(com.baidu.searchbox.feed.detail.frame.Store):boolean");
    }
}
