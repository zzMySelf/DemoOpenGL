package com.tera.scan.network.account.io.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tera.scan.network.network.exception.RemoteExceptionInfo;

public class ServerBanInfo implements RemoteExceptionInfo {
    public static final Parcelable.Creator<ServerBanInfo> CREATOR = new qw();
    public static final String TAG = "ServerBanInfo";
    public int banCode;
    public String banMsg;

    public class qw implements Parcelable.Creator<ServerBanInfo> {
        /* renamed from: ad */
        public ServerBanInfo[] newArray(int i2) {
            return new ServerBanInfo[i2];
        }

        /* renamed from: qw */
        public ServerBanInfo createFromParcel(Parcel parcel) {
            return new ServerBanInfo(parcel, (qw) null);
        }
    }

    public /* synthetic */ ServerBanInfo(Parcel parcel, qw qwVar) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ServerBanInfo[banCode=" + this.banCode + ", banMsg=" + this.banMsg + "]";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.banCode);
        parcel.writeString(this.banMsg);
    }

    public ServerBanInfo(int i2, String str) {
        this.banCode = 0;
        this.banCode = i2;
        this.banMsg = str;
    }

    public ServerBanInfo(Parcel parcel) {
        this.banCode = 0;
        this.banCode = parcel.readInt();
        this.banMsg = parcel.readString();
    }
}
