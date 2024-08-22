package com.baidu.searchbox.video.feedflow.detail.payment.lastframe;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"DAY_OF_SECOND", "", "HOUR_OF_SECOND", "MINUTE_OF_SECOND", "digit2Time", "", "digit", "processTime", "Lcom/baidu/searchbox/video/feedflow/detail/payment/lastframe/Time;", "startTime", "endTime", "lib-flow-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ColumnLastFrameTimerView.kt */
public final class ColumnLastFrameTimerViewKt {
    private static final int DAY_OF_SECOND = 86400;
    private static final int HOUR_OF_SECOND = 3600;
    private static final int MINUTE_OF_SECOND = 60;

    public static final Time processTime(int startTime, int endTime) {
        int timeInterval = endTime - startTime;
        Time time = new Time();
        if (timeInterval > 0) {
            time.setDay(timeInterval / 86400);
            time.setHour((timeInterval / HOUR_OF_SECOND) - (time.getDay() * 24));
            time.setMinute(((timeInterval / 60) - ((time.getDay() * 24) * 60)) - (time.getHour() * 60));
            time.setSecond(((timeInterval - (time.getDay() * 86400)) - (time.getHour() * HOUR_OF_SECOND)) - (time.getMinute() * 60));
        }
        return time;
    }

    public static final String digit2Time(int digit) {
        boolean z = false;
        if (digit >= 0 && digit < 10) {
            z = true;
        }
        if (z) {
            return new StringBuilder().append('0').append(digit).toString();
        }
        if (!z) {
            return String.valueOf(digit);
        }
        throw new NoWhenBranchMatchedException();
    }
}
