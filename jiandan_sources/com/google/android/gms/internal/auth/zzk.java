package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.common.api.Status;

public final class zzk extends zzn {
    public final /* synthetic */ zzj zzaf;

    public zzk(zzj zzj) {
        this.zzaf = zzj;
    }

    public final void zzc(Account account) {
        this.zzaf.setResult(new zzo(account != null ? Status.RESULT_SUCCESS : zzh.zzad, account));
    }
}
