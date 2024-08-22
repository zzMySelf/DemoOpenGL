package com.google.android.gms.common;

import java.lang.ref.WeakReference;

public abstract class zzf extends zzd {
    public static final WeakReference<byte[]> zzah = new WeakReference<>((Object) null);
    public WeakReference<byte[]> zzag = zzah;

    public zzf(byte[] bArr) {
        super(bArr);
    }

    public final byte[] getBytes() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.zzag.get();
            if (bArr == null) {
                bArr = zzd();
                this.zzag = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }

    public abstract byte[] zzd();
}
