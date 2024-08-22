package com.baidu.searchbox.logsystem.logsys;

import android.content.Context;
import com.baidu.searchbox.logsystem.logsys.LogDiskStoreConfig;
import com.baidu.searchbox.logsystem.logsys.LogUploadConfig;

public class LogSystemConfig {
    private Context mContext;
    private LogDiskStoreConfig mLogDiskStoreConfig;
    private LogUploadConfig mLogUploadConfig;

    public static void init() {
        LogUploadConfig.init();
        LogDiskStoreConfig.init();
    }

    private LogSystemConfig(Builder builder) {
        this.mContext = builder.mContext;
        this.mLogDiskStoreConfig = builder.mLogDiskStoreConfig == null ? new LogDiskStoreConfig.Builder(this.mContext).build() : builder.mLogDiskStoreConfig;
        this.mLogUploadConfig = builder.mLogUploadConfig == null ? new LogUploadConfig.Builder().build() : builder.mLogUploadConfig;
    }

    public static Builder newBuilder(Context context) {
        return new Builder(context);
    }

    public LogUploadConfig getLogUploadNetworkConfig() {
        return this.mLogUploadConfig;
    }

    public LogDiskStoreConfig getLogDiskStoreConfig() {
        return this.mLogDiskStoreConfig;
    }

    protected static class Builder {
        /* access modifiers changed from: private */
        public Context mContext;
        /* access modifiers changed from: private */
        public LogDiskStoreConfig mLogDiskStoreConfig;
        /* access modifiers changed from: private */
        public LogUploadConfig mLogUploadConfig;

        public Builder(Context context) {
            this.mContext = context;
        }

        private Builder setLogUploadNetworkConfig(LogUploadConfig config) {
            this.mLogUploadConfig = config;
            return this;
        }

        private Builder setLogDiskStoreConfig(LogDiskStoreConfig config) {
            this.mLogDiskStoreConfig = config;
            return this;
        }

        /* access modifiers changed from: protected */
        public LogSystemConfig build() {
            return new LogSystemConfig(this);
        }
    }
}
