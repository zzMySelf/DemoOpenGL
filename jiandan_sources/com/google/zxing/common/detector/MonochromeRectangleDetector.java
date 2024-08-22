package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

@Deprecated
public final class MonochromeRectangleDetector {
    public static final int MAX_MODULES = 32;
    public final BitMatrix image;

    public MonochromeRectangleDetector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
    }

    private int[] blackWhiteRange(int i2, int i3, int i4, int i5, boolean z) {
        int i6 = (i4 + i5) / 2;
        int i7 = i6;
        while (i7 >= i4) {
            BitMatrix bitMatrix = this.image;
            if (!z ? !bitMatrix.get(i2, i7) : !bitMatrix.get(i7, i2)) {
                int i8 = i7;
                while (true) {
                    i8--;
                    if (i8 < i4) {
                        break;
                    }
                    BitMatrix bitMatrix2 = this.image;
                    if (z) {
                        if (bitMatrix2.get(i8, i2)) {
                            break;
                        }
                    } else if (bitMatrix2.get(i2, i8)) {
                        break;
                    }
                }
                int i9 = i7 - i8;
                if (i8 < i4 || i9 > i3) {
                    break;
                }
                i7 = i8;
            } else {
                i7--;
            }
        }
        int i10 = i7 + 1;
        while (i6 < i5) {
            BitMatrix bitMatrix3 = this.image;
            if (!z ? !bitMatrix3.get(i2, i6) : !bitMatrix3.get(i6, i2)) {
                int i11 = i6;
                while (true) {
                    i11++;
                    if (i11 >= i5) {
                        break;
                    }
                    BitMatrix bitMatrix4 = this.image;
                    if (z) {
                        if (bitMatrix4.get(i11, i2)) {
                            break;
                        }
                    } else if (bitMatrix4.get(i2, i11)) {
                        break;
                    }
                }
                int i12 = i11 - i6;
                if (i11 >= i5 || i12 > i3) {
                    break;
                }
                i6 = i11;
            } else {
                i6++;
            }
        }
        int i13 = i6 - 1;
        if (i13 <= i10) {
            return null;
        }
        return new int[]{i10, i13};
    }

    private ResultPoint findCornerFromCenter(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) throws NotFoundException {
        int[] iArr;
        int i11 = i2;
        int i12 = i6;
        int[] iArr2 = null;
        int i13 = i9;
        int i14 = i11;
        int i15 = i12;
        while (i15 < i13 && i15 >= i8 && i14 < i5 && i14 >= i4) {
            if (i3 == 0) {
                iArr = blackWhiteRange(i15, i10, i4, i5, true);
            } else {
                iArr = blackWhiteRange(i14, i10, i8, i9, false);
            }
            if (iArr != null) {
                i15 += i7;
                i14 += i3;
                iArr2 = iArr;
            } else if (iArr2 != null) {
                char c = 1;
                if (i3 == 0) {
                    int i16 = i15 - i7;
                    if (iArr2[0] >= i11) {
                        return new ResultPoint((float) iArr2[1], (float) i16);
                    }
                    if (iArr2[1] <= i11) {
                        return new ResultPoint((float) iArr2[0], (float) i16);
                    }
                    if (i7 > 0) {
                        c = 0;
                    }
                    return new ResultPoint((float) iArr2[c], (float) i16);
                }
                int i17 = i14 - i3;
                if (iArr2[0] >= i12) {
                    return new ResultPoint((float) i17, (float) iArr2[1]);
                }
                if (iArr2[1] <= i12) {
                    return new ResultPoint((float) i17, (float) iArr2[0]);
                }
                float f = (float) i17;
                if (i3 < 0) {
                    c = 0;
                }
                return new ResultPoint(f, (float) iArr2[c]);
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public ResultPoint[] detect() throws NotFoundException {
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i2 = height / 2;
        int i3 = width / 2;
        int max = Math.max(1, height / 256);
        int i4 = -max;
        int i5 = i3 / 2;
        int i6 = i3;
        int i7 = width;
        int i8 = i2;
        int i9 = i4;
        int i10 = height;
        int i11 = max;
        int max2 = Math.max(1, width / 256);
        int i12 = -max2;
        int y = ((int) findCornerFromCenter(i6, 0, 0, i7, i8, i4, 0, i10, i5).getY()) - 1;
        int i13 = max2;
        int i14 = i2 / 2;
        ResultPoint findCornerFromCenter = findCornerFromCenter(i6, i12, 0, i7, i8, 0, y, i10, i14);
        int x = ((int) findCornerFromCenter.getX()) - 1;
        ResultPoint findCornerFromCenter2 = findCornerFromCenter(i6, i13, x, i7, i8, 0, y, i10, i14);
        int x2 = ((int) findCornerFromCenter2.getX()) + 1;
        ResultPoint findCornerFromCenter3 = findCornerFromCenter(i6, 0, x, x2, i8, i11, y, i10, i5);
        return new ResultPoint[]{findCornerFromCenter(i6, 0, x, x2, i8, i9, y, ((int) findCornerFromCenter3.getY()) + 1, i3 / 4), findCornerFromCenter, findCornerFromCenter2, findCornerFromCenter3};
    }
}
