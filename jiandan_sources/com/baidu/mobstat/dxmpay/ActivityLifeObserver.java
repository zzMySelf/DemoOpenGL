package com.baidu.mobstat.dxmpay;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import java.util.LinkedHashSet;
import java.util.Set;

public class ActivityLifeObserver {

    /* renamed from: de  reason: collision with root package name */
    public static final ActivityLifeObserver f879de = new ActivityLifeObserver();

    /* renamed from: ad  reason: collision with root package name */
    public Set<IActivityLifeCallback> f880ad = new LinkedHashSet();
    public boolean qw;

    public interface IActivityLifeCallback {
        void onActivityCreated(Activity activity, Bundle bundle);

        void onActivityDestroyed(Activity activity);

        void onActivityPaused(Activity activity);

        void onActivityResumed(Activity activity);

        void onActivitySaveInstanceState(Activity activity, Bundle bundle);

        void onActivityStarted(Activity activity);

        void onActivityStopped(Activity activity);
    }

    public class qw implements Application.ActivityLifecycleCallbacks {
        public qw() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            synchronized (ActivityLifeObserver.this.f880ad) {
                for (IActivityLifeCallback onActivityCreated : ActivityLifeObserver.this.f880ad) {
                    onActivityCreated.onActivityCreated(activity, bundle);
                }
            }
        }

        public void onActivityDestroyed(Activity activity) {
            synchronized (ActivityLifeObserver.this.f880ad) {
                for (IActivityLifeCallback onActivityDestroyed : ActivityLifeObserver.this.f880ad) {
                    onActivityDestroyed.onActivityDestroyed(activity);
                }
            }
        }

        public void onActivityPaused(Activity activity) {
            synchronized (ActivityLifeObserver.this.f880ad) {
                for (IActivityLifeCallback onActivityPaused : ActivityLifeObserver.this.f880ad) {
                    onActivityPaused.onActivityPaused(activity);
                }
            }
        }

        public void onActivityResumed(Activity activity) {
            synchronized (ActivityLifeObserver.this.f880ad) {
                for (IActivityLifeCallback onActivityResumed : ActivityLifeObserver.this.f880ad) {
                    onActivityResumed.onActivityResumed(activity);
                }
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            synchronized (ActivityLifeObserver.this.f880ad) {
                for (IActivityLifeCallback onActivitySaveInstanceState : ActivityLifeObserver.this.f880ad) {
                    onActivitySaveInstanceState.onActivitySaveInstanceState(activity, bundle);
                }
            }
        }

        public void onActivityStarted(Activity activity) {
            synchronized (ActivityLifeObserver.this.f880ad) {
                for (IActivityLifeCallback onActivityStarted : ActivityLifeObserver.this.f880ad) {
                    onActivityStarted.onActivityStarted(activity);
                }
            }
        }

        public void onActivityStopped(Activity activity) {
            synchronized (ActivityLifeObserver.this.f880ad) {
                for (IActivityLifeCallback onActivityStopped : ActivityLifeObserver.this.f880ad) {
                    onActivityStopped.onActivityStopped(activity);
                }
            }
        }
    }

    public static ActivityLifeObserver rg() {
        return f879de;
    }

    public void ad(IActivityLifeCallback iActivityLifeCallback) {
        synchronized (this.f880ad) {
            this.f880ad.add(iActivityLifeCallback);
        }
    }

    public void de() {
        synchronized (this.f880ad) {
            this.f880ad.clear();
        }
    }

    @TargetApi(14)
    public void fe(Context context) {
        try {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new qw());
        } catch (Exception unused) {
            h.o().de("registerActivityLifecycleCallbacks encounter exception");
        }
    }

    public void th(Context context) {
        if (!this.qw && Build.VERSION.SDK_INT >= 14) {
            fe(context);
            this.qw = true;
        }
    }
}
