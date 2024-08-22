package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import org.json.JSONException;
import org.json.JSONObject;

public class GroupMemberJoinMsg extends NotifyMsg implements Parcelable, NoProGuard {
    public static final Parcelable.Creator<GroupMemberJoinMsg> CREATOR = new Parcelable.Creator<GroupMemberJoinMsg>() {
        public GroupMemberJoinMsg createFromParcel(Parcel in) {
            return new GroupMemberJoinMsg(in);
        }

        public GroupMemberJoinMsg[] newArray(int size) {
            return new GroupMemberJoinMsg[size];
        }
    };
    private int groupnum;
    private long mMemberVersion = 0;
    private String memberbuid;

    public GroupMemberJoinMsg() {
        setMsgType(1002);
    }

    public GroupMemberJoinMsg(Parcel in) {
        super(in);
        this.memberbuid = in.readString();
        this.groupnum = in.readInt();
        this.mMemberVersion = in.readLong();
    }

    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.memberbuid);
        dest.writeInt(this.groupnum);
        dest.writeLong(this.mMemberVersion);
    }

    /* access modifiers changed from: protected */
    public boolean parseJsonString() {
        try {
            JSONObject object = new JSONObject(getMsgContent());
            this.groupnum = object.optInt("group_num");
            this.memberbuid = String.valueOf(object.optLong("member"));
            this.mMemberVersion = object.optLong("member_version");
            return true;
        } catch (JSONException e2) {
            LogUtils.e(LogUtils.TAG, "parseJsonString", e2);
            return false;
        }
    }

    public int getGroupnum() {
        return this.groupnum;
    }

    public String getMemberBuid() {
        return this.memberbuid;
    }

    public long getMemberVersion() {
        return this.mMemberVersion;
    }

    public String getRecommendDescription() {
        return "你收到了一条系统消息";
    }
}
