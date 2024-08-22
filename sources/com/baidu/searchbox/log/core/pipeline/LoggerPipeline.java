package com.baidu.searchbox.log.core.pipeline;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.log.core.Logger;
import com.baidu.searchbox.log.core.dao.BIZ;
import com.baidu.searchbox.log.core.db.LoggerDBController;
import com.baidu.searchbox.log.core.pipeline.LoggerConfig;
import com.baidu.searchbox.log.core.task.Consumer;
import com.baidu.searchbox.log.core.task.DefaultProducerContext;
import com.baidu.searchbox.log.core.task.LogBizConfigProducer;
import com.baidu.searchbox.log.core.task.LogFetchProducer;
import com.baidu.searchbox.log.core.task.LogSaveProducer;
import com.baidu.searchbox.log.core.task.LogTaskManager;
import com.baidu.searchbox.log.core.task.LogUploadProducer;
import com.baidu.searchbox.log.core.task.LogUploadQueryProducer;
import com.baidu.searchbox.log.core.task.ProducerContext;
import com.baidu.searchbox.log.inter.model.ABLog;
import java.io.File;
import java.util.HashSet;
import java.util.concurrent.ThreadPoolExecutor;

public class LoggerPipeline {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = Logger.isDebug();
    private static final String TAG = "LoggerPipeline";
    /* access modifiers changed from: private */
    public ThreadPoolExecutor mActiveExecutor;
    private File mDiskCacheDir;
    /* access modifiers changed from: private */
    public ThreadPoolExecutor mFileUploadExecutor;
    /* access modifiers changed from: private */
    public LoggerDBController mLoggerDBController;
    private ThreadPoolExecutor mPassiveExecutor;

    public LoggerPipeline(Context context, LoggerConfig loggerConfig) {
        LoggerConfig loggerConfig2;
        if (loggerConfig != null) {
            loggerConfig2 = loggerConfig;
        } else {
            loggerConfig2 = new LoggerConfig.Builder().build(context);
        }
        LoggerConfig loggerConfig3 = loggerConfig2;
        this.mActiveExecutor = loggerConfig3.getExecutorSupplier().forActiveBiz();
        this.mPassiveExecutor = loggerConfig3.getExecutorSupplier().forPassiveBiz();
        this.mFileUploadExecutor = loggerConfig3.getExecutorSupplier().forFileUpload();
        File diskCacheDir = loggerConfig3.getDiskCacheDir();
        this.mDiskCacheDir = diskCacheDir;
        if (!diskCacheDir.exists()) {
            this.mDiskCacheDir.mkdirs();
        }
        this.mLoggerDBController = new LoggerDBController(context);
    }

    public void log(String bizID, String content, HashSet<ABLog.ABFile> abFiles) {
        ABLog abLog = new ABLog(bizID, content, abFiles);
        ProducerContext producerContext = new DefaultProducerContext();
        BIZ biz = this.mLoggerDBController.getBIZInCache(abLog.mBIZID);
        new LogUploadProducer(new LogSaveProducer(abLog, this.mLoggerDBController, (biz == null || !biz.mUploadType.equals("0")) ? this.mActiveExecutor : this.mPassiveExecutor, this.mDiskCacheDir), this.mLoggerDBController, this.mActiveExecutor, this.mFileUploadExecutor, false).produceResults(new Consumer<LogUploadProducer.Result>() {
            public void onNewResult(LogUploadProducer.Result newResult, int status) {
                if (newResult != null && newResult.mNeedRetry) {
                    LogTaskManager.getInstance().retry(LoggerPipeline.this.mActiveExecutor, LoggerPipeline.this.mFileUploadExecutor, LoggerPipeline.this.mLoggerDBController, newResult.mContentUploaded);
                }
            }

            public void onFailure(Throwable t) {
            }
        }, producerContext);
    }

    public void log(String bizID, String content, ABLog.ABZipFile zipFile) {
        ABLog abLog = new ABLog(bizID, content, zipFile);
        ProducerContext producerContext = new DefaultProducerContext();
        BIZ biz = this.mLoggerDBController.getBIZInCache(abLog.mBIZID);
        new LogUploadProducer(new LogSaveProducer(abLog, this.mLoggerDBController, (biz == null || !"0".equals(biz.mUploadType)) ? this.mActiveExecutor : this.mPassiveExecutor, this.mDiskCacheDir), this.mLoggerDBController, this.mActiveExecutor, this.mFileUploadExecutor, false).produceResults(new Consumer<LogUploadProducer.Result>() {
            public void onNewResult(LogUploadProducer.Result newResult, int status) {
                if (LoggerPipeline.DEBUG) {
                    Log.d(LoggerPipeline.TAG, "LoggerPipelineonNewResult");
                }
                if (newResult != null && newResult.mNeedRetry) {
                    LogTaskManager.getInstance().retry(LoggerPipeline.this.mActiveExecutor, LoggerPipeline.this.mFileUploadExecutor, LoggerPipeline.this.mLoggerDBController, newResult.mContentUploaded);
                }
            }

            public void onFailure(Throwable t) {
            }
        }, producerContext);
    }

    public void log(String bizID, String content) {
        ABLog abLog = new ABLog(bizID, content);
        ProducerContext producerContext = new DefaultProducerContext();
        BIZ biz = this.mLoggerDBController.getBIZInCache(abLog.mBIZID);
        new LogUploadProducer(new LogSaveProducer(abLog, this.mLoggerDBController, (biz == null || !"0".equals(biz.mUploadType)) ? this.mActiveExecutor : this.mPassiveExecutor, this.mDiskCacheDir), this.mLoggerDBController, this.mActiveExecutor, this.mFileUploadExecutor, false).produceResults(new Consumer<LogUploadProducer.Result>() {
            public void onNewResult(LogUploadProducer.Result newResult, int status) {
                if (newResult != null && newResult.mNeedRetry) {
                    LogTaskManager.getInstance().retry(LoggerPipeline.this.mActiveExecutor, LoggerPipeline.this.mFileUploadExecutor, LoggerPipeline.this.mLoggerDBController, newResult.mContentUploaded);
                }
            }

            public void onFailure(Throwable t) {
            }
        }, producerContext);
    }

    public void uploadCacheLog() {
        new LogUploadProducer(new LogUploadQueryProducer(), this.mLoggerDBController, this.mActiveExecutor, this.mFileUploadExecutor, false).produceResults(new Consumer<LogUploadProducer.Result>() {
            public void onNewResult(LogUploadProducer.Result newResult, int status) {
                if (newResult != null && newResult.mNeedRetry) {
                    LogTaskManager.getInstance().retry(LoggerPipeline.this.mActiveExecutor, LoggerPipeline.this.mFileUploadExecutor, LoggerPipeline.this.mLoggerDBController, newResult.mContentUploaded);
                }
            }

            public void onFailure(Throwable t) {
            }
        }, new DefaultProducerContext());
    }

    public void updateBizConfig(String config, boolean asyncUpdate) {
        new LogBizConfigProducer(this.mActiveExecutor, this.mLoggerDBController, config, asyncUpdate).produceResults(new Consumer<LogBizConfigProducer.Result>() {
            public void onNewResult(LogBizConfigProducer.Result newResult, int status) {
                if (newResult != null && newResult.mConfigUpdated) {
                    LoggerPipeline.this.mLoggerDBController.clearBIZCache();
                }
            }

            public void onFailure(Throwable t) {
            }
        }, new DefaultProducerContext());
    }

    public void updateFetchTask(String fetchData) {
        new LogFetchProducer(this.mActiveExecutor, this.mLoggerDBController, fetchData).produceResults(new Consumer<LogFetchProducer.Result>() {
            public void onNewResult(LogFetchProducer.Result newResult, int status) {
                if (newResult != null && newResult.mUpdated) {
                    LoggerPipeline.this.mLoggerDBController.clearFetchCache();
                }
            }

            public void onFailure(Throwable t) {
            }
        }, new DefaultProducerContext());
    }

    public String getBIZUploadType(String bizID) {
        BIZ biz;
        LoggerDBController loggerDBController = this.mLoggerDBController;
        if (loggerDBController == null || (biz = loggerDBController.getBIZ(bizID)) == null) {
            return null;
        }
        return biz.mUploadType;
    }
}
