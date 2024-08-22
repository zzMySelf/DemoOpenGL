package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
import java.util.Map;

public final class zzac extends zzy {
    public final transient zzx zza;
    public final transient Object[] zzb;
    public final transient int zzc;

    public zzac(zzx zzx, Object[] objArr, int i2, int i3) {
        this.zza = zzx;
        this.zzb = objArr;
        this.zzc = i3;
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals(this.zza.get(key))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final /* synthetic */ Iterator iterator() {
        return zzd().listIterator(0);
    }

    public final int size() {
        return this.zzc;
    }

    public final int zza(Object[] objArr, int i2) {
        return zzd().zza(objArr, 0);
    }

    public final zzah zze() {
        return zzd().listIterator(0);
    }

    public final boolean zzf() {
        throw null;
    }

    public final zzu zzh() {
        return new zzab(this);
    }
}
