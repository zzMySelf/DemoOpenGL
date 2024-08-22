package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.api.internal.GoogleApiManager;

public final class zad<A extends BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient>> extends zac {
    public final A zacp;

    public zad(int i2, A a) {
        super(i2);
        this.zacp = a;
    }

    public final void zaa(@NonNull Status status) {
        this.zacp.setFailedResult(status);
    }

    public final void zac(GoogleApiManager.zaa<?> zaa) throws DeadObjectException {
        try {
            this.zacp.run(zaa.zaad());
        } catch (RuntimeException e) {
            zaa(e);
        }
    }

    public final void zaa(@NonNull RuntimeException runtimeException) {
        String simpleName = runtimeException.getClass().getSimpleName();
        String localizedMessage = runtimeException.getLocalizedMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(simpleName).length() + 2 + String.valueOf(localizedMessage).length());
        sb.append(simpleName);
        sb.append(": ");
        sb.append(localizedMessage);
        this.zacp.setFailedResult(new Status(10, sb.toString()));
    }

    public final void zaa(@NonNull zaz zaz, boolean z) {
        zaz.zaa((BasePendingResult<? extends Result>) this.zacp, z);
    }
}
