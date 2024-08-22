package com.baidu.searchbox.push;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.format.Time;
import android.util.Log;
import com.baidu.android.common.ui.style.R;
import com.baidu.android.imsdk.chatmessage.IGetNewMsgCountListener;
import com.baidu.netdisk.kernel.util.TimeUtil;
import com.baidu.searchbox.bridge.MessageRuntime;
import com.baidu.searchbox.imsdk.ImSdkManager;
import com.baidu.searchbox.push.mymessagefragment.viewholder.MyMessageAdapterViewHolder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public final class MyMessageUtils {
    private static final boolean DEBUG = MessageRuntime.GLOBAL_DEBUG;
    public static final int MAX_NOT_READ_COUNT = 100;
    private static final String TAG = "MyMessageUtils";
    private static long sNowTime = -1;

    private MyMessageUtils() {
    }

    public static String formatMessageTime(Context context, long time) {
        long time2;
        if (time < 10000000000L) {
            time2 = 1000 * time;
        } else {
            time2 = time;
        }
        Calendar thenCal = Calendar.getInstance(getCurrentLocale());
        thenCal.setTimeInMillis(time2);
        Date thenDate = thenCal.getTime();
        Calendar nowCal = Calendar.getInstance(getCurrentLocale());
        long currentTime = System.currentTimeMillis();
        nowCal.setTimeInMillis(getNowTime(currentTime));
        if (DEBUG) {
            Log.d(TAG, "currentTime=" + currentTime + "; msg time = " + time2);
        }
        if (time2 > currentTime || (thenCal.get(1) == nowCal.get(1) && thenCal.get(2) == nowCal.get(2) && thenCal.get(5) == nowCal.get(5))) {
            if (DateFormat.is24HourFormat(MessageRuntime.getAppContext())) {
                return new SimpleDateFormat(TimeUtil.LONG_TIME_FORMAT1, getCurrentLocale()).format(thenDate);
            }
            String timePart1 = new SimpleDateFormat("hh:mm", getCurrentLocale()).format(thenDate);
            int hours = thenDate.getHours();
            if (hours >= 0 && hours < 5) {
                return "凌晨 " + timePart1;
            }
            if (5 <= hours && hours < 12) {
                return "上午 " + timePart1;
            }
            if (12 > hours || hours >= 19) {
                return "晚上 " + timePart1;
            }
            return "下午 " + timePart1;
        } else if (thenCal.get(1) != nowCal.get(1)) {
            return new SimpleDateFormat("yy-MM-dd", getCurrentLocale()).format(thenDate);
        } else {
            if (nowCal.get(6) - thenCal.get(6) == 1) {
                return "昨天";
            }
            if ((nowCal.get(3) != thenCal.get(3) || thenCal.get(7) == 1) && (nowCal.get(3) - 1 != thenCal.get(3) || thenCal.get(7) == 1 || nowCal.get(7) != 1)) {
                return new SimpleDateFormat(TimeUtil.SHORT_DATE_FORMAT, getCurrentLocale()).format(thenDate);
            }
            try {
                return "星期" + new String[]{"日", "一", "二", "三", "四", "五", "六"}[thenCal.get(7) - 1];
            } catch (Exception e2) {
                return "星期日";
            }
        }
    }

    public static long getNowTime(long now) {
        if (sNowTime < 0) {
            sNowTime = now;
        }
        if (Math.abs(sNowTime - now) > 1000) {
            sNowTime = now;
        }
        return sNowTime;
    }

    public static Locale getCurrentLocale() {
        return MessageRuntime.getAppContext().getResources().getConfiguration().locale;
    }

    public static void setIcon(String iconUrl, int defaultIconType, MyMessageAdapterViewHolder holder) {
        int iconResID;
        if (holder != null) {
            if (defaultIconType == 1) {
                iconResID = R.drawable.message_portrait;
            } else if (defaultIconType == 2) {
                iconResID = R.drawable.msg_center_card;
            } else if (defaultIconType == 3) {
                iconResID = R.drawable.launcher_default_icon;
            } else if (defaultIconType == 4) {
                iconResID = R.drawable.message_portrait;
            } else if (defaultIconType == 6) {
                iconResID = R.drawable.msg_center_chat;
            } else if (defaultIconType == 7) {
                iconResID = R.drawable.im_chat_advisory_icon;
            } else if (defaultIconType == 8) {
                iconResID = R.drawable.im_icon_guanzhu;
            } else if (defaultIconType == 9) {
                iconResID = R.drawable.im_icon_hudong;
            } else if (defaultIconType == 10) {
                iconResID = R.drawable.im_icon_stranger;
            } else if (defaultIconType == 11) {
                iconResID = R.drawable.im_icon_gfh_agg;
            } else if (DEBUG == 0) {
                iconResID = R.drawable.icon;
            } else {
                throw new RuntimeException("Unknown default icon type setIcon(" + iconUrl + ", " + defaultIconType + ", " + holder.toString() + ")!");
            }
            if (!TextUtils.isEmpty(iconUrl) && defaultIconType != 7 && defaultIconType != 9 && defaultIconType != 10 && defaultIconType != 11) {
                holder.iconView.setImageURI(Uri.parse(iconUrl));
            } else if (defaultIconType == 6) {
                holder.iconView.setImageResource(iconResID);
            } else {
                holder.iconView.setImageURI(MessageUtils.getUri(iconResID));
            }
            ((GenericDraweeHierarchy) holder.iconView.getHierarchy()).setPlaceholderImage(iconResID);
        }
    }

    public static String parseNotReadCount(long count) {
        if (count <= 0) {
            return null;
        }
        if (count < 100) {
            return String.valueOf(count);
        }
        return "99+";
    }

    public static int getAggregteNewImCount() {
        int count = ImSdkManager.getInstance(MessageRuntime.getAppContext()).getNewImMsgCount();
        if (count < 0) {
            return 0;
        }
        return count;
    }

    public static void getInteractionNewCount(IGetNewMsgCountListener listener) {
        ImSdkManager.getInstance(MessageRuntime.getAppContext()).getInteractionNewCount(listener);
    }

    public static String getInteractionLastUserportrait() {
        return ImSdkManager.getInstance(MessageRuntime.getAppContext()).getInteractionLastUserportrait();
    }

    public static String getInteractionPaid() {
        return ImSdkManager.getInstance(MessageRuntime.getAppContext()).getInteractionPaid();
    }

    public static boolean isCurrentInTimeScope(int beginHour, int beginMin, int endHour, int endMin) {
        long currentTimeMillis = System.currentTimeMillis();
        Time now = new Time();
        now.set(currentTimeMillis);
        Time startTime = new Time();
        startTime.set(currentTimeMillis);
        startTime.hour = beginHour;
        startTime.minute = beginMin;
        Time endTime = new Time();
        endTime.set(currentTimeMillis);
        endTime.hour = endHour;
        endTime.minute = endMin;
        boolean result = false;
        if (!startTime.before(endTime)) {
            startTime.set(startTime.toMillis(true) - 86400000);
            if (!now.before(startTime) && !now.after(endTime)) {
                result = true;
            }
            boolean result2 = result;
            Time startTimeInThisDay = new Time();
            startTimeInThisDay.set(startTime.toMillis(true) + 86400000);
            if (!now.before(startTimeInThisDay)) {
                return true;
            }
            return result2;
        }
        if (!now.before(startTime) && !now.after(endTime)) {
            result = true;
        }
        return result;
    }
}
