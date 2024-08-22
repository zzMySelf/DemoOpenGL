package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;

public class BDMapCustomMsg extends NormalMsg {
    public static final Parcelable.Creator<BDMapCustomMsg> CREATOR = new Parcelable.Creator<BDMapCustomMsg>() {
        public BDMapCustomMsg createFromParcel(Parcel in) {
            return new BDMapCustomMsg(in);
        }

        public BDMapCustomMsg[] newArray(int size) {
            return new BDMapCustomMsg[size];
        }
    };

    public BDMapCustomMsg() {
        setMsgType(101);
    }

    private BDMapCustomMsg(Parcel in) {
        super(in);
    }

    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
    }

    /* access modifiers changed from: protected */
    public boolean parseJsonString() {
        return true;
    }

    public String getRecommendDescription() {
        return "[自定义消息]";
    }
}
