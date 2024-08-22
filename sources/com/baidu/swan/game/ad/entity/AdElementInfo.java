package com.baidu.swan.game.ad.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.swan.game.ad.interfaces.IAdResonseInfo;
import com.baidu.swan.game.ad.interfaces.IGdtAdResonseInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdElementInfo implements IAdResonseInfo, Parcelable, IGdtAdResonseInfo {
    public static final int ACTION_TYPE_DOWNLOAD = 2;
    public static final int ACTION_TYPE_LANDING_PAGE = 1;
    public static final int CLOSE_TYPE_TO_NEW_STRATEGY = 6;
    public static final Parcelable.Creator<AdElementInfo> CREATOR = new Parcelable.Creator<AdElementInfo>() {
        public AdElementInfo createFromParcel(Parcel in) {
            return new AdElementInfo(in);
        }

        public AdElementInfo[] newArray(int size) {
            return new AdElementInfo[size];
        }
    };
    public static final String TAG = "AdElementInfo";
    private long createTime;
    private int dlDialog;
    private int mActionType;
    private String mAdId;
    private JSONObject mAdJsonObject;
    private JSONObject mAdMonitors;
    private int mAntiTag;
    private String mApkName;
    private String mAppName;
    private long mAppSize;
    private String mBannerHtml;
    private String mClickUrl;
    private Set<String> mCloseTrackers;
    private int mCloseType;
    private Set<String> mConversionUrls;
    private String mDescription;
    private int mDuration;
    private String mEndFrameHtml;
    private String mEndFrameUrl;
    private int mExpire;
    private String mFallback;
    private String mFbAct;
    private String mFunctionUrl;
    private boolean mGdtAd;
    private String mIconUrl;
    private Set<String> mImpressionUrls;
    private String mLandBannerHtml;
    private Set<String> mMonitorClickers;
    private String mPackageName;
    private String mPage;
    private String mPermissionUrl;
    private String mPictureUrl;
    private String mPrivacyUrl;
    private String mPublisher;
    private String mQueryKey;
    private int mRewardTime;
    private int mRewardTimeDefault;
    private int mSkipTime;
    private int mSkipTimeDefault;
    private Set<String> mSkipTrackers;
    private Set<String> mStartTrackers;
    private Set<String> mThirdClickMonitorTrackers;
    private Set<String> mThirdImpMonitorTrackers;
    private String mTitle;
    private String mType;
    private String mUniqueId;
    private String mVersion;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;

    public AdElementInfo(JSONObject object) {
        this.mAdId = "-1";
        this.mImpressionUrls = new HashSet();
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        this.mThirdImpMonitorTrackers = new HashSet();
        this.mThirdClickMonitorTrackers = new HashSet();
        this.mStartTrackers = new HashSet();
        this.mSkipTrackers = new HashSet();
        this.mCloseTrackers = new HashSet();
        this.mMonitorClickers = new HashSet();
        this.mRewardTimeDefault = 15;
        this.mSkipTimeDefault = 5;
        this.mConversionUrls = new HashSet();
        this.mAdJsonObject = object;
        try {
            this.createTime = System.currentTimeMillis();
            this.mQueryKey = object.optString(IAdResonseInfo.QK, "");
            this.mAdId = object.optString("id", "-1");
            String winurl = object.optString(IAdResonseInfo.WINURL, "");
            if (!TextUtils.isEmpty(winurl)) {
                this.mImpressionUrls.add(winurl);
            }
            this.mTitle = object.optString(IAdResonseInfo.TITLE, "");
            this.mDescription = object.optString("desc", "");
            this.mIconUrl = object.optString("icon", "");
            this.mType = object.optString("type");
            this.mActionType = object.optInt("act");
            this.mAntiTag = object.optInt(IAdResonseInfo.ANTI_TAG);
            this.mClickUrl = object.optString(IAdResonseInfo.CURL, "");
            this.mPictureUrl = object.optString(IAdResonseInfo.W_PICURL, "");
            this.mVideoUrl = object.optString("vurl", "");
            this.mPrivacyUrl = object.optString(IAdResonseInfo.PRIVACY_URL, "");
            this.mPermissionUrl = object.optString(IAdResonseInfo.PERMISSION_URL, "");
            this.mFunctionUrl = object.optString(IAdResonseInfo.FUNCTION_URL, "");
            this.mVideoWidth = object.optInt("w", 0);
            this.mVideoHeight = object.optInt("h", 0);
            this.mDuration = object.optInt("duration", 0);
            this.mCloseType = object.optInt(IAdResonseInfo.CLOSE_TYPE, 0);
            this.mExpire = object.optInt(IAdResonseInfo.EXPIRATION, 0);
            this.mRewardTime = object.optInt(IAdResonseInfo.REWARD_TIME, this.mRewardTimeDefault);
            this.mSkipTime = object.optInt(IAdResonseInfo.SKIP_TIME, this.mSkipTimeDefault);
            this.mEndFrameUrl = object.optString(IAdResonseInfo.INTERACTIVE_END_FRAME, "");
            JSONObject jsonObj = object.optJSONObject(IAdResonseInfo.MONITORS);
            this.mAdMonitors = jsonObj;
            if (jsonObj != null) {
                Iterator iter = jsonObj.keys();
                while (iter.hasNext()) {
                    String key = iter.next();
                    if (key.equals("s")) {
                        JSONArray a2 = jsonObj.optJSONArray(key);
                        for (int i2 = 0; i2 < a2.length(); i2++) {
                            addThirdImpMonitorTrackers(a2.optString(i2));
                        }
                    } else if (key.equals(IAdResonseInfo.V_SKIP)) {
                        JSONArray a3 = jsonObj.optJSONArray(key);
                        for (int i3 = 0; i3 < a3.length(); i3++) {
                            addSkipMonitorTrackers(a3.optString(i3));
                        }
                    } else if (key.equals("vstart")) {
                        JSONArray a4 = jsonObj.optJSONArray(key);
                        for (int i4 = 0; i4 < a4.length(); i4++) {
                            addStartMonitorTrackers(a4.optString(i4));
                        }
                    } else if (key.equals("vclose")) {
                        JSONArray a5 = jsonObj.optJSONArray(key);
                        for (int i5 = 0; i5 < a5.length(); i5++) {
                            addCloseMonitorTrackers(a5.optString(i5));
                        }
                    } else if (key.equals("click")) {
                        JSONArray a6 = jsonObj.optJSONArray(key);
                        for (int i6 = 0; i6 < a6.length(); i6++) {
                            addMonitorClickTrackers(a6.optString(i6));
                        }
                    } else if (key.equals("c")) {
                        JSONArray a7 = jsonObj.optJSONArray(key);
                        for (int i7 = 0; i7 < a7.length(); i7++) {
                            addThirdClickMonitorTrackers(a7.optString(i7));
                        }
                    }
                }
            }
            this.mAppName = object.optString("appname", "");
            this.mPackageName = object.optString("pk", "");
            this.mApkName = object.optString(IAdResonseInfo.APK_NAME, "");
            this.mAppSize = object.optLong(IAdResonseInfo.SZ, 0);
            this.mPublisher = object.optString("publisher", "");
            this.dlDialog = object.optInt(IAdResonseInfo.DLDIALOG, 0);
            JSONObject adHtmlJson = object.optJSONObject(IAdResonseInfo.AD_HTML);
            if (adHtmlJson != null) {
                Iterator iter2 = adHtmlJson.keys();
                while (iter2.hasNext()) {
                    String key2 = iter2.next();
                    if (key2.equals(IAdResonseInfo.BANNER_SNIPPET)) {
                        this.mBannerHtml = adHtmlJson.optString(key2);
                    } else if (key2.equals(IAdResonseInfo.INT_SNIPPET)) {
                        this.mEndFrameHtml = adHtmlJson.optString(key2);
                    } else if (key2.equals(IAdResonseInfo.BANNER_LAND_SNIPPET)) {
                        this.mLandBannerHtml = adHtmlJson.optString(key2);
                    }
                }
            }
            if (object.optJSONObject(IAdResonseInfo.APO) != null) {
                this.mPage = object.optString("page", "");
                this.mVersion = object.optString("version", "");
                this.mFallback = object.optString(IAdResonseInfo.APO_FALLBACK, "");
                this.mFbAct = object.optString(IAdResonseInfo.APO_FB_ACT, "");
            }
            this.mUniqueId = this.mQueryKey + "_" + new Random().nextLong() + System.currentTimeMillis() + "|";
            this.mGdtAd = false;
        } catch (Exception e2) {
        }
    }

    public AdElementInfo(JSONObject object, boolean isGdtAd) {
        JSONObject videoObject;
        JSONObject imageObject;
        this.mAdId = "-1";
        this.mImpressionUrls = new HashSet();
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        this.mThirdImpMonitorTrackers = new HashSet();
        this.mThirdClickMonitorTrackers = new HashSet();
        this.mStartTrackers = new HashSet();
        this.mSkipTrackers = new HashSet();
        this.mCloseTrackers = new HashSet();
        this.mMonitorClickers = new HashSet();
        this.mRewardTimeDefault = 15;
        this.mSkipTimeDefault = 5;
        this.mConversionUrls = new HashSet();
        this.mAdJsonObject = object;
        try {
            this.mGdtAd = true;
            this.mAdId = object.optString(IGdtAdResonseInfo.AD_ADID, "-1");
            this.mIconUrl = object.optString("icon_url", "");
            this.mTitle = object.optString("title", "");
            this.mDescription = object.optString("description", "");
            this.mAppName = object.optString("app_name", "");
            this.mPackageName = object.optString(IGdtAdResonseInfo.AD_APP_BUNDLE, "");
            this.mActionType = object.optInt(IGdtAdResonseInfo.AD_INTERACT_TYPE) + 1;
            this.mClickUrl = object.optString(IGdtAdResonseInfo.AD_TARGET_URL);
            this.createTime = System.currentTimeMillis();
            if (object.has("images")) {
                JSONArray array = object.optJSONArray("images");
                if (!(array == null || array.length() <= 0 || (imageObject = array.optJSONObject(0)) == null)) {
                    this.mPictureUrl = imageObject.optString("url", "");
                }
            }
            if (object.has("video") && (videoObject = object.optJSONObject("video")) != null) {
                this.mVideoUrl = videoObject.optString("url", "");
                this.mVideoWidth = videoObject.optInt("width", 0);
                this.mVideoHeight = videoObject.optInt("height", 0);
                this.mDuration = videoObject.optInt("duration", 0);
            }
            if (object.has(IGdtAdResonseInfo.AD_IMP_URLS)) {
                JSONArray array2 = object.optJSONArray(IGdtAdResonseInfo.AD_IMP_URLS);
                int i2 = 0;
                while (array2 != null && i2 < array2.length()) {
                    if (!TextUtils.isEmpty(array2.optString(i2))) {
                        this.mImpressionUrls.add(array2.optString(i2));
                    }
                    i2++;
                }
            }
            if (object.has(IGdtAdResonseInfo.AD_CLICK_URLS)) {
                JSONArray array3 = object.optJSONArray(IGdtAdResonseInfo.AD_CLICK_URLS);
                int i3 = 0;
                while (array3 != null && i3 < array3.length()) {
                    addThirdClickMonitorTrackers(array3.optString(i3));
                    i3++;
                }
            }
            if (object.has(IGdtAdResonseInfo.AD_VIDEO_PLAY_URLS)) {
                JSONArray array4 = object.optJSONArray(IGdtAdResonseInfo.AD_VIDEO_PLAY_URLS);
                int i4 = 0;
                while (array4 != null && i4 < array4.length()) {
                    addCloseMonitorTrackers(array4.optString(i4));
                    i4++;
                }
            }
            if (object.has(IGdtAdResonseInfo.AD_CONVERSION_URLS)) {
                JSONArray array5 = object.optJSONArray(IGdtAdResonseInfo.AD_CONVERSION_URLS);
                int i5 = 0;
                while (array5 != null && i5 < array5.length()) {
                    addConversionUrls(array5.optString(i5));
                    i5++;
                }
            }
            this.mExpire = object.optInt(IAdResonseInfo.EXPIRATION, 0);
            this.mUniqueId = this.mAdId + "_" + new Random().nextLong() + System.currentTimeMillis() + "|";
        } catch (Exception e2) {
        }
    }

    private AdElementInfo(Parcel in) {
        this.mAdId = "-1";
        this.mImpressionUrls = new HashSet();
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        this.mThirdImpMonitorTrackers = new HashSet();
        this.mThirdClickMonitorTrackers = new HashSet();
        this.mStartTrackers = new HashSet();
        this.mSkipTrackers = new HashSet();
        this.mCloseTrackers = new HashSet();
        this.mMonitorClickers = new HashSet();
        this.mRewardTimeDefault = 15;
        this.mSkipTimeDefault = 5;
        this.mConversionUrls = new HashSet();
        this.mQueryKey = in.readString();
        this.mAdId = in.readString();
        this.mTitle = in.readString();
        this.mDescription = in.readString();
        this.mIconUrl = in.readString();
        this.mType = in.readString();
        this.mActionType = in.readInt();
        this.mAntiTag = in.readInt();
        this.mClickUrl = in.readString();
        this.mPictureUrl = in.readString();
        this.mVideoUrl = in.readString();
        this.mVideoWidth = in.readInt();
        this.mVideoHeight = in.readInt();
        this.mDuration = in.readInt();
        this.mCloseType = in.readInt();
        this.mExpire = in.readInt();
        this.mAppName = in.readString();
        this.mPackageName = in.readString();
        this.mApkName = in.readString();
        this.mAppSize = in.readLong();
        this.mPage = in.readString();
        this.mVersion = in.readString();
        this.mFallback = in.readString();
        this.mFbAct = in.readString();
        this.mRewardTime = in.readInt();
        this.mSkipTime = in.readInt();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mQueryKey);
        dest.writeString(this.mAdId);
        dest.writeString(this.mTitle);
        dest.writeString(this.mDescription);
        dest.writeString(this.mIconUrl);
        dest.writeString(this.mType);
        dest.writeInt(this.mActionType);
        dest.writeInt(this.mAntiTag);
        dest.writeString(this.mClickUrl);
        dest.writeString(this.mPictureUrl);
        dest.writeString(this.mVideoUrl);
        dest.writeInt(this.mVideoWidth);
        dest.writeInt(this.mVideoHeight);
        dest.writeInt(this.mDuration);
        dest.writeInt(this.mCloseType);
        dest.writeInt(this.mExpire);
        dest.writeString(this.mAppName);
        dest.writeString(this.mPackageName);
        dest.writeString(this.mApkName);
        dest.writeLong(this.mAppSize);
        dest.writeString(this.mPage);
        dest.writeString(this.mVersion);
        dest.writeString(this.mFallback);
        dest.writeString(this.mFbAct);
        dest.writeInt(this.mRewardTime);
        dest.writeInt(this.mSkipTime);
    }

    public String getAdId() {
        return this.mAdId;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getType() {
        return this.mType;
    }

    public String getPictureUrl() {
        return this.mPictureUrl;
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    public int getAntiTag() {
        return this.mAntiTag;
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public int getRewardTime() {
        if (getCloseType() == 6) {
            return this.mRewardTime;
        }
        return this.mRewardTimeDefault;
    }

    public int getSkipTime() {
        if (getCloseType() == 6) {
            return this.mSkipTime;
        }
        return this.mSkipTimeDefault;
    }

    public String getEndFrameUrl() {
        return this.mEndFrameUrl;
    }

    public int getCloseType() {
        return this.mCloseType;
    }

    public String getClickUrl() {
        return this.mClickUrl;
    }

    public String getPrivacyUrl() {
        return this.mPrivacyUrl;
    }

    public String getPermissionUrl() {
        return this.mPermissionUrl;
    }

    public String getFunctionUrl() {
        return this.mFunctionUrl;
    }

    public int getActionType() {
        return this.mActionType;
    }

    public String getQueryKey() {
        return this.mQueryKey;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public String getAppName() {
        return this.mAppName;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public String getPublisher() {
        return this.mPublisher;
    }

    public int getDlDialog() {
        return this.dlDialog;
    }

    public long getAppSize() {
        return this.mAppSize;
    }

    public JSONObject getAdJsonObject() {
        return this.mAdJsonObject;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public int describeContents() {
        return 0;
    }

    public String getUniqueId() {
        return this.mUniqueId;
    }

    public String getPage() {
        return this.mPage;
    }

    public int getExpired() {
        return this.mExpire;
    }

    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    public String getBannerHtml() {
        return this.mBannerHtml;
    }

    public String getLandBannerHtml() {
        return this.mLandBannerHtml;
    }

    public String getEndFrameHtml() {
        return this.mEndFrameHtml;
    }

    public List<String> getImpressionUrls() {
        return new ArrayList(this.mImpressionUrls);
    }

    public JSONObject getAdMonitors() {
        return this.mAdMonitors;
    }

    public List<String> getThirdImpressionTrackingUrls() {
        return new ArrayList(this.mThirdImpMonitorTrackers);
    }

    public List<String> getThirdClickTrackingUrls() {
        return new ArrayList(this.mThirdClickMonitorTrackers);
    }

    public List<String> getStartTrackers() {
        return new ArrayList(this.mStartTrackers);
    }

    public List<String> getSkipTrackers() {
        return new ArrayList(this.mSkipTrackers);
    }

    public List<String> getCloseTrackers() {
        return new ArrayList(this.mCloseTrackers);
    }

    public List<String> getConversionUrls() {
        return new ArrayList(this.mConversionUrls);
    }

    private void addThirdImpMonitorTrackers(String thirdImpMonitorUrl) {
        if (!TextUtils.isEmpty(thirdImpMonitorUrl)) {
            this.mThirdImpMonitorTrackers.add(thirdImpMonitorUrl);
        }
    }

    private void addThirdClickMonitorTrackers(String thirdClickMonitorUrl) {
        if (!TextUtils.isEmpty(thirdClickMonitorUrl)) {
            this.mThirdClickMonitorTrackers.add(thirdClickMonitorUrl);
        }
    }

    private void addStartMonitorTrackers(String startTracker) {
        if (!TextUtils.isEmpty(startTracker)) {
            this.mStartTrackers.add(startTracker);
        }
    }

    private void addSkipMonitorTrackers(String skipTracker) {
        if (!TextUtils.isEmpty(skipTracker)) {
            this.mSkipTrackers.add(skipTracker);
        }
    }

    private void addCloseMonitorTrackers(String closeTracker) {
        if (closeTracker != null && !closeTracker.equals("")) {
            this.mCloseTrackers.add(closeTracker);
        }
    }

    private void addMonitorClickTrackers(String closeTracker) {
        if (closeTracker != null && !closeTracker.equals("")) {
            this.mMonitorClickers.add(closeTracker);
        }
    }

    private void addConversionUrls(String url) {
        if (!TextUtils.isEmpty(url)) {
            this.mConversionUrls.add(url);
        }
    }

    public boolean isGdtAd() {
        return this.mGdtAd;
    }
}
