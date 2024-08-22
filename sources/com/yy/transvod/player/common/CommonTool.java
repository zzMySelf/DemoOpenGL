package com.yy.transvod.player.common;

import com.yy.transvod.player.log.TLog;
import java.io.File;

public class CommonTool {
    private static final String TAG = "CommonTool";
    private static boolean mCheckClearColor = false;
    private static boolean mEnableClearColor = false;

    public static synchronized boolean checkClearColor() {
        boolean z;
        synchronized (CommonTool.class) {
            if (!mCheckClearColor) {
                mCheckClearColor = true;
                if (new File("/sdcard/transvod_clearColor.json").exists()) {
                    mEnableClearColor = true;
                }
                TLog.warn(TAG, "enableClearColor:" + mEnableClearColor);
            }
            z = mEnableClearColor;
        }
        return z;
    }
}
