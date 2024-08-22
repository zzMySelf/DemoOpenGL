package com.baidu.netdisk.kernel.android.util.monitor.battery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.netdisk.kernel.architecture.debug.NetDiskLog;
import java.util.LinkedHashMap;

public class BatteryMonitor extends BroadcastReceiver {
    private static final int LOW_POWER_LEVEL = 20;
    private static final int MAXLISTER = 2;
    public static final int POWER_LEVEL_EMPTY = 1;
    public static final int POWER_LEVEL_FULL = 4;
    public static final int POWER_LEVEL_HALF = 3;
    public static final int POWER_LEVEL_LITTLE = 2;
    private static final String TAG = "BatteryMonitor";
    private static int sCurrentPowerShowLevel = -1;
    private static int sLevel = 100;
    private static boolean sLowPower = false;
    private static PowerChangedListener sPowerChangedListener;
    private static BatteryMonitor sPowerChangedMonitor;
    private static boolean sPowerConnected = false;
    private static LinkedHashMap<String, PowerListener> sPowerListenerHashMap;

    public void onReceive(Context arg0, Intent arg1) {
        if (arg1 != null) {
            String action = arg1.getAction();
            if (TextUtils.isEmpty(action)) {
                NetDiskLog.w(TAG, "action 为空");
                return;
            }
            NetDiskLog.d(TAG, "action=" + action);
            if ("android.intent.action.BATTERY_CHANGED".contains(action)) {
                try {
                    sLevel = arg1.getIntExtra("level", 0);
                } catch (Exception e2) {
                }
                NetDiskLog.i(TAG, "ACTION_BATTERY_CHANGED:: level=" + sLevel);
                notifyPowerChanged(sLevel);
                if (sLevel > 20 && sLowPower) {
                    sLowPower = false;
                    powerChangeListener(false);
                }
            } else if ("android.intent.action.BATTERY_LOW".equals(action)) {
                NetDiskLog.i(TAG, "ACTION_BATTERY_LOW::");
                sLowPower = true;
                powerChangeListener(true);
            } else if ("android.intent.action.BATTERY_OKAY".equals(action)) {
                NetDiskLog.i(TAG, "ACTION_BATTERY_OKAY::");
                sLowPower = false;
                powerChangeListener(false);
            } else if ("android.intent.action.ACTION_POWER_CONNECTED".equals(action)) {
                sPowerConnected = true;
                powerChangeListener(false);
            } else if ("android.intent.action.ACTION_POWER_DISCONNECTED".equals(action)) {
                sPowerConnected = false;
                powerChangeListener(sLowPower);
            }
            NetDiskLog.d(TAG, "sPowerConnected = " + sPowerConnected);
        }
    }

    public static boolean isLowPower() {
        return sLowPower && !sPowerConnected;
    }

    public static boolean isPowerConnected() {
        return sPowerConnected;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void powerChangeListener(boolean r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.LinkedHashMap<java.lang.String, com.baidu.netdisk.kernel.android.util.monitor.battery.PowerListener> r0 = sPowerListenerHashMap     // Catch:{ all -> 0x003f }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r3)
            return
        L_0x0007:
            java.util.Set r0 = r0.keySet()     // Catch:{ all -> 0x003f }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x003f }
            if (r4 == 0) goto L_0x0027
        L_0x0011:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x003d
            java.util.LinkedHashMap<java.lang.String, com.baidu.netdisk.kernel.android.util.monitor.battery.PowerListener> r1 = sPowerListenerHashMap     // Catch:{ all -> 0x003f }
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x003f }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x003f }
            com.baidu.netdisk.kernel.android.util.monitor.battery.PowerListener r1 = (com.baidu.netdisk.kernel.android.util.monitor.battery.PowerListener) r1     // Catch:{ all -> 0x003f }
            r1.powerLacked()     // Catch:{ all -> 0x003f }
            goto L_0x0011
        L_0x0027:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x003d
            java.util.LinkedHashMap<java.lang.String, com.baidu.netdisk.kernel.android.util.monitor.battery.PowerListener> r1 = sPowerListenerHashMap     // Catch:{ all -> 0x003f }
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x003f }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x003f }
            com.baidu.netdisk.kernel.android.util.monitor.battery.PowerListener r1 = (com.baidu.netdisk.kernel.android.util.monitor.battery.PowerListener) r1     // Catch:{ all -> 0x003f }
            r1.powerAdequated()     // Catch:{ all -> 0x003f }
            goto L_0x0027
        L_0x003d:
            monitor-exit(r3)
            return
        L_0x003f:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.netdisk.kernel.android.util.monitor.battery.BatteryMonitor.powerChangeListener(boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void addPowerListener(java.lang.String r3, com.baidu.netdisk.kernel.android.util.monitor.battery.PowerListener r4) {
        /*
            java.lang.Class<com.baidu.netdisk.kernel.android.util.monitor.battery.BatteryMonitor> r0 = com.baidu.netdisk.kernel.android.util.monitor.battery.BatteryMonitor.class
            monitor-enter(r0)
            java.util.LinkedHashMap<java.lang.String, com.baidu.netdisk.kernel.android.util.monitor.battery.PowerListener> r1 = sPowerListenerHashMap     // Catch:{ all -> 0x0022 }
            if (r1 == 0) goto L_0x0015
            boolean r1 = r1.containsKey(r3)     // Catch:{ all -> 0x0022 }
            if (r1 == 0) goto L_0x000f
            monitor-exit(r0)
            return
        L_0x000f:
            java.util.LinkedHashMap<java.lang.String, com.baidu.netdisk.kernel.android.util.monitor.battery.PowerListener> r1 = sPowerListenerHashMap     // Catch:{ all -> 0x0022 }
            r1.put(r3, r4)     // Catch:{ all -> 0x0022 }
            goto L_0x0020
        L_0x0015:
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap     // Catch:{ all -> 0x0022 }
            r2 = 2
            r1.<init>(r2)     // Catch:{ all -> 0x0022 }
            sPowerListenerHashMap = r1     // Catch:{ all -> 0x0022 }
            r1.put(r3, r4)     // Catch:{ all -> 0x0022 }
        L_0x0020:
            monitor-exit(r0)
            return
        L_0x0022:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.netdisk.kernel.android.util.monitor.battery.BatteryMonitor.addPowerListener(java.lang.String, com.baidu.netdisk.kernel.android.util.monitor.battery.PowerListener):void");
    }

    public static void removePowerListener(String key) {
        LinkedHashMap<String, PowerListener> linkedHashMap = sPowerListenerHashMap;
        if (linkedHashMap != null && linkedHashMap.containsKey(key)) {
            sPowerListenerHashMap.remove(key);
        }
    }

    private synchronized void notifyPowerChanged(int level) {
        int showLevel = getPowerLevelToShow(level);
        if (showLevel != sCurrentPowerShowLevel) {
            PowerChangedListener powerChangedListener = sPowerChangedListener;
            if (powerChangedListener != null) {
                powerChangedListener.onPowerLevelChanged(showLevel);
            }
            sCurrentPowerShowLevel = showLevel;
        }
    }

    public static int getCurrentPowerShowLevel() {
        return sCurrentPowerShowLevel;
    }

    public static int getBatteryPercent() {
        return sLevel;
    }

    private int getPowerLevelToShow(int level) {
        if (level >= 0 && level < 5) {
            return 1;
        }
        if (5 <= level && level < 30) {
            return 2;
        }
        if (30 <= level && level < 60) {
            return 3;
        }
        if (level >= 60) {
            return 4;
        }
        return 1;
    }

    public static synchronized void registePowerChangedListener(Context context, PowerChangedListener listener) {
        synchronized (BatteryMonitor.class) {
            if (listener != null) {
                sPowerChangedListener = listener;
            }
            if (sPowerChangedMonitor == null) {
                IntentFilter filter = new IntentFilter();
                filter.addAction("android.intent.action.BATTERY_CHANGED");
                filter.addAction("android.intent.action.BATTERY_LOW");
                filter.addAction("android.intent.action.BATTERY_OKAY");
                filter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
                filter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
                BatteryMonitor batteryMonitor = new BatteryMonitor();
                sPowerChangedMonitor = batteryMonitor;
                try {
                    context.registerReceiver(batteryMonitor, filter);
                } catch (IllegalArgumentException ignore) {
                    NetDiskLog.w(TAG, "registPowerChangedListener", ignore);
                }
            } else {
                return;
            }
        }
    }

    public static synchronized void unregistePowerChangedListener(Context context, PowerChangedListener listener) {
        synchronized (BatteryMonitor.class) {
            sPowerChangedListener = null;
            BatteryMonitor batteryMonitor = sPowerChangedMonitor;
            if (batteryMonitor != null) {
                try {
                    context.unregisterReceiver(batteryMonitor);
                } catch (IllegalArgumentException ignore) {
                    NetDiskLog.w(TAG, "unregistePowerChangedListener", ignore);
                }
            }
            sPowerChangedMonitor = null;
        }
    }

    public static void registePowerChangedListener(Context context) {
        registePowerChangedListener(context, (PowerChangedListener) null);
    }

    public static void unregistePowerChangedListener(Context context) {
        unregistePowerChangedListener(context, (PowerChangedListener) null);
    }
}
