package com.baidu.android.imsdk.chatmessage.messages.body;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class ButtonBody implements Parcelable {
    public static final Parcelable.Creator<ButtonBody> CREATOR = new Parcelable.Creator<ButtonBody>() {
        public ButtonBody createFromParcel(Parcel in) {
            return new ButtonBody(in);
        }

        public ButtonBody[] newArray(int size) {
            return new ButtonBody[size];
        }
    };
    public String label;
    public String url;

    public ButtonBody() {
    }

    protected ButtonBody(Parcel in) {
        this.label = in.readString();
        this.url = in.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.label);
        dest.writeString(this.url);
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.label) && !TextUtils.isEmpty(this.url);
    }
}
