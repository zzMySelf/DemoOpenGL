package com.tera.scan.webview;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;

public class NestedNetDiskWebView extends TeraScanWebView implements NestedScrollingChild2, NestedScrollingParent {
    public static final qw ACCESSIBILITY_DELEGATE = new qw();
    public static final int ANIMATED_SCROLL_GAP = 250;
    public static final int INVALID_POINTER = -1;
    public static final String TAG = "NestedNetDiskWebView";
    public boolean flinging = false;
    public ViewGroup horizontallyScrollableParent;
    public int mActivePointerId = -1;
    public NestedScrollingChildHelper mChildHelper;
    public int mDefaultTouchSlop;
    public boolean mIsBeingDragged = false;
    public int mLastMotionX;
    public int mLastMotionY;
    public long mLastScroll;
    public int mLastScrollerY;
    public int mMaximumVelocity;
    public int mMinimumVelocity;
    public int mNestedYOffset;
    public NestedScrollingParentHelper mParentHelper;
    public final int[] mScrollConsumed = new int[2];
    public boolean mScrollHorizontalEstablish = false;
    public final int[] mScrollOffset = new int[2];
    public boolean mScrollVerticalEstablish = false;
    public OverScroller mScroller;
    public int mTouchSlop;
    public VelocityTracker mVelocityTracker;
    public float mVerticalScrollFactor;
    public int mXTouchSlop;

    public static class qw extends AccessibilityDelegateCompat {
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedNetDiskWebView nestedNetDiskWebView = (NestedNetDiskWebView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedNetDiskWebView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedNetDiskWebView.getScrollX());
            accessibilityEvent.setScrollY(nestedNetDiskWebView.getScrollY());
            AccessibilityRecordCompat.setMaxScrollX(accessibilityEvent, nestedNetDiskWebView.getScrollX());
            AccessibilityRecordCompat.setMaxScrollY(accessibilityEvent, nestedNetDiskWebView.getScrollRange());
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int access$000;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            NestedNetDiskWebView nestedNetDiskWebView = (NestedNetDiskWebView) view;
            accessibilityNodeInfoCompat.setClassName(ScrollView.class.getName());
            if (nestedNetDiskWebView.isEnabled() && (access$000 = nestedNetDiskWebView.getScrollRange()) > 0) {
                accessibilityNodeInfoCompat.setScrollable(true);
                if (nestedNetDiskWebView.getScrollY() > 0) {
                    accessibilityNodeInfoCompat.addAction(8192);
                }
                if (nestedNetDiskWebView.getScrollY() < access$000) {
                    accessibilityNodeInfoCompat.addAction(4096);
                }
            }
        }

        public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            if (super.performAccessibilityAction(view, i2, bundle)) {
                return true;
            }
            NestedNetDiskWebView nestedNetDiskWebView = (NestedNetDiskWebView) view;
            if (!nestedNetDiskWebView.isEnabled()) {
                return false;
            }
            if (i2 == 4096) {
                int min = Math.min(nestedNetDiskWebView.getScrollY() + ((nestedNetDiskWebView.getHeight() - nestedNetDiskWebView.getPaddingBottom()) - nestedNetDiskWebView.getPaddingTop()), nestedNetDiskWebView.getScrollRange());
                if (min == nestedNetDiskWebView.getScrollY()) {
                    return false;
                }
                nestedNetDiskWebView.smoothScrollTo(0, min);
                return true;
            } else if (i2 != 8192) {
                return false;
            } else {
                int max = Math.max(nestedNetDiskWebView.getScrollY() - ((nestedNetDiskWebView.getHeight() - nestedNetDiskWebView.getPaddingBottom()) - nestedNetDiskWebView.getPaddingTop()), 0);
                if (max == nestedNetDiskWebView.getScrollY()) {
                    return false;
                }
                nestedNetDiskWebView.smoothScrollTo(0, max);
                return true;
            }
        }
    }

    public NestedNetDiskWebView(Context context) {
        super(context);
        initScrollView();
    }

    private boolean canScrollHorizontal(View view) {
        return view.canScrollHorizontally(1) || view.canScrollHorizontally(-1);
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        recycleVelocityTracker();
        stopNestedScroll();
    }

    private ViewGroup findViewParentIfNeeds(View view, int i2) {
        if (i2 < 0) {
            return null;
        }
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (canScrollHorizontal(viewGroup)) {
            return viewGroup;
        }
        return findViewParentIfNeeds((View) parent, i2 - 1);
    }

    private void flingWithNestedDispatch(int i2) {
        int scrollY = getScrollY();
        boolean z = (scrollY > 0 || i2 > 0) && (scrollY < getScrollRange() || i2 < 0);
        float f = (float) i2;
        if (!dispatchNestedPreFling(0.0f, f)) {
            dispatchNestedFling(0.0f, f, z);
            fling(i2);
        }
    }

    /* access modifiers changed from: private */
    public int getScrollRange() {
        return computeVerticalScrollRange();
    }

    private float getVerticalScrollFactorCompat() {
        if (this.mVerticalScrollFactor == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.mVerticalScrollFactor = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.mVerticalScrollFactor;
    }

    private void initOrResetVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void initScrollView() {
        setOverScrollMode(2);
        this.mScroller = new OverScroller(getContext());
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mDefaultTouchSlop = scaledTouchSlop;
        this.mTouchSlop = scaledTouchSlop;
        this.mXTouchSlop = scaledTouchSlop;
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mChildHelper = new NestedScrollingChildHelper(this);
        this.mParentHelper = new NestedScrollingParentHelper(this);
        setNestedScrollingEnabled(true);
        ViewCompat.setAccessibilityDelegate(this, ACCESSIBILITY_DELEGATE);
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.mLastMotionY = (int) motionEvent.getY(i2);
            this.mLastMotionX = (int) motionEvent.getX(i2);
            this.mActivePointerId = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x007d A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean overScrollByCompat(int r17, int r18, int r19, int r20, int r21, int r22, int r23, int r24) {
        /*
            r16 = this;
            r0 = r16
            int r1 = r16.getOverScrollMode()
            int r2 = r16.computeHorizontalScrollRange()
            int r3 = r16.computeHorizontalScrollExtent()
            r4 = 0
            r5 = 1
            if (r2 <= r3) goto L_0x0014
            r2 = 1
            goto L_0x0015
        L_0x0014:
            r2 = 0
        L_0x0015:
            int r3 = r16.computeVerticalScrollRange()
            int r6 = r16.computeVerticalScrollExtent()
            if (r3 <= r6) goto L_0x0021
            r3 = 1
            goto L_0x0022
        L_0x0021:
            r3 = 0
        L_0x0022:
            if (r1 == 0) goto L_0x002b
            if (r1 != r5) goto L_0x0029
            if (r2 == 0) goto L_0x0029
            goto L_0x002b
        L_0x0029:
            r2 = 0
            goto L_0x002c
        L_0x002b:
            r2 = 1
        L_0x002c:
            if (r1 == 0) goto L_0x0035
            if (r1 != r5) goto L_0x0033
            if (r3 == 0) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            r1 = 0
            goto L_0x0036
        L_0x0035:
            r1 = 1
        L_0x0036:
            int r3 = r19 + r17
            if (r2 != 0) goto L_0x003c
            r2 = 0
            goto L_0x003e
        L_0x003c:
            r2 = r23
        L_0x003e:
            int r6 = r20 + r18
            if (r1 != 0) goto L_0x0044
            r1 = 0
            goto L_0x0046
        L_0x0044:
            r1 = r24
        L_0x0046:
            int r7 = -r2
            int r2 = r2 + r21
            int r8 = -r1
            int r1 = r1 + r22
            if (r3 <= r2) goto L_0x0051
            r3 = r2
        L_0x004f:
            r2 = 1
            goto L_0x0056
        L_0x0051:
            if (r3 >= r7) goto L_0x0055
            r3 = r7
            goto L_0x004f
        L_0x0055:
            r2 = 0
        L_0x0056:
            if (r6 <= r1) goto L_0x005b
            r6 = r1
        L_0x0059:
            r1 = 1
            goto L_0x0060
        L_0x005b:
            if (r6 >= r8) goto L_0x005f
            r6 = r8
            goto L_0x0059
        L_0x005f:
            r1 = 0
        L_0x0060:
            if (r1 == 0) goto L_0x0076
            boolean r7 = r0.hasNestedScrollingParent(r5)
            if (r7 != 0) goto L_0x0076
            android.widget.OverScroller r9 = r0.mScroller
            r12 = 0
            r13 = 0
            r14 = 0
            int r15 = r16.getScrollRange()
            r10 = r3
            r11 = r6
            r9.springBack(r10, r11, r12, r13, r14, r15)
        L_0x0076:
            if (r18 >= 0) goto L_0x007b
            r0.onOverScrolled(r3, r6, r2, r1)
        L_0x007b:
            if (r2 != 0) goto L_0x007f
            if (r1 == 0) goto L_0x0080
        L_0x007f:
            r4 = 1
        L_0x0080:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.webview.NestedNetDiskWebView.overScrollByCompat(int, int, int, int, int, int, int, int):boolean");
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void computeScroll() {
        if (!this.flinging) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            int i2 = currY - this.mLastScrollerY;
            if (dispatchNestedPreScroll(0, i2, this.mScrollConsumed, (int[]) null, 1)) {
                i2 -= this.mScrollConsumed[1];
            }
            if (i2 != 0) {
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                overScrollByCompat(0, i2, getScrollX(), scrollY, 0, scrollRange, 0, 0);
                int scrollY2 = getScrollY() - scrollY;
                dispatchNestedScroll(0, scrollY2, 0, i2 - scrollY2, (int[]) null, 1);
            }
            this.mLastScrollerY = currY;
            ViewCompat.postInvalidateOnAnimation(this);
        } else {
            this.flinging = false;
            if (hasNestedScrollingParent(1)) {
                stopNestedScroll(1);
            }
            this.mLastScrollerY = 0;
        }
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.mChildHelper.dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.mChildHelper.dispatchNestedPreFling(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.mChildHelper.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.mChildHelper.dispatchNestedScroll(i2, i3, i4, i5, iArr);
    }

    public void fling(int i2) {
        this.flinging = true;
        startNestedScroll(2, 1);
        this.mScroller.fling(getScrollX(), getScrollY(), 0, i2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
        this.mLastScrollerY = getScrollY();
        ViewCompat.postInvalidateOnAnimation(getRootView());
    }

    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    public boolean hasNestedScrollingParent() {
        return this.mChildHelper.hasNestedScrollingParent();
    }

    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.isNestedScrollingEnabled();
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && !this.mIsBeingDragged) {
            float axisValue = motionEvent.getAxisValue(9);
            if (axisValue != 0.0f) {
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int verticalScrollFactorCompat = scrollY - ((int) (axisValue * getVerticalScrollFactorCompat()));
                if (verticalScrollFactorCompat < 0) {
                    scrollRange = 0;
                } else if (verticalScrollFactorCompat <= scrollRange) {
                    scrollRange = verticalScrollFactorCompat;
                }
                if (scrollRange != scrollY) {
                    super.scrollTo(getScrollX(), scrollRange);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && this.mIsBeingDragged) {
            return true;
        }
        int i2 = action & 255;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    int i3 = this.mActivePointerId;
                    if (i3 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i3);
                        if (findPointerIndex == -1) {
                            fe.mmm.qw.i.qw.rg(TAG, "Invalid pointerId=" + i3 + " in onInterceptTouchEvent");
                        } else {
                            int y = (int) motionEvent.getY(findPointerIndex);
                            int abs = Math.abs(y - this.mLastMotionY);
                            ViewParent parent = getParent();
                            if (abs > this.mTouchSlop && (2 & getNestedScrollAxes()) == 0) {
                                this.mIsBeingDragged = true;
                                this.mLastMotionY = y;
                                initVelocityTrackerIfNotExists();
                                this.mVelocityTracker.addMovement(motionEvent);
                                this.mNestedYOffset = 0;
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                            int x = (int) motionEvent.getX(findPointerIndex);
                            if (Math.abs(x - this.mLastMotionX) > this.mXTouchSlop && (getNestedScrollAxes() & 1) == 0) {
                                this.mLastMotionX = x;
                            }
                        }
                    }
                } else if (i2 != 3) {
                    if (i2 != 6) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(false);
                        }
                    } else {
                        onSecondaryPointerUp(motionEvent);
                    }
                }
            }
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
            recycleVelocityTracker();
            if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                ViewCompat.postInvalidateOnAnimation(this);
            }
            stopNestedScroll();
        } else {
            this.mLastMotionY = (int) motionEvent.getY();
            this.mLastMotionX = (int) motionEvent.getX();
            this.mActivePointerId = motionEvent.getPointerId(0);
            initOrResetVelocityTracker();
            this.mVelocityTracker.addMovement(motionEvent);
            this.mScroller.computeScrollOffset();
            this.mIsBeingDragged = !this.mScroller.isFinished();
            startNestedScroll(2);
        }
        return this.mIsBeingDragged;
    }

    public boolean onNestedFling(@NonNull View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        flingWithNestedDispatch((int) f2);
        return true;
    }

    public boolean onNestedPreFling(@NonNull View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public void onNestedPreScroll(@NonNull View view, int i2, int i3, @NonNull int[] iArr) {
        dispatchNestedPreScroll(i2, i3, iArr, (int[]) null);
    }

    public void onNestedScroll(@NonNull View view, int i2, int i3, int i4, int i5) {
        int scrollY = getScrollY();
        scrollBy(0, i5);
        int scrollY2 = getScrollY() - scrollY;
        dispatchNestedScroll(0, scrollY2, 0, i5 - scrollY2, (int[]) null);
    }

    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i2) {
        this.mParentHelper.onNestedScrollAccepted(view, view2, i2);
        startNestedScroll(2);
    }

    public void onOverScrolled(int i2, int i3, boolean z, boolean z2) {
        if (z && this.mScrollHorizontalEstablish) {
            if (this.horizontallyScrollableParent == null) {
                this.horizontallyScrollableParent = findViewParentIfNeeds(this, 10);
            }
            ViewGroup viewGroup = this.horizontallyScrollableParent;
            if (viewGroup != null) {
                viewGroup.requestDisallowInterceptTouchEvent(false);
            }
        }
        super.onOverScrolled(i2, i3, z, z2);
    }

    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i2) {
        return (i2 & 2) != 0;
    }

    public void onStopNestedScroll(@NonNull View view) {
        this.mParentHelper.onStopNestedScroll(view);
        stopNestedScroll();
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x026b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r21) {
        /*
            r20 = this;
            r7 = r20
            r8 = r21
            r20.initVelocityTrackerIfNotExists()
            android.view.MotionEvent r9 = android.view.MotionEvent.obtain(r21)
            int r0 = r21.getActionMasked()
            r10 = 0
            if (r0 != 0) goto L_0x0014
            r7.mNestedYOffset = r10
        L_0x0014:
            int r1 = r7.mNestedYOffset
            float r1 = (float) r1
            r11 = 0
            r9.offsetLocation(r11, r1)
            r1 = 2
            r12 = 1
            if (r0 == 0) goto L_0x0213
            r2 = 3
            r3 = -1
            if (r0 == r12) goto L_0x01c8
            if (r0 == r1) goto L_0x009b
            if (r0 == r2) goto L_0x0068
            r1 = 5
            if (r0 == r1) goto L_0x004e
            r1 = 6
            if (r0 == r1) goto L_0x002f
            goto L_0x0267
        L_0x002f:
            r20.onSecondaryPointerUp(r21)
            int r0 = r7.mActivePointerId
            int r0 = r8.findPointerIndex(r0)
            float r0 = r8.getY(r0)
            int r0 = (int) r0
            r7.mLastMotionY = r0
            int r0 = r7.mActivePointerId
            int r0 = r8.findPointerIndex(r0)
            float r0 = r8.getX(r0)
            int r0 = (int) r0
            r7.mLastMotionX = r0
            goto L_0x0267
        L_0x004e:
            int r0 = r21.getActionIndex()
            float r1 = r8.getY(r0)
            int r1 = (int) r1
            r7.mLastMotionY = r1
            float r1 = r8.getX(r0)
            int r1 = (int) r1
            r7.mLastMotionX = r1
            int r0 = r8.getPointerId(r0)
            r7.mActivePointerId = r0
            goto L_0x0267
        L_0x0068:
            boolean r0 = r7.mIsBeingDragged
            if (r0 == 0) goto L_0x008f
            int r0 = r20.getChildCount()
            if (r0 <= 0) goto L_0x008f
            android.widget.OverScroller r13 = r7.mScroller
            int r14 = r20.getScrollX()
            int r15 = r20.getScrollY()
            r16 = 0
            r17 = 0
            r18 = 0
            int r19 = r20.getScrollRange()
            boolean r0 = r13.springBack(r14, r15, r16, r17, r18, r19)
            if (r0 == 0) goto L_0x008f
            androidx.core.view.ViewCompat.postInvalidateOnAnimation(r20)
        L_0x008f:
            r7.mActivePointerId = r3
            r7.mScrollVerticalEstablish = r10
            r7.mScrollHorizontalEstablish = r10
            r20.endDrag()
            r10 = 1
            goto L_0x0267
        L_0x009b:
            int r0 = r7.mActivePointerId
            int r0 = r8.findPointerIndex(r0)
            if (r0 != r3) goto L_0x00c2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid pointerId="
            r0.append(r1)
            int r1 = r7.mActivePointerId
            r0.append(r1)
            java.lang.String r1 = " in onTouchEvent"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "NestedNetDiskWebView"
            fe.mmm.qw.i.qw.rg(r1, r0)
            goto L_0x0267
        L_0x00c2:
            float r1 = r8.getY(r0)
            int r6 = (int) r1
            float r0 = r8.getX(r0)
            int r0 = (int) r0
            int r1 = r7.mLastMotionY
            int r13 = r1 - r6
            int r1 = r7.mLastMotionX
            int r1 = r1 - r0
            int r0 = java.lang.Math.abs(r13)
            int r2 = java.lang.Math.abs(r1)
            if (r0 <= r2) goto L_0x00ea
            int r0 = java.lang.Math.abs(r13)
            int r2 = r7.mTouchSlop
            if (r0 <= r2) goto L_0x00ea
            r7.mScrollVerticalEstablish = r12
            r7.mScrollHorizontalEstablish = r10
            goto L_0x0108
        L_0x00ea:
            int r0 = java.lang.Math.abs(r1)
            double r2 = (double) r0
            int r0 = java.lang.Math.abs(r13)
            double r4 = (double) r0
            r14 = 4609434218613702656(0x3ff8000000000000, double:1.5)
            double r4 = r4 * r14
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0108
            int r0 = java.lang.Math.abs(r1)
            int r1 = r7.mXTouchSlop
            if (r0 <= r1) goto L_0x0108
            r7.mScrollHorizontalEstablish = r12
            r7.mScrollVerticalEstablish = r10
        L_0x0108:
            boolean r0 = r7.mScrollHorizontalEstablish
            if (r0 == 0) goto L_0x0116
            float r0 = (float) r13
            r8.offsetLocation(r11, r0)
            boolean r10 = super.onTouchEvent(r21)
            goto L_0x0267
        L_0x0116:
            r1 = 0
            int[] r3 = r7.mScrollConsumed
            int[] r4 = r7.mScrollOffset
            r5 = 0
            r0 = r20
            r2 = r13
            boolean r0 = r0.dispatchNestedPreScroll(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0145
            int[] r0 = r7.mScrollConsumed
            r0 = r0[r12]
            int r13 = r13 - r0
            int[] r0 = r7.mScrollOffset
            r0 = r0[r12]
            int r0 = -r0
            float r0 = (float) r0
            r8.offsetLocation(r11, r0)
            int[] r0 = r7.mScrollOffset
            r0 = r0[r12]
            int r0 = -r0
            float r0 = (float) r0
            r9.offsetLocation(r11, r0)
            int r0 = r7.mNestedYOffset
            int[] r1 = r7.mScrollOffset
            r1 = r1[r12]
            int r0 = r0 + r1
            r7.mNestedYOffset = r0
        L_0x0145:
            int[] r0 = r7.mScrollOffset
            r0 = r0[r12]
            if (r0 != 0) goto L_0x014d
            r14 = 1
            goto L_0x014e
        L_0x014d:
            r14 = 0
        L_0x014e:
            boolean r0 = r7.mIsBeingDragged
            if (r0 != 0) goto L_0x016e
            int r0 = java.lang.Math.abs(r13)
            int r1 = r7.mTouchSlop
            if (r0 <= r1) goto L_0x016e
            android.view.ViewParent r0 = r20.getParent()
            if (r0 == 0) goto L_0x0163
            r0.requestDisallowInterceptTouchEvent(r12)
        L_0x0163:
            r7.mIsBeingDragged = r12
            if (r13 <= 0) goto L_0x016b
            int r0 = r7.mTouchSlop
            int r13 = r13 - r0
            goto L_0x016e
        L_0x016b:
            int r0 = r7.mTouchSlop
            int r13 = r13 + r0
        L_0x016e:
            boolean r0 = r7.mIsBeingDragged
            if (r0 == 0) goto L_0x01ac
            int[] r0 = r7.mScrollOffset
            r0 = r0[r12]
            int r6 = r6 - r0
            r7.mLastMotionY = r6
            int r0 = r20.getScrollY()
            int r1 = r0 + r13
            int r1 = java.lang.Math.max(r10, r1)
            int r2 = r1 - r0
            int r4 = r13 - r2
            r1 = 0
            r3 = 0
            int[] r5 = r7.mScrollOffset
            r6 = 0
            r0 = r20
            boolean r0 = r0.dispatchNestedScroll(r1, r2, r3, r4, r5, r6)
            if (r0 == 0) goto L_0x01ac
            int r0 = r7.mLastMotionY
            int[] r1 = r7.mScrollOffset
            r2 = r1[r12]
            int r0 = r0 - r2
            r7.mLastMotionY = r0
            r0 = r1[r12]
            float r0 = (float) r0
            r9.offsetLocation(r11, r0)
            int r0 = r7.mNestedYOffset
            int[] r1 = r7.mScrollOffset
            r1 = r1[r12]
            int r0 = r0 + r1
            r7.mNestedYOffset = r0
        L_0x01ac:
            int[] r0 = r7.mScrollOffset
            r0 = r0[r12]
            if (r0 != 0) goto L_0x01b4
            r0 = 1
            goto L_0x01b5
        L_0x01b4:
            r0 = 0
        L_0x01b5:
            r0 = r0 & r14
            if (r0 == 0) goto L_0x01bd
            boolean r0 = super.onTouchEvent(r21)
            goto L_0x0211
        L_0x01bd:
            android.view.ViewParent r0 = r20.getParent()
            if (r0 == 0) goto L_0x0267
            r0.requestDisallowInterceptTouchEvent(r12)
            goto L_0x0267
        L_0x01c8:
            boolean r0 = r7.mScrollHorizontalEstablish
            if (r0 == 0) goto L_0x01dc
            int r0 = r7.mLastMotionY
            float r0 = (float) r0
            float r1 = r21.getY()
            float r0 = r0 - r1
            r8.offsetLocation(r11, r0)
            boolean r0 = super.onTouchEvent(r21)
            goto L_0x020d
        L_0x01dc:
            int r0 = r7.mNestedYOffset
            int r0 = java.lang.Math.abs(r0)
            int r1 = r7.mTouchSlop
            if (r0 < r1) goto L_0x01e9
            r8.setAction(r2)
        L_0x01e9:
            boolean r0 = super.onTouchEvent(r21)
            android.view.VelocityTracker r1 = r7.mVelocityTracker
            r2 = 1000(0x3e8, float:1.401E-42)
            int r4 = r7.mMaximumVelocity
            float r4 = (float) r4
            r1.computeCurrentVelocity(r2, r4)
            float r1 = r1.getYVelocity()
            int r1 = (int) r1
            int r2 = java.lang.Math.abs(r1)
            int r4 = r7.mMinimumVelocity
            if (r2 <= r4) goto L_0x0208
            int r1 = -r1
            r7.flingWithNestedDispatch(r1)
        L_0x0208:
            r7.mActivePointerId = r3
            r20.endDrag()
        L_0x020d:
            r7.mScrollVerticalEstablish = r10
            r7.mScrollHorizontalEstablish = r10
        L_0x0211:
            r10 = r0
            goto L_0x0267
        L_0x0213:
            boolean r0 = super.onTouchEvent(r21)
            android.widget.OverScroller r2 = r7.mScroller
            boolean r2 = r2.isFinished()
            r2 = r2 ^ r12
            r7.mIsBeingDragged = r2
            if (r2 == 0) goto L_0x022b
            android.view.ViewParent r2 = r20.getParent()
            if (r2 == 0) goto L_0x022b
            r2.requestDisallowInterceptTouchEvent(r12)
        L_0x022b:
            android.widget.OverScroller r2 = r7.mScroller
            boolean r2 = r2.isFinished()
            if (r2 != 0) goto L_0x0238
            android.widget.OverScroller r2 = r7.mScroller
            r2.abortAnimation()
        L_0x0238:
            r7.mScrollHorizontalEstablish = r10
            r7.mScrollVerticalEstablish = r10
            float r2 = r21.getY()
            int r2 = (int) r2
            r7.mLastMotionY = r2
            float r2 = r21.getX()
            int r2 = (int) r2
            r7.mLastMotionX = r2
            int r2 = r8.getPointerId(r10)
            r7.mActivePointerId = r2
            r7.startNestedScroll(r1, r10)
            android.view.ViewGroup r1 = r7.horizontallyScrollableParent
            if (r1 != 0) goto L_0x025f
            r1 = 10
            android.view.ViewGroup r1 = r7.findViewParentIfNeeds(r7, r1)
            r7.horizontallyScrollableParent = r1
        L_0x025f:
            android.view.ViewGroup r1 = r7.horizontallyScrollableParent
            if (r1 == 0) goto L_0x0211
            r1.requestDisallowInterceptTouchEvent(r12)
            goto L_0x0211
        L_0x0267:
            android.view.VelocityTracker r0 = r7.mVelocityTracker
            if (r0 == 0) goto L_0x026e
            r0.addMovement(r9)
        L_0x026e:
            r9.recycle()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.webview.NestedNetDiskWebView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            recycleVelocityTracker();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.mChildHelper.setNestedScrollingEnabled(z);
    }

    public final void smoothScrollBy(int i2, int i3) {
        if (AnimationUtils.currentAnimationTimeMillis() - this.mLastScroll > 250) {
            int max = Math.max(0, getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
            int scrollY = getScrollY();
            this.mScroller.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i3 + scrollY, max)) - scrollY);
            ViewCompat.postInvalidateOnAnimation(this);
        } else {
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
            }
            scrollBy(i2, i3);
        }
        this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
    }

    public final void smoothScrollTo(int i2, int i3) {
        smoothScrollBy(i2 - getScrollX(), i3 - getScrollY());
    }

    public boolean startNestedScroll(int i2) {
        return this.mChildHelper.startNestedScroll(i2);
    }

    public void stopNestedScroll() {
        if (!this.flinging) {
            this.mChildHelper.stopNestedScroll();
        }
    }

    public void stopScroll() {
        OverScroller overScroller = this.mScroller;
        if (overScroller != null) {
            overScroller.forceFinished(true);
        }
    }

    public void updateXTouchSlop(int i2) {
        this.mXTouchSlop = i2;
    }

    public void updateYTouchSlop(int i2) {
        this.mTouchSlop = i2;
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return this.mChildHelper.dispatchNestedPreScroll(i2, i3, iArr, iArr2, i4);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        return this.mChildHelper.dispatchNestedScroll(i2, i3, i4, i5, iArr, i6);
    }

    public boolean hasNestedScrollingParent(int i2) {
        return this.mChildHelper.hasNestedScrollingParent(i2);
    }

    public boolean startNestedScroll(int i2, int i3) {
        return this.mChildHelper.startNestedScroll(i2, i3);
    }

    public void stopNestedScroll(int i2) {
        this.mChildHelper.stopNestedScroll(i2);
    }

    public NestedNetDiskWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initScrollView();
    }

    public NestedNetDiskWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        initScrollView();
    }

    public NestedNetDiskWebView(Context context, AttributeSet attributeSet, int i2, boolean z) {
        super(context, attributeSet, i2, z);
        initScrollView();
    }

    public NestedNetDiskWebView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        initScrollView();
    }
}
