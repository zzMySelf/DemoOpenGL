package com.google.android.gms.internal.play_billing;

import java.util.Iterator;

public final class zzad extends zzy {
    public final transient zzx zza;
    public final transient zzu zzb;

    public zzad(zzx zzx, zzu zzu) {
        this.zza = zzx;
        this.zzb = zzu;
    }

    public final boolean contains(Object obj) {
        return this.zza.get(obj) != null;
    }

    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    public final int size() {
        return this.zza.size();
    }

    public final int zza(Object[] objArr, int i2) {
        return this.zzb.zza(objArr, 0);
    }

    public final zzu zzd() {
        return this.zzb;
    }

    public final zzah zze() {
        return this.zzb.listIterator(0);
    }

    public final boolean zzf() {
        throw null;
    }
}
