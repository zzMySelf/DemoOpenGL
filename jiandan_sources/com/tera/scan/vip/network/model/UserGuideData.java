package com.tera.scan.vip.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000eJ>\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0017HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0017HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006#"}, d2 = {"Lcom/tera/scan/vip/network/model/UserGuideData;", "Landroid/os/Parcelable;", "buttonText", "", "buttonUrl", "icon", "price", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getButtonText", "()Ljava/lang/String;", "getButtonUrl", "getIcon", "getPrice", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/tera/scan/vip/network/model/UserGuideData;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "lib_vip_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserGuideData implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<UserGuideData> CREATOR = new qw();
    @SerializedName("button_text")
    @Nullable
    public final String buttonText;
    @SerializedName("button_url")
    @Nullable
    public final String buttonUrl;
    @SerializedName("icon")
    @Nullable
    public final String icon;
    @SerializedName("price")
    @Nullable
    public final Long price;

    public static final class qw implements Parcelable.Creator<UserGuideData> {
        @NotNull
        /* renamed from: ad */
        public final UserGuideData[] newArray(int i2) {
            return new UserGuideData[i2];
        }

        @NotNull
        /* renamed from: qw */
        public final UserGuideData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new UserGuideData(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()));
        }
    }

    public UserGuideData() {
        this((String) null, (String) null, (String) null, (Long) null, 15, (DefaultConstructorMarker) null);
    }

    public UserGuideData(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Long l) {
        this.buttonText = str;
        this.buttonUrl = str2;
        this.icon = str3;
        this.price = l;
    }

    public static /* synthetic */ UserGuideData copy$default(UserGuideData userGuideData, String str, String str2, String str3, Long l, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = userGuideData.buttonText;
        }
        if ((i2 & 2) != 0) {
            str2 = userGuideData.buttonUrl;
        }
        if ((i2 & 4) != 0) {
            str3 = userGuideData.icon;
        }
        if ((i2 & 8) != 0) {
            l = userGuideData.price;
        }
        return userGuideData.copy(str, str2, str3, l);
    }

    @Nullable
    public final String component1() {
        return this.buttonText;
    }

    @Nullable
    public final String component2() {
        return this.buttonUrl;
    }

    @Nullable
    public final String component3() {
        return this.icon;
    }

    @Nullable
    public final Long component4() {
        return this.price;
    }

    @NotNull
    public final UserGuideData copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Long l) {
        return new UserGuideData(str, str2, str3, l);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserGuideData)) {
            return false;
        }
        UserGuideData userGuideData = (UserGuideData) obj;
        return Intrinsics.areEqual((Object) this.buttonText, (Object) userGuideData.buttonText) && Intrinsics.areEqual((Object) this.buttonUrl, (Object) userGuideData.buttonUrl) && Intrinsics.areEqual((Object) this.icon, (Object) userGuideData.icon) && Intrinsics.areEqual((Object) this.price, (Object) userGuideData.price);
    }

    @Nullable
    public final String getButtonText() {
        return this.buttonText;
    }

    @Nullable
    public final String getButtonUrl() {
        return this.buttonUrl;
    }

    @Nullable
    public final String getIcon() {
        return this.icon;
    }

    @Nullable
    public final Long getPrice() {
        return this.price;
    }

    public int hashCode() {
        String str = this.buttonText;
        int i2 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.buttonUrl;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.icon;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l = this.price;
        if (l != null) {
            i2 = l.hashCode();
        }
        return hashCode3 + i2;
    }

    @NotNull
    public String toString() {
        return "UserGuideData(buttonText=" + this.buttonText + ", buttonUrl=" + this.buttonUrl + ", icon=" + this.icon + ", price=" + this.price + ')';
    }

    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.buttonText);
        parcel.writeString(this.buttonUrl);
        parcel.writeString(this.icon);
        Long l = this.price;
        if (l == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeLong(l.longValue());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserGuideData(String str, String str2, String str3, Long l, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : l);
    }
}
