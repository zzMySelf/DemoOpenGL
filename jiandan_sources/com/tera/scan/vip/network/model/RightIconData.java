package com.tera.scan.vip.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/tera/scan/vip/network/model/RightIconData;", "Landroid/os/Parcelable;", "iconUrl", "", "(Ljava/lang/String;)V", "getIconUrl", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "lib_vip_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RightIconData implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<RightIconData> CREATOR = new qw();
    @SerializedName("right_icon_scan_vip")
    @Nullable
    public final String iconUrl;

    public static final class qw implements Parcelable.Creator<RightIconData> {
        @NotNull
        /* renamed from: ad */
        public final RightIconData[] newArray(int i2) {
            return new RightIconData[i2];
        }

        @NotNull
        /* renamed from: qw */
        public final RightIconData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RightIconData(parcel.readString());
        }
    }

    public RightIconData() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public RightIconData(@Nullable String str) {
        this.iconUrl = str;
    }

    public static /* synthetic */ RightIconData copy$default(RightIconData rightIconData, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = rightIconData.iconUrl;
        }
        return rightIconData.copy(str);
    }

    @Nullable
    public final String component1() {
        return this.iconUrl;
    }

    @NotNull
    public final RightIconData copy(@Nullable String str) {
        return new RightIconData(str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RightIconData) && Intrinsics.areEqual((Object) this.iconUrl, (Object) ((RightIconData) obj).iconUrl);
    }

    @Nullable
    public final String getIconUrl() {
        return this.iconUrl;
    }

    public int hashCode() {
        String str = this.iconUrl;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        return "RightIconData(iconUrl=" + this.iconUrl + ')';
    }

    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.iconUrl);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RightIconData(String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str);
    }
}
