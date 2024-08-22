package com.google.android.gms.internal.play_billing;

import java.util.Set;

public abstract class zzy extends zzr implements Set {
    public transient zzu zza;

    public final boolean equals(Object obj) {
        if (obj == this || obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() != set.size() || !containsAll(set)) {
                    return false;
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public final int hashCode() {
        return zzag.zza(this);
    }

    public zzu zzd() {
        zzu zzu = this.zza;
        if (zzu != null) {
            return zzu;
        }
        zzu zzh = zzh();
        this.zza = zzh;
        return zzh;
    }

    /* renamed from: zze */
    public abstract zzah iterator();

    public zzu zzh() {
        return zzu.zzi(toArray());
    }
}
