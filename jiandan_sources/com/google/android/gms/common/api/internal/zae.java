package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class zae<T> extends zab {
    public final TaskCompletionSource<T> zacq;

    public zae(int i2, TaskCompletionSource<T> taskCompletionSource) {
        super(i2);
        this.zacq = taskCompletionSource;
    }

    public void zaa(@NonNull Status status) {
        this.zacq.trySetException(new ApiException(status));
    }

    public void zaa(@NonNull zaz zaz, boolean z) {
    }

    public final void zac(GoogleApiManager.zaa<?> zaa) throws DeadObjectException {
        try {
            zad(zaa);
        } catch (DeadObjectException e) {
            zaa(zac.zaa((RemoteException) e));
            throw e;
        } catch (RemoteException e2) {
            zaa(zac.zaa(e2));
        } catch (RuntimeException e3) {
            zaa(e3);
        }
    }

    public abstract void zad(GoogleApiManager.zaa<?> zaa) throws RemoteException;

    public void zaa(@NonNull RuntimeException runtimeException) {
        this.zacq.trySetException(runtimeException);
    }
}
