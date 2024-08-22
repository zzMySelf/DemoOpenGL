package com.baidu.android.imsdk.chatmessage.messages;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.netdisk.base.storage.db.BaseContract;
import org.json.JSONException;
import org.json.JSONObject;

public class RecallMsg extends ChatMsg {
    public static final Parcelable.Creator<RecallMsg> CREATOR = new Parcelable.Creator<RecallMsg>() {
        public RecallMsg createFromParcel(Parcel in) {
            return new RecallMsg(in);
        }

        public RecallMsg[] newArray(int size) {
            return new RecallMsg[size];
        }
    };
    private static final String TAG = "RecallMsg";
    public static final long TIME_LIMIT_REDIT = 7200000;
    private long mClickRecallTime;
    private boolean mIsAllowRedit;
    private boolean mIsNotify;
    private long mOperatorBduid;
    private long mOperatorPaid;
    private int mOriginMsgType;
    private int mRecallMode;
    private long mRecalledMsgSenderBduid;
    private int mReplyedMsgType;

    public RecallMsg(boolean isNotify) {
        this();
        this.mIsNotify = isNotify;
    }

    public RecallMsg() {
        this.mIsNotify = true;
        this.mOriginMsgType = -1;
        setMsgType(1030);
        setSendMsgTime(System.currentTimeMillis());
    }

    public RecallMsg(Parcel in) {
        super(in);
        boolean z = true;
        this.mIsNotify = true;
        this.mOriginMsgType = -1;
        this.mRecallMode = in.readInt();
        this.mOriginMsgType = in.readInt();
        this.mReplyedMsgType = in.readInt();
        this.mIsNotify = in.readInt() == 1;
        this.mIsAllowRedit = in.readInt() != 1 ? false : z;
        this.mOperatorBduid = in.readLong();
        this.mClickRecallTime = in.readLong();
        this.mRecalledMsgSenderBduid = in.readLong();
        this.mOperatorPaid = in.readLong();
    }

    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(this.mRecallMode);
        dest.writeInt(this.mOriginMsgType);
        dest.writeInt(this.mReplyedMsgType);
        dest.writeInt(this.mIsNotify ? 1 : 0);
        dest.writeInt(this.mIsAllowRedit ? 1 : 0);
        dest.writeLong(this.mOperatorBduid);
        dest.writeLong(this.mClickRecallTime);
        dest.writeLong(this.mRecalledMsgSenderBduid);
        dest.writeLong(this.mOperatorPaid);
    }

    public void initAllowReditStatus(Context context) {
        boolean isSelf = AccountManager.getUid(context).equals(String.valueOf(this.mRecalledMsgSenderBduid));
        boolean isInCertainTime = getIsInCertainTime();
        LogUtils.d(TAG, "撤回-initAllowReditStatus-isSelf: " + isSelf + ", isInCertainTime: " + isInCertainTime + ", isNotify: " + this.mIsNotify);
        this.mIsAllowRedit = isSelf && isInCertainTime && !this.mIsNotify && isSupportReditType(this.mOriginMsgType);
    }

    private boolean getIsInCertainTime() {
        return System.currentTimeMillis() - this.mClickRecallTime <= 7200000;
    }

    public void setOriginMsgType(int type) {
        this.mOriginMsgType = type;
    }

    public void setClickRecallTime(long clickRecallTime) {
        this.mClickRecallTime = clickRecallTime;
    }

    public long getClickRecallTime() {
        return this.mClickRecallTime;
    }

    public int getOriginMsgType() {
        return this.mOriginMsgType;
    }

    public void setIsAllowRedit(boolean isAllowRedit) {
        this.mIsAllowRedit = isAllowRedit;
    }

    public boolean isAllowRedit() {
        return this.mIsAllowRedit;
    }

    public long getOperatorBduid() {
        return this.mOperatorBduid;
    }

    public void setOperatorBduid(long mOperatorBduid2) {
        this.mOperatorBduid = mOperatorBduid2;
    }

    public long getOperatorPaid() {
        return this.mOperatorPaid;
    }

    public void setOperatorPaid(long operatorPaid) {
        this.mOperatorPaid = operatorPaid;
    }

    public int getRecallMode() {
        return this.mRecallMode;
    }

    public void setRecallMode(int mRecallMode2) {
        this.mRecallMode = mRecallMode2;
    }

    /* access modifiers changed from: protected */
    public boolean parseJsonString() {
        if (TextUtils.isEmpty(this.mjsonContent)) {
            return false;
        }
        try {
            JSONObject jsonObj = new JSONObject(this.mjsonContent);
            this.mRecallMode = jsonObj.optInt("recall_mode");
            this.mIsNotify = jsonObj.optBoolean(BaseContract.QUERY_PARAMETER_IS_NOTIFY, true);
            this.mOriginMsgType = jsonObj.optInt("origin_msg_type");
            this.mOperatorBduid = jsonObj.optLong("operator_bduid");
            this.mClickRecallTime = jsonObj.optLong("click_recall_time");
            setSenderUid(String.valueOf(this.mOperatorBduid));
            this.mRecalledMsgSenderBduid = jsonObj.optLong("send_msg_bduid");
            setPreviewDesc(jsonObj.optString("desc"));
            if (jsonObj.has("reply_data")) {
                String replyData = jsonObj.optString("reply_data");
                if (!TextUtils.isEmpty(replyData)) {
                    this.mReplyedMsgType = new JSONObject(replyData).getInt("re_msg_type");
                }
            }
        } catch (JSONException e2) {
            LogUtils.d(TAG, "撤回-Error: " + e2.getMessage());
        }
        return true;
    }

    private boolean isSupportReditType(int msgType) {
        return msgType == 0 || msgType == 40;
    }

    public String getRecommendDescription() {
        return getPreviewDesc();
    }

    public int getReplyedMsgType() {
        return this.mReplyedMsgType;
    }
}
