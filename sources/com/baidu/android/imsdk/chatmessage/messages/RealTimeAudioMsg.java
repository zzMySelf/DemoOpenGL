package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.NoProGuard;

public class RealTimeAudioMsg extends RealTimeMsg implements Parcelable, NoProGuard {
    public static final Parcelable.Creator<RealTimeAudioMsg> CREATOR = new Parcelable.Creator<RealTimeAudioMsg>() {
        public RealTimeAudioMsg createFromParcel(Parcel in) {
            return new RealTimeAudioMsg(in);
        }

        public RealTimeAudioMsg[] newArray(int size) {
            return new RealTimeAudioMsg[size];
        }
    };

    public RealTimeAudioMsg() {
        setMsgType(5);
    }

    private RealTimeAudioMsg(Parcel in) {
        super(in);
    }

    public String getRecommendDescription() {
        return "[实时语音]";
    }
}
