package com.google.android.gms.internal.play_billing;

import com.baidu.sapi2.share.ShareCallPacking;

public final class zzae extends zzu {
    public final transient Object[] zza;
    public final transient int zzb;
    public final transient int zzc;

    public zzae(Object[] objArr, int i2, int i3) {
        this.zza = objArr;
        this.zzb = i2;
        this.zzc = i3;
    }

    public final Object get(int i2) {
        zzm.zza(i2, this.zzc, ShareCallPacking.StatModel.KEY_INDEX);
        Object obj = this.zza[i2 + i2 + this.zzb];
        obj.getClass();
        return obj;
    }

    public final int size() {
        return this.zzc;
    }

    public final boolean zzf() {
        return true;
    }
}
