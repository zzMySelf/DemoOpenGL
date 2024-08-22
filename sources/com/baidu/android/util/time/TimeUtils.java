package com.baidu.android.util.time;

import android.content.Context;

@Deprecated
public class TimeUtils {
    private static final String MD = "MM-dd";
    private static long MSEC_OF_ONE_DAY = 86400000;
    private static long MSEC_OF_ONE_HOUR = 3600000;
    private static long MSEC_OF_ONE_MINUTE = 60000;
    private static long MSEC_OF_ONE_SEC = 1000;
    private static final String Y4MD = "yyyy-MM-dd";
    private static final String Y4MD_HM = "yyyy-MM-dd HH:mm";

    public static String getFormatTeletextTime(Context context, long cmsec) {
        return getFormatTeletextTime(context, cmsec, true);
    }

    public static String getFormatTeletextTime(Context context, long cmsec, boolean includeHM) {
        return DateTimeUtil.getFormatTeletextTime(context, cmsec, includeHM);
    }
}
