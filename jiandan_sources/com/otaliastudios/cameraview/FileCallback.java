package com.otaliastudios.cameraview;

import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import java.io.File;

public interface FileCallback {
    @UiThread
    void qw(@Nullable File file);
}
