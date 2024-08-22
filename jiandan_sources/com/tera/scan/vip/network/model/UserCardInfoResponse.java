package com.tera.scan.vip.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import fe.mmm.qw.nn.de.pf.de;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/tera/scan/vip/network/model/UserCardInfoResponse;", "Lcom/tera/scan/network/network/response/Response;", "Landroid/os/Parcelable;", "rightsInfo", "Lcom/tera/scan/vip/network/model/RightsInfoData;", "guideData", "Lcom/tera/scan/vip/network/model/UserGuideData;", "(Lcom/tera/scan/vip/network/model/RightsInfoData;Lcom/tera/scan/vip/network/model/UserGuideData;)V", "getGuideData", "()Lcom/tera/scan/vip/network/model/UserGuideData;", "getRightsInfo", "()Lcom/tera/scan/vip/network/model/RightsInfoData;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "lib_vip_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserCardInfoResponse extends de implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<UserCardInfoResponse> CREATOR = new qw();
    @SerializedName("guide_data")
    @Nullable
    public final UserGuideData guideData;
    @SerializedName("rights_info")
    @Nullable
    public final RightsInfoData rightsInfo;

    public static final class qw implements Parcelable.Creator<UserCardInfoResponse> {
        @NotNull
        /* renamed from: ad */
        public final UserCardInfoResponse[] newArray(int i2) {
            return new UserCardInfoResponse[i2];
        }

        @NotNull
        /* renamed from: qw */
        public final UserCardInfoResponse createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            UserGuideData userGuideData = null;
            RightsInfoData createFromParcel = parcel.readInt() == 0 ? null : RightsInfoData.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                userGuideData = UserGuideData.CREATOR.createFromParcel(parcel);
            }
            return new UserCardInfoResponse(createFromParcel, userGuideData);
        }
    }

    public UserCardInfoResponse() {
        this((RightsInfoData) null, (UserGuideData) null, 3, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserCardInfoResponse(RightsInfoData rightsInfoData, UserGuideData userGuideData, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : rightsInfoData, (i2 & 2) != 0 ? null : userGuideData);
    }

    public static /* synthetic */ UserCardInfoResponse copy$default(UserCardInfoResponse userCardInfoResponse, RightsInfoData rightsInfoData, UserGuideData userGuideData, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            rightsInfoData = userCardInfoResponse.rightsInfo;
        }
        if ((i2 & 2) != 0) {
            userGuideData = userCardInfoResponse.guideData;
        }
        return userCardInfoResponse.copy(rightsInfoData, userGuideData);
    }

    @Nullable
    public final RightsInfoData component1() {
        return this.rightsInfo;
    }

    @Nullable
    public final UserGuideData component2() {
        return this.guideData;
    }

    @NotNull
    public final UserCardInfoResponse copy(@Nullable RightsInfoData rightsInfoData, @Nullable UserGuideData userGuideData) {
        return new UserCardInfoResponse(rightsInfoData, userGuideData);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserCardInfoResponse)) {
            return false;
        }
        UserCardInfoResponse userCardInfoResponse = (UserCardInfoResponse) obj;
        return Intrinsics.areEqual((Object) this.rightsInfo, (Object) userCardInfoResponse.rightsInfo) && Intrinsics.areEqual((Object) this.guideData, (Object) userCardInfoResponse.guideData);
    }

    @Nullable
    public final UserGuideData getGuideData() {
        return this.guideData;
    }

    @Nullable
    public final RightsInfoData getRightsInfo() {
        return this.rightsInfo;
    }

    public int hashCode() {
        RightsInfoData rightsInfoData = this.rightsInfo;
        int i2 = 0;
        int hashCode = (rightsInfoData == null ? 0 : rightsInfoData.hashCode()) * 31;
        UserGuideData userGuideData = this.guideData;
        if (userGuideData != null) {
            i2 = userGuideData.hashCode();
        }
        return hashCode + i2;
    }

    @NotNull
    public String toString() {
        return "UserCardInfoResponse(rightsInfo=" + this.rightsInfo + ", guideData=" + this.guideData + ')';
    }

    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        RightsInfoData rightsInfoData = this.rightsInfo;
        if (rightsInfoData == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            rightsInfoData.writeToParcel(parcel, i2);
        }
        UserGuideData userGuideData = this.guideData;
        if (userGuideData == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        userGuideData.writeToParcel(parcel, i2);
    }

    public UserCardInfoResponse(@Nullable RightsInfoData rightsInfoData, @Nullable UserGuideData userGuideData) {
        this.rightsInfo = rightsInfoData;
        this.guideData = userGuideData;
    }
}
