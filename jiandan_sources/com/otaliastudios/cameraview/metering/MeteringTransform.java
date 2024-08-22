package com.otaliastudios.cameraview.metering;

import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.NonNull;

public interface MeteringTransform<T> {
    @NonNull
    PointF ad(@NonNull PointF pointF);

    @NonNull
    T qw(@NonNull RectF rectF, int i2);
}
