package com.baidu.searchbox.player.utils;

import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u001a\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0016\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"DAY_DURATION", "", "getCalendarLimitDay", "Ljava/util/Calendar;", "timeStamp", "", "getDayDiff", "beginTime", "endTime", "lib-player-business_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlayerDateUtils.kt */
public final class PlayerDateUtilsKt {
    private static final int DAY_DURATION = 86400000;

    public static final int getDayDiff(long beginTime, long endTime) {
        return (int) ((getCalendarLimitDay(beginTime).getTimeInMillis() - getCalendarLimitDay(endTime).getTimeInMillis()) / ((long) 86400000));
    }

    private static final Calendar getCalendarLimitDay(long timeStamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeStamp);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        Intrinsics.checkNotNullExpressionValue(calendar, "calendar");
        return calendar;
    }
}
