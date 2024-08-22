package com.baidu.wallet.core;

import android.os.SystemClock;
import android.view.View;

public abstract class ObserveClickIntervalListener implements View.OnClickListener, NoProguard {
    public static final int INTERVAL = 800;
    public long lastClickTime;
    public int mInterval = 800;

    public ObserveClickIntervalListener applyInterval(int i2) {
        if (i2 > 0) {
            this.mInterval = i2;
        }
        return this;
    }

    public void onClick(View view) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.lastClickTime > ((long) this.mInterval)) {
            onSingleClick(view);
        } else {
            onDoubleClick(view);
        }
        this.lastClickTime = uptimeMillis;
    }

    public void onDoubleClick(View view) {
    }

    public abstract void onSingleClick(View view);
}
