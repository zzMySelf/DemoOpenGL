package com.baidu.searchbox.mtj;

import android.util.Log;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import java.lang.Thread;

public class MTJExtraUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    private static final String TAG = "MTJExtra";
    private Thread.UncaughtExceptionHandler mBdUncaughtExceptionHandler = null;

    public MTJExtraUncaughtExceptionHandler(Thread.UncaughtExceptionHandler handler) {
        this.mBdUncaughtExceptionHandler = handler;
    }

    public void uncaughtException(Thread thread, Throwable ex) {
        Log.e(TAG, "MTJExtraAdd MTJ extra info");
        MtjWrapper.addCrashInfoWrapper("foreground", String.valueOf(BdBoxActivityManager.isForeground()));
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mBdUncaughtExceptionHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, ex);
        }
    }
}
