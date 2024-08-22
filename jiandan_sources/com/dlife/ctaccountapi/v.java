package com.dlife.ctaccountapi;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import java.util.Locale;

public class v {
    public static final String d = "v";
    public final int[] a = {1732584193, -271733879, -1732584194, 271733878, -1009589776};
    public int[] b = new int[5];
    public int[] c = new int[80];

    private int a(int i2, int i3) {
        return (i2 >>> (32 - i3)) | (i2 << i3);
    }

    private int a(int i2, int i3, int i4) {
        return ((~i2) & i4) | (i3 & i2);
    }

    private int a(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & 255) | ((bArr[i2] & 255) << Ascii.CAN) | ((bArr[i2 + 1] & 255) << Ascii.DLE) | ((bArr[i2 + 2] & 255) << 8);
    }

    private void a() {
        for (int i2 = 16; i2 <= 79; i2++) {
            int[] iArr = this.c;
            iArr[i2] = a(((iArr[i2 - 3] ^ iArr[i2 - 8]) ^ iArr[i2 - 14]) ^ iArr[i2 - 16], 1);
        }
        int[] iArr2 = new int[5];
        for (int i3 = 0; i3 < 5; i3++) {
            iArr2[i3] = this.b[i3];
        }
        for (int i4 = 0; i4 <= 19; i4++) {
            iArr2[4] = iArr2[3];
            iArr2[3] = iArr2[2];
            iArr2[2] = a(iArr2[1], 30);
            iArr2[1] = iArr2[0];
            iArr2[0] = a(iArr2[0], 5) + a(iArr2[1], iArr2[2], iArr2[3]) + iArr2[4] + this.c[i4] + 1518500249;
        }
        for (int i5 = 20; i5 <= 39; i5++) {
            iArr2[4] = iArr2[3];
            iArr2[3] = iArr2[2];
            iArr2[2] = a(iArr2[1], 30);
            iArr2[1] = iArr2[0];
            iArr2[0] = a(iArr2[0], 5) + b(iArr2[1], iArr2[2], iArr2[3]) + iArr2[4] + this.c[i5] + 1859775393;
        }
        for (int i6 = 40; i6 <= 59; i6++) {
            iArr2[4] = iArr2[3];
            iArr2[3] = iArr2[2];
            iArr2[2] = a(iArr2[1], 30);
            iArr2[1] = iArr2[0];
            iArr2[0] = (((a(iArr2[0], 5) + c(iArr2[1], iArr2[2], iArr2[3])) + iArr2[4]) + this.c[i6]) - 1894007588;
        }
        for (int i7 = 60; i7 <= 79; i7++) {
            iArr2[4] = iArr2[3];
            iArr2[3] = iArr2[2];
            iArr2[2] = a(iArr2[1], 30);
            iArr2[1] = iArr2[0];
            iArr2[0] = (((a(iArr2[0], 5) + b(iArr2[1], iArr2[2], iArr2[3])) + iArr2[4]) + this.c[i7]) - 899497514;
        }
        for (int i8 = 0; i8 < 5; i8++) {
            int[] iArr3 = this.b;
            iArr3[i8] = iArr3[i8] + iArr2[i8];
        }
        int i9 = 0;
        while (true) {
            int[] iArr4 = this.c;
            if (i9 < iArr4.length) {
                iArr4[i9] = 0;
                i9++;
            } else {
                return;
            }
        }
    }

    private void a(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) (i2 >>> 24);
        bArr[i3 + 1] = (byte) (i2 >>> 16);
        bArr[i3 + 2] = (byte) (i2 >>> 8);
        bArr[i3 + 3] = (byte) i2;
    }

    public static byte[] a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            byte[] bArr = new byte[64];
            byte[] bArr2 = new byte[64];
            byte[] bArr3 = new byte[64];
            int length = str2.length();
            v vVar = new v();
            if (str2.length() > 64) {
                byte[] c2 = vVar.c(x.a(str2));
                length = c2.length;
                for (int i2 = 0; i2 < length; i2++) {
                    bArr3[i2] = c2[i2];
                }
            } else {
                byte[] a2 = x.a(str2);
                for (int i3 = 0; i3 < a2.length; i3++) {
                    bArr3[i3] = a2[i3];
                }
            }
            while (length < 64) {
                bArr3[length] = 0;
                length++;
            }
            for (int i4 = 0; i4 < 64; i4++) {
                bArr[i4] = (byte) (bArr3[i4] ^ 54);
                bArr2[i4] = (byte) (bArr3[i4] ^ 92);
            }
            return vVar.c(a(bArr2, vVar.c(a(bArr, x.a(str)))));
        } catch (Throwable unused) {
            return null;
        }
    }

    private byte[] a(byte[] bArr) {
        int i2;
        int i3;
        int length = bArr.length;
        int i4 = length % 64;
        if (i4 < 56) {
            i2 = 55 - i4;
            i3 = (length - i4) + 64;
        } else if (i4 == 56) {
            i3 = length + 8 + 64;
            i2 = 63;
        } else {
            i2 = (63 - i4) + 56;
            i3 = ((length + 64) - i4) + 64;
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        int i5 = length + 1;
        bArr2[length] = Byte.MIN_VALUE;
        int i6 = 0;
        while (i6 < i2) {
            bArr2[i5] = 0;
            i6++;
            i5++;
        }
        long j = ((long) length) * 8;
        byte b2 = (byte) ((int) ((j >> 8) & 255));
        byte b3 = (byte) ((int) ((j >> 16) & 255));
        byte b4 = (byte) ((int) ((j >> 24) & 255));
        byte b5 = (byte) ((int) ((j >> 32) & 255));
        byte b6 = (byte) ((int) ((j >> 40) & 255));
        byte b7 = (byte) ((int) (j >> 56));
        int i7 = i5 + 1;
        bArr2[i5] = b7;
        int i8 = i7 + 1;
        bArr2[i7] = (byte) ((int) (255 & (j >> 48)));
        int i9 = i8 + 1;
        bArr2[i8] = b6;
        int i10 = i9 + 1;
        bArr2[i9] = b5;
        int i11 = i10 + 1;
        bArr2[i10] = b4;
        int i12 = i11 + 1;
        bArr2[i11] = b3;
        bArr2[i12] = b2;
        bArr2[i12 + 1] = (byte) ((int) (j & 255));
        return bArr2;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr3[i2] = bArr[i2];
        }
        for (int i3 = 0; i3 < bArr2.length; i3++) {
            bArr3[bArr.length + i3] = bArr2[i3];
        }
        return bArr3;
    }

    private int b(int i2, int i3, int i4) {
        return (i2 ^ i3) ^ i4;
    }

    public static String b(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b2 : bArr) {
            String upperCase = Integer.toHexString(b2 & 255).toUpperCase(Locale.CHINA);
            if (upperCase.length() < 2) {
                sb.append(0);
            }
            sb.append(upperCase);
        }
        return sb.toString();
    }

    private int c(int i2, int i3, int i4) {
        return (i2 & i4) | (i2 & i3) | (i3 & i4);
    }

    private int d(byte[] bArr) {
        int[] iArr = this.a;
        System.arraycopy(iArr, 0, this.b, 0, iArr.length);
        byte[] a2 = a(bArr);
        int length = a2.length / 64;
        for (int i2 = 0; i2 < length; i2++) {
            for (int i3 = 0; i3 < 16; i3++) {
                this.c[i3] = a(a2, (i2 * 64) + (i3 * 4));
            }
            a();
        }
        return 20;
    }

    public byte[] c(byte[] bArr) {
        d(bArr);
        byte[] bArr2 = new byte[20];
        int i2 = 0;
        while (true) {
            int[] iArr = this.b;
            if (i2 >= iArr.length) {
                return bArr2;
            }
            a(iArr[i2], bArr2, i2 * 4);
            i2++;
        }
    }
}
