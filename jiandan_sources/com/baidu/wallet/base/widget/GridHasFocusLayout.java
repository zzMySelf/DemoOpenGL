package com.baidu.wallet.base.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.internal.view.SupportMenu;
import com.baidu.apollon.utils.DisplayUtils;

public class GridHasFocusLayout extends ViewGroup {
    public static final int a = 3;
    public static final int b = 1;
    public static final int c = 1;
    public int d;
    public int e;
    public int f;
    public RectF g;
    public Paint h;

    /* renamed from: i  reason: collision with root package name */
    public Integer f1142i = null;
    public int j = -1;
    public boolean k = true;
    public Paint l = new Paint();

    public static class LayoutParams extends ViewGroup.LayoutParams {
        public int a;
        public int b;

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public GridHasFocusLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        this.d = 3;
        this.e = DisplayUtils.dip2px(getContext(), 1.0f);
        this.f = DisplayUtils.dip2px(getContext(), 1.0f);
        this.g = new RectF();
        this.h = new Paint();
        this.l.setColor(SupportMenu.CATEGORY_MASK);
    }

    private void b() {
        this.j = -1;
        invalidate();
    }

    public void addSelectionView(View view) {
    }

    public void configFocusPaintColor(int i2) {
        this.l.setColor(i2);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
        if (getChildCount() % this.d != 0 && this.f1142i != null) {
            View childAt = getChildAt(getChildCount() - 1);
            this.g.set((float) (childAt.getLeft() + childAt.getWidth() + this.e), (float) childAt.getTop(), (float) (getLeft() + getWidth()), (float) (getTop() + getHeight()));
            this.h.setColor(this.f1142i.intValue());
            canvas.drawRect(this.g, this.h);
        }
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int i7 = layoutParams.a;
                int i8 = layoutParams.b;
                childAt.layout(i7, i8, layoutParams.width + i7, layoutParams.height + i8);
            }
        }
    }

    @SuppressLint({"DrawAllocation"})
    public void onMeasure(int i2, int i3) {
        LayoutParams layoutParams;
        int i4 = 0;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3), 0);
        int size = (View.MeasureSpec.getSize(i2) - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        int i5 = size - (this.k ? this.e * 2 : 0);
        int i6 = this.e;
        int i7 = this.d;
        int i8 = (i5 - (i6 * (i7 - 1))) / i7;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i2, makeMeasureSpec);
                i10 = childAt.getMeasuredHeight();
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(i10, 1073741824));
                if ((i11 - i9) % this.d == 0) {
                    paddingLeft = getPaddingLeft() + (this.k ? this.e : 0);
                    if (i11 != 0) {
                        paddingTop += this.f + i10;
                    } else {
                        paddingTop = this.k ? this.f : 0;
                    }
                } else {
                    paddingLeft += this.e + i8;
                }
                if (childAt.getLayoutParams() == null || !(childAt.getLayoutParams() instanceof LayoutParams)) {
                    LayoutParams layoutParams2 = new LayoutParams(0, 0);
                    childAt.setLayoutParams(layoutParams2);
                    layoutParams = layoutParams2;
                } else {
                    layoutParams = (LayoutParams) childAt.getLayoutParams();
                }
                layoutParams.a = paddingLeft;
                layoutParams.b = paddingTop;
                layoutParams.width = i8;
                layoutParams.height = i10;
            } else {
                i9++;
            }
        }
        int i12 = childCount - i9;
        int i13 = this.d;
        int i14 = (i12 / i13) + (i12 % i13 == 0 ? 0 : 1);
        int i15 = this.f;
        int i16 = (i10 * i14) + ((i14 - 1) * i15);
        if (this.k) {
            i4 = i15 * 2;
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i2), i16 + i4);
    }

    public void setColumnCount(int i2) {
        this.d = i2;
    }

    public void setEmptyAreaColor(int i2) {
        this.f1142i = Integer.valueOf(i2);
    }

    public void setHorizontalSpacing(int i2) {
        this.e = i2;
    }

    public void setSelection(int i2) {
        this.j = i2;
        invalidate();
    }

    public void setVerticalSpacing(int i2) {
        this.f = i2;
    }

    public void showSideLine(boolean z) {
        this.k = z;
    }

    public GridHasFocusLayout(Context context) {
        super(context);
        a();
    }

    private void a(Canvas canvas) {
        this.l.setStrokeWidth((float) this.e);
        int i2 = this.j;
        if (i2 >= 0 && i2 < getChildCount()) {
            View childAt = getChildAt(this.j);
            float left = (float) (childAt.getLeft() - (this.k ? this.f : 0));
            float top = (float) (childAt.getTop() - (this.k ? this.e : 0));
            float left2 = (float) (((childAt.getLeft() + childAt.getWidth()) + (this.k ? this.f : 0)) - 1);
            float top2 = (float) (((childAt.getTop() + childAt.getHeight()) + 0) - 1);
            Canvas canvas2 = canvas;
            float f2 = left;
            float f3 = top2;
            canvas2.drawLine(f2, top, left, f3, this.l);
            float f4 = left2;
            canvas2.drawLine(f2, top2, f4, f3, this.l);
            float f5 = top;
            canvas2.drawLine(f2, f5, f4, top, this.l);
            canvas2.drawLine(left2, f5, f4, top2, this.l);
        }
    }
}
