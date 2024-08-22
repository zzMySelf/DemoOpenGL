package com.baidu.swan.apps.toppingdata;

import android.text.TextUtils;
import com.baidu.swan.api.SwanAppApi;

public class SwanToppingItemData {
    private int mAppFrameType = -1;
    private String mAppKey = "";
    private String mAppName = "";
    private String mIconUrl = "";
    private String mLiveScheme;
    private long mLiveStartTime;
    private int mPayProtected = 0;
    private String mRootSource;
    private int mSortIndex;
    private long mToppingTime;

    public String getScheme(String fromValue) {
        if (TextUtils.isEmpty(fromValue) || TextUtils.isEmpty(this.mAppKey) || this.mAppFrameType == -1) {
            return null;
        }
        return SwanAppApi.getFrameworkRuntime().getSwanAppLaunchScheme(this.mAppKey, fromValue, this.mAppFrameType);
    }

    public int getAppType() {
        return 0;
    }

    public boolean isLiveNow() {
        return getLiveStartTime() > 0 && !TextUtils.isEmpty(getLiveScheme());
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public void setAppKey(String appKey) {
        this.mAppKey = appKey;
    }

    public String getAppName() {
        return this.mAppName;
    }

    public void setAppName(String appName) {
        this.mAppName = appName;
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.mIconUrl = iconUrl;
    }

    public int getPayProtected() {
        return this.mPayProtected;
    }

    public void setPayProtected(int payProtected) {
        this.mPayProtected = payProtected;
    }

    public int getAppFrameType() {
        return this.mAppFrameType;
    }

    public void setAppFrameType(int appFrameType) {
        this.mAppFrameType = appFrameType;
    }

    public long getToppingTime() {
        return this.mToppingTime;
    }

    public void setToppingTime(long toppingTime) {
        this.mToppingTime = toppingTime;
    }

    public long getLiveStartTime() {
        return this.mLiveStartTime;
    }

    public void setLiveStartTime(long liveStartTime) {
        this.mLiveStartTime = liveStartTime;
    }

    public String getLiveScheme() {
        return this.mLiveScheme;
    }

    public void setLiveScheme(String liveScheme) {
        this.mLiveScheme = liveScheme;
    }

    public String getRootSource() {
        return this.mRootSource;
    }

    public void setRootSource(String rootSource) {
        this.mRootSource = rootSource;
    }

    public int getSortIndex() {
        return this.mSortIndex;
    }

    public void setSortIndex(int sortIndex) {
        this.mSortIndex = sortIndex;
    }
}
