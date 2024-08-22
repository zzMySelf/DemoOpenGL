package com.google.android.gms.common.internal;

import androidx.renderscript.ScriptIntrinsicBLAS;

public final class zzh {
    public final String packageName;
    public final int zzek = ScriptIntrinsicBLAS.RsBlas_ctrmm;
    public final boolean zzel;
    public final String zzet;
    public final boolean zzeu;

    public zzh(String str, String str2, boolean z, int i2, boolean z2) {
        this.packageName = str;
        this.zzet = str2;
        this.zzeu = z;
        this.zzel = z2;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final boolean getUseDynamicLookup() {
        return this.zzel;
    }

    public final int zzq() {
        return this.zzek;
    }

    public final String zzt() {
        return this.zzet;
    }
}
