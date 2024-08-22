package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;

class f implements Parcelable.Creator<DrivingRouteResult> {
    f() {
    }

    /* renamed from: a */
    public DrivingRouteResult createFromParcel(Parcel parcel) {
        return new DrivingRouteResult(parcel);
    }

    /* renamed from: a */
    public DrivingRouteResult[] newArray(int i2) {
        return new DrivingRouteResult[i2];
    }
}
