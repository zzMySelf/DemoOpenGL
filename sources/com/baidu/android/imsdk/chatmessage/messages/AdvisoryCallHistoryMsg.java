package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class AdvisoryCallHistoryMsg extends NormalMsg {
    public static final Parcelable.Creator<AdvisoryCallHistoryMsg> CREATOR = new Parcelable.Creator<AdvisoryCallHistoryMsg>() {
        public AdvisoryCallHistoryMsg createFromParcel(Parcel in) {
            return new AdvisoryCallHistoryMsg(in);
        }

        public AdvisoryCallHistoryMsg[] newArray(int size) {
            return new AdvisoryCallHistoryMsg[size];
        }
    };
    private static final String TAG = "AdvisoryCallHistoryMsg";
    private static final int VIDEO_TYPE = 2;
    private String mFromTips;
    private long mFromUid;
    private int mMediaType;
    private String mRoomId;
    private String mToTips;
    private long mToUid;

    public AdvisoryCallHistoryMsg() {
        setMsgType(47);
    }

    public AdvisoryCallHistoryMsg(Parcel in) {
        super(in);
        this.mMediaType = in.readInt();
        this.mFromUid = in.readLong();
        this.mFromTips = in.readString();
        this.mToUid = in.readLong();
        this.mToTips = in.readString();
        this.mRoomId = in.readString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(this.mMediaType);
        dest.writeLong(this.mFromUid);
        dest.writeString(this.mFromTips);
        dest.writeLong(this.mToUid);
        dest.writeString(this.mToTips);
        dest.writeString(this.mRoomId);
    }

    /* access modifiers changed from: protected */
    public boolean parseJsonString() {
        if (TextUtils.isEmpty(this.mjsonContent)) {
            return false;
        }
        try {
            JSONObject json = new JSONObject(this.mjsonContent);
            this.mMediaType = json.optInt("media_type");
            this.mRoomId = json.optString("room_id");
            JSONObject fromJson = json.optJSONObject("from");
            if (fromJson != null) {
                this.mFromUid = fromJson.optLong("uid");
                this.mFromTips = fromJson.optString("tips");
            }
            JSONObject toJson = json.optJSONObject("to");
            if (toJson != null) {
                this.mToUid = toJson.optLong("uid");
                this.mToTips = toJson.optString("tips");
            }
            return true;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void setMediaType(int mMediaType2) {
        this.mMediaType = mMediaType2;
    }

    public void setFromUid(long mFromUid2) {
        this.mFromUid = mFromUid2;
    }

    public void setFromTips(String mFromTips2) {
        this.mFromTips = mFromTips2;
    }

    public void setToUid(long mToUid2) {
        this.mToUid = mToUid2;
    }

    public void setToTips(String mToTips2) {
        this.mToTips = mToTips2;
    }

    public String getRoomId() {
        return this.mRoomId;
    }

    public void setRoomId(String mRoomId2) {
        this.mRoomId = mRoomId2;
    }

    public int getMediaType() {
        return this.mMediaType;
    }

    public long getFromUid() {
        return this.mFromUid;
    }

    public String getFromTips() {
        return this.mFromTips;
    }

    public long getToUid() {
        return this.mToUid;
    }

    public String getToTips() {
        return this.mToTips;
    }

    public String getRecommendDescription() {
        if (this.mMediaType == 2) {
            return "[视频通话]";
        }
        return "[音频通话]";
    }

    public boolean setJsonContent() {
        JSONObject contentJson = new JSONObject();
        JSONObject fromJson = new JSONObject();
        JSONObject toJson = new JSONObject();
        try {
            fromJson.put("uid", this.mFromUid);
            fromJson.put("tips", this.mFromTips);
            toJson.put("uid", this.mToUid);
            toJson.put("tips", this.mToTips);
            contentJson.put("media_type", this.mMediaType);
            contentJson.put("room_id", this.mRoomId);
            contentJson.put("from", fromJson);
            contentJson.put("to", toJson);
            return setMsgContent(contentJson.toString());
        } catch (JSONException e2) {
            LogUtils.e(TAG, "content error!");
            return false;
        }
    }
}
