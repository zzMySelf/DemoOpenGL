package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;

public class AdvisoryRepurchaseGuideMsg extends NormalMsg {
    public static final Parcelable.Creator<AdvisoryRepurchaseGuideMsg> CREATOR = new Parcelable.Creator<AdvisoryRepurchaseGuideMsg>() {
        public AdvisoryRepurchaseGuideMsg createFromParcel(Parcel source) {
            return new AdvisoryRepurchaseGuideMsg(source);
        }

        public AdvisoryRepurchaseGuideMsg[] newArray(int size) {
            return new AdvisoryRepurchaseGuideMsg[size];
        }
    };
    public String askMe;
    public String askMeScheme;
    public String askOther;
    public String askOtherScheme;
    public String avatarUrl;
    public String cardSubTitle;
    public String cardTitle;
    public String domains;
    public int helpCount;
    public String name;
    public String qualification;
    public String ukAsk;
    public String ukReply;
    public int userType;
    public String vTypeImg;
    public double valueScore;

    public AdvisoryRepurchaseGuideMsg(int msgType, int userType2, String cardTitle2, String cardSubTitle2, String name2, String avatarUrl2, int helpCount2, String qualification2, String domains2, String vTypeImg2, double valueScore2, String askMe2, String askMeScheme2, String askOther2, String askOtherScheme2, String ukAsk2, String ukReply2) {
        setMsgType(msgType);
        this.userType = userType2;
        this.cardTitle = cardTitle2;
        this.cardSubTitle = cardSubTitle2;
        this.name = name2;
        this.avatarUrl = avatarUrl2;
        this.helpCount = helpCount2;
        this.qualification = qualification2;
        this.domains = domains2;
        this.vTypeImg = vTypeImg2;
        this.valueScore = valueScore2;
        this.askMe = askMe2;
        this.askMeScheme = askMeScheme2;
        this.askOther = askOther2;
        this.askOtherScheme = askOtherScheme2;
        this.ukAsk = ukAsk2;
        this.ukReply = ukReply2;
    }

    protected AdvisoryRepurchaseGuideMsg(Parcel in) {
        super(in);
        this.userType = in.readInt();
        this.cardTitle = in.readString();
        this.cardSubTitle = in.readString();
        this.name = in.readString();
        this.avatarUrl = in.readString();
        this.helpCount = in.readInt();
        this.qualification = in.readString();
        this.domains = in.readString();
        this.vTypeImg = in.readString();
        this.valueScore = in.readDouble();
        this.askMe = in.readString();
        this.askMeScheme = in.readString();
        this.askOther = in.readString();
        this.askOtherScheme = in.readString();
        this.ukAsk = in.readString();
        this.ukReply = in.readString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(this.userType);
        dest.writeString(this.cardTitle);
        dest.writeString(this.cardSubTitle);
        dest.writeString(this.name);
        dest.writeString(this.avatarUrl);
        dest.writeInt(this.helpCount);
        dest.writeString(this.qualification);
        dest.writeString(this.domains);
        dest.writeString(this.vTypeImg);
        dest.writeDouble(this.valueScore);
        dest.writeString(this.askMe);
        dest.writeString(this.askMeScheme);
        dest.writeString(this.askOther);
        dest.writeString(this.askOtherScheme);
        dest.writeString(this.ukAsk);
        dest.writeString(this.ukReply);
    }

    /* access modifiers changed from: protected */
    public boolean parseJsonString() {
        return false;
    }

    public String getRecommendDescription() {
        return null;
    }
}
