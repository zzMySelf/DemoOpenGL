package androidx.constraintlayout.motion.utils;

import java.lang.reflect.Array;

public class MonotonicCurveFit extends CurveFit {
    private static final String TAG = "MonotonicCurveFit";
    private double[] mT;
    private double[][] mTangent;
    private double[][] mY;

    public MonotonicCurveFit(double[] time, double[][] y) {
        double[] dArr = time;
        double[][] dArr2 = y;
        int N = dArr.length;
        int dim = dArr2[0].length;
        int[] iArr = new int[2];
        iArr[1] = dim;
        iArr[0] = N - 1;
        double[][] slope = (double[][]) Array.newInstance(Double.TYPE, iArr);
        int[] iArr2 = new int[2];
        iArr2[1] = dim;
        iArr2[0] = N;
        double[][] tangent = (double[][]) Array.newInstance(Double.TYPE, iArr2);
        for (int j2 = 0; j2 < dim; j2++) {
            for (int i2 = 0; i2 < N - 1; i2++) {
                slope[i2][j2] = (dArr2[i2 + 1][j2] - dArr2[i2][j2]) / (dArr[i2 + 1] - dArr[i2]);
                if (i2 == 0) {
                    tangent[i2][j2] = slope[i2][j2];
                } else {
                    tangent[i2][j2] = (slope[i2 - 1][j2] + slope[i2][j2]) * 0.5d;
                }
            }
            tangent[N - 1][j2] = slope[N - 2][j2];
        }
        for (int i3 = 0; i3 < N - 1; i3++) {
            for (int j3 = 0; j3 < dim; j3++) {
                if (slope[i3][j3] == 0.0d) {
                    tangent[i3][j3] = 0.0d;
                    tangent[i3 + 1][j3] = 0.0d;
                } else {
                    double a2 = tangent[i3][j3] / slope[i3][j3];
                    double b2 = tangent[i3 + 1][j3] / slope[i3][j3];
                    double h2 = Math.hypot(a2, b2);
                    if (h2 > 9.0d) {
                        double t = 3.0d / h2;
                        tangent[i3][j3] = t * a2 * slope[i3][j3];
                        tangent[i3 + 1][j3] = t * b2 * slope[i3][j3];
                    }
                }
            }
        }
        this.mT = dArr;
        this.mY = dArr2;
        this.mTangent = tangent;
    }

    public void getPos(double t, double[] v) {
        double[] dArr = this.mT;
        int n = dArr.length;
        int dim = this.mY[0].length;
        if (t <= dArr[0]) {
            for (int j2 = 0; j2 < dim; j2++) {
                v[j2] = this.mY[0][j2];
            }
        } else if (t >= dArr[n - 1]) {
            for (int j3 = 0; j3 < dim; j3++) {
                v[j3] = this.mY[n - 1][j3];
            }
        } else {
            for (int i2 = 0; i2 < n - 1; i2++) {
                if (t == this.mT[i2]) {
                    for (int j4 = 0; j4 < dim; j4++) {
                        v[j4] = this.mY[i2][j4];
                    }
                }
                double[] dArr2 = this.mT;
                if (t < dArr2[i2 + 1]) {
                    double d2 = dArr2[i2 + 1];
                    double d3 = dArr2[i2];
                    double h2 = d2 - d3;
                    double x = (t - d3) / h2;
                    for (int j5 = 0; j5 < dim; j5++) {
                        double[][] dArr3 = this.mY;
                        double y1 = dArr3[i2][j5];
                        double y2 = dArr3[i2 + 1][j5];
                        double[][] dArr4 = this.mTangent;
                        v[j5] = interpolate(h2, x, y1, y2, dArr4[i2][j5], dArr4[i2 + 1][j5]);
                    }
                    return;
                }
            }
        }
    }

    public void getPos(double t, float[] v) {
        double[] dArr = this.mT;
        int n = dArr.length;
        int dim = this.mY[0].length;
        if (t <= dArr[0]) {
            for (int j2 = 0; j2 < dim; j2++) {
                v[j2] = (float) this.mY[0][j2];
            }
        } else if (t >= dArr[n - 1]) {
            for (int j3 = 0; j3 < dim; j3++) {
                v[j3] = (float) this.mY[n - 1][j3];
            }
        } else {
            for (int i2 = 0; i2 < n - 1; i2++) {
                if (t == this.mT[i2]) {
                    for (int j4 = 0; j4 < dim; j4++) {
                        v[j4] = (float) this.mY[i2][j4];
                    }
                }
                double[] dArr2 = this.mT;
                if (t < dArr2[i2 + 1]) {
                    double d2 = dArr2[i2 + 1];
                    double d3 = dArr2[i2];
                    double h2 = d2 - d3;
                    double x = (t - d3) / h2;
                    for (int j5 = 0; j5 < dim; j5++) {
                        double[][] dArr3 = this.mY;
                        double y1 = dArr3[i2][j5];
                        double y2 = dArr3[i2 + 1][j5];
                        double[][] dArr4 = this.mTangent;
                        v[j5] = (float) interpolate(h2, x, y1, y2, dArr4[i2][j5], dArr4[i2 + 1][j5]);
                    }
                    return;
                }
            }
        }
    }

    public double getPos(double t, int j2) {
        double[] dArr = this.mT;
        int n = dArr.length;
        if (t <= dArr[0]) {
            return this.mY[0][j2];
        }
        if (t >= dArr[n - 1]) {
            return this.mY[n - 1][j2];
        }
        for (int i2 = 0; i2 < n - 1; i2++) {
            double[] dArr2 = this.mT;
            double d2 = dArr2[i2];
            if (t == d2) {
                return this.mY[i2][j2];
            }
            if (t < dArr2[i2 + 1]) {
                double h2 = dArr2[i2 + 1] - d2;
                double[][] dArr3 = this.mY;
                double y1 = dArr3[i2][j2];
                double y2 = dArr3[i2 + 1][j2];
                double[][] dArr4 = this.mTangent;
                return interpolate(h2, (t - d2) / h2, y1, y2, dArr4[i2][j2], dArr4[i2 + 1][j2]);
            }
        }
        return 0.0d;
    }

    public void getSlope(double t, double[] v) {
        double t2;
        double[] dArr = this.mT;
        int n = dArr.length;
        int dim = this.mY[0].length;
        if (t <= dArr[0]) {
            t2 = dArr[0];
        } else if (t >= dArr[n - 1]) {
            t2 = dArr[n - 1];
        } else {
            t2 = t;
        }
        for (int i2 = 0; i2 < n - 1; i2++) {
            double[] dArr2 = this.mT;
            if (t2 <= dArr2[i2 + 1]) {
                double d2 = dArr2[i2 + 1];
                double d3 = dArr2[i2];
                double h2 = d2 - d3;
                double x = (t2 - d3) / h2;
                for (int j2 = 0; j2 < dim; j2++) {
                    double[][] dArr3 = this.mY;
                    double y1 = dArr3[i2][j2];
                    double y2 = dArr3[i2 + 1][j2];
                    double[][] dArr4 = this.mTangent;
                    v[j2] = diff(h2, x, y1, y2, dArr4[i2][j2], dArr4[i2 + 1][j2]) / h2;
                }
                return;
            }
        }
    }

    public double getSlope(double t, int j2) {
        double t2;
        double[] dArr = this.mT;
        int n = dArr.length;
        if (t < dArr[0]) {
            t2 = dArr[0];
        } else if (t >= dArr[n - 1]) {
            t2 = dArr[n - 1];
        } else {
            t2 = t;
        }
        for (int i2 = 0; i2 < n - 1; i2++) {
            double[] dArr2 = this.mT;
            if (t2 <= dArr2[i2 + 1]) {
                double d2 = dArr2[i2 + 1];
                double d3 = dArr2[i2];
                double h2 = d2 - d3;
                double[][] dArr3 = this.mY;
                double y1 = dArr3[i2][j2];
                double y2 = dArr3[i2 + 1][j2];
                double[][] dArr4 = this.mTangent;
                return diff(h2, (t2 - d3) / h2, y1, y2, dArr4[i2][j2], dArr4[i2 + 1][j2]) / h2;
            }
        }
        return 0.0d;
    }

    public double[] getTimePoints() {
        return this.mT;
    }

    private static double interpolate(double h2, double x, double y1, double y2, double t1, double t2) {
        double x2 = x * x;
        double x3 = x2 * x;
        return ((((((((((-2.0d * x3) * y2) + ((x2 * 3.0d) * y2)) + ((x3 * 2.0d) * y1)) - ((3.0d * x2) * y1)) + y1) + ((h2 * t2) * x3)) + ((h2 * t1) * x3)) - ((h2 * t2) * x2)) - (((h2 * 2.0d) * t1) * x2)) + (h2 * t1 * x);
    }

    private static double diff(double h2, double x, double y1, double y2, double t1, double t2) {
        double x2 = x * x;
        return (((((((((-6.0d * x2) * y2) + ((x * 6.0d) * y2)) + ((x2 * 6.0d) * y1)) - ((6.0d * x) * y1)) + (((h2 * 3.0d) * t2) * x2)) + (((3.0d * h2) * t1) * x2)) - (((2.0d * h2) * t2) * x)) - (((4.0d * h2) * t1) * x)) + (h2 * t1);
    }
}
