package com.baidu.browser.searchfps;

import android.os.Build;
import android.util.Log;
import android.view.Choreographer;
import com.baidu.searchbox.config.AppConfig;
import java.util.concurrent.TimeUnit;

public class FPSFrameCallback implements Choreographer.FrameCallback {
    private boolean mIsEnable = true;
    private long mLastSampleTimeInNs = 0;
    private long mStartSampleTimeInNs = 0;

    public void setEnabled(boolean enabled) {
        this.mIsEnable = enabled;
    }

    public void doFrame(long frameTimeNanos) {
        if (!this.mIsEnable) {
            destroy();
            return;
        }
        if (this.mStartSampleTimeInNs == 0) {
            this.mStartSampleTimeInNs = frameTimeNanos;
        } else {
            checkFrameCollect(frameTimeNanos);
        }
        this.mLastSampleTimeInNs = frameTimeNanos;
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                Choreographer.getInstance().postFrameCallback(this);
            } catch (Exception e2) {
                if (AppConfig.isDebug()) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private void checkFrameCollect(long frameTimeNanos) {
        FPSMonitor monitor;
        long diffMs = 0;
        if (this.mLastSampleTimeInNs != 0) {
            diffMs = TimeUnit.MILLISECONDS.convert(frameTimeNanos - this.mLastSampleTimeInNs, TimeUnit.NANOSECONDS);
        }
        FPSConfig config = SearchFPSMonitor.getConfig();
        if (config != null) {
            if (diffMs > config.mLongTaskFrameThresholdInMs && (monitor = SearchFPSMonitor.getMonitor()) != null) {
                if (AppConfig.isDebug() || FpsConfigUtils.isSearchFrameFPSForceEnable()) {
                    Log.i("SearchPerformance", " long task = " + diffMs);
                }
                monitor.recordLongTaskTimeSet(String.valueOf(diffMs));
            }
            if (diffMs > config.mLongTaskTime) {
                if (AppConfig.isDebug() || FpsConfigUtils.isSearchFrameFPSForceEnable()) {
                    Log.d("SearchPerformance", " time > " + config.mLongTaskTime + " consume  = " + diffMs);
                }
                SearchFPSMonitor.onLongTask((int) diffMs);
            }
        }
    }

    public void destroy() {
        this.mStartSampleTimeInNs = 0;
        this.mLastSampleTimeInNs = 0;
    }
}
