package com.baidu.searchbox.video.feedflow.tab.recommend;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001Be\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\u0002\u0010\u000bJ\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u0003HÆ\u0003Ji\u0010\u0019\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u0006\u0010 \u001a\u00020\u0004J\u0006\u0010!\u001a\u00020\u0004J\r\u0010\"\u001a\u00020\u0004H\u0000¢\u0006\u0002\b#J\u0006\u0010$\u001a\u00020\u0004J\u0006\u0010%\u001a\u00020\u0004R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006&"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/tab/recommend/RecommendFlowState;", "", "inflateLoading", "Landroidx/lifecycle/MutableLiveData;", "", "inflateNetError", "attachAuthorWork", "inflatePersonalTip", "inflateSimpleToast", "setTopEntranceVisible", "", "(Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;)V", "getAttachAuthorWork", "()Landroidx/lifecycle/MutableLiveData;", "getInflateLoading", "getInflateNetError", "getInflatePersonalTip", "getInflateSimpleToast", "getSetTopEntranceVisible", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "triggerAttachAuthorWork", "triggerAttachPersonalTip", "triggerInflateLoading", "triggerInflateLoading$feed_flow_release", "triggerInflateNetError", "triggerSimpleToast", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecommendFlowState.kt */
public final class RecommendFlowState {
    private final MutableLiveData<Unit> attachAuthorWork;
    private final MutableLiveData<Unit> inflateLoading;
    private final MutableLiveData<Unit> inflateNetError;
    private final MutableLiveData<Unit> inflatePersonalTip;
    private final MutableLiveData<Unit> inflateSimpleToast;
    private final MutableLiveData<Boolean> setTopEntranceVisible;

    public RecommendFlowState() {
        this((MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RecommendFlowState copy$default(RecommendFlowState recommendFlowState, MutableLiveData<Unit> mutableLiveData, MutableLiveData<Unit> mutableLiveData2, MutableLiveData<Unit> mutableLiveData3, MutableLiveData<Unit> mutableLiveData4, MutableLiveData<Unit> mutableLiveData5, MutableLiveData<Boolean> mutableLiveData6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            mutableLiveData = recommendFlowState.inflateLoading;
        }
        if ((i2 & 2) != 0) {
            mutableLiveData2 = recommendFlowState.inflateNetError;
        }
        MutableLiveData<Unit> mutableLiveData7 = mutableLiveData2;
        if ((i2 & 4) != 0) {
            mutableLiveData3 = recommendFlowState.attachAuthorWork;
        }
        MutableLiveData<Unit> mutableLiveData8 = mutableLiveData3;
        if ((i2 & 8) != 0) {
            mutableLiveData4 = recommendFlowState.inflatePersonalTip;
        }
        MutableLiveData<Unit> mutableLiveData9 = mutableLiveData4;
        if ((i2 & 16) != 0) {
            mutableLiveData5 = recommendFlowState.inflateSimpleToast;
        }
        MutableLiveData<Unit> mutableLiveData10 = mutableLiveData5;
        if ((i2 & 32) != 0) {
            mutableLiveData6 = recommendFlowState.setTopEntranceVisible;
        }
        return recommendFlowState.copy(mutableLiveData, mutableLiveData7, mutableLiveData8, mutableLiveData9, mutableLiveData10, mutableLiveData6);
    }

    public final MutableLiveData<Unit> component1() {
        return this.inflateLoading;
    }

    public final MutableLiveData<Unit> component2() {
        return this.inflateNetError;
    }

    public final MutableLiveData<Unit> component3() {
        return this.attachAuthorWork;
    }

    public final MutableLiveData<Unit> component4() {
        return this.inflatePersonalTip;
    }

    public final MutableLiveData<Unit> component5() {
        return this.inflateSimpleToast;
    }

    public final MutableLiveData<Boolean> component6() {
        return this.setTopEntranceVisible;
    }

    public final RecommendFlowState copy(MutableLiveData<Unit> mutableLiveData, MutableLiveData<Unit> mutableLiveData2, MutableLiveData<Unit> mutableLiveData3, MutableLiveData<Unit> mutableLiveData4, MutableLiveData<Unit> mutableLiveData5, MutableLiveData<Boolean> mutableLiveData6) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "inflateLoading");
        Intrinsics.checkNotNullParameter(mutableLiveData2, "inflateNetError");
        Intrinsics.checkNotNullParameter(mutableLiveData3, "attachAuthorWork");
        Intrinsics.checkNotNullParameter(mutableLiveData4, "inflatePersonalTip");
        Intrinsics.checkNotNullParameter(mutableLiveData5, "inflateSimpleToast");
        Intrinsics.checkNotNullParameter(mutableLiveData6, "setTopEntranceVisible");
        return new RecommendFlowState(mutableLiveData, mutableLiveData2, mutableLiveData3, mutableLiveData4, mutableLiveData5, mutableLiveData6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecommendFlowState)) {
            return false;
        }
        RecommendFlowState recommendFlowState = (RecommendFlowState) obj;
        return Intrinsics.areEqual((Object) this.inflateLoading, (Object) recommendFlowState.inflateLoading) && Intrinsics.areEqual((Object) this.inflateNetError, (Object) recommendFlowState.inflateNetError) && Intrinsics.areEqual((Object) this.attachAuthorWork, (Object) recommendFlowState.attachAuthorWork) && Intrinsics.areEqual((Object) this.inflatePersonalTip, (Object) recommendFlowState.inflatePersonalTip) && Intrinsics.areEqual((Object) this.inflateSimpleToast, (Object) recommendFlowState.inflateSimpleToast) && Intrinsics.areEqual((Object) this.setTopEntranceVisible, (Object) recommendFlowState.setTopEntranceVisible);
    }

    public int hashCode() {
        return (((((((((this.inflateLoading.hashCode() * 31) + this.inflateNetError.hashCode()) * 31) + this.attachAuthorWork.hashCode()) * 31) + this.inflatePersonalTip.hashCode()) * 31) + this.inflateSimpleToast.hashCode()) * 31) + this.setTopEntranceVisible.hashCode();
    }

    public String toString() {
        return "RecommendFlowState(inflateLoading=" + this.inflateLoading + ", inflateNetError=" + this.inflateNetError + ", attachAuthorWork=" + this.attachAuthorWork + ", inflatePersonalTip=" + this.inflatePersonalTip + ", inflateSimpleToast=" + this.inflateSimpleToast + ", setTopEntranceVisible=" + this.setTopEntranceVisible + ')';
    }

    public RecommendFlowState(MutableLiveData<Unit> inflateLoading2, MutableLiveData<Unit> inflateNetError2, MutableLiveData<Unit> attachAuthorWork2, MutableLiveData<Unit> inflatePersonalTip2, MutableLiveData<Unit> inflateSimpleToast2, MutableLiveData<Boolean> setTopEntranceVisible2) {
        Intrinsics.checkNotNullParameter(inflateLoading2, "inflateLoading");
        Intrinsics.checkNotNullParameter(inflateNetError2, "inflateNetError");
        Intrinsics.checkNotNullParameter(attachAuthorWork2, "attachAuthorWork");
        Intrinsics.checkNotNullParameter(inflatePersonalTip2, "inflatePersonalTip");
        Intrinsics.checkNotNullParameter(inflateSimpleToast2, "inflateSimpleToast");
        Intrinsics.checkNotNullParameter(setTopEntranceVisible2, "setTopEntranceVisible");
        this.inflateLoading = inflateLoading2;
        this.inflateNetError = inflateNetError2;
        this.attachAuthorWork = attachAuthorWork2;
        this.inflatePersonalTip = inflatePersonalTip2;
        this.inflateSimpleToast = inflateSimpleToast2;
        this.setTopEntranceVisible = setTopEntranceVisible2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RecommendFlowState(androidx.lifecycle.MutableLiveData r5, androidx.lifecycle.MutableLiveData r6, androidx.lifecycle.MutableLiveData r7, androidx.lifecycle.MutableLiveData r8, androidx.lifecycle.MutableLiveData r9, androidx.lifecycle.MutableLiveData r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            if (r12 == 0) goto L_0x0009
            androidx.lifecycle.MutableLiveData r5 = new androidx.lifecycle.MutableLiveData
            r5.<init>()
        L_0x0009:
            r12 = r11 & 2
            if (r12 == 0) goto L_0x0014
            androidx.lifecycle.MutableLiveData r6 = new androidx.lifecycle.MutableLiveData
            r6.<init>()
            r12 = r6
            goto L_0x0015
        L_0x0014:
            r12 = r6
        L_0x0015:
            r6 = r11 & 4
            if (r6 == 0) goto L_0x0020
            androidx.lifecycle.MutableLiveData r7 = new androidx.lifecycle.MutableLiveData
            r7.<init>()
            r0 = r7
            goto L_0x0021
        L_0x0020:
            r0 = r7
        L_0x0021:
            r6 = r11 & 8
            if (r6 == 0) goto L_0x002c
            androidx.lifecycle.MutableLiveData r8 = new androidx.lifecycle.MutableLiveData
            r8.<init>()
            r1 = r8
            goto L_0x002d
        L_0x002c:
            r1 = r8
        L_0x002d:
            r6 = r11 & 16
            if (r6 == 0) goto L_0x0038
            androidx.lifecycle.MutableLiveData r9 = new androidx.lifecycle.MutableLiveData
            r9.<init>()
            r2 = r9
            goto L_0x0039
        L_0x0038:
            r2 = r9
        L_0x0039:
            r6 = r11 & 32
            if (r6 == 0) goto L_0x0044
            androidx.lifecycle.MutableLiveData r10 = new androidx.lifecycle.MutableLiveData
            r10.<init>()
            r3 = r10
            goto L_0x0045
        L_0x0044:
            r3 = r10
        L_0x0045:
            r6 = r4
            r7 = r5
            r8 = r12
            r9 = r0
            r10 = r1
            r11 = r2
            r12 = r3
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.tab.recommend.RecommendFlowState.<init>(androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final MutableLiveData<Unit> getInflateLoading() {
        return this.inflateLoading;
    }

    public final MutableLiveData<Unit> getInflateNetError() {
        return this.inflateNetError;
    }

    public final MutableLiveData<Unit> getAttachAuthorWork() {
        return this.attachAuthorWork;
    }

    public final MutableLiveData<Unit> getInflatePersonalTip() {
        return this.inflatePersonalTip;
    }

    public final MutableLiveData<Unit> getInflateSimpleToast() {
        return this.inflateSimpleToast;
    }

    public final MutableLiveData<Boolean> getSetTopEntranceVisible() {
        return this.setTopEntranceVisible;
    }

    public final void triggerInflateLoading$feed_flow_release() {
        this.inflateLoading.setValue(Unit.INSTANCE);
    }

    public final void triggerInflateNetError() {
        this.inflateNetError.setValue(Unit.INSTANCE);
    }

    public final void triggerAttachAuthorWork() {
        this.attachAuthorWork.setValue(Unit.INSTANCE);
    }

    public final void triggerAttachPersonalTip() {
        this.inflatePersonalTip.setValue(Unit.INSTANCE);
    }

    public final void triggerSimpleToast() {
        this.inflateSimpleToast.setValue(Unit.INSTANCE);
    }
}
