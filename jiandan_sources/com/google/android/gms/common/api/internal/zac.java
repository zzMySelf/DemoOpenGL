package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.util.PlatformVersion;

public abstract class zac {
    public final int type;

    public zac(int i2) {
        this.type = i2;
    }

    public static Status zaa(RemoteException remoteException) {
        StringBuilder sb = new StringBuilder();
        if (PlatformVersion.isAtLeastIceCreamSandwichMR1() && (remoteException instanceof TransactionTooLargeException)) {
            sb.append("TransactionTooLargeException: ");
        }
        sb.append(remoteException.getLocalizedMessage());
        return new Status(8, sb.toString());
    }

    public abstract void zaa(@NonNull Status status);

    public abstract void zaa(@NonNull zaz zaz, boolean z);

    public abstract void zaa(@NonNull RuntimeException runtimeException);

    public abstract void zac(GoogleApiManager.zaa<?> zaa) throws DeadObjectException;
}
