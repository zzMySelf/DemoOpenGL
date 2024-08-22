package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

public final class WhiteRectangleDetector {
    public static final int CORR = 1;
    public static final int INIT_SIZE = 10;
    public final int downInit;
    public final int height;
    public final BitMatrix image;
    public final int leftInit;
    public final int rightInit;
    public final int upInit;
    public final int width;

    public WhiteRectangleDetector(BitMatrix bitMatrix) throws NotFoundException {
        this(bitMatrix, 10, bitMatrix.getWidth() / 2, bitMatrix.getHeight() / 2);
    }

    private ResultPoint[] centerEdges(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) {
        float x = resultPoint.getX();
        float y = resultPoint.getY();
        float x2 = resultPoint2.getX();
        float y2 = resultPoint2.getY();
        float x3 = resultPoint3.getX();
        float y3 = resultPoint3.getY();
        float x4 = resultPoint4.getX();
        float y4 = resultPoint4.getY();
        if (x < ((float) this.width) / 2.0f) {
            return new ResultPoint[]{new ResultPoint(x4 - 1.0f, y4 + 1.0f), new ResultPoint(x2 + 1.0f, y2 + 1.0f), new ResultPoint(x3 - 1.0f, y3 - 1.0f), new ResultPoint(x + 1.0f, y - 1.0f)};
        }
        return new ResultPoint[]{new ResultPoint(x4 + 1.0f, y4 + 1.0f), new ResultPoint(x2 + 1.0f, y2 - 1.0f), new ResultPoint(x3 - 1.0f, y3 + 1.0f), new ResultPoint(x - 1.0f, y - 1.0f)};
    }

    private boolean containsBlackPoint(int i2, int i3, int i4, boolean z) {
        if (z) {
            while (i2 <= i3) {
                if (this.image.get(i2, i4)) {
                    return true;
                }
                i2++;
            }
            return false;
        }
        while (i2 <= i3) {
            if (this.image.get(i4, i2)) {
                return true;
            }
            i2++;
        }
        return false;
    }

    private ResultPoint getBlackPointOnSegment(float f, float f2, float f3, float f4) {
        int round = MathUtils.round(MathUtils.distance(f, f2, f3, f4));
        float f5 = (float) round;
        float f6 = (f3 - f) / f5;
        float f7 = (f4 - f2) / f5;
        for (int i2 = 0; i2 < round; i2++) {
            float f8 = (float) i2;
            int round2 = MathUtils.round((f8 * f6) + f);
            int round3 = MathUtils.round((f8 * f7) + f2);
            if (this.image.get(round2, round3)) {
                return new ResultPoint((float) round2, (float) round3);
            }
        }
        return null;
    }

    public ResultPoint[] detect() throws NotFoundException {
        int i2 = this.leftInit;
        int i3 = this.rightInit;
        int i4 = this.upInit;
        int i5 = this.downInit;
        boolean z = false;
        int i6 = 1;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        while (true) {
            if (!z2) {
                break;
            }
            boolean z8 = true;
            boolean z9 = false;
            while (true) {
                if ((z8 || !z3) && i3 < this.width) {
                    z8 = containsBlackPoint(i4, i5, i3, false);
                    if (z8) {
                        i3++;
                        z3 = true;
                        z9 = true;
                    } else if (!z3) {
                        i3++;
                    }
                }
            }
            if (i3 >= this.width) {
                break;
            }
            boolean z10 = true;
            while (true) {
                if ((z10 || !z4) && i5 < this.height) {
                    z10 = containsBlackPoint(i2, i3, i5, true);
                    if (z10) {
                        i5++;
                        z4 = true;
                        z9 = true;
                    } else if (!z4) {
                        i5++;
                    }
                }
            }
            if (i5 >= this.height) {
                break;
            }
            boolean z11 = true;
            while (true) {
                if ((z11 || !z5) && i2 >= 0) {
                    z11 = containsBlackPoint(i4, i5, i2, false);
                    if (z11) {
                        i2--;
                        z5 = true;
                        z9 = true;
                    } else if (!z5) {
                        i2--;
                    }
                }
            }
            if (i2 < 0) {
                break;
            }
            z2 = z9;
            boolean z12 = true;
            while (true) {
                if ((z12 || !z7) && i4 >= 0) {
                    z12 = containsBlackPoint(i2, i3, i4, true);
                    if (z12) {
                        i4--;
                        z2 = true;
                        z7 = true;
                    } else if (!z7) {
                        i4--;
                    }
                }
            }
            if (i4 < 0) {
                break;
            } else if (z2) {
                z6 = true;
            }
        }
        z = true;
        if (z || !z6) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i7 = i3 - i2;
        ResultPoint resultPoint = null;
        ResultPoint resultPoint2 = null;
        int i8 = 1;
        while (resultPoint2 == null && i8 < i7) {
            resultPoint2 = getBlackPointOnSegment((float) i2, (float) (i5 - i8), (float) (i2 + i8), (float) i5);
            i8++;
        }
        if (resultPoint2 != null) {
            ResultPoint resultPoint3 = null;
            int i9 = 1;
            while (resultPoint3 == null && i9 < i7) {
                resultPoint3 = getBlackPointOnSegment((float) i2, (float) (i4 + i9), (float) (i2 + i9), (float) i4);
                i9++;
            }
            if (resultPoint3 != null) {
                ResultPoint resultPoint4 = null;
                int i10 = 1;
                while (resultPoint4 == null && i10 < i7) {
                    resultPoint4 = getBlackPointOnSegment((float) i3, (float) (i4 + i10), (float) (i3 - i10), (float) i4);
                    i10++;
                }
                if (resultPoint4 != null) {
                    while (resultPoint == null && i6 < i7) {
                        resultPoint = getBlackPointOnSegment((float) i3, (float) (i5 - i6), (float) (i3 - i6), (float) i5);
                        i6++;
                    }
                    if (resultPoint != null) {
                        return centerEdges(resultPoint, resultPoint2, resultPoint4, resultPoint3);
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
                throw NotFoundException.getNotFoundInstance();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public WhiteRectangleDetector(BitMatrix bitMatrix, int i2, int i3, int i4) throws NotFoundException {
        this.image = bitMatrix;
        this.height = bitMatrix.getHeight();
        int width2 = bitMatrix.getWidth();
        this.width = width2;
        int i5 = i2 / 2;
        int i6 = i3 - i5;
        this.leftInit = i6;
        int i7 = i3 + i5;
        this.rightInit = i7;
        int i8 = i4 - i5;
        this.upInit = i8;
        int i9 = i4 + i5;
        this.downInit = i9;
        if (i8 < 0 || i6 < 0 || i9 >= this.height || i7 >= width2) {
            throw NotFoundException.getNotFoundInstance();
        }
    }
}
