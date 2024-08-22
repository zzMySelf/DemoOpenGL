package com.baidu.down.manage;

import android.util.Pair;
import com.baidu.chatsearch.aisearch.resultpage.toolbar.discovery.span.RhetoricalTagUtilKt;
import com.baidu.down.common.DownDetail;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Download {
    private static final DecimalFormat DFOEMAT = new DecimalFormat("###0.0");
    private Long mControlFlag = 9L;
    private Long mCurrentbytes = 0L;
    DownDetail mDownDetail = new DownDetail();
    private String mDownDir = "";
    private String mEtag = "";
    private String mFailedReason = "";
    private Integer mFailedType = -1;
    private String mFileName = "";
    private String mFromParam;
    private Long mId;
    private String mKeyByUser;
    float mLastProgressNoti = 0.0f;
    long mLastProgressNotiStamp = 0;
    long mLastProgressSaveStamp = 0;
    long mLastSpeed = 0;
    private String mMimetype = "";
    boolean mNeedDeleteFile = true;
    private boolean mNotificationNeeded = false;
    private int mPriority = 3;
    private String mProgressmap = "";
    private String mRealUrl = "";
    private String mRedownloadReason = "";
    String mRequestHeader = "";
    List<Pair<String, String>> mRequestHeaders = new ArrayList();
    private String mSavedPathForUser = "";
    private String mSize;
    private Integer mStatus = Integer.valueOf(DownloadState.WAITING.ordinal());
    private Long mTotalbytes = 0L;
    private String mUrihost = "";
    private String mUrl = "";

    public Long getId() {
        return this.mId;
    }

    /* access modifiers changed from: package-private */
    public void setId(Long id) {
        this.mId = id;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void setUrl(String url) {
        this.mUrl = url;
    }

    public String getRealUrl() {
        return this.mRealUrl;
    }

    public void setRealUrl(String realUrl) {
        this.mRealUrl = realUrl;
    }

    public String getFileName() {
        return this.mFileName;
    }

    public void setFileName(String fileName) {
        this.mFileName = fileName;
    }

    /* access modifiers changed from: package-private */
    public String getSavedPathForUser() {
        return this.mSavedPathForUser;
    }

    public void setSavedPathForUser(String savedPathForUser) {
        this.mSavedPathForUser = savedPathForUser;
    }

    public boolean getNotificationNeeded() {
        return this.mNotificationNeeded;
    }

    public void setNotificationNeeded(boolean notificationNeeded) {
        this.mNotificationNeeded = notificationNeeded;
    }

    public String getMimetype() {
        return this.mMimetype;
    }

    public void setMimetype(String mimetype) {
        this.mMimetype = mimetype;
    }

    /* access modifiers changed from: package-private */
    public String getEtag() {
        return this.mEtag;
    }

    /* access modifiers changed from: package-private */
    public void setEtag(String etag) {
        this.mEtag = etag;
    }

    /* access modifiers changed from: package-private */
    public Integer getStatus() {
        return this.mStatus;
    }

    /* access modifiers changed from: package-private */
    public void setStatus(Integer status) {
        this.mStatus = status;
    }

    public Long getTotalbytes() {
        return this.mTotalbytes;
    }

    /* access modifiers changed from: package-private */
    public void setTotalbytes(Long totalbytes) {
        this.mTotalbytes = totalbytes;
    }

    public Long getCurrentbytes() {
        return this.mCurrentbytes;
    }

    /* access modifiers changed from: package-private */
    public void setCurrentbytes(Long currentbytes) {
        this.mCurrentbytes = currentbytes;
    }

    public String getFailedReason() {
        return this.mFailedReason;
    }

    /* access modifiers changed from: package-private */
    public void setFailedReason(String failedReason) {
        this.mFailedReason = failedReason;
    }

    public Integer getFailedType() {
        return this.mFailedType;
    }

    /* access modifiers changed from: package-private */
    public void setFailedType(Integer failedType) {
        this.mFailedType = failedType;
    }

    /* access modifiers changed from: package-private */
    public String getProgressmap() {
        return this.mProgressmap;
    }

    /* access modifiers changed from: package-private */
    public void setProgressmap(String progressmap) {
        this.mProgressmap = progressmap;
    }

    /* access modifiers changed from: package-private */
    public String getUrihost() {
        return this.mUrihost;
    }

    /* access modifiers changed from: package-private */
    public void setUrihost(String urihost) {
        this.mUrihost = urihost;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public void setPriority(int priority) {
        this.mPriority = priority;
    }

    public Boolean isAutoPause() {
        return Boolean.valueOf(hasControlFlag(2));
    }

    /* access modifiers changed from: package-private */
    public void setAutoPause(Boolean autopause) {
        if (autopause.booleanValue()) {
            addControlFlag(2);
        } else {
            removeControlFlag(2);
        }
    }

    /* access modifiers changed from: package-private */
    public Boolean getSupportrange() {
        return Boolean.valueOf(hasControlFlag(1));
    }

    /* access modifiers changed from: package-private */
    public void setSupportrange(Boolean supportrange) {
        if (supportrange.booleanValue()) {
            addControlFlag(1);
        } else {
            removeControlFlag(1);
        }
    }

    public boolean isWifiOnly() {
        return hasControlFlag(4);
    }

    public void setWifiOnly(boolean wifiOnly) {
        if (wifiOnly) {
            addControlFlag(4);
        } else {
            removeControlFlag(4);
        }
    }

    /* access modifiers changed from: package-private */
    public Long getControlFlag() {
        return this.mControlFlag;
    }

    /* access modifiers changed from: package-private */
    public void setControlFlag(Long controlFlag) {
        this.mControlFlag = controlFlag;
    }

    /* access modifiers changed from: package-private */
    public void addRequestHeader(String header, String value) {
        if (header == null) {
            throw new NullPointerException("header cannot be null");
        } else if (!header.contains(":")) {
            if (value == null) {
                value = "";
            }
            this.mRequestHeaders.add(Pair.create(header, value));
        } else {
            throw new IllegalArgumentException("header may not contain ':'");
        }
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[mUrl=").append(this.mUrl).append(RhetoricalTagUtilKt.TAG_END_SYMBOL).append("[mFileName=").append(this.mFileName).append(RhetoricalTagUtilKt.TAG_END_SYMBOL).append("[mSavedPath=").append(this.mSavedPathForUser).append(RhetoricalTagUtilKt.TAG_END_SYMBOL).append("[mFileLength=").append(this.mTotalbytes).append(RhetoricalTagUtilKt.TAG_END_SYMBOL).append("[mCurrentLength=").append(this.mCurrentbytes).append(RhetoricalTagUtilKt.TAG_END_SYMBOL).append("[mState=").append(this.mStatus).append(RhetoricalTagUtilKt.TAG_END_SYMBOL).append("[mFailReason=").append(this.mStatus).append(RhetoricalTagUtilKt.TAG_END_SYMBOL).append("[mId=").append(this.mId).append(RhetoricalTagUtilKt.TAG_END_SYMBOL).append("[mProgressmap=").append(this.mProgressmap).append(RhetoricalTagUtilKt.TAG_END_SYMBOL).append("[mEtag=").append(this.mEtag).append(RhetoricalTagUtilKt.TAG_END_SYMBOL).append("[mMimeType=").append(this.mMimetype).append(RhetoricalTagUtilKt.TAG_END_SYMBOL).append("[mSavedPathForUser=").append(this.mSavedPathForUser).append(RhetoricalTagUtilKt.TAG_END_SYMBOL);
        return sb.toString();
    }

    public enum DownloadState {
        WAITING,
        DOWNLOADING,
        PAUSE,
        FAILED,
        CANCEL,
        FINISH,
        UNKNOWN;

        public static DownloadState getState(int state) {
            switch (state) {
                case 0:
                    return WAITING;
                case 1:
                    return DOWNLOADING;
                case 2:
                    return PAUSE;
                case 3:
                    return FAILED;
                case 4:
                    return CANCEL;
                case 5:
                    return FINISH;
                default:
                    return UNKNOWN;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public String getDownloadFileName() {
        return new File(this.mSavedPathForUser, this.mFileName).getPath();
    }

    public float getCurrentProgress() {
        if (this.mCurrentbytes.longValue() == 0 || this.mTotalbytes.longValue() == 0) {
            return 0.0f;
        }
        float progress = ((float) (this.mCurrentbytes.longValue() * 100)) / ((float) this.mTotalbytes.longValue());
        if (progress >= 100.0f) {
            return 99.99f;
        }
        return progress;
    }

    /* access modifiers changed from: package-private */
    public String getExactProgressString() {
        return DFOEMAT.format((double) getCurrentProgress());
    }

    public DownloadState getState() {
        return DownloadState.values()[this.mStatus.intValue()];
    }

    /* access modifiers changed from: package-private */
    public void setState(DownloadState state) {
        this.mStatus = Integer.valueOf(state.ordinal());
    }

    /* access modifiers changed from: package-private */
    public String getRedownloadReason() {
        return this.mRedownloadReason;
    }

    /* access modifiers changed from: package-private */
    public void setRedownloadReason(String reason) {
        this.mRedownloadReason = reason;
    }

    /* access modifiers changed from: package-private */
    public boolean isCheckConentType() {
        return hasControlFlag(8);
    }

    /* access modifiers changed from: package-private */
    public void setCheckContentType(boolean isCheck) {
        if (isCheck) {
            addControlFlag(8);
        } else {
            removeControlFlag(8);
        }
    }

    private void addControlFlag(long flag) {
        this.mControlFlag = Long.valueOf(this.mControlFlag.longValue() | flag);
    }

    private void removeControlFlag(long flag) {
        this.mControlFlag = Long.valueOf(this.mControlFlag.longValue() & (~flag));
    }

    private boolean hasControlFlag(long flag) {
        return (this.mControlFlag.longValue() & flag) > 0;
    }

    public String getRealDownloadDir() {
        return this.mDownDir;
    }

    /* access modifiers changed from: package-private */
    public void setDownDir(String downDir) {
        this.mDownDir = downDir;
    }

    public String getFromParam() {
        return this.mFromParam;
    }

    public void setNeedDeleteFile(boolean needDeleteFile) {
        this.mNeedDeleteFile = needDeleteFile;
    }

    public void setFromParam(String fromParam) {
        this.mFromParam = fromParam;
    }

    public String getKeyByUser() {
        return this.mKeyByUser;
    }

    public void setKeyByUser(String keyByUser) {
        this.mKeyByUser = keyByUser;
    }
}
