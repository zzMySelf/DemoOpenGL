package com.baidu.searchbox.aisearch.utils;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0007R\u000e\u0010\n\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/aisearch/utils/BezierInterpolator;", "Landroid/view/animation/Interpolator;", "x1", "", "y1", "x2", "y2", "accuracy", "", "(FFFFI)V", "innerAccuracy", "mControlPoint1", "Landroid/graphics/PointF;", "mControlPoint2", "mLastI", "getInterpolation", "input", "reset", "", "Companion", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BezierInterpolator.kt */
public final class BezierInterpolator implements Interpolator {
    public static final int ACCURACY = 4096;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private int innerAccuracy;
    private final PointF mControlPoint1;
    private final PointF mControlPoint2;
    private int mLastI;

    public BezierInterpolator(float x1, float y1, float x2, float y2, int accuracy) {
        this.innerAccuracy = accuracy;
        PointF pointF = new PointF();
        this.mControlPoint1 = pointF;
        PointF pointF2 = new PointF();
        this.mControlPoint2 = pointF2;
        pointF.x = x1;
        pointF.y = y1;
        pointF2.x = x2;
        pointF2.y = y2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BezierInterpolator(float f2, float f3, float f4, float f5, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(f2, f3, f4, f5, (i3 & 16) != 0 ? 4096 : i2);
    }

    public final void reset() {
        this.mLastI = 0;
    }

    public float getInterpolation(float input) {
        float t = input;
        int i2 = this.mLastI;
        int i3 = this.innerAccuracy;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            t = (((float) i2) * 1.0f) / ((float) this.innerAccuracy);
            if (Companion.cubicCurves((double) t, 0.0d, (double) this.mControlPoint1.x, (double) this.mControlPoint2.x, 1.0d) >= ((double) input)) {
                this.mLastI = i2;
                break;
            }
            i2++;
        }
        double value = Companion.cubicCurves((double) t, 0.0d, (double) this.mControlPoint1.y, (double) this.mControlPoint2.y, 1.0d);
        if (value > 0.999d) {
            value = 1.0d;
            this.mLastI = 0;
        }
        return (float) value;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/aisearch/utils/BezierInterpolator$Companion;", "", "()V", "ACCURACY", "", "cubicCurves", "", "t", "p0", "p1", "p2", "p3", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BezierInterpolator.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final double cubicCurves(double t, double p0, double p1, double p2, double p3) {
            double u = ((double) 1) - t;
            double tt = t * t;
            double uu = u * u;
            double d2 = (double) 3;
            return (uu * u * p0) + (d2 * uu * t * p1) + (d2 * u * tt * p2) + (tt * t * p3);
        }
    }
}
