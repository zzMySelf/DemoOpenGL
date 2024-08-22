package com.tera.scan.framework.kernel;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import fe.mmm.qw.j.rg;
import fe.mmm.qw.p030switch.th.qw;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class BaseApplication extends SkinBaseApplication {

    /* renamed from: ad  reason: collision with root package name */
    public static Class<? extends Service> f6945ad;
    @SuppressLint({"StaticFieldLeak"})
    public static Context mContext;

    /* renamed from: th  reason: collision with root package name */
    public static Class<? extends Service> f6946th;
    public SchedulerManager mSchedulerManager;

    public BaseApplication() {
        mContext = this;
    }

    public static Class<? extends Service> getAppBackgroundSchedulerService() {
        return f6946th;
    }

    public static Context getInstance() {
        return mContext;
    }

    public static Class<? extends Service> getSchedulerService() {
        return f6945ad;
    }

    public static void setAppBackgroundSchedulerService(Class<? extends Service> cls) {
        f6946th = cls;
    }

    public static void setSchedulerService(Class<? extends Service> cls) {
        f6945ad = cls;
    }

    public final void ad() {
        registerActivityLifecycleCallbacks(new qw());
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        fe.mmm.qw.de.ad.qw.qw.f7755yj = mContext.getPackageName();
        new fe.mmm.qw.ppp.qw().ad(this);
        ad();
        qw();
    }

    public SchedulerManager getSchedulerManager() {
        return this.mSchedulerManager;
    }

    public void initApp() {
        onAnyProcessInit();
    }

    public void initSchedulerManager(Class cls) {
        this.mSchedulerManager = new SchedulerManager(this, cls);
    }

    public abstract boolean isCurrentAppProcess();

    public abstract void onAnyProcessInit();

    public abstract void onAsyncDelayedInit();

    public abstract void onAsyncInit();

    public abstract void onAttachContext();

    public void onComponentAsyncDelayedInit() {
    }

    public void onComponentAsyncInit() {
    }

    public void onComponentAttachContext() {
    }

    public void onComponentDestroy() {
    }

    public void onComponentFirstActivityCreated() {
    }

    public void onComponentPostSyncInit() {
    }

    public void onComponentPreSyncInit() {
    }

    public void onCreate() {
        String str;
        fe.mmm.qw.i.qw.f7864uk = mContext.getPackageName();
        fe.mmm.qw.i.qw.ad("BaseApplication", "AppLaunch:Application Create Start");
        super.onCreate();
        rg.fe(this);
        fe.mmm.qw.de.ad.qw.qw.de(this);
        File qw = rg.qw();
        if (qw == null) {
            str = "";
        } else {
            str = qw.getAbsolutePath();
        }
        fe.mmm.qw.i.qw.ad("BaseApplication", " getExternalFilesDir = " + str);
    }

    public abstract void onFirstActivityCreated();

    public abstract void onSyncInit();

    public final void qw() {
        try {
            Class<?> cls = Class.forName("java.lang.Daemons$FinalizerWatchdogDaemon");
            Method declaredMethod = cls.getSuperclass().getDeclaredMethod("stop", new Class[0]);
            declaredMethod.setAccessible(true);
            Field declaredField = cls.getDeclaredField("INSTANCE");
            declaredField.setAccessible(true);
            declaredMethod.invoke(declaredField.get((Object) null), new Object[0]);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void selfCreateOperation() {
        super.selfCreateOperation();
        initApp();
    }
}
