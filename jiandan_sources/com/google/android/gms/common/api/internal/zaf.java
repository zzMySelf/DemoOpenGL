package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zaf<ResultT> extends zab {
    public final TaskCompletionSource<ResultT> zacq;
    public final TaskApiCall<Api.AnyClient, ResultT> zacr;
    public final StatusExceptionMapper zacs;

    public zaf(int i2, TaskApiCall<Api.AnyClient, ResultT> taskApiCall, TaskCompletionSource<ResultT> taskCompletionSource, StatusExceptionMapper statusExceptionMapper) {
        super(i2);
        this.zacq = taskCompletionSource;
        this.zacr = taskApiCall;
        this.zacs = statusExceptionMapper;
    }

    public final void zaa(@NonNull Status status) {
        this.zacq.trySetException(this.zacs.getException(status));
    }

    public final boolean zab(GoogleApiManager.zaa<?> zaa) {
        return this.zacr.shouldAutoResolveMissingFeatures();
    }

    public final void zac(GoogleApiManager.zaa<?> zaa) throws DeadObjectException {
        try {
            this.zacr.doExecute(zaa.zaad(), this.zacq);
        } catch (DeadObjectException e) {
            throw e;
        } catch (RemoteException e2) {
            zaa(zac.zaa(e2));
        } catch (RuntimeException e3) {
            zaa(e3);
        }
    }

    public final void zaa(@NonNull RuntimeException runtimeException) {
        this.zacq.trySetException(runtimeException);
    }

    public final void zaa(@NonNull zaz zaz, boolean z) {
        zaz.zaa(this.zacq, z);
    }

    @Nullable
    public final Feature[] zaa(GoogleApiManager.zaa<?> zaa) {
        return this.zacr.zabr();
    }
}
