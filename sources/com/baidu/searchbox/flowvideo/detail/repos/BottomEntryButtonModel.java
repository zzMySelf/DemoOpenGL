package com.baidu.searchbox.flowvideo.detail.repos;

import com.baidu.searchbox.NoProGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/flowvideo/detail/repos/BottomEntryButtonModel;", "Lcom/baidu/searchbox/NoProGuard;", "landBtnText", "", "firstTime", "secondTime", "landBtnShowEnable", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getFirstTime", "()Ljava/lang/String;", "getLandBtnShowEnable", "()Z", "getLandBtnText", "getSecondTime", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowDetailModel.kt */
public final class BottomEntryButtonModel implements NoProGuard {
    private final String firstTime;
    private final boolean landBtnShowEnable;
    private final String landBtnText;
    private final String secondTime;

    public BottomEntryButtonModel() {
        this((String) null, (String) null, (String) null, false, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ BottomEntryButtonModel copy$default(BottomEntryButtonModel bottomEntryButtonModel, String str, String str2, String str3, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = bottomEntryButtonModel.landBtnText;
        }
        if ((i2 & 2) != 0) {
            str2 = bottomEntryButtonModel.firstTime;
        }
        if ((i2 & 4) != 0) {
            str3 = bottomEntryButtonModel.secondTime;
        }
        if ((i2 & 8) != 0) {
            z = bottomEntryButtonModel.landBtnShowEnable;
        }
        return bottomEntryButtonModel.copy(str, str2, str3, z);
    }

    public final String component1() {
        return this.landBtnText;
    }

    public final String component2() {
        return this.firstTime;
    }

    public final String component3() {
        return this.secondTime;
    }

    public final boolean component4() {
        return this.landBtnShowEnable;
    }

    public final BottomEntryButtonModel copy(String str, String str2, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "landBtnText");
        Intrinsics.checkNotNullParameter(str2, "firstTime");
        Intrinsics.checkNotNullParameter(str3, "secondTime");
        return new BottomEntryButtonModel(str, str2, str3, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BottomEntryButtonModel)) {
            return false;
        }
        BottomEntryButtonModel bottomEntryButtonModel = (BottomEntryButtonModel) obj;
        return Intrinsics.areEqual((Object) this.landBtnText, (Object) bottomEntryButtonModel.landBtnText) && Intrinsics.areEqual((Object) this.firstTime, (Object) bottomEntryButtonModel.firstTime) && Intrinsics.areEqual((Object) this.secondTime, (Object) bottomEntryButtonModel.secondTime) && this.landBtnShowEnable == bottomEntryButtonModel.landBtnShowEnable;
    }

    public int hashCode() {
        int hashCode = ((((this.landBtnText.hashCode() * 31) + this.firstTime.hashCode()) * 31) + this.secondTime.hashCode()) * 31;
        boolean z = this.landBtnShowEnable;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "BottomEntryButtonModel(landBtnText=" + this.landBtnText + ", firstTime=" + this.firstTime + ", secondTime=" + this.secondTime + ", landBtnShowEnable=" + this.landBtnShowEnable + ')';
    }

    public BottomEntryButtonModel(String landBtnText2, String firstTime2, String secondTime2, boolean landBtnShowEnable2) {
        Intrinsics.checkNotNullParameter(landBtnText2, "landBtnText");
        Intrinsics.checkNotNullParameter(firstTime2, "firstTime");
        Intrinsics.checkNotNullParameter(secondTime2, "secondTime");
        this.landBtnText = landBtnText2;
        this.firstTime = firstTime2;
        this.secondTime = secondTime2;
        this.landBtnShowEnable = landBtnShowEnable2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BottomEntryButtonModel(String str, String str2, String str3, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? false : z);
    }

    public final String getLandBtnText() {
        return this.landBtnText;
    }

    public final String getFirstTime() {
        return this.firstTime;
    }

    public final String getSecondTime() {
        return this.secondTime;
    }

    public final boolean getLandBtnShowEnable() {
        return this.landBtnShowEnable;
    }
}
