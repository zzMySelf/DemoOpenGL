package com.alipay.sdk.m.l0;

public class c {
    public static byte[] a(int i2) {
        byte[] bArr = new byte[4];
        bArr[3] = (byte) (i2 % 256);
        int i3 = i2 >> 8;
        bArr[2] = (byte) (i3 % 256);
        int i4 = i3 >> 8;
        bArr[1] = (byte) (i4 % 256);
        bArr[0] = (byte) ((i4 >> 8) % 256);
        return bArr;
    }
}
