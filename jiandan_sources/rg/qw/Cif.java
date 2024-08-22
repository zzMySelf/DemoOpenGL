package rg.qw;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import dxm.sasdk.DxmSdkSensorsDataAPI;
import java.text.SimpleDateFormat;
import java.util.Locale;

@TargetApi(14)
/* renamed from: rg.qw.if  reason: invalid class name */
public class Cif implements Application.ActivityLifecycleCallbacks {

    /* renamed from: o  reason: collision with root package name */
    public static final SimpleDateFormat f10439o = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

    /* renamed from: ad  reason: collision with root package name */
    public Integer f10440ad = 0;

    /* renamed from: i  reason: collision with root package name */
    public final th f10441i;

    /* renamed from: th  reason: collision with root package name */
    public final Object f10442th = new Object();

    /* renamed from: uk  reason: collision with root package name */
    public final yj f10443uk;

    /* renamed from: yj  reason: collision with root package name */
    public final DxmSdkSensorsDataAPI f10444yj;

    public Cif(DxmSdkSensorsDataAPI dxmSdkSensorsDataAPI, yj yjVar, th thVar) {
        this.f10444yj = dxmSdkSensorsDataAPI;
        this.f10443uk = yjVar;
        this.f10441i = thVar;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        try {
            synchronized (this.f10442th) {
                if (this.f10440ad.intValue() == 0) {
                    if (this.f10441i.ad() == null) {
                        this.f10441i.qw(f10439o.format(Long.valueOf(System.currentTimeMillis())));
                    }
                    ((Boolean) this.f10443uk.ad()).booleanValue();
                    try {
                        this.f10444yj.i();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    this.f10444yj.f();
                }
                this.f10440ad = Integer.valueOf(this.f10440ad.intValue() + 1);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onActivityStopped(Activity activity) {
        try {
            synchronized (this.f10442th) {
                Integer valueOf = Integer.valueOf(this.f10440ad.intValue() - 1);
                this.f10440ad = valueOf;
                if (valueOf.intValue() == 0) {
                    try {
                        this.f10444yj.l();
                        this.f10444yj.o();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        this.f10444yj.ggg();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            return;
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }
}
