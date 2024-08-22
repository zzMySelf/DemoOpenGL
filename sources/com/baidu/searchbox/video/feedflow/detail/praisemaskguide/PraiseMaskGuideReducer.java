package com.baidu.searchbox.video.feedflow.detail.praisemaskguide;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/praisemaskguide/PraiseMaskGuideReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "reduce", "state", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PraiseMaskGuideReducer.kt */
public final class PraiseMaskGuideReducer implements Reducer<CommonState> {
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0055, code lost:
        if (r2 != false) goto L_0x0057;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.searchbox.feed.detail.arch.ext.CommonState reduce(com.baidu.searchbox.feed.detail.arch.ext.CommonState r10, com.baidu.searchbox.feed.detail.frame.Action r11) {
        /*
            r9 = this;
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            boolean r0 = r11 instanceof com.baidu.searchbox.video.feedflow.detail.player.PlayerFirstFrame
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0072
            r0 = r11
            com.baidu.searchbox.video.feedflow.detail.player.PlayerFirstFrame r0 = (com.baidu.searchbox.video.feedflow.detail.player.PlayerFirstFrame) r0
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r0 = r0.getItemModel()
            com.baidu.searchbox.video.feedflow.detail.praisemaskguide.doubleclick.DoubleClickPraiseMaskGuideConfig r3 = com.baidu.searchbox.video.feedflow.detail.praisemaskguide.doubleclick.DoubleClickPraiseMaskGuideConfig.INSTANCE
            java.lang.Object r3 = r3.getData()
            com.baidu.searchbox.video.feedflow.detail.praisemaskguide.doubleclick.DoubleClickPraiseMaskModel r3 = (com.baidu.searchbox.video.feedflow.detail.praisemaskguide.doubleclick.DoubleClickPraiseMaskModel) r3
            if (r0 == 0) goto L_0x0028
            java.lang.String r4 = r0.getLayout()
            goto L_0x0029
        L_0x0028:
            r4 = r1
        L_0x0029:
            if (r4 != 0) goto L_0x002d
            java.lang.String r4 = ""
        L_0x002d:
            boolean r4 = com.baidu.searchbox.video.feedflow.flow.list.ItemTypeManifestKt.isVideoItem((java.lang.String) r4)
            if (r4 == 0) goto L_0x00e5
            r4 = 0
            if (r0 == 0) goto L_0x0044
            com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus r5 = r0.getRunTimeStatus()
            if (r5 == 0) goto L_0x0044
            boolean r5 = r5.isFromCache()
            if (r5 != 0) goto L_0x0044
            r5 = r2
            goto L_0x0045
        L_0x0044:
            r5 = r4
        L_0x0045:
            if (r5 == 0) goto L_0x00e5
            if (r3 == 0) goto L_0x0057
            double r5 = r3.getProgress()
            r7 = 0
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 != 0) goto L_0x0054
            goto L_0x0055
        L_0x0054:
            r2 = r4
        L_0x0055:
            if (r2 == 0) goto L_0x00e5
        L_0x0057:
            r2 = r10
            r4 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.praisemaskguide.PraiseMaskGuideState> r5 = com.baidu.searchbox.video.feedflow.detail.praisemaskguide.PraiseMaskGuideState.class
            java.lang.Object r2 = r2.select(r5)
            com.baidu.searchbox.video.feedflow.detail.praisemaskguide.PraiseMaskGuideState r2 = (com.baidu.searchbox.video.feedflow.detail.praisemaskguide.PraiseMaskGuideState) r2
            if (r2 == 0) goto L_0x0067
            androidx.lifecycle.MutableLiveData r1 = r2.getTryShowGuide()
        L_0x0067:
            if (r1 != 0) goto L_0x006b
            goto L_0x00e5
        L_0x006b:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            r1.setValue(r2)
            goto L_0x00e5
        L_0x0072:
            boolean r0 = r11 instanceof com.baidu.searchbox.video.feedflow.detail.praisemaskguide.DoubleClickPraiseMaskGuideShowingAction
            if (r0 == 0) goto L_0x0090
            r0 = r10
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.praisemaskguide.PraiseMaskGuideState> r2 = com.baidu.searchbox.video.feedflow.detail.praisemaskguide.PraiseMaskGuideState.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.video.feedflow.detail.praisemaskguide.PraiseMaskGuideState r0 = (com.baidu.searchbox.video.feedflow.detail.praisemaskguide.PraiseMaskGuideState) r0
            if (r0 != 0) goto L_0x0084
            goto L_0x00e5
        L_0x0084:
            r1 = r11
            com.baidu.searchbox.video.feedflow.detail.praisemaskguide.DoubleClickPraiseMaskGuideShowingAction r1 = (com.baidu.searchbox.video.feedflow.detail.praisemaskguide.DoubleClickPraiseMaskGuideShowingAction) r1
            boolean r1 = r1.isShowing()
            r0.setShowing(r1)
            goto L_0x00e5
        L_0x0090:
            boolean r0 = r11 instanceof com.baidu.searchbox.video.feedflow.detail.praisemaskguide.HidePraiseMaskGuideAction
            if (r0 == 0) goto L_0x009a
            r0 = r2
            goto L_0x00a0
        L_0x009a:
            com.baidu.searchbox.video.feedflow.flow.slide.LeftSlideAction$DrawerBeginAction r0 = com.baidu.searchbox.video.feedflow.flow.slide.LeftSlideAction.DrawerBeginAction.INSTANCE
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r0)
        L_0x00a0:
            if (r0 == 0) goto L_0x00a4
            r0 = r2
            goto L_0x00aa
        L_0x00a4:
            com.baidu.searchbox.video.feedflow.flow.list.ActivityAnimation$DragBegin r0 = com.baidu.searchbox.video.feedflow.flow.list.ActivityAnimation.DragBegin.INSTANCE
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r0)
        L_0x00aa:
            if (r0 == 0) goto L_0x00ae
            r0 = r2
            goto L_0x00b4
        L_0x00ae:
            com.baidu.searchbox.video.feedflow.flow.list.OnPanelSlideStartAction r0 = com.baidu.searchbox.video.feedflow.flow.list.OnPanelSlideStartAction.INSTANCE
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r0)
        L_0x00b4:
            if (r0 == 0) goto L_0x00b8
            r0 = r2
            goto L_0x00ba
        L_0x00b8:
            boolean r0 = r11 instanceof com.baidu.searchbox.video.feedflow.detail.relatedsearch.RelatedSearchPanelAction.ShowRelatedSearchPanelAction
        L_0x00ba:
            if (r0 == 0) goto L_0x00be
            r0 = r2
            goto L_0x00c0
        L_0x00be:
            boolean r0 = r11 instanceof com.baidu.searchbox.video.feedflow.tab.TabComponentAction.OnTabScrollStateChanged
        L_0x00c0:
            if (r0 == 0) goto L_0x00c4
            r0 = r2
            goto L_0x00c6
        L_0x00c4:
            boolean r0 = r11 instanceof com.baidu.searchbox.video.feedflow.sidebar.SideBarAction.OnDrawerSlideBegin
        L_0x00c6:
            if (r0 == 0) goto L_0x00c9
            goto L_0x00cb
        L_0x00c9:
            boolean r2 = r11 instanceof com.baidu.searchbox.video.feedflow.detail.player.PlayerOrientationChanged
        L_0x00cb:
            if (r2 == 0) goto L_0x00e5
            r0 = r10
            r2 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.praisemaskguide.PraiseMaskGuideState> r3 = com.baidu.searchbox.video.feedflow.detail.praisemaskguide.PraiseMaskGuideState.class
            java.lang.Object r0 = r0.select(r3)
            com.baidu.searchbox.video.feedflow.detail.praisemaskguide.PraiseMaskGuideState r0 = (com.baidu.searchbox.video.feedflow.detail.praisemaskguide.PraiseMaskGuideState) r0
            if (r0 == 0) goto L_0x00dd
            androidx.lifecycle.MutableLiveData r1 = r0.getHideGuide()
        L_0x00dd:
            if (r1 != 0) goto L_0x00e0
            goto L_0x00e5
        L_0x00e0:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r1.setValue(r0)
        L_0x00e5:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.praisemaskguide.PraiseMaskGuideReducer.reduce(com.baidu.searchbox.feed.detail.arch.ext.CommonState, com.baidu.searchbox.feed.detail.frame.Action):com.baidu.searchbox.feed.detail.arch.ext.CommonState");
    }
}
