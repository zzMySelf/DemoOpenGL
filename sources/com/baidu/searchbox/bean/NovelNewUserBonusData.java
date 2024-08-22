package com.baidu.searchbox.bean;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONObject;

public class NovelNewUserBonusData implements Parcelable {
    public static final String ACT_2018_JUM_PURL = "ACT_2018_JUM_PURL";
    public static final String ACT_2018_PIC_URL = "ACT_2018_PIC_URL";
    public static final String ACT_TYPE = "ACT_TYPE";
    public static final String ACT_TYPE_1DAY_FREE = "1dayfree";
    public static final String ACT_TYPE_2018ACT = "2018act";
    public static final String ACT_TYPE_7DAYS_FREE = "7daysfree";
    public static final String ACT_TYPE_CASH_BACK = "cashback";
    public static final String CASH_BACK_BOTTOM_DOC = "CASH_BACK_BOTTOM_DOC";
    public static final String CASH_BACK_NIGHT_PIC_URL = "CASH_BACK_NIGHT_PIC_URL";
    public static final String CASH_BACK_PIC_URL = "CASH_BACK_PIC_URL";
    public static final String CASH_BACK_SUBTITLE_DOC = "CASH_BACK_SUBTITLE_DOC";
    public static final String CASH_BACK_TOP_DOC = "CASH_BACK_TOP_DOC";
    public static final Parcelable.Creator<NovelNewUserBonusData> CREATOR = new Parcelable.Creator<NovelNewUserBonusData>() {
        public NovelNewUserBonusData createFromParcel(Parcel source) {
            return new NovelNewUserBonusData(source);
        }

        public NovelNewUserBonusData[] newArray(int size) {
            return new NovelNewUserBonusData[size];
        }
    };
    public static final String DAY_PIC_URL = "DAY_PIC_URL";
    public static final String IS_GUEST_1_DAY_FREE = "IS_GUEST_1_DAY_FREE";
    public static final String IS_ONE_DAY_ADOPTED = "IS_ONE_DAY_ADOPTED";
    public static final String PIC_URL = "PIC_URL";
    private String m1DayPicUrl;
    private String mAct2018JumpUrl;
    private String mAct2018PicUrl;
    private String mActType;
    private String mCashBackBottomDoc;
    private String mCashBackNightPicUrl;
    private String mCashBackPicUrl;
    private String mCashBackSubtitleDoc;
    private String mCashBackTopDoc;
    private boolean mIsGuest1DayFree;
    private boolean mIsOneDayAdopted;
    private String mPicUrl;

    public String getPicUrl() {
        return this.mPicUrl;
    }

    public void setPicUrl(String picUrl) {
        this.mPicUrl = picUrl;
    }

    public boolean is1DayFree() {
        return this.mIsGuest1DayFree;
    }

    public void setIs1DayFree(boolean is1DayFree) {
        this.mIsGuest1DayFree = is1DayFree;
    }

    public String get1DayPicUrl() {
        return this.m1DayPicUrl;
    }

    public void set1DayPicUrl(String oneDayPicUrl) {
        this.m1DayPicUrl = oneDayPicUrl;
    }

    public boolean isOneDayAdopted() {
        return this.mIsOneDayAdopted;
    }

    public void setIsOneDayAdopted(boolean isOneDayAdopted) {
        this.mIsOneDayAdopted = isOneDayAdopted;
    }

    public String getAct2018PicUrl() {
        return this.mAct2018PicUrl;
    }

    public void setAct2018PicUrl(String act2018PicUrl) {
        this.mAct2018PicUrl = act2018PicUrl;
    }

    public String getAct2018JumpUrl() {
        return this.mAct2018JumpUrl;
    }

    public void setAct2018JumpUrl(String act2018JumpUrl) {
        this.mAct2018JumpUrl = act2018JumpUrl;
    }

    public String getActType() {
        return this.mActType;
    }

    public void setActType(String actType) {
        this.mActType = actType;
    }

    public String getCashBackPicUrl() {
        return this.mCashBackPicUrl;
    }

    public void setCashBackPicUrl(String mCashBackPicUrl2) {
        this.mCashBackPicUrl = mCashBackPicUrl2;
    }

    public String getCashBackNightPicUrl() {
        return this.mCashBackNightPicUrl;
    }

    public void setCashBackNightPicUrl(String mCashBackNightPicUrl2) {
        this.mCashBackNightPicUrl = mCashBackNightPicUrl2;
    }

    public String getCashBackTopDoc() {
        return this.mCashBackTopDoc;
    }

    public void setCashBackTopDoc(String mCashBackTopDoc2) {
        this.mCashBackTopDoc = mCashBackTopDoc2;
    }

    public String getCashBackBottomDoc() {
        return this.mCashBackBottomDoc;
    }

    public void setCashBackBottomDoc(String mCashBackBottomDoc2) {
        this.mCashBackBottomDoc = mCashBackBottomDoc2;
    }

    public String getCashBackSubtitleDoc() {
        return this.mCashBackSubtitleDoc;
    }

    public void setCashBackSubtitleDoc(String mCashBackSubtitleDoc2) {
        this.mCashBackSubtitleDoc = mCashBackSubtitleDoc2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mPicUrl);
        dest.writeByte(this.mIsGuest1DayFree ? (byte) 1 : 0);
        dest.writeString(this.m1DayPicUrl);
        dest.writeByte(this.mIsOneDayAdopted ? (byte) 1 : 0);
        dest.writeString(this.mAct2018PicUrl);
        dest.writeString(this.mAct2018JumpUrl);
        dest.writeString(this.mActType);
        dest.writeString(this.mCashBackPicUrl);
        dest.writeString(this.mCashBackNightPicUrl);
        dest.writeString(this.mCashBackTopDoc);
        dest.writeString(this.mCashBackSubtitleDoc);
        dest.writeString(this.mCashBackBottomDoc);
    }

    public NovelNewUserBonusData() {
    }

    protected NovelNewUserBonusData(Parcel in) {
        this.mPicUrl = in.readString();
        boolean z = true;
        this.mIsGuest1DayFree = in.readByte() != 0;
        this.m1DayPicUrl = in.readString();
        this.mIsOneDayAdopted = in.readByte() == 0 ? false : z;
        this.mAct2018PicUrl = in.readString();
        this.mAct2018JumpUrl = in.readString();
        this.mActType = in.readString();
        this.mCashBackPicUrl = in.readString();
        this.mCashBackNightPicUrl = in.readString();
        this.mCashBackTopDoc = in.readString();
        this.mCashBackSubtitleDoc = in.readString();
        this.mCashBackBottomDoc = in.readString();
    }

    public static NovelNewUserBonusData fromJson(String json) {
        NovelNewUserBonusData data = new NovelNewUserBonusData();
        try {
            JSONObject jsonObject = new JSONObject(json);
            data.mPicUrl = jsonObject.optString(PIC_URL);
            data.mIsGuest1DayFree = jsonObject.optBoolean(IS_GUEST_1_DAY_FREE);
            data.m1DayPicUrl = jsonObject.optString(DAY_PIC_URL);
            data.mIsOneDayAdopted = jsonObject.optBoolean(IS_ONE_DAY_ADOPTED);
            data.mAct2018PicUrl = jsonObject.optString(ACT_2018_PIC_URL);
            data.mAct2018JumpUrl = jsonObject.optString(ACT_2018_JUM_PURL);
            data.mActType = jsonObject.optString(ACT_TYPE);
            data.mCashBackPicUrl = jsonObject.optString(CASH_BACK_PIC_URL);
            data.mCashBackNightPicUrl = jsonObject.optString(CASH_BACK_NIGHT_PIC_URL);
            data.mCashBackTopDoc = jsonObject.optString(CASH_BACK_TOP_DOC);
            data.mCashBackSubtitleDoc = jsonObject.optString(CASH_BACK_SUBTITLE_DOC);
            data.mCashBackBottomDoc = jsonObject.optString(CASH_BACK_BOTTOM_DOC);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return data;
    }

    public String toJson() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(PIC_URL, this.mPicUrl);
            jsonObject.put(IS_GUEST_1_DAY_FREE, this.mIsGuest1DayFree);
            jsonObject.put(DAY_PIC_URL, this.m1DayPicUrl);
            jsonObject.put(IS_ONE_DAY_ADOPTED, this.mIsOneDayAdopted);
            jsonObject.put(ACT_2018_PIC_URL, this.mAct2018PicUrl);
            jsonObject.put(ACT_2018_JUM_PURL, this.mAct2018JumpUrl);
            jsonObject.put(ACT_TYPE, this.mActType);
            jsonObject.put(CASH_BACK_PIC_URL, this.mCashBackPicUrl);
            jsonObject.put(CASH_BACK_NIGHT_PIC_URL, this.mCashBackNightPicUrl);
            jsonObject.put(CASH_BACK_TOP_DOC, this.mCashBackTopDoc);
            jsonObject.put(CASH_BACK_SUBTITLE_DOC, this.mCashBackSubtitleDoc);
            jsonObject.put(CASH_BACK_BOTTOM_DOC, this.mCashBackBottomDoc);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jsonObject.toString();
    }
}
