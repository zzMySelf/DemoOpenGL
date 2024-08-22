package com.google.zxing.pdf417.decoder;

import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.pdf417.PDF417Common;
import java.lang.reflect.Array;

public final class PDF417CodewordDecoder {
    public static final float[][] RATIOS_TABLE;

    static {
        int i2;
        int length = PDF417Common.SYMBOL_TABLE.length;
        int[] iArr = new int[2];
        iArr[1] = 8;
        iArr[0] = length;
        RATIOS_TABLE = (float[][]) Array.newInstance(float.class, iArr);
        int i3 = 0;
        while (true) {
            int[] iArr2 = PDF417Common.SYMBOL_TABLE;
            if (i3 < iArr2.length) {
                int i4 = iArr2[i3];
                int i5 = i4 & 1;
                int i6 = 0;
                while (i6 < 8) {
                    float f = 0.0f;
                    while (true) {
                        i2 = i4 & 1;
                        if (i2 != i5) {
                            break;
                        }
                        f += 1.0f;
                        i4 >>= 1;
                    }
                    RATIOS_TABLE[i3][(8 - i6) - 1] = f / 17.0f;
                    i6++;
                    i5 = i2;
                }
                i3++;
            } else {
                return;
            }
        }
    }

    public static int getBitValue(int[] iArr) {
        long j = 0;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            for (int i3 = 0; i3 < iArr[i2]; i3++) {
                int i4 = 1;
                long j2 = j << 1;
                if (i2 % 2 != 0) {
                    i4 = 0;
                }
                j = j2 | ((long) i4);
            }
        }
        return (int) j;
    }

    public static int getClosestDecodedValue(int[] iArr) {
        int sum = MathUtils.sum(iArr);
        float[] fArr = new float[8];
        if (sum > 1) {
            for (int i2 = 0; i2 < 8; i2++) {
                fArr[i2] = ((float) iArr[i2]) / ((float) sum);
            }
        }
        float f = Float.MAX_VALUE;
        int i3 = -1;
        int i4 = 0;
        while (true) {
            float[][] fArr2 = RATIOS_TABLE;
            if (i4 >= fArr2.length) {
                return i3;
            }
            float f2 = 0.0f;
            float[] fArr3 = fArr2[i4];
            for (int i5 = 0; i5 < 8; i5++) {
                float f3 = fArr3[i5] - fArr[i5];
                f2 += f3 * f3;
                if (f2 >= f) {
                    break;
                }
            }
            if (f2 < f) {
                i3 = PDF417Common.SYMBOL_TABLE[i4];
                f = f2;
            }
            i4++;
        }
    }

    public static int getDecodedCodewordValue(int[] iArr) {
        int bitValue = getBitValue(iArr);
        if (PDF417Common.getCodeword(bitValue) == -1) {
            return -1;
        }
        return bitValue;
    }

    public static int getDecodedValue(int[] iArr) {
        int decodedCodewordValue = getDecodedCodewordValue(sampleBitCounts(iArr));
        if (decodedCodewordValue != -1) {
            return decodedCodewordValue;
        }
        return getClosestDecodedValue(iArr);
    }

    public static int[] sampleBitCounts(int[] iArr) {
        float sum = (float) MathUtils.sum(iArr);
        int[] iArr2 = new int[8];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 17; i4++) {
            if (((float) (iArr[i3] + i2)) <= (sum / 34.0f) + ((((float) i4) * sum) / 17.0f)) {
                i2 += iArr[i3];
                i3++;
            }
            iArr2[i3] = iArr2[i3] + 1;
        }
        return iArr2;
    }
}
