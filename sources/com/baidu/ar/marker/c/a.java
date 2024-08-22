package com.baidu.ar.marker.c;

import android.os.Parcel;
import android.os.Parcelable;

public class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0169a();

    /* renamed from: a  reason: collision with root package name */
    public int f9902a;

    /* renamed from: b  reason: collision with root package name */
    public String f9903b;

    /* renamed from: c  reason: collision with root package name */
    public String f9904c;

    /* renamed from: d  reason: collision with root package name */
    public String f9905d;

    /* renamed from: e  reason: collision with root package name */
    public double[] f9906e;

    /* renamed from: f  reason: collision with root package name */
    public String f9907f;

    /* renamed from: g  reason: collision with root package name */
    public float f9908g;

    /* renamed from: h  reason: collision with root package name */
    public float f9909h;

    /* renamed from: i  reason: collision with root package name */
    public int f9910i;

    /* renamed from: j  reason: collision with root package name */
    public String f9911j;

    /* renamed from: com.baidu.ar.marker.c.a$a  reason: collision with other inner class name */
    static class C0169a implements Parcelable.Creator<a> {
        C0169a() {
        }

        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        /* renamed from: a */
        public a[] newArray(int i2) {
            return new a[i2];
        }
    }

    protected a(Parcel parcel) {
        this.f9903b = parcel.readString();
        this.f9904c = parcel.readString();
        this.f9905d = parcel.readString();
        this.f9906e = parcel.createDoubleArray();
        this.f9907f = parcel.readString();
        this.f9908g = parcel.readFloat();
        this.f9909h = parcel.readFloat();
        this.f9910i = parcel.readInt();
        this.f9902a = parcel.readInt();
        this.f9911j = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f9903b);
        parcel.writeString(this.f9904c);
        parcel.writeString(this.f9905d);
        parcel.writeDoubleArray(this.f9906e);
        parcel.writeString(this.f9907f);
        parcel.writeFloat(this.f9908g);
        parcel.writeFloat(this.f9909h);
        parcel.writeInt(this.f9910i);
        parcel.writeInt(this.f9902a);
        parcel.writeString(this.f9911j);
    }
}
