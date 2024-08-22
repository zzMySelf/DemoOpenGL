package com.google.android.gms.internal.play_billing;

import com.baidu.sapi2.share.ShareCallPacking;
import java.util.NoSuchElementException;

public abstract class zzo extends zzai {
    public final int zza;
    public int zzb;

    public zzo(int i2, int i3) {
        zzm.zzb(i3, i2, ShareCallPacking.StatModel.KEY_INDEX);
        this.zza = i2;
        this.zzb = i3;
    }

    public final boolean hasNext() {
        return this.zzb < this.zza;
    }

    public final boolean hasPrevious() {
        return this.zzb > 0;
    }

    public final Object next() {
        if (hasNext()) {
            int i2 = this.zzb;
            this.zzb = i2 + 1;
            return zza(i2);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.zzb;
    }

    public final Object previous() {
        if (hasPrevious()) {
            int i2 = this.zzb - 1;
            this.zzb = i2;
            return zza(i2);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.zzb - 1;
    }

    public abstract Object zza(int i2);
}
