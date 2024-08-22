package com.facebook.fresco.animation.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.common.logging.FLog;
import com.facebook.drawable.base.DrawableWithCaches;
import com.facebook.drawee.drawable.DrawableProperties;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.frame.DropFramesFrameScheduler;
import com.facebook.fresco.animation.frame.FrameScheduler;
import javax.annotation.Nullable;

public class AnimatedDrawable2 extends Drawable implements Animatable, DrawableWithCaches {
    private static final int DEFAULT_FRAME_SCHEDULING_DELAY_MS = 8;
    private static final int DEFAULT_FRAME_SCHEDULING_OFFSET_MS = 0;
    private static final AnimationListener NO_OP_LISTENER = new BaseAnimationListener();
    private static final Class<?> TAG = AnimatedDrawable2.class;
    private final AnimationBackend.Listener animationBackendListener;
    @Nullable
    private AnimationBackend mAnimationBackend;
    private volatile AnimationListener mAnimationListener;
    @Nullable
    private volatile DrawListener mDrawListener;
    @Nullable
    private DrawableProperties mDrawableProperties;
    private int mDroppedFrames;
    private long mExpectedRenderTimeMs;
    @Nullable
    private FrameScheduler mFrameScheduler;
    private long mFrameSchedulingDelayMs;
    private long mFrameSchedulingOffsetMs;
    /* access modifiers changed from: private */
    public final Runnable mInvalidateRunnable;
    private volatile boolean mIsRunning;
    private int mLastDrawnFrameNumber;
    private long mLastFrameAnimationTimeMs;
    private int mPausedLastDrawnFrameNumber;
    private long mPausedLastFrameAnimationTimeMsDifference;
    private long mPausedStartTimeMsDifference;
    private long mStartTimeMs;

    public interface DrawListener {
        void onDraw(AnimatedDrawable2 animatedDrawable2, FrameScheduler frameScheduler, int i2, boolean z, boolean z2, long j2, long j3, long j4, long j5, long j6, long j7, long j8);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-facebook-fresco-animation-drawable-AnimatedDrawable2  reason: not valid java name */
    public /* synthetic */ void m8176lambda$new$0$comfacebookfrescoanimationdrawableAnimatedDrawable2() {
        this.mAnimationListener.onAnimationLoaded();
    }

    public AnimatedDrawable2() {
        this((AnimationBackend) null);
    }

    public AnimatedDrawable2(@Nullable AnimationBackend animationBackend) {
        this.mFrameSchedulingDelayMs = 8;
        this.mFrameSchedulingOffsetMs = 0;
        this.mAnimationListener = NO_OP_LISTENER;
        this.mDrawListener = null;
        AnimatedDrawable2$$ExternalSyntheticLambda0 animatedDrawable2$$ExternalSyntheticLambda0 = new AnimatedDrawable2$$ExternalSyntheticLambda0(this);
        this.animationBackendListener = animatedDrawable2$$ExternalSyntheticLambda0;
        this.mInvalidateRunnable = new Runnable() {
            public void run() {
                AnimatedDrawable2 animatedDrawable2 = AnimatedDrawable2.this;
                animatedDrawable2.unscheduleSelf(animatedDrawable2.mInvalidateRunnable);
                AnimatedDrawable2.this.invalidateSelf();
            }
        };
        this.mAnimationBackend = animationBackend;
        this.mFrameScheduler = createSchedulerForBackendAndDelayMethod(animationBackend);
        if (animationBackend != null) {
            animationBackend.setAnimationListener(animatedDrawable2$$ExternalSyntheticLambda0);
        }
    }

    public int getIntrinsicWidth() {
        AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend == null) {
            return super.getIntrinsicWidth();
        }
        return animationBackend.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend == null) {
            return super.getIntrinsicHeight();
        }
        return animationBackend.getIntrinsicHeight();
    }

    public void start() {
        AnimationBackend animationBackend;
        if (!this.mIsRunning && (animationBackend = this.mAnimationBackend) != null && animationBackend.getFrameCount() > 1) {
            this.mIsRunning = true;
            long now = now();
            long j2 = now - this.mPausedStartTimeMsDifference;
            this.mStartTimeMs = j2;
            this.mExpectedRenderTimeMs = j2;
            this.mLastFrameAnimationTimeMs = now - this.mPausedLastFrameAnimationTimeMsDifference;
            this.mLastDrawnFrameNumber = this.mPausedLastDrawnFrameNumber;
            invalidateSelf();
            this.mAnimationListener.onAnimationStart(this);
        }
    }

    public void stop() {
        if (this.mIsRunning) {
            long now = now();
            this.mPausedStartTimeMsDifference = now - this.mStartTimeMs;
            this.mPausedLastFrameAnimationTimeMsDifference = now - this.mLastFrameAnimationTimeMs;
            this.mPausedLastDrawnFrameNumber = this.mLastDrawnFrameNumber;
            this.mIsRunning = false;
            this.mStartTimeMs = 0;
            this.mExpectedRenderTimeMs = 0;
            this.mLastFrameAnimationTimeMs = -1;
            this.mLastDrawnFrameNumber = -1;
            unscheduleSelf(this.mInvalidateRunnable);
            this.mAnimationListener.onAnimationStop(this);
        }
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend != null) {
            animationBackend.setBounds(bounds);
        }
    }

    public void draw(Canvas canvas) {
        long j2;
        int frameNumberToDraw;
        long scheduledRenderTimeForNextFrameMs;
        long targetRenderTimeForNextFrameMs;
        long animationTimeMs;
        if (this.mAnimationBackend == null) {
        } else if (this.mFrameScheduler == null) {
        } else {
            long actualRenderTimeStartMs = now();
            if (this.mIsRunning) {
                j2 = (actualRenderTimeStartMs - this.mStartTimeMs) + this.mFrameSchedulingOffsetMs;
            } else {
                j2 = Math.max(this.mLastFrameAnimationTimeMs, 0);
            }
            long animationTimeMs2 = j2;
            int frameNumberToDraw2 = this.mFrameScheduler.getFrameNumberToRender(animationTimeMs2, this.mLastFrameAnimationTimeMs);
            if (frameNumberToDraw2 == -1) {
                int frameNumberToDraw3 = this.mAnimationBackend.getFrameCount() - 1;
                this.mAnimationListener.onAnimationStop(this);
                this.mIsRunning = false;
                frameNumberToDraw = frameNumberToDraw3;
            } else {
                if (frameNumberToDraw2 == 0 && this.mLastDrawnFrameNumber != -1 && actualRenderTimeStartMs >= this.mExpectedRenderTimeMs) {
                    this.mAnimationListener.onAnimationRepeat(this);
                }
                frameNumberToDraw = frameNumberToDraw2;
            }
            boolean frameDrawn = this.mAnimationBackend.drawFrame(this, canvas, frameNumberToDraw);
            if (frameDrawn) {
                this.mAnimationListener.onAnimationFrame(this, frameNumberToDraw);
                this.mLastDrawnFrameNumber = frameNumberToDraw;
            }
            if (!frameDrawn) {
                onFrameDropped();
            }
            long actualRenderTimeEnd = now();
            if (this.mIsRunning) {
                long targetRenderTimeForNextFrameMs2 = this.mFrameScheduler.getTargetRenderTimeForNextFrameMs(actualRenderTimeEnd - this.mStartTimeMs);
                if (targetRenderTimeForNextFrameMs2 != -1) {
                    long scheduledRenderTimeForNextFrameMs2 = targetRenderTimeForNextFrameMs2 + this.mFrameSchedulingDelayMs;
                    scheduleNextFrame(scheduledRenderTimeForNextFrameMs2);
                    targetRenderTimeForNextFrameMs = targetRenderTimeForNextFrameMs2;
                    scheduledRenderTimeForNextFrameMs = scheduledRenderTimeForNextFrameMs2;
                } else {
                    this.mAnimationListener.onAnimationStop(this);
                    this.mIsRunning = false;
                    targetRenderTimeForNextFrameMs = targetRenderTimeForNextFrameMs2;
                    scheduledRenderTimeForNextFrameMs = -1;
                }
            } else {
                targetRenderTimeForNextFrameMs = -1;
                scheduledRenderTimeForNextFrameMs = -1;
            }
            DrawListener listener = this.mDrawListener;
            if (listener != null) {
                DrawListener drawListener = listener;
                animationTimeMs = animationTimeMs2;
                int i2 = frameNumberToDraw;
                listener.onDraw(this, this.mFrameScheduler, frameNumberToDraw, frameDrawn, this.mIsRunning, this.mStartTimeMs, animationTimeMs2, this.mLastFrameAnimationTimeMs, actualRenderTimeStartMs, actualRenderTimeEnd, targetRenderTimeForNextFrameMs, scheduledRenderTimeForNextFrameMs);
            } else {
                animationTimeMs = animationTimeMs2;
                int i3 = frameNumberToDraw;
            }
            this.mLastFrameAnimationTimeMs = animationTimeMs;
        }
    }

    public void setAlpha(int alpha) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new DrawableProperties();
        }
        this.mDrawableProperties.setAlpha(alpha);
        AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend != null) {
            animationBackend.setAlpha(alpha);
        }
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new DrawableProperties();
        }
        this.mDrawableProperties.setColorFilter(colorFilter);
        AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend != null) {
            animationBackend.setColorFilter(colorFilter);
        }
    }

    public int getOpacity() {
        return -3;
    }

    public void preloadAnimation() {
        AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend != null) {
            animationBackend.preloadAnimation();
        }
    }

    public void setAnimationBackend(@Nullable AnimationBackend animationBackend) {
        AnimationBackend animationBackend2 = this.mAnimationBackend;
        if (animationBackend2 != null) {
            animationBackend2.setAnimationListener((AnimationBackend.Listener) null);
        }
        this.mAnimationBackend = animationBackend;
        if (animationBackend != null) {
            this.mFrameScheduler = new DropFramesFrameScheduler(this.mAnimationBackend);
            this.mAnimationBackend.setAnimationListener(this.animationBackendListener);
            this.mAnimationBackend.setBounds(getBounds());
            DrawableProperties drawableProperties = this.mDrawableProperties;
            if (drawableProperties != null) {
                drawableProperties.applyTo(this);
            }
        }
        this.mFrameScheduler = createSchedulerForBackendAndDelayMethod(this.mAnimationBackend);
        stop();
    }

    @Nullable
    public AnimationBackend getAnimationBackend() {
        return this.mAnimationBackend;
    }

    public long getDroppedFrames() {
        return (long) this.mDroppedFrames;
    }

    public long getStartTimeMs() {
        return this.mStartTimeMs;
    }

    public boolean isInfiniteAnimation() {
        FrameScheduler frameScheduler = this.mFrameScheduler;
        return frameScheduler != null && frameScheduler.isInfiniteAnimation();
    }

    public void jumpToFrame(int targetFrameNumber) {
        FrameScheduler frameScheduler;
        if (this.mAnimationBackend != null && (frameScheduler = this.mFrameScheduler) != null) {
            this.mLastFrameAnimationTimeMs = frameScheduler.getTargetRenderTimeMs(targetFrameNumber);
            this.mPausedLastDrawnFrameNumber = targetFrameNumber;
            this.mPausedStartTimeMsDifference = 0;
            this.mPausedLastFrameAnimationTimeMsDifference = 0;
            long now = now() - this.mLastFrameAnimationTimeMs;
            this.mStartTimeMs = now;
            this.mExpectedRenderTimeMs = now;
            invalidateSelf();
        }
    }

    public long getLoopDurationMs() {
        if (this.mAnimationBackend == null) {
            return 0;
        }
        FrameScheduler frameScheduler = this.mFrameScheduler;
        if (frameScheduler != null) {
            return frameScheduler.getLoopDurationMs();
        }
        int loopDurationMs = 0;
        for (int i2 = 0; i2 < this.mAnimationBackend.getFrameCount(); i2++) {
            loopDurationMs += this.mAnimationBackend.getFrameDurationMs(i2);
        }
        return (long) loopDurationMs;
    }

    public int getFrameCount() {
        AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend == null) {
            return 0;
        }
        return animationBackend.getFrameCount();
    }

    public int getLoopCount() {
        AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend == null) {
            return 0;
        }
        return animationBackend.getLoopCount();
    }

    public void setFrameSchedulingDelayMs(long frameSchedulingDelayMs) {
        this.mFrameSchedulingDelayMs = frameSchedulingDelayMs;
    }

    public void setFrameSchedulingOffsetMs(long frameSchedulingOffsetMs) {
        this.mFrameSchedulingOffsetMs = frameSchedulingOffsetMs;
    }

    public void setAnimationListener(@Nullable AnimationListener animationListener) {
        this.mAnimationListener = animationListener != null ? animationListener : NO_OP_LISTENER;
    }

    public void setDrawListener(@Nullable DrawListener drawListener) {
        this.mDrawListener = drawListener;
    }

    private void scheduleNextFrame(long targetAnimationTimeMs) {
        long j2 = this.mStartTimeMs + targetAnimationTimeMs;
        this.mExpectedRenderTimeMs = j2;
        scheduleSelf(this.mInvalidateRunnable, j2);
    }

    private void onFrameDropped() {
        this.mDroppedFrames++;
        if (FLog.isLoggable(2)) {
            FLog.v(TAG, "Dropped a frame. Count: %s", (Object) Integer.valueOf(this.mDroppedFrames));
        }
    }

    private long now() {
        return SystemClock.uptimeMillis();
    }

    @Nullable
    private static FrameScheduler createSchedulerForBackendAndDelayMethod(@Nullable AnimationBackend animationBackend) {
        if (animationBackend == null) {
            return null;
        }
        return new DropFramesFrameScheduler(animationBackend);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int level) {
        if (this.mIsRunning || this.mLastFrameAnimationTimeMs == ((long) level)) {
            return false;
        }
        this.mLastFrameAnimationTimeMs = (long) level;
        invalidateSelf();
        return true;
    }

    public void dropCaches() {
        AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend != null) {
            animationBackend.clear();
        }
    }
}
