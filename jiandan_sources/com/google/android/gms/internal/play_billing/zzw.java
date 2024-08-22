package com.google.android.gms.internal.play_billing;

import java.util.Arrays;

public final class zzw {
    public Object[] zza = new Object[8];
    public int zzb = 0;
    public zzv zzc;

    public final zzw zza(Object obj, Object obj2) {
        int i2 = this.zzb + 1;
        int i3 = i2 + i2;
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (i3 > length) {
            int i4 = length + (length >> 1) + 1;
            if (i4 < i3) {
                int highestOneBit = Integer.highestOneBit(i3 - 1);
                i4 = highestOneBit + highestOneBit;
            }
            if (i4 < 0) {
                i4 = Integer.MAX_VALUE;
            }
            this.zza = Arrays.copyOf(objArr, i4);
        }
        zzp.zza(obj, obj2);
        Object[] objArr2 = this.zza;
        int i5 = this.zzb;
        int i6 = i5 + i5;
        objArr2[i6] = obj;
        objArr2[i6 + 1] = obj2;
        this.zzb = i5 + 1;
        return this;
    }

    public final zzx zzb() {
        zzv zzv = this.zzc;
        if (zzv == null) {
            zzaf zzf = zzaf.zzf(this.zzb, this.zza, this);
            zzv zzv2 = this.zzc;
            if (zzv2 == null) {
                return zzf;
            }
            throw zzv2.zza();
        }
        throw zzv.zza();
    }
}
