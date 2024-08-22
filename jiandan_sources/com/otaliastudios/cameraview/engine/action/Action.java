package com.otaliastudios.cameraview.engine.action;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
public interface Action {
    void ad(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult);

    void de(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest);

    void fe(@NonNull ActionCallback actionCallback);

    void qw(@NonNull ActionHolder actionHolder);

    void rg(@NonNull ActionCallback actionCallback);

    void th(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult);

    void yj(@NonNull ActionHolder actionHolder);
}
