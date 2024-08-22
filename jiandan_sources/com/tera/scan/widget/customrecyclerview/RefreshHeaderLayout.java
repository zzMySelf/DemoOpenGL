package com.tera.scan.widget.customrecyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class RefreshHeaderLayout extends ViewGroup {

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public RefreshHeaderLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private void layoutChildren() {
        getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        getPaddingRight();
        getPaddingBottom();
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight2 = childAt.getMeasuredHeight();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int i2 = paddingLeft + marginLayoutParams.leftMargin;
            int i3 = (paddingTop + marginLayoutParams.topMargin) - (measuredHeight2 - measuredHeight);
            childAt.layout(i2, i3, measuredWidth + i2, measuredHeight2 + i3);
        }
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        layoutChildren();
    }

    public void onMeasure(int i2, int i3) {
        if (getChildCount() > 0) {
            measureChildWithMargins(getChildAt(0), i2, 0, View.MeasureSpec.makeMeasureSpec(0, 0), 0);
        }
        super.onMeasure(i2, i3);
    }

    public RefreshHeaderLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public RefreshHeaderLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
