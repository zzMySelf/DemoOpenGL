package com.temp.mario.gldraw2d.drawtarget;

import com.temp.mario.gldraw2d.egl.EGLCore;
import com.temp.mario.gldraw2d.egl.EGLSurfaceBase;
import com.temp.mario.gldraw2d.models.BufferSize;

public class TargetPBuffer extends EGLSurfaceBase {
    private BufferSize mBufferSize;

    public TargetPBuffer(EGLCore eglCore, BufferSize bufferSize) {
        super(eglCore);
        createOffscreenSurface(bufferSize.getWidth(), bufferSize.getHeight());
        this.mBufferSize = bufferSize;
    }

    public void release() {
        releaseEglSurface();
    }

    public void recreate(EGLCore newEGLCore) {
        this.mEGLCore = newEGLCore;
        createOffscreenSurface(this.mBufferSize.getWidth(), this.mBufferSize.getHeight());
    }
}
