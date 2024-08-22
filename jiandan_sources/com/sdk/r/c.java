package com.sdk.r;

import androidx.exifinterface.media.ExifInterface;
import com.alipay.sdk.m.n.a;
import com.google.common.base.Ascii;
import com.sdk.f.f;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

public final class c {
    public static final char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    public static final byte[] b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 63, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, 0, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -1, -1, -1, -1, -1, -1, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 34, 35, 36, 37, 38, 39, 40, 41, ExifInterface.START_CODE, 43, 44, 45, 46, ExifInterface.WEBP_VP8L_SIGNATURE, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    static {
        boolean z = f.a;
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(((bArr.length - 1) / 3) << 6);
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            int i4 = i3 % 3;
            int i5 = 16 - (i4 * 8);
            i2 |= (bArr[i3] << i5) & (255 << i5);
            if (i4 == 2 || i3 == bArr.length - 1) {
                char[] cArr = a;
                stringBuffer.append(cArr[(16515072 & i2) >>> 18]);
                stringBuffer.append(cArr[(258048 & i2) >>> 12]);
                stringBuffer.append(cArr[(i2 & 4032) >>> 6]);
                stringBuffer.append(cArr[i2 & 63]);
                i2 = 0;
            }
        }
        if (bArr.length % 3 > 0) {
            stringBuffer.setCharAt(stringBuffer.length() - 1, a.h);
        }
        if (bArr.length % 3 == 1) {
            stringBuffer.setCharAt(stringBuffer.length() - 2, a.h);
        }
        return stringBuffer.toString();
    }

    public static byte[] a(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length % 4 == 0) {
            if (str.length() == 0) {
                return new byte[0];
            }
            int i2 = str.charAt(length + -1) == '=' ? 1 : 0;
            if (str.charAt(length - 2) == '=') {
                i2++;
            }
            int i3 = ((length / 4) * 3) - i2;
            byte[] bArr = new byte[i3];
            for (int i4 = 0; i4 < length; i4 += 4) {
                int i5 = (i4 / 4) * 3;
                char charAt = str.charAt(i4);
                char charAt2 = str.charAt(i4 + 1);
                char charAt3 = str.charAt(i4 + 2);
                char charAt4 = str.charAt(i4 + 3);
                byte[] bArr2 = b;
                byte b2 = (bArr2[charAt] << Ascii.DC2) | (bArr2[charAt2] << 12) | (bArr2[charAt3] << 6) | bArr2[charAt4];
                bArr[i5] = (byte) ((16711680 & b2) >> Ascii.DLE);
                if (i4 < length - 4) {
                    bArr[i5 + 1] = (byte) ((65280 & b2) >> 8);
                    bArr[i5 + 2] = (byte) (b2 & 255);
                } else {
                    int i6 = i5 + 1;
                    if (i6 < i3) {
                        bArr[i6] = (byte) ((65280 & b2) >> 8);
                    }
                    int i7 = i5 + 2;
                    if (i7 < i3) {
                        bArr[i7] = (byte) (b2 & 255);
                    }
                }
            }
            return bArr;
        }
        throw new IllegalArgumentException("Base64 string length must be 4*n");
    }
}
