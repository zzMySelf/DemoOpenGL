package com.otaliastudios.cameraview.engine.action;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
public interface ActionHolder {
    void ggg(@NonNull Action action);

    void i(@NonNull Action action);

    @Nullable
    /* renamed from: if  reason: not valid java name */
    TotalCaptureResult m714if(@NonNull Action action);

    void o(@NonNull Action action, @NonNull CaptureRequest.Builder builder) throws CameraAccessException;

    void pf(@NonNull Action action);

    @NonNull
    CaptureRequest.Builder rg(@NonNull Action action);

    @NonNull
    CameraCharacteristics uk(@NonNull Action action);
}
