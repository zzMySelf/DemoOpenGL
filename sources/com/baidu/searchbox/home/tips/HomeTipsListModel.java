package com.baidu.searchbox.home.tips;

import android.text.TextUtils;
import com.baidu.searchbox.NoProGuard;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class HomeTipsListModel implements NoProGuard {
    private static final String BOOLEAN_FALSE_STRING = "0";
    private static final String BOOLEAN_TRUE_STRING = "1";
    @SerializedName("depend_splash")
    private String mIsDependSplash;
    @SerializedName("link_splash")
    private String mIsLinkSplash;
    @SerializedName("md5")
    private String mMd5;
    @SerializedName("list")
    private List<HomeTipsItemModel> mTipsModelList;
    @SerializedName("url")
    private String mUrl;

    public List<HomeTipsItemModel> getTipsModelList() {
        return this.mTipsModelList;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String getMd5() {
        return this.mMd5;
    }

    public boolean isLinkSplash() {
        return TextUtils.equals(this.mIsLinkSplash, "1");
    }

    public boolean isDependSplash() {
        return TextUtils.equals(this.mIsDependSplash, "1");
    }
}
