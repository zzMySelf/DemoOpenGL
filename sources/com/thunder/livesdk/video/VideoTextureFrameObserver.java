package com.thunder.livesdk.video;

public abstract class VideoTextureFrameObserver {
    public void onInit(int textureTarget, int outputWidth, int outputHeight) {
    }

    public void onDraw(ThunderVideoFrame videoFrame) {
    }

    public void onDestroy() {
    }

    public void onOutputSizeChanged(int width, int height) {
    }
}
