package com.google.zxing.common;

import com.google.zxing.NotFoundException;

public final class DefaultGridSampler extends GridSampler {
    public BitMatrix sampleGrid(BitMatrix bitMatrix, int i2, int i3, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) throws NotFoundException {
        BitMatrix bitMatrix2 = bitMatrix;
        int i4 = i2;
        int i5 = i3;
        return sampleGrid(bitMatrix, i2, i3, PerspectiveTransform.quadrilateralToQuadrilateral(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16));
    }

    public BitMatrix sampleGrid(BitMatrix bitMatrix, int i2, int i3, PerspectiveTransform perspectiveTransform) throws NotFoundException {
        if (i2 <= 0 || i3 <= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        BitMatrix bitMatrix2 = new BitMatrix(i2, i3);
        int i4 = i2 * 2;
        float[] fArr = new float[i4];
        for (int i5 = 0; i5 < i3; i5++) {
            float f = ((float) i5) + 0.5f;
            for (int i6 = 0; i6 < i4; i6 += 2) {
                fArr[i6] = ((float) (i6 / 2)) + 0.5f;
                fArr[i6 + 1] = f;
            }
            perspectiveTransform.transformPoints(fArr);
            GridSampler.checkAndNudgePoints(bitMatrix, fArr);
            int i7 = 0;
            while (i7 < i4) {
                try {
                    if (bitMatrix.get((int) fArr[i7], (int) fArr[i7 + 1])) {
                        bitMatrix2.set(i7 / 2, i5);
                    }
                    i7 += 2;
                } catch (ArrayIndexOutOfBoundsException unused) {
                    throw NotFoundException.getNotFoundInstance();
                }
            }
        }
        return bitMatrix2;
    }
}
