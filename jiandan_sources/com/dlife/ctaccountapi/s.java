package com.dlife.ctaccountapi;

import com.google.common.primitives.SignedBytes;
import java.nio.charset.Charset;

public class s {
    public static byte[] a = {68, SignedBytes.MAX_POWER_OF_TWO, 94, 49, 69, 35, 50, 83};

    static {
        Charset.forName("UTF-8");
    }

    public static String a(byte[] bArr) {
        try {
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                bArr2[i2] = bArr[i2];
                for (byte b : a) {
                    bArr2[i2] = (byte) (b ^ bArr2[i2]);
                }
            }
            return new String(bArr2);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "";
        }
    }
}
