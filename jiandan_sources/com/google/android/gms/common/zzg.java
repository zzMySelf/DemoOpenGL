package com.google.android.gms.common;

import java.util.Arrays;

public final class zzg extends zzd {
    public final byte[] zzai;

    public zzg(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.zzai = bArr;
    }

    public final byte[] getBytes() {
        return this.zzai;
    }
}
