package com.baidu.searchbox.ui.animview.praise;

import android.util.Log;
import com.baidu.searchbox.ui.animview.util.DebugUtil;

public class ClickIntervalTracker {
    private static final boolean DEBUG = DebugUtil.isApkInDebug();
    private static final String TAG = "ClickIntervalTracker";
    private long mInitialClickCounts;
    private long mLastClickTimeMs;
    private long mLastIntervalTimeMs = 2147483647L;
    private long mTotalClickCounts;

    public enum SpeedLevel {
        V0(-1, "NONE"),
        V1(1000, "V1"),
        V2(250, "V2"),
        V3(0, "V3");
        
        private String mInfo;
        private long mInterval;

        private SpeedLevel(long interval, String info) {
            this.mInterval = interval;
            this.mInfo = info;
        }

        public long getInterval() {
            return this.mInterval;
        }

        public String toString() {
            return this.mInfo;
        }

        public static SpeedLevel instantiate(long clickInterval, long clickTotal) {
            if (clickTotal == 1 || clickTotal % 10 == 0) {
                return V3;
            }
            SpeedLevel speedLevel = V2;
            if (clickInterval < speedLevel.getInterval()) {
                return speedLevel;
            }
            return V1;
        }
    }

    public void setInitialClickCounts(long initialClickCounts) {
        this.mInitialClickCounts = initialClickCounts;
    }

    public void addClick() {
        this.mLastIntervalTimeMs = System.currentTimeMillis() - this.mLastClickTimeMs;
        this.mTotalClickCounts++;
        this.mLastClickTimeMs = System.currentTimeMillis();
    }

    public SpeedLevel getSpeedLevel() {
        if (DEBUG) {
            Log.d(TAG, "LastIntervalTimeMs:" + this.mLastIntervalTimeMs + ", TotalClickCounts" + (this.mInitialClickCounts + this.mTotalClickCounts));
        }
        return SpeedLevel.instantiate(this.mLastIntervalTimeMs, this.mInitialClickCounts + this.mTotalClickCounts);
    }

    public void reset() {
        this.mTotalClickCounts = 0;
        this.mLastClickTimeMs = 0;
        this.mInitialClickCounts = 0;
        this.mLastIntervalTimeMs = 2147483647L;
    }
}
