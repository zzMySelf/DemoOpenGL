package com.baidu.searchbox.log.core.dao;

import android.text.TextUtils;
import com.baidu.searchbox.log.core.dao.Common;
import com.baidu.searchbox.log.core.db.dao.DBBIZ;
import com.baidu.searchbox.log.core.task.LogUploadProducer;
import com.baidu.searchbox.log.core.util.LogUtil;
import java.io.File;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

public class Log {
    public static final int DEFAULT_SLICE_SIZE = 1048576;
    public static final String KEY_ALIAS = "alias";
    public static final String KEY_DELETE = "delete";
    public static final String KEY_PATH = "path";
    public static final String NULL = "null";
    public String mBIZGroupID;
    public String mBIZID;
    public String mContentUploadStatus = "true";
    public Common.Device mDevice;
    public String mEventType = "0";
    public String mExtra;
    public String mFileID;
    public String mFileMeta;
    public String mGFlow;
    public String mIdType = "1";
    public String mIsAbTest = "0";
    public String mIsFetchBack = "0";
    public String mIsReal = "0";
    public byte[] mLogContent;
    public long mLogFileSize;
    public String mLogLaunchID;
    public long mLogSize;
    public long mLogTimeStamp;
    public String mLogUUID;
    public Common.Perf mPerf;
    public long mTTL;
    public String mTemporary = "0";
    public long mTimeout = DBBIZ.DEFAULT_TIMEOUT;
    public String mType = "0";
    public Common.Version mVersion;
    public File mZipFile;

    public JSONObject contentJson() {
        JSONObject content = new JSONObject();
        try {
            content.put("launchid", this.mLogLaunchID);
            content.put("logid", this.mLogUUID);
            content.put(LogUploadProducer.Constants.CONTENT_APPEXT, this.mExtra);
            content.put("packagename", LogUtil.getPackageName());
            Common.Device device = this.mDevice;
            if (device != null) {
                content.put("osversion", device.mOSVersion);
                content.put("memory", this.mDevice.mMemory);
                content.put("cpu", this.mDevice.mCPU);
            }
            Common.Version version = this.mVersion;
            if (version != null) {
                content.put("sdkversion", version.mSDKVersion);
                content.put("appversion", this.mVersion.mAppVersion);
            }
            Common.Perf perf = this.mPerf;
            if (perf != null) {
                content.put("network", perf.mNetwork);
                content.put("devicescore", this.mPerf.mStaticScore);
            }
            if (!TextUtils.isEmpty(this.mFileID)) {
                content.put("fileid", this.mFileID);
            }
            if (!TextUtils.isEmpty(this.mFileMeta)) {
                content.put("filemeta", this.mFileMeta);
            }
            if (!TextUtils.isEmpty(this.mIsFetchBack) && "1".equals(this.mIsFetchBack)) {
                content.put(LogUploadProducer.Constants.CONTENT_IS_FETCH_BACK, this.mIsFetchBack);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return content;
    }

    public String toString() {
        return "Log{mBIZID='" + this.mBIZID + '\'' + ", mBIZGroupID='" + this.mBIZGroupID + '\'' + ", mLogUUID='" + this.mLogUUID + '\'' + ", mLogLaunchID='" + this.mLogLaunchID + '\'' + ", mLogTimeStamp=" + this.mLogTimeStamp + ", mTTL=" + this.mTTL + ", mPerf=" + this.mPerf + ", mDevice=" + this.mDevice + ", mVersion=" + this.mVersion + ", mExtra='" + this.mExtra + '\'' + ", mLogContent=" + new String(this.mLogContent) + ", mZipFile=" + this.mZipFile + ", mFileID='" + this.mFileID + '\'' + ", mLogSize=" + this.mLogSize + ", mLogFileSize=" + this.mLogFileSize + ", mContentUploadStatus='" + this.mContentUploadStatus + '\'' + ", mType='" + this.mType + '\'' + ", mIsReal='" + this.mIsReal + '\'' + ", mIsAbTest='" + this.mIsAbTest + '\'' + ", mIdType='" + this.mIdType + '\'' + ", mEventType='" + this.mEventType + '\'' + ", mTimeout=" + this.mTimeout + ", mTemporary='" + this.mTemporary + '\'' + ", mFileMeta='" + this.mFileMeta + '\'' + AbstractJsonLexerKt.END_OBJ;
    }
}
