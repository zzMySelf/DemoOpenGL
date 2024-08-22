package com.tera.scan.vip.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\"\u001a\u00020\u0004HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0004HÖ\u0001R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR \u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\"\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR \u0010\u001f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000f¨\u0006("}, d2 = {"Lcom/tera/scan/vip/network/model/OrderInfo;", "Landroid/os/Parcelable;", "()V", "kind", "", "getKind", "()Ljava/lang/Integer;", "setKind", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "orderNo", "", "getOrderNo", "()Ljava/lang/String;", "setOrderNo", "(Ljava/lang/String;)V", "payStatus", "getPayStatus", "setPayStatus", "payTime", "getPayTime", "setPayTime", "price", "getPrice", "setPrice", "priceCurrency", "getPriceCurrency", "setPriceCurrency", "productId", "getProductId", "setProductId", "productName", "getProductName", "setProductName", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "lib_vip_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderInfo implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<OrderInfo> CREATOR = new qw();
    @SerializedName("kind")
    @Nullable
    public Integer kind;
    @SerializedName("order_no")
    @Nullable
    public String orderNo;
    @SerializedName("pay_status")
    @Nullable
    public Integer payStatus;
    @SerializedName("pay_time")
    @Nullable
    public Integer payTime;
    @SerializedName("price")
    @Nullable
    public Integer price;
    @SerializedName("price_currency")
    @Nullable
    public String priceCurrency;
    @SerializedName("product_id")
    @Nullable
    public Integer productId;
    @SerializedName("product_name")
    @Nullable
    public String productName;

    public static final class qw implements Parcelable.Creator<OrderInfo> {
        @NotNull
        /* renamed from: ad */
        public final OrderInfo[] newArray(int i2) {
            return new OrderInfo[i2];
        }

        @NotNull
        /* renamed from: qw */
        public final OrderInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.readInt();
            return new OrderInfo();
        }
    }

    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Integer getKind() {
        return this.kind;
    }

    @Nullable
    public final String getOrderNo() {
        return this.orderNo;
    }

    @Nullable
    public final Integer getPayStatus() {
        return this.payStatus;
    }

    @Nullable
    public final Integer getPayTime() {
        return this.payTime;
    }

    @Nullable
    public final Integer getPrice() {
        return this.price;
    }

    @Nullable
    public final String getPriceCurrency() {
        return this.priceCurrency;
    }

    @Nullable
    public final Integer getProductId() {
        return this.productId;
    }

    @Nullable
    public final String getProductName() {
        return this.productName;
    }

    public final void setKind(@Nullable Integer num) {
        this.kind = num;
    }

    public final void setOrderNo(@Nullable String str) {
        this.orderNo = str;
    }

    public final void setPayStatus(@Nullable Integer num) {
        this.payStatus = num;
    }

    public final void setPayTime(@Nullable Integer num) {
        this.payTime = num;
    }

    public final void setPrice(@Nullable Integer num) {
        this.price = num;
    }

    public final void setPriceCurrency(@Nullable String str) {
        this.priceCurrency = str;
    }

    public final void setProductId(@Nullable Integer num) {
        this.productId = num;
    }

    public final void setProductName(@Nullable String str) {
        this.productName = str;
    }

    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(1);
    }
}
