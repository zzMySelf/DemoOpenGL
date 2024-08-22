package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class MediaObject implements Parcelable, Serializable {
    public static final Parcelable.Creator<MediaObject> CREATOR = new Parcelable.Creator<MediaObject>() {
        public MediaObject createFromParcel(Parcel parcel) {
            return new MediaObject(parcel);
        }

        public MediaObject[] newArray(int i2) {
            return new MediaObject[i2];
        }
    };
    private static final long serialVersionUID = -5562495969515901397L;
    public String actionUrl;
    public String description;
    public String identify;
    public String schema;
    public byte[] thumbData;
    public String title;

    public MediaObject() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.actionUrl);
        parcel.writeString(this.schema);
        parcel.writeString(this.identify);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeByteArray(this.thumbData);
    }

    public MediaObject(Parcel parcel) {
        this.actionUrl = parcel.readString();
        this.schema = parcel.readString();
        this.identify = parcel.readString();
        this.title = parcel.readString();
        this.description = parcel.readString();
        this.thumbData = parcel.createByteArray();
    }
}
