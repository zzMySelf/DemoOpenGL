package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import org.json.JSONException;
import org.json.JSONObject;

public class NotifyCustomerMsg extends NotifyMsg implements Parcelable, NoProGuard {
    public static final Parcelable.Creator<NotifyCustomerMsg> CREATOR = new Parcelable.Creator<NotifyCustomerMsg>() {
        public NotifyCustomerMsg createFromParcel(Parcel in) {
            return new NotifyCustomerMsg(in);
        }

        public NotifyCustomerMsg[] newArray(int size) {
            return new NotifyCustomerMsg[size];
        }
    };
    private long csuid = -1;
    private String text = "";

    public NotifyCustomerMsg(int cmdtype) {
        setNotifyCmd(cmdtype);
    }

    public NotifyCustomerMsg(Parcel in) {
        super(in);
        this.csuid = in.readLong();
        this.text = in.readString();
    }

    public long getCsUid() {
        return this.csuid;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String txt) {
        this.text = txt;
    }

    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeLong(this.csuid);
        dest.writeString(this.text);
    }

    public boolean parseJsonString() {
        try {
            JSONObject object = new JSONObject(getJsonContent());
            this.csuid = (long) object.getInt("cs_uid");
            this.text = object.getString("text");
            return true;
        } catch (JSONException e2) {
            LogUtils.e(LogUtils.TAG, "parseJsonString", e2);
            return false;
        }
    }
}
