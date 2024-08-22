package com.baidu.searchbox.talos.views.nativeanimation.interpolator;

import android.view.animation.Interpolator;

public class SinInterpolator implements Interpolator {
    public float getInterpolation(float input) {
        return (float) (1.0d - Math.cos((((double) input) * 3.141592653589793d) / 2.0d));
    }
}
