package com.baidu.sofire.core;

import android.os.Parcel;
import android.os.Parcelable;

public class CallArgs implements Parcelable {
    public static final Parcelable.Creator<CallArgs> CREATOR = new a();
    public int a;
    public int b;
    public String c;
    public Object[] d;
    public Object[] e;
    public Object f;

    public class a implements Parcelable.Creator<CallArgs> {
        public Object createFromParcel(Parcel parcel) {
            return new CallArgs(parcel);
        }

        public Object[] newArray(int i2) {
            return new CallArgs[i2];
        }
    }

    public CallArgs() {
    }

    public void a(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readString();
        this.e = parcel.readArray(CallArgs.class.getClassLoader());
        this.d = parcel.readArray(CallArgs.class.getClassLoader());
        this.f = parcel.readValue(CallArgs.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeString(this.c);
        parcel.writeArray(this.e);
        parcel.writeArray(this.d);
        parcel.writeValue(this.f);
    }

    public CallArgs(Parcel parcel) {
        a(parcel);
    }
}
