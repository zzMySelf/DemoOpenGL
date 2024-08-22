package com.google.android.gms.common.api.internal;

import android.app.Activity;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;

public class zaad extends zak {
    public GoogleApiManager zabo;
    public final ArraySet<ApiKey<?>> zafs = new ArraySet<>();

    public zaad(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        this.mLifecycleFragment.addCallback("ConnectionlessLifecycleHelper", this);
    }

    public static void zaa(Activity activity, GoogleApiManager googleApiManager, ApiKey<?> apiKey) {
        LifecycleFragment fragment = LifecycleCallback.getFragment(activity);
        zaad zaad = (zaad) fragment.getCallbackOrNull("ConnectionlessLifecycleHelper", zaad.class);
        if (zaad == null) {
            zaad = new zaad(fragment);
        }
        zaad.zabo = googleApiManager;
        Preconditions.checkNotNull(apiKey, "ApiKey cannot be null");
        zaad.zafs.add(apiKey);
        googleApiManager.zaa(zaad);
    }

    private final void zaai() {
        if (!this.zafs.isEmpty()) {
            this.zabo.zaa(this);
        }
    }

    public void onResume() {
        super.onResume();
        zaai();
    }

    public void onStart() {
        super.onStart();
        zaai();
    }

    public void onStop() {
        super.onStop();
        this.zabo.zab(this);
    }

    public final ArraySet<ApiKey<?>> zaah() {
        return this.zafs;
    }

    public final void zam() {
        this.zabo.zam();
    }

    public final void zaa(ConnectionResult connectionResult, int i2) {
        this.zabo.zaa(connectionResult, i2);
    }
}
