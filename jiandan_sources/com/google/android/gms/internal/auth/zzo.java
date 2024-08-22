package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.auth.account.WorkAccountApi;
import com.google.android.gms.common.api.Status;

public final class zzo implements WorkAccountApi.AddAccountResult {
    public final Status mStatus;
    public final Account zzk;

    public zzo(Status status, Account account) {
        this.mStatus = status;
        this.zzk = account;
    }

    public final Account getAccount() {
        return this.zzk;
    }

    public final Status getStatus() {
        return this.mStatus;
    }
}
