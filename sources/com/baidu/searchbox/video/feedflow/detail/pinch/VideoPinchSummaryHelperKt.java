package com.baidu.searchbox.video.feedflow.detail.pinch;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.feed.detail.arch.ComponentArchManager;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.pinchsummary.interfaces.IPinchSummaryService;
import com.baidu.searchbox.pinchsummary.model.PinchSummaryPageInfo;
import com.baidu.searchbox.pinchsummary.model.PinchSummarySceneType;
import com.baidu.searchbox.pinchsummary.model.PinchSummarySourceType;
import com.baidu.searchbox.video.feedflow.flow.list.FlowModelKt;
import com.baidu.searchbox.video.feedflow.flow.list.FlowModelUtilsKt;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.ItemTypeManifestKt;
import com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel;
import com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006H\u0002\u001a&\u0010\u0007\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006H\u0002\u001a\u0016\u0010\b\u001a\u00020\t2\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006H\u0002\u001a\u0012\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0006\u0010\f\u001a\u00020\r\u001a\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u001a\u0014\u0010\u0012\u001a\u00020\u0013*\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¨\u0006\u0014"}, d2 = {"create346UbcParams", "", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "Lcom/baidu/searchbox/feed/detail/frame/AbsState;", "item", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "createUbcParams", "getPinchSummarySceneType", "Lcom/baidu/searchbox/pinchsummary/model/PinchSummarySceneType;", "getSceneTypeByLayoutInternal", "layout", "isPinchSummaryGlobalSwitchOpen", "", "fillPinchSummaryDataSource", "Lcom/baidu/searchbox/pinchsummary/model/PinchSummaryDataSource;", "manager", "Lcom/baidu/searchbox/feed/detail/arch/ComponentArchManager;", "fillPinchSummaryPageInfo", "Lcom/baidu/searchbox/pinchsummary/model/PinchSummaryPageInfo;", "lib-flow-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoPinchSummaryHelper.kt */
public final class VideoPinchSummaryHelperKt {
    public static final boolean isPinchSummaryGlobalSwitchOpen() {
        IPinchSummaryService pinchSummaryService = (IPinchSummaryService) ServiceManager.getService(IPinchSummaryService.Companion.getSERVICE_REFERENCE());
        if (pinchSummaryService != null) {
            return pinchSummaryService.getPinchSummaryGlobalSwitch();
        }
        return false;
    }

    public static final PinchSummaryPageInfo fillPinchSummaryPageInfo(PinchSummaryPageInfo $this$fillPinchSummaryPageInfo, ComponentArchManager manager) {
        IFlowComponentService iFlowComponentService;
        Intrinsics.checkNotNullParameter($this$fillPinchSummaryPageInfo, "<this>");
        ItemModel item = null;
        Store store = manager != null ? manager.getStore() : null;
        if (!(manager == null || (iFlowComponentService = (IFlowComponentService) manager.getService(IFlowComponentService.class)) == null)) {
            item = iFlowComponentService.getCurItemModel();
        }
        $this$fillPinchSummaryPageInfo.setSceneType(getPinchSummarySceneType(item));
        $this$fillPinchSummaryPageInfo.setSourceType(PinchSummarySourceType.VIDEO);
        $this$fillPinchSummaryPageInfo.setUbcExtInfo(createUbcParams(store, item));
        $this$fillPinchSummaryPageInfo.setDurationUBCInfo(create346UbcParams(store, item));
        $this$fillPinchSummaryPageInfo.setTitle(FlowModelKt.getItemTitle(item));
        return $this$fillPinchSummaryPageInfo;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r1 = (com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService) r8.getService(com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService.class);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.baidu.searchbox.pinchsummary.model.PinchSummaryDataSource fillPinchSummaryDataSource(com.baidu.searchbox.pinchsummary.model.PinchSummaryDataSource r7, com.baidu.searchbox.feed.detail.arch.ComponentArchManager r8) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 0
            if (r8 == 0) goto L_0x0019
            r1 = r8
            r2 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService> r3 = com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r1 = r1.getService(r3)
            com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService r1 = (com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService) r1
            if (r1 == 0) goto L_0x0019
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r1 = r1.getCurItemModel()
            goto L_0x001a
        L_0x0019:
            r1 = r0
        L_0x001a:
            if (r8 == 0) goto L_0x0021
            com.baidu.searchbox.feed.detail.frame.Store r2 = r8.getStore()
            goto L_0x0022
        L_0x0021:
            r2 = r0
        L_0x0022:
            if (r1 == 0) goto L_0x0029
            java.lang.String r3 = r1.getNid()
            goto L_0x002a
        L_0x0029:
            r3 = r0
        L_0x002a:
            r7.setPageId(r3)
            com.baidu.searchbox.pinchsummary.model.PinchSummarySceneType r3 = getPinchSummarySceneType(r1)
            r7.setSceneType(r3)
            if (r2 == 0) goto L_0x003d
            com.baidu.searchbox.feed.detail.frame.State r3 = r2.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r3 = (com.baidu.searchbox.feed.detail.frame.AbsState) r3
            goto L_0x003e
        L_0x003d:
            r3 = r0
        L_0x003e:
            boolean r3 = com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt.isPageFromSearchFlow((com.baidu.searchbox.feed.detail.frame.AbsState) r3)
            if (r3 == 0) goto L_0x007b
            if (r2 == 0) goto L_0x006d
            r3 = r2
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r3.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r6 == 0) goto L_0x0053
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x0054
        L_0x0053:
            r5 = r0
        L_0x0054:
            if (r5 == 0) goto L_0x005d
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r6 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r5 = r5.select(r6)
            goto L_0x005e
        L_0x005d:
            r5 = r0
        L_0x005e:
            com.baidu.searchbox.video.detail.core.model.IntentData r5 = (com.baidu.searchbox.video.detail.core.model.IntentData) r5
            if (r5 == 0) goto L_0x006d
            org.json.JSONObject r3 = r5.extRequest
            if (r3 == 0) goto L_0x006d
            java.lang.String r0 = "word"
            java.lang.String r0 = r3.optString(r0)
        L_0x006d:
            if (r0 != 0) goto L_0x0071
            java.lang.String r0 = ""
        L_0x0071:
            r7.setQuery(r0)
            java.lang.String r0 = "search"
            r7.setSourcePage(r0)
            goto L_0x0080
        L_0x007b:
            java.lang.String r0 = "feed"
            r7.setSourcePage(r0)
        L_0x0080:
            java.lang.String r0 = com.baidu.searchbox.video.feedflow.flow.list.FlowModelKt.getItemTitle(r1)
            r7.setTitle(r0)
            com.baidu.searchbox.pinchsummary.model.PinchSummaryDataState r0 = com.baidu.searchbox.pinchsummary.model.PinchSummaryDataState.SUCCESS
            r7.setDataState(r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.pinch.VideoPinchSummaryHelperKt.fillPinchSummaryDataSource(com.baidu.searchbox.pinchsummary.model.PinchSummaryDataSource, com.baidu.searchbox.feed.detail.arch.ComponentArchManager):com.baidu.searchbox.pinchsummary.model.PinchSummaryDataSource");
    }

    private static final PinchSummarySceneType getPinchSummarySceneType(ItemModel<?> item) {
        VideoItemModel transformVideoItemModel = FlowModelUtilsKt.transformVideoItemModel(item);
        boolean z = true;
        if (transformVideoItemModel == null || !transformVideoItemModel.isCollectionPayType()) {
            z = false;
        }
        if (z) {
            return PinchSummarySceneType.VIDEO_PURCHASE;
        }
        return getSceneTypeByLayoutInternal(item != null ? item.getLayout() : null);
    }

    private static final PinchSummarySceneType getSceneTypeByLayoutInternal(String layout) {
        if (layout == null) {
            return PinchSummarySceneType.VIDEO_OTHER;
        }
        if (ItemTypeManifestKt.isVideoItem(layout) || ItemTypeManifestKt.isSimilarCollectionItem(layout) || ItemTypeManifestKt.isPaymentItem(layout) || ItemTypeManifestKt.isAuditVideoItem(layout)) {
            return PinchSummarySceneType.VIDEO_STANDARD;
        }
        if (ItemTypeManifestKt.isLiveItem(layout) || ItemTypeManifestKt.isRealLiveRoomItem(layout) || ItemTypeManifestKt.isAdLiveItem(layout)) {
            return PinchSummarySceneType.VIDEO_LIVE;
        }
        if (ItemTypeManifestKt.isGuessLikeItem(layout) || ItemTypeManifestKt.isInterestItem(layout) || ItemTypeManifestKt.isTalosItem(layout) || ItemTypeManifestKt.isPersonalContentItem(layout) || ItemTypeManifestKt.isFollowBatchItem(layout) || ItemTypeManifestKt.isFollowGuideItem(layout) || ItemTypeManifestKt.isQuerySpecialContentItem(layout) || ItemTypeManifestKt.isAssessmentItem(layout)) {
            return PinchSummarySceneType.VIDEO_BIG_CARD;
        }
        if (ItemTypeManifestKt.isPaymentItem(layout)) {
            return PinchSummarySceneType.VIDEO_LANDING_PURCHASE;
        }
        if (ItemTypeManifestKt.isSoftAdLiveItem(layout) || ItemTypeManifestKt.isAdVideoItem(layout) || ItemTypeManifestKt.isOptAdTopViewItem(layout)) {
            return PinchSummarySceneType.VIDEO_AD;
        }
        if (ItemTypeManifestKt.isDynamicItem(layout)) {
            return PinchSummarySceneType.VIDEO_DT;
        }
        if (ItemTypeManifestKt.isGraphicGenreItem(layout)) {
            return PinchSummarySceneType.VIDEO_ARTICLE;
        }
        return PinchSummarySceneType.VIDEO_OTHER;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ce  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.lang.String create346UbcParams(com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r10, com.baidu.searchbox.video.feedflow.flow.list.ItemModel<?> r11) {
        /*
            java.lang.String r0 = ""
            r1 = 0
            if (r11 == 0) goto L_0x0057
            com.baidu.searchbox.video.feedflow.flow.list.CommonItemData r2 = r11.getCommonItemData()
            if (r2 == 0) goto L_0x0057
            org.json.JSONObject r2 = r2.getExtJo()
            if (r2 == 0) goto L_0x0057
            r3 = r2
            r4 = 0
            java.lang.String r5 = "previouspage"
            java.lang.String r6 = r3.optString(r5)
            java.lang.String r7 = "optString(\"previouspage\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            int r6 = r6.length()
            if (r6 != 0) goto L_0x002a
            r6 = 1
            goto L_0x002b
        L_0x002a:
            r6 = 0
        L_0x002b:
            if (r6 == 0) goto L_0x0055
            if (r10 == 0) goto L_0x004e
            r6 = r10
            r7 = 0
            com.baidu.searchbox.feed.detail.frame.State r8 = r6.getState()
            boolean r9 = r8 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r9 == 0) goto L_0x003c
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r8 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r8
            goto L_0x003d
        L_0x003c:
            r8 = r1
        L_0x003d:
            if (r8 == 0) goto L_0x0046
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r9 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r8 = r8.select(r9)
            goto L_0x0047
        L_0x0046:
            r8 = r1
        L_0x0047:
            com.baidu.searchbox.video.detail.core.model.IntentData r8 = (com.baidu.searchbox.video.detail.core.model.IntentData) r8
            if (r8 == 0) goto L_0x004e
            java.lang.String r6 = r8.page
            goto L_0x004f
        L_0x004e:
            r6 = r1
        L_0x004f:
            if (r6 != 0) goto L_0x0052
            r6 = r0
        L_0x0052:
            r3.putOpt(r5, r6)
        L_0x0055:
            goto L_0x0058
        L_0x0057:
            r2 = r1
        L_0x0058:
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            r4 = r3
            r5 = 0
            java.lang.String r6 = "from"
            java.lang.String r7 = "feed"
            r4.putOpt(r6, r7)
            java.lang.String r6 = "page"
            java.lang.String r7 = "pinch_ai_summary"
            r4.putOpt(r6, r7)
            if (r10 == 0) goto L_0x0090
            r6 = r10
            r7 = 0
            com.baidu.searchbox.feed.detail.frame.State r8 = r6.getState()
            boolean r9 = r8 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r9 == 0) goto L_0x007e
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r8 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r8
            goto L_0x007f
        L_0x007e:
            r8 = r1
        L_0x007f:
            if (r8 == 0) goto L_0x0088
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r9 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r8 = r8.select(r9)
            goto L_0x0089
        L_0x0088:
            r8 = r1
        L_0x0089:
            com.baidu.searchbox.video.detail.core.model.IntentData r8 = (com.baidu.searchbox.video.detail.core.model.IntentData) r8
            if (r8 == 0) goto L_0x0090
            java.lang.String r6 = r8.page
            goto L_0x0091
        L_0x0090:
            r6 = r1
        L_0x0091:
            if (r6 != 0) goto L_0x0094
            r6 = r0
        L_0x0094:
            java.lang.String r7 = "source"
            r4.putOpt(r7, r6)
            java.lang.String r6 = "ext"
            r4.putOpt(r6, r2)
            if (r11 == 0) goto L_0x00a5
            java.lang.String r1 = r11.getNid()
        L_0x00a5:
            if (r1 != 0) goto L_0x00a8
            r1 = r0
        L_0x00a8:
            java.lang.String r6 = "nid"
            r4.putOpt(r6, r1)
            r1 = r3
            kotlin.Result$Companion r3 = kotlin.Result.Companion     // Catch:{ all -> 0x00bc }
            r3 = 0
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x00bc }
            java.lang.Object r3 = kotlin.Result.m8971constructorimpl(r4)     // Catch:{ all -> 0x00bc }
            goto L_0x00c7
        L_0x00bc:
            r3 = move-exception
            kotlin.Result$Companion r4 = kotlin.Result.Companion
            java.lang.Object r3 = kotlin.ResultKt.createFailure(r3)
            java.lang.Object r3 = kotlin.Result.m8971constructorimpl(r3)
        L_0x00c7:
            boolean r4 = kotlin.Result.m8977isFailureimpl(r3)
            if (r4 == 0) goto L_0x00ce
            goto L_0x00cf
        L_0x00ce:
            r0 = r3
        L_0x00cf:
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.pinch.VideoPinchSummaryHelperKt.create346UbcParams(com.baidu.searchbox.feed.detail.frame.Store, com.baidu.searchbox.video.feedflow.flow.list.ItemModel):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d A[Catch:{ all -> 0x0096 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.lang.String createUbcParams(com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r11, com.baidu.searchbox.video.feedflow.flow.list.ItemModel<?> r12) {
        /*
            java.lang.String r0 = ""
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x0096 }
            r1 = 0
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x0096 }
            r2.<init>()     // Catch:{ all -> 0x0096 }
            r3 = r2
            r4 = 0
            r5 = 0
            if (r11 == 0) goto L_0x0016
            com.baidu.searchbox.feed.detail.frame.State r6 = r11.getState()     // Catch:{ all -> 0x0096 }
            com.baidu.searchbox.feed.detail.frame.AbsState r6 = (com.baidu.searchbox.feed.detail.frame.AbsState) r6     // Catch:{ all -> 0x0096 }
            goto L_0x0017
        L_0x0016:
            r6 = r5
        L_0x0017:
            boolean r6 = com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt.isPageFromSearchFlow((com.baidu.searchbox.feed.detail.frame.AbsState) r6)     // Catch:{ all -> 0x0096 }
            if (r6 == 0) goto L_0x0051
            java.lang.String r6 = "page"
            if (r11 == 0) goto L_0x004a
            r7 = r11
            r8 = 0
            com.baidu.searchbox.feed.detail.frame.State r9 = r7.getState()     // Catch:{ all -> 0x0096 }
            boolean r10 = r9 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState     // Catch:{ all -> 0x0096 }
            if (r10 == 0) goto L_0x002f
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r9 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r9     // Catch:{ all -> 0x0096 }
            goto L_0x0030
        L_0x002f:
            r9 = r5
        L_0x0030:
            if (r9 == 0) goto L_0x0039
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r10 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r9 = r9.select(r10)     // Catch:{ all -> 0x0096 }
            goto L_0x003a
        L_0x0039:
            r9 = r5
        L_0x003a:
            com.baidu.searchbox.video.detail.core.model.IntentData r9 = (com.baidu.searchbox.video.detail.core.model.IntentData) r9     // Catch:{ all -> 0x0096 }
            if (r9 == 0) goto L_0x004a
            org.json.JSONObject r7 = r9.extRequest     // Catch:{ all -> 0x0096 }
            if (r7 == 0) goto L_0x004a
            java.lang.String r8 = "word"
            java.lang.String r7 = r7.optString(r8)     // Catch:{ all -> 0x0096 }
            goto L_0x004b
        L_0x004a:
            r7 = r5
        L_0x004b:
            if (r7 != 0) goto L_0x004e
            r7 = r0
        L_0x004e:
            r3.putOpt(r6, r7)     // Catch:{ all -> 0x0096 }
        L_0x0051:
            java.lang.String r6 = "nid"
            if (r12 == 0) goto L_0x005b
            java.lang.String r7 = r12.getNid()     // Catch:{ all -> 0x0096 }
            goto L_0x005c
        L_0x005b:
            r7 = r5
        L_0x005c:
            if (r7 != 0) goto L_0x005f
            r7 = r0
        L_0x005f:
            r3.putOpt(r6, r7)     // Catch:{ all -> 0x0096 }
            java.lang.String r6 = "sourcePage"
            if (r11 == 0) goto L_0x0085
            r7 = r11
            r8 = 0
            com.baidu.searchbox.feed.detail.frame.State r9 = r7.getState()     // Catch:{ all -> 0x0096 }
            boolean r10 = r9 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState     // Catch:{ all -> 0x0096 }
            if (r10 == 0) goto L_0x0074
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r9 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r9     // Catch:{ all -> 0x0096 }
            goto L_0x0075
        L_0x0074:
            r9 = r5
        L_0x0075:
            if (r9 == 0) goto L_0x007e
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r10 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r9 = r9.select(r10)     // Catch:{ all -> 0x0096 }
            goto L_0x007f
        L_0x007e:
            r9 = r5
        L_0x007f:
            com.baidu.searchbox.video.detail.core.model.IntentData r9 = (com.baidu.searchbox.video.detail.core.model.IntentData) r9     // Catch:{ all -> 0x0096 }
            if (r9 == 0) goto L_0x0085
            java.lang.String r5 = r9.page     // Catch:{ all -> 0x0096 }
        L_0x0085:
            if (r5 != 0) goto L_0x0088
            r5 = r0
        L_0x0088:
            r3.putOpt(r6, r5)     // Catch:{ all -> 0x0096 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0096 }
            java.lang.Object r1 = kotlin.Result.m8971constructorimpl(r2)     // Catch:{ all -> 0x0096 }
            goto L_0x00a1
        L_0x0096:
            r1 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r1 = kotlin.ResultKt.createFailure(r1)
            java.lang.Object r1 = kotlin.Result.m8971constructorimpl(r1)
        L_0x00a1:
            boolean r2 = kotlin.Result.m8977isFailureimpl(r1)
            if (r2 == 0) goto L_0x00a8
            goto L_0x00a9
        L_0x00a8:
            r0 = r1
        L_0x00a9:
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.pinch.VideoPinchSummaryHelperKt.createUbcParams(com.baidu.searchbox.feed.detail.frame.Store, com.baidu.searchbox.video.feedflow.flow.list.ItemModel):java.lang.String");
    }
}
