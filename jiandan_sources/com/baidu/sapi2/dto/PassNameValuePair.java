package com.baidu.sapi2.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class PassNameValuePair implements Parcelable {
    public static final Parcelable.Creator<PassNameValuePair> CREATOR = new Parcelable.Creator<PassNameValuePair>() {
        public PassNameValuePair createFromParcel(Parcel parcel) {
            return new PassNameValuePair(parcel);
        }

        public PassNameValuePair[] newArray(int i2) {
            return new PassNameValuePair[i2];
        }
    };
    public String name;
    public String value;

    public PassNameValuePair(String str, String str2) {
        this.name = str;
        this.value = str2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PassNameValuePair.class != obj.getClass()) {
            return false;
        }
        PassNameValuePair passNameValuePair = (PassNameValuePair) obj;
        String str = this.name;
        if (str == null ? passNameValuePair.name != null : !str.equals(passNameValuePair.name)) {
            return false;
        }
        String str2 = this.value;
        String str3 = passNameValuePair.value;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
        return false;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        String str = this.name;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.value;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.name);
        parcel.writeString(this.value);
    }

    public PassNameValuePair(Parcel parcel) {
        this.name = parcel.readString();
        this.value = parcel.readString();
    }
}
