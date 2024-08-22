package com.tera.scan.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.RequiresApi;
import com.tera.scan.app.R$styleable;

public class FixedRatioRelativeLayout extends RelativeLayout {
    public static final float DEFAULT_ASPECT_RATIO = 1.0f;
    public float mRatio;

    public FixedRatioRelativeLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private void init(Context context, AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FixedRatioRelativeLayout, i2, 0);
        float f = obtainStyledAttributes.getFloat(0, -1.0f);
        this.mRatio = f;
        if (f < 0.0f) {
            this.mRatio = 1.0f;
        }
        obtainStyledAttributes.recycle();
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec((int) ((((float) ((View.MeasureSpec.getSize(i2) - getPaddingLeft()) - getPaddingRight())) / this.mRatio) + 0.5f), View.MeasureSpec.getMode(i3)));
    }

    public void setRatio(float f) {
        this.mRatio = f;
    }

    public FixedRatioRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FixedRatioRelativeLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mRatio = 1.0f;
        init(context, attributeSet, i2);
    }

    @RequiresApi(api = 21)
    public FixedRatioRelativeLayout(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i2);
        this.mRatio = 1.0f;
        init(context, attributeSet, i2);
    }
}
