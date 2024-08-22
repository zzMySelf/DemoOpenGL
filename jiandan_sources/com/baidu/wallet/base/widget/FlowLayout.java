package com.baidu.wallet.base.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.apollon.utils.DisplayUtils;

public final class FlowLayout extends ViewGroup {
    public static final int a = 6;
    public static final int b = 6;
    public static final int c = 55;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h = 2;

    public FlowLayout(Context context) {
        super(context);
    }

    public int getChildViewHeight() {
        return this.g;
    }

    public int getHorizontalChildNum() {
        return this.h;
    }

    public int getHorizontalSpacing() {
        return this.e;
    }

    public int getVerticalSpacing() {
        return this.f;
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(paddingLeft, paddingTop, paddingLeft + measuredWidth, childAt.getMeasuredHeight() + paddingTop);
                if (i7 != childCount - 1) {
                    paddingLeft += this.e + measuredWidth;
                    if ((measuredWidth + paddingLeft) - 1 > i6) {
                        paddingLeft = getPaddingLeft();
                        paddingTop += this.d;
                    }
                }
            }
        }
    }

    public void onMeasure(int i2, int i3) {
        int size = (View.MeasureSpec.getSize(i2) - getPaddingLeft()) - getPaddingRight();
        View.MeasureSpec.getSize(i3);
        getPaddingTop();
        getPaddingBottom();
        int childCount = getChildCount();
        int i4 = this.e;
        int i5 = this.h;
        int i6 = (size - (i4 * (i5 - 1))) / i5;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), View.MeasureSpec.makeMeasureSpec(this.g, 1073741824));
                i8 = Math.max(i8, childAt.getMeasuredHeight() + this.f);
            }
        }
        this.d = i8;
        int i10 = this.h;
        int i11 = childCount / i10;
        if (childCount % i10 != 0) {
            i7 = 1;
        }
        int i12 = i11 + i7;
        setMeasuredDimension(size, (this.g * i12) + (this.f * (i12 - 1)));
    }

    public void setChildViewHeight(int i2) {
        this.g = i2;
    }

    public void setHorizontalChildNum(int i2) {
        this.h = i2;
    }

    public void setHorizontalSpacing(int i2) {
        this.e = i2;
    }

    public void setVerticalSpacing(int i2) {
        this.f = i2;
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = DisplayUtils.dip2px(context, 6.0f);
        this.f = DisplayUtils.dip2px(context, 6.0f);
        this.g = DisplayUtils.dip2px(context, 55.0f);
    }
}
