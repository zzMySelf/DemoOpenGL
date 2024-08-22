package com.baidu.searchbox.video.channel.flow.flow.showclick;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.channel.flow.utils.VideoChannelUtils;
import com.baidu.searchbox.video.channel.flow.utils.VideoChannelUtilsKt;
import com.baidu.searchbox.video.channel.tab.utils.ChannelFirstJumpUtilsKt;
import com.baidu.searchbox.video.detail.business.VideoBizUtilsKt;
import com.baidu.searchbox.video.detail.export.ReportClick;
import com.baidu.searchbox.video.detail.export.ReportShow;
import com.baidu.searchbox.video.detail.export.ShowItem;
import com.baidu.searchbox.video.feedflow.flow.list.FlowState;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus;
import com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService;
import com.baidu.searchbox.video.feedflow.flow.showclick.ShowClickUploadPlugin;
import com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0014J\u000e\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006H\u0002J\u0014\u0010\b\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0014J\b\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0004H\u0002¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/video/channel/flow/flow/showclick/ChannelFlowShowClickUploadPlugin;", "Lcom/baidu/searchbox/video/feedflow/flow/showclick/ShowClickUploadPlugin;", "()V", "getClickActionId", "", "curItemModel", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "getFirstCacheRelationItem", "getShowActionId", "getSpecificExt", "Lorg/json/JSONObject;", "getUserWatchStep", "", "curPos", "state", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "interceptFirstJump", "", "isCacheRelationList", "isNotShownLocalData", "runTime", "Lcom/baidu/searchbox/video/feedflow/flow/list/RunTimeStatus;", "onAttachToManager", "", "reportData", "reportClick", "Lcom/baidu/searchbox/video/detail/export/ReportClick;", "reportDataSync", "reportShow", "Lcom/baidu/searchbox/video/detail/export/ReportShow;", "uploadSimple5880Statistic", "type", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelFlowShowClickUploadPlugin.kt */
public final class ChannelFlowShowClickUploadPlugin extends ShowClickUploadPlugin {
    public void onAttachToManager() {
        ChannelShowClickUploadState $this$onAttachToManager_u24lambda_u2d1;
        super.onAttachToManager();
        Store $this$subscribe$iv = getStore();
        if ($this$subscribe$iv != null && ($this$onAttachToManager_u24lambda_u2d1 = (ChannelShowClickUploadState) $this$subscribe$iv.subscribe(ChannelShowClickUploadState.class)) != null) {
            $this$onAttachToManager_u24lambda_u2d1.getUploadWithPosition().observe(this, new ChannelFlowShowClickUploadPlugin$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-1$lambda-0  reason: not valid java name */
    public static final void m4880onAttachToManager$lambda1$lambda0(ChannelFlowShowClickUploadPlugin this$0, Integer position) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(position, "position");
        this$0.reportShowAndClick(position.intValue());
    }

    /* access modifiers changed from: protected */
    public boolean interceptFirstJump() {
        AbsState absState = null;
        if (VideoChannelUtilsKt.isChannelFirstJump$default((Store) getStore(), false, 1, (Object) null)) {
            Store<AbsState> store = getStore();
            if (!VideoBizUtilsKt.isPdFromFeedTabVideo(UBCManifestKt.getPd(store != null ? store.getState() : null))) {
                Store<AbsState> store2 = getStore();
                if (store2 != null) {
                    absState = store2.getState();
                }
                if (VideoBizUtilsKt.isPdFromPush(UBCManifestKt.getPd(absState))) {
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public String getClickActionId(ItemModel<?> curItemModel) {
        Intrinsics.checkNotNullParameter(curItemModel, "curItemModel");
        if (!curItemModel.getRunTimeStatus().isCacheCanAutoScrollNext() || curItemModel.getRunTimeStatus().isReportClick()) {
            return super.getClickActionId(curItemModel);
        }
        return "auto_clk";
    }

    /* access modifiers changed from: protected */
    public String getShowActionId(ItemModel<?> curItemModel) {
        Intrinsics.checkNotNullParameter(curItemModel, "curItemModel");
        if (!curItemModel.getRunTimeStatus().isCacheCanAutoScrollNext() || curItemModel.getRunTimeStatus().isReportShow()) {
            return super.getShowActionId(curItemModel);
        }
        return "auto_display";
    }

    public void reportData(ReportClick reportClick) {
        Intrinsics.checkNotNullParameter(reportClick, "reportClick");
        try {
            JSONObject ext = StringsKt.isBlank(reportClick.getExt()) ? new JSONObject() : new JSONObject(reportClick.getExt());
            JSONObject extLog = ext.optJSONObject("ext_log");
            if (extLog == null) {
                extLog = new JSONObject();
            }
            IFlowComponentService iFlowComponentService = (IFlowComponentService) getManager().getService(IFlowComponentService.class);
            if (iFlowComponentService != null) {
                ItemModel curItemModel = iFlowComponentService.getCurItemModel();
                if (curItemModel != null) {
                    extLog.putOpt("first_index_is_cache", isCacheRelationList() ? "1" : "0");
                    if (curItemModel.getRunTimeStatus().getWindowMovingUpFlagState()) {
                        extLog.putOpt("first_index_toast_type", "shangyi");
                    }
                    if (ChannelFirstJumpUtilsKt.isChannelColdFirstJump$default(getManager(), (ItemModel) null, 1, (Object) null)) {
                        extLog.put("bar_default_video_filter", 1);
                    }
                    String optString = extLog.optString("enterPathWay");
                    Intrinsics.checkNotNullExpressionValue(optString, "extLog.optString(PARAMS_ENTERPATHWAY)");
                    if (StringsKt.isBlank(optString)) {
                        extLog.putOpt("enterPathWay", ChannelShowClickUploadStateKt.getChannelEnterPathWay(getStore()));
                    }
                    ext.putOpt("ext_log", extLog);
                    String jSONObject = ext.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject, "ext.toString()");
                    reportClick.setExt(jSONObject);
                    uploadSimple5880Statistic("102");
                    super.reportData(reportClick);
                }
            }
        } catch (Exception e2) {
        }
    }

    public void reportDataSync(ReportShow reportShow) {
        Intrinsics.checkNotNullParameter(reportShow, "reportShow");
        try {
            List<ShowItem> $this$forEach$iv = reportShow.getItems();
            if ($this$forEach$iv.isEmpty()) {
                super.reportDataSync(reportShow);
                return;
            }
            for (ShowItem item : $this$forEach$iv) {
                JSONObject ext = StringsKt.isBlank(item.getExt()) ? new JSONObject() : new JSONObject(item.getExt());
                IFlowComponentService iFlowComponentService = (IFlowComponentService) getManager().getService(IFlowComponentService.class);
                if (iFlowComponentService != null) {
                    ItemModel curItemModel = iFlowComponentService.getCurItemModel();
                    if (curItemModel != null) {
                        JSONObject extLog = ext.optJSONObject("ext_log");
                        if (extLog == null) {
                            extLog = new JSONObject();
                        } else {
                            Intrinsics.checkNotNullExpressionValue(extLog, "ext.optJSONObject(\"ext_log\") ?: JSONObject()");
                        }
                        extLog.putOpt("first_index_is_cache", isCacheRelationList() ? "1" : "0");
                        if (curItemModel.getRunTimeStatus().getWindowMovingUpFlagState()) {
                            extLog.putOpt("first_index_toast_type", "shangyi");
                        }
                        String optString = extLog.optString("enterPathWay");
                        Intrinsics.checkNotNullExpressionValue(optString, "extLog.optString(PARAMS_ENTERPATHWAY)");
                        if (StringsKt.isBlank(optString)) {
                            extLog.putOpt("enterPathWay", ChannelShowClickUploadStateKt.getChannelEnterPathWay(getStore()));
                        }
                        ext.putOpt("ext_log", extLog);
                        String jSONObject = ext.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject, "ext.toString()");
                        item.setExt(jSONObject);
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            uploadSimple5880Statistic("109");
            super.reportDataSync(reportShow);
        } catch (Exception e2) {
        }
    }

    private final boolean isCacheRelationList() {
        ItemModel itemModel;
        RunTimeStatus runTimeStatus;
        IFlowComponentService iFlowComponentService = (IFlowComponentService) getManager().getService(IFlowComponentService.class);
        List dataSource = iFlowComponentService != null ? iFlowComponentService.getDataSource() : null;
        return (dataSource == null || (itemModel = (ItemModel) CollectionsKt.getOrNull(dataSource, 0)) == null || (runTimeStatus = itemModel.getRunTimeStatus()) == null || !runTimeStatus.isFromCache()) ? false : true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.baidu.searchbox.video.feedflow.flow.list.ItemModel<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.baidu.searchbox.video.feedflow.flow.list.ItemModel<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: com.baidu.searchbox.video.feedflow.flow.list.ItemModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.baidu.searchbox.video.feedflow.flow.list.ItemModel<?>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.baidu.searchbox.video.feedflow.flow.list.ItemModel<?> getFirstCacheRelationItem() {
        /*
            r8 = this;
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r0 = r8.getManager()
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService> r2 = com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r0 = r0.getService(r2)
            com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService r0 = (com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService) r0
            r1 = 0
            if (r0 == 0) goto L_0x0015
            java.util.List r0 = r0.getDataSource()
            goto L_0x0016
        L_0x0015:
            r0 = r1
        L_0x0016:
            if (r0 == 0) goto L_0x0021
            int r2 = r0.size()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0022
        L_0x0021:
            r2 = r1
        L_0x0022:
            int r2 = com.baidu.searchbox.player.utils.BdPlayerUtils.orZero((java.lang.Integer) r2)
            if (r2 <= 0) goto L_0x0068
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0041
            java.lang.Object r4 = kotlin.collections.CollectionsKt.getOrNull(r0, r3)
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r4 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r4
            if (r4 == 0) goto L_0x0041
            com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus r4 = r4.getRunTimeStatus()
            if (r4 == 0) goto L_0x0041
            boolean r4 = r4.isFromCache()
            if (r4 != r2) goto L_0x0041
            r3 = r2
        L_0x0041:
            if (r3 == 0) goto L_0x0068
            r3 = r0
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x004a:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0065
            java.lang.Object r4 = r3.next()
            r5 = r4
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r5 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r5
            r6 = 0
            com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus r7 = r5.getRunTimeStatus()
            boolean r7 = r7.isFromCache()
            r5 = r7 ^ 1
            if (r5 == 0) goto L_0x004a
            r1 = r4
        L_0x0065:
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r1 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r1
            return r1
        L_0x0068:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.channel.flow.flow.showclick.ChannelFlowShowClickUploadPlugin.getFirstCacheRelationItem():com.baidu.searchbox.video.feedflow.flow.list.ItemModel");
    }

    public JSONObject getSpecificExt() {
        JSONObject specificExt = super.getSpecificExt();
        JSONObject $this$getSpecificExt_u24lambda_u2d4 = specificExt;
        $this$getSpecificExt_u24lambda_u2d4.put("extra_pd", VideoChannelUtils.EXTRA_PD);
        $this$getSpecificExt_u24lambda_u2d4.put("video_source", VideoChannelUtils.VIDEO_SOURCE);
        return specificExt;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0028, code lost:
        r1 = (r1 = r3.getCurItemModel()).getRunTimeStatus();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void uploadSimple5880Statistic(java.lang.String r11) {
        /*
            r10 = this;
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x006f }
            r0.<init>()     // Catch:{ JSONException -> 0x006f }
            java.lang.String r1 = "isVideoChannelFirstShow"
            java.lang.String r2 = "3"
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x006f }
            java.lang.String r1 = "type"
            r0.put(r1, r11)     // Catch:{ JSONException -> 0x006f }
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r1 = r10.getManager()     // Catch:{ JSONException -> 0x006f }
            r2 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService> r3 = com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r3 = r1.getService(r3)     // Catch:{ JSONException -> 0x006f }
            com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService r3 = (com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService) r3     // Catch:{ JSONException -> 0x006f }
            if (r3 == 0) goto L_0x0034
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r1 = r3.getCurItemModel()     // Catch:{ JSONException -> 0x006f }
            if (r1 == 0) goto L_0x0034
            com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus r1 = r1.getRunTimeStatus()     // Catch:{ JSONException -> 0x006f }
            if (r1 == 0) goto L_0x0034
            int r1 = r1.getPosition()     // Catch:{ JSONException -> 0x006f }
            goto L_0x0035
        L_0x0034:
            r1 = -1
        L_0x0035:
            java.lang.String r2 = "pos"
            r0.put(r2, r1)     // Catch:{ JSONException -> 0x006f }
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r2 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE     // Catch:{ JSONException -> 0x006f }
            java.lang.String r3 = "feed"
            java.lang.String r4 = "channel_video_landing"
            com.baidu.searchbox.feed.detail.frame.Store r5 = r10.getStore()     // Catch:{ JSONException -> 0x006f }
            r6 = 0
            if (r5 == 0) goto L_0x0066
            r7 = 0
            com.baidu.searchbox.feed.detail.frame.State r8 = r5.getState()     // Catch:{ JSONException -> 0x006f }
            boolean r9 = r8 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState     // Catch:{ JSONException -> 0x006f }
            if (r9 == 0) goto L_0x0055
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r8 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r8     // Catch:{ JSONException -> 0x006f }
            goto L_0x0056
        L_0x0055:
            r8 = r6
        L_0x0056:
            if (r8 == 0) goto L_0x005f
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r9 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r8 = r8.select(r9)     // Catch:{ JSONException -> 0x006f }
            goto L_0x0060
        L_0x005f:
            r8 = r6
        L_0x0060:
            com.baidu.searchbox.video.detail.core.model.IntentData r8 = (com.baidu.searchbox.video.detail.core.model.IntentData) r8     // Catch:{ JSONException -> 0x006f }
            if (r8 == 0) goto L_0x0066
            java.lang.String r6 = r8.pd     // Catch:{ JSONException -> 0x006f }
        L_0x0066:
            if (r6 != 0) goto L_0x006a
            java.lang.String r6 = ""
        L_0x006a:
            r2.upload5800Ubc(r3, r4, r6, r0)     // Catch:{ JSONException -> 0x006f }
            goto L_0x0070
        L_0x006f:
            r0 = move-exception
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.channel.flow.flow.showclick.ChannelFlowShowClickUploadPlugin.uploadSimple5880Statistic(java.lang.String):void");
    }

    private final boolean isNotShownLocalData(RunTimeStatus runTime) {
        return !runTime.isReportShow() && (runTime.isFromCache() || runTime.isFromScheme());
    }

    private final int getUserWatchStep(int curPos, CommonState state) {
        ItemModel itemModel;
        String nid;
        if (state == null || (itemModel = (ItemModel) state.select(ItemModel.class)) == null || (nid = itemModel.getNid()) == null) {
            return curPos;
        }
        FlowState flowState = (FlowState) state.select(FlowState.class);
        return flowState != null ? flowState.getUserWatchStep(nid) : curPos;
    }
}
