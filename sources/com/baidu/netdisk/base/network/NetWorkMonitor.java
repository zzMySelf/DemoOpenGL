package com.baidu.netdisk.base.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import com.baidu.netdisk.config.GlobalConfig;
import com.baidu.netdisk.kernel.architecture.debug.NetDiskLog;
import com.baidu.netdisk.kernel.util.network.ConnectivityState;
import com.baidu.netdisk.kernel.util.network.NetUtil;
import com.baidu.searchbox.preload.business.inner.PreloadConstantsKt;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

public class NetWorkMonitor extends BroadcastReceiver {
    private static long DELAY = 10000;
    public static final String KEY_STOP_BAKEUPTASK_TOGGLE = "key_stop_bakeuptask_toggle";
    public static final String TAG = "NetWorkMonitor";
    private static int mLastNetworkType = -3;
    private static long mobileNetTime = 0;
    private static long noNetTime = 0;
    private static long otherNetTime = 0;
    private static long wifiTime = 0;
    private Handler handler;
    /* access modifiers changed from: private */
    public boolean isChangeToMobileNet;
    /* access modifiers changed from: private */
    public AtomicBoolean isScheduleEnd;
    /* access modifiers changed from: private */
    public Context mContext;
    private long mDelayTime;
    /* access modifiers changed from: private */
    public NetWorkChangeListener mNetWorkChangeListener;
    private Runnable mNotifyRunnable;

    public interface NetWorkChangeListener {
        void networkStateChanged(boolean z, boolean z2);

        void noNetToMobileNet();
    }

    public NetWorkMonitor(NetWorkChangeListener callback, Context context) {
        this(callback, DELAY, context);
    }

    public NetWorkMonitor(NetWorkChangeListener callback, long delay, Context context) {
        this.isScheduleEnd = new AtomicBoolean(true);
        this.mNotifyRunnable = new Runnable() {
            public void run() {
                NetWorkMonitor.this.isScheduleEnd.set(false);
                NetDiskLog.d(NetWorkMonitor.TAG, "isConnected=" + ConnectivityState.isConnected(NetWorkMonitor.this.mContext) + " isWifi=" + ConnectivityState.isWifiEnabled(NetWorkMonitor.this.mContext));
                if (NetWorkMonitor.this.mNetWorkChangeListener != null) {
                    NetWorkMonitor.this.mNetWorkChangeListener.networkStateChanged(ConnectivityState.isConnected(NetWorkMonitor.this.mContext), ConnectivityState.isWifiEnabled(NetWorkMonitor.this.mContext));
                    if (NetWorkMonitor.this.isChangeToMobileNet) {
                        NetWorkMonitor.this.mNetWorkChangeListener.noNetToMobileNet();
                    }
                }
                NetWorkMonitor.this.isScheduleEnd.set(true);
            }
        };
        this.mNetWorkChangeListener = callback;
        this.mDelayTime = delay;
        this.handler = new Handler(Looper.getMainLooper());
        registerMonitor(context);
    }

    public void onReceive(Context context, Intent intent) {
        this.mContext = context;
        NetDiskLog.d(TAG, "onReceive::" + intent.getAction());
        if (this.mNetWorkChangeListener != null && intent.getAction().equals(PreloadConstantsKt.CONNECTIVITY_ACTION) && this.isScheduleEnd.get() && !isWifiApMode()) {
            recordNetState(context);
            this.handler.removeCallbacks(this.mNotifyRunnable);
            this.handler.postDelayed(this.mNotifyRunnable, this.mDelayTime);
        }
    }

    private void recordNetState(Context context) {
        int i2;
        this.isChangeToMobileNet = false;
        long time = getTime();
        if (time != wifiTime && time != mobileNetTime && time != noNetTime && time != otherNetTime) {
            this.isChangeToMobileNet = false;
            int netWorkState = NetUtil.getNetWorkState(context);
            if (netWorkState == 0 && mLastNetworkType != 0) {
                wifiTime = time;
                NetDiskLog.d("wwwwwww", "当前连接的网络为wifi");
            } else if (netWorkState == 1 && (i2 = mLastNetworkType) != 1) {
                mobileNetTime = time;
                if (i2 == 0) {
                    this.isChangeToMobileNet = false;
                } else {
                    this.isChangeToMobileNet = true;
                    NetDiskLog.d("wwwwwww", "从非wifi的网络变为连接数据流量");
                }
                NetDiskLog.d("wwwwwww", "当前连接的网络为数据网络");
            } else if (netWorkState == -1 && mLastNetworkType != -1) {
                noNetTime = time;
                NetDiskLog.d("wwwwwww", "当前连接的网络为无网络");
            } else if (netWorkState == 2 && mLastNetworkType != 2) {
                otherNetTime = time;
                NetDiskLog.d("wwwwwww", "当前连接的网络为其他网络");
            }
            mLastNetworkType = netWorkState;
        }
    }

    public long getTime() {
        try {
            return Long.valueOf(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date())).longValue();
        } catch (NumberFormatException e2) {
            NetDiskLog.d("uiframe", "NetWorkMonitor getTime 转化数字错误");
            return 0;
        }
    }

    private void registerMonitor(Context context) {
        IntentFilter networkFilter = new IntentFilter();
        networkFilter.addAction(PreloadConstantsKt.CONNECTIVITY_ACTION);
        context.registerReceiver(this, networkFilter);
    }

    public void unregisterMonitor(Context context) {
        this.mNetWorkChangeListener = null;
        context.unregisterReceiver(this);
    }

    private boolean isWifiApMode() {
        return GlobalConfig.getInstance().getBoolean(KEY_STOP_BAKEUPTASK_TOGGLE, false);
    }
}
