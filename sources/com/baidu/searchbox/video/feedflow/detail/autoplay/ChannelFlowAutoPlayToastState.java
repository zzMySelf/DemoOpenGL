package com.baidu.searchbox.video.feedflow.detail.autoplay;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B£\u0001\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0011J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0004HÆ\u0003J\t\u0010'\u001a\u00020\u0004HÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010,\u001a\u00020\rHÆ\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J§\u0001\u0010.\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010/\u001a\u00020\u00042\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\rHÖ\u0001J\t\u00102\u001a\u000203HÖ\u0001R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0013R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0013¨\u00064"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/autoplay/ChannelFlowAutoPlayToastState;", "", "intercept", "Landroidx/lifecycle/MutableLiveData;", "", "guideShowing", "isGuideShown", "autoGuideClick", "", "aIGuideClick", "loopGuideClick", "onPageSelected", "curPosition", "", "onDetachFromScreen", "tabSelected", "isEnable", "(Landroidx/lifecycle/MutableLiveData;ZZLandroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;ILandroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;)V", "getAIGuideClick", "()Landroidx/lifecycle/MutableLiveData;", "getAutoGuideClick", "getCurPosition", "()I", "setCurPosition", "(I)V", "getGuideShowing", "()Z", "setGuideShowing", "(Z)V", "getIntercept", "setGuideShown", "getLoopGuideClick", "getOnDetachFromScreen", "getOnPageSelected", "getTabSelected", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelFlowAutoPlayToastState.kt */
public final class ChannelFlowAutoPlayToastState {
    private final MutableLiveData<Unit> aIGuideClick;
    private final MutableLiveData<Unit> autoGuideClick;
    private int curPosition;
    private boolean guideShowing;
    private final MutableLiveData<Boolean> intercept;
    private final MutableLiveData<Boolean> isEnable;
    private boolean isGuideShown;
    private final MutableLiveData<Unit> loopGuideClick;
    private final MutableLiveData<Unit> onDetachFromScreen;
    private final MutableLiveData<Boolean> onPageSelected;
    private final MutableLiveData<Unit> tabSelected;

    public ChannelFlowAutoPlayToastState() {
        this((MutableLiveData) null, false, false, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, 0, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, 2047, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ChannelFlowAutoPlayToastState copy$default(ChannelFlowAutoPlayToastState channelFlowAutoPlayToastState, MutableLiveData mutableLiveData, boolean z, boolean z2, MutableLiveData mutableLiveData2, MutableLiveData mutableLiveData3, MutableLiveData mutableLiveData4, MutableLiveData mutableLiveData5, int i2, MutableLiveData mutableLiveData6, MutableLiveData mutableLiveData7, MutableLiveData mutableLiveData8, int i3, Object obj) {
        ChannelFlowAutoPlayToastState channelFlowAutoPlayToastState2 = channelFlowAutoPlayToastState;
        int i4 = i3;
        return channelFlowAutoPlayToastState.copy((i4 & 1) != 0 ? channelFlowAutoPlayToastState2.intercept : mutableLiveData, (i4 & 2) != 0 ? channelFlowAutoPlayToastState2.guideShowing : z, (i4 & 4) != 0 ? channelFlowAutoPlayToastState2.isGuideShown : z2, (i4 & 8) != 0 ? channelFlowAutoPlayToastState2.autoGuideClick : mutableLiveData2, (i4 & 16) != 0 ? channelFlowAutoPlayToastState2.aIGuideClick : mutableLiveData3, (i4 & 32) != 0 ? channelFlowAutoPlayToastState2.loopGuideClick : mutableLiveData4, (i4 & 64) != 0 ? channelFlowAutoPlayToastState2.onPageSelected : mutableLiveData5, (i4 & 128) != 0 ? channelFlowAutoPlayToastState2.curPosition : i2, (i4 & 256) != 0 ? channelFlowAutoPlayToastState2.onDetachFromScreen : mutableLiveData6, (i4 & 512) != 0 ? channelFlowAutoPlayToastState2.tabSelected : mutableLiveData7, (i4 & 1024) != 0 ? channelFlowAutoPlayToastState2.isEnable : mutableLiveData8);
    }

    public final MutableLiveData<Boolean> component1() {
        return this.intercept;
    }

    public final MutableLiveData<Unit> component10() {
        return this.tabSelected;
    }

    public final MutableLiveData<Boolean> component11() {
        return this.isEnable;
    }

    public final boolean component2() {
        return this.guideShowing;
    }

    public final boolean component3() {
        return this.isGuideShown;
    }

    public final MutableLiveData<Unit> component4() {
        return this.autoGuideClick;
    }

    public final MutableLiveData<Unit> component5() {
        return this.aIGuideClick;
    }

    public final MutableLiveData<Unit> component6() {
        return this.loopGuideClick;
    }

    public final MutableLiveData<Boolean> component7() {
        return this.onPageSelected;
    }

    public final int component8() {
        return this.curPosition;
    }

    public final MutableLiveData<Unit> component9() {
        return this.onDetachFromScreen;
    }

    public final ChannelFlowAutoPlayToastState copy(MutableLiveData<Boolean> mutableLiveData, boolean z, boolean z2, MutableLiveData<Unit> mutableLiveData2, MutableLiveData<Unit> mutableLiveData3, MutableLiveData<Unit> mutableLiveData4, MutableLiveData<Boolean> mutableLiveData5, int i2, MutableLiveData<Unit> mutableLiveData6, MutableLiveData<Unit> mutableLiveData7, MutableLiveData<Boolean> mutableLiveData8) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "intercept");
        Intrinsics.checkNotNullParameter(mutableLiveData2, "autoGuideClick");
        Intrinsics.checkNotNullParameter(mutableLiveData3, "aIGuideClick");
        Intrinsics.checkNotNullParameter(mutableLiveData4, "loopGuideClick");
        Intrinsics.checkNotNullParameter(mutableLiveData5, "onPageSelected");
        MutableLiveData<Unit> mutableLiveData9 = mutableLiveData6;
        Intrinsics.checkNotNullParameter(mutableLiveData9, "onDetachFromScreen");
        Intrinsics.checkNotNullParameter(mutableLiveData7, "tabSelected");
        Intrinsics.checkNotNullParameter(mutableLiveData8, "isEnable");
        return new ChannelFlowAutoPlayToastState(mutableLiveData, z, z2, mutableLiveData2, mutableLiveData3, mutableLiveData4, mutableLiveData5, i2, mutableLiveData9, mutableLiveData7, mutableLiveData8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelFlowAutoPlayToastState)) {
            return false;
        }
        ChannelFlowAutoPlayToastState channelFlowAutoPlayToastState = (ChannelFlowAutoPlayToastState) obj;
        return Intrinsics.areEqual((Object) this.intercept, (Object) channelFlowAutoPlayToastState.intercept) && this.guideShowing == channelFlowAutoPlayToastState.guideShowing && this.isGuideShown == channelFlowAutoPlayToastState.isGuideShown && Intrinsics.areEqual((Object) this.autoGuideClick, (Object) channelFlowAutoPlayToastState.autoGuideClick) && Intrinsics.areEqual((Object) this.aIGuideClick, (Object) channelFlowAutoPlayToastState.aIGuideClick) && Intrinsics.areEqual((Object) this.loopGuideClick, (Object) channelFlowAutoPlayToastState.loopGuideClick) && Intrinsics.areEqual((Object) this.onPageSelected, (Object) channelFlowAutoPlayToastState.onPageSelected) && this.curPosition == channelFlowAutoPlayToastState.curPosition && Intrinsics.areEqual((Object) this.onDetachFromScreen, (Object) channelFlowAutoPlayToastState.onDetachFromScreen) && Intrinsics.areEqual((Object) this.tabSelected, (Object) channelFlowAutoPlayToastState.tabSelected) && Intrinsics.areEqual((Object) this.isEnable, (Object) channelFlowAutoPlayToastState.isEnable);
    }

    public int hashCode() {
        int hashCode = this.intercept.hashCode() * 31;
        boolean z = this.guideShowing;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (hashCode + (z ? 1 : 0)) * 31;
        boolean z3 = this.isGuideShown;
        if (!z3) {
            z2 = z3;
        }
        return ((((((((((((((((i2 + (z2 ? 1 : 0)) * 31) + this.autoGuideClick.hashCode()) * 31) + this.aIGuideClick.hashCode()) * 31) + this.loopGuideClick.hashCode()) * 31) + this.onPageSelected.hashCode()) * 31) + Integer.hashCode(this.curPosition)) * 31) + this.onDetachFromScreen.hashCode()) * 31) + this.tabSelected.hashCode()) * 31) + this.isEnable.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ChannelFlowAutoPlayToastState(intercept=").append(this.intercept).append(", guideShowing=").append(this.guideShowing).append(", isGuideShown=").append(this.isGuideShown).append(", autoGuideClick=").append(this.autoGuideClick).append(", aIGuideClick=").append(this.aIGuideClick).append(", loopGuideClick=").append(this.loopGuideClick).append(", onPageSelected=").append(this.onPageSelected).append(", curPosition=").append(this.curPosition).append(", onDetachFromScreen=").append(this.onDetachFromScreen).append(", tabSelected=").append(this.tabSelected).append(", isEnable=").append(this.isEnable).append(')');
        return sb.toString();
    }

    public ChannelFlowAutoPlayToastState(MutableLiveData<Boolean> intercept2, boolean guideShowing2, boolean isGuideShown2, MutableLiveData<Unit> autoGuideClick2, MutableLiveData<Unit> aIGuideClick2, MutableLiveData<Unit> loopGuideClick2, MutableLiveData<Boolean> onPageSelected2, int curPosition2, MutableLiveData<Unit> onDetachFromScreen2, MutableLiveData<Unit> tabSelected2, MutableLiveData<Boolean> isEnable2) {
        Intrinsics.checkNotNullParameter(intercept2, "intercept");
        Intrinsics.checkNotNullParameter(autoGuideClick2, "autoGuideClick");
        Intrinsics.checkNotNullParameter(aIGuideClick2, "aIGuideClick");
        Intrinsics.checkNotNullParameter(loopGuideClick2, "loopGuideClick");
        Intrinsics.checkNotNullParameter(onPageSelected2, "onPageSelected");
        Intrinsics.checkNotNullParameter(onDetachFromScreen2, "onDetachFromScreen");
        Intrinsics.checkNotNullParameter(tabSelected2, "tabSelected");
        Intrinsics.checkNotNullParameter(isEnable2, "isEnable");
        this.intercept = intercept2;
        this.guideShowing = guideShowing2;
        this.isGuideShown = isGuideShown2;
        this.autoGuideClick = autoGuideClick2;
        this.aIGuideClick = aIGuideClick2;
        this.loopGuideClick = loopGuideClick2;
        this.onPageSelected = onPageSelected2;
        this.curPosition = curPosition2;
        this.onDetachFromScreen = onDetachFromScreen2;
        this.tabSelected = tabSelected2;
        this.isEnable = isEnable2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ChannelFlowAutoPlayToastState(androidx.lifecycle.MutableLiveData r12, boolean r13, boolean r14, androidx.lifecycle.MutableLiveData r15, androidx.lifecycle.MutableLiveData r16, androidx.lifecycle.MutableLiveData r17, androidx.lifecycle.MutableLiveData r18, int r19, androidx.lifecycle.MutableLiveData r20, androidx.lifecycle.MutableLiveData r21, androidx.lifecycle.MutableLiveData r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r11 = this;
            r0 = r23
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000c
            androidx.lifecycle.MutableLiveData r1 = new androidx.lifecycle.MutableLiveData
            r1.<init>()
            goto L_0x000d
        L_0x000c:
            r1 = r12
        L_0x000d:
            r2 = r0 & 2
            r3 = 0
            if (r2 == 0) goto L_0x0014
            r2 = r3
            goto L_0x0015
        L_0x0014:
            r2 = r13
        L_0x0015:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001b
            r4 = r3
            goto L_0x001c
        L_0x001b:
            r4 = r14
        L_0x001c:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0026
            androidx.lifecycle.MutableLiveData r5 = new androidx.lifecycle.MutableLiveData
            r5.<init>()
            goto L_0x0027
        L_0x0026:
            r5 = r15
        L_0x0027:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0031
            androidx.lifecycle.MutableLiveData r6 = new androidx.lifecycle.MutableLiveData
            r6.<init>()
            goto L_0x0033
        L_0x0031:
            r6 = r16
        L_0x0033:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x003d
            androidx.lifecycle.MutableLiveData r7 = new androidx.lifecycle.MutableLiveData
            r7.<init>()
            goto L_0x003f
        L_0x003d:
            r7 = r17
        L_0x003f:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0049
            androidx.lifecycle.MutableLiveData r8 = new androidx.lifecycle.MutableLiveData
            r8.<init>()
            goto L_0x004b
        L_0x0049:
            r8 = r18
        L_0x004b:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0050
            goto L_0x0052
        L_0x0050:
            r3 = r19
        L_0x0052:
            r9 = r0 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x005c
            androidx.lifecycle.MutableLiveData r9 = new androidx.lifecycle.MutableLiveData
            r9.<init>()
            goto L_0x005e
        L_0x005c:
            r9 = r20
        L_0x005e:
            r10 = r0 & 512(0x200, float:7.175E-43)
            if (r10 == 0) goto L_0x0068
            androidx.lifecycle.MutableLiveData r10 = new androidx.lifecycle.MutableLiveData
            r10.<init>()
            goto L_0x006a
        L_0x0068:
            r10 = r21
        L_0x006a:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0074
            androidx.lifecycle.MutableLiveData r0 = new androidx.lifecycle.MutableLiveData
            r0.<init>()
            goto L_0x0076
        L_0x0074:
            r0 = r22
        L_0x0076:
            r12 = r1
            r13 = r2
            r14 = r4
            r15 = r5
            r16 = r6
            r17 = r7
            r18 = r8
            r19 = r3
            r20 = r9
            r21 = r10
            r22 = r0
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.autoplay.ChannelFlowAutoPlayToastState.<init>(androidx.lifecycle.MutableLiveData, boolean, boolean, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, int, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final MutableLiveData<Boolean> getIntercept() {
        return this.intercept;
    }

    public final boolean getGuideShowing() {
        return this.guideShowing;
    }

    public final void setGuideShowing(boolean z) {
        this.guideShowing = z;
    }

    public final boolean isGuideShown() {
        return this.isGuideShown;
    }

    public final void setGuideShown(boolean z) {
        this.isGuideShown = z;
    }

    public final MutableLiveData<Unit> getAutoGuideClick() {
        return this.autoGuideClick;
    }

    public final MutableLiveData<Unit> getAIGuideClick() {
        return this.aIGuideClick;
    }

    public final MutableLiveData<Unit> getLoopGuideClick() {
        return this.loopGuideClick;
    }

    public final MutableLiveData<Boolean> getOnPageSelected() {
        return this.onPageSelected;
    }

    public final int getCurPosition() {
        return this.curPosition;
    }

    public final void setCurPosition(int i2) {
        this.curPosition = i2;
    }

    public final MutableLiveData<Unit> getOnDetachFromScreen() {
        return this.onDetachFromScreen;
    }

    public final MutableLiveData<Unit> getTabSelected() {
        return this.tabSelected;
    }

    public final MutableLiveData<Boolean> isEnable() {
        return this.isEnable;
    }
}
