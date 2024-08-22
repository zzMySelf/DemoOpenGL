package com.baidu.talos.core.render.animation;

import android.animation.ArgbEvaluator;
import android.animation.TypeEvaluator;

public class TLSArgbEvaluator implements TypeEvaluator {
    private static final TLSArgbEvaluator INSTANCE = new TLSArgbEvaluator();

    public static TLSArgbEvaluator getInstance() {
        return INSTANCE;
    }

    public Object evaluate(float fraction, Object startValue, Object endValue) {
        int startInt = 0;
        if (startValue instanceof Float) {
            startInt = Integer.valueOf(Math.round(((Float) startValue).floatValue()));
        } else if (startValue instanceof Integer) {
            startInt = (Integer) startValue;
        }
        int endInt = 0;
        if (endValue instanceof Float) {
            endInt = Integer.valueOf(Math.round(((Float) endValue).floatValue()));
        } else if (endValue instanceof Integer) {
            endInt = (Integer) endValue;
        }
        return new ArgbEvaluator().evaluate(fraction, startInt, endInt);
    }
}
