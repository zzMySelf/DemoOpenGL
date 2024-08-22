package com.google.android.gms.internal.play_billing;

import com.baidu.sapi2.share.ShareCallPacking;

public final class zzt extends zzu {
    public final transient int zza;
    public final transient int zzb;
    public final /* synthetic */ zzu zzc;

    public zzt(zzu zzu, int i2, int i3) {
        this.zzc = zzu;
        this.zza = i2;
        this.zzb = i3;
    }

    public final Object get(int i2) {
        zzm.zza(i2, this.zzb, ShareCallPacking.StatModel.KEY_INDEX);
        return this.zzc.get(i2 + this.zza);
    }

    public final int size() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    public final boolean zzf() {
        return true;
    }

    public final Object[] zzg() {
        return this.zzc.zzg();
    }

    /* renamed from: zzh */
    public final zzu subList(int i2, int i3) {
        zzm.zzd(i2, i3, this.zzb);
        zzu zzu = this.zzc;
        int i4 = this.zza;
        return zzu.subList(i2 + i4, i3 + i4);
    }
}
