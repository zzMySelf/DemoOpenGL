package com.baidu.cyberplayer.sdk;

import android.util.Log;
import com.baidu.cyberplayer.sdk.statistics.YalogWrap;

public class CyberLog {
    public static final int LOG_DEBUG = 3;
    public static final int LOG_ERROR = 6;
    public static final int LOG_INFO = 4;
    public static final int LOG_INIT = 1;
    public static final int LOG_MAX = 7;
    public static final int LOG_VERBOSE = 2;
    public static final int LOG_WARN = 5;
    public static final int LOG_YALOG = 9;
    private static final String TAG = "duplayer-";
    public static int sLogLevel = 1;
    public static int sYalogLevel = 6;

    public static void setLogLevel(int level) {
        sLogLevel = level;
    }

    public static void setYalogLevel(int level) {
        sYalogLevel = level;
    }

    public static int getLogLevel() {
        return sLogLevel;
    }

    public static void v(String tag, String msg) {
        if (2 >= sYalogLevel) {
            YalogWrap.getInstance().writeYalog(2, TAG + tag, msg);
        }
        if (7 - sLogLevel <= 2) {
            Log.v(TAG + tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (3 >= sYalogLevel) {
            YalogWrap.getInstance().writeYalog(3, TAG + tag, msg);
        }
        if (7 - sLogLevel <= 3) {
            Log.i(TAG + tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (4 >= sYalogLevel) {
            YalogWrap.getInstance().writeYalog(4, TAG + tag, msg);
        }
        if (7 - sLogLevel <= 4) {
            Log.i(TAG + tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (5 >= sYalogLevel) {
            YalogWrap.getInstance().writeYalog(5, TAG + tag, msg);
        }
        if (7 - sLogLevel <= 5) {
            Log.w(TAG + tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (6 >= sYalogLevel) {
            YalogWrap.getInstance().writeYalog(6, TAG + tag, msg);
        }
        if (7 - sLogLevel <= 6) {
            Log.e(TAG + tag, msg);
        }
    }

    public static void e(String tag, String msg, Throwable tr) {
        if (6 >= sYalogLevel) {
            YalogWrap.getInstance().writeYalog(6, TAG + tag, msg);
        }
        if (7 - sLogLevel <= 6) {
            Log.e(TAG + tag, msg, tr);
        }
    }

    public static void y(String tag, String msg) {
        YalogWrap.getInstance().writeYalog(9, TAG + tag, msg);
    }
}
