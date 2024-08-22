package com.baidu.nadcore.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003JE\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0006HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\f\"\u0004\b\u000f\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e¨\u0006%"}, d2 = {"Lcom/baidu/nadcore/model/RewardRuntimeData;", "", "isPanelPopShown", "", "isTailFrameShown", "rewardShownIndex", "", "clickUserInfoContainer", "upperLimit", "lottieDialogBtnClick", "(ZZIZZZ)V", "getClickUserInfoContainer", "()Z", "setClickUserInfoContainer", "(Z)V", "setPanelPopShown", "setTailFrameShown", "getLottieDialogBtnClick", "setLottieDialogBtnClick", "getRewardShownIndex", "()I", "setRewardShownIndex", "(I)V", "getUpperLimit", "setUpperLimit", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "nadcore-lib-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdRewardVideoLpModel.kt */
public final class RewardRuntimeData {
    private boolean clickUserInfoContainer;
    private boolean isPanelPopShown;
    private boolean isTailFrameShown;
    private boolean lottieDialogBtnClick;
    private int rewardShownIndex;
    private boolean upperLimit;

    public RewardRuntimeData() {
        this(false, false, 0, false, false, false, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RewardRuntimeData copy$default(RewardRuntimeData rewardRuntimeData, boolean z, boolean z2, int i2, boolean z3, boolean z4, boolean z5, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = rewardRuntimeData.isPanelPopShown;
        }
        if ((i3 & 2) != 0) {
            z2 = rewardRuntimeData.isTailFrameShown;
        }
        boolean z6 = z2;
        if ((i3 & 4) != 0) {
            i2 = rewardRuntimeData.rewardShownIndex;
        }
        int i4 = i2;
        if ((i3 & 8) != 0) {
            z3 = rewardRuntimeData.clickUserInfoContainer;
        }
        boolean z7 = z3;
        if ((i3 & 16) != 0) {
            z4 = rewardRuntimeData.upperLimit;
        }
        boolean z8 = z4;
        if ((i3 & 32) != 0) {
            z5 = rewardRuntimeData.lottieDialogBtnClick;
        }
        return rewardRuntimeData.copy(z, z6, i4, z7, z8, z5);
    }

    public final boolean component1() {
        return this.isPanelPopShown;
    }

    public final boolean component2() {
        return this.isTailFrameShown;
    }

    public final int component3() {
        return this.rewardShownIndex;
    }

    public final boolean component4() {
        return this.clickUserInfoContainer;
    }

    public final boolean component5() {
        return this.upperLimit;
    }

    public final boolean component6() {
        return this.lottieDialogBtnClick;
    }

    public final RewardRuntimeData copy(boolean z, boolean z2, int i2, boolean z3, boolean z4, boolean z5) {
        return new RewardRuntimeData(z, z2, i2, z3, z4, z5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RewardRuntimeData)) {
            return false;
        }
        RewardRuntimeData rewardRuntimeData = (RewardRuntimeData) obj;
        return this.isPanelPopShown == rewardRuntimeData.isPanelPopShown && this.isTailFrameShown == rewardRuntimeData.isTailFrameShown && this.rewardShownIndex == rewardRuntimeData.rewardShownIndex && this.clickUserInfoContainer == rewardRuntimeData.clickUserInfoContainer && this.upperLimit == rewardRuntimeData.upperLimit && this.lottieDialogBtnClick == rewardRuntimeData.lottieDialogBtnClick;
    }

    public int hashCode() {
        boolean z = this.isPanelPopShown;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        boolean z3 = this.isTailFrameShown;
        if (z3) {
            z3 = true;
        }
        int hashCode = (((i2 + (z3 ? 1 : 0)) * 31) + Integer.hashCode(this.rewardShownIndex)) * 31;
        boolean z4 = this.clickUserInfoContainer;
        if (z4) {
            z4 = true;
        }
        int i3 = (hashCode + (z4 ? 1 : 0)) * 31;
        boolean z5 = this.upperLimit;
        if (z5) {
            z5 = true;
        }
        int i4 = (i3 + (z5 ? 1 : 0)) * 31;
        boolean z6 = this.lottieDialogBtnClick;
        if (!z6) {
            z2 = z6;
        }
        return i4 + (z2 ? 1 : 0);
    }

    public String toString() {
        return "RewardRuntimeData(isPanelPopShown=" + this.isPanelPopShown + ", isTailFrameShown=" + this.isTailFrameShown + ", rewardShownIndex=" + this.rewardShownIndex + ", clickUserInfoContainer=" + this.clickUserInfoContainer + ", upperLimit=" + this.upperLimit + ", lottieDialogBtnClick=" + this.lottieDialogBtnClick + ')';
    }

    public RewardRuntimeData(boolean isPanelPopShown2, boolean isTailFrameShown2, int rewardShownIndex2, boolean clickUserInfoContainer2, boolean upperLimit2, boolean lottieDialogBtnClick2) {
        this.isPanelPopShown = isPanelPopShown2;
        this.isTailFrameShown = isTailFrameShown2;
        this.rewardShownIndex = rewardShownIndex2;
        this.clickUserInfoContainer = clickUserInfoContainer2;
        this.upperLimit = upperLimit2;
        this.lottieDialogBtnClick = lottieDialogBtnClick2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RewardRuntimeData(boolean z, boolean z2, int i2, boolean z3, boolean z4, boolean z5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z, (i3 & 2) != 0 ? false : z2, (i3 & 4) != 0 ? 1 : i2, (i3 & 8) != 0 ? false : z3, (i3 & 16) != 0 ? false : z4, (i3 & 32) != 0 ? false : z5);
    }

    public final boolean isPanelPopShown() {
        return this.isPanelPopShown;
    }

    public final void setPanelPopShown(boolean z) {
        this.isPanelPopShown = z;
    }

    public final boolean isTailFrameShown() {
        return this.isTailFrameShown;
    }

    public final void setTailFrameShown(boolean z) {
        this.isTailFrameShown = z;
    }

    public final int getRewardShownIndex() {
        return this.rewardShownIndex;
    }

    public final void setRewardShownIndex(int i2) {
        this.rewardShownIndex = i2;
    }

    public final boolean getClickUserInfoContainer() {
        return this.clickUserInfoContainer;
    }

    public final void setClickUserInfoContainer(boolean z) {
        this.clickUserInfoContainer = z;
    }

    public final boolean getUpperLimit() {
        return this.upperLimit;
    }

    public final void setUpperLimit(boolean z) {
        this.upperLimit = z;
    }

    public final boolean getLottieDialogBtnClick() {
        return this.lottieDialogBtnClick;
    }

    public final void setLottieDialogBtnClick(boolean z) {
        this.lottieDialogBtnClick = z;
    }
}
