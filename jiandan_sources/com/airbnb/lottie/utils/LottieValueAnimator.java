package com.airbnb.lottie.utils;

import android.view.Choreographer;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import fe.qw.qw.ad;
import fe.qw.qw.de;
import fe.qw.qw.ggg.qw;
import fe.qw.qw.ggg.th;

public class LottieValueAnimator extends qw implements Choreographer.FrameCallback {
    @Nullable
    public de composition;
    public float frame = 0.0f;
    public long lastFrameTimeNs = 0;
    public float maxFrame = 2.14748365E9f;
    public float minFrame = -2.14748365E9f;
    public int repeatCount = 0;
    @VisibleForTesting
    public boolean running = false;
    public float speed = 1.0f;
    public boolean speedReversedForRepeatMode = false;

    private float getFrameDurationNs() {
        de deVar = this.composition;
        if (deVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / deVar.uk()) / Math.abs(this.speed);
    }

    private boolean isReversed() {
        return getSpeed() < 0.0f;
    }

    private void verifyFrame() {
        if (this.composition != null) {
            float f = this.frame;
            if (f < this.minFrame || f > this.maxFrame) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", new Object[]{Float.valueOf(this.minFrame), Float.valueOf(this.maxFrame), Float.valueOf(this.frame)}));
            }
        }
    }

    @MainThread
    public void cancel() {
        notifyCancel();
        removeFrameCallback();
    }

    public void clearComposition() {
        this.composition = null;
        this.minFrame = -2.14748365E9f;
        this.maxFrame = 2.14748365E9f;
    }

    public void doFrame(long j) {
        postFrameCallback();
        if (this.composition != null && isRunning()) {
            ad.qw("LottieValueAnimator#doFrame");
            long j2 = this.lastFrameTimeNs;
            long j3 = 0;
            if (j2 != 0) {
                j3 = j - j2;
            }
            float frameDurationNs = ((float) j3) / getFrameDurationNs();
            float f = this.frame;
            if (isReversed()) {
                frameDurationNs = -frameDurationNs;
            }
            float f2 = f + frameDurationNs;
            this.frame = f2;
            boolean z = !th.rg(f2, getMinFrame(), getMaxFrame());
            this.frame = th.de(this.frame, getMinFrame(), getMaxFrame());
            this.lastFrameTimeNs = j;
            notifyUpdate();
            if (z) {
                if (getRepeatCount() == -1 || this.repeatCount < getRepeatCount()) {
                    notifyRepeat();
                    this.repeatCount++;
                    if (getRepeatMode() == 2) {
                        this.speedReversedForRepeatMode = !this.speedReversedForRepeatMode;
                        reverseAnimationSpeed();
                    } else {
                        this.frame = isReversed() ? getMaxFrame() : getMinFrame();
                    }
                    this.lastFrameTimeNs = j;
                } else {
                    this.frame = this.speed < 0.0f ? getMinFrame() : getMaxFrame();
                    removeFrameCallback();
                    notifyEnd(isReversed());
                }
            }
            verifyFrame();
            ad.ad("LottieValueAnimator#doFrame");
        }
    }

    @MainThread
    public void endAnimation() {
        removeFrameCallback();
        notifyEnd(isReversed());
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getAnimatedFraction() {
        float minFrame2;
        float maxFrame2;
        float minFrame3;
        if (this.composition == null) {
            return 0.0f;
        }
        if (isReversed()) {
            minFrame2 = getMaxFrame() - this.frame;
            maxFrame2 = getMaxFrame();
            minFrame3 = getMinFrame();
        } else {
            minFrame2 = this.frame - getMinFrame();
            maxFrame2 = getMaxFrame();
            minFrame3 = getMinFrame();
        }
        return minFrame2 / (maxFrame2 - minFrame3);
    }

    public Object getAnimatedValue() {
        return Float.valueOf(getAnimatedValueAbsolute());
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getAnimatedValueAbsolute() {
        de deVar = this.composition;
        if (deVar == null) {
            return 0.0f;
        }
        return (this.frame - deVar.ppp()) / (this.composition.th() - this.composition.ppp());
    }

    public long getDuration() {
        de deVar = this.composition;
        if (deVar == null) {
            return 0;
        }
        return (long) deVar.fe();
    }

    public float getFrame() {
        return this.frame;
    }

    public float getMaxFrame() {
        de deVar = this.composition;
        if (deVar == null) {
            return 0.0f;
        }
        float f = this.maxFrame;
        return f == 2.14748365E9f ? deVar.th() : f;
    }

    public float getMinFrame() {
        de deVar = this.composition;
        if (deVar == null) {
            return 0.0f;
        }
        float f = this.minFrame;
        return f == -2.14748365E9f ? deVar.ppp() : f;
    }

    public float getSpeed() {
        return this.speed;
    }

    public boolean isRunning() {
        return this.running;
    }

    @MainThread
    public void pauseAnimation() {
        removeFrameCallback();
    }

    @MainThread
    public void playAnimation() {
        this.running = true;
        notifyStart(isReversed());
        setFrame((float) ((int) (isReversed() ? getMaxFrame() : getMinFrame())));
        this.lastFrameTimeNs = 0;
        this.repeatCount = 0;
        postFrameCallback();
    }

    public void postFrameCallback() {
        if (isRunning()) {
            removeFrameCallback(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @MainThread
    public void removeFrameCallback() {
        removeFrameCallback(true);
    }

    @MainThread
    public void resumeAnimation() {
        this.running = true;
        postFrameCallback();
        this.lastFrameTimeNs = 0;
        if (isReversed() && getFrame() == getMinFrame()) {
            this.frame = getMaxFrame();
        } else if (!isReversed() && getFrame() == getMaxFrame()) {
            this.frame = getMinFrame();
        }
    }

    public void reverseAnimationSpeed() {
        setSpeed(-getSpeed());
    }

    public void setComposition(de deVar) {
        boolean z = this.composition == null;
        this.composition = deVar;
        if (z) {
            setMinAndMaxFrames((float) ((int) Math.max(this.minFrame, deVar.ppp())), (float) ((int) Math.min(this.maxFrame, deVar.th())));
        } else {
            setMinAndMaxFrames((float) ((int) deVar.ppp()), (float) ((int) deVar.th()));
        }
        float f = this.frame;
        this.frame = 0.0f;
        setFrame((float) ((int) f));
        notifyUpdate();
    }

    public void setFrame(float f) {
        if (this.frame != f) {
            this.frame = th.de(f, getMinFrame(), getMaxFrame());
            this.lastFrameTimeNs = 0;
            notifyUpdate();
        }
    }

    public void setMaxFrame(float f) {
        setMinAndMaxFrames(this.minFrame, f);
    }

    public void setMinAndMaxFrames(float f, float f2) {
        if (f <= f2) {
            de deVar = this.composition;
            float ppp = deVar == null ? -3.4028235E38f : deVar.ppp();
            de deVar2 = this.composition;
            float th2 = deVar2 == null ? Float.MAX_VALUE : deVar2.th();
            this.minFrame = th.de(f, ppp, th2);
            this.maxFrame = th.de(f2, ppp, th2);
            setFrame((float) ((int) th.de(this.frame, f, f2)));
            return;
        }
        throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", new Object[]{Float.valueOf(f), Float.valueOf(f2)}));
    }

    public void setMinFrame(int i2) {
        setMinAndMaxFrames((float) i2, (float) ((int) this.maxFrame));
    }

    public void setRepeatMode(int i2) {
        super.setRepeatMode(i2);
        if (i2 != 2 && this.speedReversedForRepeatMode) {
            this.speedReversedForRepeatMode = false;
            reverseAnimationSpeed();
        }
    }

    public void setSpeed(float f) {
        this.speed = f;
    }

    @MainThread
    public void removeFrameCallback(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.running = false;
        }
    }
}
