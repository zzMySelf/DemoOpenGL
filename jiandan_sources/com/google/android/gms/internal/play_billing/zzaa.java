package com.google.android.gms.internal.play_billing;

import com.baidu.sapi2.share.ShareCallPacking;

public final class zzaa extends zzu {
    public static final zzu zza = new zzaa(new Object[0], 0);
    public final transient Object[] zzb;
    public final transient int zzc;

    public zzaa(Object[] objArr, int i2) {
        this.zzb = objArr;
        this.zzc = i2;
    }

    public final Object get(int i2) {
        zzm.zza(i2, this.zzc, ShareCallPacking.StatModel.KEY_INDEX);
        Object obj = this.zzb[i2];
        obj.getClass();
        return obj;
    }

    public final int size() {
        return this.zzc;
    }

    public final int zza(Object[] objArr, int i2) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    public final int zzb() {
        return this.zzc;
    }

    public final int zzc() {
        return 0;
    }

    public final boolean zzf() {
        return false;
    }

    public final Object[] zzg() {
        return this.zzb;
    }
}
