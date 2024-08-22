package com.otaliastudios.cameraview.frame;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import fe.vvv.qw.o.qw;

public interface FrameProcessor {
    @WorkerThread
    void process(@NonNull qw qwVar);
}
