package com.baidu.searchbox.common.security;

import android.os.Parcel;
import android.os.Parcelable;

public class DeviceIdBag implements Parcelable {
    public static final int CODE_BACKGROUD = -1;
    public static final int CODE_CACHE = 1;
    public static final int CODE_CACHE_EMPTY = 2;
    public static final int CODE_NORMAL = 0;
    public static final int CODE_PRIVACY_DISAGREE = -3;
    public static final int CODE_REFUSE = -2;
    public static final int CODE_SYNC_MAPPING = 3;
    public static final Parcelable.Creator<DeviceIdBag> CREATOR = new qw();
    public String deviceId;
    public String encodedDeviceId;
    public int errorCode;

    public class qw implements Parcelable.Creator<DeviceIdBag> {
        /* renamed from: ad */
        public DeviceIdBag[] newArray(int i2) {
            return new DeviceIdBag[i2];
        }

        /* renamed from: qw */
        public DeviceIdBag createFromParcel(Parcel parcel) {
            return new DeviceIdBag(parcel);
        }
    }

    public DeviceIdBag() {
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "DeviceIdBag[" + this.deviceId + "--" + this.errorCode + "]";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.deviceId);
        parcel.writeInt(this.errorCode);
        parcel.writeString(this.encodedDeviceId);
    }

    public DeviceIdBag(Parcel parcel) {
        this.deviceId = parcel.readString();
        this.errorCode = parcel.readInt();
        this.encodedDeviceId = parcel.readString();
    }
}
