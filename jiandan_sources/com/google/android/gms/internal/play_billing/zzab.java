package com.google.android.gms.internal.play_billing;

import com.baidu.sapi2.share.ShareCallPacking;
import java.util.AbstractMap;

public final class zzab extends zzu {
    public final /* synthetic */ zzac zza;

    public zzab(zzac zzac) {
        this.zza = zzac;
    }

    public final /* bridge */ /* synthetic */ Object get(int i2) {
        zzm.zza(i2, this.zza.zzc, ShareCallPacking.StatModel.KEY_INDEX);
        zzac zzac = this.zza;
        int i3 = i2 + i2;
        Object obj = zzac.zzb[i3];
        obj.getClass();
        Object obj2 = zzac.zzb[i3 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    public final int size() {
        return this.zza.zzc;
    }

    public final boolean zzf() {
        return true;
    }
}
