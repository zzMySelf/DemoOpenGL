package com.baidu.searchbox.video.feedflow.detail.listpanel.statistic;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.video.feedflow.detail.appdownload.VideoDownloadClickType;
import com.baidu.searchbox.video.feedflow.detail.banner.model.FlowDetailBannerModelKt;
import com.baidu.searchbox.video.feedflow.detail.banner.model.GoodsCommonBannerModel;
import com.baidu.searchbox.video.inf.GoodsModel;
import com.baidu.searchbox.video.inf.GoodsRollBarModel;
import com.baidu.searchbox.video.inf.ListPanelItemModel;
import com.baidu.searchbox.video.inf.ListPanelModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016J\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0002J\u001c\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\b\u001a\u00020\u0012H\u0002J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0014H\u0002J\u0016\u0010\u0015\u001a\u0004\u0018\u00010\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0002J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\r\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010\u0019\u001a\u00020\u00182\b\u0010\r\u001a\u0004\u0018\u00010\u0014H\u0002J\u001c\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\r\u001a\u0004\u0018\u00010\u0014H\u0002¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/listpanel/statistic/ListPanelStatisticMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "getPanelClickSpecialExt", "Lorg/json/JSONObject;", "model", "Lcom/baidu/searchbox/video/inf/ListPanelItemModel;", "getPanelCommonAndDownloadUbc", "Lkotlin/Pair;", "", "Lcom/baidu/searchbox/video/feedflow/detail/listpanel/ListPanelVisibleChangeAction;", "getPanelCommonAndPaShowSpecialExt", "Lcom/baidu/searchbox/video/inf/ListPanelModel;", "getPanelDownloadItemClickSpecialExt", "getPanelShowSpecialExt", "isPanelCommonAndDownloadType", "", "isPanelDownloadType", "reportPanelShow15396", "", "state", "Lcom/baidu/searchbox/feed/detail/frame/AbsState;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ListPanelStatisticMiddleware.kt */
public final class ListPanelStatisticMiddleware implements Middleware<CommonState> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ListPanelStatisticMiddleware.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VideoDownloadClickType.values().length];
            iArr[VideoDownloadClickType.DOWNLOAD.ordinal()] = 1;
            iArr[VideoDownloadClickType.INSTALL.ordinal()] = 2;
            iArr[VideoDownloadClickType.OPEN.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: com.baidu.searchbox.video.feedflow.detail.banner.model.BannerRedPacketModel} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.searchbox.feed.detail.frame.Action apply(com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.arch.ext.CommonState> r32, com.baidu.searchbox.feed.detail.frame.Action r33, com.baidu.searchbox.feed.detail.frame.Next<com.baidu.searchbox.feed.detail.arch.ext.CommonState> r34) {
        /*
            r31 = this;
            r0 = r31
            r1 = r32
            r2 = r33
            r3 = r34
            java.lang.String r4 = "store"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r4)
            java.lang.String r4 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r4)
            java.lang.String r4 = "next"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r4)
            boolean r4 = r2 instanceof com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelVisibleChangeAction
            if (r4 == 0) goto L_0x00fb
            r4 = r2
            com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelVisibleChangeAction r4 = (com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelVisibleChangeAction) r4
            boolean r4 = r4.isShown()
            if (r4 == 0) goto L_0x0260
            r4 = r2
            com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelVisibleChangeAction r4 = (com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelVisibleChangeAction) r4
            com.baidu.searchbox.video.inf.ListPanelModel r4 = r4.getModel()
            boolean r4 = r0.isPanelCommonAndDownloadType(r4)
            if (r4 == 0) goto L_0x009e
            r4 = r2
            com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelVisibleChangeAction r4 = (com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelVisibleChangeAction) r4
            kotlin.Pair r4 = r0.getPanelCommonAndDownloadUbc(r4)
            java.lang.Object r5 = r4.component1()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r4 = r4.component2()
            java.lang.String r4 = (java.lang.String) r4
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r6 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            com.baidu.searchbox.feed.detail.frame.State r7 = r32.getState()
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r7 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r7
            r8 = r2
            com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelVisibleChangeAction r8 = (com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelVisibleChangeAction) r8
            com.baidu.searchbox.video.inf.ListPanelModel r8 = r8.getModel()
            org.json.JSONObject r13 = r0.getPanelCommonAndPaShowSpecialExt(r8)
            com.baidu.searchbox.feed.detail.frame.AbsState r7 = (com.baidu.searchbox.feed.detail.frame.AbsState) r7
            r10 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r15 = 0
            r17 = 440(0x1b8, float:6.17E-43)
            r18 = 0
            java.lang.String r8 = "show"
            r9 = r5
            r16 = r4
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.uploadPageElementUbc$default(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r6 = r2
            com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelVisibleChangeAction r6 = (com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelVisibleChangeAction) r6
            com.baidu.searchbox.video.inf.ListPanelModel r6 = r6.getModel()
            boolean r6 = r0.isPanelDownloadType(r6)
            if (r6 != 0) goto L_0x0260
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r6 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            com.baidu.searchbox.feed.detail.frame.State r7 = r32.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r7 = (com.baidu.searchbox.feed.detail.frame.AbsState) r7
            r8 = r2
            com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelVisibleChangeAction r8 = (com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelVisibleChangeAction) r8
            com.baidu.searchbox.video.inf.ListPanelModel r8 = r8.getModel()
            org.json.JSONObject r10 = r0.getPanelCommonAndPaShowSpecialExt(r8)
            r11 = 0
            r12 = 16
            r13 = 0
            java.lang.String r8 = "display"
            r9 = r5
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.upload3838Ubc$default(r6, r7, r8, r9, r10, r11, r12, r13)
            goto L_0x0260
        L_0x009e:
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r14 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            com.baidu.searchbox.feed.detail.frame.State r4 = r32.getState()
            r15 = r4
            com.baidu.searchbox.feed.detail.frame.AbsState r15 = (com.baidu.searchbox.feed.detail.frame.AbsState) r15
            r18 = 0
            r19 = 0
            r20 = 0
            r4 = r2
            com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelVisibleChangeAction r4 = (com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelVisibleChangeAction) r4
            com.baidu.searchbox.video.inf.ListPanelModel r4 = r4.getModel()
            org.json.JSONObject r21 = r0.getPanelShowSpecialExt(r4)
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 952(0x3b8, float:1.334E-42)
            r26 = 0
            java.lang.String r16 = "show"
            java.lang.String r17 = "goods_panel"
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.uploadPageElementUbc$default(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r4 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            com.baidu.searchbox.feed.detail.frame.State r5 = r32.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r5 = (com.baidu.searchbox.feed.detail.frame.AbsState) r5
            r6 = r2
            com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelVisibleChangeAction r6 = (com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelVisibleChangeAction) r6
            com.baidu.searchbox.video.inf.ListPanelModel r6 = r6.getModel()
            org.json.JSONObject r8 = r0.getPanelShowSpecialExt(r6)
            r9 = 0
            r10 = 16
            r11 = 0
            java.lang.String r6 = "display"
            java.lang.String r7 = "goods_panel"
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.upload3838Ubc$default(r4, r5, r6, r7, r8, r9, r10, r11)
            com.baidu.searchbox.feed.detail.frame.State r4 = r32.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r4 = (com.baidu.searchbox.feed.detail.frame.AbsState) r4
            r5 = r2
            com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelVisibleChangeAction r5 = (com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelVisibleChangeAction) r5
            com.baidu.searchbox.video.inf.ListPanelModel r5 = r5.getModel()
            r0.reportPanelShow15396(r4, r5)
            goto L_0x0260
        L_0x00fb:
            boolean r4 = r2 instanceof com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelItemClickAction
            r5 = 0
            if (r4 == 0) goto L_0x01f0
            r4 = r2
            com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelItemClickAction r4 = (com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelItemClickAction) r4
            com.baidu.searchbox.video.inf.ListPanelItemModel r4 = r4.getModel()
            java.lang.String r4 = r4.getLayout()
            int r6 = r4.hashCode()
            switch(r6) {
                case 457783984: goto L_0x018f;
                case 977830009: goto L_0x013d;
                case 1184594248: goto L_0x0114;
                default: goto L_0x0112;
            }
        L_0x0112:
            goto L_0x01c1
        L_0x0114:
            java.lang.String r5 = "guideBanner"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x011d
            goto L_0x0112
        L_0x011d:
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r5 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            com.baidu.searchbox.feed.detail.frame.State r4 = r32.getState()
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
            java.lang.String r8 = "activity_banner"
            java.lang.String r15 = "15396"
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.uploadPageElementUbc$default(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            goto L_0x0260
        L_0x013d:
            java.lang.String r6 = "redPacket"
            boolean r4 = r4.equals(r6)
            if (r4 != 0) goto L_0x0147
            goto L_0x0112
        L_0x0147:
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r6 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            com.baidu.searchbox.feed.detail.frame.State r4 = r32.getState()
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r7 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            r8 = r2
            com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelItemClickAction r8 = (com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelItemClickAction) r8
            com.baidu.searchbox.video.inf.ListPanelItemModel r8 = r8.getModel()
            java.lang.Object r8 = r8.getData()
            boolean r9 = r8 instanceof com.baidu.searchbox.video.feedflow.detail.banner.model.BannerRedPacketModel
            if (r9 == 0) goto L_0x0164
            r5 = r8
            com.baidu.searchbox.video.feedflow.detail.banner.model.BannerRedPacketModel r5 = (com.baidu.searchbox.video.feedflow.detail.banner.model.BannerRedPacketModel) r5
        L_0x0164:
            if (r5 == 0) goto L_0x016c
            java.lang.String r5 = r5.getExt()
            if (r5 != 0) goto L_0x016e
        L_0x016c:
            java.lang.String r5 = ""
        L_0x016e:
            java.lang.String r8 = "card_ext"
            org.json.JSONObject r13 = r7.generateSpecialExt(r8, r5)
            r7 = r4
            com.baidu.searchbox.feed.detail.frame.AbsState r7 = (com.baidu.searchbox.feed.detail.frame.AbsState) r7
            r10 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r15 = 0
            r17 = 440(0x1b8, float:6.17E-43)
            r18 = 0
            java.lang.String r8 = "click"
            java.lang.String r9 = "red_envelope_card"
            java.lang.String r16 = "15396"
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.uploadPageElementUbc$default(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            goto L_0x0260
        L_0x018f:
            java.lang.String r5 = "common_panel"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0199
            goto L_0x0112
        L_0x0199:
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r5 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            com.baidu.searchbox.feed.detail.frame.State r4 = r32.getState()
            r6 = r4
            com.baidu.searchbox.feed.detail.frame.AbsState r6 = (com.baidu.searchbox.feed.detail.frame.AbsState) r6
            r9 = 0
            r10 = 0
            r11 = 0
            r4 = r2
            com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelItemClickAction r4 = (com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelItemClickAction) r4
            com.baidu.searchbox.video.inf.ListPanelItemModel r4 = r4.getModel()
            org.json.JSONObject r12 = r0.getPanelDownloadItemClickSpecialExt(r4)
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 952(0x3b8, float:1.334E-42)
            r17 = 0
            java.lang.String r7 = "click"
            java.lang.String r8 = "banner"
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.uploadPageElementUbc$default(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            goto L_0x0260
        L_0x01c1:
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r18 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            com.baidu.searchbox.feed.detail.frame.State r4 = r32.getState()
            r19 = r4
            com.baidu.searchbox.feed.detail.frame.AbsState r19 = (com.baidu.searchbox.feed.detail.frame.AbsState) r19
            r22 = 0
            r23 = 0
            r24 = 0
            r4 = r2
            com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelItemClickAction r4 = (com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelItemClickAction) r4
            com.baidu.searchbox.video.inf.ListPanelItemModel r4 = r4.getModel()
            org.json.JSONObject r25 = r0.getPanelClickSpecialExt(r4)
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 952(0x3b8, float:1.334E-42)
            r30 = 0
            java.lang.String r20 = "click"
            java.lang.String r21 = "goods_card"
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.uploadPageElementUbc$default(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            goto L_0x0260
        L_0x01f0:
            boolean r4 = r2 instanceof com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelItemDownloadBtnClickAction
            if (r4 == 0) goto L_0x023f
            r4 = r2
            com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelItemDownloadBtnClickAction r4 = (com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelItemDownloadBtnClickAction) r4
            com.baidu.searchbox.video.feedflow.detail.appdownload.VideoDownloadClickType r4 = r4.getType()
            int[] r6 = com.baidu.searchbox.video.feedflow.detail.listpanel.statistic.ListPanelStatisticMiddleware.WhenMappings.$EnumSwitchMapping$0
            int r4 = r4.ordinal()
            r4 = r6[r4]
            switch(r4) {
                case 1: goto L_0x0212;
                case 2: goto L_0x020d;
                case 3: goto L_0x0208;
                default: goto L_0x0206;
            }
        L_0x0206:
            r8 = r5
            goto L_0x0215
        L_0x0208:
            java.lang.String r5 = "open"
            r8 = r5
            goto L_0x0215
        L_0x020d:
            java.lang.String r5 = "install"
            r8 = r5
            goto L_0x0215
        L_0x0212:
            java.lang.String r5 = "click"
            r8 = r5
        L_0x0215:
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r6 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            com.baidu.searchbox.feed.detail.frame.State r4 = r32.getState()
            r7 = r4
            com.baidu.searchbox.feed.detail.frame.AbsState r7 = (com.baidu.searchbox.feed.detail.frame.AbsState) r7
            r10 = 0
            r11 = 0
            r12 = 0
            r4 = r2
            com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelItemDownloadBtnClickAction r4 = (com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelItemDownloadBtnClickAction) r4
            com.baidu.searchbox.video.inf.ListPanelItemModel r4 = r4.getModel()
            org.json.JSONObject r13 = r0.getPanelDownloadItemClickSpecialExt(r4)
            r14 = 0
            r15 = 0
            r17 = 440(0x1b8, float:6.17E-43)
            r18 = 0
            java.lang.String r9 = "load_banner"
            java.lang.String r16 = "6664"
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.uploadPageElementUbc$default(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            goto L_0x0260
        L_0x023f:
            boolean r4 = r2 instanceof com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelSubTitleClickAction
            if (r4 == 0) goto L_0x0260
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r5 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            com.baidu.searchbox.feed.detail.frame.State r4 = r32.getState()
            r6 = r4
            com.baidu.searchbox.feed.detail.frame.AbsState r6 = (com.baidu.searchbox.feed.detail.frame.AbsState) r6
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 1016(0x3f8, float:1.424E-42)
            r17 = 0
            java.lang.String r7 = "click"
            java.lang.String r8 = "order"
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.uploadPageElementUbc$default(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
        L_0x0260:
            com.baidu.searchbox.feed.detail.frame.Action r4 = r3.next(r1, r2)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.listpanel.statistic.ListPanelStatisticMiddleware.apply(com.baidu.searchbox.feed.detail.frame.Store, com.baidu.searchbox.feed.detail.frame.Action, com.baidu.searchbox.feed.detail.frame.Next):com.baidu.searchbox.feed.detail.frame.Action");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r0 = (com.baidu.searchbox.video.inf.ListPanelItemModel) kotlin.collections.CollectionsKt.getOrNull((r0 = r0.getList()), 0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlin.Pair<java.lang.String, java.lang.String> getPanelCommonAndDownloadUbc(com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelVisibleChangeAction r4) {
        /*
            r3 = this;
            com.baidu.searchbox.video.inf.ListPanelModel r0 = r4.getModel()
            if (r0 == 0) goto L_0x001a
            java.util.List r0 = r0.getList()
            if (r0 == 0) goto L_0x001a
            r1 = 0
            java.lang.Object r0 = kotlin.collections.CollectionsKt.getOrNull(r0, r1)
            com.baidu.searchbox.video.inf.ListPanelItemModel r0 = (com.baidu.searchbox.video.inf.ListPanelItemModel) r0
            if (r0 == 0) goto L_0x001a
            java.lang.String r0 = r0.getLayout()
            goto L_0x001b
        L_0x001a:
            r0 = 0
        L_0x001b:
            java.lang.String r1 = "download_panel"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x002e
            kotlin.Pair r0 = new kotlin.Pair
            java.lang.String r1 = "load_banner"
            java.lang.String r2 = "6664"
            r0.<init>(r1, r2)
            goto L_0x0037
        L_0x002e:
            kotlin.Pair r0 = new kotlin.Pair
            java.lang.String r1 = "banner"
            java.lang.String r2 = "2736"
            r0.<init>(r1, r2)
        L_0x0037:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.listpanel.statistic.ListPanelStatisticMiddleware.getPanelCommonAndDownloadUbc(com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelVisibleChangeAction):kotlin.Pair");
    }

    private final boolean isPanelCommonAndDownloadType(ListPanelModel model) {
        List<ListPanelItemModel<?>> list;
        ListPanelItemModel $this$isPanelCommonAndDownloadType_u24lambda_u2d0;
        if (model == null || (list = model.getList()) == null || ($this$isPanelCommonAndDownloadType_u24lambda_u2d0 = (ListPanelItemModel) CollectionsKt.getOrNull(list, 0)) == null) {
            return false;
        }
        if (Intrinsics.areEqual((Object) $this$isPanelCommonAndDownloadType_u24lambda_u2d0.getLayout(), (Object) FlowDetailBannerModelKt.LAYOUT_PANEL_COMMON_PANEL) || Intrinsics.areEqual((Object) $this$isPanelCommonAndDownloadType_u24lambda_u2d0.getLayout(), (Object) "download_panel")) {
            return true;
        }
        return false;
    }

    private final boolean isPanelDownloadType(ListPanelModel model) {
        List<ListPanelItemModel<?>> list;
        ListPanelItemModel $this$isPanelDownloadType_u24lambda_u2d1;
        if (model == null || (list = model.getList()) == null || ($this$isPanelDownloadType_u24lambda_u2d1 = (ListPanelItemModel) CollectionsKt.getOrNull(list, 0)) == null) {
            return false;
        }
        return Intrinsics.areEqual((Object) $this$isPanelDownloadType_u24lambda_u2d1.getLayout(), (Object) "download_panel");
    }

    private final JSONObject getPanelShowSpecialExt(ListPanelModel model) {
        List<ListPanelItemModel<?>> $this$forEachIndexed$iv;
        JSONArray jsonArray = new JSONArray();
        if (!(model == null || ($this$forEachIndexed$iv = model.getList()) == null)) {
            int index = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv = index + 1;
                if (index < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Object data = ((ListPanelItemModel) item$iv).getData();
                GoodsModel $this$getPanelShowSpecialExt_u24lambda_u2d3_u24lambda_u2d2 = data instanceof GoodsModel ? (GoodsModel) data : null;
                if (!($this$getPanelShowSpecialExt_u24lambda_u2d3_u24lambda_u2d2 == null || $this$getPanelShowSpecialExt_u24lambda_u2d3_u24lambda_u2d2.getExt() == null)) {
                    JSONObject ext = $this$getPanelShowSpecialExt_u24lambda_u2d3_u24lambda_u2d2.getExt();
                    if (ext != null) {
                        ext.putOpt("pos", Integer.valueOf(index));
                    }
                    jsonArray.put($this$getPanelShowSpecialExt_u24lambda_u2d3_u24lambda_u2d2.getExt());
                }
                index = index$iv;
            }
        }
        if (jsonArray.length() > 0) {
            return new JSONObject().putOpt("card_ext", jsonArray);
        }
        return null;
    }

    private final JSONObject getPanelCommonAndPaShowSpecialExt(ListPanelModel model) {
        List<ListPanelItemModel<?>> $this$forEachIndexed$iv;
        JSONArray jsonArray = new JSONArray();
        if (!(model == null || ($this$forEachIndexed$iv = model.getList()) == null)) {
            int index = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv = index + 1;
                if (index < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Object data = ((ListPanelItemModel) item$iv).getData();
                GoodsCommonBannerModel $this$getPanelCommonAndPaShowSpecialExt_u24lambda_u2d5_u24lambda_u2d4 = data instanceof GoodsCommonBannerModel ? (GoodsCommonBannerModel) data : null;
                if (!($this$getPanelCommonAndPaShowSpecialExt_u24lambda_u2d5_u24lambda_u2d4 == null || $this$getPanelCommonAndPaShowSpecialExt_u24lambda_u2d5_u24lambda_u2d4.getExt() == null)) {
                    JSONObject ext = $this$getPanelCommonAndPaShowSpecialExt_u24lambda_u2d5_u24lambda_u2d4.getExt();
                    if (ext != null) {
                        ext.putOpt("pos", Integer.valueOf(index));
                    }
                    jsonArray.put($this$getPanelCommonAndPaShowSpecialExt_u24lambda_u2d5_u24lambda_u2d4.getExt());
                }
                index = index$iv;
            }
        }
        if (jsonArray.length() > 0) {
            return new JSONObject().putOpt("card_ext", jsonArray);
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: com.baidu.searchbox.video.feedflow.detail.banner.model.BannerGuideBannerModel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void reportPanelShow15396(com.baidu.searchbox.feed.detail.frame.AbsState r23, com.baidu.searchbox.video.inf.ListPanelModel r24) {
        /*
            r22 = this;
            if (r24 == 0) goto L_0x0087
            java.util.List r0 = r24.getList()
            if (r0 == 0) goto L_0x0087
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r1 = 0
            java.util.Iterator r2 = r0.iterator()
        L_0x000f:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0086
            java.lang.Object r3 = r2.next()
            r4 = r3
            com.baidu.searchbox.video.inf.ListPanelItemModel r4 = (com.baidu.searchbox.video.inf.ListPanelItemModel) r4
            r5 = 0
            java.lang.Object r6 = r4.getData()
            boolean r7 = r6 instanceof com.baidu.searchbox.video.feedflow.detail.banner.model.BannerRedPacketModel
            r8 = 0
            if (r7 == 0) goto L_0x0029
            com.baidu.searchbox.video.feedflow.detail.banner.model.BannerRedPacketModel r6 = (com.baidu.searchbox.video.feedflow.detail.banner.model.BannerRedPacketModel) r6
            goto L_0x002a
        L_0x0029:
            r6 = r8
        L_0x002a:
            if (r6 == 0) goto L_0x0058
            r7 = 0
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r9 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r10 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            java.lang.String r11 = r6.getExt()
            java.lang.String r12 = "card_ext"
            org.json.JSONObject r16 = r10.generateSpecialExt(r12, r11)
            r13 = 0
            r14 = 0
            r15 = 0
            r17 = 0
            r18 = 0
            r20 = 440(0x1b8, float:6.17E-43)
            r21 = 0
            java.lang.String r11 = "show"
            java.lang.String r12 = "red_envelope_card"
            java.lang.String r19 = "15396"
            r10 = r23
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.uploadPageElementUbc$default(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
        L_0x0058:
            java.lang.Object r6 = r4.getData()
            boolean r7 = r6 instanceof com.baidu.searchbox.video.feedflow.detail.banner.model.BannerGuideBannerModel
            if (r7 == 0) goto L_0x0063
            r8 = r6
            com.baidu.searchbox.video.feedflow.detail.banner.model.BannerGuideBannerModel r8 = (com.baidu.searchbox.video.feedflow.detail.banner.model.BannerGuideBannerModel) r8
        L_0x0063:
            if (r8 == 0) goto L_0x0084
            r6 = r8
            r7 = 0
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r8 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r19 = 504(0x1f8, float:7.06E-43)
            r20 = 0
            java.lang.String r10 = "show"
            java.lang.String r11 = "activity_banner"
            java.lang.String r18 = "15396"
            r9 = r23
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.uploadPageElementUbc$default(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
        L_0x0084:
            goto L_0x000f
        L_0x0086:
        L_0x0087:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.listpanel.statistic.ListPanelStatisticMiddleware.reportPanelShow15396(com.baidu.searchbox.feed.detail.frame.AbsState, com.baidu.searchbox.video.inf.ListPanelModel):void");
    }

    private final JSONObject getPanelClickSpecialExt(ListPanelItemModel<?> model) {
        JSONObject extLog;
        int position;
        int number;
        Object data = model.getData();
        GoodsModel goodsModel = data instanceof GoodsModel ? (GoodsModel) data : null;
        if (goodsModel == null || (extLog = goodsModel.getExt()) == null) {
            return null;
        }
        if (goodsModel.isRec()) {
            position = model.getPosition() - 1;
        } else {
            position = model.getPosition();
        }
        extLog.putOpt("pos", Integer.valueOf(position));
        try {
            List<GoodsRollBarModel> $this$filter$iv = goodsModel.getGoodsRollBar();
            if ($this$filter$iv != null) {
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filter$iv) {
                    if (((GoodsRollBarModel) element$iv$iv).isShown()) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
                number = ((List) destination$iv$iv).size();
            } else {
                number = 0;
            }
            extLog.put("running_light_users_number", number);
        } catch (Exception e2) {
        }
        return new JSONObject().putOpt("card_ext", extLog);
    }

    private final JSONObject getPanelDownloadItemClickSpecialExt(ListPanelItemModel<?> model) {
        Object obj;
        JSONObject jSONObject;
        JSONObject extLog;
        JSONObject jSONObject2 = null;
        try {
            Result.Companion companion = Result.Companion;
            ListPanelStatisticMiddleware listPanelStatisticMiddleware = this;
            Object data = model.getData();
            GoodsCommonBannerModel goodsCommonBannerModel = data instanceof GoodsCommonBannerModel ? (GoodsCommonBannerModel) data : null;
            if (goodsCommonBannerModel == null || (extLog = goodsCommonBannerModel.getExt()) == null) {
                jSONObject = null;
            } else {
                jSONObject = extLog.putOpt("bannerOrder", Integer.valueOf(model.getPosition()));
            }
            obj = Result.m8971constructorimpl(jSONObject);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        if (!Result.m8977isFailureimpl(obj)) {
            jSONObject2 = obj;
        }
        return jSONObject2;
    }
}
