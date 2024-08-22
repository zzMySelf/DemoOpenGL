package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;
import java.lang.reflect.Array;

public final class HybridBinarizer extends GlobalHistogramBinarizer {
    public static final int BLOCK_SIZE = 8;
    public static final int BLOCK_SIZE_MASK = 7;
    public static final int BLOCK_SIZE_POWER = 3;
    public static final int MINIMUM_DIMENSION = 40;
    public static final int MIN_DYNAMIC_RANGE = 24;
    public BitMatrix matrix;

    public HybridBinarizer(LuminanceSource luminanceSource) {
        super(luminanceSource);
    }

    public static int[][] calculateBlackPoints(byte[] bArr, int i2, int i3, int i4, int i5) {
        int i6 = i2;
        int i7 = i3;
        int i8 = 8;
        int i9 = i5 - 8;
        int i10 = i4 - 8;
        int[] iArr = new int[2];
        iArr[1] = i6;
        iArr[0] = i7;
        int[][] iArr2 = (int[][]) Array.newInstance(int.class, iArr);
        int i11 = 0;
        while (i11 < i7) {
            int i12 = i11 << 3;
            if (i12 > i9) {
                i12 = i9;
            }
            int i13 = 0;
            while (i13 < i6) {
                int i14 = i13 << 3;
                if (i14 > i10) {
                    i14 = i10;
                }
                int i15 = (i12 * i4) + i14;
                byte b = 255;
                int i16 = 0;
                int i17 = 0;
                byte b2 = 0;
                while (i16 < i8) {
                    byte b3 = b2;
                    int i18 = 0;
                    while (i18 < i8) {
                        byte b4 = bArr[i15 + i18] & 255;
                        i17 += b4;
                        if (b4 < b) {
                            b = b4;
                        }
                        if (b4 > b3) {
                            b3 = b4;
                        }
                        i18++;
                        i8 = 8;
                    }
                    if (b3 - b <= 24) {
                        i16++;
                        i15 += i4;
                        b2 = b3;
                        i8 = 8;
                    }
                    while (true) {
                        i16++;
                        i15 += i4;
                        if (i16 >= 8) {
                            break;
                        }
                        int i19 = 0;
                        for (int i20 = 8; i19 < i20; i20 = 8) {
                            i17 += bArr[i15 + i19] & 255;
                            i19++;
                        }
                    }
                    i16++;
                    i15 += i4;
                    b2 = b3;
                    i8 = 8;
                }
                int i21 = i17 >> 6;
                if (b2 - b <= 24) {
                    i21 = b / 2;
                    if (i11 > 0 && i13 > 0) {
                        int i22 = i11 - 1;
                        int i23 = i13 - 1;
                        int i24 = ((iArr2[i22][i13] + (iArr2[i11][i23] * 2)) + iArr2[i22][i23]) / 4;
                        if (b < i24) {
                            i21 = i24;
                        }
                        iArr2[i11][i13] = i21;
                        i13++;
                        i8 = 8;
                    }
                }
                iArr2[i11][i13] = i21;
                i13++;
                i8 = 8;
            }
            i11++;
            i8 = 8;
        }
        return iArr2;
    }

    public static void calculateThresholdForBlock(byte[] bArr, int i2, int i3, int i4, int i5, int[][] iArr, BitMatrix bitMatrix) {
        int i6 = i2;
        int i7 = i3;
        int i8 = i5 - 8;
        int i9 = i4 - 8;
        for (int i10 = 0; i10 < i7; i10++) {
            int i11 = i10 << 3;
            int i12 = i11 > i8 ? i8 : i11;
            int cap = cap(i10, 2, i7 - 3);
            for (int i13 = 0; i13 < i6; i13++) {
                int i14 = i13 << 3;
                int i15 = i14 > i9 ? i9 : i14;
                int cap2 = cap(i13, 2, i6 - 3);
                int i16 = 0;
                for (int i17 = -2; i17 <= 2; i17++) {
                    int[] iArr2 = iArr[cap + i17];
                    i16 += iArr2[cap2 - 2] + iArr2[cap2 - 1] + iArr2[cap2] + iArr2[cap2 + 1] + iArr2[cap2 + 2];
                }
                thresholdBlock(bArr, i15, i12, i16 / 25, i4, bitMatrix);
            }
        }
    }

    public static int cap(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    public static void thresholdBlock(byte[] bArr, int i2, int i3, int i4, int i5, BitMatrix bitMatrix) {
        int i6 = (i3 * i5) + i2;
        int i7 = 0;
        while (i7 < 8) {
            for (int i8 = 0; i8 < 8; i8++) {
                if ((bArr[i6 + i8] & 255) <= i4) {
                    bitMatrix.set(i2 + i8, i3 + i7);
                }
            }
            i7++;
            i6 += i5;
        }
    }

    public Binarizer createBinarizer(LuminanceSource luminanceSource) {
        return new HybridBinarizer(luminanceSource);
    }

    public BitMatrix getBlackMatrix() throws NotFoundException {
        BitMatrix bitMatrix = this.matrix;
        if (bitMatrix != null) {
            return bitMatrix;
        }
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        int height = luminanceSource.getHeight();
        if (width < 40 || height < 40) {
            this.matrix = super.getBlackMatrix();
        } else {
            byte[] matrix2 = luminanceSource.getMatrix();
            int i2 = width >> 3;
            if ((width & 7) != 0) {
                i2++;
            }
            int i3 = i2;
            int i4 = height >> 3;
            if ((height & 7) != 0) {
                i4++;
            }
            int i5 = i4;
            int[][] calculateBlackPoints = calculateBlackPoints(matrix2, i3, i5, width, height);
            BitMatrix bitMatrix2 = new BitMatrix(width, height);
            calculateThresholdForBlock(matrix2, i3, i5, width, height, calculateBlackPoints, bitMatrix2);
            this.matrix = bitMatrix2;
        }
        return this.matrix;
    }
}
