package com.baidu.wallet.utils;

import androidx.recyclerview.widget.ItemTouchHelper;

public class ImageUtils {
    public static int[] decodeYUV420SP(byte[] bArr, int i2, int i3) {
        int i4 = i2;
        int i5 = i3;
        int i6 = i4 * i5;
        int[] iArr = new int[i6];
        int i7 = 0;
        for (int i8 = 0; i8 < i5; i8++) {
            int i9 = ((i8 >> 1) * i4) + i6;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            while (i10 < i4) {
                int i13 = (bArr[i7] & 255) - 16;
                if (i13 < 0) {
                    i13 = 0;
                }
                if ((i10 & 1) == 0) {
                    int i14 = i9 + 1;
                    i12 = (bArr[i9] & 255) - 128;
                    i9 = i14 + 1;
                    i11 = (bArr[i14] & 255) - 128;
                }
                int i15 = i13 * 1192;
                int i16 = (i12 * 1634) + i15;
                int i17 = (i15 - (i12 * 833)) - (i11 * 400);
                int i18 = i15 + (i11 * 2066);
                if (i16 < 0) {
                    i16 = 0;
                } else if (i16 > 262143) {
                    i16 = 262143;
                }
                if (i17 < 0) {
                    i17 = 0;
                } else if (i17 > 262143) {
                    i17 = 262143;
                }
                if (i18 < 0) {
                    i18 = 0;
                } else if (i18 > 262143) {
                    i18 = 262143;
                }
                iArr[i7] = ((i18 >> 10) & 255) | ((i16 << 6) & ItemTouchHelper.ACTION_MODE_DRAG_MASK) | -16777216 | ((i17 >> 2) & 65280);
                i10++;
                i7++;
            }
        }
        return iArr;
    }

    public static void rotateYUV240SP(byte[] bArr, byte[] bArr2, int i2, int i3) {
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = 0;
            while (i6 < i3) {
                bArr2[i4] = bArr[(i2 - i5) - 1];
                i6++;
                i4++;
            }
        }
        int i7 = i3 / 2;
        for (int i8 = 0; i8 < i2; i8 += 2) {
            int i9 = (i2 * i3) + i2;
            int i10 = 0;
            while (i10 < i7) {
                int i11 = i9 - i8;
                bArr2[i4] = bArr[i11 - 2];
                bArr2[i4 + 1] = bArr[i11 - 1];
                i9 += i2;
                i10++;
                i4 += 2;
            }
        }
    }

    public static void rotateYUV240SP2(byte[] bArr, byte[] bArr2, int i2, int i3) {
        int i4 = i2 * i3;
        int i5 = 0;
        for (int i6 = 0; i6 < i2; i6++) {
            for (int i7 = 0; i7 < i3; i7++) {
                bArr2[i5] = bArr[(i2 * i7) + i6];
                i5++;
            }
        }
        for (int i8 = 0; i8 < i2; i8 += 2) {
            for (int i9 = 0; i9 < i3 / 2; i9++) {
                int i10 = (i2 * i9) + i4 + i8;
                bArr2[i5] = bArr[i10];
                bArr2[i5 + 1] = bArr[i10 + 1];
                i5 += 2;
            }
        }
    }

    public static byte[] rotateYUV420Degree180(byte[] bArr, int i2, int i3) {
        int i4 = i2 * i3;
        int i5 = (i4 * 3) / 2;
        byte[] bArr2 = new byte[i5];
        int i6 = 0;
        for (int i7 = i4 - 1; i7 >= 0; i7--) {
            bArr2[i6] = bArr[i7];
            i6++;
        }
        for (int i8 = i5 - 1; i8 >= i4; i8 -= 2) {
            int i9 = i6 + 1;
            bArr2[i6] = bArr[i8 - 1];
            i6 = i9 + 1;
            bArr2[i9] = bArr[i8];
        }
        return bArr2;
    }

    public static byte[] rotateYUV420Degree270(byte[] bArr, int i2, int i3) {
        int i4;
        int i5 = i2 * i3;
        byte[] bArr2 = new byte[((i5 * 3) / 2)];
        if (i2 == 0 && i3 == 0) {
            i5 = 0;
            i4 = 0;
        } else {
            i4 = i3 >> 1;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < i2; i7++) {
            int i8 = 0;
            for (int i9 = 0; i9 < i3; i9++) {
                bArr2[i6] = bArr[i8 + i7];
                i6++;
                i8 += i2;
            }
        }
        for (int i10 = 0; i10 < i2; i10 += 2) {
            int i11 = i5;
            for (int i12 = 0; i12 < i4; i12++) {
                int i13 = i11 + i10;
                bArr2[i6] = bArr[i13];
                bArr2[i6 + 1] = bArr[i13 + 1];
                i6 += 2;
                i11 += i2;
            }
        }
        return rotateYUV420Degree180(bArr2, i2, i3);
    }

    public static byte[] rotateYUV420Degree90(byte[] bArr, int i2, int i3) {
        int i4 = i2 * i3;
        int i5 = (i4 * 3) / 2;
        byte[] bArr2 = new byte[i5];
        int i6 = 0;
        for (int i7 = 0; i7 < i2; i7++) {
            for (int i8 = i3 - 1; i8 >= 0; i8--) {
                bArr2[i6] = bArr[(i8 * i2) + i7];
                i6++;
            }
        }
        int i9 = i5 - 1;
        for (int i10 = i2 - 1; i10 > 0; i10 -= 2) {
            for (int i11 = 0; i11 < i3 / 2; i11++) {
                int i12 = (i11 * i2) + i4;
                bArr2[i9] = bArr[i12 + i10];
                int i13 = i9 - 1;
                bArr2[i13] = bArr[i12 + (i10 - 1)];
                i9 = i13 - 1;
            }
        }
        return bArr2;
    }
}
