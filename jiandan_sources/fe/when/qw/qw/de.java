package fe.when.qw.qw;

import com.itextpdf.awt.geom.Shape;

public abstract class de implements Shape, Cloneable {
    public static boolean th(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        double d9 = d3 - d;
        double d10 = d4 - d2;
        double d11 = d5 - d;
        double d12 = d6 - d2;
        double d13 = d7 - d;
        double d14 = d8 - d2;
        double d15 = (d9 * d12) - (d11 * d10);
        double d16 = (d9 * d14) - (d13 * d10);
        if (d15 == 0.0d && d16 == 0.0d) {
            int i2 = (d9 > 0.0d ? 1 : (d9 == 0.0d ? 0 : -1));
            if (i2 == 0) {
                int i3 = (d10 > 0.0d ? 1 : (d10 == 0.0d ? 0 : -1));
                if (i3 == 0) {
                    return false;
                }
                if (d14 * d12 <= 0.0d) {
                    return true;
                }
                if (d12 * d10 >= 0.0d) {
                    if (i3 > 0) {
                        if (d12 <= d10 || d14 <= d10) {
                            return true;
                        }
                    } else if (d12 >= d10 || d14 >= d10) {
                        return true;
                    }
                }
                return false;
            } else if (d13 * d11 <= 0.0d) {
                return true;
            } else {
                if (d11 * d9 >= 0.0d) {
                    if (i2 > 0) {
                        if (d11 <= d9 || d13 <= d9) {
                            return true;
                        }
                    } else if (d11 >= d9 || d13 >= d9) {
                        return true;
                    }
                }
                return false;
            }
        } else {
            double d17 = (d11 * d14) - (d13 * d12);
            return d15 * d16 <= 0.0d && d17 * ((d15 + d17) - d16) <= 0.0d;
        }
    }

    public abstract double ad();

    public abstract double de();

    public abstract double fe();

    public abstract double rg();
}
