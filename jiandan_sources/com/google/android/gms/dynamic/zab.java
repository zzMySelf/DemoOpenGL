package com.google.android.gms.dynamic;

import android.os.Bundle;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;

public final class zab implements DeferredLifecycleHelper.zaa {
    public final /* synthetic */ DeferredLifecycleHelper zart;
    public final /* synthetic */ Bundle zary;

    public zab(DeferredLifecycleHelper deferredLifecycleHelper, Bundle bundle) {
        this.zart = deferredLifecycleHelper;
        this.zary = bundle;
    }

    public final int getState() {
        return 1;
    }

    public final void zaa(LifecycleDelegate lifecycleDelegate) {
        this.zart.zaru.onCreate(this.zary);
    }
}
