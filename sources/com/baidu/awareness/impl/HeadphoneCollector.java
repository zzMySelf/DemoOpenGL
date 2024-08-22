package com.baidu.awareness.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.baidu.awareness.state.HeadphoneState;

class HeadphoneCollector extends BaseCollector<HeadphoneState> {
    private BroadcastReceiver mReceiver = null;

    HeadphoneCollector(Context context) {
        super(context);
    }

    /* access modifiers changed from: package-private */
    public long autoDestoryTime() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public HeadphoneState tryToGetInstantData() {
        boolean isHeadsetOn = ((AudioManager) this.mContext.getSystemService("audio")).isWiredHeadsetOn();
        HeadphoneState headphoneState = new HeadphoneState();
        headphoneState.state = isHeadsetOn;
        headphoneState.updateTime = System.currentTimeMillis();
        return headphoneState;
    }

    /* access modifiers changed from: package-private */
    public void start() {
        L.d("HeadphoneCollector start");
        this.mOnCollectFinishListener.onCollectFinish(4, tryToGetInstantData());
        IntentFilter filter = new IntentFilter("android.intent.action.HEADSET_PLUG");
        this.mReceiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                if ("android.intent.action.HEADSET_PLUG".equals(intent.getAction()) && intent.hasExtra("state")) {
                    int state = intent.getIntExtra("state", 0);
                    HeadphoneState headphoneState = new HeadphoneState();
                    headphoneState.state = state;
                    headphoneState.updateTime = System.currentTimeMillis();
                    HeadphoneCollector.this.mOnCollectFinishListener.onCollectFinish(4, headphoneState);
                }
            }
        };
        this.mContext.registerReceiver(this.mReceiver, filter);
    }

    /* access modifiers changed from: package-private */
    public void stop() {
        L.d("HeadphoneCollector stop");
        if (this.mReceiver != null) {
            this.mContext.unregisterReceiver(this.mReceiver);
        }
        this.mOnCollectFinishListener.onCollectFinish(4, (BaseState) null);
    }
}
