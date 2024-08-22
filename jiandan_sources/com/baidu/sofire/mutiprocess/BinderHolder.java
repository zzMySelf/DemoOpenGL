package com.baidu.sofire.mutiprocess;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public class BinderHolder implements Parcelable {
    public static final Parcelable.Creator<BinderHolder> CREATOR = new a();
    public IBinder a;

    public class a implements Parcelable.Creator<BinderHolder> {
        public Object createFromParcel(Parcel parcel) {
            return new BinderHolder(parcel);
        }

        public Object[] newArray(int i2) {
            return new BinderHolder[i2];
        }
    }

    public BinderHolder(IBinder iBinder) {
        this.a = iBinder;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeStrongBinder(this.a);
    }

    public BinderHolder(Parcel parcel) {
        this.a = parcel.readStrongBinder();
    }
}
