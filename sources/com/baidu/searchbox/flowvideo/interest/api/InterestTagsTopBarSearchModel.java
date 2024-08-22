package com.baidu.searchbox.flowvideo.interest.api;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0006\u0010\u0014\u001a\u00020\u0010J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/flowvideo/interest/api/InterestTagsTopBarSearchModel;", "", "switch", "", "scheme", "(Ljava/lang/String;Ljava/lang/String;)V", "getScheme", "()Ljava/lang/String;", "setScheme", "(Ljava/lang/String;)V", "getSwitch", "setSwitch", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "isSwitch", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InterestTagsDataModel.kt */
public final class InterestTagsTopBarSearchModel {
    private String scheme;

    /* renamed from: switch  reason: not valid java name */
    private String f1145switch;

    public InterestTagsTopBarSearchModel() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ InterestTagsTopBarSearchModel copy$default(InterestTagsTopBarSearchModel interestTagsTopBarSearchModel, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = interestTagsTopBarSearchModel.f1145switch;
        }
        if ((i2 & 2) != 0) {
            str2 = interestTagsTopBarSearchModel.scheme;
        }
        return interestTagsTopBarSearchModel.copy(str, str2);
    }

    public final String component1() {
        return this.f1145switch;
    }

    public final String component2() {
        return this.scheme;
    }

    public final InterestTagsTopBarSearchModel copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "switch");
        Intrinsics.checkNotNullParameter(str2, "scheme");
        return new InterestTagsTopBarSearchModel(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InterestTagsTopBarSearchModel)) {
            return false;
        }
        InterestTagsTopBarSearchModel interestTagsTopBarSearchModel = (InterestTagsTopBarSearchModel) obj;
        return Intrinsics.areEqual((Object) this.f1145switch, (Object) interestTagsTopBarSearchModel.f1145switch) && Intrinsics.areEqual((Object) this.scheme, (Object) interestTagsTopBarSearchModel.scheme);
    }

    public int hashCode() {
        return (this.f1145switch.hashCode() * 31) + this.scheme.hashCode();
    }

    public String toString() {
        return "InterestTagsTopBarSearchModel(switch=" + this.f1145switch + ", scheme=" + this.scheme + ')';
    }

    public InterestTagsTopBarSearchModel(String str, String scheme2) {
        Intrinsics.checkNotNullParameter(str, "switch");
        Intrinsics.checkNotNullParameter(scheme2, "scheme");
        this.f1145switch = str;
        this.scheme = scheme2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InterestTagsTopBarSearchModel(String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2);
    }

    public final String getSwitch() {
        return this.f1145switch;
    }

    public final void setSwitch(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f1145switch = str;
    }

    public final String getScheme() {
        return this.scheme;
    }

    public final void setScheme(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.scheme = str;
    }

    public final boolean isSwitch() {
        return Intrinsics.areEqual((Object) this.f1145switch, (Object) "1");
    }
}
