package com.baidu.searchbox.push.subscribes;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public abstract class AbstractSiteInfo {
    public static final String ALLOW_PUSH = "allow_push";
    public static final String APPID = "app_id";
    public static final String CATEGORY = "category";
    public static final String ICON_DATA = "icon";
    public static final String ICON_URL = "icon_url";
    public static final String SITE_STATUS = "site_status";
    public static final String SITE_URL = "site_url";
    public static final String TITLE = "title";
    private String mAppId;
    private String mAppType;
    private int mCategory;
    private String mDes;
    private byte[] mIconData = null;
    private String mIconUrl;
    private boolean mMsgSetting = true;
    private String mShortDes;
    private int mSiteStatus;
    private String mSiteUrl;
    private String mTitle;

    public enum AppType {
        preset,
        bdapp,
        card
    }

    public enum Category {
        LIGHTAPP_CATE,
        BAIDUCUID_CATE,
        SUBSCRIBE_PA_CATE,
        ZHIDA_CATE,
        USER_SUBSCRIBE_CATE
    }

    public abstract int getSubCategory();

    public class SITESTATUS {
        public static final int SITE_STATUS_FOLLOWED = 1;
        public static final int SITE_STATUS_FOLLOWING = 2;
        public static final int SITE_STATUS_UNFOLLOWED = 0;

        public SITESTATUS() {
        }
    }

    public String getAppId() {
        return this.mAppId;
    }

    public void setAppId(String id) {
        this.mAppId = id;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String name) {
        this.mTitle = name;
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.mIconUrl = iconUrl;
    }

    public String getSiteUrl() {
        return this.mSiteUrl;
    }

    public void setSiteUrl(String url) {
        this.mSiteUrl = url;
    }

    public boolean getMsgSetting() {
        return this.mMsgSetting;
    }

    public void setMsgSetting(boolean msgSetting) {
        this.mMsgSetting = msgSetting;
    }

    public int getCategory() {
        return this.mCategory;
    }

    public void setCategory(int category) {
        this.mCategory = category;
    }

    public byte[] getIconData() {
        return this.mIconData;
    }

    public void setIconData(byte[] iconData) {
        this.mIconData = iconData;
    }

    public int getSiteStatus() {
        return this.mSiteStatus;
    }

    public void setSiteStatus(int siteStatus) {
        this.mSiteStatus = siteStatus;
    }

    public Bitmap getIconBitmap() {
        byte[] bArr;
        if (this.mIconUrl == null || (bArr = this.mIconData) == null) {
            return null;
        }
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, (BitmapFactory.Options) null);
    }

    public String getDes() {
        return this.mDes;
    }

    public void setDes(String des) {
        this.mDes = des;
    }

    public String getshortDes() {
        return this.mShortDes;
    }

    public void setShortDes(String shortDes) {
        this.mShortDes = shortDes;
    }

    public String getAppType() {
        return this.mAppType;
    }

    public void setAppType(String appType) {
        this.mAppType = appType;
    }
}
