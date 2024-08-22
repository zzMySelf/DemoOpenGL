package com.baidu.searchbox.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.baidu.fsg.base.a;
import com.baidu.searchbox.ui.multiwindow.EdgeEffect;

public class HorizontalScrollLinearLayout extends LinearLayout {
    static final int ANIMATED_SCROLL_GAP = 250;
    private static final boolean DEBUG = false;
    private static final int INVALID_POINTER = -1;
    static final float MAX_SCROLL_FACTOR = 0.5f;
    private static final String TAG = "HorScrollLinearLayout";
    private int mActivePointerId = -1;
    private EdgeEffect mEdgeGlowRight;
    private boolean mIsBeingDragged = false;
    protected int mLastItemRightMargin = 0;
    private int mLastMotionX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    protected OverScroller mScroller;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    public HorizontalScrollLinearLayout(Context context) {
        super(context);
        initScrollView();
    }

    public HorizontalScrollLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initScrollView();
    }

    public HorizontalScrollLinearLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initScrollView();
    }

    private void initScrollView() {
        this.mScroller = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration configuration = ViewConfiguration.get(getContext());
        this.mTouchSlop = configuration.getScaledTouchSlop();
        this.mMinimumVelocity = configuration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = configuration.getScaledMaximumFlingVelocity();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 0), heightMeasureSpec);
        setMeasuredDimension(size, getMeasuredHeight());
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            int oldX = getScrollX();
            int oldY = getScrollY();
            int x = this.mScroller.getCurrX();
            int y = this.mScroller.getCurrY();
            if (!(oldX == x && oldY == y)) {
                int range = getScrollRange();
                scrollBy(x - oldX, y - oldY);
                onScrollChanged(getScrollX(), getScrollY(), oldX, oldY);
                EdgeEffect edgeEffect = this.mEdgeGlowRight;
                if (edgeEffect != null && x >= range && oldX < range) {
                    edgeEffect.onAbsorb(((int) this.mScroller.getCurrVelocity()) / 2);
                }
            }
            if (awakenScrollBars() == 0) {
                postInvalidate();
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int pointerIndex;
        int action = ev.getAction();
        if (action == 2 && this.mIsBeingDragged) {
            return true;
        }
        if (getScrollX() == 0 && !canScrollHorizontally(1)) {
            return false;
        }
        switch (action & 255) {
            case 0:
                int x = (int) ev.getX();
                if (inChild(x, (int) ev.getY())) {
                    this.mLastMotionX = x;
                    this.mActivePointerId = ev.getPointerId(0);
                    initOrResetVelocityTracker();
                    this.mVelocityTracker.addMovement(ev);
                    this.mIsBeingDragged = true ^ this.mScroller.isFinished();
                    break;
                } else {
                    this.mIsBeingDragged = false;
                    recycleVelocityTracker();
                    break;
                }
            case 1:
            case 3:
                this.mIsBeingDragged = false;
                this.mActivePointerId = -1;
                recycleVelocityTracker();
                break;
            case 2:
                int activePointerId = this.mActivePointerId;
                if (!(activePointerId == -1 || (pointerIndex = ev.findPointerIndex(activePointerId)) == -1)) {
                    int x2 = (int) ev.getX(pointerIndex);
                    if (Math.abs(x2 - this.mLastMotionX) > this.mTouchSlop) {
                        this.mIsBeingDragged = true;
                        this.mLastMotionX = x2;
                        initVelocityTrackerIfNotExists();
                        this.mVelocityTracker.addMovement(ev);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                            break;
                        }
                    }
                }
                break;
            case 6:
                onSecondaryPointerUp(ev);
                break;
        }
        return this.mIsBeingDragged;
    }

    private int getContentWidth() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public boolean onTouchEvent(MotionEvent ev) {
        ViewParent parent;
        EdgeEffect edgeEffect;
        initVelocityTrackerIfNotExists();
        this.mVelocityTracker.addMovement(ev);
        switch (ev.getAction() & 255) {
            case 0:
                if (getChildCount() != 0) {
                    boolean z = !this.mScroller.isFinished();
                    this.mIsBeingDragged = z;
                    if (z && (parent = getParent()) != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                    if (!this.mScroller.isFinished()) {
                        this.mScroller.abortAnimation();
                    }
                    this.mLastMotionX = (int) ev.getX();
                    this.mActivePointerId = ev.getPointerId(0);
                    break;
                } else {
                    return false;
                }
            case 1:
                if (this.mIsBeingDragged != 0) {
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
                    int initialVelocity = (int) velocityTracker.getXVelocity();
                    if (getChildCount() > 0 && Math.abs(initialVelocity) > this.mMinimumVelocity) {
                        fling(-initialVelocity);
                    }
                    this.mActivePointerId = -1;
                    endDrag();
                    break;
                }
                break;
            case 2:
                int activePointerIndex = ev.findPointerIndex(this.mActivePointerId);
                if (activePointerIndex != -1) {
                    int x = (int) ev.getX(activePointerIndex);
                    int deltaX = this.mLastMotionX - x;
                    if (!this.mIsBeingDragged && Math.abs(deltaX) > this.mTouchSlop) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.mIsBeingDragged = true;
                        deltaX = deltaX > 0 ? deltaX - this.mTouchSlop : deltaX + this.mTouchSlop;
                    }
                    if (this.mIsBeingDragged) {
                        this.mLastMotionX = x;
                        int oldX = getScrollX();
                        int oldY = getScrollY();
                        int range = getScrollRange();
                        scrollBy(deltaX, 0);
                        onScrollChanged(getScrollX(), getScrollY(), oldX, oldY);
                        int pulledToX = oldX + deltaX;
                        if (pulledToX < 0) {
                            EdgeEffect edgeEffect2 = this.mEdgeGlowRight;
                            if (edgeEffect2 != null && !edgeEffect2.isFinished()) {
                                this.mEdgeGlowRight.onRelease();
                            }
                        } else if (pulledToX > range && (edgeEffect = this.mEdgeGlowRight) != null) {
                            edgeEffect.onPull(((float) deltaX) / ((float) getWidth()));
                            Log.e(a.f11536g, "edge effect:" + (((float) deltaX) / ((float) getWidth())));
                        }
                        EdgeEffect edgeEffect3 = this.mEdgeGlowRight;
                        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
                            invalidate();
                            break;
                        }
                    }
                }
                break;
            case 3:
                if (this.mIsBeingDragged != 0 && getChildCount() > 0) {
                    this.mActivePointerId = -1;
                    endDrag();
                    break;
                }
            case 5:
                int index = 0;
                if (Build.VERSION.SDK_INT > 5) {
                    index = ev.getActionIndex();
                }
                this.mLastMotionX = (int) ev.getX(index);
                this.mActivePointerId = ev.getPointerId(index);
                break;
            case 6:
                onSecondaryPointerUp(ev);
                this.mLastMotionX = (int) ev.getX(ev.findPointerIndex(this.mActivePointerId));
                break;
        }
        return true;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        EdgeEffect edgeEffect = this.mEdgeGlowRight;
        if (edgeEffect != null && !edgeEffect.isFinished()) {
            int restoreCount = canvas.save();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = getHeight();
            canvas.translate((float) ((-width) + getPaddingLeft()), (float) (Math.max(getScrollRange(), getScrollY()) + height));
            canvas.rotate(180.0f, (float) width, 0.0f);
            this.mEdgeGlowRight.setSize(width, height);
            if (this.mEdgeGlowRight.draw(canvas)) {
                invalidate();
            }
            canvas.restoreToCount(restoreCount);
        }
    }

    public void fling(int velocityX) {
        if (getChildCount() > 0) {
            int width = (getWidth() - getPaddingRight()) - getPaddingLeft();
            int i2 = velocityX;
            this.mScroller.fling(getScrollX(), getScrollY(), i2, 0, 0, Math.max(0, getChildrenRight() - width), 0, 0);
            postInvalidate();
        }
    }

    private void onSecondaryPointerUp(MotionEvent ev) {
        int pointerIndex = (ev.getAction() & 65280) >> 8;
        if (ev.getPointerId(pointerIndex) == this.mActivePointerId) {
            int newPointerIndex = pointerIndex == 0 ? 1 : 0;
            this.mLastMotionX = (int) ev.getX(newPointerIndex);
            this.mActivePointerId = ev.getPointerId(newPointerIndex);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void initOrResetVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        recycleVelocityTracker();
        EdgeEffect edgeEffect = this.mEdgeGlowRight;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
        }
    }

    public boolean canScrollHorizontally(int direction) {
        return super.canScrollHorizontally(direction);
    }

    /* access modifiers changed from: protected */
    public int computeHorizontalScrollOffset() {
        return Math.max(0, super.computeHorizontalScrollOffset());
    }

    /* access modifiers changed from: protected */
    public int computeHorizontalScrollRange() {
        if (getChildCount() == 0) {
            return (getWidth() - getPaddingRight()) - getPaddingLeft();
        }
        return getChildrenRight();
    }

    private int getScrollRange() {
        return Math.max(0, getChildrenRight() - getContentWidth());
    }

    private int getChildrenRight() {
        for (int i2 = getChildCount() - 1; i2 >= 0; i2--) {
            View child = getChildAt(i2);
            if (child != null && child.getVisibility() != 8) {
                return child.getRight() + this.mLastItemRightMargin;
            }
        }
        return 0;
    }

    private boolean inChild(int x, int y) {
        return true;
    }

    public void scrollTo(int x, int y) {
        if (getChildCount() > 0) {
            int x2 = clamp(x, (getWidth() - getPaddingRight()) - getPaddingLeft(), computeHorizontalScrollRange());
            int y2 = clamp(y, (getHeight() - getPaddingBottom()) - getPaddingTop(), getHeight());
            if (x2 != getScrollX() || y2 != getScrollY()) {
                super.scrollTo(x2, y2);
            }
        }
    }

    private static int clamp(int n, int my, int child) {
        if (my >= child || n < 0) {
            return 0;
        }
        if (my + n > child) {
            return child - my;
        }
        return n;
    }

    public void setEdgeGlowBottom(EdgeEffect edgeEffect) {
        this.mEdgeGlowRight = edgeEffect;
    }
}
