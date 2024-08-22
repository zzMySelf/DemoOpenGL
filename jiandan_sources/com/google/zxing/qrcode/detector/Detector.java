package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.PerspectiveTransform;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.qrcode.decoder.Version;
import java.util.Map;

public class Detector {
    public final BitMatrix image;
    public ResultPointCallback resultPointCallback;

    public Detector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
    }

    private float calculateModuleSizeOneWay(ResultPoint resultPoint, ResultPoint resultPoint2) {
        float sizeOfBlackWhiteBlackRunBothWays = sizeOfBlackWhiteBlackRunBothWays((int) resultPoint.getX(), (int) resultPoint.getY(), (int) resultPoint2.getX(), (int) resultPoint2.getY());
        float sizeOfBlackWhiteBlackRunBothWays2 = sizeOfBlackWhiteBlackRunBothWays((int) resultPoint2.getX(), (int) resultPoint2.getY(), (int) resultPoint.getX(), (int) resultPoint.getY());
        if (Float.isNaN(sizeOfBlackWhiteBlackRunBothWays)) {
            return sizeOfBlackWhiteBlackRunBothWays2 / 7.0f;
        }
        return Float.isNaN(sizeOfBlackWhiteBlackRunBothWays2) ? sizeOfBlackWhiteBlackRunBothWays / 7.0f : (sizeOfBlackWhiteBlackRunBothWays + sizeOfBlackWhiteBlackRunBothWays2) / 14.0f;
    }

    public static int computeDimension(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, float f) throws NotFoundException {
        int round = ((MathUtils.round(ResultPoint.distance(resultPoint, resultPoint2) / f) + MathUtils.round(ResultPoint.distance(resultPoint, resultPoint3) / f)) / 2) + 7;
        int i2 = round & 3;
        if (i2 == 0) {
            return round + 1;
        }
        if (i2 == 2) {
            return round - 1;
        }
        if (i2 != 3) {
            return round;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static PerspectiveTransform createTransform(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i2) {
        float f;
        float f2;
        float f3;
        float f4 = ((float) i2) - 3.5f;
        if (resultPoint4 != null) {
            f2 = resultPoint4.getX();
            f = resultPoint4.getY();
            f3 = f4 - 3.0f;
        } else {
            f2 = (resultPoint2.getX() - resultPoint.getX()) + resultPoint3.getX();
            f = (resultPoint2.getY() - resultPoint.getY()) + resultPoint3.getY();
            f3 = f4;
        }
        return PerspectiveTransform.quadrilateralToQuadrilateral(3.5f, 3.5f, f4, 3.5f, f3, f3, 3.5f, f4, resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY(), f2, f, resultPoint3.getX(), resultPoint3.getY());
    }

    public static BitMatrix sampleGrid(BitMatrix bitMatrix, PerspectiveTransform perspectiveTransform, int i2) throws NotFoundException {
        return GridSampler.getInstance().sampleGrid(bitMatrix, i2, i2, perspectiveTransform);
    }

    private float sizeOfBlackWhiteBlackRun(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z;
        Detector detector;
        boolean z2;
        int i11 = 1;
        boolean z3 = Math.abs(i5 - i3) > Math.abs(i4 - i2);
        if (z3) {
            i8 = i2;
            i9 = i3;
            i6 = i4;
            i7 = i5;
        } else {
            i9 = i2;
            i8 = i3;
            i7 = i4;
            i6 = i5;
        }
        int abs = Math.abs(i7 - i9);
        int abs2 = Math.abs(i6 - i8);
        int i12 = (-abs) / 2;
        int i13 = -1;
        int i14 = i9 < i7 ? 1 : -1;
        if (i8 < i6) {
            i13 = 1;
        }
        int i15 = i7 + i14;
        int i16 = i9;
        int i17 = i8;
        int i18 = 0;
        while (true) {
            if (i16 == i15) {
                i10 = i15;
                break;
            }
            int i19 = z3 ? i17 : i16;
            int i20 = z3 ? i16 : i17;
            if (i18 == i11) {
                detector = this;
                z = z3;
                i10 = i15;
                z2 = true;
            } else {
                detector = this;
                z = z3;
                i10 = i15;
                z2 = false;
            }
            if (z2 == detector.image.get(i19, i20)) {
                if (i18 == 2) {
                    return MathUtils.distance(i16, i17, i9, i8);
                }
                i18++;
            }
            i12 += abs2;
            if (i12 > 0) {
                if (i17 == i6) {
                    break;
                }
                i17 += i13;
                i12 -= abs;
            }
            i16 += i14;
            i15 = i10;
            z3 = z;
            i11 = 1;
        }
        if (i18 == 2) {
            return MathUtils.distance(i10, i6, i9, i8);
        }
        return Float.NaN;
    }

    private float sizeOfBlackWhiteBlackRunBothWays(int i2, int i3, int i4, int i5) {
        float f;
        float f2;
        float sizeOfBlackWhiteBlackRun = sizeOfBlackWhiteBlackRun(i2, i3, i4, i5);
        int i6 = i2 - (i4 - i2);
        int i7 = 0;
        if (i6 < 0) {
            f = ((float) i2) / ((float) (i2 - i6));
            i6 = 0;
        } else if (i6 >= this.image.getWidth()) {
            f = ((float) ((this.image.getWidth() - 1) - i2)) / ((float) (i6 - i2));
            i6 = this.image.getWidth() - 1;
        } else {
            f = 1.0f;
        }
        float f3 = (float) i3;
        int i8 = (int) (f3 - (((float) (i5 - i3)) * f));
        if (i8 < 0) {
            f2 = f3 / ((float) (i3 - i8));
        } else if (i8 >= this.image.getHeight()) {
            f2 = ((float) ((this.image.getHeight() - 1) - i3)) / ((float) (i8 - i3));
            i7 = this.image.getHeight() - 1;
        } else {
            i7 = i8;
            f2 = 1.0f;
        }
        return (sizeOfBlackWhiteBlackRun + sizeOfBlackWhiteBlackRun(i2, i3, (int) (((float) i2) + (((float) (i6 - i2)) * f2)), i7)) - 1.0f;
    }

    public final float calculateModuleSize(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3) {
        return (calculateModuleSizeOneWay(resultPoint, resultPoint2) + calculateModuleSizeOneWay(resultPoint, resultPoint3)) / 2.0f;
    }

    public DetectorResult detect() throws NotFoundException, FormatException {
        return detect((Map<DecodeHintType, ?>) null);
    }

    public final AlignmentPattern findAlignmentInRegion(float f, int i2, int i3, float f2) throws NotFoundException {
        int i4 = (int) (f2 * f);
        int max = Math.max(0, i2 - i4);
        int min = Math.min(this.image.getWidth() - 1, i2 + i4) - max;
        float f3 = 3.0f * f;
        if (((float) min) >= f3) {
            int max2 = Math.max(0, i3 - i4);
            int min2 = Math.min(this.image.getHeight() - 1, i3 + i4) - max2;
            if (((float) min2) >= f3) {
                return new AlignmentPatternFinder(this.image, max, max2, min, min2, f, this.resultPointCallback).find();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final BitMatrix getImage() {
        return this.image;
    }

    public final ResultPointCallback getResultPointCallback() {
        return this.resultPointCallback;
    }

    public final DetectorResult processFinderPatternInfo(FinderPatternInfo finderPatternInfo) throws NotFoundException, FormatException {
        ResultPoint[] resultPointArr;
        FinderPattern topLeft = finderPatternInfo.getTopLeft();
        FinderPattern topRight = finderPatternInfo.getTopRight();
        FinderPattern bottomLeft = finderPatternInfo.getBottomLeft();
        float calculateModuleSize = calculateModuleSize(topLeft, topRight, bottomLeft);
        if (calculateModuleSize >= 1.0f) {
            int computeDimension = computeDimension(topLeft, topRight, bottomLeft, calculateModuleSize);
            Version provisionalVersionForDimension = Version.getProvisionalVersionForDimension(computeDimension);
            int dimensionForVersion = provisionalVersionForDimension.getDimensionForVersion() - 7;
            AlignmentPattern alignmentPattern = null;
            if (provisionalVersionForDimension.getAlignmentPatternCenters().length > 0) {
                float x = (topRight.getX() - topLeft.getX()) + bottomLeft.getX();
                float y = (topRight.getY() - topLeft.getY()) + bottomLeft.getY();
                float f = 1.0f - (3.0f / ((float) dimensionForVersion));
                int x2 = (int) (topLeft.getX() + ((x - topLeft.getX()) * f));
                int y2 = (int) (topLeft.getY() + (f * (y - topLeft.getY())));
                int i2 = 4;
                while (true) {
                    if (i2 > 16) {
                        break;
                    }
                    try {
                        alignmentPattern = findAlignmentInRegion(calculateModuleSize, x2, y2, (float) i2);
                        break;
                    } catch (NotFoundException unused) {
                        i2 <<= 1;
                    }
                }
            }
            BitMatrix sampleGrid = sampleGrid(this.image, createTransform(topLeft, topRight, bottomLeft, alignmentPattern, computeDimension), computeDimension);
            if (alignmentPattern == null) {
                resultPointArr = new ResultPoint[]{bottomLeft, topLeft, topRight};
            } else {
                resultPointArr = new ResultPoint[]{bottomLeft, topLeft, topRight, alignmentPattern};
            }
            return new DetectorResult(sampleGrid, resultPointArr);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final DetectorResult detect(Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        ResultPointCallback resultPointCallback2;
        if (map == null) {
            resultPointCallback2 = null;
        } else {
            resultPointCallback2 = (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        }
        this.resultPointCallback = resultPointCallback2;
        return processFinderPatternInfo(new FinderPatternFinder(this.image, resultPointCallback2).find(map));
    }
}
