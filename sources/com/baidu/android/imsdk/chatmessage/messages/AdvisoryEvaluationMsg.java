package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class AdvisoryEvaluationMsg extends NormalMsg {
    public static final Parcelable.Creator<AdvisoryEvaluationMsg> CREATOR = new Parcelable.Creator<AdvisoryEvaluationMsg>() {
        public AdvisoryEvaluationMsg createFromParcel(Parcel source) {
            return new AdvisoryEvaluationMsg(source);
        }

        public AdvisoryEvaluationMsg[] newArray(int size) {
            return new AdvisoryEvaluationMsg[size];
        }
    };
    public int allowRefund;
    public int amount;
    public boolean hasRefund;
    public int isFree;
    public String msg;
    public int orderType;
    public String replyerUid;
    public int role;
    public int source;
    public String star_desc;
    public int star_num;
    public List<String> tags = new ArrayList();
    public String targetAid;
    public String uk;

    public AdvisoryEvaluationMsg(int msgType, int starNum, String starDesc, String msg2, List<String> tags2, int role2, String uk2, int amount2, int isFree2, boolean hasRefund2, String targetAid2, int source2, int orderType2, String replyerUid2, int banRefund) {
        setMsgType(msgType);
        this.star_num = starNum;
        this.star_desc = starDesc;
        this.msg = msg2;
        this.tags = tags2;
        this.role = role2;
        this.uk = uk2;
        this.amount = amount2;
        this.isFree = isFree2;
        this.hasRefund = hasRefund2;
        this.targetAid = targetAid2;
        this.source = source2;
        this.orderType = orderType2;
        this.replyerUid = replyerUid2;
        this.allowRefund = banRefund;
    }

    protected AdvisoryEvaluationMsg(Parcel in) {
        super(in);
        this.star_num = in.readInt();
        this.star_desc = in.readString();
        this.msg = in.readString();
        this.tags = in.createStringArrayList();
        this.role = in.readInt();
        this.uk = in.readString();
        this.amount = in.readInt();
        this.isFree = in.readInt();
        this.hasRefund = in.readByte() != 0;
        this.targetAid = in.readString();
        this.source = in.readInt();
        this.orderType = in.readInt();
        this.replyerUid = in.readString();
    }

    /* access modifiers changed from: protected */
    public boolean parseJsonString() {
        return false;
    }

    public String getRecommendDescription() {
        return null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(this.star_num);
        dest.writeString(this.star_desc);
        dest.writeString(this.msg);
        dest.writeStringList(this.tags);
        dest.writeInt(this.role);
        dest.writeString(this.uk);
        dest.writeInt(this.amount);
        dest.writeInt(this.isFree);
        dest.writeByte(this.hasRefund ? (byte) 1 : 0);
        dest.writeString(this.targetAid);
        dest.writeInt(this.source);
        dest.writeInt(this.orderType);
        dest.writeString(this.replyerUid);
    }
}
