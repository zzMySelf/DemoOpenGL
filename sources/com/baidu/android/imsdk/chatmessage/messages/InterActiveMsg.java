package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONObject;

public class InterActiveMsg extends NormalMsg {
    public static final Parcelable.Creator<InterActiveMsg> CREATOR = new Parcelable.Creator<InterActiveMsg>() {
        public InterActiveMsg createFromParcel(Parcel in) {
            return new InterActiveMsg(in);
        }

        public InterActiveMsg[] newArray(int size) {
            return new InterActiveMsg[size];
        }
    };
    public static final String TAG = "InterActiveMsg";
    private int mTemplate;

    public InterActiveMsg(Parcel in) {
        super(in);
        this.mTemplate = in.readInt();
    }

    public InterActiveMsg() {
        setMsgType(24);
    }

    /* access modifiers changed from: protected */
    public boolean parseJsonString() {
        try {
            this.mTemplate = new JSONObject(getJsonContent()).optInt("template");
            return true;
        } catch (Exception e2) {
            LogUtils.e(TAG, "parseJsonString JSONException", e2);
            return false;
        }
    }

    public int getTemplate() {
        return this.mTemplate;
    }

    public void setTemplate(int template) {
        this.mTemplate = template;
    }

    public String getRecommendDescription() {
        String desc = getLocalUrl();
        if (TextUtils.isEmpty(desc)) {
            return IMConstants.INTER_ACTIVE_MSG_RECOMMEND_DESC;
        }
        return desc;
    }

    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(this.mTemplate);
    }

    /* access modifiers changed from: protected */
    public boolean parseExt() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean parseCommon() {
        LogUtils.d(TAG, "parseCommon");
        return true;
    }
}
