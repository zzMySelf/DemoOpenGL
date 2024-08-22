package com.tera.scan.vip.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010,\u001a\u00020\u0013HÖ\u0001J\u0006\u0010-\u001a\u00020\u0013J\u0019\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0013HÖ\u0001R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\"\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010#\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010\u000fR\"\u0010&\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b'\u0010\u0015\"\u0004\b(\u0010\u0017R \u0010)\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\r\"\u0004\b+\u0010\u000f¨\u00063"}, d2 = {"Lcom/tera/scan/vip/network/model/ProductInfo;", "Landroid/os/Parcelable;", "()V", "canAutoRenew", "", "getCanAutoRenew", "()Ljava/lang/Boolean;", "setCanAutoRenew", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "currency", "", "getCurrency", "()Ljava/lang/String;", "setCurrency", "(Ljava/lang/String;)V", "isRecommend", "setRecommend", "originPrice", "", "getOriginPrice", "()Ljava/lang/Integer;", "setOriginPrice", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "price", "getPrice", "setPrice", "productId", "", "getProductId", "()Ljava/lang/Long;", "setProductId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "productName", "getProductName", "setProductName", "renewPrice", "getRenewPrice", "setRenewPrice", "thirdProductId", "getThirdProductId", "setThirdProductId", "describeContents", "getSavePercentage", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "lib_vip_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductInfo implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<ProductInfo> CREATOR = new qw();
    @SerializedName("can_auto_renew")
    @Nullable
    public Boolean canAutoRenew;
    @SerializedName("currency")
    @Nullable
    public String currency;
    @SerializedName("is_recommend")
    @Nullable
    public Boolean isRecommend;
    @SerializedName("origin_price")
    @Nullable
    public Integer originPrice;
    @SerializedName("price")
    @Nullable
    public Integer price;
    @SerializedName("product_id")
    @Nullable
    public Long productId;
    @SerializedName("product_name")
    @Nullable
    public String productName;
    @SerializedName("renew_price")
    @Nullable
    public Integer renewPrice;
    @SerializedName("third_product_id")
    @Nullable
    public String thirdProductId;

    public static final class qw implements Parcelable.Creator<ProductInfo> {
        @NotNull
        /* renamed from: ad */
        public final ProductInfo[] newArray(int i2) {
            return new ProductInfo[i2];
        }

        @NotNull
        /* renamed from: qw */
        public final ProductInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.readInt();
            return new ProductInfo();
        }
    }

    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Boolean getCanAutoRenew() {
        return this.canAutoRenew;
    }

    @Nullable
    public final String getCurrency() {
        return this.currency;
    }

    @Nullable
    public final Integer getOriginPrice() {
        return this.originPrice;
    }

    @Nullable
    public final Integer getPrice() {
        return this.price;
    }

    @Nullable
    public final Long getProductId() {
        return this.productId;
    }

    @Nullable
    public final String getProductName() {
        return this.productName;
    }

    @Nullable
    public final Integer getRenewPrice() {
        return this.renewPrice;
    }

    public final int getSavePercentage() {
        Integer num = this.originPrice;
        double intValue = num != null ? (double) num.intValue() : 0.0d;
        Integer num2 = this.price;
        double intValue2 = num2 != null ? (double) num2.intValue() : 0.0d;
        if (intValue == 0.0d) {
            return 0;
        }
        return (int) (((intValue - intValue2) / intValue) * ((double) 100));
    }

    @Nullable
    public final String getThirdProductId() {
        return this.thirdProductId;
    }

    @Nullable
    public final Boolean isRecommend() {
        return this.isRecommend;
    }

    public final void setCanAutoRenew(@Nullable Boolean bool) {
        this.canAutoRenew = bool;
    }

    public final void setCurrency(@Nullable String str) {
        this.currency = str;
    }

    public final void setOriginPrice(@Nullable Integer num) {
        this.originPrice = num;
    }

    public final void setPrice(@Nullable Integer num) {
        this.price = num;
    }

    public final void setProductId(@Nullable Long l) {
        this.productId = l;
    }

    public final void setProductName(@Nullable String str) {
        this.productName = str;
    }

    public final void setRecommend(@Nullable Boolean bool) {
        this.isRecommend = bool;
    }

    public final void setRenewPrice(@Nullable Integer num) {
        this.renewPrice = num;
    }

    public final void setThirdProductId(@Nullable String str) {
        this.thirdProductId = str;
    }

    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(1);
    }
}
