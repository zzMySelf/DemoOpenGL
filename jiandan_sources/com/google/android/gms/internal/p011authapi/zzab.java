package com.google.android.gms.internal.p011authapi;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.BeginSignInResult;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.auth-api.zzab  reason: invalid package */
public interface zzab extends IInterface {
    void zzc(Status status, BeginSignInResult beginSignInResult) throws RemoteException;
}
