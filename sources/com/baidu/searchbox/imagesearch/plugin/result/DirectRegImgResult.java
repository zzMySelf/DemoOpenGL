package com.baidu.searchbox.imagesearch.plugin.result;

import com.baidu.searchbox.imagesearch.plugin.base.BaseResult;

public class DirectRegImgResult extends BaseResult {
    private String mCategoryResult;
    private String mFrom;
    private String mImageSearchId;
    private String mImgUri;
    private int mMemoryLevel = 0;
    private int mMultiResourceState = 0;
    private boolean mNeedShowLog = false;
    private boolean mShowLogUploaded = false;

    public void setFrom(String from) {
        this.mFrom = from;
    }

    public void setImageSearchId(String imageSearchId) {
        this.mImageSearchId = imageSearchId;
    }

    public void setImgUri(String imgUri) {
        this.mImgUri = imgUri;
    }

    public void setShowLogUploaded(boolean showLogUploaded) {
        this.mShowLogUploaded = showLogUploaded;
    }

    public void setNeedShowLog(boolean needShowLog) {
        this.mNeedShowLog = needShowLog;
    }

    public void setCategoryResult(String categoryResult) {
        this.mCategoryResult = categoryResult;
    }

    public void setMultiResourceState(int multiResourceState) {
        this.mMultiResourceState = multiResourceState;
    }

    public void setMemoryLevel(int memoryLevel) {
        this.mMemoryLevel = memoryLevel;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String getImageSearchId() {
        return this.mImageSearchId;
    }

    public String getImgUri() {
        return this.mImgUri;
    }

    public boolean getShowLogUploaded() {
        return this.mShowLogUploaded;
    }

    public boolean getNeedShowLog() {
        return this.mNeedShowLog;
    }

    public String getCategoryResult() {
        return this.mCategoryResult;
    }

    public int getMultiResourceState() {
        return this.mMultiResourceState;
    }

    public int getMemoryLevel() {
        return this.mMemoryLevel;
    }
}
