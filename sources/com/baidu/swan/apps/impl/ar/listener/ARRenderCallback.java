package com.baidu.swan.apps.impl.ar.listener;

import android.graphics.SurfaceTexture;

public interface ARRenderCallback {
    void onSurfaceChanged(int i2, int i3);

    void onSurfaceCreated(SurfaceTexture surfaceTexture, SurfaceTexture surfaceTexture2);
}
