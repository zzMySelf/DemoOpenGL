package com.baidu.searchbox.mvp.aggcard;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.mvp.entity.CardList;
import com.baidu.searchbox.mvp.entity.MvpRecommendList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001Ba\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00060\u0003\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0003\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003¢\u0006\u0002\u0010\rR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR!\u0010\u0005\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/mvp/aggcard/AggCardState;", "", "recommendListData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/baidu/searchbox/mvp/entity/MvpRecommendList;", "showAggCardView", "", "Lcom/baidu/searchbox/mvp/entity/CardList;", "resumeAggCardView", "", "aggCardViewGone", "clkReportData", "Lcom/baidu/searchbox/mvp/aggcard/ClkReportData;", "(Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;)V", "getAggCardViewGone", "()Landroidx/lifecycle/MutableLiveData;", "getClkReportData", "getRecommendListData", "getResumeAggCardView", "getShowAggCardView", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AggCardState.kt */
public final class AggCardState {
    private final MutableLiveData<Unit> aggCardViewGone;
    private final MutableLiveData<ClkReportData> clkReportData;
    private final MutableLiveData<MvpRecommendList> recommendListData;
    private final MutableLiveData<Unit> resumeAggCardView;
    private final MutableLiveData<List<CardList>> showAggCardView;

    public AggCardState() {
        this((MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, 31, (DefaultConstructorMarker) null);
    }

    public AggCardState(MutableLiveData<MvpRecommendList> recommendListData2, MutableLiveData<List<CardList>> showAggCardView2, MutableLiveData<Unit> resumeAggCardView2, MutableLiveData<Unit> aggCardViewGone2, MutableLiveData<ClkReportData> clkReportData2) {
        Intrinsics.checkNotNullParameter(recommendListData2, "recommendListData");
        Intrinsics.checkNotNullParameter(showAggCardView2, "showAggCardView");
        Intrinsics.checkNotNullParameter(resumeAggCardView2, "resumeAggCardView");
        Intrinsics.checkNotNullParameter(aggCardViewGone2, "aggCardViewGone");
        Intrinsics.checkNotNullParameter(clkReportData2, "clkReportData");
        this.recommendListData = recommendListData2;
        this.showAggCardView = showAggCardView2;
        this.resumeAggCardView = resumeAggCardView2;
        this.aggCardViewGone = aggCardViewGone2;
        this.clkReportData = clkReportData2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AggCardState(androidx.lifecycle.MutableLiveData r4, androidx.lifecycle.MutableLiveData r5, androidx.lifecycle.MutableLiveData r6, androidx.lifecycle.MutableLiveData r7, androidx.lifecycle.MutableLiveData r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L_0x0009
            androidx.lifecycle.MutableLiveData r4 = new androidx.lifecycle.MutableLiveData
            r4.<init>()
        L_0x0009:
            r10 = r9 & 2
            if (r10 == 0) goto L_0x0014
            androidx.lifecycle.MutableLiveData r5 = new androidx.lifecycle.MutableLiveData
            r5.<init>()
            r10 = r5
            goto L_0x0015
        L_0x0014:
            r10 = r5
        L_0x0015:
            r5 = r9 & 4
            if (r5 == 0) goto L_0x0020
            androidx.lifecycle.MutableLiveData r6 = new androidx.lifecycle.MutableLiveData
            r6.<init>()
            r0 = r6
            goto L_0x0021
        L_0x0020:
            r0 = r6
        L_0x0021:
            r5 = r9 & 8
            if (r5 == 0) goto L_0x002c
            androidx.lifecycle.MutableLiveData r7 = new androidx.lifecycle.MutableLiveData
            r7.<init>()
            r1 = r7
            goto L_0x002d
        L_0x002c:
            r1 = r7
        L_0x002d:
            r5 = r9 & 16
            if (r5 == 0) goto L_0x0038
            androidx.lifecycle.MutableLiveData r8 = new androidx.lifecycle.MutableLiveData
            r8.<init>()
            r2 = r8
            goto L_0x0039
        L_0x0038:
            r2 = r8
        L_0x0039:
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r0
            r9 = r1
            r10 = r2
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.mvp.aggcard.AggCardState.<init>(androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final MutableLiveData<MvpRecommendList> getRecommendListData() {
        return this.recommendListData;
    }

    public final MutableLiveData<List<CardList>> getShowAggCardView() {
        return this.showAggCardView;
    }

    public final MutableLiveData<Unit> getResumeAggCardView() {
        return this.resumeAggCardView;
    }

    public final MutableLiveData<Unit> getAggCardViewGone() {
        return this.aggCardViewGone;
    }

    public final MutableLiveData<ClkReportData> getClkReportData() {
        return this.clkReportData;
    }
}
