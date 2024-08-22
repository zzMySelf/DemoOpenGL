package io.flutter.view;

import android.graphics.SurfaceTexture;
import androidx.annotation.NonNull;

public interface TextureRegistry {

    public interface SurfaceTextureEntry {
        long id();

        void release();

        SurfaceTexture surfaceTexture();
    }

    SurfaceTextureEntry createSurfaceTexture();

    SurfaceTextureEntry registerSurfaceTexture(@NonNull SurfaceTexture surfaceTexture);
}
