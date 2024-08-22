package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
public class LifecycleActivity {
    public final Object zzbp;

    public LifecycleActivity(Activity activity) {
        Preconditions.checkNotNull(activity, "Activity must not be null");
        this.zzbp = activity;
    }

    @KeepForSdk
    public Activity asActivity() {
        return (Activity) this.zzbp;
    }

    @KeepForSdk
    public FragmentActivity asFragmentActivity() {
        return (FragmentActivity) this.zzbp;
    }

    @KeepForSdk
    public Object asObject() {
        return this.zzbp;
    }

    @KeepForSdk
    public boolean isChimera() {
        return false;
    }

    @KeepForSdk
    public boolean isSupport() {
        return this.zzbp instanceof FragmentActivity;
    }

    public final boolean zzh() {
        return this.zzbp instanceof Activity;
    }

    @KeepForSdk
    public LifecycleActivity(ContextWrapper contextWrapper) {
        throw new UnsupportedOperationException();
    }
}
