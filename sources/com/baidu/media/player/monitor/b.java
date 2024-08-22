package com.baidu.media.player.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberMediaCommand;
import com.baidu.cyberplayer.sdk.CyberTaskExecutor;
import com.baidu.cyberplayer.sdk.DeviceInfoUtils;
import com.baidu.cyberplayer.sdk.PlayerConfigManager;
import com.baidu.cyberplayer.sdk.mediainfo.DuDownloaderInfo;
import com.baidu.cyberplayer.sdk.remote.DuMediaPrefetchOptions;
import com.baidu.cyberplayer.sdk.statistics.DpNetworkUtils;
import com.baidu.media.player.Utils;
import com.baidu.searchbox.preload.business.inner.PreloadConstantsKt;

public class b extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f15320a = false;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f15321b = false;

    private b() {
    }

    public static void a(Context context, boolean z) {
        if (!f15320a) {
            f15321b = z;
            if (z) {
                b(context, false);
                return;
            }
            synchronized (b.class) {
                if (!f15320a) {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction(PreloadConstantsKt.CONNECTIVITY_ACTION);
                    context.registerReceiver(new b(), intentFilter);
                    f15320a = true;
                    CyberLog.d("NetWorkStateMonitor", "initOnce");
                }
            }
        }
    }

    public static void b(Context context, final boolean z) {
        NetworkInfo netWorkInfo = DpNetworkUtils.getNetWorkInfo(context);
        final int networkConnectType = DpNetworkUtils.getNetworkConnectType(netWorkInfo);
        PlayerConfigManager.updateNetWorkType(networkConnectType);
        DuDownloaderInfo.setNetworkType(networkConnectType);
        final int i2 = 0;
        if (netWorkInfo != null) {
            CyberLog.d("NetWorkStateMonitor", "networkInfo:" + netWorkInfo.toString());
            if (netWorkInfo.getState() == NetworkInfo.State.CONNECTED) {
                i2 = 1;
            }
        }
        final String c2 = Utils.c();
        if (c2 != null && c2.length() > 0) {
            c2 = "http://" + c2;
        }
        CyberLog.d("NetWorkStateMonitor", "onReceive type:" + networkConnectType + " state:" + i2 + " proxyServer:" + c2);
        CyberTaskExecutor.getInstance().executeSingleHighThread(new Runnable() {
            public void run() {
                if (z) {
                    CyberMediaCommand.sendGlobalCommandToRemote("onReceiveNetworkInfo", networkConnectType, (long) i2, c2, (DuMediaPrefetchOptions) null);
                }
                Utils.nativeUpdateNetworkInfo(networkConnectType, i2, c2);
                DeviceInfoUtils.clearOperator();
            }
        });
    }

    public void onReceive(Context context, Intent intent) {
        boolean z = !f15321b;
        CyberLog.d("NetWorkStateMonitor", "onReceive called isNeedNotifyRemote:" + z);
        b(context, z);
    }
}
