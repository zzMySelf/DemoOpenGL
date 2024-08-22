package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;

public interface DrawingContent extends Content {
    void rg(RectF rectF, Matrix matrix, boolean z);

    void yj(Canvas canvas, Matrix matrix, int i2);
}
