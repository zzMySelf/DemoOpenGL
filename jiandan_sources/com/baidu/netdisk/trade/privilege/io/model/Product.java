package com.baidu.netdisk.trade.privilege.io.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001Ba\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b6\u00107J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\n\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u000b\u0010\tJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J|\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b#\u0010\u001dJ\u0010\u0010$\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b$\u0010\u0004J \u0010)\u001a\u00020(2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b)\u0010*R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010+\u001a\u0004\b,\u0010\u0004R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010+\u001a\u0004\b-\u0010\u0004R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010.\u001a\u0004\b/\u0010\tR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010.\u001a\u0004\b0\u0010\tR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u00101\u001a\u0004\b\u0018\u0010\u000fR\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010+\u001a\u0004\b2\u0010\u0004R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010+\u001a\u0004\b3\u0010\u0004R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010.\u001a\u0004\b4\u0010\tR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010+\u001a\u0004\b5\u0010\u0004¨\u00068"}, d2 = {"Lcom/baidu/netdisk/trade/privilege/io/model/Product;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()Ljava/lang/Long;", "component5", "component6", "component7", "", "component8", "()Ljava/lang/Integer;", "component9", "cluster", "detailCluster", "productType", "expiredTime", "startTime", "endTime", "productName", "isAutoUpgradeToSVip", "svipType", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/baidu/netdisk/trade/privilege/io/model/Product;", "describeContents", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getCluster", "getDetailCluster", "Ljava/lang/Long;", "getEndTime", "getExpiredTime", "Ljava/lang/Integer;", "getProductName", "getProductType", "getStartTime", "getSvipType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "TradeMemberPrivilege_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class Product implements Parcelable {
    public static final Parcelable.Creator CREATOR = new qw();
    @SerializedName("cluster")
    @Nullable

    /* renamed from: _  reason: collision with root package name */
    public final String f922_;
    @SerializedName("detail_cluster")
    @Nullable
    public final String __;
    @SerializedName("product_type")
    @Nullable
    public final String ___;
    @SerializedName("expired_time")
    @Nullable
    public final Long ____;
    @SerializedName("start_time")
    @Nullable
    public final Long _____;
    @SerializedName("end_time")
    @Nullable
    public final Long ______;
    @SerializedName("product_name")
    @Nullable
    public final String a;
    @SerializedName("auto_upgrade_to_svip")
    @Nullable
    public final Integer b;
    @SerializedName("cur_svip_type")
    @Nullable
    public final String c;

    public static class qw implements Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new Product(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readString(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readString());
        }

        @NotNull
        public final Object[] newArray(int i2) {
            return new Product[i2];
        }
    }

    public Product(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Long l, @Nullable Long l2, @Nullable Long l3, @Nullable String str4, @Nullable Integer num, @Nullable String str5) {
        this.f922_ = str;
        this.__ = str2;
        this.___ = str3;
        this.____ = l;
        this._____ = l2;
        this.______ = l3;
        this.a = str4;
        this.b = num;
        this.c = str5;
    }

    @Nullable
    public final String _() {
        return this.f922_;
    }

    @Nullable
    public final String __() {
        return this.__;
    }

    @Nullable
    public final Long ___() {
        return this.______;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Product)) {
            return false;
        }
        Product product = (Product) obj;
        return Intrinsics.areEqual((Object) this.f922_, (Object) product.f922_) && Intrinsics.areEqual((Object) this.__, (Object) product.__) && Intrinsics.areEqual((Object) this.___, (Object) product.___) && Intrinsics.areEqual((Object) this.____, (Object) product.____) && Intrinsics.areEqual((Object) this._____, (Object) product._____) && Intrinsics.areEqual((Object) this.______, (Object) product.______) && Intrinsics.areEqual((Object) this.a, (Object) product.a) && Intrinsics.areEqual((Object) this.b, (Object) product.b) && Intrinsics.areEqual((Object) this.c, (Object) product.c);
    }

    public int hashCode() {
        String str = this.f922_;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.__;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.___;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Long l = this.____;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this._____;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.______;
        int hashCode6 = (hashCode5 + (l3 != null ? l3.hashCode() : 0)) * 31;
        String str4 = this.a;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Integer num = this.b;
        int hashCode8 = (hashCode7 + (num != null ? num.hashCode() : 0)) * 31;
        String str5 = this.c;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode8 + i2;
    }

    @NotNull
    public String toString() {
        return "Product(cluster=" + this.f922_ + ", detailCluster=" + this.__ + ", productType=" + this.___ + ", expiredTime=" + this.____ + ", startTime=" + this._____ + ", endTime=" + this.______ + ", productName=" + this.a + ", isAutoUpgradeToSVip=" + this.b + ", svipType=" + this.c + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.f922_);
        parcel.writeString(this.__);
        parcel.writeString(this.___);
        Long l = this.____;
        if (l != null) {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        } else {
            parcel.writeInt(0);
        }
        Long l2 = this._____;
        if (l2 != null) {
            parcel.writeInt(1);
            parcel.writeLong(l2.longValue());
        } else {
            parcel.writeInt(0);
        }
        Long l3 = this.______;
        if (l3 != null) {
            parcel.writeInt(1);
            parcel.writeLong(l3.longValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.a);
        Integer num = this.b;
        if (num != null) {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.c);
    }
}
