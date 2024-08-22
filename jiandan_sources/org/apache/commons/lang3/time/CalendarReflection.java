package org.apache.commons.lang3.time;

import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.apache.commons.lang3.exception.ExceptionUtils;

public class CalendarReflection {
    public static final Method GET_WEEK_YEAR = getCalendarMethod("getWeekYear", new Class[0]);
    public static final Method IS_WEEK_DATE_SUPPORTED = getCalendarMethod("isWeekDateSupported", new Class[0]);

    public static Method getCalendarMethod(String str, Class<?>... clsArr) {
        try {
            return Calendar.class.getMethod(str, clsArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static int getWeekYear(Calendar calendar) {
        try {
            if (isWeekDateSupported(calendar)) {
                return ((Integer) GET_WEEK_YEAR.invoke(calendar, new Object[0])).intValue();
            }
            int i2 = calendar.get(1);
            if (IS_WEEK_DATE_SUPPORTED != null || !(calendar instanceof GregorianCalendar)) {
                return i2;
            }
            int i3 = calendar.get(2);
            if (i3 == 0) {
                return calendar.get(3) >= 52 ? i2 - 1 : i2;
            }
            if (i3 == 11 && calendar.get(3) == 1) {
                return i2 + 1;
            }
            return i2;
        } catch (Exception e) {
            return ((Integer) ExceptionUtils.rethrow(e)).intValue();
        }
    }

    public static boolean isWeekDateSupported(Calendar calendar) {
        try {
            return IS_WEEK_DATE_SUPPORTED != null && ((Boolean) IS_WEEK_DATE_SUPPORTED.invoke(calendar, new Object[0])).booleanValue();
        } catch (Exception e) {
            return ((Boolean) ExceptionUtils.rethrow(e)).booleanValue();
        }
    }
}
