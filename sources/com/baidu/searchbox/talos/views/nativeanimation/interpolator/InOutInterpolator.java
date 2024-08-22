package com.baidu.searchbox.talos.views.nativeanimation.interpolator;

import android.view.animation.Interpolator;

public class InOutInterpolator implements Interpolator {
    private Interpolator easing;

    public InOutInterpolator(Interpolator easing2) {
        this.easing = easing2;
    }

    public float getInterpolation(float t) {
        if (((double) t) < 0.5d) {
            return this.easing.getInterpolation(t * 2.0f) / 2.0f;
        }
        return 1.0f - (this.easing.getInterpolation((1.0f - t) * 2.0f) / 2.0f);
    }
}
