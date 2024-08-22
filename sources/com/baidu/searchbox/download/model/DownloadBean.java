package com.baidu.searchbox.download.model;

import android.content.ContentUris;
import android.net.Uri;

public class DownloadBean {
    private long mCurrentBytes;
    private long mDownloadId;
    private DownloadState mDownloadState;
    private String mExtraInfo;
    private String mFilePath;
    private int mProgress;
    private long mSpeedBytes;
    private int mStatus;
    private long mTotalBytes;
    private Uri mUri;

    public DownloadBean() {
        this.mDownloadState = DownloadState.NOT_START;
        this.mUri = null;
        this.mDownloadId = -1;
    }

    public DownloadBean(Uri uri) {
        this.mDownloadState = DownloadState.NOT_START;
        this.mUri = uri;
        this.mDownloadId = ContentUris.parseId(uri);
    }

    public void setDownloadState(DownloadState state) {
        this.mDownloadState = state;
    }

    public DownloadState getDownloadState() {
        return this.mDownloadState;
    }

    public void setCurrentBytes(long current) {
        this.mCurrentBytes = current;
    }

    public long getCurrentBytes() {
        return this.mCurrentBytes;
    }

    public void setTotalBytes(long totalbytes) {
        this.mTotalBytes = totalbytes;
    }

    public long getTotalBytes() {
        return this.mTotalBytes;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void setProgress(int progress) {
        if (progress < 0) {
            progress = 0;
        } else if (progress > 100) {
            progress = 100;
        }
        this.mProgress = progress;
    }

    public void setUri(Uri uri) {
        this.mUri = uri;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public void setDownloadId(int downloadId) {
        this.mDownloadId = (long) downloadId;
    }

    public long getDownloadId() {
        return this.mDownloadId;
    }

    public void setSpeed(long speed) {
        this.mSpeedBytes = speed;
    }

    public long getSpeed() {
        return this.mSpeedBytes;
    }

    public void setStatus(int status) {
        this.mStatus = status;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    public void setFilePath(String filefPath) {
        this.mFilePath = filefPath;
    }

    public String getExtraInfo() {
        return this.mExtraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.mExtraInfo = extraInfo;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DownloadBean=(uri: " + this.mUri);
        sb.append(", current bytes: " + this.mCurrentBytes);
        sb.append(", total bytes: " + this.mTotalBytes);
        sb.append(", speed: " + this.mSpeedBytes);
        sb.append(", status: " + this.mStatus);
        sb.append(", state: " + this.mDownloadState);
        sb.append(", filePath: " + this.mFilePath);
        sb.append(")");
        return sb.toString();
    }
}
