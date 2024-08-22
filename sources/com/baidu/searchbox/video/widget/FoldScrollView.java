package com.baidu.searchbox.video.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import com.baidu.searchbox.video.widget.LayoutState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0015\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0013H\u0002J\u000e\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\fJ\u000e\u0010\"\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\fJ\u000e\u0010#\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\fJ\u000e\u0010$\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\fJ \u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007H\u0014J0\u0010*\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0014J0\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0007H\u0016J0\u00104\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020'2\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007H\u0016J8\u00104\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020'2\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0016J@\u00104\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020'2\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\u0006\u00101\u001a\u000202H\u0016J\"\u00109\u001a\u00020\u001e2\u0006\u00108\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\b\u00101\u001a\u0004\u0018\u000102H\u0002J(\u0010:\u001a\u00020\u001e2\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0014J\u0018\u0010?\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020'2\u0006\u00103\u001a\u00020\u0007H\u0016J\u0012\u0010@\u001a\u00020\f2\b\u0010A\u001a\u0004\u0018\u00010BH\u0017R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0011\u0010\u000e\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\rR\u001a\u0010\u000f\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\r\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006C"}, d2 = {"Lcom/baidu/searchbox/video/widget/FoldScrollView;", "Landroidx/core/widget/NestedScrollView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "collapsePercent", "", "isCollapse", "", "()Z", "isExpand", "isExpandEnable", "setExpandEnable", "(Z)V", "layoutState", "Lcom/baidu/searchbox/video/widget/LayoutState;", "onFoldScrollListener", "Lcom/baidu/searchbox/video/widget/OnFoldScrollListener;", "getOnFoldScrollListener", "()Lcom/baidu/searchbox/video/widget/OnFoldScrollListener;", "setOnFoldScrollListener", "(Lcom/baidu/searchbox/video/widget/OnFoldScrollListener;)V", "scrollRange", "getScrollRange", "()I", "changeState", "", "state", "collapse", "isAnimate", "expand", "expandIfEnable", "forceExpand", "measureChild", "child", "Landroid/view/View;", "parentWidthMeasureSpec", "parentHeightMeasureSpec", "measureChildWithMargins", "widthUsed", "heightUsed", "onNestedPreScroll", "target", "dx", "dy", "consumed", "", "type", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScrollInternal", "onScrollChanged", "scrollX", "scrollY", "oldScrollX", "oldScrollY", "onStopNestedScroll", "onTouchEvent", "ev", "Landroid/view/MotionEvent;", "lib-feed-video_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FoldScrollView.kt */
public final class FoldScrollView extends NestedScrollView {
    private float collapsePercent;
    private boolean isExpandEnable;
    private LayoutState layoutState;
    private OnFoldScrollListener onFoldScrollListener;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FoldScrollView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FoldScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FoldScrollView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FoldScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isExpandEnable = true;
    }

    public final boolean isExpandEnable() {
        return this.isExpandEnable;
    }

    public final void setExpandEnable(boolean z) {
        this.isExpandEnable = z;
    }

    public final OnFoldScrollListener getOnFoldScrollListener() {
        return this.onFoldScrollListener;
    }

    public final void setOnFoldScrollListener(OnFoldScrollListener onFoldScrollListener2) {
        this.onFoldScrollListener = onFoldScrollListener2;
    }

    public final boolean isExpand() {
        return getScrollY() == 0;
    }

    public final boolean isCollapse() {
        return getScrollY() == getScrollRange();
    }

    public final int getScrollRange() {
        return computeVerticalScrollRange() - computeVerticalScrollExtent();
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        super.onScrollChanged(scrollX, scrollY, oldScrollX, oldScrollY);
        if (getScrollRange() == 0) {
            OnFoldScrollListener onFoldScrollListener2 = this.onFoldScrollListener;
            if (onFoldScrollListener2 != null) {
                onFoldScrollListener2.onFoldScrollPercentChange(this, 0.0f);
                return;
            }
            return;
        }
        float percent = ((float) scrollY) / ((float) getScrollRange());
        boolean z = true;
        if (!(this.collapsePercent == percent)) {
            this.collapsePercent = percent;
            if (percent < 0.0f) {
                this.collapsePercent = 0.0f;
            }
            if (this.collapsePercent > 1.0f) {
                this.collapsePercent = 1.0f;
            }
            if (this.collapsePercent == 0.0f) {
                changeState(LayoutState.EXPANDED.INSTANCE);
            }
            if (this.collapsePercent != 1.0f) {
                z = false;
            }
            if (z) {
                changeState(LayoutState.COLLAPSED.INSTANCE);
            }
            OnFoldScrollListener onFoldScrollListener3 = this.onFoldScrollListener;
            if (onFoldScrollListener3 != null) {
                onFoldScrollListener3.onFoldScrollPercentChange(this, this.collapsePercent);
            }
        }
    }

    public void onStopNestedScroll(View target, int type) {
        Intrinsics.checkNotNullParameter(target, "target");
        super.onStopNestedScroll(target, type);
        if (getScrollY() > getScrollRange() / 2) {
            collapse(true);
        } else {
            expand(true);
        }
    }

    public final void expand(boolean isAnimate) {
        if (isAnimate) {
            smoothScrollTo(0, 0);
        } else {
            scrollTo(0, 0);
        }
        changeState(LayoutState.EXPANDED.INSTANCE);
    }

    public final void expandIfEnable(boolean isAnimate) {
        if (this.isExpandEnable) {
            expand(isAnimate);
        }
    }

    public final void forceExpand(boolean isAnimate) {
        this.isExpandEnable = true;
        expandIfEnable(isAnimate);
    }

    public final void collapse(boolean isAnimate) {
        if (isAnimate) {
            smoothScrollTo(0, getScrollRange());
        } else {
            scrollTo(0, getScrollRange());
        }
        changeState(LayoutState.COLLAPSED.INSTANCE);
    }

    private final void changeState(LayoutState state) {
        if (!Intrinsics.areEqual((Object) this.layoutState, (Object) state)) {
            this.layoutState = state;
            OnFoldScrollListener onFoldScrollListener2 = this.onFoldScrollListener;
            if (onFoldScrollListener2 != null) {
                onFoldScrollListener2.onFoldScrollLayoutStateChanged(this, state);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void measureChild(View child, int parentWidthMeasureSpec, int parentHeightMeasureSpec) {
        Intrinsics.checkNotNullParameter(child, "child");
        ViewGroup.LayoutParams lp = child.getLayoutParams();
        child.measure(NestedScrollView.getChildMeasureSpec(parentWidthMeasureSpec, getPaddingLeft() + getPaddingRight(), lp.width), NestedScrollView.getChildMeasureSpec(parentHeightMeasureSpec, getPaddingTop() + getPaddingBottom(), lp.height));
    }

    /* access modifiers changed from: protected */
    public void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        Intrinsics.checkNotNullParameter(child, "child");
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) layoutParams;
            child.measure(NestedScrollView.getChildMeasureSpec(parentWidthMeasureSpec, getPaddingLeft() + getPaddingRight() + lp.leftMargin + lp.rightMargin + widthUsed, lp.width), NestedScrollView.getChildMeasureSpec(parentHeightMeasureSpec, getPaddingTop() + getPaddingBottom() + lp.topMargin + lp.bottomMargin + heightUsed, lp.height));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed, int type) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        int unConsumedDy = dy;
        if (dispatchNestedPreScroll(dx, unConsumedDy, consumed, (int[]) null, type)) {
            unConsumedDy -= consumed[1];
        }
        if (unConsumedDy > 0 && canScrollVertically(1)) {
            consumed[0] = 0;
            int oldScrollY = getScrollY();
            scrollBy(0, unConsumedDy);
            consumed[1] = consumed[1] + (getScrollY() - oldScrollY);
        }
    }

    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, int[] consumed) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        onNestedScrollInternal(dyUnconsumed, type, consumed);
    }

    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        Intrinsics.checkNotNullParameter(target, "target");
        onNestedScrollInternal(dyUnconsumed, type, (int[]) null);
    }

    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        Intrinsics.checkNotNullParameter(target, "target");
        onNestedScrollInternal(dyUnconsumed, 0, (int[]) null);
    }

    private final void onNestedScrollInternal(int dyUnconsumed, int type, int[] consumed) {
        int myUnconsumed;
        int myConsumed;
        int i2 = dyUnconsumed;
        int myUnconsumed2 = dyUnconsumed;
        if (i2 < 0 && getScrollY() >= 0 && this.isExpandEnable) {
            int oldScrollY = getScrollY();
            scrollBy(0, dyUnconsumed);
            int myConsumed2 = getScrollY() - oldScrollY;
            if (consumed != null) {
                int[] iArr = consumed;
                consumed[1] = consumed[1] + myConsumed2;
            }
            myConsumed = myConsumed2;
            myUnconsumed = i2 - myConsumed2;
        } else {
            myConsumed = 0;
            myUnconsumed = myUnconsumed2;
        }
        dispatchNestedScroll(0, myConsumed, 0, myUnconsumed, (int[]) null, type, consumed == null ? new int[2] : consumed);
    }

    public boolean onTouchEvent(MotionEvent ev) {
        if (!this.isExpandEnable) {
            return false;
        }
        return super.onTouchEvent(ev);
    }
}
