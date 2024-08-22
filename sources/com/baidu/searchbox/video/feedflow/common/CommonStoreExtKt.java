package com.baidu.searchbox.video.feedflow.common;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.feedflow.flow.globalmuteguide.GlobalMuteGuideHelper;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0010\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0002\b\u0003\u0018\u00010\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u0001*\b\u0012\u0002\b\u0003\u0018\u00010\u0002\u001a\f\u0010\u0004\u001a\u00020\u0001*\u0004\u0018\u00010\u0005\u001a\u0010\u0010\u0004\u001a\u00020\u0001*\b\u0012\u0002\b\u0003\u0018\u00010\u0002\u001a\u0010\u0010\u0006\u001a\u00020\u0001*\b\u0012\u0002\b\u0003\u0018\u00010\u0002\u001a\u0010\u0010\u0007\u001a\u00020\u0001*\b\u0012\u0002\b\u0003\u0018\u00010\u0002\u001a\u0010\u0010\b\u001a\u00020\u0001*\b\u0012\u0002\b\u0003\u0018\u00010\u0002\u001a\f\u0010\t\u001a\u00020\u0001*\u0004\u0018\u00010\u0005\u001a\u0010\u0010\t\u001a\u00020\u0001*\b\u0012\u0002\b\u0003\u0018\u00010\u0002\u001a\f\u0010\n\u001a\u00020\u0001*\u0004\u0018\u00010\u0005\u001a\u0010\u0010\n\u001a\u00020\u0001*\b\u0012\u0002\b\u0003\u0018\u00010\u0002¨\u0006\u000b"}, d2 = {"isItemTriggerByFlow", "", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "isItemTriggerByTab", "isLandingVideoInSimpleStyleFromFeed", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "isPageSelected", "isShowMuteGuideComponentEnabled", "isShowSettingPanelMuteFunction", "isSimplePageStyleFromFeed", "isSingleVideoPage", "lib-flow-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommonStoreExt.kt */
public final class CommonStoreExtKt {
    public static final boolean isItemTriggerByFlow(Store<?> $this$isItemTriggerByFlow) {
        if ($this$isItemTriggerByFlow == null) {
            return false;
        }
        Object state = $this$isItemTriggerByFlow.getState();
        String str = null;
        CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
        ItemTriggerSourceState itemTriggerSourceState = (ItemTriggerSourceState) (commonState != null ? commonState.select(ItemTriggerSourceState.class) : null);
        if (itemTriggerSourceState != null) {
            str = itemTriggerSourceState.getTriggerMode();
        }
        return Intrinsics.areEqual((Object) str, (Object) ItemTriggerSourceStateKt.ITEM_TRIGGER_SOURCE_FLOW);
    }

    public static final boolean isItemTriggerByTab(Store<?> $this$isItemTriggerByTab) {
        if ($this$isItemTriggerByTab == null) {
            return false;
        }
        Object state = $this$isItemTriggerByTab.getState();
        String str = null;
        CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
        ItemTriggerSourceState itemTriggerSourceState = (ItemTriggerSourceState) (commonState != null ? commonState.select(ItemTriggerSourceState.class) : null);
        if (itemTriggerSourceState != null) {
            str = itemTriggerSourceState.getTriggerMode();
        }
        return Intrinsics.areEqual((Object) str, (Object) ItemTriggerSourceStateKt.ITEM_TRIGGER_SOURCE_TAB);
    }

    public static final boolean isSingleVideoPage(Store<?> $this$isSingleVideoPage) {
        CommonState commonState = null;
        Object state = $this$isSingleVideoPage != null ? $this$isSingleVideoPage.getState() : null;
        if (state instanceof CommonState) {
            commonState = (CommonState) state;
        }
        return isSingleVideoPage(commonState);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = (com.baidu.searchbox.video.detail.core.model.IntentData) r5.select(com.baidu.searchbox.video.detail.core.model.IntentData.class);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isSingleVideoPage(com.baidu.searchbox.feed.detail.arch.ext.CommonState r5) {
        /*
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L_0x0015
            r2 = r5
            r3 = 0
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r4 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r2 = r2.select(r4)
            com.baidu.searchbox.video.detail.core.model.IntentData r2 = (com.baidu.searchbox.video.detail.core.model.IntentData) r2
            if (r2 == 0) goto L_0x0015
            boolean r2 = r2.disableSlide
            if (r2 != r0) goto L_0x0015
            goto L_0x0016
        L_0x0015:
            r0 = r1
        L_0x0016:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.common.CommonStoreExtKt.isSingleVideoPage(com.baidu.searchbox.feed.detail.arch.ext.CommonState):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002b, code lost:
        if (r3 == null) goto L_0x002d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0061  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isShowSettingPanelMuteFunction(com.baidu.searchbox.feed.detail.frame.Store<?> r5) {
        /*
            boolean r0 = com.baidu.searchbox.video.feedflow.common.downgrade.DowngradeUtilKt.canProcessSecondaryFeature((com.baidu.searchbox.feed.detail.frame.Store<?>) r5)
            if (r0 != 0) goto L_0x007b
            com.baidu.searchbox.player.ab.PlayerSPManager r0 = com.baidu.searchbox.player.ab.PlayerSPManager.INSTANCE
            boolean r0 = r0.getFeedGlobalMuteSwitch()
            if (r0 != 0) goto L_0x007b
            r0 = 0
            if (r5 == 0) goto L_0x002d
            r1 = r5
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r1.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x001e
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x001f
        L_0x001e:
            r3 = r0
        L_0x001f:
            if (r3 == 0) goto L_0x0028
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r4 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r3 = r3.select(r4)
            goto L_0x0029
        L_0x0028:
            r3 = r0
        L_0x0029:
            com.baidu.searchbox.video.detail.core.model.IntentData r3 = (com.baidu.searchbox.video.detail.core.model.IntentData) r3
            if (r3 != 0) goto L_0x0051
        L_0x002d:
            if (r5 == 0) goto L_0x0050
            r1 = r5
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r1.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x003c
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x003d
        L_0x003c:
            r3 = r0
        L_0x003d:
            if (r3 == 0) goto L_0x0046
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.nid.FirstJumpNidState> r4 = com.baidu.searchbox.video.feedflow.flow.nid.FirstJumpNidState.class
            java.lang.Object r3 = r3.select(r4)
            goto L_0x0047
        L_0x0046:
            r3 = r0
        L_0x0047:
            com.baidu.searchbox.video.feedflow.flow.nid.FirstJumpNidState r3 = (com.baidu.searchbox.video.feedflow.flow.nid.FirstJumpNidState) r3
            if (r3 == 0) goto L_0x0050
            com.baidu.searchbox.video.detail.core.model.IntentData r3 = r3.getIntentData()
            goto L_0x0051
        L_0x0050:
            r3 = r0
        L_0x0051:
            if (r3 == 0) goto L_0x0056
            java.lang.String r1 = r3.layout
            goto L_0x0057
        L_0x0056:
            r1 = r0
        L_0x0057:
            if (r1 != 0) goto L_0x005b
            java.lang.String r1 = ""
        L_0x005b:
            boolean r1 = com.baidu.searchbox.video.feedflow.flow.list.ItemTypeManifestKt.isDynamicItem((java.lang.String) r1)
            if (r1 != 0) goto L_0x007b
            com.baidu.searchbox.video.feedflow.flow.globalmuteguide.GlobalMuteGuideHelper r1 = com.baidu.searchbox.video.feedflow.flow.globalmuteguide.GlobalMuteGuideHelper.INSTANCE
            if (r5 == 0) goto L_0x006a
            com.baidu.searchbox.feed.detail.frame.State r2 = r5.getState()
            goto L_0x006b
        L_0x006a:
            r2 = r0
        L_0x006b:
            boolean r3 = r2 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r3 == 0) goto L_0x0072
            r0 = r2
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r0 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r0
        L_0x0072:
            boolean r0 = r1.isShowMuteButtonFromFloating(r0)
            if (r0 == 0) goto L_0x0079
            goto L_0x007b
        L_0x0079:
            r0 = 0
            goto L_0x007c
        L_0x007b:
            r0 = 1
        L_0x007c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.common.CommonStoreExtKt.isShowSettingPanelMuteFunction(com.baidu.searchbox.feed.detail.frame.Store):boolean");
    }

    public static final boolean isShowMuteGuideComponentEnabled(Store<?> $this$isShowMuteGuideComponentEnabled) {
        if (!isShowSettingPanelMuteFunction($this$isShowMuteGuideComponentEnabled)) {
            GlobalMuteGuideHelper globalMuteGuideHelper = GlobalMuteGuideHelper.INSTANCE;
            CommonState commonState = null;
            Object state = $this$isShowMuteGuideComponentEnabled != null ? $this$isShowMuteGuideComponentEnabled.getState() : null;
            if (state instanceof CommonState) {
                commonState = (CommonState) state;
            }
            return globalMuteGuideHelper.needShowCancelMuteGuide(commonState);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000d, code lost:
        r0 = (com.baidu.searchbox.video.detail.core.model.IntentData) r5.select(com.baidu.searchbox.video.detail.core.model.IntentData.class);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isSimplePageStyleFromFeed(com.baidu.searchbox.feed.detail.arch.ext.CommonState r5) {
        /*
            r0 = r5
            com.baidu.searchbox.feed.detail.frame.AbsState r0 = (com.baidu.searchbox.feed.detail.frame.AbsState) r0
            boolean r0 = com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt.isPageSourceFromFeed((com.baidu.searchbox.feed.detail.frame.AbsState) r0)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0025
            if (r5 == 0) goto L_0x0021
            r0 = r5
            r3 = 0
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r4 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r0 = r0.select(r4)
            com.baidu.searchbox.video.detail.core.model.IntentData r0 = (com.baidu.searchbox.video.detail.core.model.IntentData) r0
            if (r0 == 0) goto L_0x0021
            boolean r0 = com.baidu.searchbox.video.detail.core.IntextDataExtKt.isSimplePageStyle(r0)
            if (r0 != r1) goto L_0x0021
            r0 = r1
            goto L_0x0022
        L_0x0021:
            r0 = r2
        L_0x0022:
            if (r0 == 0) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r1 = r2
        L_0x0026:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.common.CommonStoreExtKt.isSimplePageStyleFromFeed(com.baidu.searchbox.feed.detail.arch.ext.CommonState):boolean");
    }

    public static final boolean isSimplePageStyleFromFeed(Store<?> $this$isSimplePageStyleFromFeed) {
        CommonState commonState = null;
        Object state = $this$isSimplePageStyleFromFeed != null ? $this$isSimplePageStyleFromFeed.getState() : null;
        if (state instanceof CommonState) {
            commonState = (CommonState) state;
        }
        return isSimplePageStyleFromFeed(commonState);
    }

    public static final boolean isLandingVideoInSimpleStyleFromFeed(CommonState $this$isLandingVideoInSimpleStyleFromFeed) {
        if ($this$isLandingVideoInSimpleStyleFromFeed != null && isSimplePageStyleFromFeed($this$isLandingVideoInSimpleStyleFromFeed)) {
            ItemModel itemModel = (ItemModel) $this$isLandingVideoInSimpleStyleFromFeed.select(ItemModel.class);
            String str = null;
            String nid = itemModel != null ? itemModel.getNid() : null;
            IntentData intentData = (IntentData) $this$isLandingVideoInSimpleStyleFromFeed.select(IntentData.class);
            if (intentData != null) {
                str = intentData.nid;
            }
            if (Intrinsics.areEqual((Object) nid, (Object) str)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isLandingVideoInSimpleStyleFromFeed(Store<?> $this$isLandingVideoInSimpleStyleFromFeed) {
        CommonState commonState = null;
        Object state = $this$isLandingVideoInSimpleStyleFromFeed != null ? $this$isLandingVideoInSimpleStyleFromFeed.getState() : null;
        if (state instanceof CommonState) {
            commonState = (CommonState) state;
        }
        return isLandingVideoInSimpleStyleFromFeed(commonState);
    }

    public static final boolean isPageSelected(Store<?> $this$isPageSelected) {
        CommonState commonState = null;
        Object state = $this$isPageSelected != null ? $this$isPageSelected.getState() : null;
        if (state instanceof CommonState) {
            commonState = (CommonState) state;
        }
        return commonState != null && CommonStateExtKt.isPageSelected(commonState);
    }
}
