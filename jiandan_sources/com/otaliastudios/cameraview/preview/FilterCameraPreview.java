package com.otaliastudios.cameraview.preview;

import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.filter.Filter;

public interface FilterCameraPreview {
    void ad(@NonNull Filter filter);

    @NonNull
    Filter de();
}
