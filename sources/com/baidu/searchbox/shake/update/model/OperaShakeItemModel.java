package com.baidu.searchbox.shake.update.model;

import android.text.TextUtils;
import com.baidu.chatsearch.aisearch.resultpage.toolbar.discovery.span.RhetoricalTagUtilKt;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.config.AppConfig;
import java.util.List;

public class OperaShakeItemModel implements NoProGuard {
    public static final Long DEFAULT_LONG = 0L;
    public List<String> avoidSwanAppKeyList;
    public String endtime;
    public String logkey;
    public String scheme;
    public String starttime;

    public Long getStartTime() {
        if (TextUtils.isEmpty(this.starttime)) {
            return DEFAULT_LONG;
        }
        try {
            return Long.valueOf(this.starttime);
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return DEFAULT_LONG;
        }
    }

    public Long getEndTime() {
        if (TextUtils.isEmpty(this.endtime)) {
            return DEFAULT_LONG;
        }
        try {
            return Long.valueOf(this.endtime);
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return DEFAULT_LONG;
        }
    }

    public String getScheme() {
        return this.scheme;
    }

    public String getLogKey() {
        return this.logkey;
    }

    public List<String> getAppKeyList() {
        return this.avoidSwanAppKeyList;
    }

    public String toString() {
        return "[starttime = " + this.starttime + " ,endtime = " + this.endtime + " ,scheme = " + this.scheme + " ,logkey = " + this.logkey + RhetoricalTagUtilKt.TAG_END_SYMBOL;
    }

    public boolean isValid() {
        if (TextUtils.isEmpty(this.starttime) || TextUtils.isEmpty(this.endtime) || TextUtils.isEmpty(this.scheme) || TextUtils.isEmpty(this.logkey)) {
            return false;
        }
        try {
            long sTime = Long.parseLong(this.starttime);
            long eTime = Long.parseLong(this.endtime);
            if (sTime <= 0 || eTime <= 0 || eTime <= sTime) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
            return false;
        }
    }
}
