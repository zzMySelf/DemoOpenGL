package com.otaliastudios.cameraview.preview;

import android.graphics.SurfaceTexture;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.filter.Filter;

public interface RendererFrameCallback {
    void fe(int i2);

    void qw(@NonNull SurfaceTexture surfaceTexture, int i2, float f, float f2);

    void th(@NonNull Filter filter);
}
