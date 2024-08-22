package com.baidu.swan.menu.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

public class WrapContentHeightViewPager extends ViewPager {
    public WrapContentHeightViewPager(Context context) {
        super(context);
    }

    public WrapContentHeightViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (getChildCount() > 0) {
            int count = getChildCount();
            View child = null;
            int height = -1;
            for (int i2 = 0; i2 < count; i2++) {
                View view2 = getChildAt(i2);
                if (view2 != null) {
                    view2.measure(widthMeasureSpec, heightMeasureSpec);
                    int h2 = view2.getMeasuredHeight();
                    if (h2 > height) {
                        height = h2;
                        child = view2;
                    }
                }
            }
            View view3 = child == null ? getChildAt(0) : child;
            if (view3 != null) {
                view3.measure(widthMeasureSpec, heightMeasureSpec);
            }
            setMeasuredDimension(getMeasuredWidth(), measureHeight(heightMeasureSpec, view3));
        }
    }

    private int measureHeight(int measureSpec, View view2) {
        int result = 0;
        int specMode = View.MeasureSpec.getMode(measureSpec);
        int specSize = View.MeasureSpec.getSize(measureSpec);
        if (specMode == 1073741824) {
            return specSize;
        }
        if (view2 != null) {
            result = view2.getMeasuredHeight();
        }
        if (specMode == Integer.MIN_VALUE) {
            return Math.min(result, specSize);
        }
        return result;
    }
}
