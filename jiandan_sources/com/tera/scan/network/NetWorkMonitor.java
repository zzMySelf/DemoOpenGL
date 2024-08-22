package com.tera.scan.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import fe.mmm.qw.ppp.ad.qw.ad;
import fe.mmm.qw.yj.de;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

public class NetWorkMonitor extends BroadcastReceiver {

    /* renamed from: i  reason: collision with root package name */
    public static long f7041i = 0;

    /* renamed from: if  reason: not valid java name */
    public static int f291if = -3;

    /* renamed from: o  reason: collision with root package name */
    public static long f7042o;

    /* renamed from: pf  reason: collision with root package name */
    public static long f7043pf;

    /* renamed from: uk  reason: collision with root package name */
    public static long f7044uk;

    /* renamed from: ad  reason: collision with root package name */
    public AtomicBoolean f7045ad;

    /* renamed from: de  reason: collision with root package name */
    public NetWorkChangeListener f7046de;

    /* renamed from: fe  reason: collision with root package name */
    public Context f7047fe;
    public Handler qw;

    /* renamed from: rg  reason: collision with root package name */
    public long f7048rg;

    /* renamed from: th  reason: collision with root package name */
    public boolean f7049th;

    /* renamed from: yj  reason: collision with root package name */
    public Runnable f7050yj;

    public interface NetWorkChangeListener {
        void ad();

        void qw(boolean z, boolean z2);
    }

    public class qw implements Runnable {
        public qw() {
        }

        public void run() {
            NetWorkMonitor.this.f7045ad.set(false);
            fe.mmm.qw.i.qw.ad("NetWorkMonitor", "isConnected=" + fe.mmm.qw.ppp.ad.qw.qw.ad(NetWorkMonitor.this.f7047fe) + " isWifi=" + fe.mmm.qw.ppp.ad.qw.qw.fe(NetWorkMonitor.this.f7047fe));
            if (NetWorkMonitor.this.f7046de != null) {
                NetWorkMonitor.this.f7046de.qw(fe.mmm.qw.ppp.ad.qw.qw.ad(NetWorkMonitor.this.f7047fe), fe.mmm.qw.ppp.ad.qw.qw.fe(NetWorkMonitor.this.f7047fe));
                if (NetWorkMonitor.this.f7049th) {
                    NetWorkMonitor.this.f7046de.ad();
                }
            }
            NetWorkMonitor.this.f7045ad.set(true);
        }
    }

    public NetWorkMonitor(NetWorkChangeListener netWorkChangeListener, Context context) {
        this(netWorkChangeListener, 10000, context);
    }

    public void i(Context context) {
        this.f7046de = null;
        context.unregisterReceiver(this);
    }

    public void onReceive(Context context, Intent intent) {
        this.f7047fe = context;
        fe.mmm.qw.i.qw.ad("NetWorkMonitor", "onReceive::" + intent.getAction());
        if (this.f7046de != null && intent.getAction().equals(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION) && this.f7045ad.get() && !th()) {
            yj(context);
            this.qw.removeCallbacks(this.f7050yj);
            this.qw.postDelayed(this.f7050yj, this.f7048rg);
        }
    }

    public long rg() {
        try {
            return Long.valueOf(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date())).longValue();
        } catch (NumberFormatException unused) {
            fe.mmm.qw.i.qw.ad("uiframe", "NetWorkMonitor getTime 转化数字错误");
            return 0;
        }
    }

    public final boolean th() {
        return de.ppp().fe("key_stop_bakeuptask_toggle", false);
    }

    public final void uk(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION);
        context.registerReceiver(this, intentFilter);
    }

    public final void yj(Context context) {
        int i2;
        this.f7049th = false;
        long rg2 = rg();
        if (rg2 != f7044uk && rg2 != f7041i && rg2 != f7042o && rg2 != f7043pf) {
            this.f7049th = false;
            int qw2 = ad.qw(context);
            if (qw2 == 0 && f291if != 0) {
                f7044uk = rg2;
                fe.mmm.qw.i.qw.ad("wwwwwww", "当前连接的网络为wifi");
            } else if (qw2 == 1 && (i2 = f291if) != 1) {
                f7041i = rg2;
                if (i2 == 0) {
                    this.f7049th = false;
                } else {
                    this.f7049th = true;
                    fe.mmm.qw.i.qw.ad("wwwwwww", "从非wifi的网络变为连接数据流量");
                }
                fe.mmm.qw.i.qw.ad("wwwwwww", "当前连接的网络为数据网络");
            } else if (qw2 == -1 && f291if != -1) {
                f7042o = rg2;
                fe.mmm.qw.i.qw.ad("wwwwwww", "当前连接的网络为无网络");
            } else if (qw2 == 2 && f291if != 2) {
                f7043pf = rg2;
                fe.mmm.qw.i.qw.ad("wwwwwww", "当前连接的网络为其他网络");
            }
            f291if = qw2;
        }
    }

    public NetWorkMonitor(NetWorkChangeListener netWorkChangeListener, long j, Context context) {
        this.f7045ad = new AtomicBoolean(true);
        this.f7050yj = new qw();
        this.f7046de = netWorkChangeListener;
        this.f7048rg = j;
        this.qw = new Handler(Looper.getMainLooper());
        uk(context);
    }
}
