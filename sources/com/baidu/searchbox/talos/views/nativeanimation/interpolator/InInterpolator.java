package com.baidu.searchbox.talos.views.nativeanimation.interpolator;

import android.view.animation.Interpolator;

public class InInterpolator implements Interpolator {
    private Interpolator easing;

    public InInterpolator(Interpolator easing2) {
        this.easing = easing2;
    }

    public float getInterpolation(float input) {
        return this.easing.getInterpolation(input);
    }
}
