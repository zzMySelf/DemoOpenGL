package com.baidu.searchbox.openwidget;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/openwidget/OpenWidgetAbilityRequest;", "Landroid/os/Parcelable;", "target", "", "extra", "Landroid/os/Bundle;", "(Ljava/lang/String;Landroid/os/Bundle;)V", "getExtra", "()Landroid/os/Bundle;", "getTarget", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "lib-openwidget-ability-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OpenWidgetAbilityRequest.kt */
public final class OpenWidgetAbilityRequest implements Parcelable {
    public static final Parcelable.Creator<OpenWidgetAbilityRequest> CREATOR = new Creator();
    private final Bundle extra;
    private final String target;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: OpenWidgetAbilityRequest.kt */
    public static final class Creator implements Parcelable.Creator<OpenWidgetAbilityRequest> {
        public final OpenWidgetAbilityRequest createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new OpenWidgetAbilityRequest(parcel.readString(), parcel.readBundle());
        }

        public final OpenWidgetAbilityRequest[] newArray(int i2) {
            return new OpenWidgetAbilityRequest[i2];
        }
    }

    public static /* synthetic */ OpenWidgetAbilityRequest copy$default(OpenWidgetAbilityRequest openWidgetAbilityRequest, String str, Bundle bundle, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = openWidgetAbilityRequest.target;
        }
        if ((i2 & 2) != 0) {
            bundle = openWidgetAbilityRequest.extra;
        }
        return openWidgetAbilityRequest.copy(str, bundle);
    }

    public final String component1() {
        return this.target;
    }

    public final Bundle component2() {
        return this.extra;
    }

    public final OpenWidgetAbilityRequest copy(String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "target");
        Intrinsics.checkNotNullParameter(bundle, "extra");
        return new OpenWidgetAbilityRequest(str, bundle);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OpenWidgetAbilityRequest)) {
            return false;
        }
        OpenWidgetAbilityRequest openWidgetAbilityRequest = (OpenWidgetAbilityRequest) obj;
        return Intrinsics.areEqual((Object) this.target, (Object) openWidgetAbilityRequest.target) && Intrinsics.areEqual((Object) this.extra, (Object) openWidgetAbilityRequest.extra);
    }

    public int hashCode() {
        return (this.target.hashCode() * 31) + this.extra.hashCode();
    }

    public String toString() {
        return "OpenWidgetAbilityRequest(target=" + this.target + ", extra=" + this.extra + ')';
    }

    public void writeToParcel(Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.target);
        parcel.writeBundle(this.extra);
    }

    public OpenWidgetAbilityRequest(String target2, Bundle extra2) {
        Intrinsics.checkNotNullParameter(target2, "target");
        Intrinsics.checkNotNullParameter(extra2, "extra");
        this.target = target2;
        this.extra = extra2;
    }

    public final String getTarget() {
        return this.target;
    }

    public final Bundle getExtra() {
        return this.extra;
    }
}
