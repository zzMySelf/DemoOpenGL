package com.baidu.searchbox.video.feedflow.detail.recommend;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.file.watcher.base.FileWatcher;
import com.baidu.searchbox.flowvideo.detail.repos.RelateModel;
import com.baidu.searchbox.video.feedflow.detail.recommend.ShowPanelReason;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.swan.apps.statistic.SwanAppUBCStatistic;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B±\u0001\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0003\u0012\u001a\b\u0002\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0018\u00010\u000b0\u0003\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0014J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0004HÆ\u0003J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010.\u001a\u00020\u0004HÆ\u0003J\u0011\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0003HÆ\u0003J\u001b\u00100\u001a\u0014\u0012\u0010\u0012\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0018\u00010\u000b0\u0003HÆ\u0003J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0004HÆ\u0003J\t\u00103\u001a\u00020\u0004HÆ\u0003J\t\u00104\u001a\u00020\u0004HÆ\u0003Jµ\u0001\u00105\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00032\u001a\b\u0002\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0018\u00010\u000b0\u00032\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00042\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00042\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u00106\u001a\u00020\u00042\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u000209HÖ\u0001J\u0006\u0010:\u001a\u00020;J\t\u0010<\u001a\u00020=HÖ\u0001R#\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0018\u00010\u000b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0010\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0016R\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u000e\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\u001a\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0018\"\u0004\b\u001f\u0010\u001aR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0016R\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010(¨\u0006>"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/recommend/RelatedRecommendState;", "", "showPanel", "Landroidx/lifecycle/MutableLiveData;", "", "showPanelReason", "Lcom/baidu/searchbox/video/feedflow/detail/recommend/ShowPanelReason;", "isPanelShowing", "relateInfo", "Lcom/baidu/searchbox/flowvideo/detail/repos/RelateModel;", "dataList", "", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "isShowEntry", "isHoldEntry", "hideByDragSeekBar", "hideByClearScreen", "tempHidePanel", "isEntryEnable", "isEnable", "(Landroidx/lifecycle/MutableLiveData;Lcom/baidu/searchbox/video/feedflow/detail/recommend/ShowPanelReason;ZLandroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;ZZZLandroidx/lifecycle/MutableLiveData;ZLandroidx/lifecycle/MutableLiveData;)V", "getDataList", "()Landroidx/lifecycle/MutableLiveData;", "getHideByClearScreen", "()Z", "setHideByClearScreen", "(Z)V", "getHideByDragSeekBar", "setHideByDragSeekBar", "setEntryEnable", "setHoldEntry", "setPanelShowing", "getRelateInfo", "getShowPanel", "getShowPanelReason", "()Lcom/baidu/searchbox/video/feedflow/detail/recommend/ShowPanelReason;", "setShowPanelReason", "(Lcom/baidu/searchbox/video/feedflow/detail/recommend/ShowPanelReason;)V", "getTempHidePanel", "setTempHidePanel", "(Landroidx/lifecycle/MutableLiveData;)V", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "reset", "", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RelatedRecommendState.kt */
public final class RelatedRecommendState {
    private final MutableLiveData<List<ItemModel<?>>> dataList;
    private boolean hideByClearScreen;
    private boolean hideByDragSeekBar;
    private final MutableLiveData<Boolean> isEnable;
    private boolean isEntryEnable;
    private boolean isHoldEntry;
    private boolean isPanelShowing;
    private final MutableLiveData<Boolean> isShowEntry;
    private final MutableLiveData<RelateModel> relateInfo;
    private final MutableLiveData<Boolean> showPanel;
    private ShowPanelReason showPanelReason;
    private MutableLiveData<Boolean> tempHidePanel;

    public RelatedRecommendState() {
        this((MutableLiveData) null, (ShowPanelReason) null, false, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, false, false, false, (MutableLiveData) null, false, (MutableLiveData) null, FileWatcher.ALL_EVENTS, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RelatedRecommendState copy$default(RelatedRecommendState relatedRecommendState, MutableLiveData mutableLiveData, ShowPanelReason showPanelReason2, boolean z, MutableLiveData mutableLiveData2, MutableLiveData mutableLiveData3, MutableLiveData mutableLiveData4, boolean z2, boolean z3, boolean z4, MutableLiveData mutableLiveData5, boolean z5, MutableLiveData mutableLiveData6, int i2, Object obj) {
        RelatedRecommendState relatedRecommendState2 = relatedRecommendState;
        int i3 = i2;
        return relatedRecommendState.copy((i3 & 1) != 0 ? relatedRecommendState2.showPanel : mutableLiveData, (i3 & 2) != 0 ? relatedRecommendState2.showPanelReason : showPanelReason2, (i3 & 4) != 0 ? relatedRecommendState2.isPanelShowing : z, (i3 & 8) != 0 ? relatedRecommendState2.relateInfo : mutableLiveData2, (i3 & 16) != 0 ? relatedRecommendState2.dataList : mutableLiveData3, (i3 & 32) != 0 ? relatedRecommendState2.isShowEntry : mutableLiveData4, (i3 & 64) != 0 ? relatedRecommendState2.isHoldEntry : z2, (i3 & 128) != 0 ? relatedRecommendState2.hideByDragSeekBar : z3, (i3 & 256) != 0 ? relatedRecommendState2.hideByClearScreen : z4, (i3 & 512) != 0 ? relatedRecommendState2.tempHidePanel : mutableLiveData5, (i3 & 1024) != 0 ? relatedRecommendState2.isEntryEnable : z5, (i3 & 2048) != 0 ? relatedRecommendState2.isEnable : mutableLiveData6);
    }

    public final MutableLiveData<Boolean> component1() {
        return this.showPanel;
    }

    public final MutableLiveData<Boolean> component10() {
        return this.tempHidePanel;
    }

    public final boolean component11() {
        return this.isEntryEnable;
    }

    public final MutableLiveData<Boolean> component12() {
        return this.isEnable;
    }

    public final ShowPanelReason component2() {
        return this.showPanelReason;
    }

    public final boolean component3() {
        return this.isPanelShowing;
    }

    public final MutableLiveData<RelateModel> component4() {
        return this.relateInfo;
    }

    public final MutableLiveData<List<ItemModel<?>>> component5() {
        return this.dataList;
    }

    public final MutableLiveData<Boolean> component6() {
        return this.isShowEntry;
    }

    public final boolean component7() {
        return this.isHoldEntry;
    }

    public final boolean component8() {
        return this.hideByDragSeekBar;
    }

    public final boolean component9() {
        return this.hideByClearScreen;
    }

    public final RelatedRecommendState copy(MutableLiveData<Boolean> mutableLiveData, ShowPanelReason showPanelReason2, boolean z, MutableLiveData<RelateModel> mutableLiveData2, MutableLiveData<List<ItemModel<?>>> mutableLiveData3, MutableLiveData<Boolean> mutableLiveData4, boolean z2, boolean z3, boolean z4, MutableLiveData<Boolean> mutableLiveData5, boolean z5, MutableLiveData<Boolean> mutableLiveData6) {
        Intrinsics.checkNotNullParameter(mutableLiveData, SwanAppUBCStatistic.PAYMENT_PROCESS_SHOW_PANEL);
        Intrinsics.checkNotNullParameter(mutableLiveData2, "relateInfo");
        Intrinsics.checkNotNullParameter(mutableLiveData3, "dataList");
        Intrinsics.checkNotNullParameter(mutableLiveData4, "isShowEntry");
        MutableLiveData<Boolean> mutableLiveData7 = mutableLiveData5;
        Intrinsics.checkNotNullParameter(mutableLiveData7, "tempHidePanel");
        Intrinsics.checkNotNullParameter(mutableLiveData6, "isEnable");
        return new RelatedRecommendState(mutableLiveData, showPanelReason2, z, mutableLiveData2, mutableLiveData3, mutableLiveData4, z2, z3, z4, mutableLiveData7, z5, mutableLiveData6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RelatedRecommendState)) {
            return false;
        }
        RelatedRecommendState relatedRecommendState = (RelatedRecommendState) obj;
        return Intrinsics.areEqual((Object) this.showPanel, (Object) relatedRecommendState.showPanel) && Intrinsics.areEqual((Object) this.showPanelReason, (Object) relatedRecommendState.showPanelReason) && this.isPanelShowing == relatedRecommendState.isPanelShowing && Intrinsics.areEqual((Object) this.relateInfo, (Object) relatedRecommendState.relateInfo) && Intrinsics.areEqual((Object) this.dataList, (Object) relatedRecommendState.dataList) && Intrinsics.areEqual((Object) this.isShowEntry, (Object) relatedRecommendState.isShowEntry) && this.isHoldEntry == relatedRecommendState.isHoldEntry && this.hideByDragSeekBar == relatedRecommendState.hideByDragSeekBar && this.hideByClearScreen == relatedRecommendState.hideByClearScreen && Intrinsics.areEqual((Object) this.tempHidePanel, (Object) relatedRecommendState.tempHidePanel) && this.isEntryEnable == relatedRecommendState.isEntryEnable && Intrinsics.areEqual((Object) this.isEnable, (Object) relatedRecommendState.isEnable);
    }

    public int hashCode() {
        int hashCode = this.showPanel.hashCode() * 31;
        ShowPanelReason showPanelReason2 = this.showPanelReason;
        int hashCode2 = (hashCode + (showPanelReason2 == null ? 0 : showPanelReason2.hashCode())) * 31;
        boolean z = this.isPanelShowing;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int hashCode3 = (((((((hashCode2 + (z ? 1 : 0)) * 31) + this.relateInfo.hashCode()) * 31) + this.dataList.hashCode()) * 31) + this.isShowEntry.hashCode()) * 31;
        boolean z3 = this.isHoldEntry;
        if (z3) {
            z3 = true;
        }
        int i2 = (hashCode3 + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.hideByDragSeekBar;
        if (z4) {
            z4 = true;
        }
        int i3 = (i2 + (z4 ? 1 : 0)) * 31;
        boolean z5 = this.hideByClearScreen;
        if (z5) {
            z5 = true;
        }
        int hashCode4 = (((i3 + (z5 ? 1 : 0)) * 31) + this.tempHidePanel.hashCode()) * 31;
        boolean z6 = this.isEntryEnable;
        if (!z6) {
            z2 = z6;
        }
        return ((hashCode4 + (z2 ? 1 : 0)) * 31) + this.isEnable.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RelatedRecommendState(showPanel=").append(this.showPanel).append(", showPanelReason=").append(this.showPanelReason).append(", isPanelShowing=").append(this.isPanelShowing).append(", relateInfo=").append(this.relateInfo).append(", dataList=").append(this.dataList).append(", isShowEntry=").append(this.isShowEntry).append(", isHoldEntry=").append(this.isHoldEntry).append(", hideByDragSeekBar=").append(this.hideByDragSeekBar).append(", hideByClearScreen=").append(this.hideByClearScreen).append(", tempHidePanel=").append(this.tempHidePanel).append(", isEntryEnable=").append(this.isEntryEnable).append(", isEnable=");
        sb.append(this.isEnable).append(')');
        return sb.toString();
    }

    public RelatedRecommendState(MutableLiveData<Boolean> showPanel2, ShowPanelReason showPanelReason2, boolean isPanelShowing2, MutableLiveData<RelateModel> relateInfo2, MutableLiveData<List<ItemModel<?>>> dataList2, MutableLiveData<Boolean> isShowEntry2, boolean isHoldEntry2, boolean hideByDragSeekBar2, boolean hideByClearScreen2, MutableLiveData<Boolean> tempHidePanel2, boolean isEntryEnable2, MutableLiveData<Boolean> isEnable2) {
        Intrinsics.checkNotNullParameter(showPanel2, SwanAppUBCStatistic.PAYMENT_PROCESS_SHOW_PANEL);
        Intrinsics.checkNotNullParameter(relateInfo2, "relateInfo");
        Intrinsics.checkNotNullParameter(dataList2, "dataList");
        Intrinsics.checkNotNullParameter(isShowEntry2, "isShowEntry");
        Intrinsics.checkNotNullParameter(tempHidePanel2, "tempHidePanel");
        Intrinsics.checkNotNullParameter(isEnable2, "isEnable");
        this.showPanel = showPanel2;
        this.showPanelReason = showPanelReason2;
        this.isPanelShowing = isPanelShowing2;
        this.relateInfo = relateInfo2;
        this.dataList = dataList2;
        this.isShowEntry = isShowEntry2;
        this.isHoldEntry = isHoldEntry2;
        this.hideByDragSeekBar = hideByDragSeekBar2;
        this.hideByClearScreen = hideByClearScreen2;
        this.tempHidePanel = tempHidePanel2;
        this.isEntryEnable = isEntryEnable2;
        this.isEnable = isEnable2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RelatedRecommendState(androidx.lifecycle.MutableLiveData r14, com.baidu.searchbox.video.feedflow.detail.recommend.ShowPanelReason r15, boolean r16, androidx.lifecycle.MutableLiveData r17, androidx.lifecycle.MutableLiveData r18, androidx.lifecycle.MutableLiveData r19, boolean r20, boolean r21, boolean r22, androidx.lifecycle.MutableLiveData r23, boolean r24, androidx.lifecycle.MutableLiveData r25, int r26, kotlin.jvm.internal.DefaultConstructorMarker r27) {
        /*
            r13 = this;
            r0 = r26
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000c
            androidx.lifecycle.MutableLiveData r1 = new androidx.lifecycle.MutableLiveData
            r1.<init>()
            goto L_0x000d
        L_0x000c:
            r1 = r14
        L_0x000d:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0016
            com.baidu.searchbox.video.feedflow.detail.recommend.ShowPanelReason$def r2 = com.baidu.searchbox.video.feedflow.detail.recommend.ShowPanelReason.def.INSTANCE
            com.baidu.searchbox.video.feedflow.detail.recommend.ShowPanelReason r2 = (com.baidu.searchbox.video.feedflow.detail.recommend.ShowPanelReason) r2
            goto L_0x0017
        L_0x0016:
            r2 = r15
        L_0x0017:
            r3 = r0 & 4
            r4 = 0
            if (r3 == 0) goto L_0x001e
            r3 = r4
            goto L_0x0020
        L_0x001e:
            r3 = r16
        L_0x0020:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x002a
            androidx.lifecycle.MutableLiveData r5 = new androidx.lifecycle.MutableLiveData
            r5.<init>()
            goto L_0x002c
        L_0x002a:
            r5 = r17
        L_0x002c:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0036
            androidx.lifecycle.MutableLiveData r6 = new androidx.lifecycle.MutableLiveData
            r6.<init>()
            goto L_0x0038
        L_0x0036:
            r6 = r18
        L_0x0038:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0042
            androidx.lifecycle.MutableLiveData r7 = new androidx.lifecycle.MutableLiveData
            r7.<init>()
            goto L_0x0044
        L_0x0042:
            r7 = r19
        L_0x0044:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x004a
            r8 = r4
            goto L_0x004c
        L_0x004a:
            r8 = r20
        L_0x004c:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0052
            r9 = r4
            goto L_0x0054
        L_0x0052:
            r9 = r21
        L_0x0054:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x005a
            r10 = r4
            goto L_0x005c
        L_0x005a:
            r10 = r22
        L_0x005c:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0066
            androidx.lifecycle.MutableLiveData r11 = new androidx.lifecycle.MutableLiveData
            r11.<init>()
            goto L_0x0068
        L_0x0066:
            r11 = r23
        L_0x0068:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x006d
            goto L_0x006f
        L_0x006d:
            r4 = r24
        L_0x006f:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0079
            androidx.lifecycle.MutableLiveData r0 = new androidx.lifecycle.MutableLiveData
            r0.<init>()
            goto L_0x007b
        L_0x0079:
            r0 = r25
        L_0x007b:
            r14 = r1
            r15 = r2
            r16 = r3
            r17 = r5
            r18 = r6
            r19 = r7
            r20 = r8
            r21 = r9
            r22 = r10
            r23 = r11
            r24 = r4
            r25 = r0
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.recommend.RelatedRecommendState.<init>(androidx.lifecycle.MutableLiveData, com.baidu.searchbox.video.feedflow.detail.recommend.ShowPanelReason, boolean, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, boolean, boolean, boolean, androidx.lifecycle.MutableLiveData, boolean, androidx.lifecycle.MutableLiveData, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final MutableLiveData<Boolean> getShowPanel() {
        return this.showPanel;
    }

    public final ShowPanelReason getShowPanelReason() {
        return this.showPanelReason;
    }

    public final void setShowPanelReason(ShowPanelReason showPanelReason2) {
        this.showPanelReason = showPanelReason2;
    }

    public final boolean isPanelShowing() {
        return this.isPanelShowing;
    }

    public final void setPanelShowing(boolean z) {
        this.isPanelShowing = z;
    }

    public final MutableLiveData<RelateModel> getRelateInfo() {
        return this.relateInfo;
    }

    public final MutableLiveData<List<ItemModel<?>>> getDataList() {
        return this.dataList;
    }

    public final MutableLiveData<Boolean> isShowEntry() {
        return this.isShowEntry;
    }

    public final boolean isHoldEntry() {
        return this.isHoldEntry;
    }

    public final void setHoldEntry(boolean z) {
        this.isHoldEntry = z;
    }

    public final boolean getHideByDragSeekBar() {
        return this.hideByDragSeekBar;
    }

    public final void setHideByDragSeekBar(boolean z) {
        this.hideByDragSeekBar = z;
    }

    public final boolean getHideByClearScreen() {
        return this.hideByClearScreen;
    }

    public final void setHideByClearScreen(boolean z) {
        this.hideByClearScreen = z;
    }

    public final MutableLiveData<Boolean> getTempHidePanel() {
        return this.tempHidePanel;
    }

    public final void setTempHidePanel(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.tempHidePanel = mutableLiveData;
    }

    public final boolean isEntryEnable() {
        return this.isEntryEnable;
    }

    public final void setEntryEnable(boolean z) {
        this.isEntryEnable = z;
    }

    public final MutableLiveData<Boolean> isEnable() {
        return this.isEnable;
    }

    public final void reset() {
        this.showPanelReason = ShowPanelReason.def.INSTANCE;
        this.isPanelShowing = false;
        this.isHoldEntry = false;
        this.hideByDragSeekBar = false;
        this.hideByClearScreen = false;
        this.isEntryEnable = false;
    }
}
