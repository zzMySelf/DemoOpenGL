package com.baidu.mms.voicesearch.mmsvoicesearchv2.uikit.openglkit;

import android.graphics.PointF;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003J\u0006\u0010\u0017\u001a\u00020\u0018R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/baidu/mms/voicesearch/mmsvoicesearchv2/uikit/openglkit/BezierCalculator;", "", "x1", "", "y1", "x2", "y2", "(FFFF)V", "hasReset", "", "getHasReset", "()Z", "setHasReset", "(Z)V", "mControlPoint1", "Landroid/graphics/PointF;", "mControlPoint2", "mLastI", "", "value", "", "getCalculation", "input", "reset", "", "Companion", "lib-speech-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BezierCalculator.kt */
public final class BezierCalculator {
    private static final int ACCURACY = 4096;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private boolean hasReset;
    private final PointF mControlPoint1;
    private final PointF mControlPoint2;
    private int mLastI;
    private double value;

    public BezierCalculator(float x1, float y1, float x2, float y2) {
        PointF pointF = new PointF();
        this.mControlPoint1 = pointF;
        PointF pointF2 = new PointF();
        this.mControlPoint2 = pointF2;
        pointF.x = x1;
        pointF.y = y1;
        pointF2.x = x2;
        pointF2.y = y2;
    }

    public final boolean getHasReset() {
        return this.hasReset;
    }

    public final void setHasReset(boolean z) {
        this.hasReset = z;
    }

    public final float getCalculation(float input) {
        float t = input;
        int i2 = this.mLastI;
        while (true) {
            if (i2 >= 4096) {
                break;
            }
            t = (((float) i2) * 1.0f) / ((float) 4096);
            if (Companion.cubicCurves((double) t, 0.0d, (double) this.mControlPoint1.x, (double) this.mControlPoint2.x, 1.0d) >= ((double) input)) {
                this.mLastI = i2;
                break;
            }
            i2++;
        }
        double cubicCurves = Companion.cubicCurves((double) t, 0.0d, (double) this.mControlPoint1.y, (double) this.mControlPoint2.y, 1.0d);
        this.value = cubicCurves;
        boolean z = false;
        if (cubicCurves >= 0.9999d) {
            this.value = 1.0d;
            this.mLastI = 0;
        }
        if (input > 0.95f || input < 0.05f) {
            z = true;
        }
        this.hasReset = z;
        return (float) this.value;
    }

    public final void reset() {
        this.value = 1.0d;
        this.mLastI = 0;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/baidu/mms/voicesearch/mmsvoicesearchv2/uikit/openglkit/BezierCalculator$Companion;", "", "()V", "ACCURACY", "", "cubicCurves", "", "t", "p0", "p1", "p2", "p3", "lib-speech-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BezierCalculator.kt */
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
