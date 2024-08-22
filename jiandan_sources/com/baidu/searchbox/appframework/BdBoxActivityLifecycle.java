package com.baidu.searchbox.appframework;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

public class BdBoxActivityLifecycle implements Application.ActivityLifecycleCallbacks {

    /* renamed from: i  reason: collision with root package name */
    public static boolean f1002i = false;

    /* renamed from: ad  reason: collision with root package name */
    public LinkedList<WeakReference<Activity>> f1003ad = new LinkedList<>();

    /* renamed from: th  reason: collision with root package name */
    public int f1004th;

    /* renamed from: uk  reason: collision with root package name */
    public CopyOnWriteArrayList<IActivityLifecycle> f1005uk = new CopyOnWriteArrayList<>();

    /* renamed from: yj  reason: collision with root package name */
    public boolean f1006yj = false;

    public interface IActivityLifecycle {
        void onActivityCreated(Activity activity, Bundle bundle);

        void onActivityDestroyed(Activity activity);

        void onActivityPaused(Activity activity);

        void onActivityResumed(Activity activity);

        void onActivitySaveInstanceState(Activity activity, Bundle bundle);

        void onActivityStarted(Activity activity);

        void onActivityStopped(Activity activity);

        void onBackgroundToForeground(Activity activity);

        void onForegroundToBackground(Activity activity);
    }

    public void ad(Activity activity) {
        this.f1006yj = true;
        CopyOnWriteArrayList<IActivityLifecycle> copyOnWriteArrayList = this.f1005uk;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<IActivityLifecycle> it = this.f1005uk.iterator();
            while (it.hasNext()) {
                it.next().onBackgroundToForeground(activity);
            }
        }
    }

    public void de(Activity activity) {
        this.f1006yj = false;
        CopyOnWriteArrayList<IActivityLifecycle> copyOnWriteArrayList = this.f1005uk;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<IActivityLifecycle> it = this.f1005uk.iterator();
            while (it.hasNext()) {
                it.next().onForegroundToBackground(activity);
            }
        }
    }

    public void fe(IActivityLifecycle iActivityLifecycle) {
        if (iActivityLifecycle != null && !this.f1005uk.contains(iActivityLifecycle)) {
            f1002i = true;
            this.f1005uk.add(iActivityLifecycle);
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        this.f1003ad.add(new WeakReference(activity));
        CopyOnWriteArrayList<IActivityLifecycle> copyOnWriteArrayList = this.f1005uk;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<IActivityLifecycle> it = this.f1005uk.iterator();
            while (it.hasNext()) {
                it.next().onActivityCreated(activity, bundle);
            }
        }
    }

    public void onActivityDestroyed(Activity activity) {
        if (!this.f1003ad.isEmpty()) {
            int size = this.f1003ad.size();
            while (true) {
                size--;
                if (size < 0) {
                    size = -1;
                    break;
                }
                Activity activity2 = (Activity) this.f1003ad.get(size).get();
                if (activity2 != null && activity2 == activity) {
                    break;
                }
            }
            if (size != -1) {
                this.f1003ad.remove(size);
            }
        }
        CopyOnWriteArrayList<IActivityLifecycle> copyOnWriteArrayList = this.f1005uk;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<IActivityLifecycle> it = this.f1005uk.iterator();
            while (it.hasNext()) {
                it.next().onActivityDestroyed(activity);
            }
        }
    }

    public void onActivityPaused(Activity activity) {
        CopyOnWriteArrayList<IActivityLifecycle> copyOnWriteArrayList = this.f1005uk;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<IActivityLifecycle> it = this.f1005uk.iterator();
            while (it.hasNext()) {
                it.next().onActivityPaused(activity);
            }
        }
    }

    public void onActivityResumed(Activity activity) {
        CopyOnWriteArrayList<IActivityLifecycle> copyOnWriteArrayList = this.f1005uk;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<IActivityLifecycle> it = this.f1005uk.iterator();
            while (it.hasNext()) {
                it.next().onActivityResumed(activity);
            }
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        CopyOnWriteArrayList<IActivityLifecycle> copyOnWriteArrayList = this.f1005uk;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<IActivityLifecycle> it = this.f1005uk.iterator();
            while (it.hasNext()) {
                it.next().onActivitySaveInstanceState(activity, bundle);
            }
        }
    }

    public void onActivityStarted(Activity activity) {
        CopyOnWriteArrayList<IActivityLifecycle> copyOnWriteArrayList = this.f1005uk;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<IActivityLifecycle> it = this.f1005uk.iterator();
            while (it.hasNext()) {
                it.next().onActivityStarted(activity);
            }
        }
        int i2 = this.f1004th + 1;
        this.f1004th = i2;
        if (i2 == 1) {
            ad(activity);
        }
    }

    public void onActivityStopped(Activity activity) {
        CopyOnWriteArrayList<IActivityLifecycle> copyOnWriteArrayList = this.f1005uk;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<IActivityLifecycle> it = this.f1005uk.iterator();
            while (it.hasNext()) {
                it.next().onActivityStopped(activity);
            }
        }
        int i2 = this.f1004th - 1;
        this.f1004th = i2;
        if (i2 == 0) {
            de(activity);
        }
    }

    public boolean qw() {
        return this.f1006yj;
    }

    public void rg(IActivityLifecycle iActivityLifecycle) {
        if (iActivityLifecycle != null && !this.f1005uk.contains(iActivityLifecycle)) {
            if (!f1002i || this.f1005uk.size() <= 0) {
                this.f1005uk.add(iActivityLifecycle);
                return;
            }
            CopyOnWriteArrayList<IActivityLifecycle> copyOnWriteArrayList = this.f1005uk;
            copyOnWriteArrayList.add(copyOnWriteArrayList.size() - 1, iActivityLifecycle);
        }
    }
}
