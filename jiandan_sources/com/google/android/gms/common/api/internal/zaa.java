package com.google.android.gms.common.api.internal;

import android.app.Activity;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class zaa extends ActivityLifecycleObserver {
    public final WeakReference<C0186zaa> zaco;

    public zaa(Activity activity) {
        this(C0186zaa.zaa(activity));
    }

    public final ActivityLifecycleObserver onStopCallOnce(Runnable runnable) {
        C0186zaa zaa = (C0186zaa) this.zaco.get();
        if (zaa != null) {
            zaa.zaa(runnable);
            return this;
        }
        throw new IllegalStateException("The target activity has already been GC'd");
    }

    @VisibleForTesting(otherwise = 2)
    public zaa(C0186zaa zaa) {
        this.zaco = new WeakReference<>(zaa);
    }

    @VisibleForTesting(otherwise = 2)
    /* renamed from: com.google.android.gms.common.api.internal.zaa$zaa  reason: collision with other inner class name */
    public static class C0186zaa extends LifecycleCallback {
        public List<Runnable> zacn = new ArrayList();

        public C0186zaa(LifecycleFragment lifecycleFragment) {
            super(lifecycleFragment);
            this.mLifecycleFragment.addCallback("LifecycleObserverOnStop", this);
        }

        public static C0186zaa zaa(Activity activity) {
            C0186zaa zaa;
            synchronized (activity) {
                LifecycleFragment fragment = LifecycleCallback.getFragment(activity);
                zaa = (C0186zaa) fragment.getCallbackOrNull("LifecycleObserverOnStop", C0186zaa.class);
                if (zaa == null) {
                    zaa = new C0186zaa(fragment);
                }
            }
            return zaa;
        }

        @MainThread
        public void onStop() {
            List<Runnable> list;
            synchronized (this) {
                list = this.zacn;
                this.zacn = new ArrayList();
            }
            for (Runnable run : list) {
                run.run();
            }
        }

        /* access modifiers changed from: private */
        public final synchronized void zaa(Runnable runnable) {
            this.zacn.add(runnable);
        }
    }
}
