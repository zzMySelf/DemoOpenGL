package com.tera.scan.themeskin.viewcomplemen;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import fe.mmm.qw.d.fe.ad;

public class RecyclerViewItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: ad  reason: collision with root package name */
    public int f7362ad = 0;

    /* renamed from: de  reason: collision with root package name */
    public int f7363de = 1;

    /* renamed from: fe  reason: collision with root package name */
    public int f7364fe = 42;
    public Paint qw = new Paint();

    /* renamed from: rg  reason: collision with root package name */
    public int f7365rg = 0;

    /* renamed from: th  reason: collision with root package name */
    public Drawable f7366th;

    /* renamed from: yj  reason: collision with root package name */
    public int f7367yj;

    public RecyclerViewItemDecoration() {
    }

    public final void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        ad.ad("DividerAttr", "drawHorizontal++++++");
        int paddingLeft = recyclerView.getPaddingLeft();
        int measuredWidth = recyclerView.getMeasuredWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            int i3 = this.f7363de + bottom;
            Drawable drawable = this.f7366th;
            if (drawable != null) {
                drawable.setBounds(this.f7364fe + paddingLeft, bottom, measuredWidth - this.f7365rg, i3);
                this.f7366th.draw(canvas);
            } else {
                Paint paint = this.qw;
                if (paint != null) {
                    paint.setColor(this.f7367yj);
                    canvas.drawRect((float) (this.f7364fe + paddingLeft), (float) bottom, (float) (measuredWidth - this.f7365rg), (float) i3, this.qw);
                }
            }
        }
    }

    public final void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int paddingTop = recyclerView.getPaddingTop();
        int measuredHeight = recyclerView.getMeasuredHeight() - recyclerView.getPaddingBottom();
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            int right = childAt.getRight() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).rightMargin;
            int i3 = this.f7363de + right;
            Drawable drawable = this.f7366th;
            if (drawable != null) {
                drawable.setBounds(right + this.f7364fe, paddingTop, i3 - this.f7365rg, measuredHeight);
                this.f7366th.draw(canvas);
            } else {
                Paint paint = this.qw;
                if (paint != null) {
                    paint.setColor(this.f7367yj);
                    canvas.drawRect((float) (right + this.f7364fe), (float) paddingTop, (float) (i3 - this.f7365rg), (float) measuredHeight, this.qw);
                }
            }
        }
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        rect.set(0, 0, 0, this.f7363de);
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
        if (this.f7362ad == 1) {
            drawVertical(canvas, recyclerView);
        } else {
            drawHorizontal(canvas, recyclerView);
        }
    }

    public void setColor(int i2) {
        this.f7367yj = i2;
    }

    public void setmDividerDrawable(Drawable drawable) {
        this.f7366th = drawable;
    }

    public void setmDividerHeight(int i2) {
        this.f7363de = i2;
    }

    public void setmMOrientation(int i2) {
        this.f7362ad = i2;
    }

    public void setmMarginLeff(int i2) {
        this.f7364fe = i2;
    }

    public void setmMarginRight(int i2) {
        this.f7365rg = i2;
    }

    public RecyclerViewItemDecoration(int i2) {
        this.f7367yj = i2;
    }

    public RecyclerViewItemDecoration(Drawable drawable) {
        this.f7366th = drawable;
    }
}
