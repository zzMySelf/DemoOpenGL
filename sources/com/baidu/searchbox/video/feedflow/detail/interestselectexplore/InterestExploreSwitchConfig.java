package com.baidu.searchbox.video.feedflow.detail.interestselectexplore;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\"\b\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003JO\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010)\u001a\u00020\u00032\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0005HÖ\u0001J\t\u0010,\u001a\u00020\u000bHÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006-"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/interestselectexplore/InterestExploreSwitchConfig;", "", "switch", "", "slideTimes", "", "showDaysLimit", "exitConsecutiveTimes", "exitDays", "independentCount", "toastText", "", "(ZIIIIZLjava/lang/String;)V", "getExitConsecutiveTimes", "()I", "setExitConsecutiveTimes", "(I)V", "getExitDays", "setExitDays", "getIndependentCount", "()Z", "setIndependentCount", "(Z)V", "getShowDaysLimit", "setShowDaysLimit", "getSlideTimes", "setSlideTimes", "getSwitch", "setSwitch", "getToastText", "()Ljava/lang/String;", "setToastText", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InterestExploreModel.kt */
public final class InterestExploreSwitchConfig {
    private int exitConsecutiveTimes;
    private int exitDays;
    private boolean independentCount;
    private int showDaysLimit;
    private int slideTimes;

    /* renamed from: switch  reason: not valid java name */
    private boolean f1109switch;
    private String toastText;

    public InterestExploreSwitchConfig() {
        this(false, 0, 0, 0, 0, false, (String) null, 127, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ InterestExploreSwitchConfig copy$default(InterestExploreSwitchConfig interestExploreSwitchConfig, boolean z, int i2, int i3, int i4, int i5, boolean z2, String str, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            z = interestExploreSwitchConfig.f1109switch;
        }
        if ((i6 & 2) != 0) {
            i2 = interestExploreSwitchConfig.slideTimes;
        }
        int i7 = i2;
        if ((i6 & 4) != 0) {
            i3 = interestExploreSwitchConfig.showDaysLimit;
        }
        int i8 = i3;
        if ((i6 & 8) != 0) {
            i4 = interestExploreSwitchConfig.exitConsecutiveTimes;
        }
        int i9 = i4;
        if ((i6 & 16) != 0) {
            i5 = interestExploreSwitchConfig.exitDays;
        }
        int i10 = i5;
        if ((i6 & 32) != 0) {
            z2 = interestExploreSwitchConfig.independentCount;
        }
        boolean z3 = z2;
        if ((i6 & 64) != 0) {
            str = interestExploreSwitchConfig.toastText;
        }
        return interestExploreSwitchConfig.copy(z, i7, i8, i9, i10, z3, str);
    }

    public final boolean component1() {
        return this.f1109switch;
    }

    public final int component2() {
        return this.slideTimes;
    }

    public final int component3() {
        return this.showDaysLimit;
    }

    public final int component4() {
        return this.exitConsecutiveTimes;
    }

    public final int component5() {
        return this.exitDays;
    }

    public final boolean component6() {
        return this.independentCount;
    }

    public final String component7() {
        return this.toastText;
    }

    public final InterestExploreSwitchConfig copy(boolean z, int i2, int i3, int i4, int i5, boolean z2, String str) {
        Intrinsics.checkNotNullParameter(str, "toastText");
        return new InterestExploreSwitchConfig(z, i2, i3, i4, i5, z2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InterestExploreSwitchConfig)) {
            return false;
        }
        InterestExploreSwitchConfig interestExploreSwitchConfig = (InterestExploreSwitchConfig) obj;
        return this.f1109switch == interestExploreSwitchConfig.f1109switch && this.slideTimes == interestExploreSwitchConfig.slideTimes && this.showDaysLimit == interestExploreSwitchConfig.showDaysLimit && this.exitConsecutiveTimes == interestExploreSwitchConfig.exitConsecutiveTimes && this.exitDays == interestExploreSwitchConfig.exitDays && this.independentCount == interestExploreSwitchConfig.independentCount && Intrinsics.areEqual((Object) this.toastText, (Object) interestExploreSwitchConfig.toastText);
    }

    public int hashCode() {
        boolean z = this.f1109switch;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int hashCode = (((((((((z ? 1 : 0) * true) + Integer.hashCode(this.slideTimes)) * 31) + Integer.hashCode(this.showDaysLimit)) * 31) + Integer.hashCode(this.exitConsecutiveTimes)) * 31) + Integer.hashCode(this.exitDays)) * 31;
        boolean z3 = this.independentCount;
        if (!z3) {
            z2 = z3;
        }
        return ((hashCode + (z2 ? 1 : 0)) * 31) + this.toastText.hashCode();
    }

    public String toString() {
        return "InterestExploreSwitchConfig(switch=" + this.f1109switch + ", slideTimes=" + this.slideTimes + ", showDaysLimit=" + this.showDaysLimit + ", exitConsecutiveTimes=" + this.exitConsecutiveTimes + ", exitDays=" + this.exitDays + ", independentCount=" + this.independentCount + ", toastText=" + this.toastText + ')';
    }

    public InterestExploreSwitchConfig(boolean z, int slideTimes2, int showDaysLimit2, int exitConsecutiveTimes2, int exitDays2, boolean independentCount2, String toastText2) {
        Intrinsics.checkNotNullParameter(toastText2, "toastText");
        this.f1109switch = z;
        this.slideTimes = slideTimes2;
        this.showDaysLimit = showDaysLimit2;
        this.exitConsecutiveTimes = exitConsecutiveTimes2;
        this.exitDays = exitDays2;
        this.independentCount = independentCount2;
        this.toastText = toastText2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InterestExploreSwitchConfig(boolean z, int i2, int i3, int i4, int i5, boolean z2, String str, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? false : z, (i6 & 2) != 0 ? 0 : i2, (i6 & 4) != 0 ? 0 : i3, (i6 & 8) != 0 ? 0 : i4, (i6 & 16) != 0 ? 0 : i5, (i6 & 32) != 0 ? false : z2, (i6 & 64) != 0 ? "" : str);
    }

    public final boolean getSwitch() {
        return this.f1109switch;
    }

    public final void setSwitch(boolean z) {
        this.f1109switch = z;
    }

    public final int getSlideTimes() {
        return this.slideTimes;
    }

    public final void setSlideTimes(int i2) {
        this.slideTimes = i2;
    }

    public final int getShowDaysLimit() {
        return this.showDaysLimit;
    }

    public final void setShowDaysLimit(int i2) {
        this.showDaysLimit = i2;
    }

    public final int getExitConsecutiveTimes() {
        return this.exitConsecutiveTimes;
    }

    public final void setExitConsecutiveTimes(int i2) {
        this.exitConsecutiveTimes = i2;
    }

    public final int getExitDays() {
        return this.exitDays;
    }

    public final void setExitDays(int i2) {
        this.exitDays = i2;
    }

    public final boolean getIndependentCount() {
        return this.independentCount;
    }

    public final void setIndependentCount(boolean z) {
        this.independentCount = z;
    }

    public final String getToastText() {
        return this.toastText;
    }

    public final void setToastText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.toastText = str;
    }
}
