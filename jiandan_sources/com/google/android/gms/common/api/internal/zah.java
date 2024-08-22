package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zah extends zae<Boolean> {
    public final ListenerHolder.ListenerKey<?> zacv;

    public zah(ListenerHolder.ListenerKey<?> listenerKey, TaskCompletionSource<Boolean> taskCompletionSource) {
        super(4, taskCompletionSource);
        this.zacv = listenerKey;
    }

    public final /* bridge */ /* synthetic */ void zaa(@NonNull zaz zaz, boolean z) {
    }

    @Nullable
    public final Feature[] zaa(GoogleApiManager.zaa<?> zaa) {
        zabv zabv = zaa.zabi().get(this.zacv);
        if (zabv == null) {
            return null;
        }
        return zabv.zakc.getRequiredFeatures();
    }

    public final boolean zab(GoogleApiManager.zaa<?> zaa) {
        zabv zabv = zaa.zabi().get(this.zacv);
        return zabv != null && zabv.zakc.shouldAutoResolveMissingFeatures();
    }

    public final void zad(GoogleApiManager.zaa<?> zaa) throws RemoteException {
        zabv remove = zaa.zabi().remove(this.zacv);
        if (remove != null) {
            remove.zakd.unregisterListener(zaa.zaad(), this.zacq);
            remove.zakc.clearListener();
            return;
        }
        this.zacq.trySetResult(Boolean.FALSE);
    }

    public final /* bridge */ /* synthetic */ void zaa(@NonNull RuntimeException runtimeException) {
        super.zaa(runtimeException);
    }

    public final /* bridge */ /* synthetic */ void zaa(@NonNull Status status) {
        super.zaa(status);
    }
}
