package com.baidu.android.util.android;

public class FastClickUtil {
    public static final int SHOW_DIOLOG_GAP_TIME = 1300;
    public static long sLastShowDiologTime;

    public static void clearLastRecordTime() {
        sLastShowDiologTime = 0;
    }

    public static boolean isFastShowDialogCallback() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = currentTimeMillis - sLastShowDiologTime <= 1300;
        sLastShowDiologTime = currentTimeMillis;
        return z;
    }
}
