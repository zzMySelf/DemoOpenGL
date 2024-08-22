package com.baidu.android.util.time;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.util.TimeUtils;
import com.baidu.aiscan.R;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public final class DateTimeUtils {
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_FORMAT_CN = "yyyy年MM月dd日";
    public static final String DAY_FORMAT = "yyyyMMdd";
    public static final String DAY_FORMAT_MONTH_CN = "MM月dd日";
    public static final String MD = "MM-dd";
    public static final int MODE_NEXT_NORMAL_DAY = 1;
    public static final int MODE_NEXT_WEEKEND = 3;
    public static final int MODE_NEXT_WORKDAY = 2;
    public static final String MONTH_FORMAT = "yyyy-MM";
    public static long MSEC_OF_ONE_DAY = 86400000;
    public static long MSEC_OF_ONE_HOUR = 3600000;
    public static long MSEC_OF_ONE_MINUTE = 60000;
    public static long MSEC_OF_ONE_SEC = 1000;
    public static final Set<Integer> NORMAL_DAY = new HashSet();
    public static final int TIME_DAY_MILLISECOND = 86400000;
    public static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String TIME_FORMAT_CN = "yyyy年MM月dd日 HH:mm:ss";
    public static final Set<Integer> WEEKEND_DAY = new HashSet();
    public static final Set<Integer> WORK_DAY = new HashSet();
    public static final String Y4MD = "yyyy-MM-dd";
    public static final String Y4MD_HM = "yyyy-MM-dd HH:mm";
    public static final String YEAR_FORMAT = "yyyy";

    static {
        WORK_DAY.add(2);
        WORK_DAY.add(3);
        WORK_DAY.add(4);
        WORK_DAY.add(5);
        WORK_DAY.add(6);
        WEEKEND_DAY.add(7);
        WEEKEND_DAY.add(1);
        NORMAL_DAY.addAll(WORK_DAY);
        NORMAL_DAY.addAll(WEEKEND_DAY);
    }

    public static String convertSecondToHumanView(String str) {
        if (TextUtils.isEmpty(str) || !TextUtils.isDigitsOnly(str)) {
            return "00:00";
        }
        long parseLong = Long.parseLong(str);
        return String.format("%02d:%02d", new Object[]{Long.valueOf(parseLong / 60), Long.valueOf(parseLong % 60)});
    }

    public static String format(Date date, String str) {
        if (date == null) {
            return "";
        }
        try {
            return new SimpleDateFormat(str).format(date);
        } catch (Exception unused) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd").format(date);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public static Date getCurrDate() {
        return new Date();
    }

    public static Timestamp getCurrTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static String getFormatDateTime(Date date, String str) {
        if (date == null) {
            return "";
        }
        try {
            return new SimpleDateFormat(str).format(date);
        } catch (Exception unused) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
    }

    public static String getFormatTeletextTime(Context context, long j) {
        return getFormatTeletextTime(context, j, true);
    }

    public static long getNextDayByMode(long j, int i2) {
        Set<Integer> set;
        if (i2 == 1) {
            set = NORMAL_DAY;
        } else if (i2 == 2) {
            set = WORK_DAY;
        } else if (i2 != 3) {
            set = NORMAL_DAY;
        } else {
            set = WEEKEND_DAY;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j + 86400000);
        while (!set.contains(Integer.valueOf(instance.get(7)))) {
            instance.setTimeInMillis(instance.getTimeInMillis() + 86400000);
        }
        return instance.getTimeInMillis();
    }

    public static String getTextWithSecond(int i2, boolean z) {
        if (i2 < 0) {
            return "";
        }
        int i3 = i2 / TimeUtils.SECONDS_PER_HOUR;
        int i4 = (i2 % TimeUtils.SECONDS_PER_HOUR) / 60;
        int i5 = i2 % 60;
        if (i3 != 0 || z) {
            return String.format(Locale.US, "%02d:%02d:%02d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
        }
        return String.format(Locale.US, "%02d:%02d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i5)});
    }

    public static String getWeek() {
        return new SimpleDateFormat("EEEE").format(new Date());
    }

    public static String getWeekInZH() {
        return getWeekInZH(new Date());
    }

    public static long interval(long j, long j2) {
        return Math.abs((j2 - j) / 86400000);
    }

    public static boolean isFewDaysAgo(long j, int i2) {
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance2.add(6, -i2);
        instance2.set(11, 0);
        instance2.set(12, 0);
        instance2.set(13, 0);
        instance2.set(14, 0);
        Calendar instance3 = Calendar.getInstance();
        instance3.setTimeInMillis(j);
        if (!instance3.after(instance2) || !instance3.before(instance)) {
            return false;
        }
        return true;
    }

    public static boolean isSameDay(long j, long j2) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(j2);
        if (instance.get(1) == instance2.get(1) && instance.get(6) == instance2.get(6)) {
            return true;
        }
        return false;
    }

    public static boolean isToday(Date date) {
        if (date == null) {
            return false;
        }
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date);
        if (instance.get(1) == instance2.get(1) && instance.get(6) == instance2.get(6)) {
            return true;
        }
        return false;
    }

    public static boolean isYesterday(Date date) {
        if (date == null) {
            return false;
        }
        Calendar instance = Calendar.getInstance();
        instance.add(6, -1);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date);
        if (instance.get(1) == instance2.get(1) && instance.get(6) == instance2.get(6)) {
            return true;
        }
        return false;
    }

    public static String getFormatTeletextTime(Context context, long j, boolean z) {
        long j2;
        Context context2 = context;
        try {
            j2 = System.currentTimeMillis();
            long j3 = j2 - j;
            if (j3 >= 0) {
                j2 = j;
            }
            try {
                Calendar instance = Calendar.getInstance();
                instance.setTimeInMillis(j2);
                long j4 = (j3 % MSEC_OF_ONE_DAY) / MSEC_OF_ONE_HOUR;
                long j5 = ((j3 % MSEC_OF_ONE_DAY) % MSEC_OF_ONE_HOUR) / MSEC_OF_ONE_MINUTE;
                Calendar instance2 = Calendar.getInstance();
                instance2.set(11, 0);
                instance2.set(12, 0);
                instance2.set(13, 0);
                instance2.set(14, 0);
                boolean z2 = instance.get(1) == instance2.get(1);
                Calendar instance3 = Calendar.getInstance();
                instance3.add(2, -1);
                instance3.set(11, 0);
                instance3.set(12, 0);
                instance3.set(13, 0);
                instance3.set(14, 0);
                if (instance.after(instance2)) {
                    if (j4 > 0) {
                        return String.format(context2.getString(R.string.time_liveshow_teletext_time_hour_before), new Object[]{Long.valueOf(j4)});
                    } else if (j5 <= 0) {
                        return context2.getString(R.string.time_liveshow_teletext_time_sec_before);
                    } else {
                        return String.format(context2.getString(R.string.time_liveshow_teletext_time_min_before), new Object[]{Long.valueOf(j5)});
                    }
                } else if (instance.after(instance3)) {
                    return String.format(context2.getString(R.string.time_liveshow_teletext_time_day_before), new Object[]{Integer.valueOf((int) (((instance2.getTimeInMillis() - instance.getTimeInMillis()) / MSEC_OF_ONE_DAY) + 1))});
                } else if (z2) {
                    return new SimpleDateFormat("MM-dd", Locale.getDefault()).format(instance.getTime());
                } else {
                    Date time = instance.getTime();
                    String str = "yyyy-MM-dd";
                    if (z) {
                        str = "yyyy-MM-dd HH:mm";
                    }
                    return new SimpleDateFormat(str, Locale.getDefault()).format(time);
                }
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                return String.valueOf(j2);
            }
        } catch (Exception e2) {
            e = e2;
            j2 = j;
            e.printStackTrace();
            return String.valueOf(j2);
        }
    }

    public static String getWeekInZH(Date date) {
        String[] strArr = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        int i2 = instance.get(7) - 1;
        if (i2 < 0) {
            i2 = 0;
        }
        return strArr[i2];
    }

    public static Date format(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return new SimpleDateFormat(str2).parse(str);
        } catch (Exception unused) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd").parse(str);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public static Date getFormatDateTime(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return new SimpleDateFormat(str2).parse(str);
        } catch (Exception unused) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public static String getTextWithSecond(int i2) {
        return getTextWithSecond(i2, true);
    }

    public static Date getNextDayByMode(Date date, int i2) {
        Set<Integer> set;
        if (i2 == 1) {
            set = NORMAL_DAY;
        } else if (i2 == 2) {
            set = WORK_DAY;
        } else if (i2 != 3) {
            set = NORMAL_DAY;
        } else {
            set = WEEKEND_DAY;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(5, 1);
        while (!set.contains(Integer.valueOf(instance.get(7)))) {
            instance.add(5, 1);
        }
        return instance.getTime();
    }

    public static Date format(String str, String[] strArr) {
        Date date = null;
        if (!TextUtils.isEmpty(str) && strArr != null) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                try {
                    date = new SimpleDateFormat(strArr[i2]).parse(str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (date != null) {
                    break;
                }
            }
        }
        return date;
    }
}
