package com.baidu.netdisk.cloudfile.io.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.sdk.m.u.i;
import com.baidu.netdisk.network.response.Response;

public class InfoResponse extends Response implements Parcelable {
    public static final Parcelable.Creator<InfoResponse> CREATOR = new Parcelable.Creator<InfoResponse>() {
        public InfoResponse[] newArray(int size) {
            return new InfoResponse[size];
        }

        public InfoResponse createFromParcel(Parcel source) {
            return new InfoResponse(source);
        }
    };
    public String path;

    public InfoResponse() {
    }

    public int describeContents() {
        return 0;
    }

    public InfoResponse(Parcel source) {
        this.errno = source.readInt();
        this.path = source.readString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.errno);
        dest.writeString(this.path);
    }

    public String toString() {
        return "{'errno':" + this.errno + ", 'path':" + this.path + i.f2534d;
    }
}
