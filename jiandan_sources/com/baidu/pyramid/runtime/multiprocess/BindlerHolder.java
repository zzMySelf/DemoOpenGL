package com.baidu.pyramid.runtime.multiprocess;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public class BindlerHolder implements Parcelable {
    public static final Parcelable.Creator<BindlerHolder> CREATOR = new qw();
    public IBinder mBinder;

    public class qw implements Parcelable.Creator<BindlerHolder> {
        /* renamed from: ad */
        public BindlerHolder[] newArray(int i2) {
            return new BindlerHolder[i2];
        }

        /* renamed from: qw */
        public BindlerHolder createFromParcel(Parcel parcel) {
            return new BindlerHolder(parcel);
        }
    }

    public BindlerHolder(IBinder iBinder) {
        this.mBinder = iBinder;
    }

    public int describeContents() {
        return 0;
    }

    public IBinder getBinder() {
        return this.mBinder;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeStrongBinder(this.mBinder);
    }

    public BindlerHolder(Parcel parcel) {
        this.mBinder = parcel.readStrongBinder();
    }
}
