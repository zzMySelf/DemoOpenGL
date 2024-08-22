package com.google.android.gms.internal.play_billing;

import com.google.common.collect.Hashing;

public final class zzq {
    public static int zza(int i2) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i2) * Hashing.C1), 15)) * Hashing.C2);
    }
}
