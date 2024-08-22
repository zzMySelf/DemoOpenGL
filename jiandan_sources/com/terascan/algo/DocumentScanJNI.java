package com.terascan.algo;

import java.util.ArrayList;

public class DocumentScanJNI {
    public native long nativeCreateAlgoInstance(byte[] bArr, long j, byte[] bArr2, long j2, String str);

    public native byte[] nativeRectify(long j, byte[] bArr, long j2, ArrayList<Point> arrayList, int i2, int i3, int i4, int i5, boolean z);

    public native void nativeReleaseAlgoInstance(long j);

    public native DocumentResult nativeScan(long j, byte[] bArr, long j2, int i2, int i3, boolean z);
}
