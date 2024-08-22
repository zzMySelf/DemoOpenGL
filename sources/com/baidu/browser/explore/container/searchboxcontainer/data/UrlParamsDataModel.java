package com.baidu.browser.explore.container.searchboxcontainer.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class UrlParamsDataModel implements Serializable {
    @SerializedName("pageType")
    @Expose
    private int mPageType;
    @SerializedName("url")
    @Expose
    private String mUrl;

    public UrlParamsDataModel() {
    }

    public UrlParamsDataModel(String mUrl2, int pageType) {
        this.mUrl = mUrl2;
        this.mPageType = pageType;
    }

    public String getmUrl() {
        return this.mUrl;
    }

    public boolean isLoadingPage() {
        return this.mPageType == 16;
    }

    public int getType() {
        return this.mPageType;
    }
}
