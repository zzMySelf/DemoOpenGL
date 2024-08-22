package com.baidu.mobstat.dxmpay;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.mobstat.dxmpay.ActivityLifeObserver;
import fe.fe.p007switch.qw.ad;

public class AutoTrack$MyActivityLifeCallback implements ActivityLifeObserver.IActivityLifeCallback {
    public int qw;

    public AutoTrack$MyActivityLifeCallback(int i2) {
        this.qw = i2;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        Context applicationContext = activity.getApplicationContext();
        int i2 = this.qw;
        if (i2 == 1) {
            ad.m207if().fe(applicationContext);
        } else if (i2 == 2) {
            ad.m207if().i(applicationContext);
        }
    }

    public void onActivityResumed(Activity activity) {
        Context applicationContext = activity.getApplicationContext();
        int i2 = this.qw;
        if (i2 == 1) {
            ad.m207if().rg(applicationContext);
        } else if (i2 == 2) {
            ad.m207if().uk();
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}
