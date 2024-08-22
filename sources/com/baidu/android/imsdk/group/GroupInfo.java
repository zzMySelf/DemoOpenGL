package com.baidu.android.imsdk.group;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import com.baidu.android.imsdk.utils.PinYinUtils;
import com.baidu.chatsearch.aisearch.resultpage.toolbar.discovery.span.RhetoricalTagUtilKt;
import org.json.JSONException;
import org.json.JSONObject;

public class GroupInfo implements Parcelable, NoProGuard, PinYinUtils.PinYinObject {
    public static final Parcelable.Creator<GroupInfo> CREATOR = new Parcelable.Creator<GroupInfo>() {
        public GroupInfo createFromParcel(Parcel in) {
            return new GroupInfo(in);
        }

        public GroupInfo[] newArray(int size) {
            return new GroupInfo[size];
        }
    };
    private static final String TAG = "GroupInfo";
    private int brief;
    private int mActiveState;
    private int mAuditState;
    private long mBduid;
    private String mCertification;
    private long mCreateTime;
    private String mDescription = "";
    private int mDisturb;
    private int mGroupCapacity;
    private String mGroupId;
    private int mGroupMuted;
    private String mGroupName = "";
    private String mGroupNotice;
    private String mGroupNoticeAuthorBduk;
    private long mGroupNoticePublishTime;
    private int mGroupVerify;
    private int mHasNotice;
    private String mHeadUrl;
    private String mHomePage;
    private long mInfoVersion;
    private int mLimitGroupWelcomeMsg;
    private long mLocalInfoVersion;
    private long mLocalMembersVersion;
    private int mMarkTop;
    private long mMarkTopTime;
    private int mMaxAdminCount;
    private long mMembersVersion;
    private String mNoticeExt;
    private int mNum;
    private String mPinYin;
    private String mSettingInfo;
    private int mSubType;
    private int mType = 0;
    private long mUk;
    private String mWelcomeContent;
    private int mWelcomeDisplayRangeSwitch;
    private String mWelcomeJsonTxt;
    private String mWelcomeOperatorBdUk;
    private long mWelcomeOperatorTimeSeconds;
    private int state;

    public void setSubType(int subType) {
        this.mSubType = subType;
    }

    public void setSettingInfo(String info) {
        this.mSettingInfo = info;
    }

    public int getSubType() {
        return this.mSubType;
    }

    public String getSettingInfo() {
        return this.mSettingInfo;
    }

    public void setGroupCapacity(int capacity) {
        this.mGroupCapacity = capacity;
    }

    public void setGroupVerify(int verify) {
        this.mGroupVerify = verify;
    }

    public void setGroupNotice(String notice) {
        this.mGroupNotice = notice;
    }

    public int getGroupCapacity() {
        return this.mGroupCapacity;
    }

    public int getGroupVerify() {
        return this.mGroupVerify;
    }

    public String getGroupNotice() {
        return this.mGroupNotice;
    }

    public String getHeadUrl() {
        return this.mHeadUrl;
    }

    public void setHeadUrl(String mHeadUrl2) {
        this.mHeadUrl = mHeadUrl2;
    }

    public int getBrief() {
        return this.brief;
    }

    public void setBrief(int brief2) {
        this.brief = brief2;
    }

    public String getHomePage() {
        return this.mHomePage;
    }

    public void setHomePage(String homePage) {
        this.mHomePage = homePage;
    }

    public void setNoticeExt(String noticeExt) {
        this.mNoticeExt = noticeExt;
        parseGroupNoticeExt();
    }

    public String getNoticeExt() {
        return this.mNoticeExt;
    }

    public void setHasNotice(int hasNotice) {
        this.mHasNotice = hasNotice;
    }

    public String getCertification() {
        return this.mCertification;
    }

    public void setCertification(String certification) {
        this.mCertification = certification;
    }

    public int getHasGroupNotice() {
        return this.mHasNotice;
    }

    public String getWelcomeJsonTxt() {
        return this.mWelcomeJsonTxt;
    }

    public void setWelcomeJsonTxt(String welcomeJsonTxt) {
        this.mWelcomeJsonTxt = welcomeJsonTxt;
        parseWelcomeJson();
    }

    private void parseWelcomeJson() {
        if (!TextUtils.isEmpty(this.mWelcomeJsonTxt)) {
            try {
                JSONObject json = new JSONObject(this.mWelcomeJsonTxt);
                this.mWelcomeContent = json.optString("content", "");
                this.mWelcomeDisplayRangeSwitch = json.optInt("operation_type", 0);
                this.mWelcomeOperatorBdUk = json.optString("operator", "");
                this.mWelcomeOperatorTimeSeconds = json.optLong("operation_time", 0);
                this.mLimitGroupWelcomeMsg = json.optInt("limit_group_welcome_msg", 0);
            } catch (JSONException e2) {
                if (Constants.isDebugMode()) {
                    Log.d(TAG, "parse welcome json exception," + e2.toString());
                }
            }
        }
    }

    public String getWelcomeContent() {
        return this.mWelcomeContent;
    }

    public int getWelcomeDisplayRangeSwitch() {
        return this.mWelcomeDisplayRangeSwitch;
    }

    public void setWelcomeDisplayRangeSwitch(int welcomeDisplayRangeSwitch) {
        this.mWelcomeDisplayRangeSwitch = welcomeDisplayRangeSwitch;
    }

    public String getWelcomeOperatorBdUk() {
        return this.mWelcomeOperatorBdUk;
    }

    public long getWelcomeOperatorTimeSeconds() {
        return this.mWelcomeOperatorTimeSeconds;
    }

    public long getGroupNoticePublishTime() {
        return this.mGroupNoticePublishTime;
    }

    public String getNoticeAuthorBduk() {
        return this.mGroupNoticeAuthorBduk;
    }

    private void parseGroupNoticeExt() {
        if (!TextUtils.isEmpty(this.mNoticeExt)) {
            try {
                JSONObject json = new JSONObject(this.mNoticeExt);
                this.mGroupNoticeAuthorBduk = json.optString("operator");
                this.mGroupNoticePublishTime = json.optLong("operation_time", 0);
            } catch (JSONException e2) {
                LogUtils.d(TAG, e2.toString());
            }
        }
    }

    public int getLimitGroupWelcomeMsg() {
        return this.mLimitGroupWelcomeMsg;
    }

    public GroupInfo(String groupId) {
        this.mGroupId = groupId;
    }

    GroupInfo(Parcel in) {
        this.mGroupId = in.readString();
        this.mGroupName = in.readString();
        this.mDescription = in.readString();
        this.mDisturb = in.readInt();
        this.state = in.readInt();
        this.mType = in.readInt();
        this.mNum = in.readInt();
        this.mCreateTime = in.readLong();
        this.mBduid = in.readLong();
        this.mUk = in.readLong();
        this.mActiveState = in.readInt();
        this.mMembersVersion = in.readLong();
        this.brief = in.readInt();
        this.mMarkTop = in.readInt();
        this.mMarkTopTime = in.readLong();
        this.mGroupNotice = in.readString();
        this.mGroupCapacity = in.readInt();
        this.mGroupVerify = in.readInt();
        this.mLocalMembersVersion = in.readLong();
        this.mLocalInfoVersion = in.readLong();
        this.mInfoVersion = in.readLong();
        this.mMaxAdminCount = in.readInt();
        this.mSubType = in.readInt();
        this.mSettingInfo = in.readString();
        this.mHomePage = in.readString();
        this.mAuditState = in.readInt();
        this.mNoticeExt = in.readString();
        this.mHasNotice = in.readInt();
        this.mWelcomeJsonTxt = in.readString();
        this.mWelcomeContent = in.readString();
        this.mWelcomeOperatorBdUk = in.readString();
        this.mWelcomeOperatorTimeSeconds = in.readLong();
        this.mWelcomeDisplayRangeSwitch = in.readInt();
        this.mCertification = in.readString();
        this.mGroupMuted = in.readInt();
    }

    public String toString() {
        return "GroupInfo [mGroupId=" + this.mGroupId + ", mGroupName=" + this.mGroupName + ", mDescription=" + this.mDescription + ", mType=" + this.mType + ", mPinYin=" + this.mPinYin + ", mCreateTime=" + this.mCreateTime + ", mBduid=" + this.mBduid + ", mUk=" + this.mUk + ", mNum=" + this.mNum + ", mGroupCapacity=" + this.mGroupCapacity + ", mMembersVersion=" + this.mMembersVersion + ", mDisturb=" + this.mDisturb + ", state=" + this.state + ", activeState=" + this.mActiveState + " marktop = " + this.mMarkTop + " martTime = " + this.mMarkTopTime + ", mAuditState=" + this.mAuditState + ", certification = " + this.mCertification + ", groupMuted = " + this.mGroupMuted + ", mHeadUrl = " + this.mHeadUrl + RhetoricalTagUtilKt.TAG_END_SYMBOL;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mGroupId);
        dest.writeString(this.mGroupName);
        dest.writeString(this.mDescription);
        dest.writeInt(this.mDisturb);
        dest.writeInt(this.state);
        dest.writeInt(this.mType);
        dest.writeInt(this.mNum);
        dest.writeLong(this.mCreateTime);
        dest.writeLong(this.mBduid);
        dest.writeLong(this.mUk);
        dest.writeInt(this.mActiveState);
        dest.writeLong(this.mMembersVersion);
        dest.writeInt(this.brief);
        dest.writeInt(this.mMarkTop);
        dest.writeLong(this.mMarkTopTime);
        dest.writeString(this.mGroupNotice);
        dest.writeInt(this.mGroupCapacity);
        dest.writeInt(this.mGroupVerify);
        dest.writeLong(this.mLocalMembersVersion);
        dest.writeLong(this.mLocalInfoVersion);
        dest.writeLong(this.mInfoVersion);
        dest.writeInt(this.mMaxAdminCount);
        dest.writeInt(this.mSubType);
        dest.writeString(this.mSettingInfo);
        dest.writeString(this.mHomePage);
        dest.writeInt(this.mAuditState);
        dest.writeString(this.mNoticeExt);
        dest.writeInt(this.mHasNotice);
        dest.writeString(this.mWelcomeJsonTxt);
        dest.writeString(this.mWelcomeContent);
        dest.writeString(this.mWelcomeOperatorBdUk);
        dest.writeLong(this.mWelcomeOperatorTimeSeconds);
        dest.writeInt(this.mWelcomeDisplayRangeSwitch);
        dest.writeString(this.mCertification);
        dest.writeInt(this.mGroupMuted);
    }

    public String getGroupId() {
        return this.mGroupId;
    }

    public void setGroupName(String groupName) {
        this.mGroupName = groupName;
    }

    public String getGroupName() {
        return this.mGroupName;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int type) {
        this.mType = type;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int state2) {
        this.state = state2;
    }

    public int getDisturb() {
        return this.mDisturb;
    }

    public void setDisturb(int disturb) {
        this.mDisturb = disturb;
    }

    public void setCreateTime(long t) {
        this.mCreateTime = t;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public void setBuid(long uid) {
        this.mBduid = uid;
    }

    public long getBuid() {
        return this.mBduid;
    }

    public void setUk(long uk) {
        this.mUk = uk;
    }

    public long getUk() {
        return this.mUk;
    }

    public void setNum(int n) {
        this.mNum = n;
    }

    public int getNum() {
        return this.mNum;
    }

    public long getMembersVersion() {
        return this.mMembersVersion;
    }

    public void setMembersVersion(long membersVersion) {
        this.mMembersVersion = membersVersion;
    }

    public void setLocalMembersVersion(long version) {
        this.mLocalMembersVersion = version;
    }

    public void setLocalInfoVersion(long version) {
        this.mLocalInfoVersion = version;
    }

    public void setInfoVersion(long version) {
        this.mInfoVersion = version;
    }

    public long getLocalMembersVersion() {
        return this.mLocalMembersVersion;
    }

    public long getLocalInfoVersion() {
        return this.mLocalInfoVersion;
    }

    public long getInfoVersion() {
        return this.mInfoVersion;
    }

    public int getMaxAdminCount() {
        return this.mMaxAdminCount;
    }

    public void setMaxAdminCount(int maxAdminCount) {
        this.mMaxAdminCount = maxAdminCount;
    }

    public int getActiveState() {
        return this.mActiveState;
    }

    public void setActiveState(int activeState) {
        this.mActiveState = activeState;
    }

    public void setMarkTop(int markTop) {
        this.mMarkTop = markTop;
    }

    public int getMarkTop() {
        return this.mMarkTop;
    }

    public void setMarkTopTime(long time) {
        this.mMarkTopTime = time;
    }

    public long getMarkTopTime() {
        return this.mMarkTopTime;
    }

    public int getAuditState() {
        return this.mAuditState;
    }

    public void setAuditState(int auditState) {
        this.mAuditState = auditState;
    }

    public int getGroupMuted() {
        return this.mGroupMuted;
    }

    public void setGroupMuted(int groupMuted) {
        this.mGroupMuted = groupMuted;
    }

    public String getPy() {
        if (TextUtils.isEmpty(this.mPinYin)) {
            this.mPinYin = PinYinUtils.getPy(this.mGroupName);
        }
        return this.mPinYin;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.mGroupId) && this.mType > 0;
    }
}
