package com.google.android.gms.common;

import java.util.concurrent.Callable;

public final /* synthetic */ class zze implements Callable {
    public final boolean zzad;
    public final String zzae;
    public final zzd zzaf;

    public zze(boolean z, String str, zzd zzd) {
        this.zzad = z;
        this.zzae = str;
        this.zzaf = zzd;
    }

    public final Object call() {
        return zzc.zza(this.zzad, this.zzae, this.zzaf);
    }
}
