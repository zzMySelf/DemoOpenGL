package com.baidu.searchbox.comment.util;

import android.content.Context;
import com.baidu.android.util.time.DateTimeUtils;
import com.baidu.searchbox.comment.CommentRuntime;
import com.baidu.searchbox.comment.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TimeUtils {
    public static final int DEFAULT_DURATION = 90;
    private static final long HOURS_48 = 172800000;
    private static final long HOURS_72 = 259200000;
    private static final long HOURS_96 = 345600000;
    private static final String MD = "MM-dd";
    private static final long MSEC_OF_ONE_HOUR = 3600000;
    private static final long MSEC_OF_ONE_MINUTE = 60000;
    public static final String Y4MD = "yyyy-MM-dd";
    public static final String Y4MD_HM = "yyyy-MM-dd HH:mm";

    public static String getFormatTeletextTime(long timeStamp) {
        long diff = Math.max(System.currentTimeMillis() - timeStamp, 0);
        Date commentDate = new Date(timeStamp);
        Context context = CommentRuntime.getAppContext();
        if (diff < 60000) {
            return context.getString(R.string.comment_teletext_time_sec_before);
        }
        if (diff < 3600000) {
            return String.format(context.getString(R.string.comment_teletext_time_min_before), new Object[]{Long.valueOf(diff / 60000)});
        } else if (DateTimeUtils.isToday(commentDate)) {
            return String.format(context.getString(R.string.comment_teletext_time_hour_before), new Object[]{Long.valueOf(diff / 3600000)});
        } else if (DateTimeUtils.isYesterday(commentDate)) {
            return context.getString(R.string.comment_teletext_time_yesterday);
        } else {
            if (diff < HOURS_48 && DateTimeUtils.isFewDaysAgo(timeStamp, 2)) {
                return String.format(context.getString(R.string.comment_teletext_time_day_before), new Object[]{1});
            } else if (diff >= HOURS_48 && diff < 259200000) {
                return String.format(context.getString(R.string.comment_teletext_time_day_before), new Object[]{2});
            } else if (diff >= 259200000 && diff < HOURS_96) {
                return String.format(context.getString(R.string.comment_teletext_time_day_before), new Object[]{3});
            } else if (isInThisYear(commentDate)) {
                return new SimpleDateFormat("MM-dd", Locale.getDefault()).format(commentDate);
            } else {
                return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(commentDate);
            }
        }
    }

    private static boolean isInThisYear(Date date) {
        if (date == null) {
            return false;
        }
        Calendar currCal = Calendar.getInstance();
        Calendar dateCal = Calendar.getInstance();
        dateCal.setTime(date);
        if (currCal.get(1) == dateCal.get(1)) {
            return true;
        }
        return false;
    }

    public static String getLastTime(int duration) {
        long timeStamp = System.currentTimeMillis();
        if (duration <= 0) {
            duration = 90;
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(new Date((((long) duration) * 86400000) + timeStamp));
    }

    public static String getDate(String dateStr, String format) {
        try {
            return String.valueOf(new SimpleDateFormat(format, Locale.getDefault()).parse(dateStr).getTime() / 1000);
        } catch (ParseException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static boolean isValueLastTime(String time) {
        if (Long.parseLong(getDate(time, "yyyy-MM-dd HH:mm")) / 60 >= ((86400000 + System.currentTimeMillis()) / 1000) / 60) {
            return true;
        }
        return false;
    }
}
