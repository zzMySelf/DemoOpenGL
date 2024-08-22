package com.baidu.netdisk.transfer.io.model;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class UploadTaskModel {
    private int mCategory;
    private long mCreateTime;
    private int mErrorCode;
    private String mErrorMsg;
    private String mFileName;
    private long mFileSize;
    private String mFsId;
    private int mIsDir;
    private long mOffsetSize;
    private long mRate;
    private long mSize;
    private int mState;
    private int mTaskId;
    private String mTaskLocalPath;
    private String mTaskRemotePath;

    public int getTaskId() {
        return this.mTaskId;
    }

    public void setTaskId(int mTaskId2) {
        this.mTaskId = mTaskId2;
    }

    public String getFileName() {
        return this.mFileName;
    }

    public void setFileName(String mFileName2) {
        this.mFileName = mFileName2;
    }

    public long getFileSize() {
        return this.mFileSize;
    }

    public void setFileSize(long mFileSize2) {
        this.mFileSize = mFileSize2;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public void setCreateTime(long mCreateTime2) {
        this.mCreateTime = mCreateTime2;
    }

    public String getTaskLocalPath() {
        return this.mTaskLocalPath;
    }

    public void setTaskLocalPath(String mTaskLocalPath2) {
        this.mTaskLocalPath = mTaskLocalPath2;
    }

    public String getTaskRemotePath() {
        return this.mTaskRemotePath;
    }

    public void setTaskRemotePath(String mTaskRemotePath2) {
        this.mTaskRemotePath = mTaskRemotePath2;
    }

    public String getFsId() {
        return this.mFsId;
    }

    public void setFsId(String mFsId2) {
        this.mFsId = mFsId2;
    }

    public int getCategory() {
        return this.mCategory;
    }

    public void setCategory(int mCategory2) {
        this.mCategory = mCategory2;
    }

    public int getIsDir() {
        return this.mIsDir;
    }

    public void setIsDir(int mIsDir2) {
        this.mIsDir = mIsDir2;
    }

    public int getState() {
        return this.mState;
    }

    public void setState(int mState2) {
        this.mState = mState2;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public void setErrorCode(int mErrorCode2) {
        this.mErrorCode = mErrorCode2;
    }

    public String getErrorMsg() {
        return this.mErrorMsg;
    }

    public void setErrorMsg(String mErrorMsg2) {
        this.mErrorMsg = mErrorMsg2;
    }

    public long getSize() {
        return this.mSize;
    }

    public void setSize(long size) {
        this.mSize = size;
    }

    public long getOffsetSize() {
        return this.mOffsetSize;
    }

    public void setOffsetSize(long offsetSize) {
        this.mOffsetSize = offsetSize;
    }

    public long getRate() {
        return this.mRate;
    }

    public void setRate(long rate) {
        this.mRate = rate;
    }

    public String toString() {
        return "UploadTaskModel{mTaskId=" + this.mTaskId + ", mFileName='" + this.mFileName + '\'' + ", mFileSize=" + this.mFileSize + ", mCreateTime=" + this.mCreateTime + ", mTaskLocalPath='" + this.mTaskLocalPath + '\'' + ", mTaskRemotePath='" + this.mTaskRemotePath + '\'' + ", mFsId='" + this.mFsId + '\'' + ", mCategory=" + this.mCategory + ", mIsDir=" + this.mIsDir + ", mState=" + this.mState + ", mErrorCode=" + this.mErrorCode + ", mErrorMsg='" + this.mErrorMsg + '\'' + ", mSize=" + this.mSize + ", mOffsetSize=" + this.mOffsetSize + ", mRate=" + this.mRate + AbstractJsonLexerKt.END_OBJ;
    }
}
