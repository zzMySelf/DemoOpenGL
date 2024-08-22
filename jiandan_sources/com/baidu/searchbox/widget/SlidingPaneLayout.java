package com.baidu.searchbox.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import fe.fe.ddd.rrr.fe;
import java.util.ArrayList;

public abstract class SlidingPaneLayout extends ViewGroup {
    public static final int DEFAULT_FADE_COLOR = -858993460;
    public static final rg IMPL;
    public static final int MIN_FLING_VELOCITY = 400;
    public static final String TAG = "SlidingPaneLayout";
    public boolean mAutoSlide;
    public boolean mCanSlide;
    public int mCoveredFadeColor;
    public final fe.fe.ddd.rrr.fe mDragHelper;
    public boolean mFirstLayout;
    public float mInitialMotionX;
    public float mInitialMotionY;
    public boolean mIsActivityTranslucent;
    public boolean mIsUnableToDrag;
    public final int mOverhangSize;
    public PanelSlideListener mPanelSlideListener;
    public int mParallaxBy;
    public float mParallaxOffset;
    public final ArrayList<de> mPostedRunnables;
    public boolean mPreservedOpenState;
    public int mScreenWidth;
    public Drawable mShadowDrawable;
    public float mSlideOffset;
    public int mSlideRange;
    public View mSlideableView;
    public int mSliderFadeColor;
    public final Rect mTmpRect;
    public boolean showShadow;
    public double slideEdgeFactor;
    public double slideWidthFactor;

    public interface PanelSlideListener {
        void onPanelClosed(View view);

        void onPanelOpened(View view);

        void onPanelSlide(View view, float f);
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new qw();
        public boolean isOpen;

        public static class qw implements Parcelable.Creator<SavedState> {
            /* renamed from: ad */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }

            /* renamed from: qw */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.isOpen ? 1 : 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.isOpen = parcel.readInt() != 0;
        }
    }

    public class ad extends AccessibilityDelegateCompat {
        public final Rect qw = new Rect();

        public ad() {
        }

        public final void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Rect rect = this.qw;
            accessibilityNodeInfoCompat2.getBoundsInParent(rect);
            accessibilityNodeInfoCompat.setBoundsInParent(rect);
            accessibilityNodeInfoCompat2.getBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setVisibleToUser(accessibilityNodeInfoCompat2.isVisibleToUser());
            accessibilityNodeInfoCompat.setPackageName(accessibilityNodeInfoCompat2.getPackageName());
            accessibilityNodeInfoCompat.setClassName(accessibilityNodeInfoCompat2.getClassName());
            accessibilityNodeInfoCompat.setContentDescription(accessibilityNodeInfoCompat2.getContentDescription());
            accessibilityNodeInfoCompat.setEnabled(accessibilityNodeInfoCompat2.isEnabled());
            accessibilityNodeInfoCompat.setClickable(accessibilityNodeInfoCompat2.isClickable());
            accessibilityNodeInfoCompat.setFocusable(accessibilityNodeInfoCompat2.isFocusable());
            accessibilityNodeInfoCompat.setFocused(accessibilityNodeInfoCompat2.isFocused());
            accessibilityNodeInfoCompat.setAccessibilityFocused(accessibilityNodeInfoCompat2.isAccessibilityFocused());
            accessibilityNodeInfoCompat.setSelected(accessibilityNodeInfoCompat2.isSelected());
            accessibilityNodeInfoCompat.setLongClickable(accessibilityNodeInfoCompat2.isLongClickable());
            accessibilityNodeInfoCompat.addAction(accessibilityNodeInfoCompat2.getActions());
            accessibilityNodeInfoCompat.setMovementGranularities(accessibilityNodeInfoCompat2.getMovementGranularities());
        }

        public boolean filter(View view) {
            return SlidingPaneLayout.this.isDimmed(view);
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(accessibilityNodeInfoCompat);
            super.onInitializeAccessibilityNodeInfo(view, obtain);
            copyNodeInfoNoChildren(accessibilityNodeInfoCompat, obtain);
            obtain.recycle();
            accessibilityNodeInfoCompat.setClassName(SlidingPaneLayout.class.getName());
            accessibilityNodeInfoCompat.setSource(view);
            ViewParent parentForAccessibility = ViewCompat.getParentForAccessibility(view);
            if (parentForAccessibility instanceof View) {
                accessibilityNodeInfoCompat.setParent((View) parentForAccessibility);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i2);
                if (!filter(childAt) && childAt.getVisibility() == 0) {
                    ViewCompat.setImportantForAccessibility(childAt, 1);
                    accessibilityNodeInfoCompat.addChild(childAt);
                }
            }
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (!filter(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    public class de implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final View f1081ad;

        public de(View view) {
            this.f1081ad = view;
        }

        public void run() {
            if (this.f1081ad.getParent() == SlidingPaneLayout.this) {
                ViewCompat.setLayerType(this.f1081ad, 0, (Paint) null);
                SlidingPaneLayout.this.invalidateChildRegion(this.f1081ad);
            }
            SlidingPaneLayout.this.mPostedRunnables.remove(this);
        }
    }

    public class fe extends fe.de {
        public int qw;

        public fe() {
        }

        public int fe(View view) {
            return SlidingPaneLayout.this.mSlideRange;
        }

        /* renamed from: if  reason: not valid java name */
        public void m49if(View view, int i2, int i3, int i4, int i5) {
            this.qw = i2;
            SlidingPaneLayout.this.onPanelDragged(i2);
            SlidingPaneLayout.this.invalidate();
        }

        public void o(View view, int i2) {
            SlidingPaneLayout.this.setAllChildrenVisible();
        }

        public void pf(int i2) {
            if (SlidingPaneLayout.this.mDragHelper.rrr() != 0) {
                return;
            }
            if (SlidingPaneLayout.this.mSlideOffset == 0.0f) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                slidingPaneLayout.updateObscuredViewsVisibility(slidingPaneLayout.mSlideableView);
                SlidingPaneLayout slidingPaneLayout2 = SlidingPaneLayout.this;
                slidingPaneLayout2.dispatchOnPanelClosed(slidingPaneLayout2.mSlideableView);
                boolean unused = SlidingPaneLayout.this.mPreservedOpenState = false;
                return;
            }
            SlidingPaneLayout slidingPaneLayout3 = SlidingPaneLayout.this;
            slidingPaneLayout3.dispatchOnPanelOpened(slidingPaneLayout3.mSlideableView);
            boolean unused2 = SlidingPaneLayout.this.mPreservedOpenState = true;
        }

        public int qw(View view, int i2, int i3) {
            int paddingLeft = SlidingPaneLayout.this.getPaddingLeft() + ((LayoutParams) SlidingPaneLayout.this.mSlideableView.getLayoutParams()).leftMargin;
            return Math.min(Math.max(i2, paddingLeft), SlidingPaneLayout.this.mSlideRange + paddingLeft);
        }

        /* renamed from: switch  reason: not valid java name */
        public void m50switch(View view, float f, float f2) {
            int i2;
            int paddingLeft = SlidingPaneLayout.this.getPaddingLeft() + ((LayoutParams) view.getLayoutParams()).leftMargin;
            int i3 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
            if (i3 != 0 || SlidingPaneLayout.this.mSlideOffset <= 0.25f) {
                if (i3 > 0) {
                    paddingLeft += SlidingPaneLayout.this.mSlideRange;
                }
                SlidingPaneLayout.this.mDragHelper.k(paddingLeft, view.getTop());
                SlidingPaneLayout.this.invalidate();
                return;
            }
            if (SlidingPaneLayout.this.mAutoSlide) {
                i2 = SlidingPaneLayout.this.mSlideRange;
            } else {
                i2 = this.qw + 10;
            }
            SlidingPaneLayout.this.mDragHelper.k(paddingLeft + i2, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        public boolean th() {
            return SlidingPaneLayout.this.mIsActivityTranslucent;
        }

        public boolean when(View view, int i2) {
            if (SlidingPaneLayout.this.mIsUnableToDrag) {
                return false;
            }
            if (!SlidingPaneLayout.this.mIsActivityTranslucent) {
                SlidingPaneLayout.this.convertActivityToTranslucent();
            }
            return ((LayoutParams) view.getLayoutParams()).slideable;
        }

        public void yj(int i2, int i3) {
            if (!SlidingPaneLayout.this.mIsActivityTranslucent) {
                SlidingPaneLayout.this.convertActivityToTranslucent();
            }
            SlidingPaneLayout.this.mDragHelper.de(SlidingPaneLayout.this.mSlideableView, i3);
        }
    }

    public interface rg {
        void qw(SlidingPaneLayout slidingPaneLayout, View view);
    }

    public static class th implements rg {
        public void qw(SlidingPaneLayout slidingPaneLayout, View view) {
            ViewCompat.postInvalidateOnAnimation(slidingPaneLayout, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public static class yj extends th {
        public void qw(SlidingPaneLayout slidingPaneLayout, View view) {
            ViewCompat.setLayerPaint(view, ((LayoutParams) view.getLayoutParams()).dimPaint);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            IMPL = new yj();
        } else {
            IMPL = new th();
        }
    }

    public SlidingPaneLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private void dimChildView(View view, float f, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f > 0.0f && i2 != 0) {
            int i3 = (((int) (((float) ((-16777216 & i2) >>> 24)) * f)) << 24) | (i2 & ViewCompat.MEASURED_SIZE_MASK);
            if (layoutParams.dimPaint == null) {
                layoutParams.dimPaint = new Paint();
            }
            layoutParams.dimPaint.setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.SRC_OVER));
            if (ViewCompat.getLayerType(view) != 2) {
                ViewCompat.setLayerType(view, 2, layoutParams.dimPaint);
            }
            invalidateChildRegion(view);
        } else if (ViewCompat.getLayerType(view) != 0) {
            Paint paint = layoutParams.dimPaint;
            if (paint != null) {
                paint.setColorFilter((ColorFilter) null);
            }
            de deVar = new de(view);
            this.mPostedRunnables.add(deVar);
            ViewCompat.postOnAnimation(this, deVar);
        }
    }

    /* access modifiers changed from: private */
    public void invalidateChildRegion(View view) {
        IMPL.qw(this, view);
    }

    /* access modifiers changed from: private */
    public void onPanelDragged(int i2) {
        View view;
        if (this.mCanSlide && (view = this.mSlideableView) != null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            float paddingLeft = ((float) (i2 - (getPaddingLeft() + layoutParams.leftMargin))) / ((float) this.mSlideRange);
            this.mSlideOffset = paddingLeft;
            if (this.mParallaxBy != 0) {
                parallaxOtherViews(paddingLeft);
            }
            if (layoutParams.dimWhenOffset) {
                dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
            }
            dispatchOnPanelSlide(this.mSlideableView);
        }
    }

    private void parallaxOtherViews(float f) {
        LayoutParams layoutParams = (LayoutParams) this.mSlideableView.getLayoutParams();
        boolean z = layoutParams.dimWhenOffset && layoutParams.leftMargin <= 0;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != this.mSlideableView) {
                int i3 = this.mParallaxBy;
                this.mParallaxOffset = f;
                childAt.offsetLeftAndRight(((int) ((1.0f - this.mParallaxOffset) * ((float) i3))) - ((int) ((1.0f - f) * ((float) i3))));
                if (z) {
                    dimChildView(childAt, 1.0f - this.mParallaxOffset, this.mCoveredFadeColor);
                }
            }
        }
    }

    public static boolean viewIsOpaque(View view) {
        Drawable background;
        if (Build.VERSION.SDK_INT < 18 && (background = view.getBackground()) != null && background.getOpacity() == -1) {
            return true;
        }
        return false;
    }

    public abstract void attachActivity(Activity activity);

    public boolean canScroll(View view, boolean z, int i2, int i3, int i4) {
        int i5;
        View view2 = view;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i6 = i3 + scrollX;
                if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom()) {
                    if (canScroll(childAt, true, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (!z || !ViewCompat.canScrollHorizontally(view, -i2)) {
            return false;
        }
        return true;
    }

    @Deprecated
    public boolean canSlide() {
        return this.mCanSlide;
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public boolean closePane() {
        return closePane(this.mSlideableView, 0);
    }

    public void computeScroll() {
        if (!this.mDragHelper.m77if(true)) {
            return;
        }
        if (!this.mCanSlide) {
            this.mDragHelper.qw();
        } else {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public abstract void convertActivityFromTranslucent();

    public abstract void convertActivityToTranslucent();

    public void dispatchOnPanelClosed(View view) {
        PanelSlideListener panelSlideListener = this.mPanelSlideListener;
        if (panelSlideListener != null) {
            panelSlideListener.onPanelClosed(view);
        }
        sendAccessibilityEvent(32);
    }

    public void dispatchOnPanelOpened(View view) {
        PanelSlideListener panelSlideListener = this.mPanelSlideListener;
        if (panelSlideListener != null) {
            panelSlideListener.onPanelOpened(view);
        }
        sendAccessibilityEvent(32);
    }

    public void dispatchOnPanelSlide(View view) {
        PanelSlideListener panelSlideListener = this.mPanelSlideListener;
        if (panelSlideListener != null) {
            panelSlideListener.onPanelSlide(view, this.mSlideOffset);
        }
    }

    public void draw(Canvas canvas) {
        try {
            super.draw(canvas);
            View childAt = getChildCount() > 1 ? getChildAt(1) : null;
            if (this.showShadow && childAt != null) {
                if (this.mShadowDrawable != null) {
                    int intrinsicWidth = this.mShadowDrawable.getIntrinsicWidth();
                    int left = childAt.getLeft();
                    this.mShadowDrawable.setBounds(left - intrinsicWidth, childAt.getTop(), left, childAt.getBottom());
                    this.mShadowDrawable.draw(canvas);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean z;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save();
        if (this.mCanSlide && !layoutParams.slideable && this.mSlideableView != null && this.mAutoSlide) {
            canvas.getClipBounds(this.mTmpRect);
            Rect rect = this.mTmpRect;
            rect.right = Math.min(rect.right, this.mSlideableView.getLeft());
            canvas.clipRect(this.mTmpRect);
        }
        if (Build.VERSION.SDK_INT >= 11) {
            z = super.drawChild(canvas, view, j);
        } else if (!layoutParams.dimWhenOffset || this.mSlideOffset <= 0.0f) {
            if (view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(false);
            }
            z = super.drawChild(canvas, view, j);
        } else {
            if (!view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(true);
            }
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null) {
                canvas.drawBitmap(drawingCache, (float) view.getLeft(), (float) view.getTop(), layoutParams.dimPaint);
                z = false;
            } else {
                "drawChild: child view " + view + " returned null drawing cache";
                z = super.drawChild(canvas, view, j);
            }
        }
        canvas.restoreToCount(save);
        return z;
    }

    public abstract void forceActivityTransparent(boolean z);

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public int getCoveredFadeColor() {
        return this.mCoveredFadeColor;
    }

    public int getParallaxDistance() {
        return this.mParallaxBy;
    }

    public int getSliderFadeColor() {
        return this.mSliderFadeColor;
    }

    public boolean isDimmed(View view) {
        if (view == null) {
            return false;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!this.mCanSlide || !layoutParams.dimWhenOffset || this.mSlideOffset <= 0.0f) {
            return false;
        }
        return true;
    }

    public boolean isOpen() {
        return !this.mCanSlide || this.mSlideOffset == 1.0f;
    }

    public void isShowShadow(boolean z) {
        this.showShadow = z;
    }

    public boolean isSlideable() {
        return this.mCanSlide;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
        int size = this.mPostedRunnables.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mPostedRunnables.get(i2).run();
        }
        this.mPostedRunnables.clear();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b8, code lost:
        if (canScroll(r13, false, java.lang.Math.round(r0 - r13.mInitialMotionX), java.lang.Math.round(r0), java.lang.Math.round(r1)) != false) goto L_0x00ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00e2, code lost:
        if (isDimmed(r13.mSlideableView) != false) goto L_0x00e4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00f5 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r14) {
        /*
            r13 = this;
            int r0 = androidx.core.view.MotionEventCompat.getActionMasked(r14)
            boolean r1 = r13.mCanSlide
            r2 = 1
            if (r1 != 0) goto L_0x002a
            if (r0 != 0) goto L_0x002a
            int r1 = r13.getChildCount()
            if (r1 <= r2) goto L_0x002a
            android.view.View r1 = r13.getChildAt(r2)
            if (r1 == 0) goto L_0x002a
            fe.fe.ddd.rrr.fe r3 = r13.mDragHelper
            float r4 = r14.getX()
            int r4 = (int) r4
            float r5 = r14.getY()
            int r5 = (int) r5
            boolean r1 = r3.a(r1, r4, r5)
            r1 = r1 ^ r2
            r13.mPreservedOpenState = r1
        L_0x002a:
            float r1 = r14.getX()
            int r3 = r13.mScreenWidth
            double r3 = (double) r3
            double r5 = r13.slideWidthFactor
            double r3 = r3 * r5
            int r3 = (int) r3
            float r3 = (float) r3
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 < 0) goto L_0x0045
            fe.fe.ddd.rrr.fe r0 = r13.mDragHelper
            r0.ad()
            boolean r14 = super.onInterceptTouchEvent(r14)
            return r14
        L_0x0045:
            boolean r1 = r13.mCanSlide
            if (r1 == 0) goto L_0x0100
            boolean r1 = r13.mIsUnableToDrag
            if (r1 == 0) goto L_0x0051
            if (r0 == 0) goto L_0x0051
            goto L_0x0100
        L_0x0051:
            r1 = 3
            r3 = 0
            if (r0 == r1) goto L_0x00fa
            if (r0 != r2) goto L_0x0059
            goto L_0x00fa
        L_0x0059:
            if (r0 == 0) goto L_0x00c2
            r1 = 2
            if (r0 == r1) goto L_0x0060
            goto L_0x00e6
        L_0x0060:
            float r0 = r14.getX()
            float r1 = r14.getY()
            float r4 = r13.mInitialMotionX
            float r4 = r0 - r4
            float r4 = java.lang.Math.abs(r4)
            float r5 = r13.mInitialMotionY
            float r5 = r1 - r5
            float r5 = java.lang.Math.abs(r5)
            fe.fe.ddd.rrr.fe r6 = r13.mDragHelper
            int r6 = r6.eee()
            r7 = 0
            int r7 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r7 <= 0) goto L_0x0098
            int r7 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0098
            boolean r7 = r13.mCanSlide
            if (r7 == 0) goto L_0x0098
            double r7 = (double) r0
            int r9 = r13.mScreenWidth
            double r9 = (double) r9
            double r11 = r13.slideEdgeFactor
            double r9 = r9 * r11
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 >= 0) goto L_0x0098
            goto L_0x00e4
        L_0x0098:
            float r6 = (float) r6
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x00a1
            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r4 > 0) goto L_0x00ba
        L_0x00a1:
            r7 = 0
            float r4 = r13.mInitialMotionX
            float r4 = r0 - r4
            int r8 = java.lang.Math.round(r4)
            int r9 = java.lang.Math.round(r0)
            int r10 = java.lang.Math.round(r1)
            r5 = r13
            r6 = r13
            boolean r0 = r5.canScroll(r6, r7, r8, r9, r10)
            if (r0 == 0) goto L_0x00e6
        L_0x00ba:
            fe.fe.ddd.rrr.fe r14 = r13.mDragHelper
            r14.ad()
            r13.mIsUnableToDrag = r2
            return r3
        L_0x00c2:
            r13.mIsUnableToDrag = r3
            float r0 = r14.getX()
            float r1 = r14.getY()
            r13.mInitialMotionX = r0
            r13.mInitialMotionY = r1
            fe.fe.ddd.rrr.fe r4 = r13.mDragHelper
            android.view.View r5 = r13.mSlideableView
            int r0 = (int) r0
            int r1 = (int) r1
            boolean r0 = r4.a(r5, r0, r1)
            if (r0 == 0) goto L_0x00e6
            android.view.View r0 = r13.mSlideableView
            boolean r0 = r13.isDimmed(r0)
            if (r0 == 0) goto L_0x00e6
        L_0x00e4:
            r0 = 1
            goto L_0x00e7
        L_0x00e6:
            r0 = 0
        L_0x00e7:
            fe.fe.ddd.rrr.fe r1 = r13.mDragHelper     // Catch:{ Exception -> 0x00ee }
            boolean r14 = r1.l(r14)     // Catch:{ Exception -> 0x00ee }
            goto L_0x00f3
        L_0x00ee:
            r14 = move-exception
            r14.printStackTrace()
            r14 = 0
        L_0x00f3:
            if (r14 != 0) goto L_0x00f9
            if (r0 == 0) goto L_0x00f8
            goto L_0x00f9
        L_0x00f8:
            r2 = 0
        L_0x00f9:
            return r2
        L_0x00fa:
            fe.fe.ddd.rrr.fe r14 = r13.mDragHelper
            r14.ad()
            return r3
        L_0x0100:
            fe.fe.ddd.rrr.fe r0 = r13.mDragHelper
            r0.ad()
            boolean r14 = super.onInterceptTouchEvent(r14)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.widget.SlidingPaneLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.mFirstLayout) {
            this.mSlideOffset = (!this.mCanSlide || !this.mPreservedOpenState) ? 0.0f : 1.0f;
        }
        int i9 = paddingLeft;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.slideable) {
                    int i11 = i8 - paddingRight;
                    int min = (Math.min(paddingLeft, i11 - this.mOverhangSize) - i9) - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.mSlideRange = min;
                    layoutParams.dimWhenOffset = ((layoutParams.leftMargin + i9) + min) + (measuredWidth / 2) > i11;
                    i9 += ((int) (((float) min) * this.mSlideOffset)) + layoutParams.leftMargin;
                } else if (!this.mCanSlide || (i7 = this.mParallaxBy) == 0) {
                    i9 = paddingLeft;
                } else {
                    i6 = (int) ((1.0f - this.mSlideOffset) * ((float) i7));
                    i9 = paddingLeft;
                    int i12 = i9 - i6;
                    childAt.layout(i12, paddingTop, measuredWidth + i12, childAt.getMeasuredHeight() + paddingTop);
                    paddingLeft += childAt.getWidth();
                }
                i6 = 0;
                int i122 = i9 - i6;
                childAt.layout(i122, paddingTop, measuredWidth + i122, childAt.getMeasuredHeight() + paddingTop);
                paddingLeft += childAt.getWidth();
            }
        }
        if (this.mFirstLayout) {
            if (this.mCanSlide) {
                if (this.mParallaxBy != 0) {
                    parallaxOtherViews(this.mSlideOffset);
                }
                if (((LayoutParams) this.mSlideableView.getLayoutParams()).dimWhenOffset) {
                    dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
                }
            } else {
                for (int i13 = 0; i13 < childCount; i13++) {
                    dimChildView(getChildAt(i13), 0.0f, this.mSliderFadeColor);
                }
            }
            updateObscuredViewsVisibility(this.mSlideableView);
        }
        this.mFirstLayout = false;
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
            } else if (mode != Integer.MIN_VALUE && mode == 0) {
                size = 300;
            }
        } else if (mode2 == 0) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Height must not be UNSPECIFIED");
            } else if (mode2 == 0) {
                mode2 = Integer.MIN_VALUE;
                size2 = 300;
            }
        }
        boolean z = false;
        if (mode2 == Integer.MIN_VALUE) {
            i4 = (size2 - getPaddingTop()) - getPaddingBottom();
            i5 = 0;
        } else if (mode2 != 1073741824) {
            i5 = 0;
            i4 = -1;
        } else {
            i5 = (size2 - getPaddingTop()) - getPaddingBottom();
            i4 = i5;
        }
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        this.mSlideableView = null;
        float f = 0.0f;
        int i16 = 0;
        boolean z2 = false;
        float f2 = 0.0f;
        while (true) {
            i6 = 8;
            if (i16 >= childCount) {
                break;
            }
            View childAt = getChildAt(i16);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                layoutParams.dimWhenOffset = z;
            } else {
                float f3 = layoutParams.weight;
                if (f3 > f) {
                    f2 += f3;
                    if (layoutParams.width == 0) {
                    }
                }
                int i17 = layoutParams.leftMargin + layoutParams.rightMargin;
                int i18 = layoutParams.width;
                if (i18 == -2) {
                    i12 = View.MeasureSpec.makeMeasureSpec(size - i17, Integer.MIN_VALUE);
                    i13 = -1;
                } else {
                    i13 = -1;
                    if (i18 == -1) {
                        i12 = View.MeasureSpec.makeMeasureSpec(size - i17, 1073741824);
                    } else {
                        i12 = View.MeasureSpec.makeMeasureSpec(i18, 1073741824);
                    }
                }
                int i19 = layoutParams.height;
                if (i19 == -2) {
                    i15 = Integer.MIN_VALUE;
                    i14 = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
                } else {
                    i15 = Integer.MIN_VALUE;
                    if (i19 == i13) {
                        i14 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                    } else {
                        i14 = View.MeasureSpec.makeMeasureSpec(i19, 1073741824);
                    }
                }
                childAt.measure(i12, i14);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (mode2 == i15 && measuredHeight > i5) {
                    i5 = Math.min(measuredHeight, i4);
                }
                paddingLeft -= measuredWidth;
                boolean z3 = paddingLeft < 0;
                layoutParams.slideable = z3;
                z2 |= z3;
                if (z3) {
                    this.mSlideableView = childAt;
                }
            }
            i16++;
            z = false;
            f = 0.0f;
        }
        if (z2 || f2 > 0.0f) {
            int i20 = size - this.mOverhangSize;
            int i21 = 0;
            while (i21 < childCount) {
                View childAt2 = getChildAt(i21);
                if (childAt2.getVisibility() != i6) {
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != i6) {
                        boolean z4 = layoutParams2.width == 0 && layoutParams2.weight > 0.0f;
                        if (z4) {
                            i7 = 0;
                        } else {
                            i7 = childAt2.getMeasuredWidth();
                        }
                        if (!z2 || childAt2 == this.mSlideableView) {
                            if (layoutParams2.weight > 0.0f) {
                                if (layoutParams2.width == 0) {
                                    int i22 = layoutParams2.height;
                                    if (i22 == -2) {
                                        i9 = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
                                        i8 = 1073741824;
                                    } else if (i22 == -1) {
                                        i8 = 1073741824;
                                        i9 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                                    } else {
                                        i8 = 1073741824;
                                        i9 = View.MeasureSpec.makeMeasureSpec(i22, 1073741824);
                                    }
                                } else {
                                    i8 = 1073741824;
                                    i9 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                }
                                if (z2) {
                                    int i23 = size - (layoutParams2.leftMargin + layoutParams2.rightMargin);
                                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i23, i8);
                                    if (i7 != i23) {
                                        childAt2.measure(makeMeasureSpec, i9);
                                    }
                                } else {
                                    childAt2.measure(View.MeasureSpec.makeMeasureSpec(i7 + ((int) ((layoutParams2.weight * ((float) Math.max(0, paddingLeft))) / f2)), 1073741824), i9);
                                    i21++;
                                    i6 = 8;
                                }
                            }
                        } else if (layoutParams2.width < 0 && (i7 > i20 || layoutParams2.weight > 0.0f)) {
                            if (z4) {
                                int i24 = layoutParams2.height;
                                if (i24 == -2) {
                                    i11 = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
                                    i10 = 1073741824;
                                } else if (i24 == -1) {
                                    i10 = 1073741824;
                                    i11 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                                } else {
                                    i10 = 1073741824;
                                    i11 = View.MeasureSpec.makeMeasureSpec(i24, 1073741824);
                                }
                            } else {
                                i10 = 1073741824;
                                i11 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            }
                            childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.mAutoSlide ? i20 : size, i10), i11);
                        }
                    }
                }
                i21++;
                i6 = 8;
            }
        }
        setMeasuredDimension(size, i5);
        this.mCanSlide = z2;
        if (this.mDragHelper.rrr() != 0 && !z2) {
            this.mDragHelper.qw();
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.isOpen) {
            openPane();
        } else {
            closePane();
        }
        this.mPreservedOpenState = savedState.isOpen;
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.isOpen = isSlideable() ? isOpen() : this.mPreservedOpenState;
        return savedState;
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            this.mFirstLayout = true;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mCanSlide) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.mInitialMotionX = x;
            this.mInitialMotionY = y;
        } else if (action != 1) {
            if (action == 2) {
                float x2 = motionEvent.getX();
                if (Math.abs(motionEvent.getY() - this.mInitialMotionY) > Math.abs(x2 - this.mInitialMotionX)) {
                    return true;
                }
            }
        } else if (isDimmed(this.mSlideableView)) {
            float x3 = motionEvent.getX();
            float y2 = motionEvent.getY();
            float f = x3 - this.mInitialMotionX;
            float f2 = y2 - this.mInitialMotionY;
            int eee = this.mDragHelper.eee();
            if ((f * f) + (f2 * f2) < ((float) (eee * eee)) && this.mDragHelper.a(this.mSlideableView, (int) x3, (int) y2)) {
                closePane(this.mSlideableView, 0);
            }
        }
        try {
            this.mDragHelper.b(motionEvent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean openPane() {
        return openPane(this.mSlideableView, 0);
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.mCanSlide) {
            this.mPreservedOpenState = view == this.mSlideableView;
        }
    }

    public void setActivityIsTranslucent(boolean z) {
        this.mIsActivityTranslucent = z;
    }

    public void setAllChildrenVisible() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    public void setAutoSlideToRight(boolean z) {
        this.mAutoSlide = z;
    }

    public void setCanSlideRegionFactor(double d) {
        this.slideWidthFactor = d;
    }

    public void setCoveredFadeColor(int i2) {
        this.mCoveredFadeColor = i2;
    }

    public void setPanelSlideListener(PanelSlideListener panelSlideListener) {
        this.mPanelSlideListener = panelSlideListener;
    }

    public void setParallaxDistance(int i2) {
        this.mParallaxBy = i2;
        requestLayout();
    }

    public void setShadowDrawable(Drawable drawable) {
        this.mShadowDrawable = drawable;
    }

    public void setShadowResource(int i2) {
        setShadowDrawable(getResources().getDrawable(i2));
    }

    public void setSliderFadeColor(int i2) {
        this.mSliderFadeColor = i2;
    }

    @Deprecated
    public void smoothSlideClosed() {
        closePane();
    }

    @Deprecated
    public void smoothSlideOpen() {
        openPane();
    }

    public boolean smoothSlideTo(float f, int i2) {
        if (!this.mCanSlide) {
            return false;
        }
        int paddingLeft = (int) (((float) (getPaddingLeft() + ((LayoutParams) this.mSlideableView.getLayoutParams()).leftMargin)) + (f * ((float) this.mSlideRange)));
        fe.fe.ddd.rrr.fe feVar = this.mDragHelper;
        View view = this.mSlideableView;
        if (!feVar.m(view, paddingLeft, view.getTop())) {
            return false;
        }
        setAllChildrenVisible();
        ViewCompat.postInvalidateOnAnimation(this);
        return true;
    }

    public void updateObscuredViewsVisibility(View view) {
        int i2;
        int i3;
        int i4;
        int i5;
        View childAt;
        View view2 = view;
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !viewIsOpaque(view)) {
            i5 = 0;
            i4 = 0;
            i3 = 0;
            i2 = 0;
        } else {
            i5 = view.getLeft();
            i4 = view.getRight();
            i3 = view.getTop();
            i2 = view.getBottom();
        }
        int childCount = getChildCount();
        int i6 = 0;
        while (true) {
            if (i6 < childCount && (childAt = getChildAt(i6)) != view2) {
                childAt.setVisibility((Math.max(paddingLeft, childAt.getLeft()) < i5 || Math.max(paddingTop, childAt.getTop()) < i3 || Math.min(width, childAt.getRight()) > i4 || Math.min(height, childAt.getBottom()) > i2) ? 0 : 4);
                i6++;
                view2 = view;
            } else {
                return;
            }
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static final int[] ATTRS = {16843137};
        public Paint dimPaint;
        public boolean dimWhenOffset;
        public boolean slideable;
        public float weight = 0.0f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.weight = layoutParams.weight;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
            this.weight = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private boolean closePane(View view, int i2) {
        if (!this.mFirstLayout && !smoothSlideTo(0.0f, i2)) {
            return false;
        }
        this.mPreservedOpenState = false;
        return true;
    }

    private boolean openPane(View view, int i2) {
        if (!this.mFirstLayout && !smoothSlideTo(1.0f, i2)) {
            return false;
        }
        this.mPreservedOpenState = true;
        return true;
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mSliderFadeColor = -858993460;
        this.slideWidthFactor = 0.25d;
        this.slideEdgeFactor = 0.15d;
        this.showShadow = true;
        this.mFirstLayout = true;
        this.mTmpRect = new Rect();
        this.mPostedRunnables = new ArrayList<>();
        this.mAutoSlide = true;
        float f = context.getResources().getDisplayMetrics().density;
        this.mOverhangSize = 5;
        this.mScreenWidth = context.getResources().getDisplayMetrics().widthPixels;
        setWillNotDraw(false);
        ViewCompat.setAccessibilityDelegate(this, new ad());
        ViewCompat.setImportantForAccessibility(this, 1);
        fe.fe.ddd.rrr.fe feVar = fe.fe.ddd.rrr.fe.m76switch(this, 0.5f, new fe());
        this.mDragHelper = feVar;
        feVar.h(1);
        this.mDragHelper.j(f * 400.0f);
    }
}
