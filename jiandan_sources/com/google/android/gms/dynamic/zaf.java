package com.google.android.gms.dynamic;

import com.google.android.gms.dynamic.DeferredLifecycleHelper;

public final class zaf implements DeferredLifecycleHelper.zaa {
    public final /* synthetic */ DeferredLifecycleHelper zart;

    public zaf(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.zart = deferredLifecycleHelper;
    }

    public final int getState() {
        return 5;
    }

    public final void zaa(LifecycleDelegate lifecycleDelegate) {
        this.zart.zaru.onResume();
    }
}
