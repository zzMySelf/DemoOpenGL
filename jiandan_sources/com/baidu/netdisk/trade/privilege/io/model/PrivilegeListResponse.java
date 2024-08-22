package com.baidu.netdisk.trade.privilege.io.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\"\u0010\b\u001a\u00020\u00002\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u001c\u0010\u0006¨\u0006\u001f"}, d2 = {"Lcom/baidu/netdisk/trade/privilege/io/model/PrivilegeListResponse;", "Landroid/os/Parcelable;", "Lcom/baidu/netdisk/trade/privilege/io/model/Response;", "", "Lcom/baidu/netdisk/trade/privilege/io/model/Privilege;", "component1", "()Ljava/util/List;", "privileges", "copy", "(Ljava/util/List;)Lcom/baidu/netdisk/trade/privilege/io/model/PrivilegeListResponse;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getPrivileges", "<init>", "(Ljava/util/List;)V", "TradeMemberPrivilege_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class PrivilegeListResponse extends Response implements Parcelable {
    public static final Parcelable.Creator CREATOR = new qw();
    @SerializedName("privilege_list")
    @Nullable
    public final List<Privilege> privileges;

    public static class qw implements Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((Privilege) Privilege.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new PrivilegeListResponse(arrayList);
        }

        @NotNull
        public final Object[] newArray(int i2) {
            return new PrivilegeListResponse[i2];
        }
    }

    public PrivilegeListResponse() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PrivilegeListResponse(List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : list);
    }

    public static /* synthetic */ PrivilegeListResponse copy$default(PrivilegeListResponse privilegeListResponse, List<Privilege> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = privilegeListResponse.privileges;
        }
        return privilegeListResponse.copy(list);
    }

    @Nullable
    public final List<Privilege> component1() {
        return this.privileges;
    }

    @NotNull
    public final PrivilegeListResponse copy(@Nullable List<Privilege> list) {
        return new PrivilegeListResponse(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof PrivilegeListResponse) && Intrinsics.areEqual((Object) this.privileges, (Object) ((PrivilegeListResponse) obj).privileges);
        }
        return true;
    }

    @Nullable
    public final List<Privilege> getPrivileges() {
        return this.privileges;
    }

    public int hashCode() {
        List<Privilege> list = this.privileges;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return "PrivilegeListResponse(privileges=" + this.privileges + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        List<Privilege> list = this.privileges;
        if (list != null) {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (Privilege writeToParcel : list) {
                writeToParcel.writeToParcel(parcel, 0);
            }
            return;
        }
        parcel.writeInt(0);
    }

    public PrivilegeListResponse(@Nullable List<Privilege> list) {
        this.privileges = list;
    }
}
