package com.baidu.down.request.task;

import android.content.Context;
import com.baidu.chatsearch.aisearch.resultpage.toolbar.discovery.span.RhetoricalTagUtilKt;
import com.baidu.down.common.DownConstants;
import com.baidu.down.common.TaskMsg;
import com.baidu.down.common.intercepter.IIntercepter;
import com.baidu.down.loopj.android.http.BinaryHttpResponseHandler;
import com.baidu.down.retry.HttpRetryStrategyHandler;
import com.baidu.down.statistic.TaskSpeedStat;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractTask implements DownConstants, Comparable<AbstractTask> {
    public static final int DF_SEG_SIZE = 524288;
    public static int DF_SEG_WRITE_SIZE = 524288;
    public static final int MODE_HTTPCLIENT_COMMON = 0;
    public static final int MODE_HTTPCLIENT_MULTISRC = 1;
    public static final int MODE_MULTISRC_MASK = 1;
    public static final int MODE_OKHTTP_COMMON = 16;
    public static final int MODE_OKHTTP_MASK = 16;
    public static final int MODE_OKHTTP_MULTISRC = 17;
    public static final int RANGE_BLOCK_SIZE = 307200;
    public static final int TASK_TYPE_MUTI = 3;
    public static final int TASK_TYPE_NARMAL = 1;
    public static final int TASK_TYPE_WAP = 2;
    public static final int URL_TYPE_DEFAULT = 0;
    public static final int URL_TYPE_FASTEST = 2;
    public static final int URL_TYPE_NOT_MEASURE = 1;
    public static int bufferSize = 16384;
    public static long minSegLen = 524288;
    public RandomAccessFile fout;
    public boolean isReplace;
    public boolean mBNotifyStart = false;
    public Context mContext;
    public long mCurLength;
    public int mDownInfoMode;
    public String mDownInfoParams;
    public long mDownloadId = -1;
    public String mDownloadType;
    public String mDownloadUri = "";
    public String mETag = "";
    public File mFile = null;
    public String mFileDir = "";
    public String mFilePath = "";
    public String mFilename = "";
    public String mFromParam;
    public HashMap<String, String> mHeaders;
    public String mHost;
    public HttpRetryStrategyHandler mHttpRetryStrategyHandler;
    public Map<String, IIntercepter<?>> mIntercepters = new HashMap();
    public boolean mIsVisibility = true;
    public boolean mKeepNameAndPath = false;
    public long mLastNotifyBytes = 0;
    public long mLastNotifySpeed = 0;
    public long mLastNotifyTime = 0;
    public boolean mLengthRec = false;
    public int mMaxTestIpCount = 2;
    public int mMaxThread = 2;
    public String mMimetype = "";
    public boolean mNeedMuti = false;
    private int mPriority = 3;
    public ProgressInfo mProgressInfo = new ProgressInfo();
    public String mRealUrl = "";
    public int mRetryCount = 0;
    public String mSid;
    public String mSize;
    public long mSizeB;
    public long mStartTime;
    public int mStatus = -1;
    public String mStrRedownload = "";
    public BinaryHttpResponseHandler mTaskHandler;
    public TaskSpeedStat mTaskSpeedStat;
    public int mTaskType;
    public TaskMsg mTaskmsg;
    public int mThreadCount = 0;
    public String mTj;
    public long mTotalLength = 0;
    public String mUri = "";
    public long mWriteFileLastTime = 0;
    public Context myContext = null;
    public boolean needThumbnail;
    public boolean needWriteDb;

    public abstract String getDefaultUrl();

    public abstract String getFastestUrl();

    public abstract String getNoMeasuredUrl(boolean z);

    public abstract void pause();

    public abstract void pend();

    public abstract void start();

    public abstract void stop(boolean z);

    public AbstractTask(int taskType) {
        this.mTaskType = taskType;
    }

    public String getTaskKey() {
        return this.mUri + this.mDownloadId;
    }

    public int compareTo(AbstractTask another) {
        AbstractTask abstractTask = another;
        int i2 = this.mPriority;
        int i3 = abstractTask.mPriority;
        if (i2 > i3) {
            return -1;
        }
        if (i2 != i3) {
            return 1;
        }
        long j2 = this.mLastNotifyBytes;
        if (j2 > 0) {
            long j3 = this.mTotalLength;
            if (j3 > 0) {
                long j4 = this.mLastNotifySpeed;
                if (j4 > 0) {
                    long j5 = abstractTask.mLastNotifyBytes;
                    if (j5 > 0) {
                        long j6 = abstractTask.mTotalLength;
                        if (j6 > 0) {
                            long j7 = abstractTask.mLastNotifySpeed;
                            if (j7 > 0) {
                                long leftTime = (j3 - j2) / j4;
                                long anotherLeftTime = (j6 - j5) / j7;
                                if (leftTime > anotherLeftTime) {
                                    return 1;
                                }
                                if (leftTime < anotherLeftTime) {
                                    return -1;
                                }
                                return 0;
                            }
                        }
                    }
                }
            }
        }
        if (this.mTotalLength != 0) {
            return 0;
        }
        long j8 = this.mSizeB;
        if (j8 <= 0 || abstractTask.mTotalLength != 0) {
            return 0;
        }
        long j9 = abstractTask.mSizeB;
        if (j9 <= 0) {
            return 0;
        }
        if (j8 > j9) {
            return 1;
        }
        if (j8 < j9) {
            return -1;
        }
        return 0;
    }

    public void setPriority(int priority) {
        if (priority < 1) {
            priority = 1;
        } else if (priority > 5) {
            priority = 5;
        }
        this.mPriority = priority;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public void setTaskmsg(TaskMsg taskmsg) {
        this.mTaskmsg = taskmsg;
    }

    public String toString() {
        return "[mUri=" + this.mUri + "][mDownloadId=" + this.mDownloadId + "][status=" + this.mStatus + RhetoricalTagUtilKt.TAG_END_SYMBOL;
    }
}
