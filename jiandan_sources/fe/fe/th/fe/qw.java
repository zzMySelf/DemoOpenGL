package fe.fe.th.fe;

import com.google.common.base.Ascii;

public final class qw {

    /* renamed from: ad  reason: collision with root package name */
    public static final char[] f3092ad = new char[64];
    public static final byte[] qw = new byte[128];

    static {
        int i2;
        int i3;
        int i4 = 0;
        for (int i5 = 0; i5 < 128; i5++) {
            qw[i5] = -1;
        }
        for (int i6 = 90; i6 >= 65; i6--) {
            qw[i6] = (byte) (i6 - 65);
        }
        int i7 = 122;
        while (true) {
            i2 = 26;
            if (i7 < 97) {
                break;
            }
            qw[i7] = (byte) ((i7 - 97) + 26);
            i7--;
        }
        int i8 = 57;
        while (true) {
            i3 = 52;
            if (i8 < 48) {
                break;
            }
            qw[i8] = (byte) ((i8 - 48) + 52);
            i8--;
        }
        byte[] bArr = qw;
        bArr[43] = 62;
        bArr[47] = 63;
        for (int i9 = 0; i9 <= 25; i9++) {
            f3092ad[i9] = (char) (i9 + 65);
        }
        int i10 = 0;
        while (i2 <= 51) {
            f3092ad[i2] = (char) (i10 + 97);
            i2++;
            i10++;
        }
        while (i3 <= 61) {
            f3092ad[i3] = (char) (i4 + 48);
            i3++;
            i4++;
        }
        char[] cArr = f3092ad;
        cArr[62] = '+';
        cArr[63] = '/';
    }

    public static boolean ad(char c) {
        return c == ' ' || c == 13 || c == 10 || c == 9;
    }

    public static byte[] de(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int qw2 = qw(charArray);
        if (qw2 % 4 != 0) {
            return null;
        }
        int i2 = qw2 / 4;
        if (i2 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[(i2 * 3)];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < i2 - 1) {
            int i6 = i4 + 1;
            char c = charArray[i4];
            if (rg(c)) {
                int i7 = i6 + 1;
                char c2 = charArray[i6];
                if (rg(c2)) {
                    int i8 = i7 + 1;
                    char c3 = charArray[i7];
                    if (rg(c3)) {
                        int i9 = i8 + 1;
                        char c4 = charArray[i8];
                        if (rg(c4)) {
                            byte[] bArr2 = qw;
                            byte b = bArr2[c];
                            byte b2 = bArr2[c2];
                            byte b3 = bArr2[c3];
                            byte b4 = bArr2[c4];
                            int i10 = i5 + 1;
                            bArr[i5] = (byte) ((b << 2) | (b2 >> 4));
                            int i11 = i10 + 1;
                            bArr[i10] = (byte) (((b2 & Ascii.SI) << 4) | ((b3 >> 2) & 15));
                            i5 = i11 + 1;
                            bArr[i11] = (byte) ((b3 << 6) | b4);
                            i3++;
                            i4 = i9;
                        }
                    }
                }
            }
            return null;
        }
        int i12 = i4 + 1;
        char c5 = charArray[i4];
        if (!rg(c5)) {
            return null;
        }
        int i13 = i12 + 1;
        char c6 = charArray[i12];
        if (!rg(c6)) {
            return null;
        }
        byte[] bArr3 = qw;
        byte b5 = bArr3[c5];
        byte b6 = bArr3[c6];
        int i14 = i13 + 1;
        char c7 = charArray[i13];
        char c8 = charArray[i14];
        if (rg(c7) && rg(c8)) {
            byte[] bArr4 = qw;
            byte b7 = bArr4[c7];
            byte b8 = bArr4[c8];
            int i15 = i5 + 1;
            bArr[i5] = (byte) ((b5 << 2) | (b6 >> 4));
            bArr[i15] = (byte) (((b6 & Ascii.SI) << 4) | ((b7 >> 2) & 15));
            bArr[i15 + 1] = (byte) (b8 | (b7 << 6));
            return bArr;
        } else if (!fe(c7) || !fe(c8)) {
            if (fe(c7) || !fe(c8)) {
                return null;
            }
            byte b9 = qw[c7];
            if ((b9 & 3) != 0) {
                return null;
            }
            int i16 = i3 * 3;
            byte[] bArr5 = new byte[(i16 + 2)];
            System.arraycopy(bArr, 0, bArr5, 0, i16);
            bArr5[i5] = (byte) ((b5 << 2) | (b6 >> 4));
            bArr5[i5 + 1] = (byte) (((b9 >> 2) & 15) | ((b6 & Ascii.SI) << 4));
            return bArr5;
        } else if ((b6 & Ascii.SI) != 0) {
            return null;
        } else {
            int i17 = i3 * 3;
            byte[] bArr6 = new byte[(i17 + 1)];
            System.arraycopy(bArr, 0, bArr6, 0, i17);
            bArr6[i5] = (byte) ((b5 << 2) | (b6 >> 4));
            return bArr6;
        }
    }

    public static boolean fe(char c) {
        return c == '=';
    }

    public static int qw(char[] cArr) {
        if (cArr == null) {
            return 0;
        }
        int length = cArr.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (!ad(cArr[i3])) {
                cArr[i2] = cArr[i3];
                i2++;
            }
        }
        return i2;
    }

    public static boolean rg(char c) {
        return c < 128 && qw[c] != -1;
    }
}
