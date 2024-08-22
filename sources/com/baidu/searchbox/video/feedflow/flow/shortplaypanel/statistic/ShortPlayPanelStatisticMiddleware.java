package com.baidu.searchbox.video.feedflow.flow.shortplaypanel.statistic;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.detail.export.IVideoFeedReportUtils;
import com.baidu.searchbox.video.detail.export.ReportShow;
import com.baidu.searchbox.video.detail.export.ShowItem;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelState;
import com.baidu.searchbox.video.feedflow.flow.list.CommonItemData;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.ShortMoreItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel;
import com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState;
import com.baidu.searchbox.video.feedflow.ubc.UBC6470;
import com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt;
import com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016J&\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0002J\u0016\u0010\u0011\u001a\u00020\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0002J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J$\u0010\u0013\u001a\u00020\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\f\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0015H\u0002J \u0010\u0016\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0016\u0010\u001a\u001a\u00020\u001b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0002J&\u0010\u001c\u001a\u00020\u001b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000eH\u0002¨\u0006\u001f"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/shortplaypanel/statistic/ShortPlayPanelStatisticMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "build6470Ext", "Lorg/json/JSONObject;", "firstId", "", "collId", "title", "generateStatisticExt", "getCollectionParams", "getExt", "model", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "getExtParams", "isFavor", "", "isShowShortBtn", "reportShow", "", "uploadCollectionPanelUbc", "type", "value", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShortPlayPanelStatisticMiddleware.kt */
public final class ShortPlayPanelStatisticMiddleware implements Middleware<CommonState> {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v24, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v28, resolved type: com.baidu.searchbox.video.feedflow.flow.list.ItemModel<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v30, resolved type: com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v37, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v38, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v39, resolved type: com.baidu.searchbox.video.feedflow.flow.list.ItemModel<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v40, resolved type: java.lang.Object} */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01d0, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) "subscribe") != false) goto L_0x01d2;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.searchbox.feed.detail.frame.Action apply(com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.arch.ext.CommonState> r31, com.baidu.searchbox.feed.detail.frame.Action r32, com.baidu.searchbox.feed.detail.frame.Next<com.baidu.searchbox.feed.detail.arch.ext.CommonState> r33) {
        /*
            r30 = this;
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r33
            java.lang.String r4 = "store"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r4)
            java.lang.String r4 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r4)
            java.lang.String r4 = "next"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r4)
            boolean r4 = r2 instanceof com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction.ShortPlayPanelVisibleChangedAction
            r5 = 0
            r6 = 1
            r7 = 0
            if (r4 == 0) goto L_0x0108
            r4 = r2
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction$ShortPlayPanelVisibleChangedAction r4 = (com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction.ShortPlayPanelVisibleChangedAction) r4
            boolean r4 = r4.getOnlyChangeState()
            if (r4 != 0) goto L_0x046c
            r4 = r2
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction$ShortPlayPanelVisibleChangedAction r4 = (com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction.ShortPlayPanelVisibleChangedAction) r4
            boolean r4 = r4.getVisible()
            if (r4 == 0) goto L_0x00b8
            java.lang.String r4 = "collection_panel"
            r8 = r31
            r9 = 0
            com.baidu.searchbox.feed.detail.frame.State r10 = r8.getState()
            boolean r11 = r10 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r11 == 0) goto L_0x0042
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r10 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r10
            goto L_0x0043
        L_0x0042:
            r10 = r7
        L_0x0043:
            if (r10 == 0) goto L_0x004c
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.FlowState> r11 = com.baidu.searchbox.video.feedflow.flow.list.FlowState.class
            java.lang.Object r10 = r10.select(r11)
            goto L_0x004d
        L_0x004c:
            r10 = r7
        L_0x004d:
            com.baidu.searchbox.video.feedflow.flow.list.FlowState r10 = (com.baidu.searchbox.video.feedflow.flow.list.FlowState) r10
            if (r10 == 0) goto L_0x0058
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r8 = r10.getCurrentPlayItemModel()
            r16 = r8
            goto L_0x005a
        L_0x0058:
            r16 = r7
        L_0x005a:
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r8 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            com.baidu.searchbox.feed.detail.frame.State r9 = r31.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r9 = (com.baidu.searchbox.feed.detail.frame.AbsState) r9
            r12 = 0
            r13 = 0
            r14 = 0
            org.json.JSONObject r15 = r30.generateStatisticExt(r31)
            r17 = 0
            r18 = 0
            r19 = 824(0x338, float:1.155E-42)
            r20 = 0
            java.lang.String r10 = "show"
            r11 = r4
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.uploadPageElementUbc$default(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r8 = r31
            r9 = 0
            com.baidu.searchbox.feed.detail.frame.State r10 = r8.getState()
            boolean r11 = r10 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r11 == 0) goto L_0x0089
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r10 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r10
            goto L_0x008a
        L_0x0089:
            r10 = r7
        L_0x008a:
            if (r10 == 0) goto L_0x0092
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState> r7 = com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState.class
            java.lang.Object r7 = r10.select(r7)
        L_0x0092:
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState r7 = (com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState) r7
            if (r7 == 0) goto L_0x009d
            boolean r7 = r7.isShowPages()
            if (r7 != r6) goto L_0x009d
            r5 = r6
        L_0x009d:
            if (r5 == 0) goto L_0x046c
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r6 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            com.baidu.searchbox.feed.detail.frame.State r5 = r31.getState()
            r7 = r5
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r7 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r7
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 124(0x7c, float:1.74E-43)
            r15 = 0
            java.lang.String r8 = "collection_tab_show"
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.uploadUbc6037$default(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            goto L_0x046c
        L_0x00b8:
            java.lang.String r4 = "collection_panel_close"
            r5 = r31
            r6 = 0
            com.baidu.searchbox.feed.detail.frame.State r8 = r5.getState()
            boolean r9 = r8 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r9 == 0) goto L_0x00c8
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r8 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r8
            goto L_0x00c9
        L_0x00c8:
            r8 = r7
        L_0x00c9:
            if (r8 == 0) goto L_0x00d2
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.FlowState> r9 = com.baidu.searchbox.video.feedflow.flow.list.FlowState.class
            java.lang.Object r8 = r8.select(r9)
            goto L_0x00d3
        L_0x00d2:
            r8 = r7
        L_0x00d3:
            com.baidu.searchbox.video.feedflow.flow.list.FlowState r8 = (com.baidu.searchbox.video.feedflow.flow.list.FlowState) r8
            if (r8 == 0) goto L_0x00db
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r7 = r8.getCurrentPlayItemModel()
        L_0x00db:
            r25 = r7
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r17 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            com.baidu.searchbox.feed.detail.frame.State r5 = r31.getState()
            r18 = r5
            com.baidu.searchbox.feed.detail.frame.AbsState r18 = (com.baidu.searchbox.feed.detail.frame.AbsState) r18
            r21 = 0
            r22 = 0
            r23 = 0
            org.json.JSONObject r24 = r30.generateStatisticExt(r31)
            r26 = 0
            r27 = 0
            r28 = 824(0x338, float:1.155E-42)
            r29 = 0
            java.lang.String r19 = "click"
            r20 = r4
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.uploadPageElementUbc$default(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            r30.reportShow(r31)
            goto L_0x046c
        L_0x0108:
            boolean r4 = r2 instanceof com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction.OnFirstScreenShowAction
            if (r4 == 0) goto L_0x0111
            r30.reportShow(r31)
            goto L_0x046c
        L_0x0111:
            boolean r4 = r2 instanceof com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction.ShortPlayPanelScrollEndAction
            if (r4 == 0) goto L_0x011a
            r30.reportShow(r31)
            goto L_0x046c
        L_0x011a:
            boolean r4 = r2 instanceof com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelAction.ItemClickAction
            if (r4 == 0) goto L_0x0153
            r4 = r2
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelAction$ItemClickAction r4 = (com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelAction.ItemClickAction) r4
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionItemClickActionType r4 = r4.getClickType()
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionItemClickActionType r5 = com.baidu.searchbox.video.feedflow.flow.collection.CollectionItemClickActionType.SHORT_MORE_TYPE
            if (r4 != r5) goto L_0x046c
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r6 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            com.baidu.searchbox.feed.detail.frame.State r4 = r31.getState()
            r7 = r4
            com.baidu.searchbox.feed.detail.frame.AbsState r7 = (com.baidu.searchbox.feed.detail.frame.AbsState) r7
            r10 = 0
            r11 = 0
            r12 = 0
            org.json.JSONObject r13 = r30.generateStatisticExt(r31)
            r4 = r2
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelAction$ItemClickAction r4 = (com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelAction.ItemClickAction) r4
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r14 = r4.getItemModel()
            r15 = 0
            r16 = 0
            r17 = 824(0x338, float:1.155E-42)
            r18 = 0
            java.lang.String r8 = "click"
            java.lang.String r9 = "video_cell"
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.uploadPageElementUbc$default(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            goto L_0x046c
        L_0x0153:
            boolean r4 = r2 instanceof com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction.ShortPlayPanelCloseClick
            if (r4 == 0) goto L_0x01f6
            r4 = r31
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r4.getState()
            boolean r8 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r8 == 0) goto L_0x0165
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x0166
        L_0x0165:
            r6 = r7
        L_0x0166:
            if (r6 == 0) goto L_0x016f
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.FlowState> r8 = com.baidu.searchbox.video.feedflow.flow.list.FlowState.class
            java.lang.Object r6 = r6.select(r8)
            goto L_0x0170
        L_0x016f:
            r6 = r7
        L_0x0170:
            com.baidu.searchbox.video.feedflow.flow.list.FlowState r6 = (com.baidu.searchbox.video.feedflow.flow.list.FlowState) r6
            if (r6 == 0) goto L_0x017b
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r4 = r6.getCurrentPlayItemModel()
            r16 = r4
            goto L_0x017d
        L_0x017b:
            r16 = r7
        L_0x017d:
            r4 = r31
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r4.getState()
            boolean r8 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r8 == 0) goto L_0x018b
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x018c
        L_0x018b:
            r6 = r7
        L_0x018c:
            if (r6 == 0) goto L_0x0195
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelState> r8 = com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelState.class
            java.lang.Object r6 = r6.select(r8)
            goto L_0x0196
        L_0x0195:
            r6 = r7
        L_0x0196:
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelState r6 = (com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelState) r6
            if (r6 == 0) goto L_0x019f
            java.lang.String r4 = r6.getType()
            goto L_0x01a0
        L_0x019f:
            r4 = r7
        L_0x01a0:
            java.lang.String r5 = "payment"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01d2
            r4 = r31
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r4.getState()
            boolean r8 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r8 == 0) goto L_0x01b6
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x01b7
        L_0x01b6:
            r6 = r7
        L_0x01b7:
            if (r6 == 0) goto L_0x01c0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelState> r8 = com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelState.class
            java.lang.Object r6 = r6.select(r8)
            goto L_0x01c1
        L_0x01c0:
            r6 = r7
        L_0x01c1:
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelState r6 = (com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelState) r6
            if (r6 == 0) goto L_0x01c9
            java.lang.String r7 = r6.getType()
        L_0x01c9:
            java.lang.String r4 = "subscribe"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x046c
        L_0x01d2:
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r8 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            com.baidu.searchbox.feed.detail.frame.State r4 = r31.getState()
            r9 = r4
            com.baidu.searchbox.feed.detail.frame.AbsState r9 = (com.baidu.searchbox.feed.detail.frame.AbsState) r9
            r12 = 0
            r13 = 0
            r14 = 0
            org.json.JSONObject r15 = r30.generateStatisticExt(r31)
            r17 = 0
            r18 = 0
            r19 = 824(0x338, float:1.155E-42)
            r20 = 0
            java.lang.String r10 = "click"
            java.lang.String r11 = "collection_pane_payment_close"
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.uploadPageElementUbc$default(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            goto L_0x046c
        L_0x01f6:
            boolean r4 = r2 instanceof com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction.ShortPlayPageTabClickAction
            if (r4 == 0) goto L_0x0254
            r4 = r2
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction$ShortPlayPageTabClickAction r4 = (com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction.ShortPlayPageTabClickAction) r4
            boolean r4 = r4.isSimilar()
            if (r4 == 0) goto L_0x021f
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r7 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            com.baidu.searchbox.feed.detail.frame.State r4 = r31.getState()
            r8 = r4
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r8 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r8
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 120(0x78, float:1.68E-43)
            r16 = 0
            java.lang.String r9 = "click"
            java.lang.String r10 = "relate_collection"
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.uploadUbc6037$default(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            goto L_0x046c
        L_0x021f:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "tab"
            java.lang.StringBuilder r4 = r4.append(r5)
            r5 = r2
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction$ShortPlayPageTabClickAction r5 = (com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction.ShortPlayPageTabClickAction) r5
            int r5 = r5.getPosition()
            int r5 = r5 + r6
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r5 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            com.baidu.searchbox.feed.detail.frame.State r6 = r31.getState()
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 120(0x78, float:1.68E-43)
            r14 = 0
            java.lang.String r7 = "collection_tab_click"
            r8 = r4
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.uploadUbc6037$default(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            goto L_0x046c
        L_0x0254:
            boolean r4 = r2 instanceof com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction.ClickShortPlayShareAction
            java.lang.String r8 = "share_collection"
            java.lang.String r9 = "click"
            if (r4 == 0) goto L_0x0262
            r0.uploadCollectionPanelUbc(r1, r9, r8)
            goto L_0x046c
        L_0x0262:
            boolean r4 = r2 instanceof com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction.ShowShortPanelShareBtnAction
            java.lang.String r10 = "show"
            if (r4 == 0) goto L_0x026e
            r0.uploadCollectionPanelUbc(r1, r10, r8)
            goto L_0x046c
        L_0x026e:
            boolean r4 = r2 instanceof com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction.ShowShortPlayShortPlayPayBtnAction
            if (r4 == 0) goto L_0x0279
            java.lang.String r4 = "buy_playlet"
            r0.uploadCollectionPanelUbc(r1, r10, r4)
            goto L_0x046c
        L_0x0279:
            boolean r4 = r2 instanceof com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction.ShortPlayFavorShowAction
            if (r4 == 0) goto L_0x02ce
            boolean r4 = com.baidu.searchbox.video.feedflow.detail.favor.favorshortguide.FavorShortGuideUtilsKt.isHitExperimentAndShortPlay((com.baidu.searchbox.feed.detail.frame.Store<?>) r31)
            r7 = r2
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction$ShortPlayFavorShowAction r7 = (com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction.ShortPlayFavorShowAction) r7
            boolean r7 = r7.isShow()
            if (r7 == 0) goto L_0x046c
            r7 = r2
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction$ShortPlayFavorShowAction r7 = (com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction.ShortPlayFavorShowAction) r7
            java.lang.String r7 = r7.getCllId()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            int r7 = r7.length()
            if (r7 <= 0) goto L_0x029a
            r5 = r6
        L_0x029a:
            if (r5 == 0) goto L_0x046c
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r6 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            com.baidu.searchbox.feed.detail.frame.State r5 = r31.getState()
            r7 = r5
            com.baidu.searchbox.feed.detail.frame.AbsState r7 = (com.baidu.searchbox.feed.detail.frame.AbsState) r7
            r10 = 0
            r11 = 0
            r12 = 0
            r5 = r2
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction$ShortPlayFavorShowAction r5 = (com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction.ShortPlayFavorShowAction) r5
            java.lang.String r5 = r5.getCllId()
            r8 = r2
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction$ShortPlayFavorShowAction r8 = (com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction.ShortPlayFavorShowAction) r8
            boolean r8 = r8.isFavor()
            org.json.JSONObject r13 = r0.getExtParams(r5, r8, r4)
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 952(0x3b8, float:1.334E-42)
            r18 = 0
            java.lang.String r8 = "show"
            java.lang.String r9 = "mark"
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.uploadPageElementUbc$default(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            goto L_0x046c
        L_0x02ce:
            boolean r4 = r2 instanceof com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction.ShortPlayFavorClickAction
            if (r4 == 0) goto L_0x031b
            boolean r4 = com.baidu.searchbox.video.feedflow.detail.favor.favorshortguide.FavorShortGuideUtilsKt.isHitExperimentAndShortPlay((com.baidu.searchbox.feed.detail.frame.Store<?>) r31)
            r7 = r2
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction$ShortPlayFavorClickAction r7 = (com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction.ShortPlayFavorClickAction) r7
            java.lang.String r7 = r7.getCllId()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            int r7 = r7.length()
            if (r7 <= 0) goto L_0x02e6
            r5 = r6
        L_0x02e6:
            if (r5 == 0) goto L_0x046c
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r7 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            com.baidu.searchbox.feed.detail.frame.State r5 = r31.getState()
            r8 = r5
            com.baidu.searchbox.feed.detail.frame.AbsState r8 = (com.baidu.searchbox.feed.detail.frame.AbsState) r8
            r11 = 0
            r12 = 0
            r13 = 0
            r5 = r2
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction$ShortPlayFavorClickAction r5 = (com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction.ShortPlayFavorClickAction) r5
            java.lang.String r5 = r5.getCllId()
            r9 = r2
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction$ShortPlayFavorClickAction r9 = (com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction.ShortPlayFavorClickAction) r9
            boolean r9 = r9.isFavor()
            r6 = r6 ^ r9
            org.json.JSONObject r14 = r0.getExtParams(r5, r6, r4)
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 952(0x3b8, float:1.334E-42)
            r19 = 0
            java.lang.String r9 = "click"
            java.lang.String r10 = "mark"
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.uploadPageElementUbc$default(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            goto L_0x046c
        L_0x031b:
            boolean r4 = r2 instanceof com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction.ShortPlayPanelIntroduceFoldViewClick
            if (r4 == 0) goto L_0x033d
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r10 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            com.baidu.searchbox.feed.detail.frame.State r4 = r31.getState()
            r11 = r4
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r11 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r11
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 120(0x78, float:1.68E-43)
            r19 = 0
            java.lang.String r12 = "click"
            java.lang.String r13 = "abstract_expand"
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.uploadUbc6037$default(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            goto L_0x046c
        L_0x033d:
            boolean r4 = r2 instanceof com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction.ShortPlayPanelIntroduceFoldViewShow
            if (r4 == 0) goto L_0x0360
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r10 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            com.baidu.searchbox.feed.detail.frame.State r4 = r31.getState()
            r11 = r4
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r11 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r11
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 120(0x78, float:1.68E-43)
            r19 = 0
            java.lang.String r12 = "show"
            java.lang.String r13 = "abstract_expand"
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.uploadUbc6037$default(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            goto L_0x046c
        L_0x0360:
            boolean r4 = r2 instanceof com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction.TopTitleViewSubTitleClick
            if (r4 == 0) goto L_0x0382
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r10 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            com.baidu.searchbox.feed.detail.frame.State r4 = r31.getState()
            r11 = r4
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r11 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r11
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 120(0x78, float:1.68E-43)
            r19 = 0
            java.lang.String r12 = "click"
            java.lang.String r13 = "detail_button"
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.uploadUbc6037$default(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            goto L_0x046c
        L_0x0382:
            boolean r4 = r2 instanceof com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction.ClickShortPlayMoreViewAction
            if (r4 == 0) goto L_0x03a4
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r10 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            com.baidu.searchbox.feed.detail.frame.State r4 = r31.getState()
            r11 = r4
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r11 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r11
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 120(0x78, float:1.68E-43)
            r19 = 0
            java.lang.String r12 = "click"
            java.lang.String r13 = "more_collection"
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.uploadUbc6037$default(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            goto L_0x046c
        L_0x03a4:
            boolean r4 = r2 instanceof com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction.ShowShortPlayMoreViewAction
            if (r4 == 0) goto L_0x03c7
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r10 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            com.baidu.searchbox.feed.detail.frame.State r4 = r31.getState()
            r11 = r4
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r11 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r11
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 120(0x78, float:1.68E-43)
            r19 = 0
            java.lang.String r12 = "show"
            java.lang.String r13 = "more_collection"
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.uploadUbc6037$default(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            goto L_0x046c
        L_0x03c7:
            boolean r4 = r2 instanceof com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction.ClickShortPlayViewAction
            if (r4 == 0) goto L_0x0424
            r4 = r31
            r6 = 0
            com.baidu.searchbox.feed.detail.frame.State r8 = r4.getState()
            boolean r10 = r8 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r10 == 0) goto L_0x03d9
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r8 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r8
            goto L_0x03da
        L_0x03d9:
            r8 = r7
        L_0x03da:
            if (r8 == 0) goto L_0x03e3
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState> r10 = com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState.class
            java.lang.Object r8 = r8.select(r10)
            goto L_0x03e4
        L_0x03e3:
            r8 = r7
        L_0x03e4:
            r4 = r8
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState r4 = (com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState) r4
            if (r4 == 0) goto L_0x03ee
            java.util.List r6 = r4.getDataShortPlaySource()
            goto L_0x03ef
        L_0x03ee:
            r6 = r7
        L_0x03ef:
            if (r6 == 0) goto L_0x03fe
            java.lang.Object r5 = kotlin.collections.CollectionsKt.getOrNull(r6, r5)
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r5 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r5
            if (r5 == 0) goto L_0x03fe
            java.lang.String r5 = r5.getId()
            goto L_0x03ff
        L_0x03fe:
            r5 = r7
        L_0x03ff:
            java.lang.String r8 = ""
            if (r5 != 0) goto L_0x0404
            r5 = r8
        L_0x0404:
            if (r4 == 0) goto L_0x040a
            java.lang.String r7 = r4.getCollId()
        L_0x040a:
            if (r7 != 0) goto L_0x040d
            goto L_0x040e
        L_0x040d:
            r8 = r7
        L_0x040e:
            r7 = r8
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r8 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            r10 = r2
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction$ClickShortPlayViewAction r10 = (com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction.ClickShortPlayViewAction) r10
            java.lang.String r10 = r10.getTitle()
            org.json.JSONObject r10 = r0.build6470Ext(r5, r7, r10)
            java.lang.String r11 = "pannel_more_shortplay"
            r8.upload6470Ubc(r1, r9, r11, r10)
            goto L_0x046c
        L_0x0424:
            boolean r4 = r2 instanceof com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction.ShortPlayPanelBannerShowAction
            if (r4 == 0) goto L_0x0449
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r5 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            com.baidu.searchbox.feed.detail.frame.State r4 = r31.getState()
            r6 = r4
            com.baidu.searchbox.feed.detail.frame.AbsState r6 = (com.baidu.searchbox.feed.detail.frame.AbsState) r6
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 504(0x1f8, float:7.06E-43)
            r17 = 0
            java.lang.String r7 = "show"
            java.lang.String r8 = "panel_operation"
            java.lang.String r15 = "6037"
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.uploadPageElementUbc$default(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            goto L_0x046c
        L_0x0449:
            boolean r4 = r2 instanceof com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction.ShortPlayPanelBannerClickAction
            if (r4 == 0) goto L_0x046c
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r5 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            com.baidu.searchbox.feed.detail.frame.State r4 = r31.getState()
            r6 = r4
            com.baidu.searchbox.feed.detail.frame.AbsState r6 = (com.baidu.searchbox.feed.detail.frame.AbsState) r6
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 504(0x1f8, float:7.06E-43)
            r17 = 0
            java.lang.String r7 = "click"
            java.lang.String r8 = "panel_operation"
            java.lang.String r15 = "6037"
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.uploadPageElementUbc$default(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
        L_0x046c:
            com.baidu.searchbox.feed.detail.frame.Action r4 = r3.next(r1, r2)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.shortplaypanel.statistic.ShortPlayPanelStatisticMiddleware.apply(com.baidu.searchbox.feed.detail.frame.Store, com.baidu.searchbox.feed.detail.frame.Action, com.baidu.searchbox.feed.detail.frame.Next):com.baidu.searchbox.feed.detail.frame.Action");
    }

    private final void uploadCollectionPanelUbc(Store<CommonState> store, String type, String value) {
        JSONObject jSONObject;
        try {
            Result.Companion companion = Result.Companion;
            ShortPlayPanelStatisticMiddleware shortPlayPanelStatisticMiddleware = this;
            JSONObject jSONObject2 = new JSONObject();
            CommonState state = store.getState();
            String str = null;
            CommonState commonState = state instanceof CommonState ? state : null;
            CollectionPanelState collectionPanelState = (CollectionPanelState) (commonState != null ? commonState.select(CollectionPanelState.class) : null);
            if (collectionPanelState != null) {
                str = collectionPanelState.getCollId();
            }
            if (str == null) {
                str = "";
            }
            jSONObject = Result.m8971constructorimpl(jSONObject2.putOpt("collection_id", str));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            jSONObject = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        JSONObject jSONObject3 = new JSONObject();
        if (Result.m8977isFailureimpl(jSONObject)) {
            jSONObject = jSONObject3;
        }
        VideoFlowUBCHelper.uploadPageElementUbc$default(VideoFlowUBCHelper.INSTANCE, store.getState(), type, value, (String) null, (String) null, (String) null, (JSONObject) jSONObject, (ItemModel) null, false, "6037", 440, (Object) null);
    }

    private final JSONObject generateStatisticExt(Store<CommonState> store) {
        JSONObject jSONObject = new JSONObject();
        CommonState state = store.getState();
        String str = null;
        CommonState commonState = state instanceof CommonState ? state : null;
        IntentData intentData = (IntentData) (commonState != null ? commonState.select(IntentData.class) : null);
        if (intentData != null) {
            str = intentData.extLog;
        }
        if (str == null) {
            return jSONObject;
        }
        String ext = str;
        if (!(!StringsKt.isBlank(ext))) {
            return jSONObject;
        }
        try {
            jSONObject = new JSONObject(ext);
            JSONObject $this$generateStatisticExt_u24lambda_u2d1 = new JSONObject();
            $this$generateStatisticExt_u24lambda_u2d1.putOpt("bannerType", jSONObject.optString("bannerType"));
            Unit unit = Unit.INSTANCE;
            jSONObject.put("banner_ext", $this$generateStatisticExt_u24lambda_u2d1);
            return jSONObject;
        } catch (JSONException e2) {
            return jSONObject;
        }
    }

    private final void reportShow(Store<CommonState> store) {
        List dataList;
        ShortPlayPanelStatisticMiddleware shortPlayPanelStatisticMiddleware = this;
        Store<CommonState> store2 = store;
        CommonState state = store.getState();
        String str = null;
        CommonState commonState = state instanceof CommonState ? state : null;
        ShortPlayPanelState state2 = (ShortPlayPanelState) (commonState != null ? commonState.select(ShortPlayPanelState.class) : null);
        if (state2 != null && (dataList = state2.getDataShortPlaySource()) != null) {
            ItemModel itemModel = (ItemModel) CollectionsKt.getOrNull(dataList, 0);
            if (itemModel != null) {
                str = itemModel.getId();
            }
            if (str == null) {
                str = "";
            }
            String firstId = str;
            List showItems109 = new ArrayList();
            List<Pair> showItems6470 = new ArrayList<>();
            int size = dataList.size();
            for (int position = 0; position < size; position++) {
                ItemModel item = dataList.get(position);
                if (item.getRunTimeStatus().getNeedReportShow() && !item.getRunTimeStatus().isReportShow()) {
                    item.getRunTimeStatus().setReportShow(true);
                    if (item.getData() instanceof VideoItemModel) {
                        String nid = item.getNid();
                        String valueOf = String.valueOf(position);
                        String jSONObject = shortPlayPanelStatisticMiddleware.getExt(store2, item).toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject, "getExt(store, item).toString()");
                        showItems109.add(new ShowItem(nid, valueOf, jSONObject, (String) null, 8, (DefaultConstructorMarker) null));
                    } else if (!Intrinsics.areEqual((Object) item.getId(), (Object) "1") && (item.getData() instanceof ShortMoreItemModel) && ((ShortMoreItemModel) item.getData()).getShortPlayPanelItemType() == 2) {
                        showItems6470.add(TuplesKt.to(item.getId(), ((ShortMoreItemModel) item.getData()).getTitle()));
                    }
                }
            }
            if (showItems109.size() > 0) {
                IVideoFeedReportUtils.Impl.INSTANCE.get().reportDataSync(new ReportShow("land_page", "display", showItems109, (String) null, (String) null, (String) null, 56, (DefaultConstructorMarker) null));
            }
            if (showItems6470.size() > 0) {
                for (Pair value : showItems6470) {
                    VideoFlowUBCHelper.INSTANCE.upload6470Ubc(store2, "show", UBC6470.Value.VALUE_SHORT_PLAY_PANEL_MORE, shortPlayPanelStatisticMiddleware.build6470Ext(firstId, (String) value.getFirst(), (String) value.getSecond()));
                    shortPlayPanelStatisticMiddleware = this;
                }
            }
        }
    }

    private final JSONObject build6470Ext(String firstId, String collId, String title) {
        JSONObject jSONObject;
        try {
            Result.Companion companion = Result.Companion;
            JSONObject jSONObject2 = new JSONObject();
            JSONObject $this$build6470Ext_u24lambda_u2d4_u24lambda_u2d3 = jSONObject2;
            $this$build6470Ext_u24lambda_u2d4_u24lambda_u2d3.putOpt("id", firstId);
            $this$build6470Ext_u24lambda_u2d4_u24lambda_u2d3.putOpt("collection_id", collId);
            $this$build6470Ext_u24lambda_u2d4_u24lambda_u2d3.putOpt("title", title);
            jSONObject = Result.m8971constructorimpl(jSONObject2);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            jSONObject = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        JSONObject jSONObject3 = new JSONObject();
        if (Result.m8977isFailureimpl(jSONObject)) {
            jSONObject = jSONObject3;
        }
        return (JSONObject) jSONObject;
    }

    private final JSONObject getExt(Store<CommonState> store, ItemModel<?> model) {
        if (model == null) {
            return new JSONObject();
        }
        try {
            CommonState state = store.getState();
            JSONObject jSONObject = null;
            CommonState commonState = state instanceof CommonState ? state : null;
            IntentData intentData = (IntentData) (commonState != null ? commonState.select(IntentData.class) : null);
            String page = intentData != null ? intentData.page : null;
            String extString = "";
            if (page == null) {
                page = extString;
            }
            CommonItemData commonItemData = model.getCommonItemData();
            String ext = commonItemData != null ? commonItemData.getExt() : null;
            if (ext != null) {
                extString = ext;
            }
            JSONObject ext2 = StringsKt.isBlank(extString) ^ true ? new JSONObject(extString) : new JSONObject();
            ext2.putOpt("status", UBCManifestKt.getLandscapeModeStatus(store.getState()));
            CommonItemData commonItemData2 = model.getCommonItemData();
            if (commonItemData2 != null) {
                jSONObject = commonItemData2.getExtLogJo();
            }
            ext2.putOpt("ext_log", jSONObject);
            ext2.putOpt("netType", DIFactory.INSTANCE.getNetType());
            ext2.putOpt("page", page);
            ext2.putOpt("actionType", "show");
            return ext2;
        } catch (Exception e2) {
            return new JSONObject();
        }
    }

    private final JSONObject getExtParams(String collId, boolean isFavor, boolean isShowShortBtn) {
        String buttonStatus;
        if (isFavor) {
            buttonStatus = "follow";
        } else {
            buttonStatus = "cancel";
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject $this$getExtParams_u24lambda_u2d5 = jSONObject;
        $this$getExtParams_u24lambda_u2d5.putOpt("button_status", buttonStatus);
        $this$getExtParams_u24lambda_u2d5.putOpt("collection", getCollectionParams(collId));
        if (isShowShortBtn) {
            $this$getExtParams_u24lambda_u2d5.putOpt("is_collection_zj", "1");
        }
        return jSONObject;
    }

    private final JSONObject getCollectionParams(String collId) {
        JSONObject $this$getCollectionParams_u24lambda_u2d6 = new JSONObject();
        $this$getCollectionParams_u24lambda_u2d6.putOpt("id", collId);
        return $this$getCollectionParams_u24lambda_u2d6;
    }
}
