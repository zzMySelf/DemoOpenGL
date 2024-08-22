package com.tera.scan.doc.preview.pdf.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

public class FixedRatioImage extends AppCompatImageView {
    public double mRatio = 1.0d;

    public FixedRatioImage(Context context) {
        super(context);
    }

    public double getRatio() {
        return this.mRatio;
    }

    public void onMeasure(int i2, int i3) {
        int resolveSize = ImageView.resolveSize(getSuggestedMinimumWidth(), i2);
        if (resolveSize > 0) {
            setMeasuredDimension(resolveSize, (int) (((double) resolveSize) * this.mRatio));
        } else {
            super.onMeasure(i2, i3);
        }
    }

    public void setRatio(double d) {
        this.mRatio = d;
    }

    public FixedRatioImage(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FixedRatioImage(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
