package com.baidu.mapapi.map;

import android.os.Parcel;
import android.os.Parcelable;

class g implements Parcelable.Creator<BaiduMapOptions> {
    g() {
    }

    /* renamed from: a */
    public BaiduMapOptions createFromParcel(Parcel parcel) {
        return new BaiduMapOptions(parcel);
    }

    /* renamed from: a */
    public BaiduMapOptions[] newArray(int i2) {
        return new BaiduMapOptions[i2];
    }
}
