package com.tera.scan.vip.network.model;

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

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/tera/scan/vip/network/model/RightsInfoData;", "Landroid/os/Parcelable;", "title", "", "listIconUrl", "subCardList", "", "Lcom/tera/scan/vip/network/model/PrivilegeInfoData;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getListIconUrl", "()Ljava/lang/String;", "getSubCardList", "()Ljava/util/List;", "getTitle", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "lib_vip_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RightsInfoData implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<RightsInfoData> CREATOR = new qw();
    @SerializedName("list_icon")
    @Nullable
    public final String listIconUrl;
    @SerializedName("list")
    @Nullable
    public final List<PrivilegeInfoData> subCardList;
    @SerializedName("title")
    @Nullable
    public final String title;

    public static final class qw implements Parcelable.Creator<RightsInfoData> {
        @NotNull
        /* renamed from: ad */
        public final RightsInfoData[] newArray(int i2) {
            return new RightsInfoData[i2];
        }

        @NotNull
        /* renamed from: qw */
        public final RightsInfoData createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                for (int i2 = 0; i2 != readInt; i2++) {
                    arrayList2.add(PrivilegeInfoData.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new RightsInfoData(readString, readString2, arrayList);
        }
    }

    public RightsInfoData() {
        this((String) null, (String) null, (List) null, 7, (DefaultConstructorMarker) null);
    }

    public RightsInfoData(@Nullable String str, @Nullable String str2, @Nullable List<PrivilegeInfoData> list) {
        this.title = str;
        this.listIconUrl = str2;
        this.subCardList = list;
    }

    public static /* synthetic */ RightsInfoData copy$default(RightsInfoData rightsInfoData, String str, String str2, List<PrivilegeInfoData> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = rightsInfoData.title;
        }
        if ((i2 & 2) != 0) {
            str2 = rightsInfoData.listIconUrl;
        }
        if ((i2 & 4) != 0) {
            list = rightsInfoData.subCardList;
        }
        return rightsInfoData.copy(str, str2, list);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final String component2() {
        return this.listIconUrl;
    }

    @Nullable
    public final List<PrivilegeInfoData> component3() {
        return this.subCardList;
    }

    @NotNull
    public final RightsInfoData copy(@Nullable String str, @Nullable String str2, @Nullable List<PrivilegeInfoData> list) {
        return new RightsInfoData(str, str2, list);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RightsInfoData)) {
            return false;
        }
        RightsInfoData rightsInfoData = (RightsInfoData) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) rightsInfoData.title) && Intrinsics.areEqual((Object) this.listIconUrl, (Object) rightsInfoData.listIconUrl) && Intrinsics.areEqual((Object) this.subCardList, (Object) rightsInfoData.subCardList);
    }

    @Nullable
    public final String getListIconUrl() {
        return this.listIconUrl;
    }

    @Nullable
    public final List<PrivilegeInfoData> getSubCardList() {
        return this.subCardList;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int i2 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.listIconUrl;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<PrivilegeInfoData> list = this.subCardList;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode2 + i2;
    }

    @NotNull
    public String toString() {
        return "RightsInfoData(title=" + this.title + ", listIconUrl=" + this.listIconUrl + ", subCardList=" + this.subCardList + ')';
    }

    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
        parcel.writeString(this.listIconUrl);
        List<PrivilegeInfoData> list = this.subCardList;
        if (list == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(list.size());
        for (PrivilegeInfoData writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, i2);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RightsInfoData(String str, String str2, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : list);
    }
}
