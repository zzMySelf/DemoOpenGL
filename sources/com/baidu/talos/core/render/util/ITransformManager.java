package com.baidu.talos.core.render.util;

import android.util.Pair;

public interface ITransformManager {
    public static final ITransformManager DEFALT = new ITransformManager() {
        public Pair<Float, Float> parsePivot(String transformOrigin, float width, float height) {
            return null;
        }
    };

    Pair<Float, Float> parsePivot(String str, float f2, float f3);
}
