package com.tera.scan.vip.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J>\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0017J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\bHÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\r¨\u0006$"}, d2 = {"Lcom/tera/scan/vip/network/model/PrivilegeInfoData;", "Landroid/os/Parcelable;", "rightId", "", "sortNum", "button", "Lcom/tera/scan/vip/network/model/RightIconData;", "rightName", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Lcom/tera/scan/vip/network/model/RightIconData;Ljava/lang/String;)V", "getButton", "()Lcom/tera/scan/vip/network/model/RightIconData;", "getRightId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRightName", "()Ljava/lang/String;", "getSortNum", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Lcom/tera/scan/vip/network/model/RightIconData;Ljava/lang/String;)Lcom/tera/scan/vip/network/model/PrivilegeInfoData;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "lib_vip_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PrivilegeInfoData implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<PrivilegeInfoData> CREATOR = new qw();
    @SerializedName("right_icon")
    @Nullable
    public final RightIconData button;
    @SerializedName("right_id")
    @Nullable
    public final Integer rightId;
    @SerializedName("right_name")
    @Nullable
    public final String rightName;
    @SerializedName("card_sort_num")
    @Nullable
    public final Integer sortNum;

    public static final class qw implements Parcelable.Creator<PrivilegeInfoData> {
        @NotNull
        /* renamed from: ad */
        public final PrivilegeInfoData[] newArray(int i2) {
            return new PrivilegeInfoData[i2];
        }

        @NotNull
        /* renamed from: qw */
        public final PrivilegeInfoData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            RightIconData rightIconData = null;
            Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Integer valueOf2 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() != 0) {
                rightIconData = RightIconData.CREATOR.createFromParcel(parcel);
            }
            return new PrivilegeInfoData(valueOf, valueOf2, rightIconData, parcel.readString());
        }
    }

    public PrivilegeInfoData() {
        this((Integer) null, (Integer) null, (RightIconData) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public PrivilegeInfoData(@Nullable Integer num, @Nullable Integer num2, @Nullable RightIconData rightIconData, @Nullable String str) {
        this.rightId = num;
        this.sortNum = num2;
        this.button = rightIconData;
        this.rightName = str;
    }

    public static /* synthetic */ PrivilegeInfoData copy$default(PrivilegeInfoData privilegeInfoData, Integer num, Integer num2, RightIconData rightIconData, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = privilegeInfoData.rightId;
        }
        if ((i2 & 2) != 0) {
            num2 = privilegeInfoData.sortNum;
        }
        if ((i2 & 4) != 0) {
            rightIconData = privilegeInfoData.button;
        }
        if ((i2 & 8) != 0) {
            str = privilegeInfoData.rightName;
        }
        return privilegeInfoData.copy(num, num2, rightIconData, str);
    }

    @Nullable
    public final Integer component1() {
        return this.rightId;
    }

    @Nullable
    public final Integer component2() {
        return this.sortNum;
    }

    @Nullable
    public final RightIconData component3() {
        return this.button;
    }

    @Nullable
    public final String component4() {
        return this.rightName;
    }

    @NotNull
    public final PrivilegeInfoData copy(@Nullable Integer num, @Nullable Integer num2, @Nullable RightIconData rightIconData, @Nullable String str) {
        return new PrivilegeInfoData(num, num2, rightIconData, str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PrivilegeInfoData)) {
            return false;
        }
        PrivilegeInfoData privilegeInfoData = (PrivilegeInfoData) obj;
        return Intrinsics.areEqual((Object) this.rightId, (Object) privilegeInfoData.rightId) && Intrinsics.areEqual((Object) this.sortNum, (Object) privilegeInfoData.sortNum) && Intrinsics.areEqual((Object) this.button, (Object) privilegeInfoData.button) && Intrinsics.areEqual((Object) this.rightName, (Object) privilegeInfoData.rightName);
    }

    @Nullable
    public final RightIconData getButton() {
        return this.button;
    }

    @Nullable
    public final Integer getRightId() {
        return this.rightId;
    }

    @Nullable
    public final String getRightName() {
        return this.rightName;
    }

    @Nullable
    public final Integer getSortNum() {
        return this.sortNum;
    }

    public int hashCode() {
        Integer num = this.rightId;
        int i2 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.sortNum;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        RightIconData rightIconData = this.button;
        int hashCode3 = (hashCode2 + (rightIconData == null ? 0 : rightIconData.hashCode())) * 31;
        String str = this.rightName;
        if (str != null) {
            i2 = str.hashCode();
        }
        return hashCode3 + i2;
    }

    @NotNull
    public String toString() {
        return "PrivilegeInfoData(rightId=" + this.rightId + ", sortNum=" + this.sortNum + ", button=" + this.button + ", rightName=" + this.rightName + ')';
    }

    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Integer num = this.rightId;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Integer num2 = this.sortNum;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        RightIconData rightIconData = this.button;
        if (rightIconData == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            rightIconData.writeToParcel(parcel, i2);
        }
        parcel.writeString(this.rightName);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PrivilegeInfoData(Integer num, Integer num2, RightIconData rightIconData, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : num2, (i2 & 4) != 0 ? null : rightIconData, (i2 & 8) != 0 ? null : str);
    }
}
