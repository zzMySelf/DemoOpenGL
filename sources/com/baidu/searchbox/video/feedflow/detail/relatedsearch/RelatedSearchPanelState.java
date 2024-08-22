package com.baidu.searchbox.video.feedflow.detail.relatedsearch;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.player.widget.PanelDragStatus;
import com.baidu.searchbox.video.feedflow.detail.relatedsearch.model.RelatedSearchPanelModel;
import com.baidu.swan.apps.statistic.SwanAppUBCStatistic;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\bJ\u0018\u00002\u00020\u0001BÛ\u0001\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0014\u0012\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00190\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u0012\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003¢\u0006\u0002\u0010\u001cJ\u0006\u0010[\u001a\u00020\bJ\u0006\u0010\\\u001a\u00020\bJ\u0006\u0010]\u001a\u00020\bJ\u0006\u0010^\u001a\u00020\rJ\u0006\u0010_\u001a\u00020\rJ\u0018\u0010`\u001a\u00020\r2\u0006\u0010a\u001a\u00020\u00062\b\b\u0002\u0010b\u001a\u00020\bR\u001a\u0010\u001d\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\u001a\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010$\"\u0004\b,\u0010&R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u001a\u0010\n\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u0010\u000f\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00100\"\u0004\b4\u00102R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u00100\"\u0004\b5\u00102R\u001a\u0010\u000e\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u00100\"\u0004\b6\u00102R\u001a\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u00100\"\u0004\b7\u00102R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010.R\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010.R\u001a\u00109\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001f\"\u0004\b;\u0010!R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010=\"\u0004\bA\u0010?R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u001f\"\u0004\bC\u0010!R\u001a\u0010D\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010$\"\u0004\bF\u0010&R\u001a\u0010\u0016\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010=\"\u0004\bH\u0010?R&\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00190\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001a\u0010M\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010$\"\u0004\bO\u0010&R\u001a\u0010P\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010$\"\u0004\bR\u0010&R\u001a\u0010S\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u001f\"\u0004\bU\u0010!R\u001a\u0010V\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010$\"\u0004\bX\u0010&R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0003¢\u0006\b\n\u0000\u001a\u0004\bY\u0010.R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010.¨\u0006c"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/relatedsearch/RelatedSearchPanelState;", "", "model", "Landroidx/lifecycle/MutableLiveData;", "Lcom/baidu/searchbox/video/feedflow/detail/relatedsearch/model/RelatedSearchPanelModel;", "showPanel", "Lcom/baidu/searchbox/player/widget/PanelDragStatus;", "isAlphaAnimWithShow", "", "currPanelStatus", "hasReportBottomGuide", "isPanelDragging", "showCountDownGuide", "", "isCountDownGuideShow", "hasRetractPanelShow", "isShowBackView", "panelLoadStatus", "", "panelDataLoadBegin", "", "panelDataLoadEnd", "panelShowAnimDur", "panelShowTimesMap", "", "", "currentPanelPreRequest", "extQuery", "(Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;ZLcom/baidu/searchbox/player/widget/PanelDragStatus;ZZLandroidx/lifecycle/MutableLiveData;ZZLandroidx/lifecycle/MutableLiveData;Ljava/lang/String;JJJLjava/util/Map;ILandroidx/lifecycle/MutableLiveData;)V", "changeQuery", "getChangeQuery", "()Ljava/lang/String;", "setChangeQuery", "(Ljava/lang/String;)V", "changeQueryPosition", "getChangeQueryPosition", "()I", "setChangeQueryPosition", "(I)V", "getCurrPanelStatus", "()Lcom/baidu/searchbox/player/widget/PanelDragStatus;", "setCurrPanelStatus", "(Lcom/baidu/searchbox/player/widget/PanelDragStatus;)V", "getCurrentPanelPreRequest", "setCurrentPanelPreRequest", "getExtQuery", "()Landroidx/lifecycle/MutableLiveData;", "getHasReportBottomGuide", "()Z", "setHasReportBottomGuide", "(Z)V", "getHasRetractPanelShow", "setHasRetractPanelShow", "setAlphaAnimWithShow", "setCountDownGuideShow", "setPanelDragging", "getModel", "panelDadaType", "getPanelDadaType", "setPanelDadaType", "getPanelDataLoadBegin", "()J", "setPanelDataLoadBegin", "(J)V", "getPanelDataLoadEnd", "setPanelDataLoadEnd", "getPanelLoadStatus", "setPanelLoadStatus", "panelRequestNewData", "getPanelRequestNewData", "setPanelRequestNewData", "getPanelShowAnimDur", "setPanelShowAnimDur", "getPanelShowTimesMap", "()Ljava/util/Map;", "setPanelShowTimesMap", "(Ljava/util/Map;)V", "panelStyle", "getPanelStyle", "setPanelStyle", "reenterAutoShow", "getReenterAutoShow", "setReenterAutoShow", "relatedPanelShowTime", "getRelatedPanelShowTime", "setRelatedPanelShowTime", "scrollBackSwitch", "getScrollBackSwitch", "setScrollBackSwitch", "getShowCountDownGuide", "getShowPanel", "isCanWeakAlpha", "isCanWeakAlphaOpt", "isShowPanel", "reset", "resetPanelStatisticData", "toShowPanel", "newPanelStatus", "isAlphaAnim", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RelatedSearchPanelState.kt */
public final class RelatedSearchPanelState {
    private String changeQuery;
    private int changeQueryPosition;
    private PanelDragStatus currPanelStatus;
    private int currentPanelPreRequest;
    private final MutableLiveData<String> extQuery;
    private boolean hasReportBottomGuide;
    private boolean hasRetractPanelShow;
    private boolean isAlphaAnimWithShow;
    private boolean isCountDownGuideShow;
    private boolean isPanelDragging;
    private final MutableLiveData<Boolean> isShowBackView;
    private final MutableLiveData<RelatedSearchPanelModel> model;
    private String panelDadaType;
    private long panelDataLoadBegin;
    private long panelDataLoadEnd;
    private String panelLoadStatus;
    private int panelRequestNewData;
    private long panelShowAnimDur;
    private Map<String, Integer> panelShowTimesMap;
    private int panelStyle;
    private int reenterAutoShow;
    private String relatedPanelShowTime;
    private int scrollBackSwitch;
    private final MutableLiveData<Unit> showCountDownGuide;
    private final MutableLiveData<PanelDragStatus> showPanel;

    public RelatedSearchPanelState() {
        this((MutableLiveData) null, (MutableLiveData) null, false, (PanelDragStatus) null, false, false, (MutableLiveData) null, false, false, (MutableLiveData) null, (String) null, 0, 0, 0, (Map) null, 0, (MutableLiveData) null, 131071, (DefaultConstructorMarker) null);
    }

    public RelatedSearchPanelState(MutableLiveData<RelatedSearchPanelModel> model2, MutableLiveData<PanelDragStatus> showPanel2, boolean isAlphaAnimWithShow2, PanelDragStatus currPanelStatus2, boolean hasReportBottomGuide2, boolean isPanelDragging2, MutableLiveData<Unit> showCountDownGuide2, boolean isCountDownGuideShow2, boolean hasRetractPanelShow2, MutableLiveData<Boolean> isShowBackView2, String panelLoadStatus2, long panelDataLoadBegin2, long panelDataLoadEnd2, long panelShowAnimDur2, Map<String, Integer> panelShowTimesMap2, int currentPanelPreRequest2, MutableLiveData<String> extQuery2) {
        MutableLiveData<RelatedSearchPanelModel> mutableLiveData = model2;
        MutableLiveData<PanelDragStatus> mutableLiveData2 = showPanel2;
        PanelDragStatus panelDragStatus = currPanelStatus2;
        MutableLiveData<Unit> mutableLiveData3 = showCountDownGuide2;
        MutableLiveData<Boolean> mutableLiveData4 = isShowBackView2;
        String str = panelLoadStatus2;
        Map<String, Integer> map = panelShowTimesMap2;
        MutableLiveData<String> mutableLiveData5 = extQuery2;
        Intrinsics.checkNotNullParameter(mutableLiveData, "model");
        Intrinsics.checkNotNullParameter(mutableLiveData2, SwanAppUBCStatistic.PAYMENT_PROCESS_SHOW_PANEL);
        Intrinsics.checkNotNullParameter(panelDragStatus, "currPanelStatus");
        Intrinsics.checkNotNullParameter(mutableLiveData3, "showCountDownGuide");
        Intrinsics.checkNotNullParameter(mutableLiveData4, "isShowBackView");
        Intrinsics.checkNotNullParameter(str, "panelLoadStatus");
        Intrinsics.checkNotNullParameter(map, "panelShowTimesMap");
        Intrinsics.checkNotNullParameter(mutableLiveData5, "extQuery");
        this.model = mutableLiveData;
        this.showPanel = mutableLiveData2;
        this.isAlphaAnimWithShow = isAlphaAnimWithShow2;
        this.currPanelStatus = panelDragStatus;
        this.hasReportBottomGuide = hasReportBottomGuide2;
        this.isPanelDragging = isPanelDragging2;
        this.showCountDownGuide = mutableLiveData3;
        this.isCountDownGuideShow = isCountDownGuideShow2;
        this.hasRetractPanelShow = hasRetractPanelShow2;
        this.isShowBackView = mutableLiveData4;
        this.panelLoadStatus = str;
        this.panelDataLoadBegin = panelDataLoadBegin2;
        this.panelDataLoadEnd = panelDataLoadEnd2;
        this.panelShowAnimDur = panelShowAnimDur2;
        this.panelShowTimesMap = map;
        this.currentPanelPreRequest = currentPanelPreRequest2;
        this.extQuery = mutableLiveData5;
        this.panelDadaType = "";
        this.changeQuery = "";
        this.relatedPanelShowTime = "";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RelatedSearchPanelState(androidx.lifecycle.MutableLiveData r22, androidx.lifecycle.MutableLiveData r23, boolean r24, com.baidu.searchbox.player.widget.PanelDragStatus r25, boolean r26, boolean r27, androidx.lifecycle.MutableLiveData r28, boolean r29, boolean r30, androidx.lifecycle.MutableLiveData r31, java.lang.String r32, long r33, long r35, long r37, java.util.Map r39, int r40, androidx.lifecycle.MutableLiveData r41, int r42, kotlin.jvm.internal.DefaultConstructorMarker r43) {
        /*
            r21 = this;
            r0 = r42
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000c
            androidx.lifecycle.MutableLiveData r1 = new androidx.lifecycle.MutableLiveData
            r1.<init>()
            goto L_0x000e
        L_0x000c:
            r1 = r22
        L_0x000e:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0018
            androidx.lifecycle.MutableLiveData r2 = new androidx.lifecycle.MutableLiveData
            r2.<init>()
            goto L_0x001a
        L_0x0018:
            r2 = r23
        L_0x001a:
            r3 = r0 & 4
            r4 = 0
            if (r3 == 0) goto L_0x0021
            r3 = r4
            goto L_0x0023
        L_0x0021:
            r3 = r24
        L_0x0023:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x002c
            com.baidu.searchbox.player.widget.PanelDragStatus$NONE r5 = com.baidu.searchbox.player.widget.PanelDragStatus.NONE.INSTANCE
            com.baidu.searchbox.player.widget.PanelDragStatus r5 = (com.baidu.searchbox.player.widget.PanelDragStatus) r5
            goto L_0x002e
        L_0x002c:
            r5 = r25
        L_0x002e:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0034
            r6 = r4
            goto L_0x0036
        L_0x0034:
            r6 = r26
        L_0x0036:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x003c
            r7 = r4
            goto L_0x003e
        L_0x003c:
            r7 = r27
        L_0x003e:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0048
            androidx.lifecycle.MutableLiveData r8 = new androidx.lifecycle.MutableLiveData
            r8.<init>()
            goto L_0x004a
        L_0x0048:
            r8 = r28
        L_0x004a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0050
            r9 = r4
            goto L_0x0052
        L_0x0050:
            r9 = r29
        L_0x0052:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0058
            r10 = r4
            goto L_0x005a
        L_0x0058:
            r10 = r30
        L_0x005a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0064
            androidx.lifecycle.MutableLiveData r11 = new androidx.lifecycle.MutableLiveData
            r11.<init>()
            goto L_0x0066
        L_0x0064:
            r11 = r31
        L_0x0066:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x006d
            java.lang.String r12 = ""
            goto L_0x006f
        L_0x006d:
            r12 = r32
        L_0x006f:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            r14 = 0
            if (r13 == 0) goto L_0x0078
            r16 = r14
            goto L_0x007a
        L_0x0078:
            r16 = r33
        L_0x007a:
            r13 = r0 & 4096(0x1000, float:5.74E-42)
            if (r13 == 0) goto L_0x0081
            r18 = r14
            goto L_0x0083
        L_0x0081:
            r18 = r35
        L_0x0083:
            r13 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r13 == 0) goto L_0x0088
            goto L_0x008a
        L_0x0088:
            r14 = r37
        L_0x008a:
            r13 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r13 == 0) goto L_0x0096
            java.util.LinkedHashMap r13 = new java.util.LinkedHashMap
            r13.<init>()
            java.util.Map r13 = (java.util.Map) r13
            goto L_0x0098
        L_0x0096:
            r13 = r39
        L_0x0098:
            r20 = 32768(0x8000, float:4.5918E-41)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00a0
            goto L_0x00a2
        L_0x00a0:
            r4 = r40
        L_0x00a2:
            r20 = 65536(0x10000, float:9.18355E-41)
            r0 = r0 & r20
            if (r0 == 0) goto L_0x00ae
            androidx.lifecycle.MutableLiveData r0 = new androidx.lifecycle.MutableLiveData
            r0.<init>()
            goto L_0x00b0
        L_0x00ae:
            r0 = r41
        L_0x00b0:
            r22 = r1
            r23 = r2
            r24 = r3
            r25 = r5
            r26 = r6
            r27 = r7
            r28 = r8
            r29 = r9
            r30 = r10
            r31 = r11
            r32 = r12
            r33 = r16
            r35 = r18
            r37 = r14
            r39 = r13
            r40 = r4
            r41 = r0
            r21.<init>(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r35, r37, r39, r40, r41)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.relatedsearch.RelatedSearchPanelState.<init>(androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, boolean, com.baidu.searchbox.player.widget.PanelDragStatus, boolean, boolean, androidx.lifecycle.MutableLiveData, boolean, boolean, androidx.lifecycle.MutableLiveData, java.lang.String, long, long, long, java.util.Map, int, androidx.lifecycle.MutableLiveData, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final MutableLiveData<RelatedSearchPanelModel> getModel() {
        return this.model;
    }

    public final MutableLiveData<PanelDragStatus> getShowPanel() {
        return this.showPanel;
    }

    public final boolean isAlphaAnimWithShow() {
        return this.isAlphaAnimWithShow;
    }

    public final void setAlphaAnimWithShow(boolean z) {
        this.isAlphaAnimWithShow = z;
    }

    public final PanelDragStatus getCurrPanelStatus() {
        return this.currPanelStatus;
    }

    public final void setCurrPanelStatus(PanelDragStatus panelDragStatus) {
        Intrinsics.checkNotNullParameter(panelDragStatus, "<set-?>");
        this.currPanelStatus = panelDragStatus;
    }

    public final boolean getHasReportBottomGuide() {
        return this.hasReportBottomGuide;
    }

    public final void setHasReportBottomGuide(boolean z) {
        this.hasReportBottomGuide = z;
    }

    public final boolean isPanelDragging() {
        return this.isPanelDragging;
    }

    public final void setPanelDragging(boolean z) {
        this.isPanelDragging = z;
    }

    public final MutableLiveData<Unit> getShowCountDownGuide() {
        return this.showCountDownGuide;
    }

    public final boolean isCountDownGuideShow() {
        return this.isCountDownGuideShow;
    }

    public final void setCountDownGuideShow(boolean z) {
        this.isCountDownGuideShow = z;
    }

    public final boolean getHasRetractPanelShow() {
        return this.hasRetractPanelShow;
    }

    public final void setHasRetractPanelShow(boolean z) {
        this.hasRetractPanelShow = z;
    }

    public final MutableLiveData<Boolean> isShowBackView() {
        return this.isShowBackView;
    }

    public final String getPanelLoadStatus() {
        return this.panelLoadStatus;
    }

    public final void setPanelLoadStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.panelLoadStatus = str;
    }

    public final long getPanelDataLoadBegin() {
        return this.panelDataLoadBegin;
    }

    public final void setPanelDataLoadBegin(long j2) {
        this.panelDataLoadBegin = j2;
    }

    public final long getPanelDataLoadEnd() {
        return this.panelDataLoadEnd;
    }

    public final void setPanelDataLoadEnd(long j2) {
        this.panelDataLoadEnd = j2;
    }

    public final long getPanelShowAnimDur() {
        return this.panelShowAnimDur;
    }

    public final void setPanelShowAnimDur(long j2) {
        this.panelShowAnimDur = j2;
    }

    public final Map<String, Integer> getPanelShowTimesMap() {
        return this.panelShowTimesMap;
    }

    public final void setPanelShowTimesMap(Map<String, Integer> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.panelShowTimesMap = map;
    }

    public final int getCurrentPanelPreRequest() {
        return this.currentPanelPreRequest;
    }

    public final void setCurrentPanelPreRequest(int i2) {
        this.currentPanelPreRequest = i2;
    }

    public final MutableLiveData<String> getExtQuery() {
        return this.extQuery;
    }

    public final String getPanelDadaType() {
        return this.panelDadaType;
    }

    public final void setPanelDadaType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.panelDadaType = str;
    }

    public final int getReenterAutoShow() {
        return this.reenterAutoShow;
    }

    public final void setReenterAutoShow(int i2) {
        this.reenterAutoShow = i2;
    }

    public final int getPanelStyle() {
        return this.panelStyle;
    }

    public final void setPanelStyle(int i2) {
        this.panelStyle = i2;
    }

    public final int getScrollBackSwitch() {
        return this.scrollBackSwitch;
    }

    public final void setScrollBackSwitch(int i2) {
        this.scrollBackSwitch = i2;
    }

    public final int getPanelRequestNewData() {
        return this.panelRequestNewData;
    }

    public final void setPanelRequestNewData(int i2) {
        this.panelRequestNewData = i2;
    }

    public final String getChangeQuery() {
        return this.changeQuery;
    }

    public final void setChangeQuery(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.changeQuery = str;
    }

    public final int getChangeQueryPosition() {
        return this.changeQueryPosition;
    }

    public final void setChangeQueryPosition(int i2) {
        this.changeQueryPosition = i2;
    }

    public final String getRelatedPanelShowTime() {
        return this.relatedPanelShowTime;
    }

    public final void setRelatedPanelShowTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.relatedPanelShowTime = str;
    }

    public final void reset() {
        this.currPanelStatus = PanelDragStatus.NONE.INSTANCE;
        this.hasReportBottomGuide = false;
        this.isPanelDragging = false;
        this.hasRetractPanelShow = false;
        this.isCountDownGuideShow = false;
        this.changeQuery = "";
        this.changeQueryPosition = 0;
    }

    public final void resetPanelStatisticData() {
        this.panelLoadStatus = "";
        this.panelDataLoadBegin = 0;
        this.panelDataLoadEnd = 0;
        this.panelShowAnimDur = 0;
    }

    public final boolean isShowPanel() {
        return !Intrinsics.areEqual((Object) this.currPanelStatus, (Object) PanelDragStatus.NONE.INSTANCE);
    }

    public static /* synthetic */ void toShowPanel$default(RelatedSearchPanelState relatedSearchPanelState, PanelDragStatus panelDragStatus, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        relatedSearchPanelState.toShowPanel(panelDragStatus, z);
    }

    public final void toShowPanel(PanelDragStatus newPanelStatus, boolean isAlphaAnim) {
        Intrinsics.checkNotNullParameter(newPanelStatus, "newPanelStatus");
        this.isAlphaAnimWithShow = isAlphaAnim;
        this.showPanel.setValue(newPanelStatus);
        this.currPanelStatus = newPanelStatus;
    }

    public final boolean isCanWeakAlpha() {
        return Intrinsics.areEqual((Object) this.currPanelStatus, (Object) PanelDragStatus.UNFOLD.INSTANCE) || Intrinsics.areEqual((Object) this.currPanelStatus, (Object) PanelDragStatus.NONE.INSTANCE);
    }

    public final boolean isCanWeakAlphaOpt() {
        return Intrinsics.areEqual((Object) this.currPanelStatus, (Object) PanelDragStatus.FOLD.INSTANCE);
    }
}
