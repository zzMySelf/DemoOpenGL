package androidx.constraintlayout.motion.utils;

import java.util.Arrays;

public class ArcCurveFit extends CurveFit {
    public static final int ARC_START_FLIP = 3;
    public static final int ARC_START_HORIZONTAL = 2;
    public static final int ARC_START_LINEAR = 0;
    public static final int ARC_START_VERTICAL = 1;
    public static final int START_HORIZONTAL = 2;
    public static final int START_LINEAR = 3;
    public static final int START_VERTICAL = 1;
    public Arc[] mArcs;
    public final double[] mTime;

    public static class Arc {
        public static final double EPSILON = 0.001d;
        public static final String TAG = "Arc";
        public static double[] ourPercent = new double[91];
        public boolean linear = false;
        public double mArcDistance;
        public double mArcVelocity;
        public double mEllipseA;
        public double mEllipseB;
        public double mEllipseCenterX;
        public double mEllipseCenterY;
        public double[] mLut;
        public double mOneOverDeltaTime;
        public double mTime1;
        public double mTime2;
        public double mTmpCosAngle;
        public double mTmpSinAngle;
        public boolean mVertical;
        public double mX1;
        public double mX2;
        public double mY1;
        public double mY2;

        public Arc(int i2, double d, double d2, double d3, double d4, double d5, double d6) {
            int i3 = i2;
            double d7 = d;
            double d8 = d2;
            double d9 = d3;
            double d10 = d4;
            double d11 = d5;
            double d12 = d6;
            boolean z = false;
            this.mVertical = i3 == 1 ? true : z;
            this.mTime1 = d7;
            this.mTime2 = d8;
            this.mOneOverDeltaTime = 1.0d / (d8 - d7);
            if (3 == i3) {
                this.linear = true;
            }
            double d13 = d11 - d9;
            double d14 = d12 - d10;
            if (this.linear || Math.abs(d13) < 0.001d || Math.abs(d14) < 0.001d) {
                this.linear = true;
                this.mX1 = d9;
                this.mX2 = d11;
                this.mY1 = d10;
                this.mY2 = d12;
                double hypot = Math.hypot(d14, d13);
                this.mArcDistance = hypot;
                this.mArcVelocity = hypot * this.mOneOverDeltaTime;
                double d15 = this.mTime2;
                double d16 = this.mTime1;
                this.mEllipseCenterX = d13 / (d15 - d16);
                this.mEllipseCenterY = d14 / (d15 - d16);
                return;
            }
            this.mLut = new double[101];
            this.mEllipseA = d13 * ((double) (this.mVertical ? -1 : 1));
            this.mEllipseB = d14 * ((double) (this.mVertical ? 1 : -1));
            this.mEllipseCenterX = this.mVertical ? d11 : d9;
            this.mEllipseCenterY = this.mVertical ? d10 : d12;
            buildTable(d3, d4, d5, d6);
            this.mArcVelocity = this.mArcDistance * this.mOneOverDeltaTime;
        }

        private void buildTable(double d, double d2, double d3, double d4) {
            double d5;
            double d6 = d3 - d;
            double d7 = d2 - d4;
            int i2 = 0;
            double d8 = 0.0d;
            double d9 = 0.0d;
            double d10 = 0.0d;
            while (true) {
                double[] dArr = ourPercent;
                if (i2 >= dArr.length) {
                    break;
                }
                double d11 = d8;
                double radians = Math.toRadians((((double) i2) * 90.0d) / ((double) (dArr.length - 1)));
                double sin = Math.sin(radians) * d6;
                double cos = Math.cos(radians) * d7;
                if (i2 > 0) {
                    d5 = d11 + Math.hypot(sin - d9, cos - d10);
                    ourPercent[i2] = d5;
                } else {
                    d5 = d11;
                }
                i2++;
                d10 = cos;
                double d12 = sin;
                d8 = d5;
                d9 = d12;
            }
            double d13 = d8;
            this.mArcDistance = d13;
            int i3 = 0;
            while (true) {
                double[] dArr2 = ourPercent;
                if (i3 >= dArr2.length) {
                    break;
                }
                dArr2[i3] = dArr2[i3] / d13;
                i3++;
            }
            int i4 = 0;
            while (true) {
                double[] dArr3 = this.mLut;
                if (i4 < dArr3.length) {
                    double length = ((double) i4) / ((double) (dArr3.length - 1));
                    int binarySearch = Arrays.binarySearch(ourPercent, length);
                    if (binarySearch >= 0) {
                        this.mLut[i4] = (double) (binarySearch / (ourPercent.length - 1));
                    } else if (binarySearch == -1) {
                        this.mLut[i4] = 0.0d;
                    } else {
                        int i5 = -binarySearch;
                        int i6 = i5 - 2;
                        double[] dArr4 = ourPercent;
                        this.mLut[i4] = (((double) i6) + ((length - dArr4[i6]) / (dArr4[i5 - 1] - dArr4[i6]))) / ((double) (dArr4.length - 1));
                    }
                    i4++;
                } else {
                    return;
                }
            }
        }

        public double getDX() {
            double d = this.mEllipseA * this.mTmpCosAngle;
            double hypot = this.mArcVelocity / Math.hypot(d, (-this.mEllipseB) * this.mTmpSinAngle);
            if (this.mVertical) {
                d = -d;
            }
            return d * hypot;
        }

        public double getDY() {
            double d = this.mEllipseA * this.mTmpCosAngle;
            double d2 = (-this.mEllipseB) * this.mTmpSinAngle;
            double hypot = this.mArcVelocity / Math.hypot(d, d2);
            return this.mVertical ? (-d2) * hypot : d2 * hypot;
        }

        public double getLinearDX(double d) {
            return this.mEllipseCenterX;
        }

        public double getLinearDY(double d) {
            return this.mEllipseCenterY;
        }

        public double getLinearX(double d) {
            double d2 = (d - this.mTime1) * this.mOneOverDeltaTime;
            double d3 = this.mX1;
            return d3 + (d2 * (this.mX2 - d3));
        }

        public double getLinearY(double d) {
            double d2 = (d - this.mTime1) * this.mOneOverDeltaTime;
            double d3 = this.mY1;
            return d3 + (d2 * (this.mY2 - d3));
        }

        public double getX() {
            return this.mEllipseCenterX + (this.mEllipseA * this.mTmpSinAngle);
        }

        public double getY() {
            return this.mEllipseCenterY + (this.mEllipseB * this.mTmpCosAngle);
        }

        public double lookup(double d) {
            if (d <= 0.0d) {
                return 0.0d;
            }
            if (d >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.mLut;
            double length = d * ((double) (dArr.length - 1));
            int i2 = (int) length;
            return dArr[i2] + ((length - ((double) i2)) * (dArr[i2 + 1] - dArr[i2]));
        }

        public void setPoint(double d) {
            double lookup = lookup((this.mVertical ? this.mTime2 - d : d - this.mTime1) * this.mOneOverDeltaTime) * 1.5707963267948966d;
            this.mTmpSinAngle = Math.sin(lookup);
            this.mTmpCosAngle = Math.cos(lookup);
        }
    }

    public ArcCurveFit(int[] iArr, double[] dArr, double[][] dArr2) {
        int i2;
        double[] dArr3 = dArr;
        this.mTime = dArr3;
        this.mArcs = new Arc[(dArr3.length - 1)];
        int i3 = 0;
        int i4 = 1;
        int i5 = 1;
        while (i3 < this.mArcs.length) {
            int i6 = iArr[i3];
            if (i6 == 0) {
                i2 = 3;
            } else if (i6 == 1) {
                i4 = 1;
                i2 = 1;
            } else if (i6 == 2) {
                i4 = 2;
                i2 = 2;
            } else if (i6 != 3) {
                i2 = i5;
            } else {
                i4 = i4 == 1 ? 2 : 1;
                i2 = i4;
            }
            int i7 = i3 + 1;
            this.mArcs[i3] = new Arc(i2, dArr3[i3], dArr3[i7], dArr2[i3][0], dArr2[i3][1], dArr2[i7][0], dArr2[i7][1]);
            i5 = i2;
            i3 = i7;
        }
    }

    public void getPos(double d, double[] dArr) {
        Arc[] arcArr = this.mArcs;
        if (d < arcArr[0].mTime1) {
            d = arcArr[0].mTime1;
        }
        Arc[] arcArr2 = this.mArcs;
        if (d > arcArr2[arcArr2.length - 1].mTime2) {
            d = arcArr2[arcArr2.length - 1].mTime2;
        }
        int i2 = 0;
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i2 >= arcArr3.length) {
                return;
            }
            if (d > arcArr3[i2].mTime2) {
                i2++;
            } else if (arcArr3[i2].linear) {
                dArr[0] = arcArr3[i2].getLinearX(d);
                dArr[1] = this.mArcs[i2].getLinearY(d);
                return;
            } else {
                arcArr3[i2].setPoint(d);
                dArr[0] = this.mArcs[i2].getX();
                dArr[1] = this.mArcs[i2].getY();
                return;
            }
        }
    }

    public void getSlope(double d, double[] dArr) {
        Arc[] arcArr = this.mArcs;
        if (d < arcArr[0].mTime1) {
            d = arcArr[0].mTime1;
        } else if (d > arcArr[arcArr.length - 1].mTime2) {
            d = arcArr[arcArr.length - 1].mTime2;
        }
        int i2 = 0;
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i2 >= arcArr2.length) {
                return;
            }
            if (d > arcArr2[i2].mTime2) {
                i2++;
            } else if (arcArr2[i2].linear) {
                dArr[0] = arcArr2[i2].getLinearDX(d);
                dArr[1] = this.mArcs[i2].getLinearDY(d);
                return;
            } else {
                arcArr2[i2].setPoint(d);
                dArr[0] = this.mArcs[i2].getDX();
                dArr[1] = this.mArcs[i2].getDY();
                return;
            }
        }
    }

    public double[] getTimePoints() {
        return this.mTime;
    }

    public void getPos(double d, float[] fArr) {
        Arc[] arcArr = this.mArcs;
        if (d < arcArr[0].mTime1) {
            d = arcArr[0].mTime1;
        } else if (d > arcArr[arcArr.length - 1].mTime2) {
            d = arcArr[arcArr.length - 1].mTime2;
        }
        int i2 = 0;
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i2 >= arcArr2.length) {
                return;
            }
            if (d > arcArr2[i2].mTime2) {
                i2++;
            } else if (arcArr2[i2].linear) {
                fArr[0] = (float) arcArr2[i2].getLinearX(d);
                fArr[1] = (float) this.mArcs[i2].getLinearY(d);
                return;
            } else {
                arcArr2[i2].setPoint(d);
                fArr[0] = (float) this.mArcs[i2].getX();
                fArr[1] = (float) this.mArcs[i2].getY();
                return;
            }
        }
    }

    public double getSlope(double d, int i2) {
        Arc[] arcArr = this.mArcs;
        int i3 = 0;
        if (d < arcArr[0].mTime1) {
            d = arcArr[0].mTime1;
        }
        Arc[] arcArr2 = this.mArcs;
        if (d > arcArr2[arcArr2.length - 1].mTime2) {
            d = arcArr2[arcArr2.length - 1].mTime2;
        }
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i3 >= arcArr3.length) {
                return Double.NaN;
            }
            if (d > arcArr3[i3].mTime2) {
                i3++;
            } else if (!arcArr3[i3].linear) {
                arcArr3[i3].setPoint(d);
                if (i2 == 0) {
                    return this.mArcs[i3].getDX();
                }
                return this.mArcs[i3].getDY();
            } else if (i2 == 0) {
                return arcArr3[i3].getLinearDX(d);
            } else {
                return arcArr3[i3].getLinearDY(d);
            }
        }
    }

    public double getPos(double d, int i2) {
        Arc[] arcArr = this.mArcs;
        int i3 = 0;
        if (d < arcArr[0].mTime1) {
            d = arcArr[0].mTime1;
        } else if (d > arcArr[arcArr.length - 1].mTime2) {
            d = arcArr[arcArr.length - 1].mTime2;
        }
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i3 >= arcArr2.length) {
                return Double.NaN;
            }
            if (d > arcArr2[i3].mTime2) {
                i3++;
            } else if (!arcArr2[i3].linear) {
                arcArr2[i3].setPoint(d);
                if (i2 == 0) {
                    return this.mArcs[i3].getX();
                }
                return this.mArcs[i3].getY();
            } else if (i2 == 0) {
                return arcArr2[i3].getLinearX(d);
            } else {
                return arcArr2[i3].getLinearY(d);
            }
        }
    }
}
