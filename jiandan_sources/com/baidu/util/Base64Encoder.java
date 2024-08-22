package com.baidu.util;

public class Base64Encoder {
    static {
        try {
            System.loadLibrary("base64encoder_v2_0");
        } catch (Error | Exception unused) {
        }
    }

    public static final int ad() {
        try {
            return nativeB64GetVersion();
        } catch (Error | Exception unused) {
            return 0;
        }
    }

    public static final byte[] de(byte[] bArr) {
        try {
            return nativeB64Encode(bArr, 0);
        } catch (Error | Exception unused) {
            return bArr;
        }
    }

    public static final native byte[] nativeB64Decode(byte[] bArr, int i2);

    public static final native byte[] nativeB64Encode(byte[] bArr, int i2);

    public static final native int nativeB64GetVersion();

    public static final byte[] qw(byte[] bArr) {
        try {
            return nativeB64Encode(bArr, 0);
        } catch (Error | Exception unused) {
            return bArr;
        }
    }
}
