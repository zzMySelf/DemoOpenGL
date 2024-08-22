package com.baidu.searchbox.widget;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;

public class ClockWidgetReceiverManager {
    private static volatile ClockWidgetReceiverManager sInstanse;
    private BroadcastReceiver mClockWidgetTimeChangeReceiver;

    public static ClockWidgetReceiverManager getInstanse() {
        if (sInstanse == null) {
            synchronized (BroadcastReceiver.class) {
                if (sInstanse == null) {
                    sInstanse = new ClockWidgetReceiverManager();
                }
            }
        }
        return sInstanse;
    }

    public void registerClockWidgetProviderReceiver() {
        try {
            this.mClockWidgetTimeChangeReceiver = new ClockWidgetProvider();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.DATE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            AppRuntime.getAppContext().registerReceiver(this.mClockWidgetTimeChangeReceiver, intentFilter);
        } catch (Throwable e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        }
    }

    public void unregisterClockWidgetProviderReceiver() {
        if (this.mClockWidgetTimeChangeReceiver != null) {
            try {
                AppRuntime.getAppContext().unregisterReceiver(this.mClockWidgetTimeChangeReceiver);
            } catch (Exception e2) {
            }
        }
    }
}
