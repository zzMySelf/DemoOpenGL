package com.baidu.mapapi.search.geocode;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;

public class GeoCodeResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<GeoCodeResult> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private LatLng f14541a;

    /* renamed from: b  reason: collision with root package name */
    private String f14542b;

    /* renamed from: c  reason: collision with root package name */
    private int f14543c;

    /* renamed from: d  reason: collision with root package name */
    private int f14544d;

    /* renamed from: e  reason: collision with root package name */
    private String f14545e;

    public GeoCodeResult() {
    }

    protected GeoCodeResult(Parcel parcel) {
        this.f14541a = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.f14542b = parcel.readString();
        this.f14543c = parcel.readInt();
        this.f14544d = parcel.readInt();
        this.f14545e = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    @Deprecated
    public String getAddress() {
        return this.f14542b;
    }

    public int getConfidence() {
        return this.f14544d;
    }

    public String getLevel() {
        return this.f14545e;
    }

    public LatLng getLocation() {
        return this.f14541a;
    }

    public int getPrecise() {
        return this.f14543c;
    }

    @Deprecated
    public void setAddress(String str) {
        this.f14542b = str;
    }

    public void setConfidence(int i2) {
        this.f14544d = i2;
    }

    public void setLevel(String str) {
        this.f14545e = str;
    }

    public void setLocation(LatLng latLng) {
        this.f14541a = latLng;
    }

    public void setPrecise(int i2) {
        this.f14543c = i2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("GeoCodeResult: \n");
        stringBuffer.append("location = ").append(this.f14541a);
        stringBuffer.append("; precise = ").append(this.f14543c);
        stringBuffer.append("; confidence = ").append(this.f14544d);
        stringBuffer.append("; level = ").append(this.f14545e);
        return stringBuffer.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeValue(this.f14541a);
        parcel.writeString(this.f14542b);
        parcel.writeInt(this.f14543c);
        parcel.writeInt(this.f14544d);
        parcel.writeString(this.f14545e);
    }
}
