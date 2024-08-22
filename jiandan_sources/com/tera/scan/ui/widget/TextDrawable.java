package com.tera.scan.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tera.scan.app.R$styleable;

public class TextDrawable extends TextView {
    public Drawable drawableLeft;
    public Drawable drawableRight;
    public Drawable drawableTop;
    public int leftHeight;
    public int leftWidth;
    public Context mContext;
    public int rightHeight;
    public int rightWidth;
    public int topHeight;
    public int topWidth;

    public TextDrawable(Context context) {
        this(context, (AttributeSet) null, 0);
        this.mContext = context;
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TextDrawable);
        this.drawableLeft = obtainStyledAttributes.getDrawable(0);
        this.drawableRight = obtainStyledAttributes.getDrawable(3);
        this.drawableTop = obtainStyledAttributes.getDrawable(6);
        if (this.drawableLeft != null) {
            this.leftWidth = obtainStyledAttributes.getDimensionPixelOffset(2, dip2px(context, 20.0f));
            this.leftHeight = obtainStyledAttributes.getDimensionPixelOffset(1, dip2px(context, 20.0f));
        }
        if (this.drawableRight != null) {
            this.rightWidth = obtainStyledAttributes.getDimensionPixelOffset(5, dip2px(context, 20.0f));
            this.rightHeight = obtainStyledAttributes.getDimensionPixelOffset(4, dip2px(context, 20.0f));
        }
        if (this.drawableTop != null) {
            this.topWidth = obtainStyledAttributes.getDimensionPixelOffset(8, dip2px(context, 20.0f));
            this.topHeight = obtainStyledAttributes.getDimensionPixelOffset(7, dip2px(context, 20.0f));
        }
    }

    public int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setCompoundDrawables(this.drawableLeft, this.drawableTop, this.drawableRight, (Drawable) null);
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        Drawable drawable = this.drawableLeft;
        if (drawable != null) {
            drawable.setBounds(0, 0, this.leftWidth, this.leftHeight);
        }
        Drawable drawable2 = this.drawableRight;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, this.rightWidth, this.rightHeight);
        }
        Drawable drawable3 = this.drawableTop;
        if (drawable3 != null) {
            drawable3.setBounds(0, 0, this.topWidth, this.topHeight);
        }
    }

    public void setDrawable(Drawable drawable) {
        this.drawableTop = drawable;
        invalidate();
    }

    public void setDrawableLeft(Drawable drawable) {
        this.drawableLeft = drawable;
        invalidate();
    }

    public void setDrawableRight(Drawable drawable) {
        this.drawableRight = this.drawableLeft;
        invalidate();
    }

    public void setDrawableTop(int i2) {
        this.drawableTop = this.mContext.getResources().getDrawable(i2);
        invalidate();
    }

    public TextDrawable(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.mContext = context;
    }

    public void setDrawableLeft(int i2) {
        this.drawableLeft = this.mContext.getResources().getDrawable(i2);
        invalidate();
    }

    public void setDrawableRight(int i2) {
        this.drawableRight = this.mContext.getResources().getDrawable(i2);
        invalidate();
    }

    public TextDrawable(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mContext = context;
        init(context, attributeSet);
    }
}
