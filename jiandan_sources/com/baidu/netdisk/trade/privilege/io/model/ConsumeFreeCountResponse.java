package com.baidu.netdisk.trade.privilege.io.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\b\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ>\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0005J\u0010\u0010\u0018\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0018\u0010\bJ \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\f\u001a\u00020\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b \u0010\u0005R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010!\u001a\u0004\b\"\u0010\bR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010!\u001a\u0004\b#\u0010\bR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010$\u001a\u0004\b%\u0010\u000b¨\u0006("}, d2 = {"Lcom/baidu/netdisk/trade/privilege/io/model/ConsumeFreeCountResponse;", "Landroid/os/Parcelable;", "Lcom/baidu/netdisk/trade/privilege/io/model/Response;", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "component3", "component4", "()Ljava/lang/Integer;", "freeCount", "newno", "privilegeId", "serverTime", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/baidu/netdisk/trade/privilege/io/model/ConsumeFreeCountResponse;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "I", "getFreeCount", "Ljava/lang/String;", "getNewno", "getPrivilegeId", "Ljava/lang/Integer;", "getServerTime", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "TradeMemberPrivilege_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class ConsumeFreeCountResponse extends Response implements Parcelable {
    public static final Parcelable.Creator CREATOR = new qw();
    @SerializedName("free_count")
    public final int freeCount;
    @SerializedName("newno")
    @Nullable
    public final String newno;
    @SerializedName("privilege_id")
    @Nullable
    public final String privilegeId;
    @SerializedName("server_time")
    @Nullable
    public final Integer serverTime;

    public static class qw implements Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ConsumeFreeCountResponse(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
        }

        @NotNull
        public final Object[] newArray(int i2) {
            return new ConsumeFreeCountResponse[i2];
        }
    }

    public ConsumeFreeCountResponse() {
        this(0, (String) null, (String) null, (Integer) null, 15, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConsumeFreeCountResponse(int i2, String str, String str2, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? -1 : i2, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? null : num);
    }

    public static /* synthetic */ ConsumeFreeCountResponse copy$default(ConsumeFreeCountResponse consumeFreeCountResponse, int i2, String str, String str2, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = consumeFreeCountResponse.freeCount;
        }
        if ((i3 & 2) != 0) {
            str = consumeFreeCountResponse.newno;
        }
        if ((i3 & 4) != 0) {
            str2 = consumeFreeCountResponse.privilegeId;
        }
        if ((i3 & 8) != 0) {
            num = consumeFreeCountResponse.serverTime;
        }
        return consumeFreeCountResponse.copy(i2, str, str2, num);
    }

    public final int component1() {
        return this.freeCount;
    }

    @Nullable
    public final String component2() {
        return this.newno;
    }

    @Nullable
    public final String component3() {
        return this.privilegeId;
    }

    @Nullable
    public final Integer component4() {
        return this.serverTime;
    }

    @NotNull
    public final ConsumeFreeCountResponse copy(int i2, @Nullable String str, @Nullable String str2, @Nullable Integer num) {
        return new ConsumeFreeCountResponse(i2, str, str2, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConsumeFreeCountResponse)) {
            return false;
        }
        ConsumeFreeCountResponse consumeFreeCountResponse = (ConsumeFreeCountResponse) obj;
        return this.freeCount == consumeFreeCountResponse.freeCount && Intrinsics.areEqual((Object) this.newno, (Object) consumeFreeCountResponse.newno) && Intrinsics.areEqual((Object) this.privilegeId, (Object) consumeFreeCountResponse.privilegeId) && Intrinsics.areEqual((Object) this.serverTime, (Object) consumeFreeCountResponse.serverTime);
    }

    public final int getFreeCount() {
        return this.freeCount;
    }

    @Nullable
    public final String getNewno() {
        return this.newno;
    }

    @Nullable
    public final String getPrivilegeId() {
        return this.privilegeId;
    }

    @Nullable
    public final Integer getServerTime() {
        return this.serverTime;
    }

    public int hashCode() {
        int i2 = this.freeCount * 31;
        String str = this.newno;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.privilegeId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.serverTime;
        if (num != null) {
            i3 = num.hashCode();
        }
        return hashCode2 + i3;
    }

    @NotNull
    public String toString() {
        return "ConsumeFreeCountResponse(freeCount=" + this.freeCount + ", newno=" + this.newno + ", privilegeId=" + this.privilegeId + ", serverTime=" + this.serverTime + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.freeCount);
        parcel.writeString(this.newno);
        parcel.writeString(this.privilegeId);
        Integer num = this.serverTime;
        if (num != null) {
            parcel.writeInt(1);
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        parcel.writeInt(i3);
    }

    public ConsumeFreeCountResponse(int i2, @Nullable String str, @Nullable String str2, @Nullable Integer num) {
        this.freeCount = i2;
        this.newno = str;
        this.privilegeId = str2;
        this.serverTime = num;
    }
}
