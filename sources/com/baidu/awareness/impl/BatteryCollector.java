package com.baidu.awareness.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.awareness.impl.BaseCollector;
import com.baidu.awareness.state.BatteryState;

public class BatteryCollector extends BaseCollector<BatteryState> {
    private BatteryStateChangeReceiver mBatteryStateChangeReceiver;

    BatteryCollector(Context mContext) {
        super(mContext);
    }

    /* access modifiers changed from: package-private */
    public BatteryState tryToGetInstantData() {
        Intent batteryStatus = this.mContext.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int status = batteryStatus.getIntExtra("status", -1);
        boolean isCharging = status == 2 || status == 5;
        BatteryState batteryState = new BatteryState();
        batteryState.updateTime = System.currentTimeMillis();
        batteryState.isCharging = isCharging;
        if (isCharging) {
            batteryState.chargeWay = batteryStatus.getIntExtra("plugged", -1);
        }
        float level = (float) batteryStatus.getIntExtra("level", -1);
        float scale = (float) batteryStatus.getIntExtra("scale", -1);
        batteryState.leftBatteryRatio = level / scale;
        batteryState.batteryRemainingLevel = (float) ((int) ((((double) level) * 100.0d) / ((double) scale)));
        return batteryState;
    }

    /* access modifiers changed from: package-private */
    public void start() {
        super.start();
        L.d("BatteryCollector start");
        this.mOnCollectFinishListener.onCollectFinish(9, tryToGetInstantData());
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.BATTERY_LOW");
        filter.addAction("android.intent.action.BATTERY_OKAY");
        filter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        filter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        this.mBatteryStateChangeReceiver = new BatteryStateChangeReceiver(this.mOnCollectFinishListener);
        this.mContext.registerReceiver(this.mBatteryStateChangeReceiver, filter);
    }

    /* access modifiers changed from: package-private */
    public void stop() {
        super.stop();
        L.d("BatteryCollector stop");
        this.mContext.unregisterReceiver(this.mBatteryStateChangeReceiver);
        this.mBatteryStateChangeReceiver = null;
        this.mOnCollectFinishListener.onCollectFinish(9, (BaseState) null);
    }

    public class BatteryStateChangeReceiver extends BroadcastReceiver {
        private BaseCollector.OnCollectFinishListener callback;

        public BatteryStateChangeReceiver(BaseCollector.OnCollectFinishListener callback2) {
            this.callback = callback2;
        }

        public void onReceive(Context context, Intent intent) {
            this.callback.onCollectFinish(9, BatteryCollector.this.tryToGetInstantData());
        }
    }
}
