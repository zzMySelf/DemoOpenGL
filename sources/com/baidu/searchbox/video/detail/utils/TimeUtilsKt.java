package com.baidu.searchbox.video.detail.utils;

import java.util.Calendar;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\u001a\u0006\u0010\u0005\u001a\u00020\u0001\u001a\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u0006\u0010\u0007\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"MS_OF_ONE_DAY", "", "MS_OF_ONE_HOUR", "MS_OF_ONE_MINUTE", "MS_OF_ONE_SEC", "getCurDayZeroHourMs", "getCurDayZeroHourS", "getTimestampBySecond", "lib-support_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: TimeUtils.kt */
public final class TimeUtilsKt {
    private static final long MS_OF_ONE_DAY = 86400000;
    private static final long MS_OF_ONE_HOUR = 3600000;
    private static final long MS_OF_ONE_MINUTE = 60000;
    private static final long MS_OF_ONE_SEC = 1000;

    public static final long getCurDayZeroHourMs() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static final long getCurDayZeroHourS() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() / 1000;
    }

    public static final long getTimestampBySecond() {
        return System.currentTimeMillis() / ((long) 1000);
    }
}
