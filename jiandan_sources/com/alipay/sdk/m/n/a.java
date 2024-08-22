package com.alipay.sdk.m.n;

import com.baidu.idl.authority.AuthorityState;
import com.google.common.base.Ascii;

public final class a {
    public static final int a = 128;
    public static final int b = 64;
    public static final int c = 24;
    public static final int d = 8;
    public static final int e = 16;
    public static final int f = 4;
    public static final int g = -128;
    public static final char h = '=';

    /* renamed from: i  reason: collision with root package name */
    public static final byte[] f671i = new byte[128];
    public static final char[] j = new char[64];

    static {
        int i2;
        int i3;
        int i4 = 0;
        for (int i5 = 0; i5 < 128; i5++) {
            f671i[i5] = -1;
        }
        for (int i6 = 90; i6 >= 65; i6--) {
            f671i[i6] = (byte) (i6 - 65);
        }
        int i7 = 122;
        while (true) {
            i2 = 26;
            if (i7 < 97) {
                break;
            }
            f671i[i7] = (byte) ((i7 - 97) + 26);
            i7--;
        }
        int i8 = 57;
        while (true) {
            i3 = 52;
            if (i8 < 48) {
                break;
            }
            f671i[i8] = (byte) ((i8 - 48) + 52);
            i8--;
        }
        byte[] bArr = f671i;
        bArr[43] = 62;
        bArr[47] = 63;
        for (int i9 = 0; i9 <= 25; i9++) {
            j[i9] = (char) (i9 + 65);
        }
        int i10 = 0;
        while (i2 <= 51) {
            j[i2] = (char) (i10 + 97);
            i2++;
            i10++;
        }
        while (i3 <= 61) {
            j[i3] = (char) (i4 + 48);
            i3++;
            i4++;
        }
        char[] cArr = j;
        cArr[62] = '+';
        cArr[63] = '/';
    }

    public static boolean a(char c2) {
        return c2 < 128 && f671i[c2] != -1;
    }

    public static boolean b(char c2) {
        return c2 == '=';
    }

    public static boolean c(char c2) {
        return c2 == ' ' || c2 == 13 || c2 == 10 || c2 == 9;
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length * 8;
        if (length == 0) {
            return "";
        }
        int i2 = length % 24;
        int i3 = length / 24;
        char[] cArr = new char[((i2 != 0 ? i3 + 1 : i3) * 4)];
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < i3) {
            int i7 = i5 + 1;
            byte b2 = bArr[i5];
            int i8 = i7 + 1;
            byte b3 = bArr[i7];
            int i9 = i8 + 1;
            byte b4 = bArr[i8];
            byte b5 = (byte) (b3 & Ascii.SI);
            byte b6 = (byte) (b2 & 3);
            byte b7 = b2 & Byte.MIN_VALUE;
            int i10 = b2 >> 2;
            if (b7 != 0) {
                i10 ^= 192;
            }
            byte b8 = (byte) i10;
            byte b9 = b3 & Byte.MIN_VALUE;
            int i11 = b3 >> 4;
            if (b9 != 0) {
                i11 ^= AuthorityState.STATE_ERROR_NETWORK;
            }
            byte b10 = (byte) i11;
            int i12 = (b4 & Byte.MIN_VALUE) == 0 ? b4 >> 6 : (b4 >> 6) ^ 252;
            int i13 = i6 + 1;
            char[] cArr2 = j;
            cArr[i6] = cArr2[b8];
            int i14 = i13 + 1;
            cArr[i13] = cArr2[(b6 << 4) | b10];
            int i15 = i14 + 1;
            cArr[i14] = cArr2[(b5 << 2) | ((byte) i12)];
            cArr[i15] = cArr2[b4 & 63];
            i4++;
            i6 = i15 + 1;
            i5 = i9;
        }
        if (i2 == 8) {
            byte b11 = bArr[i5];
            byte b12 = (byte) (b11 & 3);
            byte b13 = b11 & Byte.MIN_VALUE;
            int i16 = b11 >> 2;
            if (b13 != 0) {
                i16 ^= 192;
            }
            int i17 = i6 + 1;
            char[] cArr3 = j;
            cArr[i6] = cArr3[(byte) i16];
            int i18 = i17 + 1;
            cArr[i17] = cArr3[b12 << 4];
            cArr[i18] = h;
            cArr[i18 + 1] = h;
        } else if (i2 == 16) {
            byte b14 = bArr[i5];
            byte b15 = bArr[i5 + 1];
            byte b16 = (byte) (b15 & Ascii.SI);
            byte b17 = (byte) (b14 & 3);
            byte b18 = b14 & Byte.MIN_VALUE;
            int i19 = b14 >> 2;
            if (b18 != 0) {
                i19 ^= 192;
            }
            byte b19 = (byte) i19;
            byte b20 = b15 & Byte.MIN_VALUE;
            int i20 = b15 >> 4;
            if (b20 != 0) {
                i20 ^= AuthorityState.STATE_ERROR_NETWORK;
            }
            int i21 = i6 + 1;
            char[] cArr4 = j;
            cArr[i6] = cArr4[b19];
            int i22 = i21 + 1;
            cArr[i21] = cArr4[((byte) i20) | (b17 << 4)];
            cArr[i22] = cArr4[b16 << 2];
            cArr[i22 + 1] = h;
        }
        return new String(cArr);
    }

    public static byte[] a(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int a2 = a(charArray);
        if (a2 % 4 != 0) {
            return null;
        }
        int i2 = a2 / 4;
        if (i2 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[(i2 * 3)];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < i2 - 1) {
            int i6 = i4 + 1;
            char c2 = charArray[i4];
            if (a(c2)) {
                int i7 = i6 + 1;
                char c3 = charArray[i6];
                if (a(c3)) {
                    int i8 = i7 + 1;
                    char c4 = charArray[i7];
                    if (a(c4)) {
                        int i9 = i8 + 1;
                        char c5 = charArray[i8];
                        if (a(c5)) {
                            byte[] bArr2 = f671i;
                            byte b2 = bArr2[c2];
                            byte b3 = bArr2[c3];
                            byte b4 = bArr2[c4];
                            byte b5 = bArr2[c5];
                            int i10 = i5 + 1;
                            bArr[i5] = (byte) ((b2 << 2) | (b3 >> 4));
                            int i11 = i10 + 1;
                            bArr[i10] = (byte) (((b3 & Ascii.SI) << 4) | ((b4 >> 2) & 15));
                            i5 = i11 + 1;
                            bArr[i11] = (byte) ((b4 << 6) | b5);
                            i3++;
                            i4 = i9;
                        }
                    }
                }
            }
            return null;
        }
        int i12 = i4 + 1;
        char c6 = charArray[i4];
        if (!a(c6)) {
            return null;
        }
        int i13 = i12 + 1;
        char c7 = charArray[i12];
        if (!a(c7)) {
            return null;
        }
        byte[] bArr3 = f671i;
        byte b6 = bArr3[c6];
        byte b7 = bArr3[c7];
        int i14 = i13 + 1;
        char c8 = charArray[i13];
        char c9 = charArray[i14];
        if (a(c8) && a(c9)) {
            byte[] bArr4 = f671i;
            byte b8 = bArr4[c8];
            byte b9 = bArr4[c9];
            int i15 = i5 + 1;
            bArr[i5] = (byte) ((b6 << 2) | (b7 >> 4));
            bArr[i15] = (byte) (((b7 & Ascii.SI) << 4) | ((b8 >> 2) & 15));
            bArr[i15 + 1] = (byte) (b9 | (b8 << 6));
            return bArr;
        } else if (!b(c8) || !b(c9)) {
            if (b(c8) || !b(c9)) {
                return null;
            }
            byte b10 = f671i[c8];
            if ((b10 & 3) != 0) {
                return null;
            }
            int i16 = i3 * 3;
            byte[] bArr5 = new byte[(i16 + 2)];
            System.arraycopy(bArr, 0, bArr5, 0, i16);
            bArr5[i5] = (byte) ((b6 << 2) | (b7 >> 4));
            bArr5[i5 + 1] = (byte) (((b10 >> 2) & 15) | ((b7 & Ascii.SI) << 4));
            return bArr5;
        } else if ((b7 & Ascii.SI) != 0) {
            return null;
        } else {
            int i17 = i3 * 3;
            byte[] bArr6 = new byte[(i17 + 1)];
            System.arraycopy(bArr, 0, bArr6, 0, i17);
            bArr6[i5] = (byte) ((b6 << 2) | (b7 >> 4));
            return bArr6;
        }
    }

    public static int a(char[] cArr) {
        if (cArr == null) {
            return 0;
        }
        int length = cArr.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (!c(cArr[i3])) {
                cArr[i2] = cArr[i3];
                i2++;
            }
        }
        return i2;
    }
}
