package com.baidu.wallet.base.camera.internal;

public interface c {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 4;
    public static final int d = 8;

    void destroyCamera();

    boolean initCamera(int i2, int i3, int i4, int i5);

    void processImage(byte[] bArr);
}
