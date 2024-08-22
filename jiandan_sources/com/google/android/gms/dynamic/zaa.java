package com.google.android.gms.dynamic;

import android.os.Bundle;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import java.util.Iterator;

public final class zaa implements OnDelegateCreatedListener<T> {
    public final /* synthetic */ DeferredLifecycleHelper zart;

    public zaa(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.zart = deferredLifecycleHelper;
    }

    public final void onDelegateCreated(T t) {
        LifecycleDelegate unused = this.zart.zaru = t;
        Iterator it = this.zart.zarw.iterator();
        while (it.hasNext()) {
            ((DeferredLifecycleHelper.zaa) it.next()).zaa(this.zart.zaru);
        }
        this.zart.zarw.clear();
        Bundle unused2 = this.zart.zarv = null;
    }
}
