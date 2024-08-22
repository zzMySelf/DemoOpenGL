package com.google.android.gms.internal.p011authapi;

import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.auth-api.zzg  reason: invalid package */
public final class zzg implements CredentialRequestResult {
    public final Status mStatus;
    @Nullable
    public final Credential zzam;

    public zzg(Status status, @Nullable Credential credential) {
        this.mStatus = status;
        this.zzam = credential;
    }

    public static zzg zzc(Status status) {
        return new zzg(status, (Credential) null);
    }

    @Nullable
    public final Credential getCredential() {
        return this.zzam;
    }

    public final Status getStatus() {
        return this.mStatus;
    }
}
