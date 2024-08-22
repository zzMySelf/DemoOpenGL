package com.baidu.searchbox.player.event;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.helper.NetUtils;
import com.baidu.searchbox.player.urlparams.UrlParamsManagerKt;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.searchbox.preload.business.inner.PreloadConstantsKt;

class VideoReceiver extends BroadcastReceiver {
    public static final String ACTION_VOLUME_CHANGED = "android.media.VOLUME_CHANGED_ACTION";
    private static final String TAG = "BdVideoReceiver";
    private boolean mHeadsetConnected;
    private boolean mLastIsCharging = false;
    private int mLastNetType = 4;
    private NetUtils.NetStatus mLastStatus = NetUtils.NetStatus.NET_DOWN;
    private int mLastVolume = -1;
    private final VideoReceiverListener mListener;

    interface VideoReceiverListener {
        void onBatteryChanged(int i2);

        void onBatteryChargingChanged(boolean z);

        void onBluetoothHeadsetChanged(boolean z);

        void onConfigurationChanged();

        @Deprecated
        void onConnectChanged(NetUtils.NetStatus netStatus, NetUtils.NetStatus netStatus2);

        void onHeadsetPlug(boolean z);

        void onNetworkChanged(int i2, int i3);

        void onScreenStatusChanged(boolean z);

        void onVolumeChanged(int i2);
    }

    public VideoReceiver(VideoReceiverListener listener) {
        this.mListener = listener;
    }

    public void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PreloadConstantsKt.CONNECTIVITY_ACTION);
        intentFilter.addAction("android.intent.action.DATE_CHANGED");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        intentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
        intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction(ACTION_VOLUME_CHANGED);
        intentFilter.addAction("android.intent.action.CONFIGURATION_CHANGED");
        Intent intent = BDPlayerConfig.getAppContext().registerReceiver(this, intentFilter);
        this.mLastStatus = NetUtils.getNetStatus();
        this.mLastNetType = UrlParamsManagerKt.getNewNetType();
        boolean z = false;
        if (intent.getIntExtra("plugged", 0) != 0) {
            z = true;
        }
        this.mLastIsCharging = z;
    }

    public void unregisterReceiver() {
        BDPlayerConfig.getAppContext().unregisterReceiver(this);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(android.content.Context r11, android.content.Intent r12) {
        /*
            r10 = this;
            if (r12 == 0) goto L_0x0159
            com.baidu.searchbox.player.event.VideoReceiver$VideoReceiverListener r0 = r10.mListener
            if (r0 != 0) goto L_0x0008
            goto L_0x0159
        L_0x0008:
            java.lang.String r0 = r12.getAction()
            if (r0 != 0) goto L_0x000f
            return
        L_0x000f:
            int r1 = r0.hashCode()
            r2 = 5
            r3 = -1
            r4 = 2
            r5 = 1
            r6 = 0
            switch(r1) {
                case -2128145023: goto L_0x007a;
                case -1940635523: goto L_0x006f;
                case -1676458352: goto L_0x0065;
                case -1538406691: goto L_0x005b;
                case -1454123155: goto L_0x0051;
                case -1172645946: goto L_0x0047;
                case -549244379: goto L_0x003d;
                case -403228793: goto L_0x0033;
                case 158859398: goto L_0x0028;
                case 545516589: goto L_0x001d;
                default: goto L_0x001b;
            }
        L_0x001b:
            goto L_0x0084
        L_0x001d:
            java.lang.String r1 = "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x001b
            r1 = 6
            goto L_0x0085
        L_0x0028:
            java.lang.String r1 = "android.intent.action.CONFIGURATION_CHANGED"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x001b
            r1 = 9
            goto L_0x0085
        L_0x0033:
            java.lang.String r1 = "android.intent.action.CLOSE_SYSTEM_DIALOGS"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x001b
            r1 = 3
            goto L_0x0085
        L_0x003d:
            java.lang.String r1 = "android.media.AUDIO_BECOMING_NOISY"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x001b
            r1 = r2
            goto L_0x0085
        L_0x0047:
            java.lang.String r1 = "android.net.conn.CONNECTIVITY_CHANGE"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x001b
            r1 = r6
            goto L_0x0085
        L_0x0051:
            java.lang.String r1 = "android.intent.action.SCREEN_ON"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x001b
            r1 = r4
            goto L_0x0085
        L_0x005b:
            java.lang.String r1 = "android.intent.action.BATTERY_CHANGED"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x001b
            r1 = 7
            goto L_0x0085
        L_0x0065:
            java.lang.String r1 = "android.intent.action.HEADSET_PLUG"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x001b
            r1 = 4
            goto L_0x0085
        L_0x006f:
            java.lang.String r1 = "android.media.VOLUME_CHANGED_ACTION"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x001b
            r1 = 8
            goto L_0x0085
        L_0x007a:
            java.lang.String r1 = "android.intent.action.SCREEN_OFF"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x001b
            r1 = r5
            goto L_0x0085
        L_0x0084:
            r1 = r3
        L_0x0085:
            switch(r1) {
                case 0: goto L_0x0154;
                case 1: goto L_0x0148;
                case 2: goto L_0x013c;
                case 3: goto L_0x0136;
                case 4: goto L_0x00ed;
                case 5: goto L_0x00e2;
                case 6: goto L_0x00ca;
                case 7: goto L_0x0096;
                case 8: goto L_0x0091;
                case 9: goto L_0x008a;
                default: goto L_0x0088;
            }
        L_0x0088:
            goto L_0x0158
        L_0x008a:
            com.baidu.searchbox.player.event.VideoReceiver$VideoReceiverListener r1 = r10.mListener
            r1.onConfigurationChanged()
            goto L_0x0158
        L_0x0091:
            r10.onVolumeChanged(r11)
            goto L_0x0158
        L_0x0096:
            java.lang.String r1 = "level"
            int r1 = r12.getIntExtra(r1, r6)
            java.lang.String r7 = "scale"
            int r7 = r12.getIntExtra(r7, r5)
            int r8 = r1 * 100
            int r8 = r8 / r7
            com.baidu.searchbox.player.utils.BdBatteryUtils.batter_level = r8
            com.baidu.searchbox.player.event.VideoReceiver$VideoReceiverListener r8 = r10.mListener
            int r9 = com.baidu.searchbox.player.utils.BdBatteryUtils.batter_level
            r8.onBatteryChanged(r9)
            java.lang.String r8 = "status"
            int r3 = r12.getIntExtra(r8, r3)
            if (r3 == r4) goto L_0x00bc
            if (r3 != r2) goto L_0x00bb
            goto L_0x00bc
        L_0x00bb:
            r5 = r6
        L_0x00bc:
            r2 = r5
            boolean r4 = r10.mLastIsCharging
            if (r4 == r2) goto L_0x0158
            r10.mLastIsCharging = r2
            com.baidu.searchbox.player.event.VideoReceiver$VideoReceiverListener r4 = r10.mListener
            r4.onBatteryChargingChanged(r2)
            goto L_0x0158
        L_0x00ca:
            java.lang.String r1 = "android.bluetooth.profile.extra.STATE"
            int r1 = r12.getIntExtra(r1, r6)
            if (r1 != r4) goto L_0x00d9
            com.baidu.searchbox.player.event.VideoReceiver$VideoReceiverListener r2 = r10.mListener
            r2.onBluetoothHeadsetChanged(r5)
            goto L_0x0158
        L_0x00d9:
            if (r1 != 0) goto L_0x0158
            com.baidu.searchbox.player.event.VideoReceiver$VideoReceiverListener r2 = r10.mListener
            r2.onBluetoothHeadsetChanged(r6)
            goto L_0x0158
        L_0x00e2:
            java.lang.String r1 = "headset quick ACTION_AUDIO_BECOMING_NOISY"
            com.baidu.searchbox.player.utils.BdVideoLog.d(r1)
            com.baidu.searchbox.player.event.VideoReceiver$VideoReceiverListener r1 = r10.mListener
            r1.onHeadsetPlug(r6)
            goto L_0x0158
        L_0x00ed:
            java.lang.String r1 = "state"
            boolean r2 = r12.hasExtra(r1)
            if (r2 == 0) goto L_0x0158
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "headset "
            java.lang.StringBuilder r2 = r2.append(r3)
            int r3 = r12.getIntExtra(r1, r6)
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.baidu.searchbox.player.utils.BdVideoLog.d(r2)
            boolean r2 = r10.mHeadsetConnected
            if (r2 == 0) goto L_0x0122
            int r2 = r12.getIntExtra(r1, r6)
            if (r2 != 0) goto L_0x0122
            java.lang.String r1 = "headset plugout"
            com.baidu.searchbox.player.utils.BdVideoLog.d(r1)
            r10.mHeadsetConnected = r6
            goto L_0x012e
        L_0x0122:
            boolean r2 = r10.mHeadsetConnected
            if (r2 != 0) goto L_0x012e
            int r1 = r12.getIntExtra(r1, r6)
            if (r1 != r5) goto L_0x012e
            r10.mHeadsetConnected = r5
        L_0x012e:
            com.baidu.searchbox.player.event.VideoReceiver$VideoReceiverListener r1 = r10.mListener
            boolean r2 = r10.mHeadsetConnected
            r1.onHeadsetPlug(r2)
            goto L_0x0158
        L_0x0136:
            java.lang.String r1 = "ACTION_CLOSE_SYSTEM_DIALOGS"
            com.baidu.searchbox.player.utils.BdVideoLog.d(r1)
            goto L_0x0158
        L_0x013c:
            java.lang.String r1 = "screen on"
            com.baidu.searchbox.player.utils.BdVideoLog.d(r1)
            com.baidu.searchbox.player.event.VideoReceiver$VideoReceiverListener r1 = r10.mListener
            r1.onScreenStatusChanged(r6)
            goto L_0x0158
        L_0x0148:
            java.lang.String r1 = "screen off"
            com.baidu.searchbox.player.utils.BdVideoLog.d(r1)
            com.baidu.searchbox.player.event.VideoReceiver$VideoReceiverListener r1 = r10.mListener
            r1.onScreenStatusChanged(r5)
            goto L_0x0158
        L_0x0154:
            r10.onConnectChanged()
        L_0x0158:
            return
        L_0x0159:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.player.event.VideoReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }

    private void onConnectChanged() {
        BdVideoLog.d("connectivity action");
        if (isInitialStickyBroadcast()) {
            BdVideoLog.d("NetChanged: StickBroadcast");
            return;
        }
        NetUtils.NetStatus netstatus = NetUtils.getNetStatus();
        int networkType = UrlParamsManagerKt.getNewNetType();
        BdVideoLog.d("onConnectChanged(), Net status " + netstatus);
        this.mListener.onConnectChanged(this.mLastStatus, netstatus);
        this.mListener.onNetworkChanged(this.mLastNetType, networkType);
        this.mLastStatus = netstatus;
        this.mLastNetType = networkType;
    }

    private void onVolumeChanged(Context context) {
        AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService("audio");
        if (audioManager != null) {
            int curVolume = this.mLastVolume;
            try {
                curVolume = audioManager.getStreamVolume(3);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (curVolume != this.mLastVolume) {
                this.mLastVolume = curVolume;
                this.mListener.onVolumeChanged(curVolume);
            }
        }
    }

    public boolean isBatteryCharging() {
        return this.mLastIsCharging;
    }
}
