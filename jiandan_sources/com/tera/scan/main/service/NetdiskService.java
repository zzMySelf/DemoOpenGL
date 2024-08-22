package com.tera.scan.main.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.text.TextUtils;
import com.mars.kotlin.service.IHandlable;
import com.mars.kotlin.service.extension.ServiceKt;
import com.tera.scan.framework.component.base.service.IServiceBinder;
import com.tera.scan.framework.kernel.SchedulerManager;
import com.tera.scan.framework.kernel.service.ISchedulerService;
import com.tera.scan.framework.service.HandlableManager;
import com.tera.scan.main.NetWorkMonitor;
import com.tera.scan.main.TeraScanApplication;
import fe.mmm.qw.a.yj.de.fe;
import fe.mmm.qw.p030switch.fe.qw.qw.ad;

public class NetdiskService extends Service {

    /* renamed from: ad  reason: collision with root package name */
    public fe f6985ad;

    /* renamed from: th  reason: collision with root package name */
    public ServiceManager f6986th;

    /* renamed from: uk  reason: collision with root package name */
    public NetWorkMonitor f6987uk;

    /* renamed from: yj  reason: collision with root package name */
    public ad f6988yj;

    public class qw extends Binder implements SchedulerManager.ISchedulerBinder, IServiceBinder {
        public qw() {
        }
    }

    public IBinder onBind(Intent intent) {
        fe.mmm.qw.i.qw.ad("NetdiskService", "onBind");
        return new qw();
    }

    public void onCreate() {
        super.onCreate();
        fe.mmm.qw.i.qw.ad("NetdiskService", "AppLaunch:Service Create Start");
        fe feVar = new fe("default");
        this.f6985ad = feVar;
        feVar.ad();
        ServiceManager serviceManager = new ServiceManager(HandlableManager.qw(), this.f6985ad, getApplicationContext());
        this.f6986th = serviceManager;
        serviceManager.fe(HandlableManager.qw());
        this.f6986th.de(HandlableManager.qw());
        fe.mmm.qw.xxx.i.qw.ad().rg(this.f6986th);
        if (TeraScanApplication.netdiskApplication.isEnableStartService()) {
            fe.mmm.qw.i.qw.uk("NetdiskService", "transmit service create initializeTasks");
            this.f6988yj = new ad(HandlableManager.qw(), getApplicationContext());
            fe.mmm.qw.xxx.i.qw.ad().th(this.f6988yj);
            fe.mmm.qw.p030switch.fe.qw.qw.qw.qw().ad(this);
            NetWorkMonitor netWorkMonitor = new NetWorkMonitor();
            this.f6987uk = netWorkMonitor;
            netWorkMonitor.qw(getApplicationContext());
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (HandlableManager.qw() != null) {
            HandlableManager.qw().fe();
        }
        fe feVar = this.f6985ad;
        if (feVar != null) {
            feVar.de();
        }
        NetWorkMonitor netWorkMonitor = this.f6987uk;
        if (netWorkMonitor != null) {
            netWorkMonitor.ad(TeraScanApplication.netdiskApplication);
        }
        if (TeraScanApplication.netdiskApplication.isEnableStartService()) {
            stopForeground(true);
            fe.mmm.qw.xxx.i.qw.ad().qw();
        }
    }

    public void onStart(Intent intent, int i2) {
        ServiceManager serviceManager;
        super.onStart(intent, i2);
        if (intent != null && TeraScanApplication.netdiskApplication.isEnableStartService() && (serviceManager = this.f6986th) != null) {
            ISchedulerService ad2 = serviceManager.ad(intent);
            if (ad2 != null) {
                ad2.qw(intent, this);
                return;
            }
            ISchedulerService qw2 = this.f6988yj.qw(intent);
            if (qw2 != null) {
                qw2.qw(intent, this);
            } else if (!ServiceKt.onHandle((Service) this, intent, (IHandlable<? extends Object>[]) HandlableManager.ad(getApplicationContext()))) {
                String action = intent.getAction();
                fe.mmm.qw.i.qw.ad("NetdiskService", action);
                if (!TextUtils.isEmpty(action) && fe.mmm.qw.i.qw.o()) {
                    throw new IllegalArgumentException(action + " unhandled");
                }
            }
        }
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        fe.mmm.qw.i.qw.ad("NetdiskService", "onStartCommand");
        return super.onStartCommand(intent, i2, i3);
    }
}
