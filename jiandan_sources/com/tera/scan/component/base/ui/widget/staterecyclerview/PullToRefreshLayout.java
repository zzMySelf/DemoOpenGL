package com.tera.scan.component.base.ui.widget.staterecyclerview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.baidu.wallet.base.iddetect.utils.CameraUtilsForScan;
import com.mars.kotlin.extension.Logger;
import com.tera.scan.ui.widget.RotateProgress;

public class PullToRefreshLayout extends ViewGroup {
    public static final int ANIMATE_TO_START_DURATION = 200;
    public static final int ANIMATE_TO_TRIGGER_DURATION = 200;
    public static final float DECELERATE_INTERPOLATION_FACTOR = 2.0f;
    public static final int DEFAULT_CIRCLE_TARGET = 64;
    public static final float DRAG_RATE = 0.5f;
    public static final int HEADER_VIEW_HEIGHT = 50;
    public static final int INVALID_POINTER = -1;
    public static final int[] LAYOUT_ATTRS = {16842766};
    public static final String LOG_TAG = "PullToRefreshLayout";
    public static final int SCALE_DOWN_DURATION = 150;
    public CircleProgressView defaultProgressView;
    public float density;
    public boolean enablePullEvent;
    public boolean enablePushEvent;
    public boolean isProgressEnable;
    public int mActivePointerId;
    public final Animation mAnimateToCorrectPosition;
    public final Animation mAnimateToStartPosition;
    public int mCurrentTargetOffsetTop;
    public CustomChildScroller mCustomChildScroller;
    public final DecelerateInterpolator mDecelerateInterpolator;
    public RelativeLayout mFooterViewContainer;
    public int mFooterViewHeight;
    public int mFooterViewIndex;
    public int mFooterViewWidth;
    public int mFrom;
    public pf mHeadViewContainer;
    public int mHeaderViewHeight;
    public int mHeaderViewIndex;
    public int mHeaderViewWidth;
    public float mInitialMotionY;
    public boolean mIsBeingDragged;
    public OnPullRefreshListener mListener;
    public boolean mLoadMore;
    public int mMediumAnimationDuration;
    public boolean mNotify;
    public OnPushLoadMoreListener mOnPushLoadMoreListener;
    public boolean mOriginalOffsetCalculated;
    public int mOriginalOffsetTop;
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
    public int mTouchSlop;
    public boolean mUsingCustomStart;
    public int pushDistance;
    public boolean targetScrollWithLayout;
    public boolean usingDefaultHeader;
    public float xDistance;
    public float xLast;
    public float yDistance;
    public float yLast;

    public interface CustomChildScroller {
        boolean qw(int i2);
    }

    public interface OnPullRefreshListener {
        void ad(boolean z);

        void onRefresh();

        void qw(int i2);
    }

    public interface OnPushLoadMoreListener {
        void ad(boolean z);

        void de(int i2);

        void qw();
    }

    public class ad implements Animation.AnimationListener {
        public ad() {
        }

        public void onAnimationEnd(Animation animation) {
            boolean unused = PullToRefreshLayout.this.isProgressEnable = true;
            if (!PullToRefreshLayout.this.mRefreshing) {
                PullToRefreshLayout.this.mHeadViewContainer.setVisibility(8);
                if (PullToRefreshLayout.this.mScale) {
                    PullToRefreshLayout.this.setAnimationProgress(0.0f);
                } else {
                    PullToRefreshLayout pullToRefreshLayout = PullToRefreshLayout.this;
                    pullToRefreshLayout.setTargetOffsetTopAndBottom(pullToRefreshLayout.mOriginalOffsetTop - pullToRefreshLayout.mCurrentTargetOffsetTop, true);
                }
            } else if (PullToRefreshLayout.this.mNotify) {
                if (PullToRefreshLayout.this.usingDefaultHeader) {
                    ViewCompat.setAlpha(PullToRefreshLayout.this.defaultProgressView, 1.0f);
                    PullToRefreshLayout.this.defaultProgressView.setOnDraw(true);
                    new Thread(PullToRefreshLayout.this.defaultProgressView).start();
                }
                if (PullToRefreshLayout.this.mListener != null) {
                    PullToRefreshLayout.this.mListener.onRefresh();
                }
            }
            PullToRefreshLayout pullToRefreshLayout2 = PullToRefreshLayout.this;
            int unused2 = pullToRefreshLayout2.mCurrentTargetOffsetTop = pullToRefreshLayout2.mHeadViewContainer.getTop();
            PullToRefreshLayout.this.updateListenerCallBack();
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
            boolean unused = PullToRefreshLayout.this.isProgressEnable = false;
        }
    }

    public class de extends Animation {
        public de() {
        }

        public void applyTransformation(float f, Transformation transformation) {
            PullToRefreshLayout.this.setAnimationProgress(f);
        }
    }

    public class fe extends Animation {
        public fe() {
        }

        public void applyTransformation(float f, Transformation transformation) {
            PullToRefreshLayout.this.setAnimationProgress(1.0f - f);
        }
    }

    public class i extends Animation {
        public i() {
        }

        public void applyTransformation(float f, Transformation transformation) {
            float f2;
            if (!PullToRefreshLayout.this.mUsingCustomStart) {
                f2 = PullToRefreshLayout.this.mSpinnerFinalOffset - ((float) Math.abs(PullToRefreshLayout.this.mOriginalOffsetTop));
            } else {
                f2 = PullToRefreshLayout.this.mSpinnerFinalOffset;
            }
            PullToRefreshLayout pullToRefreshLayout = PullToRefreshLayout.this;
            int i2 = pullToRefreshLayout.mFrom;
            PullToRefreshLayout.this.setTargetOffsetTopAndBottom((i2 + ((int) (((float) (((int) f2) - i2)) * f))) - pullToRefreshLayout.mHeadViewContainer.getTop(), false);
        }

        public void setAnimationListener(Animation.AnimationListener animationListener) {
            super.setAnimationListener(animationListener);
        }
    }

    public class o extends Animation {
        public o() {
        }

        public void applyTransformation(float f, Transformation transformation) {
            PullToRefreshLayout.this.moveToStart(f);
        }
    }

    public class pf extends RelativeLayout {

        /* renamed from: ad  reason: collision with root package name */
        public Animation.AnimationListener f6862ad;

        public pf(Context context) {
            super(context);
        }

        public void onAnimationEnd() {
            super.onAnimationEnd();
            Animation.AnimationListener animationListener = this.f6862ad;
            if (animationListener != null) {
                animationListener.onAnimationEnd(getAnimation());
            }
        }

        public void onAnimationStart() {
            super.onAnimationStart();
            Animation.AnimationListener animationListener = this.f6862ad;
            if (animationListener != null) {
                animationListener.onAnimationStart(getAnimation());
            }
        }

        public void qw(Animation.AnimationListener animationListener) {
            this.f6862ad = animationListener;
        }
    }

    public class qw extends Animation {
        public qw() {
        }

        public void applyTransformation(float f, Transformation transformation) {
            PullToRefreshLayout.this.setAnimationProgress(PullToRefreshLayout.this.mStartingScale + ((-PullToRefreshLayout.this.mStartingScale) * f));
            PullToRefreshLayout.this.moveToStart(f);
        }
    }

    public class rg implements Animation.AnimationListener {
        public rg() {
        }

        public void onAnimationEnd(Animation animation) {
            if (!PullToRefreshLayout.this.mScale) {
                PullToRefreshLayout.this.startScaleDownAnimation((Animation.AnimationListener) null);
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public class th implements ValueAnimator.AnimatorUpdateListener {
        public th() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int unused = PullToRefreshLayout.this.pushDistance = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            PullToRefreshLayout.this.updateFooterViewPosition();
        }
    }

    public class uk implements Runnable {
        public uk() {
        }

        public void run() {
            PullToRefreshLayout.this.resetTargetLayout();
        }
    }

    public class yj extends AnimatorListenerAdapter {
        public final /* synthetic */ int qw;

        public yj(int i2) {
            this.qw = i2;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.qw <= 0 || PullToRefreshLayout.this.mOnPushLoadMoreListener == null) {
                PullToRefreshLayout.this.resetTargetLayout();
                boolean unused = PullToRefreshLayout.this.mLoadMore = false;
                return;
            }
            boolean unused2 = PullToRefreshLayout.this.mLoadMore = true;
            PullToRefreshLayout.this.mOnPushLoadMoreListener.qw();
        }
    }

    public PullToRefreshLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private void animateOffsetToCorrectPosition(int i2, Animation.AnimationListener animationListener) {
        this.mFrom = i2;
        this.mAnimateToCorrectPosition.reset();
        this.mAnimateToCorrectPosition.setDuration(200);
        this.mAnimateToCorrectPosition.setInterpolator(this.mDecelerateInterpolator);
        if (animationListener != null) {
            this.mHeadViewContainer.qw(animationListener);
        }
        this.mHeadViewContainer.clearAnimation();
        this.mHeadViewContainer.startAnimation(this.mAnimateToCorrectPosition);
    }

    private void animateOffsetToStartPosition(int i2, Animation.AnimationListener animationListener) {
        if (this.mScale) {
            startScaleDownReturnToStartAnimation(i2, animationListener);
        } else {
            this.mFrom = i2;
            this.mAnimateToStartPosition.reset();
            this.mAnimateToStartPosition.setDuration(200);
            this.mAnimateToStartPosition.setInterpolator(this.mDecelerateInterpolator);
            if (animationListener != null) {
                this.mHeadViewContainer.qw(animationListener);
            }
            this.mHeadViewContainer.clearAnimation();
            this.mHeadViewContainer.startAnimation(this.mAnimateToStartPosition);
        }
        resetTargetLayoutDelay(200);
    }

    @TargetApi(11)
    private void animatorFooterToBottom(int i2, int i3) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i2, i3});
        ofInt.setDuration(150);
        ofInt.addUpdateListener(new th());
        ofInt.addListener(new yj(i3));
        ofInt.setInterpolator(this.mDecelerateInterpolator);
        ofInt.start();
    }

    private void createFooterViewContainer() {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.mFooterViewContainer = relativeLayout;
        relativeLayout.setVisibility(8);
        addView(this.mFooterViewContainer);
    }

    private void createHeaderViewContainer() {
        int i2 = this.mHeaderViewHeight;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (((double) i2) * 0.8d), (int) (((double) i2) * 0.8d));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        pf pfVar = new pf(getContext());
        this.mHeadViewContainer = pfVar;
        pfVar.setVisibility(8);
        this.defaultProgressView.setVisibility(0);
        this.defaultProgressView.setOnDraw(false);
        this.mHeadViewContainer.addView(this.defaultProgressView, layoutParams);
        addView(this.mHeadViewContainer);
    }

    private void ensureTarget() {
        if (this.mTarget == null) {
            int i2 = 0;
            while (i2 < getChildCount()) {
                View childAt = getChildAt(i2);
                if (childAt.equals(this.mHeadViewContainer) || childAt.equals(this.mFooterViewContainer)) {
                    i2++;
                } else {
                    this.mTarget = childAt;
                    return;
                }
            }
        }
    }

    private float getMotionEventY(MotionEvent motionEvent, int i2) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i2);
        if (findPointerIndex < 0) {
            return -1.0f;
        }
        return MotionEventCompat.getY(motionEvent, findPointerIndex);
    }

    private boolean handlerPullTouchEvent(MotionEvent motionEvent, int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId);
                    if (findPointerIndex < 0) {
                        boolean enable = Logger.INSTANCE.getEnable();
                        return false;
                    }
                    float y = (MotionEventCompat.getY(motionEvent, findPointerIndex) - this.mInitialMotionY) * 0.5f;
                    if (this.mIsBeingDragged) {
                        float f = y / this.mTotalDragDistance;
                        if (f < 0.0f) {
                            return false;
                        }
                        float f2 = 1.0f;
                        float min = Math.min(1.0f, Math.abs(f));
                        float abs = Math.abs(y) - this.mTotalDragDistance;
                        float f3 = this.mUsingCustomStart ? this.mSpinnerFinalOffset - ((float) this.mOriginalOffsetTop) : this.mSpinnerFinalOffset;
                        double max = (double) (Math.max(0.0f, Math.min(abs, f3 * 2.0f) / f3) / 4.0f);
                        int pow = this.mOriginalOffsetTop + ((int) ((f3 * min) + (((float) (max - Math.pow(max, 2.0d))) * 2.0f * f3 * 2.0f)));
                        if (this.mHeadViewContainer.getVisibility() != 0) {
                            this.mHeadViewContainer.setVisibility(0);
                        }
                        if (!this.mScale) {
                            ViewCompat.setScaleX(this.mHeadViewContainer, 1.0f);
                            ViewCompat.setScaleY(this.mHeadViewContainer, 1.0f);
                        }
                        if (this.usingDefaultHeader) {
                            float f4 = y / this.mTotalDragDistance;
                            if (f4 < 1.0f) {
                                f2 = f4;
                            }
                            ViewCompat.setScaleX(this.defaultProgressView, f2);
                            ViewCompat.setScaleY(this.defaultProgressView, f2);
                            ViewCompat.setAlpha(this.defaultProgressView, f2);
                        }
                        float f5 = this.mTotalDragDistance;
                        if (y < f5) {
                            if (this.mScale) {
                                setAnimationProgress(y / f5);
                            }
                            OnPullRefreshListener onPullRefreshListener = this.mListener;
                            if (onPullRefreshListener != null) {
                                onPullRefreshListener.ad(false);
                            }
                        } else {
                            OnPullRefreshListener onPullRefreshListener2 = this.mListener;
                            if (onPullRefreshListener2 != null) {
                                onPullRefreshListener2.ad(true);
                            }
                        }
                        setTargetOffsetTopAndBottom(pow - this.mCurrentTargetOffsetTop, true);
                    }
                } else if (i2 != 3) {
                    if (i2 == 5) {
                        this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                    } else if (i2 == 6) {
                        onSecondaryPointerUp(motionEvent);
                    }
                }
            }
            int i3 = this.mActivePointerId;
            if (i3 == -1) {
                if (i2 == 1) {
                    boolean enable2 = Logger.INSTANCE.getEnable();
                }
                return false;
            }
            this.mIsBeingDragged = false;
            if ((MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, i3)) - this.mInitialMotionY) * 0.5f > this.mTotalDragDistance) {
                setRefreshing(true, true);
            } else {
                this.mRefreshing = false;
                rg rgVar = null;
                if (!this.mScale) {
                    rgVar = new rg();
                }
                animateOffsetToStartPosition(this.mCurrentTargetOffsetTop, rgVar);
            }
            this.mActivePointerId = -1;
            return false;
        }
        this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
        this.mIsBeingDragged = false;
        return true;
    }

    private boolean handlerPushTouchEvent(MotionEvent motionEvent, int i2) {
        OnPushLoadMoreListener onPushLoadMoreListener;
        boolean z = false;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId);
                    if (findPointerIndex < 0) {
                        boolean enable = Logger.INSTANCE.getEnable();
                        return false;
                    }
                    float y = (this.mInitialMotionY - MotionEventCompat.getY(motionEvent, findPointerIndex)) * 0.5f;
                    if (this.mIsBeingDragged) {
                        this.pushDistance = (int) y;
                        updateFooterViewPosition();
                        OnPushLoadMoreListener onPushLoadMoreListener2 = this.mOnPushLoadMoreListener;
                        if (onPushLoadMoreListener2 != null) {
                            if (this.pushDistance >= this.mFooterViewHeight) {
                                z = true;
                            }
                            onPushLoadMoreListener2.ad(z);
                        }
                    }
                } else if (i2 != 3) {
                    if (i2 == 5) {
                        this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                    } else if (i2 == 6) {
                        onSecondaryPointerUp(motionEvent);
                    }
                }
            }
            int i3 = this.mActivePointerId;
            if (i3 == -1) {
                if (i2 == 1) {
                    boolean enable2 = Logger.INSTANCE.getEnable();
                }
                return false;
            }
            float y2 = (this.mInitialMotionY - MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, i3))) * 0.5f;
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
            int i4 = this.mFooterViewHeight;
            if (y2 < ((float) i4) || this.mOnPushLoadMoreListener == null) {
                this.pushDistance = 0;
            } else {
                this.pushDistance = i4;
            }
            if (Build.VERSION.SDK_INT < 11) {
                updateFooterViewPosition();
                if (this.pushDistance == this.mFooterViewHeight && (onPushLoadMoreListener = this.mOnPushLoadMoreListener) != null) {
                    this.mLoadMore = true;
                    onPushLoadMoreListener.qw();
                }
            } else {
                animatorFooterToBottom((int) y2, this.pushDistance);
            }
            return false;
        }
        this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
        this.mIsBeingDragged = false;
        boolean enable3 = Logger.INSTANCE.getEnable();
        return true;
    }

    /* access modifiers changed from: private */
    public void moveToStart(float f) {
        int i2 = this.mFrom;
        setTargetOffsetTopAndBottom((i2 + ((int) (((float) (this.mOriginalOffsetTop - i2)) * f))) - this.mHeadViewContainer.getTop(), false);
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.mActivePointerId) {
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex == 0 ? 1 : 0);
        }
    }

    /* access modifiers changed from: private */
    public void setAnimationProgress(float f) {
        if (!this.usingDefaultHeader) {
            f = 1.0f;
        }
        ViewCompat.setScaleX(this.mHeadViewContainer, f);
        ViewCompat.setScaleY(this.mHeadViewContainer, f);
    }

    /* access modifiers changed from: private */
    public void setTargetOffsetTopAndBottom(int i2, boolean z) {
        this.mHeadViewContainer.bringToFront();
        this.mHeadViewContainer.offsetTopAndBottom(i2);
        this.mCurrentTargetOffsetTop = this.mHeadViewContainer.getTop();
        if (z && Build.VERSION.SDK_INT < 11) {
            invalidate();
        }
        updateListenerCallBack();
    }

    /* access modifiers changed from: private */
    public void startScaleDownAnimation(Animation.AnimationListener animationListener) {
        fe feVar = new fe();
        this.mScaleDownAnimation = feVar;
        feVar.setDuration(150);
        this.mHeadViewContainer.qw(animationListener);
        this.mHeadViewContainer.clearAnimation();
        this.mHeadViewContainer.startAnimation(this.mScaleDownAnimation);
    }

    private void startScaleDownReturnToStartAnimation(int i2, Animation.AnimationListener animationListener) {
        this.mFrom = i2;
        this.mStartingScale = ViewCompat.getScaleX(this.mHeadViewContainer);
        qw qwVar = new qw();
        this.mScaleDownToStartAnimation = qwVar;
        qwVar.setDuration(150);
        if (animationListener != null) {
            this.mHeadViewContainer.qw(animationListener);
        }
        this.mHeadViewContainer.clearAnimation();
        this.mHeadViewContainer.startAnimation(this.mScaleDownToStartAnimation);
    }

    private void startScaleUpAnimation(Animation.AnimationListener animationListener) {
        this.mHeadViewContainer.setVisibility(0);
        de deVar = new de();
        this.mScaleAnimation = deVar;
        deVar.setDuration((long) this.mMediumAnimationDuration);
        if (animationListener != null) {
            this.mHeadViewContainer.qw(animationListener);
        }
        this.mHeadViewContainer.clearAnimation();
        this.mHeadViewContainer.startAnimation(this.mScaleAnimation);
    }

    /* access modifiers changed from: private */
    public void updateFooterViewPosition() {
        this.mFooterViewContainer.setVisibility(0);
        this.mFooterViewContainer.bringToFront();
        if (Build.VERSION.SDK_INT < 19) {
            this.mFooterViewContainer.getParent().requestLayout();
        }
        this.mFooterViewContainer.offsetTopAndBottom(-this.pushDistance);
        updatePushDistanceListener();
    }

    /* access modifiers changed from: private */
    public void updateListenerCallBack() {
        int height = this.mCurrentTargetOffsetTop + this.mHeadViewContainer.getHeight();
        OnPullRefreshListener onPullRefreshListener = this.mListener;
        if (onPullRefreshListener != null) {
            onPullRefreshListener.qw(height);
        }
        if (this.usingDefaultHeader && this.isProgressEnable) {
            this.defaultProgressView.setPullDistance(height);
        }
    }

    private void updatePushDistanceListener() {
        OnPushLoadMoreListener onPushLoadMoreListener = this.mOnPushLoadMoreListener;
        if (onPushLoadMoreListener != null) {
            onPushLoadMoreListener.de(this.pushDistance);
        }
    }

    public int getChildDrawingOrder(int i2, int i3) {
        if (this.mHeaderViewIndex < 0 && this.mFooterViewIndex < 0) {
            return i3;
        }
        if (i3 == i2 - 2) {
            return this.mHeaderViewIndex;
        }
        if (i3 == i2 - 1) {
            return this.mFooterViewIndex;
        }
        int i4 = this.mFooterViewIndex;
        int i5 = this.mHeaderViewIndex;
        if (i4 <= i5) {
            i4 = i5;
        }
        int i6 = this.mFooterViewIndex;
        int i7 = this.mHeaderViewIndex;
        if (i6 >= i7) {
            i6 = i7;
        }
        if (i3 < i6 || i3 >= i4 - 1) {
            return (i3 >= i4 || i3 == i4 + -1) ? i3 + 2 : i3;
        }
        return i3 + 1;
    }

    public CustomChildScroller getCustomChildScroller() {
        return this.mCustomChildScroller;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00c6 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isChildScrollToBottom() {
        /*
            r6 = this;
            boolean r0 = r6.isChildScrollToTop()
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            com.tera.scan.component.base.ui.widget.staterecyclerview.PullToRefreshLayout$CustomChildScroller r0 = r6.mCustomChildScroller
            r2 = 1
            if (r0 == 0) goto L_0x0013
            boolean r0 = r0.qw(r2)
            r0 = r0 ^ r2
            return r0
        L_0x0013:
            android.view.View r0 = r6.mTarget
            boolean r3 = r0 instanceof androidx.recyclerview.widget.RecyclerView
            if (r3 == 0) goto L_0x0050
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            androidx.recyclerview.widget.RecyclerView$LayoutManager r3 = r0.getLayoutManager()
            androidx.recyclerview.widget.RecyclerView$Adapter r0 = r0.getAdapter()
            int r0 = r0.getItemCount()
            boolean r4 = r3 instanceof androidx.recyclerview.widget.LinearLayoutManager
            if (r4 == 0) goto L_0x0037
            if (r0 <= 0) goto L_0x0037
            androidx.recyclerview.widget.LinearLayoutManager r3 = (androidx.recyclerview.widget.LinearLayoutManager) r3
            int r3 = r3.findLastCompletelyVisibleItemPosition()
            int r0 = r0 - r2
            if (r3 != r0) goto L_0x004f
            return r2
        L_0x0037:
            boolean r4 = r3 instanceof androidx.recyclerview.widget.StaggeredGridLayoutManager
            if (r4 == 0) goto L_0x004f
            androidx.recyclerview.widget.StaggeredGridLayoutManager r3 = (androidx.recyclerview.widget.StaggeredGridLayoutManager) r3
            r4 = 2
            int[] r4 = new int[r4]
            r3.findLastCompletelyVisibleItemPositions(r4)
            r3 = r4[r1]
            r4 = r4[r2]
            int r3 = java.lang.Math.max(r3, r4)
            int r0 = r0 - r2
            if (r3 != r0) goto L_0x004f
            return r2
        L_0x004f:
            return r1
        L_0x0050:
            boolean r3 = r0 instanceof android.widget.AbsListView
            if (r3 == 0) goto L_0x0082
            android.widget.AbsListView r0 = (android.widget.AbsListView) r0
            android.widget.Adapter r3 = r0.getAdapter()
            android.widget.ListAdapter r3 = (android.widget.ListAdapter) r3
            int r3 = r3.getCount()
            int r4 = r0.getFirstVisiblePosition()
            if (r4 != 0) goto L_0x0075
            android.view.View r4 = r0.getChildAt(r1)
            int r4 = r4.getTop()
            int r5 = r0.getPaddingTop()
            if (r4 < r5) goto L_0x0075
            return r1
        L_0x0075:
            int r0 = r0.getLastVisiblePosition()
            if (r0 <= 0) goto L_0x0081
            if (r3 <= 0) goto L_0x0081
            int r3 = r3 - r2
            if (r0 != r3) goto L_0x0081
            return r2
        L_0x0081:
            return r1
        L_0x0082:
            boolean r3 = r0 instanceof android.widget.ScrollView
            if (r3 == 0) goto L_0x00a4
            android.widget.ScrollView r0 = (android.widget.ScrollView) r0
            int r3 = r0.getChildCount()
            int r3 = r3 - r2
            android.view.View r3 = r0.getChildAt(r3)
            if (r3 == 0) goto L_0x00c6
            int r3 = r3.getBottom()
            int r4 = r0.getHeight()
            int r0 = r0.getScrollY()
            int r4 = r4 + r0
            int r3 = r3 - r4
            if (r3 != 0) goto L_0x00c6
            return r2
        L_0x00a4:
            boolean r3 = r0 instanceof androidx.core.widget.NestedScrollView
            if (r3 == 0) goto L_0x00c6
            androidx.core.widget.NestedScrollView r0 = (androidx.core.widget.NestedScrollView) r0
            int r3 = r0.getChildCount()
            int r3 = r3 - r2
            android.view.View r3 = r0.getChildAt(r3)
            if (r3 == 0) goto L_0x00c6
            int r3 = r3.getBottom()
            int r4 = r0.getHeight()
            int r0 = r0.getScrollY()
            int r4 = r4 + r0
            int r3 = r3 - r4
            if (r3 != 0) goto L_0x00c6
            return r2
        L_0x00c6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.component.base.ui.widget.staterecyclerview.PullToRefreshLayout.isChildScrollToBottom():boolean");
    }

    public boolean isChildScrollToTop() {
        CustomChildScroller customChildScroller = this.mCustomChildScroller;
        if (customChildScroller != null) {
            return !customChildScroller.qw(-1);
        }
        if (Build.VERSION.SDK_INT >= 14) {
            return !ViewCompat.canScrollVertically(this.mTarget, -1);
        }
        View view = this.mTarget;
        if (view instanceof AbsListView) {
            AbsListView absListView = (AbsListView) view;
            if (absListView.getChildCount() <= 0) {
                return true;
            }
            if (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop()) {
                return false;
            }
            return true;
        } else if (view.getScrollY() <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isRefreshing() {
        return this.mRefreshing;
    }

    public boolean isTargetScrollWithLayout() {
        return this.targetScrollWithLayout;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.yDistance = 0.0f;
            this.xDistance = 0.0f;
            this.xLast = motionEvent.getX();
            this.yLast = motionEvent.getY();
        } else if (action == 2) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.xDistance += Math.abs(x - this.xLast);
            float abs = this.yDistance + Math.abs(y - this.yLast);
            this.yDistance = abs;
            this.xLast = x;
            this.yLast = y;
            if (this.xDistance > abs) {
                return false;
            }
        }
        return onInterceptTouchEventA(motionEvent);
    }

    public boolean onInterceptTouchEventA(MotionEvent motionEvent) {
        ensureTarget();
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (this.mReturningToStart && actionMasked == 0) {
            this.mReturningToStart = false;
        }
        if (!isEnabled() || this.mReturningToStart || this.mRefreshing || this.mLoadMore || (!isChildScrollToTop() && !isChildScrollToBottom())) {
            return false;
        }
        if (isChildScrollToTop() && !this.enablePullEvent) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i2 = this.mActivePointerId;
                    if (i2 == -1) {
                        boolean enable = Logger.INSTANCE.getEnable();
                        return false;
                    }
                    float motionEventY = getMotionEventY(motionEvent, i2);
                    if (motionEventY == -1.0f) {
                        return false;
                    }
                    if (isChildScrollToBottom()) {
                        if (this.mInitialMotionY - motionEventY > ((float) this.mTouchSlop) && !this.mIsBeingDragged) {
                            this.mIsBeingDragged = true;
                        }
                    } else if (motionEventY - this.mInitialMotionY > ((float) this.mTouchSlop) && !this.mIsBeingDragged) {
                        this.mIsBeingDragged = true;
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
            setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mHeadViewContainer.getTop(), true);
            int pointerId = MotionEventCompat.getPointerId(motionEvent, 0);
            this.mActivePointerId = pointerId;
            this.mIsBeingDragged = false;
            float motionEventY2 = getMotionEventY(motionEvent, pointerId);
            if (motionEventY2 == -1.0f) {
                return false;
            }
            this.mInitialMotionY = motionEventY2;
            int i3 = this.mActivePointerId;
            if (i3 == -1) {
                boolean enable2 = Logger.INSTANCE.getEnable();
                return false;
            }
            float motionEventY3 = getMotionEventY(motionEvent, i3);
            if (motionEventY3 == -1.0f) {
                return false;
            }
            if (isChildScrollToBottom()) {
                if (this.mInitialMotionY - motionEventY3 > ((float) this.mTouchSlop) && !this.mIsBeingDragged) {
                    this.mIsBeingDragged = true;
                }
            } else if (motionEventY3 - this.mInitialMotionY > ((float) this.mTouchSlop) && !this.mIsBeingDragged) {
                this.mIsBeingDragged = true;
            }
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
            if (this.mTarget != null) {
                int measuredHeight2 = this.mCurrentTargetOffsetTop + this.mHeadViewContainer.getMeasuredHeight();
                if (!this.targetScrollWithLayout) {
                    measuredHeight2 = 0;
                }
                View view = this.mTarget;
                int paddingLeft = getPaddingLeft();
                int paddingTop = (getPaddingTop() + measuredHeight2) - this.pushDistance;
                try {
                    view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                } catch (Exception e) {
                    e.toString();
                }
                int measuredWidth2 = this.mHeadViewContainer.getMeasuredWidth();
                int measuredHeight3 = this.mHeadViewContainer.getMeasuredHeight();
                int i6 = measuredWidth / 2;
                int i7 = measuredWidth2 / 2;
                int i8 = this.mCurrentTargetOffsetTop;
                this.mHeadViewContainer.layout(i6 - i7, i8, i7 + i6, measuredHeight3 + i8);
                int measuredWidth3 = this.mFooterViewContainer.getMeasuredWidth();
                int measuredHeight4 = this.mFooterViewContainer.getMeasuredHeight();
                int i9 = measuredWidth3 / 2;
                int i10 = this.pushDistance;
                this.mFooterViewContainer.layout(i6 - i9, measuredHeight - i10, i6 + i9, (measuredHeight + measuredHeight4) - i10);
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
            this.mHeadViewContainer.measure(View.MeasureSpec.makeMeasureSpec(this.mHeaderViewWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeaderViewHeight * 3, 1073741824));
            this.mFooterViewContainer.measure(View.MeasureSpec.makeMeasureSpec(this.mFooterViewWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mFooterViewHeight, 1073741824));
            if (!this.mUsingCustomStart && !this.mOriginalOffsetCalculated) {
                this.mOriginalOffsetCalculated = true;
                int i4 = -this.mHeadViewContainer.getMeasuredHeight();
                this.mOriginalOffsetTop = i4;
                this.mCurrentTargetOffsetTop = i4;
                updateListenerCallBack();
            }
            this.mHeaderViewIndex = -1;
            int i5 = 0;
            while (true) {
                if (i5 >= getChildCount()) {
                    break;
                } else if (getChildAt(i5) == this.mHeadViewContainer) {
                    this.mHeaderViewIndex = i5;
                    break;
                } else {
                    i5++;
                }
            }
            this.mFooterViewIndex = -1;
            for (int i6 = 0; i6 < getChildCount(); i6++) {
                if (getChildAt(i6) == this.mFooterViewContainer) {
                    this.mFooterViewIndex = i6;
                    return;
                }
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (this.mReturningToStart && actionMasked == 0) {
            this.mReturningToStart = false;
        }
        if (!isEnabled() || this.mReturningToStart) {
            return false;
        }
        if (!isChildScrollToTop() && !isChildScrollToBottom()) {
            return false;
        }
        if (isChildScrollToBottom()) {
            if (!this.enablePushEvent || !handlerPushTouchEvent(motionEvent, actionMasked)) {
                return false;
            }
            return true;
        } else if (!this.enablePullEvent || !handlerPullTouchEvent(motionEvent, actionMasked)) {
            return false;
        } else {
            return true;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void resetTargetLayout() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        View view = this.mTarget;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((view.getWidth() - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((view.getHeight() - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.mHeadViewContainer.getMeasuredWidth();
        int i2 = measuredWidth / 2;
        int i3 = measuredWidth2 / 2;
        this.mHeadViewContainer.layout(i2 - i3, -this.mHeadViewContainer.getMeasuredHeight(), i3 + i2, 0);
        int measuredWidth3 = this.mFooterViewContainer.getMeasuredWidth();
        int i4 = measuredWidth3 / 2;
        this.mFooterViewContainer.layout(i2 - i4, measuredHeight, i2 + i4, this.mFooterViewContainer.getMeasuredHeight() + measuredHeight);
    }

    public void resetTargetLayoutDelay(int i2) {
        new Handler().postDelayed(new uk(), (long) i2);
    }

    public void setCustomChildScroller(CustomChildScroller customChildScroller) {
        this.mCustomChildScroller = customChildScroller;
    }

    public void setDefaultCircleBackgroundColor(int i2) {
        if (this.usingDefaultHeader) {
            this.defaultProgressView.setCircleBackgroundColor(i2);
        }
    }

    public void setDefaultCircleProgressColor(int i2) {
        if (this.usingDefaultHeader) {
            this.defaultProgressView.setProgressColor(i2);
        }
    }

    public void setDefaultCircleShadowColor(int i2) {
        if (this.usingDefaultHeader) {
            this.defaultProgressView.setShadowColor(i2);
        }
    }

    public void setDistanceToTriggerSync(int i2) {
        this.mTotalDragDistance = (float) i2;
    }

    public void setFooterView(View view) {
        RelativeLayout relativeLayout;
        if (view != null && (relativeLayout = this.mFooterViewContainer) != null) {
            relativeLayout.removeAllViews();
            this.mFooterViewContainer.addView(view, new RelativeLayout.LayoutParams(this.mFooterViewWidth, this.mFooterViewHeight));
        }
    }

    public void setHeaderView(View view) {
        pf pfVar;
        if (view != null && (pfVar = this.mHeadViewContainer) != null) {
            this.usingDefaultHeader = false;
            pfVar.removeAllViews();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mHeaderViewWidth, this.mHeaderViewHeight);
            layoutParams.addRule(12);
            this.mHeadViewContainer.addView(view, layoutParams);
        }
    }

    public void setHeaderViewBackgroundColor(int i2) {
        this.mHeadViewContainer.setBackgroundColor(i2);
    }

    public void setLoadMore(boolean z) {
        if (!z && this.mLoadMore) {
            if (Build.VERSION.SDK_INT < 11) {
                this.mLoadMore = false;
                this.pushDistance = 0;
                updateFooterViewPosition();
                return;
            }
            animatorFooterToBottom(this.mFooterViewHeight, 0);
        }
    }

    public void setOnPullRefreshListener(OnPullRefreshListener onPullRefreshListener) {
        this.mListener = onPullRefreshListener;
    }

    public void setOnPushLoadMoreListener(OnPushLoadMoreListener onPushLoadMoreListener) {
        this.mOnPushLoadMoreListener = onPushLoadMoreListener;
    }

    public void setRefreshing(boolean z) {
        float f;
        if (!z || this.mRefreshing == z) {
            setRefreshing(z, false);
            if (this.usingDefaultHeader) {
                this.defaultProgressView.setOnDraw(false);
                return;
            }
            return;
        }
        this.mRefreshing = z;
        if (!this.mUsingCustomStart) {
            f = this.mSpinnerFinalOffset + ((float) this.mOriginalOffsetTop);
        } else {
            f = this.mSpinnerFinalOffset;
        }
        setTargetOffsetTopAndBottom(((int) f) - this.mCurrentTargetOffsetTop, true);
        this.mNotify = false;
        startScaleUpAnimation(this.mRefreshListener);
    }

    public void setTargetScrollWithLayout(boolean z) {
        this.targetScrollWithLayout = z;
    }

    public PullToRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRefreshing = false;
        this.mLoadMore = false;
        this.mTotalDragDistance = -1.0f;
        this.mOriginalOffsetCalculated = false;
        this.mActivePointerId = -1;
        this.mHeaderViewIndex = -1;
        this.mFooterViewIndex = -1;
        this.targetScrollWithLayout = true;
        this.pushDistance = 0;
        this.defaultProgressView = null;
        this.usingDefaultHeader = true;
        this.density = 1.0f;
        this.isProgressEnable = true;
        this.xDistance = 0.0f;
        this.yDistance = 0.0f;
        this.xLast = 0.0f;
        this.yLast = 0.0f;
        this.mRefreshListener = new ad();
        this.enablePushEvent = true;
        this.enablePullEvent = true;
        this.mAnimateToCorrectPosition = new i();
        this.mAnimateToStartPosition = new o();
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mMediumAnimationDuration = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.mDecelerateInterpolator = new DecelerateInterpolator(2.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, LAYOUT_ATTRS);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.mHeaderViewWidth = defaultDisplay.getWidth();
        this.mFooterViewWidth = defaultDisplay.getWidth();
        float f = displayMetrics.density;
        this.mHeaderViewHeight = (int) (f * 50.0f);
        this.mFooterViewHeight = (int) (f * 50.0f);
        this.defaultProgressView = new CircleProgressView(getContext());
        createHeaderViewContainer();
        createFooterViewContainer();
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        float f2 = displayMetrics.density;
        float f3 = 64.0f * f2;
        this.mSpinnerFinalOffset = f3;
        this.density = f2;
        this.mTotalDragDistance = f3;
    }

    public class CircleProgressView extends View implements Runnable {
        public static final int PEROID = 16;
        public Paint bgPaint;
        public RectF bgRect = null;
        public int circleBackgroundColor = -1;
        public int height;
        public boolean isOnDraw = false;
        public boolean isRunning = false;
        public RectF ovalRect = null;
        public int progressColor = -3355444;
        public Paint progressPaint;
        public int shadowColor = -6710887;
        public int speed = 8;
        public int startAngle = 0;
        public int swipeAngle;
        public int width;

        public CircleProgressView(Context context) {
            super(context);
        }

        private Paint createBgPaint() {
            if (this.bgPaint == null) {
                Paint paint = new Paint();
                this.bgPaint = paint;
                paint.setColor(this.circleBackgroundColor);
                this.bgPaint.setStyle(Paint.Style.FILL);
                this.bgPaint.setAntiAlias(true);
                if (Build.VERSION.SDK_INT >= 11) {
                    setLayerType(1, this.bgPaint);
                }
                this.bgPaint.setShadowLayer(4.0f, 0.0f, 2.0f, this.shadowColor);
            }
            return this.bgPaint;
        }

        private Paint createPaint() {
            if (this.progressPaint == null) {
                Paint paint = new Paint();
                this.progressPaint = paint;
                paint.setStrokeWidth((float) ((int) (PullToRefreshLayout.this.density * 3.0f)));
                this.progressPaint.setStyle(Paint.Style.STROKE);
                this.progressPaint.setAntiAlias(true);
            }
            this.progressPaint.setColor(this.progressColor);
            return this.progressPaint;
        }

        private RectF getBgRect() {
            this.width = getWidth();
            this.height = getHeight();
            if (this.bgRect == null) {
                int access$2100 = (int) (PullToRefreshLayout.this.density * 2.0f);
                float f = (float) access$2100;
                this.bgRect = new RectF(f, f, (float) (this.width - access$2100), (float) (this.height - access$2100));
            }
            return this.bgRect;
        }

        private RectF getOvalRect() {
            this.width = getWidth();
            this.height = getHeight();
            if (this.ovalRect == null) {
                int access$2100 = (int) (PullToRefreshLayout.this.density * 8.0f);
                float f = (float) access$2100;
                this.ovalRect = new RectF(f, f, (float) (this.width - access$2100), (float) (this.height - access$2100));
            }
            return this.ovalRect;
        }

        public boolean isRunning() {
            return this.isRunning;
        }

        public void onDetachedFromWindow() {
            this.isOnDraw = false;
            super.onDetachedFromWindow();
        }

        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawArc(getBgRect(), 0.0f, 360.0f, false, createBgPaint());
            int i2 = this.startAngle;
            if ((i2 / RotateProgress.FULL_DEGREE) % 2 == 0) {
                this.swipeAngle = (i2 % CameraUtilsForScan.MAX_SIZE_HEIGHT) / 2;
            } else {
                this.swipeAngle = 360 - ((i2 % CameraUtilsForScan.MAX_SIZE_HEIGHT) / 2);
            }
            canvas.drawArc(getOvalRect(), (float) this.startAngle, (float) this.swipeAngle, false, createPaint());
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
        }

        public void run() {
            while (this.isOnDraw) {
                this.isRunning = true;
                long currentTimeMillis = System.currentTimeMillis();
                this.startAngle += this.speed;
                postInvalidate();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis2 < 16) {
                    try {
                        Thread.sleep(16 - currentTimeMillis2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public void setCircleBackgroundColor(int i2) {
            this.circleBackgroundColor = i2;
        }

        public void setOnDraw(boolean z) {
            this.isOnDraw = z;
        }

        public void setProgressColor(int i2) {
            this.progressColor = i2;
        }

        public void setPullDistance(int i2) {
            this.startAngle = i2 * 2;
            postInvalidate();
        }

        public void setShadowColor(int i2) {
            this.shadowColor = i2;
        }

        public void setSpeed(int i2) {
            this.speed = i2;
        }

        public CircleProgressView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public CircleProgressView(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
        }
    }

    private void setRefreshing(boolean z, boolean z2) {
        if (this.mRefreshing != z) {
            this.mNotify = z2;
            ensureTarget();
            this.mRefreshing = z;
            if (z) {
                animateOffsetToCorrectPosition(this.mCurrentTargetOffsetTop, this.mRefreshListener);
            } else {
                animateOffsetToStartPosition(this.mCurrentTargetOffsetTop, this.mRefreshListener);
            }
        }
    }
}
