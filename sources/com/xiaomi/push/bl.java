package com.xiaomi.push;

import kotlin.UByte;
import okio.Utf8;

public class bl {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6759a = System.getProperty("line.separator");

    /* renamed from: a  reason: collision with other field name */
    private static byte[] f180a = new byte[128];

    /* renamed from: a  reason: collision with other field name */
    private static char[] f181a = new char[64];

    static {
        char c2 = 'A';
        int i2 = 0;
        while (c2 <= 'Z') {
            f181a[i2] = c2;
            c2 = (char) (c2 + 1);
            i2++;
        }
        char c3 = 'a';
        while (c3 <= 'z') {
            f181a[i2] = c3;
            c3 = (char) (c3 + 1);
            i2++;
        }
        char c4 = '0';
        while (c4 <= '9') {
            f181a[i2] = c4;
            c4 = (char) (c4 + 1);
            i2++;
        }
        char[] cArr = f181a;
        cArr[i2] = '+';
        cArr[i2 + 1] = '/';
        int i3 = 0;
        while (true) {
            byte[] bArr = f180a;
            if (i3 >= bArr.length) {
                break;
            }
            bArr[i3] = -1;
            i3++;
        }
        for (int i4 = 0; i4 < 64; i4++) {
            f180a[f181a[i4]] = (byte) i4;
        }
    }

    public static String a(String str) {
        return new String(a(str.getBytes()));
    }

    public static char[] a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static char[] a(byte[] bArr, int i2, int i3) {
        int i4;
        byte b2;
        byte b3;
        int i5 = ((i3 * 4) + 2) / 3;
        char[] cArr = new char[(((i3 + 2) / 3) * 4)];
        int i6 = i3 + i2;
        int i7 = 0;
        while (i2 < i6) {
            int i8 = i2 + 1;
            byte b4 = bArr[i2] & UByte.MAX_VALUE;
            if (i8 < i6) {
                i4 = i8 + 1;
                b2 = bArr[i8] & UByte.MAX_VALUE;
            } else {
                i4 = i8;
                b2 = 0;
            }
            if (i4 < i6) {
                b3 = bArr[i4] & UByte.MAX_VALUE;
                i4++;
            } else {
                b3 = 0;
            }
            int i9 = b4 >>> 2;
            int i10 = ((b4 & 3) << 4) | (b2 >>> 4);
            int i11 = ((b2 & 15) << 2) | (b3 >>> 6);
            byte b5 = b3 & Utf8.REPLACEMENT_BYTE;
            int i12 = i7 + 1;
            char[] cArr2 = f181a;
            cArr[i7] = cArr2[i9];
            int i13 = i12 + 1;
            cArr[i12] = cArr2[i10];
            char c2 = '=';
            cArr[i13] = i13 < i5 ? cArr2[i11] : '=';
            int i14 = i13 + 1;
            if (i14 < i5) {
                c2 = cArr2[b5];
            }
            cArr[i14] = c2;
            i7 = i14 + 1;
            i2 = i4;
        }
        return cArr;
    }

    public static String b(String str) {
        return new String(a(str));
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m8325a(String str) {
        return a(str.toCharArray());
    }

    public static byte[] a(char[] cArr) {
        return a(cArr, 0, cArr.length);
    }

    public static byte[] a(char[] cArr, int i2, int i3) {
        int i4;
        char c2;
        char c3;
        int i5;
        if (i3 % 4 == 0) {
            while (i3 > 0 && cArr[(i2 + i3) - 1] == '=') {
                i3--;
            }
            int i6 = (i3 * 3) / 4;
            byte[] bArr = new byte[i6];
            int i7 = i3 + i2;
            int i8 = 0;
            while (i2 < i7) {
                int i9 = i2 + 1;
                char c4 = cArr[i2];
                int i10 = i9 + 1;
                char c5 = cArr[i9];
                if (i10 < i7) {
                    i4 = i10 + 1;
                    c2 = cArr[i10];
                } else {
                    i4 = i10;
                    c2 = 'A';
                }
                if (i4 < i7) {
                    i5 = i4 + 1;
                    c3 = cArr[i4];
                } else {
                    int i11 = i4;
                    c3 = 'A';
                    i5 = i11;
                }
                if (c4 > 127 || c5 > 127 || c2 > 127 || c3 > 127) {
                    throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
                }
                byte[] bArr2 = f180a;
                byte b2 = bArr2[c4];
                byte b3 = bArr2[c5];
                byte b4 = bArr2[c2];
                byte b5 = bArr2[c3];
                if (b2 < 0 || b3 < 0 || b4 < 0 || b5 < 0) {
                    throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
                }
                int i12 = (b2 << 2) | (b3 >>> 4);
                int i13 = ((b3 & 15) << 4) | (b4 >>> 2);
                byte b6 = ((b4 & 3) << 6) | b5;
                int i14 = i8 + 1;
                bArr[i8] = (byte) i12;
                if (i14 < i6) {
                    bArr[i14] = (byte) i13;
                    i14++;
                }
                if (i14 < i6) {
                    bArr[i14] = (byte) b6;
                    i8 = i14 + 1;
                } else {
                    i8 = i14;
                }
                i2 = i5;
            }
            return bArr;
        }
        throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
    }
}
