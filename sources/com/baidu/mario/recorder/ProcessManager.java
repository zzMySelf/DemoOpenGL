package com.baidu.mario.recorder;

class ProcessManager {
    private static final int DEFAULT_TOTAL_PROCESS = 100;
    private boolean mStart;
    private long mStartTimeMs;
    private int mTotalProcess;
    private long mTotalTimeMs;

    public ProcessManager(long j2) {
        this.mTotalProcess = 100;
        this.mStartTimeMs = 0;
        this.mStart = false;
        this.mTotalTimeMs = j2;
    }

    public int getCurrentProcess(long j2) {
        if (this.mTotalTimeMs == 0) {
            return 0;
        }
        long j3 = this.mStartTimeMs;
        if (j3 == 0) {
            return 0;
        }
        return (int) (j2 - j3);
    }

    public int getTotalProcess() {
        return this.mTotalProcess;
    }

    public boolean isStart() {
        return this.mStart;
    }

    public void start(long j2) {
        this.mStartTimeMs = j2;
        this.mStart = true;
    }

    public ProcessManager(long j2, int i2) {
        this.mStartTimeMs = 0;
        this.mStart = false;
        this.mTotalTimeMs = j2;
        this.mTotalProcess = i2;
    }
}
