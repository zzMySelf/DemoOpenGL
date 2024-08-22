package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;

public class HashAccumulator {
    @VisibleForTesting
    public static int zaam = 31;
    public int zaan = 1;

    @KeepForSdk
    public HashAccumulator addObject(Object obj) {
        this.zaan = (zaam * this.zaan) + (obj == null ? 0 : obj.hashCode());
        return this;
    }

    @KeepForSdk
    public int hash() {
        return this.zaan;
    }

    public final HashAccumulator zaa(boolean z) {
        this.zaan = (zaam * this.zaan) + (z ? 1 : 0);
        return this;
    }
}
