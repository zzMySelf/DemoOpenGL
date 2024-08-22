package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.Status;

public final class zzi extends zzd {
    public final /* synthetic */ zzj zzce;

    public zzi(zzj zzj) {
        this.zzce = zzj;
    }

    public final void zzc(GoogleSignInAccount googleSignInAccount, Status status) throws RemoteException {
        if (googleSignInAccount != null) {
            zzo.zzd(this.zzce.val$context).zzc(this.zzce.zzcf, googleSignInAccount);
        }
        this.zzce.setResult(new GoogleSignInResult(googleSignInAccount, status));
    }
}
