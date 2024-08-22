package com.baidu.searchbox.ui.pullrefresh;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;

public class NeutralRefreshAnimView extends View {
    private static final int ALPHA_ANIM_DURATION = 300;
    private static final int BALL_RADIUS = DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 3.5f);
    private static final int COLOR_OF_BALLS = Color.parseColor("#000000");
    private static final String CREATEBITMAP_RUNNABLE_NAME = "CreateBitmapOnSizeChanged";
    private static final boolean DEBUG = false;
    private static final float FIFTY_PERCENT = 0.5f;
    /* access modifiers changed from: private */
    public static final int HALF_MAX_DISTANCE;
    private static final int LEFT_BALL_ALPHA_THREAD = 26;
    private static final int MAX_DISTANCE;
    private static final int RIGHT_BALL_ALPHA_THREAD = 77;
    private static final int STATE_KEEP_POSITION = 4;
    private static final int STATE_ON_REFRESHING = 2;
    private static final int STATE_PULL_TO_REFRESH = 1;
    private static final int STATE_REFRESH_COMPLETE = 3;
    private static final String TAG = "NeutralRefreshAnimView";
    private static final int TRANSLATE_ANIM_DURATION = 480;
    private float mAnimPercent;
    private AnimatorSet mAnimatorSet;
    /* access modifiers changed from: private */
    public Bitmap mBitmap;
    /* access modifiers changed from: private */
    public Canvas mCanvas;
    private PointF mCenterPos;
    private int mHeight;
    /* access modifiers changed from: private */
    public int mLeftAlpha;
    private ValueAnimator mLeftAlphaAnimator;
    private ValueAnimator mLeftBallAnimator;
    /* access modifiers changed from: private */
    public float mLeftBallXPosi;
    private Paint mLeftPaint;
    /* access modifiers changed from: private */
    public int mRightAlpha;
    private ValueAnimator mRightAlphaAnimator;
    private ValueAnimator mRightBallAnimator;
    /* access modifiers changed from: private */
    public float mRightBallXPosi;
    private Paint mRightPaint;
    private int mState;
    private int mWidth;

    static {
        int dp2px = DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 18.0f);
        MAX_DISTANCE = dp2px;
        HALF_MAX_DISTANCE = dp2px >> 1;
    }

    public NeutralRefreshAnimView(Context context) {
        super(context);
        init();
    }

    public NeutralRefreshAnimView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        this.mCenterPos = new PointF();
        this.mLeftPaint = new Paint(1);
        this.mRightPaint = new Paint(1);
        Paint paint = this.mLeftPaint;
        int i2 = COLOR_OF_BALLS;
        paint.setColor(i2);
        this.mRightPaint.setColor(i2);
    }

    public void setAnimPercent(float percent) {
        if (percent < 0.0f) {
            percent = 0.0f;
        }
        if (percent > 1.0f) {
            percent = 1.0f;
        }
        this.mAnimPercent = percent;
        changeState(1);
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.mWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.mHeight = measuredHeight;
        this.mCenterPos.set((float) (this.mWidth >> 1), (float) (measuredHeight >> 1));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(final int w, final int h2, int oldw, int oldh) {
        super.onSizeChanged(w, h2, oldw, oldh);
        if (w > 0 && h2 > 0) {
            ExecutorUtilsExt.postOnElastic(new Runnable() {
                public void run() {
                    Bitmap unused = NeutralRefreshAnimView.this.mBitmap = Bitmap.createBitmap(w, h2, Bitmap.Config.ARGB_8888);
                    Canvas unused2 = NeutralRefreshAnimView.this.mCanvas = new Canvas(NeutralRefreshAnimView.this.mBitmap);
                }
            }, CREATEBITMAP_RUNNABLE_NAME, 2);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        switch (this.mState) {
            case 1:
                performPullToRefreshAnim(canvas);
                break;
            case 2:
                performOnRefreshingAnim(canvas);
                break;
            case 3:
                performRefreshCompleteAnim(canvas);
                break;
            case 4:
                performOnRefreshingAnim(canvas);
                break;
        }
        canvas.restore();
    }

    /* access modifiers changed from: private */
    public void changeState(int state) {
        this.mState = state;
    }

    private void performPullToRefreshAnim(Canvas canvas) {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null && this.mCanvas != null) {
            bitmap.eraseColor(0);
            float f2 = this.mAnimPercent;
            if (f2 == 0.0f) {
                this.mRightPaint.setAlpha(0);
                this.mCanvas.drawCircle(this.mCenterPos.x, this.mCenterPos.y, (float) BALL_RADIUS, this.mRightPaint);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (f2 <= 0.5f) {
                this.mRightPaint.setAlpha((int) (f2 * 77.0f));
                this.mCanvas.drawCircle(this.mCenterPos.x, this.mCenterPos.y, (float) BALL_RADIUS, this.mRightPaint);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (f2 < 1.0f) {
                this.mRightPaint.setAlpha(checkAlphaValue((int) (f2 * 77.0f)));
                float fraction = (this.mAnimPercent - 0.5f) * 2.0f;
                this.mLeftPaint.setAlpha(checkAlphaValue((int) (26.0f * fraction)));
                Canvas canvas2 = this.mCanvas;
                float f3 = this.mCenterPos.x;
                int i2 = HALF_MAX_DISTANCE;
                float f4 = this.mCenterPos.y;
                int i3 = BALL_RADIUS;
                canvas2.drawCircle(f3 + (((float) i2) * fraction), f4, (float) i3, this.mRightPaint);
                this.mCanvas.drawCircle(this.mCenterPos.x - (((float) i2) * fraction), this.mCenterPos.y, (float) i3, this.mLeftPaint);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (f2 == 1.0f) {
                this.mLeftPaint.setAlpha(26);
                this.mRightPaint.setAlpha(77);
                Canvas canvas3 = this.mCanvas;
                float f5 = this.mCenterPos.x;
                int i4 = HALF_MAX_DISTANCE;
                float f6 = this.mCenterPos.y;
                int i5 = BALL_RADIUS;
                canvas3.drawCircle(f5 + ((float) i4), f6, (float) i5, this.mRightPaint);
                this.mCanvas.drawCircle(this.mCenterPos.x - ((float) i4), this.mCenterPos.y, (float) i5, this.mLeftPaint);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            }
        }
    }

    public void onRefreshingAnim() {
        changeState(2);
        performRefreshingAnim();
    }

    private void performRefreshingAnim() {
        resetAnimator();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, -1.0f});
        this.mRightBallAnimator = ofFloat;
        ofFloat.setDuration(480);
        this.mRightBallAnimator.setRepeatMode(2);
        this.mRightBallAnimator.setRepeatCount(-1);
        this.mRightBallAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        this.mRightBallAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                float unused = NeutralRefreshAnimView.this.mRightBallXPosi = ((float) NeutralRefreshAnimView.HALF_MAX_DISTANCE) * ((Float) animation.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{-1.0f, 1.0f});
        this.mLeftBallAnimator = ofFloat2;
        ofFloat2.setDuration(480);
        this.mLeftBallAnimator.setRepeatMode(2);
        this.mLeftBallAnimator.setRepeatCount(-1);
        this.mLeftBallAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        this.mLeftBallAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                float unused = NeutralRefreshAnimView.this.mLeftBallXPosi = ((float) NeutralRefreshAnimView.HALF_MAX_DISTANCE) * ((Float) animation.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.mAnimatorSet = animatorSet;
        animatorSet.playTogether(new Animator[]{this.mLeftBallAnimator, this.mRightBallAnimator});
        this.mAnimatorSet.setDuration(480);
        this.mAnimatorSet.addListener(new Animator.AnimatorListener() {
            public void onAnimationStart(Animator animation) {
            }

            public void onAnimationEnd(Animator animation) {
                NeutralRefreshAnimView.this.changeState(4);
                NeutralRefreshAnimView.this.postInvalidate();
            }

            public void onAnimationCancel(Animator animation) {
            }

            public void onAnimationRepeat(Animator animation) {
            }
        });
        if (!this.mAnimatorSet.isRunning()) {
            this.mAnimatorSet.start();
        }
    }

    private void performOnRefreshingAnim(Canvas canvas) {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null && this.mCanvas != null) {
            bitmap.eraseColor(0);
            this.mRightPaint.setAlpha(77);
            Canvas canvas2 = this.mCanvas;
            float f2 = this.mCenterPos.x + this.mRightBallXPosi;
            float f3 = this.mCenterPos.y;
            int i2 = BALL_RADIUS;
            canvas2.drawCircle(f2, f3, (float) i2, this.mRightPaint);
            this.mLeftPaint.setAlpha(26);
            this.mCanvas.drawCircle(this.mCenterPos.x + this.mLeftBallXPosi, this.mCenterPos.y, (float) i2, this.mLeftPaint);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    public void onRefreshCompleteAnim() {
        stopAnim();
        changeState(3);
        performRefreshCompleteAnim();
    }

    private void performRefreshCompleteAnim() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{26, 0});
        this.mLeftAlphaAnimator = ofInt;
        ofInt.setDuration(300);
        this.mLeftAlphaAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                int unused = NeutralRefreshAnimView.this.mLeftAlpha = ((Integer) animation.getAnimatedValue()).intValue();
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.mLeftAlphaAnimator.isRunning()) {
            this.mLeftAlphaAnimator.start();
        }
        ValueAnimator ofInt2 = ValueAnimator.ofInt(new int[]{77, 0});
        this.mRightAlphaAnimator = ofInt2;
        ofInt2.setDuration(300);
        this.mRightAlphaAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                int unused = NeutralRefreshAnimView.this.mRightAlpha = ((Integer) animation.getAnimatedValue()).intValue();
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.mRightAlphaAnimator.isRunning()) {
            this.mRightAlphaAnimator.start();
        }
    }

    private void performRefreshCompleteAnim(Canvas canvas) {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null && this.mCanvas != null) {
            bitmap.eraseColor(0);
            this.mLeftAlpha = checkAlphaValue(this.mLeftAlpha);
            int checkAlphaValue = checkAlphaValue(this.mRightAlpha);
            this.mRightAlpha = checkAlphaValue;
            this.mRightPaint.setAlpha(checkAlphaValue);
            this.mLeftPaint.setAlpha(this.mLeftAlpha);
            Canvas canvas2 = this.mCanvas;
            float f2 = this.mCenterPos.x + this.mRightBallXPosi;
            float f3 = this.mCenterPos.y;
            int i2 = BALL_RADIUS;
            canvas2.drawCircle(f2, f3, (float) i2, this.mRightPaint);
            this.mLeftPaint.setAlpha(this.mLeftAlpha);
            this.mCanvas.drawCircle(this.mCenterPos.x + this.mLeftBallXPosi, this.mCenterPos.y, (float) i2, this.mLeftPaint);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    public void stopAnim() {
        resetAnimator();
        clearAnimation();
        changeState(1);
        postInvalidate();
    }

    private void resetAnimator(ValueAnimator animator, boolean isRepeat) {
        if (animator != null) {
            if (isRepeat) {
                animator.setRepeatCount(0);
            }
            animator.removeAllUpdateListeners();
            animator.removeAllListeners();
            animator.end();
            animator.cancel();
        }
    }

    private void resetAnimator() {
        resetAnimator(this.mLeftBallAnimator, true);
        resetAnimator(this.mRightBallAnimator, true);
        resetAnimator(this.mLeftAlphaAnimator, false);
        resetAnimator(this.mRightAlphaAnimator, false);
        AnimatorSet animatorSet = this.mAnimatorSet;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            this.mAnimatorSet.end();
            this.mAnimatorSet.cancel();
        }
    }

    private int checkAlphaValue(int value) {
        if (value < 0) {
            value = 0;
        }
        if (value > 255) {
            value = 255;
        }
        return value;
    }
}
