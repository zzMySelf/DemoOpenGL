package com.baidu.netdisk.trade.privilege.io.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0007J\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0007J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0004J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\u000b\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b!\u0010\u0004R\u001c\u0010\n\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\"\u0010\u0007¨\u0006%"}, d2 = {"Lcom/baidu/netdisk/trade/privilege/io/model/Privilege;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "component3", "privilegeId", "privilegeValue", "freeCount", "copy", "(Ljava/lang/String;II)Lcom/baidu/netdisk/trade/privilege/io/model/Privilege;", "describeContents", "", "enable", "()Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "I", "getFreeCount", "Ljava/lang/String;", "getPrivilegeId", "getPrivilegeValue", "<init>", "(Ljava/lang/String;II)V", "TradeMemberPrivilege_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class Privilege implements Parcelable {
    public static final Parcelable.Creator CREATOR = new qw();
    @SerializedName("free_count")
    public final int freeCount;
    @SerializedName("privilege_id")
    @NotNull
    public final String privilegeId;
    @SerializedName("privilege_value")
    public final int privilegeValue;

    public static class qw implements Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new Privilege(parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        @NotNull
        public final Object[] newArray(int i2) {
            return new Privilege[i2];
        }
    }

    public Privilege(@NotNull String str, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "privilegeId");
        this.privilegeId = str;
        this.privilegeValue = i2;
        this.freeCount = i3;
    }

    public static /* synthetic */ Privilege copy$default(Privilege privilege, String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = privilege.privilegeId;
        }
        if ((i4 & 2) != 0) {
            i2 = privilege.privilegeValue;
        }
        if ((i4 & 4) != 0) {
            i3 = privilege.freeCount;
        }
        return privilege.copy(str, i2, i3);
    }

    @NotNull
    public final String component1() {
        return this.privilegeId;
    }

    public final int component2() {
        return this.privilegeValue;
    }

    public final int component3() {
        return this.freeCount;
    }

    @NotNull
    public final Privilege copy(@NotNull String str, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "privilegeId");
        return new Privilege(str, i2, i3);
    }

    public int describeContents() {
        return 0;
    }

    public final boolean enable() {
        return this.privilegeValue == 1 && this.freeCount > 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Privilege)) {
            return false;
        }
        Privilege privilege = (Privilege) obj;
        return Intrinsics.areEqual((Object) this.privilegeId, (Object) privilege.privilegeId) && this.privilegeValue == privilege.privilegeValue && this.freeCount == privilege.freeCount;
    }

    public final int getFreeCount() {
        return this.freeCount;
    }

    @NotNull
    public final String getPrivilegeId() {
        return this.privilegeId;
    }

    public final int getPrivilegeValue() {
        return this.privilegeValue;
    }

    public int hashCode() {
        String str = this.privilegeId;
        return ((((str != null ? str.hashCode() : 0) * 31) + this.privilegeValue) * 31) + this.freeCount;
    }

    @NotNull
    public String toString() {
        return "Privilege(privilegeId=" + this.privilegeId + ", privilegeValue=" + this.privilegeValue + ", freeCount=" + this.freeCount + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.privilegeId);
        parcel.writeInt(this.privilegeValue);
        parcel.writeInt(this.freeCount);
    }
}
