package com.baidu.wallet.base.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.apollon.utils.DisplayUtils;

public class GridLayout extends ViewGroup {
    public static final int a = 3;
    public static final int b = 1;
    public static final int c = 1;
    public int d;
    public int e;
    public int f;
    public RectF g;
    public Paint h;

    /* renamed from: i  reason: collision with root package name */
    public Integer f1143i = null;
    public int j = 0;
    public int k = 0;
    public Paint l;
    public Integer m = null;
    public RectF n = new RectF();

    /* renamed from: o  reason: collision with root package name */
    public int f1144o = 0;

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
        this.d = 3;
        this.e = DisplayUtils.dip2px(getContext(), 1.0f);
        this.f = DisplayUtils.dip2px(getContext(), 1.0f);
        this.g = new RectF();
        this.h = new Paint();
        this.l = new Paint();
        this.n = new RectF();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.m != null && getChildCount() > this.d && this.f > 0) {
            float height = (float) getChildAt(getChildCount() - 1).getHeight();
            for (int i2 = 1; ((double) i2) < Math.ceil((double) ((((float) getChildCount()) * 1.0f) / ((float) this.d))); i2++) {
                RectF rectF = this.n;
                rectF.left = (float) this.j;
                int i3 = this.f;
                float f2 = (float) i2;
                rectF.top = (((float) getPaddingTop()) + ((((float) i3) + height) * f2)) - ((float) i3);
                this.n.right = (float) (getWidth() - this.j);
                this.n.bottom = ((float) getPaddingTop()) + ((((float) this.f) + height) * f2);
                canvas.drawRect(this.n, this.l);
            }
        }
        if (this.m != null && this.d > 1 && this.e > 0) {
            float width = (float) getChildAt(getChildCount() - 1).getWidth();
            for (int i4 = 1; i4 < this.d; i4++) {
                RectF rectF2 = this.n;
                int i5 = this.e;
                float f3 = (float) i4;
                rectF2.left = (((float) getPaddingLeft()) + ((((float) i5) + width) * f3)) - ((float) i5);
                RectF rectF3 = this.n;
                rectF3.top = (float) this.k;
                rectF3.right = ((float) getPaddingLeft()) + ((((float) this.e) + width) * f3);
                this.n.bottom = (float) (getHeight() - this.k);
                canvas.drawRect(this.n, this.l);
            }
        }
        if (getChildCount() % this.d != 0 && this.f1143i != null) {
            View childAt = getChildAt(getChildCount() - 1);
            this.g.set((float) (childAt.getLeft() + childAt.getWidth() + this.e), (float) childAt.getTop(), (float) (getLeft() + getWidth()), (float) (getTop() + getHeight()));
            this.h.setColor(this.f1143i.intValue());
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
        int i5 = this.e;
        int i6 = this.d;
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
                if (this.f1144o <= i9) {
                    this.f1144o = i9;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i7, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f1144o, 1073741824));
                if ((i10 - i8) % this.d == 0) {
                    paddingLeft = getPaddingLeft();
                    if (i10 != 0) {
                        paddingTop += this.f1144o + this.f;
                    }
                } else {
                    paddingLeft += this.e + i7;
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
                layoutParams.height = this.f1144o;
            } else {
                i8++;
            }
        }
        int i11 = childCount - i8;
        int i12 = this.d;
        int i13 = i11 / i12;
        if (i11 % i12 != 0) {
            i4 = 1;
        }
        int i14 = i13 + i4;
        setMeasuredDimension(View.MeasureSpec.getSize(i2), (i9 * i14) + (this.f * (i14 - 1)) + getPaddingTop() + getPaddingBottom());
    }

    public void setColumnCount(int i2) {
        this.d = i2;
    }

    public void setEmptyAreaColor(int i2) {
        this.f1143i = Integer.valueOf(i2);
    }

    public void setHorizontalSpacing(int i2) {
        this.e = i2;
    }

    public void setSeparateLine(int i2, int i3, int i4) {
        Integer valueOf = Integer.valueOf(i2);
        this.m = valueOf;
        this.j = i3;
        this.k = i4;
        this.l.setColor(valueOf.intValue());
    }

    public void setVerticalSpacing(int i2) {
        this.f = i2;
    }

    public GridLayout(Context context) {
        super(context);
        a();
    }
}
