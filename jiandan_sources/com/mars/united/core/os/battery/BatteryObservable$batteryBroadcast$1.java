package com.mars.united.core.os.battery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import fe.ggg.ad.qw.de.de.qw;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/mars/united/core/os/battery/BatteryObservable$batteryBroadcast$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "batteryStatus", "Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BatteryObservable$batteryBroadcast$1 extends BroadcastReceiver {
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        String str;
        String action = intent == null ? null : intent.getAction();
        if (action != null) {
            switch (action.hashCode()) {
                case -1980154005:
                    str = "android.intent.action.BATTERY_OKAY";
                    break;
                case -1886648615:
                    str = "android.intent.action.ACTION_POWER_DISCONNECTED";
                    break;
                case -1538406691:
                    if (action.equals("android.intent.action.BATTERY_CHANGED")) {
                        BatteryObservable.qw.ad(qw.qw(intent));
                        return;
                    }
                    return;
                case 490310653:
                    str = "android.intent.action.BATTERY_LOW";
                    break;
                case 1019184907:
                    str = "android.intent.action.ACTION_POWER_CONNECTED";
                    break;
                default:
                    return;
            }
            boolean equals = action.equals(str);
        }
    }
}
