package com.baidu.megapp.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

public class NotificationChannelUtil {
    public static final String APS_CHANNEL = "aps_channel";
    public static final String APS_CHANNEL_FLAG = "插件中心";
    private static boolean hasInit = false;
    private static NotificationManager manager;

    private static void init(Context context) {
        if (!hasInit) {
            createDownloadChannel(context);
            hasInit = true;
        }
    }

    private static void createDownloadChannel(Context context) {
        NotificationChannel downloadChannel = new NotificationChannel(APS_CHANNEL, APS_CHANNEL_FLAG, 2);
        downloadChannel.setLockscreenVisibility(0);
        ((NotificationManager) context.getSystemService("notification")).createNotificationChannel(downloadChannel);
    }

    public static void setNotificationChannelId(Context context, Notification.Builder builder, String channelId) {
        init(context);
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setChannelId(channelId);
        }
    }
}
