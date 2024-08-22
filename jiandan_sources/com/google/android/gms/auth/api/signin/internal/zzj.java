package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public final class zzj extends zzp<GoogleSignInResult> {
    public final /* synthetic */ Context val$context;
    public final /* synthetic */ GoogleSignInOptions zzcf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzj(GoogleApiClient googleApiClient, Context context, GoogleSignInOptions googleSignInOptions) {
        super(googleApiClient);
        this.val$context = context;
        this.zzcf = googleSignInOptions;
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        return new GoogleSignInResult((GoogleSignInAccount) null, status);
    }

    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzv) ((zzh) anyClient).getService()).zzc(new zzi(this), this.zzcf);
    }
}
