package com.otaliastudios.cameraview.gesture;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;

public abstract class GestureFinder {
    @VisibleForTesting

    /* renamed from: ad  reason: collision with root package name */
    public Gesture f6747ad;

    /* renamed from: de  reason: collision with root package name */
    public PointF[] f6748de;
    public boolean qw;

    public interface Controller {
        @NonNull
        Context getContext();

        int getHeight();

        int getWidth();
    }

    public GestureFinder(@NonNull Controller controller, int i2) {
        this.f6748de = new PointF[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            this.f6748de[i3] = new PointF(0.0f, 0.0f);
        }
    }

    public static float qw(float f, float f2, float f3, float f4) {
        if (f2 < f3) {
            f2 = f3;
        }
        if (f2 > f4) {
            f2 = f4;
        }
        float f5 = ((f4 - f3) / 50.0f) / 2.0f;
        return (f2 < f - f5 || f2 > f5 + f) ? f2 : f;
    }

    public final float ad(float f, float f2, float f3) {
        return qw(f, th(f, f2, f3), f2, f3);
    }

    @NonNull
    public final Gesture de() {
        return this.f6747ad;
    }

    @NonNull
    public final PointF fe(int i2) {
        return this.f6748de[i2];
    }

    public void i(boolean z) {
        this.qw = z;
    }

    public final void o(Gesture gesture) {
        this.f6747ad = gesture;
    }

    @NonNull
    public final PointF[] rg() {
        return this.f6748de;
    }

    public abstract float th(float f, float f2, float f3);

    public final boolean uk(@NonNull MotionEvent motionEvent) {
        if (!this.qw) {
            return false;
        }
        return yj(motionEvent);
    }

    public abstract boolean yj(@NonNull MotionEvent motionEvent);
}
