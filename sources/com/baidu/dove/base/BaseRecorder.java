package com.baidu.dove.base;

import com.baidu.dove.data.MetricsData;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;

public abstract class BaseRecorder {
    public MetricsData mMetricsData = new MetricsData();

    public void startGlobalRecord() {
    }

    public void stopGlobalRecord() {
    }

    public void startSubsystemRecord(String viewType, long timeStamp) {
    }

    public void stopSubsystemRecord(String viewType, long timeStamp) {
    }

    public void recordMsgStart(long startMsgTime) {
    }

    public void recordMsgEnd(long endMsgime) {
    }

    public void recordTask(String viewType, long tid, long timeStamp) {
    }

    public void recordTask(String viewType, long startTimeStamp, long endTimeStamp, long duration) {
    }

    public void recordTaskStart(String viewType, long tid, long timeStamp) {
    }

    public void recordTaskEnd(String viewType, long tid, long timeStamp) {
    }

    public MetricsData getRecordData() {
        return this.mMetricsData;
    }

    public void setRecordDataEndInfo() {
        MetricsData metricsData = this.mMetricsData;
        if (metricsData != null) {
            metricsData.updateHeader(3, Long.valueOf(System.currentTimeMillis()));
            this.mMetricsData.updateHeader(2, ProcessUtils.getCurProcessName());
        }
    }

    public void resetRecordData() {
        this.mMetricsData = new MetricsData();
    }

    public MetricsData formatMetricsData(MetricsData metricsData) {
        return null;
    }
}
