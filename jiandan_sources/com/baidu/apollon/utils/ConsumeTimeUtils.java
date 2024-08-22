package com.baidu.apollon.utils;

import android.os.SystemClock;

public class ConsumeTimeUtils {
    public TimeResult a;
    public String b = "ConsumeTime";
    public String c;

    public final class TimeResult {
        public long a = 0;
        public long b = 0;
        public long c = 0;
        public int d = 0;

        public TimeResult() {
        }

        public String buildLog() {
            StringBuilder sb = new StringBuilder();
            if (ConsumeTimeUtils.this.c != null) {
                sb.append(ConsumeTimeUtils.this.c + ":");
            }
            sb.append(" task last " + getDurationMesc() + " millisecond about " + getDurationSecond() + " second");
            return sb.toString();
        }

        public long getDurationMesc() {
            return this.b - this.a;
        }

        public int getDurationSecond() {
            return (int) (getDurationMesc() / 1000);
        }

        public long getEndTime() {
            return this.b;
        }

        public long getStartTime() {
            return this.a;
        }

        public void logd() {
            LogUtil.d(ConsumeTimeUtils.this.b, buildLog());
        }

        public void loge() {
            LogUtil.e(ConsumeTimeUtils.this.b, buildLog(), new Throwable());
        }

        public void logi() {
            LogUtil.i(ConsumeTimeUtils.this.b, buildLog());
        }

        public void logv() {
            LogUtil.v(ConsumeTimeUtils.this.b, buildLog());
        }

        public void logw() {
            LogUtil.w(ConsumeTimeUtils.this.b, buildLog());
        }

        public String toString() {
            String buildLog = buildLog();
            LogUtil.v(ConsumeTimeUtils.this.b, buildLog);
            return buildLog;
        }
    }

    public TimeResult finish() {
        this.a.b = SystemClock.uptimeMillis();
        return this.a;
    }

    public void setPrefix(String str) {
        this.c = str;
    }

    public void setTAGString(String str) {
        this.b = str;
    }

    public ConsumeTimeUtils start() {
        TimeResult timeResult = new TimeResult();
        this.a = timeResult;
        timeResult.a = SystemClock.uptimeMillis();
        return this;
    }
}
