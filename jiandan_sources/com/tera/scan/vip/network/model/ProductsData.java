package com.tera.scan.vip.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bHÖ\u0001R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/tera/scan/vip/network/model/ProductsData;", "Landroid/os/Parcelable;", "()V", "productList", "", "Lcom/tera/scan/vip/network/model/ProductInfo;", "getProductList", "()Ljava/util/List;", "setProductList", "(Ljava/util/List;)V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "lib_vip_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductsData implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<ProductsData> CREATOR = new qw();
    @SerializedName("product_list")
    @Nullable
    public List<ProductInfo> productList;

    public static final class qw implements Parcelable.Creator<ProductsData> {
        @NotNull
        /* renamed from: ad */
        public final ProductsData[] newArray(int i2) {
            return new ProductsData[i2];
        }

        @NotNull
        /* renamed from: qw */
        public final ProductsData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.readInt();
            return new ProductsData();
        }
    }

    public int describeContents() {
        return 0;
    }

    @Nullable
    public final List<ProductInfo> getProductList() {
        return this.productList;
    }

    public final void setProductList(@Nullable List<ProductInfo> list) {
        this.productList = list;
    }

    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(1);
    }
}
