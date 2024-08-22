package com.tera.scan.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;
import fe.mmm.qw.i.qw;

public class FixedRatioImageView extends ImageView {
    public static final String TAG = "FixedRatioImageView";
    public int mHeight;
    public int mWidth;

    public FixedRatioImageView(Context context) {
        super(context);
    }

    public void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Exception e) {
            qw.ad("FixedRatioImageView", "onDraw e: " + e.toString());
        }
    }

    public void onMeasure(int i2, int i3) {
        int resolveSize = ImageView.resolveSize(getSuggestedMinimumWidth(), i2);
        int i4 = this.mWidth;
        if (i4 != 0) {
            int i5 = (this.mHeight * resolveSize) / i4;
            qw.ad("FixedRatioImageView", "WIDTH: " + resolveSize);
            qw.ad("FixedRatioImageView", "HEIGHT: " + i5);
            setMeasuredDimension(resolveSize, i5);
        }
    }

    public void setSize(int i2, int i3) {
        this.mWidth = i2;
        this.mHeight = i3;
    }

    public FixedRatioImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FixedRatioImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @TargetApi(21)
    public FixedRatioImageView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }
}
