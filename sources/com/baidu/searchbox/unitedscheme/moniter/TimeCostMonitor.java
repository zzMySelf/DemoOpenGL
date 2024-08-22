package com.baidu.searchbox.unitedscheme.moniter;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import java.util.Hashtable;

public class TimeCostMonitor {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "TimeCostMonitor";
    private Hashtable<String, Long> mEventRecorder = new Hashtable<>();
    private long mThresholdValue;
    private TimeCostHandler mTimeoutHandler;

    public TimeCostMonitor(TimeCostHandler timeoutHandler, long thresholdValue) {
        this.mTimeoutHandler = timeoutHandler;
        this.mThresholdValue = thresholdValue;
    }

    public void recordStart(String event) {
        Hashtable<String, Long> hashtable;
        if (!TextUtils.isEmpty(event) && (hashtable = this.mEventRecorder) != null) {
            hashtable.put(event, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public void recordEnd(String event) {
        Hashtable<String, Long> hashtable;
        Long startTime;
        TimeCostHandler timeCostHandler;
        if (!TextUtils.isEmpty(event) && (hashtable = this.mEventRecorder) != null && (startTime = hashtable.get(event)) != null) {
            long endTime = System.currentTimeMillis();
            long costTime = endTime - startTime.longValue();
            if (costTime > this.mThresholdValue && (timeCostHandler = this.mTimeoutHandler) != null) {
                timeCostHandler.handle(startTime.longValue(), endTime, this.mThresholdValue, event);
            }
            if (DEBUG) {
                Log.i(TAG, "执行耗时：" + costTime + "，开始时间：" + startTime + "，结束时间：" + endTime + "，event：" + event);
            }
            this.mEventRecorder.remove(event);
        }
    }
}
