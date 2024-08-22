package com.alipay.sdk.m.g;

import android.util.Base64;
import com.google.common.base.Ascii;
import java.security.SecureRandom;
import java.util.Arrays;

public class c {
    public static volatile SecureRandom a;
    public static final char[] b = "0123456789ABCDEF".toCharArray();

    public static SecureRandom a() {
        if (a != null) {
            return a;
        }
        synchronized (c.class) {
            if (a == null) {
                a = new SecureRandom();
            }
        }
        return a;
    }

    public static byte[] a(byte b2) {
        return new byte[]{b2};
    }

    public static byte[] a(char c) {
        return new byte[]{(byte) (c & 255)};
    }

    public static byte[] a(char c, char c2) {
        return new byte[]{(byte) (c & 255), (byte) (c2 & 255)};
    }

    public static byte[] a(int i2) {
        return new byte[]{(byte) i2, (byte) (i2 >> 8), (byte) (i2 >> 16), (byte) (i2 >> 24)};
    }

    public static byte[] a(long j) {
        return new byte[]{(byte) ((int) j), (byte) ((int) (j >> 8)), (byte) ((int) (j >> 16)), (byte) ((int) (j >> 24)), (byte) ((int) (j >> 32)), (byte) ((int) (j >> 40)), (byte) ((int) (j >> 48)), (byte) ((int) (j >> 56))};
    }

    public static byte[] a(short s) {
        return new byte[]{(byte) s, (byte) (s >> 8)};
    }

    public static byte[] b() {
        byte[] bArr = new byte[2];
        a().nextBytes(bArr);
        return bArr;
    }

    public static byte[] c() {
        byte[] bArr = new byte[4];
        a().nextBytes(bArr);
        return bArr;
    }

    public static String b(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b2 = bArr[i2] & 255;
            int i3 = i2 * 2;
            char[] cArr2 = b;
            cArr[i3] = cArr2[b2 >>> 4];
            cArr[i3 + 1] = cArr2[b2 & Ascii.SI];
        }
        return new String(cArr);
    }

    public static byte[] a(byte[]... bArr) {
        int i2 = 0;
        for (byte[] length : bArr) {
            i2 += length.length;
        }
        byte[] bArr2 = null;
        int i3 = 0;
        for (byte[] bArr3 : bArr) {
            if (bArr2 == null) {
                bArr2 = Arrays.copyOf(bArr3, i2);
                i3 = bArr3.length;
            } else {
                System.arraycopy(bArr3, 0, bArr2, i3, bArr3.length);
                i3 += bArr3.length;
            }
        }
        return bArr2;
    }

    public static String a(byte[] bArr) {
        return Base64.encodeToString(bArr, 3);
    }
}
