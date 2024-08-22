package com.baidu.netdisk.account.io.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.chatsearch.aisearch.resultpage.toolbar.discovery.span.RhetoricalTagUtilKt;
import com.google.gson.annotations.SerializedName;

public class ProductInfo implements Parcelable {
    public static final Parcelable.Creator<ProductInfo> CREATOR = new Parcelable.Creator<ProductInfo>() {
        public ProductInfo[] newArray(int size) {
            return new ProductInfo[size];
        }

        public ProductInfo createFromParcel(Parcel source) {
            return new ProductInfo(source);
        }
    };
    private static final String TAG = "ProductInfo";
    @SerializedName("cluster")
    public String cluster;
    @SerializedName("detail_cluster")
    public String detailCluster;
    @SerializedName("end_time")
    public long endTime;
    @SerializedName("auto_upgrade_to_svip")
    public int isAutoUpgradeToSVip;
    @SerializedName("product_name")
    public String productName;
    @SerializedName("start_time")
    public long startTime;
    @SerializedName("cur_svip_type")
    public String svipType;

    public ProductInfo() {
    }

    public ProductInfo(Parcel parcel) {
        this.startTime = parcel.readLong();
        this.endTime = parcel.readLong();
        this.productName = parcel.readString();
        this.cluster = parcel.readString();
        this.detailCluster = parcel.readString();
        this.isAutoUpgradeToSVip = parcel.readInt();
        this.svipType = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        arg0.writeLong(this.startTime);
        arg0.writeLong(this.endTime);
        arg0.writeString(this.productName);
        arg0.writeString(this.cluster);
        arg0.writeString(this.detailCluster);
        arg0.writeInt(this.isAutoUpgradeToSVip);
        arg0.writeString(this.svipType);
    }

    public String toString() {
        return "ProductInfo[startTime=" + this.startTime + ", endTime=" + this.endTime + ", productName=" + this.productName + ", cluster= " + this.cluster + RhetoricalTagUtilKt.TAG_END_SYMBOL;
    }

    public String getSvipType() {
        return this.svipType;
    }
}
