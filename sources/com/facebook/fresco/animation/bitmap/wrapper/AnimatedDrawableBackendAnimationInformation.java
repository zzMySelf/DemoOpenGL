package com.facebook.fresco.animation.bitmap.wrapper;

import com.facebook.fresco.animation.backend.AnimationInformation;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;

public class AnimatedDrawableBackendAnimationInformation implements AnimationInformation {
    private final AnimatedDrawableBackend mAnimatedDrawableBackend;

    public AnimatedDrawableBackendAnimationInformation(AnimatedDrawableBackend animatedDrawableBackend) {
        this.mAnimatedDrawableBackend = animatedDrawableBackend;
    }

    public int getFrameCount() {
        return this.mAnimatedDrawableBackend.getFrameCount();
    }

    public int getFrameDurationMs(int frameNumber) {
        return this.mAnimatedDrawableBackend.getDurationMsForFrame(frameNumber);
    }

    public int getLoopCount() {
        return this.mAnimatedDrawableBackend.getLoopCount();
    }

    public int getLoopDurationMs() {
        return this.mAnimatedDrawableBackend.getDurationMs();
    }

    public int width() {
        return this.mAnimatedDrawableBackend.getWidth();
    }

    public int height() {
        return this.mAnimatedDrawableBackend.getHeight();
    }
}
