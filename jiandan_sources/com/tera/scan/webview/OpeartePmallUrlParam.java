package com.tera.scan.webview;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class OpeartePmallUrlParam implements Parcelable {
    public static final Parcelable.Creator<OpeartePmallUrlParam> CREATOR = new qw();
    @SerializedName("page")
    public String page;
    @SerializedName("url")
    public String url;

    public class qw implements Parcelable.Creator<OpeartePmallUrlParam> {
        /* renamed from: ad */
        public OpeartePmallUrlParam[] newArray(int i2) {
            return new OpeartePmallUrlParam[i2];
        }

        /* renamed from: qw */
        public OpeartePmallUrlParam createFromParcel(Parcel parcel) {
            return new OpeartePmallUrlParam(parcel);
        }
    }

    public OpeartePmallUrlParam(Parcel parcel) {
        this.url = parcel.readString();
        this.page = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String getPage() {
        return this.page;
    }

    public String getUrl() {
        return this.url;
    }

    public void setPage(String str) {
        this.page = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.url);
        parcel.writeString(this.page);
    }
}
