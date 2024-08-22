package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class SettingRemindMsg extends NormalMsg {
    public static final Parcelable.Creator<SettingRemindMsg> CREATOR = new Parcelable.Creator<SettingRemindMsg>() {
        public SettingRemindMsg createFromParcel(Parcel in) {
            return new SettingRemindMsg(in);
        }

        public SettingRemindMsg[] newArray(int size) {
            return new SettingRemindMsg[size];
        }
    };
    public static final String PAGE_SYMBOL = "msg_setting_page";
    public static final char SEARCH_SYMBOL = '#';
    private String mContent;
    private String mPage;

    public SettingRemindMsg(Parcel in) {
        super(in);
        this.mContent = in.readString();
        this.mPage = in.readString();
    }

    public SettingRemindMsg() {
        setMsgType(36);
    }

    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.mContent);
        dest.writeString(this.mPage);
    }

    /* access modifiers changed from: protected */
    public boolean parseJsonString() {
        String content = getJsonContent();
        if (TextUtils.isEmpty(content)) {
            return false;
        }
        try {
            JSONObject json = new JSONObject(content);
            this.mContent = json.optString("text");
            this.mPage = json.optString("page");
            return true;
        } catch (JSONException e2) {
            LogUtils.e("TextMsg", "parse json err!", e2);
            return false;
        }
    }

    public String getText() {
        return this.mContent;
    }

    public String getPage() {
        return this.mPage;
    }

    public String getRecommendDescription() {
        return null;
    }
}
