package com.baidu.searchbox.talos.views.nativeanimation.interpolator;

import android.view.animation.Interpolator;

public class ElasticInterpolator implements Interpolator {
    private float t;

    public ElasticInterpolator(float t2) {
        this.t = t2;
    }

    public float getInterpolation(float bounciness) {
        return (float) (1.0d - (Math.pow(Math.cos((((double) this.t) * 3.141592653589793d) / 2.0d), 3.0d) * Math.cos(((double) this.t) * (((double) bounciness) * 3.141592653589793d))));
    }
}
