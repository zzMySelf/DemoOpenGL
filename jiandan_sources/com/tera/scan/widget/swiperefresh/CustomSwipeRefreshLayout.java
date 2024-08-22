package com.tera.scan.widget.swiperefresh;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.baidu.aiscan.R;
import fe.mmm.qw.j.o;

public class CustomSwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild {
    public static final int ANIMATE_TO_START_DURATION = 200;
    public static final int ANIMATE_TO_TRIGGER_DURATION = 200;
    public static final int BRAND_IMAGE_HEIGTH = 142;
    public static final int CIRCLE_BG_LIGHT = -328966;
    public static final int CIRCLE_DIAMETER = 23;
    public static final float DECELERATE_INTERPOLATION_FACTOR = 2.0f;
    public static final int DEFAULT_CIRCLE_TARGET = 46;
    public static final float DRAG_RATE = 0.5f;
    public static final int INVALID_POINTER = -1;
    public static final int[] LAYOUT_ATTRS = {16842766};
    public static final String LOG_TAG = SwipeRefreshLayout.class.getSimpleName();
    public static final int MAX_ALPHA = 255;
    public static final int OFFSET_TIME_BY_BRANCH = 300;
    public static final int SCALE_DOWN_DURATION = 200;
    public static final String TAG = "CustomSwipeRefreshLayout";
    public int mActivePointerId;
    public final Animation mAnimateToCorrectPosition;
    public final Animation mAnimateToStartPosition;
    public int mBrandHegigt;
    public int mBrandTime;
    public CircleImageWithTextView mCircleView;
    public int mCircleViewIndex;
    public int mCurrentTargetOffsetTop;
    public final DecelerateInterpolator mDecelerateInterpolator;
    public int mFrom;
    public float mInitialDownY;
    public float mInitialMotionY;
    public boolean mIsBeingDragged;
    public OnRefreshListener mListener;
    public View mLoadingBg;
    public int mMediumAnimationDuration;
    public boolean mNestedScrollInProgress;
    public final NestedScrollingChildHelper mNestedScrollingChildHelper;
    public final NestedScrollingParentHelper mNestedScrollingParentHelper;
    public boolean mNotify;
    public boolean mOriginalOffsetCalculated;
    public int mOriginalOffsetTop;
    public final int[] mParentOffsetInWindow;
    public final int[] mParentScrollConsumed;
    public Animation.AnimationListener mRefreshListener;
    public boolean mRefreshing;
    public boolean mReturningToStart;
    public boolean mScale;
    public Animation mScaleAnimation;
    public Animation mScaleDownAnimation;
    public Animation mScaleDownToStartAnimation;
    public float mSpinnerFinalOffset;
    public float mStartingScale;
    public View mTarget;
    public float mTotalDragDistance;
    public float mTotalUnconsumed;
    public int mTouchSlop;
    public boolean mUsingCustomStart;
    public int margintop;

    public interface OnRefreshListener {
        void onRefresh();
    }

    public class ad extends Animation {
        public ad() {
        }

        public void applyTransformation(float f, Transformation transformation) {
            CustomSwipeRefreshLayout.this.setAnimationProgress(f);
        }
    }

    public class de extends Animation {
        public de() {
        }

        public void applyTransformation(float f, Transformation transformation) {
            CustomSwipeRefreshLayout.this.moveToStart(f);
        }
    }

    public class fe implements Animation.AnimationListener {
        public fe() {
        }

        public void onAnimationEnd(Animation animation) {
            if (!CustomSwipeRefreshLayout.this.mScale) {
                CustomSwipeRefreshLayout.this.startScaleDownAnimation((Animation.AnimationListener) null);
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public class qw implements Animation.AnimationListener {
        public qw() {
        }

        public void onAnimationEnd(Animation animation) {
            if (CustomSwipeRefreshLayout.this.mRefreshing) {
                CustomSwipeRefreshLayout.this.mCircleView.start();
                if (CustomSwipeRefreshLayout.this.mNotify && CustomSwipeRefreshLayout.this.mListener != null) {
                    CustomSwipeRefreshLayout.this.mListener.onRefresh();
                }
                CustomSwipeRefreshLayout customSwipeRefreshLayout = CustomSwipeRefreshLayout.this;
                int unused = customSwipeRefreshLayout.mCurrentTargetOffsetTop = customSwipeRefreshLayout.mCircleView.getTop();
                return;
            }
            CustomSwipeRefreshLayout.this.reset();
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public class rg extends Animation {
        public rg() {
        }

        public void applyTransformation(float f, Transformation transformation) {
            int i2;
            if (!CustomSwipeRefreshLayout.this.mUsingCustomStart) {
                i2 = CustomSwipeRefreshLayout.this.margintop;
            } else {
                i2 = ((int) CustomSwipeRefreshLayout.this.mSpinnerFinalOffset) + o.qw((float) CustomSwipeRefreshLayout.this.mBrandHegigt);
            }
            CustomSwipeRefreshLayout customSwipeRefreshLayout = CustomSwipeRefreshLayout.this;
            int i3 = customSwipeRefreshLayout.mFrom;
            customSwipeRefreshLayout.mTarget.setTranslationY((float) CustomSwipeRefreshLayout.this.getCircleViewHeight());
            CustomSwipeRefreshLayout.this.setTargetOffsetTopAndBottom(i3 + ((int) (((float) (i2 - i3)) * f)), false);
        }
    }

    public class th extends Animation {
        public th() {
        }

        public void applyTransformation(float f, Transformation transformation) {
            CustomSwipeRefreshLayout.this.moveToStart(f);
        }
    }

    public class yj extends Animation {
        public yj() {
        }

        public void applyTransformation(float f, Transformation transformation) {
            CustomSwipeRefreshLayout.this.moveToStart(f);
        }
    }

    public CustomSwipeRefreshLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private void animateOffsetToCorrectPosition(int i2, Animation.AnimationListener animationListener) {
        this.mFrom = i2;
        this.mAnimateToCorrectPosition.reset();
        this.mAnimateToCorrectPosition.setDuration((long) (this.mBrandTime + 200));
        this.mAnimateToCorrectPosition.setInterpolator(this.mDecelerateInterpolator);
        if (animationListener != null) {
            this.mCircleView.setAnimationListener(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mAnimateToCorrectPosition);
    }

    private void animateOffsetToStartPosition(int i2, Animation.AnimationListener animationListener) {
        if (this.mScale) {
            startScaleDownReturnToStartAnimation(i2, animationListener);
            return;
        }
        this.mFrom = i2;
        this.mAnimateToStartPosition.reset();
        this.mAnimateToStartPosition.setDuration(200);
        this.mAnimateToStartPosition.setInterpolator(this.mDecelerateInterpolator);
        if (animationListener != null) {
            this.mCircleView.setAnimationListener(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mAnimateToStartPosition);
    }

    public static final void canRefresh(CustomSwipeRefreshLayout customSwipeRefreshLayout, boolean z) {
        if (customSwipeRefreshLayout != null) {
            customSwipeRefreshLayout.setEnabled(z);
        }
    }

    private void createProgressView() {
        CircleImageWithTextView circleImageWithTextView = new CircleImageWithTextView(getContext(), -328966, 11.0f);
        this.mCircleView = circleImageWithTextView;
        circleImageWithTextView.setVisibility(8);
        addView(this.mCircleView);
        View view = new View(getContext());
        this.mLoadingBg = view;
        view.setBackgroundColor(fe.mmm.qw.d.de.de.when().i(R.color.transparent));
        addView(this.mLoadingBg);
    }

    private void ensureTarget() {
        if (this.mTarget == null) {
            int i2 = 0;
            while (i2 < getChildCount()) {
                View childAt = getChildAt(i2);
                if (childAt.equals(this.mCircleView) || childAt.equals(this.mLoadingBg)) {
                    i2++;
                } else {
                    this.mTarget = childAt;
                    return;
                }
            }
        }
    }

    private void finishSpinner(float f) {
        if (f > this.mTotalDragDistance + ((float) o.qw((float) this.mBrandHegigt))) {
            setRefreshing(true, true);
            return;
        }
        this.mRefreshing = false;
        fe feVar = null;
        if (!this.mScale) {
            feVar = new fe();
        }
        animateOffsetToStartPosition(this.mCurrentTargetOffsetTop, feVar);
    }

    /* access modifiers changed from: private */
    public int getCircleViewHeight() {
        int i2 = o.ad(this.mCircleView)[1];
        if (i2 <= 0) {
            return 64;
        }
        return i2;
    }

    private float getMotionEventY(MotionEvent motionEvent, int i2) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i2);
        if (findPointerIndex < 0) {
            return -1.0f;
        }
        return MotionEventCompat.getY(motionEvent, findPointerIndex);
    }

    private boolean isAlphaUsedForScale() {
        return Build.VERSION.SDK_INT < 11;
    }

    private void moveSpinner(float f) {
        if (this.mCircleView.getVisibility() != 0) {
            this.mCircleView.start();
            this.mCircleView.setVisibility(0);
            this.mLoadingBg.setVisibility(0);
        }
        if (!this.mScale) {
            ViewCompat.setScaleX(this.mCircleView, 1.0f);
            ViewCompat.setScaleY(this.mCircleView, 1.0f);
        }
        this.mTarget.setTranslationY(f);
        setTargetOffsetTopAndBottom((int) (((f - this.mSpinnerFinalOffset) - ((float) o.qw((float) this.mBrandHegigt))) + ((float) this.margintop)), true);
    }

    /* access modifiers changed from: private */
    public void moveToStart(float f) {
        int i2 = this.mFrom;
        int i3 = i2 + ((int) (((float) (this.mOriginalOffsetTop - i2)) * f));
        this.mCircleView.getTop();
        setTargetOffsetTopAndBottom(i3, false);
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.mActivePointerId) {
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex == 0 ? 1 : 0);
        }
    }

    /* access modifiers changed from: private */
    public void reset() {
        this.mCircleView.clearAnimation();
        this.mCircleView.stop();
        this.mCircleView.setVisibility(8);
        this.mLoadingBg.setVisibility(8);
        setColorViewAlpha(255);
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
    }

    /* access modifiers changed from: private */
    public void setAnimationProgress(float f) {
        if (isAlphaUsedForScale()) {
            setColorViewAlpha((int) (f * 255.0f));
            return;
        }
        ViewCompat.setScaleX(this.mCircleView, f);
        ViewCompat.setScaleY(this.mCircleView, f);
    }

    private void setColorViewAlpha(int i2) {
        this.mCircleView.setAlpha((float) i2);
    }

    public static final void setIsRefreshing(CustomSwipeRefreshLayout customSwipeRefreshLayout, boolean z) {
        if (customSwipeRefreshLayout != null) {
            customSwipeRefreshLayout.setRefreshing(z);
        }
    }

    /* access modifiers changed from: private */
    public void setTargetOffsetTopAndBottom(int i2, boolean z) {
        this.mCircleView.bringToFront();
        this.mCircleView.setTop(i2);
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
        if (z && Build.VERSION.SDK_INT < 11) {
            invalidate();
        }
    }

    /* access modifiers changed from: private */
    public void startScaleDownAnimation(Animation.AnimationListener animationListener) {
        de deVar = new de();
        this.mScaleDownAnimation = deVar;
        deVar.setDuration((long) (this.mBrandTime + 200));
        this.mCircleView.setAnimationListener(animationListener);
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownAnimation);
        this.mTarget.animate().translationY(0.0f).setDuration((long) (this.mBrandTime + 200)).start();
    }

    private void startScaleDownReturnToStartAnimation(int i2, Animation.AnimationListener animationListener) {
        this.mFrom = i2;
        yj yjVar = new yj();
        this.mScaleDownToStartAnimation = yjVar;
        yjVar.setDuration((long) (this.mBrandTime + 200));
        if (animationListener != null) {
            this.mCircleView.setAnimationListener(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownToStartAnimation);
        this.mTarget.animate().translationY(0.0f).setDuration((long) (this.mBrandTime + 200)).start();
    }

    private void startScaleUpAnimation(Animation.AnimationListener animationListener) {
        this.mCircleView.setVisibility(0);
        this.mLoadingBg.setVisibility(0);
        ad adVar = new ad();
        this.mScaleAnimation = adVar;
        adVar.setDuration((long) (this.mMediumAnimationDuration + this.mBrandTime));
        if (animationListener != null) {
            this.mCircleView.setAnimationListener(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleAnimation);
    }

    public boolean canChildScrollUp() {
        if (Build.VERSION.SDK_INT >= 14) {
            return ViewCompat.canScrollVertically(this.mTarget, -1);
        }
        View view = this.mTarget;
        if (view instanceof AbsListView) {
            AbsListView absListView = (AbsListView) view;
            if (absListView.getChildCount() <= 0 || (absListView.getFirstVisiblePosition() <= 0 && absListView.getChildAt(0).getTop() >= absListView.getPaddingTop())) {
                return false;
            }
            return true;
        } else if (ViewCompat.canScrollVertically(view, -1) || this.mTarget.getScrollY() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.mNestedScrollingChildHelper.dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreFling(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.mNestedScrollingChildHelper.dispatchNestedScroll(i2, i3, i4, i5, iArr);
    }

    public int getChildDrawingOrder(int i2, int i3) {
        int i4 = this.mCircleViewIndex;
        if (i4 < 0) {
            return i3;
        }
        if (i3 == i2 - 1) {
            return i4;
        }
        return i3 >= i4 ? i3 + 1 : i3;
    }

    public View getCircleView() {
        return this.mCircleView;
    }

    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.getNestedScrollAxes();
    }

    public boolean hasNestedScrollingParent() {
        return this.mNestedScrollingChildHelper.hasNestedScrollingParent();
    }

    public boolean isNestedScrollingEnabled() {
        return this.mNestedScrollingChildHelper.isNestedScrollingEnabled();
    }

    public boolean isRefreshing() {
        return this.mRefreshing;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        View view = this.mTarget;
        if (!(view == null || view.getTranslationY() == 0.0f)) {
            setRefreshing(false, false);
        }
        reset();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ensureTarget();
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (this.mReturningToStart && actionMasked == 0) {
            this.mReturningToStart = false;
        }
        updateDarkBg();
        if (!isEnabled() || this.mReturningToStart || canChildScrollUp() || this.mRefreshing || this.mNestedScrollInProgress) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i2 = this.mActivePointerId;
                    if (i2 == -1) {
                        return false;
                    }
                    float motionEventY = getMotionEventY(motionEvent, i2);
                    if (motionEventY == -1.0f) {
                        return false;
                    }
                    float f = this.mInitialDownY;
                    int i3 = this.mTouchSlop;
                    if (motionEventY - f > ((float) i3) && !this.mIsBeingDragged) {
                        this.mInitialMotionY = f + ((float) i3);
                        this.mIsBeingDragged = true;
                        this.mCircleView.start();
                    }
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        onSecondaryPointerUp(motionEvent);
                    }
                }
            }
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
        } else {
            int pointerId = MotionEventCompat.getPointerId(motionEvent, 0);
            this.mActivePointerId = pointerId;
            this.mIsBeingDragged = false;
            float motionEventY2 = getMotionEventY(motionEvent, pointerId);
            if (motionEventY2 == -1.0f) {
                return false;
            }
            this.mInitialDownY = motionEventY2;
        }
        return this.mIsBeingDragged;
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.mTarget == null) {
                ensureTarget();
            }
            View view = this.mTarget;
            if (view != null) {
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                int paddingLeft2 = (measuredWidth - getPaddingLeft()) - getPaddingRight();
                int paddingTop2 = (measuredHeight - getPaddingTop()) - getPaddingBottom();
                int measuredWidth2 = this.mCircleView.getMeasuredWidth();
                int measuredHeight2 = this.mCircleView.getMeasuredHeight();
                view.layout(paddingLeft, paddingTop, paddingLeft2 + paddingLeft, paddingTop2 + paddingTop);
                int i6 = measuredWidth / 2;
                int i7 = measuredWidth2 / 2;
                int i8 = this.mCurrentTargetOffsetTop;
                this.mCircleView.layout(i6 - i7, i8, i6 + i7, i8 + measuredHeight2);
                int i9 = this.mCurrentTargetOffsetTop;
                if (i9 > 0) {
                    measuredHeight2 += i9;
                }
                this.mLoadingBg.layout(0, 0, measuredWidth, measuredHeight2);
            }
        }
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.mTarget == null) {
            ensureTarget();
        }
        View view = this.mTarget;
        if (view != null) {
            view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.mCircleView.measure(0, 0);
            this.mLoadingBg.measure(0, 0);
            if (!this.mUsingCustomStart && !this.mOriginalOffsetCalculated) {
                this.mOriginalOffsetCalculated = true;
                int i4 = -this.mCircleView.getMeasuredHeight();
                this.mOriginalOffsetTop = i4;
                this.mCurrentTargetOffsetTop = i4;
            }
            this.mCircleViewIndex = -1;
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                if (getChildAt(i5) == this.mCircleView) {
                    this.mCircleViewIndex = i5;
                    return;
                }
            }
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        if (i3 > 0) {
            float f = this.mTotalUnconsumed;
            if (f > 0.0f) {
                float f2 = (float) i3;
                if (f2 > f) {
                    iArr[1] = i3 - ((int) f);
                    this.mTotalUnconsumed = 0.0f;
                } else {
                    this.mTotalUnconsumed = f - f2;
                    iArr[1] = i3;
                }
                moveSpinner(this.mTotalUnconsumed);
            }
        }
        if (this.mUsingCustomStart && i3 > 0 && this.mTotalUnconsumed == 0.0f && Math.abs(i3 - iArr[1]) > 0) {
            this.mCircleView.setVisibility(8);
        }
        int[] iArr2 = this.mParentScrollConsumed;
        if (dispatchNestedPreScroll(i2 - iArr[0], i3 - iArr[1], iArr2, (int[]) null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        dispatchNestedScroll(i2, i3, i4, i5, this.mParentOffsetInWindow);
        int i6 = i5 + this.mParentOffsetInWindow[1];
        if (i6 < 0) {
            float abs = this.mTotalUnconsumed + ((float) Math.abs(i6));
            this.mTotalUnconsumed = abs;
            moveSpinner(abs);
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.mNestedScrollingParentHelper.onNestedScrollAccepted(view, view2, i2);
        startNestedScroll(i2 & 2);
        this.mTotalUnconsumed = 0.0f;
        this.mNestedScrollInProgress = true;
    }

    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return isEnabled() && canChildScrollUp() && !this.mReturningToStart && !this.mRefreshing && (i2 & 2) != 0;
    }

    public void onStopNestedScroll(View view) {
        this.mNestedScrollingParentHelper.onStopNestedScroll(view);
        this.mNestedScrollInProgress = false;
        float f = this.mTotalUnconsumed;
        if (f > 0.0f) {
            finishSpinner(f);
            this.mTotalUnconsumed = 0.0f;
        }
        stopNestedScroll();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (this.mReturningToStart && actionMasked == 0) {
            this.mReturningToStart = false;
        }
        if (!isEnabled() || this.mReturningToStart || canChildScrollUp() || this.mNestedScrollInProgress) {
            return false;
        }
        if (actionMasked == 0) {
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
            this.mIsBeingDragged = false;
        } else if (actionMasked == 1) {
            int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId);
            if (findPointerIndex < 0) {
                return false;
            }
            this.mIsBeingDragged = false;
            finishSpinner((MotionEventCompat.getY(motionEvent, findPointerIndex) - this.mInitialMotionY) * 0.5f);
            this.mActivePointerId = -1;
            return false;
        } else if (actionMasked == 2) {
            int findPointerIndex2 = MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId);
            if (findPointerIndex2 < 0) {
                return false;
            }
            float y = MotionEventCompat.getY(motionEvent, findPointerIndex2);
            if (y == -1.0f) {
                return false;
            }
            float f = this.mInitialDownY;
            int i2 = this.mTouchSlop;
            if (y - f > ((float) i2) && !this.mIsBeingDragged) {
                this.mInitialMotionY = f + ((float) i2);
                this.mIsBeingDragged = true;
                this.mCircleView.start();
            }
            float f2 = (y - this.mInitialMotionY) * 0.5f;
            if (this.mIsBeingDragged) {
                if (f2 <= 0.0f) {
                    return false;
                }
                moveSpinner(f2);
            }
        } else if (actionMasked == 3) {
            return false;
        } else {
            if (actionMasked == 5) {
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                if (actionIndex < 0) {
                    return false;
                }
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
            } else if (actionMasked != 6) {
                return true;
            } else {
                onSecondaryPointerUp(motionEvent);
            }
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (Build.VERSION.SDK_INT >= 21 || !(this.mTarget instanceof AbsListView)) {
            View view = this.mTarget;
            if (view == null || ViewCompat.isNestedScrollingEnabled(view)) {
                super.requestDisallowInterceptTouchEvent(z);
            }
        }
    }

    public void setBrandImageBackground(int i2) {
        CircleImageWithTextView circleImageWithTextView = this.mCircleView;
        if (circleImageWithTextView != null) {
            circleImageWithTextView.setBrandImageBackground(i2);
        }
    }

    public void setBrandTime(int i2) {
        this.mBrandTime = i2;
    }

    public void setBrandViewClickbale() {
        this.mCircleView.setBrandViewClickbale();
    }

    @Deprecated
    public void setColorScheme(@ColorInt int... iArr) {
        setColorSchemeResources(iArr);
    }

    @ColorInt
    public void setColorSchemeColors(int... iArr) {
        ensureTarget();
    }

    public void setColorSchemeResources(@ColorRes int... iArr) {
        Resources resources = getResources();
        int[] iArr2 = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr2[i2] = resources.getColor(iArr[i2]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.mNestedScrollingChildHelper.setNestedScrollingEnabled(z);
    }

    public void setOffsetHeight(int i2) {
        this.mBrandHegigt = i2;
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.mListener = onRefreshListener;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i2) {
        setProgressBackgroundColorSchemeResource(i2);
    }

    public void setProgressBackgroundColorSchemeColor(@ColorInt int i2) {
        this.mCircleView.setBackgroundColor(i2);
    }

    public void setProgressBackgroundColorSchemeResource(@ColorRes int i2) {
        setProgressBackgroundColorSchemeColor(getResources().getColor(i2));
    }

    public void setRefreshing(boolean z) {
        int i2;
        if (!z || this.mRefreshing == z) {
            setRefreshing(z, false);
            return;
        }
        this.mRefreshing = z;
        if (!this.mUsingCustomStart) {
            i2 = (int) (this.mSpinnerFinalOffset + ((float) o.qw((float) this.mBrandHegigt)) + ((float) this.mOriginalOffsetTop));
        } else {
            i2 = ((int) this.mSpinnerFinalOffset) + o.qw((float) this.mBrandHegigt);
        }
        setTargetOffsetTopAndBottom(i2 - this.mCurrentTargetOffsetTop, true);
        this.mNotify = false;
        startScaleUpAnimation(this.mRefreshListener);
        View view = this.mTarget;
        if (view != null) {
            view.animate().translationY((float) getCircleViewHeight()).setDuration((long) (this.mBrandTime + 200)).start();
        }
    }

    public void setText(String str) {
        this.mCircleView.setText(str);
    }

    public void setViewHight(int i2) {
        this.mCircleView.setViewHeigth(i2);
    }

    public boolean startNestedScroll(int i2) {
        return this.mNestedScrollingChildHelper.startNestedScroll(i2);
    }

    public void stopNestedScroll() {
        this.mNestedScrollingChildHelper.stopNestedScroll();
    }

    public void updateDarkBg() {
        this.mLoadingBg.setBackgroundColor(fe.mmm.qw.d.de.de.when().i(R.color.transparent));
    }

    public CustomSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBrandHegigt = 0;
        this.mBrandTime = 0;
        this.mRefreshing = false;
        this.mTotalDragDistance = -1.0f;
        this.mParentScrollConsumed = new int[2];
        this.mParentOffsetInWindow = new int[2];
        this.mOriginalOffsetCalculated = false;
        this.mActivePointerId = -1;
        this.mScale = true;
        this.mCircleViewIndex = -1;
        this.mUsingCustomStart = false;
        this.margintop = 10;
        this.mRefreshListener = new qw();
        this.mAnimateToCorrectPosition = new rg();
        this.mAnimateToStartPosition = new th();
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mMediumAnimationDuration = getResources().getInteger(17694721);
        this.mMediumAnimationDuration = 300;
        setWillNotDraw(false);
        this.mDecelerateInterpolator = new DecelerateInterpolator(2.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, LAYOUT_ATTRS);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
        createProgressView();
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        float qw2 = (float) o.qw(46.0f);
        this.mSpinnerFinalOffset = qw2;
        this.mTotalDragDistance = qw2;
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        this.mNestedScrollingChildHelper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
    }

    private void setRefreshing(boolean z, boolean z2) {
        if (this.mRefreshing != z) {
            this.mNotify = z2;
            ensureTarget();
            this.mRefreshing = z;
            if (z) {
                animateOffsetToCorrectPosition(this.margintop, this.mRefreshListener);
            } else {
                startScaleDownAnimation(this.mRefreshListener);
            }
        }
    }
}
