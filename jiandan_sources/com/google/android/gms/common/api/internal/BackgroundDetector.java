package com.google.android.gms.common.api.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

@KeepForSdk
public final class BackgroundDetector implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    public static final BackgroundDetector zzbe = new BackgroundDetector();
    public final AtomicBoolean zzbf = new AtomicBoolean();
    public final AtomicBoolean zzbg = new AtomicBoolean();
    public final ArrayList<BackgroundStateChangeListener> zzbh = new ArrayList<>();
    public boolean zzbi = false;

    @KeepForSdk
    public interface BackgroundStateChangeListener {
        @KeepForSdk
        void onBackgroundStateChanged(boolean z);
    }

    @KeepForSdk
    public static BackgroundDetector getInstance() {
        return zzbe;
    }

    @KeepForSdk
    public static void initialize(Application application) {
        synchronized (zzbe) {
            if (!zzbe.zzbi) {
                application.registerActivityLifecycleCallbacks(zzbe);
                application.registerComponentCallbacks(zzbe);
                zzbe.zzbi = true;
            }
        }
    }

    private final void onBackgroundStateChanged(boolean z) {
        synchronized (zzbe) {
            ArrayList<BackgroundStateChangeListener> arrayList = this.zzbh;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                BackgroundStateChangeListener backgroundStateChangeListener = arrayList.get(i2);
                i2++;
                backgroundStateChangeListener.onBackgroundStateChanged(z);
            }
        }
    }

    @KeepForSdk
    public final void addListener(BackgroundStateChangeListener backgroundStateChangeListener) {
        synchronized (zzbe) {
            this.zzbh.add(backgroundStateChangeListener);
        }
    }

    @KeepForSdk
    public final boolean isInBackground() {
        return this.zzbf.get();
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean compareAndSet = this.zzbf.compareAndSet(true, false);
        this.zzbg.set(true);
        if (compareAndSet) {
            onBackgroundStateChanged(false);
        }
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
        boolean compareAndSet = this.zzbf.compareAndSet(true, false);
        this.zzbg.set(true);
        if (compareAndSet) {
            onBackgroundStateChanged(false);
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onLowMemory() {
    }

    public final void onTrimMemory(int i2) {
        if (i2 == 20 && this.zzbf.compareAndSet(false, true)) {
            this.zzbg.set(true);
            onBackgroundStateChanged(true);
        }
    }

    @TargetApi(16)
    @KeepForSdk
    public final boolean readCurrentStateIfPossible(boolean z) {
        if (!this.zzbg.get()) {
            if (!PlatformVersion.isAtLeastJellyBean()) {
                return z;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.zzbg.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.zzbf.set(true);
            }
        }
        return isInBackground();
    }
}
