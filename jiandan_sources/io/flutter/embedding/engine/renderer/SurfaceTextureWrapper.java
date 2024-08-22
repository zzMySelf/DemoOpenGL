package io.flutter.embedding.engine.renderer;

import android.graphics.SurfaceTexture;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;

@Keep
public class SurfaceTextureWrapper {
    public boolean released = false;
    public SurfaceTexture surfaceTexture;

    public SurfaceTextureWrapper(@NonNull SurfaceTexture surfaceTexture2) {
        this.surfaceTexture = surfaceTexture2;
    }

    public void attachToGLContext(int i2) {
        synchronized (this) {
            if (!this.released) {
                this.surfaceTexture.attachToGLContext(i2);
            }
        }
    }

    public void detachFromGLContext() {
        this.surfaceTexture.detachFromGLContext();
    }

    public void getTransformMatrix(float[] fArr) {
        this.surfaceTexture.getTransformMatrix(fArr);
    }

    public void release() {
        synchronized (this) {
            if (!this.released) {
                this.surfaceTexture.release();
                this.released = true;
            }
        }
    }

    @NonNull
    public SurfaceTexture surfaceTexture() {
        return this.surfaceTexture;
    }

    public void updateTexImage() {
        synchronized (this) {
            if (!this.released) {
                this.surfaceTexture.updateTexImage();
            }
        }
    }
}
