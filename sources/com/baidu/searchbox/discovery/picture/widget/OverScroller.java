package com.baidu.searchbox.discovery.picture.widget;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class OverScroller {
    private static final int DEFAULT_DURATION = 250;
    private static final int FLING_MODE = 1;
    private static final int SCROLL_MODE = 0;
    private final Interpolator mInterpolator;
    private int mMode;
    private MagneticOverScroller mScrollerX;
    private MagneticOverScroller mScrollerY;

    public OverScroller(Context context) {
        this(context, (Interpolator) null);
    }

    public OverScroller(Context context, Interpolator interpolator) {
        this(context, interpolator, 0.16f, 0.16f);
    }

    public OverScroller(Context context, Interpolator interpolator, float bounceCoefficientX, float bounceCoefficientY) {
        this.mInterpolator = interpolator;
        this.mScrollerX = new MagneticOverScroller();
        this.mScrollerY = new MagneticOverScroller();
        MagneticOverScroller.initializeFromContext(context);
        this.mScrollerX.setBounceCoefficient(bounceCoefficientX);
        this.mScrollerY.setBounceCoefficient(bounceCoefficientY);
    }

    public final boolean isFinished() {
        return this.mScrollerX.mFinished && this.mScrollerY.mFinished;
    }

    public final void forceFinished(boolean finished) {
        MagneticOverScroller magneticOverScroller = this.mScrollerX;
        this.mScrollerY.mFinished = finished;
        magneticOverScroller.mFinished = finished;
    }

    public final int getCurrX() {
        return this.mScrollerX.mCurrentPosition;
    }

    public final int getCurrY() {
        return this.mScrollerY.mCurrentPosition;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((double) ((this.mScrollerX.mCurrVelocity * this.mScrollerX.mCurrVelocity) + (this.mScrollerY.mCurrVelocity * this.mScrollerY.mCurrVelocity)));
    }

    public final int getStartX() {
        return this.mScrollerX.mStart;
    }

    public final int getStartY() {
        return this.mScrollerY.mStart;
    }

    public final int getFinalX() {
        return this.mScrollerX.mFinal;
    }

    public final int getFinalY() {
        return this.mScrollerY.mFinal;
    }

    public final int getDuration() {
        return Math.max(this.mScrollerX.mDuration, this.mScrollerY.mDuration);
    }

    public void extendDuration(int extend) {
        this.mScrollerX.extendDuration(extend);
        this.mScrollerY.extendDuration(extend);
    }

    public void setFinalX(int newX) {
        this.mScrollerX.setFinalPosition(newX);
    }

    public void setFinalY(int newY) {
        this.mScrollerY.setFinalPosition(newY);
    }

    public boolean computeScrollOffset() {
        float q;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long elapsedTime = AnimationUtils.currentAnimationTimeMillis() - this.mScrollerX.mStartTime;
                int duration = this.mScrollerX.mDuration;
                if (elapsedTime < ((long) duration)) {
                    float q2 = ((float) elapsedTime) / ((float) duration);
                    Interpolator interpolator = this.mInterpolator;
                    if (interpolator == null) {
                        q = Scroller.viscousFluid(q2);
                    } else {
                        q = interpolator.getInterpolation(q2);
                    }
                    this.mScrollerX.updateScroll(q);
                    this.mScrollerY.updateScroll(q);
                    return true;
                }
                abortAnimation();
                return true;
            case 1:
                if (!this.mScrollerX.mFinished && !this.mScrollerX.update() && !this.mScrollerX.continueWhenFinished()) {
                    this.mScrollerX.finish();
                }
                if (this.mScrollerY.mFinished || this.mScrollerY.update() || this.mScrollerY.continueWhenFinished()) {
                    return true;
                }
                this.mScrollerY.finish();
                return true;
            default:
                return true;
        }
    }

    public void startScroll(int startX, int startY, int dx, int dy) {
        startScroll(startX, startY, dx, dy, 250);
    }

    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        this.mMode = 0;
        this.mScrollerX.startScroll(startX, dx, duration);
        this.mScrollerY.startScroll(startY, dy, duration);
    }

    public boolean springBack(int startX, int startY, int minX, int maxX, int minY, int maxY) {
        this.mMode = 1;
        boolean spingbackX = this.mScrollerX.springback(startX, minX, maxX);
        boolean spingbackY = this.mScrollerY.springback(startY, minY, maxY);
        if (spingbackX || spingbackY) {
            return true;
        }
        return false;
    }

    public void fling(int startX, int startY, int velocityX, int velocityY, int minX, int maxX, int minY, int maxY) {
        fling(startX, startY, velocityX, velocityY, minX, maxX, minY, maxY, 0, 0);
    }

    public void fling(int startX, int startY, int velocityX, int velocityY, int minX, int maxX, int minY, int maxY, int overX, int overY) {
        this.mMode = 1;
        this.mScrollerX.fling(startX, velocityX, minX, maxX, overX);
        this.mScrollerY.fling(startY, velocityY, minY, maxY, overY);
    }

    public void notifyHorizontalEdgeReached(int startX, int finalX, int overX) {
        this.mScrollerX.notifyEdgeReached(startX, finalX, overX);
    }

    public void notifyVerticalEdgeReached(int startY, int finalY, int overY) {
        this.mScrollerY.notifyEdgeReached(startY, finalY, overY);
    }

    public boolean isOverScrolled() {
        return (!this.mScrollerX.mFinished && this.mScrollerX.mState != 0) || (!this.mScrollerY.mFinished && this.mScrollerY.mState != 0);
    }

    public void abortAnimation() {
        this.mScrollerX.finish();
        this.mScrollerY.finish();
    }

    public int timePassed() {
        return (int) (AnimationUtils.currentAnimationTimeMillis() - Math.min(this.mScrollerX.mStartTime, this.mScrollerY.mStartTime));
    }

    static class MagneticOverScroller {
        private static final float DEFAULT_BOUNCE_COEFFICIENT = 0.16f;
        static float GRAVITY = 0.0f;
        private static final float MINIMUM_VELOCITY_FOR_BOUNCE = Float.MAX_VALUE;
        private static final int OVERSCROLL_SPRINGBACK_DURATION = 200;
        private static final float TIME_COEF = 15.707964f;
        private static final int TO_BOUNCE = 2;
        private static final int TO_BOUNDARY = 1;
        private static final int TO_EDGE = 0;
        private float mBounceCoefficient = DEFAULT_BOUNCE_COEFFICIENT;
        float mCurrVelocity;
        int mCurrentPosition;
        float mDeceleration;
        int mDuration;
        int mFinal;
        boolean mFinished = true;
        private int mOver;
        int mStart;
        long mStartTime;
        /* access modifiers changed from: private */
        public int mState = 0;
        int mVelocity;

        static void initializeFromContext(Context context) {
            GRAVITY = 386.0878f * context.getResources().getDisplayMetrics().density * 160.0f * ViewConfiguration.getScrollFriction();
        }

        MagneticOverScroller() {
        }

        /* access modifiers changed from: package-private */
        public void updateScroll(float q) {
            int i2 = this.mStart;
            this.mCurrentPosition = i2 + Math.round(((float) (this.mFinal - i2)) * q);
        }

        static float getDeceleration(int velocity) {
            float f2 = GRAVITY;
            return velocity > 0 ? -f2 : f2;
        }

        static int computeDuration(int start, int end, float initialVelocity, float deceleration) {
            float discriminant = (initialVelocity * initialVelocity) - ((2.0f * deceleration) * ((float) (start - end)));
            if (discriminant < 0.0f) {
                return 0;
            }
            float delta = (float) Math.sqrt((double) discriminant);
            if (deceleration < 0.0f) {
                delta = -delta;
            }
            return (int) ((((-initialVelocity) - delta) * 1000.0f) / deceleration);
        }

        /* access modifiers changed from: package-private */
        public void startScroll(int start, int distance, int duration) {
            this.mFinished = false;
            this.mStart = start;
            this.mFinal = start + distance;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = duration;
            this.mDeceleration = 0.0f;
            this.mVelocity = 0;
        }

        /* access modifiers changed from: package-private */
        public void fling(int start, int velocity, int min, int max) {
            this.mFinished = false;
            this.mStart = start;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mVelocity = velocity;
            float deceleration = getDeceleration(velocity);
            this.mDeceleration = deceleration;
            int i2 = this.mStart;
            if (i2 < min) {
                this.mDuration = 0;
                this.mFinal = min;
            } else if (i2 > max) {
                this.mDuration = 0;
                this.mFinal = max;
            } else {
                this.mDuration = (int) ((((float) velocity) * -1000.0f) / deceleration);
                int round = start - Math.round(((float) (velocity * velocity)) / (deceleration * 2.0f));
                this.mFinal = round;
                if (round < min) {
                    this.mFinal = min;
                    this.mDuration = computeDuration(this.mStart, min, (float) this.mVelocity, this.mDeceleration);
                }
                if (this.mFinal > max) {
                    this.mFinal = max;
                    this.mDuration = computeDuration(this.mStart, max, (float) this.mVelocity, this.mDeceleration);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void finish() {
            this.mCurrentPosition = this.mFinal;
            this.mFinished = true;
        }

        /* access modifiers changed from: package-private */
        public void setFinalPosition(int position) {
            this.mFinal = position;
            this.mFinished = false;
        }

        /* access modifiers changed from: package-private */
        public void extendDuration(int extend) {
            this.mDuration = ((int) (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime)) + extend;
            this.mFinished = false;
        }

        /* access modifiers changed from: package-private */
        public void setBounceCoefficient(float coefficient) {
            this.mBounceCoefficient = coefficient;
        }

        /* access modifiers changed from: package-private */
        public boolean springback(int start, int min, int max) {
            this.mFinished = true;
            this.mStart = start;
            this.mVelocity = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 0;
            if (start < min) {
                startSpringback(start, min, false);
            } else if (start > max) {
                startSpringback(start, max, true);
            }
            return true ^ this.mFinished;
        }

        private void startSpringback(int start, int end, boolean positive) {
            this.mFinished = false;
            this.mState = 2;
            this.mFinal = end;
            this.mStart = end;
            this.mDuration = 200;
            this.mStartTime -= 100;
            this.mVelocity = (int) (((double) (((float) Math.abs(end - start)) * TIME_COEF)) * (positive ? 1.0d : -1.0d));
        }

        /* access modifiers changed from: package-private */
        public void fling(int start, int velocity, int min, int max, int over) {
            int i2 = start;
            int i3 = velocity;
            int i4 = min;
            int i5 = max;
            int i6 = over;
            this.mState = 0;
            this.mOver = i6;
            this.mFinished = false;
            this.mStart = i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mVelocity = i3;
            float deceleration = getDeceleration(velocity);
            this.mDeceleration = deceleration;
            this.mDuration = (int) ((((float) i3) * -1000.0f) / deceleration);
            int round = i2 - Math.round(((float) (i3 * i3)) / (deceleration * 2.0f));
            this.mFinal = round;
            if (round < i4) {
                this.mFinal = i4;
                this.mDuration = computeDuration(this.mStart, i4, (float) this.mVelocity, this.mDeceleration);
            }
            if (this.mFinal > i5) {
                this.mFinal = i5;
                this.mDuration = computeDuration(this.mStart, i5, (float) this.mVelocity, this.mDeceleration);
            }
            if (i2 > i5) {
                if (i2 >= i5 + i6) {
                    springback(i5 + i6, i4, i5);
                } else if (i3 <= 0) {
                    springback(i2, i4, i5);
                } else {
                    long time = AnimationUtils.currentAnimationTimeMillis();
                    double durationSinceEdge = Math.atan((double) ((((float) (i2 - i5)) * TIME_COEF) / ((float) i3))) / 15.707963943481445d;
                    this.mStartTime = (long) ((int) (((double) time) - (1000.0d * durationSinceEdge)));
                    this.mStart = i5;
                    this.mVelocity = (int) (((double) i3) / Math.cos(durationSinceEdge * 15.707963943481445d));
                    onEdgeReached();
                }
            } else if (i2 >= i4) {
            } else {
                if (i2 <= i4 - i6) {
                    springback(i4 - i6, i4, i5);
                } else if (i3 >= 0) {
                    springback(i2, i4, i5);
                } else {
                    long time2 = AnimationUtils.currentAnimationTimeMillis();
                    double durationSinceEdge2 = Math.atan((double) ((((float) (i2 - i4)) * TIME_COEF) / ((float) i3))) / 15.707963943481445d;
                    this.mStartTime = (long) ((int) (((double) time2) - (1000.0d * durationSinceEdge2)));
                    this.mStart = i4;
                    this.mVelocity = (int) (((double) i3) / Math.cos(15.707963943481445d * durationSinceEdge2));
                    onEdgeReached();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void notifyEdgeReached(int start, int end, int over) {
            float deceleration = getDeceleration(this.mVelocity);
            this.mDeceleration = deceleration;
            float timeCurrent = this.mCurrVelocity / deceleration;
            float timeEdge = -((float) Math.sqrt((double) (((((float) (end - start)) * 2.0f) / deceleration) + (timeCurrent * timeCurrent))));
            this.mVelocity = (int) (this.mDeceleration * timeEdge);
            this.mStart = end;
            this.mOver = over;
            this.mStartTime = (long) ((int) (((float) AnimationUtils.currentAnimationTimeMillis()) - ((timeCurrent - timeEdge) * 1000.0f)));
            onEdgeReached();
        }

        private void onEdgeReached() {
            float distance = ((float) this.mVelocity) / TIME_COEF;
            float abs = Math.abs(distance);
            int i2 = this.mOver;
            if (abs < ((float) i2)) {
                this.mState = 2;
                this.mFinal = this.mStart;
                this.mDuration = 200;
                return;
            }
            this.mState = 1;
            if (this.mVelocity <= 0) {
                i2 = -i2;
            }
            int over = i2;
            this.mFinal = this.mStart + over;
            this.mDuration = (int) ((Math.asin((double) (((float) over) / distance)) * 1000.0d) / 15.707963943481445d);
        }

        /* access modifiers changed from: package-private */
        public boolean continueWhenFinished() {
            boolean z = false;
            switch (this.mState) {
                case 0:
                    int i2 = this.mVelocity;
                    float f2 = this.mDeceleration;
                    int duration = (int) ((((float) i2) * -1000.0f) / f2);
                    int i3 = this.mDuration;
                    if (i3 < duration) {
                        this.mStart = this.mFinal;
                        this.mVelocity = (int) (((float) i2) + ((f2 * ((float) i3)) / 1000.0f));
                        this.mStartTime += (long) i3;
                        onEdgeReached();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    this.mStartTime += (long) this.mDuration;
                    int i4 = this.mFinal;
                    int i5 = this.mVelocity;
                    int i6 = this.mOver;
                    if (i5 <= 0) {
                        i6 = -i6;
                    }
                    int i7 = i4 - i6;
                    if (i5 > 0) {
                        z = true;
                    }
                    startSpringback(i4, i7, z);
                    break;
                case 2:
                    int i8 = (int) (((float) this.mVelocity) * this.mBounceCoefficient);
                    this.mVelocity = i8;
                    if (((float) Math.abs(i8)) >= Float.MAX_VALUE) {
                        this.mStartTime += (long) this.mDuration;
                        break;
                    } else {
                        return false;
                    }
            }
            update();
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean update() {
            double distance;
            long duration = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            if (duration > ((long) this.mDuration)) {
                return false;
            }
            float t = ((float) duration) / 1000.0f;
            if (this.mState == 0) {
                int i2 = this.mVelocity;
                float f2 = this.mDeceleration;
                this.mCurrVelocity = ((float) i2) + (f2 * t);
                distance = (double) ((((float) i2) * t) + (((f2 * t) * t) / 2.0f));
            } else {
                float d2 = t * TIME_COEF;
                this.mCurrVelocity = ((float) this.mVelocity) * ((float) Math.cos((double) d2));
                distance = ((double) (((float) this.mVelocity) / TIME_COEF)) * Math.sin((double) d2);
            }
            this.mCurrentPosition = this.mStart + ((int) distance);
            return true;
        }
    }

    public static class Scroller {
        private static float ALPHA = 800.0f;
        private static float DECELERATION_RATE = ((float) (Math.log(0.75d) / Math.log(0.9d)));
        private static final int DEFAULT_DURATION = 250;
        private static float END_TENSION = (1.0f - 0.4f);
        private static final int FLING_MODE = 1;
        private static final int NB_SAMPLES = 100;
        private static final int SCROLL_MODE = 0;
        private static final float[] SPLINE = new float[101];
        private static float START_TENSION = 0.4f;
        private static float sViscousFluidNormalize;
        private static float sViscousFluidScale = 8.0f;
        private int mCurrX;
        private int mCurrY;
        private float mDeceleration;
        private float mDeltaX;
        private float mDeltaY;
        private int mDuration;
        private float mDurationReciprocal;
        private int mFinalX;
        private int mFinalY;
        private boolean mFinished;
        private boolean mFlywheel;
        private Interpolator mInterpolator;
        private int mMaxX;
        private int mMaxY;
        private int mMinX;
        private int mMinY;
        private int mMode;
        private final float mPpi;
        private long mStartTime;
        private int mStartX;
        private int mStartY;
        private float mVelocity;

        static {
            float x;
            float coef;
            float x_min = 0.0f;
            for (int i2 = 0; i2 <= 100; i2++) {
                float t = ((float) i2) / 100.0f;
                float x_max = 1.0f;
                while (true) {
                    x = ((x_max - x_min) / 2.0f) + x_min;
                    coef = 3.0f * x * (1.0f - x);
                    float tx = ((((1.0f - x) * START_TENSION) + (END_TENSION * x)) * coef) + (x * x * x);
                    if (((double) Math.abs(tx - t)) < 1.0E-5d) {
                        break;
                    } else if (tx > t) {
                        x_max = x;
                    } else {
                        x_min = x;
                    }
                }
                SPLINE[i2] = (x * x * x) + coef;
            }
            SPLINE[100] = 1.0f;
            sViscousFluidNormalize = 1.0f;
            sViscousFluidNormalize = 1.0f / viscousFluid(1.0f);
        }

        public Scroller(Context context) {
            this(context, (Interpolator) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Scroller(Context context, Interpolator interpolator) {
            this(context, interpolator, context.getApplicationInfo().targetSdkVersion >= 11);
        }

        public Scroller(Context context, Interpolator interpolator, boolean flywheel) {
            this.mFinished = true;
            this.mInterpolator = interpolator;
            this.mPpi = context.getResources().getDisplayMetrics().density * 160.0f;
            this.mDeceleration = computeDeceleration(ViewConfiguration.getScrollFriction());
            this.mFlywheel = flywheel;
        }

        public final void setFriction(float friction) {
            this.mDeceleration = computeDeceleration(friction);
        }

        private float computeDeceleration(float friction) {
            return this.mPpi * 386.0878f * friction;
        }

        public final boolean isFinished() {
            return this.mFinished;
        }

        public final void forceFinished(boolean finished) {
            this.mFinished = finished;
        }

        public final int getDuration() {
            return this.mDuration;
        }

        public final int getCurrX() {
            return this.mCurrX;
        }

        public final int getCurrY() {
            return this.mCurrY;
        }

        public float getCurrVelocity() {
            return this.mVelocity - ((this.mDeceleration * ((float) timePassed())) / 2000.0f);
        }

        public final int getStartX() {
            return this.mStartX;
        }

        public final int getStartY() {
            return this.mStartY;
        }

        public final int getFinalX() {
            return this.mFinalX;
        }

        public final int getFinalY() {
            return this.mFinalY;
        }

        public boolean computeScrollOffset() {
            float x;
            if (this.mFinished) {
                return false;
            }
            int timePassed = (int) (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
            int i2 = this.mDuration;
            if (timePassed < i2) {
                switch (this.mMode) {
                    case 0:
                        float x2 = ((float) timePassed) * this.mDurationReciprocal;
                        Interpolator interpolator = this.mInterpolator;
                        if (interpolator == null) {
                            x = viscousFluid(x2);
                        } else {
                            x = interpolator.getInterpolation(x2);
                        }
                        this.mCurrX = this.mStartX + Math.round(this.mDeltaX * x);
                        this.mCurrY = this.mStartY + Math.round(this.mDeltaY * x);
                        break;
                    case 1:
                        float t = ((float) timePassed) / ((float) i2);
                        int index = (int) (t * 100.0f);
                        float t_inf = ((float) index) / 100.0f;
                        float[] fArr = SPLINE;
                        float d_inf = fArr[index];
                        float distanceCoef = (((t - t_inf) / ((((float) (index + 1)) / 100.0f) - t_inf)) * (fArr[index + 1] - d_inf)) + d_inf;
                        int i3 = this.mStartX;
                        int round = i3 + Math.round(((float) (this.mFinalX - i3)) * distanceCoef);
                        this.mCurrX = round;
                        int min = Math.min(round, this.mMaxX);
                        this.mCurrX = min;
                        this.mCurrX = Math.max(min, this.mMinX);
                        int i4 = this.mStartY;
                        int round2 = i4 + Math.round(((float) (this.mFinalY - i4)) * distanceCoef);
                        this.mCurrY = round2;
                        int min2 = Math.min(round2, this.mMaxY);
                        this.mCurrY = min2;
                        int max = Math.max(min2, this.mMinY);
                        this.mCurrY = max;
                        if (this.mCurrX == this.mFinalX && max == this.mFinalY) {
                            this.mFinished = true;
                            break;
                        }
                }
            } else {
                this.mCurrX = this.mFinalX;
                this.mCurrY = this.mFinalY;
                this.mFinished = true;
            }
            return true;
        }

        public void startScroll(int startX, int startY, int dx, int dy) {
            startScroll(startX, startY, dx, dy, 250);
        }

        public void startScroll(int startX, int startY, int dx, int dy, int duration) {
            this.mMode = 0;
            this.mFinished = false;
            this.mDuration = duration;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStartX = startX;
            this.mStartY = startY;
            this.mFinalX = startX + dx;
            this.mFinalY = startY + dy;
            this.mDeltaX = (float) dx;
            this.mDeltaY = (float) dy;
            this.mDurationReciprocal = 1.0f / ((float) this.mDuration);
        }

        public void fling(int startX, int startY, int velocityX, int velocityY, int minX, int maxX, int minY, int maxY) {
            int i2 = startX;
            int i3 = startY;
            int velocityX2 = velocityX;
            int velocityY2 = velocityY;
            if (this.mFlywheel && !this.mFinished) {
                float oldVel = getCurrVelocity();
                float dx = (float) (this.mFinalX - this.mStartX);
                float dy = (float) (this.mFinalY - this.mStartY);
                float hyp = (float) Math.sqrt((double) ((dx * dx) + (dy * dy)));
                float oldVelocityX = (dx / hyp) * oldVel;
                float oldVelocityY = (dy / hyp) * oldVel;
                if (Math.signum((float) velocityX2) == Math.signum(oldVelocityX) && Math.signum((float) velocityY2) == Math.signum(oldVelocityY)) {
                    velocityX2 = (int) (((float) velocityX2) + oldVelocityX);
                    velocityY2 = (int) (((float) velocityY2) + oldVelocityY);
                }
            }
            this.mMode = 1;
            this.mFinished = false;
            float velocity = (float) Math.sqrt((double) ((velocityX2 * velocityX2) + (velocityY2 * velocityY2)));
            this.mVelocity = velocity;
            double l = Math.log((double) ((START_TENSION * velocity) / ALPHA));
            this.mDuration = (int) (Math.exp(l / (((double) DECELERATION_RATE) - 1.0d)) * 1000.0d);
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStartX = i2;
            this.mStartY = i3;
            float coeffY = 1.0f;
            float coeffX = velocity == 0.0f ? 1.0f : ((float) velocityX2) / velocity;
            if (velocity != 0.0f) {
                coeffY = ((float) velocityY2) / velocity;
            }
            float f2 = DECELERATION_RATE;
            int i4 = velocityX2;
            int i5 = velocityY2;
            int totalDistance = (int) (((double) ALPHA) * Math.exp((((double) f2) / (((double) f2) - 1.0d)) * l));
            this.mMinX = minX;
            this.mMaxX = maxX;
            this.mMinY = minY;
            this.mMaxY = maxY;
            int round = Math.round(((float) totalDistance) * coeffX) + i2;
            this.mFinalX = round;
            int min = Math.min(round, this.mMaxX);
            this.mFinalX = min;
            this.mFinalX = Math.max(min, this.mMinX);
            int round2 = Math.round(((float) totalDistance) * coeffY) + i3;
            this.mFinalY = round2;
            int min2 = Math.min(round2, this.mMaxY);
            this.mFinalY = min2;
            this.mFinalY = Math.max(min2, this.mMinY);
        }

        static float viscousFluid(float x) {
            float x2;
            float x3 = x * sViscousFluidScale;
            if (x3 < 1.0f) {
                x2 = x3 - (1.0f - ((float) Math.exp((double) (-x3))));
            } else {
                x2 = 0.36787945f + ((1.0f - 0.36787945f) * (1.0f - ((float) Math.exp((double) (1.0f - x3)))));
            }
            return x2 * sViscousFluidNormalize;
        }

        public void abortAnimation() {
            this.mCurrX = this.mFinalX;
            this.mCurrY = this.mFinalY;
            this.mFinished = true;
        }

        public void extendDuration(int extend) {
            int timePassed = timePassed() + extend;
            this.mDuration = timePassed;
            this.mDurationReciprocal = 1.0f / ((float) timePassed);
            this.mFinished = false;
        }

        public int timePassed() {
            return (int) (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
        }

        public void setFinalX(int newX) {
            this.mFinalX = newX;
            this.mDeltaX = (float) (newX - this.mStartX);
            this.mFinished = false;
        }

        public void setFinalY(int newY) {
            this.mFinalY = newY;
            this.mDeltaY = (float) (newY - this.mStartY);
            this.mFinished = false;
        }

        public boolean isScrollingInDirection(float xvel, float yvel) {
            return !this.mFinished && Math.signum(xvel) == Math.signum((float) (this.mFinalX - this.mStartX)) && Math.signum(yvel) == Math.signum((float) (this.mFinalY - this.mStartY));
        }
    }
}
