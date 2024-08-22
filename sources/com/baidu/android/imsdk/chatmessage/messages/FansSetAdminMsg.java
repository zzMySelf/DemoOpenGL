package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import com.baidu.android.imsdk.utils.Utility;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FansSetAdminMsg extends NotifyMsg implements Parcelable, NoProGuard {
    public static final Parcelable.Creator<FansSetAdminMsg> CREATOR = new Parcelable.Creator<FansSetAdminMsg>() {
        public FansSetAdminMsg createFromParcel(Parcel in) {
            return new FansSetAdminMsg(in);
        }

        public FansSetAdminMsg[] newArray(int size) {
            return new FansSetAdminMsg[size];
        }
    };
    private List<String> mBduids;
    private int mGroupNum;
    private long mGroupVersion;
    private long mMemberVersion;
    private long mOperator;
    private String mRoleDisplayName;

    public FansSetAdminMsg() {
        setMsgType(1015);
    }

    public FansSetAdminMsg(Parcel in) {
        super(in);
        this.mOperator = in.readLong();
        this.mMemberVersion = in.readLong();
        ArrayList arrayList = new ArrayList();
        this.mBduids = arrayList;
        in.readList(arrayList, String.class.getClassLoader());
        this.mRoleDisplayName = in.readString();
        this.mGroupNum = in.readInt();
        this.mGroupVersion = in.readLong();
    }

    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeLong(this.mOperator);
        dest.writeLong(this.mMemberVersion);
        dest.writeList(this.mBduids);
        dest.writeString(this.mRoleDisplayName);
        dest.writeInt(this.mGroupNum);
        dest.writeLong(this.mGroupVersion);
    }

    /* access modifiers changed from: protected */
    public boolean parseJsonString() {
        try {
            JSONObject object = new JSONObject(getMsgContent());
            this.mOperator = Utility.getLongByString(Utility.transBDUK(object.optString("operator")), 0);
            this.mMemberVersion = object.optLong("member_version");
            this.mGroupNum = object.optInt("group_num");
            JSONArray bduks = object.optJSONArray("member");
            if (bduks != null && bduks.length() > 0) {
                this.mBduids = new ArrayList();
                for (int i2 = 0; i2 < bduks.length(); i2++) {
                    this.mBduids.add(Utility.transBDUK(bduks.getString(i2)));
                }
            }
            this.mRoleDisplayName = object.optString(DBTableDefine.GroupMemberColumns.COLUMN_ROLE_DISPLAY_NAME);
            this.mGroupVersion = object.optLong("group_version");
            return true;
        } catch (JSONException e2) {
            LogUtils.e(LogUtils.TAG, "parseJsonString", e2);
            return false;
        }
    }

    public long getOperator() {
        return this.mOperator;
    }

    public long getMemberVersion() {
        return this.mMemberVersion;
    }

    public List<String> getBduids() {
        return this.mBduids;
    }

    public int getGroupNum() {
        return this.mGroupNum;
    }

    public String getRoleDisplayName() {
        return this.mRoleDisplayName;
    }

    public long getGroupVersion() {
        return this.mGroupVersion;
    }

    public String getRecommendDescription() {
        return "你收到了一条系统消息";
    }
}
