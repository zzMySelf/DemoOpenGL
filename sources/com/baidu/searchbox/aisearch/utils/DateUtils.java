package com.baidu.searchbox.aisearch.utils;

import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import java.util.Arrays;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0007J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0007J#\u0010\u000e\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010\u0010J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/aisearch/utils/DateUtils;", "", "()V", "DAY", "", "DEBUG", "", "INVALID_TIMES", "", "TAG", "getDayDuration", "startTimeStamp", "getYYYYMMDD", "timeStamp", "isSameDay", "endTimeStamp", "(Ljava/lang/Long;Ljava/lang/Long;)Z", "isSameDayStr", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DateUtils.kt */
public final class DateUtils {
    private static final long DAY = 86400;
    private static final boolean DEBUG = AppConfig.isDebug();
    public static final DateUtils INSTANCE = new DateUtils();
    public static final String INVALID_TIMES = "--";
    private static final String TAG = "DateUtils";

    private DateUtils() {
    }

    public static /* synthetic */ boolean isSameDay$default(DateUtils dateUtils, Long l, Long l2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            l2 = Long.valueOf(System.currentTimeMillis() / ((long) 1000));
        }
        return dateUtils.isSameDay(l, l2);
    }

    public final boolean isSameDay(Long startTimeStamp, Long endTimeStamp) {
        if (startTimeStamp == null || endTimeStamp == null || startTimeStamp.longValue() < 0 || endTimeStamp.longValue() < 0) {
            if (DEBUG) {
                Log.w(TAG, "isSameDay: timeStamp is " + startTimeStamp);
            }
            return false;
        }
        Calendar startCalendar = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(startCalendar, "getInstance()");
        long j2 = (long) 1000;
        startCalendar.setTimeInMillis(startTimeStamp.longValue() * j2);
        int sYear = startCalendar.get(1);
        int sMonth = startCalendar.get(2);
        int sDay = startCalendar.get(5);
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        Calendar endCalendar = instance;
        endCalendar.setTimeInMillis(endTimeStamp.longValue() * j2);
        int eYear = endCalendar.get(1);
        int eMonth = endCalendar.get(2);
        int eDay = endCalendar.get(5);
        if (sYear == eYear && sMonth == eMonth && sDay == eDay) {
            return true;
        }
        return false;
    }

    public final boolean isSameDayStr(String timeStamp) {
        CharSequence charSequence = timeStamp;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            return isSameDay$default(this, StringsKt.toLongOrNull(timeStamp), (Long) null, 2, (Object) null);
        }
        if (DEBUG) {
            Log.w(TAG, "isSameDayStr: timeStamp is " + timeStamp);
        }
        return false;
    }

    public final String getYYYYMMDD(String timeStamp) {
        Intrinsics.checkNotNullParameter(timeStamp, "timeStamp");
        Long longOrNull = StringsKt.toLongOrNull(timeStamp);
        if (longOrNull == null) {
            return timeStamp;
        }
        long tmpTimeStamp = longOrNull.longValue();
        Calendar calendar = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance()");
        calendar.setTimeInMillis(((long) 1000) * tmpTimeStamp);
        int year = calendar.get(1);
        int day = calendar.get(5);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%d.%d.%d", Arrays.copyOf(new Object[]{Integer.valueOf(year), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(day)}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    public final String getDayDuration(String startTimeStamp) {
        Intrinsics.checkNotNullParameter(startTimeStamp, "startTimeStamp");
        try {
            Long longOrNull = StringsKt.toLongOrNull(startTimeStamp);
            if (longOrNull == null) {
                return INVALID_TIMES;
            }
            long startTime = longOrNull.longValue();
            long timeDiff = (System.currentTimeMillis() / ((long) 1000)) - startTime;
            if (timeDiff < 0) {
                return "0";
            }
            long dayNum = timeDiff / 86400;
            if (isSameDay(Long.valueOf(startTime), Long.valueOf(startTime + (timeDiff % 86400)))) {
                return String.valueOf(dayNum);
            }
            return String.valueOf(1 + dayNum);
        } catch (Exception e2) {
            if (DEBUG) {
                Log.e(TAG, "getDayDuration: " + e2);
            }
            return INVALID_TIMES;
        }
    }
}
