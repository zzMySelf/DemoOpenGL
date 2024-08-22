package com.google.android.gms.common.internal.service;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

public final class zag extends zaa {
    public final BaseImplementation.ResultHolder<Status> mResultHolder;

    public zag(BaseImplementation.ResultHolder<Status> resultHolder) {
        this.mResultHolder = resultHolder;
    }

    public final void zaj(int i2) throws RemoteException {
        this.mResultHolder.setResult(new Status(i2));
    }
}
