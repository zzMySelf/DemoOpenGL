package rg.qw.vvv;

import com.alipay.sdk.m.n.a;
import com.google.common.base.Ascii;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public static byte[] f10454ad = new byte[128];
    public static char[] qw = new char[64];

    static {
        char c = 'A';
        int i2 = 0;
        while (c <= 'Z') {
            qw[i2] = c;
            c = (char) (c + 1);
            i2++;
        }
        char c2 = 'a';
        while (c2 <= 'z') {
            qw[i2] = c2;
            c2 = (char) (c2 + 1);
            i2++;
        }
        char c3 = '0';
        while (c3 <= '9') {
            qw[i2] = c3;
            c3 = (char) (c3 + 1);
            i2++;
        }
        char[] cArr = qw;
        cArr[i2] = '+';
        cArr[i2 + 1] = '/';
        int i3 = 0;
        while (true) {
            byte[] bArr = f10454ad;
            if (i3 >= bArr.length) {
                break;
            }
            bArr[i3] = -1;
            i3++;
        }
        for (int i4 = 0; i4 < 64; i4++) {
            f10454ad[qw[i4]] = (byte) i4;
        }
    }

    public static char[] ad(byte[] bArr, int i2) {
        int i3;
        byte b;
        byte b2;
        int i4 = ((i2 * 4) + 2) / 3;
        char[] cArr = new char[(((i2 + 2) / 3) * 4)];
        int i5 = 0;
        int i6 = 0;
        while (i5 < i2) {
            int i7 = i5 + 1;
            byte b3 = bArr[i5] & 255;
            if (i7 < i2) {
                i3 = i7 + 1;
                b = bArr[i7] & 255;
            } else {
                i3 = i7;
                b = 0;
            }
            if (i3 < i2) {
                b2 = bArr[i3] & 255;
                i3++;
            } else {
                b2 = 0;
            }
            int i8 = b3 >>> 2;
            int i9 = ((b3 & 3) << 4) | (b >>> 4);
            int i10 = ((b & Ascii.SI) << 2) | (b2 >>> 6);
            byte b4 = b2 & 63;
            int i11 = i6 + 1;
            char[] cArr2 = qw;
            cArr[i6] = cArr2[i8];
            int i12 = i11 + 1;
            cArr[i11] = cArr2[i9];
            char c = a.h;
            cArr[i12] = i12 < i4 ? cArr2[i10] : a.h;
            int i13 = i12 + 1;
            if (i13 < i4) {
                c = qw[b4];
            }
            cArr[i13] = c;
            i6 = i13 + 1;
            i5 = i3;
        }
        return cArr;
    }

    public static char[] qw(byte[] bArr) {
        return ad(bArr, bArr.length);
    }
}
