package com.dxmpay.wallet.base.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.dxmpay.apollon.utils.DisplayUtils;

public class GridLayout extends ViewGroup {
    public int a;
    public int b;
    public int c;
    public RectF d;
    public Paint e;
    public Integer f = null;
    public int g = 0;
    public int h = 0;

    /* renamed from: i  reason: collision with root package name */
    public Paint f4164i;
    public Integer j = null;
    public RectF k = new RectF();
    public int l = 0;

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

    public GridLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        this.a = 3;
        this.b = DisplayUtils.dip2px(getContext(), 1.0f);
        this.c = DisplayUtils.dip2px(getContext(), 1.0f);
        this.d = new RectF();
        this.e = new Paint();
        this.f4164i = new Paint();
        this.k = new RectF();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.j != null && getChildCount() > this.a && this.c > 0) {
            float height = (float) getChildAt(getChildCount() - 1).getHeight();
            for (int i2 = 1; ((double) i2) < Math.ceil((double) ((((float) getChildCount()) * 1.0f) / ((float) this.a))); i2++) {
                RectF rectF = this.k;
                rectF.left = (float) this.g;
                int i3 = this.c;
                float f2 = (float) i2;
                rectF.top = (((float) getPaddingTop()) + ((((float) i3) + height) * f2)) - ((float) i3);
                this.k.right = (float) (getWidth() - this.g);
                this.k.bottom = ((float) getPaddingTop()) + ((((float) this.c) + height) * f2);
                canvas.drawRect(this.k, this.f4164i);
            }
        }
        if (this.j != null && this.a > 1 && this.b > 0) {
            float width = (float) getChildAt(getChildCount() - 1).getWidth();
            for (int i4 = 1; i4 < this.a; i4++) {
                RectF rectF2 = this.k;
                int i5 = this.b;
                float f3 = (float) i4;
                rectF2.left = (((float) getPaddingLeft()) + ((((float) i5) + width) * f3)) - ((float) i5);
                RectF rectF3 = this.k;
                rectF3.top = (float) this.h;
                rectF3.right = ((float) getPaddingLeft()) + ((((float) this.b) + width) * f3);
                this.k.bottom = (float) (getHeight() - this.h);
                canvas.drawRect(this.k, this.f4164i);
            }
        }
        if (getChildCount() % this.a != 0 && this.f != null) {
            View childAt = getChildAt(getChildCount() - 1);
            this.d.set((float) (childAt.getLeft() + childAt.getWidth() + this.b), (float) childAt.getTop(), (float) (getLeft() + getWidth()), (float) (getTop() + getHeight()));
            this.e.setColor(this.f.intValue());
            canvas.drawRect(this.d, this.e);
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
        int i5 = this.b;
        int i6 = this.a;
        int i7 = (size - (i5 * (i6 - 1))) / i6;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i2, makeMeasureSpec);
                i9 = childAt.getMeasuredHeight();
                if (this.l <= i9) {
                    this.l = i9;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i7, 1073741824), View.MeasureSpec.makeMeasureSpec(this.l, 1073741824));
                if ((i10 - i8) % this.a == 0) {
                    paddingLeft = getPaddingLeft();
                    if (i10 != 0) {
                        paddingTop += this.l + this.c;
                    }
                } else {
                    paddingLeft += this.b + i7;
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
                layoutParams.width = i7;
                layoutParams.height = this.l;
            } else {
                i8++;
            }
        }
        int i11 = childCount - i8;
        int i12 = this.a;
        int i13 = i11 / i12;
        if (i11 % i12 != 0) {
            i4 = 1;
        }
        int i14 = i13 + i4;
        setMeasuredDimension(View.MeasureSpec.getSize(i2), (i9 * i14) + (this.c * (i14 - 1)) + getPaddingTop() + getPaddingBottom());
    }

    public void setColumnCount(int i2) {
        this.a = i2;
    }

    public void setEmptyAreaColor(int i2) {
        this.f = Integer.valueOf(i2);
    }

    public void setHorizontalSpacing(int i2) {
        this.b = i2;
    }

    public void setSeparateLine(int i2, int i3, int i4) {
        Integer valueOf = Integer.valueOf(i2);
        this.j = valueOf;
        this.g = i3;
        this.h = i4;
        this.f4164i.setColor(valueOf.intValue());
    }

    public void setVerticalSpacing(int i2) {
        this.c = i2;
    }

    public GridLayout(Context context) {
        super(context);
        a();
    }
}
