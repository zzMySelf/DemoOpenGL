package com.baidu.searchbox.video.widget.interpolator;

import android.graphics.PointF;
import android.view.animation.Interpolator;

public class CubicBezierInterpolator implements Interpolator {
    private static final int ACCURACY = 4096;
    private final PointF mControlPoint1;
    private final PointF mControlPoint2;
    private int mLastI = 0;

    public CubicBezierInterpolator(float x1, float y1, float x2, float y2) {
        PointF pointF = new PointF();
        this.mControlPoint1 = pointF;
        PointF pointF2 = new PointF();
        this.mControlPoint2 = pointF2;
        pointF.x = x1;
        pointF.y = y1;
        pointF2.x = x2;
        pointF2.y = y2;
    }

    public float getInterpolation(float input) {
        float t = input;
        int i2 = this.mLastI;
        while (true) {
            if (i2 >= 4096) {
                break;
            }
            t = (((float) i2) * 1.0f) / 4096.0f;
            if (cubicCurves((double) t, 0.0d, (double) this.mControlPoint1.x, (double) this.mControlPoint2.x, 1.0d) >= ((double) input)) {
                this.mLastI = i2;
                break;
            }
            i2++;
        }
        double value = cubicCurves((double) t, 0.0d, (double) this.mControlPoint1.y, (double) this.mControlPoint2.y, 1.0d);
        if (value > 0.999d) {
            value = 1.0d;
            this.mLastI = 0;
        }
        return (float) value;
    }

    private double cubicCurves(double t, double value0, double value1, double value2, double value3) {
        double u = 1.0d - t;
        double tt = t * t;
        double uu = u * u;
        return (uu * u * value0) + (uu * 3.0d * t * value1) + (3.0d * u * tt * value2) + (tt * t * value3);
    }
}
