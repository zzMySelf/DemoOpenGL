package com.terascan.algo;

public class DocumentEnhanceJNI {
    public native long nativeCreateAlgoAPI();

    public native long nativeCreateAlgoInstance(long j, byte[] bArr, long j2, String str, byte[] bArr2, long j3, String str2);

    public native byte[] nativeEnhance(long j, byte[] bArr, long j2, boolean z, boolean z2, int i2);

    public native void nativeReleaseAlgoInstance(long j);
}
