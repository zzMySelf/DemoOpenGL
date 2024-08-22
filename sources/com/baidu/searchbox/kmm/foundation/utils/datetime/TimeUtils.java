package com.baidu.searchbox.kmm.foundation.utils.datetime;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0012\u0010\u0006\u001a\u00020\u0003*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0001¨\u0006\b"}, d2 = {"createTimeFormat", "Lcom/baidu/searchbox/kmm/foundation/utils/datetime/TimeStampFormatter;", "format", "", "getCurrentTimeStamp", "", "millisecondToString", "formatter", "com.baidu.searchbox.kmm.foundation.utils"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: TimeUtils.kt */
public final class TimeUtils {
    public static final long getCurrentTimeStamp() {
        return System.currentTimeMillis();
    }

    public static final String millisecondToString(long $this$millisecondToString, TimeStampFormatter formatter) {
        Intrinsics.checkNotNullParameter(formatter, "formatter");
        Object sdf = formatter.getFormat();
        if (!(sdf instanceof SimpleDateFormat)) {
            return "";
        }
        String format = ((SimpleDateFormat) sdf).format(new Date($this$millisecondToString));
        Intrinsics.checkNotNullExpressionValue(format, "sdf.format(Date(this))");
        return format;
    }

    public static final TimeStampFormatter createTimeFormat(String format) {
        Intrinsics.checkNotNullParameter(format, "format");
        SimpleDateFormat sdf = null;
        try {
            sdf = new SimpleDateFormat(format, Locale.CHINA);
        } catch (Exception e2) {
        }
        return new TimeStampFormatter(sdf);
    }
}
