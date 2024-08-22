package com.otaliastudios.cameraview.markers;

import android.graphics.PointF;
import androidx.annotation.NonNull;

public interface AutoFocusMarker extends Marker {
    void de(@NonNull AutoFocusTrigger autoFocusTrigger, boolean z, @NonNull PointF pointF);

    void qw(@NonNull AutoFocusTrigger autoFocusTrigger, @NonNull PointF pointF);
}
