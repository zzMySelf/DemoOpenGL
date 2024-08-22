package com.baidu.searchbox.elasticthread.executor;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.searchbox.elasticthread.scheduler.ElasticTaskScheduler;
import com.baidu.searchbox.elasticthread.statistic.Recordable;
import com.baidu.searchbox.elasticthread.task.ElasticTask;
import java.util.concurrent.TimeUnit;

public abstract class BaseDredgeExecutorCell extends BaseExecutorCell {
    protected static final long KEEP_ALIVE_TIME_OPEN = 5000;
    protected static final long KEEP_ALIVE_TIME_SHUTDOWN = 100;
    protected boolean isOpen = false;
    private long lastOpenTime = 0;
    private long lastShutdownTime = 0;
    private int openCountInRecordLifeCycle;
    private long openTimeInRecordLifeCycle;

    protected BaseDredgeExecutorCell(int maxThreadNum) {
        super(maxThreadNum);
    }

    /* access modifiers changed from: protected */
    public boolean available() {
        if (this.isOpen && getWorkingThreadNum() < this.maxThreadNum) {
            return true;
        }
        return false;
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public void open() {
        if (this.isOpen) {
            Log.w(getTag(), "This executor cell is already opened.");
            return;
        }
        this.isOpen = true;
        this.lastOpenTime = SystemClock.elapsedRealtime();
        if (this.mRecordStatus == Recordable.RecordStatus.RECORDING) {
            this.openCountInRecordLifeCycle++;
        }
        this.mExecutor.setKeepAliveTime(5000, TimeUnit.MILLISECONDS);
    }

    public void shutdown() {
        if (!this.isOpen) {
            Log.w(getTag(), "This executor cell is already shutdown.");
            return;
        }
        this.isOpen = false;
        this.lastShutdownTime = SystemClock.elapsedRealtime();
        if (this.mRecordStatus == Recordable.RecordStatus.RECORDING) {
            this.openTimeInRecordLifeCycle += this.lastShutdownTime - Math.max(this.recordBeginTime, this.lastOpenTime);
        }
        this.mExecutor.setKeepAliveTime(100, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: protected */
    public void onTaskEnd(ElasticTask elasticTask) {
        super.onTaskEnd(elasticTask);
        if (this.isOpen) {
            ElasticTaskScheduler.getInstance().postConcurrentSchedule();
        }
    }

    public void onRecordBegin() {
        super.onRecordBegin();
        this.openCountInRecordLifeCycle = 0;
        this.openTimeInRecordLifeCycle = 0;
        if (this.isOpen) {
            this.openTimeInRecordLifeCycle = 0 + 1;
        }
    }

    public void onRecordEnd() {
        super.onRecordEnd();
        if (this.isOpen) {
            this.openTimeInRecordLifeCycle += SystemClock.elapsedRealtime() - Math.max(this.recordBeginTime, this.lastOpenTime);
        }
    }

    public int getOpenCountInRecordLifeCycle() {
        return this.openCountInRecordLifeCycle;
    }

    public long getOpenTimeInRecordLifeCycle() {
        return this.openTimeInRecordLifeCycle;
    }
}
