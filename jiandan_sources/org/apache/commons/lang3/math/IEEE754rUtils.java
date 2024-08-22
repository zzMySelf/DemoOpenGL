package org.apache.commons.lang3.math;

import org.apache.commons.lang3.Validate;

public class IEEE754rUtils {
    public static double max(double... dArr) {
        if (dArr != null) {
            Validate.isTrue(dArr.length != 0, "Array cannot be empty.", new Object[0]);
            double d = dArr[0];
            for (int i2 = 1; i2 < dArr.length; i2++) {
                d = max(dArr[i2], d);
            }
            return d;
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static double min(double... dArr) {
        if (dArr != null) {
            Validate.isTrue(dArr.length != 0, "Array cannot be empty.", new Object[0]);
            double d = dArr[0];
            for (int i2 = 1; i2 < dArr.length; i2++) {
                d = min(dArr[i2], d);
            }
            return d;
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static float max(float... fArr) {
        if (fArr != null) {
            Validate.isTrue(fArr.length != 0, "Array cannot be empty.", new Object[0]);
            float f = fArr[0];
            for (int i2 = 1; i2 < fArr.length; i2++) {
                f = max(fArr[i2], f);
            }
            return f;
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static float min(float... fArr) {
        if (fArr != null) {
            Validate.isTrue(fArr.length != 0, "Array cannot be empty.", new Object[0]);
            float f = fArr[0];
            for (int i2 = 1; i2 < fArr.length; i2++) {
                f = min(fArr[i2], f);
            }
            return f;
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static double max(double d, double d2, double d3) {
        return max(max(d, d2), d3);
    }

    public static double min(double d, double d2, double d3) {
        return min(min(d, d2), d3);
    }

    public static double max(double d, double d2) {
        if (Double.isNaN(d)) {
            return d2;
        }
        if (Double.isNaN(d2)) {
            return d;
        }
        return Math.max(d, d2);
    }

    public static double min(double d, double d2) {
        if (Double.isNaN(d)) {
            return d2;
        }
        if (Double.isNaN(d2)) {
            return d;
        }
        return Math.min(d, d2);
    }

    public static float max(float f, float f2, float f3) {
        return max(max(f, f2), f3);
    }

    public static float min(float f, float f2, float f3) {
        return min(min(f, f2), f3);
    }

    public static float max(float f, float f2) {
        if (Float.isNaN(f)) {
            return f2;
        }
        if (Float.isNaN(f2)) {
            return f;
        }
        return Math.max(f, f2);
    }

    public static float min(float f, float f2) {
        if (Float.isNaN(f)) {
            return f2;
        }
        if (Float.isNaN(f2)) {
            return f;
        }
        return Math.min(f, f2);
    }
}
