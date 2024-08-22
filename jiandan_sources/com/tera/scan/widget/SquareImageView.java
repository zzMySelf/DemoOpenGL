package com.tera.scan.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class SquareImageView extends ImageView {
    public float proportion = 1.0f;

    public SquareImageView(Context context) {
        super(context);
    }

    public void onMeasure(int i2, int i3) {
        int resolveSize = ImageView.resolveSize(getSuggestedMinimumWidth(), i2);
        setMeasuredDimension(resolveSize, (int) (((float) resolveSize) / this.proportion));
    }

    public void setAspectRatio(float f) {
        this.proportion = f;
    }

    public SquareImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SquareImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
