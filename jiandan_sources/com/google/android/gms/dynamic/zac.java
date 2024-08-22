package com.google.android.gms.dynamic;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;

public final class zac implements DeferredLifecycleHelper.zaa {
    public final /* synthetic */ Activity val$activity;
    public final /* synthetic */ DeferredLifecycleHelper zart;
    public final /* synthetic */ Bundle zary;
    public final /* synthetic */ Bundle zarz;

    public zac(DeferredLifecycleHelper deferredLifecycleHelper, Activity activity, Bundle bundle, Bundle bundle2) {
        this.zart = deferredLifecycleHelper;
        this.val$activity = activity;
        this.zarz = bundle;
        this.zary = bundle2;
    }

    public final int getState() {
        return 0;
    }

    public final void zaa(LifecycleDelegate lifecycleDelegate) {
        this.zart.zaru.onInflate(this.val$activity, this.zarz, this.zary);
    }
}
