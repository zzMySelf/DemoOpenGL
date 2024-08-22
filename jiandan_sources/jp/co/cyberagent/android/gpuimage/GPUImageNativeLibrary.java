package jp.co.cyberagent.android.gpuimage;

import android.graphics.Bitmap;

public class GPUImageNativeLibrary {
    static {
        System.loadLibrary("yuv-decoder");
    }

    public static native void YUVtoARBG(byte[] bArr, int i2, int i3, int[] iArr);

    public static native void YUVtoRBGA(byte[] bArr, int i2, int i3, int[] iArr);

    public static native void adjustBitmap(Bitmap bitmap);
}
