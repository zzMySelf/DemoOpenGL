package com.baidu.netdisk.account.io.model;

import com.google.gson.annotations.SerializedName;

public class OverdueInfoBean {
    @SerializedName("msg_end_time")
    public long mMsgEndTime;
    @SerializedName("msg_time")
    public long mMsgTime;
    @SerializedName("msg_type")
    public int mMsgType;
    @SerializedName("notice")
    public String mNotice;
    @SerializedName("picture_url")
    public String mPictureUrl;
    @SerializedName("quota")
    public QuotaOverdueTipBean mQuotaNotice;
    @SerializedName("redirect_content")
    public String mRedirectContent;
    @SerializedName("redirect_url")
    public String mRedirectUrl;
    @SerializedName("resident_notice")
    public QuotaOverdueTipBean mResidentNotice;
    @SerializedName("state")
    public String mState;
    @SerializedName("title")
    public String mTitle;
}
