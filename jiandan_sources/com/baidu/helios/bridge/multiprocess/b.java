package com.baidu.helios.bridge.multiprocess;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new qw();
    public IBinder a;

    public class qw implements Parcelable.Creator<b> {
        /* renamed from: ad */
        public b[] newArray(int i2) {
            return new b[i2];
        }

        /* renamed from: qw */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }
    }

    public b(IBinder iBinder) {
        this.a = iBinder;
    }

    public b(Parcel parcel) {
        this.a = parcel.readStrongBinder();
    }

    public IBinder a() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeStrongBinder(this.a);
    }
}
